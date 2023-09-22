 package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalReporte;
import com.aaq.col.clases.database.servicios.interfase.TerminalReporteServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.aaq.col.clases.webservices.wscabina.reporte.Resultado;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "terminalReporte")
@RequestScoped
@Entity(name = "TerminalReporte")
@Access(AccessType.FIELD)
@Table(name = "terminal_reporte")
public class TerminalReporte extends AbstractTerminalReporte {
	private static final long serialVersionUID = -5591393203482305948L;

	@Transient
	private Transaccion transaccion;

	@Transient
	private Resultado resultado;

//	@Transient
//	private JMWSPoliza poliza;

	@Transient
	private List<TerminalReporteDocumento> terminalReporteDocumentos;

	/** default constructor */
	public TerminalReporte() {
		super();
		this.setAnio(StringUtils.right(Integer.toString(DateUtils.toCalendar(new Date()).get(Calendar.YEAR)), 2));
		this.terminalReporteDocumentos = new ArrayList<>();
		this.setRamo("04");
		this.setReporte("000000");

		this.setSipacAplica(Boolean.FALSE);
		this.setSipacRecibimos(Boolean.FALSE);
		this.setSipacDimos(Boolean.FALSE);
		this.setSipacAmbos(Boolean.FALSE);
	}

	private static TerminalReporteServiceInterfase terminalReporteService;

	public static TerminalReporteServiceInterfase getTerminalReporteService() {
		if (TerminalReporte.terminalReporteService == null) {
			TerminalReporte.terminalReporteService = JMSIICAServerServiceSingleton.getInstance()
					.getTerminalReporteService();
		}
		return TerminalReporte.terminalReporteService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Fecha,fecha,fecha", "Ajustador,terminal", "Año,anio",
				"Reporte,reporte", "Siniestro,siniestro", "Folio,folioAjustador" }).getLista();
	}

	// **************************************************************//
	// Especificos para la aplicacion
	// **************************************************************//

	/**
	 * @return la lista
	 */
	public List<TerminalReporteDocumento> getTerminalReporteDocumentos() {
		return this.terminalReporteDocumentos;
	}

	/**
	 * @param terminalReporteDocumentos
	 *            the terminalReporteDocumentos to set
	 */
	public void setTerminalReporteDocumentos(final ArrayList<TerminalReporteDocumento> terminalReporteDocumentos) {
		this.terminalReporteDocumentos = terminalReporteDocumentos;
	}

	// **************************************************************//
	// Getters y setters
	// **************************************************************//

	/**
	 * @return the transaccion
	 */
	public Transaccion getTransaccion() {
		return this.transaccion;
	}

	/**
	 * @param transaccion
	 *            the transaccion to set
	 */
	public void setTransaccion(final Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	/**
	 * @return the resultado
	 */
	public Resultado getResultado() {
		return this.resultado;
	}

	public void setResultado(final Resultado resultado) {
		this.resultado = resultado;
	}


	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return TerminalReporte.getTerminalReporteService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return TerminalReporte.getTerminalReporteService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
