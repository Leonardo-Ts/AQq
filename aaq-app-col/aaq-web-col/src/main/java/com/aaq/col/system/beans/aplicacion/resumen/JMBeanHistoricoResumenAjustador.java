package com.aaq.col.system.beans.aplicacion.resumen;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.HistoricoResumenAjustador;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.ReporteMovilSacGruas;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.HistoricoResumenAjustadorDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@ManagedBean(name = "beanHistoricoResumenAjustador")
@SessionScoped
public class JMBeanHistoricoResumenAjustador extends JMBeanExtensiblePrincipal<HistoricoResumenAjustador> {

	private static final long serialVersionUID = 2443971085706379056L;
	private String txtNumeroReporte;
	private String txtClaveAjustador;
	private final String actividad="Insertar Término";
	private ReporteMovilSac reporteMovilSacObj;
	private List<HistoricoResumenAjustador> historicos;
	private Date txtFechaInicio;
   	private Date txtFechaFin;
   	private ReporteMovilSacGruas reporteGrua;

	public JMBeanHistoricoResumenAjustador() {
		super();
		this.actualizarListado();
		txtFechaInicio = new Date();
        txtFechaFin = new Date();
	}
	
	@Override
	public void actualizarListado() {
		if ((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
			this.ponerMensajeAdvertencia("Los reportes estan limitados a 31 dias naturales de datos. Para obtener reportes de meses multiples, es necesario crear el reporte uno por uno del mes que se solicita.");
			return;
		}
		
		if(this.getTxtClaveAjustador() != null && this.getTxtNumeroReporte() != null) {
			
			if(!this.getTxtClaveAjustador().isEmpty() && !this.getTxtNumeroReporte().isEmpty()) {				
				this.ponerMensajeAdvertencia("La consulta solo se permite con numero de reporte ó clave de ajustador.");
				this.setListado(new HistoricoResumenAjustadorDataModel(new ArrayList<HistoricoResumenAjustador>()));
				return;
			}
			
			if(this.getTxtNumeroReporte().isEmpty()) this.setTxtNumeroReporte(null);
			if(this.getTxtClaveAjustador().isEmpty())  this.setTxtClaveAjustador(null); 
		}

		try {
			if(this.getPermisoTodosBases() && this.getPermisoTodosEstados()){
				this.setListado(new HistoricoResumenAjustadorDataModel(this.getHistoricoResumenAjustadorService().
						listaDeHistoricoResumenAjustador(this.getTxtNumeroReporte(), this.getTxtClaveAjustador(), this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin())));
			}else
			{	
				List <String> claveAjustadores = obtenerTodasTerminalesFrecuencia(); 	
				if (StringUtils.isNotBlank(this.getTxtClaveAjustador())) {
					resumenAjustadorFreq(claveAjustadores);
				}else{
					this.setListado(new HistoricoResumenAjustadorDataModel(this.getHistoricoResumenAjustadorService().
							listaDeHistoricoResumenAjustadorFreq(this.getTxtNumeroReporte(), claveAjustadores, this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin())));
				}
			}
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListadoFrecuencia");
		}
	}
	
	private void resumenAjustadorFreq(List<String> claveAjustadores){
		for (String clave : claveAjustadores){
			if(clave.equals(this.getTxtClaveAjustador())){
				try {
					this.setListado(new HistoricoResumenAjustadorDataModel(this.getHistoricoResumenAjustadorService().
							listaDeHistoricoResumenAjustador(this.getTxtNumeroReporte(), this.getTxtClaveAjustador(), this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin())));
				} catch (Exception ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListadoFrecuencia");
				}
				return;
			}
		}
			this.setListado(new HistoricoResumenAjustadorDataModel(new ArrayList<HistoricoResumenAjustador>()));
			return;
	}

	private boolean existeClaveAjustadorFreq(List<String> claveAjustadores){
		for (String clave : claveAjustadores){
			if(clave.equals(this.getTxtClaveAjustador())){
				return true;
			}
		}
			return false;
	}
	
	private boolean existeNumeroReporteFreq(String numeroReporte){
		List <String> claveAjustadores = obtenerTodasTerminalesFrecuencia();
		
		try {
			historicos = this.getHistoricoResumenAjustadorService().
					listaDeHistoricoResumenAjustadorFreq(this.getTxtNumeroReporte(), claveAjustadores, this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin());
		} catch (Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "existeNumeroReporteFreq");
		}
		
		for(HistoricoResumenAjustador resumen : historicos){
			if(numeroReporte.equals(resumen.getGeneralNumeroReporte())){
				return true;
			}
		}
		return false;
	}
		
