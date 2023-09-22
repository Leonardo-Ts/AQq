package com.aaq.col.clases.database.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalAlerta;
import com.aaq.col.clases.database.servicios.interfase.TerminalAlertaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Entity(name = "TerminalAlerta")
@Access(AccessType.FIELD)
@Table(name = "terminal_alerta")
public class TerminalAlerta extends AbstractTerminalAlerta {

	private static final long serialVersionUID = 1862914286881963020L;

	public TerminalAlerta() {
		super();
		this.setHabilitado(Boolean.TRUE);
	}

	private static TerminalAlertaServiceInterfase terminalAlertaService;

	public static TerminalAlertaServiceInterfase getTerminalAlertaService() {
		if (TerminalAlerta.terminalAlertaService == null) {
			TerminalAlerta.terminalAlertaService = JMSIICAServerServiceSingleton.getInstance()
					.getTerminalAlertaService();
		}
		return TerminalAlerta.terminalAlertaService;
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);

		try {
			return TerminalAlerta.getTerminalAlertaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return TerminalAlerta.getTerminalAlertaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

}
