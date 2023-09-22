package com.aaq.col.clases.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.DatosEmailPlantillas;
import com.aaq.col.clases.database.entidades.DatosEmailPlantillasB;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.path.ProveedorApplicationContextFormatos;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.web.spring.JMBeanSIICATimerOrdenPases;
import com.aaq.col.clases.webservices.ordenes.ReporteOrdenes;
import com.jcraft.jsch.ChannelSftp;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class GenerarOrdenPase {
	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@SuppressWarnings("unused")
	private DateFormat readFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private String respuestaEmail = "";
	private String respuestaSFTP = "";
	private int emailEnviado = 0;
	private int sftpEnviado = 0;
	private boolean PRODUCCION = true;
	private String direccion = "";
	private String direccionMail = "";
	private String direccionMailB = "";
	private Timestamp fechaEnvioMail;
	private Timestamp fechaEnvioSftp;
	private String pathArchivoVentauto = "";
	private String pathImgLiga = "";
	private String pathImgAjustador = "";

	// CORREOS B
	private int emailEnviadoB = 0;
	private String respuestaEmailB = "";
	private Timestamp fechaEnvioMailB;
	//
	private ConectarSFTP conectarSFTP = new ConectarSFTP();

	LibEMAIL libreriaEMAIL;
	LibEMAIL2 libreriaEMAIL2;

	private static final ConfiguracionServiceInterfase configuracionDao = Configuracion.getConfiguracionService();
	

	@SuppressWarnings("deprecation")
	public Map<String, Object> crearArchivoPaseOrden(String subtipoDocumento, InputStream fileJrxml,
			HashMap<String, Object> parametros, String numeroReporte, String numeroPoliza, String tipoAfectado,
			ArrayList<DatosEmailPlantillas> emails, int consecutivo, String correoOculto) {
		

		HashMap<String, Object> datosArchivos = null;
		fechaEnvioMail = null;
		fechaEnvioSftp = null;
		sftpEnviado = 0;
		String contenidoEmail = "";
		respuestaEmail = "NO ENVIADO";
		emailEnviado = 0;
		int abrirConexion = 0;

		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(fileJrxml);
			// fileJrxml.close();
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, new JREmptyDataSource());

			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);
			datosArchivos = nombrarArchivoPaseOrden(subtipoDocumento, numeroReporte, numeroPoliza, tipoAfectado, "", consecutivo, 1);

			datosArchivos.put("contenidoPDF", pdf);
			datosArchivos.put("tipoDocumento", subtipoDocumento);
			ByteArrayInputStream bis = new ByteArrayInputStream(pdf);
			String reposoPDF = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/pdf").getFile().getPath();

			FileOutputStream out1 = null;
			if (PRODUCCION == true) {
				try {
					direccion = reposoPDF + "\\" + datosArchivos.get("nombrePDF");
					if (direccion != null) {
						out1 = new FileOutputStream(reposoPDF + "\\" + datosArchivos.get("nombrePDF"));
						out1.write(pdf);
					}

				} catch (Exception e) {
					log.error("Formatos Error=> crearArchivoPaseOrden()=> Escribe PDF " + numeroReporte, e);
				} finally {
					out1.close();
				}

			}

			try {
				conectarSFTP.abrirConexion();
				abrirConexion = 1;
				conectarSFTP.ubicarRuta();
				abrirConexion = 2;
				ChannelSftp channelSftp = conectarSFTP.getChannelSftp();
				channelSftp.put(bis, datosArchivos.get("nombrePDF").toString());

				bis.close();
				esperarXsegundos(1);
				// conectarSFTP.salirChannel();
				// conectarSFTP.desconectarSession();
				// esperarXsegundos(1);
				String contenidoLista = armarContenidoArchivoLst(datosArchivos.get("nombrePDF").toString(),
						subtipoDocumento, tipoAfectado, numeroReporte, numeroPoliza);
				ByteArrayInputStream bisLst = new ByteArrayInputStream(contenidoLista.getBytes());
				String nombreLst = numeroReporte + "D" + obtenerFecha() + ".lst";

				// conectarSFTP.abrirConexion();
				// abrirConexion = 1;
				// conectarSFTP.ubicarRuta();
				// abrirConexion = 2;
				ChannelSftp channelLST = conectarSFTP.getChannelSftp();

				channelLST.put(bisLst, nombreLst);
				// esperarXsegundos(1);
				bisLst.close();
				conectarSFTP.salirChannel();
				conectarSFTP.desconectarSession();
				abrirConexion = 0;
				sftpEnviado = 1;
				respuestaSFTP = "ENVIO EXITOSO";
				Date fecha1 = new Date();
				fechaEnvioSftp = obtenerFechaI(
						((fecha1.getDate() + "").length() == 1 ? ("0" + fecha1.getDate()) : fecha1.getDate() + "") + "/"
								+ ((fecha1.getMonth() + "").length() == 1
										? ("0" + (fecha1.getMonth() + 1))
										: (fecha1.getMonth() + 1) + "")
								+ "/" + (fecha1.getYear() + 1900) + " "
								+ ((fecha1.getHours() + "").length() == 1 ? ("0" + fecha1.getHours())
										: fecha1.getHours() + "")
								+ ":"
								+ ((fecha1.getMinutes() + "").length() == 1 ? ("0" + (fecha1.getMinutes() + 1))
										: (fecha1.getMinutes() + 1) + "")
								+ ":" + ((fecha1.getSeconds() + "").length() == 1 ? ("0" + (fecha1.getSeconds() + 1))
										: (fecha1.getSeconds() + 1) + ""));
			} catch (Exception e) {
				log.error("Formatos Error=> crearArchivoPaseOrden()=> SFTP=> " + numeroReporte, e);
				sftpEnviado = 0;
				respuestaSFTP = "NO ENVIADO: " + e.getMessage();
				if (abrirConexion == 1) {
					conectarSFTP.desconectarSession();
				} else if (abrirConexion == 2) {
					conectarSFTP.salirChannel();
					conectarSFTP.desconectarSession();
				}

			}

			/////////////////////////////////////////////////////// E M A I L

			if (emails.size() == 0) {
				respuestaEmail = "- NO SE REGISTRO NINGUN EMAIL ";
				emailEnviado = 0;
			}

			if (GenerarOrdenPase.configuracionDao
					.obtenerBooleano(JMConstantes.CONFIGURACION_OP_FTP_ENVIO_EMAIL) == false) {
				respuestaEmail += "- EL SERVICIO DE EMAIL ESTA APAGADO ";
				emailEnviado = 0;
			}
			if (sftpEnviado == 1) {
				if (emails.size() != 0 && GenerarOrdenPase.configuracionDao
						.obtenerBooleano(JMConstantes.CONFIGURACION_OP_FTP_ENVIO_EMAIL) == true) {
					ArrayList<String> lstEmails = new ArrayList<String>();
					for (int i = 0; i < emails.size(); i++) {
						lstEmails.add(emails.get(i).getEmail_1());
					}

					try {
						contenidoEmail = GenerarOrdenPase.configuracionDao
								.obtenerCadena(JMConstantes.CONFIGURACION_OP_FTP_MENSAJE_EMAIL);
						libreriaEMAIL = new LibEMAIL(
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
								GenerarOrdenPase.configuracionDao
										.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
								GenerarOrdenPase.configuracionDao
										.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
								GenerarOrdenPase.configuracionDao
										.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
								GenerarOrdenPase.configuracionDao
										.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG),
								direccion);

						
						if (libreriaEMAIL.enviarEmail(lstEmails,
								"QUALITAS S.A. DE C.V. " + " REPORTE: " + emails.get(0).getReporte(), contenidoEmail,
								emails.get(0).getNombreDocumento(),correoOculto)) {

							Date fecha = new Date();
							fechaEnvioMail = obtenerFechaI(
									((fecha.getDate() + "").length() == 1 ? ("0" + fecha.getDate())
											: fecha.getDate() + "")
											+ "/"
											+ ((fecha.getMonth() + "").length() == 1 ? ("0" + (fecha.getMonth() + 1))
													: (fecha.getMonth() + 1) + "")
											+ "/" + (fecha.getYear() + 1900) + " "
											+ ((fecha.getHours() + "").length() == 1 ? ("0" + fecha.getHours())
													: fecha.getHours() + "")
											+ ":"
											+ ((fecha.getMinutes() + "").length() == 1
													? ("0" + (fecha.getMinutes() + 1))
													: (fecha.getMinutes() + 1) + "")
											+ ":"
											+ ((fecha.getSeconds() + "").length() == 1
													? ("0" + (fecha.getSeconds() + 1))
													: (fecha.getSeconds() + 1) + ""));

							respuestaEmail = "MENSAJE ENVIADO";
							emailEnviado = 1;

						} else {

							respuestaEmail = "NO ENVIADO: " + libreriaEMAIL.error;
							emailEnviado = 0;
							log.error("Formatos Error=> crearArchivoPaseOrden)=> Email false=>" + numeroReporte
									+ "=> Error: " + libreriaEMAIL.error);

						}

					} catch (Exception e) {
						respuestaEmail = "NO ENVIADO: ( " + e.getMessage() + " )";
						emailEnviado = 0;
						log.error("Formatos Error=> crearArchivoPaseOrden()=> Email=> " + numeroReporte, e);

					}

				}
			} // if de si se envio bien el lst

			if (PRODUCCION == true) {
				File fichero = new File(direccion);
				fichero.delete();
			}
		} catch (Exception eg) {
			log.error("Formatos Error=> crearArchivoPaseOrden()=> " + numeroReporte, eg);
			return datosArchivos;
		}
		return datosArchivos;
	}

	// orden pases dua nuevo

	@SuppressWarnings({ "deprecation", "unused" })
	public Map<String, Object> crearArchivoPaseOrdenDua(String subtipoDocumento, InputStream fileJrxmlContent,
			InputStream fileJrxmlMail, HashMap<String, Object> parametrosMail, InputStream fileJrxmlMailB,
			HashMap<String, Object> parametrosMailB, HashMap<String, Object> parametrosContent, String numeroReporte,
			String numeroPoliza, String tipoAfectado, ArrayList<DatosEmailPlantillas> emails,
			ArrayList<DatosEmailPlantillasB> emailsB, boolean enviarVentaAuto, int consecutivoBase,
			String correoOculto) {

		HashMap<String, Object> datosArchivos = null;
		fechaEnvioMail = null;
		fechaEnvioSftp = null;
		sftpEnviado = 0;
		String contenidoEmail = "";
		respuestaEmail = "NO ENVIADO";
		emailEnviado = 0;
		int abrirConexion = 0;
		// CORREO B DUA
		fechaEnvioMailB = null;
		respuestaEmailB = "NO ENVIADO";
		emailEnviadoB = 0;
		//

		try {
			// content
			JasperReport jasperReportContent = JasperCompileManager.compileReport(fileJrxmlContent);
			// fileJrxmlContent.close();
			JasperPrint jasperPrintContent = JasperFillManager.fillReport(jasperReportContent, parametrosContent,
					new JREmptyDataSource());

			datosArchivos = nombrarArchivoPaseOrden(subtipoDocumento, numeroReporte, numeroPoliza, tipoAfectado, "",
					consecutivoBase, 1);

			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrintContent);

			datosArchivos.put("contenidoPDF", pdf);
			datosArchivos.put("tipoDocumento", subtipoDocumento);
			ByteArrayInputStream bis = new ByteArrayInputStream(pdf);

			/// mail A
			JasperReport jasperReportMail = JasperCompileManager.compileReport(fileJrxmlMail);
			// fileJrxmlMail.close();
			JasperPrint jasperPrintMail = JasperFillManager.fillReport(jasperReportMail, parametrosMail,
					new JREmptyDataSource());

			HashMap<String, Object> datosArchivosMail = nombrarArchivoPaseOrden(subtipoDocumento, numeroReporte,
					numeroPoliza, tipoAfectado, "_A", consecutivoBase, 1);

			byte[] pdfMail = JasperExportManager.exportReportToPdf(jasperPrintMail);

			datosArchivosMail.put("contenidoPDF", pdfMail);
			datosArchivosMail.put("tipoDocumento", subtipoDocumento);
			ByteArrayInputStream bisMail = new ByteArrayInputStream(pdfMail);

			// MAIL B
			JasperReport jasperReportMailB = JasperCompileManager.compileReport(fileJrxmlMailB);
			// fileJrxmlMailB.close();
			JasperPrint jasperPrintMailB = JasperFillManager.fillReport(jasperReportMailB, parametrosMailB,
					new JREmptyDataSource());

			HashMap<String, Object> datosArchivosMailB = nombrarArchivoPaseOrden(subtipoDocumento, numeroReporte,
					numeroPoliza, tipoAfectado, "_B", consecutivoBase, 1);

			byte[] pdfMailB = JasperExportManager.exportReportToPdf(jasperPrintMailB);

			datosArchivosMailB.put("contenidoPDF", pdfMailB);
			datosArchivosMailB.put("tipoDocumento", subtipoDocumento);
			ByteArrayInputStream bisMailB = new ByteArrayInputStream(pdfMailB);

			String reposoPDFMail = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/pdf").getFile().getPath();
			String reposoPDFMailB = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/pdf").getFile().getPath();
			String reposoPDFContent = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/pdf").getFile().getPath();
			pathArchivoVentauto = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/pdf/VENTAUTO.pdf").getFile().getPath();
			pathImgLiga = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/link.jpeg").getFile().getPath();
			pathImgAjustador = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/img/superAjustador.png").getFile().getPath();

			FileOutputStream out1 = null;
			if (PRODUCCION == true) {
				try {
					direccion = reposoPDFContent + "\\" + datosArchivos.get("nombrePDF");
					if (direccion != null) {
						out1 = new FileOutputStream(reposoPDFContent + "\\" + datosArchivos.get("nombrePDF"));
						out1.write(pdf);
					}

				} catch (Exception e) {
					log.error("Formatos Error=> crearArchivoPaseOrdenDUA()=> Escribe PDF" + numeroReporte, e);
				} finally {
					out1.close();
				}

				FileOutputStream out2 = null;
				try {
					direccionMail = reposoPDFMail + "\\" + datosArchivosMail.get("nombrePDF");

					if (direccionMail != null) {
						out2 = new FileOutputStream(reposoPDFMail + "\\" + datosArchivosMail.get("nombrePDF"));
						out2.write(pdfMail);
					}

				} catch (Exception e) {
					log.error("Formatos Error=> crearArchivoPaseOrdenDUA()=> Escribe PDF A" + numeroReporte, e);
				} finally {
					out2.close();
				}

				FileOutputStream out3 = null;
				try {
					direccionMailB = reposoPDFMailB + "\\" + datosArchivosMailB.get("nombrePDF");
					if (direccionMailB != null) {
						out3 = new FileOutputStream(reposoPDFMailB + "\\" + datosArchivosMailB.get("nombrePDF"));
						out3.write(pdfMailB);
					}

				} catch (Exception e) {
					log.error("Formatos Error=> crearArchivoPaseOrdenDUA()=> Escribe PDF B" + numeroReporte, e);
				} finally {
					out3.close();
				}

			}

			try {
				conectarSFTP.abrirConexion();
				abrirConexion = 1;
				conectarSFTP.ubicarRuta();
				abrirConexion = 2;
				ChannelSftp channelSftpDUA = conectarSFTP.getChannelSftp();
				channelSftpDUA.put(bis, datosArchivos.get("nombrePDF").toString());

				bis.close();
				esperarXsegundos(1);
				// conectarSFTP.salirChannel();
				// conectarSFTP.desconectarSession();

				String contenidoLista = armarContenidoArchivoLst(datosArchivos.get("nombrePDF").toString(),
						subtipoDocumento, tipoAfectado, numeroReporte, numeroPoliza);
				ByteArrayInputStream bisLst = new ByteArrayInputStream(contenidoLista.getBytes());
				String nombreLst = numeroReporte + "D" + obtenerFecha() + ".lst";

				// conectarSFTP.abrirConexion();
				// abrirConexion = 1;
				// conectarSFTP.ubicarRuta();
				// abrirConexion = 2;

				ChannelSftp channelLST = conectarSFTP.getChannelSftp();
				channelLST.put(bisLst, nombreLst);
				bisLst.close();
				conectarSFTP.salirChannel();
				conectarSFTP.desconectarSession();
				abrirConexion = 0;
				sftpEnviado = 1;
				respuestaSFTP = "ENVIO EXITOSO";

				Date fecha1 = new Date();
				fechaEnvioSftp = obtenerFechaI(
						((fecha1.getDate() + "").length() == 1 ? ("0" + fecha1.getDate()) : fecha1.getDate() + "") + "/"
								+ ((fecha1.getMonth() + "").length() == 1
										? ("0" + (fecha1.getMonth() + 1))
										: (fecha1.getMonth() + 1) + "")
								+ "/" + (fecha1.getYear() + 1900) + " "
								+ ((fecha1.getHours() + "").length() == 1 ? ("0" + fecha1.getHours())
										: fecha1.getHours() + "")
								+ ":"
								+ ((fecha1.getMinutes() + "").length() == 1 ? ("0" + (fecha1.getMinutes() + 1))
										: (fecha1.getMinutes() + 1) + "")
								+ ":" + ((fecha1.getSeconds() + "").length() == 1 ? ("0" + (fecha1.getSeconds() + 1))
										: (fecha1.getSeconds() + 1) + ""));

			} catch (Exception e) {
				log.error("Formatos Error=> crearArchivoPaseOrdenDUA()=> SFTP=>" + numeroReporte, e);
				sftpEnviado = 0;
				respuestaSFTP = "NO ENVIADO: " + e.getMessage();
				if (abrirConexion == 1) {
					conectarSFTP.desconectarSession();
				} else if (abrirConexion == 2) {
					conectarSFTP.salirChannel();
					conectarSFTP.desconectarSession();
				}

			}

			/************** ENVIO A SERVIDOR SFTP DUA DEL ASEGURADO **************/
			try {
			 if (StringUtils.isNotBlank(tipoAfectado) && StringUtils.equalsIgnoreCase(tipoAfectado, "1")) {
				HashMap<String, Object> datosArchivosAseg = null;
				datosArchivosAseg = nombrarArchivoPaseOrden(subtipoDocumento, numeroReporte, numeroPoliza, tipoAfectado, "",
						consecutivoBase,2);
				log.info("INICIA ENVIO AL SFTP PDF ASEGURADO");
				conectarSFTP.abrirConexion();
				abrirConexion = 1;
				conectarSFTP.ubicarRuta();
				abrirConexion = 2;
				try {
				ChannelSftp channelSftpDUAMail = conectarSFTP.getChannelSftp();
				channelSftpDUAMail.put(bisMail, datosArchivosAseg.get("nombrePDF").toString());
				} catch (Exception e) {
					log.error("Formatos Error=> crearArchivoPaseOrdenDUA()=> SFTP Asegurado=>" + numeroReporte, e);
				}
				
				bisMail.close();
				esperarXsegundos(1);
				String contenidoLista = armarContenidoArchivoLst(datosArchivosAseg.get("nombrePDF").toString(),
						subtipoDocumento, tipoAfectado, numeroReporte, numeroPoliza);
				ByteArrayInputStream bisLstMail = new ByteArrayInputStream(contenidoLista.getBytes());
				String nombreLstMail = numeroReporte + "D" + obtenerFecha() + ".lst";

				ChannelSftp channelLSTMail = conectarSFTP.getChannelSftp();
				channelLSTMail.put(bisLstMail, nombreLstMail);
				bisLstMail.close();
				conectarSFTP.salirChannel();
				conectarSFTP.desconectarSession();
				abrirConexion = 0;
				log.info("TERMINA ENVIO AL SFTP PDF COMPLETO");
			 }
			} catch (Exception e) {
				log.error("Formatos Error=> crearArchivoPaseOrdenDUA()=> SFTP=>" + numeroReporte, e);
					conectarSFTP.salirChannel();
					conectarSFTP.desconectarSession();

			}

			/////////////////////////////////////////////////////// E M A I L

			respuestaEmail = "";
			emailEnviado = 0;
			respuestaEmailB = "";
			emailEnviadoB = 0;

			if (emails.size() == 0) {
				respuestaEmail = "- NO SE REGISTRO NINGUN EMAIL ";
				emailEnviado = 0;
			}
			if (emailsB.size() == 0) {
				respuestaEmailB = "- NO SE REGISTRO NINGUN EMAIL ";
				emailEnviadoB = 0;
			}
			if (GenerarOrdenPase.configuracionDao
					.obtenerBooleano(JMConstantes.CONFIGURACION_OP_FTP_ENVIO_EMAIL) == false) {
				respuestaEmail += "- EL SERVICIO DE EMAIL ESTA APAGADO ";
				emailEnviado = 0;
				respuestaEmailB += "- EL SERVICIO DE EMAIL ESTA APAGADO ";
				emailEnviadoB = 0;

			}

			if (sftpEnviado == 1) {
				// GENERICO Y A
				if (emails.size() != 0 && GenerarOrdenPase.configuracionDao
						.obtenerBooleano(JMConstantes.CONFIGURACION_OP_FTP_ENVIO_EMAIL) == true) {
					ArrayList<String> lstEmails = new ArrayList<String>();
					for (int i = 0; i < emails.size(); i++) {
						lstEmails.add(emails.get(i).getEmail_1());
					}
					try {

						if (consecutivoBase == 1) {
							contenidoEmail = GenerarOrdenPase.configuracionDao
									.obtenerCadena(JMConstantes.CONFIGURACION_OP_FTP_MENSAJE_EMAIL);

							libreriaEMAIL2 = new LibEMAIL2(
									GenerarOrdenPase.configuracionDao
											.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
									GenerarOrdenPase.configuracionDao
											.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
									GenerarOrdenPase.configuracionDao
											.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
									GenerarOrdenPase.configuracionDao
											.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
									GenerarOrdenPase.configuracionDao
											.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
									GenerarOrdenPase.configuracionDao
											.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
									GenerarOrdenPase.configuracionDao
											.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
									GenerarOrdenPase.configuracionDao
											.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG),
									direccionMail, pathArchivoVentauto, enviarVentaAuto, pathImgLiga,pathImgAjustador);

							if (libreriaEMAIL2.enviarEmail(lstEmails,
									"QUALITAS S.A. DE C.V. " + " REPORTE: " + emails.get(0).getReporte(),
									contenidoEmail, emails.get(0).getNombreDocumento(),correoOculto)) {

								Date fecha = new Date();
								fechaEnvioMail = obtenerFechaI(
										((fecha.getDate() + "").length() == 1 ? ("0" + fecha.getDate())
												: fecha.getDate() + "")
												+ "/"
												+ ((fecha.getMonth() + "").length() == 1
														? ("0" + (fecha.getMonth() + 1))
														: (fecha.getMonth() + 1) + "")
												+ "/" + (fecha.getYear() + 1900) + " "
												+ ((fecha.getHours() + "").length() == 1 ? ("0" + fecha.getHours())
														: fecha.getHours() + "")
												+ ":"
												+ ((fecha.getMinutes() + "").length() == 1
														? ("0" + (fecha.getMinutes() + 1))
														: (fecha.getMinutes() + 1) + "")
												+ ":"
												+ ((fecha.getSeconds() + "").length() == 1
														? ("0" + (fecha.getSeconds() + 1))
														: (fecha.getSeconds() + 1) + ""));

								respuestaEmail = "MENSAJE ENVIADO";
								emailEnviado = 1;

							} else {
								respuestaEmail = "NO ENVIADO: " + libreriaEMAIL2.error;
								emailEnviado = 0;
								log.error("Formatos Error=> crearArchivoPaseOrdenDUA()=> Email A false=> "
										+ numeroReporte + "Error: " + libreriaEMAIL2.error);
							}
							// de lo contrario de consecutivo sea diferente de 1
						} else {
							Date fecha = new Date();
							fechaEnvioMail = obtenerFechaI(
									((fecha.getDate() + "").length() == 1 ? ("0" + fecha.getDate())
											: fecha.getDate() + "")
											+ "/"
											+ ((fecha.getMonth() + "").length() == 1 ? ("0" + (fecha.getMonth() + 1))
													: (fecha.getMonth() + 1) + "")
											+ "/" + (fecha.getYear() + 1900) + " "
											+ ((fecha.getHours() + "").length() == 1 ? ("0" + fecha.getHours())
													: fecha.getHours() + "")
											+ ":"
											+ ((fecha.getMinutes() + "").length() == 1
													? ("0" + (fecha.getMinutes() + 1))
													: (fecha.getMinutes() + 1) + "")
											+ ":"
											+ ((fecha.getSeconds() + "").length() == 1
													? ("0" + (fecha.getSeconds() + 1))
													: (fecha.getSeconds() + 1) + ""));

							respuestaEmail = "MENSAJE ENVIADO";
							emailEnviado = 1;
						}

					} catch (Exception e) {
						respuestaEmail = "NO ENVIADO -->( " + e.getMessage() + " )<--";
						emailEnviado = 0;
						log.error("Formatos Error=> crearArchivoPaseOrdenDUA()=> Email A=>" + numeroReporte, e);
					}

				}

				////////// CORREO A ASEGURADO EN B

				if (emailsB.size() != 0 && GenerarOrdenPase.configuracionDao
						.obtenerBooleano(JMConstantes.CONFIGURACION_OP_FTP_ENVIO_EMAIL) == true) {
					ArrayList<String> lstEmails = new ArrayList<String>();
					for (int i = 0; i < emailsB.size(); i++) {
						lstEmails.add(emailsB.get(i).getEmail_1());
					}

					try {
						contenidoEmail = GenerarOrdenPase.configuracionDao
								.obtenerCadena(JMConstantes.CONFIGURACION_OP_FTP_MENSAJE_EMAIL);

						////////////// AQUI SE ARMA Y ENVIA EL EMAIL

						libreriaEMAIL = new LibEMAIL(
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
								GenerarOrdenPase.configuracionDao
										.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
								GenerarOrdenPase.configuracionDao
										.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
								GenerarOrdenPase.configuracionDao
										.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
								GenerarOrdenPase.configuracionDao
										.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG),
								direccionMailB);

						if (libreriaEMAIL.enviarEmail(lstEmails,
								"QUALITAS S.A. DE C.V. " + " REPORTE: " + emailsB.get(0).getReporte(), contenidoEmail,
								emailsB.get(0).getNombreDocumento(),correoOculto)) {

							Date fecha = new Date();
							fechaEnvioMailB = obtenerFechaI(
									((fecha.getDate() + "").length() == 1 ? ("0" + fecha.getDate())
											: fecha.getDate() + "")
											+ "/"
											+ ((fecha.getMonth() + "").length() == 1 ? ("0" + (fecha.getMonth() + 1))
													: (fecha.getMonth() + 1) + "")
											+ "/" + (fecha.getYear() + 1900) + " "
											+ ((fecha.getHours() + "").length() == 1 ? ("0" + fecha.getHours())
													: fecha.getHours() + "")
											+ ":"
											+ ((fecha.getMinutes() + "").length() == 1
													? ("0" + (fecha.getMinutes() + 1))
													: (fecha.getMinutes() + 1) + "")
											+ ":"
											+ ((fecha.getSeconds() + "").length() == 1
													? ("0" + (fecha.getSeconds() + 1))
													: (fecha.getSeconds() + 1) + ""));

							respuestaEmailB = "MENSAJE ENVIADO";
							emailEnviadoB = 1;

						} else {
							respuestaEmailB = "NO ENVIADO: " + libreriaEMAIL.error;
							emailEnviadoB = 0;
							log.error(
									"Formatos Error=> crearArchivoPaseOrdenDUA()=> Email B false=> numeroReporte => Error: "
											+ libreriaEMAIL.error);
						}

					} catch (Exception e) {
						respuestaEmailB = "NO ENVIADO -->( " + e.getMessage() + " )<--";
						emailEnviadoB = 0;
						log.error("Formatos Error=> crearArchivoPaseOrdenDUA()=> Email B=>" + numeroReporte, e);
					}

				}
			} // if de si se envio bien el lstsi se envio bien LST

			if (PRODUCCION == true) {

				File fichero = new File(direccion);
				fichero.delete();

				File fichero1 = new File(direccionMail);
				fichero1.delete();

				File fichero2 = new File(direccionMailB);
				fichero2.delete();
			}
		} catch (Exception eg) {
			log.error("Formatos Error=> crearArchivoPaseOrdenDUA()=> " + numeroReporte, eg);
			return datosArchivos;
		}
		return datosArchivos;
	}

	

	// orden pases RESPONSABILIDAD CIVIL
	@SuppressWarnings({ "deprecation", "unused" })
	public Map<String, Object> crearArchivoPaseOrdenRC(String subtipoDocumento, InputStream fileJrxmlContent,
			HashMap<String, Object> parametrosContent, InputStream fileJrxmlMail,
			HashMap<String, Object> parametrosMail, String numeroReporte, String numeroPoliza, String tipoAfectado,
			ArrayList<DatosEmailPlantillas> emails, int consecutivo, String correoOculto) {

		HashMap<String, Object> datosArchivos = null;
		fechaEnvioMail = null;
		fechaEnvioSftp = null;
		sftpEnviado = 0;
		String contenidoEmail = "";
		respuestaEmail = "NO ENVIADO";
		emailEnviado = 0;
		int abrirConexion = 0;
		// CORREO B DUA
		fechaEnvioMailB = null;
		respuestaEmailB = "NO ENVIADO";
		emailEnviadoB = 0;
		//

		try {
			// content
			JasperReport jasperReportContent = JasperCompileManager.compileReport(fileJrxmlContent);
			JasperPrint jasperPrintContent = JasperFillManager.fillReport(jasperReportContent, parametrosContent,
					new JREmptyDataSource());
			datosArchivos = nombrarArchivoPaseOrden(subtipoDocumento, numeroReporte, numeroPoliza, tipoAfectado, "", consecutivo, 1);
			byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrintContent);
			datosArchivos.put("contenidoPDF", pdf);
			datosArchivos.put("tipoDocumento", subtipoDocumento);
			ByteArrayInputStream bis = new ByteArrayInputStream(pdf);

			/// mail A
			JasperReport jasperReportMail = JasperCompileManager.compileReport(fileJrxmlMail);
			JasperPrint jasperPrintMail = JasperFillManager.fillReport(jasperReportMail, parametrosMail,
					new JREmptyDataSource());
			HashMap<String, Object> datosArchivosMail = nombrarArchivoPaseOrden(subtipoDocumento, numeroReporte,
					numeroPoliza, tipoAfectado, "_A", consecutivo, 1);
			byte[] pdfMail = JasperExportManager.exportReportToPdf(jasperPrintMail);
			datosArchivosMail.put("contenidoPDF", pdfMail);
			datosArchivosMail.put("tipoDocumento", subtipoDocumento);
			ByteArrayInputStream bisMail = new ByteArrayInputStream(pdfMail);

			String reposoPDFMail = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/pdf").getFile().getPath();

			String reposoPDFContent = ProveedorApplicationContextFormatos.getApplicationContext()
					.getResource("/OrdenesPases/pdf").getFile().getPath();

			FileOutputStream out1 = null;
			if (PRODUCCION == true) {
				try {
					direccion = reposoPDFContent + "\\" + datosArchivos.get("nombrePDF");
					if (direccion != null) {
						out1 = new FileOutputStream(reposoPDFContent + "\\" + datosArchivos.get("nombrePDF"));
						out1.write(pdf);
					}

				} catch (Exception e) {
					log.error("Formatos Error=> crearArchivoPaseOrdenRC()=> Escribe PDF" + numeroReporte, e);
				} finally {
					out1.close();
				}

				FileOutputStream out2 = null;
				try {
					direccionMail = reposoPDFMail + "\\" + datosArchivosMail.get("nombrePDF");
					if (direccionMail != null) {
						out2 = new FileOutputStream(reposoPDFMail + "\\" + datosArchivosMail.get("nombrePDF"));
						out2.write(pdfMail);
					}

				} catch (Exception e) {
					log.error("Formatos Error=> crearArchivoPaseOrdenRC()=> Escribe PDF A" + numeroReporte, e);
				} finally {
					out2.close();
				}
			}

			try {
				conectarSFTP.abrirConexion();
				abrirConexion = 1;
				conectarSFTP.ubicarRuta();
				abrirConexion = 2;
				ChannelSftp channelSftp = conectarSFTP.getChannelSftp();
				channelSftp.put(bis, datosArchivos.get("nombrePDF").toString());

				bis.close();
				esperarXsegundos(1);

				String contenidoLista = armarContenidoArchivoLst(datosArchivos.get("nombrePDF").toString(),
						subtipoDocumento, tipoAfectado, numeroReporte, numeroPoliza);
				ByteArrayInputStream bisLst = new ByteArrayInputStream(contenidoLista.getBytes());
				String nombreLst = numeroReporte + "D" + obtenerFecha() + ".lst";

				ChannelSftp channelLST = conectarSFTP.getChannelSftp();
				channelLST.put(bisLst, nombreLst);
				bisLst.close();
				conectarSFTP.salirChannel();
				conectarSFTP.desconectarSession();
				abrirConexion = 0;
				sftpEnviado = 1;
				respuestaSFTP = "ENVIO EXITOSO";

				Date fecha1 = new Date();
				fechaEnvioSftp = obtenerFechaI(
						((fecha1.getDate() + "").length() == 1 ? ("0" + fecha1.getDate()) : fecha1.getDate() + "") + "/"
								+ ((fecha1.getMonth() + "").length() == 1
										? ("0" + (fecha1.getMonth() + 1))
										: (fecha1.getMonth() + 1) + "")
								+ "/" + (fecha1.getYear() + 1900) + " "
								+ ((fecha1.getHours() + "").length() == 1 ? ("0" + fecha1.getHours())
										: fecha1.getHours() + "")
								+ ":"
								+ ((fecha1.getMinutes() + "").length() == 1 ? ("0" + (fecha1.getMinutes() + 1))
										: (fecha1.getMinutes() + 1) + "")
								+ ":" + ((fecha1.getSeconds() + "").length() == 1 ? ("0" + (fecha1.getSeconds() + 1))
										: (fecha1.getSeconds() + 1) + ""));

			} catch (Exception e) {
				log.error("Formatos Error=> crearArchivoPaseOrdenRC()=> SFTP=>" + numeroReporte, e);
				sftpEnviado = 0;
				respuestaSFTP = "NO ENVIADO: " + e.getMessage();
				if (abrirConexion == 1) {
					conectarSFTP.desconectarSession();
				} else if (abrirConexion == 2) {
					conectarSFTP.salirChannel();
					conectarSFTP.desconectarSession();
				}

			}

			/////////////////////////////////////////////////////// E M A I L

			respuestaEmail = "";
			emailEnviado = 0;

			if (emails.size() == 0) {
				respuestaEmail = "- NO SE REGISTRO NINGUN EMAIL ";
				emailEnviado = 0;
			}

			if (GenerarOrdenPase.configuracionDao
					.obtenerBooleano(JMConstantes.CONFIGURACION_OP_FTP_ENVIO_EMAIL) == false) {
				respuestaEmail += "- EL SERVICIO DE EMAIL ESTA APAGADO ";
				emailEnviado = 0;
				respuestaEmailB += "- EL SERVICIO DE EMAIL ESTA APAGADO ";
				emailEnviadoB = 0;

			}

			if (sftpEnviado == 1) {
				// GENERICO Y A
				if (emails.size() != 0 && GenerarOrdenPase.configuracionDao
						.obtenerBooleano(JMConstantes.CONFIGURACION_OP_FTP_ENVIO_EMAIL) == true) {
					ArrayList<String> lstEmails = new ArrayList<String>();
					for (int i = 0; i < emails.size(); i++) {
						lstEmails.add(emails.get(i).getEmail_1());
					}
					try {
						contenidoEmail = GenerarOrdenPase.configuracionDao
								.obtenerCadena(JMConstantes.CONFIGURACION_OP_FTP_MENSAJE_EMAIL);

						libreriaEMAIL = new LibEMAIL(
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
								GenerarOrdenPase.configuracionDao
										.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
								GenerarOrdenPase.configuracionDao
										.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
								GenerarOrdenPase.configuracionDao
										.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
								GenerarOrdenPase.configuracionDao
										.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
								GenerarOrdenPase.configuracionDao
										.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG),
								direccionMail);

						if (libreriaEMAIL.enviarEmail(lstEmails,
								"QUALITAS S.A. DE C.V. " + " REPORTE: " + emails.get(0).getReporte(), contenidoEmail,
								emails.get(0).getNombreDocumento(), correoOculto)) {

							Date fecha = new Date();
							fechaEnvioMail = obtenerFechaI(
									((fecha.getDate() + "").length() == 1 ? ("0" + fecha.getDate())
											: fecha.getDate() + "")
											+ "/"
											+ ((fecha.getMonth() + "").length() == 1 ? ("0" + (fecha.getMonth() + 1))
													: (fecha.getMonth() + 1) + "")
											+ "/" + (fecha.getYear() + 1900) + " "
											+ ((fecha.getHours() + "").length() == 1 ? ("0" + fecha.getHours())
													: fecha.getHours() + "")
											+ ":"
											+ ((fecha.getMinutes() + "").length() == 1
													? ("0" + (fecha.getMinutes() + 1))
													: (fecha.getMinutes() + 1) + "")
											+ ":"
											+ ((fecha.getSeconds() + "").length() == 1
													? ("0" + (fecha.getSeconds() + 1))
													: (fecha.getSeconds() + 1) + ""));

							respuestaEmail = "MENSAJE ENVIADO";
							emailEnviado = 1;

						} else {
							respuestaEmail = "NO ENVIADO: " + libreriaEMAIL.error;
							emailEnviado = 0;
							log.error("Formatos Error=> crearArchivoPaseOrdenRC()=> Email A false=> " + numeroReporte
									+ "Error: " + libreriaEMAIL.error);
						}

					} catch (Exception e) {
						respuestaEmail = "NO ENVIADO -->( " + e.getMessage() + " )<--";
						emailEnviado = 0;
						log.error("Formatos Error=> crearArchivoPaseOrdenRC()=> Email A=>" + numeroReporte, e);
					}

				}
			} // if de si se envio bien el lstsi se envio bien LST

			if (PRODUCCION == true) {

				File fichero = new File(direccion);
				fichero.delete();

				File fichero1 = new File(direccionMail);
				fichero1.delete();

			}
		} catch (Exception eg) {
			log.error("Formatos Error=> crearArchivoPaseOrdenRC()=> " + numeroReporte, eg);
			return datosArchivos;
		}
		return datosArchivos;
	}


	@SuppressWarnings("unused")
	private HashMap<String, Object> nombrarArchivoPaseOrden(String subtipoDocumento, String numeroReporte,
			String numeroPoliza, String tipoAfectado, String numDocumento, int consecutivoBase, int asegurado) {

		// Nombre de archivo jpg
		String nombreArchivo = "";
		String separador = "_";
		String extensionArchivo = ".pdf";
		String subtipoTemp = "";

		// Contenido archivo lst
		String contenidoLst = "";

		// Variable general de salida
		HashMap<String, Object> hashArchivo = new HashMap<String, Object>();

		/// AQUI SE MODIFICARA PARA EL TIPO DE DOCUMENTO

		String tipoDoc = "N-A";
		subtipoTemp = subtipoDocumento;

		if (subtipoDocumento.equals("LE29")) {
			tipoDoc = "QSCT";
		} else if (subtipoDocumento.equals("QS25") || subtipoDocumento.equals("RO01") || subtipoDocumento.equals("QS60")
				|| subtipoDocumento.equals("QS03") || subtipoDocumento.equals("QS19")
				|| subtipoDocumento.equals("QS65")) {
			tipoDoc = "QSFR";
		} else if (subtipoDocumento.equals("QSD1")) {
			tipoDoc = "QSIN";
		} else if (subtipoDocumento.equals("GN08")) {
			tipoDoc = "QSCV";
		} else if (subtipoDocumento.equals("QS07") || subtipoDocumento.equals("QS21")) {
			tipoDoc = "QSCM";
		} else if (subtipoDocumento.equals("QS08") || subtipoDocumento.equals("QS63") || subtipoDocumento.equals("QS08")
				|| subtipoDocumento.equals("QS62") || subtipoDocumento.equals("QS53")
				|| subtipoDocumento.equals("QS65")) {
			tipoDoc = "QSOR";
		}

		if (subtipoDocumento.equals("PESADO")) {

			subtipoTemp = subtipoDocumento;
			subtipoDocumento = "QS08";

		}

		String val = String.valueOf(consecutivoBase);
		String consecutivo = StringUtils.leftPad(val, 10, "0");

		nombreArchivo = validarCadena(subtipoDocumento) + separador + separador + separador
				+ validarCadena(numeroReporte) + separador + validarCadena(consecutivo) + separador + separador
				+ tipoAfectado + separador + "1_"+asegurado + numDocumento + extensionArchivo;

		contenidoLst = armarContenidoArchivoLst(nombreArchivo, subtipoDocumento, tipoAfectado, numeroReporte,
				numeroPoliza);

		hashArchivo.put("nombrePDF", nombreArchivo);
		hashArchivo.put("contenidoLst", contenidoLst);

		return hashArchivo;
	}

	@SuppressWarnings("unused")
	private String armarContenidoArchivoLst(String nombreArchivo, String subtipodocumento, String tiposAfectado,
			String numeroReporte, String numeroPoliza) {
		String contenido = "";
		String separadorContenido = "|";
		String cadenaRuta = "";

		try {
			String cadenaDestino = configuracionDao
					.obtenerCadena("configuracion.siica.sistema.orden.pases.usuario.ftp.ruta");
			contenido = cadenaDestino + nombreArchivo + separadorContenido + subtipodocumento + separadorContenido
					+ separadorContenido + separadorContenido + validarCadena(numeroReporte) + separadorContenido
					+ validarCadena(numeroPoliza) + "||" + tiposAfectado;

		} catch (Exception ex) {
			log.error("Formatos Error=> armarContenidoArchivoLst() " + nombreArchivo + " =>" + subtipodocumento + " =>"
					+ tiposAfectado + " =>" + numeroReporte + " =>" + numeroPoliza, ex);
		}
		return contenido;
	}

	private String obtenerFecha() {
		DateFormat date = new SimpleDateFormat("yyyMMdd");
		DateFormat time = new SimpleDateFormat("HHmmss");
		Date currentDate = new Date();

		String fecha = date.format(currentDate) + time.format(currentDate);

		return fecha;
	}

	private Timestamp obtenerFechaI(String str_date) {

		try {
			DateFormat writeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = (Date) writeFormat.parse(str_date);
			java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

			return timeStampDate;
		} catch (ParseException e) {

			return null;
		}
	}

