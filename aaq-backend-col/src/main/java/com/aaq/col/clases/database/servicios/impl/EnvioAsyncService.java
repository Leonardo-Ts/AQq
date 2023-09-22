package com.aaq.col.clases.database.servicios.impl;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.aaq.col.clases.database.entidades.CatalogoCodigoResponsabilidad;
import com.aaq.col.clases.database.entidades.CorreoPolizaAgente;
import com.aaq.col.clases.database.entidades.ExpedienteEjecutivo;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.interfase.ConclusionSiniestroDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.CorreoPolizaAgenteDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCodigoResponsabilidadServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.EnvioAsyncServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ExpedienteEjecutivoServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacServiceInterfase;
import com.aaq.col.clases.pojo.conclusion.ConclusionAjustador;
import com.aaq.col.clases.pojo.conclusion.DocEntregados;
import com.aaq.col.clases.util.EnvioDeCorreos;
import com.aaq.col.clases.util.avisos.EnviarDeslindeResponsabilidad;
import com.aaq.col.clases.util.avisos.EnvioDeCorreosAvisos;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import net.sf.jasperreports.engine.JRException;

@Service("envioAsyncService")
public class EnvioAsyncService implements EnvioAsyncServiceInterfase  {
	
	public Log log = LogFactory.getLog(EnvioAsyncService.class);
	
	Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");


	@Autowired
	CorreoPolizaAgenteDaoInterfase correoPoliza;
	
	@Autowired
	ConclusionSiniestroDaoInterfase conclusionSiniestro;
	
	@Autowired 
	private ReporteMovilSacServiceInterfase reporteMovilSacService;
	
	@Autowired
	private CatalogoCodigoResponsabilidadServiceInterfase catalogoCodigoRespDao;
	
	@Autowired
	private ExpedienteEjecutivoServiceInterfase expedienteEjecutivoService;

	
	
	@Async
	public void enviarCorreoNuevo(Terminal term , String reporte) {
		this.loggerAvisos.info("***INICIA PROCESO DE BUSQUEDA DE POLIZA/CLAVE AGENTE PARA ENVIO DE CORREO PARA EL REPORTE "+reporte+"***");
		 try {
			 ReporteMovilSac reporteMovilSac = reporteMovilSacService.objetoReporteMovilSac(reporte, null);
	 if (reporteMovilSac != null) {
		try {
			if (reporteMovilSac.getGeneralNumeroPoliza() != null) {
				List<CorreoPolizaAgente> success = correoPoliza.listaDeCorreoPolizaAgente(reporteMovilSac.getGeneralNumeroPoliza(), null);
				if (success.size() > 0) {
					this.loggerAvisos.info("Poliza encontrada: "+reporteMovilSac.getGeneralNumeroPoliza()+" para envio de correo para el reporte "+reporte);
					EnvioDeCorreos envio= new EnvioDeCorreos();
					envio.notificacionTerminoAtencionAgente(reporte, term.getNumeroproveedor(), reporteMovilSac.getGeneralNumeroPoliza(), null);
					this.loggerAvisos.info("***TERMINA PROCESO DE ENVIO DE POLIZA/CLAVE AGENTE PARA ENVIO DE CORREO PARA REPORTE"+reporte+"***");
					return;
				}
			}
		} catch (ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		} catch (NoSuchElementException | DataAccessException e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		}catch (Exception e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		}
		
		try {
			if (reporteMovilSac.getClaveAgente() != null) {
				List<CorreoPolizaAgente> claveAgente = correoPoliza.listaDeCorreoPolizaAgente(null, reporteMovilSac.getClaveAgente());
					if(claveAgente.size() > 0) {
						this.loggerAvisos.info("Clave agente encontrada: "+reporteMovilSac.getClaveAgente()+" para envio de correo para el reporte "+reporte);
						EnvioDeCorreos envio= new EnvioDeCorreos();
						envio.notificacionTerminoAtencionAgente(reporte, term.getNumeroproveedor(), null, reporteMovilSac.getClaveAgente());
						this.loggerAvisos.info("***TERMINA PROCESO DE ENVIO DE POLIZA/CLAVE AGENTE PARA ENVIO DE CORREO PARA REPORTE"+reporte+"***");
						return;
					}
			}
		} catch ( ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		} catch (NoSuchElementException | DataAccessException e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		}catch (Exception e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		}
	 } else {
			this.loggerAvisos.info("No se encontro información del reporte: "+reporte+" para enviar Resumen Ajustador Termino");
		}
		
	 } catch ( RollbackException | IllegalArgumentException | IndexOutOfBoundsException e) {
		 this.loggerAvisos.error("Ocurrio un error -> "+e);
	} catch (PersistenceException | ClassCastException e) {
		this.loggerAvisos.error("Ocurrio un error -> "+e);
	}
		this.loggerAvisos.info("***TERMINA PROCESO DE ENVIO DE POLIZA/CLAVE AGENTE PARA ENVIO DE CORREO***");
		return;
	}
	
