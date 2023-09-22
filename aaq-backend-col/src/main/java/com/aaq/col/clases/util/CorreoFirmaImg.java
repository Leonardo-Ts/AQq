package com.aaq.col.clases.util;

import org.apache.commons.logging.impl.*;
import org.apache.commons.logging.*;
import javax.activation.*;
import org.apache.commons.lang3.*;
import org.springframework.mail.javamail.*;

import com.jmfg.jmlib.sistema.classes.web.spring.JMProveedorApplicationContext;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaEmail;

import org.apache.commons.validator.routines.*;
import org.springframework.core.io.*;
import javax.mail.internet.*;

import java.io.File;
import java.util.*;

public class CorreoFirmaImg extends JMUtileriaEmail{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -2830939533003598955L;
    private final Log4JLogger logger;
    private String servidor;
    private String correo;
    private String usuario;
    private String passwd;
    private int puerto;
    private boolean conexionSegura;
    private boolean iniciarLogin;
    @SuppressWarnings("unused")
	private boolean debug;
    private String mensajeAsunto;
    private String mensajeTexto;
    private ArrayList<String> mensajePara;
    private ArrayList<String> mensajeCC;
    private ArrayList<String> mensajeBCC;
    private byte[] attachmentByte;
    private String attachmentNombre; 
    
	public CorreoFirmaImg() {
        this.logger = (Log4JLogger)LogFactory.getLog("com.jmfg.jmlibrerias.logging.utilerias");
    }
    
    public CorreoFirmaImg(final String servidor, final String correo, final String usuario, final String passwd, final int puerto, final boolean conexionSegura, final boolean iniciarLogin, final boolean debug) {
        this.logger = (Log4JLogger)LogFactory.getLog("com.jmfg.jmlibrerias.logging.utilerias");
        this.servidor = servidor;
        this.correo = correo;
        this.usuario = usuario;
        this.passwd = passwd;
        this.puerto = puerto;
        this.conexionSegura = conexionSegura;
        this.iniciarLogin = iniciarLogin;
        this.debug = debug;
    }

	@Override
	public void enviarEmail(final ArrayList<String> listado, final ArrayList<String> listadocc, final ArrayList<String> listadobcc, final String asunto, final String texto, final byte[] att, final String attName) {
        this.mensajePara = listado;
        this.mensajeCC = listadocc;
        this.mensajeBCC = listadobcc;
        this.mensajeAsunto = asunto;
        this.mensajeTexto = texto;
        this.attachmentByte = att;
        this.attachmentNombre = attName;
//        final Thread t = new Thread(this);
//        t.start();
        
//    }
	
//	 @Override
//	    public void run() {
//	public void enviarEmail () {
		 
		 final String protocol = this.conexionSegura ? "smtps" : "smtp";
	        final JavaMailSenderImpl sender = new JavaMailSenderImpl();
	        sender.setHost(this.servidor);
	        sender.setPort(this.puerto);
	        sender.setProtocol(protocol);
	        if (this.iniciarLogin) {
	            sender.setUsername(this.usuario);
	            sender.setPassword(this.passwd);
	        }
	        final MailcapCommandMap mc = (MailcapCommandMap)CommandMap.getDefaultCommandMap();
	        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
	        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
	        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
	        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
	        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
	        CommandMap.setDefaultCommandMap(mc);
	        final Properties props = new Properties();
	        props.setProperty("mail.debug", Boolean.toString(false));
	        props.setProperty("mail." + protocol + ".user", this.usuario);
	        props.setProperty("mail." + protocol + ".host", this.servidor);
	        props.setProperty("mail." + protocol + ".port", Integer.toString(this.puerto));
	        props.setProperty("mail." + protocol + ".connectiontimeout", "15000");
	        props.setProperty("mail." + protocol + ".timeout", "15000");
	        props.setProperty("mail." + protocol + ".from", this.correo);
	        props.setProperty("mail." + protocol + ".auth", Boolean.toString(this.iniciarLogin));
	        props.setProperty("mail." + protocol + ".ssl.enable", Boolean.toString(this.conexionSegura));
	        props.setProperty("mail." + protocol + ".ssl.checkserveridentity", "false");
	        props.setProperty("mail." + protocol + ".ssl.trust", "*");
	        sender.setJavaMailProperties(props);
	        if (!StringUtils.startsWith((CharSequence)this.mensajeTexto, (CharSequence)"<html>")) {
	            this.mensajeTexto = "<html><head></head><body>" + this.mensajeTexto + "</body></html>";
	        }
	        final MimeMessage message = sender.createMimeMessage();
	        try {
	            final MimeMessageHelper msg = new MimeMessageHelper(message, true, "UTF-8");
	            msg.setFrom(this.correo);
	            if (this.mensajePara != null && this.mensajePara.size() > 0) {
	                for (final String str : this.mensajePara) {
	                    if (StringUtils.containsIgnoreCase((CharSequence)str, (CharSequence)",")) {
	                        for (final String p : StringUtils.splitPreserveAllTokens(str, ",")) {
	                            if (EmailValidator.getInstance().isValid(p)) {
	                                msg.addTo(p);
	                            }
	                        }
	                    }
	                    else {
	                        msg.addTo(str);
	                    }
	                }
	            }
	            if (this.mensajeCC != null && this.mensajeCC.size() > 0) {
	                for (final String p2 : this.mensajeCC) {
	                    if (EmailValidator.getInstance().isValid(p2)) {
	                        msg.addCc(p2);
	                    }
	                }
	            }
	            if (this.mensajeBCC != null && this.mensajeBCC.size() > 0) {
	                for (final String p2 : this.mensajeBCC) {
	                    if (EmailValidator.getInstance().isValid(p2)) {
	                        msg.addBcc(p2);
	                    }
	                }
	            }
	            String ruta = JMProveedorApplicationContext.getApplicationContext().getResource("/resumen").getFile().getPath() + "/";
	            msg.setSubject(this.mensajeAsunto);
	            msg.setText(this.mensajeTexto, true);
	            FileSystemResource res = new FileSystemResource(new File(ruta + "firmaMail.png"));
	            msg.addInline("firmaCorreo", res);

	            if (this.attachmentByte != null && this.attachmentByte.length > 0 && StringUtils.isNotBlank((CharSequence)this.attachmentNombre)) {
	                msg.addAttachment(this.attachmentNombre, (InputStreamSource)new ByteArrayResource(this.attachmentByte));
	            }
	            sender.send(message);
	            this.setChanged();
	            this.notifyObservers("Mensaje Enviado OK. Para: " + Objects.toString(this.mensajePara, "") + ", CC: " + Objects.toString(this.mensajeCC, "") + ", BCC: " + Objects.toString(this.mensajeBCC, "") + ", Asunto: " + Objects.toString(this.mensajeAsunto, ""));
	        }
	        catch (Exception e) {
	            this.setChanged();
	            this.notifyObservers("Error de Envio de Correo. Detalles: " + e.getMessage() + ". Para: " + Objects.toString(this.mensajePara, "") + ", CC: " + Objects.toString(this.mensajeCC, "") + ", BCC: " + Objects.toString(this.mensajeBCC, "") + ", Asunto: " + Objects.toString(this.mensajeAsunto, ""));
	            this.logger.error((Object)("Error de Envio de Correo. Detalles: " + e.getMessage() + ". Para: " + this.mensajePara + ", CC: " + this.mensajeCC + ", BCC: " + this.mensajeBCC + ", Asunto: " + this.mensajeAsunto), (Throwable)e);
	        }
		 
	 }
}
