package com.aaq.col.clases.util;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.siica.JMConstantes;


public class ConectarSMTP {
	
	  public Properties props = new Properties();
	  public Session session = Session.getDefaultInstance(props, null);
	  public Transport t;
	  
	  private static final ConfiguracionServiceInterfase configuracionDao = Configuracion.getConfiguracionService();
	  
	  public ConectarSMTP ()  {
		 try {
		  String protocol=ConectarSMTP.configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA) ? "smtps" : "smtp";
		try {
			    props.setProperty("mail.debug", ConectarSMTP.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG));
			    props.setProperty("mail." + protocol + ".user", ConectarSMTP.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO));
			    props.setProperty("mail." + protocol + ".host", ConectarSMTP.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST));
			    props.setProperty("mail." + protocol + ".port", ConectarSMTP.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO));
			    props.setProperty("mail." + protocol + ".connectiontimeout", "30000");
			    props.setProperty("mail." + protocol + ".timeout", "30000");
			    props.setProperty("mail." + protocol + ".from", ConectarSMTP.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL));
			    props.setProperty("mail." + protocol + ".auth", ConectarSMTP.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN));
			    props.setProperty("mail." + protocol + ".ssl.enable", ConectarSMTP.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA));
			    props.setProperty("mail." + protocol + ".ssl.checkserveridentity", "false");
			    props.setProperty("mail." + protocol + ".ssl.trust", "*");
			    if(ConectarSMTP.configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_OP_FTP_MAIL_ENABLE)) {
			    props.setProperty("mail."+protocol+".starttls.enable", "true");
			    }
		}catch(Exception e ) {
		}
       
        try {
        t = session.getTransport(protocol);           
        t.connect(ConectarSMTP.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL), ConectarSMTP.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD)); // ESTA SE DESCOMENTA
        }catch(Exception e ) {
        	
        	
        }
		 }catch(Exception e) {
			 
			 
		 }
	}

}
