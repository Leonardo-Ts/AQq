package com.aaq.col.clases.database.repositorios.dao.sac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Types;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.CallableStatementCreator;

import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;

public class SacSPExamenToxCallableStatement implements CallableStatementCreator {

	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase = HistoricoTerminal.getHistoricoTerminalService();
    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
    
	private Map<String, Object> entry;

	public SacSPExamenToxCallableStatement(Map<String, Object> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con) throws SQLException {
		try {
		CallableStatement statement = con.prepareCall("call SP_DM_DATOSTABLET(?,?,?,?,?,"
																			+ "?,?,?,?,?,"
																			+ "?,?,?)"); // 13

		statement.setString(1, (String) entry.get("DMREPORTE"));
		statement.setString(2, (String) entry.get("DMUSER"));
		statement.setString(3, (String) entry.get("DMHORA_REC"));
		statement.setString(4, (String) entry.get("DMSIPAC"));
		statement.setString(5, (String) entry.get("DMTERCERO"));
		statement.setString(6, (String) entry.get("DMEXA_TOX"));
		statement.setString(7, (String) entry.get("DMEXA_TOX_CON"));
		statement.setString(8, (String) entry.get("DMEXA_TOX_BEB"));
		statement.setString(9, (String) entry.get("DMEXA_TOX_DRO"));
		statement.setString(10, (String) entry.get("DMEXA_TOX_AUT"));
		statement.setString(11, (String) entry.get("DMEXA_TOX_MOT"));
		statement.setString(12, (String) entry.get("DMQPRIMERO"));
		statement.registerOutParameter(13, Types.VARCHAR);
		
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, (Terminal) entry.get("terminal"), (String) entry.get("DMREPORTE"),
                    "SAC(SP_DM_DATOSTABLET)", "Examen Toxicologico",
                    "Envio a SAC(ExamenT): " + "[" +
                    entry.get("DMREPORTE") + ", " +
					entry.get("DMUSER") + ", " +
					entry.get("DMHORA_REC") + ", " +
					entry.get("DMSIPAC") + ", " +
					entry.get("DMTERCERO") + ", " +
					entry.get("DMEXA_TOX") + ", " +
					entry.get("DMEXA_TOX_CON") + ", " +
					entry.get("DMEXA_TOX_BEB") + ", " +
					entry.get("DMEXA_TOX_DRO") + ", " +
					entry.get("DMEXA_TOX_AUT") + ", " +
					entry.get("DMEXA_TOX_MOT") + ", " +
					entry.get("DMQPRIMERO") + 
					"]");
			
			return statement;
		}  catch (IndexOutOfBoundsException | ClassCastException  e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "SACEjecucionSP => SP_DM_DATOSTABLET");
		}catch (CannotGetJdbcConnectionException | DataIntegrityViolationException | 
				NoResultException| RollbackException | SQLFeatureNotSupportedException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SACEjecucionSP => SP_DM_DATOSTABLET");
		} catch (SQLException | PersistenceException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "SACEjecucionSP => SP_DM_DATOSTABLET");
		}
		return null;
	}


}
