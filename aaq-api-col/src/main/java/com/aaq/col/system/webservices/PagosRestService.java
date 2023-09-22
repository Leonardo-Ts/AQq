package com.aaq.col.system.webservices;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;

import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Transaccion;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TransaccionServiceInterfase;
import com.aaq.col.clases.path.ProveedorApplicationContext;
import com.aaq.col.clases.pojo.aaq.InformacionPago;
import com.aaq.col.clases.pojo.pagos.CargoAbierto;
import com.aaq.col.clases.pojo.pagos.ConsultarDetalles;
import com.aaq.col.clases.pojo.pagos.LinkPago;
import com.aaq.col.clases.pojo.pagos.MovilDetallesPago;
import com.aaq.col.clases.pojo.pagos.PagoReferenciado;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.EnviarUnicoCorreo;
import com.aaq.col.clases.util.GenericoEnviarSMS;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.util.LinkDePago;
import com.aaq.col.clases.util.avisos.CuerpoMail;
import com.aaq.col.clases.webservices.formatos.FormatoOdaAuto;
import com.aaq.col.clases.webservices.movil.GETMovilResultadoOperacion;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;

public class PagosRestService implements PagosRestServiceInterface {
	
	private final String fuenteWS = "SIICA Servicios REST -> ";
	
	Log4JLogger loggerEspecial = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.especial");
	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
	            JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
	 
	@Autowired
	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase;
	  
    @Autowired
    private TerminalServiceInterfase terminalDao;
    
    @Autowired
    private TransaccionServiceInterfase transaccionService;

