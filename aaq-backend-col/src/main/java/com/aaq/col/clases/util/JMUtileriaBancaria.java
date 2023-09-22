package com.aaq.col.clases.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.commons.validator.routines.CreditCardValidator;
import org.apache.commons.validator.routines.DoubleValidator;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.IntegerValidator;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import com.aaq.col.clases.database.entidades.CatalogoCodigoRespuestaBancario;
import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.entidades.MensajeSms;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Transaccion;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCodigoRespuestaBancarioServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.factories.xml.JMXMLObjectFactory;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.xml.link2b.JMLinkInformacionEmpresa;
import com.aaq.col.clases.xml.link2b.JMLinkMotoContenedor;
import com.aaq.col.clases.xml.link2b.JMLinkMotoTarjeta;
import com.aaq.col.clases.xml.link2b.JMLinkMotoTransaccion;
import com.aaq.col.clases.xml.link2b.JMLinkResultadoTransaccion;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaEmail;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaRC4;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;

public class JMUtileriaBancaria {
	
	 Log log = LogFactory.getLog(JMUtileriaBancaria.class);

	Log4JLogger loggerEspecial = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.especial");
	
	
	private static final ConfiguracionServiceInterfase configuracionDao = Configuracion.getConfiguracionService();
	private static final TerminalServiceInterfase terminalDao = Terminal.getTerminalService();
	private static CatalogoCodigoRespuestaBancarioServiceInterfase catalogoCodigoRespuestaBancarioDao = CatalogoCodigoRespuestaBancario
			.getCatalogoCodigoRespuestaBancarioService();
	private static HistoricoTerminalServiceInterfase historicoTerminalDao = HistoricoTerminal
			.getHistoricoTerminalService();
	private static GenericoEnviarSMS genericoEnviarSMS = new GenericoEnviarSMS();

	// **************************************************************//
	// Metodos para pago tipo MOTO
	// **************************************************************//

	/**
	 * Jose Miguel Sep 13, 2012 9:21:31 PM
	 * 
	 * @param terminal
	 * @param usuario
	 * @param tipoDeCobro
	 * @param nombreCuentaHabiente
	 * @param numeroTarjeta
	 * @param expiracionMes
	 * @param expiracionAnio
	 * @param codigoCVV2
	 * @param tipoDeTarjeta
	 * @param montoDeCobro
	 * @param numeroReporte
	 * @param numeroPoliza
	 * @param oficina
	 * @param coberturaAfectada
	 * @param celular
	 * @param email
	 * @param fuente
	 * @param mesesSinIntereses
	 * @param numeroDeMesesSinIntereses
	 * @return la transaccion
	 * @throws Exception
	 */
	public static Transaccion realizarCobro(final Terminal terminal, final Usuario usuario, final String tipoDeCobro,
			final String nombreCuentaHabiente, final String numeroTarjeta, final String expiracionMes,
			final String expiracionAnio, final String codigoCVV2, final String tipoDeTarjeta,
			final String montoDeCobro, final String numeroReporte, final String numeroPoliza, final String oficina,
			final String coberturaAfectada, final String celular, final String email, final String fuente,
			final Boolean mesesSinIntereses, final Integer numeroDeMesesSinIntereses, final Integer claveAbogado) throws Exception {

		// Validamos el Email
		if ((StringUtils.length(email) > 0) && !EmailValidator.getInstance().isValid(email)) {
			throw new Exception(
					"Error Aplicativo Cobro Web: La direccion de correo electronico proporcionada no es valida");
		}

		// Validamos el Telefono
		if ((StringUtils.length(celular) > 0)) {
			if (StringUtils.length(celular) != 10) {
				throw new Exception(
						"Error Aplicativo Cobro Web: El numero de celular proporcionado no es de 10 digitos");
			}
			if (!NumberUtils.isDigits(celular)) {
				throw new Exception("Error Aplicativo Cobro Web: El numero de celular debe de ser 10 digitos numericos");
			}

		}

		// Validamos la llave de Encripcion
		final String llave = JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_GENERAL_LLAVE_ENCRIPCION);
		final int crypto = JMUtileriaBancaria.configuracionDao
				.obtenerEntero(JMConstantes.CONFIGURACION_LINK2B_MOTO_CRYPTO);

		if (StringUtils.isEmpty(llave)) {
			throw new Exception("Error Aplicativo Cobro Web: La llave de encripcion es nula");
		}

		// La interfase para el guardado de los detalles

		// El Contenedor XML
		final JMLinkMotoContenedor tarjetaContenedor = JMUtileriaBancaria.obtenerJMLinkMotoContenedor(usuario,
				nombreCuentaHabiente, numeroTarjeta, expiracionMes, expiracionAnio, codigoCVV2, tipoDeTarjeta,
				montoDeCobro, numeroReporte, llave, mesesSinIntereses, numeroDeMesesSinIntereses);
		if (tarjetaContenedor == null) {
			throw new Exception(
					"Error Aplicativo Cobro Web: El Contenedor XML en formato XStream para la Tarjeta es nulo");
		}

		// La peticion XML
		final String peticionXML = JMUtileriaString.obtenerStringFormateadoParaLink2B(new JMXMLObjectFactory()
				.obtenerStringParaJMLinkMotoContenedor(tarjetaContenedor));

