package com.aaq.col.clases.database.servicios.impl;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CorreoPolizaAgente;
import com.aaq.col.clases.database.entidades.ExpedienteEjecutivo;
import com.aaq.col.clases.database.entidades.HistoricoResumenAjustador;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.Abogado;
import com.aaq.col.clases.database.entidades.pojo.AsignacionReporte;
import com.aaq.col.clases.database.entidades.pojo.CobroData;
import com.aaq.col.clases.database.entidades.pojo.DatosRobo;
import com.aaq.col.clases.database.entidades.pojo.InsertarCobertura;
import com.aaq.col.clases.database.entidades.pojo.InsertarGestion;
import com.aaq.col.clases.database.entidades.pojo.InsertarTermino;
import com.aaq.col.clases.database.entidades.pojo.ReportePadre;
import com.aaq.col.clases.database.entidades.pojo.ReporteResumenAjus;
import com.aaq.col.clases.database.entidades.pojo.SolicitarFolio;
import com.aaq.col.clases.database.entidades.pojo.SolicitarGrua;
import com.aaq.col.clases.database.repositorios.impl.CorreoPolizaAgenteDao;
import com.aaq.col.clases.database.repositorios.impl.HistoricoResumenAjustadorDao;
import com.aaq.col.clases.database.repositorios.impl.ReporteMovilSacDao;
import com.aaq.col.clases.database.repositorios.interfase.ConclusionSiniestroDaoInterfase;
import com.aaq.col.clases.database.repositorios.interfase.CorreoPolizaAgenteDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ExpedienteEjecutivoServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoResumenAjustadorServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.pojo.conclusion.CoberturasL;
import com.aaq.col.clases.pojo.conclusion.Grua;
import com.aaq.col.clases.pojo.conclusion.GruaEquipoPesado;
import com.aaq.col.clases.pojo.conclusion.InformacionAbogado;
import com.aaq.col.clases.pojo.conclusion.PaseMedico;
import com.aaq.col.clases.pojo.conclusion.Reparacion;
import com.aaq.col.clases.pojo.conclusion.ReporteResumenAjustN;
import com.aaq.col.clases.pojo.conclusion.ResumenAjustadorInfo;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.CorreoFirmaImagAsync;
import com.aaq.col.clases.util.CorreoFirmaImg;
import com.aaq.col.clases.util.DecimalFormatoUtil;
import com.aaq.col.clases.util.HoraConsultaUtil;
import com.aaq.col.clases.util.UtileriaCadenas;
import com.aaq.col.clases.webservices.movil.aex.Adicionales;
import com.aaq.col.clases.webservices.movil.aex.Asegurado;
import com.aaq.col.clases.webservices.movil.aex.InsertarCoberturaRA;
import com.aaq.col.clases.webservices.movil.aex.RecuperoRA;
import com.aaq.col.clases.webservices.movil.aex.Recuperos;
import com.aaq.col.clases.webservices.movil.aex.Reporte;
import com.aaq.col.clases.webservices.movil.aex.TerceroRA;
import com.aaq.col.clases.webservices.movil.aex.Terceros;
import com.aaq.col.clases.webservices.movil.aex.Tiempos;
import com.aaq.col.clases.webservices.movil.aex.Ubicacion;
import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.jmfg.jmlib.sistema.classes.web.spring.JMProveedorApplicationContext;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.castor.util.Base64Decoder;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.eclipse.persistence.exceptions.TransactionException;

@Service("historicoResumenAjustadorService")
@Transactional
public class HistoricoResumenAjustadorService implements HistoricoResumenAjustadorServiceInterfase {	
	
	Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");
	
	@Autowired
	private ConfiguracionServiceInterfase configuracionDao;
	
	@Autowired
	@Qualifier("historicoResumenAjustadorDao")
	HistoricoResumenAjustadorDao historicoResumenAjustadorDao;
		
	@Autowired
	@Qualifier("reporteMovilSacDao")
	ReporteMovilSacDao reporteMovilSacDao;	
	
	@Autowired
	@Qualifier("correoPolizaAgenteDao")
	CorreoPolizaAgenteDao correoPolizaAgenteDao;
	
	@Autowired
	CorreoPolizaAgenteDaoInterfase correoPoliza;
	
	@Autowired
	ConclusionSiniestroDaoInterfase conclusionSiniestro;
	
	@Autowired
	ExpedienteEjecutivoServiceInterfase expedienteEjecutivoService;
	
