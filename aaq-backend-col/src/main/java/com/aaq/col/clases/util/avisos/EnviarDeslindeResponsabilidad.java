package com.aaq.col.clases.util.avisos;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
//import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//import java.util.Base64;

//import org.apache.commons.io.FileUtils;
//import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.castor.util.Base64Decoder;
import org.springframework.scheduling.annotation.Async;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.path.ProveedorApplicationContext;
import com.aaq.col.clases.pojo.conclusion.DocEntregados;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.CorreoFirmaImagAsync;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class EnviarDeslindeResponsabilidad {

	
Log4JLogger loggerAvisos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.avisos");
	
	//********Nuevo método para el envio de correo de resumen ajustador**********
	
	@Async
	public boolean correoDeslindeRespons(ReporteMovilSac reporteSac, String nombreAjustador, Map<String, Object> dua, 
			String responsabilidad, DocEntregados docEntregado, String claveAcc){
	try {
		String ruta = null;
		String email = null;
//		String rutaCausas = null;
		try {	
			ruta = ProveedorApplicationContext.getApplicationContext().getResource("/deslinde").getFile().getPath() + "/";
//			rutaCausas = ProveedorApplicationContext.getApplicationContext().getResource("/deslinde/causas").getFile().getPath() + "/";
		} catch (Exception e) {
				this.loggerAvisos.error("Ocurrio una excepcion -> "+e);
				return false;
		}
//		 String encodedString = null;
//		if (StringUtils.equalsIgnoreCase(claveAcc, "03")) {
//				try {
//		        File inputFile = new File(rutaCausas+"3.png");
//		        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//		        encodedString = Base64.getEncoder().encodeToString(fileContent);
//		        this.loggerAvisos.info("Imagen");
//				}catch (Exception e) {
//					this.loggerAvisos.error("Error al obtener imagen 1"+e);
//				}
//		}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "07")) {
//			try {
//	        File inputFile = new File(rutaCausas+"7.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "08")) {
//			try {
//	        File inputFile = new File(rutaCausas+"8.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		
//		if (StringUtils.equalsIgnoreCase(claveAcc, "10")) {
//			try {
//	        File inputFile = new File(rutaCausas+"10.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 10"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "11")) {
//			try {
//	        File inputFile = new File(rutaCausas+"11.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "12")) {
//			try {
//	        File inputFile = new File(rutaCausas+"12.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		
//		if (StringUtils.equalsIgnoreCase(claveAcc, "13")) {
//			try {
//	        File inputFile = new File(rutaCausas+"13.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "14")) {
//			try {
//	        File inputFile = new File(rutaCausas+"14.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "15")) {
//			try {
//	        File inputFile = new File(rutaCausas+"15.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "17")) {
//			try {
//	        File inputFile = new File(rutaCausas+"17.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "18")) {
//			try {
//	        File inputFile = new File(rutaCausas+"18.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "19")) {
//			try {
//	        File inputFile = new File(rutaCausas+"19.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "20")) {
//			try {
//	        File inputFile = new File(rutaCausas+"20.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "21")) {
//			try {
//	        File inputFile = new File(rutaCausas+"21.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "22")) {
//			try {
//	        File inputFile = new File(rutaCausas+"22.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "24")) {
//			try {
//	        File inputFile = new File(rutaCausas+"24.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "25")) {
//			try {
//	        File inputFile = new File(rutaCausas+"25.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "26")) {
//			try {
//	        File inputFile = new File(rutaCausas+"26.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "27")) {
//			try {
//	        File inputFile = new File(rutaCausas+"27.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "28")) {
//			try {
//	        File inputFile = new File(rutaCausas+"28.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "29")) {
//			try {
//	        File inputFile = new File(rutaCausas+"29.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "30")) {
//			try {
//	        File inputFile = new File(rutaCausas+"30.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "32")) {
//			try {
//	        File inputFile = new File(rutaCausas+"32.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "33")) {
//			try {
//	        File inputFile = new File(rutaCausas+"33.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}
//		if (StringUtils.equalsIgnoreCase(claveAcc, "34")) {
//			try {
//	        File inputFile = new File(rutaCausas+"34.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "35")) {
//			try {
//	        File inputFile = new File(rutaCausas+"35.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "36")) {
//			try {
//	        File inputFile = new File(rutaCausas+"36.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "37")) {
//			try {
//	        File inputFile = new File(rutaCausas+"37.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "38")) {
//			try {
//	        File inputFile = new File(rutaCausas+"38.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "39")) {
//			try {
//	        File inputFile = new File(rutaCausas+"39.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "40")) {
//			try {
//	        File inputFile = new File(rutaCausas+"40.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "41")) {
//			try {
//	        File inputFile = new File(rutaCausas+"41.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "42")) {
//			try {
//	        File inputFile = new File(rutaCausas+"42.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "44")) {
//			try {
//	        File inputFile = new File(rutaCausas+"44.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "45")) {
//			try {
//	        File inputFile = new File(rutaCausas+"45.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "46")) {
//			try {
//	        File inputFile = new File(rutaCausas+"46.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "47")) {
//			try {
//	        File inputFile = new File(rutaCausas+"47.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "48")) {
//			try {
//	        File inputFile = new File(rutaCausas+"48.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}if (StringUtils.equalsIgnoreCase(claveAcc, "49")) {
//			try {
//	        File inputFile = new File(rutaCausas+"49.png");
//	        byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
//	        encodedString = Base64.getEncoder().encodeToString(fileContent);
//	        this.loggerAvisos.info("Imagen");
//			}catch (Exception e) {
//				this.loggerAvisos.error("Error al obtener imagen 1"+e);
//			}
//	}	
		
		this.loggerAvisos.info("RUTA DE LA CARPETA PARA AVISOS: "+ruta);
		
		Map<String, Object> titulos = new HashMap<String, Object>();
		titulos.put("path", ruta);
		titulos.put("asegurado", reporteSac.getGeneralNombreAsegurado());
		titulos.put("reporte",reporteSac.getGeneralNumeroReporte());
		titulos.put("siniestro", reporteSac.getGeneralNumeroSiniestro());
		titulos.put("ajustador", nombreAjustador);
		titulos.put("causaAccidente", reporteSac.getGeneralComoOcurrio());
		titulos.put("responsabilidadTermino", responsabilidad);
		titulos.put("docEntregados", docEntregado);
		
		titulos.put("docDua", docEntregado.getDua());
		titulos.put("docAdmAutos", docEntregado.getAdmAutos());
		titulos.put("docAsigAbogado", docEntregado.getAsigAbogado());
		titulos.put("docEncuesta", docEntregado.getEncuesta());
		
//		if (claveAcc != null ) {
//			InputStream targetCroquis = null;
//			if (encodedString != null && !encodedString.isEmpty()) {
//				byte[] bytesCroquis = Base64Decoder.decode(encodedString);
//				targetCroquis = new ByteArrayInputStream(bytesCroquis);
//			}
//				titulos.put("croquis", targetCroquis);
//		}
		
		if (dua != null) {
			if (dua.get("respuesta") != null ) {
				if ( !(dua.get("respuesta").toString().contains("ERROR")) ) {
					if (dua.get("narracion") != null ) {
						titulos.put("declaracionAsegurado",dua.get("narracion").toString());
					}
					// Conductor
					if (dua.get("nombreConductor") != null ) {
						titulos.put("conductor",dua.get("nombreConductor").toString());
					}
					//Email Conductor
 					if (dua.get("email_conductor") != null) {
						email = dua.get("email_conductor").toString();
					}
					//Responsable
					// Conductor
					if (dua.get("responsable") != null ) {
						if (dua.get("responsable") == "1") {
							titulos.put("responsable","VEHÍCULO A");
						} else {
							titulos.put("responsable","VEHÍCULO B");
						}
					} else {
						titulos.put("responsable","VEHÍCULO B");
					}
					
					// Conclusiones
//					if (dua.get("conclusion") != null ) {
//						titulos.put("conclusiones",dua.get("conclusion").toString());
//					}
					
					if (dua.get("nombreConductor") != null) {
						titulos.put("nombreTitular", dua.get("nombreConductor").toString());
					}
					if (dua.get("croquis") != null ) {
						
						String croquis = dua.get("croquis").toString();
//						log.info("CROQUIS: "+croquis);
						InputStream targetCroquis = null;
						if (croquis != null && !croquis.isEmpty()) {
							byte[] bytesCroquis = Base64Decoder.decode(croquis);
							targetCroquis = new ByteArrayInputStream(bytesCroquis);
						}
							titulos.put("croquis", targetCroquis);
						}
					
						if (dua.get("firmaConductor") != null ) {
						String firmaConductor = dua.get("firmaConductor").toString();
//						this.loggerAvisos.info("firmaConductor: "+firmaConductor);
						InputStream targetFirmaCond = null;
						if (firmaConductor != null && !firmaConductor.isEmpty()) {
							byte[] bytesFirmaConductor = Base64Decoder.decode(firmaConductor);
							targetFirmaCond = new ByteArrayInputStream(bytesFirmaConductor);
						}
							titulos.put("firmaConductor", targetFirmaCond);
						}
						
					} else {
						this.loggerAvisos.error("Resultado de dua.get(respuesta):"+dua.get("respuesta"));
					}
				}
			}
		
		try {
			 boolean respuesta = this.generaPDFDeclaracion(ruta, reporteSac,titulos, email);
			return respuesta;
		
		}	catch (Exception e) {
			this.loggerAvisos.info("Ocurrio un error -> correoDeslindeRespons -> "+e);
			this.loggerAvisos.error(e.getMessage());
		}
	} catch (ClassCastException | IndexOutOfBoundsException | IllegalArgumentException e) {
		this.loggerAvisos.info("Ocurrio un error -> correoDeslindeRespons -> "+e);
	}
	return false;
	}		
		
	private boolean generaPDFDeclaracion(String ruta, ReporteMovilSac reporteSac, Map<String, Object> datos, String email) {
		try {
		byte[] arr = null;
		JasperReport reporte = null;
		ByteArrayOutputStream baos=new ByteArrayOutputStream(); 
		String asunto = "INFORME DE TU ATENCIÓN";

		reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta+"DeslindeResponsabilidad.jasper");
		JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, datos , new JREmptyDataSource());
	
		//Export PDF
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
		exporter.exportReport();

		if(baos!=null){
		    arr = baos.toByteArray();
		}		
		
		String cuerpoCorreo  = this.cuerpoNotificacionDeslindeR(reporteSac);
		
		//Tratar correos
		String [] listaCorreos = null;		
		ArrayList<String> correos = new ArrayList<String>();
		if(email != null) {
				listaCorreos = email.split(",");
				for(int i = 0; i < listaCorreos.length; i++) {
					correos.add(listaCorreos[i]);
				}
			this.loggerAvisos.info("Tamaño de lista de correos con poliza " + listaCorreos.length);
		}
		
		if (reporteSac.getGeneralCorreoAsegurado() != null) {
			correos.add(reporteSac.getGeneralCorreoAsegurado());
		}
		
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
				correoFirmaImagAsyncObj.enviarEmailAsync(correos,  asunto,  cuerpoCorreo, arr,"informe-de-tu-atencion.pdf", reporteSac.getGeneralNumeroReporte(), ruta,false, false, true);
				return true;
				}catch (Exception e) {
					this.loggerAvisos.info("Ocurrio un error an invocar el metodo correoFirmaImagAsyncObj.enviarEmailAsync: "+e);
				}
			}catch (Exception e) {
				this.loggerAvisos.info("Ocurrio un error CorreoFirmaImagAsync -> "+e);
	        	}
		}
		} catch (JRException e) {
			return false;
		}
		return false;
		
	}
	private String cuerpoNotificacionDeslindeR( ReporteMovilSac reporteMovilSac ) {
		String cuerpoCorreo = null;
		try {
		DateFormat writeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String claveAgente="";
		if (reporteMovilSac != null) {
			if (reporteMovilSac.getClaveAgente() != null) {
				claveAgente = reporteMovilSac.getClaveAgente();
			}
		cuerpoCorreo = "<div><center>\r\n" + 
				"<div style=\"color: #008c99; font-family: Arial,sans-serif; font-size: 24px; font-weight: 600;\">QUÁLITAS COMPAÑÍA DE SEGUROS S.A. DE C.V.</div>\r\n" + 
				"<div style=\"color: #008c99; font-size: 31px; font-weight: 900;\">&nbsp;</div>\r\n" + 
				"</center>\r\n" + 
				"<div>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 12.0pt; font-family: Arial,sans-serif; color: #148c9a;\"> Notificación </span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-size: 12.0pt; font-family: Arial,sans-serif; color: #ae1985;\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Informe de tu Atención.</span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<p style=\"margin: 0cm;\"><strong> <span style=\"font-family: Arial,sans-serif; color: #91167f;\"> Estimado/a Asegurado/a: </span> </strong></p>\r\n" + 
				"<p style=\"margin: 0cm;\"><!-- o ignored -->&nbsp;</p>\r\n" + 
				"<table style=\"border-collapse: collapse; border: none;\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
				"<tbody>\r\n" + 
				"<tr>\r\n" + 
				"<td style=\"border: none; background: #E1F2F4; padding: 10pt 10pt 10pt 10pt; border-radius: 3%;\" valign=\"top\">\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:10pt\">A continuación nos permitimos adjuntar archivo informe de tu atención.\r\n" + 
				"\r\n" + 
				"<!-- o ignored --></p>\r\n" +  
				"</td>\r\n" + 
				"</tr>\r\n" + 
				"</tbody>\r\n" + 
				"</table>\r\n" + 
				"<p style=\"margin: 0cm;\"> <img src='cid:imagenSiniestro' align=\"right\"> &nbsp;</p>\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Numero de Reporte asignado:&nbsp; </span> "+reporteMovilSac.getGeneralNumeroReporte() +"</p>\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt;\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Fecha y hora de arribo:&nbsp;&nbsp; </span> "+ writeFormat.format(  reporteMovilSac.getFechaArribo() )+" </p>\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Tipo de siniestro:&nbsp;&nbsp; </span> "+ reporteMovilSac.getAjusteCodigoCausa() +"</p>\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Nombre del conductor:&nbsp; </span>"+ reporteMovilSac.getConductorNombre()+"</p>\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Localidad donde ocurrió:&nbsp; </span>"+ reporteMovilSac.getUbicacionColoniaDesc() +", " + reporteMovilSac.getUbicacionMunicipio() + ", " + reporteMovilSac.getUbicacionEntidad() +"</p>\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Vehículo:&nbsp; </span>"+ reporteMovilSac.getVehiculoMarca() +"</p>\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Modelo:&nbsp; </span>"+ reporteMovilSac.getVehiculoModelo() +"</p>\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Placas:&nbsp; </span>"+ reporteMovilSac.getVehiculoPlacas() +"</p>\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Num. Serie:&nbsp; </span>"+reporteMovilSac.getVehiculoSerie() +"</p>\r\n" + 
				"<p style=\"margin: 0cm; font-family: Arial,sans-serif; font-size:7pt\"><span style=\"color: #ad1683;\">&nbsp;&nbsp;Agente:&nbsp; </span>"+claveAgente+"</p>\r\n" + 
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
		} catch (ClassCastException | IndexOutOfBoundsException e) {
		}		
		
		return cuerpoCorreo;
		
	}
	

}
