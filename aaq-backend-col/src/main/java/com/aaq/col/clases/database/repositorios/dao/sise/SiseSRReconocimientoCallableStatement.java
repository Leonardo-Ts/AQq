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


public class SiseSRReconocimientoCallableStatement implements CallableStatementCreator{
	
	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase = HistoricoTerminal.getHistoricoTerminalService();
    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);


	private Map<String, String> entry ;
	
	public  SiseSRReconocimientoCallableStatement(Map<String, String> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con) throws SQLException {
		CallableStatement statement = con.prepareCall("call WSCSIDEACT(?,?,?,?,?,?,?,?)");
//		 CALL WSCSIDEACT(REPORTE,AFEC,NOM,AP.PAT,AP.MAT,CURP,TIPO,ERROR,SALIDA)
			statement.setString(1, entry.get("reporte"));
			statement.setString(2, entry.get("nombre"));
			statement.setString(3, entry.get("apellidoPat"));
			statement.setString(4, entry.get("apellidoMat"));
			statement.setString(5, entry.get("curp"));
			statement.setString(6, entry.get("tipo"));
			statement.registerOutParameter(7, Types.VARCHAR);
			statement.registerOutParameter(8, Types.VARCHAR);
			
			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, null, null,
	                    "SISE" + "ejecucionSub Rutina => WSCSIDEACT", "Reconocimiento Movil V3",
	                    "Guardar datos de reconocimiento");
			} catch (Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SISEejecucionSRWSCSIDEACT => ejecutarFuncionHistoricoTerminalNuevo");
			}
			
		return statement;
	}
	

}