	@Autowired
	TerminalServiceInterfase terminalService;
	
	
	@Override
	public JMResultadoOperacion ejecutarFuncionHistoricoResumenAjustadorNuevo(String cveAjustador, String nombreAjustador, String numReporte,
			String poliza, String incisoEstatus, String actividad,String usuario, String fuente, String descripcionActividad,String resultado) {
		return this.historicoResumenAjustadorDao.ejecutarFuncionHistoricoResumenAjustadorNuevo(cveAjustador,nombreAjustador, numReporte, poliza, incisoEstatus,
						actividad, usuario, fuente, descripcionActividad,
						resultado);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(HistoricoResumenAjustador historicoResumenAjustador) {
		return this.historicoResumenAjustadorDao.eliminarObjeto(historicoResumenAjustador);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(HistoricoResumenAjustador historicoResumenAjustador) {
		return this.historicoResumenAjustadorDao.guardarObjeto(historicoResumenAjustador);
	}

	@Override
	public List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustador(String reporte, String claveAjustador, String actividad,
			Date fechaInicial, Date fechaFinal) {
		return this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustador(reporte, claveAjustador,
						actividad, fechaInicial, fechaFinal);
	}

	@Override
	public List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustadorFreq(
			String reporte, List<String> clavesAjustadores, String actividad,
			Date fechaInicial, Date fechaFinal) {
		return this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustadorFreq(reporte, clavesAjustadores, actividad, fechaInicial, fechaFinal);
	}

	@Override
	public List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustador(String reporte) {
		return this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustador(reporte, null, null, null,null);
	}

	@Override
	public void generaReporteAjustadoresResumen(String reporte, String claveAjustador, String actividad, Date fechaInicial,
			Date fechaFinal, OutputStream ou, String ruta) {

		List<ReporteResumenAjus> reportesResumenes= new ArrayList<ReporteResumenAjus>();
		
		Map<String, String> titulos = new HashMap<String, String>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");	
		if(fechaFinal!=null && fechaInicial!=null)
			titulos.put("titulo1", "Fecha de: "+df.format(fechaInicial)+" al "+df.format(fechaFinal));
		if(reporte!=null)
			titulos.put("titulo2","Reporte: "+reporte);
		if(claveAjustador!=null)
			titulos.put("titulo3","Ajustador: "+claveAjustador);
		
		List<HistoricoResumenAjustador> resumens = 
				this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustador(reporte, claveAjustador, actividad, fechaInicial, fechaFinal);
		
		for (HistoricoResumenAjustador historicoResumenAjustador : resumens) {
			
			List<HistoricoResumenAjustador> resultado = 
					this.listaDeHistoricoResumenAjustador(historicoResumenAjustador.getGeneralNumeroReporte());
			ReporteResumenAjus datosParseados=this.parseaDatos(resultado,historicoResumenAjustador.getGeneralNumeroReporte(),ruta);
			if(datosParseados!=null)
			reportesResumenes.add(datosParseados);
			
		}
		this.generaPDF(reportesResumenes, titulos ,ruta,ou);

	}
	
	@Override
	public void generaReporteAjustadoresResumenFreq(String reporte,
			List <String> claveAjustador, String actividad, Date fechaInicial,
			Date fechaFinal, OutputStream ou, String ruta)  {

		List<ReporteResumenAjus> reportesResumenes= new ArrayList<ReporteResumenAjus>();
		
		Map<String, String> titulos = new HashMap<String, String>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");	
		if(fechaFinal!=null && fechaInicial!=null)
			titulos.put("titulo1", "Fecha de: "+df.format(fechaInicial)+" al "+df.format(fechaFinal));
		if(reporte!=null)
			titulos.put("titulo2","Reporte: "+reporte);
		if(claveAjustador.size() == 1)
			titulos.put("titulo3","Ajustador: "+claveAjustador);
		
		List<HistoricoResumenAjustador> resumens = 
				this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustadorFreq(reporte, claveAjustador, actividad, fechaInicial, fechaFinal);
		
		for (HistoricoResumenAjustador historicoResumenAjustador : resumens) {
			
			List<HistoricoResumenAjustador> resultado = 
					this.listaDeHistoricoResumenAjustador(historicoResumenAjustador.getGeneralNumeroReporte());
			ReporteResumenAjus datosParseados=this.parseaDatos(resultado,historicoResumenAjustador.getGeneralNumeroReporte(),ruta);
			if(datosParseados!=null)
			reportesResumenes.add(datosParseados);
			
		}
		this.generaPDF(reportesResumenes, titulos ,ruta,ou);

	}

	public ReporteResumenAjus parseaDatos(List<HistoricoResumenAjustador> datos,String numReporte,String ruta){
		
		ReporteResumenAjus respuesta= new ReporteResumenAjus();
		respuesta.setRuta(ruta);

		Map<String,Object> datosReporte = null;		
		AsignacionReporte asignacionReporte = null;
		Map<String,Object> arriboReporte = null;
		InsertarTermino insertarTermino = null;
		InsertarCobertura insertarCobertura = null;
		InsertarGestion insertarGestion = null;
		
		SolicitarFolio solicitarFolio=null;
		List<SolicitarFolio> folios= new ArrayList<SolicitarFolio>();
		
		List<SolicitarGrua> gruas = new ArrayList<SolicitarGrua>();
		SolicitarGrua solicitarGrua = null;
		
		List<CobroData> cobros = new ArrayList<CobroData>();
		CobroData cobroData = null;
		
		List<Abogado> abogados = new ArrayList<Abogado>();
		Abogado abogado = null;
		
		ReporteMovilSac reporteMovilSac=	this.reporteMovilSacDao.objetoReporteMovilSac(numReporte,null);
		
		for (HistoricoResumenAjustador historicoResumenAjustador : datos) {
			
			// Se obtienen para la seccion datos del reporte
			if(datosReporte == null) datosReporte = historicoResumenAjustador.getDatosReporte();
			
			// Datos de la asignacion
			if(asignacionReporte == null) asignacionReporte = historicoResumenAjustador.getActividadAsignacionReporte();									

			// Datos del arribo
			if(arriboReporte == null) arriboReporte = historicoResumenAjustador.getActividadArribo();
			
			// Datos de termino
			if(insertarTermino == null) insertarTermino = historicoResumenAjustador.getActividadTerminoReporte();
			
			// Listas
			
			// coberturas
			if(insertarCobertura == null) insertarCobertura = historicoResumenAjustador.getActividadInsertarCobertura();
						
			// recuperos y terceros
			if ( insertarGestion == null ) {
				insertarGestion = historicoResumenAjustador.getActividadInsertarGestion();
			}else {
				
					insertarGestion = historicoResumenAjustador.getActividadInsertarGestion();
							
			}
			
			// folios
			solicitarFolio= historicoResumenAjustador.getActividadSolicitarFolio();
			if(solicitarFolio != null) folios.add(solicitarFolio);	
			
			// gruas
			solicitarGrua=historicoResumenAjustador.getActividadSolicitarGrua();
			if(solicitarGrua != null) gruas.add(solicitarGrua);			

			// cobros
			cobroData = historicoResumenAjustador.getActividadCobroBancario();
			if(cobroData != null) cobros.add(cobroData);				
			
			// abogados
			abogado= historicoResumenAjustador.getActividadAbogado();
			if(abogado != null) abogados.add(abogado);
		}
		
		if(datosReporte!=null){
			respuesta.setReporte((String)datosReporte.get("reporte"));
			respuesta.setClaveAjustador((String)datosReporte.get("claveAjustador"));
//			respuesta.setFecha((Date)datosReporte.get("fecha"));
			respuesta.setFecha(reporteMovilSac.getFechaOcurrido());
			respuesta.setAjustador((String)datosReporte.get("Ajustador"));
			respuesta.setCodigoCausa(reporteMovilSac.getAjusteCodigoCausa());
		}
		
		if(asignacionReporte!=null ){
			if ( reporteMovilSac.getProximidad() ) {
				respuesta.setOrigenAsig("Por cercania");
			} else {
				respuesta.setOrigenAsig("Por disponibilidad");
			}
			
			
			respuesta.setFechaAsig((Date)asignacionReporte.getFecha());
			respuesta.setUsuarioAsig(asignacionReporte.getUsuario());
			respuesta.setServicioAmbulanciaAsig(StringUtils.isBlank(asignacionReporte.getServicioAmbulancia()) ? "No se solicitó" : asignacionReporte.getServicioAmbulancia());
			
		}		
		
		if(arriboReporte!=null){
			respuesta.setOrigenArribo((String)arriboReporte.get("origen"));
			//Validamos el arribo para tomarlo de ReporteMovilSac
			try {
				if(reporteMovilSac!=null) {
					if (StringUtils.isNotBlank(reporteMovilSac.getAjusteFechaArriboAjustador()) &&
							StringUtils.isNotBlank(reporteMovilSac.getAjusteHoraArriboAjustador()) ) {
						UtileriaCadenas utileria = new UtileriaCadenas();
						Date fechaArribo = utileria.convertirFecha(reporteMovilSac.getAjusteFechaArriboAjustador(),
								reporteMovilSac.getAjusteHoraArriboAjustador());
						respuesta.setFechaArribo(fechaArribo);

					} else {
						respuesta.setFechaArribo((Date)arriboReporte.get("fecha"));
					}
				} else {
					respuesta.setFechaArribo((Date)arriboReporte.get("fecha"));
				}
			} catch (Exception e) {
				respuesta.setFechaArribo((Date)arriboReporte.get("fecha"));
			}
		}
		
		if(insertarTermino!=null){
			respuesta.setOrigenTermino(insertarTermino.getOrigen());
			respuesta.setFechaTermino((Date)insertarTermino.getFecha());
			respuesta.setObservacionesTermino(insertarTermino.getObservaciones());
			respuesta.setResponsabilidadTermino(insertarTermino.getCodigoResp());
			respuesta.setDescDaniosPreTermino(insertarTermino.getDescDaniosPre());	
			
			if(insertarTermino.getDatosRobo() != null) {
				List<DatosRobo> robos = new ArrayList<DatosRobo>();
				robos.add(insertarTermino.getDatosRobo());
				respuesta.setDatosRobos(robos);			
			}
		}
		
		if(insertarGestion!=null){
			respuesta.setRecuperos(insertarGestion.getRecuperos());
			respuesta.setTerceros(insertarGestion.getTerceros());
		}
		
		if(!folios.isEmpty()){
			respuesta.setFolio(folios);
		}
		
		if(reporteMovilSac!=null){
			respuesta.setNombreConductor(reporteMovilSac.getConductorNombre());
			respuesta.setNombreAsgurado(reporteMovilSac.getGeneralNombreAsegurado());
			respuesta.setVehiculoSerie(reporteMovilSac.getVehiculoSerie());
			respuesta.setTelefono(reporteMovilSac.getConductorTelefonoContacto());
			respuesta.setPoliza(reporteMovilSac.getGeneralNumeroPoliza());
			respuesta.setInciso(reporteMovilSac.getGeneralInciso());
			respuesta.setMarca(reporteMovilSac.getVehiculoMarca());
			respuesta.setCorreoAsegurado(reporteMovilSac.getGeneralCorreoAsegurado());
			respuesta.setModelo(reporteMovilSac.getVehiculoModelo());
			respuesta.setEstatusPoliza(reporteMovilSac.getGeneralPolizaEstatus());
			respuesta.setPlacas(reporteMovilSac.getVehiculoPlacas());
			if(reporteMovilSac.getProximidad() == true){
				respuesta.setProximidadAsig("SI");
			}else{
				respuesta.setProximidadAsig("NO");
			}
		}
		
		if(insertarCobertura!=null) respuesta.setCoberturas(insertarCobertura.getCoberturas());
		
		if(!gruas.isEmpty()) respuesta.setSolicitarGrua(gruas);		
		  
		if(!cobros.isEmpty()) respuesta.setCobroBancario(cobros);		
		
		if(!abogados.isEmpty()) respuesta.setAbogados(abogados);
			
		if(respuesta.getReporte()!=null) return respuesta;
		else return null;
	}


	private void generaPDF(List<ReporteResumenAjus> datos,Map<String, String> titulos,String ruta,OutputStream ou) {
								
		JasperReport reporte = null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
		
		try {
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
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, map,reportePadreSource);
		//Export PDF
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
		exporter.exportReport();
		
		if(baos!=null){
		    byte[] arr = baos.toByteArray();
		    ou.write(arr); 
		}	
		}catch (JRException  e) {
			this.loggerAvisos.info("Ocurrio un error al obtener JASPER: "+e);
		} catch (IOException e) {
			this.loggerAvisos.info("Ocurrio un error: "+e);
		}

	}
	
	@Override
	public void notificacionTerminoAtencion(String reporte, String claveAjustador, String correo) {
	
		String actividad = "Insertar Término";
		final Calendar cal = Calendar.getInstance();
		Date fechaFinal = cal.getTime();
		cal.add(Calendar.DATE, -2 );
		Date fechaInicial = cal.getTime();
		String ruta = null;
		try {
			ruta = JMProveedorApplicationContext.getApplicationContext().getResource("/resumen").getFile().getPath() + "/";
				
			List<ReporteResumenAjus> reportesResumenes= new ArrayList<ReporteResumenAjus>();
			
			Map<String, String> titulos = new HashMap<String, String>();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");	
			if(fechaFinal!=null && fechaInicial!=null)
				titulos.put("titulo1", "Fecha de: "+df.format(fechaInicial)+" al "+df.format(fechaFinal));
			if(reporte!=null)
				titulos.put("titulo2","Reporte: "+reporte);
			if(claveAjustador!=null)
				titulos.put("titulo3","Ajustador: "+claveAjustador);
			
			List<HistoricoResumenAjustador> resumens = 
					this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustador(reporte, claveAjustador, actividad, fechaInicial, fechaFinal);
			
			for (HistoricoResumenAjustador historicoResumenAjustador : resumens) {
				
				List<HistoricoResumenAjustador> resultado = 
						this.listaDeHistoricoResumenAjustador(historicoResumenAjustador.getGeneralNumeroReporte());
				ReporteResumenAjus datosParseados=this.parseaDatos(resultado,historicoResumenAjustador.getGeneralNumeroReporte(),ruta);
				if(datosParseados!=null) {
					reportesResumenes.add(datosParseados);				
				}
				
			}
			
			this.generaPDFEnviaCorreo(reportesResumenes, titulos, ruta, reporte, correo);
		} catch (JRException e) {
			this.loggerAvisos.info("Ocurrio un error en notificacionTerminoAtencion: "+e);
		} catch (IOException e) {
			this.loggerAvisos.info("Ocurrio un error en notificacionTerminoAtencion: "+e);
		} 
			
	}		
		
	private void generaPDFEnviaCorreo(List<ReporteResumenAjus> datos,Map<String, String> titulos,String ruta, String numeroReporte, String correo) throws  JRException{
		
		byte[] arr = null;
		JasperReport reporte = null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
		String asunto = "QUALITAS S.A. DE C.V. "+" REPORTE: "+ numeroReporte;
		try {
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
		
			ReporteMovilSac reporteMovilSac = ReporteMovilSac.getReporteMovilSacService().objetoReporteMovilSac(numeroReporte, null);
			
		List<CorreoPolizaAgente> correosPolizas = this.correoPolizaAgenteDao.listaDeCorreoPolizaAgente(reporteMovilSac.getGeneralNumeroPoliza(), null);
		String [] listaCorreos = null;		
		ArrayList<String> correos = new ArrayList<String>();
		
		
		
		if (correosPolizas.size() > 0) {
			for (CorreoPolizaAgente correoPolizaAgente : correosPolizas) {
				listaCorreos = correoPolizaAgente.getCorreos().split(",");
				for(int i = 0; i < listaCorreos.length; i++) {
					correos.add(listaCorreos[i]);
				}
			}
		}
		
		if (StringUtils.isNotBlank(correo)) {
			correos.add(correo);
		}

				
		if(baos!=null){
		    arr = baos.toByteArray();
		}		
		
		String cuerpoCorreo  = this.cuerpoNotificacionCorreo(numeroReporte);
		
		if(arr.length != 0) {
						
			new CorreoFirmaImg(
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
					configuracionDao.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG))
			.enviarEmail(correos, asunto, cuerpoCorreo,arr,"resumen-ajustador.pdf");	
		}
		
		}catch (JRException e) {
			this.loggerAvisos.info("Ocurrio un error en generaPDFEnviaCorreo: "+e );
		} catch (ClassCastException | IndexOutOfBoundsException  e) {
			this.loggerAvisos.info("Ocurrio un error en generaPDFEnviaCorreo: "+e );
		} catch (RollbackException | CannotGetJdbcConnectionException | IllegalThreadStateException  e) {
			this.loggerAvisos.info("Ocurrio un error en generaPDFEnviaCorreo: "+e);
		} catch (DataAccessException | PersistenceException   e) {
			this.loggerAvisos.info("Ocurrio un error en generaPDFEnviaCorreo: "+e);
		} catch (Exception   e) {
			this.loggerAvisos.info("Ocurrio un error en generaPDFEnviaCorreo: "+e);
		}
	}

