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

public class SacSPCuentasEspecialesCallableStatement implements CallableStatementCreator{

	private Map<String, String> entry;
	
	public SacSPCuentasEspecialesCallableStatement(Map<String, String> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con)
			throws SQLException {
		CallableStatement statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_DATADIC(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		statement.setString(1, entry.get("dmReporte"));
		statement.setString(2, entry.get("dmType"));
		statement.setString(3, entry.get("dm1"));
		statement.setString(4, entry.get("dm2"));
		statement.setString(5, entry.get("dm3"));
		statement.setString(6, entry.get("dm4"));
		statement.setString(7, entry.get("dm5"));
		statement.setString(8, entry.get("dm6"));
		statement.setString(9, entry.get("dm7"));
		statement.setString(10, entry.get("dm8"));
		statement.setString(11, entry.get("dm9"));
		statement.setString(12, entry.get("dm10"));
		statement.setString(13, entry.get("dm11"));
		statement.setString(14, entry.get("dm12"));
		statement.setString(15, entry.get("dm13"));
		statement.setString(16, entry.get("dm14"));
		statement.setString(17, entry.get("dm15"));
		statement.registerOutParameter(18, Types.VARCHAR);

		return statement;
	}				

}
