 package com.aaq.col.clases.database.entidades;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalAlertaLog;
import com.aaq.col.clases.database.servicios.interfase.TerminalAlertaLogServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Entity(name = "TerminalAlertaLog")
@Access(AccessType.FIELD)
@Table(name = "terminal_alerta_log")
public class TerminalAlertaLog extends AbstractTerminalAlertaLog {

	private static final long serialVersionUID = 2113385307974025155L;

	/** default constructor */
	public TerminalAlertaLog() {
		super();
		this.setFecha(new Date());
		this.setEnviadaEmail(Boolean.FALSE);
		this.setEnviadaSms(Boolean.FALSE);
		this.setEnviadaWeb(Boolean.FALSE);
	}

	private static TerminalAlertaLogServiceInterfase TerminalAlertaLogService;

    	public static TerminalAlertaLogServiceInterfase getTerminalAlertaLogService() {
		if (TerminalAlertaLog.TerminalAlertaLogService == null) {
			TerminalAlertaLog.TerminalAlertaLogService = JMSIICAServerServiceSingleton.getInstance()
					.getTerminalAlertaLogService();
		}
		return TerminalAlertaLog.TerminalAlertaLogService;
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return TerminalAlertaLog.getTerminalAlertaLogService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return TerminalAlertaLog.getTerminalAlertaLogService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

}
