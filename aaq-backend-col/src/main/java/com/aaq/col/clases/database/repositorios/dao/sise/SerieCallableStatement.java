package com.aaq.col.clases.database.repositorios.dao.sise;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;

public class SerieCallableStatement implements CallableStatementCreator {

	private Map<String, String> params;

	public SerieCallableStatement(Map<String, String> params) {
		this.params = params;
	}		
	
	public CallableStatement createCallableStatement(Connection con)
			throws SQLException {
		CallableStatement cs = con.prepareCall("call CONSERIE.EDOCTA2(?,?)");
		cs.setString(1, params.get("numSerie"));
		cs.registerOutParameter(2, Types.VARCHAR);
		return cs;
	}

}
