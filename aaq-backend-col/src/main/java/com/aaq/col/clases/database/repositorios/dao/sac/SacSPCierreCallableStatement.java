/**
 * 
 */
package com.aaq.col.clases.database.repositorios.dao.sac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;

public class SacSPCierreCallableStatement implements CallableStatementCreator{

	private Map<String, String> entry;
	
	public SacSPCierreCallableStatement(Map<String, String> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con)
			throws SQLException {
		CallableStatement statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_ESTIMA(?,?,?,?,?,?)");
//		CallableStatement statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_ESTIMA(?,?,?,?,?)");

		statement.setString(1, entry.get("dmReporte"));
		statement.setString(2, entry.get("dmSiniestro"));
		statement.setString(3, entry.get("dmCobertura"));
		statement.setString(4, entry.get("dmMonto"));
//		statement.registerOutParameter(5, Types.VARCHAR);
		statement.setString(5, entry.get("dmCoberturaFlexible"));
		statement.registerOutParameter(6, Types.VARCHAR);
		return statement;
	}


}
