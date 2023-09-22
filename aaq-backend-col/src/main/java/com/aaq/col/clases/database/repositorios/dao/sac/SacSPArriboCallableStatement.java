package com.aaq.col.clases.database.repositorios.dao.sac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;

public class SacSPArriboCallableStatement implements CallableStatementCreator {

	private Map<String, Object> entry;

	public SacSPArriboCallableStatement(Map<String, Object> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con)
			throws SQLException {
		CallableStatement statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_ARRIBO(?,?,?,?,?,?,?,?,?,?,?,?,?)");
		statement.setString(1, (String) entry.get("fechaArribo"));
		statement.setString(2, (String) entry.get("horaArribo"));
		statement.setString(3, (String) entry.get("placas"));
		statement.setString(4, (String) entry.get("serie"));
		statement.setString(5, (String) entry.get("reporte"));
		statement.setString(6, (String) entry.get("quienLlego"));
		statement.setString(7, (String) entry.get("tramoCar"));
		statement.setString(8, (String) entry.get("Latitud"));
		statement.setString(9, (String) entry.get("Longitud"));
		statement.setString(10, (String) entry.get("usuario"));
		statement.setInt(11, (int) entry.get("proximidad") );
		statement.setInt(12, (int) entry.get("ubicacionCorrecta"));
		statement.registerOutParameter(13, Types.VARCHAR);
		
		return statement;
	}
	

}
