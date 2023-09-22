package com.aaq.col.clases.database.repositorios.dao.sac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;

import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;

public class SacSPTerminoCallableStatement implements CallableStatementCreator {

	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase = HistoricoTerminal.getHistoricoTerminalService();
    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
    
	private Map<String, Object> entry;

	public SacSPTerminoCallableStatement(Map<String, Object> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con)
			throws SQLException {
CallableStatement statement = null;
		
		statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_TERMINO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); 


		statement.setString(1, (String) entry.get("reporte"));
		statement.setString(2, (String) entry.get("fechaTermino"));
		statement.setString(3, (String) entry.get("horaTermino"));
		statement.setString(4, (String) entry.get("correo"));
		statement.setString(5, (String) entry.get("observaciones"));
		statement.setString(6, (String) entry.get("preaveriguacion"));
		statement.setString(7, (String) entry.get("averiguacion"));
		statement.setString(8, (String) entry.get("entidad"));
		statement.setString(9, (String) entry.get("municipio"));
		statement.setString(10, (String) entry.get("numeroAveriguacion"));
		statement.setString(11, (String) entry.get("localizadoEn"));
		statement.setString(12, (String) entry.get("dependencia"));
		statement.setString(13, (String) entry.get("localizado"));
		statement.setString(14, (String) entry.get("fechaRobo"));
		statement.setString(15, (String) entry.get("telRobo"));
		statement.setString(16, (String) entry.get("Latitud"));
		statement.setString(17, (String) entry.get("Longitud"));
		statement.setString(18, (String) entry.get("placasRobo"));
		statement.setString(19, (String) entry.get("serieInsp"));
		statement.setString(20, (String) entry.get("danosInsp"));
		statement.setString(21, (String) entry.get("descInsp"));
		statement.setString(22, (String) entry.get("roboColor"));
		statement.setString(23, (String) entry.get("noMotor"));
			statement.setString(24, (String) entry.get("codigoResponsabilidad"));
			statement.setString(25, (String) entry.get("estadoUnidad"));
			statement.setString(26, (String) entry.get("motivoNoInsp"));
			statement.setString(27, (String) entry.get("claveAccidente"));
			statement.setString(28, (String) entry.get("polizaTurista"));
			statement.setString(29, (String) entry.get("numeroPolizaTurista"));
			statement.setString(30, (String) entry.get("incisoPolizaTurista"));
			statement.setString(31, (String) entry.get("codigoResponsabilidadDUA"));
			statement.registerOutParameter(32, Types.VARCHAR);
			statement.registerOutParameter(33, Types.VARCHAR);
			

			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, (Terminal) entry.get("terminal"), (String) entry.get("reporte"),
	                    "SAC" + "ejecucionSP", "Gestion Movil V3",
	                    "Envio a SAC(Termino): " + "{" +
	            		entry.get("reporte") + ", " +
	            		entry.get("fechaTermino") + ", " +
	            		entry.get("horaTermino") + ", " +
	            		entry.get("correo") + ", " +
	            		entry.get("observaciones") + ", " +
	            		entry.get("preaveriguacion") + ", " +
	            		entry.get("averiguacion") + ", " +
	            		entry.get("entidad") + ", " +
	            		entry.get("municipio") + ", " +
	            		entry.get("numeroAveriguacion") + ", " +
	            		entry.get("localizadoEn") + ", " +
	            		entry.get("dependencia") + ", " +
	            		entry.get("localizado") + ", " +
	            		entry.get("fechaRobo") + ", " +
	            		entry.get("telRobo") + ", " +
	            		entry.get("Latitud") + ", " +
	            		entry.get("Longitud") + ", " +
	            		entry.get("placasRobo") + ", " +
	            		entry.get("serieInsp") + ", " +
	            		entry.get("danosInsp") + ", " +
	            		entry.get("descInsp") + ", " +
	            		entry.get("roboColor") + ", " +
	            		entry.get("noMotor") + ", " +
	            		entry.get("codigoResponsabilidad") +  ", " +
	            		entry.get("estadoUnidad") + ", " +
	            		entry.get("motivoNoInsp") + ", " +
	            		entry.get("claveAccidente") + ", " +
	            		entry.get("polizaTurista") + ", " +
	            		entry.get("numeroPolizaTurista") + ", " +
	            		entry.get("incisoPolizaTurista") + ", " + 
	            		entry.get("codigoResponsabilidadDUA") +
						"}");
			} catch (Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SACejecucionSPTermino => ejecutarFuncionHistoricoTerminalNuevo");
			}
		
		return statement;
	}
	

}
