package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteMovil;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "reporteMovil")
@RequestScoped
@Entity(name = "ReporteMovil")
@Access(AccessType.FIELD)
@Table(name = "reporte_movil")
public class ReporteMovil extends AbstractReporteMovil {
	private static final long serialVersionUID = -7333472680109133272L;

	// Constructors

	public ReporteMovil() {
		super();

	}

	private static ReporteMovilServiceInterfase reporteMovilService;

	public static ReporteMovilServiceInterfase getReporteMovilService() {
		if (ReporteMovil.reporteMovilService == null) {
			ReporteMovil.reporteMovilService = JMSIICAServerServiceSingleton.getInstance().getReporteMovilService();
		}
		return ReporteMovil.reporteMovilService;
	}

	@JMReporteOmitirMetodo
	public String getIcono() {
		if ((this.getFechaVisto() != null)) {
			return "/diseno/imagenes/otros/handshake.png";
		}
		final long dif = System.currentTimeMillis() - this.getFecha().getTime();
		if (dif <= 60000) {
			return "/diseno/imagenes/otros/flag_green.png";
		}
		if (dif <= 120000) {
			return "/diseno/imagenes/otros/flag_yellow.png";
		}
		if (dif <= 180000) {
			return "/diseno/imagenes/otros/flag_red.png";
		}

		return "/diseno/imagenes/otros/flag_yellow.png";

	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Fecha,fecha,fecha,,agenteEspecialCSS",
				"Telefono,telefonoContacto,,,agenteEspecialCSS", "Poliza,poliza,,,agenteEspecialCSS",
				"Inciso,inciso,,,agenteEspecialCSS", "Fuente,fuente,,,agenteEspecialCSS",
				"Agente,agente,,,agenteEspecialCSS" }).getLista();
	}

	@JMReporteOmitirMetodo
	public String getDescripcionHTML() {
		final StringBuilder b = new StringBuilder("<b>Ticket: </b>" + this.getId());
		b.append("<br /><b>Poliza: </b>" + this.getPoliza());
		b.append("<br /><b>Inciso: </b>" + this.getInciso());
		return Objects.toString(b, "");
	}

	@JMReporteOmitirMetodo
	public boolean getTieneAgenteEspecial() {

		return StringUtils.containsAny(this.getAgente(), "54740")||StringUtils.containsAny(this.getAgente(), "57346")||StringUtils.containsAny(this.getAgente(), "7910")
				||StringUtils.containsAny(this.getPoliza(), "0002724870");

	}

	@JMReporteOmitirMetodo
	public String getAgenteEspecialLeyenda() {

		if (StringUtils.equalsIgnoreCase(this.getAgente(), "54740")||StringUtils.equalsIgnoreCase(this.getAgente(), "57346")){
			return "Qualitas Programa Hyundai Protec le atiende";
		}
		
		else if (StringUtils.equalsIgnoreCase(this.getAgente(), "7910")){ 
			return "Autocompara Santander";	
		}
		
		else if(StringUtils.equalsIgnoreCase(this.getPoliza(), "0002724870")){
			return "Traductor:Alex Park,  Tel:8120229197";
		}

		return null;

	}

	@JMReporteOmitirMetodo
	public String getAgenteEspecialCSS() {

		if (StringUtils.equalsIgnoreCase(this.getAgente(), "54740")||StringUtils.equalsIgnoreCase(this.getAgente(), "57346")||StringUtils.equalsIgnoreCase(this.getAgente(), "7910")
				||StringUtils.equalsIgnoreCase(this.getPoliza(), "0002724870")) {
			return "css_reporte_movil_agente_especial_54740";
		}

		return null;

	}

	@JMReporteOmitirMetodo
	public String getAgenteEspecialImagen() {

		if (StringUtils.equalsIgnoreCase(this.getAgente(), "54740")||StringUtils.equalsIgnoreCase(this.getAgente(), "57346")) {
			return "/diseno/imagenes/logos/externo/Hyundai-Logo.png";
		}
		else if(StringUtils.equalsIgnoreCase(this.getAgente(), "7910")){
			return "/diseno/imagenes/logos/externo/autocompara.png";
		}
		else if(StringUtils.equalsIgnoreCase(this.getPoliza(), "0002724870")){
			return "/diseno/imagenes/logos/externo/KIA.png";
		}
		
		return null;

	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad #editarObjeto()
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {

		try {
			return ReporteMovil.getReporteMovilService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return ReporteMovil.getReporteMovilService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
}
