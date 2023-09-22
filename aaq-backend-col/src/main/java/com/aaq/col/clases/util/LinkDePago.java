package com.aaq.col.clases.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.http.client.HttpResponseException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Transaccion;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.pojo.aaq.DetallesPago;
import com.aaq.col.clases.pojo.aaq.InformacionPago;
import com.aaq.col.clases.pojo.pagos.CargoAbierto;
import com.aaq.col.clases.siica.JMConstantes;
import com.google.gson.Gson;

public class LinkDePago {
	
	Log4JLogger loggerEspecial = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.especial");
	
	
	private ConfiguracionServiceInterfase configuracionDao = Configuracion.getConfiguracionService();
	private HistoricoTerminalServiceInterfase historicoTerminalDao = HistoricoTerminal.getHistoricoTerminalService();
	
	@SuppressWarnings("unused")
	public List<Object> genLinkCaja( CargoAbierto datos) {
		List<Object> salida = new ArrayList<Object>();

		try {
			
			String token = null;
			String branch = null;
			String user = null;
			String urlCaja = null;
			try {
				token = this.configuracionDao.obtenerCadena(JMConstantes.LINK_PAGO_TOKEN);
				branch = this.configuracionDao.obtenerCadena(JMConstantes.LINK_PAGO_BRANCH);
				user = this.configuracionDao.obtenerCadena(JMConstantes.LINK_PAGO_USUARIO);
				urlCaja = this.configuracionDao.obtenerCadena(JMConstantes.LINK_PAGO_URL);
			} catch (IndexOutOfBoundsException | ClassCastException | RollbackException e) {
				this.loggerEspecial.error("Ocurrio un error en genLinkCaja: "+e);
				 salida.add(false);
				 salida.add("Ocurrio un error al obtener los datos de la base.");
				 return salida;
			} catch (PersistenceException | DataAccessException e) {
				this.loggerEspecial.error("Ocurrio un error en genLinkCaja: "+e);
				 salida.add(false);
				 salida.add("Ocurrio un error al obtener los datos de la base.");
				 return salida;
			}
			
			URL url = null;
			HttpURLConnection con = null;
			StringBuilder response = new StringBuilder();
			JSONObject cuerpo = new JSONObject();

		try {
			cuerpo.put("wptoken", token);
			if (StringUtils.isBlank(datos.getTelefono())) {
				cuerpo.put("m", "genAaqOpenLink");
			} else {
				cuerpo.put("m", "genAaqOpenSmsLink");
			}
			cuerpo.put("referencia", datos.getReporte());
			
			if (StringUtils.isBlank(datos.getTelefono())) {
				cuerpo.put("email", datos.getCorreo());
			} else {
				cuerpo.put("tel", datos.getTelefono());
			}
			
			cuerpo.put("id_branch", branch);
			cuerpo.put("monto", datos.getMonto());
			cuerpo.put("deducible", datos.getDeducible());
			cuerpo.put("user", user);
			cuerpo.put("siniestro", datos.getSiniestro());
			cuerpo.put("cobertura", datos.getCobertura());
			cuerpo.put("moneda", datos.getMoneda());
			cuerpo.put("claveProveedor", datos.getClaveProveedor());
			cuerpo.put("razonSocial", datos.getRazonSocial());
			cuerpo.put("calle", datos.getCalle());
			cuerpo.put("noExt", datos.getNoExt());
			cuerpo.put("noInt", datos.getNoInt());
			cuerpo.put("colonia", datos.getColonia());
			cuerpo.put("delPob", datos.getDelPob());
			cuerpo.put("cp", datos.getCp());
			cuerpo.put("estado", datos.getEstado());
			cuerpo.put("dom_ref", datos.getDomicilioRef());
			cuerpo.put("rfc", datos.getRfc());
		} catch (JSONException | ClassCastException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerEspecial.error("Ocurrio un error en genLinkCaja:"+e);
		}
		
			try {
				 url = new URL (urlCaja);
			} catch (MalformedURLException  e) {
				this.loggerEspecial.error("genLinkCaja EXCEPCION! ==> genLinkCaja().- ERROR AL Generar  URL - Detalles:"+e);
			} catch (@SuppressWarnings("hiding") IOException ex) {
				this.loggerEspecial.error("genLinkCaja EXCEPCION! ==> genLinkCaja().- ERROR AL Generar  URL - Detalles:"+ex);
			}
			
			// Nuevo cliente para conexion
			try {
				con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json; utf-8");
				con.setRequestProperty("Accept", "application/json");
				//Tiempo de espera
				con.setConnectTimeout(5000);
				con.setReadTimeout(5000);
				con.setDoOutput(true);
			} catch (IllegalStateException | IllegalArgumentException|  ProtocolException | ClassCastException | IndexOutOfBoundsException e) {
				this.loggerEspecial.error("ERROR en HttpURLConnection genLinkCaja => "+e);
			} catch ( SecurityException| IOException e) {
				this.loggerEspecial.error("ERROR en HttpURLConnection genLinkCaja => "+e);
			}
				              
		
		String jsonInputString = cuerpo.toString();
		this.loggerEspecial.info("peticion: "+cuerpo.toString());
		
		
		try {
			this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(datos.getUsuario(), datos.getTerminal(),
					datos.getReporte(), datos.getFuente(), "Generar -> Link de Pago", "Petición ->"
							+ cuerpo.toString());
			} catch (IndexOutOfBoundsException | ClassCastException | RollbackException e) {
				this.loggerEspecial.error(e);
			} catch (DataAccessException | PersistenceException e) {
				this.loggerEspecial.error(e);
			}
		
			try {
				try(OutputStream os = con.getOutputStream()){
					byte[] input = jsonInputString.getBytes("utf-8");
					os.write(input, 0, input.length);			
				}
//				int code = con.getResponseCode();
//				log.info(code);
			} catch (IllegalStateException| IllegalArgumentException| HttpResponseException | 
					IndexOutOfBoundsException | ClassCastException  hre) {
				this.loggerEspecial.info("ERROR en HttpResponseException de genLinkCaja => "+hre.getLocalizedMessage() );
			}catch ( IOException e) {
				this.loggerEspecial.info("ERROR genLinkCaja => "+e );
			}
			
			
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
				String responseLine = null;
					while ((responseLine = br.readLine()) != null) {
						response.append(responseLine.trim());
					}
		this.loggerEspecial.info("Respuesta => "+response.toString());
				} catch (IndexOutOfBoundsException | ClassCastException | IllegalStateException|
						IllegalArgumentException | UnsupportedEncodingException e) {
					this.loggerEspecial.error("ERROR genLinkCaja  => "+e);
				} catch (IOException e) {
					this.loggerEspecial.error("ERROR genLinkCaja => "+e);
				}
			
			try {
			this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(datos.getUsuario(), datos.getTerminal(),
					datos.getReporte(), datos.getFuente(), "Generar -> Link de Pago", "Respuesta ->"
							+ response.toString());
			} catch (IndexOutOfBoundsException | ClassCastException | RollbackException e) {
				this.loggerEspecial.error(e);
			} catch (DataAccessException | PersistenceException e) {
				this.loggerEspecial.error(e);
			}
			
			
			if (response != null) {
				try {
				if (response.toString().contains("for key 'PRIMARY'")) {
					salida.add(false);
					salida.add("ERROR: El reporte "+datos.getReporte()+" ya cuenta con un Link de Pago.");
					return salida;
				}
				}catch (ClassCastException | IndexOutOfBoundsException | IllegalArgumentException  e) {
					this.loggerEspecial.error("ERROR genLinkCaja => "+e);
				}
			}
			
		if (response != null) {
			List<Object> result =  this.parseoRespuesta(response.toString());
			boolean envio = (boolean) result.get(0);
			String mensaje = (String) result.get(1);
			
			//Guardar en tabla Transaccion
			try {
				final Transaccion transaccion = new Transaccion();
				transaccion.setClaveOficina(datos.getOficina());
				transaccion.setChecksum("N/A");
				transaccion.setCoberturaAfectada(datos.getCoberturaAfectada());
				transaccion.setDatosAdicionales("N/A");
				transaccion.setFecha(new Date());
				transaccion.setFuente(JMConstantes.FUENTE_LINK_PAGO + " - "+ datos.getFuente());
				transaccion.setMonto(datos.getMonto());
				transaccion.setNumeroAutorizacion("N/A");
				transaccion.setNumeroOperacion("N/A");
				transaccion.setNumeroReferencia(datos.getReporte());
				transaccion.setNumeroReporte(datos.getReporte());
				transaccion.setNumeroSiniestro(datos.getSiniestro());
				transaccion.setNumeroPoliza(null);
				transaccion.setTerminal(datos.getTerminal());
				transaccion.setTipoDeCobro(datos.getTipoDeCobro());
				//Cambiar para saber si fue enviado o no
				transaccion.setTransaccionAprobada(envio);
				transaccion.setUsuario(datos.getUsuario());
				//Guardar Clave Abogado
				if (datos.getAbogado() == 0) {
					transaccion.setClaveAbogado(null);
				} else {
					transaccion.setClaveAbogado(datos.getAbogado());
				}
				
				transaccion.setRespuestaAmigable(mensaje);
				transaccion.setVoucherCliente("N/A");
	
				transaccion.setXmlRespuesta("N/A");
				transaccion.setXmlTarjeta("N/A");
				transaccion.setMesesSinIntereses(null);
				transaccion.guardarObjeto();
			} catch (IndexOutOfBoundsException | ClassCastException | RollbackException | IllegalArgumentException e) {
				this.loggerEspecial.error("Ocurrio un error genLinkCaja: "+e);
			} catch ( IllegalStateException | DataAccessException | PersistenceException e) {
				this.loggerEspecial.error("Ocurrio un error genLinkCaja: "+e);
			}
			
			salida.add(envio);
			salida.add(mensaje);
			return salida;
		
		} else {
			this.loggerEspecial.error("NO se obtiene respuesta del servicio: "+response);
			salida.add(false);
			salida.add("NO se obtiene respuesta del servicio: "+response);
			try {
				final Transaccion transaccion = new Transaccion();
				transaccion.setClaveOficina(datos.getOficina());
				transaccion.setChecksum("N/A");
				transaccion.setCoberturaAfectada(datos.getCoberturaAfectada());
				transaccion.setDatosAdicionales("N/A");
				transaccion.setFecha(new Date());
				transaccion.setFuente(JMConstantes.FUENTE_LINK_PAGO + " - "+ datos.getFuente());
				transaccion.setMonto(datos.getMonto());
				transaccion.setNumeroAutorizacion("N/A");
				transaccion.setNumeroOperacion("N/A");
				transaccion.setNumeroReferencia(datos.getReporte());
				transaccion.setNumeroReporte(datos.getReporte());
				transaccion.setNumeroSiniestro(datos.getSiniestro());
				transaccion.setNumeroPoliza(null);
				transaccion.setTerminal(datos.getTerminal());
				transaccion.setTipoDeCobro(datos.getTipoDeCobro());
				//Cambiar para saber si fue enviado o no
				transaccion.setTransaccionAprobada(false);
				transaccion.setUsuario(datos.getUsuario());
				//Guardar Clave Abogado
				if (datos.getAbogado() == 0) {
					transaccion.setClaveAbogado(null);
				} else {
					transaccion.setClaveAbogado(datos.getAbogado());
				}
				transaccion.setRespuestaAmigable("No se puede establecer respuesta con el servicio");
				transaccion.setVoucherCliente("N/A");
				transaccion.setXmlRespuesta("N/A");
				transaccion.setXmlTarjeta("N/A");
				transaccion.setMesesSinIntereses(null);
				transaccion.guardarObjeto();
			} catch (IndexOutOfBoundsException | ClassCastException | RollbackException | IllegalArgumentException e) {
				this.loggerEspecial.error("Ocurrio un error genLinkCaja: "+e);
			} catch ( IllegalStateException | DataAccessException | PersistenceException e) {
				this.loggerEspecial.error("Ocurrio un error genLinkCaja: "+e);
			}
		}
		 
		
		} catch ( ClassCastException | IndexOutOfBoundsException | RollbackException |
				DataAccessException | IllegalStateException e) {
			this.loggerEspecial.error("Ocurrio un error genLinkCaja: "+e);
			salida.add(false);
			salida.add("Ocurrio un error: "+e);
		} catch (IllegalArgumentException | PersistenceException e) {
			this.loggerEspecial.error("Ocurrio un error genLinkCaja: "+e);
			salida.add(false);
			salida.add("Ocurrio un error: "+e);
		}
			
		
		return salida;
	}
	
	private List<Object> parseoRespuesta(String salida) {
		List<Object> result = new ArrayList<Object>();
		String respuesta = null;
		try {
			 JSONObject json = new JSONObject(salida);
			 try {
				 respuesta = json.getString("result");
				 result.add(true);
				 result.add(respuesta);
				 return result;
			 } catch (JSONException | PersistenceException | ClassCastException e) {
			}
			 
			 try {
				 respuesta = json.getString("error");
				 result.add(false);
			   result.add(respuesta);
				 return result;
			 } catch (JSONException | IndexOutOfBoundsException | ClassCastException e) {
				
			}
		} catch (JSONException e) {
			 result.add(false);
			 result.add("Ocurrio un error al generar respuesta: "+e);
			this.loggerEspecial.error("Ocurrio un error: "+e);
		}
		return result;
	}

	public InformacionPago detallesPagoLP(Terminal terminal, String numeroReporte, String fuente) {
		/* Este método muestra los detalles del pago del deducible con base en
		 *  la referencia de pago. */
		InformacionPago salida = new InformacionPago();
		List<DetallesPago> result = new ArrayList<>();
			String token = null;
			String urlCaja = null;
			try {
				token = this.configuracionDao.obtenerCadena(JMConstantes.LINK_PAGO_TOKEN);
				urlCaja = this.configuracionDao.obtenerCadena(JMConstantes.LINK_PAGO_URL);
			} catch (IndexOutOfBoundsException | ClassCastException | RollbackException e) {
				this.loggerEspecial.error("Ocurrio un error en detallesPagoLP: ",e);
				 return null;
			} catch (PersistenceException | DataAccessException e) {
				this.loggerEspecial.error("Ocurrio un error en detallesPagoLP: ",e);
				 return null;
			}
			
			URL url = null;
			HttpURLConnection con = null;
			StringBuilder response = new StringBuilder();
			JSONObject cuerpo = new JSONObject();

		try {
			cuerpo.put("wptoken", token);
			cuerpo.put("m","pagoAaq");
			cuerpo.put("referenciaAq",numeroReporte);
		} catch (JSONException | ClassCastException | IndexOutOfBoundsException | IllegalStateException e) {
			this.loggerEspecial.error("Ocurrio un error en detallesPagoLP:",e);
		}
			try {
				 url = new URL (urlCaja);
			} catch (MalformedURLException  e) {
				this.loggerEspecial.error("detallesPagoLP EXCEPCION! ==> detallesPagoLP().- ERROR AL Generar  URL - Detalles:",e);
			} catch (@SuppressWarnings("hiding") IOException ex) {
				this.loggerEspecial.error("detallesPagoLP EXCEPCION! ==> detallesPagoLP().- ERROR AL Generar  URL - Detalles:",ex);
			}
			
			// Nuevo cliente para conexion
			try {
				con = (HttpURLConnection)url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json; utf-8");
				con.setRequestProperty("Accept", "application/json");
				//Tiempo de espera
				con.setConnectTimeout(5000);
				con.setReadTimeout(5000);
				con.setDoOutput(true);
			} catch (IllegalStateException | IllegalArgumentException|  ProtocolException | ClassCastException | IndexOutOfBoundsException e) {
				this.loggerEspecial.error("ERROR en HttpURLConnection detallesPagoLP => ",e);
			} catch ( SecurityException| IOException e) {
				this.loggerEspecial.error("ERROR en HttpURLConnection detallesPagoLP => ",e);
			}
		String jsonInputString = cuerpo.toString();
		this.loggerEspecial.info("peticion: "+cuerpo.toString());
		try {
			this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null,terminal,
					numeroReporte, fuente, "Consultar Detalles Pago ->", "Petición ->"
							+ cuerpo.toString());
			} catch (IndexOutOfBoundsException | ClassCastException | RollbackException e) {
				this.loggerEspecial.error("ERROR: detallesPagoLP",e);
			} catch (DataAccessException | PersistenceException e) {
				this.loggerEspecial.error("ERROR: detallesPagoLP",e);
			}
		
			try {
				try(OutputStream os = con.getOutputStream()){
					byte[] input = jsonInputString.getBytes("utf-8");
					os.write(input, 0, input.length);			
				}
			} catch (IllegalStateException| IllegalArgumentException| HttpResponseException | 
					IndexOutOfBoundsException | ClassCastException  hre) {
				this.loggerEspecial.info("ERROR en HttpResponseException de detallesPagoLP => "+hre.getLocalizedMessage() );
			}catch ( IOException e) {
				this.loggerEspecial.info("ERROR detallesPagoLP => "+e );
			}
			try {
			if (con.getResponseCode() == 200) {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
					String responseLine = null;
						while ((responseLine = br.readLine()) != null) {
							response.append(responseLine.trim());
						}
			this.loggerEspecial.info("Respuesta => "+response.toString());
					} catch (IndexOutOfBoundsException | ClassCastException | IllegalStateException|
							IllegalArgumentException | UnsupportedEncodingException e) {
						this.loggerEspecial.error("ERROR detallesPagoLP  => ",e);
						salida.setStatus("Ocurrio un error: "+e);
					} catch (IOException e) {
						this.loggerEspecial.error("ERROR detallesPagoLP => ",e);
						salida.setStatus("Ocurrio un error: "+e);
					}
				
			if (response != null) {
				 result = this.parseoRespuestaDetalles(response.toString());
				 if (result != null) {
					 try {
						 Gson json = new Gson();
						 String respuesta = json.toJson(result);
						this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, terminal,
								numeroReporte, fuente, "Consultar Detalles de Pago Deducible", "Respuesta ->"
									+respuesta);
					} catch (IndexOutOfBoundsException | ClassCastException | RollbackException e) {
						this.loggerEspecial.error("ERROR: detallesPagoLP",e);
					} catch (DataAccessException | PersistenceException e) {
						this.loggerEspecial.error("ERROR: detallesPagoLP",e);
					}
					 
					 salida.setDetalles(result);
					 salida.setStatus(null);
					 return salida ;
				} else {
					String status = this.parseoRespuestaStatus(response.toString());
					salida.setDetalles(null);
					salida.setStatus(status);
					try {
						this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, terminal,
							numeroReporte, fuente, "Consultar Detalles de Pago Deducible", "Respuesta ->"
							+status);
						} catch (IndexOutOfBoundsException | ClassCastException | RollbackException e) {
							this.loggerEspecial.error("ERROR: detallesPagoLP",e);
						} catch (DataAccessException | PersistenceException e) {
							this.loggerEspecial.error("ERROR: detallesPagoLP",e);
						}
					return salida ;
				}
			} 
	 } else {
	  BufferedReader br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
		try {
	  String responseLine = null;
		while ((responseLine = br.readLine()) != null) {
				response.append(responseLine.trim());
				}
		try {
			this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, terminal,
					numeroReporte, fuente, "Consultar Detalles de Pago Deducible", "Respuesta ->"
							+ response.toString());
			} catch (IndexOutOfBoundsException | ClassCastException | RollbackException e) {
				this.loggerEspecial.error("ERROR: detallesPagoLP",e);
			} catch (DataAccessException | PersistenceException e) {
				this.loggerEspecial.error("ERROR: detallesPagoLP",e);
			}
		String status = this.parseoRespuestaStatus(response.toString());
				salida.setDetalles(null);
				salida.setStatus(status);
					return salida ;
			} catch (IllegalStateException| IllegalArgumentException| HttpResponseException | 
					IndexOutOfBoundsException | ClassCastException  hre) {
				this.loggerEspecial.info("ERROR en HttpResponseException de detallesPagoLP => "+hre.getLocalizedMessage() );
			}catch ( IOException e) {
				this.loggerEspecial.info("ERROR detallesPagoLP => "+e );
			}
	 } 
			} catch (IllegalArgumentException | IOException e) {
				this.loggerEspecial.info("ERROR detallesPagoLP => "+e );
			}
			salida.setDetalles(null);
			salida.setStatus("Error al consultar detalles del pago del deducible.");
			return salida;
	}
	
	private List<DetallesPago> parseoRespuestaDetalles(String salida) {
		List<DetallesPago> result = new ArrayList<DetallesPago>();
		try {
			JSONArray arrayJson = new JSONArray(salida);
			for (int i = 0; i < arrayJson.length(); i++) {
				JSONObject json = (JSONObject) arrayJson.get(i);
				DetallesPago detalles = new DetallesPago();
				try {
					detalles.setReferenciaDeCobro(json.getString("Referencia de Cobro"));
				} catch (ClassCastException | JSONException | IndexOutOfBoundsException | IllegalArgumentException e) {
				}
				try {
					detalles.setStatus(json.getString("Status"));
				} catch (ClassCastException | JSONException | IndexOutOfBoundsException | IllegalArgumentException e) {
				}
				try {
					detalles.setTipoDeTarjeta(json.getString("Tipo de Tarjeta"));
				} catch (ClassCastException | JSONException | IndexOutOfBoundsException | IllegalArgumentException e) {
				}
				try {
					detalles.setMontoCobrado(json.getString("Monto Cobrado"));
				} catch (ClassCastException | JSONException | IndexOutOfBoundsException | IllegalArgumentException e) {
				}
				try {
					detalles.setFechaPago(json.getString("Fecha de Pago"));
				} catch (ClassCastException | JSONException | IndexOutOfBoundsException | IllegalArgumentException e) {
				}
				try {
					detalles.setHoraPago(json.getString("Hora de Pago"));
				} catch (ClassCastException | JSONException | IndexOutOfBoundsException | IllegalArgumentException e) {
				}
				try {
					detalles.setNoAutorizacion(json.getString("No. de Autorizacion"));
				} catch (ClassCastException | JSONException | IndexOutOfBoundsException | IllegalArgumentException e) {
				}
				try {
					detalles.setFolioTransaccion(json.getString("Folio de Transaccion"));
				} catch (ClassCastException | JSONException | IndexOutOfBoundsException | IllegalArgumentException e) {
				}
				result.add(detalles);
			}
			return result;
		} catch (JSONException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException e) {
		}
		return null;
	}
	
	private String parseoRespuestaStatus(String mensaje) {
		try {
			JSONObject obj = new JSONObject(mensaje);
			return obj.getString("Status");
		} catch (JSONException | ClassCastException | IllegalArgumentException | IndexOutOfBoundsException e) {
		}
		return null;
	}

}

