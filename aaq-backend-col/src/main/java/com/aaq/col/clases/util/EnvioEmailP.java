package com.aaq.col.clases.util;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.siica.JMConstantes;


public class EnvioEmailP extends ConectarSMTP{
	
	ConectarSMTP conexionEmail = new ConectarSMTP();
	private static final ConfiguracionServiceInterfase configuracionDao = Configuracion.getConfiguracionService();
	
	
	public void enviarEmailPrueba(String direccion) {
	try
 	{

 		// Se compone la parte del texto
 		BodyPart texto = new MimeBodyPart();
			 		
 		texto.setContent("\r\n" + 
 				"<!DOCTYPE html>\r\n" + 
 				"<html \"><head>\r\n" + 
 				"                <meta charset=\"utf-8\"/>\r\n" + 
 				"                <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"/><meta content=\"Webflow\" name=\"generator\"/>\r\n" + 
 				"                <link href=\"https://uploads-ssl.webflow.com/5bb623f75253bf12aa4ec1a1/css/cristinas-first-project-81713a.webflow.ea77e490f.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n" + 
 				"                \r\n" + 
 				"<link href=\"https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico\" rel=\"shortcut icon\" type=\"image/x-icon\"/><link href=\"https://daks2k3a4ib2z.cloudfront.net/img/webclip.png\" rel=\"apple-touch-icon\"/>\r\n" + 
 				"\r\n" + 
 				"\r\n" + 
 				"\r\n" + 
 				"</head>\r\n" + 
 				"<body style=\"color:#148679;font-size: 10px;\">\r\n" + 
 				"\r\n" + 
 				"\r\n" + 
 				"                <div style=\"width: 550px;height: 300px;padding-bottom: 13px;float: left;background-color: transparent; \">\r\n" + 
 				"                \r\n" + 
 				"\r\n" + 
 				"                <center><label style=\"color: rgb(0,140,153); font-size: 50px;text-align: center; margin-top: 10px; font-family: Tahoma, Verdana, Segoe, sans-serif;\">NOTIFICACIÓN</h1></center>\r\n" + 
 				"\r\n" + 
 				"                <center><div style=\"margin-top: 8px; color: rgb(145,39,143); font-size:23px; text-align: center; font-family: Tahoma, Verdana, Segoe, sans-serif;\"> DOCUMENTO DE PRUEBA </div></center>\r\n" + 
 				"    \r\n" + 
 				"\r\n" + 
 				"\r\n" + 
 				"\r\n" + 
 				"                <center>  \r\n" + 
 				"                        \r\n" + 
 				"                         \r\n" + 
 				"                          <strong>\r\n" + 
 				"                                   <center>\r\n" + 
 				"                                  <p style=\"width:455px;margin-top: 15px;margin-bottom: 15px;margin-left:34px; float: left;background-color: rgb(0,140,153);font-family: Tahoma, Verdana, Segoe, sans-serif;font-size: 15px; color: #fff; text-align: justify; \r\n" + 
 				"                                  padding-top: 1%; padding-left:2%; padding-right: 2%;padding-bottom: 1%; \"> De antemano agradecemos la confianza depositada en nosotros para brindarle el servicio. Le adjuntamos el formato registrado por el Ajustador para su servicio.\r\n" + 
 				"                                  </p> </center>\r\n" + 
 				"                            \r\n" + 
 				"                          </strong>\r\n" + 
 				"                                                 \r\n" + 
 				"                      \r\n" + 
 				"\r\n" + 
 				"\r\n" + 
 				"\r\n" + 
 				"\r\n" + 
 				"</center>\r\n" + 
 				"\r\n" + 
 				"        <div class=\"w-row\">\r\n" + 
 				"                <div class=\"w-col w-col-4\" style=\"margin-left: 60px;  margin-right: 50px; width: 460px; margin-top: 5px;\">\r\n" + 
 				"                        <label style=\"position: relative;margin-right: 0px;margin-bottom: 3px; font-family: Georgia, Times, 'Times New Roman' serif; color: #8a0a8a;font-size:17px;\">Fecha: </label>\r\n" + 
 				"                               \r\n" + 
 				"                        <label style=\"margin-bottom: 3px; font-family: Georigia, Times, 'Times New Roman', serif;color: #000;font-size: 17px;\">FECHA DE PRUEBA</label>\r\n" + 
 				"                </div>\r\n" + 
 				"        </div>\r\n" + 
 				"\r\n" + 
 				"        <div class=\"w-row\">\r\n" + 
 				"                <div class=\"w-col w-col-4\" style=\"margin-left: 60px;  margin-right: 10px; width: 440px; margin-top: 5px;\">\r\n" + 
 				"                        <label style=\"position: relative;margin-right: 0px;margin-bottom: 3px; font-family: Georgia, Times, 'Times New Roman' serif; color: #8a0a8a;font-size:17px;\">Nombre del conductor: </label>\r\n" + 
 				"                               \r\n" + 
 				"                        <label style=\"margin-bottom: 3px; font-family: Georigia, Times, 'Times New Roman', serif;color: #000;font-size: 17px;\">"+ "-----N/A-----" + "</label>\r\n" + 
 				"                </div>\r\n" + 
 				"        </div>\r\n" + 
 				"        <div class=\"w-row\">\r\n" + 
 				"                <div class=\"w-col w-col-4\" style=\"margin-left: 60px;  margin-right: 10px; width: 440px; margin-top: 5px;\">\r\n" + 
 				"                        <label style=\"position: relative;margin-right: 0px;margin-bottom: 3px; font-family: Georgia, Times, 'Times New Roman' serif; color: #8a0a8a;font-size:17px;\">Nombre del asegurado: </label>\r\n" + 
 				"                               \r\n" + 
 				"                        <label style=\"margin-bottom: 3px; font-family: Georigia, Times, 'Times New Roman', serif;color: #000;font-size: 17px;\">DESTINATARIO DE PRUEBA</label>\r\n" + 
 				"                </div>\r\n" + 
 				"        </div>\r\n" + 
 				"        <div class=\"w-row\">\r\n" + 
 				"                <div class=\"w-col w-col-4\" style=\"margin-left: 60px;  margin-right: 10px; width: 440px; margin-top: 5px;\">\r\n" + 
 				"                        <label style=\"position: relative;margin-right: 0px;margin-bottom: 3px; font-family: Georgia, Times, 'Times New Roman' serif; color: #8a0a8a;font-size:17px;\">Nombre del tercero: </label>\r\n" + 
 				"                               \r\n" + 
 				"                        <label style=\"margin-bottom: 3px; font-family: Georigia, Times, 'Times New Roman', serif;color: #000;font-size: 17px;\"> -----N/A----- </label>\r\n" + 
 				"                </div>\r\n" + 
 				"        </div>\r\n" + 
 				"        <div class=\"w-row\">\r\n" + 
 				"                <div class=\"w-col w-col-4\" style=\"margin-left: 60px;  margin-right: 10px; width: 440px; margin-top: 5px;\">\r\n" + 
 				"                        <label style=\"position: relative;margin-right: 0px;margin-bottom: 3px; font-family: Georgia, Times, 'Times New Roman' serif; color: #8a0a8a;font-size:17px;\">Número de reporte: </label>\r\n" + 
 				"                               \r\n" + 
 				"                        <label style=\"margin-bottom: 3px;font-family: Georigia, Times, 'Times New Roman', serif;color: #000;font-size: 17px;\">REPORTE DE PRUEBA</label>\r\n" + 
 				"                </div>\r\n" + 
 				"        </div>\r\n" + 
 				"        <div class=\"w-row\">\r\n" + 
 				"                <div class=\"w-col w-col-4\" style=\"margin-left: 60px;  margin-right: 10px; width: 440px; margin-top: 5px;\">\r\n" + 
 				"                        <label style=\"position: relative;margin-right: 0px;margin-bottom: 3px; font-family: Georgia, Times, 'Times New Roman' serif; color: #8a0a8a;font-size:17px;\">Número de póliza </label>\r\n" + 
 				"                               \r\n" + 
 				"                        <label style=\"margin-bottom: 3px;font-family: Georigia, Times, 'Times New Roman', serif;color: #000;font-size: 17px;\">POLIZA DE PRUEBA</label>\r\n" + 
 				"                </div>\r\n" + 
 				"        </div>\r\n" + 
 				"                <div style=\"margin:20px 50px 6px;\r\n" + 
 				"                               font-family: Georigia, Times, 'Times New Roman', serif;\r\n" + 
 				"                               color: rgba(113,125,141,.82);\r\n" + 
 				"                               font-size: 12px;\r\n" + 
 				"                               font-weight: 700;\">En caso de dudas o comentarios, favor de contactar a su Ejecutivo de Cuenta.<br/>LÍNEA DE ATENCIÓN TELEFÓNICA 01 800 062 3212\r\n" + 
 				"                </div>\r\n" + 
 				"</div>\r\n" + 
 				"<div style=\"width: 600px;\r\n" + 
 				"                               height: 420px;\r\n" + 
 				"                               float: left;\r\n" + 
 				"                               background-color:transparent; \">\r\n" + 
 				"                <img src=\"https://prueba9031.webnode.mx/_files/200000003-6854d694d9/450/img_qualitas.jpg\" alt=\"\" style=\"width: 390px;\r\n" + 
 				"                               height: 410px;\r\n" + 
 				"                               margin-top: 5px;\r\n" + 
 				"                               margin-left: 4px;\r\n" + 
 				"                               \" />\r\n" + 
 				"</div></div>\r\n" + 
 				"\r\n" + 
 				"<div style=\"width: 1205px;height: 130px;float: left;background-color:transparent;margin-top: 30px;line-height: 50px;\">\r\n" + 
 				"\r\n" + 
 				"                               <div class=\"w-row\">\r\n" + 
 				"                                               <div class=\" w-clearfix w-col w-col-12\" style=\"background-color: transparent;\">\r\n" + 
 				"                                               <img src=\"https://prueba9031.webnode.mx/_files/200000008-64a67659e6/700/pie_pagina_ALTA_6.jpg\" height=\"62px\";  alt=\"\" style=\"margin-left: 45px;\r\n" + 
 				"                                              width: 800px;\r\n" + 
 				"                                               float: left;\" />\r\n" + 
 				"                               </div>\r\n" + 
 				"                               \r\n" + 
 				"                </div>\r\n" + 
 				"\r\n" + 
 				"</body>\r\n" + 
 				"                </html>", "text/html");
 		
 		// Se compone el adjunto con la imagen
 		
 		
 		BodyPart adjunto = new MimeBodyPart();
 		adjunto.setDataHandler(
 				new DataHandler(new FileDataSource(direccion+"")));
 				adjunto.setFileName(direccion+"");
 		
 		// Una MultiParte para agrupar texto e imagen.
 		MimeMultipart multiParte = new MimeMultipart();
 		multiParte.addBodyPart(texto);
 		multiParte.addBodyPart(adjunto);

 		// Se compone el correo, dando to, from, subject y el  contenido.			 		
 		
 		
 		MimeMessage message = new MimeMessage(session);
 		message.setFrom(new InternetAddress(EnvioEmailP.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL)));

 		message.addRecipient(
 		Message.RecipientType.TO,
 		new InternetAddress("osiris.montes.sn@gmail.com"));
 		message.setSubject("REPORTE:  QUÁLITAS COMPAÑIA DE SEGUROS");
 		message.setContent(multiParte);

 		// Se envia el correo.

 		try {
 			t.sendMessage(message, message.getAllRecipients());
 			
 		}catch(javax.mail.SendFailedException a) {
 		}




} catch (Exception e) {        
   
}

}
	

}
