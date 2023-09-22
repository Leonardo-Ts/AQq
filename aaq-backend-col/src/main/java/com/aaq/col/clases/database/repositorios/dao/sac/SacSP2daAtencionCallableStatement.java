package com.aaq.col.clases.database.repositorios.dao.sac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;

public class SacSP2daAtencionCallableStatement implements CallableStatementCreator{

		private Map<String, String> entry;
		
		public SacSP2daAtencionCallableStatement(Map<String, String> entry) {
			this.entry = entry;
		}
		
		@Override
		public CallableStatement createCallableStatement(Connection con)
				throws SQLException {
			CallableStatement statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_ALTA2DA(?,?,?,?,?,"
																							+ "?,?,?,?,?)");
			statement.setString(1, entry.get("dmReporte"));
			statement.setString(2, entry.get("dmAjustador"));
			statement.setString(3, entry.get("dmUsuarioAlta"));
			statement.setString(4, entry.get("dmObservacion"));
			statement.setString(5, entry.get("dmEdoPob"));
			statement.setString(6, entry.get("dmColonia"));
			statement.setString(7, entry.get("dmCalle"));
			statement.setString(8, entry.get("dmEntre"));
			statement.setString(9, entry.get("dmRefer"));
			
			statement.registerOutParameter(10, Types.VARCHAR);
			return statement;
		}
}
