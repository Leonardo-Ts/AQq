package com.aaq.col.clases.database.repositorios.dao.sac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import javax.persistence.NoResultException;
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

public class SacSPSolicitarTicketCondCallableStatement implements CallableStatementCreator {


	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase = HistoricoTerminal.getHistoricoTerminalService();
    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
    
	private Map<String, Object> entry;

	public SacSPSolicitarTicketCondCallableStatement(Map<String, Object> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con) throws SQLException {
			CallableStatement statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_CESP(?,?,?)");
				statement.setString(1, (String) entry.get("dmReporte"));
				statement.setString(2, (String) entry.get("dmClaveCondicion"));
				statement.registerOutParameter(3, Types.VARCHAR);
			
			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, (Terminal) entry.get("terminal"), (String) entry.get("dmReporte"),
	                    "SAC(Generar_Ticket_Condiciones)", "Solicitar Ticket Condiciones",
	                    "Envio a SAC(SP_DISPOSITIVO_MOVIL_CESP)- Reporte: "+entry.get("dmReporte")+ ", Clave Condicion: "+entry.get("dmClaveCondicion"));
			} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
			}catch (CannotGetJdbcConnectionException | DataIntegrityViolationException | NoResultException| RollbackException ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
			} catch (ClassCastException | IllegalArgumentException e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
			} catch ( DataAccessException  e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
			} 
			
			return statement;
	}

}
