package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteAbogado;
import com.aaq.col.clases.database.servicios.interfase.ReporteAbogadoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

/**
 */
@ManagedBean(name = "reporteAbogado")
@RequestScoped
@Entity(name = "ReporteAbogado")
@Access(AccessType.FIELD)
@Table(name = "reporte_abogado")
public class ReporteAbogado extends AbstractReporteAbogado {
	
	@Override
	public String toString() {
		return "ReporteAbogado [getId()=" + getId() + ", getFechaRecibidoWs()=" + getFechaRecibidoWs()
				+ ", getFechaAsignado()=" + getFechaAsignado() + ", getFechaArribo()=" + getFechaArribo()
				+ ", getNumeroReporteSise()=" + getNumeroReporteSise() + ", getNumeroReporteLegal()="
				+ getNumeroReporteLegal() + ", getNumeroProveedorAbogado()=" + getNumeroProveedorAbogado()
				+ ", getEstatus()=" + getEstatus() + ", getConductorDetenido()=" + getConductorDetenido()
				+ ", getVehiculoRetenido()=" + getVehiculoRetenido() + ", getNumeroLesionadosNa()="
				+ getNumeroLesionadosNa() + ", getNumeroLesionadosTs()=" + getNumeroLesionadosTs()
				+ ", getNumeroMuertosNa()=" + getNumeroMuertosNa() + ", getNumeroMuertosTs()=" + getNumeroMuertosTs()
				+ ", getLugarAPresentarse()=" + getLugarAPresentarse() + ", getEnviadoASise()=" + getEnviadoASise()
				+ ", getEnviadoPorSms()=" + getEnviadoPorSms() + ", getResponsabilidad()=" + getResponsabilidad()
				+ ", getMotivoSolicitud()=" + getMotivoSolicitud() + ", getTerminal()=" + getTerminal()
				+ ", getTelefonoAbogado()=" + getTelefonoAbogado() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	private static final long serialVersionUID = 4153868564562283288L;

	/** default constructor */
	public ReporteAbogado() {
		super();
	}

	/**
	 * @param terminal
	 * @param fechaRecibidoWs
	 * @param numeroReporteSise
	 * @param numeroReporteLegal
	 * @param numeroProveedorAbogado
	 * @param estatus
	 * @param conductorDetenido
	 * @param vehiculoRetenido
	 * @param numeroLesionadosNa
	 * @param numeroLesionadosTs
	 * @param numeroMuertosNa
	 * @param numeroMuertosTs
	 * @param lugarAPresentarse
	 * @param responsabilidad
	 * @param motivoSolicitud
	 * @param telefonoAbogado
	 */
	public ReporteAbogado(final Terminal terminal, final Date fechaRecibidoWs, final String numeroReporteSise,
			final String numeroReporteLegal, final String numeroProveedorAbogado, final String estatus,
			final Boolean conductorDetenido, final Boolean vehiculoRetenido, final Integer numeroLesionadosNa,
			final Integer numeroLesionadosTs, final Integer numeroMuertosNa, final Integer numeroMuertosTs,
			final String lugarAPresentarse, final Integer responsabilidad, final Integer motivoSolicitud, final Integer telefonoAbogado) {
		super(terminal, fechaRecibidoWs, numeroReporteSise, numeroReporteLegal, numeroProveedorAbogado, estatus,
				conductorDetenido, vehiculoRetenido, numeroLesionadosNa, numeroLesionadosTs, numeroMuertosNa,
				numeroMuertosTs, lugarAPresentarse, Boolean.FALSE, Boolean.FALSE, responsabilidad, motivoSolicitud, telefonoAbogado );

	}

	private static ReporteAbogadoServiceInterfase reporteAbogadoService;

	public static ReporteAbogadoServiceInterfase getReporteAbogadoService() {
		if (ReporteAbogado.reporteAbogadoService == null) {
			ReporteAbogado.reporteAbogadoService = JMSIICAServerServiceSingleton.getInstance()
					.getReporteAbogadoService();
		}
		return ReporteAbogado.reporteAbogadoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Reporte SISE,numeroReporteSise",
				"Reporte Legal,numeroReporteLegal", "No. Proveedor / Nombre Abogado,numeroProveedorAbogado",
				"Ajustador,ajustadorNombre", "Cve Ajustador,ajustadorNumero", "Estatus,estatus",
				"Solicitado,fechaRecibidoWs,fecha", "Asignado,fechaAsignado,fecha", "Arribo,fechaArribo,fecha"})
				.getLista();
	}

	/**
	 * @return la prop
	 */
	public String getAjustadorNombre() {
		return this.getTerminal() != null ? this.getTerminal().getNombre() : "";
	}

	/**
	 * @return la prop
	 */
	public String getAjustadorNumero() {
		return this.getTerminal() != null ? this.getTerminal().getNumeroproveedor() : "";
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
			return ReporteAbogado.getReporteAbogadoService().eliminarObjeto(this);
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
			return ReporteAbogado.getReporteAbogadoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