//	@SuppressWarnings(value = { "all" })
//	public void enviarArchivosPaseOrden(List<ReporteOrdenes> reporteOrdenes) {
//		Map<String, List<ReporteOrdenes>> mapReporteOrdenes = new HashMap<String, List<ReporteOrdenes>>();
//		List<ReporteOrdenes> r = new ArrayList<ReporteOrdenes>();
//		Set<String> duplicados = obtenerDuplicados(reporteOrdenes);
//
//		for (ReporteOrdenes objReporteOrden : reporteOrdenes) {
//			for (String string : duplicados) {
//				if (mapReporteOrdenes.containsKey(string) && (objReporteOrden.getNumeroReporte().equals(string))) {
//					r = mapReporteOrdenes.get(objReporteOrden.getNumeroReporte());
//					r.add(objReporteOrden);
//
//					mapReporteOrdenes.put(objReporteOrden.getNumeroReporte(), r);
//				} else {
//					if (!mapReporteOrdenes.containsKey(objReporteOrden)) {
//						r = new ArrayList<ReporteOrdenes>();
//						r.add(objReporteOrden);
//						mapReporteOrdenes.put(objReporteOrden.getNumeroReporte(), r);
//					}
//				}
//			}
//		}
//
//		Set entrySet = mapReporteOrdenes.entrySet();
//		Iterator<ReporteOrdenes> iterator = entrySet.iterator();
//
//		while (iterator.hasNext()) {
//			Map.Entry<String, List<ReporteOrdenes>> mapEntry = (Entry<String, List<ReporteOrdenes>>) iterator.next();
//			List<ReporteOrdenes> tmpReportes = mapEntry.getValue();
//			String contenidoLst = "";
//			for (ReporteOrdenes currentReport : tmpReportes) {
//				String numeroPoliza = "";
//
//				switch (currentReport.getTipoServicio()) {
//				/*
//				 * case JMBeanSIICATimerOrdenPases.PASE_MEDICO: OrdenPaseMedico servicioMedico =
//				 * (OrdenPaseMedico) currentReport.getServicio(); numeroPoliza =
//				 * servicioMedico.getReporteNumeroPoliza(); break;
//				 * 
//				 * case JMBeanSIICATimerOrdenPases.ORDEN_ADMISION: OrdenPaseAdmision
//				 * servicioAdmision = (OrdenPaseAdmision) currentReport.getServicio();
//				 * numeroPoliza = servicioAdmision.getReporteNumeroPoliza(); break;
//				 * 
//				 * OrdenPaseReclamacion servicioReclamacion = (OrdenPaseReclamacion)
//				 * currentReport.getServicio(); numeroPoliza =
//				 * servicioReclamacion.getReporteNumeroPoliza(); break;
//				 * 
//				 * case JMBeanSIICATimerOrdenPases.VALE_AMBULANCIA: OrdenPaseAmbulancia
//				 * servicioAmbulancia = (OrdenPaseAmbulancia) currentReport.getServicio();
//				 * numeroPoliza = servicioAmbulancia.getReporteNumeroPoliza(); break;
//				 * 
//				 * case JMBeanSIICATimerOrdenPases.ENCUESTA_SERVICIO: EncuestaAjustador
//				 * servicioEncuesta = (EncuestaAjustador) currentReport.getServicio();
//				 * numeroPoliza = servicioEncuesta.getPoliza(); break;
//				 */
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_RECLAMACION_PENDIENTE:
//					FormatoReclamacionPendiente servicioReclamacionPendiente = (FormatoReclamacionPendiente) currentReport
//							.getServicio();
//					numeroPoliza = servicioReclamacionPendiente.getRpNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_ENCUESTA_SERVICIO:
//					FormatoEncuestaServicio servicioEncuestaServicio = (FormatoEncuestaServicio) currentReport
//							.getServicio();
//					numeroPoliza = servicioEncuestaServicio.getEsNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_ASISTENCIA_VIAL:
//					FormatoAsistenciaVial servicioAsistenciaVial = (FormatoAsistenciaVial) currentReport.getServicio();
//					numeroPoliza = servicioAsistenciaVial.getAvNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_NUEVOS_VEHICULOS:
//					FormatoNuevosVehiculos servicioNuevosVehiculos = (FormatoNuevosVehiculos) currentReport
//							.getServicio();
//					numeroPoliza = servicioNuevosVehiculos.getNvNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_PASE_MEDICO:
//					FormatoPaseMedico servicioPaseMedico = (FormatoPaseMedico) currentReport.getServicio();
//					numeroPoliza = servicioPaseMedico.getPmNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_ASIGNACION_ABOGADO:
//					FormatoAsignacionAbogado servicioAsignacionAbogado = (FormatoAsignacionAbogado) currentReport
//							.getServicio();
//					numeroPoliza = servicioAsignacionAbogado.getAaNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_GARANTIA_PRENDARIA:
//					FormatoGarantiaPrendaria servicioGarantia = (FormatoGarantiaPrendaria) currentReport.getServicio();
//					numeroPoliza = servicioGarantia.getGpNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_REPARACION_BIENES:
//					FormatoReparacionBienes servicioReparacion = (FormatoReparacionBienes) currentReport.getServicio();
//					numeroPoliza = servicioReparacion.getRbNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_VALE_AMBULANCIA:
//					FormatoValeAmbulancia servicioValeAmbulancia = (FormatoValeAmbulancia) currentReport.getServicio();
//					numeroPoliza = servicioValeAmbulancia.getVaNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_ORDEN_SERVICIO:
//					FormatoOrdenServicio servicioServicio = (FormatoOrdenServicio) currentReport.getServicio();
//					numeroPoliza = servicioServicio.getOsPoliza();
//					break;
//
//				// case JMBeanSIICATimerOrdenPases.FORMATO_DECLARACION_UNIVERSAL:
//				// FormatoDeclaracionUniversal servicioDeclaracionUn =
//				// (FormatoDeclaracionUniversal) currentReport.getServicio();
//				// numeroPoliza = servicioDeclaracionUn.getDuNumPoliza();
//				// break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_INVENTARIO_AUTOMOVILES:
//					FormatoInventarioAutomoviles servicioInventario = (FormatoInventarioAutomoviles) currentReport
//							.getServicio();
//					numeroPoliza = servicioInventario.getIaNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_CUESTIONARIO_ROBO:
//					FormatoCuestionarioRobo servicioCuestionario = (FormatoCuestionarioRobo) currentReport
//							.getServicio();
//					numeroPoliza = servicioCuestionario.getCrNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_ADMISION_AUTOMOVILES:
//					FormatoAdmisionAutomoviles servicioAdmisionAuto = (FormatoAdmisionAutomoviles) currentReport
//							.getServicio();
//					numeroPoliza = servicioAdmisionAuto.getOaNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_ADMISION_MOTOCICLETAS:
//					FormatoAdmisionMotocicletas servicioAdmisionMoto = (FormatoAdmisionMotocicletas) currentReport
//							.getServicio();
//					numeroPoliza = servicioAdmisionMoto.getOaNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_ADMISION_PESADO:
//					FormatoAdmisionPesado servicioAdmisionPesado = (FormatoAdmisionPesado) currentReport.getServicio();
//					numeroPoliza = servicioAdmisionPesado.getOpNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.F_INSPECCION_PESADO:
//					FormatoInspeccionPesado servicioInspeccionPesado = (FormatoInspeccionPesado) currentReport
//							.getServicio();
//					numeroPoliza = servicioInspeccionPesado.getIpNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.F_INSPECCION_MOTO:
//					FormatoInspeccionMoto servicioInspeccionMoto = (FormatoInspeccionMoto) currentReport.getServicio();
//					numeroPoliza = servicioInspeccionMoto.getImNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_PRUEBA:
//					FormatoPrueba servicioPrueba = (FormatoPrueba) currentReport.getServicio();
//					numeroPoliza = servicioPrueba.getFpEdad();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_RECIBO_INGRESO:
//					FormatoReciboIngresoSiniestro servicioReciboIngreso = (FormatoReciboIngresoSiniestro) currentReport
//							.getServicio();
//					numeroPoliza = servicioReciboIngreso.getRiNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_RECIBO_DEDUCIBLE:
//					FormatoReciboPagoDeducible servicioReciboDeducible = (FormatoReciboPagoDeducible) currentReport
//							.getServicio();
//					numeroPoliza = servicioReciboDeducible.getRdNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_SOLICITUD_DIAGNOSTICO:
//					FormatoSolicitudDiagnostico servicioSolicitudDiagnostico = (FormatoSolicitudDiagnostico) currentReport
//							.getServicio();
//					numeroPoliza = servicioSolicitudDiagnostico.getSdNumPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_MEMORIA_DESCRIPTIVA:
//					FormatoMemoriaDescriptiva servicioMemoriaDescriptiva = (FormatoMemoriaDescriptiva) currentReport
//							.getServicio();
//					numeroPoliza = servicioMemoriaDescriptiva.getPoliza();
//					break;
//
//				case JMBeanSIICATimerOrdenPases.FORMATO_OBSERVACIONES_ASEGURADO:
//					FormatoObservacionesAsegurado servicioObservacionesAsegurado = (FormatoObservacionesAsegurado) currentReport
//							.getServicio();
//					numeroPoliza = servicioObservacionesAsegurado.getFoaNumPoliza();
//					break;
//
//				/*
//				 * case JMBeanSIICATimerOrdenPases.LOG_FORMATOS_AJUSTADOR_ERROR:
//				 * LogFormatosAjustadorError servicioLFormatosAjustador =
//				 * (LogFormatosAjustadorError) currentReport.getServicio(); numeroPoliza =
//				 * servicioFormatosAjustadorError.getOaNumPoliza(); break;
//				 */
//
//				default:
//					break;
//				}
//
//				/// ESTE PROCESO YA NO SE USA contenidoLst +=
//				/// armarContenidoArchivoLst(currentReport.getNombrePDF(),
//				/// currentReport.getTipoServicio(), "1", currentReport.getNumeroReporte(),
//				/// numeroPoliza) + "\n";
//			}
//
//			FileOutputStream out;
//
//		}
//	}

	private Set<String> obtenerDuplicados(List<ReporteOrdenes> reporteOrdenes) {
		final Set<String> duplicados = new HashSet<String>();
		final Set<String> set1 = new HashSet<String>();

		for (int i = 0; i < reporteOrdenes.size(); i++) {
			if (!set1.add(reporteOrdenes.get(i).getNumeroReporte())) {
				duplicados.add(reporteOrdenes.get(i).getNumeroReporte());
			}
		}

		return duplicados;
	}

	private static void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/**
	 * @return the respuestaEmail
	 */
	public String getRespuestaEmail() {
		return respuestaEmail;
	}

	/**
	 * @param respuestaEmail the respuestaEmail to set
	 */
	public void setRespuestaEmail(String respuestaEmail) {
		this.respuestaEmail = respuestaEmail;
	}

	/**
	 * @return the emailEnviado
	 */
	public int getEmailEnviado() {
		return emailEnviado;
	}

	/**
	 * @param emailEnviado the emailEnviado to set
	 */
	public void setEmailEnviado(int emailEnviado) {
		this.emailEnviado = emailEnviado;
	}

	public String validarCadena(String cadena) {

		if (cadena == null) {
			return "";
		} else {
			return cadena;
		}

	}

	/**
	 * @return the fechaEnvioMail
	 */
	public Timestamp getFechaEnvioMail() {
		return fechaEnvioMail;
	}

	/**
	 * @param fechaEnvioMail the fechaEnvioMail to set
	 */
	public void setFechaEnvioMail(Timestamp fechaEnvioMail) {
		this.fechaEnvioMail = fechaEnvioMail;
	}

	/**
	 * @return the fechaEnvioSftp
	 */
	public Timestamp getFechaEnvioSftp() {
		return fechaEnvioSftp;
	}

	/**
	 * @param fechaEnvioSftp the fechaEnvioSftp to set
	 */
	public void setFechaEnvioSftp(Timestamp fechaEnvioSftp) {
		this.fechaEnvioSftp = fechaEnvioSftp;
	}

	public int getSftpEnviado() {
		return sftpEnviado;
	}

	public void setSftpEnviado(int sftpEnviado) {
		this.sftpEnviado = sftpEnviado;
	}

	public String getRespuestaSFTP() {
		return respuestaSFTP;
	}

	public void setRespuestaSFTP(String respuestaSFTP) {
		this.respuestaSFTP = respuestaSFTP;
	}

	public int getEmailEnviadoB() {
		return emailEnviadoB;
	}

	public void setEmailEnviadoB(int emailEnviadoB) {
		this.emailEnviadoB = emailEnviadoB;
	}

	public String getRespuestaEmailB() {
		return respuestaEmailB;
	}

	public void setRespuestaEmailB(String respuestaEmailB) {
		this.respuestaEmailB = respuestaEmailB;
	}

	public Timestamp getFechaEnvioMailB() {
		return fechaEnvioMailB;
	}

	public void setFechaEnvioMailB(Timestamp fechaEnvioMailB) {
		this.fechaEnvioMailB = fechaEnvioMailB;
	}

	

}