package com.aaq.col.clases.xml.webservices;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;
import javax.xml.bind.annotation.XmlAccessType;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.util.TiempoEstatusUtil;

@XmlRootElement //agregado para Rest
@XmlAccessorType(XmlAccessType.FIELD)
public class JMWSTerminalGenesys {
	private String nombre;
	
	private String telefono;
	
	private String password;
	
	private String latitudArribo;
	
	private String longitudArribo;
	
	private String latitudTermino;
	
	private String longitudTermino;
	
	private String base;
	
	private String reporteAsignado;
	
	private String latitudActual;
	
	private String longitudActual;
	
	private String estatus;
	
	private String uid;
	
	private String ultimaLocalizacionFecha;
	
	private String fechaEstatusAsignado;
	
	private String fechaEstatusArribo;
	
	private String fechaEstatusTermino;
	
	private String unidadPlacas;
	
	private String unidadMarcaAjust;

	public JMWSTerminalGenesys() {
		super();
	}

	public JMWSTerminalGenesys(final Terminal terminal) {
		super();
		
		this.nombre = terminal.getNombre();
		this.password = terminal.getPasswd();
		this.telefono = terminal.getTelefono();
		this.base = terminal.getBase().getNombre();
		
		try {
			this.reporteAsignado = terminal.getReporteSac().getGeneralNumeroReporte();			
		} catch (Exception e) {
			this.reporteAsignado = "no tiene reporte asignado por SAC"; 
		}
		
		this.latitudActual = terminal.getLatitud();
		this.longitudActual = terminal.getLongitud();
//		this.estatus = terminal.getEstatus();
		//Se añade el estatus igual que en el monitor
		
		
		  if (terminal.getFechaEstatusDesconectado() != null) {
	            this.estatus = "Desconectado";
	        }
	        if (terminal.getFechaEstatusOcupado() != null) {
	        	this.estatus = "Ocupado";
	        }
	      //Se cambia logica para V.9.20.7 para Guadalajara 360000 (6 min) y demas bases 300000(5 min)
	        if (terminal.getFechaEstatusDisponible() != null) {
	        	 TiempoEstatusUtil estatusUtileria = new TiempoEstatusUtil();
	 	        String estatusD = estatusUtileria.estatusDisponibles(terminal.getUltimoLocalizacionFecha(), 
	 	        		terminal.getFechaEstatusDisponible(), terminal.getBase(), terminal.getEstado()  );
	 	        if (StringUtils.isNotBlank(estatusD)) {
	 	        	this.estatus = estatusD;
	 			}
			}
	        
	        if (terminal.getFechaEstatusTermino() != null) {
	        	this.estatus = "Arribo";
	        }
	        if (terminal.getFechaEstatusArribo() != null) {
	            this.estatus = "Arribo";
	        }
		
		
		this.uid = terminal.getAndroidUid();
		this.ultimaLocalizacionFecha = String.valueOf(terminal.getUltimoLocalizacionFecha());
		this.fechaEstatusAsignado = String.valueOf(terminal.getFechaEstatusAsignado());
		this.fechaEstatusArribo = String.valueOf(terminal.getFechaEstatusArribo());
		this.fechaEstatusTermino = String.valueOf(terminal.getFechaEstatusTermino());
		this.unidadPlacas = terminal.getUnidadPlacas();	
		
		if (terminal.getCatalogoVehiculoAjus() != null) {
			this.unidadMarcaAjust = terminal.getCatalogoVehiculoAjus().getMarca() +" "+terminal.getCatalogoVehiculoAjus().getTipo();
		}


	}



	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the latitudArribo
	 */
	public String getLatitudArribo() {
		return latitudArribo;
	}

	/**
	 * @param latitudArribo the latitudArribo to set
	 */
	public void setLatitudArribo(String latitudArribo) {
		this.latitudArribo = latitudArribo;
	}

	/**
	 * @return the longitudArribo
	 */
	public String getLongitudArribo() {
		return longitudArribo;
	}

