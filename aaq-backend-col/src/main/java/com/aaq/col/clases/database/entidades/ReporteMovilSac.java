package com.aaq.col.clases.database.entidades;

import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteMovilSac;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

import java.util.ArrayList;
@ManagedBean(name = "reporteMovilSac")
@RequestScoped
@Entity(name = "ReporteMovilSac")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "reporte_movil_sac")
public class ReporteMovilSac extends AbstractReporteMovilSac {

	private static final long serialVersionUID = 7436240901781318247L;

	public ReporteMovilSac() {
		super();

	}

	private static ReporteMovilSacServiceInterfase reporteMovilSacService;

	public static ReporteMovilSacServiceInterfase getReporteMovilSacService() {
		if (ReporteMovilSac.reporteMovilSacService == null) {
			ReporteMovilSac.reporteMovilSacService = JMSIICAServerServiceSingleton.getInstance().getReporteMovilSacService();
		}
		return ReporteMovilSac.reporteMovilSacService;
	}


	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return ReporteMovilSac.getReporteMovilSacService().guardarObjeto(this);
		} catch ( IndexOutOfBoundsException | RollbackException e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		}	catch (DataAccessException e) {
			return new JMResultadoOperacion(e.getMessage());
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return super.getGeneralNumeroReporte();
	}
	
    @JMReporteOmitirMetodo
    public Date getFechaCreacion(){
        if (StringUtils.isNotBlank(getUbicacionDireccion())){
            try{
                return DateUtils.parseDate(StringUtils.left(getUbicacionDireccion(),16),"dd/MM/yyyy HH:mm");
			} catch (Exception ex){
                // nada
            }
        }

        return null;
    }
    
    
	public Date getFechaOcurrido(){	
		String horasplit [] = getGeneralHoraOcurrido().split(":");
		String fechasplit [] = getGeneralFechaOcurrido().split("-");
		
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(Calendar.HOUR_OF_DAY, Integer.parseInt(horasplit[0]));
		rightNow.set(Calendar.MINUTE, Integer.parseInt(horasplit[1]));
		rightNow.set(Calendar.YEAR, Integer.parseInt(fechasplit[0]));
		rightNow.set(Calendar.MONTH, Integer.parseInt(fechasplit[1])-1);
		rightNow.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fechasplit[2]));
		
		Date now = rightNow.getTime();

		return now;
	}
	
	public Date getFechaArribo(){	
		String horasplit [] = getAjusteHoraArriboAjustador().split(":");
		String fechasplit [] = getAjusteFechaArriboAjustador().split("/");
		
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(Calendar.HOUR_OF_DAY, Integer.parseInt(horasplit[0]));
		rightNow.set(Calendar.MINUTE, Integer.parseInt(horasplit[1]));
		rightNow.set(Calendar.YEAR, Integer.parseInt(fechasplit[2]));
		rightNow.set(Calendar.MONTH, Integer.parseInt(fechasplit[1])-1);
		rightNow.set(Calendar.DAY_OF_MONTH, Integer.parseInt(fechasplit[0]));
		
		Date now = rightNow.getTime();

		return now;
	}
	
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Fecha,fecha,fecha", "Numero Reporte,generalNumeroReporte",
				"Poliza,generalNumeroPoliza", "Inciso,generalInciso", "Fecha Ocurrido,horaFechaOcurrido",
				"Codigo-Causa,ajusteCodigoCausa","Estado,ubicacionEntidad","Municipio,ubicacionMunicipio",
				"Clave Ajustador,ajusteAjustadorCodigo","Nombre Ajustador,ajusteAjustadorNombre",
				"Codigo Responsabilidad,codigoResponsabilidad","Matriz,matriz","Codigo Matriz,codigoMatriz"}).getLista();
	}

	public String getPolizaInciso() {
		if(getGeneralNumeroPoliza()!= null && getGeneralInciso()!= null) {
		return getGeneralNumeroPoliza() + getGeneralInciso();
		} else
			if(getGeneralNumeroPoliza() != null && getGeneralInciso()== null) {
				return getGeneralNumeroPoliza();
			} else 
				if(getGeneralNumeroPoliza() == null && getGeneralInciso()!= null) {
					return getGeneralInciso();
				}
		return null;
		
	}
	
	public String getHoraFechaOcurrido() {
		if(getGeneralFechaOcurrido() != null && getGeneralHoraOcurrido()!= null) {
			return getGeneralFechaOcurrido() + " "+ getGeneralHoraOcurrido();
		} else 
			if(getGeneralFechaOcurrido() != null && getGeneralHoraOcurrido()== null) {
				return getGeneralFechaOcurrido();
			} else 
				if(getGeneralFechaOcurrido()== null && getGeneralHoraOcurrido()!= null) {
					return getGeneralHoraOcurrido();
				}
		return null;
	}
}
