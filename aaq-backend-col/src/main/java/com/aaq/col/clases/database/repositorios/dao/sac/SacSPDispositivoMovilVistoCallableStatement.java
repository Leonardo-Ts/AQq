package com.aaq.col.clases.database.repositorios.dao.sac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;

public class SacSPDispositivoMovilVistoCallableStatement implements CallableStatementCreator {

	private Map<String, String> entry;

	public SacSPDispositivoMovilVistoCallableStatement(Map<String, String> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con)
			throws SQLException {
		CallableStatement statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_VISTO(?,?)");
		statement.setString(1, entry.get("numeroReporte"));
		statement.registerOutParameter(2, Types.VARCHAR);
		
		return statement;
	}

}
