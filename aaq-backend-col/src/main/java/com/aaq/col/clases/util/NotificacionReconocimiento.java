package com.aaq.col.clases.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.MailcapCommandMap;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import com.aaq.col.clases.path.ProveedorApplicationContext;


public class NotificacionReconocimiento {

	
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
    private ArrayList<String> mensajePara;
    private ArrayList<String> mensajeCC;
    private ArrayList<String> mensajeBCC;
    
	public NotificacionReconocimiento() {
        this.logger = (Log4JLogger)LogFactory.getLog("com.jmfg.jmlibrerias.logging.utilerias");
    }
    
    public NotificacionReconocimiento(final String servidor, final String correo, final String usuario, final String passwd, final int puerto, final boolean conexionSegura, final boolean iniciarLogin, final boolean debug) {
        this.logger = (Log4JLogger)LogFactory.getLog("com.jmfg.jmlibrerias.logging.utilerias");
        this.servidor = servidor;
        this.correo = correo;
        this.usuario = usuario;
        this.passwd = passwd;
        this.puerto = puerto;
        this.conexionSegura = conexionSegura;
        this.iniciarLogin = iniciarLogin;
    }
    
    public boolean enviarEmailAsync(final ArrayList<String> listado, final String asunto, final String texto,  final String numeroReporte) {
      return this.enviarEmailAsync(listado, null, null, asunto, texto, numeroReporte);
    }
    
	@Async
	public boolean enviarEmailAsync(final ArrayList<String> listado, final ArrayList<String> listadocc, final ArrayList<String> listadobcc, final String asunto, final String texto, final String numeroReporte) {
		this.loggerAvisos.info("*** Entrada al proceso de envio de correo -> notificaciones -> reconocimiento ***");
		this.loggerAvisos.info("Destinatario: "+listado+", asunto: "+asunto+", reporte: "+numeroReporte);
		this.loggerAvisos.info("Inicia conteo de tiempo de enviol método para enviar correo");
		
		long startTime = System.currentTimeMillis();
		
			this.mensajePara = listado;
	        this.mensajeCC = listadocc;
	        this.mensajeBCC = listadobcc;
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
	           
	            msg.setSubject(this.mensajeAsunto);
	            msg.setText(this.mensajeTexto, true);
	            
	            try {
	            String ruta = ProveedorApplicationContext.getApplicationContext().getResource("/resumen").getFile().getPath() + "/";
	            this.loggerAvisos.info("Ruta de imagen -> "+ruta);
	            FileSystemResource res = new FileSystemResource(new File(ruta + "firmaMail.png"));
	            msg.addInline("firmaCorreo", res);
	            
	            FileSystemResource resIcono = new FileSystemResource(new File(ruta + "logoQualitasNuevo.png"));
	            msg.addInline("logoQualitas", resIcono);

	            } catch (FileNotFoundException | ClassCastException | IllegalArgumentException | MessagingException e) {
	            	 this.loggerAvisos.error("Ocurrio un error al obtener la ruta de la carpeta resumen-> "+e);
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
	            this.logger.error((Object)("Error de Envio de Correo. Detalles: " + e.getMessage() + ". Para: " + this.mensajePara + ", CC: " + this.mensajeCC + ", BCC: " + this.mensajeBCC + ", Asunto: " + this.mensajeAsunto), (Throwable)e);
	            return false;
	        }  catch (IOException e) {
	        	long endTime = System.currentTimeMillis() - startTime;
	        	this.loggerAvisos.info("Duración del proceso CorreoFirmaImagAsync " + endTime + " milisegundos.");
	        	this.loggerAvisos.info("Ocurrio un error -> CorreoFirmaImagAsync -> "+e);
				log.info(e);			
	            this.logger.error((Object)("Error de Envio de Correo. Detalles: " + e.getMessage() + ". Para: " + this.mensajePara + ", CC: " + this.mensajeCC + ", BCC: " + this.mensajeBCC + ", Asunto: " + this.mensajeAsunto), (Throwable)e);
	            return false;
	        } catch (MessagingException e) {
	        	long endTime = System.currentTimeMillis() - startTime;
	        	this.loggerAvisos.info("Duración del proceso CorreoFirmaImagAsync " + endTime + " milisegundos.");
	        	this.loggerAvisos.info("Ocurrio un error -> CorreoFirmaImagAsync -> "+e);
				log.info(e);			
	            this.logger.error((Object)("Error de Envio de Correo. Detalles: " + e.getMessage() + ". Para: " + this.mensajePara + ", CC: " + this.mensajeCC + ", BCC: " + this.mensajeBCC + ", Asunto: " + this.mensajeAsunto), (Throwable)e);
	            return false;
	         }   catch (Exception e) {
	        	long endTime = System.currentTimeMillis() - startTime;
	        	this.loggerAvisos.info("Duración del proceso CorreoFirmaImagAsync " + endTime + " milisegundos.");
	        	this.loggerAvisos.info("Ocurrio un error -> CorreoFirmaImagAsync -> "+e);
				log.info(e);			
	            this.logger.error((Object)("Error de Envio de Correo. Detalles: " + e.getMessage() + ". Para: " + this.mensajePara + ", CC: " + this.mensajeCC + ", BCC: " + this.mensajeBCC + ", Asunto: " + this.mensajeAsunto), (Throwable)e);
	            return false;
	         } 
    }
	
}
