package com.aaq.col.clases.util;

import java.io.IOError;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.pojo.notificacion.EnviarNotificacionesReconocimiento;
import com.aaq.col.clases.siica.JMConstantes;

public class EnviarNotificacionR {

	public Log log = LogFactory.getLog(EnviarNotificacionR.class);
	Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");
	
	
	//********Nuevo método para el envio de correo de resumen ajustador**********
	public boolean  enviarNotificacionReconocimiento(EnviarNotificacionesReconocimiento entrada)  {
	try {
		String asunto = "Aviso de Reconocimiento de Identidad en Crucero";
		ArrayList<String> correos = new ArrayList<String>();
		
		try {
		// Aqui va la busqueda de los correos
		correos.add("arpadilla@qualitas.com.mx");
		correos.add("mvdiaz@qualitas.com.mx");
		correos.add("verificaciones12@qualitas.com.mx");
		correos.add("verificaciones04@qualitas.com.mx");
//		Verificaciones12@qualitas.com.mx
//		Verificaciones04@qualitas.com.mx
//		mvdiaz@qualitas.com.mx

//		correos.add("jpestrategica6@qualitas.com.mx");
		
		}catch (IndexOutOfBoundsException | IOError e) {
			log.info("Ocurrio un error: "+e);
			this.loggerAvisos.info("Ocurrio un error al recorrer recorrer los correos -> "+e.getMessage());
		}
		
		
		String cuerpoCorreo  = this.cuerpoNotificacionCorreo(entrada);
		if(correos.size() != 0) {
			try {
				NotificacionReconocimiento correoNotifRecon = new NotificacionReconocimiento(
						Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
						Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
						Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
						Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
						Configuracion.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
						Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
						Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
						true);
				try {
				boolean respuesta = correoNotifRecon.enviarEmailAsync(correos,  asunto,  cuerpoCorreo, entrada.getReporte());
				return respuesta;
				}catch (Exception e) {
					this.loggerAvisos.info("Ocurrio un error an invocar el metodo NotificacionReconocimiento "+e);
					return false;
				}
			}catch (Exception e) {
				this.loggerAvisos.info("Ocurrio un error CorreoFirmaImagAsync -> "+e);
				return false;
	        	}
		}
		}	catch (Exception e) {
			this.loggerAvisos.info("Ocurrio un error -> notificacionTerminoAtencionAgente -> "+e);
			return false;
		}
	return false;
	}
	
	private String cuerpoNotificacionCorreo ( EnviarNotificacionesReconocimiento entrada ) {
		
			String cuerpoCorreo = null;
			if ( entrada != null ) { 
				String datosAfectado = this.añadirAfectado(entrada);
				String similitudReportes = this.reporteSimilitud(entrada);
				String tercero = this.cuerpoTerceros(entrada);
				String porcentaje = this.porcentaje(entrada);
				
				cuerpoCorreo = "<div><center>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<p style=\"margin: 0cm;\"><img src='cid:logoQualitas'></p>\r\n" +
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" +
						
						"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 31px; font-weight: 600;\">QUÁLITAS COMPAÑÍA DE SEGUROS S.A. DE C.V.</div>\r\n" + 
						"<div style=\"color: #008c99; font-size: 31px; font-weight: 900;\">&nbsp;</div>\r\n" + 
						"</center>\r\n" + 
						"<div>\r\n" + 
						"<table style=\"border-collapse: collapse; border: none;\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
						"<tbody>\r\n" + 
						"<tr>\r\n" + 
						"<td style=\"border: none; background: #E1F2F4; padding: 10pt 10pt 10pt 10pt; border-radius: 3%;\" valign=\"top\">\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\">Se ha detectado un reconocimiento de identidad"+porcentaje+" en el reporte "+entrada.getReporte()+". "+similitudReportes+" La información es la siguiente:"+
						" \r\n" + 
						"\r\n" + 
						"<!-- o ignored --></p>\r\n" +  
						"</td>\r\n" + 
						"</tr>\r\n" + 
						"</tbody>\r\n" + 
						"</table>\r\n" + 
						
						"<p style=\"margin: 0cm;\">&nbsp;</p>\r\n" + 
						datosAfectado+ tercero+
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<center>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<p style=\"margin: 0cm;\"><img src='cid:firmaCorreo'></p>\r\n" +
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" +
						"<div style=\"font-family: Arial,sans-serif; color: #808080; font-size: 12px; font-weight: 600;\">Favor de no responder sobre el mismo correo.</div>\r\n" + 
						"</center>\r\n" + 
						"<p><!-- o ignored -->&nbsp;</p>\r\n" + 
						"</div>\r\n" + 
						"</div>";
				return cuerpoCorreo;
			}
		return cuerpoCorreo;
	}

