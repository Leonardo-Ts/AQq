package com.aaq.col.system.webservices;


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

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.dao.sise.SiseSPImpTelAjuCallableStatement;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.SiseSP_ServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.pojo.edocta.EstadoCuenta;
import com.aaq.col.clases.pojo.edocta.Serie6EdoCta;
import com.aaq.col.clases.pojo.edocta.SerieEdoCta;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.util.edocta.Validadores;
import com.aaq.col.system.model.EdoCtaEntry;
import com.aaq.col.system.model.EstadoCuentaRequest;
import com.aaq.col.system.model.SerieEdoCtaRequest;
import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;

public class SIICAEdoCtaService  implements SIICAEdoCtaServiceInterfase {
	
	private final String fuenteWS = "SIICA Servicios Web -> SIICA EdoCuenta Service -> ";

	private final Log4JLogger loggerSISE = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.sise");
    private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
            JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
	
	@Autowired
	SiseSP_ServiceInterfase siseRutinaService;
	
	@Autowired
	private TerminalServiceInterfase terminalDao;
	 
	@Autowired
	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase;
	
	@Autowired
	private JdbcTemplate siseJdbcTemplate;
	
	private Validadores validate = new Validadores();

	@Override
	public EstadoCuentaRequest consultaEdoCta(EdoCtaEntry serv) {
		if (serv == null) {
			return new EstadoCuentaRequest(false, null, "ERROR: Es necesario especificar las credenciales.");
		}
		if (StringUtils.isBlank(serv.getPoliza())) {
			return new EstadoCuentaRequest(false, null, "ERROR: Es necesario especificar la poliza.");
		}
		if (StringUtils.isBlank(serv.getInciso())) {
			return new EstadoCuentaRequest(false, null, "ERROR: Es necesario especificar el inciso.");
		}
		if (StringUtils.isBlank(serv.getFecha())) {
			return new EstadoCuentaRequest(false, null, "ERROR: Es necesario especificar la fecha.");
		}
		
		//Validamos formato de fecha
		try {
			boolean esFecha = validate.esValidaFecha(serv.getFecha(), "dd/MM/yyyy");
			if (!esFecha) {
				return new EstadoCuentaRequest(false, null, "ERROR: Formato de fecha incorrecto, debe ser dd/MM/AAAA");
			}
		} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException e) {
			return new EstadoCuentaRequest(false, null, "ERROR: Ocurrio un erro al validar la fecha.");
		}
		//Aqui la va la validacion de la terminal
		  Terminal term = null;
	        try {
	            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPwd());
	        } catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
	        	this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			} catch (DataAccessException | PersistenceException   e) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			}

