package com.aaq.col.clases.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.castor.util.Base64Decoder;

import com.aaq.col.clases.database.entidades.DatosEmailPlantillas;
import com.aaq.col.clases.database.entidades.FormatoAdmisionAutomoviles;
import com.aaq.col.clases.database.entidades.FormatoAdmisionMotocicletas;
import com.aaq.col.clases.database.entidades.FormatoAdmisionPesado;
import com.aaq.col.clases.database.entidades.FormatoAsignacionAbogado;
import com.aaq.col.clases.database.entidades.FormatoAsistenciaVial;
import com.aaq.col.clases.database.entidades.FormatoCargoTarjetaCredito;
import com.aaq.col.clases.database.entidades.FormatoCatalogos;
import com.aaq.col.clases.database.entidades.FormatoCuestionarioRobo;
import com.aaq.col.clases.database.entidades.FormatoDeclaracionUniversal;
import com.aaq.col.clases.database.entidades.FormatoEncuestaServicio;
import com.aaq.col.clases.database.entidades.FormatoGarantiaPrendaria;
import com.aaq.col.clases.database.entidades.FormatoInspeccionMoto;
import com.aaq.col.clases.database.entidades.FormatoInspeccionPesado;
import com.aaq.col.clases.database.entidades.FormatoInventarioAutomoviles;
import com.aaq.col.clases.database.entidades.FormatoInventarioUnicoPesado;
import com.aaq.col.clases.database.entidades.FormatoMemoriaDescriptiva;
import com.aaq.col.clases.database.entidades.FormatoNuevosVehiculos;
import com.aaq.col.clases.database.entidades.FormatoObservacionesAsegurado;
import com.aaq.col.clases.database.entidades.FormatoOrdenServicio;
import com.aaq.col.clases.database.entidades.FormatoPaseMedico;
import com.aaq.col.clases.database.entidades.FormatoReciboIngresoSiniestro;
import com.aaq.col.clases.database.entidades.FormatoReciboPagoDeducible;
import com.aaq.col.clases.database.entidades.FormatoReclamacionComprobantePeaje;
import com.aaq.col.clases.database.entidades.FormatoReclamacionPendiente;
import com.aaq.col.clases.database.entidades.FormatoReparacionBienes;
import com.aaq.col.clases.database.entidades.FormatoReparacionBienesDiversos;
import com.aaq.col.clases.database.entidades.FormatoResponsabilidadCivil;
import com.aaq.col.clases.database.entidades.FormatoSolicitudDiagnostico;
import com.aaq.col.clases.database.entidades.FormatoValeAmbulancia;
import com.aaq.col.clases.path.ProveedorApplicationContextFormatos;

import org.apache.commons.lang3.StringUtils;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class ValidarFormatosPlantillas {

	Log4JLogger loggerDownload = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.downloadFile");

	/*@Autowired
	ExpedienteDigitalServiceInterfase expedienteDigitalService;*/

	private InputStream fileJrxmlReclamacion;

	private InputStream fileJrxmlEncuesta;

	private InputStream fileJrxmlAsistencia;

	private InputStream fileJrxmlNuevos;

	private InputStream fileJrxmlPaseMedico;

	private InputStream fileJrxmlAbogado;

	private InputStream fileJrxmlGarantia;

	private InputStream fileJrxmlReparacion;

	private InputStream fileJrxmlAmbulancia;

	private InputStream fileJrxmlOrdenServicio;


	private InputStream fileJrxmlDeclaracionContent;

	@SuppressWarnings("unused")
	private InputStream fileJrxmlDeclaracionMail;

	@SuppressWarnings("unused")
	private InputStream fileJrxmlDeclaracionMailB;

	private InputStream fileJrxmlInventario;

	private InputStream fileJrxmlCuestionario;

	private InputStream fileJrxmlAdmisionAuto;

	private InputStream fileJrxmlAdmisionMoto;

	private InputStream fileJrxmlAdmisionPesado;

	private InputStream fileJrxmlInspeccionPesado;

	private InputStream fileJrxmlInspeccionMoto;

	private InputStream fileJrxmlReciboIngresoSiniestro;

	private InputStream fileJrxmlReciboPagoDeducible;

	private InputStream fileJrxmlSolicitudDiagnostico;

	private InputStream fileJrxmlMemoriaDescriptiva;
//	private InputStream fileJrxmlPagoIndemnizacion;
	
	private InputStream fileJrxmlCargoTarjeta;
	
	private InputStream fileJrxmlResponsabilidad;
	
	private InputStream fileJrxmlBienesDiversos;
	
	private InputStream fileJrxmlObservacionesAsegurado;
	
	public static final String TIPO_DOCUMENTO = "QSID";

	public static final String FORMATO_PRUEBA = "PRUEBA";

	public static final String FORMATO_RECLAMACION_PENDIENTE = "QS19";

	public static final String FORMATO_ENCUESTA_SERVICIO = "QS25";

	public static final String FORMATO_ASISTENCIA_VIAL = "QS65";

	public static final String FORMATO_NUEVOS_VEHICULOS = "QS60";

	public static final String FORMATO_PASE_MEDICO = "QS07";

	public static final String FORMATO_ASIGNACION_ABOGADO = "LE29";

	public static final String FORMATO_GARANTIA_PRENDARIA = "GN08";

	public static final String FORMATO_REPARACION_BIENES = "QS53";

	public static final String FORMATO_VALE_AMBULANCIA = "QS21";

	public static final String FORMATO_ORDEN_SERVICIO = "QS62";

	public static final String FORMATO_DECLARACION_UNIVERSAL = "QSD1";

	public static final String FORMATO_INVENTARIO_AUTOMOVILES = "QS03";

	public static final String FORMATO_CUESTIONARIO_ROBO = "RO01";

	public static final String FORMATO_ADMISION_AUTOMOVILES = "QS08";

	public static final String FORMATO_ADMISION_MOTOCICLETAS = "QS63";

	public static final String FORMATO_ADMISION_PESADO = "PESADO";

	public static final String F_INSPECCION_PESADO = "QS0000";

	public static final String F_INSPECCION_MOTO = "Q00000";

	public static final String FORMATO_RECIBO_INGRESO = "QS11";

	public static final String FORMATO_RECIBO_DEDUCIBLE = "QS10";

	public static final String FORMATO_SOLICITUD_DIAGNOSTICO = "GN71";

	public static final String FORMATO_MEMORIA_DESCRIPTIVA = "QS42";
	
	public static final String FORMATO_PAGO_INDEMNIZACION = "QSCM";
	
	public static final String FORMATO_CARGO_TARJETA = "QE26";
	
	public static final String FORMATO_RESPONSABILIDAD_CIVIL= "RC03";
	
	public static final String FORMATO_BIENES_DIVERSOS= "QS57";
	
	public static final String FORMATO_OBSERVACIONES_ASEGURADO= "OB01";
	
	public static final String FORMATO_INVENTARIO_PESADO= "QS3A";
	
	public static final String FORMATO_RECLAMACION_COMPROBANTE_PEAJE= "QS41";
	
	private InputStream fileJrxmlInventarioUnicoPesado;
	
	private InputStream fileJrxmlReclamacionComprobantePeaje;

	private DateFormat readFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private DateFormat writeFormatFecha = new SimpleDateFormat("dd/MM/yyyy");

	private DateFormat writeFormatHora = new SimpleDateFormat("HH:mm");
	@SuppressWarnings("unused")
	private String respuestaEmail = "";
	@SuppressWarnings("unused")
	private int emailEnviado = 0;
	@SuppressWarnings("unused")
	private boolean PRODUCCION = true;
	@SuppressWarnings("unused")
	private String direccion = "";
	@SuppressWarnings("unused")
	private String direccionMail = "";
	@SuppressWarnings("unused")
	private String direccionMailB = "";
	@SuppressWarnings("unused")
	private Timestamp fechaEnvioMail;
	@SuppressWarnings("unused")
	private Timestamp fechaEnvioSftp;

	public void crearArchivoError(String subtipoDocumento, InputStream fileJrxml, HashMap<String, Object> parametros,
			String numeroReporte, String numeroPoliza, String tipoAfectado, OutputStream ou) {
		try {
			fechaEnvioMail = null;
			fechaEnvioSftp = null;

			JasperReport jasperReport = JasperCompileManager.compileReport(fileJrxml);
			fileJrxml.close();
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());

			HashMap<String, Object> datosArchivos = nombrarArchivoPaseOrden(subtipoDocumento, numeroReporte,
					numeroPoliza, tipoAfectado, "");

			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

			datosArchivos.put("contenidoPDF", pdf);
			datosArchivos.put("tipoDocumento", subtipoDocumento);
			ByteArrayInputStream bis = new ByteArrayInputStream(pdf);
			
			ou.write(pdf);
			bis.close();
		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}

	}

	////////////////////////////////////////////////////////////////////////
	public static String formatoMontos(String monto) {
		int posicionPunto = 0;
		boolean hayPunto = false;
		for (int i = 0; i < monto.length(); i++) {

			if (monto.charAt(i) == '.') {

				posicionPunto = i;

				hayPunto = true;
			}
		}

		if (hayPunto == true) {
			if (monto.length() - posicionPunto > 2) {
				monto = monto.substring(0, posicionPunto + 3);
			}
			else if (monto.length() - posicionPunto == 1) {
				monto = monto + "00";
			}
			else if (monto.length() - posicionPunto == 2) {
				monto = monto + "0";

			}

		} else {

			if (!monto.equals(" ")) {

				monto = monto + ".00";

			} else {

				return "0.00";

			}

		}

		return monto;

	}

	public String validarCadena(String cadena) {
		if (cadena == null) {
			return " ";
		}
		else {
			return cadena.toUpperCase().replaceAll("\n", " ");
		}
	}

	public int validarNumero(String numero) {
		if (numero.equals("null")) {
			return 0;
		} else {
			return Integer.parseInt(numero);
		}
	}

	public String buscarBlank(String cadena, int corteI, int corteF) {
		corteF = corteF - 1;
		boolean valido = true;
		String renglonActual = "";
		char[] descomponerCadena = cadena.toCharArray();
		while (descomponerCadena[corteF] != ' ' && valido == true) {
			if (corteF != 0) {
				corteF = corteF - 1;
			}
			else {
				valido = false;
			}
		}

		renglonActual = cadena.substring(corteI, corteF);
		return renglonActual;

	}

	public int validarAsegurado(String valor) {
		String tercero = "";
		int terceroValidado = 0;

		if (valor == null) {
			return 1;
		}

		String cadena = valor.replaceAll(" ", "");

		if (cadena.equals("1")) {
			return Integer.parseInt(cadena);
		} else {
			tercero = valor.replaceAll("T", "");
			terceroValidado = Integer.parseInt(tercero) + 1;
		}
		return terceroValidado;
	}

	public String formatoNumero(String num) {

		if (!num.equals("0000000000")) {

			num = num.replace("-", "");

			num = num.replace("(", "");

			num = num.replace(")", "");

			num = num.replace(" ", "");

			if (num.length() == 10) {
				return num.substring(0, 2) + " " + num.substring(2, 6) + " " + num.substring(6, 10);
			} else {
				return num;
			}
		} else {
			return " ";
		}
	}

	public String validarCadenaMail(String cadena) {
		if (cadena == null) {
			return " ";
		} else {
			return cadena;
		}
	}

	public String separarMontos(String monto) {
		if (monto.length() > 6) {
			String aux = "";
			String separador = ",";
			int ultimo = 0;
			for (int i = 0; i < monto.length(); i++) {
				if (monto.charAt(i) == '.') {
					for (int j = i - 3; j > 0; j = j - 3) {
						aux = separador + monto.substring(j, (j + 3)) + aux;
						ultimo = j;
					}
				}
			}
			return monto.substring(0, ultimo) + aux + "." + monto.substring(monto.length() - 2, monto.length());
		} else {
			return monto;
		}
	}

	public int validarES(String numero) {
		if (numero.equals("null")) {
			return 10;
		} else {
			return Integer.parseInt(numero);
		}
	}
	
	@SuppressWarnings("unused")
	private HashMap<String, Object> nombrarArchivoPaseOrden(String subtipoDocumento, String numeroReporte,
			String numeroPoliza, String tipoAfectado, String numDocumento) {

		// Nombre de archivo jpg
		String nombreArchivo = "";
		String separador = "_";
		String extensionArchivo = ".pdf";

		// Contenido archivo lst
		String contenidoLst = "";

		// Variable general de salida
		HashMap<String, Object> hashArchivo = new HashMap<String, Object>();

		/// AQUI SE MODIFICARA PARA EL TIPO DE DOCUMENTO
		String tipoDoc = "N-A";


		nombreArchivo = validarCadena(subtipoDocumento) + separador + separador + separador
				+ validarCadena(numeroReporte) + separador + validarCadena(numeroPoliza) + separador + separador
				+ tipoAfectado + separador + "1_1" + numDocumento + extensionArchivo;

		hashArchivo.put("nombrePDF", nombreArchivo);
		hashArchivo.put("contenidoLst", contenidoLst);

		return hashArchivo;
	}

	public String nombrarArchivo(String subtipoDocumento, String numeroReporte, String numeroPoliza,
			String tipoAfectado, String numDocumento) {

		// Nombre de archivo jpg
		String nombreArchivo = "";
		String separador = "_";
		String extensionArchivo = ".pdf";

		/// AQUI SE MODIFICARA PARA EL TIPO DE DOCUMENTO
		nombreArchivo = validarCadena(subtipoDocumento) + separador + separador + separador
				+ validarCadena(numeroReporte) + separador + validarCadena(numeroPoliza) + separador + separador
				+ tipoAfectado + separador + "1_1" + numDocumento + extensionArchivo;

		return nombreArchivo;
	}

	public void procesoReclamacionPendienteError(FormatoReclamacionPendiente formatoReclamacionPendiente,
			OutputStream ou) {
		try {
			fileJrxmlReclamacion = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/ReclamacionPendiente.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			HashMap<String, Object> paramReclamacion = new HashMap<String, Object>();

			paramReclamacion.put("imgLogoQualitas", imgLogoQualitas);

			if (formatoReclamacionPendiente.getRpFecha() != null) {
				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoReclamacionPendiente.getRpFecha()));

				paramReclamacion.put("fecha", writeFormatFecha.format(date) + "");

			} else {
				paramReclamacion.put("fecha", "");
			}

			paramReclamacion.put("nombreAjustador",
					validarCadena(formatoReclamacionPendiente.getRpNomAjustador()));
			paramReclamacion.put("numReclamacion",
					validarCadena(formatoReclamacionPendiente.getRpNumReclamacion()));
			paramReclamacion.put("poliza", validarCadena(formatoReclamacionPendiente.getRpNumPoliza()));
			paramReclamacion.put("folio", validarCadena(formatoReclamacionPendiente.getId() + ""));

			if (validarNumero(formatoReclamacionPendiente.getRpPolizaVigente() + "") != 0) {

				paramReclamacion.put("df_polizaVigente", true);

			} else {

				paramReclamacion.put("df_polizaVigente", false);

			}

			if (validarNumero(formatoReclamacionPendiente.getRpReciboPago() + "") != 0) {

				paramReclamacion.put("df_reciboPago", true);

			} else {

				paramReclamacion.put("df_reciboPago", false);

			}

			if (validarNumero(formatoReclamacionPendiente.getRpLicencia() + "") != 0) {

				paramReclamacion.put("df_licencia", true);

			} else {

				paramReclamacion.put("df_licencia", false);

			}

			if (validarNumero(formatoReclamacionPendiente.getRpDfEndoso() + "") != 0) {

				paramReclamacion.put("df_endoso", true);

			} else {

				paramReclamacion.put("df_endoso", false);

			}

			if (validarNumero(formatoReclamacionPendiente.getRpCopiaActaMp() + "") != 0) {

				paramReclamacion.put("df_copiaActa", true);

			} else {

				paramReclamacion.put("df_copiaActa", false);

			}

			if (validarNumero(formatoReclamacionPendiente.getRpOtros() + "") != 0) {

				paramReclamacion.put("df_otros", true);

			} else {

				paramReclamacion.put("df_otros", false);

			}

			paramReclamacion.put("endosoAclaratorio",
					validarCadena(formatoReclamacionPendiente.getRpObsEndosoAclara()));

			paramReclamacion.put("nombreConductor",
					validarCadena(formatoReclamacionPendiente.getRpNomConductor()));

			paramReclamacion.put("chUno", formatoReclamacionPendiente.getCheck1());

			paramReclamacion.put("chDos", formatoReclamacionPendiente.getCheck2());

			paramReclamacion.put("chTres", formatoReclamacionPendiente.getCheck3());

			paramReclamacion.put("chCuatro", formatoReclamacionPendiente.getCheck4());

			// ***FIRMA ELECTRONICA ASEGURADO**//

			String firma = formatoReclamacionPendiente.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramReclamacion.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA ASEGURADO**//

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String firma1 = formatoReclamacionPendiente.getFirmaAjustador();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramReclamacion.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String contenido = validarCadena(formatoReclamacionPendiente.getRpObservaciones());

			String nombreRenglon = "observaciones";

			String auxRenglon = "";

			int longitudRenglon = 120;

			int numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramReclamacion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramReclamacion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			} 
			
			
			paramReclamacion.put("datosOficina", formatoReclamacionPendiente.getRpDatosOficina().toUpperCase());
			
			paramReclamacion.put("chCinco", formatoReclamacionPendiente.getCheck5());

			paramReclamacion.put("chSeis", formatoReclamacionPendiente.getCheck6());
			
			
			crearArchivoError(FORMATO_RECLAMACION_PENDIENTE, fileJrxmlReclamacion, paramReclamacion,
					formatoReclamacionPendiente.getRpNumReporte(), formatoReclamacionPendiente.getRpNumPoliza(),
					"" + validarAsegurado(formatoReclamacionPendiente.getRpAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}

	}

	public void procesoAdmisionMotocicletasError(FormatoAdmisionMotocicletas formatoAdmisionMotocicletas,
			List<FormatoCatalogos> catalogo, OutputStream ou) {
		try {
			List<FormatoCatalogos> datosCatalogos = catalogo;
			fileJrxmlAdmisionMoto = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/OrdenDeAdmisionMotocicletas.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			String imgAdmisionMoto = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/admisionMotos.png").getFile().getPath();

			HashMap<String, Object> paramAdmisionMoto = new HashMap<String, Object>();

			paramAdmisionMoto.put("imgLogoQualitas", imgLogoQualitas);

			paramAdmisionMoto.put("imgAdmisionMoto", imgAdmisionMoto);

//			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			//DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoAdmisionMotocicletas.getOaFecha() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoAdmisionMotocicletas.getOaFecha()) + "");

				paramAdmisionMoto.put("fecha", writeFormatFecha.format(date));

				paramAdmisionMoto.put("hora", writeFormatHora.format(date) + " HRS");

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramAdmisionMoto.put("fecha", "");

				paramAdmisionMoto.put("hora", "");

			}

			if (formatoAdmisionMotocicletas.getOaEmailCliente() != null) {
				/////////////////
//				String poliza = formatoAdmisionMotocicletas.getOaNumPoliza();
//				String reporte = formatoAdmisionMotocicletas.getOaNumReporte();
//				String destinatario = "";
//				String nombreDoc = "Orden Admisión Motocicletas";
//				String cadenaCorreos = formatoAdmisionMotocicletas.getOaEmailCliente();
//				agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				//////////////////
			}

			paramAdmisionMoto.put("numReporte",
					validarCadena(formatoAdmisionMotocicletas.getOaNumReporte()));

			paramAdmisionMoto.put("numSiniestro",
					validarCadena(formatoAdmisionMotocicletas.getOaNumSiniestro()));

			paramAdmisionMoto.put("folio", validarCadena(formatoAdmisionMotocicletas.getId() + ""));

			paramAdmisionMoto.put("folioElectronico",
					validarCadena(formatoAdmisionMotocicletas.getOaFolioElectro()));

			if (validarNumero(
					validarAsegurado(formatoAdmisionMotocicletas.getOaAsegurado()) + "") == 1) {

				paramAdmisionMoto.put("asegurado", true);

			} else {

				paramAdmisionMoto.put("asegurado", false);

			}

			paramAdmisionMoto.put("numPoliza",
					validarCadena(formatoAdmisionMotocicletas.getOaNumPoliza()));

			paramAdmisionMoto.put("numEndoso",
					validarCadena(formatoAdmisionMotocicletas.getOaNumEndoso()));

			paramAdmisionMoto.put("numInciso",
					validarCadena(formatoAdmisionMotocicletas.getOaNumInciso()));

			paramAdmisionMoto.put("nombre",
					validarCadena(formatoAdmisionMotocicletas.getOaNomCliente()));

			paramAdmisionMoto.put("emailCliente",
					validarCadenaMail(formatoAdmisionMotocicletas.getOaEmailCliente()));

			paramAdmisionMoto.put("telefonoCliente",
					formatoNumero(validarCadena(formatoAdmisionMotocicletas.getOaTelCliente())));

			paramAdmisionMoto.put("razonSocial",
					validarCadena(formatoAdmisionMotocicletas.getOaRazonEnvio()));

			paramAdmisionMoto.put("responsable",
					validarCadena(formatoAdmisionMotocicletas.getOaRazonResponsable()));

			paramAdmisionMoto.put("telRazonSocial",
					formatoNumero(validarCadena(formatoAdmisionMotocicletas.getOaRazonTelefono())));

			paramAdmisionMoto.put("domRazonSocial",
					validarCadena(formatoAdmisionMotocicletas.getOaRazonDomicilio()));

			paramAdmisionMoto.put("coberturaRazon",
					validarCadena(formatoAdmisionMotocicletas.getOaRazonCobertura()));

			paramAdmisionMoto.put("tipoAuto",
					validarCadena(formatoAdmisionMotocicletas.getOaTipoAuto()));

			paramAdmisionMoto.put("marcaAuto",
					validarCadena(formatoAdmisionMotocicletas.getOaMarcaAuto()));

			paramAdmisionMoto.put("modeloAuto",
					validarCadena(formatoAdmisionMotocicletas.getOaModeloAuto()));

			paramAdmisionMoto.put("kilometraje",
					validarCadena(formatoAdmisionMotocicletas.getOaKilometraje()));

			paramAdmisionMoto.put("numSerie",
					validarCadena(formatoAdmisionMotocicletas.getOaNumSerie()));

			paramAdmisionMoto.put("colorAuto",
					validarCadena(formatoAdmisionMotocicletas.getOaColorAuto()));

			paramAdmisionMoto.put("placasAuto",
					validarCadena(formatoAdmisionMotocicletas.getOaPlacaAuto()));

			paramAdmisionMoto.put("chUno", formatoAdmisionMotocicletas.getCheck1());

			paramAdmisionMoto.put("chDos", formatoAdmisionMotocicletas.getCheck2());

			paramAdmisionMoto.put("chTres", formatoAdmisionMotocicletas.getCheck3());

			paramAdmisionMoto.put("chCuatro", formatoAdmisionMotocicletas.getCheck4());

			if (validarNumero(formatoAdmisionMotocicletas.getOaTManual() + "") == 1) {

				paramAdmisionMoto.put("transimisionManual", true);

			} else {

				paramAdmisionMoto.put("transimisionManual", false);

			}
			////////////////
			if (formatoAdmisionMotocicletas.getOaDeducible() != null) {
				if (formatoAdmisionMotocicletas.getOaDeducible() == 1) {
					paramAdmisionMoto.put("deducible", true);
				}

				if (formatoAdmisionMotocicletas.getOaDeducible() == 0) {
					paramAdmisionMoto.put("deducible", false);
				}
			}
			/////////

			paramAdmisionMoto.put("tipoDeducible",
					validarNumero(formatoAdmisionMotocicletas.getOaTipoDeducible() + ""));

			paramAdmisionMoto.put("sumaAsegurada",
					validarCadena(formatoAdmisionMotocicletas.getOaSumaAsegurada()));

			paramAdmisionMoto.put("porcentajeD",
					validarCadena(formatoAdmisionMotocicletas.getOaPorcentajeDed()));

			paramAdmisionMoto.put("cantidad",
					validarCadena(formatoAdmisionMotocicletas.getOaCantidad()));

			paramAdmisionMoto.put("deducibleAdministrativo",
					validarNumero(formatoAdmisionMotocicletas.getOaAdminDeducible() + ""));

			paramAdmisionMoto.put("nivel", formatoAdmisionMotocicletas.getOaNivelInundacion());

			// ***FIRMA ELECTRONICA ASEGURADO**//

			String firma = formatoAdmisionMotocicletas.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramAdmisionMoto.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA ASEGURADO**//

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String firma1 = formatoAdmisionMotocicletas.getFirmaAjustador();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramAdmisionMoto.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			if (validarNumero(formatoAdmisionMotocicletas.getOaPerdidaTotal() + "") == 1) {

				paramAdmisionMoto.put("perdidaTotal", true);

			}

			else {

				paramAdmisionMoto.put("perdidaTotal", false);

			}

			paramAdmisionMoto.put("descripcionPreexistentes",
					validarCadena(formatoAdmisionMotocicletas.getOaDaniosPre()));

			if (!validarCadena(formatoAdmisionMotocicletas.getOaDaniosPre()).equals(" ")) {

				paramAdmisionMoto.put("daniosPre", true);

			}

			else {

				paramAdmisionMoto.put("daniosPre", false);

			}

			String contenido = validarCadena(formatoAdmisionMotocicletas.getOaDescDanios())
					.replaceAll(",", ", ");

			paramAdmisionMoto.put("desDanios1", contenido);

			contenido = validarCadena(formatoAdmisionMotocicletas.getOaAgravamiento());
			paramAdmisionMoto.put("posAgravamiento1", contenido);
			

			paramAdmisionMoto.put("datosAjustador",
					validarCadena(formatoAdmisionMotocicletas.getOaClaveAjustador()) + " "
							+ validarCadena(formatoAdmisionMotocicletas.getOaNomAjustador()));

			String registradas = validarCadena(formatoAdmisionMotocicletas.getOaDaniosPre());

			String posibles = datosCatalogos.get(5).getValores();

			String[] reg = registradas.split(",");

			String[] pos = posibles.split(",");

			for (int i = 1; i <= pos.length; i++) {

				paramAdmisionMoto.put("pm" + (i), 0);

			}

			if (!registradas.equals(" ")) {

				for (int i = 0; i < pos.length; i++) {

					for (int j = 0; j < reg.length; j++) {

						if (pos[i].replaceAll(" ", "").equals(reg[j].replaceAll(" ", ""))) {

							paramAdmisionMoto.put("pm" + (i + 1), 1);

						}

					}

				}

			}

			registradas = validarCadena(formatoAdmisionMotocicletas.getOaDescDanios());

			posibles = datosCatalogos.get(5).getValores();

			String[] reg1 = registradas.split(",");

			String[] pos1 = posibles.split(",");

			for (int i = 1; i <= pos1.length; i++) {

				paramAdmisionMoto.put("sm" + (i), 0);

			}

			if (!registradas.equals(" ")) {

				for (int i = 0; i < pos1.length; i++) {

					for (int j = 0; j < reg1.length; j++) {

						if (pos1[i].replaceAll(" ", "").equals(reg1[j].replaceAll(" ", ""))) {

							paramAdmisionMoto.put("sm" + (i + 1), 1);

						}

					}

				}

			}
			
			// ***CODIGO QR**//

			String codigo = formatoAdmisionMotocicletas.getOaCodigoQr();						
			if (codigo != null && !codigo.isEmpty()) {
				InputStream targetcodigo = null;

				byte[] bytes1 = Base64Decoder.decode(codigo);

				targetcodigo = new ByteArrayInputStream(bytes1);
				paramAdmisionMoto.put("codigoQR", targetcodigo);
			}
			
			if (formatoAdmisionMotocicletas.getOaPtEvidente() != null) {

				paramAdmisionMoto.put("ptEvidente", formatoAdmisionMotocicletas.getOaPtEvidente());

			}
			
			if (formatoAdmisionMotocicletas.getOaAbandono() != null) {

				paramAdmisionMoto.put("abandono", formatoAdmisionMotocicletas.getOaAbandono());

			}
			paramAdmisionMoto.put("chCinco", formatoAdmisionMotocicletas.getCheck5());

			paramAdmisionMoto.put("chSeis", formatoAdmisionMotocicletas.getCheck6());
			
			crearArchivoError(FORMATO_ADMISION_MOTOCICLETAS, fileJrxmlAdmisionMoto, paramAdmisionMoto,
					formatoAdmisionMotocicletas.getOaNumReporte(), formatoAdmisionMotocicletas.getOaNumPoliza(),
					"" + validarAsegurado(formatoAdmisionMotocicletas.getOaAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	// ADMISION PESADO
	@SuppressWarnings("unused")
	public void procesoAdmisionPesadoError(FormatoAdmisionPesado formatoAdmisionPesado, List<FormatoCatalogos> catalogo,
			OutputStream ou) {
		try {
			List<FormatoCatalogos> datosCatalogos = catalogo;

			fileJrxmlAdmisionPesado = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/OrdenDeAdmisionPesadoCompleto.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			String imgCamion = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/camion.PNG").getFile().getPath();

			String imgTanque = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/tanque.PNG").getFile().getPath();

			String imgCaja = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/caja.PNG").getFile().getPath();

			HashMap<String, Object> paramPesado = new HashMap<String, Object>();

			paramPesado.put("imgLogoQualitas", imgLogoQualitas);

			paramPesado.put("imaCamion", imgCamion);

			paramPesado.put("imgTanque", imgTanque);

			paramPesado.put("imgCaja", imgCaja);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();
			Date vig = new Date();

			if (formatoAdmisionPesado.getOfFecha() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoAdmisionPesado.getOfFecha()) + "");

				// datosEmail.setFecha(writeFormatFecha.format(date));

				Calendar calendar = Calendar.getInstance();

				calendar.setTime(date);

				calendar.add(Calendar.DAY_OF_YEAR, 7);

				vig = readFormat.parse(
						new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(calendar.getTime()) + "");

				paramPesado.put("fecha", writeFormatFecha.format(date) + "");

				paramPesado.put("hora", writeFormatHora.format(date) + " HRS");

				paramPesado.put("vigencia", writeFormatFecha.format(vig));

			} else {

				paramPesado.put("fecha", "");

				paramPesado.put("hora", "");

				paramPesado.put("vigencia", "");

			}

			if (formatoAdmisionPesado.getEmailDefault() != null) {

				///////////////////
				String poliza = formatoAdmisionPesado.getOpNumPoliza();
				String reporte = formatoAdmisionPesado.getOpNumReporte();
				String destinatario = "";
				String nombreDoc = "Admisión Vehículos Pesados";
				String cadenaCorreos = formatoAdmisionPesado.getEmailDefault();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				paramPesado.put("correoDef", formatoAdmisionPesado.getEmailDefault());
				////////////////////

			}

			paramPesado.put("numFolio", validarCadena(formatoAdmisionPesado.getId() + ""));

			paramPesado.put("folioElectronico",
					validarCadena(formatoAdmisionPesado.getOpFolioElectro()));

			paramPesado.put("numSiniestro", validarCadena(formatoAdmisionPesado.getOpNumSiniestro()));

			paramPesado.put("numReporte", validarCadena(formatoAdmisionPesado.getOpNumReporte()));

			paramPesado.put("numPoliza", validarCadena(formatoAdmisionPesado.getOpNumPoliza()));

			paramPesado.put("numInciso", validarCadena(formatoAdmisionPesado.getOpNumInciso()));

			paramPesado.put("numEndoso", validarCadena(formatoAdmisionPesado.getOpNumEndoso()));

			if (formatoAdmisionPesado.getNiu() != null) {

				paramPesado.put("niu", formatoAdmisionPesado.getNiu() + "");

			}

			paramPesado.put("nomAsegurado", validarCadena(formatoAdmisionPesado.getOpNomAsegurado()));

			paramPesado.put("telAsegurado",
					formatoNumero(validarCadena(formatoAdmisionPesado.getOpTelAsegurado())));

			paramPesado.put("nomConductor", validarCadena(formatoAdmisionPesado.getOpConductorAse()));

			paramPesado.put("telConductor",
					formatoNumero(validarCadena(formatoAdmisionPesado.getOpTelConAse())));

			paramPesado.put("marcaAsegurado", validarCadena(formatoAdmisionPesado.getOpMarcaAutoAse()));

			paramPesado.put("tipoAsegurado", validarCadena(formatoAdmisionPesado.getOpTipoAutoAse()));

			paramPesado.put("modeloAsegurado", validarCadena(formatoAdmisionPesado.getOpModeloAse()));

			paramPesado.put("colorAsegurado", validarCadena(formatoAdmisionPesado.getOpColorAutoAse()));

			paramPesado.put("placasAsegurado",
					validarCadena(formatoAdmisionPesado.getOpPlacasAutoAse()));

			paramPesado.put("motorAsegurado", validarCadena(formatoAdmisionPesado.getOpMotorAutoAse()));

			paramPesado.put("serieAsegurado", validarCadena(formatoAdmisionPesado.getOpSerieAutoAse()));

			paramPesado.put("sumaAsegurado", validarCadena(formatoAdmisionPesado.getOpSumaAsegurado()));

			paramPesado.put("nomTercero", validarCadena(formatoAdmisionPesado.getOpNomAfe()));

			paramPesado.put("telTercero",
					formatoNumero(validarCadena(formatoAdmisionPesado.getOpTelAfe())));

			paramPesado.put("nomConductorT", validarCadena(formatoAdmisionPesado.getOpConductorAfe()));

			paramPesado.put("telConductorT",
					formatoNumero(validarCadena(formatoAdmisionPesado.getOpTelConAfe())));

			paramPesado.put("marcaTercero", validarCadena(formatoAdmisionPesado.getOpMarcaAutoAfe()));

			paramPesado.put("tipoTercero", validarCadena(formatoAdmisionPesado.getOpTipoAutoAfe()));

			paramPesado.put("modeloTercero", validarCadena(formatoAdmisionPesado.getOpModeloTer()));

			paramPesado.put("colorTercero", validarCadena(formatoAdmisionPesado.getOpColorAutoAfe()));

			paramPesado.put("placasTercero", validarCadena(formatoAdmisionPesado.getOpPlacasAutoAfe()));

			paramPesado.put("motorTercero", validarCadena(formatoAdmisionPesado.getOpMotorAutoAfe()));

			paramPesado.put("serieTercero", validarCadena(formatoAdmisionPesado.getOpSerieAutoAfe()));

			paramPesado.put("chUno", formatoAdmisionPesado.getCheck1());

			paramPesado.put("chDos", formatoAdmisionPesado.getCheck2());

			paramPesado.put("chTres", formatoAdmisionPesado.getCheck3());

			paramPesado.put("chCuatro", formatoAdmisionPesado.getCheck4());

			// ***FIRMA ELECTRONICA ASEGURADO**//

			String firma = formatoAdmisionPesado.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramPesado.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA ASEGURADO**//

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String firma1 = formatoAdmisionPesado.getFirmaAjustador();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramPesado.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			if (formatoAdmisionPesado.getOpDeducible() != null) {
				if (formatoAdmisionPesado.getOpDeducible() == 0) {
					paramPesado.put("deducible", false);
				}

				if (formatoAdmisionPesado.getOpDeducible() == 1) {
					paramPesado.put("deducible", true);
				}
			}

			paramPesado.put("tipoDeducible",
					validarNumero(formatoAdmisionPesado.getOpTipoDeducible() + ""));

			paramPesado.put("valorDeducible", validarCadena(formatoAdmisionPesado.getOpDedDias()));

			paramPesado.put("porcentajeD", validarCadena(formatoAdmisionPesado.getOpDefinicion()));

			paramPesado.put("cantidad", validarCadena(formatoAdmisionPesado.getOpCantidad()));

			if (formatoAdmisionPesado.getOpDedAdmin() != null) {
				if (formatoAdmisionPesado.getOpDedAdmin() == 1) {
					paramPesado.put("sipac", true);
				}

				if (formatoAdmisionPesado.getOpDedAdmin() == 0) {
					paramPesado.put("sipac", false);
				}
			}

			paramPesado.put("nomTaller", validarCadena(formatoAdmisionPesado.getOpNomTaller()));

			paramPesado.put("telTaller",
					formatoNumero(validarCadena(formatoAdmisionPesado.getOpTelTaller())));

			paramPesado.put("dirTaller", validarCadena(formatoAdmisionPesado.getOpDirTaller()));

			paramPesado.put("atenTaller", validarCadena(formatoAdmisionPesado.getOpAtencionTaller()));

			for (int i = 1; i <= 16; i++) {

				paramPesado.put("a" + i, false);

			}

			for (int i = 1; i <= 17; i++) {

				paramPesado.put("c" + i, false);

			}

			for (int i = 1; i <= 15; i++) {

				paramPesado.put("t" + i, false);

			}

			String[] idRegistradas;

			String[] idPosibles;

			String idPos;

			String idReg = validarCadena(formatoAdmisionPesado.getOpDaniosCamion());

			boolean esOtra = true;

			String otrasPartes = "";

			if (!idReg.equals(" ")) {

				idPos = datosCatalogos.get(4).getValores();

				idRegistradas = idReg.split(",");

				idPosibles = idPos.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas.length; i++) {

					for (int j = 0; j < idPosibles.length; j++)

					{

						if (idRegistradas[i].replaceAll(" ", "").equalsIgnoreCase(idPosibles[j])) {

							paramPesado.put("a" + ((int) j + 1), true);

							esOtra = false;

						}

					}

					if (esOtra == true) {

						otrasPartes = otrasPartes + ", " + idRegistradas[i];

					}

					esOtra = true;

				}

				if (otrasPartes.replace(" ", "").length() > 3) {

					String contenido = otrasPartes.substring(1, otrasPartes.length());

					String nombreRenglon = "otrosCamion";

					String auxRenglon = "";

					int longitudRenglon = 40;

					int numeroRenglones = 4;

					if ((longitudRenglon * numeroRenglones) < contenido.length()) {

						contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

					}

					float renglonesUsados = (float) contenido.length() / longitudRenglon;

					int inicio = 0;

					int fin = longitudRenglon;

					for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

						if (i != ((int) Math.ceil(renglonesUsados))) {

							auxRenglon = buscarBlank(contenido, inicio, fin);

							paramPesado.put(nombreRenglon + i, auxRenglon);

							inicio = inicio + auxRenglon.length();

							fin = (i + 1) * longitudRenglon;

							auxRenglon = "";

						} else {

							auxRenglon = contenido.substring(inicio, contenido.length());

							paramPesado.put(nombreRenglon + i, auxRenglon);

							inicio = inicio + auxRenglon.length();

							fin = (i + 1) * longitudRenglon;

							auxRenglon = "";

						}

					}

				}

			}

			idReg = validarCadena(formatoAdmisionPesado.getOpDaniosCaja());

			esOtra = true;

			otrasPartes = "";

			if (!idReg.equals(" ")) {

//				idPos = idPos = datosCatalogos.get(3).getValores();
				idPos = datosCatalogos.get(3).getValores();

				idRegistradas = idReg.split(",");

				idPosibles = idPos.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas.length; i++) {

					for (int j = 0; j < idPosibles.length; j++)

					{

						if (idRegistradas[i].replaceAll(" ", "").equalsIgnoreCase(idPosibles[j])) {

							if (j > 11) { // le cambie de 12 a 11

								paramPesado.put("c" + ((int) j), true);

								esOtra = false;

							} else {

								paramPesado.put("c" + ((int) j + 1), true);

								esOtra = false;

							}

						}

					}

					if (esOtra == true) {

						otrasPartes = otrasPartes + ", " + idRegistradas[i];

					}

					esOtra = true;

				}

				if (otrasPartes.replace(" ", "").length() > 3) {

					if (otrasPartes.replace(" ", "").length() > 3) {

						String contenido = otrasPartes.substring(1, otrasPartes.length());

						String nombreRenglon = "otrosCaja";

						String auxRenglon = "";

						int longitudRenglon = 40;

						int numeroRenglones = 4;

						if ((longitudRenglon * numeroRenglones) < contenido.length()) {

							contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

						}

						float renglonesUsados = (float) contenido.length() / longitudRenglon;

						int inicio = 0;

						int fin = longitudRenglon;

						for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

							if (i != ((int) Math.ceil(renglonesUsados))) {

								auxRenglon = buscarBlank(contenido, inicio, fin);

								paramPesado.put(nombreRenglon + i, auxRenglon);

								inicio = inicio + auxRenglon.length();

								fin = (i + 1) * longitudRenglon;

								auxRenglon = "";

							} else {

								auxRenglon = contenido.substring(inicio, contenido.length());

								paramPesado.put(nombreRenglon + i, auxRenglon);

								inicio = inicio + auxRenglon.length();

								fin = (i + 1) * longitudRenglon;

								auxRenglon = "";

							}

						}

					}

				}

			}

			idReg = validarCadena(formatoAdmisionPesado.getOpDaniosTanque());

			esOtra = true;

			otrasPartes = "";

			if (!idReg.equals(" ")) {

//				idPos = idPos = datosCatalogos.get(2).getValores();
				idPos = datosCatalogos.get(2).getValores();

				idRegistradas = idReg.split(",");

				idPosibles = idPos.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas.length; i++) {

					for (int j = 0; j < idPosibles.length; j++)

					{

						if (idRegistradas[i].replaceAll(" ", "").equalsIgnoreCase(idPosibles[j])) {

							if (j > 12) {

								paramPesado.put("t" + ((int) j), true);

								esOtra = false;

							} else {

								paramPesado.put("t" + ((int) j + 1), true);

								esOtra = false;

							}

						}

					}

					if (esOtra == true) {

						otrasPartes = otrasPartes + ", " + idRegistradas[i];

					}

					esOtra = true;

				}

				if (otrasPartes.replace(" ", "").length() > 3) {

					String contenido = otrasPartes.substring(1, otrasPartes.length());

					String nombreRenglon = "otrosTanque";

					String auxRenglon = "";

					int longitudRenglon = 40;

					int numeroRenglones = 3;

					if ((longitudRenglon * numeroRenglones) < contenido.length()) {

						contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

					}

					float renglonesUsados = (float) contenido.length() / longitudRenglon;

					int inicio = 0;

					int fin = longitudRenglon;

					for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

						if (i != ((int) Math.ceil(renglonesUsados))) {

							auxRenglon = buscarBlank(contenido, inicio, fin);

							paramPesado.put(nombreRenglon + i, auxRenglon);

							inicio = inicio + auxRenglon.length();

							fin = (i + 1) * longitudRenglon;

							auxRenglon = "";

						} else {

							auxRenglon = contenido.substring(inicio, contenido.length());

							paramPesado.put(nombreRenglon + i, auxRenglon);

							inicio = inicio + auxRenglon.length();

							fin = (i + 1) * longitudRenglon;

							auxRenglon = "";

						}

					}

				}
			}

			//// segundo

			paramPesado.put("datosAjustador", validarCadena(formatoAdmisionPesado.getOpClaveAjustador())
					+ " " + validarCadena(formatoAdmisionPesado.getOpNomAjustador()));

			

			for (int i = 1; i <= 16; i++) {

				paramPesado.put("ad" + i, false);

			}

			for (int i = 1; i <= 17; i++) {

				paramPesado.put("cd" + i, false);

			}

			for (int i = 1; i <= 15; i++) {

				paramPesado.put("td" + i, false);

			}

			
			String idReg1;

			String idPos1;

			String[] idRegistradas1;

			String[] idPosibles1;

			idReg1 = validarCadena(formatoAdmisionPesado.getOpSiniestroCamion());
			List<Integer> listaOcupadosCamion = new ArrayList<Integer>();
			String[] entradaCamion =idReg1.split(",");
			List<String> listaCamion = new ArrayList<String>();
			String siniestroOtroCamion="";

			if (!idReg1.equals(" ")) {

				idPos1 = idPos = datosCatalogos.get(4).getValores();

				idRegistradas1 = idReg1.replaceAll(" ", "").split(",");

				idPosibles1 = idPos1.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas1.length; i++) {

					for (int j = 0; j < idPosibles1.length; j++)

					{

						if (idRegistradas1[i].equalsIgnoreCase(idPosibles1[j])) {

							paramPesado.put("ad" + ((int) j + 1), true);
							listaOcupadosCamion.add(i);		

						}

					}

				}
				
				for(int l=0; l<entradaCamion.length; l++) {
					listaCamion.add(entradaCamion[l]);
					}
						
				for(int k=0; k<listaOcupadosCamion.size(); k++) {
					int pos =listaOcupadosCamion.get(k)-k;
                    listaCamion.remove(pos);
                    }
				
				 for(String s : listaCamion)
			        {
					 siniestroOtroCamion+= s + ",";
			        }
				 paramPesado.put("otrosSiniestroCamion", siniestroOtroCamion+"");
				
				

			}

			////Siniestro caja
			idReg1 = validarCadena(formatoAdmisionPesado.getOpSiniestroCaja());
			List<Integer> listaOcupadosCaja = new ArrayList<Integer>();
			String[] entradaCaja =idReg1.split(",");
			List<String> listaCaja = new ArrayList<String>();
			String siniestroOtroCaja="";

			if (!idReg1.equals(" ")) {

				idPos1 = idPos = datosCatalogos.get(3).getValores();

				idRegistradas1 = idReg1.replaceAll(" ", "").split(",");

				idPosibles1 = idPos1.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas1.length; i++) {

					for (int j = 0; j < idPosibles1.length; j++)

					{

						if (idRegistradas1[i].equalsIgnoreCase(idPosibles1[j])) {

							if (j > 11) { // dato original 12

								paramPesado.put("cd" + ((int) j), true);
								listaOcupadosCaja.add(i);		

								esOtra = false;

							} else {

								paramPesado.put("cd" + ((int) j + 1), true);
								listaOcupadosCaja.add(i);		

								esOtra = false;

							}

						}

					}

				}
				
				for(int l=0; l<entradaCaja.length; l++) {
					listaCaja.add(entradaCaja[l]);
					}
						
				for(int k=0; k<listaOcupadosCaja.size(); k++) {
					int pos =listaOcupadosCaja.get(k)-k;
                    listaCaja.remove(pos);
                    }
				
				 for(String s : listaCaja)
			        {
					 siniestroOtroCaja+= s + ",";
			        }
				 paramPesado.put("otrosSiniestroCaja", siniestroOtroCaja+"");
			}

			//siniestro tanque
			idReg1 = validarCadena(formatoAdmisionPesado.getOpSiniestroTanque());
			List<Integer> listaOcupadosTanque = new ArrayList<Integer>();
			String[] entradaTanque =idReg1.split(",");
			List<String> listaTanque = new ArrayList<String>();
			String siniestroOtroTanque="";

			if (!idReg1.equals(" ")) {

				idPos1 = idPos = datosCatalogos.get(2).getValores();

				idRegistradas1 = idReg1.replaceAll(" ", "").split(",");

				idPosibles1 = idPos1.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas1.length; i++) {

					for (int j = 0; j < idPosibles1.length; j++)

					{

						if (idRegistradas1[i].equalsIgnoreCase(idPosibles1[j])) {

							if (j > 12) {

								paramPesado.put("td" + ((int) j), true);
								listaOcupadosTanque.add(i);		

								esOtra = false;

							} else {

								paramPesado.put("td" + ((int) j + 1), true);
								listaOcupadosTanque.add(i);		

								esOtra = false;

							}

						}

					}

				}
				
				for(int l=0; l<entradaTanque.length; l++) {
					listaTanque.add(entradaTanque[l]);
					}
						
				for(int k=0; k<listaOcupadosTanque.size(); k++) {
					int pos =listaOcupadosTanque.get(k)-k;
                    listaTanque.remove(pos);
                    }
				
				 for(String s : listaTanque)
			        {
					 siniestroOtroTanque+= s + ",";
			        }
				 paramPesado.put("otrosSiniestroTanque", siniestroOtroTanque+"");

			}
			
			//cmbio de firma de tercero o asegurado					
										
			paramPesado.put("datosAsegurado", 
				validarAsegurado(formatoAdmisionPesado.getOpAsegurado())==1?
						validarCadena(formatoAdmisionPesado.getOpNomAsegurado()):
						validarCadena(formatoAdmisionPesado.getOpNomAfe())
						);

			
			String codigo = formatoAdmisionPesado.getOpCodigoQr();						
			if (codigo != null && !codigo.isEmpty()) {
				InputStream targetcodigo = null;

				byte[] bytes1 = Base64Decoder.decode(codigo);

				targetcodigo = new ByteArrayInputStream(bytes1);
				paramPesado.put("codigoQR", targetcodigo);
			}
			
			if (formatoAdmisionPesado.getOpPtEvidente() != null) {

				paramPesado.put("ptEvidente", formatoAdmisionPesado.getOpPtEvidente());

			}
			
			if (formatoAdmisionPesado.getOpAbandono() != null) {

				paramPesado.put("abandono", formatoAdmisionPesado.getOpAbandono());

			}
			paramPesado.put("chCinco", formatoAdmisionPesado.getCheck5());

			paramPesado.put("chSeis", formatoAdmisionPesado.getCheck6());
			
			crearArchivoError(FORMATO_ADMISION_PESADO, fileJrxmlAdmisionPesado, paramPesado,
					formatoAdmisionPesado.getOpNumReporte(), formatoAdmisionPesado.getOpNumPoliza(),
					"" + validarAsegurado(formatoAdmisionPesado.getOpAsegurado()), ou);

		} catch (Exception ex) {
		}
	}

	// dua
	@SuppressWarnings("unused")
	public void procesoDeclaracionUniversalCompletoError(FormatoDeclaracionUniversal formatoDeclaracionUniversal,
			OutputStream ou) {

		try {

			fileJrxmlDeclaracionContent = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/DeclaracionUniversalCompleto.jrxml").getFile());

			fileJrxmlDeclaracionMail = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/DeclaracionUniversalCompleto.jrxml").getFile());

			fileJrxmlDeclaracionMailB = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/DeclaracionUniversalCompleto.jrxml").getFile());

			String imgDeclaracion = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/declaracion.PNG").getFile().getPath();
			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			// PARAMETROS PARA PDF CONTENT//

			HashMap<String, Object> paramDeclaracion = new HashMap<String, Object>();

			paramDeclaracion.put("imgDeclaracion", imgDeclaracion);
			paramDeclaracion.put("imgLogoQualitas", imgLogoQualitas);

		

			if (formatoDeclaracionUniversal.getDuFechaOcurrido() != null) {

				Date ocurridoDate = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuFechaOcurrido()) + "");

				paramDeclaracion.put("fechaOcurrido", writeFormatFecha.format(ocurridoDate));

				paramDeclaracion.put("horaOcurrido", writeFormatHora.format(ocurridoDate));

				// datosEmail.setFecha(writeFormatFecha.format(ocurridoDate));

			} else {

				paramDeclaracion.put("fechaOcurrido", "");

				paramDeclaracion.put("horaOcurrido", "");

			}

			if (formatoDeclaracionUniversal.getDuEmailConductor() != null) {

				////////////////
				String poliza = validarCadena(formatoDeclaracionUniversal.getDuNumPoliza());
				String reporte = validarCadena(formatoDeclaracionUniversal.getDuNumReporte());
				String destinatario = "";
				String nombreDoc = "Declaración Universal del Accidente";
				String cadenaCorreos = formatoDeclaracionUniversal.getDuEmailConductor();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////

			}

			if (formatoDeclaracionUniversal.getDuDescripcionCroquis() != null) {
				paramDeclaracion.put("descripcionCroquis",
						formatoDeclaracionUniversal.getDuDescripcionCroquis());
			}

			if (formatoDeclaracionUniversal.getDuFechaAtencion() != null) {

				Date atencionDate = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuFechaAtencion()) + "");

				paramDeclaracion.put("fechaAtencion", writeFormatFecha.format(atencionDate));

			} else {

				paramDeclaracion.put("fechaAtencion", "");

			}

			if (formatoDeclaracionUniversal.getDuArriboAjustador() != null) {

				Date arriboDate = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuArriboAjustador()) + "");

				paramDeclaracion.put("horaArribo", writeFormatHora.format(arriboDate) + " HRS");

			} else {

				paramDeclaracion.put("horaArribo", "");

			}

			if (formatoDeclaracionUniversal.getDuTerminoAjustador() != null) {

				Date terminoDate = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuTerminoAjustador()) + "");

				paramDeclaracion.put("horaTermino", writeFormatHora.format(terminoDate) + " HRS");

			} else {

				paramDeclaracion.put("horaTermino", "");

			}

			if (formatoDeclaracionUniversal.getDuFechaOcurridoB() != null) {

				Date ocurridoDateB = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuFechaOcurridoB()) + "");

				paramDeclaracion.put("fechaOcurrido_B", writeFormatFecha.format(ocurridoDateB));

				paramDeclaracion.put("horaOcurrido_B", writeFormatHora.format(ocurridoDateB));

				// datosEmailB.setFecha(writeFormatFecha.format(ocurridoDateB));

			} else {

				paramDeclaracion.put("fechaOcurrido_B", "");

				paramDeclaracion.put("horaOcurrido_B", "");

			}



			if (formatoDeclaracionUniversal.getDuEmailConductorB() != null) {

				////////////////
				String poliza = validarCadena(formatoDeclaracionUniversal.getDuNumPolizaB());
				String reporte = validarCadena(formatoDeclaracionUniversal.getDuNumReporteB());
				String destinatario = "";
				String nombreDoc = "Declaración Universal del Accidente";
				String cadenaCorreos = formatoDeclaracionUniversal.getDuEmailConductorB();
				//agregaCorreosB(correosB, cadenaCorreos, poliza, reporte, destinatario, nombreDoc, null);
				////////////////

			}

			if (formatoDeclaracionUniversal.getDuFechaAtencionB() != null) {

				Date atencionDateB = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuFechaAtencionB()) + "");

				paramDeclaracion.put("fechaAtencion_B", writeFormatFecha.format(atencionDateB));

			} else {

				paramDeclaracion.put("fechaAtencion_B", "");

			}

			if (formatoDeclaracionUniversal.getDuArriboAjustadorB() != null) {

				Date arriboDateB = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuArriboAjustadorB()) + "");

				paramDeclaracion.put("horaArribo_B", writeFormatHora.format(arriboDateB) + " HRS");

			} else {

				paramDeclaracion.put("horaArribo_B", "");

			}

			if (formatoDeclaracionUniversal.getDuTerminoAjustadorB() != null) {

				Date terminoDateB = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuTerminoAjustadorB()) + "");

				paramDeclaracion.put("horaTermino_B", writeFormatHora.format(terminoDateB) + " HRS");

			} else {

				paramDeclaracion.put("horaTermino_B", "");

			}

			if (formatoDeclaracionUniversal.getDuVigenciaDe() != null) {

				Date vigenciaA = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuVigenciaDe()) + "");

				paramDeclaracion.put("vigilancia", writeFormatFecha.format(vigenciaA));

			} else {

				paramDeclaracion.put("vigilancia", "");

			}

			if (formatoDeclaracionUniversal.getDuVigenciaDeB() != null) {

				Date vigenciaB = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuVigenciaDeB()) + "");

				paramDeclaracion.put("vigilancia_B", writeFormatFecha.format(vigenciaB));

			} else {

				paramDeclaracion.put("vigilancia_B", "");

			}

			if (formatoDeclaracionUniversal.getDuVigenciaAl() != null) {

				Date alA = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuVigenciaAl()) + "");

				paramDeclaracion.put("al", writeFormatFecha.format(alA));

			} else {

				paramDeclaracion.put("al", "");

			}

			if (formatoDeclaracionUniversal.getDuVigenciaAlB() != null) {

				Date alB = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuVigenciaAlB()) + "");

				paramDeclaracion.put("al_B", writeFormatFecha.format(alB));

			} else {

				paramDeclaracion.put("al_B", "");

			}

			if (formatoDeclaracionUniversal.getDuCaducidadLicencia() != null) {

				Date caducidadA = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuCaducidadLicencia()) + "");

				paramDeclaracion.put("validoHasta", writeFormatFecha.format(caducidadA));

			} else {

				paramDeclaracion.put("validoHasta", "");

			}

			if (formatoDeclaracionUniversal.getDuCaducidadLicenciaB() != null) {

				Date caducidadB = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuCaducidadLicenciaB()) + "");

				paramDeclaracion.put("validoHasta_B", writeFormatFecha.format(caducidadB));

			} else {

				paramDeclaracion.put("validoHasta_B", "");

			}

			// ***INICIA CROQUIS***//

			String croquis = formatoDeclaracionUniversal.getDuCroquis();

			InputStream targetCroquis = null;

			if (croquis != null && !croquis.isEmpty()) {

				byte[] bytesCroquis = Base64Decoder.decode(croquis);

				targetCroquis = new ByteArrayInputStream(bytesCroquis);

			}

			paramDeclaracion.put("imgCroquis", targetCroquis);

			// ***CIERRE CROQUIS***//
			// CALCAS

			String calcaA = formatoDeclaracionUniversal.getDuCalcaA();

			InputStream targetCalcaA = null;

			if (calcaA != null && !calcaA.isEmpty()) {

				byte[] bytesCalcaA = Base64Decoder.decode(calcaA);

				targetCalcaA = new ByteArrayInputStream(bytesCalcaA);

			}

			paramDeclaracion.put("calcaA", targetCalcaA);
			// calca B
			String calcaB = formatoDeclaracionUniversal.getDuCalcaB();

			InputStream targetCalcaB = null;

			if (calcaB != null && !calcaB.isEmpty()) {

				byte[] bytesCalcaB = Base64Decoder.decode(calcaB);

				targetCalcaB = new ByteArrayInputStream(bytesCalcaB);

			}

			paramDeclaracion.put("calcaB", targetCalcaB);

			//NUEVAS VARIABLES
			String contenido = "";
			String nombreRenglon ="";
			String auxRenglon = "";
			int longitudRenglon = 0;
			int numeroRenglones = 0;
			float renglonesUsados = (float) contenido.length() / longitudRenglon;
			int inicio = 0;
			int fin = longitudRenglon;


			//nuevo LUGAR
			paramDeclaracion.put("lugar1", validarCadenaDUA(formatoDeclaracionUniversal.getDuLugar()));
			
			paramDeclaracion.put("nomCia", validarCadenaDUA(formatoDeclaracionUniversal.getDuNomCia()));

			paramDeclaracion.put("numSiniestro",
					validarCadena(formatoDeclaracionUniversal.getDuNumSiniestro()));

			paramDeclaracion.put("numReporte",
					validarCadena(formatoDeclaracionUniversal.getDuNumReporte()));

			paramDeclaracion.put("cobertura",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuCobertura()));

			paramDeclaracion.put("cobranza",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuCobranza()));

			paramDeclaracion.put("inc", validarCadena(formatoDeclaracionUniversal.getDuInc()));

			paramDeclaracion.put("chUno", formatoDeclaracionUniversal.getCheck1());

			paramDeclaracion.put("chDos", formatoDeclaracionUniversal.getCheck2());

			paramDeclaracion.put("chTres", formatoDeclaracionUniversal.getCheck3());

			paramDeclaracion.put("chCuatro", formatoDeclaracionUniversal.getCheck4());

		//	String observacion = validarCadena(formatoDeclaracionUniversal.getDuNomAsegurado());
			paramDeclaracion.put("nomAsegurado", "NOMBRE / NAME: " +validarCadenaDUA(formatoDeclaracionUniversal.getDuNomAsegurado())+ "");


			paramDeclaracion.put("telAsegurado", "TELEFONO/PHONE: "
					+ formatoNumero(validarCadena(formatoDeclaracionUniversal.getDuTelAsegurado())));

			paramDeclaracion.put("nomConductor",
					"NOMBRE/NAME: " + validarCadenaDUA(formatoDeclaracionUniversal.getDuNomConductor()));

			paramDeclaracion.put("edadConductor", "EDAD/AGE: "
					+ validarCadenaDUA(formatoDeclaracionUniversal.getDuEdadConductor()) + " AÑOS/YEARS");

			paramDeclaracion.put("firmaConductor", (formatoDeclaracionUniversal.getDuNomConductor()));

			paramDeclaracion.put("firmaConductorB", (formatoDeclaracionUniversal.getDuNomConductorB()));

			

			//nuevo direccion conductor						
			paramDeclaracion.put("dirConductor1",validarCadenaDUA(formatoDeclaracionUniversal.getDuDirConductor()));
			
			paramDeclaracion.put("folioInforme",
					validarCadena(formatoDeclaracionUniversal.getDuFolioInforme()));

			paramDeclaracion.put("telConductor", "TELEFONO/PHONE: "
					+ formatoNumero(validarCadena(formatoDeclaracionUniversal.getDuTelConductor())));

			paramDeclaracion.put("mailConductor",
					"EMAIL/EMAIL: " + validarCadenaMail(formatoDeclaracionUniversal.getDuEmailConductor()));

			paramDeclaracion.put("numLicConductor",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuLicenciaNum()));

			paramDeclaracion.put("edoLicConductor",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuLicenciaEstado()));

			paramDeclaracion.put("tipoLicConductor",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuTipoLicencia()));

			paramDeclaracion.put("marcaAuto",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuMarcaAuto()));

			paramDeclaracion.put("modeloAuto",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuModeloAutoA()));

			paramDeclaracion.put("placasAuto",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuPlacasAuto()));

			paramDeclaracion.put("tipoAuto",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuTipoAuto()));

			paramDeclaracion.put("colorAuto",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuColorAuto()));

			paramDeclaracion.put("usoAuto", validarCadenaDUA(formatoDeclaracionUniversal.getDuUsoAutoA()));

			paramDeclaracion.put("serieAuto", validarCadenaDUA(formatoDeclaracionUniversal.getDuSerie()));

			paramDeclaracion.put("narracion1",
					validarCadena(formatoDeclaracionUniversal.getDuNarracion()));

		

			contenido = validarCadena(formatoDeclaracionUniversal.getDuDaniosApre());

			nombreRenglon = "daniosA";

			auxRenglon = "";

			longitudRenglon = 30;

			numeroRenglones = 7;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramDeclaracion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramDeclaracion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoDeclaracionUniversal.getDuDaniosPre());

			nombreRenglon = "daniosP";

			auxRenglon = "";

			longitudRenglon = 27;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramDeclaracion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramDeclaracion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramDeclaracion.put("ajustador1A",
					validarCadena(formatoDeclaracionUniversal.getDuNomAjustador()));

			paramDeclaracion.put("claveA",
					validarCadena(formatoDeclaracionUniversal.getDuClaveAjustador()));

			///////////////////////////////////// PARA B

			//NUEVO LUGAR B
			paramDeclaracion.put("lugar1_B",validarCadenaDUA(formatoDeclaracionUniversal.getDuLugarB()));
			
			paramDeclaracion.put("nomCia_B", validarCadenaDUA(formatoDeclaracionUniversal.getDuNomCiaB()));

			paramDeclaracion.put("numSiniestro_B",
					validarCadena(formatoDeclaracionUniversal.getDuNumSiniestroB()));

			paramDeclaracion.put("numReporte_B",
					validarCadena(formatoDeclaracionUniversal.getDuNumReporteB()));

			paramDeclaracion.put("cobertura_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuCoberturaB()));

			paramDeclaracion.put("cobranza_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuCobranzaB()));

			paramDeclaracion.put("inc_B", validarCadena(formatoDeclaracionUniversal.getDuIncB()));

			//NUEVO NOMBRE ASEGURADO
			paramDeclaracion.put("nomAsegurado_B", "NOMBRE/NAME: " +validarCadenaDUA(formatoDeclaracionUniversal.getDuNomAseguradoB())+ "");

			paramDeclaracion.put("telAsegurado_B", "TELEFONO/PHONE: "
					+ formatoNumero(validarCadena(formatoDeclaracionUniversal.getDuTelAseguradoB())));

			paramDeclaracion.put("nomConductor_B",
					"NOMBRE/NAME: " + validarCadenaDUA(formatoDeclaracionUniversal.getDuNomConductorB()));

			paramDeclaracion.put("edadConductor_B", "EDAD/AGE: "
					+ validarCadenaDUA(formatoDeclaracionUniversal.getDuEdadConductorB()) + " AÑOS/YEARS");
			
			//NUEVO DIRECCION B
			
			paramDeclaracion.put("dirConductor1_B", "" + validarCadenaDUA(formatoDeclaracionUniversal.getDuDirConductorB()) + "");

			

			paramDeclaracion.put("telConductor_B", "TELEFONO/PHONE: "
					+ formatoNumero(validarCadena(formatoDeclaracionUniversal.getDuTelConductorB())));

			paramDeclaracion.put("mailConductor_B",
					"EMAIL/EMAIL: " + validarCadenaMail(formatoDeclaracionUniversal.getDuEmailConductorB()));

			paramDeclaracion.put("numLicConductor_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuLicenciaNumB()));

			paramDeclaracion.put("edoLicConductor_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuLicenciaEstadoB()));

			paramDeclaracion.put("tipoLicConductor_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuTipoLicenciaB()));

			paramDeclaracion.put("marcaAuto_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuMarcaAutoB()));

			paramDeclaracion.put("modeloAuto_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuModeloAutoB()));

			paramDeclaracion.put("placasAuto_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuPlacasAutoB()));

			paramDeclaracion.put("tipoAuto_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuTipoAutoB()));

			paramDeclaracion.put("colorAuto_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuColorAutoB()));

			paramDeclaracion.put("usoAuto_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuUsoAutoB()));

			paramDeclaracion.put("serieAuto_B",
					validarCadenaDUA(formatoDeclaracionUniversal.getDuSerieB()));

			paramDeclaracion.put("narracion1_B",
					validarCadena(formatoDeclaracionUniversal.getDuNarracionB()));

		

			contenido = validarCadena(formatoDeclaracionUniversal.getDuDaniosApreB());

			nombreRenglon = "daniosA";

			auxRenglon = "";

			longitudRenglon = 30;

			numeroRenglones = 7;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramDeclaracion.put(nombreRenglon + i + "_B", auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramDeclaracion.put(nombreRenglon + i + "_B", auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoDeclaracionUniversal.getDuDaniosPreB());

			nombreRenglon = "daniosP";

			auxRenglon = "";

			longitudRenglon = 27;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramDeclaracion.put(nombreRenglon + i + "_B", auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramDeclaracion.put(nombreRenglon + i + "_B", auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramDeclaracion.put("ajustador1B",
					validarCadena(formatoDeclaracionUniversal.getDuNomAjustadorB()));

			paramDeclaracion.put("claveB",
					validarCadena(formatoDeclaracionUniversal.getDuClaveAjustadorB()));

			/////////////////////////////////////// TERMINA B

			paramDeclaracion.put("polizaA",
					validarCadena(formatoDeclaracionUniversal.getDuNumPoliza()));

			paramDeclaracion.put("polizaB",
					validarCadena(formatoDeclaracionUniversal.getDuNumPolizaB()));

			paramDeclaracion.put("folio", validarCadena(formatoDeclaracionUniversal.getId() + ""));

			if (validarNumero(formatoDeclaracionUniversal.getDuResponsableA() + "") == 1) {

				paramDeclaracion.put("responsableA", true);

			} else {

				paramDeclaracion.put("responsableA", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuSipac() + "") == 1) {

				paramDeclaracion.put("sipac", true);

			} else {

				paramDeclaracion.put("sipac", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuEnEspera() + "") == 1) {

				paramDeclaracion.put("espera", true);

			} else {

				paramDeclaracion.put("espera", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta1a() + "") == 1) {

				paramDeclaracion.put("pre1A", true);

			} else {

				paramDeclaracion.put("pre1A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta2a() + "") == 1) {

				paramDeclaracion.put("pre2A", true);

			} else {

				paramDeclaracion.put("pre2A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta3a() + "") == 1) {

				paramDeclaracion.put("pre3A", true);

			} else {

				paramDeclaracion.put("pre3A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta4a() + "") == 1) {

				paramDeclaracion.put("pre4A", true);

			} else {

				paramDeclaracion.put("pre4A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta5a() + "") == 1) {

				paramDeclaracion.put("pre5A", true);

			} else {

				paramDeclaracion.put("pre5A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta6a() + "") == 1) {

				paramDeclaracion.put("pre6A", true);

			} else {

				paramDeclaracion.put("pre6A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta7a() + "") == 1) {

				paramDeclaracion.put("pre7A", true);

			} else {

				paramDeclaracion.put("pre7A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta8a() + "") == 1) {

				paramDeclaracion.put("pre8A", true);

			} else {

				paramDeclaracion.put("pre8A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta9a() + "") == 1) {

				paramDeclaracion.put("pre9A", true);

			} else {

				paramDeclaracion.put("pre9A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta10a() + "") == 1) {

				paramDeclaracion.put("pre10A", true);

			} else {

				paramDeclaracion.put("pre10A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta11a() + "") == 1) {

				paramDeclaracion.put("pre11A", true);

			} else {

				paramDeclaracion.put("pre11A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta12a() + "") == 1) {

				paramDeclaracion.put("pre12A", true);

			} else {

				paramDeclaracion.put("pre12A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta13a() + "") == 1) {

				paramDeclaracion.put("pre13A", true);

			} else {

				paramDeclaracion.put("pre13A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta14a() + "") == 1) {

				paramDeclaracion.put("pre14A", true);

			} else {

				paramDeclaracion.put("pre14A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta15a() + "") == 1) {

				paramDeclaracion.put("pre15A", true);

			} else {

				paramDeclaracion.put("pre15A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta16a() + "") == 1) {

				paramDeclaracion.put("pre16A", true);

			} else {

				paramDeclaracion.put("pre16A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta17a() + "") == 1) {

				paramDeclaracion.put("pre17A", true);

			} else {

				paramDeclaracion.put("pre17A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta18a() + "") == 1) {

				paramDeclaracion.put("pre18A", true);

			} else {

				paramDeclaracion.put("pre18A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta19a() + "") == 1) {

				paramDeclaracion.put("pre19A", true);

			} else {

				paramDeclaracion.put("pre19A", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta1b() + "") == 1) {

				paramDeclaracion.put("pre1B", true);

			} else {

				paramDeclaracion.put("pre1B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta2b() + "") == 1) {

				paramDeclaracion.put("pre2B", true);

			} else {

				paramDeclaracion.put("pre2B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta3b() + "") == 1) {

				paramDeclaracion.put("pre3B", true);

			} else {

				paramDeclaracion.put("pre3B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta4b() + "") == 1) {

				paramDeclaracion.put("pre4B", true);

			} else {

				paramDeclaracion.put("pre4B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta5b() + "") == 1) {

				paramDeclaracion.put("pre5B", true);

			} else {

				paramDeclaracion.put("pre5B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta6b() + "") == 1) {

				paramDeclaracion.put("pre6B", true);

			} else {

				paramDeclaracion.put("pre6B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta7b() + "") == 1) {

				paramDeclaracion.put("pre7B", true);

			} else {

				paramDeclaracion.put("pre7B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta8b() + "") == 1) {

				paramDeclaracion.put("pre8B", true);

			} else {

				paramDeclaracion.put("pre8B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta9b() + "") == 1) {

				paramDeclaracion.put("pre9B", true);

			} else {

				paramDeclaracion.put("pre9B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta10b() + "") == 1) {

				paramDeclaracion.put("pre10B", true);

			} else {

				paramDeclaracion.put("pre10B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta11b() + "") == 1) {

				paramDeclaracion.put("pre11B", true);

			} else {

				paramDeclaracion.put("pre11B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta12b() + "") == 1) {

				paramDeclaracion.put("pre12B", true);

			} else {

				paramDeclaracion.put("pre12B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta13b() + "") == 1) {

				paramDeclaracion.put("pre13B", true);

			} else {

				paramDeclaracion.put("pre13B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta14b() + "") == 1) {

				paramDeclaracion.put("pre14B", true);

			} else {

				paramDeclaracion.put("pre14B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta15b() + "") == 1) {

				paramDeclaracion.put("pre15B", true);

			} else {

				paramDeclaracion.put("pre15B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta16b() + "") == 1) {

				paramDeclaracion.put("pre16B", true);

			} else {

				paramDeclaracion.put("pre16B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta17b() + "") == 1) {

				paramDeclaracion.put("pre17B", true);

			} else {

				paramDeclaracion.put("pre17B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta18b() + "") == 1) {

				paramDeclaracion.put("pre18B", true);

			} else {

				paramDeclaracion.put("pre18B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPregunta19b() + "") == 1) {

				paramDeclaracion.put("pre19B", true);

			} else {

				paramDeclaracion.put("pre19B", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPreguntaABool() + "") == 1) {

				paramDeclaracion.put("resA", true);

			} else {

				paramDeclaracion.put("resA", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuPreguntaBBool() + "") == 1) {

				paramDeclaracion.put("resB", true);

			} else {

				paramDeclaracion.put("resB", false);

			}

			if (validarCadena(formatoDeclaracionUniversal.getDuPreguntaA()).equals(" ")) {

				paramDeclaracion.put("riesgo", "NO APLICA");

			} else {

				paramDeclaracion.put("riesgo", formatoDeclaracionUniversal.getDuPreguntaA());

			}

			paramDeclaracion.put("riesgoB", "");

			/////// LE AGREGUE ESTO DECLARACION 2

			if (formatoDeclaracionUniversal.getDuHoraGrua() != null) {

				Date horaGr = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuHoraGrua()) + "");

				paramDeclaracion.put("horaGrua", writeFormatHora.format(horaGr));

			} else {

				paramDeclaracion.put("horaGrua", " ");

			}

			if (formatoDeclaracionUniversal.getDuHoraAmbulancia() != null) {

				Date horaAm = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuHoraAmbulancia()) + "");

				paramDeclaracion.put("horaAmbulancia", writeFormatHora.format(horaAm));

			} else {

				paramDeclaracion.put("horaAmbulancia", " ");

			}

			if (formatoDeclaracionUniversal.getDuHoraAbogado() != null) {

				Date horaAb = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoDeclaracionUniversal.getDuHoraAbogado()) + "");

				paramDeclaracion.put("horaAbogado", writeFormatHora.format(horaAb));

			} else {

				paramDeclaracion.put("horaAbogado", " ");

			}

			for (int i = 1; i <= 4; i++) {

				if (i == 4) {

					paramDeclaracion.put("ocuA" + i, false);

					paramDeclaracion.put("ocuB" + i, false);

					paramDeclaracion.put("ocuC" + i, false);

					paramDeclaracion.put("ocuD" + i, false);

					paramDeclaracion.put("ocuE" + i, false);

					paramDeclaracion.put("ocuF" + i, false);

					paramDeclaracion.put("ocuG" + i, false);

					paramDeclaracion.put("ocuH" + i, false);

					paramDeclaracion.put("ocuI" + i, false);

					paramDeclaracion.put("ocuJ" + i, false);

				} else {

					paramDeclaracion.put("ocuA" + i, "");

					paramDeclaracion.put("ocuB" + i, "");

					paramDeclaracion.put("ocuC" + i, "");

					paramDeclaracion.put("ocuD" + i, "");

					paramDeclaracion.put("ocuE" + i, "");

					paramDeclaracion.put("ocuF" + i, "");

					paramDeclaracion.put("ocuG" + i, "");

					paramDeclaracion.put("ocuH" + i, "");

					paramDeclaracion.put("ocuI" + i, "");

					paramDeclaracion.put("ocuJ" + i, "");

				}

			}

			String[] o1 = (validarCadena(formatoDeclaracionUniversal.getDuOcupante1())).split("-");

			String[] o2 = (validarCadena(formatoDeclaracionUniversal.getDuOcupante2())).split("-");

			String[] o3 = (validarCadena(formatoDeclaracionUniversal.getDuOcupante3())).split("-");

			String[] o4 = (validarCadena(formatoDeclaracionUniversal.getDuOcupante4())).split("-");

			String[] o5 = (validarCadena(formatoDeclaracionUniversal.getDuOcupante5())).split("-");

			String[] o6 = (validarCadena(formatoDeclaracionUniversal.getDuOcupante1B())).split("-");

			String[] o7 = (validarCadena(formatoDeclaracionUniversal.getDuOcupante2B())).split("-");

			String[] o8 = (validarCadena(formatoDeclaracionUniversal.getDuOcupante3B())).split("-");

			String[] o9 = (validarCadena(formatoDeclaracionUniversal.getDuOcupante4B())).split("-");

			String[] o10 = (validarCadena(formatoDeclaracionUniversal.getDuOcupante5B())).split("-");

			for (int i = 0; i < o1.length; i++) {

				for (int j = 0; j < o1[i].length(); j++) {

					if (o1[i].charAt(j) == '(') {

						for (int k = 1; k <= 4; k++) {

							if (Integer.parseInt(o1[i].substring(0, j).replaceAll(" ", "")) == k) {

								if (k != 4) {

									if (k == 3) {

										paramDeclaracion.put("ocuA" + k, formatoNumero(
												o1[i].substring(j + 1, o1[i].length() - 1)));

									} else {

										paramDeclaracion.put("ocuA" + k,
												o1[i].substring(j + 1, o1[i].length() - 1));

									}

								} else {

									if ((!(o1[i].substring(j + 1, o1[i].length() - 1).replaceAll(" ",
											"")).equals(""))) {

										if (Integer.parseInt(o1[i].substring(j + 1, o1[i].length() - 1)
												.replaceAll(" ", "")) == 1) {

											paramDeclaracion.put("ocuA" + k, true);

										}
									}

								}

							}

						}

					}

				}

			}

			for (int i = 0; i < o2.length; i++) {

				for (int j = 0; j < o2[i].length(); j++) {

					if (o2[i].charAt(j) == '(') {

						for (int k = 1; k <= 4; k++) {

							if (Integer.parseInt(o2[i].substring(0, j).replaceAll(" ", "")) == k) {

								if (k != 4) {

									if (k == 3) {

										paramDeclaracion.put("ocuB" + k, formatoNumero(
												o2[i].substring(j + 1, o2[i].length() - 1)));

									} else {

										paramDeclaracion.put("ocuB" + k,
												o2[i].substring(j + 1, o2[i].length() - 1));

									}

								} else {

									if ((!(o2[i].substring(j + 1, o2[i].length() - 1).replaceAll(" ",
											"")).equals(""))) {

										if (Integer.parseInt(o2[i].substring(j + 1, o2[i].length() - 1)
												.replaceAll(" ", "")) == 1) {

											paramDeclaracion.put("ocuB" + k, true);

										}

									}

								}

							}

						}

					}

				}

			}

			for (int i = 0; i < o3.length; i++) {

				for (int j = 0; j < o3[i].length(); j++) {

					if (o3[i].charAt(j) == '(') {

						for (int k = 1; k <= 4; k++) {

							if (Integer.parseInt(o3[i].substring(0, j).replaceAll(" ", "")) == k) {

								if (k != 4) {

									if (k == 3) {

										paramDeclaracion.put("ocuC" + k, formatoNumero(
												o3[i].substring(j + 1, o3[i].length() - 1)));

									} else {

										paramDeclaracion.put("ocuC" + k,
												o3[i].substring(j + 1, o3[i].length() - 1));

									}

								} else {

									if ((!(o3[i].substring(j + 1, o3[i].length() - 1).replaceAll(" ",
											"")).equals(""))) {

										if (Integer.parseInt(o3[i].substring(j + 1, o3[i].length() - 1)
												.replaceAll(" ", "")) == 1) {

											paramDeclaracion.put("ocuC" + k, true);

										}
									}

								}

							}

						}

					}

				}

			}

			for (int i = 0; i < o4.length; i++) {

				for (int j = 0; j < o4[i].length(); j++) {

					if (o4[i].charAt(j) == '(') {

						for (int k = 1; k <= 4; k++) {

							if (Integer.parseInt(o4[i].substring(0, j).replaceAll(" ", "")) == k) {

								if (k != 4) {

									if (k == 3) {

										paramDeclaracion.put("ocuD" + k, formatoNumero(
												o4[i].substring(j + 1, o4[i].length() - 1)));

									} else {

										paramDeclaracion.put("ocuD" + k,
												o4[i].substring(j + 1, o4[i].length() - 1));

									}

								} else {

									if ((!(o4[i].substring(j + 1, o4[i].length() - 1).replaceAll(" ",
											"")).equals(""))) {

										if (Integer.parseInt(o4[i].substring(j + 1, o4[i].length() - 1)
												.replaceAll(" ", "")) == 1) {

											paramDeclaracion.put("ocuD" + k, true);

										}
									}

								}

							}

						}

					}

				}

			}

			for (int i = 0; i < o5.length; i++) {

				for (int j = 0; j < o5[i].length(); j++) {

					if (o5[i].charAt(j) == '(') {

						for (int k = 1; k <= 4; k++) {

							if (Integer.parseInt(o5[i].substring(0, j).replaceAll(" ", "")) == k) {

								if (k != 4) {

									if (k == 3) {

										paramDeclaracion.put("ocuE" + k, formatoNumero(
												o5[i].substring(j + 1, o5[i].length() - 1)));

									} else {

										paramDeclaracion.put("ocuE" + k,
												o5[i].substring(j + 1, o5[i].length() - 1));

									}

								} else {

									if ((!(o5[i].substring(j + 1, o5[i].length() - 1).replaceAll(" ",
											"")).equals(""))) {

										if (Integer.parseInt(o5[i].substring(j + 1, o5[i].length() - 1)
												.replaceAll(" ", "")) == 1) {

											paramDeclaracion.put("ocuE" + k, true);

										}
									}

								}

							}

						}

					}

				}

			}

			for (int i = 0; i < o6.length; i++) {

				for (int j = 0; j < o6[i].length(); j++) {

					if (o6[i].charAt(j) == '(') {

						for (int k = 1; k <= 4; k++) {

							if (Integer.parseInt(o6[i].substring(0, j).replaceAll(" ", "")) == k) {

								if (k != 4) {

									if (k == 3) {

										paramDeclaracion.put("ocuF" + k, formatoNumero(
												o6[i].substring(j + 1, o6[i].length() - 1)));

									} else {

										paramDeclaracion.put("ocuF" + k,
												o6[i].substring(j + 1, o6[i].length() - 1));

									}

								} else {

									if ((!(o6[i].substring(j + 1, o6[i].length() - 1).replaceAll(" ",
											"")).equals(""))) {

										if (Integer.parseInt(o6[i].substring(j + 1, o6[i].length() - 1)
												.replaceAll(" ", "")) == 1) {

											paramDeclaracion.put("ocuF" + k, true);

										}
									}

								}

							}

						}

					}

				}

			}

			for (int i = 0; i < o7.length; i++) {

				for (int j = 0; j < o7[i].length(); j++) {

					if (o7[i].charAt(j) == '(') {

						for (int k = 1; k <= 4; k++) {

							if (Integer.parseInt(o7[i].substring(0, j).replaceAll(" ", "")) == k) {

								if (k != 4) {

									if (k == 3) {

										paramDeclaracion.put("ocuG" + k, formatoNumero(
												o7[i].substring(j + 1, o7[i].length() - 1)));

									} else {

										paramDeclaracion.put("ocuG" + k,
												o7[i].substring(j + 1, o7[i].length() - 1));

									}

								} else {

									if ((!(o7[i].substring(j + 1, o7[i].length() - 1).replaceAll(" ",
											"")).equals(""))) {

										if (Integer.parseInt(o7[i].substring(j + 1, o7[i].length() - 1)
												.replaceAll(" ", "")) == 1) {

											paramDeclaracion.put("ocuG" + k, true);

										}
									}

								}

							}

						}

					}

				}

			}

			for (int i = 0; i < o8.length; i++) {

				for (int j = 0; j < o8[i].length(); j++) {

					if (o8[i].charAt(j) == '(') {

						for (int k = 1; k <= 4; k++) {

							if (Integer.parseInt(o8[i].substring(0, j).replaceAll(" ", "")) == k) {

								if (k != 4) {

									if (k == 3) {

										paramDeclaracion.put("ocuH" + k, formatoNumero(
												o8[i].substring(j + 1, o8[i].length() - 1)));

									} else {

										paramDeclaracion.put("ocuH" + k,
												o8[i].substring(j + 1, o8[i].length() - 1));

									}

								} else {

									if ((!(o8[i].substring(j + 1, o8[i].length() - 1).replaceAll(" ",
											"")).equals(""))) {

										if (Integer.parseInt(o8[i].substring(j + 1, o8[i].length() - 1)
												.replaceAll(" ", "")) == 1) {

											paramDeclaracion.put("ocuH" + k, true);

										}
									}

								}

							}

						}

					}

				}

			}

			for (int i = 0; i < o9.length; i++) {

				for (int j = 0; j < o9[i].length(); j++) {

					if (o9[i].charAt(j) == '(') {

						for (int k = 1; k <= 4; k++) {

							if (Integer.parseInt(o9[i].substring(0, j).replaceAll(" ", "")) == k) {

								if (k != 4) {

									if (k == 3) {

										paramDeclaracion.put("ocuI" + k, formatoNumero(
												o9[i].substring(j + 1, o9[i].length() - 1)));

									} else {

										paramDeclaracion.put("ocuI" + k,
												o9[i].substring(j + 1, o9[i].length() - 1));

									}

								} else {

									if ((!(o9[i].substring(j + 1, o9[i].length() - 1).replaceAll(" ",
											"")).equals(""))) {

										if (Integer.parseInt(o9[i].substring(j + 1, o9[i].length() - 1)
												.replaceAll(" ", "")) == 1) {

											paramDeclaracion.put("ocuI" + k, true);

										}
									}

								}

							}

						}

					}

				}

			}

			for (int i = 0; i < o10.length; i++) {

				for (int j = 0; j < o10[i].length(); j++) {

					if (o10[i].charAt(j) == '(') {

						for (int k = 1; k <= 4; k++) {

							if (Integer.parseInt(o10[i].substring(0, j).replaceAll(" ", "")) == k) {

								if (k != 4) {

									if (k == 3) {

										paramDeclaracion.put("ocuJ" + k, formatoNumero(
												o10[i].substring(j + 1, o10[i].length() - 1)));

									} else {

										paramDeclaracion.put("ocuJ" + k,
												o10[i].substring(j + 1, o10[i].length() - 1));

									}

								} else {

									if ((!(o10[i].substring(j + 1, o10[i].length() - 1).replaceAll(" ",
											"")).equals(""))) {

										if (Integer
												.parseInt(o10[i].substring(j + 1, o10[i].length() - 1)
														.replaceAll(" ", "")) == 1) {

											paramDeclaracion.put("ocuJ" + k, true);

										}
									}

								}

							}

						}

					}

				}

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuVolanteAdmison() + "") == 1) {

				paramDeclaracion.put("volanteAdmision", true);

			} else {

				paramDeclaracion.put("volanteAdmision", false);

			}

			if (validarCadena(formatoDeclaracionUniversal.getDuAplicoDeducible()).equals("DM")) {

				paramDeclaracion.put("dm", true);

			} else {

				paramDeclaracion.put("dm", false);

			}

			if (validarCadena(formatoDeclaracionUniversal.getDuAplicoDeducible()).equals("RC")) {

				paramDeclaracion.put("rc", true);

			} else {

				paramDeclaracion.put("rc", false);

			}
			if (validarCadena(formatoDeclaracionUniversal.getDuAplicoDeducible()).equals("RT")) {

				paramDeclaracion.put("rt", true);

			} else {

				paramDeclaracion.put("rt", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuTradicionalEnt() + "") == 1) {

				paramDeclaracion.put("ordTradicionalEnt", true);

			} else {

				paramDeclaracion.put("ordTradicionalEnt", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuTradicionalRec() + "") == 1) {

				paramDeclaracion.put("ordTradicionalRec", true);

			} else {

				paramDeclaracion.put("ordTradicionalRec", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuSipacEnt() + "") == 1) {

				paramDeclaracion.put("ordSipacEnt", true);

			} else {

				paramDeclaracion.put("ordSipacEnt", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuSipacRec() + "") == 1) {

				paramDeclaracion.put("ordSipacRec", true);

			} else {

				paramDeclaracion.put("ordSipacRec", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuOtrosEnt() + "") == 1) {

				paramDeclaracion.put("otrosEnt", true);

			} else {

				paramDeclaracion.put("otrosEnt", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuOtrosRec() + "") == 1) {

				paramDeclaracion.put("otrosRec", true);

			} else {

				paramDeclaracion.put("otrosRec", false);

			}

			paramDeclaracion.put("otros", validarCadena(formatoDeclaracionUniversal.getDuOtros()));

			paramDeclaracion.put("garantia", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuRecuperacion()))));

			paramDeclaracion.put("folio", validarCadena(formatoDeclaracionUniversal.getId() + ""));

			paramDeclaracion.put("autoridad",
					validarCadena(formatoDeclaracionUniversal.getDuAutoridad()));

			paramDeclaracion.put("abogado",
					validarCadena(formatoDeclaracionUniversal.getDuNomAbogado()));

			paramDeclaracion.put("numActa", validarCadena(formatoDeclaracionUniversal.getDuNumActa()));

			paramDeclaracion.put("numReporteAuto",
					validarCadena(formatoDeclaracionUniversal.getDuNumReporteAut()));

			paramDeclaracion.put("daniosMateriales", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuDaniosMateriales()))));

			paramDeclaracion.put("equipoEspecial", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuEquipoEspecial()))));

			paramDeclaracion.put("roboTotal", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuRoboTotal()))));

			paramDeclaracion.put("resPersonas", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuResPersonas()))));

			paramDeclaracion.put("gasOcupantes", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuGastosMedicos()))));

			paramDeclaracion.put("lesOcupantes",
					validarCadena(formatoDeclaracionUniversal.getDuNumOcupantes()));

			paramDeclaracion.put("gasLegales", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuGastosLegales()))));

			paramDeclaracion.put("acciPersonales", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuAcciPersonales()))));

			paramDeclaracion.put("lesPersonales",
					validarCadena(formatoDeclaracionUniversal.getDuNumPersonales()));

			paramDeclaracion.put("rcViajero", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuRcViajero()))));

			paramDeclaracion.put("lesViajero", validarCadena(formatoDeclaracionUniversal.getDuNumRc()));

			paramDeclaracion.put("cristales", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuCristales()))));

			paramDeclaracion.put("otro", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuOtro()))));

			paramDeclaracion.put("especificarOtro",
					validarCadena(formatoDeclaracionUniversal.getDuOtroEspecificar()));

			paramDeclaracion.put("nomSupervisor",
					validarCadena(formatoDeclaracionUniversal.getDuNomSupervisor()).replaceAll(" ",
							""));

			paramDeclaracion.put("tipoAjuste",
					validarNumero(formatoDeclaracionUniversal.getDuEstadoAjuste() + ""));

			paramDeclaracion.put("condicionadoA",
					validarCadena(formatoDeclaracionUniversal.getDuCondicionadoA()));

			paramDeclaracion.put("conclusiones1", "");

			paramDeclaracion.put("conclusiones2", "");

			paramDeclaracion.put("conclusiones3", "");

			paramDeclaracion.put("conclusiones4", "");

			paramDeclaracion.put("conclusiones5", "");

			paramDeclaracion.put("conclusiones6", "");

			paramDeclaracion.put("conclusiones7", "");

			paramDeclaracion.put("conclusiones8", "");

			paramDeclaracion.put("conclusiones9", "");

			paramDeclaracion.put("conclusiones10", "");

			paramDeclaracion.put("conclusiones11", "");

			paramDeclaracion.put("conclusiones12", "");

			paramDeclaracion.put("conclusiones13", "");

			paramDeclaracion.put("conclusiones14", "");

			paramDeclaracion.put("conclusiones15", "");

			contenido = validarCadena(formatoDeclaracionUniversal.getDuConclusiones());

			nombreRenglon = "conclusiones";

			auxRenglon = "";

			longitudRenglon = 120;

			numeroRenglones = 15;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramDeclaracion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramDeclaracion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuInformeAdicional() + "") == 1) {

				paramDeclaracion.put("informe", true);

			} else {

				paramDeclaracion.put("informe", false);

			}

			if (validarNumero(formatoDeclaracionUniversal.getDuVehicuoCorralon() + "") == 1) {

				paramDeclaracion.put("corralon", true);

			} else {

				paramDeclaracion.put("corralon", false);

			}

			paramDeclaracion.put("ajustador",
					validarCadena(formatoDeclaracionUniversal.getDuNomAjustadorGral()));

			paramDeclaracion.put("clave",
					validarCadena(formatoDeclaracionUniversal.getDuClaveAjustadorGral()));

			paramDeclaracion.put("resBienes", separarMontos(
					formatoMontos(validarCadena(formatoDeclaracionUniversal.getDuResBienes()))));

			paramDeclaracion.put("lesPersonas",
					validarCadena(formatoDeclaracionUniversal.getDuNumPersonas()));

			/////

			// ***FIRMA ELECTRONICA***//

			String firma_ = formatoDeclaracionUniversal.getFirmaResponsable();

			InputStream targetStream_ = null;

			if (firma_ != null && !firma_.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma_);

				targetStream_ = new ByteArrayInputStream(bytes);

			}

			paramDeclaracion.put("imgBits", targetStream_);

			// ***FIRMA ELECTRONICA***//

			// ***FIRMA ELECTRONICA AJUSA***//

			String firma1_ = formatoDeclaracionUniversal.getFirmaAjusA();

			InputStream targetStream1_ = null;

			if (firma1_ != null && !firma1_.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1_);

				targetStream1_ = new ByteArrayInputStream(bytes1);

			}

			paramDeclaracion.put("imgBits1", targetStream1_);

			// ***FIRMA ELECTRONICA AJUSA***//

			// ***FIRMA ELECTRONICA AJUSB***//

			String firma2_ = formatoDeclaracionUniversal.getFirmaAjusB();

			InputStream targetStream2_ = null;

			if (firma2_ != null && !firma2_.isEmpty()) {

				byte[] bytes2 = Base64Decoder.decode(firma2_);

				targetStream2_ = new ByteArrayInputStream(bytes2);

			}

			paramDeclaracion.put("imgBits2", targetStream2_);

			// ***FIRMA ELECTRONICA AJUSB***//

			// ***FIRMA ELECTRONICA AJUS QUALITAS***//

			String firma3_ = formatoDeclaracionUniversal.getFirmaAjusQualitas();

			InputStream targetStream3_ = null;

			if (firma3_ != null && !firma3_.isEmpty()) {

				byte[] bytes3 = Base64Decoder.decode(firma3_);

				targetStream3_ = new ByteArrayInputStream(bytes3);

			}

			paramDeclaracion.put("imgBits3", targetStream3_);

			String firma4_ = formatoDeclaracionUniversal.getFirmaConA();

			InputStream targetStream4_ = null;

			if (firma4_ != null && !firma4_.isEmpty()) {

				byte[] bytes4 = Base64Decoder.decode(firma4_);

				targetStream4_ = new ByteArrayInputStream(bytes4);

			}

			paramDeclaracion.put("imgBits4", targetStream4_);

			// ***FIRMA ELECTRONICA CONA***//

			String firma5_ = formatoDeclaracionUniversal.getFirmaConB();

			InputStream targetStream5_ = null;

			if (firma5_ != null && !firma5_.isEmpty()) {

				byte[] bytes5 = Base64Decoder.decode(firma5_);

				targetStream5_ = new ByteArrayInputStream(bytes5);

			}

			paramDeclaracion.put("imgBits5", targetStream5_);
			
			paramDeclaracion.put("codigoResponsabilidad",
					validarCadena(formatoDeclaracionUniversal.getDuCodigoResponsabilidad()));


			paramDeclaracion.put("chCinco", formatoDeclaracionUniversal.getCheck5());

			paramDeclaracion.put("chSeis", formatoDeclaracionUniversal.getCheck6());
			
			crearArchivoError(FORMATO_DECLARACION_UNIVERSAL, fileJrxmlDeclaracionContent, paramDeclaracion,
					formatoDeclaracionUniversal.getDuNumReporte(), formatoDeclaracionUniversal.getDuNumPoliza(),
					"" + validarAsegurado(formatoDeclaracionUniversal.getDuAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	@SuppressWarnings("unused")
	public void procesoEncuestaServicioError(FormatoEncuestaServicio formatoEncuestaServicio, OutputStream ou) {

		try {

			fileJrxmlEncuesta = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/EncuestaDeServicio.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitasEE.png").getFile().getPath();

			HashMap<String, Object> paramEncuesta = new HashMap<String, Object>();

			paramEncuesta.put("imgLogoQualitas", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoEncuestaServicio.getEsFecha() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoEncuestaServicio.getEsFecha()));

				String fechaDesglosada = "";

				fechaDesglosada = " " + writeFormatFecha.format(date).substring(0, 2) + " DE "
						+ mesLetra(date) + " DEL " + writeFormatFecha.format(date).substring(6, 10)
						+ ".";

				paramEncuesta.put("lugarFecha", validarCadena(formatoEncuestaServicio.getEsLugar())
						+ " A " + fechaDesglosada + "");

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramEncuesta.put("lugarFecha",
						validarCadena(formatoEncuestaServicio.getEsLugar()) + "");

			}

			if (formatoEncuestaServicio.getEsEmailConductor() != null) {

				///////////////////
				String poliza = formatoEncuestaServicio.getEsNumPoliza();
				String reporte = formatoEncuestaServicio.getEsNumReporte();
				String destinatario = "";
				String nombreDoc = "Encuesta de Servicio";
				String cadenaCorreos = formatoEncuestaServicio.getEsEmailConductor();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			paramEncuesta.put("folio", validarCadena(formatoEncuestaServicio.getId() + ""));

			paramEncuesta.put("nomAsegurado",
					validarCadena(formatoEncuestaServicio.getEsNomAsegurado()));

			paramEncuesta.put("numReporte", validarCadena(formatoEncuestaServicio.getEsNumReporte()));

			paramEncuesta.put("numSiniestro",
					validarCadena(formatoEncuestaServicio.getEsNumSiniestro()));

			paramEncuesta.put("p1", validarNumero(formatoEncuestaServicio.getEsPregunta1() + ""));

			paramEncuesta.put("p2", validarNumero(formatoEncuestaServicio.getEsPregunta2() + ""));

			paramEncuesta.put("p3", validarNumero(formatoEncuestaServicio.getEsPregunta3() + ""));

			paramEncuesta.put("p4", validarNumero(formatoEncuestaServicio.getEsPregunta4() + ""));

			paramEncuesta.put("p5", validarNumero(formatoEncuestaServicio.getEsPregunta5() + ""));

			paramEncuesta.put("p6", validarES(formatoEncuestaServicio.getEsPregunta6() + ""));

			paramEncuesta.put("p7", validarNumero(formatoEncuestaServicio.getEsPregunta7() + ""));

			paramEncuesta.put("p8", validarNumero(formatoEncuestaServicio.getEsPregunta8() + ""));

			paramEncuesta.put("p9", validarNumero(formatoEncuestaServicio.getEsPregunta9() + ""));

			paramEncuesta.put("p10", validarNumero(formatoEncuestaServicio.getEsPregunta10() + ""));

			String contenido = validarCadena(formatoEncuestaServicio.getEsObservaciones());

			String nombreRenglon = "observaciones";

			String auxRenglon = "";

			int longitudRenglon = 116;

			int numeroRenglones = 6;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramEncuesta.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramEncuesta.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramEncuesta.put("nomConductor",
					validarCadena(formatoEncuestaServicio.getEsNomConductor()));

			paramEncuesta.put("telConductor",
					formatoNumero(validarCadena(formatoEncuestaServicio.getEsTelConductor())));

			paramEncuesta.put("emailConductor",
					validarCadenaMail(formatoEncuestaServicio.getEsEmailConductor()));

			paramEncuesta.put("chUno", formatoEncuestaServicio.getCheck1());

			paramEncuesta.put("chDos", formatoEncuestaServicio.getCheck2());

			paramEncuesta.put("chTres", formatoEncuestaServicio.getCheck3());

			paramEncuesta.put("chCuatro", formatoEncuestaServicio.getCheck4());

			// ***FIRMA ELECTRONICA ASEGURADO**//

			String firma = formatoEncuestaServicio.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramEncuesta.put("imgBits", targetStream);

			paramEncuesta.put("chCinco", formatoEncuestaServicio.getCheck5());

			paramEncuesta.put("chSeis", formatoEncuestaServicio.getCheck6());
			
			crearArchivoError(FORMATO_ENCUESTA_SERVICIO, fileJrxmlEncuesta, paramEncuesta,
					formatoEncuestaServicio.getEsNumReporte(), formatoEncuestaServicio.getEsNumPoliza(),
					"" + validarAsegurado(formatoEncuestaServicio.getEsAsegurado()), ou);
		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	@SuppressWarnings("deprecation")
	public String mesLetra(Date date) {

		String mes = "";

		switch (date.getMonth()) {

		case 0:

			mes = "ENERO";

			break;

		case 1:

			mes = "FEBRERO";

			break;

		case 2:

			mes = "MARZO";

			break;

		case 3:

			mes = "ABRIL";

			break;

		case 4:

			mes = "MAYO";

			break;

		case 5:

			mes = "JUNIO";

			break;

		case 6:

			mes = "JULIO";

			break;

		case 7:

			mes = "AGOSTO";

			break;

		case 8:

			mes = "SEPTIEMBRE";

			break;

		case 9:

			mes = "OCTUBRE";

			break;

		case 10:

			mes = "NOVIEMBRE";

			break;

		case 11:

			mes = "DICIEMBRE";

			break;

		}

		return mes;

	}

	@SuppressWarnings("unused")
	public void procesoAsistenciaVialError(FormatoAsistenciaVial formatoAsistenciaVial, OutputStream ou) {
		try {
			fileJrxmlAsistencia = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/AsistenciaVial.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitasEE.png").getFile().getPath();

			HashMap<String, Object> paramAsistencia = new HashMap<String, Object>();

			paramAsistencia.put("imgLogoQualitas", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoAsistenciaVial.getAvFecha() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoAsistenciaVial.getAvFecha()));

				paramAsistencia.put("fecha", writeFormatFecha.format(date) + "");

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramAsistencia.put("fecha", "");

			}

			if (formatoAsistenciaVial.getAvEmail() != null) {
				///////////////////
				String poliza = formatoAsistenciaVial.getAvNumPoliza();
				String reporte = formatoAsistenciaVial.getAvNumReporte();
				String destinatario = "";
				String nombreDoc = "Encuesta Asistencia Víal";
				String cadenaCorreos = formatoAsistenciaVial.getAvEmail();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			paramAsistencia.put("numReporte", validarCadena(formatoAsistenciaVial.getAvNumReporte()));

			paramAsistencia.put("polizaInciso", validarCadena(formatoAsistenciaVial.getAvNumPoliza())
					+ " / " + validarCadena(formatoAsistenciaVial.getAvNumInciso()));

			paramAsistencia.put("folio", validarCadena(formatoAsistenciaVial.getId() + ""));

			paramAsistencia.put("p1", validarNumero(formatoAsistenciaVial.getAvPregunta1() + ""));

			paramAsistencia.put("p2", validarNumero(formatoAsistenciaVial.getAvPregunta2() + ""));

			paramAsistencia.put("p3", validarNumero(formatoAsistenciaVial.getAvPregunta3() + ""));

			paramAsistencia.put("p4", validarNumero(formatoAsistenciaVial.getAvPregunta4() + ""));

			paramAsistencia.put("p6", validarNumero(formatoAsistenciaVial.getAvPregunta6() + ""));

			paramAsistencia.put("p7", validarNumero(formatoAsistenciaVial.getAvPregunta7() + ""));

			String contenido = validarCadena(formatoAsistenciaVial.getAvPregunta5());

			String nombreRenglon = "p5_";

			String auxRenglon = "";

			int longitudRenglon = 120;

			int numeroRenglones = 6;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramAsistencia.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramAsistencia.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoAsistenciaVial.getAvComentarios());

			nombreRenglon = "comentarios";

			auxRenglon = "";

			longitudRenglon = 120;

			numeroRenglones = 6;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramAsistencia.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramAsistencia.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramAsistencia.put("nombreAsegurado",
					validarCadena(formatoAsistenciaVial.getAvNomAsegurado()));

			paramAsistencia.put("emailAsegurado",
					validarCadenaMail(formatoAsistenciaVial.getAvEmail()));

			paramAsistencia.put("chUno", formatoAsistenciaVial.getCheck1());

			paramAsistencia.put("chDos", formatoAsistenciaVial.getCheck2());

			paramAsistencia.put("chTres", formatoAsistenciaVial.getCheck3());

			paramAsistencia.put("chCuatro", formatoAsistenciaVial.getCheck4());

			// ***FIRMA ELECTRONICA ASEGURADO**//

			String firma = formatoAsistenciaVial.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramAsistencia.put("imgBits", targetStream);
			
			paramAsistencia.put("chCinco", formatoAsistenciaVial.getCheck5());

			paramAsistencia.put("chSeis", formatoAsistenciaVial.getCheck6());
			
			
			crearArchivoError(FORMATO_ASISTENCIA_VIAL, fileJrxmlAsistencia, paramAsistencia,
					formatoAsistenciaVial.getAvNumReporte(), formatoAsistenciaVial.getAvNumPoliza(),
					"" + validarAsegurado(formatoAsistenciaVial.getAvAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	@SuppressWarnings("unused")
	public void procesoNuevosVehiculosError(FormatoNuevosVehiculos formatoNuevosVehiculos,
			List<FormatoCatalogos> datosCatalogos, OutputStream ou) {

		try {
			fileJrxmlNuevos = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/InspeccionDeNuevosVehiculos.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			String imgNuevosV = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/admisionAutos.png").getFile().getPath();

			HashMap<String, Object> paramNuevos = new HashMap<String, Object>();

			paramNuevos.put("imgLogoQualitas", imgLogoQualitas);

			paramNuevos.put("imgNuevosV", imgNuevosV);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoNuevosVehiculos.getNvFecha() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoNuevosVehiculos.getNvFecha()));

				paramNuevos.put("fecha", writeFormatFecha.format(date) + "");

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramNuevos.put("fecha", "");

			}

			if (formatoNuevosVehiculos.getNvEmail() != null) {

				///////////////////
				String poliza = formatoNuevosVehiculos.getNvNumPoliza();
				String reporte = formatoNuevosVehiculos.getNvNumReporte();
				String destinatario = "";
				String nombreDoc = "Inspección Nuevos Vehículos";
				String cadenaCorreos = formatoNuevosVehiculos.getNvEmail();
			//	agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			if (formatoNuevosVehiculos.getNvFechaInspeccion() != null) {

				Date dateI = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoNuevosVehiculos.getNvFechaInspeccion()));

				paramNuevos.put("fechaInspeccion", writeFormatFecha.format(dateI));

			} else {

				paramNuevos.put("fechaInspeccion", "");

			}

			if (formatoNuevosVehiculos.getNvHora() != null) {

				Date dateDH = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoNuevosVehiculos.getNvHora()));

				String fechaDesglosada = "";

				fechaDesglosada = " " + writeFormatFecha.format(dateDH).substring(0, 2) + " DE "
						+ mesLetra(dateDH) + " DEL " + writeFormatFecha.format(dateDH).substring(6, 10)
						+ " ";

				paramNuevos.put("diaHora",
						fechaDesglosada + " A LAS " + writeFormatHora.format(dateDH) + " HRS.");

			} else {

				paramNuevos.put("diaHora", "");

			}

			paramNuevos.put("folio", validarCadena(formatoNuevosVehiculos.getId() + ""));

			paramNuevos.put("solicitante", validarCadena(formatoNuevosVehiculos.getNvSolicitante()));

			paramNuevos.put("oficina", validarCadena(formatoNuevosVehiculos.getNvOficna()));

			paramNuevos.put("telefono",
					formatoNumero(validarCadena(formatoNuevosVehiculos.getNvTelSolicitante())));

			paramNuevos.put("atencion", validarCadena(formatoNuevosVehiculos.getNvNombreCliente()));

			paramNuevos.put("ubicacion", validarCadena(formatoNuevosVehiculos.getNvUbicacion()));

			paramNuevos.put("email", validarCadenaMail(formatoNuevosVehiculos.getNvEmail()));

			paramNuevos.put("unidad", validarCadena(formatoNuevosVehiculos.getNvUnidadAuto()));

			paramNuevos.put("tipo", validarCadena(formatoNuevosVehiculos.getNvTipoAuto()));

			paramNuevos.put("modelo", validarCadena(formatoNuevosVehiculos.getNvModeloAuto()));

			paramNuevos.put("placas", validarCadena(formatoNuevosVehiculos.getNvPlacas()));

			paramNuevos.put("puertasD", validarCadena(formatoNuevosVehiculos.getNvPuertasAuto()));

			paramNuevos.put("estandarT", validarCadena(formatoNuevosVehiculos.getNvTransmisionAuto()));

			paramNuevos.put("motor", validarCadena(formatoNuevosVehiculos.getNvMotorAuto()));

			paramNuevos.put("numSerie", validarCadena(formatoNuevosVehiculos.getNvNumSerieAuto()));

			paramNuevos.put("kilometraje", validarCadena(formatoNuevosVehiculos.getNvKilometrosAuto()));

			paramNuevos.put("nombreCliente",
					validarCadena(formatoNuevosVehiculos.getNvNombreCliente()));

			paramNuevos.put("nombreAjustador",
					validarCadena(formatoNuevosVehiculos.getNvClaveAjustador()) + " "
							+ validarCadena(formatoNuevosVehiculos.getNvNombreAjustador()));

			paramNuevos.put("chUno", formatoNuevosVehiculos.getCheck1());

			paramNuevos.put("chDos", formatoNuevosVehiculos.getCheck2());

			paramNuevos.put("chTres", formatoNuevosVehiculos.getCheck3());

			paramNuevos.put("chCuatro", formatoNuevosVehiculos.getCheck4());

			String contenido = validarCadena(formatoNuevosVehiculos.getNvObservacionesAuto());

			String nombreRenglon = "observaciones";

			String auxRenglon = "";

			int longitudRenglon = 120;

			int numeroRenglones = 6;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramNuevos.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramNuevos.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramNuevos.put("procedencia",
					validarNumero(formatoNuevosVehiculos.getNvProcedenciaAuto() + ""));

			if (validarNumero(formatoNuevosVehiculos.getNvDerivadaAuto() + "") == 1) {

				paramNuevos.put("salvamentos", true);

			} else {

				paramNuevos.put("salvamentos", false);

			}

			if (validarNumero(formatoNuevosVehiculos.getNvFotoMotor() + "") == 1) {

				paramNuevos.put("fotoMotor", true);

			} else {

				paramNuevos.put("fotoMotor", false);

			}

			if (validarNumero(formatoNuevosVehiculos.getNvFotoSerie() + "") == 1) {

				paramNuevos.put("fotoSerie", true);

			} else {

				paramNuevos.put("fotoSerie", false);

			}

			paramNuevos.put("totalFotos", validarNumero(formatoNuevosVehiculos.getNvTotalFotos() + ""));

			paramNuevos.put("tipoEncargado",
					validarNumero(formatoNuevosVehiculos.getNvTipoEmpleado() + ""));

			paramNuevos.put("marca1", 1);

			paramNuevos.put("marca2", 0);

			// ***FIRMA ELECTRONICA CLIENTE**//

			String firma = formatoNuevosVehiculos.getFirmaCliente();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramNuevos.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA CLIENTE**//

			// ***FIRMA ELECTRONICA AGENTE***//

			String firma1 = formatoNuevosVehiculos.getFirmaAgente();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramNuevos.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AGENTE***//

			String registradas = validarCadena(formatoNuevosVehiculos.getNvDaniosPre());

			String posibles = datosCatalogos.get(6).getValores() + "";

			String[] reg = registradas.split(",");

			String[] pos = posibles.split(",");

			for (int i = 1; i <= pos.length; i++) {

				paramNuevos.put("dp" + (i), 0);

			}

			if (!registradas.equals(" ")) {

				for (int i = 0; i < pos.length; i++) {

					for (int j = 0; j < reg.length; j++) {

						if (pos[i].replaceAll(" ", "").equals(reg[j].replaceAll(" ", ""))) {

							paramNuevos.put("dp" + (i + 1), 1);

						}

					}

				}

			}
			
			paramNuevos.put("chCinco", formatoNuevosVehiculos.getCheck5());

			paramNuevos.put("chSeis", formatoNuevosVehiculos.getCheck6());
			
			
			crearArchivoError(FORMATO_NUEVOS_VEHICULOS, fileJrxmlNuevos, paramNuevos,
					formatoNuevosVehiculos.getNvNumReporte(), formatoNuevosVehiculos.getNvNumPoliza(),
					"" + validarAsegurado(formatoNuevosVehiculos.getNvAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}

	}

	@SuppressWarnings("unused")
	public void procesoPaseMedicoError(FormatoPaseMedico formatoPaseMedico, OutputStream ou) {
		try {
			fileJrxmlPaseMedico = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/PaseMedico.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			HashMap<String, Object> paramMedico = new HashMap<String, Object>();

			paramMedico.put("imgLogoQualitas", imgLogoQualitas);

		

			if (formatoPaseMedico.getPmFechaEmision() != null) {

				Date dateE = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoPaseMedico.getPmFechaEmision()));

				paramMedico.put("fechaEmision", writeFormatFecha.format(dateE));

				// datosEmail.setFecha(writeFormatFecha.format(dateE));

			} else {

				paramMedico.put("fechaEmision", "");

			}

			if (formatoPaseMedico.getPmFechaSiniestro() != null) {

				Date dateS = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoPaseMedico.getPmFechaSiniestro()));

				paramMedico.put("fechaSiniestro", writeFormatFecha.format(dateS));

			} else {

				paramMedico.put("fechaSiniestro", "");

			}

			if (formatoPaseMedico.getPmEmailLesionado() != null) {
				///////////////////
				String poliza = formatoPaseMedico.getPmNumPoliza();
				String reporte = formatoPaseMedico.getPmNumReporte();
				String destinatario = "";
				String nombreDoc = "Pase Médico";
				String cadenaCorreos = formatoPaseMedico.getPmEmailLesionado();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			paramMedico.put("folioElectronico", validarCadena(formatoPaseMedico.getPmFolioElectro()));

			paramMedico.put("numeroFolio", validarCadena(formatoPaseMedico.getId() + ""));

			paramMedico.put("numeroReporte", validarCadena(formatoPaseMedico.getPmNumReporte()));

			paramMedico.put("numeroSiniestro", validarCadena(formatoPaseMedico.getPmNumSiniestro()));

			paramMedico.put("numPoliza", validarCadena(formatoPaseMedico.getPmNumPoliza()));

			paramMedico.put("numInciso", validarCadena(formatoPaseMedico.getPmNumInciso()));

			paramMedico.put("numEndoso", validarCadena(formatoPaseMedico.getPmNumEndoso()));

			paramMedico.put("nombreAsegurado", validarCadena(formatoPaseMedico.getPmNomAsegurado()));

			paramMedico.put("email", validarCadenaMail(formatoPaseMedico.getPmEmailAsegurado()));

			paramMedico.put("lugarEmision", validarNumero(formatoPaseMedico.getPmLugarEmision() + ""));

			paramMedico.put("emisionPase", validarCadena(formatoPaseMedico.getPmLugarEstado()));

			paramMedico.put("numOcupantes", validarCadena(formatoPaseMedico.getPmNumOcupantes()));

			paramMedico.put("tipoVehiculo", validarNumero(formatoPaseMedico.getPmTipoVehiculo() + ""));

			paramMedico.put("otroVehiculo", validarCadena(formatoPaseMedico.getPmOtroVehiculo()));

			paramMedico.put("causasLesion", validarNumero(formatoPaseMedico.getPmCausaLesion() + ""));

			paramMedico.put("otroCausa", validarCadena(formatoPaseMedico.getPmOtraLesion()));

			paramMedico.put("coberturaAfectada",
					validarNumero(formatoPaseMedico.getPmCoberturaAfec() + ""));

			paramMedico.put("otroCobertura", validarCadena(formatoPaseMedico.getPmOtraCobertura()));

			paramMedico.put("nomLesionado", validarCadena(formatoPaseMedico.getPmNomLesionado()));

			paramMedico.put("edadLesionado", validarCadena(formatoPaseMedico.getPmEdadLesionado()));

			paramMedico.put("telLesionado",
					formatoNumero(validarCadena(formatoPaseMedico.getPmTelLesionado())));

			paramMedico.put("datosAjustador", validarCadena(formatoPaseMedico.getPmClaveAjustador())
					+ " " + validarCadena(formatoPaseMedico.getPmNomAjustador()));

			paramMedico.put("chUno", formatoPaseMedico.getCheck1());

			paramMedico.put("chDos", formatoPaseMedico.getCheck2());

			paramMedico.put("chTres", formatoPaseMedico.getCheck3());

			paramMedico.put("chCuatro", formatoPaseMedico.getCheck4());

			// ***FIRMA ELECTRONICA ASEGURADO**//

			String firma = formatoPaseMedico.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramMedico.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA ASEGURADO**//

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String firma1 = formatoPaseMedico.getFirmaAjustador();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramMedico.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			// ***FIRMA ELECTRONICA LESIONADO**//

			String firma2 = formatoPaseMedico.getFirmaLesionado();

			InputStream targetStream2 = null;

			if (firma2 != null && !firma2.isEmpty()) {

				byte[] bytes2 = Base64Decoder.decode(firma2);

				targetStream2 = new ByteArrayInputStream(bytes2);

			}

			paramMedico.put("imgBits2", targetStream2);

			// ***FIRMA ELECTRONICA LESIONADO**//

			if (validarNumero(validarAsegurado(formatoPaseMedico.getPmAsegurado()) + "") == 1) {

				paramMedico.put("na", 1);

				paramMedico.put("tercero", 0);

			}

			if (validarNumero(validarAsegurado(formatoPaseMedico.getPmAsegurado()) + "") != 1) {

				paramMedico.put("tercero", 1);

				paramMedico.put("na", 0);

			}

			paramMedico.put("numeroDeLesionado", validarCadena(formatoPaseMedico.getPmNumLesionado()));

			if (validarNumero(formatoPaseMedico.getPmAmbulatoria() + "") == 1) {

				paramMedico.put("ta_ambulatoria", true);

			}

			if (validarNumero(formatoPaseMedico.getPmAmbulatoria() + "") == 0) {

				paramMedico.put("ta_ambulatoria", false);

			}

			paramMedico.put("idLesionado", validarCadena(formatoPaseMedico.getPmIdeLesionado()));

			String contenido = validarCadena(formatoPaseMedico.getPmLesionesAparentes());

			String nombreRenglon = "lesionesAparentes";

			String auxRenglon = "";

			int longitudRenglon = 120;

			int numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramMedico.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramMedico.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramMedico.put("tipoClinica", validarNumero(formatoPaseMedico.getPmTipoClinica() + ""));

			if (validarNumero(formatoPaseMedico.getPmConvenio() + "") == 1) {

				paramMedico.put("convenio", true);

			}

			if (validarNumero(formatoPaseMedico.getPmConvenio() + "") == 0) {

				paramMedico.put("convenio", false);

			}

			paramMedico.put("claveClinica", validarCadena(formatoPaseMedico.getPmClaveClinica()));

			paramMedico.put("nombreClinica", validarCadena(formatoPaseMedico.getPmNomClinica()));

			paramMedico.put("domHospital", validarCadena(formatoPaseMedico.getPmDomClinica()));

			paramMedico.put("telHospital",
					formatoNumero(validarCadena(formatoPaseMedico.getPmTelClinica())));

			if (validarNumero(formatoPaseMedico.getPmMedicoRed() + "") == 1) {

				paramMedico.put("medicoRed", true);

			}

			if (validarNumero(formatoPaseMedico.getPmMedicoRed() + "") == 0) {

				paramMedico.put("medicoRed", false);

			}

			paramMedico.put("claveMedico", validarCadena(formatoPaseMedico.getPmClaveMedico()));

			paramMedico.put("nombreMedico", validarCadena(formatoPaseMedico.getPmNomMedico()));

			paramMedico.put("telMedico",
					formatoNumero(validarCadena(formatoPaseMedico.getPmTelMedico())));
			
			
			paramMedico.put("chCinco", formatoPaseMedico.getCheck5());

			paramMedico.put("chSeis", formatoPaseMedico.getCheck6());
			
			
			crearArchivoError(FORMATO_PASE_MEDICO, fileJrxmlPaseMedico, paramMedico,
					formatoPaseMedico.getPmNumReporte(), formatoPaseMedico.getPmNumPoliza(),
					"" + validarAsegurado(formatoPaseMedico.getPmAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	public double validarDoble(String numero) {
		if (numero.equals("null")) {
			return 0.0;
		} else {
			return Double.parseDouble(numero);
		}
	}

	@SuppressWarnings("unused")
	public void procesoAsignacionAbogadoError(FormatoAsignacionAbogado formatoAsignacionAbogado, OutputStream ou) {
		try {
			fileJrxmlAbogado = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/AsignacionAbogado.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			HashMap<String, Object> paramAbogado = new HashMap<String, Object>();

			paramAbogado.put("ubicacionPATH", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoAsignacionAbogado.getAaHoraAbogado() != null) {

				Date dateA = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoAsignacionAbogado.getAaHoraAbogado()) + "");

				paramAbogado.put("fechaHora_A", writeFormatFecha.format(dateA) + " - "
						+ writeFormatHora.format(dateA) + " HRS");

				// datosEmail.setFecha(writeFormatFecha.format(dateA));

			} else {

				paramAbogado.put("fechaHora_A", "");

			}

			if (formatoAsignacionAbogado.getAaEmail() != null) {

				///////////////////
				String poliza = formatoAsignacionAbogado.getAaNumPoliza();
				String reporte = formatoAsignacionAbogado.getAaNumReporte();
				String destinatario = "";
				String nombreDoc = "Formato Asignación Abogado";
				String cadenaCorreos = formatoAsignacionAbogado.getAaEmail();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			if (formatoAsignacionAbogado.getAaHoraSiniestro() != null) {

				Date dateS = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoAsignacionAbogado.getAaHoraSiniestro()) + "");

				paramAbogado.put("fechaHora_S", writeFormatFecha.format(dateS) + " - "
						+ writeFormatHora.format(dateS) + " HRS");

			} else {

				paramAbogado.put("fechaHora_S", "");

			}

			if (formatoAsignacionAbogado.getAaHoraTurnado() != null) {

				Date dateT = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoAsignacionAbogado.getAaHoraTurnado()) + "");

				paramAbogado.put("fechaHora_T", writeFormatFecha.format(dateT) + " - "
						+ writeFormatHora.format(dateT) + " HRS");

			} else {

				paramAbogado.put("fechaHora_T", "");

			}

			paramAbogado.put("folio", validarCadena(formatoAsignacionAbogado.getId() + ""));

			paramAbogado.put("asignacionp1A",
					validarNumero(formatoAsignacionAbogado.getAaPregunta1A() + ""));

			paramAbogado.put("asignacionp1B",
					validarNumero(formatoAsignacionAbogado.getAaPregunta1B() + ""));

			paramAbogado.put("asignacionp1",
					validarNumero(formatoAsignacionAbogado.getAaPregunta1() + ""));

			paramAbogado.put("asignacionp2",
					validarNumero(formatoAsignacionAbogado.getAaPregunta2() + ""));

			paramAbogado.put("asignacionp3",
					validarNumero(formatoAsignacionAbogado.getAaPregunta3() + ""));

			paramAbogado.put("asignacionp4",
					validarNumero(formatoAsignacionAbogado.getAaPregunta4() + ""));

			paramAbogado.put("asignacionp5",
					validarNumero(formatoAsignacionAbogado.getAaPregunta5() + ""));

			paramAbogado.put("asignacionp6",
					validarNumero(formatoAsignacionAbogado.getAaPregunta6() + ""));

			paramAbogado.put("asignacionp7A",
					validarNumero(formatoAsignacionAbogado.getAaPregunta7A() + ""));

			paramAbogado.put("asignacionp7B",
					validarNumero(formatoAsignacionAbogado.getAaPregunta7B() + ""));

			paramAbogado.put("numeroSiniestro",
					validarCadena(formatoAsignacionAbogado.getAaNumSiniestro()));

			paramAbogado.put("numPoliza", validarCadena(formatoAsignacionAbogado.getAaNumPoliza()));

			paramAbogado.put("numReporte", validarCadena(formatoAsignacionAbogado.getAaNumReporte()));

			paramAbogado.put("marcaAuto", validarCadena(formatoAsignacionAbogado.getAaMarcaAuto()));

			paramAbogado.put("tipoAuto", validarCadena(formatoAsignacionAbogado.getAaTipoAuto()));

			paramAbogado.put("colorAuto", validarCadena(formatoAsignacionAbogado.getAaColorAuto()));

			paramAbogado.put("placasAuto", validarCadena(formatoAsignacionAbogado.getAaPlacaAuto()));

			paramAbogado.put("chUno", formatoAsignacionAbogado.getCheck1());

			paramAbogado.put("chDos", formatoAsignacionAbogado.getCheck2());

			paramAbogado.put("chTres", formatoAsignacionAbogado.getCheck3());

			paramAbogado.put("chCuatro", formatoAsignacionAbogado.getCheck4());

			// ***FIRMA ELECTRONICA ASEGURADO***//

			String firma = formatoAsignacionAbogado.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramAbogado.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA ASEGURADO***//

			// ***FIRMA ELECTRONICA AJUSTADOR***//

			String firma1 = formatoAsignacionAbogado.getFirmaAjustador();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramAbogado.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR***//

			// ***FIRMA ELECTRONICA ABOGADO***//

			String firma2 = formatoAsignacionAbogado.getFirmaAbogado();

			InputStream targetStream2 = null;

			if (firma2 != null && !firma2.isEmpty()) {

				byte[] bytes2 = Base64Decoder.decode(firma2);

				targetStream2 = new ByteArrayInputStream(bytes2);

			}

			paramAbogado.put("imgBits2", targetStream2);

			// ***FIRMA ELECTRONICA ABOGADO***//

			if (validarNumero(formatoAsignacionAbogado.getAaDeducibleRc() + "") == 1) {

				paramAbogado.put("deducibleRC", true);

			} else {

				paramAbogado.put("deducibleRC", false);

			}

			if (validarNumero(formatoAsignacionAbogado.getAaPagado() + "") == 1) {

				paramAbogado.put("pagado", true);

			} else {

				paramAbogado.put("pagado", false);

			}

			String dN = Double.toString(validarDoble(formatoAsignacionAbogado.getAaDaniosNa() + ""));

			String mC = Double
					.toString(validarDoble(formatoAsignacionAbogado.getAaMontoCrucero() + ""));

			String mD = Double
					.toString(validarDoble(formatoAsignacionAbogado.getAaMontoDeducible() + ""));

			dN = formatoMontos(dN);

			mC = formatoMontos(mC);

			mD = formatoMontos(mD);

			if (dN.length() > 6) {

				dN = separarMontos(dN);

			}

			if (mC.length() > 6) {

				mC = separarMontos(mC);

			}

			if (dN.length() > 6) {

				mD = separarMontos(mD);

			}

			paramAbogado.put("daniosNA", "$ " + dN);

			paramAbogado.put("montoCrucero", "$ " + mC);

			paramAbogado.put("montoDeducible", "$ " + mD);

			paramAbogado.put("nomAsegurado",
					validarCadena(formatoAsignacionAbogado.getAaNomAsegurado()));

			if (validarNumero(formatoAsignacionAbogado.getAaPropietario() + "") == 1) {

				paramAbogado.put("propietario", true);

			} else {

				paramAbogado.put("propietario", false);

			}

			paramAbogado.put("localizacionA",
					validarCadena(formatoAsignacionAbogado.getAaUbicacionActual()));

			paramAbogado.put("telOficina",
					formatoNumero(validarCadena(formatoAsignacionAbogado.getAaTelOficina())));

			String contenido = validarCadena(formatoAsignacionAbogado.getAaDescripcionDanios());

			String nombreRenglon = "desDanios";

			String auxRenglon = "";

			int longitudRenglon = 50;

			int numeroRenglones = 4;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramAbogado.put("nomConductor",
					validarCadena(formatoAsignacionAbogado.getAaNomConductor()));

			paramAbogado.put("telConductor",
					formatoNumero(validarCadena(formatoAsignacionAbogado.getAaTelCasa())));

			paramAbogado.put("email", validarCadenaMail(formatoAsignacionAbogado.getAaEmail()));

			paramAbogado.put("lugarSiniestro",
					validarCadena(formatoAsignacionAbogado.getAaLugarSiniestro()));

			paramAbogado.put("autoridadC", validarCadena(formatoAsignacionAbogado.getAaAutoridad()));

			paramAbogado.put("numAccidente",
					validarCadena(formatoAsignacionAbogado.getAaNumAccidente()));

			if (validarNumero(formatoAsignacionAbogado.getAaGrua() + "") == 1) {

				paramAbogado.put("grua", true);

			} else {

				paramAbogado.put("grua", false);

			}

			paramAbogado.put("nomTercero", validarCadena(formatoAsignacionAbogado.getAaNomTercero()));

			paramAbogado.put("terceroTelCasa",
					formatoNumero(validarCadena(formatoAsignacionAbogado.getAaTelCasaTercero())));

			paramAbogado.put("terceroTelOfi",
					formatoNumero(validarCadena(formatoAsignacionAbogado.getAaTelOficinaTercero())));

			contenido = validarCadena(formatoAsignacionAbogado.getAaDesDaniosTer());

			nombreRenglon = "desDaniosT";

			auxRenglon = "";

			longitudRenglon = 50;

			numeroRenglones = 6;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoAsignacionAbogado.getAaComentarios());

			nombreRenglon = "comentariosA";

			auxRenglon = "";

			longitudRenglon = 50;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramAbogado.put("terceroDanios", "$ " + separarMontos(formatoMontos(
					validarNumero(formatoAsignacionAbogado.getAaDaniosEstimados() + "") + "")));

			contenido = validarCadena(formatoAsignacionAbogado.getAaNomLesionados());

			nombreRenglon = "nomLesionados";

			auxRenglon = "";

			longitudRenglon = 50;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoAsignacionAbogado.getAaInforme());

			nombreRenglon = "informe";

			auxRenglon = "";

			longitudRenglon = 50;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoAsignacionAbogado.getAaOtros());

			nombreRenglon = "otros";

			auxRenglon = "";

			longitudRenglon = 50;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramAbogado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			if (validarNumero(formatoAsignacionAbogado.getAaGruaTercero() + "") == 1) {

				paramAbogado.put("tercerosGrua", true);

			} else {

				paramAbogado.put("tercerosGrua", false);

			}

			if (validarNumero(formatoAsignacionAbogado.getAaDeclaracionConduc() + "") == 1) {

				paramAbogado.put("dt_declaracion", true);

			} else {

				paramAbogado.put("dt_declaracion", false);

			}

			if (validarNumero(formatoAsignacionAbogado.getAaParteAcciden() + "") == 1) {

				paramAbogado.put("dt_parte", true);

			} else {

				paramAbogado.put("dt_parte", false);

			}

			if (validarNumero(formatoAsignacionAbogado.getAaCopiaPoliza() + "") == 1) {

				paramAbogado.put("dt_poliza", true);

			} else {

				paramAbogado.put("dt_poliza", false);

			}

			if (validarNumero(formatoAsignacionAbogado.getAaPresuAsegurado() + "") == 1) {

				paramAbogado.put("dt_presupuesto", true);

			} else {

				paramAbogado.put("dt_presupuesto", false);

			}

			if (validarNumero(formatoAsignacionAbogado.getAaCopiaLicencia() + "") == 1) {

				paramAbogado.put("dt_licencia", true);

			} else {

				paramAbogado.put("dt_licencia", false);

			}

			if (validarNumero(formatoAsignacionAbogado.getAaOrdenAdmision() + "") == 1) {

				paramAbogado.put("dt_admision", true);

			} else {

				paramAbogado.put("dt_admision", false);

			}

			if (validarNumero(formatoAsignacionAbogado.getAaPaseMedico() + "") == 1) {

				paramAbogado.put("dt_medico", true);

			} else {

				paramAbogado.put("dt_medico", false);

			}

			paramAbogado.put("datosAjustador",
					validarCadena(formatoAsignacionAbogado.getAaClaveAjustador()) + " "
							+ validarCadena(formatoAsignacionAbogado.getAaNomAjustador()));

			paramAbogado.put("datosAbogado", validarCadena(formatoAsignacionAbogado.getAaClaveAbogado())
					+ " " + validarCadena(formatoAsignacionAbogado.getAaNomAbogado()));
			
			
			String firmaTercero = formatoAsignacionAbogado.getFirmaTercero();
			
			

			InputStream targetStreamTercero = null;

			if (firmaTercero != null && !firmaTercero.isEmpty()) {

				byte[] bytesTercero = Base64Decoder.decode(firmaTercero);

				targetStreamTercero = new ByteArrayInputStream(bytesTercero);

			}
			paramAbogado.put("imgBitsTercero", targetStreamTercero);

			
			paramAbogado.put("chCinco", formatoAsignacionAbogado.getCheck5());

			paramAbogado.put("chSeis", formatoAsignacionAbogado.getCheck6());
			
			
			crearArchivoError(FORMATO_ASIGNACION_ABOGADO, fileJrxmlAbogado, paramAbogado,
					formatoAsignacionAbogado.getAaNumReporte(), formatoAsignacionAbogado.getAaNumPoliza(),
					"" + validarAsegurado(formatoAsignacionAbogado.getAaAsegurado()), ou);
		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}

	}

	@SuppressWarnings("unused")
	public void procesoAdmisionAutomovilesError(FormatoAdmisionAutomoviles formatoAdmisionAutomoviles,
			List<FormatoCatalogos> catalogo, OutputStream ou) {
		try {
			List<FormatoCatalogos> datosCatalogos = catalogo;
			fileJrxmlAdmisionAuto = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/OrdenDeAdmisionAutomoviles.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			String imgAdmisionAuto = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/Auto.png").getFile().getPath();
			
			String imgAdmisionAuto_1 = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/Auto_1.jpg").getFile().getPath();

			HashMap<String, Object> paramAdmisionAuto = new HashMap<String, Object>();

			paramAdmisionAuto.put("imgAdmisionAuto", imgAdmisionAuto);

			paramAdmisionAuto.put("imgLogoQualitas", imgLogoQualitas);
			
			paramAdmisionAuto.put("imgAdmisionAuto_1", validarAsegurado(formatoAdmisionAutomoviles.getOaAsegurado())==1 && 
					formatoAdmisionAutomoviles.getOaProductoEsencial()==1 ? imgAdmisionAuto_1 :imgAdmisionAuto);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoAdmisionAutomoviles.getOaFecha() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoAdmisionAutomoviles.getOaFecha()) + "");

				paramAdmisionAuto.put("fecha", writeFormatFecha.format(date));

				paramAdmisionAuto.put("hora", writeFormatHora.format(date) + " HRS");

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramAdmisionAuto.put("fecha", "");

				paramAdmisionAuto.put("hora", "");

			}

			if (formatoAdmisionAutomoviles.getOaEmailCliente() != null) {

				///////////////////
				String poliza = formatoAdmisionAutomoviles.getOaNumPoliza();
				String reporte = formatoAdmisionAutomoviles.getOaNumReporte();
				String destinatario = "";
				String nombreDoc = "Orden Admisión Autómoviles";
				String cadenaCorreos = formatoAdmisionAutomoviles.getOaEmailCliente();
			//	agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			paramAdmisionAuto.put("numReporte",
					validarCadena(formatoAdmisionAutomoviles.getOaNumReporte()));

			paramAdmisionAuto.put("numSiniestro",
					validarCadena(formatoAdmisionAutomoviles.getOaNumSiniestro()));

			paramAdmisionAuto.put("folio", validarCadena(formatoAdmisionAutomoviles.getId() + ""));

			paramAdmisionAuto.put("folioElectronico",
					validarCadena(formatoAdmisionAutomoviles.getOaFolioElectro()));

			if (validarNumero(
					validarAsegurado(formatoAdmisionAutomoviles.getOaAsegurado()) + "") == 1) {

				paramAdmisionAuto.put("asegurado", true);

			} else {

				paramAdmisionAuto.put("asegurado", false);

			}

			if (formatoAdmisionAutomoviles.getNiu() != null) {

				paramAdmisionAuto.put("niu", formatoAdmisionAutomoviles.getNiu() + "");

			}

			paramAdmisionAuto.put("numPoliza",
					validarCadena(formatoAdmisionAutomoviles.getOaNumPoliza()));

			paramAdmisionAuto.put("numEndoso",
					validarCadena(formatoAdmisionAutomoviles.getOaNumEndoso()));

			paramAdmisionAuto.put("numInciso",
					validarCadena(formatoAdmisionAutomoviles.getOaNumInciso()));

			paramAdmisionAuto.put("nombre",
					validarCadena(formatoAdmisionAutomoviles.getOaNomCliente()));

			paramAdmisionAuto.put("emailCliente",
					validarCadenaMail(formatoAdmisionAutomoviles.getOaEmailCliente()));

			paramAdmisionAuto.put("telefonoCliente",
					formatoNumero(validarCadena(formatoAdmisionAutomoviles.getOaTelCliente())));

			paramAdmisionAuto.put("razonSocial",
					validarCadena(formatoAdmisionAutomoviles.getOaRazonEnvio()));

			paramAdmisionAuto.put("responsable",
					validarCadena(formatoAdmisionAutomoviles.getOaRazonResponsable()));

			paramAdmisionAuto.put("telRazonSocial",
					formatoNumero(validarCadena(formatoAdmisionAutomoviles.getOaRazonTelefono())));

			paramAdmisionAuto.put("domRazonSocial",
					validarCadena(formatoAdmisionAutomoviles.getOaRazonDomicilio()));

			paramAdmisionAuto.put("coberturaRazon",
					validarCadena(formatoAdmisionAutomoviles.getOaRazonCobertura()));

			paramAdmisionAuto.put("tipoAuto",
					validarCadena(formatoAdmisionAutomoviles.getOaTipoAuto()));

			paramAdmisionAuto.put("marcaAuto",
					validarCadena(formatoAdmisionAutomoviles.getOaMarcaAuto()));

			paramAdmisionAuto.put("modeloAuto",
					validarCadena(formatoAdmisionAutomoviles.getOaModeloAuto()));

			paramAdmisionAuto.put("kilometraje",
					validarCadena(formatoAdmisionAutomoviles.getOaKilometraje()));

			paramAdmisionAuto.put("numSerie",
					validarCadena(formatoAdmisionAutomoviles.getOaNumSerie()));

			paramAdmisionAuto.put("colorAuto",
					validarCadena(formatoAdmisionAutomoviles.getOaColorAuto()));

			paramAdmisionAuto.put("placasAuto",
					validarCadena(formatoAdmisionAutomoviles.getOaPlacaAuto()));

			paramAdmisionAuto.put("chUno", formatoAdmisionAutomoviles.getCheck1());

			paramAdmisionAuto.put("chDos", formatoAdmisionAutomoviles.getCheck2());

			paramAdmisionAuto.put("chTres", formatoAdmisionAutomoviles.getCheck3());

			paramAdmisionAuto.put("chCuatro", formatoAdmisionAutomoviles.getCheck4());

			if (validarNumero(formatoAdmisionAutomoviles.getOaTManual() + "") == 1) {

				paramAdmisionAuto.put("transimisionManual", true);

			} else {

				paramAdmisionAuto.put("transimisionManual", false);

			}
			//////////////////////////////////////////////

			if (formatoAdmisionAutomoviles.getOaDeducible() != null) {
				if (formatoAdmisionAutomoviles.getOaDeducible() == 1) {
					paramAdmisionAuto.put("deducible", true);
				}
				if (formatoAdmisionAutomoviles.getOaDeducible() == 0) {
					paramAdmisionAuto.put("deducible", false);
				}

			}
			////////////////////////////////////////////

			paramAdmisionAuto.put("tipoDeducible",
					validarNumero(formatoAdmisionAutomoviles.getOaTipoDeducible() + ""));

			paramAdmisionAuto.put("sumaAsegurada",
					validarCadena(formatoAdmisionAutomoviles.getOaSumaAsegurada()));

			paramAdmisionAuto.put("porcentajeD",
					validarCadena(formatoAdmisionAutomoviles.getOaPorcentajeDed()));

			paramAdmisionAuto.put("cantidad",
					validarCadena(formatoAdmisionAutomoviles.getOaCantidad()));

			paramAdmisionAuto.put("deducibleAdministrativo",
					validarNumero(formatoAdmisionAutomoviles.getOaAdminDeducible() + ""));

			paramAdmisionAuto.put("nivel", formatoAdmisionAutomoviles.getOaNivelInundacion());

			// ***FIRMA ELECTRONICA ASEGURADO**//

			String firma = formatoAdmisionAutomoviles.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramAdmisionAuto.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA ASEGURADO**//

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String firma1 = formatoAdmisionAutomoviles.getFirmaAjustador();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramAdmisionAuto.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			if (validarNumero(formatoAdmisionAutomoviles.getOaPerdidaTotal() + "") == 1) {

				paramAdmisionAuto.put("perdidaTotal", true);

			}

			else {

				paramAdmisionAuto.put("perdidaTotal", false);

			}

			paramAdmisionAuto.put("descripcionPreexistentes",
					validarCadena(formatoAdmisionAutomoviles.getOaDaniosPre()));

			if (!validarCadena(formatoAdmisionAutomoviles.getOaDaniosPre()).equals(" ")) {

				paramAdmisionAuto.put("daniosPre", true);

			}

			else {

				paramAdmisionAuto.put("daniosPre", false);

			}

			String contenido = validarCadena(formatoAdmisionAutomoviles.getOaDescDanios())
					.replaceAll(",", ", ");

			String nombreRenglon = "desDanios";

			String auxRenglon = "";

			int longitudRenglon = 125;

			int numeroRenglones = 8;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramAdmisionAuto.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramAdmisionAuto.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoAdmisionAutomoviles.getOaAgravamiento());

			nombreRenglon = "posAgravamiento";

			auxRenglon = "";

			longitudRenglon = 50;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramAdmisionAuto.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramAdmisionAuto.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramAdmisionAuto.put("datosAjustador",
					validarCadena(formatoAdmisionAutomoviles.getOaClaveAjustador()) + " "
							+ validarCadena(formatoAdmisionAutomoviles.getOaNomAjustador()));

			String registradas = validarCadena(formatoAdmisionAutomoviles.getOaDaniosPre());

			String posibles = datosCatalogos.get(6).getValores();

			String[] reg = registradas.split(",");

			String[] pos = posibles.split(",");

			for (int i = 1; i <= pos.length; i++) {

				paramAdmisionAuto.put("dp" + (i), 0);

			}

			if (!registradas.equals(" ")) {

				for (int i = 0; i < pos.length; i++) {

					for (int j = 0; j < reg.length; j++) {

						if (pos[i].replaceAll(" ", "").equals(reg[j].replaceAll(" ", ""))) {

							paramAdmisionAuto.put("dp" + (i + 1), 1);

						}

					}

				}

			}

			registradas = validarCadena(formatoAdmisionAutomoviles.getOaDescDanios());

			posibles = datosCatalogos.get(6).getValores();

			String[] reg1 = registradas.split(",");

			String[] pos1 = posibles.split(",");

			for (int i = 1; i <= pos1.length; i++) {

				paramAdmisionAuto.put("ds" + (i), 0);

			}

			if (!registradas.equals(" ")) {

				for (int i = 0; i < pos1.length; i++) {

					for (int j = 0; j < reg1.length; j++) {

						if (pos1[i].replaceAll(" ", "").equals(reg1[j].replaceAll(" ", ""))) {

							paramAdmisionAuto.put("ds" + (i + 1), 1);

						}

					}

				}

			}

			if (formatoAdmisionAutomoviles.getOaCarrilExpres() != null) {

				paramAdmisionAuto.put("carrilExpres", formatoAdmisionAutomoviles.getOaCarrilExpres());

			}

			if (!StringUtils.isEmpty(formatoAdmisionAutomoviles.getOaDanioMenor())) {
				paramAdmisionAuto.put("danioMenor", formatoAdmisionAutomoviles.getOaDanioMenor());

			}
			
			String codigo = formatoAdmisionAutomoviles.getOaCodigoQr();						
			if (codigo != null && !codigo.isEmpty()) {
				InputStream targetcodigo = null;

				byte[] bytes1 = Base64Decoder.decode(codigo);

				targetcodigo = new ByteArrayInputStream(bytes1);
				paramAdmisionAuto.put("codigoQR", targetcodigo);
			}
			
			if (formatoAdmisionAutomoviles.getOaPtEvidente() != null) {

				paramAdmisionAuto.put("ptEvidente", formatoAdmisionAutomoviles.getOaPtEvidente());

			}
			
			if (formatoAdmisionAutomoviles.getOaAbandono() != null) {

				paramAdmisionAuto.put("abandono", formatoAdmisionAutomoviles.getOaAbandono());

			}
			
			paramAdmisionAuto.put("chCinco", formatoAdmisionAutomoviles.getCheck5());

			paramAdmisionAuto.put("chSeis", formatoAdmisionAutomoviles.getCheck6());
			
			crearArchivoError(FORMATO_ADMISION_AUTOMOVILES, fileJrxmlAdmisionAuto, paramAdmisionAuto,
					formatoAdmisionAutomoviles.getOaNumReporte(), formatoAdmisionAutomoviles.getOaNumPoliza(), 
					""+ validarAsegurado(formatoAdmisionAutomoviles.getOaAsegurado()), ou);
		} catch (Exception ex) {
			this.loggerDownload.error("Ocurrio un error en FORMATO_ADMISION_AUTOMOVILES: ",ex);
		}
	}

	@SuppressWarnings("unused")
	public void procesoGarantiaPrendariaError(FormatoGarantiaPrendaria formatoGarantiaPrendaria, OutputStream ou) {
		try {

			fileJrxmlGarantia = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/ContratoGarantiaPrendaria.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			HashMap<String, Object> paramGarantia = new HashMap<String, Object>();

			paramGarantia.put("imgLogoQualitas", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

		
			if (formatoGarantiaPrendaria.getGpFecha() != null) {

				paramGarantia.put("delDia",
						DateFormatUtils.format(formatoGarantiaPrendaria.getGpFecha(), "dd"));

				paramGarantia.put("delMes", mesLetra(formatoGarantiaPrendaria.getGpFecha()));

				paramGarantia.put("delAnio",
						DateFormatUtils.format(formatoGarantiaPrendaria.getGpFecha(), "yyyy"));

				// datosEmail.setFecha(DateFormatUtils.format(formatoGarantiaPrendaria.getGpFecha(),
				// "dd")
				// + "/" + mesLetra(formatoGarantiaPrendaria.getGpFecha()) + "/" +

				// DateFormatUtils.format(formatoGarantiaPrendaria.getGpFecha(), "yyyy"));

			} else {

				paramGarantia.put("delDia", "");

				paramGarantia.put("delMes", "");

				paramGarantia.put("delAnio", "");

			}

			if (formatoGarantiaPrendaria.getEmailDefault() != null) {

				///////////////////
				String poliza = formatoGarantiaPrendaria.getGpNumPoliza();
				String reporte = formatoGarantiaPrendaria.getGpNumReporte();
				String destinatario = "";
				String nombreDoc = "Contrato Garantía Prendaria";
				String cadenaCorreos = formatoGarantiaPrendaria.getEmailDefault();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			if (formatoGarantiaPrendaria.getGpFacturaFecha() != null) {

				Date dateF = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoGarantiaPrendaria.getGpFacturaFecha()));

				paramGarantia.put("fechaF", writeFormatFecha.format(dateF));

			} else {

				paramGarantia.put("fechaF", "");

			}

			if (formatoGarantiaPrendaria.getGpFechaFirma() != null) {

				paramGarantia.put("aLos",
						DateFormatUtils.format(formatoGarantiaPrendaria.getGpFechaFirma(), "dd"));

				paramGarantia.put("delMesF", mesLetra(formatoGarantiaPrendaria.getGpFechaFirma()));

				paramGarantia.put("delAnioF", DateFormatUtils
						.format(formatoGarantiaPrendaria.getGpFechaFirma(), "yyyy").substring(2, 4));

			} else {

				paramGarantia.put("aLos", "");

				paramGarantia.put("delMesF", "");

				paramGarantia.put("delAnioF", "");

			}

			paramGarantia.put("folio", validarCadena(formatoGarantiaPrendaria.getId() + ""));

			paramGarantia.put("senior", validarCadena(formatoGarantiaPrendaria.getGpSr()));

			paramGarantia.put("calle", validarCadena(formatoGarantiaPrendaria.getGpSrCalle()));

			paramGarantia.put("colonia", validarCadena(formatoGarantiaPrendaria.getGpSrColonia()));

			paramGarantia.put("municipio", validarCadena(formatoGarantiaPrendaria.getGpSrMunicipio()));

			paramGarantia.put("codigoP", validarCadena(formatoGarantiaPrendaria.getGpSrCp()));

			paramGarantia.put("ciudad", validarCadena(formatoGarantiaPrendaria.getGpSrCiudad()));

			paramGarantia.put("identidad",
					validarCadena(formatoGarantiaPrendaria.getGpSrIdentificacion()));

			paramGarantia.put("nombreAcredor",
					validarCadena(formatoGarantiaPrendaria.getGpNomAcreedor()));

			paramGarantia.put("nombreDeudor", validarCadena(formatoGarantiaPrendaria.getGpNomDeudor()));

			String cantCGP = "";

			if (!validarCadena(formatoGarantiaPrendaria.getGpCantidad()).equals(" ")) {

				cantCGP = agregarPunto(validarCadena(formatoGarantiaPrendaria.getGpCantidad()));

				cantCGP = formatoMontos(cantCGP);

				paramGarantia.put("cantidadL", formarCantidad(cantCGP).toUpperCase());

				if (cantCGP.length() > 6) {

					cantCGP = separarMontos(cantCGP);

				}

			}

			paramGarantia.put("cantidad", cantCGP);

			paramGarantia.put("autoMarca", validarCadena(formatoGarantiaPrendaria.getGpMarcaAuto()));

			paramGarantia.put("autoTipo", validarCadena(formatoGarantiaPrendaria.getGpTipoAuto()));

			paramGarantia.put("autoModelo", validarCadena(formatoGarantiaPrendaria.getGpModeloAuto()));

			paramGarantia.put("autoPlacas", validarCadena(formatoGarantiaPrendaria.getGpPlacasAuto()));

			paramGarantia.put("autoColor", validarCadena(formatoGarantiaPrendaria.getGpColorAuto()));

			paramGarantia.put("poliza", validarCadena(formatoGarantiaPrendaria.getGpNumPoliza()));

			paramGarantia.put("factura", validarCadena(formatoGarantiaPrendaria.getGpFactura()));

			paramGarantia.put("expedidaF",
					validarCadena(formatoGarantiaPrendaria.getGpFacturaExpedida()));

			paramGarantia.put("noMayor", validarCadena(formatoGarantiaPrendaria.getGpDias()));

			paramGarantia.put("chUno", formatoGarantiaPrendaria.getCheck1());

			paramGarantia.put("chDos", formatoGarantiaPrendaria.getCheck2());

			paramGarantia.put("chTres", formatoGarantiaPrendaria.getCheck3());

			paramGarantia.put("chCuatro", formatoGarantiaPrendaria.getCheck4());

			// ***FIRMA ELECTRONICA ACREE***//

			String firma = formatoGarantiaPrendaria.getFirmaAcreedor();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramGarantia.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA ACREE***//

			// ***FIRMA ELECTRONICA DEUDOR***//

			String firma1 = formatoGarantiaPrendaria.getFirmaDeudor();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramGarantia.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR DEUDOR***//

			String contenido = validarCadena(formatoGarantiaPrendaria.getGpBienes());

			String nombreRenglon = "bienes";

			String auxRenglon = "";

			int longitudRenglon = 120;

			int numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramGarantia.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramGarantia.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramGarantia.put("chCinco", formatoGarantiaPrendaria.getCheck5());

			paramGarantia.put("chSeis", formatoGarantiaPrendaria.getCheck6());
			
			crearArchivoError(FORMATO_GARANTIA_PRENDARIA, fileJrxmlGarantia, paramGarantia,
					formatoGarantiaPrendaria.getGpNumReporte(), formatoGarantiaPrendaria.getGpNumPoliza(),
					"" + validarAsegurado(formatoGarantiaPrendaria.getGpAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	@SuppressWarnings("unused")
	public void procesoReparacionBienesError(FormatoReparacionBienes formatoReparacionBienes,
			List<FormatoCatalogos> datosCatalogos, OutputStream ou) {
		try {
			fileJrxmlReparacion = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/OrdenDeAdmisionReparacionDeBienes.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			HashMap<String, Object> paramReparacion = new HashMap<String, Object>();

			paramReparacion.put("imgLogoQualitas", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoReparacionBienes.getFechaHora() != null) {

				paramReparacion.put("fecha",
						DateFormatUtils.format(formatoReparacionBienes.getFechaHora(), "dd/MM/yyyy"));

				paramReparacion.put("hora",
						DateFormatUtils.format(formatoReparacionBienes.getFechaHora(), "HH:mm:ss"));

				// datosEmail.setFecha(
				// DateFormatUtils.format(formatoReparacionBienes.getFechaHora(),
				// "dd/MM/yyyy"));

			} else {

				paramReparacion.put("fecha", "");

				paramReparacion.put("hora", "");

			}

			if (formatoReparacionBienes.getRbEmailAfectado() != null) {
				///////////////////
				String poliza = formatoReparacionBienes.getRbNumPoliza();
				String reporte = formatoReparacionBienes.getRbNumReporte();
				String destinatario = "";
				String nombreDoc = "Reparación de Bienes";
				String cadenaCorreos = formatoReparacionBienes.getRbEmailAfectado();
			//	agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////
			}

			paramReparacion.put("numFolio", validarCadena(formatoReparacionBienes.getId() + ""));

			paramReparacion.put("folioElectronico",
					validarCadena(formatoReparacionBienes.getRbFolioElectro()));

			paramReparacion.put("numSiniestro",
					validarCadena(formatoReparacionBienes.getRbNumSiniestro()));

			paramReparacion.put("numReporte", validarCadena(formatoReparacionBienes.getRbNumReporte()));

			if (validarNumero(validarAsegurado(formatoReparacionBienes.getRbAsegurado()) + "") != 1) {

				paramReparacion.put("tercero", true);

			} else if (validarNumero(
					validarAsegurado(formatoReparacionBienes.getRbAsegurado()) + "") == 1) {

				paramReparacion.put("tercero", false);
			}

			paramReparacion.put("numPoliza", validarCadena(formatoReparacionBienes.getRbNumPoliza()));

			paramReparacion.put("numEndoso", validarCadena(formatoReparacionBienes.getRbNumEndoso()));

			paramReparacion.put("numInciso", validarCadena(formatoReparacionBienes.getRbNumInciso()));

			paramReparacion.put("nomRepara", validarCadena(formatoReparacionBienes.getRbNomRepara()));

			paramReparacion.put("emailRepara",
					validarCadenaMail(formatoReparacionBienes.getRbEmailRepara()));

			paramReparacion.put("emailAfectado",
					validarCadenaMail(formatoReparacionBienes.getRbEmailAfectado()));

			paramReparacion.put("telRepara",
					formatoNumero(validarCadena(formatoReparacionBienes.getRbTelRepara())));

			paramReparacion.put("nomAfectado",
					validarCadena(formatoReparacionBienes.getRbNomAfectado()));

			paramReparacion.put("representanteA",
					validarCadena(formatoReparacionBienes.getRbRepreAfectado()));

			paramReparacion.put("telAfectado",
					formatoNumero(validarCadena(formatoReparacionBienes.getRbTelAfectado())));

			paramReparacion.put("domAfectado",
					validarCadena(formatoReparacionBienes.getRbDomAfectado()));

			paramReparacion.put("colAfectado", validarCadena(formatoReparacionBienes.getRbMunicipio()));

			paramReparacion.put("estadoAfectado", validarCadena(formatoReparacionBienes.getRbEstado()));

			paramReparacion.put("medidaLong", validarCadena(formatoReparacionBienes.getRbMedLong()));

			paramReparacion.put("medidaAlto", validarCadena(formatoReparacionBienes.getRbMedAlto()));

			paramReparacion.put("medidaAncho", validarCadena(formatoReparacionBienes.getRbMedAncho()));

			paramReparacion.put("marca", validarCadena(formatoReparacionBienes.getRbCarMarca()));

			paramReparacion.put("modelo", validarCadena(formatoReparacionBienes.getRbCarModelo()));

			paramReparacion.put("tramo", validarCadena(formatoReparacionBienes.getRbTramo()));

			paramReparacion.put("kilometro", validarCadena(formatoReparacionBienes.getRbKm()));

			paramReparacion.put("datosAjustador",
					validarCadena(formatoReparacionBienes.getRbClaveAjustador()) + " "
							+ validarCadena(formatoReparacionBienes.getRbNomAjustador()));

			paramReparacion.put("datosAsegurado",
					validarCadena(formatoReparacionBienes.getRbNomAsegurado()));

			paramReparacion.put("chUno", formatoReparacionBienes.getCheck1());

			paramReparacion.put("chDos", formatoReparacionBienes.getCheck2());

			paramReparacion.put("chTres", formatoReparacionBienes.getCheck3());

			paramReparacion.put("chCuatro", formatoReparacionBienes.getCheck4());

			// ***FIRMA ELECTRONICA**//

			String firma = formatoReparacionBienes.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramReparacion.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA**//

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String firma1 = formatoReparacionBienes.getFirmaAjustador();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramReparacion.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			if (validarNumero(formatoReparacionBienes.getRbCuerpoA() + "") == 1) {

				paramReparacion.put("cuerpoA", true);

			} else if (validarNumero(formatoReparacionBienes.getRbCuerpoA() + "") == 0) {

				paramReparacion.put("cuerpoB", false);

			}

			String contenido = validarCadena(formatoReparacionBienes.getRbObservaciones());

			String nombreRenglon = "observacion";

			String auxRenglon = "";

			int longitudRenglon = 50;

			int numeroRenglones = 5;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramReparacion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramReparacion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoReparacionBienes.getRbDesDanios());

			nombreRenglon = "desDanios";

			auxRenglon = "";

			longitudRenglon = 50;

			numeroRenglones = 6;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramReparacion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramReparacion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramReparacion.put("numFotos", validarCadena(formatoReparacionBienes.getRbNumFotos()));

			if (validarNumero(formatoReparacionBienes.getRbDaniosPre() + "") == 1) {

				paramReparacion.put("daniosPre", true);

			} else if (validarNumero(formatoReparacionBienes.getRbDaniosPre() + "") == 0) {

				paramReparacion.put("daniosPre", false);

			}

			contenido = validarCadena(formatoReparacionBienes.getRbOtros());

			nombreRenglon = "comentarios";

			auxRenglon = "";

			longitudRenglon = 50;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramReparacion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramReparacion.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			for (int i = 1; i <= 48; i++) {

				paramReparacion.put("d" + i, false);

			}

			// AQUI

			String idReg = validarCadena(formatoReparacionBienes.getRbDanios());

			if (!idReg.equals(" ")) {

				String idPos = datosCatalogos.get(1).getValores();

				String[] idRegistradas = idReg.split(",");

				String[] idPosibles = idPos.split(",");

				for (int i = 0; i < idRegistradas.length; i++) {

					for (int j = 0; j < idPosibles.length; j++)

					{

						if (idRegistradas[i].replaceAll(" ", "")
								.equals(idPosibles[j].replaceAll(" ", ""))) {

							paramReparacion.put("d" + ((int) j + 1), true);

						}

					}

				}

			}

			for (int i = 1; i <= 17; i++) {

				paramReparacion.put("m" + i, false);

			}

			String idReg1 = validarCadena(formatoReparacionBienes.getRbMaterial());

			if (!idReg1.equals(" ")) {

				String idPos1 = datosCatalogos.get(0).getValores();

				String[] idRegistradas1 = idReg1.split(",");

				String[] idPosibles1 = idPos1.split(",");

				for (int i = 0; i < idRegistradas1.length; i++) {

					for (int j = 0; j < idPosibles1.length; j++)

					{

						if (idRegistradas1[i].replaceAll(" ", "")
								.equals(idPosibles1[j].replaceAll(" ", ""))) {

							paramReparacion.put("m" + ((int) j + 1), true);

						}

					}

				}

			}
			
			paramReparacion.put("chCinco", formatoReparacionBienes.getCheck5());

			paramReparacion.put("chSeis", formatoReparacionBienes.getCheck6());
			
			crearArchivoError(FORMATO_REPARACION_BIENES, fileJrxmlReparacion, paramReparacion,
					formatoReparacionBienes.getRbNumReporte(), formatoReparacionBienes.getRbNumPoliza(),
					"" + validarAsegurado(formatoReparacionBienes.getRbAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	
	
	@SuppressWarnings({ "unused", "deprecation" })
	public void procesoFValeAmbulanciaError(FormatoValeAmbulancia formatoValeAmbulancia, OutputStream ou) {
		try {
			fileJrxmlAmbulancia = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/ValeParaServicioDeAmbulancia.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			HashMap<String, Object> paramAmbulancia = new HashMap<String, Object>();

			paramAmbulancia.put("imgLogoQualitas", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoValeAmbulancia.getVaHora() != null) {

				paramAmbulancia.put("fecha",
						DateFormatUtils.format(formatoValeAmbulancia.getVaHora(), "dd/MM/yyyy"));

				paramAmbulancia.put("hora",
						DateFormatUtils.format(formatoValeAmbulancia.getVaHora(), "HH:mm:ss"));

				paramAmbulancia.put("lugarFecha",
						validarCadena(formatoValeAmbulancia.getVaLugar()) + " A "
								+ formatoValeAmbulancia.getVaHora().getDate() + " DEL "
								+ mesLetra(formatoValeAmbulancia.getVaHora()) + " DEL "
								+ (formatoValeAmbulancia.getVaHora().getYear() + 1900));

				// datosEmail.setFecha(
				// DateFormatUtils.format(formatoValeAmbulancia.getVaHora(), "dd/MM/yyyy"));

			} else {

				paramAmbulancia.put("fecha", "");

				paramAmbulancia.put("hora", "");

				paramAmbulancia.put("lugarFecha",
						validarCadena(formatoValeAmbulancia.getVaLugar()) + "");

			}

			if (formatoValeAmbulancia.getEmailDefault() != null) {

				///////////////////
				String poliza = formatoValeAmbulancia.getVaNumPoliza();
				String reporte = formatoValeAmbulancia.getVaNumReporte();
				String destinatario = "";
				String nombreDoc = "Vale Ambulancia";
				String cadenaCorreos = formatoValeAmbulancia.getEmailDefault();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			paramAmbulancia.put("numReporte", validarCadena(formatoValeAmbulancia.getVaNumReporte()));

			paramAmbulancia.put("numSiniestro",
					validarCadena(formatoValeAmbulancia.getVaNumSiniestro()));

			paramAmbulancia.put("folio", validarCadena(formatoValeAmbulancia.getId() + ""));

			paramAmbulancia.put("folioElectronico",
					validarCadena(formatoValeAmbulancia.getVaFolioElectro()));

			paramAmbulancia.put("telefonoPaciente",
					formatoNumero(validarCadena(formatoValeAmbulancia.getVaTelPaciente())));

			paramAmbulancia.put("direccionPaciente",
					validarCadena(formatoValeAmbulancia.getVaDirPaciente()));

			if (validarNumero(validarAsegurado(formatoValeAmbulancia.getVaAsegurado()) + "") == 1) {

				paramAmbulancia.put("asegurado", true);

				paramAmbulancia.put("tercero", false);

			} else if (validarNumero(
					validarAsegurado(formatoValeAmbulancia.getVaAsegurado()) + "") != 1) {

				paramAmbulancia.put("tercero", true);

				paramAmbulancia.put("asegurado", false);

			}

			paramAmbulancia.put("numPoliza", validarCadena(formatoValeAmbulancia.getVaNumPoliza()));

			paramAmbulancia.put("numEndoso", validarCadena(formatoValeAmbulancia.getVaNumEndoso()));

			paramAmbulancia.put("numInciso", validarCadena(formatoValeAmbulancia.getVaNumInciso()));

			paramAmbulancia.put("nombre", validarCadena(formatoValeAmbulancia.getVaNomRazon()));

			paramAmbulancia.put("hospital", validarCadena(formatoValeAmbulancia.getVaHospital()));

			paramAmbulancia.put("nombrePaciente",
					validarCadena(formatoValeAmbulancia.getVaNomPaciente()));

			paramAmbulancia.put("edadPaciente",
					validarCadena(formatoValeAmbulancia.getVaEdadPaciente()));

			paramAmbulancia.put("sexo", validarCadena(formatoValeAmbulancia.getVaSexo()));

			paramAmbulancia.put("diagnosticoPre",
					validarCadena(formatoValeAmbulancia.getVaDiagnostico()));

			paramAmbulancia.put("datosAsegurado",
					validarCadena(formatoValeAmbulancia.getVaDatosConductor()));

			paramAmbulancia.put("datosAjustador",
					validarCadena(formatoValeAmbulancia.getVaClaveAjustador()) + " "
							+ validarCadena(formatoValeAmbulancia.getVaNomAjustador()));

			paramAmbulancia.put("datosLesionado",
					validarCadena(formatoValeAmbulancia.getVaDatosLesionado()));

			paramAmbulancia.put("chUno", formatoValeAmbulancia.getCheck1());

			paramAmbulancia.put("chDos", formatoValeAmbulancia.getCheck2());

			paramAmbulancia.put("chTres", formatoValeAmbulancia.getCheck3());

			paramAmbulancia.put("chCuatro", formatoValeAmbulancia.getCheck4());

			// ***FIRMA ELECTRONICA CONDUCTOR**//

			String firma = formatoValeAmbulancia.getFirmaConductor();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramAmbulancia.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA CONDUCTOR**//

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String firma1 = formatoValeAmbulancia.getFirmaAjustador();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramAmbulancia.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			// ***FIRMA ELECTRONICA LESIONADO**//

			String firma2 = formatoValeAmbulancia.getFirmaLesionado();

			InputStream targetStream2 = null;

			if (firma2 != null && !firma2.isEmpty()) {

				byte[] bytes2 = Base64Decoder.decode(firma2);

				targetStream2 = new ByteArrayInputStream(bytes2);

			}

			paramAmbulancia.put("imgBits2", targetStream2);

			// ***FIRMA ELECTRONICA LESIONADO**//
			
			paramAmbulancia.put("chCinco", formatoValeAmbulancia.getCheck5());

			paramAmbulancia.put("chSeis", formatoValeAmbulancia.getCheck6());
			
			crearArchivoError(FORMATO_VALE_AMBULANCIA, fileJrxmlAmbulancia, paramAmbulancia,
					formatoValeAmbulancia.getVaNumReporte(), formatoValeAmbulancia.getVaNumPoliza(),
					"" + validarAsegurado(formatoValeAmbulancia.getVaAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	
	@SuppressWarnings("unused")
	public void procesoInspeccionPesadoError(FormatoInspeccionPesado formatoInspeccionPesado, OutputStream ou) {

		try {
			fileJrxmlInspeccionPesado = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/FormatoUnicoInspeccionEquipoPesado.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			HashMap<String, Object> paramInspeccionPesado = new HashMap<String, Object>();

			paramInspeccionPesado.put("imgLogoQualitas", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoInspeccionPesado.getIpFecha() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoInspeccionPesado.getIpFecha()));

				paramInspeccionPesado.put("fecha", writeFormatFecha.format(date));

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramInspeccionPesado.put("fecha", "");

			}

			if (formatoInspeccionPesado.getIpEmail() != null) {

				///////////////////
				String poliza = formatoInspeccionPesado.getIpNumPoliza();
				String reporte = formatoInspeccionPesado.getIpNumReporte();
				String destinatario = "";
				String nombreDoc = "Inspección Vehículos Pesados";
				String cadenaCorreos = formatoInspeccionPesado.getIpEmail();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			if (formatoInspeccionPesado.getIpDiaHora() != null) {

				Date dh = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoInspeccionPesado.getIpDiaHora()));

				paramInspeccionPesado.put("diaHora", writeFormatFecha.format(dh));

			} else {

				paramInspeccionPesado.put("diaHora", "");

			}

			if (formatoInspeccionPesado.getIpFechaInspeccion() != null) {

				Date inspeccion = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoInspeccionPesado.getIpFechaInspeccion()));

				paramInspeccionPesado.put("fechaInspeccion", writeFormatFecha.format(inspeccion));

			} else {

				paramInspeccionPesado.put("fechaInspeccion", "");

			}

			paramInspeccionPesado.put("folio", validarCadena(formatoInspeccionPesado.getId() + ""));

			paramInspeccionPesado.put("solicitante",
					validarCadena(formatoInspeccionPesado.getIpSolicitante()));

			paramInspeccionPesado.put("oficina", validarCadena(formatoInspeccionPesado.getIpOficina()));

			paramInspeccionPesado.put("telefono",
					formatoNumero(validarCadena(formatoInspeccionPesado.getIpTelefono())));

			paramInspeccionPesado.put("atencion",
					validarCadena(formatoInspeccionPesado.getIpAtencion()));

			paramInspeccionPesado.put("ubicacion",
					validarCadena(formatoInspeccionPesado.getIpUbicacion()));

			paramInspeccionPesado.put("email", validarCadenaMail(formatoInspeccionPesado.getIpEmail()));

			paramInspeccionPesado.put("tipo", validarCadena(formatoInspeccionPesado.getIpTipo()));

			paramInspeccionPesado.put("modelo", validarCadena(formatoInspeccionPesado.getIpModelo()));

			paramInspeccionPesado.put("placas", validarCadena(formatoInspeccionPesado.getIpPlacas()));

			paramInspeccionPesado.put("puertasD",
					validarCadena(formatoInspeccionPesado.getIpPuertasD()));

			paramInspeccionPesado.put("estandarT",
					validarCadena(formatoInspeccionPesado.getIpEstandarT()));

			paramInspeccionPesado.put("color", validarCadena(formatoInspeccionPesado.getIpColor()));

			paramInspeccionPesado.put("marca", validarCadena(formatoInspeccionPesado.getIpMarca()));

			paramInspeccionPesado.put("numSerie",
					validarCadena(formatoInspeccionPesado.getIpNumSerie()));

			paramInspeccionPesado.put("kilometraje",
					validarCadena(formatoInspeccionPesado.getIpKilometraje()));

			paramInspeccionPesado.put("chUno", formatoInspeccionPesado.getCheck1());

			paramInspeccionPesado.put("chDos", formatoInspeccionPesado.getCheck2());

			paramInspeccionPesado.put("chTres", formatoInspeccionPesado.getCheck3());

			paramInspeccionPesado.put("chCuatro", formatoInspeccionPesado.getCheck4());

			// ***FIRMA ELECTRONICA CLIENTE***//

			String firma = formatoInspeccionPesado.getFirmaCliente();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramInspeccionPesado.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA CLIENTE**//

			// ***FIRMA ELECTRONICA AGENTE**//

			String firma1 = formatoInspeccionPesado.getFirmaAgente();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramInspeccionPesado.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AGENTE**//

			String contenido = validarCadena(formatoInspeccionPesado.getIpObservaciones());

			String nombreRenglon = "observaciones";

			String auxRenglon = "";

			int longitudRenglon = 50;

			int numeroRenglones = 12;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramInspeccionPesado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramInspeccionPesado.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramInspeccionPesado.put("procedencia",
					validarNumero(formatoInspeccionPesado.getIpProcedencia() + ""));

			paramInspeccionPesado.put("totalFotos",
					validarCadena(formatoInspeccionPesado.getIpTotalFotos()));

			paramInspeccionPesado.put("tipoEncargado",
					validarNumero(formatoInspeccionPesado.getIpTipoEncargado() + ""));

			paramInspeccionPesado.put("nombreCliente",
					validarCadena(formatoInspeccionPesado.getIpNomCliente()));

			paramInspeccionPesado.put("nombreAjustador",
					validarCadena(formatoInspeccionPesado.getIpNomAjustador()));

			paramInspeccionPesado.put("calificacion",
					validarNumero(formatoInspeccionPesado.getIpCalificacion() + ""));

			if (validarNumero(formatoInspeccionPesado.getIpCirculacion() + "") == 1) {

				paramInspeccionPesado.put("circulacion", true);

			}

			else if (validarNumero(formatoInspeccionPesado.getIpCirculacion() + "") == 0) {

				paramInspeccionPesado.put("circulacion", false);

			}

			if (validarNumero(formatoInspeccionPesado.getIpImportacion1() + "") == 1) {

				paramInspeccionPesado.put("importacion1", true);

			}

			if (validarNumero(formatoInspeccionPesado.getIpImportacion2() + "") == 1) {

				paramInspeccionPesado.put("importacion2", true);

			}

			if (validarNumero(formatoInspeccionPesado.getIpTCirculacion1() + "") == 1) {

				paramInspeccionPesado.put("t_circulacion_1", true);

			}

			if (validarNumero(formatoInspeccionPesado.getIpTCirculacion2() + "") == 1) {

				paramInspeccionPesado.put("t_circulacion_2", true);

			}

			if (validarNumero(formatoInspeccionPesado.getIpSalvamentos() + "") == 1) {

				paramInspeccionPesado.put("salvamento", true);

			}

			if (validarNumero(formatoInspeccionPesado.getIpPago() + "") == 1) {

				paramInspeccionPesado.put("pago", true);

			}

			if (validarNumero(formatoInspeccionPesado.getIpEquipo() + "") == 1) {

				paramInspeccionPesado.put("equipo", true);

			}

			if (validarNumero(formatoInspeccionPesado.getIpAdaptaciones() + "") == 1) {

				paramInspeccionPesado.put("adaptaciones", true);

			}

			if (validarNumero(formatoInspeccionPesado.getIpPagoSiNo() + "") == 1) {

				paramInspeccionPesado.put("pago_SI_NO", true);

			}

			else if (validarNumero(formatoInspeccionPesado.getIpPagoSiNo() + "") == 0) {

				paramInspeccionPesado.put("pago_SI_NO", false);

			}

			if (validarNumero(formatoInspeccionPesado.getIpEquipoSiNo() + "") == 1) {

				paramInspeccionPesado.put("equipo_SI_NO", true);

			}

			else if (validarNumero(formatoInspeccionPesado.getIpEquipoSiNo() + "") == 0) {

				paramInspeccionPesado.put("equipo_SI_NO", false);

			}

			if (validarNumero(formatoInspeccionPesado.getIpAdaptacionesSiNo() + "") == 1) {

				paramInspeccionPesado.put("adaptaciones_SI_NO", true);

			}

			else if (validarNumero(formatoInspeccionPesado.getIpAdaptacionesSiNo() + "") == 0) {

				paramInspeccionPesado.put("adaptaciones_SI_NO", false);

			}

			if (validarNumero(formatoInspeccionPesado.getIpDocumentacion1() + "") == 1) {

				paramInspeccionPesado.put("documentacion_1", true);

			}

			else if (validarNumero(formatoInspeccionPesado.getIpDocumentacion1() + "") == 0) {

				paramInspeccionPesado.put("documentacion_1", false);

			}

			if (validarNumero(formatoInspeccionPesado.getIpDocumentacion2() + "") == 1) {

				paramInspeccionPesado.put("documentacion_2", true);

			}

			else if (validarNumero(formatoInspeccionPesado.getIpDocumentacion2() + "") == 0) {

				paramInspeccionPesado.put("documentacion_2", false);

			}

			if (validarNumero(formatoInspeccionPesado.getIpAseguradoCompa() + "") == 1) {

				paramInspeccionPesado.put("asegurado_compania", true);

			}

			else if (validarNumero(formatoInspeccionPesado.getIpAseguradoCompa() + "") == 0) {

				paramInspeccionPesado.put("asegurado_compania", false);

			}

			paramInspeccionPesado.put("numPoliza",
					validarCadena(formatoInspeccionPesado.getIpNumPoliza()));

			paramInspeccionPesado.put("compania",
					validarCadena(formatoInspeccionPesado.getIpCompania()));

			paramInspeccionPesado.put("chCinco", formatoInspeccionPesado.getCheck5());

			paramInspeccionPesado.put("chSeis", formatoInspeccionPesado.getCheck6());
			
			
			crearArchivoError(F_INSPECCION_PESADO, fileJrxmlInspeccionPesado, paramInspeccionPesado,
					formatoInspeccionPesado.getIpNumReporte(), formatoInspeccionPesado.getIpNumPoliza(),
					"" + validarAsegurado(formatoInspeccionPesado.getIpAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	@SuppressWarnings("unused")
	public void procesoInspeccionMotoError(FormatoInspeccionMoto formatoInspeccionMoto, OutputStream ou) {
		try {
			fileJrxmlInspeccionMoto = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/FormatoUnicoInspeccionMotocicletas.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			HashMap<String, Object> paramInspeccionMoto = new HashMap<String, Object>();

			paramInspeccionMoto.put("imgLogoQualitas", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoInspeccionMoto.getImFecha() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoInspeccionMoto.getImFecha()));

				paramInspeccionMoto.put("fecha", writeFormatFecha.format(date));

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramInspeccionMoto.put("fecha", "");

			}

			if (formatoInspeccionMoto.getImEmail() != null) {

				///////////////////
				String poliza = formatoInspeccionMoto.getImNumPoliza();
				String reporte = formatoInspeccionMoto.getImNumReporte();
				String destinatario = "";
				String nombreDoc = "Inspección Motocicletas";
				String cadenaCorreos = formatoInspeccionMoto.getImEmail();
			//	agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			if (formatoInspeccionMoto.getImDiaHora() != null) {

				Date dh = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoInspeccionMoto.getImDiaHora()));

				paramInspeccionMoto.put("diaHora", writeFormatFecha.format(dh));

			} else {

				paramInspeccionMoto.put("diaHora", "");

			}

			if (formatoInspeccionMoto.getImFechaInspeccion() != null) {

				Date inspeccion = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoInspeccionMoto.getImFechaInspeccion()));

				paramInspeccionMoto.put("fechaInspeccion", writeFormatFecha.format(inspeccion));

			} else {

				paramInspeccionMoto.put("fechaInspeccion", "");

			}

			paramInspeccionMoto.put("folio", validarCadena(formatoInspeccionMoto.getId() + ""));

			paramInspeccionMoto.put("solicitante",
					validarCadena(formatoInspeccionMoto.getImSolicitante()));

			paramInspeccionMoto.put("oficina", validarCadena(formatoInspeccionMoto.getImOficina()));

			paramInspeccionMoto.put("telefono",
					formatoNumero(validarCadena(formatoInspeccionMoto.getImTelefono())));

			paramInspeccionMoto.put("atencion", validarCadena(formatoInspeccionMoto.getImAtencion()));

			paramInspeccionMoto.put("ubicacion", validarCadena(formatoInspeccionMoto.getImUbicacion()));

			paramInspeccionMoto.put("email", validarCadenaMail(formatoInspeccionMoto.getImEmail()));

			paramInspeccionMoto.put("marca", validarCadena(formatoInspeccionMoto.getImMarca()));

			paramInspeccionMoto.put("tipo", validarCadena(formatoInspeccionMoto.getImTipo()));

			paramInspeccionMoto.put("modelo", validarCadena(formatoInspeccionMoto.getImModelo()));

			paramInspeccionMoto.put("placas", validarCadena(formatoInspeccionMoto.getImPlacas()));

			paramInspeccionMoto.put("estandarT", validarCadena(formatoInspeccionMoto.getImEstandarT()));

			paramInspeccionMoto.put("color", validarCadena(formatoInspeccionMoto.getImColor()));

			paramInspeccionMoto.put("numSerie", validarCadena(formatoInspeccionMoto.getImNumSerie()));

			paramInspeccionMoto.put("kilometraje",
					validarCadena(formatoInspeccionMoto.getImKilometraje()));

			paramInspeccionMoto.put("procedencia",
					validarNumero(formatoInspeccionMoto.getImProcedencia() + ""));

			paramInspeccionMoto.put("chUno", formatoInspeccionMoto.getCheck1());

			paramInspeccionMoto.put("chDos", formatoInspeccionMoto.getCheck2());

			paramInspeccionMoto.put("chTres", formatoInspeccionMoto.getCheck3());

			paramInspeccionMoto.put("chCuatro", formatoInspeccionMoto.getCheck4());

			// ***FIRMA ELECTRONICA**//

			String firma = formatoInspeccionMoto.getFirmaCliente();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramInspeccionMoto.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA**//

			// ***FIRMA ELECTRONICA AGENTE**//

			String firma1 = formatoInspeccionMoto.getFirmaAgente();

			InputStream targetStream1 = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramInspeccionMoto.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AGENTE**//

			String contenido = validarCadena(formatoInspeccionMoto.getImObservaciones());

			String nombreRenglon = "observaciones";

			String auxRenglon = "";

			int longitudRenglon = 50;

			int numeroRenglones = 12;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramInspeccionMoto.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramInspeccionMoto.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramInspeccionMoto.put("procedencia",
					validarNumero(formatoInspeccionMoto.getImProcedencia() + ""));

			paramInspeccionMoto.put("totalFotos",
					validarCadena(formatoInspeccionMoto.getImTotalFotos()));

			paramInspeccionMoto.put("tipoEncargado",
					validarNumero(formatoInspeccionMoto.getImTipoEncargado() + ""));

			paramInspeccionMoto.put("nombreCliente",
					validarCadena(formatoInspeccionMoto.getImNomCliente()));

			paramInspeccionMoto.put("nombreAjustador",
					validarCadena(formatoInspeccionMoto.getImNomAjustador()));

			if (validarNumero(formatoInspeccionMoto.getImCirculacion() + "") == 1) {

				paramInspeccionMoto.put("circulacion", true);

			}

			else if (validarNumero(formatoInspeccionMoto.getImCirculacion() + "") == 0) {

				paramInspeccionMoto.put("circulacion", false);

			}

			if (validarNumero(formatoInspeccionMoto.getImImportacion1() + "") == 1) {

				paramInspeccionMoto.put("importacion1", true);

			}

			if (validarNumero(formatoInspeccionMoto.getImTCirculacion1() + "") == 1) {

				paramInspeccionMoto.put("t_circulacion_1", true);

			}

			if (validarNumero(formatoInspeccionMoto.getImPago() + "") == 1) {

				paramInspeccionMoto.put("pago", true);

			}

			if (validarNumero(formatoInspeccionMoto.getImPagoSiNo() + "") == 1) {

				paramInspeccionMoto.put("pago_SI_NO", true);

			}

			else if (validarNumero(formatoInspeccionMoto.getImPagoSiNo() + "") == 0) {

				paramInspeccionMoto.put("pago_SI_NO", false);

			}

			if (validarNumero(formatoInspeccionMoto.getImEquipoSiNo() + "") == 1) {

				paramInspeccionMoto.put("equipo_SI_NO", true);

			}

			else if (validarNumero(formatoInspeccionMoto.getImEquipoSiNo() + "") == 0) {

				paramInspeccionMoto.put("equipo_SI_NO", false);

			}

			if (validarNumero(formatoInspeccionMoto.getImAdaptacionesSiNo() + "") == 1) {

				paramInspeccionMoto.put("adaptaciones_SI_NO", true);

			}

			else if (validarNumero(formatoInspeccionMoto.getImAdaptacionesSiNo() + "") == 0) {

				paramInspeccionMoto.put("adaptaciones_SI_NO", false);

			}

			if (validarNumero(formatoInspeccionMoto.getImDocumentacion1() + "") == 1) {

				paramInspeccionMoto.put("documentacion_1", true);

			}

			else if (validarNumero(formatoInspeccionMoto.getImDocumentacion1() + "") == 0) {

				paramInspeccionMoto.put("documentacion_1", false);

			}

			if (validarNumero(formatoInspeccionMoto.getImDocumentacion2() + "") == 1) {

				paramInspeccionMoto.put("documentacion_2", true);

			}

			else if (validarNumero(formatoInspeccionMoto.getImDocumentacion2() + "") == 0) {

				paramInspeccionMoto.put("documentacion_2", false);

			}

			if (validarNumero(formatoInspeccionMoto.getImAseguradoCompa() + "") == 1) {

				paramInspeccionMoto.put("asegurado_compania", true);

			}

			else if (validarNumero(formatoInspeccionMoto.getImAseguradoCompa() + "") == 0) {

				paramInspeccionMoto.put("asegurado_compania", false);

			}

			paramInspeccionMoto.put("numPoliza", validarCadena(formatoInspeccionMoto.getImNumPoliza()));

			paramInspeccionMoto.put("compania", validarCadena(formatoInspeccionMoto.getImCompania()));

			paramInspeccionMoto.put("chCinco", formatoInspeccionMoto.getCheck5());

			paramInspeccionMoto.put("chSeis", formatoInspeccionMoto.getCheck6());
			
			crearArchivoError(F_INSPECCION_MOTO, fileJrxmlInspeccionMoto, paramInspeccionMoto,
					formatoInspeccionMoto.getImNumReporte(), formatoInspeccionMoto.getImNumPoliza(),
					"" + validarAsegurado(formatoInspeccionMoto.getImAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	@SuppressWarnings("unused")
	public void procesoAdmisionPesadoCompletoError(FormatoAdmisionPesado formatoAdmisionPesado,
			List<FormatoCatalogos> datosCatalogos, OutputStream ou) {
		try {
			fileJrxmlAdmisionPesado = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/OrdenDeAdmisionPesadoCompleto.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			String imgCamion = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/camion.PNG").getFile().getPath();

			String imgTanque = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/tanque.PNG").getFile().getPath();

			String imgCaja = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/caja.PNG").getFile().getPath();

			HashMap<String, Object> paramPesado = new HashMap<String, Object>();

			paramPesado.put("imgLogoQualitas", imgLogoQualitas);

			paramPesado.put("imaCamion", imgCamion);

			paramPesado.put("imgTanque", imgTanque);

			paramPesado.put("imgCaja", imgCaja);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			Date vig = new Date();

			if (formatoAdmisionPesado.getOfFecha() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoAdmisionPesado.getOfFecha()) + "");

				// datosEmail.setFecha(writeFormatFecha.format(date));

				Calendar calendar = Calendar.getInstance();

				calendar.setTime(date);

				calendar.add(Calendar.DAY_OF_YEAR, 7);

				vig = readFormat.parse(
						new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(calendar.getTime()) + "");

				paramPesado.put("fecha", writeFormatFecha.format(date) + "");

				paramPesado.put("hora", writeFormatHora.format(date) + " HRS");

				paramPesado.put("vigencia", writeFormatFecha.format(vig));

			} else {

				paramPesado.put("fecha", "");

				paramPesado.put("hora", "");

				paramPesado.put("vigencia", "");

			}

			if (formatoAdmisionPesado.getEmailDefault() != null) {

				///////////////////
				String poliza = formatoAdmisionPesado.getOpNumPoliza();
				String reporte = formatoAdmisionPesado.getOpNumReporte();
				String destinatario = "";
				String nombreDoc = "Admisión Vehículos Pesados";
				String cadenaCorreos = formatoAdmisionPesado.getEmailDefault();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				paramPesado.put("correoDef", formatoAdmisionPesado.getEmailDefault());
				////////////////////

			}

			paramPesado.put("numFolio", validarCadena(formatoAdmisionPesado.getId() + ""));

			paramPesado.put("folioElectronico",
					validarCadena(formatoAdmisionPesado.getOpFolioElectro()));

			paramPesado.put("numSiniestro", validarCadena(formatoAdmisionPesado.getOpNumSiniestro()));

			paramPesado.put("numReporte", validarCadena(formatoAdmisionPesado.getOpNumReporte()));

			paramPesado.put("numPoliza", validarCadena(formatoAdmisionPesado.getOpNumPoliza()));

			paramPesado.put("numInciso", validarCadena(formatoAdmisionPesado.getOpNumInciso()));

			paramPesado.put("numEndoso", validarCadena(formatoAdmisionPesado.getOpNumEndoso()));

			if (formatoAdmisionPesado.getNiu() != null) {

				paramPesado.put("niu", formatoAdmisionPesado.getNiu() + "");

			}

			paramPesado.put("nomAsegurado", validarCadena(formatoAdmisionPesado.getOpNomAsegurado()));

			paramPesado.put("telAsegurado",
					formatoNumero(validarCadena(formatoAdmisionPesado.getOpTelAsegurado())));

			paramPesado.put("nomConductor", validarCadena(formatoAdmisionPesado.getOpConductorAse()));

			paramPesado.put("telConductor",
					formatoNumero(validarCadena(formatoAdmisionPesado.getOpTelConAse())));

			paramPesado.put("marcaAsegurado", validarCadena(formatoAdmisionPesado.getOpMarcaAutoAse()));

			paramPesado.put("tipoAsegurado", validarCadena(formatoAdmisionPesado.getOpTipoAutoAse()));

			paramPesado.put("modeloAsegurado", validarCadena(formatoAdmisionPesado.getOpModeloAse()));

			paramPesado.put("colorAsegurado", validarCadena(formatoAdmisionPesado.getOpColorAutoAse()));

			paramPesado.put("placasAsegurado",
					validarCadena(formatoAdmisionPesado.getOpPlacasAutoAse()));

			paramPesado.put("motorAsegurado", validarCadena(formatoAdmisionPesado.getOpMotorAutoAse()));

			paramPesado.put("serieAsegurado", validarCadena(formatoAdmisionPesado.getOpSerieAutoAse()));

			paramPesado.put("sumaAsegurado", validarCadena(formatoAdmisionPesado.getOpSumaAsegurado()));

			paramPesado.put("nomTercero", validarCadena(formatoAdmisionPesado.getOpNomAfe()));

			paramPesado.put("telTercero",
					formatoNumero(validarCadena(formatoAdmisionPesado.getOpTelAfe())));

			paramPesado.put("nomConductorT", validarCadena(formatoAdmisionPesado.getOpConductorAfe()));

			paramPesado.put("telConductorT",
					formatoNumero(validarCadena(formatoAdmisionPesado.getOpTelConAfe())));

			paramPesado.put("marcaTercero", validarCadena(formatoAdmisionPesado.getOpMarcaAutoAfe()));

			paramPesado.put("tipoTercero", validarCadena(formatoAdmisionPesado.getOpTipoAutoAfe()));

			paramPesado.put("modeloTercero", validarCadena(formatoAdmisionPesado.getOpModeloTer()));

			paramPesado.put("colorTercero", validarCadena(formatoAdmisionPesado.getOpColorAutoAfe()));

			paramPesado.put("placasTercero", validarCadena(formatoAdmisionPesado.getOpPlacasAutoAfe()));

			paramPesado.put("motorTercero", validarCadena(formatoAdmisionPesado.getOpMotorAutoAfe()));

			paramPesado.put("serieTercero", validarCadena(formatoAdmisionPesado.getOpSerieAutoAfe()));

			paramPesado.put("chUno", formatoAdmisionPesado.getCheck1());

			paramPesado.put("chDos", formatoAdmisionPesado.getCheck2());

			paramPesado.put("chTres", formatoAdmisionPesado.getCheck3());

			paramPesado.put("chCuatro", formatoAdmisionPesado.getCheck4());

			// ***FIRMA ELECTRONICA ASEGURADO**//

			String firma = formatoAdmisionPesado.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramPesado.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA ASEGURADO**//

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String firma1 = formatoAdmisionPesado.getFirmaAjustador();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramPesado.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			if (formatoAdmisionPesado.getOpDeducible() != null) {
				if (formatoAdmisionPesado.getOpDeducible() == 0) {
					paramPesado.put("deducible", false);
				}

				if (formatoAdmisionPesado.getOpDeducible() == 1) {
					paramPesado.put("deducible", true);
				}
			}

			paramPesado.put("tipoDeducible",
					validarNumero(formatoAdmisionPesado.getOpTipoDeducible() + ""));

			paramPesado.put("valorDeducible", validarCadena(formatoAdmisionPesado.getOpDedDias()));

			paramPesado.put("porcentajeD", validarCadena(formatoAdmisionPesado.getOpDefinicion()));

			paramPesado.put("cantidad", validarCadena(formatoAdmisionPesado.getOpCantidad()));

			if (formatoAdmisionPesado.getOpDedAdmin() != null) {
				if (formatoAdmisionPesado.getOpDedAdmin() == 1) {
					paramPesado.put("sipac", true);
				}

				if (formatoAdmisionPesado.getOpDedAdmin() == 0) {
					paramPesado.put("sipac", false);
				}
			}

			paramPesado.put("nomTaller", validarCadena(formatoAdmisionPesado.getOpNomTaller()));

			paramPesado.put("telTaller",
					formatoNumero(validarCadena(formatoAdmisionPesado.getOpTelTaller())));

			paramPesado.put("dirTaller", validarCadena(formatoAdmisionPesado.getOpDirTaller()));

			paramPesado.put("atenTaller", validarCadena(formatoAdmisionPesado.getOpAtencionTaller()));

			for (int i = 1; i <= 16; i++) {

				paramPesado.put("a" + i, false);

			}

			for (int i = 1; i <= 17; i++) {

				paramPesado.put("c" + i, false);

			}

			for (int i = 1; i <= 15; i++) {

				paramPesado.put("t" + i, false);

			}

			String[] idRegistradas;

			String[] idPosibles;

			String idPos;

			String idReg = validarCadena(formatoAdmisionPesado.getOpDaniosCamion());

			boolean esOtra = true;

			String otrasPartes = "";

			if (!idReg.equals(" ")) {

				idPos = datosCatalogos.get(4).getValores();

				idRegistradas = idReg.split(",");

				idPosibles = idPos.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas.length; i++) {

					for (int j = 0; j < idPosibles.length; j++)

					{

						if (idRegistradas[i].replaceAll(" ", "").equalsIgnoreCase(idPosibles[j])) {

							paramPesado.put("a" + ((int) j + 1), true);

							esOtra = false;

						}

					}

					if (esOtra == true) {

						otrasPartes = otrasPartes + ", " + idRegistradas[i];

					}

					esOtra = true;

				}

				if (otrasPartes.replace(" ", "").length() > 3) {

					String contenido = otrasPartes.substring(1, otrasPartes.length());

					String nombreRenglon = "otrosCamion";

					String auxRenglon = "";

					int longitudRenglon = 40;

					int numeroRenglones = 4;

					if ((longitudRenglon * numeroRenglones) < contenido.length()) {

						contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

					}

					float renglonesUsados = (float) contenido.length() / longitudRenglon;

					int inicio = 0;

					int fin = longitudRenglon;

					for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

						if (i != ((int) Math.ceil(renglonesUsados))) {

							auxRenglon = buscarBlank(contenido, inicio, fin);

							paramPesado.put(nombreRenglon + i, auxRenglon);

							inicio = inicio + auxRenglon.length();

							fin = (i + 1) * longitudRenglon;

							auxRenglon = "";

						} else {

							auxRenglon = contenido.substring(inicio, contenido.length());

							paramPesado.put(nombreRenglon + i, auxRenglon);

							inicio = inicio + auxRenglon.length();

							fin = (i + 1) * longitudRenglon;

							auxRenglon = "";

						}

					}

				}

			}

			idReg = validarCadena(formatoAdmisionPesado.getOpDaniosCaja());

			esOtra = true;

			otrasPartes = "";

			if (!idReg.equals(" ")) {

//				idPos = idPos = datosCatalogos.get(3).getValores();
				idPos = datosCatalogos.get(3).getValores();
				idRegistradas = idReg.split(",");

				idPosibles = idPos.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas.length; i++) {

					for (int j = 0; j < idPosibles.length; j++)

					{

						if (idRegistradas[i].replaceAll(" ", "").equalsIgnoreCase(idPosibles[j])) {

							if (j > 11) { // le cambie de 12 a 11

								paramPesado.put("c" + ((int) j), true);

								esOtra = false;

							} else {

								paramPesado.put("c" + ((int) j + 1), true);

								esOtra = false;

							}

						}

					}

					if (esOtra == true) {

						otrasPartes = otrasPartes + ", " + idRegistradas[i];

					}

					esOtra = true;

				}

				if (otrasPartes.replace(" ", "").length() > 3) {

					if (otrasPartes.replace(" ", "").length() > 3) {

						String contenido = otrasPartes.substring(1, otrasPartes.length());

						String nombreRenglon = "otrosCaja";

						String auxRenglon = "";

						int longitudRenglon = 40;

						int numeroRenglones = 4;

						if ((longitudRenglon * numeroRenglones) < contenido.length()) {

							contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

						}

						float renglonesUsados = (float) contenido.length() / longitudRenglon;

						int inicio = 0;

						int fin = longitudRenglon;

						for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

							if (i != ((int) Math.ceil(renglonesUsados))) {

								auxRenglon = buscarBlank(contenido, inicio, fin);

								paramPesado.put(nombreRenglon + i, auxRenglon);

								inicio = inicio + auxRenglon.length();

								fin = (i + 1) * longitudRenglon;

								auxRenglon = "";

							} else {

								auxRenglon = contenido.substring(inicio, contenido.length());

								paramPesado.put(nombreRenglon + i, auxRenglon);

								inicio = inicio + auxRenglon.length();

								fin = (i + 1) * longitudRenglon;

								auxRenglon = "";

							}

						}

					}

				}

			}

			idReg = validarCadena(formatoAdmisionPesado.getOpDaniosTanque());

			esOtra = true;

			otrasPartes = "";

			if (!idReg.equals(" ")) {

//				idPos = idPos = datosCatalogos.get(2).getValores();
			idPos = datosCatalogos.get(2).getValores();

				idRegistradas = idReg.split(",");

				idPosibles = idPos.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas.length; i++) {

					for (int j = 0; j < idPosibles.length; j++)

					{

						if (idRegistradas[i].replaceAll(" ", "").equalsIgnoreCase(idPosibles[j])) {

							if (j > 12) {

								paramPesado.put("t" + ((int) j), true);

								esOtra = false;

							} else {

								paramPesado.put("t" + ((int) j + 1), true);

								esOtra = false;

							}

						}

					}

					if (esOtra == true) {

						otrasPartes = otrasPartes + ", " + idRegistradas[i];

					}

					esOtra = true;

				}

				if (otrasPartes.replace(" ", "").length() > 3) {

					String contenido = otrasPartes.substring(1, otrasPartes.length());

					String nombreRenglon = "otrosTanque";

					String auxRenglon = "";

					int longitudRenglon = 40;

					int numeroRenglones = 3;

					if ((longitudRenglon * numeroRenglones) < contenido.length()) {

						contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

					}

					float renglonesUsados = (float) contenido.length() / longitudRenglon;

					int inicio = 0;

					int fin = longitudRenglon;

					for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

						if (i != ((int) Math.ceil(renglonesUsados))) {

							auxRenglon = buscarBlank(contenido, inicio, fin);

							paramPesado.put(nombreRenglon + i, auxRenglon);

							inicio = inicio + auxRenglon.length();

							fin = (i + 1) * longitudRenglon;

							auxRenglon = "";

						} else {

							auxRenglon = contenido.substring(inicio, contenido.length());

							paramPesado.put(nombreRenglon + i, auxRenglon);

							inicio = inicio + auxRenglon.length();

							fin = (i + 1) * longitudRenglon;

							auxRenglon = "";

						}

					}

				}
			}

			//// segundo

			paramPesado.put("datosAjustador", validarCadena(formatoAdmisionPesado.getOpClaveAjustador())
					+ " " + validarCadena(formatoAdmisionPesado.getOpNomAjustador()));

			paramPesado.put("datosAsegurado", validarCadena(formatoAdmisionPesado.getOpNomAsegurado()));

			for (int i = 1; i <= 16; i++) {

				paramPesado.put("ad" + i, false);

			}

			for (int i = 1; i <= 17; i++) {

				paramPesado.put("cd" + i, false);

			}

			for (int i = 1; i <= 15; i++) {

				paramPesado.put("td" + i, false);

			}

			String idReg1;

			String idPos1;

			String[] idRegistradas1;

			String[] idPosibles1;

			idReg1 = validarCadena(formatoAdmisionPesado.getOpSiniestroCamion());

			if (!idReg1.equals(" ")) {

				idPos1 = idPos = datosCatalogos.get(4).getValores();

				idRegistradas1 = idReg1.replaceAll(" ", "").split(",");

				idPosibles1 = idPos1.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas1.length; i++) {

					for (int j = 0; j < idPosibles1.length; j++)

					{

						if (idRegistradas1[i].equalsIgnoreCase(idPosibles1[j])) {

							paramPesado.put("ad" + ((int) j + 1), true);

						}

					}

				}

			}

			idReg1 = validarCadena(formatoAdmisionPesado.getOpSiniestroCaja());

			if (!idReg1.equals(" ")) {

				idPos1 = idPos = datosCatalogos.get(3).getValores();

				idRegistradas1 = idReg1.replaceAll(" ", "").split(",");

				idPosibles1 = idPos1.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas1.length; i++) {

					for (int j = 0; j < idPosibles1.length; j++)

					{

						if (idRegistradas1[i].equalsIgnoreCase(idPosibles1[j])) {

							if (j > 11) { // dato original 12

								paramPesado.put("cd" + ((int) j), true);

								esOtra = false;

							} else {

								paramPesado.put("cd" + ((int) j + 1), true);

								esOtra = false;

							}

						}

					}

				}
			}

			idReg1 = validarCadena(formatoAdmisionPesado.getOpSiniestroTanque());

			if (!idReg1.equals(" ")) {

				idPos1 = idPos = datosCatalogos.get(2).getValores();

				idRegistradas1 = idReg1.replaceAll(" ", "").split(",");

				idPosibles1 = idPos1.replaceAll(" ", "").split(",");

				for (int i = 0; i < idRegistradas1.length; i++) {

					for (int j = 0; j < idPosibles1.length; j++)

					{

						if (idRegistradas1[i].equalsIgnoreCase(idPosibles1[j])) {

							if (j > 12) {

								paramPesado.put("td" + ((int) j), true);

								esOtra = false;

							} else {

								paramPesado.put("td" + ((int) j + 1), true);

								esOtra = false;

							}

						}

					}

				}

			}

			paramPesado.put("chCinco", formatoAdmisionPesado.getCheck5());

			paramPesado.put("chSeis", formatoAdmisionPesado.getCheck6());
			
			
			crearArchivoError(FORMATO_ADMISION_PESADO, fileJrxmlAdmisionPesado, paramPesado,
					formatoAdmisionPesado.getOpNumReporte(), formatoAdmisionPesado.getOpNumPoliza(),
					"" + validarAsegurado(formatoAdmisionPesado.getOpAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	@SuppressWarnings("unused")
	public void procesoInventarioAutomovilesCompletoError(FormatoInventarioAutomoviles formatoInventarioAutomoviles,
			OutputStream ou) {
		try {
			fileJrxmlInventario = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/InventarioUnicoDeAutomovilesCompleto.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			HashMap<String, Object> paramInventario = new HashMap<String, Object>();

			paramInventario.put("imgLogoQualitas", imgLogoQualitas);

			paramInventario.put("marcaLlantas", "");

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();
			DatosEmailPlantillas datosEmail2 = new DatosEmailPlantillas();
			DatosEmailPlantillas datosEmail3 = new DatosEmailPlantillas();

			if (formatoInventarioAutomoviles.getIaHora() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoInventarioAutomoviles.getIaHora()) + "");

				paramInventario.put("fechaa", writeFormatFecha.format(date));

				paramInventario.put("hora", writeFormatHora.format(date) + " HRS");

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramInventario.put("fechaa", "");

				paramInventario.put("hora", "");

			}

			if (formatoInventarioAutomoviles.getEmailDefault() != null) {

				///////////////////
				String poliza = formatoInventarioAutomoviles.getIaNumPoliza();
				String reporte = formatoInventarioAutomoviles.getIaNumReporte();
				String destinatario = "";
				String nombreDoc = "Inventario Unico de Automóviles";
				String cadenaCorreos = formatoInventarioAutomoviles.getEmailDefault();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				paramInventario.put("correo", formatoInventarioAutomoviles.getEmailDefault());
				////////////////////

			}

			for (int i = 1; i <= 154; i++) {

				paramInventario.put("e" + i, false);

				paramInventario.put("a" + i, "");

			}

			String palabras = validarCadena(formatoInventarioAutomoviles.getIaDesAuto());

			if (!palabras.equals(" ")) {

				String[] array = palabras.split("-");

				if (array.length == 0) {

					if (!palabras.equals("")) {

						int valorEdi = 0;

						for (int i = 0; i < palabras.length(); i++) {

							if (palabras.charAt(i) == '(') {

								valorEdi = i;

							}

						}

						paramInventario.put("e" + (palabras.substring(0, valorEdi)), true);

						paramInventario.put("a" + (palabras.substring(0, valorEdi)),
								palabras.substring(valorEdi + 1, palabras.length() - 1));

					}

				} else {

					String posibles = "1";

					for (int i = 2; i <= 154; i++) {

						posibles = posibles + "-" + i;
						

					}

					String[] arrayPosibles = posibles.split("-");

					for (int i = 0; i < array.length; i++) {

						int corte = 0;

						int valorEdit = 0;

						for (int j = 0; j < array[i].length(); j++) {

							if (array[i].charAt(j) == '(') {

								corte = j;

							}

						}

						valorEdit = Integer.parseInt(array[i].substring(0, corte));

						for (int k = 0; k < arrayPosibles.length; k++) {

							if (k == valorEdit) {

							

								paramInventario.put("e" + k, true);

								paramInventario.put("a" + k,
										array[i].substring(corte + 1, array[i].length() - 1));

								if (k == 152) {

									paramInventario.put("marcaLlantas",
											array[i].substring(corte + 1, array[i].length() - 1));

								}

							}

						}

					}

				}

			} 


			if (formatoInventarioAutomoviles.getNiu() != null) {

				paramInventario.put("niu", formatoInventarioAutomoviles.getNiu() + "");
			}

			if (formatoInventarioAutomoviles.getIaCorreoGrua() != null) {
				datosEmail2.setEmail_1(formatoInventarioAutomoviles.getIaCorreoGrua());
				datosEmail2.setPoliza(validarCadena(formatoInventarioAutomoviles.getIaNumPoliza()));
				datosEmail2.setReporte(validarCadena(formatoInventarioAutomoviles.getIaNumReporte()));
				datosEmail2.setNombreDestinatario(
						validarCadena(formatoInventarioAutomoviles.getIaNomAsegurado()));

				datosEmail2.setNombreDocumento("Inventario Unico de Automóviles");
				correos.add(datosEmail2);
				paramInventario.put("correoGrua", formatoInventarioAutomoviles.getIaCorreoGrua());
			}
			if (formatoInventarioAutomoviles.getIaCorreoTaller() != null) {
				datosEmail3.setEmail_1(formatoInventarioAutomoviles.getIaCorreoTaller());
				datosEmail3.setPoliza(validarCadena(formatoInventarioAutomoviles.getIaNumPoliza()));
				datosEmail3.setReporte(validarCadena(formatoInventarioAutomoviles.getIaNumReporte()));
				datosEmail3.setNombreDestinatario(
						validarCadena(formatoInventarioAutomoviles.getIaNomAsegurado()));
				datosEmail3.setNombreDocumento("Inventario Unico de Automóviles");
				correos.add(datosEmail3);
				paramInventario.put("correoTaller", formatoInventarioAutomoviles.getIaCorreoTaller());
			}

			paramInventario.put("vidaLlantas",
					validarNumero(formatoInventarioAutomoviles.getIaVidaLlantas() + ""));

			paramInventario.put("folio", validarCadena(formatoInventarioAutomoviles.getId() + ""));

			paramInventario.put("numSiniestro",
					validarCadena(formatoInventarioAutomoviles.getIaNumSiniestro()));

			paramInventario.put("numReporte",
					validarCadena(formatoInventarioAutomoviles.getIaNumReporte()));

			paramInventario.put("numPoliza",
					validarCadena(formatoInventarioAutomoviles.getIaNumPoliza()));

			paramInventario.put("nombre", validarCadena(formatoInventarioAutomoviles.getIaNomRazon()));

			paramInventario.put("nombreDestino",
					validarCadena(formatoInventarioAutomoviles.getIaNomDestino()));

			paramInventario.put("dirDestino",
					validarCadena(formatoInventarioAutomoviles.getIaDirDestino()));

			paramInventario.put("marcaAsegurado",
					validarCadena(formatoInventarioAutomoviles.getIaMarcaAuto()));

			paramInventario.put("tipoAsegurado",
					validarCadena(formatoInventarioAutomoviles.getIaTipoAuto()));

			paramInventario.put("modeloAsegurado",
					validarCadena(formatoInventarioAutomoviles.getIaAnioAuto()));

			paramInventario.put("numPuertas",
					validarNumero(formatoInventarioAutomoviles.getIaPuertasAuto() + "") + "");

			paramInventario.put("motorAsegurado",
					validarCadena(formatoInventarioAutomoviles.getIaNumMotor()));

			paramInventario.put("serieAsegurado",
					validarCadena(formatoInventarioAutomoviles.getIaNumSerie()));

			paramInventario.put("colorAsegurado",
					validarCadena(formatoInventarioAutomoviles.getIaColorAuto()));

			paramInventario.put("placasAsegurado",
					validarCadena(formatoInventarioAutomoviles.getIaPlacasAuto()));

			paramInventario.put("kilometraje",
					validarCadena(formatoInventarioAutomoviles.getIaKilometraje()));

			paramInventario.put("datosOperador",
					validarCadena(formatoInventarioAutomoviles.getIaNomOperador()));

			paramInventario.put("datosAjustador",
					validarCadena(formatoInventarioAutomoviles.getIaClaveAjustador()) + " "
							+ validarCadena(formatoInventarioAutomoviles.getIaNomAjustador()));

			paramInventario.put("datosAsegurado",
					validarCadena(formatoInventarioAutomoviles.getIaNomAsegurado()));

			// ***FIRMA ELECTRONICA**//

			String firma = formatoInventarioAutomoviles.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramInventario.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA**//

			// ***FIRMA ELECTRONICA OPER**//

			String firma1 = formatoInventarioAutomoviles.getFirmaOperRecibe();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramInventario.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA OPER**//

			// ***FIRMA ELECTRONICA AJUS**//

			String firma2 = formatoInventarioAutomoviles.getFirmaAjusRecibe();

			InputStream targetStream2 = null;

			if (firma2 != null && !firma2.isEmpty()) {

				byte[] bytes2 = Base64Decoder.decode(firma2);

				targetStream2 = new ByteArrayInputStream(bytes2);

			}

			paramInventario.put("imgBits2", targetStream2);

			// ***FIRMA ELECTRONICA AJUS**//

			paramInventario.put("chUno", formatoInventarioAutomoviles.getCheck1());

			paramInventario.put("chDos", formatoInventarioAutomoviles.getCheck2());

			paramInventario.put("chTres", formatoInventarioAutomoviles.getCheck3());

			paramInventario.put("chCuatro", formatoInventarioAutomoviles.getCheck4());

			String contenido = validarCadena(formatoInventarioAutomoviles.getIaObservacion());

			String nombreRenglon = "observacion";

			String auxRenglon = "";

			int longitudRenglon = 70;

			int numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramInventario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramInventario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			if (validarNumero(
					validarAsegurado(formatoInventarioAutomoviles.getIaAsegurado()) + "") == 1) {

				paramInventario.put("asegurado", true);

			} else {

				paramInventario.put("asegurado", false);

			}

			if (validarNumero(formatoInventarioAutomoviles.getIaLlaves() + "") == 1) {

				paramInventario.put("llaves", true);

			} else {

				paramInventario.put("llaves", false);

			}

			if (validarNumero(formatoInventarioAutomoviles.getIaTManual() + "") == 1) {

				paramInventario.put("manual", true);

			} else {

				paramInventario.put("manual", false);

			}

			paramInventario.put("combustible",
					validarNumero(formatoInventarioAutomoviles.getIaCombustible() + ""));

			paramInventario.put("destino",
					validarNumero(formatoInventarioAutomoviles.getIaDestino() + ""));

			paramInventario.put("cantidadLlaves",
					validarCadena(formatoInventarioAutomoviles.getIaCantidad()));

			String cortar1 = validarCadena(formatoInventarioAutomoviles.getIaInventario1());

			String[] array1 = cortar1.split("-");

			for (int i = 1; i <= 18; i++) {

				paramInventario.put("opcA" + i, "");

				paramInventario.put("opcB" + i, "");

				paramInventario.put("opcC" + i, "");

				paramInventario.put("opcD" + i, "");

				paramInventario.put("opcE" + i, "");

			}

			for (int i = 0; i < array1.length; i++) {

				for (int j = 0; j < array1[i].length(); j++) {

					if (array1[i].charAt(j) == '(') {

						for (int k = 1; k <= 18; k++) {

							if (Integer.parseInt(array1[i].substring(0, j).replaceAll(" ", "")) == k) {

								paramInventario.put("opcA" + k,
										"" + array1[i].substring(j + 1, array1[i].length() - 1));

							}

						}

					}

				}

			}

			String cortar2 = validarCadena(formatoInventarioAutomoviles.getIaInventario2());

			String[] array2 = cortar2.split("-");

			for (int i = 0; i < array2.length; i++) {

				for (int j = 0; j < array2[i].length(); j++) {

					if (array2[i].charAt(j) == '(') {

						for (int k = 1; k <= 18; k++) {

							if (Integer.parseInt(array2[i].substring(0, j).replaceAll(" ", "")) == k) {

								paramInventario.put("opcB" + k,
										"" + array2[i].substring(j + 1, array2[i].length() - 1));

							}

						}

					}

				}

			}

			String cortar3 = validarCadena(formatoInventarioAutomoviles.getIaInventario3());

			String[] array3 = cortar3.split("-");

			for (int i = 0; i < array3.length; i++) {

				for (int j = 0; j < array3[i].length(); j++) {

					if (array3[i].charAt(j) == '(') {

						for (int k = 1; k <= 18; k++) {

							if (Integer.parseInt(array3[i].substring(0, j).replaceAll(" ", "")) == k) {

								paramInventario.put("opcC" + k,
										"" + array3[i].substring(j + 1, array3[i].length() - 1));

							}

						}

					}

				}

			}

			String cortar4 = validarCadena(formatoInventarioAutomoviles.getIaInventario4());

			String[] array4 = cortar4.split("-");

			for (int i = 0; i < array4.length; i++) {

				for (int j = 0; j < array4[i].length(); j++) {

					if (array4[i].charAt(j) == '(') {

						for (int k = 1; k <= 18; k++) {

							if (Integer.parseInt(array4[i].substring(0, j).replaceAll(" ", "")) == k) {

								paramInventario.put("opcD" + k,
										"" + array4[i].substring(j + 1, array4[i].length() - 1));

							}

						}

					}

				}

			}

			String cortar5 = validarCadena(formatoInventarioAutomoviles.getIaInventario5());

			String[] array5 = cortar5.split("-");

			for (int i = 0; i < array5.length; i++) {

				for (int j = 0; j < array5[i].length(); j++) {

					if (array5[i].charAt(j) == '(') {

						for (int k = 1; k <= 18; k++) {

							if (Integer.parseInt(array5[i].substring(0, j).replaceAll(" ", "")) == k) {

								paramInventario.put("opcE" + k,
										"" + array5[i].substring(j + 1, array5[i].length() - 1));

							}

						}

					}

				}

			}

			paramInventario.put("chCinco", formatoInventarioAutomoviles.getCheck5());

			paramInventario.put("chSeis", formatoInventarioAutomoviles.getCheck6());
			
			crearArchivoError(FORMATO_INVENTARIO_AUTOMOVILES, fileJrxmlInventario, paramInventario,
					formatoInventarioAutomoviles.getIaNumReporte(), formatoInventarioAutomoviles.getIaNumPoliza(),
					"" + validarAsegurado(formatoInventarioAutomoviles.getIaAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	@SuppressWarnings("unused")
	public void procesoCuestionarioRoboCompletoError(FormatoCuestionarioRobo formatoCuestionarioRobo, OutputStream ou) {

		try {
			fileJrxmlCuestionario = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/CuestionarioPorRoboCompleto.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			HashMap<String, Object> paramCuestionario = new HashMap<String, Object>();

			paramCuestionario.put("imgLogoQualitas", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			
			if (formatoCuestionarioRobo.getCrHora() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoCuestionarioRobo.getCrHora()) + "");

				paramCuestionario.put("fechaHora",
						writeFormatFecha.format(date) + " - " + writeFormatHora.format(date) + " HRS");

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramCuestionario.put("fechaHora", "");

			}

			if (formatoCuestionarioRobo.getCrEmailAsegurado() != null) {

				///////////////////
				String poliza = formatoCuestionarioRobo.getCrNumPoliza();
				String reporte = formatoCuestionarioRobo.getCrNumReporte();
				String destinatario = "";
				String nombreDoc = "Cuestionario de Robo";
				String cadenaCorreos = formatoCuestionarioRobo.getCrEmailAsegurado();
			//	agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			paramCuestionario.put("folio", validarCadena(formatoCuestionarioRobo.getId() + ""));

			paramCuestionario.put("reporte", validarCadena(formatoCuestionarioRobo.getCrNumReporte()));

			paramCuestionario.put("poliza", validarCadena(formatoCuestionarioRobo.getCrNumPoliza()));

			paramCuestionario.put("siniestro",
					validarCadena(formatoCuestionarioRobo.getCrNumSiniestro()));

			paramCuestionario.put("inc", validarCadena(formatoCuestionarioRobo.getCrIncAsegurado()));

			paramCuestionario.put("asegurado",
					validarCadena(formatoCuestionarioRobo.getCrNomAsegurado()));

			paramCuestionario.put("chUno", formatoCuestionarioRobo.getCheck1());

			paramCuestionario.put("chDos", formatoCuestionarioRobo.getCheck2());

			paramCuestionario.put("chTres", formatoCuestionarioRobo.getCheck3());

			paramCuestionario.put("chCuatro", formatoCuestionarioRobo.getCheck4());

			// ***FIRMA ELECTRONICA**//

			String firma = formatoCuestionarioRobo.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramCuestionario.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA**//

			if (validarNumero(formatoCuestionarioRobo.getCrEstacionado() + "") == 1)

			{

				paramCuestionario.put("estacionado", true);

			}

			else if (validarNumero(formatoCuestionarioRobo.getCrEstacionado() + "") == 0)

			{

				paramCuestionario.put("estacionado", false);

			}

			String contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta1());

			String nombreRenglon = "pre1_";

			String auxRenglon = "";

			int longitudRenglon = 110;

			int numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramCuestionario.put("pre2", validarCadena(formatoCuestionarioRobo.getCrPregunta2()));

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta3());

			nombreRenglon = "pre3_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta4());

			nombreRenglon = "pre4_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta5());

			nombreRenglon = "pre5_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta6());

			nombreRenglon = "pre6_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta7());

			nombreRenglon = "pre7_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramCuestionario.put("pre8_A", validarCadena(formatoCuestionarioRobo.getCrPregunta81()));

			paramCuestionario.put("pre8_B", validarCadena(formatoCuestionarioRobo.getCrPregunta82()));

			paramCuestionario.put("pre8_C", validarCadena(formatoCuestionarioRobo.getCrPregunta83()));

			if (validarNumero(formatoCuestionarioRobo.getCrBool2() + "") == 1) {

				paramCuestionario.put("pre2bool", true);

			} else {

				paramCuestionario.put("pre2bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool3() + "") == 1) {

				paramCuestionario.put("pre3bool", true);

			} else {

				paramCuestionario.put("pre3bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool5() + "") == 1) {

				paramCuestionario.put("pre5bool", true);

			} else {

				paramCuestionario.put("pre5bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool8() + "") == 1) {

				paramCuestionario.put("pre8bool", true);

			} else {

				paramCuestionario.put("pre8bool", false);

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta9());

			nombreRenglon = "pre9_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta11());

			nombreRenglon = "pre11_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta12());

			nombreRenglon = "pre12_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta13());

			nombreRenglon = "pre13_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta14());

			nombreRenglon = "pre14_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta15());

			nombreRenglon = "pre15_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 3;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta17());

			nombreRenglon = "pre17_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			String datos1 = validarCadena(formatoCuestionarioRobo.getCrPregunta101());

			String datos2 = validarCadena(formatoCuestionarioRobo.getCrPregunta102());

			if (!datos1.equals(" ")) {

				String[] arrayDatos1 = datos1.split("-");

				paramCuestionario.put("nom1", arrayDatos1[0].toString());

				paramCuestionario.put("paren1", arrayDatos1[1].toString());

				paramCuestionario.put("dir1", arrayDatos1[2].toString());

				paramCuestionario.put("tel1", arrayDatos1[3].toString());

			}

			if (!datos2.equals(" ")) {

				String[] arrayDatos2 = datos2.split("-");

				paramCuestionario.put("nom2", arrayDatos2[0].toString());

				paramCuestionario.put("paren2", arrayDatos2[1].toString());

				paramCuestionario.put("dir2", arrayDatos2[2].toString());

				paramCuestionario.put("tel2", arrayDatos2[3].toString());

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrOtros());

			nombreRenglon = "otro";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool9() + "") == 1) {

				paramCuestionario.put("pre9bool", true);

			} else {

				paramCuestionario.put("pre9bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool11() + "") == 1) {

				paramCuestionario.put("pre11bool", true);

			} else {

				paramCuestionario.put("pre11bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool12() + "") == 1) {

				paramCuestionario.put("pre12bool", true);

			} else {

				paramCuestionario.put("pre12bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool14() + "") == 1) {

				paramCuestionario.put("pre14bool", true);

			} else {

				paramCuestionario.put("pre14bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool13() + "") == 1) {

				paramCuestionario.put("pre13bool", true);

			} else {

				paramCuestionario.put("pre13bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool15() + "") == 1) {

				paramCuestionario.put("pre15bool", true);

			} else {

				paramCuestionario.put("pre15bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool29() + "") == 1) {

				paramCuestionario.put("pre29bool", true);

			} else {

				paramCuestionario.put("pre29bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool31() + "") == 1) {

				paramCuestionario.put("pre31bool", true);

			} else {

				paramCuestionario.put("pre31bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrO16Particular() + "") == 1) {

				paramCuestionario.put("particular", true);

			} else {

				paramCuestionario.put("particular", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrO16Publico() + "") == 1) {

				paramCuestionario.put("publico", true);

			} else {

				paramCuestionario.put("publico", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrO16Carga() + "") == 1) {

				paramCuestionario.put("carga", true);

			} else {

				paramCuestionario.put("carga", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrO16Enseñanza() + "") == 1) {

				paramCuestionario.put("enseñanza", true);

			} else {

				paramCuestionario.put("enseñanza", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrO16Emergencia() + "") == 1) {

				paramCuestionario.put("emergencia", true);

			} else {

				paramCuestionario.put("emergencia", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrO16Otros() + "") == 1) {

				paramCuestionario.put("otros", true);

			} else {

				paramCuestionario.put("otros", false);

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta18());

			nombreRenglon = "pre18_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta19());

			nombreRenglon = "pre19_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta21());

			nombreRenglon = "pre21_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 4;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta22());

			nombreRenglon = "pre22_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 4;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta23());

			nombreRenglon = "pre23_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta24());

			nombreRenglon = "pre24_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta25());

			nombreRenglon = "pre25_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta26());

			nombreRenglon = "pre26_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta27());

			nombreRenglon = "pre27_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramCuestionario.put("pre28_A", validarCadena(formatoCuestionarioRobo.getCrPregunta281()));

			paramCuestionario.put("pre28_B", validarCadena(formatoCuestionarioRobo.getCrPregunta282()));

			paramCuestionario.put("pre28_C", validarCadena(formatoCuestionarioRobo.getCrPregunta283()));

			paramCuestionario.put("pre29", validarCadena(formatoCuestionarioRobo.getCrPregunta29()));

			if (validarNumero(formatoCuestionarioRobo.getCrBool19() + "") == 1) {

				paramCuestionario.put("pre19bool", true);

			} else {

				paramCuestionario.put("pre19bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool20() + "") == 1) {

				paramCuestionario.put("pre20bool", true);

			} else {

				paramCuestionario.put("pre20bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool26() + "") == 1) {

				paramCuestionario.put("pre26bool", true);

			} else {

				paramCuestionario.put("pre26bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool27() + "") == 1) {

				paramCuestionario.put("pre27bool", true);

			} else {

				paramCuestionario.put("pre27bool", false);

			}

			if (validarNumero(formatoCuestionarioRobo.getCrBool28() + "") == 1) {

				paramCuestionario.put("pre28bool", true);

			} else {

				paramCuestionario.put("pre28bool", false);

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta30());

			nombreRenglon = "pre30_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta31());

			nombreRenglon = "pre31_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			contenido = validarCadena(formatoCuestionarioRobo.getCrPregunta32());

			nombreRenglon = "pre32_";

			auxRenglon = "";

			longitudRenglon = 110;

			numeroRenglones = 2;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			renglonesUsados = (float) contenido.length() / longitudRenglon;

			inicio = 0;

			fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramCuestionario.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramCuestionario.put("nom", validarCadena(formatoCuestionarioRobo.getCrNomAsegurado()));

			paramCuestionario.put("dir", validarCadena(formatoCuestionarioRobo.getCrDirAsegurado()));

			paramCuestionario.put("telCasa",
					formatoNumero(validarCadena(formatoCuestionarioRobo.getCrTelCasaAsegurado())));

			paramCuestionario.put("telOficina",
					formatoNumero(validarCadena(formatoCuestionarioRobo.getCrTelOfiAsegurado())));

			paramCuestionario.put("numCelular",
					formatoNumero(validarCadena(formatoCuestionarioRobo.getCrTelCelularAsegurado())));

			paramCuestionario.put("ocupacion",
					validarCadena(formatoCuestionarioRobo.getCrOcuAsegurado()));

			paramCuestionario.put("correo",
					validarCadenaMail(formatoCuestionarioRobo.getCrEmailAsegurado()));

			if (validarNumero(formatoCuestionarioRobo.getCrBool30() + "") == 1) {

				paramCuestionario.put("pre30bool", true);

			} else {

				paramCuestionario.put("pre30bool", false);

			}

			paramCuestionario.put("chCinco", formatoCuestionarioRobo.getCheck5());

			paramCuestionario.put("chSeis", formatoCuestionarioRobo.getCheck6());
			
			
			crearArchivoError(FORMATO_CUESTIONARIO_ROBO, fileJrxmlCuestionario, paramCuestionario,
					formatoCuestionarioRobo.getCrNumReporte(), formatoCuestionarioRobo.getCrNumPoliza(),
					"" + validarAsegurado(formatoCuestionarioRobo.getCrAsegurado()), ou);
		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	public void procesoReciboIngresoSiniestroError(FormatoReciboIngresoSiniestro formatoReciboIngresoSiniestro,
			OutputStream ou) {
		try {
			fileJrxmlReciboIngresoSiniestro = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/ReciboProvisionalIngreso.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			String imgCancelado = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/imgCancelado1.png").getFile().getPath();

			HashMap<String, Object> paramRecibo = new HashMap<String, Object>();

			if (formatoReciboIngresoSiniestro.getCancelado() != null) {

				if (formatoReciboIngresoSiniestro.getCancelado() == 1) {

					paramRecibo.put("imgCanceladoSiniestro", imgCancelado);

				}

			}

			paramRecibo.put("imgLogoQualitas", imgLogoQualitas);

//			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

//			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();


			if (formatoReciboIngresoSiniestro.getRiFecha() != null) {

				// Date date = readFormat.parse(new
				// SimpleDateFormat("dd/MM/yy").format(formatoReciboIngresoSiniestro.getRiFecha()));

				paramRecibo.put("fecha", formatoReciboIngresoSiniestro.getRiFecha().toString());

				// paramRecibo.put("fecha",
				// formatoReciboIngresoSiniestro.getRiFecha().parse(s));

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramRecibo.put("fecha", "");

			}

			if (formatoReciboIngresoSiniestro.getRiEmail() != null) {
				///////////////////
//				String poliza = validarCadena(formatoReciboIngresoSiniestro.getRiNumPoliza());
//				String reporte = validarCadena(formatoReciboIngresoSiniestro.getRiNumReporte());
//				String destinatario = "";
//				String nombreDoc = "Recibo Ingresos por Siniestro";
//				String cadenaCorreos = formatoReciboIngresoSiniestro.getRiEmail();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			paramRecibo.put("numPoliza", validarCadena(formatoReciboIngresoSiniestro.getRiNumPoliza()));

			paramRecibo.put("numInciso", validarCadena(formatoReciboIngresoSiniestro.getRiNumInciso()));

			paramRecibo.put("claveProveedor",
					validarCadena(formatoReciboIngresoSiniestro.getRiClaveProv()));

			paramRecibo.put("cobertura", validarCadena(formatoReciboIngresoSiniestro.getRiCobertura()));

			paramRecibo.put("ajustador", validarCadena(formatoReciboIngresoSiniestro.getRiAjustador()));

			paramRecibo.put("recibimosDe",
					validarCadena(formatoReciboIngresoSiniestro.getRiRecibimosDe()));

			paramRecibo.put("RFC", validarCadena(formatoReciboIngresoSiniestro.getRiRfc()));

			paramRecibo.put("email", validarCadena(formatoReciboIngresoSiniestro.getRiEmail()));

			paramRecibo.put("telefono", validarCadena(formatoReciboIngresoSiniestro.getRiTelefono()));

			paramRecibo.put("domicilio", validarCadena(formatoReciboIngresoSiniestro.getRiDomicilio()));

			paramRecibo.put("cantidad", validarCadena(formatoReciboIngresoSiniestro.getRiCantidad()));

			paramRecibo.put("importeLetra",
					validarCadena(formatoReciboIngresoSiniestro.getRiImporteLetra()));

			paramRecibo.put("conceptoDe",
					validarCadena(formatoReciboIngresoSiniestro.getRiConceptoDe()));

			paramRecibo.put("banco1", validarCadena(formatoReciboIngresoSiniestro.getRiBanco1()));

			paramRecibo.put("banco2", validarCadena(formatoReciboIngresoSiniestro.getRiBanco2()));

			paramRecibo.put("banco3", validarCadena(formatoReciboIngresoSiniestro.getRiBanco3()));

			paramRecibo.put("importe1", validarCadena(formatoReciboIngresoSiniestro.getRiImporte1()));

			paramRecibo.put("importe2", validarCadena(formatoReciboIngresoSiniestro.getRiImporte2()));

			paramRecibo.put("importe3", validarCadena(formatoReciboIngresoSiniestro.getRiImporte3()));

			paramRecibo.put("autorizacion1",
					validarCadena(formatoReciboIngresoSiniestro.getRiAutorizacion1()));

			paramRecibo.put("autorizacion2",
					validarCadena(formatoReciboIngresoSiniestro.getRiAutorizacion2()));

			paramRecibo.put("autorizacion3",
					validarCadena(formatoReciboIngresoSiniestro.getRiAutorizacion3()));

			paramRecibo.put("numTarjeta1",
					validarCadena(formatoReciboIngresoSiniestro.getRiNumTarjeta1()));

			paramRecibo.put("numTarjeta2",
					validarCadena(formatoReciboIngresoSiniestro.getRiNumTarjeta2()));

			paramRecibo.put("numTarjeta3",
					validarCadena(formatoReciboIngresoSiniestro.getRiNumTarjeta3()));

			paramRecibo.put("importeTotal",
					validarCadena(formatoReciboIngresoSiniestro.getRiImporteTotal()));

			paramRecibo.put("nombreAsegurado",
					validarCadena(formatoReciboIngresoSiniestro.getRiNomAsegurado()));

			paramRecibo.put("nombreTercero",
					validarCadena(formatoReciboIngresoSiniestro.getRiNomTercero()));

			paramRecibo.put("lugarExpedicion",
					validarCadena(formatoReciboIngresoSiniestro.getRiLugarExp()));

			paramRecibo.put("numSiniestro",
					validarCadena(formatoReciboIngresoSiniestro.getRiNumSiniestro()));

			paramRecibo.put("folioRI", validarCadena(formatoReciboIngresoSiniestro.getId() + ""));

			if (formatoReciboIngresoSiniestro.getRiValores() != null) {

				paramRecibo.put("valores", formatoReciboIngresoSiniestro.getRiValores());

			}
			if (formatoReciboIngresoSiniestro.getRiNumReporte() != null) {

				paramRecibo.put("numReporte", formatoReciboIngresoSiniestro.getRiNumReporte());

			}

			paramRecibo.put("chUno", formatoReciboIngresoSiniestro.getCheck1());

			paramRecibo.put("chDos", formatoReciboIngresoSiniestro.getCheck2());

			paramRecibo.put("chTres", formatoReciboIngresoSiniestro.getCheck3());

			paramRecibo.put("chCuatro", formatoReciboIngresoSiniestro.getCheck4());

			// ***FIRMA ELECTRONICA ASEGURADO**//

			String firma = formatoReciboIngresoSiniestro.getRiFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramRecibo.put("imgAsegurado", targetStream);

			// ***FIRMA ELECTRONICA**//

			// ***FIRMA ELECTRONICA TERCERO**//

			String firma1 = formatoReciboIngresoSiniestro.getRiFirmaTercero();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramRecibo.put("imgTercero", targetStream1);

			// ***FIRMA ELECTRONICA**//

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String firma2 = formatoReciboIngresoSiniestro.getRiFirmaAjustador();

			InputStream targetStream2 = null;

			if (firma2 != null && !firma2.isEmpty()) {

				byte[] bytes2 = Base64Decoder.decode(firma2);

				targetStream2 = new ByteArrayInputStream(bytes2);

			}

			paramRecibo.put("imgAjustador", targetStream2);

			// ***FIRMA ELECTRONICA**//

			// ***FIRMA ELECTRONICA RECIBE**//

			String firma3 = formatoReciboIngresoSiniestro.getRiFirmaRecibido();

			InputStream targetStream3 = null;

			if (firma3 != null && !firma3.isEmpty()) {

				byte[] bytes3 = Base64Decoder.decode(firma3);

				targetStream3 = new ByteArrayInputStream(bytes3);

			}

			paramRecibo.put("imgRecibido", targetStream3);

			// ***FIRMA ELECTRONICA**//

			paramRecibo.put("chCinco", formatoReciboIngresoSiniestro.getCheck5());

			paramRecibo.put("chSeis", formatoReciboIngresoSiniestro.getCheck6());
			
			crearArchivoError(FORMATO_RECIBO_INGRESO, fileJrxmlReciboIngresoSiniestro, paramRecibo,
					formatoReciboIngresoSiniestro.getRiNumReporte() + "",
					formatoReciboIngresoSiniestro.getRiNumPoliza(),
					"" + validarAsegurado(formatoReciboIngresoSiniestro.getRiNumTercero() + ""), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	
	@SuppressWarnings("unused")
	public void procesoReciboPagoDeducibleError(FormatoReciboPagoDeducible formatoReciboPagoDeducible,
			OutputStream ou) {
		try {
			fileJrxmlReciboPagoDeducible = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/ReciboPagoDeducible.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			String imgCancelado = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/imgCancelado.png").getFile().getPath();

			HashMap<String, Object> paramRecibo = new HashMap<String, Object>();

			if (formatoReciboPagoDeducible.getCancelado() != null) {

				if (formatoReciboPagoDeducible.getCancelado() == 1) {

					paramRecibo.put("imgCanceladoDeducible", imgCancelado);

				}

			}

			paramRecibo.put("imgLogoQualitas", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoReciboPagoDeducible.getRdFecha() != null) {

				paramRecibo.put("fecha", formatoReciboPagoDeducible.getRdFecha().toString());

			} else {

				paramRecibo.put("fecha", "");

			}

			if (formatoReciboPagoDeducible.getRdEmail() != null) {

				String poliza = validarCadena(formatoReciboPagoDeducible.getRdNumPoliza());
				String reporte = validarCadena(formatoReciboPagoDeducible.getRdNumReporte());
				String destinatario = validarCadena(formatoReciboPagoDeducible.getRdRecibimosDe());
				String nombreDoc = "Recibo de Pago Deducible";
				String cadenaCorreos = formatoReciboPagoDeducible.getRdEmail();
			//	agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);

			}

			paramRecibo.put("numSiniestro",
					validarCadena(formatoReciboPagoDeducible.getRdNumSiniestro()));

			paramRecibo.put("numReporte", validarCadena(formatoReciboPagoDeducible.getRdNumReporte()));

			paramRecibo.put("folioRD", validarCadena(formatoReciboPagoDeducible.getId() + ""));

			paramRecibo.put("numPoliza", validarCadena(formatoReciboPagoDeducible.getRdNumPoliza()));

			paramRecibo.put("numInciso", validarCadena(formatoReciboPagoDeducible.getRdNumInciso()));

			paramRecibo.put("clave", validarCadena(formatoReciboPagoDeducible.getRdClave()));

			paramRecibo.put("ajustador", validarCadena(formatoReciboPagoDeducible.getRdAjustador()));

			paramRecibo.put("recibimosDe",
					validarCadena(formatoReciboPagoDeducible.getRdRecibimosDe()));

			paramRecibo.put("RFC", validarCadena(formatoReciboPagoDeducible.getRdRfc()));

			paramRecibo.put("email", validarCadena(formatoReciboPagoDeducible.getRdEmail()));

			paramRecibo.put("telefono", validarCadena(formatoReciboPagoDeducible.getRdTelefono()));

			paramRecibo.put("domicilio", validarCadena(formatoReciboPagoDeducible.getRdDomicilio()));

			paramRecibo.put("cantidad", validarCadena(formatoReciboPagoDeducible.getRdCantidad()));

			paramRecibo.put("importeLetra",
					validarCadena(formatoReciboPagoDeducible.getRdImporteLetra()));

			paramRecibo.put("conceptoDe", validarCadena(formatoReciboPagoDeducible.getRdConceptoDe()));

			if (formatoReciboPagoDeducible.getRdValores() != null) {

				paramRecibo.put("valores", formatoReciboPagoDeducible.getRdValores());

			}

			paramRecibo.put("numCuenta1", validarCadena(formatoReciboPagoDeducible.getRdNumCuenta1()));

			paramRecibo.put("numCuenta2", validarCadena(formatoReciboPagoDeducible.getRdNumCuenta2()));

			paramRecibo.put("banco1", validarCadena(formatoReciboPagoDeducible.getRdBanco1()));

			paramRecibo.put("banco2", validarCadena(formatoReciboPagoDeducible.getRdBanco2()));

			paramRecibo.put("importe1", validarCadena(formatoReciboPagoDeducible.getRdImporte1()));

			paramRecibo.put("importe2", validarCadena(formatoReciboPagoDeducible.getRdImporte2()));

			paramRecibo.put("autorizacion1",
					validarCadena(formatoReciboPagoDeducible.getRdAutorizacion1()));

			paramRecibo.put("autorizacion2",
					validarCadena(formatoReciboPagoDeducible.getRdAutorizacion2()));

			paramRecibo.put("numTarjeta1",
					validarCadena(formatoReciboPagoDeducible.getRdNumTarjeta1()));

			paramRecibo.put("numTarjeta2",
					validarCadena(formatoReciboPagoDeducible.getRdNumTarjeta2()));

			paramRecibo.put("banco1B", validarCadena(formatoReciboPagoDeducible.getRdBanco1B()));

			paramRecibo.put("banco2B", validarCadena(formatoReciboPagoDeducible.getRdBanco2B()));

			paramRecibo.put("importe1B", validarCadena(formatoReciboPagoDeducible.getRdImporte1B()));

			paramRecibo.put("importe2B", validarCadena(formatoReciboPagoDeducible.getRdImporte2B()));

			paramRecibo.put("importeTotal",
					validarCadena(formatoReciboPagoDeducible.getRdImporteTotal()));

			paramRecibo.put("lugarExpedicion",
					validarCadena(formatoReciboPagoDeducible.getRdLugarExp()));

			paramRecibo.put("chUno", formatoReciboPagoDeducible.getCheck1());

			paramRecibo.put("chDos", formatoReciboPagoDeducible.getCheck2());

			paramRecibo.put("chTres", formatoReciboPagoDeducible.getCheck3());

			paramRecibo.put("chCuatro", formatoReciboPagoDeducible.getCheck4());

			// ***FIRMA ELECTRONICA RECIBE**//

			String firma3 = formatoReciboPagoDeducible.getRdFirmaRecibido();

			InputStream targetStream3 = null;

			if (firma3 != null && !firma3.isEmpty()) {

				byte[] bytes3 = Base64Decoder.decode(firma3);

				targetStream3 = new ByteArrayInputStream(bytes3);

			}

			paramRecibo.put("imgRecibido", targetStream3);

			// ***FIRMA ELECTRONICA**//
			
			paramRecibo.put("chCinco", formatoReciboPagoDeducible.getCheck5());

			paramRecibo.put("chSeis", formatoReciboPagoDeducible.getCheck6());
			
			crearArchivoError(FORMATO_RECIBO_DEDUCIBLE, fileJrxmlReciboPagoDeducible, paramRecibo,
					formatoReciboPagoDeducible.getRdNumReporte() + "", formatoReciboPagoDeducible.getRdNumPoliza(), "1",
					ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	@SuppressWarnings("unused")
	public void procesoSolicitudDiagnosticoError(FormatoSolicitudDiagnostico formatoSolicitudDiagnostico,
			List<FormatoCatalogos> datosCatalogos, OutputStream ou) {
		try {
			fileJrxmlSolicitudDiagnostico = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/SolicitudDiagnostico.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			String imgAdmisionAuto = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/Auto.png").getFile().getPath();

			HashMap<String, Object> paramSolicitudDiagnostico = new HashMap<String, Object>();

			paramSolicitudDiagnostico.put("imgAdmisionAuto", imgAdmisionAuto);

			paramSolicitudDiagnostico.put("imgLogoQualitas", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoSolicitudDiagnostico.getSdFecha() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoSolicitudDiagnostico.getSdFecha()) + "");

				paramSolicitudDiagnostico.put("fecha", writeFormatFecha.format(date));

				paramSolicitudDiagnostico.put("hora", writeFormatHora.format(date) + " HRS");

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramSolicitudDiagnostico.put("fecha", "");

				paramSolicitudDiagnostico.put("hora", "");

			}

			if (formatoSolicitudDiagnostico.getSdEmailCliente() != null) {

				///////////////////
				String poliza = validarCadena(formatoSolicitudDiagnostico.getSdNumPoliza());
				String reporte = validarCadena(formatoSolicitudDiagnostico.getSdNumReporte());
				String destinatario = "";
				String nombreDoc = "Solicitud de Diagnostico";
				String cadenaCorreos = formatoSolicitudDiagnostico.getSdEmailCliente();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}

			paramSolicitudDiagnostico.put("numReporte",
					validarCadena(formatoSolicitudDiagnostico.getSdNumReporte()));

			paramSolicitudDiagnostico.put("numSiniestro",
					validarCadena(formatoSolicitudDiagnostico.getSdNumSiniestro()));

			paramSolicitudDiagnostico.put("folio",
					validarCadena(formatoSolicitudDiagnostico.getId() + ""));

			paramSolicitudDiagnostico.put("numPoliza",
					validarCadena(formatoSolicitudDiagnostico.getSdNumPoliza()));

			paramSolicitudDiagnostico.put("numEndoso",
					validarCadena(formatoSolicitudDiagnostico.getSdNumEndoso()));

			paramSolicitudDiagnostico.put("numInciso",
					validarCadena(formatoSolicitudDiagnostico.getSdNumInciso()));

			paramSolicitudDiagnostico.put("nombre",
					validarCadena(formatoSolicitudDiagnostico.getSdNomCliente()));

			paramSolicitudDiagnostico.put("emailCliente",
					validarCadenaMail(formatoSolicitudDiagnostico.getSdEmailCliente()));

			paramSolicitudDiagnostico.put("telefonoCliente",
					formatoNumero(validarCadena(formatoSolicitudDiagnostico.getSdTelCliente())));

			paramSolicitudDiagnostico.put("razonSocial",
					validarCadena(formatoSolicitudDiagnostico.getSdRazonEnvio()));

			paramSolicitudDiagnostico.put("responsable",
					validarCadena(formatoSolicitudDiagnostico.getSdRazonResponsable()));

			paramSolicitudDiagnostico.put("telRazonSocial",
					formatoNumero(validarCadena(formatoSolicitudDiagnostico.getSdRazonTelefono())));

			paramSolicitudDiagnostico.put("domRazonSocial",
					validarCadena(formatoSolicitudDiagnostico.getSdRazonDomicilio()));

			paramSolicitudDiagnostico.put("coberturaRazon",
					validarCadena(formatoSolicitudDiagnostico.getSdRazonCobertura()));

			paramSolicitudDiagnostico.put("tipoAuto",
					validarCadena(formatoSolicitudDiagnostico.getSdTipoAuto()));

			paramSolicitudDiagnostico.put("marcaAuto",
					validarCadena(formatoSolicitudDiagnostico.getSdMarcaAuto()));

			paramSolicitudDiagnostico.put("modeloAuto",
					validarCadena(formatoSolicitudDiagnostico.getSdModeloAuto()));

			paramSolicitudDiagnostico.put("kilometraje",
					validarCadena(formatoSolicitudDiagnostico.getSdKilometrajeAuto()));

			paramSolicitudDiagnostico.put("numSerie",
					validarCadena(formatoSolicitudDiagnostico.getSdNumSerie()));

			paramSolicitudDiagnostico.put("colorAuto",
					validarCadena(formatoSolicitudDiagnostico.getSdColorAuto()));

			paramSolicitudDiagnostico.put("placasAuto",
					validarCadena(formatoSolicitudDiagnostico.getSdPlacaAuto()));

			paramSolicitudDiagnostico.put("otro",
					validarCadena(formatoSolicitudDiagnostico.getSdOtro()));

			paramSolicitudDiagnostico.put("nivel", formatoSolicitudDiagnostico.getSdNivelInundacion());

			paramSolicitudDiagnostico.put("chUno", formatoSolicitudDiagnostico.getCheck1());

			paramSolicitudDiagnostico.put("chDos", formatoSolicitudDiagnostico.getCheck2());

			paramSolicitudDiagnostico.put("chTres", formatoSolicitudDiagnostico.getCheck3());

			paramSolicitudDiagnostico.put("chCuatro", formatoSolicitudDiagnostico.getCheck4());

			if (validarNumero(formatoSolicitudDiagnostico.getSdTransmision() + "") == 1) {

				paramSolicitudDiagnostico.put("transimisionManual", true);

			} else {

				paramSolicitudDiagnostico.put("transimisionManual", false);

			}

			paramSolicitudDiagnostico.put("dud1", 0);

			paramSolicitudDiagnostico.put("dud2", 0);

			paramSolicitudDiagnostico.put("dud3", 0);

			paramSolicitudDiagnostico.put("dud4", 0);

			paramSolicitudDiagnostico.put("dud5", 0);

			paramSolicitudDiagnostico.put("dud6", 0);

			paramSolicitudDiagnostico.put("dud7", 0);

			paramSolicitudDiagnostico.put("dud8", 0);

			paramSolicitudDiagnostico.put("dud9", 0);

			String cadenaDud = formatoSolicitudDiagnostico.getSdDaniosUnidad();

			String cadenaTodosDud = "1-2-3-4-5-6-7-8-9";

			String[] arrayDud = cadenaDud.split("\\-");

			String[] arrayTodosDud = cadenaTodosDud.split("\\-");

			for (int i = 0; i < arrayDud.length; i++) {

				for (int j = 0; j < arrayTodosDud.length; j++) {

					if (arrayDud[i].equals(arrayTodosDud[j])) {

						paramSolicitudDiagnostico.put("dud" + (j + 1), 1);

					}

				}

			}

			paramSolicitudDiagnostico.put("ddr1", 0);

			paramSolicitudDiagnostico.put("ddr2", 0);

			paramSolicitudDiagnostico.put("ddr3", 0);

			paramSolicitudDiagnostico.put("ddr4", 0);

			paramSolicitudDiagnostico.put("ddr5", 0);

			paramSolicitudDiagnostico.put("ddr6", 0);

			paramSolicitudDiagnostico.put("ddr7", 0);

			paramSolicitudDiagnostico.put("ddr8", 0);

			paramSolicitudDiagnostico.put("ddr9", 0);

			paramSolicitudDiagnostico.put("ddr10", 0);

			paramSolicitudDiagnostico.put("ddr11", 0);

			paramSolicitudDiagnostico.put("ddr12", 0);

			paramSolicitudDiagnostico.put("ddr13", 0);

			String cadenaDdr = formatoSolicitudDiagnostico.getSdDescripcionDanios();

			if (cadenaDdr != null) {
				String cadenaTodosDdr = "PARTE FRONTAL DERECHA,PARTE FRONTAL CENTRAL,PARTE FRONTAL IZQUIERDA,"
						+ "PARTE LATERAL DERECHA,PARTE LATERAL IZQUIERDA,PARTE TRASERA DERECHA,PARTE TRASERA CENTRAL,PARTE TRASERA IZQUIERDA,"
						+ "MOTOR COMPONENTES MECÁNICOS Y / O ELÉCTRICOS,INTERIORES,SUSPENSIÓN Y/O DIRECCIÓN DELANTERA,SUSPENSIÓN Y/O DIRECCIÓN TRASERA,TOLDO Y TOLDO INTERIOR";
				String cadenaNewcadena = "";
				cadenaNewcadena = cadenaDdr.replace("MOTOR, COMPONENTES MECÁNICOS Y / O ELÉCTRICOS",
						"MOTOR COMPONENTES MECÁNICOS Y / O ELÉCTRICOS");

				String[] arrayDdr = cadenaNewcadena.split("\\,");
				String[] arrayTodosDdr = cadenaTodosDdr.split("\\,");

				for (int i = 0; i < arrayDdr.length; i++) {
					for (int j = 0; j < arrayTodosDdr.length; j++) {

						if (arrayDdr[i].equals(arrayTodosDdr[j])) {

							paramSolicitudDiagnostico.put("ddr" + (j + 1), 1);

						}
					}
				}
			}

			String registradas = validarCadena(formatoSolicitudDiagnostico.getSdDaniosPre());

			String posibles = datosCatalogos.get(6).getValores();

			String[] reg = registradas.split(",");

			String[] pos = posibles.split(",");

			for (int i = 1; i <= pos.length; i++) {

				paramSolicitudDiagnostico.put("dp" + (i), 0);

			}

			if (!registradas.equals(" ")) {

				for (int i = 0; i < pos.length; i++) {

					for (int j = 0; j < reg.length; j++) {

						if (pos[i].replaceAll(" ", "").equals(reg[j].replaceAll(" ", ""))) {

							paramSolicitudDiagnostico.put("dp" + (i + 1), 1);

						}

					}

				}

			}

			// ***FIRMA ELECTRONICA**//

			String firma = formatoSolicitudDiagnostico.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramSolicitudDiagnostico.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA**//

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String firma1 = formatoSolicitudDiagnostico.getFirmaAJUSTADOR();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramSolicitudDiagnostico.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			if (!validarCadena(formatoSolicitudDiagnostico.getSdDaniosPre()).equals(" ")) {

				paramSolicitudDiagnostico.put("daniosPre", true);

			}

			else {

				paramSolicitudDiagnostico.put("daniosPre", false);

			}

			paramSolicitudDiagnostico.put("datosAjustador",
					validarCadena(formatoSolicitudDiagnostico.getSdClaveAjustador()) + " "
							+ validarCadena(formatoSolicitudDiagnostico.getSdNomAjustador()));

			String registradas1 = validarCadena(formatoSolicitudDiagnostico.getSdDaniosPre());

			String posibles1 = datosCatalogos.get(6).getValores();

			String[] reg1 = registradas1.split(",");

			String[] pos1 = posibles1.split(",");

			for (int i = 1; i <= pos1.length; i++) {

				paramSolicitudDiagnostico.put("dp" + (i), 0);

			}

			if (!registradas1.equals(" ")) {

				for (int i = 0; i < pos1.length; i++) {

					for (int j = 0; j < reg1.length; j++) {

						if (pos1[i].replaceAll(" ", "").equals(reg1[j].replaceAll(" ", ""))) {

							paramSolicitudDiagnostico.put("dp" + (i + 1), 1);

						}

					}

				}

			}

			paramSolicitudDiagnostico.put("chCinco", formatoSolicitudDiagnostico.getCheck5());

			paramSolicitudDiagnostico.put("chSeis", formatoSolicitudDiagnostico.getCheck6());
			
			
			crearArchivoError(FORMATO_SOLICITUD_DIAGNOSTICO, fileJrxmlSolicitudDiagnostico, paramSolicitudDiagnostico,
					formatoSolicitudDiagnostico.getSdNumReporte(), formatoSolicitudDiagnostico.getSdNumPoliza(),
					"1", ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	@SuppressWarnings("unused")
	public void procesoMemoriaDescriptivaError(FormatoMemoriaDescriptiva formatoMemoriaDescriptiva, OutputStream ou) {
		try {
			String asegurado = "1";
			fileJrxmlMemoriaDescriptiva = new FileInputStream(

					ProveedorApplicationContextFormatos.getApplicationContext()

							.getResource("/OrdenesPases/jrxml/MemoriaDescriptiva.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()

					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			String imgGruaA = ProveedorApplicationContextFormatos.getApplicationContext()

					.getResource("/OrdenesPases/img/gruasM.png").getFile().getPath();

			HashMap<String, Object> paramMemoria = new HashMap<String, Object>();

			paramMemoria.put("imgLogoQualitas", imgLogoQualitas);

			paramMemoria.put("imgGruaA", imgGruaA);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			if (formatoMemoriaDescriptiva.getFecha() != null) {

				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")

						.format(formatoMemoriaDescriptiva.getFecha()));

				paramMemoria.put("fecha", writeFormatFecha.format(date) + "");

				// datosEmail.setFecha(writeFormatFecha.format(date));

			} else {

				paramMemoria.put("fecha", "");

			}

			if (formatoMemoriaDescriptiva.getCorreo() != null) {

				///////////////////
				String poliza = (validarCadena(formatoMemoriaDescriptiva.getPoliza()));
				String reporte = (validarCadena(formatoMemoriaDescriptiva.getReporte()));
				String destinatario = "";
				String nombreDoc = "Memoria Descriptiva";
				String cadenaCorreos = formatoMemoriaDescriptiva.getCorreo();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}
			paramMemoria.put("chUno", formatoMemoriaDescriptiva.getCheck1());

			paramMemoria.put("chDos", formatoMemoriaDescriptiva.getCheck2());

			paramMemoria.put("chTres", formatoMemoriaDescriptiva.getCheck3());

			paramMemoria.put("chCuatro", formatoMemoriaDescriptiva.getCheck4());

			paramMemoria.put("reporte", validarCadena(formatoMemoriaDescriptiva.getReporte()));

			paramMemoria.put("siniestro", validarCadena(formatoMemoriaDescriptiva.getSiniestro()));

			paramMemoria.put("folioElectro",

					validarCadena(formatoMemoriaDescriptiva.getFolioElectro()));

			if (formatoMemoriaDescriptiva.getCobertura() != null) {

				paramMemoria.put("cobertura", formatoMemoriaDescriptiva.getCobertura());

			}

			paramMemoria.put("poliza", validarCadena(formatoMemoriaDescriptiva.getPoliza()));

			paramMemoria.put("endoso", validarCadena(formatoMemoriaDescriptiva.getEndoso()));

			paramMemoria.put("inciso", validarCadena(formatoMemoriaDescriptiva.getInciso()));

			paramMemoria.put("nomSocial", validarCadena(formatoMemoriaDescriptiva.getNomSocial()));

			if (formatoMemoriaDescriptiva.getTipoAsegurado() != null) {

				if (formatoMemoriaDescriptiva.getTipoAsegurado().equals("1")) {
					asegurado = "1";
					paramMemoria.put("tipoAsegurado", "1");
				}
				if (formatoMemoriaDescriptiva.getTipoAsegurado().contains("T")) {
					paramMemoria.put("tipoAsegurado", "T");
					asegurado = formatoMemoriaDescriptiva.getTipoAsegurado();
				}
				if (formatoMemoriaDescriptiva.getTipoAsegurado().contains("T") == false
						&& !formatoMemoriaDescriptiva.getTipoAsegurado().equals("1")) {
					paramMemoria.put("tipoAsegurado", formatoMemoriaDescriptiva.getTipoAsegurado());
					asegurado = "1";
				}

			}

			paramMemoria.put("marca", validarCadena(formatoMemoriaDescriptiva.getMarca()));

			paramMemoria.put("tipo", validarCadena(formatoMemoriaDescriptiva.getTipo()));

			paramMemoria.put("modelo", validarCadena(formatoMemoriaDescriptiva.getModelo()));

			paramMemoria.put("placas", validarCadena(formatoMemoriaDescriptiva.getPlacas()));

			paramMemoria.put("color", validarCadena(formatoMemoriaDescriptiva.getColor()));

			paramMemoria.put("duracionMan", validarCadena(formatoMemoriaDescriptiva.getDuracionMan()));

			if (formatoMemoriaDescriptiva.getGruaLugar() != null) {

				paramMemoria.put("gruaLugar", formatoMemoriaDescriptiva.getGruaLugar());

			}

			if (formatoMemoriaDescriptiva.getConcesion() != null) {

				paramMemoria.put("concesion", formatoMemoriaDescriptiva.getConcesion());

			}

			if (formatoMemoriaDescriptiva.getEstatalFede() != null) {

				paramMemoria.put("estatalFede", formatoMemoriaDescriptiva.getEstatalFede());

			}

			paramMemoria.put("maniobras", validarCadena(formatoMemoriaDescriptiva.getManiobras()));

			paramMemoria.put("tipoGrua", validarCadena(formatoMemoriaDescriptiva.getTipoGrua()));

			if (formatoMemoriaDescriptiva.getOtraGrua() != null) {

				paramMemoria.put("otraGrua", formatoMemoriaDescriptiva.getOtraGrua());

			}

			paramMemoria.put("otraGruaTexto",

					validarCadena(formatoMemoriaDescriptiva.getOtraGruaTexto()));

			if (formatoMemoriaDescriptiva.getCardan1() != null) {

				paramMemoria.put("cardan1", formatoMemoriaDescriptiva.getCardan1());

			}

			if (formatoMemoriaDescriptiva.getCardan2() != null) {

				paramMemoria.put("cardan2", formatoMemoriaDescriptiva.getCardan2());

			}

			if (formatoMemoriaDescriptiva.getCardan3() != null) {

				paramMemoria.put("cardan3", formatoMemoriaDescriptiva.getCardan3());

			}

			if (formatoMemoriaDescriptiva.getCantidadGruas() != null) {

				paramMemoria.put("cantidadGruas", formatoMemoriaDescriptiva.getCantidadGruas());

			}

			if (formatoMemoriaDescriptiva.getTraspaleo() != null) {

				paramMemoria.put("traspaleo", formatoMemoriaDescriptiva.getTraspaleo());

			}

			paramMemoria.put("tipoTraspaleo",

					validarCadena(formatoMemoriaDescriptiva.getTipoTraspaleo()));

			paramMemoria.put("proveedor", validarCadena(formatoMemoriaDescriptiva.getProveedor()));

			paramMemoria.put("cantidadGruasTexto",

					validarCadena(formatoMemoriaDescriptiva.getCantidadGruasTexto()));

			paramMemoria.put("telefono", validarCadena(formatoMemoriaDescriptiva.getTelefono()));

			paramMemoria.put("domicilioProv",

					validarCadena(formatoMemoriaDescriptiva.getDomicilioProv()));

			paramMemoria.put("ubicacionOrigen",

					validarCadena(formatoMemoriaDescriptiva.getUbicacionOrigen()));

			paramMemoria.put("trasladoDestino",

					validarCadena(formatoMemoriaDescriptiva.getTrasladoDestino()));

			if (formatoMemoriaDescriptiva.getCamionToneladas() != null) {

				paramMemoria.put("camionToneladas", formatoMemoriaDescriptiva.getCamionToneladas());

			}

			paramMemoria.put("horarioSolicitado",

					validarCadena(formatoMemoriaDescriptiva.getHorarioSolicitado()));

			paramMemoria.put("horarioArribo",

					validarCadena(formatoMemoriaDescriptiva.getHorarioArribo()));

			paramMemoria.put("horarioTraslado",

					validarCadena(formatoMemoriaDescriptiva.getHorarioTraslado()));

			paramMemoria.put("manualHora", validarCadena(formatoMemoriaDescriptiva.getManualHora()));

			paramMemoria.put("gruaHora", validarCadena(formatoMemoriaDescriptiva.getGruaHora()));

			paramMemoria.put("nomEmpleado", validarCadena(formatoMemoriaDescriptiva.getNomEmpleado()));

			paramMemoria.put("claveEmpleado",

					validarCadena(formatoMemoriaDescriptiva.getClaveEmpleado()));

			paramMemoria.put("nomOperadorGrua",

					validarCadena(formatoMemoriaDescriptiva.getNomOperadorGrua()));

			paramMemoria.put("numEcoGrua", validarCadena(formatoMemoriaDescriptiva.getNumEcoGrua()));

			paramMemoria.put("tipoGruaAbander",

					validarCadena(formatoMemoriaDescriptiva.getTipoGruaAbander()));

			if (formatoMemoriaDescriptiva.getServicioDesacoplar() != null) {

				paramMemoria.put("servicioDesacoplar",

						formatoMemoriaDescriptiva.getServicioDesacoplar());

			}

			if (formatoMemoriaDescriptiva.getServicioAbanderaM() != null) {

				paramMemoria.put("servicioAbanderaM", formatoMemoriaDescriptiva.getServicioAbanderaM());

			}

			if (formatoMemoriaDescriptiva.getServicioAbanderaG() != null) {

				paramMemoria.put("servicioAbanderaG", formatoMemoriaDescriptiva.getServicioAbanderaG());

			}

			if (formatoMemoriaDescriptiva.getServicioEnganche() != null) {

				paramMemoria.put("servicioEnganche", formatoMemoriaDescriptiva.getServicioEnganche());

			}

			if (formatoMemoriaDescriptiva.getServicioFueraC() != null) {

				paramMemoria.put("servicioFueraC", formatoMemoriaDescriptiva.getServicioFueraC());

			}

			if (formatoMemoriaDescriptiva.getServicioSobreC() != null) {

				paramMemoria.put("servicioSobreC", formatoMemoriaDescriptiva.getServicioSobreC());

			}

			if (formatoMemoriaDescriptiva.getServicioVolcadura() != null) {

				paramMemoria.put("servicioVolcadura", formatoMemoriaDescriptiva.getServicioVolcadura());

			}

			if (formatoMemoriaDescriptiva.getServicioCarga() != null) {

				paramMemoria.put("servicioCarga", formatoMemoriaDescriptiva.getServicioCarga());

			}

			if (formatoMemoriaDescriptiva.getServicioRescate() != null) {

				paramMemoria.put("servicioRescate", formatoMemoriaDescriptiva.getServicioRescate());

			}

			if (formatoMemoriaDescriptiva.getServicioCustodia() != null) {

				paramMemoria.put("servicioCustodia", formatoMemoriaDescriptiva.getServicioCustodia());

			}

			if (formatoMemoriaDescriptiva.getServicioManiobra() != null) {

				paramMemoria.put("servicioManiobra", formatoMemoriaDescriptiva.getServicioManiobra());

			}

			if (formatoMemoriaDescriptiva.getId() != null) {

				paramMemoria.put("folio", formatoMemoriaDescriptiva.getId() + "");

			}

			// paramMemoria.put("manEspeciales",validarCadena(formatoMemoriaDescriptiva.getHorarioTraslado()));

			String contenido = validarCadena(formatoMemoriaDescriptiva.getManEspeciales());

			String nombreRenglon = "manEspeciales";

			String auxRenglon = "";

			int longitudRenglon = 25;

			int numeroRenglones = 5;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramMemoria.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramMemoria.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			// FIRMA ASEGURADO

			String firmaAsegurado = formatoMemoriaDescriptiva.getFirmaAsegurado();

			InputStream targetStreamAse = null;

			if (firmaAsegurado != null && !firmaAsegurado.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firmaAsegurado);

				targetStreamAse = new ByteArrayInputStream(bytes);

			}

			paramMemoria.put("firmaAsegurado", targetStreamAse);

			// FIRMA EMPLEADO

			String firmaEmpleado = formatoMemoriaDescriptiva.getFirmaEmpleado();

			InputStream targetStreamEmp = null;

			if (firmaEmpleado != null && !firmaEmpleado.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firmaEmpleado);

				targetStreamEmp = new ByteArrayInputStream(bytes);

			}

			paramMemoria.put("firmaEmpleado", targetStreamEmp);

			// FIRMA OPERADOR

			String firmaOper = formatoMemoriaDescriptiva.getFirmaOperadorGrua();

			InputStream targetStreamOper = null;

			if (firmaOper != null && !firmaOper.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firmaOper);

				targetStreamOper = new ByteArrayInputStream(bytes);

			}

			paramMemoria.put("firmaOperadorGrua", targetStreamOper);

			// FIRMA CROQUIS

			String firmaCroquis = formatoMemoriaDescriptiva.getCroquis();

			InputStream targetStreamCroquis = null;

			if (firmaCroquis != null && !firmaCroquis.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firmaCroquis);

				targetStreamCroquis = new ByteArrayInputStream(bytes);

			}

			paramMemoria.put("croquis", targetStreamCroquis);

			paramMemoria.put("chCinco", formatoMemoriaDescriptiva.getCheck5());

			paramMemoria.put("chSeis", formatoMemoriaDescriptiva.getCheck6());
			

			crearArchivoError(FORMATO_MEMORIA_DESCRIPTIVA, fileJrxmlMemoriaDescriptiva, paramMemoria,
					formatoMemoriaDescriptiva.getReporte(), formatoMemoriaDescriptiva.getPoliza(),
					validarAsegurado(asegurado) + "", ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	@SuppressWarnings("unused")
	public void procesoFOrdenServicioError(FormatoOrdenServicio formatoOrdenServicio, OutputStream ou) {

		try {

			fileJrxmlOrdenServicio = new FileInputStream(ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/jrxml/OrdenDeServicio.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

			HashMap<String, Object> paramServicio = new HashMap<String, Object>();

			paramServicio.put("imgLogoQualitas", imgLogoQualitas);

			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

			DatosEmailPlantillas datosEmail = new DatosEmailPlantillas();

			paramServicio.put("numFolio", validarCadena(formatoOrdenServicio.getId() + ""));

			paramServicio.put("numReporte", validarCadena(formatoOrdenServicio.getOsNumReporte()));

			paramServicio.put("numSiniestro", validarCadena(formatoOrdenServicio.getOsNumSiniestro()));

			paramServicio.put("poliza", validarCadena(formatoOrdenServicio.getOsPoliza()));

			paramServicio.put("firmaAsegurado", formatoOrdenServicio.getOsNomConductor());

			paramServicio.put("nomConductor", "");

			if (!validarCadena(formatoOrdenServicio.getOsNomConductor()).equals(" ")) {

				int iAse = 0;

				int fAse = 0;

				if (validarCadena(formatoOrdenServicio.getOsNomConductor()).contains("(")) {

					for (int i = 0; i < validarCadena(formatoOrdenServicio.getOsNomConductor())
							.length(); i++) {

						if (validarCadena(formatoOrdenServicio.getOsNomConductor()).charAt(i) == '(') {
							iAse = i;
						}

						if (validarCadena(formatoOrdenServicio.getOsNomConductor()).charAt(i) == ')') {
							fAse = i;
						}

					}

					paramServicio.put("firmaAsegurado",
							validarCadena(formatoOrdenServicio.getOsNomConductor()).substring(iAse + 1,
									fAse));

					paramServicio.put("nomConductor",
							validarCadena(formatoOrdenServicio.getOsNomConductor().substring(0, iAse)));

				} else {

					paramServicio.put("nomConductor",
							validarCadena(formatoOrdenServicio.getOsNomConductor()));

				}

			}

			paramServicio.put("servicioLugar",
					validarCadena(formatoOrdenServicio.getOsLugarServicio()));

			paramServicio.put("telefono",
					formatoNumero(validarCadena(formatoOrdenServicio.getOsTelConductor())));

			if (validarNumero(formatoOrdenServicio.getOsEdadConductor() + "") == 0) {

				paramServicio.put("edad", "");

			} else {

				paramServicio.put("edad",
						validarNumero(formatoOrdenServicio.getOsEdadConductor() + "") + "");

			}

			paramServicio.put("email", validarCadenaMail(formatoOrdenServicio.getOsEmailConductor()));

			paramServicio.put("marcaTipo", validarCadena(formatoOrdenServicio.getOsMarcaAuto()) + " / "
					+ validarCadena(formatoOrdenServicio.getOsTipoAuto()));

			paramServicio.put("anioModelo", validarCadena(formatoOrdenServicio.getOsAnioAuto()) + " / "
					+ validarCadena(formatoOrdenServicio.getOsModeloAuto()));

			paramServicio.put("placas", validarCadena(formatoOrdenServicio.getOsPlacasAuto()));

			paramServicio.put("numSerie", validarCadena(formatoOrdenServicio.getOsNumSerieAuto()));

			paramServicio.put("chUno", formatoOrdenServicio.getCheck1());

			paramServicio.put("chDos", formatoOrdenServicio.getCheck2());

			paramServicio.put("chTres", formatoOrdenServicio.getCheck3());

			paramServicio.put("chCuatro", formatoOrdenServicio.getCheck4());

			// ***FIRMA ELECTRONICA ASEGURADO**//

			String firma = formatoOrdenServicio.getFirmaAsegurado();

			InputStream targetStream = null;

			if (firma != null && !firma.isEmpty()) {

				byte[] bytes = Base64Decoder.decode(firma);

				targetStream = new ByteArrayInputStream(bytes);

			}

			paramServicio.put("imgBits", targetStream);

			// ***FIRMA ELECTRONICA ASEGURADO**//

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			String firma1 = formatoOrdenServicio.getFirmaAjustador();

			InputStream targetStream1 = null;

			if (firma1 != null && !firma1.isEmpty()) {

				byte[] bytes1 = Base64Decoder.decode(firma1);

				targetStream1 = new ByteArrayInputStream(bytes1);

			}

			paramServicio.put("imgBits1", targetStream1);

			// ***FIRMA ELECTRONICA AJUSTADOR**//

			if (validarNumero(formatoOrdenServicio.getOsTipoServicio() + "") == 1) {

				paramServicio.put("servicioTipo", 1);

			} else if (validarNumero(formatoOrdenServicio.getOsTipoServicio() + "") == 2) {

				paramServicio.put("servicioTipo", 2);

			}

			else if (validarNumero(formatoOrdenServicio.getOsTipoServicio() + "") == 3) {

				paramServicio.put("servicioTipo", 3);

			}

			
			if(formatoOrdenServicio.getOsSurtidoCombustible() !=null) {
				
				paramServicio.put("scombustible", formatoOrdenServicio.getOsSurtidoCombustible());
			}
			

			if (formatoOrdenServicio.getOsHoraArribo() != null) {

				Date horaArribo = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoOrdenServicio.getOsHoraArribo()));

				paramServicio.put("horaArribo", writeFormatHora.format(horaArribo));

			} else {

				paramServicio.put("horaArribo", "");

			}

			if (formatoOrdenServicio.getOsHoraTermino() != null) {

				Date horaTermino = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoOrdenServicio.getOsHoraTermino()));

				paramServicio.put("horaTermino", writeFormatHora.format(horaTermino));

			} else {

				paramServicio.put("horaTermino", "");

			}

			if (formatoOrdenServicio.getOsHoraReporte() != null) {

				Date horaReporte = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoOrdenServicio.getOsHoraReporte()));

				paramServicio.put("horaReporte", writeFormatHora.format(horaReporte));

			} else {

				paramServicio.put("horaReporte", "");

			}

			paramServicio.put("ajustador", validarCadena(formatoOrdenServicio.getOsNomAjustador()));

			paramServicio.put("clave", validarCadena(formatoOrdenServicio.getOsClave()));

			String contenido = validarCadena(formatoOrdenServicio.getOsInformeAjustador());

			String nombreRenglon = "informe";

			String auxRenglon = "";

			int longitudRenglon = 100;

			int numeroRenglones = 10;

			if ((longitudRenglon * numeroRenglones) < contenido.length()) {

				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));

			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;

			int inicio = 0;

			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {

				if (i != ((int) Math.ceil(renglonesUsados))) {

					auxRenglon = buscarBlank(contenido, inicio, fin);

					paramServicio.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				} else {

					auxRenglon = contenido.substring(inicio, contenido.length());

					paramServicio.put(nombreRenglon + i, auxRenglon);

					inicio = inicio + auxRenglon.length();

					fin = (i + 1) * longitudRenglon;

					auxRenglon = "";

				}

			}

			paramServicio.put("sexo", validarCadena(formatoOrdenServicio.getOsSexoConductor()));

			if (formatoOrdenServicio.getOsFechaAtencion() != null) {

				Date dates = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoOrdenServicio.getOsFechaAtencion()));

				paramServicio.put("fecha", writeFormatFecha.format(dates));

				// datosEmail.setFecha(writeFormatFecha.format(dates));

			} else {

				paramServicio.put("fecha", "");

			}

			if (formatoOrdenServicio.getOsEmailConductor() != null) {

				///////////////////
				String poliza = formatoOrdenServicio.getOsPoliza();
				String reporte = formatoOrdenServicio.getOsNumReporte();
				String destinatario = "";
				String nombreDoc = "Orden de Servicio Asistencia Víal";
				String cadenaCorreos = formatoOrdenServicio.getOsEmailConductor();
				//agregaCorreos(correos, cadenaCorreos, poliza, reporte, destinatario, nombreDoc);
				////////////////////

			}


			paramServicio.put("chCinco", formatoOrdenServicio.getCheck5());

			paramServicio.put("chSeis", formatoOrdenServicio.getCheck6());
			
			crearArchivoError(FORMATO_ORDEN_SERVICIO, fileJrxmlOrdenServicio, paramServicio,
					formatoOrdenServicio.getOsNumReporte(), formatoOrdenServicio.getOsPoliza(),
					"" + validarAsegurado(formatoOrdenServicio.getOsAsegurado()), ou);

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	
	//FORMATO 24 CARGO TARJETA CREDITO
	
	@SuppressWarnings("unused")
	public void procesoCargoTarjetaCreditoError(FormatoCargoTarjetaCredito formatoCargoTarjetaCredito, OutputStream ou) {
		try {
			
			fileJrxmlCargoTarjeta = new FileInputStream(
					ProveedorApplicationContextFormatos.getApplicationContext()
											.getResource("/OrdenesPases/jrxml/CargoTarjetaCredito.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
									.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();

							HashMap<String, Object> paramCargo = new HashMap<String, Object>();

							paramCargo.put("imgLogoQualitas", imgLogoQualitas);

							ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

							if (formatoCargoTarjetaCredito.getTcFecha() != null) {
							Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
										.format(formatoCargoTarjetaCredito.getTcFecha()));

								paramCargo.put("fecha", writeFormatFecha.format(date) + "");

							}
							
							
							if (formatoCargoTarjetaCredito.getTcCorreo()!= null) {
							paramCargo.put("correo",
										validarCadena(formatoCargoTarjetaCredito.getTcCorreo()));

							}

							paramCargo.put("numAutorizacion",
									validarCadena(formatoCargoTarjetaCredito.getTcNumAutorizacion()));
							paramCargo.put("nombre",
									validarCadena(formatoCargoTarjetaCredito.getTcNombre()));
							paramCargo.put("direccion",
									validarCadena(formatoCargoTarjetaCredito.getTcDireccion()));
							paramCargo.put("estado",
									validarCadena(formatoCargoTarjetaCredito.getTcEstado()));
							paramCargo.put("cp",
									validarCadena(formatoCargoTarjetaCredito.getTcCp()));
							paramCargo.put("telefono",
									validarCadena(formatoCargoTarjetaCredito.getTcTelefono()));
							paramCargo.put("cargoCantidad",
									validarCadena(formatoCargoTarjetaCredito.getTcCantidadAutorizada()));
							
							paramCargo.put("opcionPago",formatoCargoTarjetaCredito.getTcPagoOpcion());
							
							
							paramCargo.put("reporte",
									validarCadena(formatoCargoTarjetaCredito.getTcNumReporte()));
							
							
							paramCargo.put("fechaVencimiento",
									validarCadena(formatoCargoTarjetaCredito.getTcVencimientoTarjeta()));
							
							if(StringUtils.isNotBlank(formatoCargoTarjetaCredito.getTcNumTarjeta()) ) {
								
								String datosTarjeta=formatoCargoTarjetaCredito.getTcNumTarjeta().replaceAll(" ", "");
								String[] parts=datosTarjeta.split("%");
								
									if(parts.length==2) {
										paramCargo.put("opcionTarjeta",Integer.parseInt(parts[0]));
										paramCargo.put("numTarjeta",parts[1]);
									}
									
							}
							
							String firma = formatoCargoTarjetaCredito.getFirmaTarjetahabiente();
							if (firma != null && !firma.isEmpty()) {
								InputStream targetStream = null;
								byte[] bytes = Base64Decoder.decode(firma);
								targetStream = new ByteArrayInputStream(bytes);
								paramCargo.put("imgBits", targetStream);
								targetStream.close();
							}
							
							paramCargo.put("chUno", formatoCargoTarjetaCredito.getCheck1());

							paramCargo.put("chDos", formatoCargoTarjetaCredito.getCheck2());

							paramCargo.put("chTres", formatoCargoTarjetaCredito.getCheck3());

							paramCargo.put("chCuatro", formatoCargoTarjetaCredito.getCheck4());
							
							paramCargo.put("chCinco", formatoCargoTarjetaCredito.getCheck5());

							paramCargo.put("chSeis", formatoCargoTarjetaCredito.getCheck6());
							
							
							crearArchivoError(FORMATO_CARGO_TARJETA, fileJrxmlCargoTarjeta, paramCargo,
									formatoCargoTarjetaCredito.getTcNumReporte(),
									formatoCargoTarjetaCredito.getTcNumPoliza(),
									"" + validarAsegurado(formatoCargoTarjetaCredito.getTtcNumAsegurado()), ou);
						

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}
		
	
	//25
	public void procesoResponsabilidadCivilError(FormatoResponsabilidadCivil formatoResponsabilidadCivil , OutputStream ou) {
	
						try {
							fileJrxmlResponsabilidad = new FileInputStream(
									ProveedorApplicationContextFormatos.getApplicationContext()
											.getResource("/OrdenesPases/jrxml/ResponsabilidadCivilContractual.jrxml").getFile());

							String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
									.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();						
																					
							HashMap<String, Object> paramResponsabilidad = new HashMap<String, Object>();

							paramResponsabilidad.put("imgLogoQualitas", imgLogoQualitas);

							if (formatoResponsabilidadCivil.getRcFechaSiniestro() != null) {

								Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
										.format(formatoResponsabilidadCivil.getRcFechaSiniestro()));

								paramResponsabilidad.put("fecha", writeFormatFecha.format(date) + "");

							} else {
								paramResponsabilidad.put("fecha", "");
							}
						
							paramResponsabilidad.put("reporteRC", formatoResponsabilidadCivil.getRcNumReporte());
							paramResponsabilidad.put("numSiniestroRC", formatoResponsabilidadCivil.getRcNumSiniestro());
							paramResponsabilidad.put("folio", formatoResponsabilidadCivil.getRcFolioDua());
							paramResponsabilidad.put("folioElectronico", formatoResponsabilidadCivil.getId().toString());
							
							if(formatoResponsabilidadCivil.getRcVehiculoQ()!=null) {
								if (formatoResponsabilidadCivil.getRcVehiculoQ() == 1) {
									paramResponsabilidad.put("aseguradoQualitas", true);
								} else if (formatoResponsabilidadCivil.getRcVehiculoQ() == 0) {
									paramResponsabilidad.put("aseguradoQualitas", false);
								}
							}
														
							paramResponsabilidad.put("companiaCarga", formatoResponsabilidadCivil.getRcCompaniaTransMer());
							paramResponsabilidad.put("reporteCarga", formatoResponsabilidadCivil.getRcReporteVehiculo());
							paramResponsabilidad.put("razonPropietario", formatoResponsabilidadCivil.getRcNomPropietario());
							paramResponsabilidad.put("telPropietario", formatoResponsabilidadCivil.getRcTelPropietario());
							paramResponsabilidad.put("correoPropietario", formatoResponsabilidadCivil.getRcCorreoPropietario());
							paramResponsabilidad.put("razonTransportista", formatoResponsabilidadCivil.getRcNomTransportista());
							paramResponsabilidad.put("telTransportista", formatoResponsabilidadCivil.getRcTelTransportista());
							paramResponsabilidad.put("correoTransportista", formatoResponsabilidadCivil.getRcCorreoTransportista());
							paramResponsabilidad.put("direccionSin", formatoResponsabilidadCivil.getRcDirSiniestro());
							paramResponsabilidad.put("entidadSin", formatoResponsabilidadCivil.getRcEntidadSiniestro());
							paramResponsabilidad.put("direccionResguardo", formatoResponsabilidadCivil.getRcDirResguardo());
							paramResponsabilidad.put("entidadResguardo", formatoResponsabilidadCivil.getRcEntidadResguardo());
							paramResponsabilidad.put("responsable", formatoResponsabilidadCivil.getRcResponsable());
							paramResponsabilidad.put("telResponsable", formatoResponsabilidadCivil.getRcTelResponsable());
							paramResponsabilidad.put("entidadResponsable",formatoResponsabilidadCivil.getRcEntidadResp());
														
							if(formatoResponsabilidadCivil.getRcTipoSiniestro()!=null) 
							{
								paramResponsabilidad.put("opcionTipoSiniestro",formatoResponsabilidadCivil.getRcTipoSiniestro());
							}
							
							paramResponsabilidad.put("numActa", formatoResponsabilidadCivil.getRcNumActa());
							paramResponsabilidad.put("descripcionVehiculo", formatoResponsabilidadCivil.getRcDescripcionVeh());
							paramResponsabilidad.put("nomOperador", formatoResponsabilidadCivil.getRcNomOperador());
							

							if(formatoResponsabilidadCivil.getRcOpcEbriedad()!=null) {
								if (formatoResponsabilidadCivil.getRcOpcEbriedad() == 1) {
									paramResponsabilidad.put("opcionEbriedad", true);
								} else if (formatoResponsabilidadCivil.getRcOpcEbriedad() == 0) {
									paramResponsabilidad.put("opcionEbriedad", false);
								}							
							}

							
							if(formatoResponsabilidadCivil.getRcOpcLicencia()!=null) {
								if (formatoResponsabilidadCivil.getRcOpcLicencia() == 1) {
									paramResponsabilidad.put("opcionTonelaje", true);
								} else if (formatoResponsabilidadCivil.getRcOpcLicencia() == 0) {
									paramResponsabilidad.put("opcionTonelaje", false);
								}
							}

							
							
							paramResponsabilidad.put("dictamen", formatoResponsabilidadCivil.getRcDictamen());
																				
							if(formatoResponsabilidadCivil.getRcOpcCargaDaniada()!=null) {
								if (formatoResponsabilidadCivil.getRcOpcCargaDaniada() == 1) {
									paramResponsabilidad.put("opcionMercaDaniada", true);
								} else if (formatoResponsabilidadCivil.getRcOpcCargaDaniada() == 0) {
									paramResponsabilidad.put("opcionMercaDaniada", false);
								}
							}
							
							
							paramResponsabilidad.put("descripcionMercancia", formatoResponsabilidadCivil.getRcDescripcionMerc());
							paramResponsabilidad.put("porcentajeAprox", formatoResponsabilidadCivil.getRcPorcentajeAprox());
							
							
							if(formatoResponsabilidadCivil.getRcOpcSeguroTrans()!=null) {
								if (formatoResponsabilidadCivil.getRcOpcSeguroTrans() == 1) {
									paramResponsabilidad.put("opcionViajaSeguro", true);
								} else if (formatoResponsabilidadCivil.getRcOpcSeguroTrans() == 0) {
									paramResponsabilidad.put("opcionViajaSeguro", false);
								}
							}
							
							paramResponsabilidad.put("nomAseguradora", formatoResponsabilidadCivil.getRcNomAseguradora());														
							
							///
							if(formatoResponsabilidadCivil.getRcOpcIntervieneA()!=null) {
								if (formatoResponsabilidadCivil.getRcOpcIntervieneA() == 1) {
									paramResponsabilidad.put("opcionAutoridad", true);
								} else if (formatoResponsabilidadCivil.getRcOpcIntervieneA() == 0) {
									paramResponsabilidad.put("opcionAutoridad", false);
								}
							}
							
							if(formatoResponsabilidadCivil.getRcOpcTraspaleoC()!=null) {
								if (formatoResponsabilidadCivil.getRcOpcTraspaleoC() == 1) {
									paramResponsabilidad.put("opcionTraspaleo", true);
								} else if (formatoResponsabilidadCivil.getRcOpcTraspaleoC() == 0) {
									paramResponsabilidad.put("opcionTraspaleo", false);
								}
							}
														
							
							if( StringUtils.isNotBlank(formatoResponsabilidadCivil.getRcFolioCarta()) ) {
								paramResponsabilidad.put("folioCarta", formatoResponsabilidadCivil.getRcFolioCarta() );
								paramResponsabilidad.put("opcionCarta", true);
							}else {
								paramResponsabilidad.put("opcionCarta", false);
							}
							
							if( StringUtils.isNotBlank(formatoResponsabilidadCivil.getRcFolioFactura()) ) {
								paramResponsabilidad.put("folioFactura", formatoResponsabilidadCivil.getRcFolioFactura() );
								paramResponsabilidad.put("opcionFactura", true);
							}else {
								paramResponsabilidad.put("opcionFactura", false);
							}
							
							if( StringUtils.isNotBlank(formatoResponsabilidadCivil.getRcFolioRemision()) ) {
								paramResponsabilidad.put("folioRemision", formatoResponsabilidadCivil.getRcFolioRemision() );
								paramResponsabilidad.put("opcionRemision", true);
							}else {
								paramResponsabilidad.put("opcionRemision", false);
							}
							
							if( StringUtils.isNotBlank(formatoResponsabilidadCivil.getRcFolioGuia()) ) {
								paramResponsabilidad.put("folioGuia", formatoResponsabilidadCivil.getRcFolioGuia() );
								paramResponsabilidad.put("opcionGuia", true);
							}else {
								paramResponsabilidad.put("opcionGuia", false);
							}
						
							if( StringUtils.isNotBlank(formatoResponsabilidadCivil.getRcFolioMapa()) ) {
								paramResponsabilidad.put("folioMapa", formatoResponsabilidadCivil.getRcFolioMapa() );
								paramResponsabilidad.put("opcionMapa", true);
							}else {
								paramResponsabilidad.put("opcionMapa", false);
							}
						
						
							paramResponsabilidad.put("informeAjustador", formatoResponsabilidadCivil.getRcInformeAjustador());
							paramResponsabilidad.put("nombreAjustador", formatoResponsabilidadCivil.getRcNomAsegurado());
							paramResponsabilidad.put("claveAjustador", formatoResponsabilidadCivil.getRcClaveAjustador());
							paramResponsabilidad.put("nomAseguradoTercero", formatoResponsabilidadCivil.getRcNomAseguradoTercero());
													
							paramResponsabilidad.put("chUno", formatoResponsabilidadCivil.getCheck1());
							paramResponsabilidad.put("chDos", formatoResponsabilidadCivil.getCheck2());
							paramResponsabilidad.put("chTres", formatoResponsabilidadCivil.getCheck3());
							paramResponsabilidad.put("chCuatro", formatoResponsabilidadCivil.getCheck4());

							// ***CROQUIS*//
						String croquis = formatoResponsabilidadCivil.getCroquis();						
							if (croquis != null && !croquis.isEmpty()) {
								InputStream targetcroquis = null;
								byte[] bytes = Base64Decoder.decode(croquis);
								targetcroquis = new ByteArrayInputStream(bytes);
								paramResponsabilidad.put("croquis", targetcroquis);
							}
												
							
							// ***firma Ajustador*//
							String firmaAjustador = formatoResponsabilidadCivil.getFirmaAjustador();						
							if (firmaAjustador != null && !firmaAjustador.isEmpty()) {
								InputStream targetAjustador = null;
								byte[] bytes = Base64Decoder.decode(firmaAjustador);
								targetAjustador = new ByteArrayInputStream(bytes);
								paramResponsabilidad.put("firmaAjustador", targetAjustador);
							}
							
							// ***firma Ajustador*//
							String firmaAseguradoTercero = formatoResponsabilidadCivil.getFirmaAseguradoTercero();						
							if (firmaAseguradoTercero != null && !firmaAseguradoTercero.isEmpty()) {
								InputStream targetAseguradoTercero = null;
								byte[] bytes = Base64Decoder.decode(firmaAseguradoTercero);
								targetAseguradoTercero = new ByteArrayInputStream(bytes);
								paramResponsabilidad.put("firmaAseguradoTercero", targetAseguradoTercero);
							}
							
							paramResponsabilidad.put("chCinco", formatoResponsabilidadCivil.getCheck5());

							paramResponsabilidad.put("chSeis", formatoResponsabilidadCivil.getCheck6());
							
					
							crearArchivoError(FORMATO_RESPONSABILIDAD_CIVIL, fileJrxmlResponsabilidad, paramResponsabilidad,
									formatoResponsabilidadCivil.getRcNumReporte(),
									formatoResponsabilidadCivil.getRcNumPoliza(),
									"" + validarAsegurado(formatoResponsabilidadCivil.getRcNumAsegurado()), ou);
						

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}

	//26
	@SuppressWarnings("unused")
	public void procesoBienesDiversosError(FormatoReparacionBienesDiversos formatoReparacionBienesDiversos, OutputStream ou) {
		try {
			
			fileJrxmlBienesDiversos = new FileInputStream(
					ProveedorApplicationContextFormatos.getApplicationContext()
											.getResource("/OrdenesPases/jrxml/ReparacionBienesDiversos.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();
			
			

							HashMap<String, Object> paramBienes = new HashMap<String, Object>();

							paramBienes.put("imgLogoQualitas", imgLogoQualitas);

							ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();

							paramBienes.put("imgLogoQualitas", imgLogoQualitas);

							if (formatoReparacionBienesDiversos.getBdFecha() != null) {

								Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
										.format(formatoReparacionBienesDiversos.getBdFecha()));

								paramBienes.put("fecha", writeFormatFecha.format(date) + "");

							} else {
								paramBienes.put("fecha", "");
							}
							
						
							
							if (formatoReparacionBienesDiversos.getBdCorreo()!= null) {
								paramBienes.put("correo",
										validarCadena(formatoReparacionBienesDiversos.getBdCorreo()));
								////////////////

							}
						
							paramBienes.put("numReporte", formatoReparacionBienesDiversos.getBdNumReporte());
							paramBienes.put("numSiniestro", formatoReparacionBienesDiversos.getBdNumSiniestro());
							paramBienes.put("folioElectronico", formatoReparacionBienesDiversos.getId()+"");							
							paramBienes.put("nombreAfectado", formatoReparacionBienesDiversos.getBdNombreAfectado());
							paramBienes.put("telefonoAfectado", formatoReparacionBienesDiversos.getBdTelAfectado());
							paramBienes.put("direccionSiniestro", formatoReparacionBienesDiversos.getBdUbicacionSiniestro());
							paramBienes.put("domicilioSiniestro", formatoReparacionBienesDiversos.getBdDomicilioSiniestro());
							paramBienes.put("telefonoSiniestro", formatoReparacionBienesDiversos.getBdTelefonoSiniestro());
							paramBienes.put("direccionResguardo", formatoReparacionBienesDiversos.getBdUbicacionResguardo());
							paramBienes.put("domicilioResguardo", formatoReparacionBienesDiversos.getBdDomicilioResguardo());
							paramBienes.put("telefonoResguardo", formatoReparacionBienesDiversos.getBdTelefonoResguardo());
							paramBienes.put("responsable", formatoReparacionBienesDiversos.getBdResponsable());
							paramBienes.put("correo", formatoReparacionBienesDiversos.getBdCorreo());
							paramBienes.put("observaciones", formatoReparacionBienesDiversos.getBdObservaciones());					
							paramBienes.put("long", formatoReparacionBienesDiversos.getBdLong());
							paramBienes.put("alto", formatoReparacionBienesDiversos.getBdAlto());
							paramBienes.put("ancho", formatoReparacionBienesDiversos.getBdAncho());
							paramBienes.put("tipo", formatoReparacionBienesDiversos.getBdTipo());
							paramBienes.put("serie", formatoReparacionBienesDiversos.getBdSerie());
							paramBienes.put("tramo", formatoReparacionBienesDiversos.getBdTramo());							
							paramBienes.put("km", formatoReparacionBienesDiversos.getBdKm());
							paramBienes.put("descripcionDanios", formatoReparacionBienesDiversos.getBdDescripcionDaniosCan());
							paramBienes.put("describirDaniosPre", formatoReparacionBienesDiversos.getBdDesDaniosPre());		
							paramBienes.put("motivoNoFuncionamiento", formatoReparacionBienesDiversos.getBdMotivo());							
							paramBienes.put("nombreAjustador", formatoReparacionBienesDiversos.getBdNomAjustador());
							paramBienes.put("claveAjustador", formatoReparacionBienesDiversos.getBdClaveAjustador());
							paramBienes.put("nomAseguradoTercero", formatoReparacionBienesDiversos.getBdNomAseguradoTercero());
							
							
							if( StringUtils.isNotBlank(formatoReparacionBienesDiversos.getBdDesDaniosPre()) ) {
								paramBienes.put("opcDaniosPreexistentes", 1);
							}else {
								paramBienes.put("opcDaniosPreexistentes", 0);
							}
							
							if( StringUtils.isNotBlank(formatoReparacionBienesDiversos.getBdMotivo()) ) {
								paramBienes.put("opcFuncionamiento", 1);
							}else {
								paramBienes.put("opcFuncionamiento", 0);
							}
													
							paramBienes.put("chUno", formatoReparacionBienesDiversos.getCheck1());
							paramBienes.put("chDos", formatoReparacionBienesDiversos.getCheck2());
							paramBienes.put("chTres", formatoReparacionBienesDiversos.getCheck3());
							paramBienes.put("chCuatro", formatoReparacionBienesDiversos.getCheck4());

							// ***CROQUIS*//
							String ilustracion = formatoReparacionBienesDiversos.getIlustracion();					
							if (ilustracion != null && !ilustracion.isEmpty()) {
								InputStream target= null;
								byte[] bytes = Base64Decoder.decode(ilustracion);
								target = new ByteArrayInputStream(bytes);
								paramBienes.put("ilustracion", target);
							}
												
							
							// ***firma Ajustador*//
							String firmaAjustador = formatoReparacionBienesDiversos.getFirmaAjustador();						
							if (firmaAjustador != null && !firmaAjustador.isEmpty()) {
								InputStream targetAjustador = null;
								byte[] bytes = Base64Decoder.decode(firmaAjustador);
								targetAjustador = new ByteArrayInputStream(bytes);
								paramBienes.put("firmaAjustador", targetAjustador);
							}
							
							// ***firma Ajustador*//
							String firmaAseguradoTercero = formatoReparacionBienesDiversos.getFirmaAseguradoTercero();						
							if (firmaAseguradoTercero != null && !firmaAseguradoTercero.isEmpty()) {
								InputStream targetAseguradoTercero = null;
								byte[] bytes = Base64Decoder.decode(firmaAseguradoTercero);
								targetAseguradoTercero = new ByteArrayInputStream(bytes);
								paramBienes.put("firmaAseguradoTercero", targetAseguradoTercero);
							}
							
									
							String requeridos =formatoReparacionBienesDiversos.getBdDaniosDiversos();
							if(StringUtils.isNotBlank(requeridos)) {	
								String validada=requeridos.replaceAll(" ", "");
						        String[] arr = validada.split("-");	
						        
						        for(int i=0; i<arr.length; i++) {
						        	 String var="";
						        	 var="d"+arr[i];
						        	 paramBienes.put(var, 1);
						        }
						        
						      
							}
						      
							paramBienes.put("chCinco", formatoReparacionBienesDiversos.getCheck5());

							paramBienes.put("chSeis", formatoReparacionBienesDiversos.getCheck6());
							
							crearArchivoError(FORMATO_BIENES_DIVERSOS, fileJrxmlBienesDiversos, paramBienes,
									formatoReparacionBienesDiversos.getBdNumReporte(),
									formatoReparacionBienesDiversos.getBdNumPoliza(),
									"" + validarAsegurado(formatoReparacionBienesDiversos.getBdNumAsegurado()), ou);
						

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}
		
	
	public void procesoObservacionesAseguradoError(FormatoObservacionesAsegurado formatoObservacionesAsegurado, OutputStream ou) {
		try {
			 
			fileJrxmlObservacionesAsegurado = new FileInputStream(
					ProveedorApplicationContextFormatos.getApplicationContext()
											.getResource("/OrdenesPases/jrxml/ObservacionesAsegurado.jrxml").getFile());

			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();
			
			HashMap<String, Object> paramObservaciones = new HashMap<String, Object>();													
			
			paramObservaciones.put("imgLogoQualitas", imgLogoQualitas);

			if (formatoObservacionesAsegurado.getFoaFecha() != null) {	
				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoObservacionesAsegurado.getFoaFecha()));	
				paramObservaciones.put("fecha", writeFormatFecha.format(date) + "");		
			} else {
				paramObservaciones.put("fecha", "");
			}
			
			paramObservaciones.put("folio", formatoObservacionesAsegurado.getId().toString());
			paramObservaciones.put("numReporte", formatoObservacionesAsegurado.getFoaNumReporte());
			paramObservaciones.put("numSiniestro", formatoObservacionesAsegurado.getFoaNumSiniestro());
			paramObservaciones.put("nombreAjustador", formatoObservacionesAsegurado.getFoaNomAjustador());
			paramObservaciones.put("nomConductor", formatoObservacionesAsegurado.getFoaNomConductor());
			paramObservaciones.put("telConductor", formatoObservacionesAsegurado.getFoaTelefono());
			paramObservaciones.put("emailConductor", formatoObservacionesAsegurado.getFoaCorreoConductor());
			paramObservaciones.put("lugar", formatoObservacionesAsegurado.getFoaLugar());
			paramObservaciones.put("nomConductor", formatoObservacionesAsegurado.getFoaNomConductor());

			paramObservaciones.put("chUno", formatoObservacionesAsegurado.getCheck1());
			paramObservaciones.put("chDos", formatoObservacionesAsegurado.getCheck2());
			paramObservaciones.put("chTres", formatoObservacionesAsegurado.getCheck3());
			paramObservaciones.put("chCuatro", formatoObservacionesAsegurado.getCheck4());
			
			String contenido = validarCadena(formatoObservacionesAsegurado.getFoaObservaciones());
			String nombreRenglon = "observaciones";
			String auxRenglon = "";
			int longitudRenglon = 116;
			int numeroRenglones = 12;
			
			if ((longitudRenglon * numeroRenglones) < contenido.length()) {
				contenido = contenido.substring(0, (longitudRenglon * numeroRenglones));
			}

			float renglonesUsados = (float) contenido.length() / longitudRenglon;
			int inicio = 0;
			int fin = longitudRenglon;

			for (int i = 1; i <= ((int) (Math.ceil(renglonesUsados))); i++) {
				if (i != ((int) Math.ceil(renglonesUsados))) {
					auxRenglon = buscarBlank(contenido, inicio, fin);
					paramObservaciones.put(nombreRenglon + i, auxRenglon);
					inicio = inicio + auxRenglon.length();
					fin = (i + 1) * longitudRenglon;
					auxRenglon = "";
				} else {
					auxRenglon = contenido.substring(inicio, contenido.length());
					paramObservaciones.put(nombreRenglon + i, auxRenglon);
					inicio = inicio + auxRenglon.length();
					fin = (i + 1) * longitudRenglon;
					auxRenglon = "";
				}
			}

			// ***FIRMA*//
			String firma = formatoObservacionesAsegurado.getFirmaConductor();					
			if (firma != null && !firma.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(firma);
				target = new ByteArrayInputStream(bytes);
				paramObservaciones.put("imgBits", target);
			}
			
			paramObservaciones.put("chCinco", formatoObservacionesAsegurado.getCheck5());

			paramObservaciones.put("chSeis", formatoObservacionesAsegurado.getCheck6());
			
							
							crearArchivoError(FORMATO_OBSERVACIONES_ASEGURADO, fileJrxmlObservacionesAsegurado, paramObservaciones,
									formatoObservacionesAsegurado.getFoaNumReporte(),
									formatoObservacionesAsegurado.getFoaNumPoliza(),
									"" + validarAsegurado(formatoObservacionesAsegurado.getFoaNumAsegurado()), ou);
						

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}
	
	
	@SuppressWarnings("unused")
	public void procesoInventarioUnicoPesadoError(FormatoInventarioUnicoPesado formatoInventarioUnicoPesado, OutputStream ou) {
		try {
			
			fileJrxmlInventarioUnicoPesado = new FileInputStream(
					ProveedorApplicationContextFormatos.getApplicationContext()
											.getResource("/OrdenesPases/jrxml/InventarioUnicoEquipoPesado.jrxml").getFile());

			HashMap<String, Object> paramInventario = new HashMap<String, Object>();	
			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/QualitasLogo2.png").getFile().getPath();
			
			paramInventario.put("imgLogoQualitas", imgLogoQualitas);
			
			String imgPesadoCamion = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/pesadoCamion1.jpg").getFile().getPath();
			
			paramInventario.put("imgPesadoCamion", imgPesadoCamion);
			
			String imgPesadoRemolque = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/pesadoRemolque.jpg").getFile().getPath();
			
			paramInventario.put("imgPesadoRemolque", imgPesadoRemolque);

			if (formatoInventarioUnicoPesado.getInp_fecha() != null) {	
				
				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoInventarioUnicoPesado.getInp_fecha()));	
				
				paramInventario.put("fecha", writeFormatFecha.format(date) + "");	
				paramInventario.put("hora",writeFormatHora.format(date)+"");
				
			} else {
				paramInventario.put("fecha", "");
			}
			
			//
			if (formatoInventarioUnicoPesado.getInpCaso1Fecha() != null) {									
				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoInventarioUnicoPesado.getInpCaso1Fecha()));	
				
				paramInventario.put("caso1Fecha", writeFormatFecha.format(date) + "");	
				
				
			} else {
				paramInventario.put("caso1Fecha", "");
			}
			
			//
			if (formatoInventarioUnicoPesado.getInpCaso2Fecha() != null) {									
				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoInventarioUnicoPesado.getInpCaso2Fecha()));	
				
				paramInventario.put("caso2Fecha", writeFormatFecha.format(date) + "");	
				
			} else {
				paramInventario.put("caso2Fecha", "");
			}
			
			//
			if (formatoInventarioUnicoPesado.getInpCaso3Fecha() != null) {									
				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoInventarioUnicoPesado.getInpCaso3Fecha()));	
				
				paramInventario.put("caso3Fecha", writeFormatFecha.format(date) + "");	
				
				
			} else {
				paramInventario.put("caso3Fecha", "");
			}
			
			
			ArrayList<DatosEmailPlantillas> correos = new ArrayList<DatosEmailPlantillas>();					
			paramInventario.put("correo",formatoInventarioUnicoPesado.getInpCorreo()+"");
			paramInventario.put("folio", formatoInventarioUnicoPesado.getId().toString());
			paramInventario.put("numReporte", formatoInventarioUnicoPesado.getInNumReporte());
			paramInventario.put("numSiniestro", formatoInventarioUnicoPesado.getInp_num_siniestro());						
			paramInventario.put("nombreAfectado", formatoInventarioUnicoPesado.getInpNombreAfectado());
			
			if(StringUtils.isNotBlank(formatoInventarioUnicoPesado.getInpNumAsegurado())) {
				
				if(formatoInventarioUnicoPesado.getInpNumAsegurado().equals("1")) {
					paramInventario.put("tipoPersona", 1);
				} else {
					paramInventario.put("tipoPersona", 0);
				}
				
			}
			
			if (formatoInventarioUnicoPesado.getInp_llaves()!=null) {					
					paramInventario.put("llaves", formatoInventarioUnicoPesado.getInp_llaves());								
			}
			
			paramInventario.put("numPoliza", formatoInventarioUnicoPesado.getInpNumPoliza());
			paramInventario.put("numEndoso", formatoInventarioUnicoPesado.getInp_num_endoso());
			paramInventario.put("numInciso", formatoInventarioUnicoPesado.getInp_num_inciso());						
			paramInventario.put("marca", formatoInventarioUnicoPesado.getInp_marca());
			paramInventario.put("tipo", formatoInventarioUnicoPesado.getInpTipo());
			paramInventario.put("puertas", formatoInventarioUnicoPesado.getInpPuertas());							
			paramInventario.put("modelo", formatoInventarioUnicoPesado.getInpModelo());
			paramInventario.put("motor", formatoInventarioUnicoPesado.getInpNumMotor());
			paramInventario.put("kilometraje", formatoInventarioUnicoPesado.getInpKilometraje());
			
			if (formatoInventarioUnicoPesado.getInpCombustible()!=null) {					
				paramInventario.put("combustible", formatoInventarioUnicoPesado.getInpCombustible());								
			}
			
			paramInventario.put("serie", formatoInventarioUnicoPesado.getInpSerie());
			paramInventario.put("color", formatoInventarioUnicoPesado.getInpColor());
			
			
			if (StringUtils.isNotBlank(formatoInventarioUnicoPesado.getInpPlacas())) {
				 String cadena =formatoInventarioUnicoPesado.getInpPlacas();							     
			     String[] arra = cadena.split("\\|");							     
			     if(arra.length>=1) {
			    	  if(arra[0].trim().equals("1")) {
			    		  paramInventario.put("tipoPlacas", 1);
						}	
			    	  if(arra[0].trim().equals("2")) {
			    		  paramInventario.put("tipoPlacas", 2);
						}	
			    	  if(arra[0].trim().equals("3")) {
			    		  paramInventario.put("tipoPlacas", 3);
						}	
			     }
			     if(arra.length>=2) {
			    	 paramInventario.put("placas", arra[1]);										     	  	 
			     	}													
			}
			
			paramInventario.put("originalesCamion", formatoInventarioUnicoPesado.getInpOriginalesCamion());
			paramInventario.put("renovadasCamion", formatoInventarioUnicoPesado.getInpRenovadasCamion());							
			paramInventario.put("daniadasCamion", formatoInventarioUnicoPesado.getInpDaniadasCamion());
			paramInventario.put("faltantesCamion", formatoInventarioUnicoPesado.getInpFaltantesCamion());							
			paramInventario.put("daniadasRemolque", formatoInventarioUnicoPesado.getInpDaniadasRemolque());
			paramInventario.put("faltantesRemolque", formatoInventarioUnicoPesado.getInoFaltantesRemolque());
			
			paramInventario.put("nombreAjustador", formatoInventarioUnicoPesado.getInpNomAjustador());
			paramInventario.put("nombreConductor", formatoInventarioUnicoPesado.getInpNombreConductor());
			paramInventario.put("nombreOperadorGrua", formatoInventarioUnicoPesado.getInpNombreOperadorGrua());
			
			paramInventario.put("caso1Lugar", formatoInventarioUnicoPesado.getInpCaso1Lugar());
			paramInventario.put("caso2Lugar", formatoInventarioUnicoPesado.getInpCaso2Lugar());
			paramInventario.put("caso3Lugar", formatoInventarioUnicoPesado.getInpCaso3Lugar());
			
			paramInventario.put("caso1Observaciones", formatoInventarioUnicoPesado.getInpCaso1Observaciones());
			paramInventario.put("caso2Observaciones", formatoInventarioUnicoPesado.getInpCaso2Observaciones());
			paramInventario.put("caso3Observaciones", formatoInventarioUnicoPesado.getInpCaso3Observaciones());
			
			paramInventario.put("caso1NombreEntrega", formatoInventarioUnicoPesado.getInpCaso1NomEntrega());
			paramInventario.put("caso2NombreEntrega", formatoInventarioUnicoPesado.getInpCaso2NomEntrega());
			paramInventario.put("caso3NombreEntrega", formatoInventarioUnicoPesado.getInpCaso3NomEntrega());
			
			paramInventario.put("caso1NombreRecibe", formatoInventarioUnicoPesado.getInpCaso1NomRecibe());
			paramInventario.put("caso2NombreRecibe", formatoInventarioUnicoPesado.getInpCaso2NomRecibe());
			paramInventario.put("caso3NombreRecibe", formatoInventarioUnicoPesado.getInpCaso3NomRecibe());	
			
			if (StringUtils.isNotBlank(formatoInventarioUnicoPesado.getInpTractocamionPieza())) {
				 String cadena =formatoInventarioUnicoPesado.getInpTractocamionPieza();							     								 								 
			     String[] pieza = cadena.split("\\|");							   
				     for(int i=0; i<pieza.length; i++) {								    	 
				    	  	 String[] elementos = pieza[i].split("_");
					    		 if(elementos.length>0) {									    			 									    			 
					    			if(StringUtils.isNotBlank(elementos[0])){	
					    				String nombreParametro="p"+elementos[0];
					    				 if(elementos.length>1) {						    			 
							    			 if(StringUtils.isNotBlank(elementos[1])){	
							    				 if(elementos[1].trim().equals("1")){
							    					 paramInventario.put(nombreParametro, 1);
							    				 }
							    				 if(elementos[1].trim().equals("0")){
							    					 paramInventario.put(nombreParametro, 0);
							    				 }											    				 
							    			 }
							    		 }									    				 
					    				 String nombreParametroC="c"+elementos[0];
							    		 if(elementos.length>2) {
							    			 if(StringUtils.isNotBlank(elementos[2])){
								    				paramInventario.put(nombreParametroC, elementos[2]+"");
							    			 }
							    		 }
					    				
					    			}									    												    												    			
					    		 }									     
				     }											
			}
			
			paramInventario.put("chUno", formatoInventarioUnicoPesado.getCheck1());
			paramInventario.put("chDos", formatoInventarioUnicoPesado.getCheck2());
			paramInventario.put("chTres", formatoInventarioUnicoPesado.getCheck3());
			paramInventario.put("chCuatro", formatoInventarioUnicoPesado.getCheck4());
			
		
		
			String firmaAjustador = formatoInventarioUnicoPesado.getFirmaAjustador();					
			if (firmaAjustador != null && !firmaAjustador.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(firmaAjustador);
				target = new ByteArrayInputStream(bytes);
				paramInventario.put("firmaAjustador", target);
			}
			
			String firmaConductor = formatoInventarioUnicoPesado.getFirmaConductor();					
			if (firmaConductor != null && !firmaConductor.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(firmaConductor);
				target = new ByteArrayInputStream(bytes);
				paramInventario.put("firmaConductor", target);
			}
			
			String firmaOperadorGrua = formatoInventarioUnicoPesado.getFirmaOperadoGrua();					
			if (firmaOperadorGrua != null && !firmaOperadorGrua.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(firmaOperadorGrua);
				target = new ByteArrayInputStream(bytes);
				paramInventario.put("firmaOperadorGrua", target);
			}
			
			String caso1FirmaEntrega = formatoInventarioUnicoPesado.getFIRMA_CASO1_ENTREGA();					
			if (caso1FirmaEntrega != null && !caso1FirmaEntrega.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(caso1FirmaEntrega);
				target = new ByteArrayInputStream(bytes);
				paramInventario.put("caso1FirmaEntrega", target);
			}
			
			String caso2FirmaEntrega = formatoInventarioUnicoPesado.getFIRMA_CASO2_ENTREGA();					
			if (caso2FirmaEntrega != null && !caso2FirmaEntrega.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(caso2FirmaEntrega);
				target = new ByteArrayInputStream(bytes);
				paramInventario.put("caso2FirmaEntrega", target);
			}
			
			String caso3FirmaEntrega = formatoInventarioUnicoPesado.getFIRMA_CASO3_ENTREGA();					
			if (caso3FirmaEntrega != null && !caso3FirmaEntrega.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(caso3FirmaEntrega);
				target = new ByteArrayInputStream(bytes);
				paramInventario.put("caso3FirmaEntrega", target);
			}
			
			String caso1FirmaRecibe = formatoInventarioUnicoPesado.getFIRMA_CASO1_RECIBE();					
			if (caso1FirmaRecibe != null && !caso1FirmaRecibe.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(caso1FirmaRecibe);
				target = new ByteArrayInputStream(bytes);
				paramInventario.put("caso1FirmaRecibe", target);
			}
			
			String caso2FirmaRecibe = formatoInventarioUnicoPesado.getFIRMA_CASO2_RECIBE();					
			if (caso2FirmaRecibe != null && !caso2FirmaRecibe.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(caso2FirmaRecibe);
				target = new ByteArrayInputStream(bytes);
				paramInventario.put("caso2FirmaRecibe", target);
			}
			
			String caso3FirmaRecibe = formatoInventarioUnicoPesado.getFIRMA_CASO3_RECIBE();					
			if (caso3FirmaRecibe != null && !caso3FirmaRecibe.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(caso3FirmaRecibe);
				target = new ByteArrayInputStream(bytes);
				paramInventario.put("caso3FirmaRecibe", target);
			}
			
			//nuevos agregados
			  String firmaEntregaGral = formatoInventarioUnicoPesado.getFirmaEntregaGral();					
				if (firmaEntregaGral != null && !firmaEntregaGral.isEmpty()) {
					InputStream target= null;
					byte[] bytes = Base64Decoder.decode(firmaEntregaGral);
					target = new ByteArrayInputStream(bytes);
					paramInventario.put("firmaEntregaGral", target);
				}
				
				
				String firmaRecibeGral = formatoInventarioUnicoPesado.getFirmaRecibeGral();					
				if (firmaRecibeGral != null && !firmaRecibeGral.isEmpty()) {
					InputStream target= null;
					byte[] bytes = Base64Decoder.decode(firmaRecibeGral);
					target = new ByteArrayInputStream(bytes);
					paramInventario.put("firmaRecibeGral", target);
				}
								
			
				  if(formatoInventarioUnicoPesado.getInpCaso1UbicacionFlecha()!=null) {
				    	paramInventario.put("caso1UbicacionCardan", formatoInventarioUnicoPesado.getInpCaso1UbicacionFlecha() );
				    }						    
				    if(formatoInventarioUnicoPesado.getInpCaso2UbicacionFlecha()!=null) {
				    	paramInventario.put("caso2UbicacionCardan", formatoInventarioUnicoPesado.getInpCaso2UbicacionFlecha() );
				    }
				    if(formatoInventarioUnicoPesado.getInpCaso3UbicacionFlecha()!=null) {
				    	paramInventario.put("caso3UbicacionCardan", formatoInventarioUnicoPesado.getInpCaso3UbicacionFlecha() );
				    }
				    paramInventario.put("correoTaller", formatoInventarioUnicoPesado.getInpCorreoTaller());
				    paramInventario.put("correoGrua", formatoInventarioUnicoPesado.getInpCorreoGrua() );
				    paramInventario.put("folioElectronico", formatoInventarioUnicoPesado.getInpFolioE() );
				    paramInventario.put("nombreEntregaGral", formatoInventarioUnicoPesado.getInpNomEntregaGral() );
				    paramInventario.put("nombreRecibeGral", formatoInventarioUnicoPesado.getInpNomRecibeGral() );  
				    
					paramInventario.put("caso1ALugar", formatoInventarioUnicoPesado.getInpCaso1ALugar());
				    paramInventario.put("caso1Prestador", formatoInventarioUnicoPesado.getInpCaso1Prestador());							   
				    paramInventario.put("caso1Crucero", formatoInventarioUnicoPesado.getInpCaso1Crucero() );
				    paramInventario.put("caso1Taller", formatoInventarioUnicoPesado.getInpCaso1Taller() );
				    paramInventario.put("caso1MP", formatoInventarioUnicoPesado.getInpCaso1Mp() );
				    paramInventario.put("caso1Ajustador", formatoInventarioUnicoPesado.getInpCaso1Ajustador());
				    
				    paramInventario.put("caso2ALugar", formatoInventarioUnicoPesado.getInpCaso2ALugar());
				    paramInventario.put("caso2Prestador", formatoInventarioUnicoPesado.getInpCaso2Prestador() );
				    paramInventario.put("caso2Crucero", formatoInventarioUnicoPesado.getInpCaso2Crucero());
				    paramInventario.put("caso2Taller", formatoInventarioUnicoPesado.getInpCaso2Taller() );
				    paramInventario.put("caso2MP", formatoInventarioUnicoPesado.getInpCaso2Mp() );
				    paramInventario.put("caso2Ajustador", formatoInventarioUnicoPesado.getInpCaso2Ajustador() );
				    
				    
				    paramInventario.put("caso3ALugar", formatoInventarioUnicoPesado.getInpCaso3ALugar());
				    paramInventario.put("caso3Prestador", formatoInventarioUnicoPesado.getInpCaso3Prestador() );
				    paramInventario.put("caso3Crucero", formatoInventarioUnicoPesado.getInpCaso3Crucero() );
				    paramInventario.put("caso3Taller", formatoInventarioUnicoPesado.getInpCaso3Taller());
				    paramInventario.put("caso3MP", formatoInventarioUnicoPesado.getInpCaso3Mp() );
				    paramInventario.put("caso3Ajustador", formatoInventarioUnicoPesado.getInpCaso3Ajustador());

				String cadena1 = formatoInventarioUnicoPesado.getInpCaso1DaniosFaltantes();
				String nombreParamNum = "caso1Num";
				String nombreParamDanio = "caso1Danio";
				if (StringUtils.isNotBlank(cadena1)) {
					String[] arra = cadena1.split("\\|");
					if (arra.length > 0) {
						for (int i = 0; i < arra.length; i++) {
							if (i < 4) {
								String[] arra1 = arra[i].split("_");
								if (arra1.length > 0) {
									if (arra1.length > 0) {
										if (StringUtils.isNotBlank(arra1[0])) {
											paramInventario.put(nombreParamNum + (i + 1), arra1[0]);
										}
									}
									if (arra1.length > 1) {
										if (StringUtils.isNotBlank(arra1[1])) {
											paramInventario.put(nombreParamDanio + (i + 1), arra1[1]);
										}
									}
								}
							}
						}
					}

				}

				String cadena2 = formatoInventarioUnicoPesado.getInpCaso2DaniosFaltantes();
				String nombreParamNum2 = "caso2Num";
				String nombreParamDanio2 = "caso2Danio";
				if (StringUtils.isNotBlank(cadena2)) {
					String[] arra = cadena2.split("\\|");
					if (arra.length > 0) {
						for (int i = 0; i < arra.length; i++) {
							if (i < 4) {
								String[] arra1 = arra[i].split("_");
								if (arra1.length > 0) {
									if (arra1.length > 0) {
										if (StringUtils.isNotBlank(arra1[0])) {
											paramInventario.put(nombreParamNum2 + (i + 1), arra1[0]);
										}
									}
									if (arra1.length > 1) {
										if (StringUtils.isNotBlank(arra1[1])) {
											paramInventario.put(nombreParamDanio2 + (i + 1), arra1[1]);
										}
									}
								}
							}
						}
					}

				}

				String cadena3 = formatoInventarioUnicoPesado.getInpCaso3DaniosFaltantes();
				String nombreParamNum3 = "caso3Num";
				String nombreParamDanio3 = "caso3Danio";
				if (StringUtils.isNotBlank(cadena3)) {
					String[] arra = cadena3.split("\\|");
					if (arra.length > 0) {
						for (int i = 0; i < arra.length; i++) {
							if (i < 4) {
								String[] arra1 = arra[i].split("_");
								if (arra1.length > 0) {
									if (arra1.length > 0) {
										if (StringUtils.isNotBlank(arra1[0])) {
											paramInventario.put(nombreParamNum3 + (i + 1), arra1[0]);
										}
									}
									if (arra1.length > 1) {
										if (StringUtils.isNotBlank(arra1[1])) {
											paramInventario.put(nombreParamDanio3 + (i + 1), arra1[1]);
										}
									}
								}
							}
						}
					}

				}
		    
			//////////////////
				paramInventario.put("chCinco", formatoInventarioUnicoPesado.getCheck5());

				paramInventario.put("chSeis", formatoInventarioUnicoPesado.getCheck6());
				
							
							crearArchivoError(FORMATO_INVENTARIO_PESADO, fileJrxmlInventarioUnicoPesado, paramInventario,
									formatoInventarioUnicoPesado.getInNumReporte(),
									formatoInventarioUnicoPesado.getInpNumPoliza(),
									"" + validarAsegurado(formatoInventarioUnicoPesado.getInpNumAsegurado()), ou);
						

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}
	
	
	
	
	
	
	public void procesoReclamacionComprobantePeajeError(FormatoReclamacionComprobantePeaje formatoReclamacionComprobantePeaje, OutputStream ou) {
		try {
			
			fileJrxmlReclamacionComprobantePeaje = new FileInputStream(
					ProveedorApplicationContextFormatos.getApplicationContext()
											.getResource("/OrdenesPases/jrxml/ReclamoSiniestro.jrxml").getFile());

			
			
			HashMap<String, Object> paramPeaje = new HashMap<String, Object>();													
			String imgLogoQualitas = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/logoQualitas.png").getFile().getPath();
			
			paramPeaje.put("imgLogoQualitas", imgLogoQualitas);
			
																
			

			if (formatoReclamacionComprobantePeaje.getRcp_fecha_siniestro() != null) {	
				
				Date date = readFormat.parse(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
						.format(formatoReclamacionComprobantePeaje.getRcp_fecha_siniestro()));	
				
				paramPeaje.put("fechaSiniestro", writeFormatFecha.format(date));
				
			}
			
				paramPeaje.put("correoUsuario",
						validarCadena(formatoReclamacionComprobantePeaje.getRcp_correo_usuario()));

			
		
			paramPeaje.put("folio", formatoReclamacionComprobantePeaje.getId().toString());
			paramPeaje.put("nombreUsuario", formatoReclamacionComprobantePeaje.getRcp_nom_usuario());
			
			if(StringUtils.isNotBlank(formatoReclamacionComprobantePeaje.getRcp_sexo_usuario())) {
				paramPeaje.put("sexoUsuario", formatoReclamacionComprobantePeaje.getRcp_sexo_usuario().toUpperCase());	
			}
			
			paramPeaje.put("edadUsuario", formatoReclamacionComprobantePeaje.getRcp_edad_usuario());						
			paramPeaje.put("estadoCivilUsuario", formatoReclamacionComprobantePeaje.getRcp_estado_civil_usuario());
			paramPeaje.put("ocupacionUsuario", formatoReclamacionComprobantePeaje.getRcp_ocupacion_usuario());
			paramPeaje.put("telefonoUsuario", formatoReclamacionComprobantePeaje.getRcp_telefono_usuario());
			paramPeaje.put("correoUsuario", formatoReclamacionComprobantePeaje.getRcp_correo_usuario());						
			paramPeaje.put("calleUsuario", formatoReclamacionComprobantePeaje.getRcp_calle_usuario());
			paramPeaje.put("coloniaUsuario", formatoReclamacionComprobantePeaje.getRcp_colonia_usuario());		
			paramPeaje.put("cpUsuario", formatoReclamacionComprobantePeaje.getRcp_cp_usuario());						
			paramPeaje.put("estadoUsuario", formatoReclamacionComprobantePeaje.getRcp_estado_usuario());
			paramPeaje.put("poblacionUsuario", formatoReclamacionComprobantePeaje.getRcp_poblacion_usuario());
			paramPeaje.put("delegacionUsuario", formatoReclamacionComprobantePeaje.getRcp_delegacion_usuario());
			
			paramPeaje.put("calleOficina", formatoReclamacionComprobantePeaje.getRcp_calle_oficina());						
			paramPeaje.put("coloniaOficina", formatoReclamacionComprobantePeaje.getRcp_colonia_oficina());
			paramPeaje.put("cpOficina", formatoReclamacionComprobantePeaje.getRcp_cp_oficina());
			paramPeaje.put("estadoOficina", formatoReclamacionComprobantePeaje.getRcp_estado_oficina());					
			paramPeaje.put("poblacionOficina", formatoReclamacionComprobantePeaje.getRcp_poblacion_oficina());						
			paramPeaje.put("delegacionOficina", formatoReclamacionComprobantePeaje.getRcp_delegacion_oficina());
			
			if(formatoReclamacionComprobantePeaje.getRcp_razon_circula_auto()!=null) {
				paramPeaje.put("circulaAutopista", formatoReclamacionComprobantePeaje.getRcp_razon_circula_auto());
			}
			
			paramPeaje.put("marca", formatoReclamacionComprobantePeaje.getRcp_marca_vehiculo());

			if(formatoReclamacionComprobantePeaje.getRcp_vehiculo_propio()!=null) {
				paramPeaje.put("vehiculoPropio", formatoReclamacionComprobantePeaje.getRcp_vehiculo_propio());
			}
			
			paramPeaje.put("licencia", formatoReclamacionComprobantePeaje.getRcp_licencia());
			paramPeaje.put("origenViaje", formatoReclamacionComprobantePeaje.getRcp_origen_viaje());
			paramPeaje.put("destinoViaje", formatoReclamacionComprobantePeaje.getRcp_destino_viaje());
			paramPeaje.put("motivoNoComprobante", formatoReclamacionComprobantePeaje.getRcp_motivo_no_comprob());
			
			paramPeaje.put("nombreAjustador", formatoReclamacionComprobantePeaje.getRcp_nom_ajustador());
			paramPeaje.put("nombreAdministracion", formatoReclamacionComprobantePeaje.getRcp_nom_administracion());
			paramPeaje.put("nombreTestigo1", formatoReclamacionComprobantePeaje.getRcp_testigo_1());
			paramPeaje.put("nombreTestigo2", formatoReclamacionComprobantePeaje.getRcp_testigo_2());
			
			if(formatoReclamacionComprobantePeaje.getRcp_pago_previo_peaje()!=null) {
				paramPeaje.put("pagoPrevioSiniestro", formatoReclamacionComprobantePeaje.getRcp_pago_previo_peaje());
			}
			
			paramPeaje.put("nombrePlaza1", formatoReclamacionComprobantePeaje.getRcp_nom_plaza_1());
			paramPeaje.put("nombrePlaza2", formatoReclamacionComprobantePeaje.getRcp_nom_plaza_2());
			paramPeaje.put("cantidadPlaza1", formatoReclamacionComprobantePeaje.getRcp_cantidad_plaza_1());
			paramPeaje.put("cantidadPlaza2", formatoReclamacionComprobantePeaje.getRcp_cantidad_plaza_2());
			
			
			
			
			if (StringUtils.isNotBlank(formatoReclamacionComprobantePeaje.getRcp_frecuencia_circula())) {
				 String cadena =formatoReclamacionComprobantePeaje.getRcp_frecuencia_circula();							     
			     
			    	  if(cadena.equals("1")||cadena.equals("2")||cadena.equals("3")) {
			    		  paramPeaje.put("frecuenciaCircula", Integer.parseInt(cadena));
						}	else {
							 paramPeaje.put("fecuenciaCirculaOtro", cadena);
						}
			    	  
			     }
			     												
			
			
			
			
			if (formatoReclamacionComprobantePeaje.getRcp_tarjeta_iave()!=null) {					
					paramPeaje.put("pagoIave", formatoReclamacionComprobantePeaje.getRcp_tarjeta_iave());								
			}

		
			
			
			if (StringUtils.isNotBlank(formatoReclamacionComprobantePeaje.getRcp_pago_tarjeta_credito())) {
				 String cadena =formatoReclamacionComprobantePeaje.getRcp_pago_tarjeta_credito();							     
			     String[] arra = cadena.split("\\|");							     
			     if(arra.length>=1) {
			    	  if(arra[0].trim().equals("1")) {
			    		  paramPeaje.put("pagoTarjeta", 1);
			    		  
			    		  if(arra.length>=2) {
						    	 paramPeaje.put("pagoTarjetaBanco", arra[1]);										     	  	 
						   }	
						}	
			    	  if(arra[0].trim().equals("0")) {
			    		  paramPeaje.put("pagoTarjeta", 0);
			    		  if(arra.length>=2) {
						    	 paramPeaje.put("pagoTarjetaOtro", arra[1]);										     	  	 
						   }
						}	
			     }
			    												
			}
			
		
				 												
				if (StringUtils.isNotBlank(formatoReclamacionComprobantePeaje.getRcp_via_ingreso())) {
					 String cadena =formatoReclamacionComprobantePeaje.getRcp_via_ingreso();							     
				     
				    	  if(cadena.equals("1")||cadena.equals("2")||cadena.equals("3")) {
				    		  paramPeaje.put("viaIngreso", Integer.parseInt(cadena));
							}	else {
								 paramPeaje.put("viaIngresoEspecificar", cadena);
							}
				    	  
				     }
				     	
			
			paramPeaje.put("motivoDanio", formatoReclamacionComprobantePeaje.getRcp_motivo_danio());
			
			if (formatoReclamacionComprobantePeaje.getRcp_causa_meteorologica()!=null) {					
					paramPeaje.put("causaMeteorologica", formatoReclamacionComprobantePeaje.getRcp_causa_meteorologica());								
			}
			
			if (formatoReclamacionComprobantePeaje.getRcp_causa_evento()!=null) {					
				paramPeaje.put("causaEvento", formatoReclamacionComprobantePeaje.getRcp_causa_evento());								
			}
			
			if (formatoReclamacionComprobantePeaje.getRcp_ingirio_sustancia()!=null) {					
				paramPeaje.put("ingirioBebidas", formatoReclamacionComprobantePeaje.getRcp_ingirio_sustancia());								
			}
			
			if (formatoReclamacionComprobantePeaje.getRcp_vehiculo_asegurado()!=null) {					
				paramPeaje.put("vehiculoAsegurado", formatoReclamacionComprobantePeaje.getRcp_vehiculo_asegurado());								
			}
			
			
			paramPeaje.put("vehiculoPoliza", formatoReclamacionComprobantePeaje.getRcp_vehiculo_asegurado_poliza());
			paramPeaje.put("vehiculoCompania", formatoReclamacionComprobantePeaje.getRcp_vehiculo_asegurado_compania());
			
			if (StringUtils.isNotBlank(formatoReclamacionComprobantePeaje.getRcp_anexo_identificacion())) {
				 String cadena =formatoReclamacionComprobantePeaje.getRcp_anexo_identificacion();							     
			     
			    	  if(cadena.equals("1")||cadena.equals("2")) {
			    		  paramPeaje.put("anexoIdentificacion", Integer.parseInt(cadena));
						}	else {
							 paramPeaje.put("anexoIdentificacionOtro", cadena);
						}
			    	  
			     }
			
			paramPeaje.put("anexoLicencia", formatoReclamacionComprobantePeaje.getRcp_licencia());						
			paramPeaje.put("narracionSiniestro", formatoReclamacionComprobantePeaje.getRcp_anexo_narracion());
			paramPeaje.put("nombreTestigo", formatoReclamacionComprobantePeaje.getRcp_nom_testigo());
			paramPeaje.put("relacionTestigo", formatoReclamacionComprobantePeaje.getRcp_relacion_testigo());							
			paramPeaje.put("telefonoTestigo", formatoReclamacionComprobantePeaje.getRcp_telefono_testigo());
			paramPeaje.put("calleTestigo", formatoReclamacionComprobantePeaje.getRcp_calle_testigo());
			paramPeaje.put("coloniaTestigo", formatoReclamacionComprobantePeaje.getRcp_colonia_testigo());					
			paramPeaje.put("cpTestigo", formatoReclamacionComprobantePeaje.getRcp_cp_testigo());
			paramPeaje.put("estadoTestigo", formatoReclamacionComprobantePeaje.getRcp_estado_testigo());
			
			paramPeaje.put("poblacionTestigo", formatoReclamacionComprobantePeaje.getRcp_poblacion_testigo());
			paramPeaje.put("delegacionTestigo", formatoReclamacionComprobantePeaje.getRcp_delegacion_testigo());
			paramPeaje.put("declaracionTestigo", formatoReclamacionComprobantePeaje.getRcp_declaracion_testigo());

		
			paramPeaje.put("chUno", formatoReclamacionComprobantePeaje.getCheck1());
			paramPeaje.put("chDos", formatoReclamacionComprobantePeaje.getCheck2());
			paramPeaje.put("chTres", formatoReclamacionComprobantePeaje.getCheck3());
			paramPeaje.put("chCuatro", formatoReclamacionComprobantePeaje.getCheck4());
			
		
		
			String firmaAjustador = formatoReclamacionComprobantePeaje.getFirma_ajustador();					
			if (firmaAjustador != null && !firmaAjustador.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(firmaAjustador);
				target = new ByteArrayInputStream(bytes);
				paramPeaje.put("firmaAjustador", target);
			}
			
			String firmaAdministracion = formatoReclamacionComprobantePeaje.getFirma_administracion();					
			if (firmaAdministracion != null && !firmaAdministracion.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(firmaAdministracion);
				target = new ByteArrayInputStream(bytes);
				paramPeaje.put("firmaAdministracion", target);
			}
			
			String firmaUsuario = formatoReclamacionComprobantePeaje.getFirma_usuario();					
			if (firmaUsuario != null && !firmaUsuario.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(firmaUsuario);
				target = new ByteArrayInputStream(bytes);
				paramPeaje.put("firmaUsuario", target);
			}
			
			String firmaTestigo1 = formatoReclamacionComprobantePeaje.getFirma_testigo1();					
			if (firmaTestigo1 != null && !firmaTestigo1.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(firmaTestigo1);
				target = new ByteArrayInputStream(bytes);
				paramPeaje.put("firmaTestigo1", target);
			}
			
			String firmaTestigo2 = formatoReclamacionComprobantePeaje.getFirma_testigo2();					
			if (firmaTestigo2 != null && !firmaTestigo2.isEmpty()) {
				InputStream target= null;
				byte[] bytes = Base64Decoder.decode(firmaTestigo2);
				target = new ByteArrayInputStream(bytes);
				paramPeaje.put("firmaTestigo2", target);
			}
			
			paramPeaje.put("chCinco", formatoReclamacionComprobantePeaje.getCheck5());

			paramPeaje.put("chSeis", formatoReclamacionComprobantePeaje.getCheck6());
			
							
							crearArchivoError(FORMATO_RECLAMACION_COMPROBANTE_PEAJE, fileJrxmlReclamacionComprobantePeaje, paramPeaje,
									formatoReclamacionComprobantePeaje.getRcp_num_reporte(),
									formatoReclamacionComprobantePeaje.getRcp_num_poliza(),
									"" + validarAsegurado(formatoReclamacionComprobantePeaje.getRcp_num_asegurado()), ou);
						

		} catch (Exception ex) {
			this.loggerDownload.info("Ocurrio un error: "+ex);
		}
	}



	public String validarCadenaDUA(String cadena) {

		if (cadena == null) {

			return " ";

		}

		else {

			return cadena.replaceAll("\n", " ");

		}

	}
	public String formarCantidad(String numero) {

		String numeroPesos = "";

		String numeroCentavos = "";

		String cantidadLetraPesos = "";

		numero = numero.replace(",", "");

		if (numero.contains(".")) {

			for (int i = 0; i < numero.length(); i++) {

				if (numero.charAt(i) == '.') {

					numeroPesos = numero.substring(0, i);

					numero = numero + "00";

					numeroCentavos = numero.substring((i + 1), i + 3);

				}

			}

		} else {

			numeroPesos = numero;

			numeroCentavos = "00";

		}

		int unidad = 0;

		int valor = 0;

		String cifra = "";

		for (int i = numeroPesos.length() - 1; i >= 0; i = i - 3) {

			valor = 0;

			cifra = "";

			if ((i - 2) >= 0) {

				valor = 2;

			} else if ((i - 1) >= 0) {

				valor = 1;

			} else if ((i - 0) >= 0) {

				valor = 0;

			}

			switch (unidad) {

			case 0:

				cifra = numeroLetraCientos(numeroPesos.substring(i - valor, i + 1), unidad);

				cantidadLetraPesos = cifra + cantidadLetraPesos;

				break;

			case 1:

				if (Integer.parseInt(numeroPesos.substring(i - valor, i + 1)) == 1) {

					cifra = " mil ";

					cantidadLetraPesos = cifra + cantidadLetraPesos;

				} else {

					cifra = numeroLetraCientos(numeroPesos.substring(i - valor, i + 1), unidad) + " mil ";

					if (cifra.replaceAll(" ", "").equals("mil")) {

						cifra = "";

					}

					cantidadLetraPesos = cifra + cantidadLetraPesos;

				}

				break;

			case 2:

				if (Integer.parseInt(numeroPesos.substring(i - valor, i + 1)) == 1) {

					cifra = " un millon ";

					cantidadLetraPesos = cifra + cantidadLetraPesos;

				} else {

					cifra = numeroLetraCientos(numeroPesos.substring(i - valor, i + 1), unidad) + " millones ";

					cantidadLetraPesos = cifra + cantidadLetraPesos;

					if (cifra.replaceAll(" ", "").equals("millones")) {

						cifra = "";

					}

				}

				break;

			case 3:

				if (Integer.parseInt(numeroPesos.substring(i - valor, i + 1)) == 1) {

					cifra = " mil ";

					cantidadLetraPesos = cifra + cantidadLetraPesos;

				} else {

					cifra = numeroLetraCientos(numeroPesos.substring(i - valor, i + 1), unidad) + " mil ";

					cantidadLetraPesos = cifra + cantidadLetraPesos;

					if (cifra.replaceAll(" ", "").equals("mil")) {

						cifra = "";

					}

				}

				break;

			case 4:

				if (Integer.parseInt(numeroPesos.substring(i - valor, i + 1)) == 1) {

					cifra = " un billon ";

					cantidadLetraPesos = cifra + cantidadLetraPesos;

				} else {

					cifra = numeroLetraCientos(numeroPesos.substring(i - valor, i + 1), unidad) + " billones ";

					cantidadLetraPesos = cifra + cantidadLetraPesos;

					if (cifra.replaceAll(" ", "").equals("billones")) {

						cifra = "";

					}

				}

				break;

			case 5:

				if (Integer.parseInt(numeroPesos.substring(i - valor, i + 1)) == 1) {

					cifra = " mil ";

					cantidadLetraPesos = cifra + cantidadLetraPesos;

				} else {

					cifra = numeroLetraCientos(numeroPesos.substring(i - valor, i + 1), unidad) + " mil ";

					cantidadLetraPesos = cifra + cantidadLetraPesos;

					if (cifra.replaceAll(" ", "").equals("mil")) {

						cifra = "";

					}

				}

				break;

			case 6:

				if (Integer.parseInt(numeroPesos.substring(i - valor, i + 1)) == 1) {

					cifra = " un trillon ";

					cantidadLetraPesos = cifra + cantidadLetraPesos;

				} else {

					cifra = numeroLetraCientos(numeroPesos.substring(0, i + 1), unidad) + " trillones ";

					cantidadLetraPesos = cifra + cantidadLetraPesos;

					if (cifra.replaceAll(" ", "").equals("trillones")) {

						cifra = "";

					}

				}

				break;

			}

			unidad++;

		}

		String centavo = numeroLetraCientos(numeroCentavos, 0) + "";

		if (centavo.equals("")) {

			centavo = " cero ";

		}

		return cantidadLetraPesos + " ";

	}

	public String numeroLetraCientos(String numero, int unidad) {

		String cadena = "";

		numero = Integer.toString(Integer.parseInt(numero));

		if (numero.equals("100")) {

			cadena = "cien";

		} else {

			if (numero.length() == 3) {

				switch (Integer.parseInt(numero.substring(numero.length() - 2, numero.length()))) {

				case 0:

					break;

				case 1:

					if (unidad == 0) {

						cadena = "uno";

					} else {

						cadena = " un ";

					}

					break;

				case 2:

					cadena = "dos";

					break;

				case 3:

					cadena = "tres";

					break;

				case 4:

					cadena = "cuatro";

					break;

				case 5:

					cadena = "cinco";

					break;

				case 6:

					cadena = "seis";

					break;

				case 7:

					cadena = "siete";

					break;

				case 8:

					cadena = "ocho";

					break;

				case 9:

					cadena = "nueve";

					break;

				case 10:

					cadena = "diez";

					break;

				case 11:

					cadena = "once";

					break;

				case 12:

					cadena = "doce";

					break;

				case 13:

					cadena = "trece";

					break;

				case 14:

					cadena = "catorce";

					break;

				case 15:

					cadena = "quince";

					break;

				case 16:

					cadena = "dieciséis";

					break;

				case 17:

					cadena = "diecisiete";

					break;

				case 18:

					cadena = "dieciocho";

					break;

				case 19:

					cadena = "diecinueve";

					break;

				case 20:

					cadena = "veinte";

					break;

				case 21:

					cadena = "veintiuno";

					break;

				case 22:

					cadena = "veintidós";

					break;

				case 23:

					cadena = "veintitrés";

					break;

				case 24:

					cadena = "veinticuatro";

					break;

				case 25:

					cadena = "veinticinco";

					break;

				case 26:

					cadena = "veintiséis";

					break;

				case 27:

					cadena = "veintisiete";

					break;

				case 28:

					cadena = "veintiocho";

					break;

				case 29:

					cadena = "veintinueve";

					break;

				case 30:

					cadena = "treinta";

					break;

				case 31:

					cadena = "treinta y uno";

					break;

				case 32:

					cadena = "treinta y dos";

					break;

				case 33:

					cadena = "treinta y tres";

					break;

				case 34:

					cadena = "treinta y cuatro";

					break;

				case 35:

					cadena = "treinta y cinco";

					break;

				case 36:

					cadena = "treinta y seis";

					break;

				case 37:

					cadena = "treinta y siete";

					break;

				case 38:

					cadena = "treinta y ocho";

					break;

				case 39:

					cadena = "treinta y nueve";

					break;

				case 40:

					cadena = "cuarenta";

					break;

				case 41:

					cadena = "cuarenta y uno";

					break;

				case 42:

					cadena = "cuarenta y dos";

					break;

				case 43:

					cadena = "cuarenta y tres";

					break;

				case 44:

					cadena = "cuarenta y cuatro";

					break;

				case 45:

					cadena = "cuarenta y cinco";

					break;

				case 46:

					cadena = "cuarenta y seis";

					break;

				case 47:

					cadena = "cuarenta y siete";

					break;

				case 48:

					cadena = "cuarenta y ocho";

					break;

				case 49:

					cadena = "cuarenta y nueve";

					break;

				case 50:

					cadena = "cincuenta";

					break;

				case 51:

					cadena = "cincuenta y uno";

					break;

				case 52:

					cadena = "cincuenta y dos";

					break;

				case 53:

					cadena = "cincuenta y tres";

					break;

				case 54:

					cadena = "cincuenta y cuatro";

					break;

				case 55:

					cadena = "cincuenta y cinco";

					break;

				case 56:

					cadena = "cincuenta y seis";

					break;

				case 57:

					cadena = "cincuenta y siete";

					break;

				case 58:

					cadena = "cincuenta y ocho";

					break;

				case 59:

					cadena = "cincuenta y nueve";

					break;

				case 60:

					cadena = "sesenta";

					break;

				case 61:

					cadena = "sesenta y uno";

					break;

				case 62:

					cadena = "sesenta y dos";

					break;

				case 63:

					cadena = "sesenta y tres";

					break;

				case 64:

					cadena = "sesenta y cuatro";

					break;

				case 65:

					cadena = "sesenta y cinco";

					break;

				case 66:

					cadena = "sesenta y seis";

					break;

				case 67:

					cadena = "sesenta y siete";

					break;

				case 68:

					cadena = "sesenta y ocho";

					break;

				case 69:

					cadena = "sesenta y nueve";

					break;

				case 70:

					cadena = "setenta";

					break;

				case 71:

					cadena = "setenta y uno";

					break;

				case 72:

					cadena = "setenta y dos";

					break;

				case 73:

					cadena = "setenta y tres";

					break;

				case 74:

					cadena = "setenta y cuatro";

					break;

				case 75:

					cadena = "setenta y cinco";

					break;

				case 76:

					cadena = "setenta y seis";

					break;

				case 77:

					cadena = "setenta y siete";

					break;

				case 78:

					cadena = "setenta y ocho";

					break;

				case 79:

					cadena = "setenta y nueve";

					break;

				case 80:

					cadena = "ochenta";

					break;

				case 81:

					cadena = "ochenta y uno";

					break;

				case 82:

					cadena = "ochenta y dos";

					break;

				case 83:

					cadena = "ochenta y tres";

					break;

				case 84:

					cadena = "ochenta y cuatro";

					break;

				case 85:

					cadena = "ochenta y cinco";

					break;

				case 86:

					cadena = "ochenta y seis";

					break;

				case 87:

					cadena = "ochenta y siete";

					break;

				case 88:

					cadena = "ochenta y ocho";

					break;

				case 89:

					cadena = "ochenta y nueve";

					break;

				case 90:

					cadena = "noventa";

					break;

				case 91:

					cadena = "noventa y uno";

					break;

				case 92:

					cadena = "noventa y dos";

					break;

				case 93:

					cadena = "noventa y tres";

					break;

				case 94:

					cadena = "noventa y cuatro";

					break;

				case 95:

					cadena = "noventa y cinco";

					break;

				case 96:

					cadena = "noventa y seis";

					break;

				case 97:

					cadena = "noventa y siete";

					break;

				case 98:

					cadena = "noventa y ocho";

					break;

				case 99:

					cadena = "noventa y nueve";

					break;

				}

				switch (numero.charAt(0)) {

				case '0':

					break;

				case '1':

					cadena = "ciento " + cadena;

					break;

				case '2':

					cadena = "doscientos " + cadena;

					break;

				case '3':

					cadena = "trescientos " + cadena;

					break;

				case '4':

					cadena = "cuatrocientos " + cadena;

					break;

				case '5':

					cadena = "quinientos " + cadena;

					break;

				case '6':

					cadena = "seiscientos " + cadena;

					break;

				case '7':

					cadena = "setecientos " + cadena;

					break;

				case '8':

					cadena = "ochocientos " + cadena;

					break;

				case '9':

					cadena = "novecientos " + cadena;

					break;

				}

			} else if (numero.length() == 2 || numero.length() == 1) {

				switch (Integer.parseInt(numero)) {

				case 0:

					break;

				case 1:

					if (unidad == 0) {

						cadena = "uno";

					} else {

						cadena = " un ";

					}

					break;

				case 2:

					cadena = "dos";

					break;

				case 3:

					cadena = "tres";

					break;

				case 4:

					cadena = "cuatro";

					break;

				case 5:

					cadena = "cinco";

					break;

				case 6:

					cadena = "seis";

					break;

				case 7:

					cadena = "siete";

					break;

				case 8:

					cadena = "ocho";

					break;

				case 9:

					cadena = "nueve";

					break;

				case 10:

					cadena = "diez";

					break;

				case 11:

					cadena = "once";

					break;

				case 12:

					cadena = "doce";

					break;

				case 13:

					cadena = "trece";

					break;

				case 14:

					cadena = "catorce";

					break;

				case 15:

					cadena = "quince";

					break;

				case 16:

					cadena = "dieciséis";

					break;

				case 17:

					cadena = "diecisiete";

					break;

				case 18:

					cadena = "dieciocho";

					break;

				case 19:

					cadena = "diecinueve";

					break;

				case 20:

					cadena = "veinte";

					break;

				case 21:

					cadena = "veintiuno";

					break;

				case 22:

					cadena = "veintidós";

					break;

				case 23:

					cadena = "veintitrés";

					break;

				case 24:

					cadena = "veinticuatro";

					break;

				case 25:

					cadena = "veinticinco";

					break;

				case 26:

					cadena = "veintiséis";

					break;

				case 27:

					cadena = "veintisiete";

					break;

				case 28:

					cadena = "veintiocho";

					break;

				case 29:

					cadena = "veintinueve";

					break;

				case 30:

					cadena = "treinta";

					break;

				case 31:

					cadena = "treinta y uno";

					break;

				case 32:

					cadena = "treinta y dos";

					break;

				case 33:

					cadena = "treinta y tres";

					break;

				case 34:

					cadena = "treinta y cuatro";

					break;

				case 35:

					cadena = "treinta y cinco";

					break;

				case 36:

					cadena = "treinta y seis";

					break;

				case 37:

					cadena = "treinta y siete";

					break;

				case 38:

					cadena = "treinta y ocho";

					break;

				case 39:

					cadena = "treinta y nueve";

					break;

				case 40:

					cadena = "cuarenta";

					break;

				case 41:

					cadena = "cuarenta y uno";

					break;

				case 42:

					cadena = "cuarenta y dos";

					break;

				case 43:

					cadena = "cuarenta y tres";

					break;

				case 44:

					cadena = "cuarenta y cuatro";

					break;

				case 45:

					cadena = "cuarenta y cinco";

					break;

				case 46:

					cadena = "cuarenta y seis";

					break;

				case 47:

					cadena = "cuarenta y siete";

					break;

				case 48:

					cadena = "cuarenta y ocho";

					break;

				case 49:

					cadena = "cuarenta y nueve";

					break;

				case 50:

					cadena = "cincuenta";

					break;

				case 51:

					cadena = "cincuenta y uno";

					break;

				case 52:

					cadena = "cincuenta y dos";

					break;

				case 53:

					cadena = "cincuenta y tres";

					break;

				case 54:

					cadena = "cincuenta y cuatro";

					break;

				case 55:

					cadena = "cincuenta y cinco";

					break;

				case 56:

					cadena = "cincuenta y seis";

					break;

				case 57:

					cadena = "cincuenta y siete";

					break;

				case 58:

					cadena = "cincuenta y ocho";

					break;

				case 59:

					cadena = "cincuenta y nueve";

					break;

				case 60:

					cadena = "sesenta";

					break;

				case 61:

					cadena = "sesenta y uno";

					break;

				case 62:

					cadena = "sesenta y dos";

					break;

				case 63:

					cadena = "sesenta y tres";

					break;

				case 64:

					cadena = "sesenta y cuatro";

					break;

				case 65:

					cadena = "sesenta y cinco";

					break;

				case 66:

					cadena = "sesenta y seis";

					break;

				case 67:

					cadena = "sesenta y siete";

					break;

				case 68:

					cadena = "sesenta y ocho";

					break;

				case 69:

					cadena = "sesenta y nueve";

					break;

				case 70:

					cadena = "setenta";

					break;

				case 71:

					cadena = "setenta y uno";

					break;

				case 72:

					cadena = "setenta y dos";

					break;

				case 73:

					cadena = "setenta y tres";

					break;

				case 74:

					cadena = "setenta y cuatro";

					break;

				case 75:

					cadena = "setenta y cinco";

					break;

				case 76:

					cadena = "setenta y seis";

					break;

				case 77:

					cadena = "setenta y siete";

					break;

				case 78:

					cadena = "setenta y ocho";

					break;

				case 79:

					cadena = "setenta y nueve";

					break;

				case 80:

					cadena = "ochenta";

					break;

				case 81:

					cadena = "ochenta y uno";

					break;

				case 82:

					cadena = "ochenta y dos";

					break;

				case 83:

					cadena = "ochenta y tres";

					break;

				case 84:

					cadena = "ochenta y cuatro";

					break;

				case 85:

					cadena = "ochenta y cinco";

					break;

				case 86:

					cadena = "ochenta y seis";

					break;

				case 87:

					cadena = "ochenta y siete";

					break;

				case 88:

					cadena = "ochenta y ocho";

					break;

				case 89:

					cadena = "ochenta y nueve";

					break;

				case 90:

					cadena = "noventa";

					break;

				case 91:

					cadena = "noventa y uno";

					break;

				case 92:

					cadena = "noventa y dos";

					break;

				case 93:

					cadena = "noventa y tres";

					break;

				case 94:

					cadena = "noventa y cuatro";

					break;

				case 95:

					cadena = "noventa y cinco";

					break;

				case 96:

					cadena = "noventa y seis";

					break;

				case 97:

					cadena = "noventa y siete";

					break;

				case 98:

					cadena = "noventa y ocho";

					break;

				case 99:

					cadena = "noventa y nueve";

					break;

				}

			}

		}

		return cadena;

	}

	public String agregarPunto(String cantidad) {
		boolean punto = false;
		for (int i = 0; i < cantidad.length(); i++) {
			if (cantidad.charAt(i) == '.') {
				punto = true;
			}
		}
		if (punto == false) {
			cantidad = cantidad + ".00";
		}
		return cantidad;
	}

}