	/**
	 * @param longitudArribo the longitudArribo to set
	 */
	public void setLongitudArribo(String longitudArribo) {
		this.longitudArribo = longitudArribo;
	}

	/**
	 * @return the latitudTermino
	 */
	public String getLatitudTermino() {
		return latitudTermino;
	}

	/**
	 * @param latitudTermino the latitudTermino to set
	 */
	public void setLatitudTermino(String latitudTermino) {
		this.latitudTermino = latitudTermino;
	}

	/**
	 * @return the longitudTermino
	 */
	public String getLongitudTermino() {
		return longitudTermino;
	}

	/**
	 * @param longitudTermino the longitudTermino to set
	 */
	public void setLongitudTermino(String longitudTermino) {
		this.longitudTermino = longitudTermino;
	}

	/**
	 * @return the base
	 */
	public String getBase() {
		return base;
	}

	/**
	 * @param base the base to set
	 */
	public void setBase(String base) {
		this.base = base;
	}

	/**
	 * @return the reporteAsignado
	 */
	public String getReporteAsignado() {
		return reporteAsignado;
	}

	/**
	 * @param reporteAsignado the reporteAsignado to set
	 */
	public void setReporteAsignado(String reporteAsignado) {
		this.reporteAsignado = reporteAsignado;
	}

	/**
	 * @return the latitudActual
	 */
	public String getLatitudActual() {
		return latitudActual;
	}

	/**
	 * @param latitudActual the latitudActual to set
	 */
	public void setLatitudActual(String latitudActual) {
		this.latitudActual = latitudActual;
	}

	/**
	 * @return the longitudActual
	 */
	public String getLongitudActual() {
		return longitudActual;
	}

	/**
	 * @param longitudActual the longitudActual to set
	 */
	public void setLongitudActual(String longitudActual) {
		this.longitudActual = longitudActual;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the ultimaLocalizacionFecha
	 */
	public String getUltimaLocalizacionFecha() {
		return ultimaLocalizacionFecha;
	}

	/**
	 * @param ultimaLocalizacionFecha the ultimaLocalizacionFecha to set
	 */
	public void setUltimaLocalizacionFecha(String ultimaLocalizacionFecha) {
		this.ultimaLocalizacionFecha = ultimaLocalizacionFecha;
	}

	/**
	 * @return the fechaEstatusAsignado
	 */
	public String getFechaEstatusAsignado() {
		return fechaEstatusAsignado;
	}

	/**
	 * @param fechaEstatusAsignado the fechaEstatusAsignado to set
	 */
	public void setFechaEstatusAsignado(String fechaEstatusAsignado) {
		this.fechaEstatusAsignado = fechaEstatusAsignado;
	}

	/**
	 * @return the fechaEstatusArribo
	 */
	public String getFechaEstatusArribo() {
		return fechaEstatusArribo;
	}

	/**
	 * @param fechaEstatusArribo the fechaEstatusArribo to set
	 */
	public void setFechaEstatusArribo(String fechaEstatusArribo) {
		this.fechaEstatusArribo = fechaEstatusArribo;
	}

	/**
	 * @return the fechaEstatusTermino
	 */
	public String getFechaEstatusTermino() {
		return fechaEstatusTermino;
	}

	/**
	 * @param fechaEstatusTermino the fechaEstatusTermino to set
	 */
	public void setFechaEstatusTermino(String fechaEstatusTermino) {
		this.fechaEstatusTermino = fechaEstatusTermino;
	}

	public String getUnidadPlacas() {
		return unidadPlacas;
	}

	public void setUnidadPlacas(String unidadPlacas) {
		this.unidadPlacas = unidadPlacas;
	}

	public String getUnidadMarcaAjust() {
		return unidadMarcaAjust;
	}

	public void setUnidadMarcaAjust(String unidadMarcaAjust) {
		this.unidadMarcaAjust = unidadMarcaAjust;
	}


}

