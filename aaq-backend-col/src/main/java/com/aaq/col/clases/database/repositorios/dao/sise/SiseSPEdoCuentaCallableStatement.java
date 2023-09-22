package com.aaq.col.clases.database.repositorios.dao.sise;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;


public class SiseSPEdoCuentaCallableStatement implements CallableStatementCreator {

    
	private Map<String, String> entry;

	public SiseSPEdoCuentaCallableStatement(Map<String, String> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con)
			throws SQLException {
		CallableStatement statement = con.prepareCall("call EDOCTA(?,?,?,?,?,?)");//Manda a pedir los datos que requiere
		statement.setString(1, entry.get("ramo"));
		statement.setString(2, entry.get("poliza"));
		statement.setString(3, entry.get("inciso"));
		statement.setString(4, entry.get("fecha"));
		statement.setString(5, entry.get("ultEndoso"));
		statement.registerOutParameter(6, Types.VARCHAR);

		return statement;	
	}

}
