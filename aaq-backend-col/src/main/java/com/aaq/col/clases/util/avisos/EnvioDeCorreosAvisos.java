package com.aaq.col.clases.util.avisos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.InputStream;
import org.castor.util.Base64Decoder;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.dao.DataAccessException;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionSystemException;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.CorreoPolizaAgente;
import com.aaq.col.clases.database.entidades.HistoricoResumenAjustador;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.path.ProveedorApplicationContext;
import com.aaq.col.clases.pojo.conclusion.Abogado;
import com.aaq.col.clases.pojo.conclusion.Coberturas;
import com.aaq.col.clases.pojo.conclusion.ConclusionAjustador;
import com.aaq.col.clases.pojo.conclusion.DatosCorreo;
import com.aaq.col.clases.pojo.conclusion.Grua;
import com.aaq.col.clases.pojo.conclusion.PaseMedico;
import com.aaq.col.clases.pojo.conclusion.ReporteResumenAjustN;
import com.aaq.col.clases.pojo.conclusion.ServiciosDiversos;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.CorreoFirmaImagAsync;
import com.aaq.col.clases.util.DecimalFormatoUtil;
import com.aaq.col.clases.util.HoraConsultaUtil;
import com.jmfg.jmlib.sistema.classes.web.spring.JMProveedorApplicationContext;
//import com.jmfg.siicaserver.system.classes.pojo.aaq.EnviarWhatsApp;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class EnvioDeCorreosAvisos {
	
	
	Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");
	
	//********Nuevo método para el envio de correo de resumen ajustador**********
	
	@Async
	public void notificacionTerminoAtencionAgente(String reporte, Terminal term, String poliza, String claveAgente, String cedulaAjustador, boolean equipoPesado, String correoAsegurado) {
	try {
		String actividad = "Insertar Término";
		final Calendar cal = Calendar.getInstance();
		Date fechaFinal = cal.getTime();
		cal.add(Calendar.DATE, -2 );
		Date fechaInicial = cal.getTime();
		String ruta = null;

		try {
			this.loggerAvisos.info("PATH: "+ProveedorApplicationContext.getApplicationContext().getResource("/").getFile().getPath());
		} catch (Exception e) { }
		
		try {	
			this.loggerAvisos.info("Obtener path de carpeta WEB-INF -> Primer Intento");
			ruta = JMProveedorApplicationContext.getApplicationContext().getResource("/conclusion").getFile().getPath() + "/";
		} catch (Exception e) {
				this.loggerAvisos.error("Ocurrio una excepcion en el primer intento -> "+e);
				this.loggerAvisos.info("Obtener path de carpeta WEB-INF -> Segundo Intento");
				ruta = ProveedorApplicationContext.getApplicationContext().getResource("/conclusion").getFile().getPath() + "/";
		}
		
		this.loggerAvisos.info("RUTA DE LA CARPETA PARA AVISOS: "+ruta);
				
			List<HistoricoResumenAjustador> resumens = new ArrayList<HistoricoResumenAjustador>();
			try {
				resumens = HistoricoResumenAjustador.getHistoricoResumenAjustadorService().listaDeHistoricoResumenAjustador(reporte, term.getNumeroproveedor(), actividad, fechaInicial, fechaFinal);
				}catch (Exception e) {
					this.loggerAvisos.info("Ocurrio un error: "+e);
				}
			
			
			this.loggerAvisos.info("Tamaño de la lista HistoricoResumenAjustador: "+resumens.size());
			if (resumens !=  null) {
				if (resumens.size() > 0) {
					this.generaPDFEnviaCorreoAgente(ruta, reporte, poliza, claveAgente, term, cedulaAjustador, equipoPesado, correoAsegurado );
				}
			}
		}	catch (Exception e) {
			this.loggerAvisos.info("Ocurrio un error -> notificacionTerminoAtencionAgente -> "+e);
			this.loggerAvisos.error(e.getMessage());
		}
	return;
	}		
		
	private void generaPDFEnviaCorreoAgente(String ruta, String numeroReporte, String poliza, String claveAgente, Terminal term, String cedulaAjustador, boolean equipoPesado, String correoAsegurado) throws JRException{
		
		byte[] arr = null;
		JasperReport reporte = null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
		String asunto = "CONCLUSIÓN "+"REPORTE: "+ numeroReporte;
		
		List<HistoricoResumenAjustador> resultado = new ArrayList<HistoricoResumenAjustador>();
		ReporteResumenAjustN datosParseados = new ReporteResumenAjustN();
		boolean band = false;
		
		try {
			 resultado = HistoricoResumenAjustador.getHistoricoResumenAjustadorService().listaDeHistoricoResumenAjustador(numeroReporte);
		}  catch (final NoResultException | RollbackException e) {
			this.loggerAvisos.error("Ocurrio un error en listaDeHistoricoResumenAjustador: "+e);
		} catch (final IllegalArgumentException e) {
			this.loggerAvisos.error("Ocurrio un error en listaDeHistoricoResumenAjustador: "+e);
		} catch (final IllegalStateException | TransactionSystemException e) {
			this.loggerAvisos.error("Ocurrio un error en listaDeHistoricoResumenAjustador: "+e);
		} catch (final PersistenceException  | TransactionException e) {
			this.loggerAvisos.error("Ocurrio un error en listaDeHistoricoResumenAjustador: "+e);
		}
		
		datosParseados = HistoricoResumenAjustador.getHistoricoResumenAjustadorService().parseaDatosN(resultado, numeroReporte,ruta, term.getNumeroproveedor(), equipoPesado );
			
			Map<String, Object> titulos = new HashMap<String, Object>();
			titulos.put("path", ruta);
			titulos.put("ajustador" , datosParseados.getAjustador());
			titulos.put("croquis" , datosParseados.getCroquis());
			titulos.put("cedulaAjustador" , cedulaAjustador);
			titulos.put("narracion" , datosParseados.getNarracion() );
			titulos.put("deslindeResponsabilidad" , datosParseados.getDeslindeResponsabilidad() );
			titulos.put("claveAgente" , datosParseados.getClaveAgente() );
			titulos.put("nombreAsegurado" ,  datosParseados.getNombreAsegurado());
			titulos.put("poliza" , datosParseados.getPoliza());
			titulos.put("marca" , datosParseados.getMarca() );
			titulos.put("correoAsegurado" , datosParseados.getCorreoAsegurado() );
			titulos.put("inciso" , datosParseados.getInciso());
			titulos.put("modelo" , datosParseados.getModelo() );
			titulos.put("nombreConductor" , datosParseados.getNombreConductor() );
			titulos.put("vehiculoSerie" , datosParseados.getVehiculoSerie() );
			titulos.put("placas" , datosParseados.getPlacas() );
			titulos.put("color" ,datosParseados.getColor() );
			titulos.put("fechaOcurrido", datosParseados.getFechaOcurrido());
			titulos.put("reporte" , numeroReporte );
			titulos.put("fechaAsig", datosParseados.getFechaAsig());
			titulos.put("codigoCausa", datosParseados.getCodigoCausa() );
			titulos.put("fechaTermino", datosParseados.getFechaTermino());
			titulos.put("fechaArribo", datosParseados.getFechaArribo());
			titulos.put("ubicacionSiniestro", datosParseados.getUbicacionSiniestro() );
			titulos.put("colonia" , datosParseados.getColonia());
			titulos.put("ciudad" , datosParseados.getCiudad() );
			titulos.put("coberturasD" , datosParseados.getCoberturasD());
			if (equipoPesado) {
				titulos.put("solicitarGruaEPD" , datosParseados.getSolicitarGruaEPD());
				if (datosParseados.getSolicitarGruaEP() != null) {
					if (datosParseados.getSolicitarGruaEP().size() > 0) {
						band = true;
					}
				}
			} else {
				titulos.put("solicitarGruaD" , datosParseados.getSolicitarGruaD());
				if (datosParseados.getSolicitarGrua() != null) {
					if (datosParseados.getSolicitarGrua().size() > 0) {
						band = true;
					}
				}
			}
			titulos.put("reparacionD" , datosParseados.getReparacionD());
			titulos.put("paseMedicoD", datosParseados.getPaseMedicoD());
			titulos.put("abogadosD", datosParseados.getAbogadosD());
			if (datosParseados.getAbogados() != null) {
				if (datosParseados.getAbogados().size() > 0) {
					band = true;
				}
			}
			//Nuevos
			titulos.put("munDeleg", datosParseados.getMunDeleg());
			titulos.put("numSiniestro", datosParseados.getNumSiniestro());
			titulos.put("firmaConductor", datosParseados.getFirmaConductor());
			titulos.put("causaAccidente", datosParseados.getCausaAccidente());
			titulos.put("responsabilidadTermino", datosParseados.getResponsabilidadTermino());
			titulos.put("docEntregados", datosParseados.getDocEntregados());
			titulos.put("nombreTitular", datosParseados.getNombreTitular());
			titulos.put("firmaConductorT", datosParseados.getFirmaConductorT());
			
			titulos.put("docDua", datosParseados.getDocDua());
			if (equipoPesado) {
				titulos.put("docAdmEquipoP", datosParseados.getDocAdmEquipoP());
			} else {
				titulos.put("docAdmAutos", datosParseados.getDocAdmAutos());
			}
			titulos.put("docAsigAbogado", datosParseados.getDocAsigAbogado());
			titulos.put("docEncuesta", datosParseados.getDocEncuesta());
			
			if (equipoPesado) {
				reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta+"equipoPesado.jasper");
			} else {
				reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta+"ajustadorNuevo.jasper");
			}
			
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, titulos , new JREmptyDataSource());
	
			
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
		
		if(baos!=null){
		    arr = baos.toByteArray();
		}		
		boolean bandUnificado = false;
		try {
		 bandUnificado = Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_NOTIF_CORREO_UNIFICADO);
		} catch (ClassCastException | RollbackException | IllegalArgumentException | IndexOutOfBoundsException e) {
			this.loggerAvisos.error("Error al obtener bandera de correoUnificado.",e);
		} catch (PersistenceException | DataAccessException e) {
			this.loggerAvisos.error("Error al obtener bandera de correoUnificado.",e);
		}
		
		if(arr.length != 0) {
			this.loggerAvisos.info("Correos para el envio de PDF -> "+correos);
			this.loggerAvisos.info("Asunto del correo: "+asunto);
			try {
			this.loggerAvisos.info("***bandUnificado***"+bandUnificado);
			
				if (bandUnificado) {
					String cuerpoCorreo  = "";
						cuerpoCorreo = this.cuerpoUnificadoCorreo();
						if (correos != null && correos.size() > 0) {
							correos.add(correoAsegurado);
						}
						CorreoConclusion correoFirmaImagAsyncObj = new CorreoConclusion(
						Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
						Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
						Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
						Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
						Configuracion.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
						Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
						Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
						true);
					try {
					correoFirmaImagAsyncObj.enviarEmailAsync(correos,  asunto,  cuerpoCorreo, arr,"resumen-ajustador.pdf",
							numeroReporte, ruta, band, true, false);
					}catch (Exception e) {
						this.loggerAvisos.info("Ocurrio un error an invocar el metodo correoFirmaImagAsyncObj.enviarEmailAsync: "+e);
					}
				} else { // ********** Correo Separados
					String cuerpoCorreoAgente  = "";
					cuerpoCorreoAgente  = this.cuerpoCorreoAgente(numeroReporte);
					//Enviar correo a Agentes
					CorreoConclusion correoFirmaImagAsyncObj = new CorreoConclusion(
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
							Configuracion.getConfiguracionService().obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
							Configuracion.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
							Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
							Configuracion.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
							true);
					try {
					correoFirmaImagAsyncObj.enviarEmailAsync(correos,  asunto,  cuerpoCorreoAgente, arr,"resumen-ajustador.pdf",
							numeroReporte, ruta, band, true, true);
					}catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | MailException e) {
						this.loggerAvisos.error("Ocurrio un error an invocar el metodo correoFirmaImagAsyncObj.enviarEmailAsync: ",e);
					}
					// Enviar Correo a Asegurado
					
					if (StringUtils.isNotBlank(correoAsegurado)) {
					ArrayList<String> correoA = new ArrayList<String>();	
					correoA.add(correoAsegurado);
						String cuerpoCorreoAsegurado = "";
						cuerpoCorreoAsegurado = this.cuerpoUnificadoCorreo();
					try {
					correoFirmaImagAsyncObj.enviarEmailAsync(correoA,  asunto,  cuerpoCorreoAsegurado, arr,"resumen-ajustador.pdf",
							numeroReporte, ruta, band, true, false);
					}catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | MailException e) {
						this.loggerAvisos.error("Ocurrio un error an invocar el metodo correoFirmaImagAsyncObj.enviarEmailAsync: ",e);
					}
					}
				}
			}catch (Exception e) {
				this.loggerAvisos.info("Ocurrio un error CorreoFirmaImagAsync -> "+e);
	        	}
			
			//************Enviar a QContent
			try {
				EnvioQContent qContent = new EnvioQContent();
			      byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);
			      this.loggerAvisos.info("pdf => "+pdf);
				qContent.envioToContent("FR05", numeroReporte, pdf, datosParseados.getPoliza());
			} catch (Exception e) {
				this.loggerAvisos.error("Ocurrio un error en EnvioQContent =>",e);
			}
		}
		
	}
	
	@SuppressWarnings("unused")
	private String infoReporteCorreo( ReporteMovilSac reporteMovilSac ) {
		/*
		<p> 
		<img src="imagen.gif" align="right">Texto tan extenso como queramos que cubrirá la parte izquierda de la imagen. Sigo poniendo texto para que se vea el efecto, Bla bla bla bla bla bla bla... 
		</p> */
		DateFormat writeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String cuerpoCorreo = "<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Numero de Reporte asignado:&nbsp; </span> "+reporteMovilSac.getGeneralNumeroReporte() +"</p>\r\n" + 
		"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Fecha y hora de arribo:&nbsp;&nbsp; </span> "+ writeFormat.format(  reporteMovilSac.getFechaArribo() )+" </p>\r\n" + 
		"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Tipo de siniestro:&nbsp;&nbsp; </span> "+ reporteMovilSac.getAjusteCodigoCausa() +"</p>\r\n" + 
		"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Nombre del conductor:&nbsp; </span>"+ reporteMovilSac.getConductorNombre()+"</p>\r\n" + 
		"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Teléfono Lugar:&nbsp; </span>"+ reporteMovilSac.getConductorTelefonoContacto()+"</p>\r\n" + 
		"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Localidad donde ocurrió:&nbsp; </span>"+ reporteMovilSac.getUbicacionColoniaDesc() +", " + reporteMovilSac.getUbicacionMunicipio() + ", " + reporteMovilSac.getUbicacionEntidad() +"</p>\r\n" + 
		"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Vehículo:&nbsp; </span>"+ reporteMovilSac.getVehiculoMarca() +"</p>\r\n" + 
		"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Modelo:&nbsp; </span>"+ reporteMovilSac.getVehiculoModelo() +"</p>\r\n" + 
		"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Placas:&nbsp; </span>"+ reporteMovilSac.getVehiculoPlacas() +"</p>\r\n" + 
		"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Num. Serie:&nbsp; </span>"+reporteMovilSac.getVehiculoSerie() +"</p>\r\n" + 
		"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Agente:&nbsp; </span>"+reporteMovilSac.getClaveAgente()+"</p>\r\n" ;		
		return cuerpoCorreo;
	}

