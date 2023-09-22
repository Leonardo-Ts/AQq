 package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalReporteDocumentoTipo;
import com.aaq.col.clases.database.servicios.interfase.TerminalReporteDocumentoTipoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "terminalReporteDocumentoTipo")
@RequestScoped
@Entity(name = "TerminalReporteDocumentoTipo")
@Access(AccessType.FIELD)
@Table(name = "TERMINAL_REPORTE_DOC_TIPO")
public class TerminalReporteDocumentoTipo extends AbstractTerminalReporteDocumentoTipo {

	private static final long serialVersionUID = -938056798904898675L;

	/** default constructor */
	public TerminalReporteDocumentoTipo() {
		super();
		this.setHabilitado(Boolean.TRUE);
	}

	private static TerminalReporteDocumentoTipoServiceInterfase terminalReporteDocumentoTipoService;

	public static TerminalReporteDocumentoTipoServiceInterfase getTerminalReporteDocumentoTipoService() {
		if (TerminalReporteDocumentoTipo.terminalReporteDocumentoTipoService == null) {
			TerminalReporteDocumentoTipo.terminalReporteDocumentoTipoService = JMSIICAServerServiceSingleton
					.getInstance().getTerminalReporteDocumentoTipoService();
		}
		return TerminalReporteDocumentoTipo.terminalReporteDocumentoTipoService;
	}

	@Override
	public int hashCode() {
		return this.getId().intValue();
	}

	@Override
	public String toString() {
		return super.getClave() + " - " + super.getTipo();
	}

	public String getDescripcion() {
		return super.getClave() + " - " + super.getTipo();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);
		try {
			return TerminalReporteDocumentoTipo.getTerminalReporteDocumentoTipoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return TerminalReporteDocumentoTipo.getTerminalReporteDocumentoTipoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
}
