package com.aaq.col.clases.database.repositorios.dao.sac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import org.springframework.jdbc.core.CallableStatementCreator;

public class SacSPConfirmarGruaCallableStatement implements CallableStatementCreator{
	
	private Map<String, String> entry;
	
	public SacSPConfirmarGruaCallableStatement(Map<String, String> entry ) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con) throws SQLException {
		CallableStatement statement = con.prepareCall("call SP_SIAG_GC_CONFIRMAGRUA(?,?,?,?,?,?)");
		statement.setString(1, entry.get("reporte"));
		statement.setString(2, entry.get("involucrado"));
		statement.setString(3, entry.get("proveedor"));
		statement.setString(4, entry.get("status"));
		statement.setString(5, entry.get("comentario"));
		statement.registerOutParameter(6, Types.VARCHAR);
		
		
		return statement;
	}

}