/*** CONCLUSION AVISO AJUSTADOR EXPRES ***/
	@Async
	public boolean notificacionTerminoAjustadorExpres(ConclusionAjustador datosExpres, Terminal terminal, ReporteMovilSac reporteSAC) throws JRException {
		try {
		byte[] arr = null;
		JasperReport reporte = null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
		String ruta = null;
		String asunto = "CONCLUSIÓN "+"REPORTE: "+ datosExpres.getNumeroReporte();

		try {
			this.loggerAvisos.info("PATH: "+ProveedorApplicationContext.getApplicationContext().getResource("/").getFile().getPath());
		} catch (Exception e) { 
			this.loggerAvisos.error("Ocurrio un error al obtener PATH: "+e);
			return false;
		}
		
		try {	
			ruta = ProveedorApplicationContext.getApplicationContext().getResource("/conclusion").getFile().getPath() + "/";
		} catch (Exception e) {
				this.loggerAvisos.error("Obtener path para Conclusion Ajustador Expres-> "+e);
				return false;
		}

		this.loggerAvisos.info("RUTA DE LA CARPETA PARA AVISOS: "+ruta);
		
		InputStream targetCroquis = null;
		if ( datosExpres.getCroquis() != null ) {
			String croquis = datosExpres.getCroquis().toString();
			if (croquis != null && !croquis.isEmpty()) {
				byte[] bytesCroquis = Base64Decoder.decode(croquis);
				targetCroquis = new ByteArrayInputStream(bytesCroquis);
			}
		}	

		InputStream targetFirmaConductor = null;
		InputStream targetFirmaConductorDeslinde = null;

		if (datosExpres.getFirmaConductor() != null ) {
			String firmaConductor = datosExpres.getFirmaConductor();
			if (firmaConductor != null && !firmaConductor.isEmpty()) {
				byte[] bytesFirmaC = Base64Decoder.decode(firmaConductor);
				targetFirmaConductor = new ByteArrayInputStream(bytesFirmaC);
			}
			
			String firmaConductorDeslinde = datosExpres.getFirmaConductor();
			if (firmaConductorDeslinde != null && !firmaConductorDeslinde.isEmpty()) {
				byte[] bytesFirmaCDeslinde = Base64Decoder.decode(firmaConductorDeslinde);
				targetFirmaConductorDeslinde = new ByteArrayInputStream(bytesFirmaCDeslinde);
			}
			
		}
		
			Map<String, Object> titulos = new HashMap<String, Object>();
			titulos.put("path", ruta);
			titulos.put("ajustador" , terminal.getNombre());
			titulos.put("croquis" ,targetCroquis);
			titulos.put("cedulaAjustador" , terminal.getCedulaAjustador());
			titulos.put("narracion" , datosExpres.getNarracion() );
			titulos.put("deslindeResponsabilidad" , datosExpres.getDeslindeResponsabilidad() );
			titulos.put("claveAgente" , datosExpres.getClaveAgente() );
			titulos.put("nombreAsegurado" ,  datosExpres.getNombreAsegurado());
			titulos.put("poliza" , datosExpres.getPoliza() );
			titulos.put("marca" , datosExpres.getVehiculoMarca());
			titulos.put("correoAsegurado" , datosExpres.getCorreoAsegurado() );
			titulos.put("inciso" , datosExpres.getInciso());
			titulos.put("modelo" , datosExpres.getVehiculoModelo());
			titulos.put("nombreConductor" , datosExpres.getNombreConductor() );
			titulos.put("vehiculoSerie" , datosExpres.getVehiculoSerie() );
			titulos.put("placas" , datosExpres.getVehiculoPlacas());
			titulos.put("color" , datosExpres.getVehiculoColor() );
			titulos.put("reporte" , datosExpres.getNumeroReporte() );
			titulos.put("codigoCausa", datosExpres.getCodigoCausa() ); // Esto se asigna en el termino Ajustador
			titulos.put("ubicacionSiniestro", datosExpres.getUbicacionSiniestro() );
			titulos.put("colonia" ,datosExpres.getColonia());
			titulos.put("ciudad" , datosExpres.getCiudad());
			titulos.put("munDeleg", datosExpres.getMunDeleg());
			titulos.put("numSiniestro", datosExpres.getNumSiniestro());
			titulos.put("firmaConductor", targetFirmaConductor);
			titulos.put("causaAccidente", datosExpres.getCausaAccidente());
			titulos.put("responsabilidadTermino", datosExpres.getResponsabilidadTermino()); // Aqui esta en veremos
			titulos.put("nombreTitular", datosExpres.getNombreConductor());
			titulos.put("firmaConductorT", targetFirmaConductorDeslinde);

			if (StringUtils.isNotBlank(datosExpres.getFechaOcurrido())) {
				HoraConsultaUtil utileria = new HoraConsultaUtil();
				Date fechaOcurrido = utileria.transformarFecha(datosExpres.getFechaOcurrido());
				titulos.put("fechaOcurrido", fechaOcurrido);
			}
			
			if (StringUtils.isNotBlank(datosExpres.getFechaAsignacion())) {
				HoraConsultaUtil utileria = new HoraConsultaUtil();
				Date fechaAsignacion = utileria.transformarFecha(datosExpres.getFechaAsignacion());
				titulos.put("fechaAsig", fechaAsignacion);
			}
			
			//Convertimos las fechas String a Date
			if (StringUtils.isNotBlank(datosExpres.getFechaTermino())) {
				HoraConsultaUtil utileria = new HoraConsultaUtil();
				Date horaTermino = utileria.transformarFecha(datosExpres.getFechaTermino());
				titulos.put("fechaTermino", horaTermino);
			}
			
			if (StringUtils.isNotBlank(datosExpres.getFechaArribo())) {
				HoraConsultaUtil utileria = new HoraConsultaUtil();
				Date fechaArribo = utileria.transformarFecha(datosExpres.getFechaArribo());
				titulos.put("fechaArribo", fechaArribo);
			}
			
			
			
			 if (datosExpres.getDocumentosEntregados() != null) {
					if (datosExpres.getDocumentosEntregados().size() > 0) {
						for (int i = 0; i < datosExpres.getDocumentosEntregados().size(); i++) {
							if (datosExpres.getDocumentosEntregados().get(i).contains("Formato Declaración Universal") || datosExpres.getDocumentosEntregados().get(i).contains("Formato Declaracion Universal")) {
								titulos.put("docDua", "Formato Declaración Universal");
							}
							if (datosExpres.getDocumentosEntregados().get(i).contains("Formato Admisión Autos") || datosExpres.getDocumentosEntregados().get(i).contains("Formato Admision Autos")) {
								titulos.put("docAdmAutos", "Formato Admisión Autos");
							}
							if (datosExpres.getDocumentosEntregados().get(i).contains("Formato Asignación Abogado") || datosExpres.getDocumentosEntregados().get(i).contains("Formato Asignacion Abogado")) {
								titulos.put("docAsigAbogado", "Formato Asignación Abogado");
							}
							if (datosExpres.getDocumentosEntregados().get(i).contains("Formato Encuesta Servicio")) {
								titulos.put("docEncuesta", "Formato Encuesta Servicio");
							}
						}
					}
				 }
			
			ServiciosDiversos servDiv = new ServiciosDiversos();
			
			DecimalFormatoUtil utileriaD = new DecimalFormatoUtil();
			List<Coberturas>  estimaciones = new ArrayList<>();
			if (datosExpres.getCoberturas() != null) {
				if (datosExpres.getCoberturas().size() > 0) {
					try {
						for (int i = 0; i < datosExpres.getCoberturas().size(); i++) {
							Coberturas cob = new Coberturas();
							cob.setClaveCobertura(datosExpres.getCoberturas().get(i).getClaveCobertura());
							cob.setDecClaveCobertura(datosExpres.getCoberturas().get(i).getDecClaveCobertura());
							cob.setMonto(utileriaD.obtenerCifra(datosExpres.getCoberturas().get(i).getMonto(), reporteSAC.getGeneralMonedaNombre()));
							estimaciones.add(cob);
						}
						servDiv.setCoberturas(estimaciones);
					} catch ( Exception e) {
						this.loggerAvisos.error("Exception en Coberturas: "+e);
					}
				}
			}
			
			titulos.put("coberturasD" , servDiv.getCoberturasD());
			
			if (datosExpres.getSolicitarGrua() != null) {
				if (datosExpres.getSolicitarGrua().size() > 0) {
					List<Grua> listaGruas = new ArrayList<>();
					HoraConsultaUtil utileria = new HoraConsultaUtil();
					for (int i = 0; i < datosExpres.getSolicitarGrua().size(); i++) {
						Grua grua = new Grua();
						try {
							grua.setFecha(utileria.transformarFecha(datosExpres.getSolicitarGrua().get(i).getFecha()));
						} catch (IndexOutOfBoundsException | ClassCastException | NumberFormatException e) {
							this.loggerAvisos.error("Ocurrio un error al parsear la fecha de Grua -> "+e);
						}
						grua.setProveedorNombre(datosExpres.getSolicitarGrua().get(i).getProveedorNombre());
						
						if (datosExpres.getSolicitarGrua().get(i).getTipoAfectado().equals("A")) {
							grua.setTipoAfectado("Asegurado");
						} else if (StringUtils.contains(datosExpres.getSolicitarGrua().get(i).getTipoAfectado(), "T")) {
								String[] terceroNumero = StringUtils.split(datosExpres.getSolicitarGrua().get(i).getTipoAfectado(),"T");
								grua.setTipoAfectado("Tercero "+terceroNumero[0]);
						}
						
					listaGruas.add(grua);
				}
					servDiv.setSolicitarGrua(listaGruas);
					titulos.put("solicitarGruaD" ,servDiv.getSolicitarGruaD() );
			}
			}
			
			if (datosExpres.getReparacion() != null) {
				if (datosExpres.getReparacion().size() > 0) {
					servDiv.setReparacion(datosExpres.getReparacion());
					titulos.put("reparacionD" , servDiv.getReparacionD() );
				}
			}
			if (datosExpres.getPaseMedico() != null) {
				if (datosExpres.getPaseMedico().size() > 0) {
					List<PaseMedico> listaPaseMedico = new ArrayList<>();
					for (int i = 0; i < datosExpres.getPaseMedico().size(); i++) {
						PaseMedico pm = new PaseMedico();
						pm.setNombreAfectado(datosExpres.getPaseMedico().get(i).getNombreAfectado());
						pm.setEdad(datosExpres.getPaseMedico().get(i).getEdad());
						pm.setNombreProveedor(datosExpres.getPaseMedico().get(i).getNombreProveedor());
						
						if (datosExpres.getPaseMedico().get(i).getTipoAfectado().equals("A")) {
							pm.setTipoAfectado("Asegurado");
						} else if (StringUtils.contains(datosExpres.getPaseMedico().get(i).getTipoAfectado(), "T")) {
								String[] terceroNumero = StringUtils.split(datosExpres.getPaseMedico().get(i).getTipoAfectado(),"T");
								pm.setTipoAfectado("Tercero "+terceroNumero[0]);
							}
						listaPaseMedico.add(pm);
						}
					servDiv.setPaseMedico(listaPaseMedico);
					titulos.put("paseMedicoD", servDiv.getPaseMedicoD());
				}
			}
			
			if(datosExpres.getAbogados() != null) {
				if (datosExpres.getAbogados().size() > 0 ) {
					List<Abogado> listaAbogado = new ArrayList<>();
					HoraConsultaUtil utileria = new HoraConsultaUtil();
					for (int i = 0; i < datosExpres.getAbogados().size(); i++) {
						Abogado abogado = new Abogado();
						try {
							abogado.setFecha(utileria.transformarFecha(datosExpres.getAbogados().get(i).getFecha()));
						}catch (IndexOutOfBoundsException | NumberFormatException | ClassCastException e) {
							this.loggerAvisos.error("Ocurrio un error al obtener fecha Grua");
						}
						abogado.setNombreAbogado(datosExpres.getAbogados().get(i).getNombreAbogado());
						abogado.setClaveAbogado(datosExpres.getAbogados().get(i).getClaveAbogado());
						abogado.setDescripPresentarse(datosExpres.getAbogados().get(i).getLugarPresentarse());
						try {
							if (datosExpres.getAbogados().get(i).isConductorDetenido()) {
								abogado.setConductorDetenido("SI");
							} else {
								abogado.setConductorDetenido("NO");
							}
						} catch (ClassCastException | IndexOutOfBoundsException | NumberFormatException e) {
							abogado.setConductorDetenido("NO");
						}
						
						abogado.setNombreCoordJuridico(datosExpres.getAbogados().get(i).getNombreCoordJuridico());
						abogado.setTelCoordJuridico(datosExpres.getAbogados().get(i).getTelCoordJuridico());
					listaAbogado.add(abogado);
					}
					servDiv.setAbogados(listaAbogado);
					titulos.put("abogadosD", servDiv.getAbogadosD());
				}
			}
			
			reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta+"ajustadorExpres.jasper");

//	Gson jsonPeticion = new Gson();
//	String json = jsonPeticion.toJson(titulos);
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, titulos , new JREmptyDataSource());
	
			
		//Export PDF
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
		exporter.exportReport();

		//Trabajar con los correos destinatarios
		ArrayList<String> correos = new ArrayList<String>();
		String [] listaCorreos = null;
		if (datosExpres.getCorreoDestinatario() != null) {
			if (datosExpres.getCorreoDestinatario().size() > 0) {
			try { 
				for (int i = 0; i < datosExpres.getCorreoDestinatario().size(); i++) {
					correos.add( datosExpres.getCorreoDestinatario().get(i));	
				}
			} catch (IndexOutOfBoundsException | ClassCastException  e) {
				this.loggerAvisos.error("Ocurrio un error al recorrer lista de correos");
			}
		 }
		}

		if (correos.size() < 1) {
			//Buscamos por poliza	
			List<CorreoPolizaAgente> correosPolizas	= null;
			if (reporteSAC.getGeneralNumeroPoliza() != null) {
				this.loggerAvisos.info("Poliza: "+reporteSAC.getGeneralNumeroPoliza()+" del reporte "+reporteSAC.getGeneralNumeroReporte());	
				correosPolizas	= CorreoPolizaAgente.getCorreoPolizaAgenteService().listaDeCorreoPolizaAgente(reporteSAC.getGeneralNumeroPoliza(), null);
				this.loggerAvisos.info("Contenido al recorrer lista CorreoPolizaAgente con poliza :"+correosPolizas.size());
				if (correosPolizas != null) {
					if(correosPolizas.size() > 0 ) {
						for (CorreoPolizaAgente correoPolizaAgente : correosPolizas) {
							listaCorreos = correoPolizaAgente.getCorreos().split(",");
							for(int i = 0; i < listaCorreos.length; i++) {
								correos.add(listaCorreos[i]);
							}
						}
						this.loggerAvisos.info("Tamaño de lista de correos con poliza " + listaCorreos.length);
						
					}
				}
			}
			
			//Se añade logica para verificar si no existe Poliza, exista Clave Agente
				if (correos.size() <= 0) {
					List<CorreoPolizaAgente> correosAgentes  =  null;
					if (reporteSAC.getClaveAgente() != null) {
						this.loggerAvisos.info("Clave Agente: "+reporteSAC.getClaveAgente()+" del reporte "+reporteSAC.getGeneralNumeroReporte());
						correosAgentes = CorreoPolizaAgente.getCorreoPolizaAgenteService().listaDeCorreoPolizaAgente(null, reporteSAC.getClaveAgente());
					   this.loggerAvisos.info("Contenido de lista CorreoPolizaAgente con correos Agentes: "+correosAgentes.size());
					   if (correosAgentes != null) {
						   if (correosAgentes.size() > 0) {
							   for (CorreoPolizaAgente correoPolizaAgente : correosAgentes) {
									listaCorreos = correoPolizaAgente.getCorreos().split(",");
									for(int i = 0; i < listaCorreos.length; i++) {
										correos.add(listaCorreos[i]);
									}
								}
							this.loggerAvisos.info("Tamaño de lista de correos con clave agente " + listaCorreos.length);
						}
					   }
						
					}
					}
				}
			
		if(baos!=null){
		    arr = baos.toByteArray();
		}	
		DatosCorreo infoCorreo = new DatosCorreo();
		try {
			infoCorreo.setNumeroReporte(datosExpres.getNumeroReporte());
			infoCorreo.setFechaArribo(datosExpres.getFechaArribo());
			infoCorreo.setAjusteCodigoCausa(datosExpres.getCausaAccidente());
			infoCorreo.setConductorNombre(datosExpres.getNombreConductor());
			infoCorreo.setConductorTel(reporteSAC.getConductorTelefonoContacto());
			infoCorreo.setUbicColonia(datosExpres.getColonia());
			infoCorreo.setUbicMunicipio(datosExpres.getMunDeleg());
			infoCorreo.setUbicEntidad(datosExpres.getCiudad());
			infoCorreo.setVehiculoMarca(datosExpres.getVehiculoMarca());
			infoCorreo.setVehiculoModelo(datosExpres.getVehiculoModelo());
			infoCorreo.setVehiculoPlacas(datosExpres.getVehiculoPlacas());
			infoCorreo.setVehiculoSerie(datosExpres.getVehiculoSerie());
			infoCorreo.setClaveAgente(datosExpres.getClaveAgente());
		} catch (ClassCastException | IndexOutOfBoundsException  e) {
			this.loggerAvisos.error("Ocurrio un error al setear informacion para el correo-> "+e);
		}
		String cuerpoCorreo  = this.cuerpoNotificacionCorreoAgente(infoCorreo);
		
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
				correoFirmaImagAsyncObj.enviarEmailAsync(correos,  asunto,  cuerpoCorreo, arr,"resumen-ajustador.pdf", datosExpres.getNumeroReporte(), ruta,false, true, true);
				return true;
				}catch (Exception e) {
					this.loggerAvisos.info("Ocurrio un error an invocar el metodo correoFirmaImagAsyncObj.enviarEmailAsync: "+e);
					return false;
				}
			}catch (Exception e) {
				this.loggerAvisos.info("Ocurrio un error CorreoFirmaImagAsync -> "+e);
				return false;
	        	}
		}
		} catch (Exception e) {
			this.loggerAvisos.info("Ocurrio un error ENVIAR CORREO TERMINO AJUSTADOR EXPRES -> "+e);
			this.loggerAvisos.info("ERROR: "+e.getCause());
			return false;
		}
		return true;
	}
	
	private String cuerpoNotificacionCorreoAgente (DatosCorreo datos ) {
		String cuerpoCorreo = null;
			if ( datos != null ) { 
				cuerpoCorreo ="<div><center>\r\n" + 
						"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 24px; font-weight: 600;\">QUÁLITAS COMPAÑÍA DE SEGUROS S.A. DE C.V.</div>\r\n" + 
						"<div style=\"color: #008c99; font-size: 31px; font-weight: 900;\">&nbsp;</div>\r\n" + 
						"</center>\r\n" + 
						"<div>\r\n" + 
						"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 12.0pt; font-family: Arial,sans-serif; color: #148c9a;\"> Notificación </span> </strong></p>\r\n" + 
						"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 12.0pt; font-family: Arial,sans-serif; color: #ae1985;\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;de Termino de la Atención.</span> </strong></p>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<p style=\"margin: 0cm;\"><strong> <span style=\"font-family: Arial,sans-serif; color: #91167f;\"> Estimado Agente: </span> </strong></p>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<table style=\"border-collapse: collapse; border: none;\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
						"<tbody>\r\n" + 
						"<tr>\r\n" + 
						"<td style=\"border: none; background: #E1F2F4; padding: 10pt 10pt 10pt 10pt; border-radius: 3%;\" valign=\"top\">\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\">A continuación nos permitimos adjuntar archivo con el detalle de la información del siniestro"+
						", una vez que nuestro ajustador concluyó con su atención.\r\n" + 
						"\r\n" + 
						"<!-- o ignored --></p>\r\n" +  
						"</td>\r\n" + 
						"</tr>\r\n" + 
						"</tbody>\r\n" + 
						"</table>\r\n" + 
						"<p style=\"margin: 0cm;\"> <img src='cid:imagenSiniestro' align=\"right\"> &nbsp;</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Numero de Reporte asignado:&nbsp; </span> "+datos.getNumeroReporte() +"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Primer contacto:&nbsp;&nbsp; </span> "+datos.getFechaArribo()+" </p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Tipo de siniestro:&nbsp;&nbsp; </span> "+ datos.getAjusteCodigoCausa() +"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Nombre del conductor:&nbsp; </span>"+ datos.getConductorNombre()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Teléfono Lugar:&nbsp; </span>"+ datos.getConductorTel()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Localidad donde ocurrió:&nbsp; </span>"+datos.getUbicColonia()+", " +datos.getUbicMunicipio()+ ", "+datos.getUbicEntidad()+"</p>\r\n" +
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Vehículo:&nbsp; </span>"+datos.getVehiculoMarca()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Modelo:&nbsp; </span>"+datos.getVehiculoModelo()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Placas:&nbsp; </span>"+datos.getVehiculoPlacas()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Num. Serie:&nbsp; </span>"+datos.getVehiculoSerie()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Agente:&nbsp; </span>"+datos.getClaveAgente()+"</p>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<center>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<p style=\"margin: 0cm;\"><img src='cid:firmaCorreo'></p>\r\n" +
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" +
						"</center>\r\n" + 
						"<p><!-- o ignored -->&nbsp;</p>\r\n" + 
						"</div>\r\n" + 
						"</div>";
			}
			
		return cuerpoCorreo;
		
	}
	
	private String cuerpoUnificadoCorreo() {
		String cuerpoCorreo ="<div>\r\n" + 
				"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 20px; font-weight: 600;\">QU&Aacute;LITAS COMPA&Ntilde;&Iacute;A DE SEGUROS S.A. DE C.V.</div>\r\n" + 
				"<br><p style=\"margin: 0cm;\"><strong> <span style=\"font-family: Arial,sans-serif ;font-size:11pt; color: #91167f;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Estimado(a)</span> </strong></p>\r\n" + 
				"<img src='cid:imagenSiniestro' width=\"160\" height=\"220\" align=\"left\">\r\n" +
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:11pt; background-color: #E1F2F4; padding: 4pt 4pt 4pt 4pt; \">Para nosotros, es muy importante garantizar que conozca claramente los detalles y las causas de su accidente,"+
				" por lo cual a continuaci&oacute;n nos permitimos adjuntar archivo con el detalle de su siniestro, en donde podr&aacute;"+
				" consultar la siguiente informaci&oacute;n:</p>" +
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" +
				"<strong>"+
				"<ul text-align: center;>" + 
		    	"<li style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt; color: #008c99;\">Datos generales.</li>\r\n" + 
		    	"<li style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt; color: #008c99;\">Datos del ajustador.</li>\r\n" + 
		    	"<li style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt; color: #008c99;\">Datos del siniestro.</li>\r\n" +
		    	"<li style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt; color: #008c99;\">Declaraci&oacute;n.</li>\r\n" +
		    	"<li style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt; color: #008c99;\">Croquis del accidente.</li>\r\n" +
		    	"<li style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt; color: #008c99;\">Servicios otorgados.</li>\r\n" +
		    	"<li style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt; color: #008c99;\">Contacto para seguimiento, quejas y/o sugerencias.</li>\r\n" +
		    	"</ul>" +
		    	"</strong>"+
				"<br><p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt\">Adicional, nos permitimos anexar una gu&iacute;a r&aacute;pida, que le permite identificar que hacer despu&eacute;s de su siniestro:\r\n" +
				"<!-- o ignored --></p>" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt; color: #91278F;\"><strong>Que sigue despu&eacute;s de tu siniestro.</strong>\r\n" + 
				"<!-- o ignored --></p>"+
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" +
				"<table style=\"width:100%\" align=\"center\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr>\r\n"+
				"<br>"+
				"<td style=\"margin: 0cm;\"><center><img src='cid:firmaCorreo' width=\"500\" height=\"103\" align=\"center\"></center></td>\r\n" +
				"</tr>\r\n"+
				"<tr>\r\n"+
				"<td style=\"font-family: Arial,sans-serif; color: #808080; font-size: 10px; font-weight: 600;\"><center>En caso de dudas o comentarios, favor de contactar a su Ejecutivo de Cuenta.<br />LINEA DE ATENCI&Oacute;N TELEF&Oacute;NICA 01 800 062 3212</center></td>\r\n" + 
				"</tr>\r\n"+
				"</tbody>\r\n" + 
				"</table>\r\n" +
				"</div>";
		return cuerpoCorreo;
	}
	private String cuerpoCorreoAgente ( String numeroReporte ) {
		ReporteMovilSac reporteMovilSac = null;
		String cuerpoCorreo = null;
		
			DateFormat writeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			reporteMovilSac = ReporteMovilSac.getReporteMovilSacService().objetoReporteMovilSac(numeroReporte, null);
			
			if ( reporteMovilSac != null ) { 
				String claveAgente = "";
				if (StringUtils.isNotBlank(reporteMovilSac.getClaveAgente())) {
					claveAgente = reporteMovilSac.getClaveAgente();
				}
				cuerpoCorreo = "<div> \r\n" + 
						"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 20px; font-weight: 600;\">QU&Aacute;LITAS COMPA&Ntilde;&Iacute;A DE SEGUROS S.A. DE C.V.</div>\r\n" + 
						"<br><p style=\"margin: 0cm;\"><strong> <span style=\"font-family: Arial,sans-serif ;font-size:11pt; color: #91167f;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Estimado Agente:</span> </strong></p>\r\n" + 
						"<img src='cid:imagenSiniestro' width=\"160\" height=\"220\" align=\"left\">\r\n" +
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt; background-color: #E1F2F4; padding: 4pt 4pt 4pt 4pt; \">A continuaci&oacute;n nos permitimos adjuntar archivo con el detalle de la información del siniestro"+
						", una vez que nuestro ajustador concluy&oacute; con su atenci&oacute;n.\r\n"+
						"</p>" +
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" +
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:9pt;\"><span style=\"color: #ad1683;\">N&uacute;mero de reporte asignado:&nbsp; </span> "+reporteMovilSac.getGeneralNumeroReporte()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:9pt;\"><span style=\"color: #ad1683;\">Fecha y hora de arribo:&nbsp;&nbsp; </span> "+writeFormat.format(reporteMovilSac.getFechaArribo())+" </p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:9pt\"><span style=\"color: #ad1683;\">Tipo de siniestro:&nbsp;&nbsp; </span> "+reporteMovilSac.getAjusteCodigoCausa()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:9pt\"><span style=\"color: #ad1683;\">Nombre del conductor:&nbsp; </span>"+reporteMovilSac.getConductorNombre()+"</p>\r\n" +  
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:9pt\"><span style=\"color: #ad1683;\">Localidad donde ocurri&oacute;:&nbsp; </span>"+ reporteMovilSac.getUbicacionColoniaDesc() +", " + reporteMovilSac.getUbicacionMunicipio() + ", " + reporteMovilSac.getUbicacionEntidad() +"</p>\r\n" +
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:9pt\"><span style=\"color: #ad1683;\">Veh&iacute;culo:&nbsp; </span>"+reporteMovilSac.getVehiculoMarca()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:9pt\"><span style=\"color: #ad1683;\">Modelo:&nbsp; </span>"+reporteMovilSac.getVehiculoModelo()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:9pt\"><span style=\"color: #ad1683;\">Placas:&nbsp; </span>"+reporteMovilSac.getVehiculoPlacas()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:9pt\"><span style=\"color: #ad1683;\">Num. Serie:&nbsp; </span>"+reporteMovilSac.getVehiculoSerie()+"</p>\r\n" + 
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:9pt\"><span style=\"color: #ad1683;\">Agente:&nbsp; </span>"+claveAgente+"</p>\r\n" + 
						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
						"<br><p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt\">Adicional, nos permitimos anexar una gu&iacute;a r&aacute;pida, que le permite identificar que hacer despu&eacute;s de su siniestro:\r\n" +
						"<!-- o ignored --></p>" +
						"<strong>"+
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt; color: #ad1683;\">Que sigue despu&eacute;s de tu siniestro. \r\n" +
						"<!-- o ignored --></p>" +
						"</strong>"+
						"<table style=\"width:100%\" align=\"center\">\r\n" + 
						"<tbody>\r\n" + 
						"<tr>\r\n"+
						"<br>"+
						"<td style=\"margin: 0cm;\"><center><img src='cid:firmaCorreo' width=\"500\" height=\"103\" align=\"center\"></center></td>\r\n" +
						"</tr>\r\n"+
						"<tr>\r\n"+
						"<td style=\"font-family: Arial,sans-serif; color: #808080; font-size: 10px; font-weight: 600;\"><center>En caso de dudas o comentarios, favor de contactar a su Ejecutivo de Cuenta.<br />LINEA DE ATENCI&Oacute;N TELEF&Oacute;NICA 01 800 062 3212</center></td>\r\n" + 
						"</tr>\r\n"+
						"</tbody>\r\n" + 
						"</table>\r\n" +
						"</div>";
			}
		return cuerpoCorreo;
	}

}