		JMUtileriaBancaria.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(usuario, terminal,
				terminal.getReporteAtendiendo(), fuente, "LINK2B -> Cobro Web -> Envio ", "Se le envia a LINK2B->"
						+ peticionXML);

		if (StringUtils.isBlank(peticionXML)) {
			throw new Exception(
					"Error Aplicativo Cobro Web: El Contenedor XML en formato String para la Tarjeta es nulo");
		}
		
		
		
		// Eliminamos datos de tarjeta y cuentahabiente para Historico Terminal
		String peticionHT = peticionXML;
		String tarjetaP = numeroTarjeta;
		String codigoCVV2P = codigoCVV2;
		String expiracionAnioP = expiracionAnio;
		String expiracionMesP = expiracionMes;
		String nombreCuentaHabienteP = nombreCuentaHabiente;
		String tarjetaB = JMUtileriaBancaria.obtenerStringConCrypto("************" + tarjetaP.subSequence(tarjetaP.length()-4, tarjetaP.length()) , "encriptar", llave, crypto);
		String tarjetaBo = JMUtileriaBancaria.obtenerStringConCrypto(tarjetaP , "encriptar", llave, crypto);
		String cvvB = JMUtileriaBancaria.obtenerStringConCrypto(codigoCVV2P,"encriptar", llave, crypto);
		//Eliminar  nombre de cuentaH, Mes y año Vig
		String yearB = JMUtileriaBancaria.obtenerStringConCrypto(expiracionAnioP, "encriptar", llave, crypto);
		String mesB =  JMUtileriaBancaria.obtenerStringConCrypto(expiracionMesP, "encriptar", llave, crypto);
		String cuentaHB =  JMUtileriaBancaria.obtenerStringConCrypto(nombreCuentaHabienteP, "encriptar", llave, crypto);
		String peticionXMLHT = peticionHT.replaceAll(tarjetaBo, tarjetaB);
		peticionXMLHT = peticionXMLHT.replaceAll(cvvB, "");
		peticionXMLHT = peticionXMLHT.replaceAll(yearB, "");
		peticionXMLHT = peticionXMLHT.replaceAll(mesB, "");
		peticionXMLHT = peticionXMLHT.replaceAll(cuentaHB, "");
		
		JMUtileriaBancaria.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(usuario, terminal,
				terminal.getReporteAtendiendo(), fuente, "LINK2B -> Cobro Web -> Envio URL",
				"Se le envia a LINK2B->" + peticionXMLHT);
		

		

		// La peticion XML formateada
		final String peticionXMLFormatURL = JMUtileriaBancaria.obtenerUrlParaXML(peticionXML);
		if (StringUtils.isBlank(peticionXML)) {
			throw new Exception(
					"Error Aplicativo Cobro Web: El Contenedor XML en formato String para la Tarjeta es nulo");
		}

		// La respuesta del Servidor
		JMUtileriaBancaria.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(usuario, terminal,
				terminal.getReporteAtendiendo(), fuente, "LINK2B -> Cobro Web -> Envio URL",
				"Se le envia a LINK2B En Formato URL ->" + peticionXMLFormatURL);

		String respuestaDelServidor = null;
		try {
			respuestaDelServidor = Request
					.Post(JMUtileriaBancaria.configuracionDao
							.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_SERVER_URL))
					.bodyForm(Form.form().add("xml", peticionXML).build()).execute().returnContent().asString();
		} catch (final Exception ex) {
		}

		// final String respuestaDelServidor =
		// JMUtileriaURL.obtenerTextoDesdeURL(peticionXMLFormatURL);

