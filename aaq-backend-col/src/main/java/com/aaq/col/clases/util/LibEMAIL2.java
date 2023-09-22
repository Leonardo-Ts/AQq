package com.aaq.col.clases.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class LibEMAIL2 extends Observable {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");
	private String servidor;
	private String correo;
	private String usuario;
	private String passwd;
	private int puerto;
	private boolean conexionSegura;
	private boolean iniciarLogin;
	private boolean debug;
	private String mensajeAsunto;
	@SuppressWarnings("unused")
	private String mensajeTexto;
	private ArrayList<String> mensajePara;
	private ArrayList<String> mensajeCC;
	private ArrayList<String> mensajeBCC;
	@SuppressWarnings("unused")
	private byte[] attachmentByte;
	@SuppressWarnings("unused")
	private String attachmentNombre;
	private String pathArchivo;
	private String nombreDocumento;
	String error = "";
	private String pathArchivoVentauto;
	private boolean enviarVentaAuto;
	private String pathImgLiga;
	private String copiaOculta;
	private String pathImgAjustador;

	public LibEMAIL2() {
	}

	public LibEMAIL2(String servidor, String correo, String usuario, String passwd, int puerto, boolean conexionSegura,
			boolean iniciarLogin, boolean debug, String pathArchivo, String pathArchivoVentauto, boolean enviarVentaAuto,
			String pathImgLiga, String pathImgAjustador) {
		this.servidor = servidor;
		this.correo = correo;
		this.usuario = usuario;
		this.passwd = passwd;
		this.puerto = puerto;
		this.conexionSegura = conexionSegura;
		this.iniciarLogin = iniciarLogin;
		this.debug = debug;
		this.pathArchivo = pathArchivo;
		this.pathArchivoVentauto=pathArchivoVentauto;
		this.enviarVentaAuto=enviarVentaAuto;
		this.pathImgLiga=pathImgLiga;
		this.pathImgAjustador=pathImgAjustador;

	}

	public boolean enviarEmail(ArrayList<String> listado, String asunto, String texto, String nombreDocumento,String emailCopiaOculta) {

		return enviarEmail(listado, null, null, asunto, texto, null, null, nombreDocumento,emailCopiaOculta);
	}

	public boolean enviarEmail(ArrayList<String> listado, ArrayList<String> listadocc, ArrayList<String> listadobcc,
			String asunto, String texto, byte[] att, String attName, String nombreDocumento,String emailCopiaOculta) {
		this.mensajePara = listado;
		this.mensajeCC = listadocc;
		this.mensajeBCC = listadobcc;
		this.mensajeAsunto = asunto;
		this.mensajeTexto = texto;
		this.attachmentByte = att;
		this.attachmentNombre = attName;
		this.nombreDocumento = nombreDocumento;
		this.copiaOculta=emailCopiaOculta;

		return envE();
	}

	public boolean envE() {
		try {

			String protocol = this.conexionSegura ? "smtps" : "smtp";

			JavaMailSenderImpl sender = new JavaMailSenderImpl();
			sender.setHost(this.servidor);
			sender.setPort(this.puerto);
			sender.setProtocol(protocol);
			if (this.iniciarLogin) {
				sender.setUsername(this.usuario);

				sender.setPassword(this.passwd);
			}
			MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
			mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
			mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
			mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
			mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
			mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
			CommandMap.setDefaultCommandMap(mc);

			Properties props = new Properties();

			props.setProperty("mail.debug", Boolean.toString(this.debug));
			props.setProperty("mail." + protocol + ".user", this.usuario);
			props.setProperty("mail." + protocol + ".host", this.servidor);
			props.setProperty("mail." + protocol + ".port", Integer.toString(this.puerto));
			props.setProperty("mail." + protocol + ".connectiontimeout", "60000");
			props.setProperty("mail." + protocol + ".timeout", "60000");
			props.setProperty("mail." + protocol + ".from", this.correo);
			props.setProperty("mail." + protocol + ".auth", Boolean.toString(this.iniciarLogin));
			props.setProperty("mail." + protocol + ".ssl.enable", Boolean.toString(this.conexionSegura));
			props.setProperty("mail." + protocol + ".ssl.checkserveridentity", "false");
			props.setProperty("mail." + protocol + ".ssl.trust", "*");

			sender.setJavaMailProperties(props);
			
			MimeMessage message = sender.createMimeMessage();
			

			MimeMessageHelper msg = new MimeMessageHelper(message, true, "UTF-8");

			msg.setFrom(this.correo);
			if ((this.mensajePara != null) && (this.mensajePara.size() > 0)) {
				for (String str : this.mensajePara) {
					if (StringUtils.containsIgnoreCase(str, ",")) {
						for (String p : StringUtils.splitPreserveAllTokens(str, ",")) {
							if (EmailValidator.getInstance().isValid(p)) {
								msg.addTo(p);
							}
						}
					} else {
						msg.addTo(str);
					}
				}
			}
			if ((this.mensajeCC != null) && (this.mensajeCC.size() > 0)) {
				for (String p : this.mensajeCC) {
					if (EmailValidator.getInstance().isValid(p)) {
						msg.addCc(p);
					}
				}
			}
			
			if (StringUtils.isNotBlank(copiaOculta)) {
				if (EmailValidator.getInstance().isValid(copiaOculta)) {
					msg.addBcc(copiaOculta);

				}

			}
			msg.setSubject(this.mensajeAsunto);
			////////nuevo texto con link
			 
			msg.setText("<div>\r\n" + 
    					"<div style=\"text-align: center;\">\r\n" + 
    					"<table style=\"width: 800px; margin-left: auto; margin-right: auto;\">\r\n" + 
    					"<tbody>\r\n" + 
    					"<tr style=\"height: 231.758px;\">\r\n" + 
    					"<td style=\"width: 900px; font-size: 14px; text-align: justify; height: 231.758px;\">\r\n" + 
    					"<table>\r\n" + 
    					"<tbody>\r\n" + 
    					"<tr>\r\n" + 
    					"<td style=\"width: 50px; text-align: justify;\">\r\n" + 
    					"<p>&nbsp;</p>\r\n" + 
    					"<p>&nbsp;</p>\r\n" + 
    					"</td>\r\n" + 
    					"<td style=\"width: 900px;\">\r\n" + 
    					"<div style=\"text-align: center; color: #008c99; font-size: 32px; font-weight: 900;\"><strong>QU&Aacute;LITAS COMPA&Ntilde;&Iacute;A DE SEGUROS S.A DE C.V</strong></div>\r\n" + 
    					"<div style=\"text-align: center; color: #91278f; font-size: 21px; font-weight: 800;\"><strong>LE HACEMOS LLEGAR SU DECLARACI&Oacute;N UNIVERSAL DEL ACCIDENTE DUA</strong></div>\r\n" + 
    					"<div>&nbsp;</div>\r\n" + 
    					"<div style=\"text-align: center;\"><strong>Adicional nos permitimos anexarles el presente documento \"Folder Digital de Siniestros\", el cual tiene como objetivo:</strong></div>\r\n" + 
    					"<ul>\r\n" + 
    					"<li>Ser tu gu&iacute;a r&aacute;pida para la atenci&oacute;n de tu siniestro.</li>\r\n" + 
    					"<li>Aclarar tus dudas mas frecuentes.</li>\r\n" + 
    					"<li>Poner a tu disposici&oacute;n diferentes medios para que nos contacte</li>\r\n" + 
    					"</ul>\r\n" + 
    					"</td>\r\n" + 
    					"<td style=\"width: 50px;\">&nbsp;</td>\r\n" + 
    					"</tr>\r\n" + 
    					"</tbody>\r\n" + 
    					"</table>\r\n" + 
    					"</td>\r\n" + 
    					"<td style=\"height: 320px;\">&nbsp;</td>\r\n" + 
    					"</tr>\r\n" + 
    					"<tr style=\"width: 900px; height: 243px;\">\r\n" + 
    					"<td style=\"width: 600px; height: 243px;\">\r\n" + 
    					"<table style=\"width: 900px; margin-left: auto; margin-right: auto;\">\r\n" + 
    					"<tbody>\r\n" + 
    					"<tr>\r\n" + 
    					"<td style=\"width: 184.949px;\">\r\n" + 
    					"<table style=\"width: 395px; height: 155px; margin-left: auto; margin-right: auto;\">\r\n" + 
    					"<tbody>\r\n" + 
    					"<tr>\r\n" + 
    					"<td style=\"width: 164.492px; margin-left: auto; margin-right: auto; vertical-align: bottom;\"><img src=\"cid:superAjustador.png\" width=\"98\" height=\"120\" align=\"right\" /></td>\r\n" + 
    					"<td style=\"width: 215.273px; margin-left: auto; margin-right: auto; vertical-align: bottom; text-align: center; height: 150px;\">Consulta los mandamientos del ajustador, <a title=\"Consulta los mandamientos de ajustador, aqu&iacute;\" href=\"https://www.qualitas.com.mx/documents/20602/0/Mandamientos+del+Ajustador/042932da-5243-480c-b408-aec1535c79c6?t=1659473645067\"><strong>aqu&iacute;</strong></a></td>\r\n" + 
    					"</tr>\r\n" + 
    					"</tbody>\r\n" + 
    					"</table>\r\n" + 
    					"</td>\r\n" + 
    					"<td style=\"width: 418.051px;\">\r\n" + 
    					"<table style=\"width: 475px; height: 156px; margin-left: auto; margin-right: auto;\">\r\n" + 
    					"<tbody>\r\n" + 
    					"<tr>\r\n" + 
    					"<td style=\"width: 140px; margin-left: auto; margin-right: auto; vertical-align: bottom; height: 150px;\">&nbsp;</td>\r\n" + 
    					"<td style=\"width: 231.547px; margin-left: auto; margin-right: auto; vertical-align: bottom; height: 150px; text-align: center;\">\r\n" + 
    					"<div style=\"margin-top: 5px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"cid:link.jpeg\" width=\"206\" height=\"84\" align=\"center\" /></div>\r\n" + 
    					"<div style=\"text-align: center;\">Consulta nuestra Gu&iacute;a R&aacute;pida, <a title=\"Consulta nuestra Gu&iacute;a R&aacute;pida, aqu&iacute;\" href=\"https://www.qualitas.com.mx/documents/20602/0/Folder+Interactivo+Siniestros/ff153788-b99a-499e-8053-0c6feea6ece9\"><strong>aqu&iacute;</strong></a></div>\r\n" + 
    					"</td>\r\n" + 
    					"<td style=\"width: 77.4531px; margin-left: auto; margin-right: auto; vertical-align: bottom; height: 150px;\">&nbsp;</td>\r\n" + 
    					"</tr>\r\n" + 
    					"</tbody>\r\n" + 
    					"</table>\r\n" + 
    					"</td>\r\n" + 
    					"</tr>\r\n" + 
    					"</tbody>\r\n" + 
    					"</table>\r\n" + 
    					"&nbsp;\r\n" + 
    					"<table style=\"width: 900px; margin-left: auto; margin-right: auto;\">\r\n" + 
    					"<tbody>\r\n" + 
    					"<tr>\r\n" + 
    					"<td>&nbsp;</td>\r\n" + 
    					"</tr>\r\n" + 
    					"<tr>\r\n" + 
    					"<td style=\"width: 186px; font-family: Times; color: #808080; font-size: 12px; font-weight: 600; text-align: left;\">&nbsp;</td>\r\n" + 
    					"<td style=\"width: 426.27px; font-family: Times; color: #808080; font-size: 12px; font-weight: 407; text-align: center;\">En caso de dudas o comentarios, favor de contactar a su Ejecutivo de Cuenta.<br />LINEA DE ATENCI&Oacute;N TELEF&Oacute;NICA 01 800 062 3212</td>\r\n" + 
    					"<td style=\"width: 185.73px; font-family: Times; color: #808080; font-size: 12px; font-weight: 600;\">&nbsp;</td>\r\n" + 
    					"</tr>\r\n" + 
    					"</tbody>\r\n" + 
    					"</table>\r\n" + 
    					"</td>\r\n" + 
    					"</tr>\r\n" + 
    					"</tbody>\r\n" + 
    					"</table>\r\n" + 
    					"</div>\r\n" + 
    					"</div>",true);
            
            FileSystemResource pathLink = new FileSystemResource(new File(pathImgLiga));
            msg.addInline("link.jpeg", pathLink);
            
            
            FileSystemResource pathsuperAjustador = new FileSystemResource(new File(pathImgAjustador));
            msg.addInline("superAjustador.png", pathsuperAjustador); 
            
            
            
			msg.addAttachment(nombreDocumento + ".pdf", new FileDataSource(pathArchivo));
			
			if(enviarVentaAuto) {
				FileSystemResource file = new FileSystemResource(new File(pathArchivoVentauto));
				msg.addAttachment("VENTAUTO" + ".pdf",file);
				
			}
			
		
			sender.send(message);
			setChanged();
			notifyObservers("Mensaje Enviado OK. Para: " + Objects.toString(this.mensajePara, "") + ", CC: "
					+ Objects.toString(this.mensajeCC, "") + ", BCC: " + Objects.toString(this.mensajeBCC, "")
					+ ", Asunto: " + Objects.toString(this.mensajeAsunto, ""));

			return true;

		} catch (Exception e) {
			error =e.getCause().getCause().toString()+"..";
			log.error("Formatos Error=> envE()=> Error al envio de email=>" + this.mensajeAsunto+": "+ e.getMessage());

			return false;

		}
	}

}
