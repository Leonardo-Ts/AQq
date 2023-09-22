package com.aaq.col.clases.database.repositorios.dao.sac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.CallableStatementCreator;

import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;

public class SacSPGestionRecuperosCallableStatement implements CallableStatementCreator {

    private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase = HistoricoTerminal.getHistoricoTerminalService();
    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
    
	private Map<String, Object> entry;

	public SacSPGestionRecuperosCallableStatement(Map<String, Object> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con)
			throws SQLException {
		CallableStatement statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_RECUPERO(?,?,?,?,?,?,?,?,?,?,?)");

		statement.setString(1, (String) entry.get("dmReporte"));
		statement.setString(2, (String) entry.get("dmIdRecuperacion"));
		statement.setString(3, (String) entry.get("dmIdInvr"));
		statement.setString(4, (String) entry.get("dmIdProveedor"));
		statement.setString(5, (String) entry.get("dmNumSiniestro"));
		statement.setString(6, (String) entry.get("dmNumFolio"));
		statement.setString(7, (String) entry.get("dmDeducible"));
		statement.setString(8, (String) entry.get("dmEfectivo"));
		statement.setString(9, (String) entry.get("dmRecibo"));
		statement.setString(10, (String) entry.get("dmUsuario"));
		statement.registerOutParameter(11, Types.VARCHAR);

		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, (Terminal) entry.get("terminal"), (String) entry.get("dmReporte"),
                    "SAC" + "ejecucionSP", "Gestion Movil V3",
                    "Envio a SAC(Recupero): " + "[" +
                    entry.get("dmReporte") + ", " +
                    entry.get("dmIdRecuperacion") + ", " +
                    entry.get("dmIdInvr") + ", " +
                    entry.get("dmIdProveedor") + ", " +
                    entry.get("dmNumSiniestro") + ", " +
                    entry.get("dmNumFolio") + ", " +
                    entry.get("dmDeducible") + ", " +
                    entry.get("dmEfectivo") + ", " +
                    entry.get("dmRecibo") +", " +
                    entry.get("dmUsuario") + "]");
		} catch ( ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
		} catch (DataIntegrityViolationException | CannotGetJdbcConnectionException | PersistenceException  ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
		} catch ( DataAccessException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
		}
		
		return statement;
	}

}