//		JMUtileriaBancaria.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(usuario, terminal,
//				terminal.getReporteAtendiendo(), fuente, "LINK2B -> Cobro Web -> Envio URL",
//				"El Servidor de LINK2B Responde ->" + respuestaDelServidor);

		if (StringUtils.isBlank(respuestaDelServidor)) {
			throw new Exception("Error Aplicativo Cobro Web / LINK2B: La respuesta del servidor es nula");
		}

		// Interpretacion de la respuesta del servidor
		final JMLinkResultadoTransaccion respuestaDelServidorXML = new JMXMLObjectFactory()
				.obtenerJMLink2bResultadoTransaccionParaString(respuestaDelServidor);
		if (respuestaDelServidorXML == null) {
			throw new Exception(
					"Error Aplicativo Cobro Web / LINK2B: La respuesta del servidor LINK2B no pudo ser interpretada");
		}

		// Inicializamos la transaccion
		final Transaccion transaccion = new Transaccion();
		transaccion.setCatalogoCodigoRespuestaBancario(JMUtileriaBancaria.catalogoCodigoRespuestaBancarioDao
				.objetoCatalogoCodigoRespuestaBancarioParaCodigo(respuestaDelServidorXML.getCd_response()));
		transaccion.setClaveOficina(oficina);
		transaccion.setChecksum(llave);
		transaccion.setCoberturaAfectada(coberturaAfectada);
		transaccion.setDatosAdicionales(respuestaDelServidorXML.getResponse() + "|"
				+ respuestaDelServidorXML.getCd_error() + "|" + respuestaDelServidorXML.getCd_response() + "|"
				+ respuestaDelServidorXML.getNb_error());
		transaccion.setFecha(new Date());
		transaccion.setFuente(fuente);
		transaccion.setMonto(montoDeCobro);
		transaccion.setNumeroAutorizacion(respuestaDelServidorXML.getAuth());
		transaccion.setNumeroOperacion(respuestaDelServidorXML.getFoliocpagos());
		transaccion.setNumeroReferencia(numeroReporte);
		transaccion.setNumeroReporte(numeroReporte);
		transaccion.setNumeroSiniestro(null);
		transaccion.setNumeroPoliza(numeroPoliza);
		transaccion.setTerminal(terminal);
		transaccion.setTipoDeCobro(tipoDeCobro);
		transaccion.setTransaccionAprobada(new Boolean(StringUtils.equalsIgnoreCase(
				respuestaDelServidorXML.getResponse(), "approved")));
		transaccion.setUsuario(usuario);
		//Guardar Clave Abogado
		transaccion.setClaveAbogado(claveAbogado);

		if (StringUtils.containsIgnoreCase(respuestaDelServidorXML.getResponse(), "approved")) {
			transaccion
					.setRespuestaAmigable("Transaccion Aprobada. El cargo se realizo en la tarjeta de credito exitosamente.");
		}
		if (StringUtils.containsIgnoreCase(respuestaDelServidorXML.getResponse(), "denied")) {
			transaccion
					.setRespuestaAmigable("Transaccion Declinada Por el Banco Emisor. NO SE HIZO EL CARGO A LA TARJETA POR QUE EL BANCO EMISOR LO DECLINO. Favor de Intentar con otra tarjeta");
		}
		if (StringUtils.containsIgnoreCase(respuestaDelServidorXML.getResponse(), "error")) {
			transaccion
					.setRespuestaAmigable("Error de Aplicacion: Codigo: "
							+ respuestaDelServidorXML.getCd_error()
							+ ", Mensaje: "
							+ respuestaDelServidorXML.getCd_response()
							+ ", Adicional: "
							+ respuestaDelServidorXML.getNb_error()
							+ ". NO SE HIZO CARGO A LA TARJETA DE CREDITO POR QUE EXISTE UN ERROR DE APLICACION O INFRAESTRUCTURA");
		}

		if (BooleanUtils.isTrue(transaccion.getTransaccionAprobada())) {
			transaccion.setVoucherCliente(JMUtileriaBancaria.obtenerStringConCrypto(
					respuestaDelServidorXML.getVoucher_cliente(), "desencriptar", llave, crypto));

			transaccion.setVoucherComercio(JMUtileriaBancaria.obtenerStringConCrypto(
					respuestaDelServidorXML.getVoucher_comercio(), "desencriptar", llave, crypto));

			transaccion.setVoucherGeneral(JMUtileriaBancaria.obtenerStringConCrypto(
					respuestaDelServidorXML.getVoucher(), "desencriptar", llave, crypto));

		}
		
		respuestaDelServidor = palabraEliminar(respuestaDelServidor,nombreCuentaHabiente);
		respuestaDelServidor = palabraEliminar(respuestaDelServidor,expiracionMes);
		respuestaDelServidor = palabraEliminar(respuestaDelServidor,expiracionAnio);
	

		transaccion.setXmlRespuesta(respuestaDelServidor);
		
		
		JMUtileriaBancaria.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(usuario, terminal,
				terminal.getReporteAtendiendo(), fuente, "LINK2B -> Cobro Web -> Envio URL",
				"El Servidor de LINK2B Responde ->" + respuestaDelServidor);
		
		
		String tarjetaLast4 = JMUtileriaBancaria.obtenerStringConCrypto("************" + numeroTarjeta.subSequence(numeroTarjeta.length()-4, numeroTarjeta.length()) , "encriptar", llave, crypto);
