package com.aaq.col.clases.database.repositorios.dao.sise;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;

public class EdoCuentaCallableStatement implements CallableStatementCreator {

		private Map<String, String> params;

		public EdoCuentaCallableStatement(Map<String, String> params) {
			this.params = params;
		}		
		
		public CallableStatement createCallableStatement(Connection con)
				throws SQLException {
			CallableStatement cs = con.prepareCall("call EDOCTA.NVO(?,?,?,?,?,?)");
			cs.setString(1, params.get("ramo"));
			cs.setString(2, params.get("poliza"));
			cs.setString(3, params.get("inciso"));
			cs.setString(4, params.get("fecha"));
			cs.setString(5, params.get("ultEndoso"));
			cs.registerOutParameter(6, Types.VARCHAR);
			
			return cs;
		}

}