	public List<String> obtenerTodasTerminalesFrecuencia(){
		List<Base> basesFreq = this.getListaDeBasesPorFrecuencia();
		List<String> claveAjustadores = new ArrayList<String>();
			
			for(final Base base : basesFreq){
				for(final Terminal terminal : this.getListaDeTerminalesParaEstadoYBase(String.valueOf(base.getEstado().getId()), String.valueOf(base.getId()))){
					claveAjustadores.add(String.valueOf(terminal.getNumeroproveedor()));
				}
			}		
		return claveAjustadores;
	}
	
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Reporte,generalNumeroReporte", "Clave Ajustador,claveAjustador", "Ajustador,nombreAjustador",
				"Fecha,fechaActividad,fecha"}).getLista();
	}
	
	public String doAccionDetalleReporte()  {
		this.setObjetoABM(this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
		if (this.getObjetoABM() == null) {
			this.ponerMensajeError("No se encontro registro para el detalle.");
            return null;
		}
		else {
			setReporteMovilSacObj(this.getReporteMovilSacService().
			objetoReporteMovilSac(getObjetoABM().getGeneralNumeroReporte(),null));
						
			setHistoricos(this.getHistoricoResumenAjustadorService().
					listaDeHistoricoResumenAjustador(getObjetoABM().getGeneralNumeroReporte()));
			  
			List<HistoricoResumenAjustador> listado2 = new ArrayList<HistoricoResumenAjustador>();
			 
			for (HistoricoResumenAjustador historicoResumenAjustador : historicos) {

				int n = 0;
				
				if(listado2.size() > 0 ) {
				
					for (HistoricoResumenAjustador historico : listado2) {
						if( historicoResumenAjustador.getActividad().equals(historico.getActividad()) &&
								historicoResumenAjustador.getDescripcionActividad().equals(historico.getDescripcionActividad())) {
							n++;
						}
					}
					if(n<1) {					
						listado2.add(historicoResumenAjustador);
					}
					
				} else {
					listado2.add(historicoResumenAjustador);
				}

			}
						
			try {
				
				reporteGrua = this.getReporteMovilSacGruasService().objetoReporteMovilSacGruas(getObjetoABM().getGeneralNumeroReporte(),
						getObjetoABM().getClaveAjustador());
			} catch (Exception e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, getClass(), "Problemas al traer el reporte de la grua");
			}
			
			return "resumenAjustadorDetalle";
		}
	}
	
	public String getTipoAfectado(String valor) {
		if (valor.equals("A")) {
			return "Asegurado";
		} else {
			if (StringUtils.contains(valor, "T")) {
				String[] terceroNumero = StringUtils.split(valor,"T");
				return "Tercero "+terceroNumero[0];
			}
		}
		
		return valor;
	}
	
	public String getNumeroTercero(String valor) {
		String[] terceroNumero = StringUtils.split(valor,"T");
		return terceroNumero[0];
	}
	
	public String getTipoTercero(String valor) {
		String respuesta = valor;
		switch (valor) {
		case "V":
			respuesta ="Vehículo";
			break;
		case "P":
			respuesta = "Persona";
			break;
		case "O":
			respuesta ="Objeto";
			break;

		default:
			break;
		}
		
		return respuesta;
	}
	
