package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractHistoricoTerminal;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "historicoTerminal")
@RequestScoped
@Entity(name = "HistoricoTerminal")
@Access(AccessType.FIELD)
@Table(name = "historico_terminal")
public class HistoricoTerminal extends AbstractHistoricoTerminal {

	private static final long serialVersionUID = 4824585755783160990L;

	public HistoricoTerminal() {
		super();
	}

	public HistoricoTerminal(final Usuario usuario, final Terminal terminal, final Date fecha, final String reporte,
			final String fuente, final String operacion, final String detalles) {
		super(usuario, terminal, fecha, reporte, fuente, operacion, detalles);
	}

	private static HistoricoTerminalServiceInterfase historicoTerminalService;

	public static HistoricoTerminalServiceInterfase getHistoricoTerminalService() {
		if (HistoricoTerminal.historicoTerminalService == null) {
			HistoricoTerminal.historicoTerminalService = JMSIICAServerServiceSingleton.getInstance()
					.getHistoricoTerminalService();
		}
		return HistoricoTerminal.historicoTerminalService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Fecha,fecha,fecha", "Ajustador,terminal",
				"Reporte,reporte", "Operacion,operacion", "Fuente,fuente", "Usuario,usuario", "Detalles,detalles" })
				.getLista();
	}

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
			return HistoricoTerminal.getHistoricoTerminalService().eliminarObjeto(this);
		}	catch (RollbackException | ClassCastException | IndexOutOfBoundsException e) {
				return new JMResultadoOperacion(e);
		}	catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			return new JMResultadoOperacion(ex);
		}	catch (final DataAccessException ex) {
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
			return HistoricoTerminal.getHistoricoTerminalService().guardarObjeto(this);
		}catch (ClassCastException e) {
			return new JMResultadoOperacion(e);
		}catch (final RollbackException | DataAccessException ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
