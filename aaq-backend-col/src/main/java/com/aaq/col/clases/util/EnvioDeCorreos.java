package com.aaq.col.clases.util;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.scheduling.annotation.Async;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.CorreoPolizaAgente;
import com.aaq.col.clases.database.entidades.HistoricoResumenAjustador;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.pojo.ReportePadre;
import com.aaq.col.clases.database.entidades.pojo.ReporteResumenAjus;
import com.aaq.col.clases.path.ProveedorApplicationContext;
import com.aaq.col.clases.siica.JMConstantes;
import com.jmfg.jmlib.sistema.classes.web.spring.JMProveedorApplicationContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class EnvioDeCorreos {
		
		Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");
		
		//********Nuevo método para el envio de correo de resumen ajustador**********
		
		@Async
		public void notificacionTerminoAtencionAgente(String reporte, String claveAjustador, String poliza, String claveAgente ) {
		try {
			String actividad = "Insertar Término";
			final Calendar cal = Calendar.getInstance();
			Date fechaFinal = cal.getTime();
			cal.add(Calendar.DATE, -2 );
			Date fechaInicial = cal.getTime();
			String ruta = null;

			try {
				this.loggerAvisos.info("PATH UNO: "+ProveedorApplicationContext.getApplicationContext().getResource("/").getFile().getPath());
			} catch (Exception e) {}
			
			try {
				this.loggerAvisos.info("PATH DOS: "+ProveedorApplicationContext.getApplicationContext().getResource("/").getFile().getPath());
			} catch (Exception e) { }
			
			try {	
				this.loggerAvisos.info("Obtener path de carpeta WEB-INF -> Primer Intento");
				ruta = JMProveedorApplicationContext.getApplicationContext().getResource("/WEB-INF").getFile().getPath() + "/";
			} catch (Exception e) {
					this.loggerAvisos.error("Ocurrio una excepcion en el primer intento -> "+e);
					this.loggerAvisos.info("Obtener path de carpeta WEB-INF -> Segundo Intento");
					ruta = ProveedorApplicationContext.getApplicationContext().getResource("/WEB-INF").getFile().getPath() + "/";
			}
			
			try {
				this.loggerAvisos.info("PATH METODO UNO ->"+ JMProveedorApplicationContext.getApplicationContext().getResource("/WEB-INF").getFile().getPath() );
				this.loggerAvisos.info("PATH METODO DOS ->: "+ProveedorApplicationContext.getApplicationContext().getResource("/WEB-INF").getFile().getPath() );
			} catch (Exception e) {
//				this.loggerAvisos.error("Ocurrio un error al obtener path: "+e);
			}
			
			this.loggerAvisos.info("RUTA DE LA CARPETA PARA AVISOS: "+ruta);
					
				List<ReporteResumenAjus> reportesResumenes= new ArrayList<ReporteResumenAjus>();
				List<HistoricoResumenAjustador> resumens = new ArrayList<HistoricoResumenAjustador>();
				
				Map<String, String> titulos = new HashMap<String, String>();
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");	
				if(fechaFinal!=null && fechaInicial!=null)
					titulos.put("titulo1", "Fecha de: "+df.format(fechaInicial)+" al "+df.format(fechaFinal));
				if(reporte!=null)
					titulos.put("titulo2","Reporte: "+reporte);
				
				try {
					resumens = HistoricoResumenAjustador.getHistoricoResumenAjustadorService().listaDeHistoricoResumenAjustador(reporte, claveAjustador, actividad, fechaInicial, fechaFinal);
					}catch (Exception e) {
						this.loggerAvisos.info("Ocurrio un error: "+e);
					}
				
//				log.info("Tamaño de la lista HistoricoResumenAjustador: "+resumens.size());
				
				this.loggerAvisos.info("Tamaño de la lista HistoricoResumenAjustador: "+resumens.size());
				if (resumens !=  null) {
					if (resumens.size() > 0) {
						for (HistoricoResumenAjustador historicoResumenAjustador : resumens) {
							
							List<HistoricoResumenAjustador> resultado = 
									HistoricoResumenAjustador.getHistoricoResumenAjustadorService().listaDeHistoricoResumenAjustador(historicoResumenAjustador.getGeneralNumeroReporte());
							ReporteResumenAjus datosParseados=HistoricoResumenAjustador.getHistoricoResumenAjustadorService().parseaDatos(resultado,historicoResumenAjustador.getGeneralNumeroReporte(),ruta);
							if(datosParseados!=null) {
								reportesResumenes.add(datosParseados);				
							}
							
						}
						
						this.generaPDFEnviaCorreoAgente(reportesResumenes, titulos, ruta, reporte, null, poliza, claveAgente);
					}
				}
			}	catch (Exception e) {
				this.loggerAvisos.info("Ocurrio un error -> notificacionTerminoAtencionAgente -> "+e);
				this.loggerAvisos.error(e.getMessage());
			}
		}		
			
		private void generaPDFEnviaCorreoAgente(List<ReporteResumenAjus> datos,Map<String, String> titulos,String ruta, String numeroReporte,
				String correo, String poliza, String claveAgente) throws JRException{
			
			byte[] arr = null;
			JasperReport reporte = null;
			ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
			String asunto = "CONCLUSIÓN "+"REPORTE: "+ numeroReporte;

				reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta+"ajustador.jasper");
			
			
			Map<String, Object> map= new HashMap<String,Object>();
			map.put("prestador", ""+"");
			map.put("titulo1", titulos.get("titulo1"));
			map.put("titulo2", titulos.get("titulo2")!=null?titulos.get("titulo2"):"");
			map.put("titulo3", titulos.get("titulo3")!=null?titulos.get("titulo3"):"");
			map.put("path", ruta);
			
			List<ReporteResumenAjus> reportes=null;
			
			List<ReportePadre> reportePadre=new ArrayList<ReportePadre>();
			
			for (ReporteResumenAjus reporteResumenAjus : datos) {
				if(reporteResumenAjus.getReporte()!=null){
				reportes= new ArrayList<ReporteResumenAjus>();
				reportes.add(reporteResumenAjus);
				reportePadre.add(new ReportePadre(new JRBeanCollectionDataSource(reportes)) );
				}
			}
			
			JRDataSource reportePadreSource=new JRBeanCollectionDataSource(reportePadre);
			JasperPrint jasperPrint = null;
		
				jasperPrint = JasperFillManager.fillReport(reporte, map,reportePadreSource);
		
				
			//Export PDF
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
			
			exporter.exportReport();
			
				//Buscamos por poliza	
				List<CorreoPolizaAgente> correosPolizas	= null;
				if (poliza != null) {
					this.loggerAvisos.info("Poliza: "+poliza+" del reporte "+numeroReporte);	
					correosPolizas	= CorreoPolizaAgente.getCorreoPolizaAgenteService().listaDeCorreoPolizaAgente(poliza, null);
					this.loggerAvisos.info("Contenido al recorrer lista CorreoPolizaAgente con poliza :"+correosPolizas.size());
				}
				
				//Se añade logica para verificar si no existe Poliza, exista Clave Agente
				List<CorreoPolizaAgente> correosAgentes  =  null;
				if (claveAgente != null) {
					this.loggerAvisos.info("Clave Agente: "+claveAgente+" del reporte "+numeroReporte);
					correosAgentes = CorreoPolizaAgente.getCorreoPolizaAgenteService().listaDeCorreoPolizaAgente(null, claveAgente);
				   this.loggerAvisos.info("Contenido de lista CorreoPolizaAgente con correos Agentes: "+correosAgentes.size());
				}
			
			
			String [] listaCorreos = null;		
			ArrayList<String> correos = new ArrayList<String>();
			
			try {
				if(poliza != null) {
					if(correosPolizas.size() > 0 ) {
						for (CorreoPolizaAgente correoPolizaAgente : correosPolizas) {
							listaCorreos = correoPolizaAgente.getCorreos().split(",");
							for(int i = 0; i < listaCorreos.length; i++) {
								correos.add(listaCorreos[i]);
							}
						}
						this.loggerAvisos.info("Tamaño de lista de correos con poliza " + listaCorreos.length);
						
					} else {
						this.loggerAvisos.info("No se econtraron correos para el reporte: "+numeroReporte+" con poliza: "+poliza);
						return ;
					}
				}
				if(claveAgente != null) {
					if (correosAgentes.size() > 0) {
						for (CorreoPolizaAgente correoPolizaAgente : correosAgentes) {
							listaCorreos = correoPolizaAgente.getCorreos().split(",");
							for(int i = 0; i < listaCorreos.length; i++) {
								correos.add(listaCorreos[i]);
							}
						}
					this.loggerAvisos.info("Tamaño de lista de correos con clave agente " + listaCorreos.length);
					} else {
						this.loggerAvisos.info("No se encontraron correos para el reporte: "+numeroReporte+" con clave agente: "+claveAgente);
						return;
					}
				}
			}catch (Exception e) {
					this.loggerAvisos.error("Ocurrio un error al recorrer recorrer los correos -> "+e.getMessage());
				}
			
			
			if (StringUtils.isNotBlank(correo)) {
				correos.add(correo);
			}
					
			if(baos!=null){
			    arr = baos.toByteArray();
			}		
			
			String cuerpoCorreo  = this.cuerpoNotificacionCorreoAgente(numeroReporte);
			
//			this.loggerAvisos.info("Tamaño de arr: "+arr.length);
			if(arr.length != 0) {
				this.loggerAvisos.info("Correos para el envio de PDF -> "+correos);
				this.loggerAvisos.info("Asunto del correo: "+asunto);
				try {
					CorreoFirmaImagAsync correoFirmaImagAsyncObj = new CorreoFirmaImagAsync(
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
							Configuracion.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
							Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
							Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
							true);
					try {
					correoFirmaImagAsyncObj.enviarEmailAsync(correos,  asunto,  cuerpoCorreo, arr,"resumen-ajustador.pdf", numeroReporte, ruta, false, true, true);
					}catch (Exception e) {
						this.loggerAvisos.info("Ocurrio un error an invocar el metodo correoFirmaImagAsyncObj.enviarEmailAsync: "+e);
					}
				}catch (Exception e) {
					this.loggerAvisos.info("Ocurrio un error CorreoFirmaImagAsync -> "+e);
		        	}
			}
			
			
		}
		private String cuerpoNotificacionCorreoAgente ( String numeroReporte ) {
			ReporteMovilSac reporteMovilSac = null;
			String cuerpoCorreo = null;
			
				DateFormat writeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				reporteMovilSac = ReporteMovilSac.getReporteMovilSacService().objetoReporteMovilSac(numeroReporte, null);
				
				if ( reporteMovilSac != null ) { 

					cuerpoCorreo = "<div><center>\r\n" + 
							"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 31px; font-weight: 600;\">QUÁLITAS COMPAÑÍA DE SEGUROS S.A. DE C.V.</div>\r\n" + 
							"<div style=\"color: #008c99; font-size: 31px; font-weight: 900;\">&nbsp;</div>\r\n" + 
							"</center>\r\n" + 
							"<div>\r\n" + 
							"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 22.0pt; font-family: Arial,sans-serif; color: #148c9a;\"> Notificación </span> </strong></p>\r\n" + 
							"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 22.0pt; font-family: Arial,sans-serif; color: #ae1985;\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;de Termino de la Atención.</span> </strong></p>\r\n" + 
							"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
							"<p style=\"margin: 0cm;\"><strong> <span style=\"font-family: Arial,sans-serif; color: #91167f;\"> Estimado Agente: </span> </strong></p>\r\n" + 
							"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
							"<table style=\"border-collapse: collapse; border: none;\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
							"<tbody>\r\n" + 
							"<tr>\r\n" + 
							"<td style=\"border: none; background: #E1F2F4; padding: 10pt 10pt 10pt 10pt; border-radius: 3%;\" valign=\"top\">\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\">A continuación nos permitimos adjuntar archivo con el detalle de la información del siniestro"+
							", una vez que nuestro ajustador concluyó con su atención\r\n" + 
							"\r\n" + 
							"<!-- o ignored --></p>\r\n" +  
							"</td>\r\n" + 
							"</tr>\r\n" + 
							"</tbody>\r\n" + 
							"</table>\r\n" + 
							"<p style=\"margin: 0cm;\">&nbsp;</p>\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Numero de Reporte asignado:&nbsp; </span> "+reporteMovilSac.getGeneralNumeroReporte() +"</p>\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Fecha y hora de arribo:&nbsp;&nbsp; </span> "+ writeFormat.format(  reporteMovilSac.getFechaArribo() )+" </p>\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Tipo de siniestro:&nbsp;&nbsp; </span> "+ reporteMovilSac.getAjusteCodigoCausa() +"</p>\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Nombre del conductor:&nbsp; </span>"+ reporteMovilSac.getConductorNombre()+"</p>\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Teléfono Lugar:&nbsp; </span>"+ reporteMovilSac.getConductorTelefonoContacto()+"</p>\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Localidad donde ocurrió:&nbsp; </span>"+ reporteMovilSac.getUbicacionColoniaDesc() +", " + reporteMovilSac.getUbicacionMunicipio() + ", " + reporteMovilSac.getUbicacionEntidad() +"</p>\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Vehículo:&nbsp; </span>"+ reporteMovilSac.getVehiculoMarca() +"</p>\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Modelo:&nbsp; </span>"+ reporteMovilSac.getVehiculoModelo() +"</p>\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Placas:&nbsp; </span>"+ reporteMovilSac.getVehiculoPlacas() +"</p>\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Num. Serie:&nbsp; </span>"+reporteMovilSac.getVehiculoSerie() +"</p>\r\n" + 
							"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Agente:&nbsp; </span>"+reporteMovilSac.getClaveAgente()+"</p>\r\n" + 
							"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
							"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
							"<center>\r\n" + 
							"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
							"<p style=\"margin: 0cm;\"><img src='cid:firmaCorreo'></p>\r\n" +
							"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" +
							"<div style=\"font-family: Arial,sans-serif; color: #808080; font-size: 12px; font-weight: 600;\">En caso de dudas o comentarios, favor de contactar a su Ejecutivo de Cuenta.<br />LINEA DE ATENCI&Oacute;N TELEF&Oacute;NICA 01 800 062 3212</div>\r\n" + 
							"</center>\r\n" + 
							"<p><!-- o ignored -->&nbsp;</p>\r\n" + 
							"</div>\r\n" + 
							"</div>";
					
					return cuerpoCorreo;
				}
				
			return cuerpoCorreo;
			
		}
		


}