	@Async
	public void enviarCorreoResumenAjustador(Terminal term , String reporte, boolean equipoPesado) {
		this.loggerAvisos.info("***INICIA PROCESO DE BUSQUEDA DE POLIZA/CLAVE AGENTE PARA ENVIO DE CORREO PARA EL REPORTE "+reporte+"***");
		 try {
			 ReporteMovilSac reporteMovilSac = reporteMovilSacService.objetoReporteMovilSac(reporte, null);
	 if (reporteMovilSac != null) {
		try {
			if (reporteMovilSac.getGeneralNumeroPoliza() != null) {
				List<CorreoPolizaAgente> success = correoPoliza.listaDeCorreoPolizaAgente(reporteMovilSac.getGeneralNumeroPoliza(), null);
				if (success.size() > 0) {
					this.loggerAvisos.info("Poliza encontrada: "+reporteMovilSac.getGeneralNumeroPoliza()+" para envio de correo para el reporte "+reporte);
					EnvioDeCorreosAvisos envio= new EnvioDeCorreosAvisos();
					envio.notificacionTerminoAtencionAgente(reporte, term, reporteMovilSac.getGeneralNumeroPoliza(), null, term.getCedulaAjustador(), equipoPesado, reporteMovilSac.getGeneralCorreoAsegurado());
					this.loggerAvisos.info("***TERMINA PROCESO DE ENVIO DE POLIZA/CLAVE AGENTE PARA ENVIO DE CORREO PARA REPORTE"+reporte+"***");
					return;
				}
			}
		} catch (ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		} catch (NoSuchElementException | DataAccessException e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		}catch (Exception e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		}
		
		try {
			if (reporteMovilSac.getClaveAgente() != null) {
				List<CorreoPolizaAgente> claveAgente = correoPoliza.listaDeCorreoPolizaAgente(null, reporteMovilSac.getClaveAgente());
					if(claveAgente.size() > 0) {
						this.loggerAvisos.info("Clave agente encontrada: "+reporteMovilSac.getClaveAgente()+" para envio de correo para el reporte "+reporte);
						EnvioDeCorreosAvisos envio= new EnvioDeCorreosAvisos();
						envio.notificacionTerminoAtencionAgente(reporte, term, null, reporteMovilSac.getClaveAgente(), term.getCedulaAjustador(), equipoPesado,reporteMovilSac.getGeneralCorreoAsegurado() );
						this.loggerAvisos.info("***TERMINA PROCESO DE ENVIO DE POLIZA/CLAVE AGENTE PARA ENVIO DE CORREO PARA REPORTE"+reporte+"***");
						return;
					}
			}
		} catch ( ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		} catch (NoSuchElementException | DataAccessException e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		}catch (Exception e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
		}
	 } else {
			this.loggerAvisos.info("No se encontro información del reporte: "+reporte+" para enviar Resumen Ajustador Termino");
		}
		
	 } catch ( RollbackException | IllegalArgumentException | IndexOutOfBoundsException e) {
		 this.loggerAvisos.error("Ocurrio un error -> "+e);
	} catch (PersistenceException | ClassCastException e) {
		this.loggerAvisos.error("Ocurrio un error -> "+e);
	}
		this.loggerAvisos.info("***TERMINA PROCESO DE ENVIO DE POLIZA/CLAVE AGENTE PARA ENVIO DE CORREO***");
		return;
	}
	
