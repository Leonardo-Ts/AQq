package com.aaq.col.clases.database.repositorios.impl;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.sisesac.ReconocimientoSISE;
import com.aaq.col.clases.database.repositorios.dao.sise.EdoCuentaCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sise.Serie6CallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sise.SerieCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sise.SiseSPImpTelAjuCallableStatement;
import com.aaq.col.clases.database.repositorios.dao.sise.SiseSRReconocimientoCallableStatement;
import com.aaq.col.clases.database.repositorios.interfase.HistoricoTerminalDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.SiseSP_DaoInterfase;
import com.aaq.col.clases.pojo.edocta.EstadoCuenta;
import com.aaq.col.clases.pojo.edocta.Serie6EdoCta;
import com.aaq.col.clases.pojo.edocta.SerieEdoCta;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.edocta.ParseoEdoCta;


@Repository("SiseSPDao")
public class SiseSP_Dao implements SiseSP_DaoInterfase {

	private final Log4JLogger loggerSISE = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.sise"); 
	
	private final String fuente = "SIICA EdoCuenta Dao -> ";
	
	@Autowired
	private JdbcTemplate siseJdbcTemplate;
	
	@Autowired
	private HistoricoTerminalDaoInterfase historicoTerminalDaoInterfase;
	
	ParseoEdoCta parseo = new ParseoEdoCta();

	@Override
	public List<String> actualizarTelefonosSise(List<Terminal> entradas) {
		
		List<String> salidas = new ArrayList<>();
		
		for (Terminal terminal : entradas) {
			
			Map<String, String> entry = new HashMap<String, String>();
			entry.put("clave", terminal.getNumeroproveedor());
			entry.put("telf", terminal.getTelefono());
			
			ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			sqlParams.add(new SqlParameter(Types.VARCHAR));
			
			sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));
			
			Map<String, Object> result = siseJdbcTemplate.call(new SiseSPImpTelAjuCallableStatement(entry), sqlParams);
			