//	        if (term == null) {
//	            return new EstadoCuentaRequest(false, null,  "ERROR: El nombre de usuario o contraseña son invalidos");
//	        }
	        String reporteSAC = null;
	        if (term != null) {
				if (term.getReporteSac() != null ) {
					if (term.getReporteSac().getGeneralNumeroReporte() != null) {
					reporteSAC = term.getReporteSac().getGeneralNumeroReporte();
					}
				}
			}
			// Se graba lo que llega
			try {
				Gson json = new Gson();
				String entrada = json.toJson(serv);
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term,
								reporteSAC, this.fuenteWS + "consutarEdoCta","Consultar EdoCtac V3",
								"Ejecucion del Metodo Con Datos -> "+ entrada);
			} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
	        	this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			} catch (DataAccessException | PersistenceException   e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"consultarEdoCta => objetoTerminalParaProveedorYPasswd");
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			}
		//Aqui se manda al historico 
		
		try {
			EstadoCuenta edoCta = new EstadoCuenta();
				edoCta = siseRutinaService.obtenerEdoCta(serv.getPoliza(), serv.getInciso(), serv.getFecha(), term, reporteSAC, serv.getRamo());
			if (edoCta != null) {
				try {
					// Pintar en el historicos
					Gson json = new Gson();
					String salida = json.toJson(edoCta);
					
					this.historicoTerminalServiceInterfase
							.ejecutarFuncionHistoricoTerminalNuevo(null, term,
									reporteSAC, this.fuenteWS + "consutarEdoCta",
									"consultarEdoCta V3",
									"Salida del servicio -> "
											+ salida);
				} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
		        	this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
				} catch (DataAccessException | PersistenceException  e) {
					this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"consultarEdoCta => objetoTerminalParaProveedorYPasswd");
					this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
				}
				
				return new EstadoCuentaRequest(true, edoCta, "Datos de poliza: "+serv.getPoliza());
			} else {
				try {
					// Pintar en el historicos
					this.historicoTerminalServiceInterfase
							.ejecutarFuncionHistoricoTerminalNuevo(null, term, reporteSAC, this.fuenteWS + "consutarEdoCta",
									"consultarEdoCta V3",
									"Salida del servicio -> No se encontraron datos de la póliza:  "+serv.getPoliza());
				} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
		        	this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
				} catch (DataAccessException | PersistenceException   e) {
					this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"consultarEdoCta => objetoTerminalParaProveedorYPasswd");
					this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
				}
				return new EstadoCuentaRequest(false, null, "No se encontraron datos de la póliza: "+serv.getPoliza());
			}
				
		}catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
			try {
				this.historicoTerminalServiceInterfase
						.ejecutarFuncionHistoricoTerminalNuevo(null, term,reporteSAC, this.fuenteWS + "consutarEdoCta",
								"consultarEdoCta V3", "Salida del servicio -> Ocurrio un error: "+e);
			} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e1) {
	        	this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e1.getMessage() + "]", e1);
			} catch (DataAccessException | PersistenceException   e2) {
				this.utileriaExcepcion.manejarExcepcion(e2, this.getClass(),"consultarEdoCta => objetoTerminalParaProveedorYPasswd");
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e2.getMessage() + "]", e2);
			}
			return new EstadoCuentaRequest(false, null, "Ocurrio un error: "+e);
		}
	}

	public String pruebaTelefonosSISE(String claveAjustador, String telefono) {
			try {
				Map<String, String> entry = new HashMap<String, String>();
				entry.put("clave", claveAjustador);
				entry.put("telf", telefono);
				
				ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				sqlParams.add(new SqlParameter(Types.VARCHAR));
				
				sqlParams.add(new SqlOutParameter("salida", Types.VARCHAR));
				
				this.loggerSISE.info("Peticion: "+entry.toString());
				
				Map<String, Object> result = siseJdbcTemplate.call(new SiseSPImpTelAjuCallableStatement(entry), sqlParams);
				
				if (result.get("salida") == null || StringUtils.isBlank(result.get("salida").toString()) ) {
					this.loggerSISE.info("Manda un error: " + result );
				}else {
					this.loggerSISE.info("SALIDA: "+result.get("salida"));
					return result.get("salida").toString();
				}
			} catch (Exception e) {
				this.loggerSISE.error("OCURRIO UN ERROR:",e);
				return e.getMessage();
			}
			return "SIN RESPUESTA.";
	}
	
	@Override
	public SerieEdoCtaRequest serieEdoCta(String serie, String claveProveedor) {
		if (StringUtils.isBlank(serie)) {
			return new SerieEdoCtaRequest(false, "ERROR: Es necesario especificar la serie a consultar.");
		}
		if (serie.length() != 6  && serie.length() != 17) {
			return new SerieEdoCtaRequest(false, "ERROR: Longitud de serie incorrecto. Tamaño valido 6 y 17 digitos.");
		}
		//Aqui la va la validacion de la terminal
		  Terminal term = null;
		  if (StringUtils.isNotBlank(claveProveedor)) {
	        try {
	            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(claveProveedor, null);
	        } catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
	        	this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> serieEdoCtaSerie(). Detalles: ==>[" + e.getMessage() + "]", e);
			} catch (DataAccessException | PersistenceException   e) {
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> serieEdoCtaSerie(). Detalles: ==>[" + e.getMessage() + "]", e);
			}
		  }
	        String reporteSAC = null;
	        if (term != null) {
				if (term.getReporteSac() != null ) {
					if (term.getReporteSac().getGeneralNumeroReporte() != null) {
					reporteSAC = term.getReporteSac().getGeneralNumeroReporte();
					}
				}
			}
		try {
			if (serie.length() == 6) {
				  List<Serie6EdoCta> serieEdoCta6Dig = siseRutinaService.serie6EdoCta(term, serie, reporteSAC);
				  if (serieEdoCta6Dig != null && serieEdoCta6Dig.size() > 0) {
						try {
							Gson json = new Gson();
							String salida = json.toJson(serieEdoCta6Dig);
							this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminal(null, term,
											reporteSAC, this.fuenteWS + "consutarSerieEdoCta","consultarSerieEdoCta V3",
											"Consulta con serie ["+serie+" ], Salida del servicio -> "+ salida);
						} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
				        	this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
						} catch (DataAccessException | PersistenceException  e) {
							this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"consultarEdoCta => objetoTerminalParaProveedorYPasswd");
							this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
						}
						return new SerieEdoCtaRequest(true,null, serieEdoCta6Dig, "Datos de la serie: "+serie);
					} else {
						try {
						// Pintar en el historicos
						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminal(null, term, reporteSAC, this.fuenteWS + "consutarSerieEdoCta",
											"consultarSerieEdoCta V3",
											"Consulta con serie ["+serie+"], Salida del servicio -> No se encontraron datos de la serie:  "+serie);
						} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
				        	this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> serieEdoCtaSerie: ==>[" + e.getMessage() + "]", e);
				        	return new SerieEdoCtaRequest(false, null,null, "No se encontraron datos de la serie: "+serie+". "+e.getMessage());
						} catch (DataAccessException | PersistenceException   e) {
							this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"serieEdoCtaSerie => objetoTerminalParaProveedorYPasswd");
							this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> serieEdoCtaSerie(). Detalles: ==>[" + e.getMessage() + "]", e);
							return new SerieEdoCtaRequest(false, null,null, "No se encontraron datos de la serie: "+serie+". "+e.getMessage());
						}
						return new SerieEdoCtaRequest(false, null,null, "No se encontraron datos de la serie: "+serie);
					}
			} else if (serie.length() == 17) {
				List<SerieEdoCta> serieEdoCta = siseRutinaService.serieEdoCta(term, serie, reporteSAC);
				if (serieEdoCta != null && serieEdoCta.size() > 0) {
					try {
						Gson json = new Gson();
						String salida = json.toJson(serieEdoCta);
						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminal(null, term,
										reporteSAC, this.fuenteWS + "consutarSerieEdoCta","consultarSerieEdoCta V3",
										"Consulta con serie ["+serie+" ], Salida del servicio -> "+ salida);
					} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
			        	this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
					} catch (DataAccessException | PersistenceException  e) {
						this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"consultarEdoCta => objetoTerminalParaProveedorYPasswd");
						this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
					}
					
					return new SerieEdoCtaRequest(true, serieEdoCta,null, "Datos de la serie: "+serie);
				} else {
					try {
					// Pintar en el historicos
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminal(null, term, reporteSAC, this.fuenteWS + "consutarSerieEdoCta",
										"consultarSerieEdoCta V3",
										"Consulta con serie ["+serie+"], Salida del servicio -> No se encontraron datos de la serie:  "+serie);
					} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
			        	this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> serieEdoCtaSerie: ==>[" + e.getMessage() + "]", e);
			        	return new SerieEdoCtaRequest(false, null,null, "No se encontraron datos de la serie: "+serie+". "+e.getMessage());
					} catch (DataAccessException | PersistenceException   e) {
						this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"serieEdoCtaSerie => objetoTerminalParaProveedorYPasswd");
						this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> serieEdoCtaSerie(). Detalles: ==>[" + e.getMessage() + "]", e);
						return new SerieEdoCtaRequest(false, null,null, "No se encontraron datos de la serie: "+serie+". "+e.getMessage());
					}
					return new SerieEdoCtaRequest(false, null,null, "No se encontraron datos de la serie: "+serie);
				}
			}
		}catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
			try {
				this.historicoTerminalServiceInterfase
						.ejecutarFuncionHistoricoTerminalNuevo(null, term,reporteSAC, this.fuenteWS + "consutarEdoCta",
								"consultarEdoCta V3", "Consulta con serie ["+serie+"], Salida del servicio -> Ocurrio un error: "+e);
			} catch (ClassCastException | IllegalAccessError | CannotGetJdbcConnectionException| IndexOutOfBoundsException | IllegalArgumentException | RollbackException e1) {
	        	this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e1.getMessage() + "]", e1);
			} catch (DataAccessException | PersistenceException   e2) {
				this.utileriaExcepcion.manejarExcepcion(e2, this.getClass(),"consultarEdoCta => objetoTerminalParaProveedorYPasswd");
				this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e2.getMessage() + "]", e2);
			}
			this.loggerSISE.error("SiseRutinaDao EXCEPCION! ==> obtenerEdoCta(). Detalles: ==>[" + e.getMessage() + "]", e);
			return new SerieEdoCtaRequest(false, "Ocurrio un error interno: "+e);
		}
		return new SerieEdoCtaRequest(false, "Ocurrio un error interno, Favor de reportar.");
	}

}
