package com.aaq.col.clases.util;

import java.io.File;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.jmfg.jmlib.sistema.classes.web.spring.JMProveedorApplicationContext;
import com.sun.mail.smtp.SMTPTransport;

public class SendEmail {
	
	public static Log log = LogFactory.getLog(SendEmail.class);
	Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");

	public void enviarPDF(String destinatario, String asunto,String cuerpoCorreo,  byte[] pdfArray, String servidor, String pwd, int puerto,
			String usuario, boolean iniciarLogin, boolean conexionSegura , String correo ) {
		
		this.loggerAvisos.info("Entrada al proceso enviarPDF");
		this.loggerAvisos.info("Destinatario: "+destinatario+", asunto: "+asunto+", servidor: "+servidor+", pwd: "+pwd+", puerto: "+puerto+", usuario: "+usuario+
				", iniciarLogin: "+iniciarLogin+", conexionSegura: "+conexionSegura+", correo: "+correo);
		
		final JavaMailSenderImpl jms = new JavaMailSenderImpl();
		String nombrePDF = "resumen-ajustador.pdf";
		final String protocolo = "smtp";
		jms.setHost(servidor);
		jms.setPort(puerto);
		jms.setProtocol(protocolo);
		if (iniciarLogin) {
			jms.setUsername(usuario);
			jms.setPassword(pwd);
		}
		
		log.info("Protocolo: "+protocolo);
		this.loggerAvisos.info("Protocolo: "+protocolo);
		
        final Properties props = new Properties();
        props.setProperty("mail." + protocolo + ".user", usuario);
        props.setProperty("mail." + protocolo + ".host", servidor);
        props.setProperty("mail." + protocolo + ".port", Integer.toString(puerto));
        props.setProperty("mail." + protocolo + ".connectiontimeout", "300000");
        props.setProperty("mail." + protocolo + ".timeout", "300000");
        props.setProperty("mail." + protocolo + ".from", correo);
        props.setProperty("mail." + protocolo + ".auth", Boolean.toString(iniciarLogin));
        props.setProperty("mail." + protocolo + ".ssl.enable", Boolean.toString(conexionSegura));
        props.setProperty("mail." + protocolo + ".ssl.checkserveridentity", "false");
        props.setProperty("mail." + protocolo + ".ssl.trust", "*");
        jms.setJavaMailProperties(props);
        
        if (!StringUtils.startsWith((CharSequence)cuerpoCorreo, (CharSequence)"<html>")) {
            cuerpoCorreo = "<html><head></head><body>" + cuerpoCorreo + "</body></html>";
        }
        
        final MimeMessage message = jms.createMimeMessage();
        try {
	        final MimeMessageHelper msg = new MimeMessageHelper(message, true, "UTF-8");
	        msg.setFrom(correo);
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
	        
	        String ruta = JMProveedorApplicationContext.getApplicationContext().getResource("/resumen").getFile().getPath() + "/";
            this.loggerAvisos.info("RUTA DE PDF -> "+ruta);
            msg.setSubject(asunto);
            msg.setText(cuerpoCorreo, true);
            FileSystemResource res = new FileSystemResource(new File(ruta + "firmaMail.png"));
            msg.addInline("firmaCorreo", res);

            if (pdfArray != null && pdfArray.length > 0 && StringUtils.isNotBlank((CharSequence)nombrePDF)) {
                msg.addAttachment(nombrePDF, (InputStreamSource)new ByteArrayResource(pdfArray));
            }
            jms.send(message);   

	        
        } catch (Exception e) {
        	this.loggerAvisos.info("Ocurrio un error al enviar el PDF -> "+e);
			log.info("OCURRIO UN ERROR AL ENVIAR EL PDF-> "+e);
		}
		
	}
	
//	public void enviarMail(byte[] arr, String asunto, String cuerpoCorreo, String servidor, String userName, String pwd, 
//							String emailFrom, String emailTo, String puerto) {
//		
	public void enviarMail (String asunto, String cuerpoCorreo, String servidor, String userName, String pwd, 
			String emailFrom, String emailTo, String puerto) {

		this.loggerAvisos.info("Entrada al proceso enviarMail");
		this.loggerAvisos.info("Destinatario: "+emailTo+", asunto: "+asunto+", servidor: "+servidor+", pwd: "+pwd+", puerto: "+puerto+", usuario: "+userName+
				", correo: "+emailFrom+", cuerpoCorreo: "+cuerpoCorreo);

	    String cuerpoCorreo1 = null;
	    
	    if (!StringUtils.startsWith((CharSequence)cuerpoCorreo, (CharSequence)"<html>")) {
	    	cuerpoCorreo1 = "<html><head></head><body>" + cuerpoCorreo + "</body></html>";
        }
	    
	    Properties prop = System.getProperties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.port", puerto);

        Session session = Session.getInstance(prop, null);
        Message msg = new MimeMessage(session);

        try {
            msg.setFrom(new InternetAddress(emailFrom));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(emailTo, false));
            msg.setSubject(asunto);

            // text
            MimeBodyPart p1 = new MimeBodyPart();
            p1.setContent(cuerpoCorreo1, "text/html; charset=utf-8");
//            
//            MimeBodyPart archivoPDF = new MimeBodyPart();
//            ByteArrayDataSource ds = new ByteArrayDataSource(arr, "application/pdf"); 
//            archivoPDF.setDataHandler(new DataHandler(ds));
//            archivoPDF.setFileName("resumen-ajustador.pdf");
            
            Multipart mp = new MimeMultipart();
            mp.addBodyPart(p1);
//            mp.addBodyPart(archivoPDF);

            msg.setContent(mp);

           try {
			SMTPTransport t = (SMTPTransport) session.getTransport("smtp");

			// connect
            t.connect(servidor, userName, pwd);

			// send
            t.sendMessage(msg, msg.getAllRecipients());

            log.info("Response: " + t.getLastServerResponse());
            this.loggerAvisos.info("Response: " + t.getLastServerResponse());

            t.close();
           } catch (Exception e) {
			this.loggerAvisos.info("Ocurrio un error en enviarMail ->SMTPTransport -> "+e);
			
		}

        } catch (MessagingException e) {
        	log.info("Error -> "+e);
        	this.loggerAvisos.info("Ocurrio un error: "+e);
        }

	}
	
	
}