//		String cvvSecret = JMUtileriaBancaria.obtenerStringConCrypto(tipoDeTarjeta.equals("AMEX") ? "****" : "***" , "encriptar", llave, crypto);
		
		String tarjetaEncryp = JMUtileriaBancaria.obtenerStringConCrypto(numeroTarjeta , "encriptar", llave, crypto);
		String cvvEncryp = JMUtileriaBancaria.obtenerStringConCrypto(codigoCVV2,"encriptar", llave, crypto);
		
		//Eliminar  nombre de cuentaH, Mes y año Vig
				String yearEncryp = JMUtileriaBancaria.obtenerStringConCrypto(expiracionAnio, "encriptar", llave, crypto);
				String mesEncryp =  JMUtileriaBancaria.obtenerStringConCrypto(expiracionMes, "encriptar", llave, crypto);
				String cuentaH =  JMUtileriaBancaria.obtenerStringConCrypto(nombreCuentaHabiente, "encriptar", llave, crypto);
				
		
		String peticionXMLCambios = peticionXML.replaceAll(tarjetaEncryp, tarjetaLast4);
		 
		peticionXMLCambios = peticionXMLCambios.replaceAll(cvvEncryp, "");
		
		peticionXMLCambios = peticionXMLCambios.replaceAll(cvvEncryp, "");
		peticionXMLCambios = peticionXMLCambios.replaceAll(yearEncryp, "");
		peticionXMLCambios = peticionXMLCambios.replaceAll(mesEncryp, "");
		peticionXMLCambios = peticionXMLCambios.replaceAll(cuentaH, "");
		
		
		transaccion.setXmlTarjeta(peticionXMLCambios);
		
		if(mesesSinIntereses){
			transaccion.setMesesSinIntereses(String.valueOf(numeroDeMesesSinIntereses));
		}

		transaccion.guardarObjeto();

		JMUtileriaBancaria.enviarNotificacionDeTransaccion(transaccion, email, celular);

		return transaccion;

	}

	/**
	 * Obtiene un contenedor moto para los datos obtenerContenedorMotoParaDatos
	 * Apr 15, 2008 3:12:45 PM
	 * 
	 * @param nombreCuentaHabiente
	 * @param numeroTarjeta
	 * @param expiracionMes
	 * @param expiracionAnio
	 * @param codigoCVV2
	 * @param tipoDeTarjeta
	 * @param montoDeCobro
	 * @param numeroReporte
	 * @return el contenedor moto
	 * @throws Exception
	 */
	private static JMLinkMotoContenedor obtenerJMLinkMotoContenedor(final Usuario usuario,
			final String nombreCuentaHabiente, final String numeroTarjeta, final String expiracionMes,
			final String expiracionAnio, final String codigoCVV2, final String tipoDeTarjeta,
			final String montoDeCobro, final String numeroReporte, final String llave, final Boolean mesesSinIntereses,
			final Integer numeroDeMesesSinIntereses) throws Exception {
		final JMLinkMotoContenedor contenedorMoto = new JMLinkMotoContenedor();

		final String motocountry = JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_COUNTRY);
		final String motobranch = JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_BRANCH);
		final String motocompany = JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_COMPANY);
		final String motopass = JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_PASSWD);
		final String motouser = JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_US_NA);
		final String motocrypto = JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_CRYPTO);
		String mototype = JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_TYPE);
		final String motocurrency = JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_CURRENCY);
		String motomerchant = JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_MERCHANT);
		String mototpoperacion = JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_TP_OPERACION);
		final double montoMaximo = NumberUtils.toDouble(JMUtileriaBancaria.configuracionDao
				.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_GENERAL_MONTO_MAXIMO));

		// Soporte para American Express
		if (StringUtils.equalsIgnoreCase(tipoDeTarjeta, "AMEX")) {
			motomerchant = JMUtileriaBancaria.configuracionDao
					.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_AMEX_MERCHANT);
			mototype = JMUtileriaBancaria.configuracionDao
					.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_AMEX_CCTYPE);
		}

		// Soporte para meses sin intereses
		if (BooleanUtils.isTrue(mesesSinIntereses) && (numeroDeMesesSinIntereses != null)) {
			if ((numeroDeMesesSinIntereses.intValue() != 3) && (numeroDeMesesSinIntereses.intValue() != 6)) {
				throw new Exception("Actualmente solo hay soporte para 3 o 6 meses sin intereses");
			}

			// Tipo de Operacion
			mototpoperacion = JMUtileriaBancaria.configuracionDao
					.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_MESES_SIN_INTERESES_TP_OPERACION);

			// Merchant 3 meses sin intereses
			if (numeroDeMesesSinIntereses.intValue() == 3) {
				motomerchant = JMUtileriaBancaria.configuracionDao
						.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_MESES_SIN_INTERESES_MERCHANT_3_MESES);

				// American Express
				if (StringUtils.equalsIgnoreCase(tipoDeTarjeta, "AMEX")) {
					motomerchant = JMUtileriaBancaria.configuracionDao
							.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_AMEX_MERCHANT_3_MESES);
				}

			}

			// merchant 6 meses sin intereses
			if (numeroDeMesesSinIntereses.intValue() == 6) {
				motomerchant = JMUtileriaBancaria.configuracionDao
						.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_MESES_SIN_INTERESES_MERCHANT_6_MESES);

				// American Express
				if (StringUtils.equalsIgnoreCase(tipoDeTarjeta, "AMEX")) {
					motomerchant = JMUtileriaBancaria.configuracionDao
							.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_MOTO_AMEX_MERCHANT_6_MESES);
				}
			}

		}

		// validacion de datos de entrada
		if (StringUtils.isBlank(nombreCuentaHabiente)) {
			throw new Exception("Es necesario especificar el nombre del cuenta habiente");
		}

		if (!(StringUtils.length(nombreCuentaHabiente) > 5)) {
			throw new Exception("ERROR: El nombre del cuentahabiente es muy corto.");
		}
		if (!NumberUtils.isDigits(numeroTarjeta)) {
			throw new Exception("El numero de tarjeta debe de contener solamente caracteres numericos");
		}

		if (!NumberUtils.isDigits(codigoCVV2)) {
			throw new Exception("El codigo de validacion debe de contener solamente caracteres numericos");
		}

		// Validar el tipo de tarjeta
		if (!StringUtils.equalsIgnoreCase(tipoDeTarjeta, "AMEX")
				&& !StringUtils.equalsIgnoreCase(tipoDeTarjeta, "V/MC")) {
			throw new Exception("Es necesario especificar un tipo de tarjeta valido AMEX o V/MC");
		}

		// Validamos caracteres de tarjeta AMEX
		if (StringUtils.equalsIgnoreCase(tipoDeTarjeta, "AMEX")) {
			if (StringUtils.length(numeroTarjeta) != 15) {
				throw new Exception(
						"Para las tarjetas American Express es necesario capturar un numero de tarjeta de 15 digitos");
			}
			if (StringUtils.length(codigoCVV2) != 4) {
				throw new Exception(
						"Para las tarjetas American Express es necesario capturar un numero de validacion de 4 digitos");

			}
			if (NumberUtils.toInt(codigoCVV2) <= 0) {
				throw new Exception("El codigo de validacion no puede ser cero 000");
			}
		}

		// Validacion de tarjeta visa / master card
		if (StringUtils.equalsIgnoreCase(tipoDeTarjeta, "V/MC")) {
			if (StringUtils.length(numeroTarjeta) != 16) {
				throw new Exception(
						"Para las tarjetas Visa o Master Card es necesario capturar un numero de tarjeta de 16 digitos");
			}
			if (StringUtils.length(codigoCVV2) != 3) {
				throw new Exception(
						"Para las tarjetas American Express es necesario capturar un numero de validacion de 3 digitos");

			}
			if (NumberUtils.toInt(codigoCVV2) <= 0) {
				throw new Exception("El codigo de validacion debe ser mayor o igual a cero");
			}
		}

		// Valida el numero de tarjeta
		if (!new CreditCardValidator().isValid(numeroTarjeta)) {
			throw new Exception(
					"Es necesario especificar un numero valido de Tarjeta de Credito VISA / American Express / Master Card");
		}
		// Valida el codigo CVV2
		if (StringUtils.isBlank(codigoCVV2)) {
			throw new Exception("Es necesario especificar el codigo CVV2 de la tarjeta");
		}

		// Valida el año
		final int anoActual = Calendar.getInstance().get(Calendar.YEAR);

		if (!IntegerValidator.getInstance().isInRange(NumberUtils.toInt(expiracionAnio) + 2000, anoActual,
				anoActual + 10)) {
			throw new Exception("Es necesario especificar un año de expiracion valido");
		}

		// Valida el Mes
		if (!IntegerValidator.getInstance().isInRange(NumberUtils.toInt(expiracionMes), 1, 12)) {
			throw new Exception("Es necesario especificar el mes de expiracion");
		}

		// Valida el monto del cobro
		if (!DoubleValidator.getInstance().isInRange(NumberUtils.toDouble(montoDeCobro), 0.5, montoMaximo)) {
			throw new Exception("Es necesario especificar el monto a cobrar mayor a 50 centavos y menor a "
					+ montoMaximo + " pesos");
		}
		if (StringUtils.isBlank(numeroReporte)) {
			throw new Exception("Es necesario especificar el numero de reporte");
		}

		// validacion de datos de configuracion
		if (StringUtils.isBlank(motocountry)) {
			throw new Exception("Error en la configuracion del sistema LINK2B. El campo MOTO-Country es nulo");
		}
		if (StringUtils.isBlank(motobranch)) {
			throw new Exception("Error en la configuracion del sistema LINK2B. El campo MOTO-Branch es nulo");
		}
		if (StringUtils.isBlank(motocompany)) {
			throw new Exception("Error en la configuracion del sistema LINK2B. El campo MOTO-Company es nulo");
		}
		if (StringUtils.isBlank(motopass)) {
			throw new Exception("Error en la configuracion del sistema LINK2B. El campo MOTO-Passwd es nulo");
		}
		if (StringUtils.isBlank(motouser)) {
			throw new Exception("Error en la configuracion del sistema LINK2B. El campo MOTO-Username es nulo");
		}
		if (StringUtils.isBlank(motocrypto)) {
			throw new Exception("Error en la configuracion del sistema LINK2B. El campo MOTO-Crypto es nulo");
		}
		if (StringUtils.isBlank(mototype)) {
			throw new Exception("Error en la configuracion del sistema LINK2B. El campo MOTO-Type es nulo");
		}
		if (StringUtils.isBlank(motocurrency)) {
			throw new Exception("Error en la configuracion del sistema LINK2B. El campo MOTO-Currency es nulo");
		}
		if (StringUtils.isBlank(motomerchant)) {
			throw new Exception("Error en la configuracion del sistema LINK2B. El campo MOTO-Merchant es nulo");
		}
		if (StringUtils.isBlank(mototpoperacion)) {
			throw new Exception("Error en la configuracion del sistema LINK2B. El campo MOTO-Tp-Operacion es nulo");
		}

		// Informacion de la empresa
		final JMLinkInformacionEmpresa informacion = new JMLinkInformacionEmpresa();

		informacion.setCountry(motocountry);
		informacion.setId_branch(motobranch);
		informacion.setId_company(motocompany);
		informacion.setPwd(JMUtileriaBancaria.obtenerStringConCrypto(motopass, "encriptar", llave,
				NumberUtils.toInt(motocrypto)));
		informacion.setUser(motouser);

		// Informacion de la tarjeta
		final JMLinkMotoTarjeta tarjeta = new JMLinkMotoTarjeta();
		tarjeta.setCrypto(motocrypto);
		tarjeta.setCvv_csc(JMUtileriaBancaria.obtenerStringConCrypto(codigoCVV2, "encriptar", llave,
				NumberUtils.toInt(motocrypto)));
		tarjeta.setExpmonth(JMUtileriaBancaria.obtenerStringConCrypto(expiracionMes, "encriptar", llave,
				NumberUtils.toInt(motocrypto)));
		tarjeta.setExpyear(JMUtileriaBancaria.obtenerStringConCrypto(expiracionAnio, "encriptar", llave,
				NumberUtils.toInt(motocrypto)));
		tarjeta.setName(JMUtileriaBancaria.obtenerStringConCrypto(
				JMUtileriaString.quitarEspeciales(nombreCuentaHabiente), "encriptar", llave,
				NumberUtils.toInt(motocrypto)));
		tarjeta.setNumber(JMUtileriaBancaria.obtenerStringConCrypto(numeroTarjeta, "encriptar", llave,
				NumberUtils.toInt(motocrypto)));
		tarjeta.setType(mototype);

		// Informacion de transaccion bancaria
		final JMLinkMotoTransaccion transaccionBancaria = new JMLinkMotoTransaccion();
		transaccionBancaria.setCreditcard(tarjeta);
		transaccionBancaria.setCurrency(motocurrency);
		transaccionBancaria.setMerchant(motomerchant);
		transaccionBancaria.setTp_operation(mototpoperacion);
		transaccionBancaria.setUsrtransacction("SIICASERVER_"
				+ (usuario != null ? StringUtils.upperCase(usuario.getUsername()) : "WEBSERVICES"));
		transaccionBancaria.setVersion("SIICASERVER_5.0");

		// validacion del monto
		if (JMUtileriaBancaria.configuracionDao
				.obtenerBooleano(JMConstantes.CONFIGURACION_LINK2B_GENERAL_COBRAR_MINIMO)) {
			transaccionBancaria.setAmount("0.5");
			transaccionBancaria.setReference(numeroReporte + RandomStringUtils.randomAlphabetic(2));
		} else {
			transaccionBancaria.setAmount(montoDeCobro);
			transaccionBancaria.setReference(numeroReporte);
		}

		// informacion del contenedir moto
		contenedorMoto.setBusiness(informacion);
		contenedorMoto.setTransacction(transaccionBancaria);

		return contenedorMoto;

	}

	// **************************************************************//
	// Metodos de transformacion
	// **************************************************************//

	private static String obtenerStringConCrypto(final String original, final String operacion, final String llave,
			final int crypto) {
		if (StringUtils.isNotBlank(original) && StringUtils.isNotBlank(operacion) && StringUtils.isNotBlank(llave)
				&& (crypto > 0)) {
			if (operacion.equals("encriptar")) {
				return new JMUtileriaRC4(llave).encriptar(original);
			}
			if (operacion.equals("desencriptar")) {
				return new JMUtileriaRC4(llave).desencriptar(original);
			}
		}
		return original;

	}

	/**
	 * Obtiene un URL formateado para un xml obtenerTransaccionEnFormatoURL Apr
	 * 15, 2008 3:19:26 PM
	 * 
	 * @param transaccion
	 * @return el ULR
	 * @throws Exception
	 */
	private static String obtenerUrlParaXML(final String transaccion) throws Exception {
		String formatoURL = null;
		try {
			formatoURL = JMUtileriaBancaria.configuracionDao
					.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_SERVER_URL)
					+ URLEncoder.encode(transaccion, "ISO-8859-1");
		} catch (final UnsupportedEncodingException e) {
			try {
				formatoURL = JMUtileriaBancaria.configuracionDao
						.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_SERVER_URL)
						+ URLEncoder.encode(transaccion, "ISO-8859_1");
			} catch (final UnsupportedEncodingException e1) {
				try {
					formatoURL = JMUtileriaBancaria.configuracionDao
							.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_SERVER_URL)
							+ URLEncoder.encode(transaccion, "UTF-8");
				} catch (final UnsupportedEncodingException e2) {
					throw new Exception("Error al intentar codificar el XML de salida en formato URL . Detalle: "
							+ e.getMessage());
				}
			}
		}
		return formatoURL;
	}

	// **************************************************************//
	// Metodos de apoyo para el envio de correo
	// **************************************************************//

	private static void enviarNotificacionDeTransaccion(final Transaccion t, final String email, final String celular)
			throws Exception {

		try {

			final StringBuilder asunto = new StringBuilder("Pago en linea. "
					+ (BooleanUtils.isTrue(t.getTransaccionAprobada()) ? "Transaccion Aprobada"
							: "Transaccion Declinada"));
			final StringBuilder sms = new StringBuilder("Servicio Movil Bancario. "
					+ (BooleanUtils.isTrue(t.getTransaccionAprobada()) ? "Transaccion Aprobada"
							: "Transaccion Declinada"));
			sms.append(", Reporte: " + t.getNumeroReferencia());
			sms.append(", Monto: " + t.getMonto());
			sms.append(", Auth: " + t.getNumeroAutorizacion());
			sms.append(", Oper: " + t.getNumeroOperacion());

			asunto.append(Objects.toString(t.getCatalogoCodigoRespuestaBancario(), ""));

			final StringBuilder correo = new StringBuilder("");

			correo.append("<p class=\"normal\">Respuesta del banco: <span style=\"BACKGROUND-COLOR: yellow\">"
					+ Objects.toString(t.getCatalogoCodigoRespuestaBancario(), "") + "</span>");

			if (BooleanUtils.isTrue(t.getTransaccionAprobada())) {
				correo.append("<br />La transaccion bancaria ha sido <b>aprobada</b>");
			} else {
				correo.append("<br />La transaccion bancaria ha sido <b>declinada</b>");
			}

			correo.append("<br> <b>Fecha:</b> " + JMUtileriaFecha.obtenerFechaActual(true));
			correo.append("<br /> <b>Numero de reporte:</b>  " + t.getNumeroReporte());

			correo.append("<br /> <b>Monto de Transaccion:</b> " + t.getMonto());
			correo.append("<br /> <b>Respuesta:</b> " + Objects.toString(t.getCatalogoCodigoRespuestaBancario(), ""));
			correo.append("<br /> <b>N. Autorizacion:</b> " + t.getNumeroAutorizacion());
			correo.append("<br /> <b>N. Operacion:</b> " + t.getNumeroOperacion());
			correo.append("<br /> <b>N. Referencia:</b> " + t.getNumeroReferencia());

			if (!BooleanUtils.isTrue(t.getTransaccionAprobada())) {
				correo.append("<br /> <b>Error:</b> " + t.getDatosAdicionales());
			}

			correo.append("</p>");

			// Enviar Email
			if (StringUtils.isNotBlank(email)) {
				final ArrayList<String> personas = new ArrayList<>();
				personas.add(email);
				new JMUtileriaEmail(
						JMUtileriaBancaria.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
						JMUtileriaBancaria.configuracionDao
								.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
						JMUtileriaBancaria.configuracionDao
								.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
						JMUtileriaBancaria.configuracionDao
								.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
						JMUtileriaBancaria.configuracionDao
								.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
						JMUtileriaBancaria.configuracionDao
								.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
						JMUtileriaBancaria.configuracionDao
								.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
						JMUtileriaBancaria.configuracionDao
								.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG)).enviarEmail(personas,
						Objects.toString(asunto, ""), Objects.toString(correo, ""));
			}

			// Enviar SMS
			if (StringUtils.isNotBlank(Objects.toString(sms, "")) && (StringUtils.length(celular) == 10)) {
				final ArrayList<String> listaMensajes = JMUtileriaString.romperString(Objects.toString(sms, ""), 153);

				for (final String texto : listaMensajes) {
					try {
						final MensajeSms mensajeSMS = new MensajeSms();
						mensajeSMS.setFecha(new Date());
						mensajeSMS.setMensajeoriginal(Objects.toString(sms, ""));
						mensajeSMS.setTelefonodestino(celular);
						mensajeSMS.setTexto(texto);
						mensajeSMS.setTerminal(JMUtileriaBancaria.terminalDao.objetoTerminalParaNumeroTelefono(celular));
						mensajeSMS.setUsuario(null);
						mensajeSMS.setDireccionIp(null);

						if(genericoEnviarSMS.enviarSMS(celular, texto)){
							mensajeSMS.guardarObjeto();
						}
					} catch (final Exception ex) {
						throw ex;
					}
				}
			}
			
			if (StringUtils.isNotBlank(Objects.toString(sms, "")) && (StringUtils.length(t.getTerminal().getTelefono()) == 10)) {
				final ArrayList<String> listaMensajes = JMUtileriaString.romperString(Objects.toString(sms, ""), 153);

				for (final String texto : listaMensajes) {
					try {
						final MensajeSms mensajeSMS = new MensajeSms();
						mensajeSMS.setFecha(new Date());
						mensajeSMS.setMensajeoriginal(Objects.toString(sms, ""));
						mensajeSMS.setTelefonodestino(celular);
						mensajeSMS.setTexto(texto);
						mensajeSMS.setTerminal(JMUtileriaBancaria.terminalDao.objetoTerminalParaNumeroTelefono(t.getTerminal().getTelefono()));
						mensajeSMS.setUsuario(null);
						mensajeSMS.setDireccionIp(null);

						if(genericoEnviarSMS.enviarSMS(t.getTerminal().getTelefono(), texto)){
							mensajeSMS.guardarObjeto();
						}
					} catch (final Exception ex) {
						throw ex;
					}
				}
			}

		} catch (final Exception ex) {
			throw ex;
		}
	}
	
	public static String  palabraEliminar(String oracion, String palabraElim) {
	    if(oracion.contains(palabraElim))
	        oracion =  oracion.replaceAll(palabraElim, "");
	    		oracion = oracion.replaceAll("\\r\\n", "");
	    return oracion;
	}
	
	@SuppressWarnings("unused")
	public static Transaccion guardarCobro(final Terminal terminal, final String coberturaAfectada,  final String email,
				final String monto, final String reporte, final String celular, final String tipoDeCobro, final String response, 
				final String auth, final String foliocpagos, final String cd_error,  final String descripcion, 
				final String cd_response,
				final String datosBanco, final String tipoOperacion,final String direccion,
				final String fecha) throws Exception {
		
		// Validamos la llave de Encripcion
				final String llave = JMUtileriaBancaria.configuracionDao
						.obtenerCadena(JMConstantes.CONFIGURACION_LINK2B_GENERAL_LLAVE_ENCRIPCION);
				final int crypto = JMUtileriaBancaria.configuracionDao
						.obtenerEntero(JMConstantes.CONFIGURACION_LINK2B_MOTO_CRYPTO);

				if (StringUtils.isEmpty(llave)) {
					throw new Exception("Error Aplicativo Cobro Web: La llave de encripcion es nula");
				}

		// Inicializamos la transaccion
		final Transaccion transaccion = new Transaccion();
		try { 
		transaccion.setCatalogoCodigoRespuestaBancario(JMUtileriaBancaria.catalogoCodigoRespuestaBancarioDao
				.objetoCatalogoCodigoRespuestaBancarioParaCodigo(cd_response));
		} catch (Exception e) {
		}
		transaccion.setCoberturaAfectada(coberturaAfectada);
		transaccion.setDatosAdicionales(response + "|" +cd_error+"|"+cd_response);
		transaccion.setFecha(new Date());
		transaccion.setFuente("Dispositivo Bancario");
		transaccion.setMonto(monto);
		transaccion.setNumeroAutorizacion(auth);
		transaccion.setNumeroOperacion(foliocpagos);
		transaccion.setNumeroReferencia(reporte);
		transaccion.setNumeroReporte(reporte);
		transaccion.setNumeroSiniestro(null);
		transaccion.setTerminal(terminal);
		transaccion.setTipoDeCobro(tipoDeCobro);
		transaccion.setChecksum(llave);
		transaccion.setTransaccionAprobada(new Boolean(StringUtils.equalsIgnoreCase(
				response, "approved")));
		

		if (StringUtils.containsIgnoreCase(response, "approved")) {
			transaccion
					.setRespuestaAmigable("Transaccion Aprobada. El cargo se realizo en la tarjeta exitosamente.");
		}
		if (StringUtils.containsIgnoreCase(response, "denied")) {
			transaccion
					.setRespuestaAmigable("Transaccion Declinada Por el Banco Emisor. NO SE HIZO EL CARGO A LA TARJETA POR QUE EL BANCO EMISOR LO DECLINO. Favor de Intentar con otra tarjeta");
		}
		if (StringUtils.containsIgnoreCase(response, "error")) {
			transaccion
					.setRespuestaAmigable("Error de Aplicacion: Codigo: "
							+ cd_error
							+ ", Mensaje: "
							+ cd_response
							+ ". NO SE HIZO CARGO A LA TARJETA DE CREDITO POR QUE EXISTE UN ERROR DE APLICACION O INFRAESTRUCTURA");
		}

		
		if(response.contains("approved")) {
			
        	ArrayList<String> lista = new ArrayList<>();
			try {
				String[] banco = datosBanco.split("\\/");
		        	for (int i = 0; i < banco.length; i++) {
						lista.add(banco[i]); 
					}
			} catch (Exception e) {
			}
			
	        	
			String voucherApro ="@cnb "+lista.get(1)
			+"	@cnn "+lista.get(0) 
			+"	@cnn "+tipoOperacion 
			+"	@cnn  QUALITAS Compañia de Seguros S.A. De C.V."
			+"	@cnn  Administración Ajustadores Qualitas."
			+"	@lnn "+direccion
			+"	@lnn "+foliocpagos 
			+"	@br "
//			+"	@lnn No.Tarjeta: xxxxxxxxxxxx"+tarjeta 
			+"	@br "
			+"	@lnn "+datosBanco
			+"	@br "
			+"	@lnn IMPORTE       $ "+monto+"MXN" 
			+"	@br "
			+"	@lnn Ref.:  "+reporte 
			+"	@lnn Aut.:  "+auth 
			+"	@lnn "   
			+"	@lnn Fecha: "+fecha 
			+"	@br "
			+"	@br "
			+"	@br "
			+"	@br "
			+"	@br "
			+"	@cnn ______________________________ "
			+"	@br ";
			transaccion.setVoucherGeneral(voucherApro);
		} else  {
			String denegado = headerMensajeXML()
					+"<CENTEROFPAYMENTS>"
					 +"<reference>"+reporte+"</reference>"
					 +"<response>"+response+"</response>"
					 +"<foliocpagos>"+foliocpagos+"</foliocpagos>"
					 +"<auth/>"
					 +"<cd_response>"+cd_response+"</cd_response>"
					 +"<cd_error/>"
					 +"<nb_error/>"
					 +"<nb_company/>"
					 +"<nb_merchant/>"
					 +"<nb_street/>"
					 +"<cc_type/>"
					 +"<tp_operation/>"
					 +"<cc_name></cc_name>"
					 +"<cc_number></cc_number>"
					 +"<cc_expmonth></cc_expmonth>"
					 +"<cc_expyear></cc_expyear>"
					 +"<amount/>"
					 +"<voucher/>"
					 +"<tokenb5/>"
					 +"<tokenb6/>"
					 +"<voucher_comercio/>"
					 +"<voucher_cliente/>"
					 +"<friendly_response>"+descripcion+"</friendly_response>"
					 +"<emv_key_date/>"
					 +"<icc_csn/>"
					 +"<icc_atc/>"
					 +"<icc_arpc/>"
					 +"<icc_issuer_script/>"
					 +"<authorized_amount/>"
					 +"<account_balance_1/>"
					 +"</CENTEROFPAYMENTS>";
			transaccion.setXmlRespuesta(denegado);

		}
		
//		String tarjetaEncry =  JMUtileriaBancaria.obtenerStringConCrypto("************"+tarjeta, "encriptar", llave, crypto);
		
		transaccion.setXmlTarjeta(null);

		transaccion.guardarObjeto();

		JMUtileriaBancaria.enviarNotificacionDeTransaccion(transaccion, email, celular);

		return transaccion;

	}
	
	public static String headerMensajeXML() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>";
    }
	
}