	private String añadirAfectado(EnviarNotificacionesReconocimiento entrada) {
		String cuerpoAfectado= "";
		if (entrada.getAsegurado() != null) {
			cuerpoAfectado =  "<p style=\"margin: 0cm;\">&nbsp;</p>\r\n <p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #008c99;\">Asegurado:&nbsp; </span> </p>\r\n";
					if (entrada.getAsegurado().getPoliza() != null) {
						cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Numero de poliza:&nbsp; </span> "+entrada.getAsegurado().getPoliza()+"</p>\r\n";
					}
					if (entrada.getAsegurado().getInciso() != null) {
						cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Numero de inciso:&nbsp; </span> "+entrada.getAsegurado().getInciso()+"</p>\r\n";
					}
					cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Tipo de afectado:&nbsp;&nbsp; </span> "+"Asegurado" +" </p>\r\n"; 
					if (entrada.getAsegurado().getNombre() != null) {
						cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Nombre:&nbsp; </span> "+entrada.getAsegurado().getNombre()+"</p>\r\n";
					}
					if (entrada.getAsegurado().getVehiculoDescripcion() != null) {
						cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Vehiculo Descripcion:&nbsp; </span> "+entrada.getAsegurado().getVehiculoDescripcion()+"</p>\r\n";
					}
					if (entrada.getAsegurado().getVehiculoPlacas() != null) {
						cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Vehiculo Placas:&nbsp; </span> "+entrada.getAsegurado().getVehiculoPlacas()+"</p>\r\n" ;
					}
					if (entrada.getAsegurado().getVehiculoSerie() != null) {
						cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Vehiculo Serie:&nbsp; </span> "+entrada.getAsegurado().getVehiculoSerie()+"</p>\r\n";
					}
					if (entrada.getAsegurado().getTipoIdentificacion() != null) {
						cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Tipo Identificacion:&nbsp; </span> "+entrada.getAsegurado().getTipoIdentificacion()+"</p>\r\n";
					}
					cuerpoAfectado = cuerpoAfectado +"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" ;
		}
		return cuerpoAfectado;
	}
	
