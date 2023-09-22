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

public class SacSPFolioHospitalAmbulanciaCallableStatement implements CallableStatementCreator {

	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase = HistoricoTerminal.getHistoricoTerminalService();
    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
    
	private Map<String, Object> entry;

	public SacSPFolioHospitalAmbulanciaCallableStatement(Map<String, Object> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con)
			throws SQLException {
		CallableStatement statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_INVOL(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); // 31

		statement.setString(1, (String) entry.get("reporteSac"));
		statement.setString(2, (String) entry.get("edadAseg"));
		statement.setString(3, (String) entry.get("sexoAseg"));
		statement.setString(4, (String) entry.get("nombreAseg"));
		statement.setString(5, (String) entry.get("correoAseg"));
		statement.setString(6, (String) entry.get("telefonoAseg"));
		statement.setString(7, null);
		statement.setString(8, null);
		statement.setString(9, (String) entry.get("edadTercero"));
		statement.setString(10, null);
		statement.setString(11, null);
		statement.setString(12, (String) entry.get("numeroTercero"));
		statement.setString(13, (String) entry.get("tipoTercero"));
		statement.setString(14, (String) entry.get("sexoTercero"));
		statement.setString(15, (String) entry.get("lesionadoTercero"));
		statement.setString(16, null);
		statement.setString(17, (String) entry.get("telefonoTercero"));
		statement.setString(18, (String) entry.get("atencionA"));
		statement.setString(19, (String) entry.get("correoTercero"));
		statement.setString(20, null);
		statement.setString(21, (String) entry.get("codigoAjustador"));
		statement.setString(22, (String) entry.get("claveProveedor"));
		statement.setString(23, (String) entry.get("cobertura"));
		statement.setString(24, (String) entry.get("montoMedico"));
		statement.setString(25, (String) entry.get("idObjeto"));
		statement.setString(26, (String) entry.get("dmFolioAMIS"));
		statement.setString(27, (String) entry.get("dmNombreAjustadorTercero"));
		statement.setString(28, (String) entry.get("dmPolizaTercero"));
		statement.setString(29, (String) entry.get("dmIncisoPolizaTercero"));
		statement.registerOutParameter(30, Types.VARCHAR);
		statement.registerOutParameter(31, Types.VARCHAR);
		
		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, (Terminal) entry.get("terminal"), (String) entry.get("dmReporte"),
                    "SAC(Folio_Hospital_Ambulancia)", "Solicitar Servicios Diversos",
                    "Envio a SAC(FolioHospital): " + "[" +
                    entry.get("reporteSac") + ", " +
					entry.get("edadAseg") + ", " +
					entry.get("sexoAseg") + ", " +
					entry.get("nombreAseg") + ", " +
					entry.get("correoAseg") + ", " +
					entry.get("telefonoAseg") + ", " +
					null + ", " +
					null + ", " +
					entry.get("edadTercero") + ", " +
					null + ", " +
					null + ", " +
					entry.get("numeroTercero") + ", " +
					entry.get("tipoTercero") + ", " +
					entry.get("sexoTercero") + ", " +
					entry.get("lesionadoTercero") + ", " +
					null + ", " +
					entry.get("telefonoTercero") + ", " +
					entry.get("atencionA") + ", " +
					entry.get("correoTercero") + ", " +
					null + ", " +
					entry.get("codigoAjustador") + ", " +
					entry.get("claveProveedor") + ", " +
					entry.get("cobertura") + ", " +
					entry.get("montoMedico") + ", " +
					entry.get("idObjeto") + ", "+
					entry.get("dmFolioAMIS") +  ", " +
					entry.get("dmNombreAjustadorTercero") + ", "+
					entry.get("dmPolizaTercero") + ", "+
					entry.get("dmIncisoPolizaTercero") +
					"]");
		} catch (Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
		}

		return statement;
	}

}
