package com.aaq.col.clases.util;

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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class LibEMAIL extends Observable {

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
	private String mensajeTexto;
	private ArrayList<String> mensajePara;
	private ArrayList<String> mensajeCC;
	private ArrayList<String> mensajeBCC;
	private byte[] attachmentByte;
	private String attachmentNombre;
	private String pathArchivo;
	private String nombreDocumento;
	private String copiaOculta;
	String error = "";

	public LibEMAIL() {
	}

	public LibEMAIL(String servidor, String correo, String usuario, String passwd, int puerto, boolean conexionSegura,
			boolean iniciarLogin, boolean debug, String pathArchivo) {
		this.servidor = servidor;
		this.correo = correo;
		this.usuario = usuario;
		this.passwd = passwd;
		this.puerto = puerto;
		this.conexionSegura = conexionSegura;
		this.iniciarLogin = iniciarLogin;
		this.debug = debug;
		this.pathArchivo = pathArchivo;

	}

	public boolean enviarEmail(ArrayList<String> listado, String asunto, String texto, String nombreDocumento,
			String emailCopiaOculta) {

		return enviarEmail(listado, null, null, asunto, texto, null, null, nombreDocumento, emailCopiaOculta);
	}

	public boolean enviarEmail(ArrayList<String> listado, ArrayList<String> listadocc, ArrayList<String> listadobcc,
			String asunto, String texto, byte[] att, String attName, String nombreDocumento, String emailCopiaOculta) {
		this.mensajePara = listado;
		this.mensajeCC = listadocc;
		this.mensajeBCC = listadobcc;
		this.mensajeAsunto = asunto;
		this.mensajeTexto = texto;
		this.attachmentByte = att;
		this.attachmentNombre = attName;
		this.nombreDocumento = nombreDocumento;
		this.copiaOculta = emailCopiaOculta;

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
			if (!StringUtils.startsWith(this.mensajeTexto, "<html>")) {
				this.mensajeTexto = ("<html><head></head><body>" + this.mensajeTexto + "</body></html>");
			}
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
			msg.setText(this.mensajeTexto, true);
			msg.addAttachment(nombreDocumento + ".pdf", new FileDataSource(pathArchivo));
			if ((this.attachmentByte != null) && (this.attachmentByte.length > 0)
					&& (StringUtils.isNotBlank(this.attachmentNombre))) {
				msg.addAttachment(this.attachmentNombre, new ByteArrayResource(this.attachmentByte));
			}
			sender.send(message);
			setChanged();
			notifyObservers("Mensaje Enviado OK. Para: " + Objects.toString(this.mensajePara, "") + ", CC: "
					+ Objects.toString(this.mensajeCC, "") + ", BCC: " + Objects.toString(this.mensajeBCC, "")
					+ ", Asunto: " + Objects.toString(this.mensajeAsunto, ""));

			return true;

		} catch (Exception e) {
			error = e.getCause().getCause().toString();
			log.error(
					"Formatos Error=> envE()=> Error al envio de email=>" + this.mensajeAsunto + ": " + e.getMessage());

			return false;

		}
	}

}
