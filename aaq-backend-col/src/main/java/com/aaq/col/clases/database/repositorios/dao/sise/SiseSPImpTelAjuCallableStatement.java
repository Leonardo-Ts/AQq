package com.aaq.col.clases.database.repositorios.dao.sise;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;

import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;


public class SiseSPImpTelAjuCallableStatement implements CallableStatementCreator {

	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase = HistoricoTerminal.getHistoricoTerminalService();
    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
    
	private Map<String, String> entry;

	public SiseSPImpTelAjuCallableStatement(Map<String, String> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con)
			throws SQLException {
		CallableStatement statement = con.prepareCall("call IMPTELAJU(?,?,?)");//Manda a pedir los datos que requiere
		statement.setString(1, entry.get("clave"));
		statement.setString(2, entry.get("telf"));
		statement.registerOutParameter(3, Types.VARCHAR);
 
		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, null, null,
                    "SISE" + "ejecucionSP IMPTELAJU", "Gestion Movil V3",
                    "Actualizar telefono de terminal en SISE");
		} catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SISEejecucionSPIMPTELAJU => ejecutarFuncionHistoricoTerminalNuevo");
		}
		
		return statement;	
		
		
	}

}