	private String cuerpoNotificacionCorreo ( String numeroReporte ) {
		
		ReporteMovilSac reporteMovilSac = null;
		String cuerpoCorreo = null;
		try {
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
						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Agente:&nbsp; </span>74450</p>\r\n" + 
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
		 } catch (  ClassCastException | RollbackException | IndexOutOfBoundsException e) {
			this.loggerAvisos.info("Ocurrio un error en cuerpoNotificacionCorreo: "+e);
		} catch ( Exception e) {
			this.loggerAvisos.info("Ocurrio un error en cuerpoNotificacionCorreo: "+e);
		}
		return cuerpoCorreo;
		
	}
	
	
//	@Override
//	public void notificacionTerminoAtencionAgente(String reporte, String claveAjustador, String correo, boolean scheduler) {
//	try {
//		String actividad = "Insertar Término";
//		final Calendar cal = Calendar.getInstance();
//		Date fechaFinal = cal.getTime();
//		cal.add(Calendar.DATE, -2 );
//		Date fechaInicial = cal.getTime();
//		String ruta = null;
//
//			ruta = JMProveedorApplicationContext.getApplicationContext().getResource("/resumen").getFile().getPath() + "/";
//			this.loggerAvisos.info("Ruta: "+ruta);
//				
//			List<ReporteResumenAjus> reportesResumenes= new ArrayList<ReporteResumenAjus>();
//			
//			Map<String, String> titulos = new HashMap<String, String>();
//			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");	
//			if(fechaFinal!=null && fechaInicial!=null)
//				titulos.put("titulo1", "Fecha de: "+df.format(fechaInicial)+" al "+df.format(fechaFinal));
//			if(reporte!=null)
//				titulos.put("titulo2","Reporte: "+reporte);
//			if(claveAjustador!=null)
//				titulos.put("titulo3","Ajustador: "+claveAjustador);
//			
//			List<HistoricoResumenAjustador> resumens = 
//					this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustador(reporte, claveAjustador, actividad, fechaInicial, fechaFinal);
//			
//			for (HistoricoResumenAjustador historicoResumenAjustador : resumens) {
//				
//				List<HistoricoResumenAjustador> resultado = 
//						this.listaDeHistoricoResumenAjustador(historicoResumenAjustador.getGeneralNumeroReporte());
//				ReporteResumenAjus datosParseados=this.parseaDatos(resultado,historicoResumenAjustador.getGeneralNumeroReporte(),ruta);
//				if(datosParseados!=null) {
//					reportesResumenes.add(datosParseados);				
//				}
//				
//			}
//			
//			this.generaPDFEnviaCorreoAgente(reportesResumenes, titulos, ruta, reporte, correo, scheduler);
//		}	catch (Exception e) {
//			this.loggerAvisos.info("Ocurrio un error -> notificacionTerminoAtencionAgente -> "+e);
//			log.info("OCURRIO UN ERROR-> notificacionTerminoAtencionAgente -> "+e);
//			e.getMessage();
//		}
//	}		
//		
//	private void generaPDFEnviaCorreoAgente(List<ReporteResumenAjus> datos,Map<String, String> titulos,String ruta, String numeroReporte, String correo, boolean scheduler) , JRException{
//		byte[] arr = null;
//		JasperReport reporte = null;
//		ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
//		String asunto = "CONCLUSIÓN "+"REPORTE: "+ numeroReporte;
//
//			reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta+"ajustador.jasper");
//		
//		
//		Map<String, Object> map= new HashMap<String,Object>();
//		map.put("prestador", ""+"");
//		map.put("titulo1", titulos.get("titulo1"));
//		map.put("titulo2", titulos.get("titulo2")!=null?titulos.get("titulo2"):"");
//		map.put("titulo3", titulos.get("titulo3")!=null?titulos.get("titulo3"):"");
//		map.put("path", ruta);
//		
//		List<ReporteResumenAjus> reportes=null;
//		
//		List<ReportePadre> reportePadre=new ArrayList<ReportePadre>();
//		
//		for (ReporteResumenAjus reporteResumenAjus : datos) {
//			if(reporteResumenAjus.getReporte()!=null){
//			reportes= new ArrayList<ReporteResumenAjus>();
//			reportes.add(reporteResumenAjus);
//			reportePadre.add(new ReportePadre(new JRBeanCollectionDataSource(reportes)) );
//			}
//		}
//		
//		JRDataSource reportePadreSource=new JRBeanCollectionDataSource(reportePadre);
//		JasperPrint jasperPrint = null;
//	
//			jasperPrint = JasperFillManager.fillReport(reporte, map,reportePadreSource);
//	
//			
//		//Export PDF
//		JRPdfExporter exporter = new JRPdfExporter();
//		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
//		
//			exporter.exportReport();
//		
//			ReporteMovilSac reporteMovilSac = ReporteMovilSac.getReporteMovilSacService().objetoReporteMovilSac(numeroReporte, null);
//			
//		List<CorreoPolizaAgente> correosPolizas = this.correoPolizaAgenteDao.listaDeCorreoPolizaAgente(reporteMovilSac.getGeneralNumeroPoliza(), null);
//		
//		//Se añade logica para verificar si no existe Poliza, exista Clave Agente
//		List<CorreoPolizaAgente> correosAgentes  =  null;
//		if(correosPolizas.size() == 0) {
//			correosAgentes = this.correoPolizaAgenteDao.listaDeCorreoPolizaAgente(null,reporteMovilSac.getClaveAgente());
//		}
//		String [] listaCorreos = null;		
//		ArrayList<String> correos = new ArrayList<String>();
//		
//		if(correosPolizas.size() > 0 ) {
//			for (CorreoPolizaAgente correoPolizaAgente : correosPolizas) {
//				listaCorreos = correoPolizaAgente.getCorreos().split(",");
//				this.loggerAvisos.info("Tamaño de lista de correos " + listaCorreos.length);
//				for(int i = 0; i < listaCorreos.length; i++) {
//					correos.add(listaCorreos[i]);
//				}
//			}
//			
//		}
//		else {
//			for (CorreoPolizaAgente correoPolizaAgente : correosAgentes) {
//				listaCorreos = correoPolizaAgente.getCorreos().split(",");
//				this.loggerAvisos.info("Tamaño de lista de correos " + listaCorreos.length);
//				for(int i = 0; i < listaCorreos.length; i++) {
//					correos.add(listaCorreos[i]);
//				}
//			}
//		}
//		if (StringUtils.isNotBlank(correo)) {
//			correos.add(correo);
//		}
//
//				
//		if(baos!=null){
//		    arr = baos.toByteArray();
//		}		
//		
//		String cuerpoCorreo  = this.cuerpoNotificacionCorreoAgente(numeroReporte);
//		
//		this.loggerAvisos.info("Tamaño de arr: "+arr.length);
//		if(arr.length != 0) {
//			log.info("Correos para el envio del PDF: "+correos);
//			this.loggerAvisos.info("Correos para el envio de PDF -> "+correos);
//			log.info("Asunto del correo: "+asunto);
//			try {
//				
//				CorreoFirmaImagAsync correoFirmaImagAsyncObj = new CorreoFirmaImagAsync(
//					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
//					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
//					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
//					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
//					configuracionDao.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
//					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
//					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
//					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG));
//				try {
//					correoFirmaImagAsyncObj.enviarEmailAsync(correos,  asunto,  cuerpoCorreo, arr,"resumen-ajustador.pdf", numeroReporte, null);
//				} catch (Exception ex) {
//					this.loggerAvisos.info("Ocurrio un error al intentar enviar el pdf -> "+ex);
//					log.info("Ocurrio un error al intentar enviar el pdf -> "+ex);
//				}
//		}catch (Exception e) {
//			this.loggerAvisos.info("Ocurrio un error al enviar el PDF -> "+e);
//			log.info("OCURRIO UN ERROR AL ENVIAR EL PDF-> "+e);
//        	} 
//		}
//		
//		
//	}
//	
//	private String cuerpoNotificacionCorreoAgente ( String numeroReporte ) {
//		ReporteMovilSac reporteMovilSac = null;
//		String cuerpoCorreo = null;
//		
//			DateFormat writeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//			reporteMovilSac = ReporteMovilSac.getReporteMovilSacService().objetoReporteMovilSac(numeroReporte, null);
//			
//			if ( reporteMovilSac != null ) { 
//
//				cuerpoCorreo = "<div><center>\r\n" + 
//						"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 31px; font-weight: 600;\">QUÁLITAS COMPAÑÍA DE SEGUROS S.A. DE C.V.</div>\r\n" + 
//						"<div style=\"color: #008c99; font-size: 31px; font-weight: 900;\">&nbsp;</div>\r\n" + 
//						"</center>\r\n" + 
//						"<div>\r\n" + 
//						"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 22.0pt; font-family: Arial,sans-serif; color: #148c9a;\"> Notificación </span> </strong></p>\r\n" + 
//						"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 22.0pt; font-family: Arial,sans-serif; color: #ae1985;\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;de Termino de la Atención.</span> </strong></p>\r\n" + 
//						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
//						"<p style=\"margin: 0cm;\"><strong> <span style=\"font-family: Arial,sans-serif; color: #91167f;\"> Estimado Agente: </span> </strong></p>\r\n" + 
//						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
//						"<table style=\"border-collapse: collapse; border: none;\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
//						"<tbody>\r\n" + 
//						"<tr>\r\n" + 
//						"<td style=\"border: none; background: #E1F2F4; padding: 10pt 10pt 10pt 10pt; border-radius: 3%;\" valign=\"top\">\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\">A continuación nos permitimos adjuntar archivo con el detalle de la información del siniestro"+
//						", una vez que nuestro ajustador concluyó con su atención\r\n" + 
//						"\r\n" + 
//						"<!-- o ignored --></p>\r\n" +  
//						"</td>\r\n" + 
//						"</tr>\r\n" + 
//						"</tbody>\r\n" + 
//						"</table>\r\n" + 
//						"<p style=\"margin: 0cm;\">&nbsp;</p>\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Numero de Reporte asignado:&nbsp; </span> "+reporteMovilSac.getGeneralNumeroReporte() +"</p>\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Fecha y hora de arribo:&nbsp;&nbsp; </span> "+ writeFormat.format(  reporteMovilSac.getFechaArribo() )+" </p>\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Tipo de siniestro:&nbsp;&nbsp; </span> "+ reporteMovilSac.getAjusteCodigoCausa() +"</p>\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Nombre del conductor:&nbsp; </span>"+ reporteMovilSac.getConductorNombre()+"</p>\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Teléfono Lugar:&nbsp; </span>"+ reporteMovilSac.getConductorTelefonoContacto()+"</p>\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Localidad donde ocurrió:&nbsp; </span>"+ reporteMovilSac.getUbicacionColoniaDesc() +", " + reporteMovilSac.getUbicacionMunicipio() + ", " + reporteMovilSac.getUbicacionEntidad() +"</p>\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Vehículo:&nbsp; </span>"+ reporteMovilSac.getVehiculoMarca() +"</p>\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Modelo:&nbsp; </span>"+ reporteMovilSac.getVehiculoModelo() +"</p>\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Placas:&nbsp; </span>"+ reporteMovilSac.getVehiculoPlacas() +"</p>\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Num. Serie:&nbsp; </span>"+reporteMovilSac.getVehiculoSerie() +"</p>\r\n" + 
//						"<p style=\"margin: 0cm; font-family: Arial,sans-serif;\"><span style=\"color: #ad1683;\">Agente:&nbsp; </span>"+reporteMovilSac.getClaveAgente()+"</p>\r\n" + 
//						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
//						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
//						"<center>\r\n" + 
//						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
//						"<p style=\"margin: 0cm;\"><img src='cid:firmaCorreo'></p>\r\n" +
//						"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
//						"<div style=\"font-family: Arial,sans-serif; color: #808080; font-size: 12px; font-weight: 600;\">En caso de dudas o comentarios, favor de contactar a su Ejecutivo de Cuenta.<br />LINEA DE ATENCI&Oacute;N TELEF&Oacute;NICA 01 800 062 3212</div>\r\n" + 
//						"</center>\r\n" + 
//						"<p><!-- o ignored -->&nbsp;</p>\r\n" + 
//						"</div>\r\n" + 
//						"</div>";
//				
//				return cuerpoCorreo;
//			}
//			
//		return cuerpoCorreo;
//		
//	}
	
	//********Nuevo método para el envio de correo de resumen ajustador**********
	

	@Override
	public void notificacionTerminoAtencionAgente(String reporte, String claveAjustador, String correo) {
	try {
		String actividad = "Insertar Término";
		final Calendar cal = Calendar.getInstance();
		Date fechaFinal = cal.getTime();
		cal.add(Calendar.DATE, -2 );
		Date fechaInicial = cal.getTime();
		String ruta = null;
			ruta = JMProveedorApplicationContext.getApplicationContext().getResource("/resumen").getFile().getPath() + "/";
			this.loggerAvisos.info("Ruta: "+ruta);
				
			List<ReporteResumenAjus> reportesResumenes= new ArrayList<ReporteResumenAjus>();
			
			Map<String, String> titulos = new HashMap<String, String>();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");	
			if(fechaFinal!=null && fechaInicial!=null)
				titulos.put("titulo1", "Fecha de: "+df.format(fechaInicial)+" al "+df.format(fechaFinal));
			if(reporte!=null)
				titulos.put("titulo2","Reporte: "+reporte);
			if(claveAjustador!=null)
				titulos.put("titulo3","Ajustador: "+claveAjustador);
			
			List<HistoricoResumenAjustador> resumens = 
					this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustador(reporte, claveAjustador, actividad, fechaInicial, fechaFinal);
			
			this.loggerAvisos.info("Tamaño de la lista HistoricoResumenAjustador: "+resumens.size());
			
			for (HistoricoResumenAjustador historicoResumenAjustador : resumens) {
				
				List<HistoricoResumenAjustador> resultado = 
						this.listaDeHistoricoResumenAjustador(historicoResumenAjustador.getGeneralNumeroReporte());
				ReporteResumenAjus datosParseados=this.parseaDatos(resultado,historicoResumenAjustador.getGeneralNumeroReporte(),ruta);
				if(datosParseados!=null) {
					reportesResumenes.add(datosParseados);				
				}
				
			}
			
			this.generaPDFEnviaCorreoAgente(reportesResumenes, titulos, ruta, reporte, correo);
		}  	catch (IOException e) {
			this.loggerAvisos.info("Ocurrio un error -> notificacionTerminoAtencionAgente -> "+e);
		} 	catch ( Exception e) {
			this.loggerAvisos.info("Ocurrio un error -> notificacionTerminoAtencionAgente -> "+e);
		}
	}		
		
