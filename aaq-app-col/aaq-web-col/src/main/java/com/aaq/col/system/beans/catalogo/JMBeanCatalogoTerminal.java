 package com.aaq.col.system.beans.catalogo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.CatalogoMovil;
import com.aaq.col.clases.database.entidades.CatalogoVehiculoAjus;
import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.GuardiaGrupo;
import com.aaq.col.clases.database.entidades.Horarios;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalAlerta;
import com.aaq.col.clases.database.entidades.TerminalComentario;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.repositorios.impl.TerminalDao;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.TerminalDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

@ManagedBean(name = "beanCatalogoTerminal")
@ViewScoped
public class JMBeanCatalogoTerminal extends JMBeanExtensiblePrincipal<Terminal> {
	
	private static final long serialVersionUID = -5546106737235444218L;

	private TerminalAlerta objetoABMAlterta;
	private String txtTerminalTerminal;
	private String txtTerminalNombre;
	private String txtComentario;
	private String txtTerminalNumeroProveedor;
	private String txtTerminalNumeroRadio;
	private String txtTerminalHorario;
	private String idPuntoInteresSeleccionado;
	private String idGeocercaEntraSeleccionado;
	private String idGeocercaSaleSeleccionado;
	private TerminalComentario objetoABMComentario;
	
	private Boolean _filtroCoordenadasBase = Boolean.FALSE;
	private Boolean _filtroCoordenadasWS = Boolean.FALSE;
	private String _filtroEstatus;
	private String _horario;

	private String[] tipoAv;
	private List<TerminalComentario> comentarios = null;
	
	private String estatusInactivo;
	
	private Usuario usuarioPermiso;
	
	
	public JMBeanCatalogoTerminal() {
		super();
		this.actualizarListado();
	}