//	public void doAccionDescargaPDF() {
//		FacesContext fc = FacesContext.getCurrentInstance();
//	    ExternalContext ec = fc.getExternalContext();
//	    String fileName = "resumen-ajustador.pdf";
//
//	    ec.responseReset(); 
//	    ec.setResponseContentType("application/pdf"); 
//	    
//	    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//	
////	    	try {
////	    		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();	       
////				this.getHistoricoResumenAjustadorService().generaReporteAjustadoresResumen(this.getTxtNumeroReporte(), this.getTxtClaveAjustador(), this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin(),  ec.getResponseOutputStream(), servletContext.getRealPath("/")+"/resumen/");
//	    try {
//    		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();	
//    		
//			if(this.getPermisoTodosBases() && this.getPermisoTodosEstados()){       
//				this.getHistoricoResumenAjustadorService().generaReporteAjustadoresResumen(this.getTxtNumeroReporte(), this.getTxtClaveAjustador(), this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin(),  ec.getResponseOutputStream(), servletContext.getRealPath("/")+"/resumen/");
//			}else
//			{	
//				List <String> claveAjustadores = obtenerTodasTerminalesFrecuencia();
//				if (StringUtils.isNotBlank(this.getTxtClaveAjustador()) ) {
//					if(existeClaveAjustadorFreq(claveAjustadores)){
//						this.getHistoricoResumenAjustadorService().generaReporteAjustadoresResumen(this.getTxtNumeroReporte(), this.getTxtClaveAjustador(), this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin(),  ec.getResponseOutputStream(), servletContext.getRealPath("/")+"/resumen/");
//					}else{
//						this.getHistoricoResumenAjustadorService().generaReporteAjustadoresResumen(this.getTxtNumeroReporte(), "0000", this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin(),  ec.getResponseOutputStream(), servletContext.getRealPath("/")+"/resumen/");
//
//					}
//				}else if(StringUtils.isNotBlank(this.getTxtNumeroReporte()) && existeNumeroReporteFreq(this.getTxtNumeroReporte())){
//					this.getHistoricoResumenAjustadorService().generaReporteAjustadoresResumen(this.getTxtNumeroReporte(), this.getTxtClaveAjustador(), this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin(),  ec.getResponseOutputStream(), servletContext.getRealPath("/")+"/resumen/");
//				}else{
//					this.getHistoricoResumenAjustadorService().generaReporteAjustadoresResumenFreq(this.getTxtNumeroReporte(), claveAjustadores, this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin(),  ec.getResponseOutputStream(), servletContext.getRealPath("/")+"/resumen/");
//				}
//			}
//		} catch (Exception e) {
//				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "doAccionDescargaPDF");
//			}
//		    fc.responseComplete();
//		}

	
	public void doAccionDescargaPDF() {
		FacesContext fc = FacesContext.getCurrentInstance();
	    ExternalContext ec = fc.getExternalContext();
	    String fileName = "resumen-ajustador.pdf";

	    ec.responseReset(); 
	    ec.setResponseContentType("application/pdf"); 
	    
	    ec.setResponseHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
	
	    try {
    		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();	
    		
			if(this.getPermisoTodosBases() && this.getPermisoTodosEstados()){       
				this.getHistoricoResumenAjustadorService().generaReporteAjustadoresResumenWeb(this.getTxtNumeroReporte(), this.getTxtClaveAjustador(), this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin(),  ec.getResponseOutputStream(), servletContext.getRealPath("/")+"/conclusion/");
			} else {	
				List <String> claveAjustadores = obtenerTodasTerminalesFrecuencia();
				if (StringUtils.isNotBlank(this.getTxtClaveAjustador()) ) {
					if(existeClaveAjustadorFreq(claveAjustadores)){
						this.getHistoricoResumenAjustadorService().generaReporteAjustadoresResumenWeb(this.getTxtNumeroReporte(), this.getTxtClaveAjustador(), this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin(),  ec.getResponseOutputStream(), servletContext.getRealPath("/")+"/conclusion/");
					}else{
						this.getHistoricoResumenAjustadorService().generaReporteAjustadoresResumenWeb(this.getTxtNumeroReporte(), "0000", this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin(),  ec.getResponseOutputStream(), servletContext.getRealPath("/")+"/conclusion/");

					}
				}else if(StringUtils.isNotBlank(this.getTxtNumeroReporte()) && existeNumeroReporteFreq(this.getTxtNumeroReporte())){
					this.getHistoricoResumenAjustadorService().generaReporteAjustadoresResumenWeb(this.getTxtNumeroReporte(), this.getTxtClaveAjustador(), this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin(),  ec.getResponseOutputStream(), servletContext.getRealPath("/")+"/conclusion/");
				}else{
					this.getHistoricoResumenAjustadorService().generaReporteAjustadoresResumenFreqWeb(this.getTxtNumeroReporte(), claveAjustadores, this.actividad, this.getTxtFechaInicio(), this.getTxtFechaFin(),  ec.getResponseOutputStream(), servletContext.getRealPath("/")+"/conclusion/");
				}
			}
		} catch (Exception e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "doAccionDescargaPDF");
			}
		    fc.responseComplete();
		}

	public String getTxtNumeroReporte() {
		return txtNumeroReporte;
	}

	public void setTxtNumeroReporte(String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}

	public String getTxtClaveAjustador() {
		return txtClaveAjustador;
	}

	public void setTxtClaveAjustador(String txtClaveAjustador) {
		this.txtClaveAjustador = txtClaveAjustador;
	}

	public ReporteMovilSac getReporteMovilSacObj() {
		return reporteMovilSacObj;
	}

	public void setReporteMovilSacObj(ReporteMovilSac reporteMovilSacObj) {
		this.reporteMovilSacObj = reporteMovilSacObj;
	}

	public List<HistoricoResumenAjustador> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<HistoricoResumenAjustador> historicos) {
		this.historicos = historicos;
	}

	public Date getTxtFechaInicio() {
		return txtFechaInicio;
	}

	public void setTxtFechaInicio(Date txtFechaInicio) {
		this.txtFechaInicio = txtFechaInicio;
	}

	public Date getTxtFechaFin() {
		return txtFechaFin;
	}

	public void setTxtFechaFin(Date txtFechaFin) {
		this.txtFechaFin = txtFechaFin;
	}

	/**
	 * @return the reporteGrua
	 */
	public ReporteMovilSacGruas getReporteGrua() {
		return reporteGrua;
	}

	/**
	 * @param reporteGrua the reporteGrua to set
	 */
	public void setReporteGrua(ReporteMovilSacGruas reporteGrua) {
		this.reporteGrua = reporteGrua;
	}

	
}