	private void generaPDFEnviaCorreoAgente(List<ReporteResumenAjus> datos,Map<String, String> titulos,String ruta, String numeroReporte, String correo) {
		try {
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
		
			ReporteMovilSac reporteMovilSac = ReporteMovilSac.getReporteMovilSacService().objetoReporteMovilSac(numeroReporte, null);
			this.loggerAvisos.info("Poliza: "+reporteMovilSac.getGeneralNumeroPoliza());	
			this.loggerAvisos.info("Clave Agente: "+reporteMovilSac.getClaveAgente());
		
		
		//Buscamos por poliza	
//		List<CorreoPolizaAgente> correosPolizas = this.correoPolizaAgenteDao.listaDeCorreoPolizaAgente(reporteMovilSac.getGeneralNumeroPoliza(), null);
		List<CorreoPolizaAgente> correosPolizas	= correoPoliza.listaDeCorreoPolizaAgente(reporteMovilSac.getGeneralNumeroPoliza(), null);
			
		this.loggerAvisos.info("Contenido al recorrer lista de poliza :"+correosPolizas.size());
		//Se añade logica para verificar si no existe Poliza, exista Clave Agente
		List<CorreoPolizaAgente> correosAgentes  =  null;
		if(correosPolizas.size() == 0) {
//			correosAgentes = this.correoPolizaAgenteDao.listaDeCorreoPolizaAgente(null,reporteMovilSac.getClaveAgente());
			 correosAgentes = correoPoliza.listaDeCorreoPolizaAgente(null, reporteMovilSac.getClaveAgente());
		}
		this.loggerAvisos.info("Contenido de lista correos Agentes: "+correosAgentes.size());
		
		String [] listaCorreos = null;		
		ArrayList<String> correos = new ArrayList<String>();
		
		try {
		if(correosPolizas.size() > 0 ) {
			for (CorreoPolizaAgente correoPolizaAgente : correosPolizas) {
				listaCorreos = correoPolizaAgente.getCorreos().split(",");
				for(int i = 0; i < listaCorreos.length; i++) {
					correos.add(listaCorreos[i]);
				}
			}
			this.loggerAvisos.info("Tamaño de lista de correos con poliza " + listaCorreos.length);
		} else {
			for (CorreoPolizaAgente correoPolizaAgente : correosAgentes) {
				listaCorreos = correoPolizaAgente.getCorreos().split(",");
				for(int i = 0; i < listaCorreos.length; i++) {
					correos.add(listaCorreos[i]);
				}
			}
			this.loggerAvisos.info("Tamaño de lista de correos con clave agente " + listaCorreos.length);

		}
		
		}catch (Exception e) {
			this.loggerAvisos.info("Ocurrio un error al recorrer recorrer los correos -> "+e.getMessage());
		}
		
		if (StringUtils.isNotBlank(correo)) {
			correos.add(correo);
		}
//		if (StringUtils.isBlank(correo)) {
//			correos.add(correo);
//		}

				
		if(baos!=null){
		    arr = baos.toByteArray();
		}		
		
		String cuerpoCorreo  = this.cuerpoNotificacionCorreoAgente(numeroReporte);
		
		this.loggerAvisos.info("Tamaño de arr: "+arr.length);
		if(arr.length != 0) {
			this.loggerAvisos.info("Correos para el envio de PDF -> "+correos);
			this.loggerAvisos.info("Asunto del correo: "+asunto);
//			try {
//				
//				SendEmail email = new SendEmail();
//				String servidor = configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST);
//				String pwd = configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD);
//				int puerto= configuracionDao.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO);
//				String usuario = configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO);
//				String correoDir = configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL);
//				destinatario =  StringUtils.join(correos,",");
//				this.loggerAvisos.info("Destinatarios del correo: "+destinatario);
//					email.enviarMail(arr, asunto, cuerpoCorreo, servidor, usuario, pwd, correoDir, destinatario, Integer.toString(puerto));
//		}catch (Exception e) {
//			this.loggerAvisos.info("Ocurrio un error al enviar el PDF -> "+e);
//			log.info("OCURRIO UN ERROR AL ENVIAR EL PDF-> "+e);
//        	} 
			
			try {
				CorreoFirmaImagAsync correoFirmaImagAsyncObj = new CorreoFirmaImagAsync(
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
					configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
					configuracionDao.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
					configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
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
		}catch (JRException e) {
			this.loggerAvisos.info("Ocurrio un error en generaPDFEnviaCorreoAgente:"+e);
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
	

	

	@Override
	public ResumenAjustadorInfo consultarResumenAjustador(String reporte)  {
		
		ResumenAjustadorInfo reportesResumenes= new ResumenAjustadorInfo();

		List<HistoricoResumenAjustador> resumens = 
				this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustador(reporte, null, null, null, null);
		
		if (resumens != null && resumens.size() > 0) {
			List<HistoricoResumenAjustador> resultado = null;	
			for (HistoricoResumenAjustador historicoResumenAjustador : resumens) {
				 resultado = this.listaDeHistoricoResumenAjustador(historicoResumenAjustador.getGeneralNumeroReporte());
				}
			ResumenAjustadorInfo datosParseados=this.parseaDatosRA(resultado, reporte);
			if(datosParseados!=null) {
				reportesResumenes.setReporte(datosParseados.getReporte());
				reportesResumenes.setAsegurado(datosParseados.getAsegurado());
				reportesResumenes.setTiempos(datosParseados.getTiempos());
				reportesResumenes.setAdicionales(datosParseados.getAdicionales());
				reportesResumenes.setEstimaciones(datosParseados.getEstimaciones());
				reportesResumenes.setTerceros(datosParseados.getTerceros());
				reportesResumenes.setRecuperos(datosParseados.getRecuperos());
				//Nuevos
				reportesResumenes.setAbogados(datosParseados.getAbogados());
				reportesResumenes.setCoberturas(datosParseados.getCoberturas());
				reportesResumenes.setDocEntregados(datosParseados.getDocEntregados());
				reportesResumenes.setPaseMedico(datosParseados.getPaseMedico());
				reportesResumenes.setRecuperos(datosParseados.getRecuperos());
				reportesResumenes.setSolicitarGrua(datosParseados.getSolicitarGrua());
				reportesResumenes.setUbicacion(datosParseados.getUbicacion());
				reportesResumenes.setReparacion(datosParseados.getReparacion());
				reportesResumenes.setCoberturas(datosParseados.getCoberturas());
			}
		return reportesResumenes;
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unused")
private ResumenAjustadorInfo parseaDatosRA(List<HistoricoResumenAjustador> datos,String numReporte){
		
		ResumenAjustadorInfo respuesta= new ResumenAjustadorInfo();
		try {
		Map<String,Object> datosReporte = null;		
		AsignacionReporte asignacionReporte = null;
		Date arriboReporte = null;
		InsertarTermino insertarTermino = null;
		InsertarCoberturaRA insertarCobertura = null;
		
		// Nuevos 
		Reporte reporte = new Reporte();
		Asegurado asegurado = new Asegurado();
		Tiempos  tiempos = new Tiempos();
		Adicionales adicionales = new Adicionales();
		List<RecuperoRA> recuperos = new ArrayList<>();
		List<TerceroRA> tercero = new ArrayList<>();
		
		//Nuevos
		List<Grua> gruas = new ArrayList<Grua>();
		Grua solicitarGrua = null;
		List<com.aaq.col.clases.pojo.conclusion.Abogado> abogados = new ArrayList<com.aaq.col.clases.pojo.conclusion.Abogado>();
		com.aaq.col.clases.pojo.conclusion.Abogado abogado = null;
		
		List<String> docEntregados = new ArrayList<String>();
		Ubicacion ubicacionS = new Ubicacion();
		List<Reparacion> reparacion = new ArrayList<Reparacion>();
		Reparacion solicitarReparacion = null;
		
		
		List<Reparacion> reparacionMovil = new ArrayList<Reparacion>();
		Reparacion solicitarReparacionMovil = null;
		
		List<PaseMedico> paseMedico = new ArrayList<PaseMedico>();
		PaseMedico solicitarPaseMedico = null;
		
		List<InformacionAbogado> listaAbogadoInfo = new ArrayList<InformacionAbogado>();
		InformacionAbogado infoAbogado = null;
		
		CoberturasL solicitarCobertura = null;
		
		ReporteMovilSac reporteMovilSac=	this.reporteMovilSacDao.objetoReporteMovilSac(numReporte,null);

		List<ExpedienteEjecutivo> expedienteEjecutivo = new ArrayList<ExpedienteEjecutivo>();
		try {
			expedienteEjecutivo = this.expedienteEjecutivoService.listaDocumentos(numReporte, null);
		} catch (final IllegalArgumentException | NoResultException | ClassCastException |
				DataAccessException | NonUniqueResultException | RollbackException | TransactionSystemException e) {
			this.loggerAvisos.error("Excepcion en tableroEjecutivoService.listaDocumentos: "+e);
		} catch (final PersistenceException | TransactionException e) {
			this.loggerAvisos.error("Excepcion en tableroEjecutivoService.listaDocumentos: "+e);
		}
		
		Map<String, Object> infoDUA = new HashMap<String, Object>();
		try {
			infoDUA = this.conclusionSiniestro.obtenerInformacionDUA(numReporte);
		}catch (Exception e) {
			this.loggerAvisos.error("Excepcion en conclusionSiniestro.obtenerInformacionDUA: "+e);
		}
		
	 if (expedienteEjecutivo != null) {
		if (expedienteEjecutivo.size() > 0) {
			for (int i = 0; i < expedienteEjecutivo.size(); i++) {
				if (expedienteEjecutivo.get(i).getNombreExpediente().contains("Formato Declaración Universal")) {
					docEntregados.add(expedienteEjecutivo.get(i).getNombreExpediente());
				}
				if (expedienteEjecutivo.get(i).getNombreExpediente().contains("Formato Admisión Autos")) {
					docEntregados.add(expedienteEjecutivo.get(i).getNombreExpediente());
				}
				if (expedienteEjecutivo.get(i).getNombreExpediente().contains("Formato Asignación Abogado")) {
					docEntregados.add(expedienteEjecutivo.get(i).getNombreExpediente());
				}
				if (expedienteEjecutivo.get(i).getNombreExpediente().contains("Formato Encuesta Servicio")) {
					docEntregados.add(expedienteEjecutivo.get(i).getNombreExpediente());
				}
			}
			respuesta.setDocEntregados(docEntregados);
		}
	 }
		
		for (HistoricoResumenAjustador historicoResumenAjustador : datos) {

			// Se obtienen para la seccion datos del reporte
			if(datosReporte == null) datosReporte = historicoResumenAjustador.getDatosReporte();
			
			// Datos de la asignacion
			if(asignacionReporte == null) asignacionReporte = historicoResumenAjustador.getActividadAsignacionReporte();									
			// Datos del arribo
			if(arriboReporte == null) arriboReporte = historicoResumenAjustador.getFechaHoraArribo();
			// Datos de termino
			if(insertarTermino == null) insertarTermino = historicoResumenAjustador.getActividadTerminoReporte();
			// coberturas
			if(insertarCobertura == null) insertarCobertura = historicoResumenAjustador.getActividadInsertarCoberturaRA();

			// coberturas
			if(solicitarCobertura == null) solicitarCobertura = historicoResumenAjustador.getActividadInsertarCoberturaN();
			
			solicitarReparacion = historicoResumenAjustador.getActividadReparacion();
			if (solicitarReparacion != null)  reparacion.add(solicitarReparacion);
			
			solicitarReparacionMovil = historicoResumenAjustador.getActividadReparacionMovil();
			if (solicitarReparacionMovil != null)  reparacionMovil.add(solicitarReparacionMovil);
			
			solicitarPaseMedico = historicoResumenAjustador.getActividadPaseMedico();
			if (solicitarPaseMedico != null) paseMedico.add(solicitarPaseMedico);
			// gruas
			solicitarGrua = historicoResumenAjustador.getActividadSolicitarServicioGrua();
			if(solicitarGrua != null) gruas.add(solicitarGrua);			
			// abogados
			abogado= historicoResumenAjustador.getActividadSolicitarAbogado();
			if(abogado != null) abogados.add(abogado);
			//Información Abogado
			infoAbogado = historicoResumenAjustador.getActividadInfoAbogado();
			if (infoAbogado != null) listaAbogadoInfo.add(infoAbogado);
		
			}
		
	try {
	List<HistoricoResumenAjustador> resultado = this.listaDeHistoricoResumenAjustadorGestion(numReporte, "Insertar Gestión");
		//Obtenere recuperos
	if (resultado != null && resultado.size() > 0) {
		for (HistoricoResumenAjustador resumen : resultado) {
			try {
					// Parseo de datos
		 if (resumen.getDescripcionActividad() != null) {
			
			 JSONObject gestion = new JSONObject(resumen.getDescripcionActividad());
			 try {
			 	JSONArray terceros = gestion.getJSONArray("terceros");
				for (int i = 0; i < terceros.length(); i++) {
					TerceroRA terc = new TerceroRA();
					try {
					JSONObject cuerpo =  (JSONObject) terceros.get(i);
				String tipoT = cuerpo.getString("tipoTercero");
				if (tipoT != null) {
				switch (tipoT) {
				case "V":
					terc.setTipoTercero("Vehículo");
					break;
				case "P":
					terc.setTipoTercero("Persona");
					break;
				case "O":
					terc.setTipoTercero("Objeto");
					break;

				default:
					break;
				}
				}
				terc.setCorreo(cuerpo.getString("correo"));
				String numT = cuerpo.getString("numeroTercero");
				String[] terceroNumeroT = StringUtils.split(numT,"T");
				terc.setNumeroTercero(terceroNumeroT[0]);
				terc.setTelefono(cuerpo.getString("telefono"));
			tercero.add(terc);
					} catch (Exception e) {
						this.loggerAvisos.info("Ocurrio un error al obtener tercero");
					}
				}
			 } catch (Exception e) {
				 this.loggerAvisos.info("Ocurrio un erro al parsear terceros "+e);
			}	
			 
			 try {
				 	JSONArray recuperosJ = gestion.getJSONArray("recuperos");
					for (int i = 0; i < recuperosJ.length(); i++) {
						RecuperoRA recu = new RecuperoRA();
						try {
						JSONObject cuerpo =  (JSONObject) recuperosJ.get(i);
						recu.setMonto(cuerpo.getString("monto"));
						recu.setNombreAseguradora(cuerpo.getString("cveAseguradora"));
						String numTerc = cuerpo.getString("numeroTercero");
						String[] terceroNumero = StringUtils.split(numTerc,"T");
						recu.setNumeroTercero(terceroNumero[0]);
						recu.setDescClaveRecupero(cuerpo.getString("descClaveRecupero"));
						recu.setCveRecupero(cuerpo.getString("cveRecupero"));
						recu.setNombreAseguradora(cuerpo.getString("nombreAseguradora"));
					recuperos.add(recu);
						} catch (Exception e) {
							this.loggerAvisos.info("Ocurrio un error al obtener recupero "+e);
						}
					}
				 } catch (Exception e) {
					 this.loggerAvisos.info("Ocurrio un erro al parsear recuperos "+e);
				}		 
		 		}		
		
			} catch (Exception e) {
				this.loggerAvisos.info("Ocurrio un error al obtener datos " +e);
				}
			}
		 }
		} catch (Exception e) {
			this.loggerAvisos.info("Ocurrio un error al obtener datos de gestion");
		}
		
		// Recuperos y Terceros
			try {
				
				Recuperos rec = new Recuperos();
				List<RecuperoRA> recupero ;
				recupero = recuperos;
				rec.setRecupero(recupero);
			respuesta.setRecuperos(rec);
			} catch (Exception e) {
				this.loggerAvisos.info("Ocurrio un error al añadir recupero. "+e);
			}
			
			try {
			Terceros terc = new Terceros();
			List<TerceroRA> terceroF;
			terceroF = tercero;
			terc.setTercero(terceroF);
		respuesta.setTerceros(terc);
			} catch (Exception e) {
				this.loggerAvisos.info("Ocurrio un error al añadir terceros. "+e);
			}	
		
		if(datosReporte!=null){
			//*** Reporte ***//
			reporte.setReporte((String)datosReporte.get("reporte"));
			reporte.setAjustador((String)datosReporte.get("Ajustador"));
			reporte.setClaveAgente(reporteMovilSac.getClaveAgente());
			reporte.setFechaHoraOcurrido(reporteMovilSac.getGeneralFechaOcurrido() +" "+reporteMovilSac.getGeneralHoraOcurrido()); // Pendiente
			reporte.setCodigoCausa(reporteMovilSac.getAjusteCodigoCausa());
			reporte.setDondeOcurrio(reporteMovilSac.getUbicacionColoniaDesc() +", "+reporteMovilSac.getUbicacionMunicipio()+", " + reporteMovilSac.getUbicacionEntidad());
		respuesta.setReporte(reporte);
		}
		
		if(asignacionReporte!=null ){
			// ** Tiempo de Asigancion 
			try {
				String pattern = "dd/MM/yyyy HH:mm:ss";
				DateFormat df = new SimpleDateFormat(pattern);
		        String fecha = df.format(asignacionReporte.getFecha());
				String[] fechaHora = fecha.split(" "); 
				tiempos.setFechaAsignacion(fechaHora[0]);
				tiempos.setHoraAsignacion(fechaHora[1]);
				} catch (Exception e) {
					this.loggerAvisos.info("Ocurrio un error al convertir fecha/hora de asignacion");
				}
		}		
		
		if(arriboReporte!=null){
			//** Tiempos de  Arribo
			try {
				String pattern = "dd/MM/yyyy HH:mm:ss";
				DateFormat df = new SimpleDateFormat(pattern);
		        String fecha = df.format(arriboReporte);
		        String[] fechaHora = fecha.split(" ");
				tiempos.setFechaArribo(fechaHora[0]);
				tiempos.setHoraArribo(fechaHora[1]);
				}catch (IllegalArgumentException e) {
					this.loggerAvisos.info("Ocurrio un error al obtener fecha Arribo");
				} catch (Exception e) {
					this.loggerAvisos.info("Ocurrio un error al obtener fecha Arribo");
				}
		}
		
		if(insertarTermino!=null){
			tiempos.setOrigenTermino(insertarTermino.getOrigen());
            try {
    		//** Tiempos de Temino
	            String pattern = "dd/MM/yyyy HH:mm:ss";
		        DateFormat df = new SimpleDateFormat(pattern);
		        String fecha = df.format(insertarTermino.getFecha());
				String[] fechaHora = fecha.split(" "); 
				tiempos.setFechaTermino(fechaHora[0]);
				tiempos.setHoraTermino(fechaHora[1]);
            } catch (IllegalArgumentException e) {
            	this.loggerAvisos.info("Ocurrio un error al obtener fecha Termino");
			}catch (Exception e) {
				this.loggerAvisos.info("Ocurrio un error al obtener fecha Termino");
			}
            // Se añaden los tiempos 
			respuesta.setTiempos(tiempos);
		
			adicionales.setObservAjustador(insertarTermino.getObservaciones());
			adicionales.setCodigoRespo(insertarTermino.getCodigoResp());
			// Se añaden los datos adicionales
			respuesta.setAdicionales(adicionales);
		}
		
		if(reporteMovilSac!=null){
			//*** Asegurado ***//
			asegurado.setNombreAsegurado(reporteMovilSac.getGeneralNombreAsegurado());
			asegurado.setConductor(reporteMovilSac.getConductorNombre());
			asegurado.setCorreo(reporteMovilSac.getGeneralCorreoAsegurado());
			asegurado.setTelefono(reporteMovilSac.getConductorTelefonoContacto());
			asegurado.setPoliza(reporteMovilSac.getGeneralNumeroPoliza());
			asegurado.setInciso(reporteMovilSac.getGeneralInciso());
			asegurado.setMarca(reporteMovilSac.getVehiculoMarca());
			asegurado.setModelo(reporteMovilSac.getVehiculoModelo());
			asegurado.setPlacas(reporteMovilSac.getVehiculoPlacas());
			asegurado.setSerie(reporteMovilSac.getVehiculoSerie());
			asegurado.setColor(reporteMovilSac.getVehiculoColor());
			
			//Ubicacion para InfoSiniestro
			ubicacionS.setUbicacionSiniestro(reporteMovilSac.getUbicacionDireccion());
			ubicacionS.setColonia(reporteMovilSac.getUbicacionColoniaDesc());
			ubicacionS.setCiudad(reporteMovilSac.getUbicacionEntidad());
			ubicacionS.setMunDeleg(reporteMovilSac.getUbicacionMunicipio());
			respuesta.setUbicacion(ubicacionS);
			reporte.setNumSiniestro(reporteMovilSac.getGeneralNumeroSiniestro());
		
			if (reporteMovilSac.getAjusteAjustadorCodigo() != null) {
				Terminal terminal = this.terminalService.objetoTerminalParaProveedorYPasswd(reporteMovilSac.getAjusteAjustadorCodigo(), null);
				if (terminal != null) {
					respuesta.getReporte().setCedulaAjustador(terminal.getCedulaAjustador());
				}
			}
			
		respuesta.setAsegurado(asegurado);
		}
////		 Coberturas - Estimaciones
//		try {
//			if(insertarCobertura!=null) {
//				com.jmfg.siicaserver.system.classes.pojo.conclusion.Coberturas cob = new com.jmfg.siicaserver.system.classes.pojo.conclusion.Coberturas();
//				 cob.setClaveCobertura(insertarCobertura.getCoberturas().get(0).getClaveCobertura());
//				 cob.setDecClaveCobertura(insertarCobertura.getCoberturas().get(0).getDecClaveCobertura());
//				 cob.setMonto(insertarCobertura.getCoberturas().get(0).getMonto());
//				respuesta.setEstimaciones(cob);
//			}
//		}catch (Exception e) {
//		}
		if (infoDUA != null) {
		 try {
			if (infoDUA.get("respuesta") != null ) {
				if ( !(infoDUA.get("respuesta").toString().contains("ERROR")) ) {
					if (infoDUA.get("narracion") != null ) {
						reporte.setNarracion(infoDUA.get("narracion").toString());
					}
					if (infoDUA.get("croquis") != null ) {
						String croquis = infoDUA.get("croquis").toString();
							reporte.setCroquis(croquis);
						}
					if (infoDUA.get("conclusion") != null ) {
						reporte.setDeslindeResponsabilidad(infoDUA.get("conclusion").toString());
					}
					
					if (infoDUA.get("firmaConductor") != null ) {
						String firmaConductor = infoDUA.get("firmaConductor").toString();
						if (firmaConductor != null && !firmaConductor.isEmpty()) {
							reporte.setFirmaConductor(firmaConductor);
						}
						
					}
					
				}
			}
		 } catch (RollbackException | TransactionException | ClassCastException | IllegalArgumentException  | IllegalStateException | NoResultException e) {
			this.loggerAvisos.error("Exception infoDUA: "+e);
		}  catch (PersistenceException | TransactionSystemException e) {
			this.loggerAvisos.error("Exception infoDUA: "+e);
		}
		}
		
		
		//Recorrer coberturas para modificar  monto
		DecimalFormatoUtil utileriaD = new DecimalFormatoUtil();
		List<com.aaq.col.clases.pojo.conclusion.Coberturas>  estimaciones = new ArrayList<>();
		if (solicitarCobertura != null) {
			if (solicitarCobertura.getCoberturas().size() > 0) {
				try {
					for (int i = 0; i < solicitarCobertura.getCoberturas().size(); i++) {
						com.aaq.col.clases.pojo.conclusion.Coberturas cob = new com.aaq.col.clases.pojo.conclusion.Coberturas();
						cob.setClaveCobertura(solicitarCobertura.getCoberturas().get(i).getClaveCobertura());
						cob.setDecClaveCobertura(solicitarCobertura.getCoberturas().get(i).getDecClaveCobertura());
						cob.setMonto(utileriaD.obtenerCifra(solicitarCobertura.getCoberturas().get(i).getMonto(), reporteMovilSac.getGeneralMonedaNombre()));
						estimaciones.add(cob);
					}
				} catch ( Exception e) {
					this.loggerAvisos.error("Exception en Coberturas: "+e);
				}
			}
		}
		
	if(solicitarCobertura !=null) respuesta.setCoberturas(estimaciones);
	
			
		if (reparacion.size() > 0 ) {
			respuesta.setReparacion(reparacion);
		}
		
		if (paseMedico.size() > 0) {
			respuesta.setPaseMedico(paseMedico);
		}
		if(!gruas.isEmpty()) respuesta.setSolicitarGrua(gruas);	
		
		//Modificar Datos de Abogado
		try {
			HoraConsultaUtil utilFecha = new HoraConsultaUtil();
	 if (listaAbogadoInfo != null) {
		if(listaAbogadoInfo.size() > 0) {
			Gson infoAbo = new Gson();
			String infoAbogadoS = infoAbo.toJson(listaAbogadoInfo);
			this.loggerAvisos.info("Informacion de Abogado: "+infoAbogadoS);
			List<com.aaq.col.clases.pojo.conclusion.Abogado> abogadoCompleto = new ArrayList<com.aaq.col.clases.pojo.conclusion.Abogado>();
				for (int i = 0; i < abogados.size(); i++) {
					com.aaq.col.clases.pojo.conclusion.Abogado abogadoInfo = new com.aaq.col.clases.pojo.conclusion.Abogado();
					abogadoInfo.setFecha( utilFecha.transformarFecha(listaAbogadoInfo.get(0).getFechaAsignacion()));
					abogadoInfo.setNombreAbogado(listaAbogadoInfo.get(0).getNombreAbogado());
					abogadoInfo.setClaveAbogado(listaAbogadoInfo.get(0).getClaveAbogado());
					abogadoInfo.setDescripPresentarse(abogados.get(i).getDescripPresentarse());
					abogadoInfo.setConductorDetenido(abogados.get(i).getConductorDetenido());
					abogadoInfo.setNombreCoordJuridico(listaAbogadoInfo.get(0).getNombreCoordJuridico());
					abogadoInfo.setTelCoordJuridico(listaAbogadoInfo.get(0).getTelCoordJuridico());
				abogadoCompleto.add(abogadoInfo);
				}
				respuesta.setAbogados(abogadoCompleto);
		} else {
				respuesta.setAbogados(abogados);
		} }
		} catch (Exception e) {
			this.loggerAvisos.error("Exception en listaAbogadoInfo: "+e);
		}
		//Modificar Datos de Reapacion / Se añaden datos del supervisor
		try {
			if (reparacion != null) {
				if( !reparacion.isEmpty()) { 
					respuesta.setReparacion(reparacion);
				} else {
				respuesta.setReparacion(reparacionMovil);
				}	
			} else {
				respuesta.setReparacion(reparacionMovil);
			}
		
		} catch (Exception e) {
			this.loggerAvisos.error("Exception en reparacion: "+e);
		}
		
		
		if(respuesta.getReporte()!=null) return respuesta;
		else return null;
		
		} catch (Exception e) {
			this.loggerAvisos.error("Exception en en RESUMEN AJUSTADOR: "+e);
			this.loggerAvisos.error("Exception en en RESUMEN AJUSTADOR -> Causa: "+e.getCause());

			return null;
		}
	}
	
	@Override
	public List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustadorGestion(String reporte, String actividad)  {
		return this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustadorGestion(reporte, actividad);
	}

	
	/***************** Para nuevo formato de conclusión del siniestro*************************/
	@SuppressWarnings("unused")
	@Override
	public ReporteResumenAjustN parseaDatosN(List<HistoricoResumenAjustador> datos,String numReporte,String ruta,
			String claveAjustador, boolean equipoPesado){
			
		ReporteResumenAjustN respuesta= new ReporteResumenAjustN();
			respuesta.setRuta(ruta);

			Map<String,Object> datosReporte = null;		
			AsignacionReporte asignacionReporte = null;
			Map<String,Object> arriboReporte = null;
			InsertarTermino insertarTermino = null;
			InsertarGestion insertarGestion = null;
			
			CoberturasL solicitarCobertura = null;
			
			List<Grua> gruas = new ArrayList<Grua>();
			Grua solicitarGrua = null;
			
			List<com.aaq.col.clases.pojo.conclusion.Abogado> abogados = new ArrayList<com.aaq.col.clases.pojo.conclusion.Abogado>();
			com.aaq.col.clases.pojo.conclusion.Abogado abogado = null;
			
			
			List<Reparacion> reparacion = new ArrayList<Reparacion>();
			Reparacion solicitarReparacion = null;
			
			List<Reparacion> reparacionMovil = new ArrayList<Reparacion>();
			Reparacion solicitarReparacionMovil = null;
			
			List<PaseMedico> paseMedico = new ArrayList<PaseMedico>();
			PaseMedico solicitarPaseMedico = null;
			
			List<InformacionAbogado> listaAbogadoInfo = new ArrayList<InformacionAbogado>();
			InformacionAbogado infoAbogado = null;
			
			ReporteMovilSac reporteMovilSac = null;
			try {
			 reporteMovilSac = this.reporteMovilSacDao.objetoReporteMovilSac(numReporte,null);
			} catch (RollbackException | ClassCastException |TransactionSystemException | NoResultException e) {
				this.loggerAvisos.error("Excepcion en objetoReporteMovilSac: "+e);
			} catch (PersistenceException | TransactionException | NoClassDefFoundError e) {
				this.loggerAvisos.error("Excepcion en objetoReporteMovilSac: "+e);
			}
			
			List<ExpedienteEjecutivo> expedienteEjecutivo = new ArrayList<ExpedienteEjecutivo>();
			try {
				expedienteEjecutivo = this.expedienteEjecutivoService.listaDocumentos(numReporte, claveAjustador);
			} catch (final IllegalArgumentException | NoResultException | ClassCastException |
					DataAccessException | NonUniqueResultException | RollbackException | TransactionSystemException e) {
				this.loggerAvisos.error("Excepcion en tableroEjecutivoService.listaDocumentos: "+e);
			} catch (final PersistenceException | TransactionException e) {
				this.loggerAvisos.error("Excepcion en tableroEjecutivoService.listaDocumentos: "+e);
			}
			
			Map<String, Object> infoDUA = new HashMap<String, Object>();
			try {
				infoDUA = this.conclusionSiniestro.obtenerInformacionDUA(numReporte);
			}catch (Exception e) {
				this.loggerAvisos.error("Excepcion en conclusionSiniestro.obtenerInformacionDUA: "+e);
			}
			
		 if (expedienteEjecutivo != null) {
			if (expedienteEjecutivo.size() > 0) {
				String recorrer = "";
				for (int i = 0; i < expedienteEjecutivo.size(); i++) {
					if (expedienteEjecutivo.get(i).getNombreExpediente().contains("Formato Declaración Universal")) {
							respuesta.setDocDua(expedienteEjecutivo.get(i).getNombreExpediente());
					}
					if (expedienteEjecutivo.get(i).getNombreExpediente().contains("Formato Admisión Autos")) {
						respuesta.setDocAdmAutos(expedienteEjecutivo.get(i).getNombreExpediente());
					}
					if (expedienteEjecutivo.get(i).getNombreExpediente().contains("Formato Asignación Abogado")) {
						respuesta.setDocAsigAbogado(expedienteEjecutivo.get(i).getNombreExpediente());
					}
					if (expedienteEjecutivo.get(i).getNombreExpediente().contains("Formato Encuesta Servicio")) {
//						recorrer = recorrer + tableroEjecutivo.get(i).getNombreFormato() + ", ";
						respuesta.setDocEncuesta(expedienteEjecutivo.get(i).getNombreExpediente());
					}
					if (expedienteEjecutivo.get(i).getNombreExpediente().contains("Formato Admisión Pesado")) {
						respuesta.setDocAdmEquipoP(expedienteEjecutivo.get(i).getNombreExpediente());
					}
				}
//				doc = StringUtils.removeEnd(recorrer, ", ")+".";
//				respuesta.setDocEntregados(doc);
			}
		 }
			
			for (HistoricoResumenAjustador historicoResumenAjustador : datos) {
				
				// Se obtienen para la seccion datos del reporte
				if(datosReporte == null) datosReporte = historicoResumenAjustador.getDatosReporte();
				
				// Datos de la asignacion
				if(asignacionReporte == null) asignacionReporte = historicoResumenAjustador.getActividadAsignacionReporte();									

				// Datos del arribo
				if(arriboReporte == null) arriboReporte = historicoResumenAjustador.getActividadArribo();
				
				// Datos de termino
				if(insertarTermino == null) insertarTermino = historicoResumenAjustador.getActividadTerminoReporte();
				
				// Listas
				
				// coberturas
				if(solicitarCobertura == null) solicitarCobertura = historicoResumenAjustador.getActividadInsertarCoberturaN();
							
				// recuperos y terceros
				if ( insertarGestion == null ) {
					insertarGestion = historicoResumenAjustador.getActividadInsertarGestion();
				}else {
					
						insertarGestion = historicoResumenAjustador.getActividadInsertarGestion();
								
				}
				
				solicitarReparacion = historicoResumenAjustador.getActividadReparacion();
				if (solicitarReparacion != null)  reparacion.add(solicitarReparacion);
				
				solicitarReparacionMovil = historicoResumenAjustador.getActividadReparacionMovil();
				if (solicitarReparacionMovil != null)  reparacionMovil.add(solicitarReparacionMovil);
				
				
				solicitarPaseMedico = historicoResumenAjustador.getActividadPaseMedico();
				if (solicitarPaseMedico != null) paseMedico.add(solicitarPaseMedico);
				
				// gruas
				solicitarGrua = historicoResumenAjustador.getActividadSolicitarServicioGrua();
				if(solicitarGrua != null) gruas.add(solicitarGrua);			

				// abogados
				abogado= historicoResumenAjustador.getActividadSolicitarAbogado();
				if(abogado != null) abogados.add(abogado);
			
				//Información Abogado
				infoAbogado = historicoResumenAjustador.getActividadInfoAbogado();
				if (infoAbogado != null) listaAbogadoInfo.add(infoAbogado);
			}
			
			
			if(reporteMovilSac!=null){
				respuesta.setPoliza(reporteMovilSac.getGeneralNumeroPoliza());
				respuesta.setInciso(reporteMovilSac.getGeneralInciso());
				respuesta.setClaveAgente(reporteMovilSac.getClaveAgente());
				respuesta.setNombreAsegurado(reporteMovilSac.getGeneralNombreAsegurado());
				respuesta.setNombreConductor(reporteMovilSac.getConductorNombre());
				respuesta.setCorreoAsegurado(reporteMovilSac.getGeneralCorreoAsegurado());
				respuesta.setMarca(reporteMovilSac.getVehiculoMarca());
				respuesta.setModelo(reporteMovilSac.getVehiculoModelo());
				respuesta.setVehiculoSerie(reporteMovilSac.getVehiculoSerie());
				respuesta.setPlacas(reporteMovilSac.getVehiculoPlacas());
				respuesta.setColor(reporteMovilSac.getVehiculoColor());
				
				//Ubicacion para InfoSiniestro
				respuesta.setUbicacionSiniestro(reporteMovilSac.getUbicacionDireccion());
				respuesta.setColonia(reporteMovilSac.getUbicacionColoniaDesc());
				respuesta.setCiudad(reporteMovilSac.getUbicacionEntidad());
				respuesta.setMunDeleg(reporteMovilSac.getUbicacionMunicipio());
				respuesta.setNumSiniestro(reporteMovilSac.getGeneralNumeroSiniestro());
			}
			
			
			if(datosReporte!=null){
				respuesta.setCodigoCausa(reporteMovilSac.getAjusteCodigoCausa());
				respuesta.setFechaOcurrido(reporteMovilSac.getFechaOcurrido());
				respuesta.setReporte((String)datosReporte.get("reporte"));
				respuesta.setCausaAccidente(reporteMovilSac.getGeneralComoOcurrio());
				
			}
			
			if(asignacionReporte!=null ){
				respuesta.setFechaAsig((Date)asignacionReporte.getFecha());
			}
			
			if(arriboReporte!=null){
				//Validamos el arribo para tomarlo de ReporteMovilSac
				try {
					if(reporteMovilSac!=null) {
						if (StringUtils.isNotBlank(reporteMovilSac.getAjusteFechaArriboAjustador()) &&
								StringUtils.isNotBlank(reporteMovilSac.getAjusteHoraArriboAjustador()) ) {
							UtileriaCadenas utileria = new UtileriaCadenas();
							Date fechaArribo = utileria.convertirFecha(reporteMovilSac.getAjusteFechaArriboAjustador(),
									reporteMovilSac.getAjusteHoraArriboAjustador());
							respuesta.setFechaArribo(fechaArribo);

						} else {
							respuesta.setFechaArribo((Date)arriboReporte.get("fecha"));

						}
					} else {
						respuesta.setFechaArribo((Date)arriboReporte.get("fecha"));

					}
				} catch (Exception e) {
					respuesta.setFechaArribo((Date)arriboReporte.get("fecha"));
					this.loggerAvisos.error("Exception en arriboReporte: "+e);
				}
			}
			
			if(insertarTermino!=null){
				respuesta.setFechaTermino((Date)insertarTermino.getFecha());
				respuesta.setResponsabilidadTermino(insertarTermino.getCodigoResp());
			}
			
			if (infoDUA != null) {
			 try {
//				Gson json= new Gson();
//				String infoDua = json.toJson(infoDUA);
//				log.info("JSON:"+infoDua);
				if (infoDUA.get("respuesta") != null ) {
					if ( !(infoDUA.get("respuesta").toString().contains("ERROR")) ) {
						if (infoDUA.get("narracion") != null ) {
							respuesta.setNarracion(infoDUA.get("narracion").toString());
						}
						if (infoDUA.get("nombreConductor") != null) {
							respuesta.setNombreTitular(infoDUA.get("nombreConductor").toString());
						}
						
						if (infoDUA.get("croquis") != null ) {
							
							String croquis = infoDUA.get("croquis").toString();

							InputStream targetCroquis = null;

							if (croquis != null && !croquis.isEmpty()) {

								byte[] bytesCroquis = Base64Decoder.decode(croquis);

								targetCroquis = new ByteArrayInputStream(bytesCroquis);
								respuesta.setCroquis(targetCroquis);
							}
							
						}
						
						//Nuevos 
						if (infoDUA.get("conclusion") != null ) {
							respuesta.setDeslindeResponsabilidad(infoDUA.get("conclusion").toString());
						}
						
						if (infoDUA.get("firmaConductor") != null ) {
							String firmaConductor = infoDUA.get("firmaConductor").toString();
							InputStream targetFirmaC = null;
							if (firmaConductor != null && !firmaConductor.isEmpty()) {
								byte[] bytesFirmaC = Base64Decoder.decode(firmaConductor);
								targetFirmaC = new ByteArrayInputStream(bytesFirmaC);
								respuesta.setFirmaConductor(targetFirmaC);
								respuesta.setFirmaConductorT(targetFirmaC);
							}
							
						}
						
						if (infoDUA.get("firmaConductor") != null ) {
							String firmaConductorT = infoDUA.get("firmaConductor").toString();
							InputStream targetFirmaCT = null;
							if (firmaConductorT != null && !firmaConductorT.isEmpty()) {
								byte[] bytesFirmaCT = Base64Decoder.decode(firmaConductorT);
								targetFirmaCT = new ByteArrayInputStream(bytesFirmaCT);
								respuesta.setFirmaConductorT(targetFirmaCT);
							}
							
						}
					}
				}
			 } catch (RollbackException | TransactionException | ClassCastException | IllegalArgumentException  | IllegalStateException | NoResultException e) {
				this.loggerAvisos.error("Exception infoDUA: "+e);
			}  catch (PersistenceException | TransactionSystemException e) {
				this.loggerAvisos.error("Exception infoDUA: "+e);
			}
			}
			
			try {
				respuesta.setAjustador((String)datosReporte.get("Ajustador"));
			} catch ( ClassCastException  | IndexOutOfBoundsException | PersistenceException | TransactionException e) {
				this.loggerAvisos.error("Excepcion datosReporte.Ajustador: "+e);
			} catch (TransactionSystemException  e) {
				this.loggerAvisos.error("Excepcion datosReporte.Ajustador: "+e);
			} 
			
			if (reparacion.size() > 0 ) {
				respuesta.setReparacion(reparacion);
			}
			
			if (paseMedico.size() > 0) {
				respuesta.setPaseMedico(paseMedico);
			}
			
			
			if (equipoPesado) {
				if ( !gruas.isEmpty()) {
					List<GruaEquipoPesado> listaGruasEquipoPesado = new ArrayList<>();
					for (int i = 0; i < gruas.size(); i++) {
						GruaEquipoPesado gruaEquipoPesado = new GruaEquipoPesado();
						gruaEquipoPesado.setClaveProveedor(gruas.get(i).getClaveProveedor());
						gruaEquipoPesado.setCodigoGrua(gruas.get(i).getCodigoGrua());
						gruaEquipoPesado.setFecha(gruas.get(i).getFecha());
						gruaEquipoPesado.setProveedorNombre(gruas.get(i).getProveedorNombre());
						gruaEquipoPesado.setTipoAfectado(gruas.get(i).getTipoAfectado());
						gruaEquipoPesado.setRespuestaGruasColi(gruas.get(i).getRespuestaGruasColi());
						// Nuevos datos
						
						listaGruasEquipoPesado.add(gruaEquipoPesado);
					}
					respuesta.setSolicitarGruaEP(listaGruasEquipoPesado);
				}
			} else {
				if(!gruas.isEmpty()) respuesta.setSolicitarGrua(gruas);
			}
			

			//Recorrer coberturas para modificar  monto
			DecimalFormatoUtil utileriaD = new DecimalFormatoUtil();
			List<com.aaq.col.clases.pojo.conclusion.Coberturas>  estimaciones = new ArrayList<>();
			if (solicitarCobertura != null) {
				if (solicitarCobertura.getCoberturas().size() > 0) {
					try {
						for (int i = 0; i < solicitarCobertura.getCoberturas().size(); i++) {
							com.aaq.col.clases.pojo.conclusion.Coberturas cob = new com.aaq.col.clases.pojo.conclusion.Coberturas();
							cob.setClaveCobertura(solicitarCobertura.getCoberturas().get(i).getClaveCobertura());
							cob.setDecClaveCobertura(solicitarCobertura.getCoberturas().get(i).getDecClaveCobertura());
							cob.setMonto(utileriaD.obtenerCifra(solicitarCobertura.getCoberturas().get(i).getMonto(), reporteMovilSac.getGeneralMonedaNombre()));
							estimaciones.add(cob);
						}
					} catch ( Exception e) {
						this.loggerAvisos.error("Exception en Coberturas: "+e);
					}
				}
			}
			
			if(solicitarCobertura !=null) respuesta.setCoberturas(estimaciones);
			//Modificar Datos de Abogado
			try {
				HoraConsultaUtil utilFecha = new HoraConsultaUtil();
		 if (listaAbogadoInfo != null) {
			if(listaAbogadoInfo.size() > 0) {
				Gson infoAbo = new Gson();
				String infoAbogadoS = infoAbo.toJson(listaAbogadoInfo);
				this.loggerAvisos.info("Informacion de Abogado: "+infoAbogadoS);
				List<com.aaq.col.clases.pojo.conclusion.Abogado> abogadoCompleto = new ArrayList<com.aaq.col.clases.pojo.conclusion.Abogado>();
					for (int i = 0; i < abogados.size(); i++) {
						com.aaq.col.clases.pojo.conclusion.Abogado abogadoInfo = new com.aaq.col.clases.pojo.conclusion.Abogado();
						abogadoInfo.setFecha( utilFecha.transformarFecha(listaAbogadoInfo.get(0).getFechaAsignacion()));
						abogadoInfo.setNombreAbogado(listaAbogadoInfo.get(0).getNombreAbogado());
						abogadoInfo.setClaveAbogado(listaAbogadoInfo.get(0).getClaveAbogado());
						abogadoInfo.setDescripPresentarse(abogados.get(i).getDescripPresentarse());
						abogadoInfo.setConductorDetenido(abogados.get(i).getConductorDetenido());
						abogadoInfo.setNombreCoordJuridico(listaAbogadoInfo.get(0).getNombreCoordJuridico());
						abogadoInfo.setTelCoordJuridico(listaAbogadoInfo.get(0).getTelCoordJuridico());
					abogadoCompleto.add(abogadoInfo);
					}
					respuesta.setAbogados(abogadoCompleto);
			} else {
					respuesta.setAbogados(abogados);
			} }
			} catch (Exception e) {
				this.loggerAvisos.error("Exception en listaAbogadoInfo: "+e);
			}
			
			//Modificar Datos de Reapacion / Se añaden datos del supervisor
			try {
				if (reparacion != null) {
					if( !reparacion.isEmpty()) { 
						respuesta.setReparacion(reparacion);
					} else {
					respuesta.setReparacion(reparacionMovil);
					}	
				} else {
					respuesta.setReparacion(reparacionMovil);
				}
			
			} catch (Exception e) {
				this.loggerAvisos.error("Exception en reparacion: "+e);
			}
				
			if(respuesta.getAjustador()!=null) return respuesta;
			else return null;
		}	

		@Override
		public void generaReporteAjustadoresResumenN(String reporte,
				String claveAjustador, String actividad, Date fechaInicial,
				Date fechaFinal, OutputStream ou, String ruta, String cedulaAjustador) {
		
		
			List<ReporteResumenAjustN> reportesResumenes= new ArrayList<ReporteResumenAjustN>();
			
			List<HistoricoResumenAjustador> resumens = 
					this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustador(reporte, claveAjustador, actividad, fechaInicial, fechaFinal);
			
			for (HistoricoResumenAjustador historicoResumenAjustador : resumens) {
				
				List<HistoricoResumenAjustador> resultado = 
						this.listaDeHistoricoResumenAjustador(historicoResumenAjustador.getGeneralNumeroReporte());
				ReporteResumenAjustN datosParseados= this.parseaDatosN(resultado,historicoResumenAjustador.getGeneralNumeroReporte(),ruta, claveAjustador, false);
				if(datosParseados!=null)
				reportesResumenes.add(datosParseados);
				
			}

			List<HistoricoResumenAjustador> resultado = this.listaDeHistoricoResumenAjustador(reporte);
			ReporteResumenAjustN datosParseados=this.parseaDatosN(resultado, reporte,ruta, claveAjustador, false);
			
			
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
			titulos.put("reporte" , reporte );
			titulos.put("fechaAsig", datosParseados.getFechaAsig());
			titulos.put("codigoCausa", datosParseados.getCodigoCausa() );
			titulos.put("fechaTermino", datosParseados.getFechaTermino());
			titulos.put("fechaArribo", datosParseados.getFechaArribo());
			titulos.put("ubicacionSiniestro", datosParseados.getUbicacionSiniestro() );
			titulos.put("colonia" , datosParseados.getColonia());
			titulos.put("ciudad" , datosParseados.getCiudad() );
			titulos.put("coberturasD" , datosParseados.getCoberturasD());
			titulos.put("solicitarGruaD" , datosParseados.getSolicitarGruaD());
			titulos.put("reparacionD" , datosParseados.getReparacionD());
			titulos.put("paseMedicoD", datosParseados.getPaseMedicoD());
			titulos.put("abogadosD", datosParseados.getAbogadosD());
			
			//Nuevos
			titulos.put("munDeleg", datosParseados.getMunDeleg());
			titulos.put("numSiniestro", datosParseados.getNumSiniestro());
			titulos.put("firmaConductor", datosParseados.getFirmaConductor());
			titulos.put("causaAccidente", datosParseados.getCausaAccidente());
			titulos.put("responsabilidadTermino", datosParseados.getResponsabilidadTermino());
			titulos.put("docEntregados", datosParseados.getDocEntregados());
			titulos.put("nombreTitular", datosParseados.getNombreTitular());
			this.loggerAvisos.info("Firma Titular: "+ datosParseados.getFirmaConductorT());
			titulos.put("firmaConductorT", datosParseados.getFirmaConductorT());

			try {
				this.generaPDFN(titulos ,ruta,ou);
			} catch (JRException e) {
				this.loggerAvisos.info(e);
			}
		
		}
		
		private void generaPDFN(Map<String, Object> titulos,String ruta,OutputStream ou) throws JRException {
			JasperReport reporte = null;
			ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
			this.loggerAvisos.info("Ruta del jasper: "+ruta);
			
			try {
				reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta+"ajustadorNuevo.jasper");
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, titulos, new JREmptyDataSource());

			//Export PDF
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
			exporter.exportReport();
			
			if(baos!=null){
			    byte[] arr = baos.toByteArray();
			    ou.write(arr); 
			}	
			}catch (JRException  e) {
				this.loggerAvisos.info("Ocurrio un error al obtener JASPER: "+e);
			} catch (IOException e) {
				this.loggerAvisos.info("Ocurrio un error: "+e);
			}

		}
		
		
		@Override
		public boolean generaReporteDeslindeResponsabilidad(String reporte, String asegurado, String conductor, String siniestro,
		String ajustador,  Map<String, Object> dua, OutputStream ou, String ruta, String responsable, String conclusiones) {
		
			
			Map<String, Object> titulos = new HashMap<String, Object>();
			titulos.put("path", ruta);
			titulos.put("asegurado",asegurado);
			titulos.put("reporte",reporte);
			titulos.put("conductor", conductor);
			titulos.put("siniestro", siniestro);
			titulos.put("ajustador", ajustador);
			titulos.put("responsable", responsable);
			titulos.put("conclusiones", conclusiones);

			if (dua != null) {
				if (dua.get("respuesta") != null ) {
					if ( !(dua.get("respuesta").toString().contains("ERROR")) ) {
						if (dua.get("narracion") != null ) {
							titulos.put("declaracionAsegurado",dua.get("narracion").toString());
						}
						if (dua.get("nombreConductor") != null) {
							titulos.put("nombreTitular", dua.get("nombreConductor").toString());
						}
						if (dua.get("croquis") != null ) {
							
							String croquis = dua.get("croquis").toString();

//							this.loggerAvisos.info("CROQUIS: "+croquis);

							InputStream targetCroquis = null;

							if (croquis != null && !croquis.isEmpty()) {

								byte[] bytesCroquis = Base64Decoder.decode(croquis);

								targetCroquis = new ByteArrayInputStream(bytesCroquis);
							}
								titulos.put("croquis", targetCroquis);
							}
						
							if (dua.get("firmaConductor") != null ) {
							
							String firmaConductor = dua.get("firmaConductor").toString();

//							this.loggerAvisos.loggerAvisos.info("firmaConductor: "+firmaConductor);

							InputStream targetFirmaCond = null;

							if (firmaConductor != null && !firmaConductor.isEmpty()) {

								byte[] bytesFirmaConductor = Base64Decoder.decode(firmaConductor);

								targetFirmaCond = new ByteArrayInputStream(bytesFirmaConductor);
							}
								titulos.put("firmaConductor", targetFirmaCond);
							}
							
						}
					}
				}
			
			try {
				this.generaPDFDeclaracion(titulos ,ruta,ou);
				return true;
			} catch (JRException e) {
				return false;
			}
		
		}
		
		private void generaPDFDeclaracion(Map<String, Object> titulos,String ruta,OutputStream ou) throws JRException {
			JasperReport reporte = null;
			ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
		
			try {
				reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta+"DeslindeResponsabilidad.jasper");
			
			Map<String, Object> map= new HashMap<String,Object>();
			map = titulos;
			
//			Gson json = new Gson();
//			 String datosLlenar = json.toJson(map);
			 
			JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, map, new JREmptyDataSource());
			//Export PDF
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
			exporter.exportReport();
			
			if(baos!=null){
			    byte[] arr = baos.toByteArray();
			    ou.write(arr); 
			}	
			}catch (JRException  e) {
				this.loggerAvisos.info("Ocurrio un error al obtener JASPER: "+e);
			} catch (IOException e) {
				this.loggerAvisos.info("Ocurrio un error: "+e);
			}

		}

		
		@Override
		public void generaReporteAjustadoresResumenWeb(String reporte, String claveAjustador, String actividad, Date fechaInicial, Date fechaFinal, OutputStream ou, String ruta) {
		
		
			List<HistoricoResumenAjustador> resultado = new ArrayList<HistoricoResumenAjustador>();
			ReporteResumenAjustN datosParseados = new ReporteResumenAjustN();
			List<HistoricoResumenAjustador> resumens = new ArrayList<HistoricoResumenAjustador>(); 
			List<HistoricoResumenAjustador> resultadoWeb = new ArrayList<HistoricoResumenAjustador>();
					
			ReporteMovilSac reporteSac = null;
			if (reporte != null) {
				 reporteSac = this.reporteMovilSacDao.objetoReporteMovilSac(reporte, null);
			}
			
			if (reporteSac != null) {
				if (claveAjustador == null) {
					resumens = 	this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustador(reporte, reporteSac.getAjusteAjustadorCodigo(), actividad, fechaInicial, fechaFinal);	
				}
			}
			
		   if (reporte == null) {
				resumens =  this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustador(null, claveAjustador, actividad, fechaInicial, fechaFinal);
			}
		
			
			if (resumens.size() > 0 ) {
				resultado.add(resumens.get(0));
			} else {
				return ;
			}
			Gson jsonResumen = new Gson();
			String jsonCadena= 	jsonResumen.toJson(resumens);
			this.loggerAvisos.info("Resulando de lista: "+jsonCadena);
			
			// Obtener clave Ajustador o Reporte, depende el caso.
			if (reporte != null) {
				 resultadoWeb = this.listaDeHistoricoResumenAjustador(reporte);
			}
			if (claveAjustador != null) {
				resultadoWeb = this.listaDeHistoricoResumenAjustador(resumens.get(0).getGeneralNumeroReporte());
			}

			if (reporteSac != null) {
				 datosParseados=this.parseaDatosN(resultadoWeb, reporte,ruta, reporteSac.getAjusteAjustadorCodigo(), false);
			}
		
			// Buscar por clave Ajustador 
			if (claveAjustador != null) {
				datosParseados = this.parseaDatosN(resultadoWeb, resultado.get(0).getGeneralNumeroReporte(), ruta, claveAjustador, false);
			}
			Terminal terminal = null;
			try {
				 terminal =  this.terminalService.objetoTerminalParaProveedorYPasswd(resumens.get(0).getClaveAjustador(), null);
			} catch (Exception e) {
			}
			
			Map<String, Object> titulos = new HashMap<String, Object>();
			titulos.put("path", ruta);
			titulos.put("ajustador" , datosParseados.getAjustador());
			titulos.put("croquis" , datosParseados.getCroquis());
			if (terminal != null) {
				titulos.put("cedulaAjustador" , terminal.getCedulaAjustador());
			}
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
			titulos.put("reporte" , reporte );
			titulos.put("fechaAsig", datosParseados.getFechaAsig());
			titulos.put("codigoCausa", datosParseados.getCodigoCausa() );
			titulos.put("fechaTermino", datosParseados.getFechaTermino());
			titulos.put("fechaArribo", datosParseados.getFechaArribo());
			titulos.put("ubicacionSiniestro", datosParseados.getUbicacionSiniestro() );
			titulos.put("colonia" , datosParseados.getColonia());
			titulos.put("ciudad" , datosParseados.getCiudad() );
			titulos.put("coberturasD" , datosParseados.getCoberturasD());
			titulos.put("solicitarGruaD" , datosParseados.getSolicitarGruaD());
			titulos.put("reparacionD" , datosParseados.getReparacionD());
			titulos.put("paseMedicoD", datosParseados.getPaseMedicoD());
			titulos.put("abogadosD", datosParseados.getAbogadosD());
			
			//Nuevos
			titulos.put("munDeleg", datosParseados.getMunDeleg());
			titulos.put("numSiniestro", datosParseados.getNumSiniestro());
			titulos.put("firmaConductor", datosParseados.getFirmaConductor());
			titulos.put("causaAccidente", datosParseados.getCausaAccidente());
			titulos.put("responsabilidadTermino", datosParseados.getResponsabilidadTermino());
			titulos.put("docEntregados", datosParseados.getDocEntregados());
			titulos.put("nombreTitular", datosParseados.getNombreTitular());
//			this.loggerAvisos.info("Firma Titular: "+ datosParseados.getFirmaConductorT());
			titulos.put("firmaConductorT", datosParseados.getFirmaConductorT());

			try {
				this.generaPDFN(titulos ,ruta,ou);
			} catch (JRException e) {
				this.loggerAvisos.error(e);
			}
		
		}
		
		
		@Override
		public void generaReporteAjustadoresResumenFreqWeb(String reporte, List <String> claveAjustador, String actividad, Date fechaInicial,
				Date fechaFinal, OutputStream ou, String ruta)  {

			ReporteResumenAjustN datosParseados = new ReporteResumenAjustN();
			List<HistoricoResumenAjustador> resumens = new ArrayList<HistoricoResumenAjustador>(); 
			List<HistoricoResumenAjustador> resultadoWeb = new ArrayList<HistoricoResumenAjustador>();
			
			ReporteMovilSac reporteSac = null;
			if (reporte != null) {
				 reporteSac = this.reporteMovilSacDao.objetoReporteMovilSac(reporte, null);
			}
			
			if (reporteSac != null) {
				if (claveAjustador == null) {
					resumens = 	this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustador(reporte, reporteSac.getAjusteAjustadorCodigo(), actividad, fechaInicial, fechaFinal);	
				}
			}
			
			if (claveAjustador != null) {
				resumens = this.historicoResumenAjustadorDao.listaDeHistoricoResumenAjustadorFreqWeb(reporte, claveAjustador, actividad, fechaInicial, fechaFinal);
			}
			
			Gson jsonResumen = new Gson();
			String jsonCadena= 	jsonResumen.toJson(resumens);
			this.loggerAvisos.info("Resultando de lista: "+jsonCadena);
			
			// Obtener clave Ajustador o Reporte, depende el caso.
			if (reporte != null) {
				 resultadoWeb = this.listaDeHistoricoResumenAjustador(reporte);
			}
			if (claveAjustador != null) {
				resultadoWeb = this.listaDeHistoricoResumenAjustador(resumens.get(0).getGeneralNumeroReporte());
			}

			if (reporte  != null) {
				datosParseados=this.parseaDatosN(resultadoWeb, reporte,ruta,reporteSac.getAjusteAjustadorCodigo(), false);
			}
			
			if (claveAjustador != null) {
				datosParseados=this.parseaDatosN(resultadoWeb, resumens.get(0).getGeneralNumeroReporte(),ruta, claveAjustador.get(0), false);
			}
			
			Terminal terminal = null;
			try {
				 terminal =  this.terminalService.objetoTerminalParaProveedorYPasswd(resumens.get(0).getClaveAjustador(), null);
			} catch (Exception e) {
			}
			
			Map<String, Object> titulos = new HashMap<String, Object>();
			titulos.put("path", ruta);
			titulos.put("ajustador" , datosParseados.getAjustador());
			titulos.put("croquis" , datosParseados.getCroquis());
			if (terminal != null) {
				titulos.put("cedulaAjustador" , terminal.getCedulaAjustador());
			}
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
			titulos.put("reporte" , reporte );
			titulos.put("fechaAsig", datosParseados.getFechaAsig());
			titulos.put("codigoCausa", datosParseados.getCodigoCausa() );
			titulos.put("fechaTermino", datosParseados.getFechaTermino());
			titulos.put("fechaArribo", datosParseados.getFechaArribo());
			titulos.put("ubicacionSiniestro", datosParseados.getUbicacionSiniestro() );
			titulos.put("colonia" , datosParseados.getColonia());
			titulos.put("ciudad" , datosParseados.getCiudad() );
			titulos.put("coberturasD" , datosParseados.getCoberturasD());
			titulos.put("solicitarGruaD" , datosParseados.getSolicitarGruaD());
			titulos.put("reparacionD" , datosParseados.getReparacionD());
			titulos.put("paseMedicoD", datosParseados.getPaseMedicoD());
			titulos.put("abogadosD", datosParseados.getAbogadosD());
			
			//Nuevos
			titulos.put("munDeleg", datosParseados.getMunDeleg());
			titulos.put("numSiniestro", datosParseados.getNumSiniestro());
			titulos.put("firmaConductor", datosParseados.getFirmaConductor());
			titulos.put("causaAccidente", datosParseados.getCausaAccidente());
			titulos.put("responsabilidadTermino", datosParseados.getResponsabilidadTermino());
			titulos.put("docEntregados", datosParseados.getDocEntregados());
			titulos.put("nombreTitular", datosParseados.getNombreTitular());
//			this.loggerAvisos.info("Firma Titular: "+ datosParseados.getFirmaConductorT());
			titulos.put("firmaConductorT", datosParseados.getFirmaConductorT());

			try {
				this.generaPDFN(titulos ,ruta,ou);
			} catch (JRException e) {
				this.loggerAvisos.error(e);
			}
		}
		
	
}