	public List<TerminalComentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<TerminalComentario> comentarios) {
		this.comentarios = comentarios;
	}

	
	@Override
	public void actualizarListado() {
		try {
			if (getPermisoTodosEstados() && getPermisoTodosBases()){
				TerminalDataModel data = new TerminalDataModel(this.getTerminalService().listaDeTerminal(
						this.getEstadoService().objetoEstado(this.getIdEstado()),
						this.getBaseService().objetoBase(this.getIdBase()), null, this.txtTerminalNombre,
						this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
						Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS));
				
				this.setListado(data);
			} else {
				if (this.getIdEstado().equals("9999")){
					if (Integer.parseInt(this.getIdBase()) < 0)
					{
						TerminalDataModel data = new TerminalDataModel(this.getTerminalService().listaDeTerminal(
								this.getEstadoService().objetoEstado(this.getIdEstado()),
								null, this.getListaDeBasesPorFrecuencia(), this.txtTerminalNombre,
								this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
								Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS));
						this.setListado(data);
					} else {
						
						TerminalDataModel data = new TerminalDataModel(this.getTerminalService().listaDeTerminal(
								this.getEstadoService().objetoEstado(this.getIdEstado()),
								this.getBaseService().objetoBase(this.getIdBase()), null, this.txtTerminalNombre,
								this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
								Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS));
						this.setListado(data);
					}
				} else {
					if (Integer.parseInt(this.getIdBase()) < 0)
					{
						TerminalDataModel data = new TerminalDataModel(this.getTerminalService().listaDeTerminal(
								null, null, this.getListaDeBasesPorFrecuencia(), this.txtTerminalNombre,
								this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
								Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS));
						this.setListado(data);
					} else {	
						TerminalDataModel data = new TerminalDataModel(this.getTerminalService().listaDeTerminal(
								this.getEstadoService().objetoEstado(this.getIdEstado()),
								this.getBaseService().objetoBase(this.getIdBase()), null, this.txtTerminalNombre,
								this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
								Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS));
						this.setListado(data);
					}
				}
				
				
			}
			
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}
	
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(
				new String[] { "Estado,estado", "Base,base", "Nombre,nombre", "Numero de Proveedor,numeroproveedor",
						"Numero de Radio,numeroradio", "Modificado Por,strDatosModificacion" }).getLista();
	}
	
	public List<CatalogoMovil> getListaDeCatalogoMovil() {
		try {
			return this.getCatalogoMovilService().listaDeCatalogoMovil();
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeCatalogoMovil");
			return null;
		}
	}
	
	public List<CatalogoVehiculoAjus> getListaDeCatalogoVehiculoAjus() {
		try {
			return this.getCatalogoVehiculoAjusService().listaDeCatalogoVehiculoAjus();
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeCatalogoVehiculoAjus");
			return null;
		}
	}


	/**
	 * @return la lista
	 */
	public List<TerminalAlerta> getListaDeTerminalAlerta() {
		if ((this.getObjetoABM() != null) && (this.getObjetoABM().getId() != null)) {
			try {
				return this.getTerminalAlertaService().listaDeTerminalAlerta(this.getObjetoABM());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeTerminalAlerta");
			}

		}
		return null;
	}
	
	public List<TerminalComentario> getListaDeTerminalComentario() {
		if ((this.getObjetoABM() != null) && (this.getObjetoABM().getId() != null)) {
			try {
				return this.getTerminalComentarioService().listaTerminalComentarios(this.getObjetoABM());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeTerminalComentario");
			}

		}
		return null;
	}
	
	public Boolean getGuardiaGrupoActiva() {
		GuardiaGrupo guardia = null;
		
		try {
			guardia = GuardiaGrupo.getGuardiaGrupoService().objetoGuardiaPorGrupo(this.getObjetoABM().getGrupo());
		} catch (Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "Obtener guardia de terminal"); 
		}
		if (guardia != null) {
			if (!guardia.getActivarGuardia()) {
				return true;
			}
		}
		
		return false;
	}
	
	// **************************************************************//
	// Listado Select Item
	// **************************************************************//

	/**
	 * @return la lista
	 */
	public List<PuntoInteres> getListaDePuntoInteres() {
		if (StringUtils.isNotBlank(this.getIdEstado())) {
			try {
				return this.getPuntoInteresService().listaDePuntoInteres(
						this.getEstadoService().objetoEstado(this.getIdEstado()), null);
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDePuntoInteres");
			}
		}
		return null;
	}

	public List<Geocerca> getListaDeGeocerca() {
		if (StringUtils.isNotBlank(this.getIdEstado())) {
			try {
				return this.getGeocercaService().listaDeGeocerca(
						this.getEstadoService().objetoEstado(this.getIdEstado()));
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeGeocerca");
			}
		}
		return null;
	}

	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		this.setObjetoABM(new Terminal());
	}

	@Override
	public void doAccionRegistroEditar(final ActionEvent e) {				
		super.doAccionRegistroEditar(e);
		this.getObjetoABM().setUsuario(getUsuarioActual());
		this.getObjetoABM().setFechaModificacion(new Date());
		
		String[] tmpTipoAv = new String[10];
		if(getObjetoABM().getTipoAsistenciaVial() != null){
			tmpTipoAv = getObjetoABM().getTipoAsistenciaVial().split("\\|");
		}
		
		this.setTipoAv(tmpTipoAv);
		this.setTxtTerminalHorario(this.getObjetoABM().getHorario());
		
	}

	@Override
	public void doAccionRegistroGuardar(final ActionEvent e) {

		if (getObjetoABM() != null && getObjetoABM().getBase() != null){
			if (BooleanUtils.isTrue(getObjetoABM().getCoordenadasDesdeBase())){
				getObjetoABM().setLatitud(getObjetoABM().getBase().getLatitud());
				getObjetoABM().setLongitud(getObjetoABM().getBase().getLongitud());
			}
			
			getObjetoABM().setUsuario(getUsuarioActual());
			getObjetoABM().setFechaModificacion(new Date());
			
			String tmpTipoAv = "";
			String suffix = "|";
			int i = 1;
			if(this.getTipoAv().length > 0){
				for (String claveTipo : tipoAv) {
					tmpTipoAv += claveTipo + (i < this.getTipoAv().length ? suffix : "");
					i++;
				}
			}else{
				tmpTipoAv = null;
			}
			getObjetoABM().setTipoAsistenciaVial(tmpTipoAv);
		}
		// Guardar el usuario que modificio el horario
		if (this.getUsuarioPermiso() != null) {
			if (this.getUsuarioPermiso().getId() != null) {
				getObjetoABM().setUsuarioModif(this.getUsuarioPermiso());
			}
		}
		
		super.doAccionRegistroGuardar(e);

	}

	public void doAccionRegistroAgregarAlerta(final ActionEvent e) {
		this.doAccionRegistroEditar(e);
		this.setIdGeocercaEntraSeleccionado(null);
		this.setIdGeocercaSaleSeleccionado(null);
		this.setIdPuntoInteresSeleccionado(null);

		this.setobjetoABMAlterta(new TerminalAlerta());
		this.getobjetoABMAlterta().setTerminal(this.getObjetoABM());

	}

	public void doAccionRegistroAlertaEliminar(final ActionEvent e) {

		TerminalAlerta terminalAlerta = null;

		try {
			terminalAlerta = this.getTerminalAlertaService().objetoTerminalAlerta(
					this.obtenerParametroDeRequest(JMConstantesComunes.WEB_PARAMETRO_ID));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionRegistroAlertaEliminar");
		}

		if (terminalAlerta != null) {
			terminalAlerta.eliminarObjeto();
		}
	}

	public void doAccionRegistroAlertaGuardar(final ActionEvent e) {

		if (StringUtils.isNotBlank(this.getIdPuntoInteresSeleccionado())) {
			try {
				this.getobjetoABMAlterta().setPuntoInteres(
						this.getPuntoInteresService().objetoPuntoInteres(this.getIdPuntoInteresSeleccionado()));
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"doAccionRegistroAlertaGuardar => objetoPuntoInteres");
			}
		}
		if (StringUtils.isNotBlank(this.getIdGeocercaEntraSeleccionado())) {
			try {
				this.getobjetoABMAlterta().setGeocercaByPorIdGeocercaEntra(
						this.getGeocercaService().objetoGeocerca(this.getIdGeocercaEntraSeleccionado()));
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"doAccionRegistroAlertaGuardar => objetoGeocerca");

			}
		}

		if (StringUtils.isNotBlank(this.getIdGeocercaSaleSeleccionado())) {
			try {
				this.getobjetoABMAlterta().setGeocercaByPorIdGeocercaSale(
						this.getGeocercaService().objetoGeocerca(this.getIdGeocercaSaleSeleccionado()));
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"doAccionRegistroAlertaGuardar => objetoGeocerca");
			}
		}

		this.ponerMensajeResultado(this.getobjetoABMAlterta().guardarObjeto());

		this.setobjetoABMAlterta(null);
		this.setIdGeocercaEntraSeleccionado(null);
		this.setIdGeocercaSaleSeleccionado(null);
		this.setIdPuntoInteresSeleccionado(null);

	}
	
	
	//NUEVO METODO 
	public void doAccionCambiarEstatusTerminal(final AjaxBehaviorEvent e) {
		this.doAccionRegistroEditar(null);
		
        if (this.getObjetoABM() != null) {
         	this.getObjetoABM().setFechaEstatusDesconectado(null);
        	this.getObjetoABM().setRazonEstatus(null);
        	this.getObjetoABM().setFechaEstatusArribo(null);
        	this.getObjetoABM().setFechaEstatusAsignado(null);
        	this.getObjetoABM().setFechaEstatusDisponible(null);
        	this.getObjetoABM().setFechaEstatusOcupado(null);
        	this.getObjetoABM().setFechaEstatusTermino(null);
        	this.getObjetoABM().setProximidad(null);
        	this.getObjetoABM().setReporteSise(null);
        	this.getObjetoABM().setUltimoLocalizacionReporte(null);
        	this.getObjetoABM().setFuenteDisponible(null);
        	this.getObjetoABM().setFuenteArribo(null);
        	this.getObjetoABM().setFuenteAsignacion(null);
        	this.getObjetoABM().setFuenteTermino(null);
        	this.getObjetoABM().setSinPosicionActual(null);
        	this.getObjetoABM().setReporteSac(null);
        	this.getObjetoABM().setReportesEsteDia(null);
        	this.getObjetoABM().setFuenteDesconectado(null);
        	this.getObjetoABM().guardarObjeto();
        	
            try {
            	final JMResultadoOperacion r =  this.getTerminalService().ejecutarFuncionTerminalEstatus(this.getObjetoABM().getId(),
                        this.getObjetoABM().getEstatus(),
                        "JMBeanAplicacionAlarma [" + this.getUsuarioActual().getNombre() + "]",
                        JMConstantes.SOCKET_FUENTE_SIICA_WEB,
                        this.getObjetoABM().getNumeroproveedor(),
                        "SIICA-AJUSTADORES  [" + this.getUsuarioActual().getNombre() + "]"
                        );   
                if(this.getObjetoABM().getEstatus().equals("DISPONIBLE") ||this.getObjetoABM().getEstatus().equals("AUTOPISTA") )
                {
                	this.ponerMensajeResultado(r);
                }
                if (this.getObjetoABM().getEstatus().equals("NO DISPONIBLE")) {
            	    Date date = new Date();
//            	    DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
          	   					this.getObjetoABM().setFechaEstatusDesconectado(date);
                              	this.getObjetoABM().setFuenteDesconectado("SIICA-AJUSTADORES  [" + this.getUsuarioActual().getNombre() + "]");
                              	this.getObjetoABM().setFechaEstatusArribo(null);
                              	this.getObjetoABM().setFechaEstatusAsignado(null);
                              	this.getObjetoABM().setFechaEstatusDisponible(null);
                              	this.getObjetoABM().setFechaEstatusOcupado(null);
                              	this.getObjetoABM().setFechaEstatusTermino(null);
                              	this.getObjetoABM().setProximidad(null);
                              	this.getObjetoABM().setReporteSise(null);
                              	this.getObjetoABM().setUltimoLocalizacionReporte(null);
                              	this.getObjetoABM().setFuenteDisponible(null);
                              	this.getObjetoABM().setFuenteArribo(null);
                              	this.getObjetoABM().setFuenteAsignacion(null);
                              	this.getObjetoABM().setFuenteTermino(null);
                              	this.getObjetoABM().setSinPosicionActual("f");
                              	this.getObjetoABM().setReporteSac(null);
                              	this.getObjetoABM().setReportesEsteDia(0);
                              	this.getObjetoABM().guardarObjeto();
                }
                
                       } catch (Exception ex) {
   					this.ponerMensajeResultado(new JMResultadoOperacion(ex));
       				}
        }
    }
	
	
	public void doAccionListaComentariosTerminal(final ActionEvent e) {
		this.setObjetoABM(this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
		if(this.getObjetoABM() == null){
			this.ponerMensajeError("No se encontro registro, para mostrar comentarios.");
			return;
		}
		else{
			//Validar si los comentarios no han sido vistos, de ser asi capturar el nombre del usuario en turno
			this.comentarios = this.getTerminalComentarioService().listaTerminalComentarios(this.getObjetoABM(), getUsuarioActual().getUsername() );
		}
	}
	
	public boolean doAccionComentariosVisto(final Terminal obj) {
		boolean salida = false;
		if (obj != null) {
			 salida = this.getTerminalComentarioService().contieneComentariosNoVistos(obj);
			 return salida;
		}
		return salida ;
	}
	
	public void doAccionRegistroTerminalComentario(final ActionEvent e) {
		 
		this.setObjetoABM(this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
		if (this.getObjetoABM() == null) {
			this.ponerMensajeError("No se encontro registro para agregar comentario.");
            return;
		}
		else {
			this.setObjetoABMComentario(new TerminalComentario());
			this.getObjetoABMComentario().setUsuarioVisto(null);
			this.getObjetoABMComentario().setTerminal(this.getObjetoABM());
		}
		
	}
	
	public void doAccionRegistroTerminalComentarioBtn(final ActionEvent e) {
		this.getObjetoABMComentario().setUsuario(this.getUsuarioActual().getUsername());
		this.ponerMensajeResultado(this.getObjetoABMComentario().guardarObjeto());
		this.setObjetoABMComentario(null);
	}
	
	public void doAccionRegistroEliminarComentario(final ActionEvent e){
		this.setObjetoABMComentario(this.getComentarios().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
		
		if (this.objetoABMComentario == null) {
            this.ponerMensajeError("No se encontro registro para eliminar");
        }
        else {
            try {
                final JMResultadoOperacion r = this.objetoABMComentario.eliminarObjeto();
                if (r.isExito()) {
                    this.ponerMensajeInfo(r.getMensaje());
                }
                else {
                    this.ponerMensajeError("Error al intentar eliminar el registro: " + r.getMensaje());
                }
            }
            catch (Exception ex) {
                getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroEliminar -> " + ex.getMessage()), (Throwable)ex);
                this.ponerMensajeError("Excepcion al intentar eliminar el registro: " + ex.getMessage());
            }
        }
		this.comentarios = this.getTerminalComentarioService().listaTerminalComentarios(this.getObjetoABM(), null);
	}
	
	
	@SuppressWarnings("unused")
	public void doAccionActualizaTelefonosSISE() { 
		List<Terminal> terminales = null;
		try {
			terminales = Terminal.getTerminalService().listaDeTerminal();
		} catch (Exception e) {
			this.ponerMensajeError("Excepcion al intentar obtener las terminales");
		}
		
		
		 List<String> respuestaSise = this.getSiseSP_ServiceInterfase().actualizarTelefonosSise(terminales);
		 int actualizado = 0;
		 int noActualizado = 0;
		 int error = 0;
		 
		 for (String respuesta : respuestaSise) {
			if(respuesta.equals("1")) {
				actualizado++;
			}else if(respuesta.equals("0")) {				
				noActualizado++;
			} else {
				error++;
			}
		}
		this.ponerMensajeInfo("Se actualizaron: " + actualizado + " Ajustadores. " + 
				" No se actualizaron: " + noActualizado + " Ajustadores. ");
	}
	
	
	
	
	public void doAccionCambiarRazonEstatus( AjaxBehaviorEvent e) {
        if (this.getObjetoABM() != null) {
        	if (StringUtils.isNotBlank(this.getEstatusInactivo())) {
				this.getObjetoABM().setRazonEstatus(this.getEstatusInactivo());
				this.getObjetoABM().guardarObjeto();
				this.ponerMensajeInfo("Guardado "+this.getEstatusInactivo());
			}
        }
    }
	
	public ArrayList<String>  diasHorarios() {
		ArrayList<String> dias = new ArrayList<>();
		List<Horarios> horarios = null;
		try {
		 horarios = getObjetoABM().getListaHorario();
		if (horarios.size() > 0) { 
			for (Horarios horarios2 : horarios) {
				dias.add(String.valueOf(horarios2.getDia_semana_num()));
			}
			return dias;
		}
		}catch (Exception e) {
		}
		return dias;
	}
	
	public void doAccionUsuarioPermiso(final AjaxBehaviorEvent e) {
		this.setUsuarioPermiso(this.getUsuarioActual());
	}

	//**************************************************************//
	// DESCARGAR ARCHIVOS CON REPORTES
	//**************************************************************//
//	@Override
//	public String doAccionReporte() {
//		return this.enviarArchivoACliente("reporte_terminales.xls", this.obtenerReporte());
//	}		
	
//	public byte[] obtenerReporte() {
	public byte[] obtenerReporteExcel(final List<Terminal> lista) {

		final ByteArrayOutputStream paraFuera = new ByteArrayOutputStream();
		try {
			final WritableWorkbook workbook = Workbook.createWorkbook(paraFuera);
			workbook.setProtected(false);

			// primero los formatos

			// fuentes
			final WritableFont fuenteTitulo = new WritableFont(WritableFont.ARIAL, 18, WritableFont.BOLD);
			final WritableFont fuenteEncabezado = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, false,
					UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
			final WritableFont fuenteDatos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);

			final WritableCellFormat estiloTitulo = new WritableCellFormat(fuenteTitulo);
			estiloTitulo.setBackground(Colour.WHITE);
			estiloTitulo.setAlignment(Alignment.CENTRE);
			estiloTitulo.setVerticalAlignment(VerticalAlignment.CENTRE);
			estiloTitulo.setLocked(true);

			final WritableCellFormat estiloEncabezadoDatosColumna = new WritableCellFormat(fuenteEncabezado);
			estiloEncabezadoDatosColumna.setBackground(Colour.GREEN);
			estiloEncabezadoDatosColumna.setAlignment(Alignment.CENTRE);
			estiloEncabezadoDatosColumna.setVerticalAlignment(VerticalAlignment.CENTRE);
			estiloEncabezadoDatosColumna.setLocked(true);

			final WritableCellFormat estiloEncabezadoRespuestaEncuesta = new WritableCellFormat(fuenteEncabezado);
			estiloEncabezadoRespuestaEncuesta.setBackground(Colour.CORAL);
			estiloEncabezadoRespuestaEncuesta.setAlignment(Alignment.CENTRE);
			estiloEncabezadoRespuestaEncuesta.setVerticalAlignment(VerticalAlignment.CENTRE);
			estiloEncabezadoRespuestaEncuesta.setLocked(true);
			
			final WritableCellFormat estiloEncabezadoValorRespuesta = new WritableCellFormat(fuenteEncabezado);
			estiloEncabezadoValorRespuesta.setBackground(Colour.GREY_25_PERCENT);
			estiloEncabezadoValorRespuesta.setAlignment(Alignment.CENTRE);
			estiloEncabezadoValorRespuesta.setVerticalAlignment(VerticalAlignment.CENTRE);
			estiloEncabezadoValorRespuesta.setLocked(true);


			final WritableCellFormat estiloDatos = new WritableCellFormat(fuenteDatos);
			estiloDatos.setBackground(Colour.WHITE);
			estiloDatos.setAlignment(Alignment.CENTRE);
			estiloDatos.setVerticalAlignment(VerticalAlignment.CENTRE);
			estiloDatos.setBorder(Border.ALL, BorderLineStyle.THIN);
			estiloDatos.setLocked(true);

			final WritableSheet hoja = workbook.createSheet("Reporte de Terminales", 0);

			// Titulo
			hoja.setRowView(0, 40 * 20);
			hoja.setRowView(1, 35 * 20);
			hoja.setRowView(2, 35 * 20);
			final Label labelTitulo = new Label(1, 0, "Reporte Terminal", estiloTitulo);
			hoja.addCell(labelTitulo);
			hoja.getSettings().setVerticalFreeze(2);
			hoja.mergeCells(1, 0, 22, 0);

			int contadorColumna = 0;

				contadorColumna = 0;
				//Nuevo
				hoja.addCell(new Label(contadorColumna++, 2, "Asistencia Víal",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Base",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Cam Foto Marca",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Cam Foto Serie",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Catálogo Móvil S",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Catálogo Oficina",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Catálogo Vehículo Aju",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Cédula Ajustador",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Clave Oficina",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Correo Electrónico",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Dispositivo Nombre",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Email Atraso",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Equipo Pesado",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Impre Marca",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Impre Serie",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Nombre",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Num. Econ",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Num. Prov.",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Número Proveedor",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Número Radio",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Otros Disp.",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Proveedor Telefonia",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Sub Grupo",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Tag",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Teléfono",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Tipo Asistencia Víal",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Unidad Marca",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Unidad Modelo",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Unidad Nombre",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Unidad Placas",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Unidad Serie",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Usuario",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Programa",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "No. Empleado",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Coordinador",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Supervisor",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Fecha Ingreso",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "No. Licencia",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Vigencia Licencia",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "No. Tarjeta Gasolina",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "No. Tag",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "GPS",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Teléfono Personal",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Dir. Calle",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Dir. Número",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Dir. Colonia",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Dir. Estado",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "Dir. C.P.",estiloEncabezadoDatosColumna));
				hoja.addCell(new Label(contadorColumna++, 2, "RFC",estiloEncabezadoDatosColumna));

//				 List<Terminal> lista = null;
//				 try {
//				 if (getPermisoTodosEstados() && getPermisoTodosBases()){
//						lista = this.getTerminalService().listaDeTerminal(
//								this.getEstadoService().objetoEstado(this.getIdEstado()),
//								this.getBaseService().objetoBase(this.getIdBase()), null, this.txtTerminalNombre,
//								this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
//								Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS);
//					} else {
//						if (this.getIdEstado().equals("9999")){
//							if (Integer.parseInt(this.getIdBase()) < 0)
//							{
//								lista = this.getTerminalService().listaDeTerminal(
//										this.getEstadoService().objetoEstado(this.getIdEstado()),
//										null, this.getListaDeBasesPorFrecuencia(), this.txtTerminalNombre,
//										this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
//										Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS);
//							} else {
//								lista = this.getTerminalService().listaDeTerminal(
//										this.getEstadoService().objetoEstado(this.getIdEstado()),
//										this.getBaseService().objetoBase(this.getIdBase()), null, this.txtTerminalNombre,
//										this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
//										Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS);
//							}
//						} else {
//							if (Integer.parseInt(this.getIdBase()) < 0)
//							{
//								lista = this.getTerminalService().listaDeTerminal(
//										null, null, this.getListaDeBasesPorFrecuencia(), this.txtTerminalNombre,
//										this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
//										Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS);
//							} else {	
//								lista = this.getTerminalService().listaDeTerminal(
//										this.getEstadoService().objetoEstado(this.getIdEstado()),
//										this.getBaseService().objetoBase(this.getIdBase()), null, this.txtTerminalNombre,
//										this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
//										Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS);
//							}
//						}
//						
//						
//					}
//				} catch (final ClassCastException| RollbackException| IndexOutOfBoundsException | IllegalArgumentException | NoResultException ex) {
//					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "listaTerminalParaReporte");
//				} catch (final PersistenceException | IllegalStateException ex) {
//					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "listaTerminalParaReporte");
//				}
//					
				int contadorFila = 3;
				if ((lista != null) && (lista.size() > 0)) {
					for (final Terminal term : lista) {
						contadorColumna = 0;
						if (term.getAsistenciaVial()) {
							hoja.addCell(new Label(contadorColumna++, contadorFila, "SI"  , estiloDatos));	
						} else {
							hoja.addCell(new Label(contadorColumna++, contadorFila, "NO" , estiloDatos));
						}
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getBase().getNombre(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getCamFotoMarca() , estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getCamFotoSerie() , estiloDatos));
						if (term.getCatalogoMovil() != null) {
							hoja.addCell(new Label(contadorColumna++, contadorFila, term.getCatalogoMovil().getMarca()+"-"+term.getCatalogoMovil().getModelo() , estiloDatos));
						}else {
							hoja.addCell(new Label(contadorColumna++, contadorFila,"" , estiloDatos));
						}
						
						if (term.getCatalogoOficina() != null) {
							hoja.addCell(new Label(contadorColumna++, contadorFila, term.getCatalogoOficina().getDescripcion() , estiloDatos));	
						} else {
							hoja.addCell(new Label(contadorColumna++, contadorFila,"" , estiloDatos));
						}
						
						if (term.getCatalogoVehiculoAjus() != null) {
							hoja.addCell(new Label(contadorColumna++, contadorFila, term.getCatalogoVehiculoAjus().getMarca()+"-"+term.getCatalogoVehiculoAjus().getTipo() , estiloDatos));
						} else {
							hoja.addCell(new Label(contadorColumna++, contadorFila,"" , estiloDatos));
						}
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getCedulaAjustador() , estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getClaveOficina(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getCorreoElectronico(), estiloDatos));					
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getDispositivoNombre(), estiloDatos));
						if (term.getEmailAtraso() != null && term.getEmailAtraso()) {
							hoja.addCell(new Label(contadorColumna++, contadorFila, "SI", estiloDatos));	
						} else {
							hoja.addCell(new Label(contadorColumna++, contadorFila, "NO", estiloDatos));
						}
						if (term.getEquipoPesado() != null && term.getEquipoPesado()) {
							hoja.addCell(new Label(contadorColumna++, contadorFila, "SI", estiloDatos));	
						} else {
							hoja.addCell(new Label(contadorColumna++, contadorFila, "NO", estiloDatos));
						}
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getImpreMarca(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getImpreSerie(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getNombre(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getNumeroEcon(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getNumeroProv(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getNumeroproveedor(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getNumeroradio(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getOtrosDisp(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getProveedorTelefonia(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getSubGrupo(), estiloDatos));
						if (term.getTag() != null) {
							if (term.getTag()) {
								hoja.addCell(new Label(contadorColumna++, contadorFila, "SI", estiloDatos));	
							} else {
								hoja.addCell(new Label(contadorColumna++, contadorFila, "NO", estiloDatos));
							}
						}else {
							hoja.addCell(new Label(contadorColumna++, contadorFila,"" , estiloDatos));
						}
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getTelefono(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getTipoAsistenciaVial(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getUnidadMarca(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getUnidadModelo(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getUnidadNombre(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getUnidadPlacas(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getUnidadSerie(), estiloDatos));
						if (term.getUsuario() != null) {
							hoja.addCell(new Label(contadorColumna++, contadorFila, term.getUsuario().getNombre(), estiloDatos));
						}else {
							hoja.addCell(new Label(contadorColumna++, contadorFila,"" , estiloDatos));
						}
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getPrograma(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getNoEmpleado(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getCoordinador(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getSupervisor() , estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getFechaIngreso(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getNoLicencia() , estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getVigenciaLicencia(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getNoTarjetaGasolina(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getNoTag() , estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getGps(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getTelefonoPersonal(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getDirCalle(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getDirNumero(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getDirColonia(), estiloDatos));
						if (term.getDirEstado() != null) {
							hoja.addCell(new Label(contadorColumna++, contadorFila, term.getDirEstado().getNombre(), estiloDatos));
						} else {
							hoja.addCell(new Label(contadorColumna++, contadorFila,"" , estiloDatos));
						}
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getDirCP(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, term.getRfc(), estiloDatos));

						
						contadorFila++;
					}
				}
				contadorFila++;
				contadorColumna = 0;
				
			workbook.write();
			workbook.close();
			return paraFuera.toByteArray();

		} catch (final IOException e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Terminal Excel");
			this.ponerMensajeError("Error al crear el reporte terminal : " + e.getMessage());
		}  catch (final WriteException e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Terminal Excel");
			this.ponerMensajeError("Error al crear el reporte terminal : " + e.getMessage());
		}  catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Terminal Excel");
			this.ponerMensajeError("Error al crear el reporte terminal : " + e.getMessage());
		}  catch (final Exception e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Terminal Excel");
			this.ponerMensajeError("Error al crear el reporte terminal : " + e.getMessage());
		}
		return null;
		
	}
	
	@Override
	public String doAccionReporte() {
		return this.doReporte(this.obtenerParametroDeRequest("id"), "reporte_terminales", this.obtenerParametroDeRequest("descripcion"));
	  }
	    
	 public String doReporte( final String id, final String nombre, final String descripcion) {
		 List<Terminal> lista = null;
		 try {
		 if (getPermisoTodosEstados() && getPermisoTodosBases()){
				lista = this.getTerminalService().listaDeTerminal(
						this.getEstadoService().objetoEstado(this.getIdEstado()),
						this.getBaseService().objetoBase(this.getIdBase()), null, this.txtTerminalNombre,
						this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
						Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS);
			} else {
				if (this.getIdEstado().equals("9999")){
					if (Integer.parseInt(this.getIdBase()) < 0)
					{
						lista = this.getTerminalService().listaDeTerminal(
								this.getEstadoService().objetoEstado(this.getIdEstado()),
								null, this.getListaDeBasesPorFrecuencia(), this.txtTerminalNombre,
								this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
								Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS);
					} else {
						lista = this.getTerminalService().listaDeTerminal(
								this.getEstadoService().objetoEstado(this.getIdEstado()),
								this.getBaseService().objetoBase(this.getIdBase()), null, this.txtTerminalNombre,
								this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
								Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS);
					}
				} else {
					if (Integer.parseInt(this.getIdBase()) < 0)
					{
						lista = this.getTerminalService().listaDeTerminal(
								null, null, this.getListaDeBasesPorFrecuencia(), this.txtTerminalNombre,
								this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
								Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS);
					} else {	
						lista = this.getTerminalService().listaDeTerminal(
								this.getEstadoService().objetoEstado(this.getIdEstado()),
								this.getBaseService().objetoBase(this.getIdBase()), null, this.txtTerminalNombre,
								this.txtTerminalTerminal, this.txtTerminalNumeroRadio, this.txtTerminalNumeroProveedor, null,
								Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenCatalogoTerminal, null, null,_filtroEstatus,_filtroCoordenadasBase,_filtroCoordenadasWS);
					}
				}
				
				
			}
		} catch (final ClassCastException| RollbackException| IndexOutOfBoundsException | IllegalArgumentException | NoResultException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "listaTerminalParaReporte");
		} catch (final PersistenceException | IllegalStateException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "listaTerminalParaReporte");
		}
			 
		 if (lista != null && lista.size() > 0) {
		     if (StringUtils.equals((CharSequence)id, (CharSequence)"excel")) {
		         return this.reporteExcel(lista, nombre);
		     }
		     if (StringUtils.equals((CharSequence)id, (CharSequence)"xml")) {
		          return this.doReporteXML(lista, nombre);
		      }
		     if (StringUtils.equals((CharSequence)id, (CharSequence)"pdf")) {
		         return this.doReportePDF(lista, nombre);
		     }
		 } else {
			this.ponerMensajeAdvertencia("No se encontraron datos para descargar.");
	    }
	     return null;
	 }
	 
	 public String reporteExcel( List<Terminal> lista,  String nombre) {
	      return  this.enviarArchivoACliente(nombre + ".xls", obtenerReporteExcel(lista));
	 }
		 
	// **************************************************************//
	// Permisos
	// **************************************************************//

	public boolean getMostrarPermisos(){	
		return true;	
	}
	/**
	 * @return el permiso
	 */
	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogo/terminalesABM.siica");

	}

	/**
	 * @return el permiso
	 */
	public boolean getPermisoABMAvanzado() {
		return this.getTienePermisoParaPagina("/Catalogo/terminalesABMAvanzado.siica");

	}
	
	
	/**
	 * @return el permiso
	 */
	public boolean getTienePermisoEditarAv(){	
		return this.getUsuarioActual().getCatalogoPermisoAv();	
	}
	
	
	public boolean getPermisoActualizarAjustadoresSise() {
		return this.getTienePermisoParaPagina("/SIICAGlobal/actulizarTelefenosSISE.siica");
	}

	// **************************************************************//
	// Getters y setters
	// **************************************************************//

	/**
	 * Jose Miguel Feb 17, 2011 8:59:33 PM
	 * 
	 * @return the objetoABM
	 */
	@Override
	public Terminal getObjetoABM() {
		return super.getObjetoABM();
	}

	/**
	 * Jose Miguel Feb 17, 2011 9:00:05 PM
	 * 
	 * @return the txtTerminalTerminal
	 */
	public String getTxtTerminalTerminal() {
		return this.txtTerminalTerminal;
	}

	/**
	 * Jose Miguel Feb 17, 2011 9:00:05 PM
	 * 
	 * @param txtTerminalTerminal
	 *            the txtTerminalTerminal to set
	 */
	public void setTxtTerminalTerminal(final String txtTerminalTerminal) {
		this.txtTerminalTerminal = txtTerminalTerminal;
	}

	/**
	 * Jose Miguel Feb 17, 2011 9:00:05 PM
	 * 
	 * @return the txtTerminalNombre
	 */
	public String getTxtTerminalNombre() {
		return this.txtTerminalNombre;
	}

	/**
	 * Jose Miguel Feb 17, 2011 9:00:05 PM
	 * 
	 * @param txtTerminalNombre
	 *            the txtTerminalNombre to set
	 */
	public void setTxtTerminalNombre(final String txtTerminalNombre) {
		this.txtTerminalNombre = txtTerminalNombre;
	}

	/**
	 * Jose Miguel Feb 17, 2011 9:00:05 PM
	 * 
	 * @return the txtTerminalNumeroProveedor
	 */
	public String getTxtTerminalNumeroProveedor() {
		return this.txtTerminalNumeroProveedor;
	}

	/**
	 * Jose Miguel Feb 17, 2011 9:00:05 PM
	 * 
	 * @param txtTerminalNumeroProveedor
	 *            the txtTerminalNumeroProveedor to set
	 */
	public void setTxtTerminalNumeroProveedor(final String txtTerminalNumeroProveedor) {
		this.txtTerminalNumeroProveedor = txtTerminalNumeroProveedor;
	}

	/**
	 * Jose Miguel Feb 17, 2011 9:00:05 PM
	 * 
	 * @return the txtTerminalNumeroRadio
	 */
	public String getTxtTerminalNumeroRadio() {
		return this.txtTerminalNumeroRadio;
	}

	/**
	 * Jose Miguel Feb 17, 2011 9:00:05 PM
	 * 
	 * @param txtTerminalNumeroRadio
	 *            the txtTerminalNumeroRadio to set
	 */
	public void setTxtTerminalNumeroRadio(final String txtTerminalNumeroRadio) {
		this.txtTerminalNumeroRadio = txtTerminalNumeroRadio;
	}

	/**
	 * Feb 28, 2011 3:33:07 PM
	 * 
	 * @return the idPuntoInteresSeleccionado
	 */
	public String getIdPuntoInteresSeleccionado() {
		return this.idPuntoInteresSeleccionado;
	}

	/**
	 * Feb 28, 2011 3:33:07 PM
	 * 
	 * @param idPuntoInteresSeleccionado
	 *            the idPuntoInteresSeleccionado to set
	 */
	public void setIdPuntoInteresSeleccionado(final String idPuntoInteresSeleccionado) {
		this.idPuntoInteresSeleccionado = idPuntoInteresSeleccionado;
	}

	/**
	 * Feb 28, 2011 3:33:07 PM
	 * 
	 * @return the idGeocercaEntraSeleccionado
	 */
	public String getIdGeocercaEntraSeleccionado() {
		return this.idGeocercaEntraSeleccionado;
	}

	/**
	 * Feb 28, 2011 3:33:07 PM
	 * 
	 * @param idGeocercaEntraSeleccionado
	 *            the idGeocercaEntraSeleccionado to set
	 */
	public void setIdGeocercaEntraSeleccionado(final String idGeocercaEntraSeleccionado) {
		this.idGeocercaEntraSeleccionado = idGeocercaEntraSeleccionado;
	}

	/**
	 * Feb 28, 2011 3:33:07 PM
	 * 
	 * @return the idGeocercaSaleSeleccionado
	 */
	public String getIdGeocercaSaleSeleccionado() {
		return this.idGeocercaSaleSeleccionado;
	}

	/**
	 * Feb 28, 2011 3:33:07 PM
	 * 
	 * @param idGeocercaSaleSeleccionado
	 *            the idGeocercaSaleSeleccionado to set
	 */
	public void setIdGeocercaSaleSeleccionado(final String idGeocercaSaleSeleccionado) {
		this.idGeocercaSaleSeleccionado = idGeocercaSaleSeleccionado;
	}

	/**
	 * Feb 28, 2011 3:34:27 PM
	 * 
	 * @return the objetoABMAlterta
	 */
	public TerminalAlerta getobjetoABMAlterta() {
		return this.objetoABMAlterta;
	}

	/**
	 * Feb 28, 2011 3:34:27 PM
	 * 
	 * @param objetoABMAlterta
	 *            the objetoABMAlterta to set
	 */
	public void setobjetoABMAlterta(final TerminalAlerta objetoABMAlterta) {
		this.objetoABMAlterta = objetoABMAlterta;
	}

	/**
	 * Jun 4, 2014 5:51:29 PM
	 * 
	 * @return the txtTerminalHorario
	 */
	public String getTxtTerminalHorario() {
		return this.txtTerminalHorario;
	}

	/**
	 * Jun 4, 2014 5:51:29 PM
	 * 
	 * @param txtTerminalHorario
	 *            the txtTerminalHorario to set
	 */
	public void setTxtTerminalHorario(final String txtTerminalHorario) {
		this.txtTerminalHorario = txtTerminalHorario;
	}

	public Boolean get_filtroCoordenadasBase() {
		return _filtroCoordenadasBase;
	}

	public void set_filtroCoordenadasBase(final Boolean _filtroCoordenadasBase) {
		this._filtroCoordenadasBase = _filtroCoordenadasBase;
	}

	public Boolean get_filtroCoordenadasWS() {
		return _filtroCoordenadasWS;
	}

	public void set_filtroCoordenadasWS(final Boolean _filtroCoordenadasWS) {
		this._filtroCoordenadasWS = _filtroCoordenadasWS;
	}

	public String get_filtroEstatus() {
		return _filtroEstatus;
	}

	public void set_filtroEstatus(final String _filtroEstatus) {
		this._filtroEstatus = _filtroEstatus;
	}

	/**
	 * @return the tipoAv
	 */
	public String[] getTipoAv() {
		return tipoAv;
	}

	/**
	 * @param tipoAv the tipoAv to set
	 */
	public void setTipoAv(String[] tipoAv) {
		this.tipoAv = tipoAv;
	}

	public TerminalComentario getObjetoABMComentario() {
		return objetoABMComentario;
	}

	public void setObjetoABMComentario(TerminalComentario objetoABMComentario) {
		this.objetoABMComentario = objetoABMComentario;
	}

	public String getTxtComentario() {
		return txtComentario;
	}

	public void setTxtComentario(String txtComentario) {
		this.txtComentario = txtComentario;
	}

	public String get_horario() {
		return _horario;
	}

	public void set_horario(String _horario) {
		this._horario = _horario;
	}
	
	/**
	 * @return the estatusInactivo
	 */
	public String getEstatusInactivo() {
		return estatusInactivo;
	}

	/**
	 * @param estatusInactivo the estatusInactivo to set
	 */
	public void setEstatusInactivo(String estatusInactivo) {
		this.estatusInactivo = estatusInactivo;
	}


	public Usuario getUsuarioPermiso() {
		return usuarioPermiso;
	}

	public void setUsuarioPermiso(Usuario usuarioPermiso) {
		this.usuarioPermiso = usuarioPermiso;
	}
	
	
	
	
}
