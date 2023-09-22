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

public class SacSPGestionCallableStatement implements CallableStatementCreator {
	
	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase = HistoricoTerminal.getHistoricoTerminalService();
    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);

	private Map<String, Object> entry;

	public SacSPGestionCallableStatement(Map<String, Object> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con)
			throws SQLException {
		CallableStatement statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_INVOL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); // con idObjeto


		statement.setString(1, (String) entry.get("dmReporte"));
		statement.setString(2, (String) entry.get("dmEdadAseg"));
		statement.setString(3, (String) entry.get("dmSexoAseg"));
		statement.setString(4, (String) entry.get("dmNombreAseg"));
		statement.setString(5, (String) entry.get("dmCorreoAseg"));
		statement.setString(6, (String) entry.get("dmTelefonoAseg"));
		statement.setString(7, (String) entry.get("dmMarca"));
		statement.setString(8, (String) entry.get("dmTipoVeh"));
		statement.setString(9, (String) entry.get("dmModeloTer"));
		statement.setString(10, (String) entry.get("dmPlacas"));
		statement.setString(11, (String) entry.get("dmColor"));
		statement.setString(12, (String) entry.get("dmClaveVeh"));
		statement.setString(13, (String) entry.get("dmTipoTerc"));
		statement.setString(14, (String) entry.get("dmDescTerc"));
		statement.setString(15, (String) entry.get("dmCondTerc"));
		statement.setString(16, (String) entry.get("dmSerie"));
		statement.setString(17, (String) entry.get("dmTelefTer"));
		statement.setString(18, (String) entry.get("dmNombreTer"));
		statement.setString(19, (String) entry.get("dmCorreoTer"));
		statement.setString(20, (String) entry.get("dmClaseVeh"));
		statement.setString(21, (String) entry.get("dmUsuario"));
		statement.setString(22, (String) entry.get("dmProveedor"));
		statement.setString(23, (String) entry.get("dmCobertura"));
		statement.setString(24, (String) entry.get("dmMontoMedico"));
		statement.setString(25, (String) entry.get("dmIdObjeto"));
		statement.setString(26, (String) entry.get("dmFolioAMIS"));
		statement.setString(27, (String) entry.get("dmNombreAjustadorTercero"));
		statement.setString(28, (String) entry.get("dmPolizaTercero"));
		statement.setString(29, (String) entry.get("dmIncisoPolizaTercero"));
		statement.registerOutParameter(30, Types.VARCHAR);
		statement.registerOutParameter(31, Types.VARCHAR);

		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, (Terminal) entry.get("terminal"), (String) entry.get("dmReporte"),
                    "SAC" + "ejecucionSP", "Gestion Movil V3",
                    "Envio a SAC(Tercero): " + "[" +
            		entry.get("dmReporte") + ", " +
            		entry.get("dmEdadAseg") + ", " +
            		entry.get("dmSexoAseg") + ", " +
            		entry.get("dmNombreAseg") + ", " +
            		entry.get("dmCorreoAseg") + ", " +
            		entry.get("dmTelefonoAseg") + ", " +
            		entry.get("dmFolioAMIS") +  ", " +
            		entry.get("dmMarca") + ", " +
            		entry.get("dmTipoVeh") + ", " +
            		entry.get("dmModeloTer") + ", " +
            		entry.get("dmPlacas") + ", " +
            		entry.get("dmColor") + ", " +
            		entry.get("dmClaveVeh") + ", " +
            		entry.get("dmTipoTerc") + ", " +
            		entry.get("dmDescTerc") + ", " +
            		entry.get("dmCondTerc") + ", " +
            		entry.get("dmSerie") + ", " +
            		entry.get("dmTelefTer") + ", " +
            		entry.get("dmNombreTer") + ", " +
            		entry.get("dmCorreoTer") + ", " +
            		entry.get("dmClaseVeh") + ", " +
            		entry.get("dmUsuario") + ", " +
            		entry.get("dmProveedor") + "," +
            		entry.get("dmCobertura") + ", " +
            		entry.get("dmMontoMedico") + ", " +
					entry.get("dmIdObjeto") + ", " +
					entry.get("dmNombreAjustadorTercero") + ", "+
					entry.get("dmPolizaTercero") + ", "+
					entry.get("dmIncisoPolizaTercero") +
					"]");
		} catch ( ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
		} catch (CannotGetJdbcConnectionException | DataIntegrityViolationException |  PersistenceException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
		} catch (DataAccessException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
		}
		
		return statement;
	}

}