	@Async
	public void enviarCorreoDeslindeResponsabilidad(Terminal term , String reporte, String claveAcc)  {
		this.loggerAvisos.info("***INICIA PROCESO PARA ENVIO DE CORREO DESLINDE DE RESPONSABILIDAD PARA EL REPORTE "+reporte+"***");
		 try {
			 ReporteMovilSac reporteMovilSac = reporteMovilSacService.objetoReporteMovilSac(reporte, null);
	 if (reporteMovilSac != null) {
//		 if (StringUtils.isNotBlank(reporteMovilSac.getGeneralCorreoAsegurado() )) {
			 String codigoResponsabilidad = null;
		 try {
					Map<String, Object> infoDUA = this.conclusionSiniestro.obtenerInformacionDUA(reporteMovilSac.getGeneralNumeroReporte());
					// Obtener datos de Responsabilidad
					if (reporteMovilSac.getCodigoResponsabilidad() != null) {
						CatalogoCodigoResponsabilidad catalogoCodigoResponsabilidad = new CatalogoCodigoResponsabilidad();
			        	try {
			        		if (reporteMovilSac.getCodigoResponsabilidad().length() == 1) {
			        			catalogoCodigoResponsabilidad = this.catalogoCodigoRespDao.objetoCatalogoCodigoResponsabilidadClave("0"+reporteMovilSac.getCodigoResponsabilidad());
							} else {
								catalogoCodigoResponsabilidad = this.catalogoCodigoRespDao.objetoCatalogoCodigoResponsabilidadClave(reporteMovilSac.getCodigoResponsabilidad());
							}
			        		
						} catch ( Exception ex) {
							this.loggerAvisos.error(ex);
						}
			        	if (catalogoCodigoResponsabilidad != null) {
				        	codigoResponsabilidad = catalogoCodigoResponsabilidad.getCodigo() + "-"+ catalogoCodigoResponsabilidad.getDescripcion();
						}
					}
				
					// Documentos Entregados
//					List<TableroEjecutivo> tableroEjecutivo = this.tableroEjecutivoService.listaDocumentos(reporte, term.getNumeroproveedor() );
					List<ExpedienteEjecutivo> tableroEjecutivo = this.expedienteEjecutivoService.listaDocumentos(reporte, null);
//					String doc = "";
					DocEntregados DocEntregados = new DocEntregados();
					try {
					if (tableroEjecutivo.size() > 0) {
//						String recorrer = "";
						for (int i = 0; i < tableroEjecutivo.size(); i++) {
							if (tableroEjecutivo.get(i).getNombreExpediente().contains("Formato Declaración Universal")) {
								DocEntregados.setDua(tableroEjecutivo.get(i).getNombreExpediente());
							}
							if (tableroEjecutivo.get(i).getNombreExpediente().contains("Formato Admisión Autos")) {
								DocEntregados.setAdmAutos(tableroEjecutivo.get(i).getNombreExpediente());
							}
							if (tableroEjecutivo.get(i).getNombreExpediente().contains("Formato Asignación Abogado")) {
								DocEntregados.setAsigAbogado(tableroEjecutivo.get(i).getNombreExpediente());
							}
							if (tableroEjecutivo.get(i).getNombreExpediente().contains("Formato Encuesta Servicio")) {
								DocEntregados.setEncuesta(tableroEjecutivo.get(i).getNombreExpediente());
							}
						}
					}
					} catch (ClassCastException | IndexOutOfBoundsException | PersistenceException | DataAccessException e) {
						this.loggerAvisos.error("Excepcion cachada al obtener documentos Entregados: "+e);
					}
					
					EnviarDeslindeResponsabilidad correoDeslinde = new EnviarDeslindeResponsabilidad();
					 correoDeslinde.correoDeslindeRespons(reporteMovilSac, term.getNombre(), infoDUA, codigoResponsabilidad, DocEntregados,claveAcc );
					}catch (ClassCastException e) {
						log.error(e);
					 } catch (IndexOutOfBoundsException | IllegalArgumentException   e) {
						this.loggerAvisos.error(e);
					}
//		 } else {
//			 this.loggerAvisos.info("No se encontro correo del asegurado del reporte: "+reporte+" para enviar DESLINDE DE RESPONSABILIDAD");
//		 }
	 } else {
			this.loggerAvisos.info("No se encontro información del reporte: "+reporte+" para enviar DESLINDE DE RESPONSABILIDAD");
		}
		
	 } catch ( RollbackException | IllegalArgumentException | IndexOutOfBoundsException e) {
		 this.loggerAvisos.error("Ocurrio un error -> "+e);
	} catch (PersistenceException | ClassCastException e) {
		this.loggerAvisos.error("Ocurrio un error -> "+e);
	}
		this.loggerAvisos.info("***TERMINA PROCESO PARA ENVIO DE CORREO DESLINDE DE RESPONSABILIDAD***");
		return;
	}
	
	@Async
	public boolean enviarCorreoResumenAjustadorExpres(ConclusionAjustador datosExpres, Terminal terminal , ReporteMovilSac reporteSAC) {
		this.loggerAvisos.info("***INICIA PROCESO ENVIAR REPORTE DE RESUMEN AJUSTADOR EXPRES "+datosExpres.getNumeroReporte()+"***");
		 try {
					EnvioDeCorreosAvisos envio= new EnvioDeCorreosAvisos();
					envio.notificacionTerminoAjustadorExpres(datosExpres, terminal, reporteSAC);
					this.loggerAvisos.info("***TERMINA PROCESO DE ENVIO DE POLIZA/CLAVE AGENTE PARA ENVIO DE CORREO PARA REPORTE"+datosExpres.getNumeroReporte()+"***");
					return true;
		} catch (ClassCastException | IndexOutOfBoundsException | RollbackException e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
			this.loggerAvisos.info("***TERMINA PROCESO ENVIAR REPORTE DE RESUMEN AJUSTADOR EXPRES "+datosExpres.getNumeroReporte()+"***");
			return false;
		} catch (NoSuchElementException | DataAccessException | JRException e) {
			this.loggerAvisos.error("Ocurrio un error: "+e);
			this.loggerAvisos.info("***TERMINA PROCESO ENVIAR REPORTE DE RESUMEN AJUSTADOR EXPRES "+datosExpres.getNumeroReporte()+"***");
			return false;
		}
	}

	
}
