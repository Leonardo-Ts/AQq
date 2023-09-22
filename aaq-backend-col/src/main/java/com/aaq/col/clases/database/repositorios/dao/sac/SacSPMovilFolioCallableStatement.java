package com.aaq.col.clases.database.repositorios.dao.sac;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.RollbackException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.CallableStatementCreator;

import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;

public class SacSPMovilFolioCallableStatement implements CallableStatementCreator {

	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase = HistoricoTerminal.getHistoricoTerminalService();
    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
    
	private Map<String, Object> entry;

	public SacSPMovilFolioCallableStatement(Map<String, Object> entry) {
		this.entry = entry;
	}
	
	@Override
	public CallableStatement createCallableStatement(Connection con) throws SQLException {
		
		CallableStatement statement = con.prepareCall("call SP_DISPOSITIVO_MOVIL_FOLIO(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

		statement.setString(1, (String) entry.get("dmProveedor"));
		statement.setString(2, (String) entry.get("dmTipoProveedor"));
		statement.setString(3, (String) entry.get("dmRamo"));
		statement.setString(4, (String) entry.get("dmEjercicio"));
		statement.setString(5, (String) entry.get("dmReporte"));
		statement.setString(6, (String) entry.get("dmTencionA"));
		statement.setString(7, (String) entry.get("dmUsuario"));
		statement.setString(8, (String) entry.get("dmVFolio"));
		statement.setString(9, (String) entry.get("dmCodigoME"));
		statement.setString(10, (String) entry.get("dmCobertura"));
		statement.setString(11, (String) entry.get("dmMontoMedico"));
		statement.setString(12, (String) entry.get("dmPolizaTerceroQualitas"));
		statement.setString(13, (String) entry.get("dmIncisoTerceroQualitas"));
		statement.setString(14, (String) entry.get("dmEndosoTerceroQualitas"));
		statement.setString(15, (String) entry.get("dmCarrilExpress"));
		statement.setString(16, (String) entry.get("dmIdObjeto"));
		statement.setString(17, (String) entry.get("dmDanioMenor"));
		statement.setString(18, (String) entry.get("dmPtEvidente"));
		statement.setString(19, (String) entry.get("dmAbandonoEvidente"));

		statement.registerOutParameter(20, Types.VARCHAR);
		statement.registerOutParameter(21, Types.VARCHAR);

		
		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, (Terminal) entry.get("terminal"), (String) entry.get("dmReporte"),
                    "SAC(MovilFolio)", "Solicitar Servicios Diversos",
                    "Envio a SAC(Folio): " + "[" +
            		entry.get("dmProveedor") + ", " +
            		entry.get("dmTipoProveedor") + ", " +
            		entry.get("dmRamo") + ", " +
            		entry.get("dmEjercicio") + ", " +
            		entry.get("dmReporte") + ", " +
            		entry.get("dmTencionA") + ", " +
            		entry.get("dmUsuario") + ", " +
            		entry.get("dmVFolio") + ", " +
            		entry.get("dmCodigoME") + ", " +
            		entry.get("dmCobertura") + ", " +
            		entry.get("dmMontoMedico") 
            		+ ", " +
            		entry.get("dmPolizaTerceroQualitas") + ", " +
            		entry.get("dmIncisoTerceroQualitas") + ", " +
            		entry.get("dmEndosoTerceroQualitas") + ", "+
            		entry.get("dmCarrilExpress")   + ", "+
            		entry.get("dmIdObjeto")  + ", "+
            		entry.get("dmDanioMenor") + ", "+
            		entry.get("dmPtEvidente") + ", "+
            		entry.get("dmAbandonoEvidente")
            		+ "]");

		} catch (ClassCastException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
		}catch (CannotGetJdbcConnectionException | DataIntegrityViolationException | RollbackException | NoResultException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "SACejecucionSP => ejecutarFuncionHistoricoTerminalNuevo");
		}		
		return statement;
	}

}
