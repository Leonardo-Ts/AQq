package com.aaq.col.clases.util;

import java.io.File;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;


public class EnviarUnicoCorreo {
	

	public org.apache.commons.logging.Log log = LogFactory.getLog(CorreoFirmaImagAsync.class);
	Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");
	
    private final Log4JLogger logger;
    private String servidor;
    private String correo;
    private String usuario;
    private transient  String passwd;
    private int puerto;
    private boolean conexionSegura;
    private boolean iniciarLogin;
    private String mensajeAsunto;
    private String mensajeTexto;
    private String mensajePara;
    
	public EnviarUnicoCorreo() {
        this.logger = (Log4JLogger)LogFactory.getLog("com.jmfg.jmlibrerias.logging.utilerias");
    }
    
    public EnviarUnicoCorreo(final String servidor, final String correo, final String usuario, final String passwd, final int puerto, final boolean conexionSegura, final boolean iniciarLogin, final boolean debug) {
        this.logger = (Log4JLogger)LogFactory.getLog("com.jmfg.jmlibrerias.logging.utilerias");
        this.servidor = servidor;
        this.correo = correo;
        this.usuario = usuario;
        this.passwd = passwd;
        this.puerto = puerto;
        this.conexionSegura = conexionSegura;
        this.iniciarLogin = iniciarLogin;
    }

    @Async
	public boolean enviarEmailAsync(final String correoDestinatario, final String asunto, final String texto, final String numeroReporte, final String ruta) {
		this.loggerAvisos.info("*** Entrada al proceso de envio de correo -> notificaciones -> reconocimiento ***");
		this.loggerAvisos.info("Destinatario: "+correo+", asunto: "+asunto+", reporte: "+numeroReporte);
		this.loggerAvisos.info("Inicia conteo de tiempo de enviol método para enviar correo");
		
		long startTime = System.currentTimeMillis();
		
			this.mensajePara = correoDestinatario;
	        this.mensajeAsunto = asunto;
	        this.mensajeTexto = texto;
	        
	        
	        final String protocol = this.conexionSegura ? "smtps" : "smtp";
	        this.loggerAvisos.info("Protocolo: "+protocol);
	        final JavaMailSenderImpl sender = new JavaMailSenderImpl();
	        sender.setHost(this.servidor);
	        sender.setPort(this.puerto);
	        
	        this.loggerAvisos.info("Servidor: "+this.servidor);
	        this.loggerAvisos.info("Puerto: "+this.puerto);
	        this.loggerAvisos.info("Iniciar Login: "+this.iniciarLogin);
	        
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
	        
	        Properties props = new Properties();
	        props.setProperty("mail.debug", Boolean.toString(false));
	        props.setProperty("mail." + protocol + ".user", this.usuario);
	        props.setProperty("mail." + protocol + ".host", this.servidor);
	        props.setProperty("mail." + protocol + ".port", Integer.toString(this.puerto));
	        props.setProperty("mail." + protocol + ".connectiontimeout", "30000");
	        props.setProperty("mail." + protocol + ".timeout", "30000");
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
	            msg.addTo(this.mensajePara);
	            msg.setSubject(this.mensajeAsunto);
	            msg.setText(this.mensajeTexto, true);
	            
	            if (ruta != null) {
		            try {
			            FileSystemResource imagenSiniestro = new FileSystemResource(new File(ruta + "logoQualitasP.png"));
			            msg.addInline("logoAAQ", imagenSiniestro);
			            
		            } catch ( ClassCastException | IndexOutOfBoundsException | IllegalArgumentException e) {
		            	 this.loggerAvisos.error("Ocurrio un error: "+e);
					} catch ( MessagingException   e) {
						this.loggerAvisos.error("Ocurrio un error: "+e);
					}
	            }
	            
	            sender.send(message);
	            long endTime = System.currentTimeMillis() - startTime;
	            //imprime tiempo transcurrido en ms
	            this.loggerAvisos.info("Duración del proceso CorreoFirmaImagAsync " + endTime + " milisegundos.");
	            return true;
	        }   catch (MailException e) {
	        	long endTime = System.currentTimeMillis() - startTime;
	        	this.loggerAvisos.info("Duración del proceso CorreoFirmaImagAsync " + endTime + " milisegundos.");
	        	this.loggerAvisos.info("Ocurrio un error -> CorreoFirmaImagAsync -> "+e);
				log.info(e);			
	            this.logger.error((Object)("Error de Envio de Correo. Detalles: " + e.getMessage() + ". Para: " + this.mensajePara + ", Asunto: " + this.mensajeAsunto), (Throwable)e);
	            return false;
	        }  catch (MessagingException e) {
	        	long endTime = System.currentTimeMillis() - startTime;
	        	this.loggerAvisos.info("Duración del proceso CorreoFirmaImagAsync " + endTime + " milisegundos.");
	        	this.loggerAvisos.info("Ocurrio un error -> CorreoFirmaImagAsync -> "+e);
				log.info(e);			
	            this.logger.error((Object)("Error de Envio de Correo. Detalles: " + e.getMessage() + ". Para: " + this.mensajePara + ", Asunto: " + this.mensajeAsunto), (Throwable)e);
	            return false;
	         }   catch (Exception e) {
	        	long endTime = System.currentTimeMillis() - startTime;
	        	this.loggerAvisos.info("Duración del proceso CorreoFirmaImagAsync " + endTime + " milisegundos.");
	        	this.loggerAvisos.info("Ocurrio un error -> CorreoFirmaImagAsync -> "+e);
				log.info(e);			
	            this.logger.error((Object)("Error de Envio de Correo. Detalles: " + e.getMessage() + ". Para: " + this.mensajePara + ", Asunto: " + this.mensajeAsunto), (Throwable)e);
	            return false;
	         } 
    }

}