			if (result.get("salida") == null || StringUtils.isBlank(result.get("salida").toString()) ) {
				salidas.add("Error");
				this.loggerSISE.info("Manda un error: " + result );
			}else {
				
				salidas.add(result.get("salida").toString());
			}
		}
		return salidas;
	}
	
	@Override
	public String guardarRecSise(ReconocimientoSISE sise) {
		String salida = null;
		Map<String , String> entry = new HashMap<String, String>();
			entry.put("reporte", sise.getReporte());
			entry.put("nombre", sise.getNombre());
			entry.put("apellidoPat", sise.getApellidoPat());
			entry.put("apellidoMat", sise.getApellidoMat());
			entry.put("curp", sise.getCurp());
			entry.put("tipo", sise.getTipo());
			
			ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlParameter(Types.VARCHAR));

				sqlParams.add(new SqlOutParameter("error", Types.VARCHAR));
				sqlParams.add(new SqlOutParameter("salida", Types.INTEGER));
				
		Map<String, Object> result = siseJdbcTemplate.call(new SiseSRReconocimientoCallableStatement(entry) , sqlParams);
			this.loggerSISE.info("Salida de sise: " + result.get("salida"));
		if(result.get("salida").equals("0")) {
			salida = "ERROR: "+ result.get("error").toString();
		} else {
			salida = "EXITO "+ result.get("error").toString();
		}
		return salida;
	}

	
	@Override
	public EstadoCuenta obtenerEdoCta(String poliza, String inciso, String fecha, Terminal term, String reporteSAC, String ramo) {
		EstadoCuenta edoCta = new EstadoCuenta();
		try {
			Map<String, String> params = new HashMap<String, String>();
				
			if (StringUtils.isNotBlank(ramo)) {
				params.put("ramo", ramo);
			} else { params.put("ramo", JMConstantes.RAMO_EDO_CTA);}
				params.put("poliza", poliza);
				params.put("inciso", inciso);
				params.put("fecha", fecha);
				params.put("ultEndoso", "");
				
			this.loggerSISE.info("Peticion ["+poliza+"]:"+ params.toString());
			try {
				this.historicoTerminalDaoInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSAC,fuente +
						"consutarEdoCta", "Consultar EdoCtac V3", "Peticion a SISE -> "+ params.toString());
			} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+poliza+"]==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			} catch (DataAccessException | PersistenceException   e) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+poliza+"]==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			}
			ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlOutParameter("ARR", Types.VARCHAR));
			Map<String, Object> result = new HashMap<String, Object>();
			 result = this.siseJdbcTemplate.call(new EdoCuentaCallableStatement(params), sqlParams);
			this.loggerSISE.info("RESULT: "+result);
		//Imprimir en el historico la respuesta de la rutina
		try {
			this.historicoTerminalDaoInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSAC,fuente +
					"consutarEdoCta", "Consultar EdoCtac V3", "Respuesta de SISE -> "+ result);
		} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+poliza+"]==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
		} catch (DataAccessException | PersistenceException   e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+poliza+"]==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
		}
		if (result != null) {
			if(((String)result.get("ARR")) != null){		
				this.loggerSISE.info("ARR=>"+(String)result.get("ARR"));
				edoCta =parseo.parseData((String)result.get("ARR"), poliza);
				return edoCta; 
			} else {
				return null;
			}
		}
		}catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+poliza+"]==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			try {
				this.historicoTerminalDaoInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSAC,fuente +
						"consutarEdoCta",
						"Consultar EdoCtac V3",
						"Excepcion  SISE -> "+ e.getMessage());
			} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+poliza+"]==> obtenerEdoCta(). Detalles: ==>[" + e1.getMessage() + "]", e);
			} catch (DataAccessException | PersistenceException   e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+poliza+"]==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			}
			return null;
		} catch (DataAccessException | PersistenceException | NoClassDefFoundError e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+poliza+"]==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			try {
				this.historicoTerminalDaoInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSAC,fuente +
						"consutarEdoCta","Consultar EdoCtac V3", "Excepcion  SISE -> "+ e.getMessage());
			} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+poliza+"]==> obtenerEdoCta(). Detalles: ==>[" + e1.getMessage() + "]", e);
			} catch (DataAccessException | PersistenceException   e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+poliza+"]==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			}
			return null;
		}
		return edoCta; 
	}
	
	
	@Override
	public List<SerieEdoCta> serieEdoCta(Terminal term, String serie, String reporteSAC) {
		List<SerieEdoCta> serieEdoCta = new ArrayList<SerieEdoCta>();
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("numSerie", serie);
				
			this.loggerSISE.info("Peticion numSerie ["+serie+"]:"+ params.toString());
			ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlOutParameter("ARR", Types.VARCHAR));
				
			Map<String, Object> result = new HashMap<String, Object>();
				 result = this.siseJdbcTemplate.call(new SerieCallableStatement(params), sqlParams);
			 
		//Imprimir en el historico la respuesta de la rutina
			 this.loggerSISE.info("RESULT=>"+result);
		try {
			this.historicoTerminalDaoInterfase.ejecutarFuncionHistoricoTerminal(null, term, reporteSAC,fuente +
					"serieEdoCta", "Consultar serieEdoCtac V3", "Peticion a SISE -> "+ params.toString()+", Respuesta de SISE -> "+ result);
		} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
		} catch (DataAccessException | PersistenceException   e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
		}
		if (result != null) {
			if(((String)result.get("ARR")) != null){		
				this.loggerSISE.info("ARR=>"+(String)result.get("ARR"));
				serieEdoCta =parseo.parseSerieEdoCta((String)result.get("ARR"), serie);
				return serieEdoCta; 
			} else {
				return null;
			}
		}
		}catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			try {
				this.historicoTerminalDaoInterfase.ejecutarFuncionHistoricoTerminal(null, term, reporteSAC,fuente +
						"serieEdoCta",
						"Consultar serieEdoCta V3", "Peticion a SISE -> "+ serie+
						"Excepcion  SISE -> "+ e.getMessage());
			} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e1.getMessage() + "]", e);
			} catch (DataAccessException | PersistenceException   e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			}
			return null;
		} catch (DataAccessException | PersistenceException | NoClassDefFoundError e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			try {
				this.historicoTerminalDaoInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSAC,fuente +
						"consutarEdoCta","Consultar EdoCtac V3","Peticion a SISE -> "+serie+", Excepcion  SISE -> "+ e.getMessage());
			} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e1.getMessage() + "]", e);
			} catch (DataAccessException | PersistenceException   e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			}
			return null;
		}
		return serieEdoCta; 
	}
	
	@Override
	public List<Serie6EdoCta> serie6EdoCta(Terminal term, String serie, String reporteSAC) {
		List<Serie6EdoCta> serieEdoCta = new ArrayList<Serie6EdoCta>();
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("numSerie", serie);
				
			this.loggerSISE.info("Peticion numSerie ["+serie+"]:"+ params.toString());
			ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlOutParameter("ARR", Types.VARCHAR));
				
			Map<String, Object> result = new HashMap<String, Object>();
				 result = this.siseJdbcTemplate.call(new Serie6CallableStatement(params), sqlParams);
			 
		//Imprimir en el historico la respuesta de la rutina
			 this.loggerSISE.info("RESULT=>"+result);
		try {
			this.historicoTerminalDaoInterfase.ejecutarFuncionHistoricoTerminal(null, term, reporteSAC,fuente +
					"serieEdoCta", "Consultar serieEdoCtac V3", "Peticion a SISE -> "+ params.toString()+", Respuesta de SISE -> "+ result);
		} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
		} catch (DataAccessException | PersistenceException   e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
		}
		if (result != null) {
			if(((String)result.get("ARR")) != null){		
				this.loggerSISE.info("ARR=>"+(String)result.get("ARR"));
				serieEdoCta =parseo.parseSerie6EdoCta((String)result.get("ARR"), serie);
				return serieEdoCta; 
			} else {
				return null;
			}
		}
		}catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			try {
				this.historicoTerminalDaoInterfase.ejecutarFuncionHistoricoTerminal(null, term, reporteSAC,fuente +
						"serieEdoCta",
						"Consultar serieEdoCta V3", "Peticion a SISE -> "+ serie+
						"Excepcion  SISE -> "+ e.getMessage());
			} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e1.getMessage() + "]", e);
			} catch (DataAccessException | PersistenceException   e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			}
			return null;
		} catch (DataAccessException | PersistenceException | NoClassDefFoundError e) {
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			try {
				this.historicoTerminalDaoInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSAC,fuente +
						"consutarEdoCta","Consultar EdoCtac V3","Peticion a SISE -> "+serie+", Excepcion  SISE -> "+ e.getMessage());
			} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e1.getMessage() + "]", e);
			} catch (DataAccessException | PersistenceException   e1) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ["+serie+"]==> serieEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			}
			return null;
		}
		return serieEdoCta; 
	}
	
}