	private String cuerpoTerceros(EnviarNotificacionesReconocimiento entrada) {
		String retorno = "";
		if (entrada.getTerceros() != null && entrada.getTerceros().size() > 0) {
			for (int i = 0; i < entrada.getTerceros().size(); i++) {
				String cuerpoAfectado= "";
				cuerpoAfectado = "<p style=\"margin: 0cm;\">&nbsp;</p>\r\n <p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #008c99;\">Tercero:&nbsp; </span> </p>\r\n";
						if (entrada.getTerceros().get(i).getPoliza() != null) {
							cuerpoAfectado = cuerpoAfectado +"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Numero de poliza:&nbsp; </span> "+entrada.getTerceros().get(i).getPoliza()+"</p>\r\n";
						}
						if (entrada.getTerceros().get(i).getInciso() != null) {
							cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Numero de inciso:&nbsp; </span> "+entrada.getTerceros().get(i).getInciso()+"</p>\r\n" ;
						}
						try {
							if (entrada.getTerceros().get(i).getTipoAfectado() >= 0) {
								cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Tipo de afectado:&nbsp;&nbsp; </span> "+"Tercero "+entrada.getTerceros().get(i).getTipoAfectado()+" </p>\r\n" ;
							} 
						} catch (Exception e) {
						}
						if (entrada.getTerceros().get(i).getNombre() != null) {
							cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Nombre:&nbsp; </span> "+entrada.getTerceros().get(i).getNombre()+"</p>\r\n" ;
						} 
						if (entrada.getTerceros().get(i).getVehiculoDescripcion() != null) {
							cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Vehiculo Descripcion:&nbsp; </span> "+entrada.getTerceros().get(i).getVehiculoDescripcion()+"</p>\r\n" ;
						}
						if (entrada.getTerceros().get(i).getVehiculoPlacas() != null) {
							cuerpoAfectado = cuerpoAfectado +"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Vehiculo Placas:&nbsp; </span> "+entrada.getTerceros().get(i).getVehiculoPlacas()+"</p>\r\n" ;
						}
						if (entrada.getTerceros().get(i).getVehiculoSerie() != null) {
							cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Vehiculo Serie:&nbsp; </span> "+entrada.getTerceros().get(i).getVehiculoSerie()+"</p>\r\n" ;
						}
						if (entrada.getTerceros().get(i).getTipoIdentificacion() != null) {
							cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Tipo Identificacion:&nbsp; </span> "+entrada.getTerceros().get(i).getTipoIdentificacion()+"</p>\r\n";
						}
						cuerpoAfectado = cuerpoAfectado + "<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" ;
						retorno = retorno + cuerpoAfectado;
			}
		
		}
		return retorno;
		
	}
	private String reporteSimilitud(EnviarNotificacionesReconocimiento entrada) {
		String valor = "";
		String reportes = "";
		if (entrada.getReporteSimilitud() != null && entrada.getReporteSimilitud().size() > 0) {
			valor =  "Tiene coincidencia con los números de reportes: ";
			for (int i = 0; i < entrada.getReporteSimilitud().size(); i++) {
				reportes =  reportes + entrada.getReporteSimilitud().get(i)+ ", ";
			}
		valor = valor + StringUtils.removeEnd(reportes, ", ")+".";
		}
		return valor;
	}
	
	private String porcentaje(EnviarNotificacionesReconocimiento entrada) {
		String valor = "";
		if (entrada.getAsegurado() != null ) {
			if (entrada.getAsegurado().getPorcentajeSimilitud() != null) {
				valor =  " con un porcentaje de similitud "+entrada.getAsegurado().getPorcentajeSimilitud();
			}
			
		}
		return valor;
	}
	
	//********Nuevo método para el envio de correo de resumen ajustador**********
		public boolean  enviarNotificacionPagosMultiples(EnviarNotificacionesReconocimiento entrada)  {
		try {
			String asunto = "Aviso de Reconocimiento de Identidad en Pagos Múltiples";
			ArrayList<String> correos = new ArrayList<String>();
			
			try {
			// Aqui va la busqueda de los correos
			correos.add("arpadilla@qualitas.com.mx");
//			correos.add("verificaciones12@qualitas.com.mx");
//			correos.add("verificaciones04@qualitas.com.mx");
			correos.add("mvdiaz@qualitas.com.mx");

//			correos.add("jpestrategica6@qualitas.com.mx");
//			correos.add("fanny.diaz@smartkode.mx");
			
			}catch (IndexOutOfBoundsException | IOError e) {
				log.info("Ocurrio un error: "+e);
				this.loggerAvisos.info("Ocurrio un error al recorrer recorrer los correos -> "+e.getMessage());
			}
			
			
			String cuerpoCorreo  = this.cuerpoNotificacionCorreo(entrada);
			if(correos.size() != 0) {
				try {
					NotificacionReconocimiento correoNotifRecon = new NotificacionReconocimiento(
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
							Configuracion.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
							Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
							Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
							true);
					try {
					boolean respuesta = correoNotifRecon.enviarEmailAsync(correos,  asunto,  cuerpoCorreo, entrada.getReporte());
					return respuesta;
					}catch (Exception e) {
						this.loggerAvisos.info("Ocurrio un error an invocar el metodo NotificacionReconocimiento "+e);
						return false;
					}
				}catch (Exception e) {
					this.loggerAvisos.info("Ocurrio un error CorreoFirmaImagAsync -> "+e);
					return false;
		        	}
			}
			}	catch (Exception e) {
				this.loggerAvisos.info("Ocurrio un error -> notificacionTerminoAtencionAgente -> "+e);
				return false;
			}
		return false;
		}
	
}