	@Override
	public MovilResultadoOperacion obtenerLinkDePago(LinkPago entrada) {
			// Validaciones
			if (StringUtils.isBlank(entrada.getUsuario())) {
				return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'usuario'");
			}
			if (StringUtils.isBlank(entrada.getPwd())) {
				return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'pwd'");
			}
			if (StringUtils.isBlank(entrada.getReporte())) {
				return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'reporte'");
			}
			if (StringUtils.isBlank(entrada.getMonto())) {
				return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'monto'");
			}
			if (StringUtils.isBlank(entrada.getTipoDeCobro())) {
				return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'tipoDeCobro'");
			}
			if (StringUtils.isBlank(entrada.getCoberturaAfectada())) {
				return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'coberturaAfectada'");
			}
			
			 if (!StringUtils.equalsIgnoreCase(entrada.getTipoDeCobro(), "P.D.")
		                && !StringUtils.equalsIgnoreCase(entrada.getTipoDeCobro(), "P.R.")) {
		            return new MovilResultadoOperacion(false,
		                    "ERROR: El tipo de cobro no es correcto. Los valores permitidos son  'P.D.' o 'P.R.'");
		       }
			 
			 if (StringUtils.isNotBlank(entrada.getTelefono()) && StringUtils.isNotBlank(entrada.getCorreo())) {
		            return new MovilResultadoOperacion(false,
		                    "ERROR: En necesario enviar número telefónico o correo electrónico");
		       }
			 
			 if (StringUtils.isNotBlank(entrada.getCorreo())) {
				 if ((StringUtils.length(entrada.getCorreo()) > 0) && !EmailValidator.getInstance().isValid(entrada.getCorreo())) {
			        return new MovilResultadoOperacion(false, "ERROR: El formato correo electrónico es incorrecto.");
					}
			}
			 
			if (StringUtils.isNotBlank(entrada.getTelefono())) {
				if (StringUtils.length(entrada.getTelefono()) != 10 ) {
					return new MovilResultadoOperacion(false, "ERROR: El número telefónico es incorrecto.");
				}
			}
			
			if (StringUtils.isBlank(entrada.getClaveCobertura())) {
				return new MovilResultadoOperacion(false, "ERROR: La clave de cobertura debe ser: '01', '04','06' o '19', etc.");
			}
			
			if (StringUtils.equalsIgnoreCase(entrada.getTipoDeCobro(), "P.D.")) {
				if ( !StringUtils.equalsIgnoreCase(entrada.getClaveCobertura(), "19")) {
					return new MovilResultadoOperacion(false, "ERROR: La clave de cobertura no corresponde al tipo de Cobro.");
				}
			}
			
			if (StringUtils.equalsIgnoreCase(entrada.getTipoDeCobro(), "P.R.")) {
				if ( !StringUtils.equalsIgnoreCase(entrada.getClaveCobertura(), "01") && !StringUtils.equalsIgnoreCase(entrada.getClaveCobertura(), "04")
						&& !StringUtils.equalsIgnoreCase(entrada.getClaveCobertura(), "06")) {
					return new MovilResultadoOperacion(false, "ERROR: La clave de cobertura no corresponde al tipo de Cobro.");
				}
			}
			
			if (StringUtils.isBlank(entrada.getMoneda())) {
				return new MovilResultadoOperacion(false, "ERROR: moneda es un campo obligatorio");
			}
			
			if (!StringUtils.equalsIgnoreCase(entrada.getMoneda(), "MXN")
	                && !StringUtils.equalsIgnoreCase(entrada.getMoneda(), "DLS")) {
	            return new MovilResultadoOperacion(false,
	                    "ERROR: moneda es incorrecto. Los valores permitidos son 'MXN' o 'DLS'. (Nacional => MXN, Dólares => DLS)");
			}
		 
			
			Terminal term= null;
			  try {
		            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(entrada.getUsuario(), entrada.getPwd());
		        } catch (final RollbackException | DataIntegrityViolationException ex) {
		            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                    "obtenerLinkDePago => objetoTerminalParaProveedorYPasswd");
		        } catch (final PersistenceException | DataAccessException ex) {
		            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                    "obtenerLinkDePago => objetoTerminalParaProveedorYPasswd");
		        }

		        if (term == null) {
		            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o contraseña son invalidos");
		        }
		        
		        //Validar que no se haya enviado el link de pago
		        try {
		        Transaccion respuesta = this.transaccionService.objetoTransaccionReporteCobro(entrada.getReporte(), entrada.getTipoDeCobro(), JMConstantes.FUENTE_LINK_PAGO);
			        if (respuesta != null) {
						if (respuesta.getTransaccionAprobada()) {
							 return new MovilResultadoOperacion(false, "ERROR: El reporte "+entrada.getReporte()+" ya cuenta con un link de pago.");
						}
					}
		        } catch (DataAccessException | NoResultException | IllegalStateException | IndexOutOfBoundsException | RollbackException e) {
		        	this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
		                    "obtenerLinkDePago => objetoTransaccionParaNumeroReporte");
				} catch (PersistenceException e) {
		        	this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
		                    "obtenerLinkDePago => objetoTransaccionParaNumeroReporte");
				}
		        
		        try {
		        	Gson json = new Gson();
		        	String peticion = json.toJson(entrada);
	    			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, entrada.getReporte(),
	    		               fuenteWS + "obtenerLinkDePago", "Invocar Link De Pago V3", "Entrada a obtenerLinkDePago: "+peticion);
	        	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
	        		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                         "obtenerLinkDePago => ejecutarFuncionHistoricoTerminalNuevo");
				} catch (PersistenceException | DataAccessException ex) {
	        		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                         "obtenerLinkDePago => ejecutarFuncionHistoricoTerminalNuevo");
				}
		        
		        CargoAbierto cargo = new CargoAbierto();
		        cargo.setReporte(entrada.getReporte());
		        cargo.setMonto(entrada.getMonto());
		        //Deducible
		        if (StringUtils.contains(entrada.getTipoDeCobro(), "P.D.")) {
		        	cargo.setDeducible("1");
				} 
		        // Recupero
		        else  if (StringUtils.contains(entrada.getTipoDeCobro(), "P.R.")) {
					cargo.setDeducible("0");
				}
		        cargo.setCorreo(entrada.getCorreo());
		        cargo.setTelefono(entrada.getTelefono());
		        cargo.setSiniestro(entrada.getSiniestro());
		        cargo.setCobertura(entrada.getClaveCobertura());
		        cargo.setMoneda(entrada.getMoneda());
		        cargo.setClaveProveedor(entrada.getUsuario());
		        cargo.setRazonSocial(entrada.getRazonSocial());
		        cargo.setCalle(entrada.getCalle());
		        cargo.setNoExt(entrada.getNoExt());
		        cargo.setNoInt(entrada.getNoInt());
		        cargo.setColonia(entrada.getColonia());
		        cargo.setDelPob(entrada.getDelPob());
		        cargo.setCp(entrada.getCp());
		        cargo.setEstado(entrada.getEstado());
		        cargo.setDomicilioRef(entrada.getDomicilioRef());
		        cargo.setRfc(entrada.getRfc());
		        cargo.setTipoDeCobro(entrada.getTipoDeCobro());
		        cargo.setCoberturaAfectada(entrada.getCoberturaAfectada());
		        cargo.setFuente("Ajustador Móvil");
		        cargo.setAbogado(entrada.isAbogado() ? 1 : 0);
		        cargo.setTerminal(term);
		        cargo.setRegFiscal(entrada.isRegFiscal());
	        	try {
	        	LinkDePago link = new LinkDePago();
	        	List<Object> respuesta = link.genLinkCaja(cargo );
	        	if (respuesta != null) {
	        		boolean envio = (boolean) respuesta.get(0);
		      		if (envio) {
		      		   return new MovilResultadoOperacion(true, (String) respuesta.get(1));
		      		} else {
		      			return new MovilResultadoOperacion(false, (String) respuesta.get(1));
		      		}
				} else {
					return new MovilResultadoOperacion(false, "No se puedo invocar el servicio para link de pago.");
				}
	        }catch (Exception ex) {
	       		 	this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                        "obtenerLinkDePago => ejecutarFuncionHistoricoTerminalNuevo");
	       		 return new MovilResultadoOperacion(false, "Ocurrio un error. "+ex);
				}
		}

	@Override
	public MovilResultadoOperacion pagoReferenciado(PagoReferenciado entrada) {
		// Validaciones
		if (StringUtils.isBlank(entrada.getUsuario())) {
			return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'usuario'");
		}
		if (StringUtils.isBlank(entrada.getPwd())) {
			return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'pwd'");
		}
		if (StringUtils.isBlank(entrada.getNumReporte())) {
			return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'numReporte'");
		}
		if (StringUtils.isBlank(entrada.getMonto())) {
			return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'monto'");
		}
		if (StringUtils.isBlank(entrada.getTipoDeCobro())) {
			return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'tipoDeCobro'");
		}
		if (StringUtils.isBlank(entrada.getCoberturaAfectada())) {
			return new MovilResultadoOperacion(false, "ERROR: Es obligatorio el campo 'coberturaAfectada'");
		}
		
		 if (!StringUtils.equalsIgnoreCase(entrada.getTipoDeCobro(), "P.P.")
	                && !StringUtils.equalsIgnoreCase(entrada.getTipoDeCobro(), "P.D.")
	                && !StringUtils.equalsIgnoreCase(entrada.getTipoDeCobro(), "P.R.")) {
	            return new MovilResultadoOperacion(false,
	                    "ERROR: El tipo de cobro no es correcto. Los valores permitidos son 'P.P.', 'P.D.', 'P.R.'");
	       }
		 
		 if (StringUtils.isBlank(entrada.getCelular()) && StringUtils.isBlank(entrada.getCorreoElectronico())) {
	            return new MovilResultadoOperacion(false,
	                    "ERROR: En necesario enviar número telefónico y/o correo electrónico");
	       }
		 
		 if (StringUtils.isNotBlank(entrada.getCorreoElectronico())) {
			 if ((StringUtils.length(entrada.getCorreoElectronico()) > 0) && !EmailValidator.getInstance().isValid(entrada.getCorreoElectronico())) {
		        return new MovilResultadoOperacion(false, "ERROR: El formato correo electrónico es incorrecto.");
				}
		}
		 
		if (StringUtils.isNotBlank(entrada.getCelular())) {
			if (StringUtils.length(entrada.getCelular()) != 10 ) {
				return new MovilResultadoOperacion(false, "ERROR: El número telefónico es incorrecto.");
			}
		}
		
		if (StringUtils.isBlank(entrada.getReferencia())) {
			return new MovilResultadoOperacion(false, "ERROR: La referencia es un campo obligatorio");
		}
		
		if ( !entrada.isConvenioTodos()) {
			if (StringUtils.isBlank(entrada.getNombreBanco())) {
				return new MovilResultadoOperacion(false, "ERROR: Es necesario espeficiar el nombre del Banco.");
			}
			
			if (!StringUtils.equalsIgnoreCase(entrada.getNombreBanco(), "BBVA Bancomer.")
	                && !StringUtils.equalsIgnoreCase(entrada.getNombreBanco(), "Santander")
	                && !StringUtils.equalsIgnoreCase(entrada.getNombreBanco(), "HSBC")) {
	            return new MovilResultadoOperacion(false,
	                    "ERROR: El banco ingresado no cuenta con convenio, permitidos 'BBVA Bancomer', 'Santander', 'HSBC'");
	       }
		}
		
		Terminal term= null;
		  try {
	            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(entrada.getUsuario(), entrada.getPwd());
	        } catch (final RollbackException | DataIntegrityViolationException ex) {
	            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "pagoReferenciado => objetoTerminalParaProveedorYPasswd");
	        } catch (final PersistenceException | DataAccessException ex) {
	            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "pagoReferenciado => objetoTerminalParaProveedorYPasswd");
	        }

	        if (term == null) {
	            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o contraseña son invalidos");
	        }
	        
	        try {
	        	Gson json = new Gson();
	        	String peticion = json.toJson(entrada);
    			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, entrada.getNumReporte(),
    		               fuenteWS + "pagoReferenciado", "Pago Referenciado V3", "Datos de entrada: "+peticion);
        	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
        		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                         "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
			} catch (PersistenceException | DataAccessException ex) {
        		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                         "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
			}
	       boolean envioSMS = false;
	       boolean respuestaEmail = false;
	        //Enviar via SMS y/o correo la referencia
	        if (StringUtils.isNotBlank(entrada.getCelular())) {
	        	if (entrada.isConvenioTodos()) {
	        		GenericoEnviarSMS enviarSMS = new GenericoEnviarSMS();
		        	 envioSMS = enviarSMS.enviarSMS(entrada.getCelular(), "Numero de Referencia: "+entrada.getReferencia()+", Banco Santander, Convenio: 5241, Cuenta: 65504441542 - Banco HSBC, Convenio: 8808, Cuenta: 4056388515- Banco BBVA Bancomer, Convenio: 1267620. "
		        	 		+ "Utilice esta referencia solo para el pago de su Deducible de RC o Recupero. NO SE ACEPTAN PAGOS CON CHEQUES.");
				
				} else {
	        	try {
	        		if (entrada.getNombreBanco().contains("Santander")) {
	        			 GenericoEnviarSMS enviarSMS = new GenericoEnviarSMS();
			        	 envioSMS = enviarSMS.enviarSMS(entrada.getCelular(), "Numero de Referencia: "+entrada.getReferencia()+", Banco: Santander, Convenio: 5241, Cuenta: 65504441542. "
			        	 		+ "Utilice esta referencia solo para el pago de su Deducible de RC o Recupero. NO SE ACEPTAN PAGOS CON CHEQUES.");
					}
	        		if (entrada.getNombreBanco().contains("HSBC")) {
	        			 GenericoEnviarSMS enviarSMS = new GenericoEnviarSMS();
			        	 envioSMS = enviarSMS.enviarSMS(entrada.getCelular(), "Numero de Referencia: "+entrada.getReferencia()+", Banco: HSBC, Convenio: 8808, Cuenta: 4056388515. "
			        	 		+ "Utilice esta referencia solo para el pago de su Deducible de RC o Recupero. NO SE ACEPTAN PAGOS CON CHEQUES.");
					}
	        		if (entrada.getNombreBanco().contains("BBVA")) {
	        			 GenericoEnviarSMS enviarSMS = new GenericoEnviarSMS();
			        	 envioSMS = enviarSMS.enviarSMS(entrada.getCelular(), "Numero de Referencia: "+entrada.getReferencia()+", Banco: BBVA, Convenio CIE: 1267620. "
			        	 		+ "Utilice esta referencia solo para el pago de su Deducible de RC o Recupero. NO SE ACEPTAN PAGOS CON CHEQUES.");
					}
	        	} catch ( ClassCastException | IndexOutOfBoundsException | PersistenceException | IllegalArgumentException e) {
				}
				}
			}
	        
	        //Obtener path
	        String  ruta = null;
	        try {	
					ruta = ProveedorApplicationContext.getApplicationContext().getResource("/correo").getFile().getPath() + "/";
			} catch (FileNotFoundException  e) {
			} catch (IOException e) {
			}
	        
	        if (StringUtils.isNotBlank(entrada.getCorreoElectronico())) {
	        	CuerpoMail bodyMail = new CuerpoMail();
	        	String cuerpoCorreo = bodyMail.body(entrada.getReferencia(), entrada.getNombreBanco(), entrada.getMonto(), entrada.getNumReporte(), entrada.isConvenioTodos());
				try {
					EnviarUnicoCorreo correoNotifRecon = new EnviarUnicoCorreo(
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
							Configuracion.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
							Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
							Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
							true);
					try {
					 respuestaEmail = correoNotifRecon.enviarEmailAsync(entrada.getCorreoElectronico(), "Confirmación Número de Referencia Pago "+entrada.getNumReporte(),  cuerpoCorreo, entrada.getNumReporte(), ruta);
					}catch (Exception e) {
					}
				} catch ( ClassCastException  | RollbackException | IndexOutOfBoundsException | IllegalArgumentException e) {
				}
			}
	        	 
	        
        	try {
        		//Guardar en tabla Transaccion
    			try {
    				final Transaccion transaccion = new Transaccion();
    				transaccion.setClaveOficina(null);
    				transaccion.setChecksum("N/A");
    				transaccion.setCoberturaAfectada(entrada.getCoberturaAfectada());
    				transaccion.setDatosAdicionales("N/A");
    				transaccion.setFecha(new Date());
    				transaccion.setFuente("Pago Referenciado");
    				transaccion.setMonto(entrada.getMonto());
    				transaccion.setNumeroAutorizacion("N/A");
    				transaccion.setNumeroOperacion("N/A");
    				transaccion.setNumeroReferencia(entrada.getNumReporte());
    				transaccion.setNumeroReporte(entrada.getNumReporte());
    				transaccion.setNumeroSiniestro(null);
    				transaccion.setNumeroPoliza(null);
    				transaccion.setTerminal(term);
    				transaccion.setTipoDeCobro(entrada.getTipoDeCobro());
    				//Cambiar para saber si fue enviado o no
    				if (envioSMS || respuestaEmail) {
        				transaccion.setTransaccionAprobada(true);
					} else {
	    				transaccion.setTransaccionAprobada(false);
					}
    				transaccion.setUsuario(null);
    				//Guardar Clave Abogado
    				transaccion.setClaveAbogado(null);
    				
    				if (envioSMS || respuestaEmail) {
    					transaccion.setRespuestaAmigable("Enviado");
					} else {
						transaccion.setRespuestaAmigable("No Enviado");
					}
    				
    				transaccion.setVoucherCliente("N/A");
    	
    				transaccion.setXmlRespuesta("N/A");
    				transaccion.setXmlTarjeta("N/A");
    				transaccion.setMesesSinIntereses(null);
    				transaccion.guardarObjeto();
    			} catch (IndexOutOfBoundsException | ClassCastException | RollbackException e) {
    				this.loggerEspecial.error("Ocurrio un error: "+e);
    			} catch (DataAccessException | PersistenceException e) {
    				this.loggerEspecial.error("Ocurrio un error: "+e);
    			}
    			
    		} catch (Exception e) {
    			this.loggerEspecial.error("Ocurrio un error: "+e);
    		}
        		if (envioSMS || respuestaEmail) {
        			return new MovilResultadoOperacion(true, "Referencia Enviada");
				} else {
					return new MovilResultadoOperacion(false, "Referencia No Enviada");
				}
        	
	}

	@Override
	public MovilDetallesPago detallesPago(ConsultarDetalles entrada) {
		if (StringUtils.isBlank(entrada.getUsuario())) {
			return new MovilDetallesPago(false, "Es necesario especificar el campo 'usuario'", null);
		}
		if (StringUtils.isBlank(entrada.getPwd())) {
			return new MovilDetallesPago(false, "Es necesario especificar el campo 'pwd'", null);
		}
		if (StringUtils.isBlank(entrada.getReferencia())) {
			return new MovilDetallesPago(false, "Es necesario especificar el campo 'referencia'", null);
		}
		
		Terminal term= null;
		  try {
	            term = this.terminalDao.objetoTerminalParaProveedorYPasswd(entrada.getUsuario(), entrada.getPwd());
	        } catch (final RollbackException | DataIntegrityViolationException ex) {
	            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "detallesPago => objetoTerminalParaProveedorYPasswd");
	        } catch (final PersistenceException | DataAccessException ex) {
	            this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                    "detallesPago => objetoTerminalParaProveedorYPasswd");
	        }

	        if (term == null) {
	            return new MovilDetallesPago(false, "ERROR: El nombre de usuario o contraseña son invalidos", null);
	        }
	        try {
        		LinkDePago link = new LinkDePago();
        		InformacionPago respuesta = link.detallesPagoLP(term, entrada.getReferencia(), "Ajustador Móvil");
        		if (respuesta != null) {
        			if (StringUtils.isNotBlank(respuesta.getStatus())) {
						return new MovilDetallesPago(false, respuesta.getStatus(), null);
					} else {
						return new MovilDetallesPago(true, null, respuesta.getDetalles());
					}
				} else {
					 return new MovilDetallesPago(false, "No se puedo invocar el servicio consultar detalles de pago", null);
				}
        	}catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | RollbackException ex) {
       		 	this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                        "detallesPago => ejecutarFuncionHistoricoTerminalNuevo");
       		 return new MovilDetallesPago(false, "Ocurrio un error. "+ex, null);
			} catch (DataAccessException | PersistenceException e) {
				this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
                        "detallesPago => ejecutarFuncionHistoricoTerminalNuevo");
       		 return new MovilDetallesPago(false, "Ocurrio un error. "+e, null);
			}
	}
		
		
	//public GETMovilResultadoOperacion InsertarFOAD(final FormatoOdaAuto formato) {
	public String InsertarFOAD(final FormatoOdaAuto formato) {
		System.out.println("Formato: InsertarFOAD");
		return "formato::";
	}
}
