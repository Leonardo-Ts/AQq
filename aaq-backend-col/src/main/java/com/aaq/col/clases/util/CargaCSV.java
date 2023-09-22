	package com.aaq.col.clases.util;
	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.text.ParseException;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Date;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	
	import org.apache.commons.lang3.StringUtils;
	import org.apache.commons.logging.Log;
	import org.apache.commons.logging.LogFactory;

import com.aaq.col.clases.database.entidades.CatalogoAccidentes;
import com.aaq.col.clases.database.entidades.CatalogoAseguradora;
import com.aaq.col.clases.database.entidades.CatalogoClaseVeh;
import com.aaq.col.clases.database.entidades.CatalogoCoberturas;
	import com.aaq.col.clases.database.entidades.CatalogoColores;
import com.aaq.col.clases.database.entidades.CatalogoCredenciales;
import com.aaq.col.clases.database.entidades.CatalogoFaq;
import com.aaq.col.clases.database.entidades.CatalogoGrua;
import com.aaq.col.clases.database.entidades.CatalogoHospitales;
import com.aaq.col.clases.database.entidades.CatalogoMP;
import com.aaq.col.clases.database.entidades.CatalogoMarca;
import com.aaq.col.clases.database.entidades.CatalogoMarcaTerc;
import com.aaq.col.clases.database.entidades.CatalogoPartesAuto;
import com.aaq.col.clases.database.entidades.CatalogoRCBienes;
import com.aaq.col.clases.database.entidades.CatalogoRecuperaciones;
	import com.aaq.col.clases.database.entidades.CatalogoTramoCar;
	import com.aaq.col.clases.database.entidades.CatalogoVehTerc;
	import com.aaq.col.clases.database.entidades.CorreoPolizaAgente;
	import com.aaq.col.clases.database.entidades.Estado;
	import com.aaq.col.clases.database.entidades.Grupo;
	import com.aaq.col.clases.database.entidades.GrupoTerminal;
	import com.aaq.col.clases.database.entidades.HorarioGrupo;
	import com.aaq.col.clases.database.entidades.Horarios;
import com.aaq.col.clases.database.entidades.Municipio;
import com.aaq.col.clases.database.entidades.Terminal;
	import com.opencsv.CSVReader;
	import com.opencsv.exceptions.CsvBadConverterException;
	import com.opencsv.exceptions.CsvBeanIntrospectionException;
	
	@org.springframework.stereotype.Repository(value = "JMPruebaDatabase")
	public class CargaCSV {
	public Log log = LogFactory.getLog(CargaCSV.class);
	private char seprator = ',';
	
	@SuppressWarnings({ "deprecation" })
	public Map<String, Object> loadCSV(File file) throws IOException, ParseException {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	CSVReader csvReader = null;
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<HorarioGrupo> listHorarios = new ArrayList<HorarioGrupo>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo");
	}
	
	validacionArchivo(listHeaders);
	
	String[] nextLine;
	
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	fillSpaces(nextLine);
	HorarioGrupo horario = new HorarioGrupo();
	Grupo grupo = Grupo.getGrupoService().objetoGrupoPorNombre(nextLine[0]);
	// Validar las fechas para el horario:
	if ((StringUtils.isNotBlank(nextLine[1])) && (StringUtils.isNotBlank(nextLine[2]))) {
	//Cambiar formato de fecha final de 00:000:00 a 23:59:59
	HoraConsultaUtil utileria = new HoraConsultaUtil(); 
	  Date fechaInicio = utileria.convertirFecha(nextLine[1]);
	  Date fechaFinal = utileria.convertirFecha(nextLine[2]);
	if (grupo != null) {
	horario.setGrupo(grupo);
	try {
	//HoraConsultaUtil utileria = new HoraConsultaUtil(); 
	//horario.setFechaInicio(utileria.convertirFecha(nextLine[1]));
	//horario.setFechaFin(utileria.convertirFecha(nextLine[2]));
	horario.setFechaInicio(fechaInicio);
	horario.setFechaFin(fechaFinal);
	} catch (ClassCastException | Error e) {
	log.info("Ocurrio un error en las fechas: "+e);
	}
	horario.setClaveHorario(nextLine[3]);
	  }
	}
	
	listHorarios.add(horario);
	horario = null;
	}
	
	if (listHorarios.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	
	result.add(listHorarios); 
	}  catch (CsvBeanIntrospectionException e) {
	log.info("CsvBeanIntrospectionException: "+e);
	throw new CsvBeanIntrospectionException("El formato del archivo que intenta procesar es incorrecto");
	}  catch (IOException e) {
	log.info("IOException: "+e);
	throw new IOException("El formato del archivo que intenta procesar es incorrecto");
	} catch (IllegalArgumentException  e) {
	log.info("IllegalArgumentException: "+e);
	throw new IllegalArgumentException("El formato del archivo que intenta procesar es incorrecto");
	}   finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	} catch (ClassCastException e) {
	log.error(e);
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	}finally {
	csvReader.close();
	}
	return wrapper;
	
	}
	
	@SuppressWarnings({ "deprecation" })
	public Map<String, Object> loadCSVCorreos(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<CorreoPolizaAgente> listPolizas = new ArrayList<CorreoPolizaAgente>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo");
	}
	
	validacionArchivoCorreos(listHeaders);
	
	String[] nextLine;
	try {
	
	
	
	        
	while((nextLine = csvReader.readNext()) != null ) {
	fillSpaces(nextLine);
	CorreoPolizaAgente correos = new CorreoPolizaAgente();
	try {
	 boolean isNumeric =  nextLine[2].matches("[+-]?\\d*(\\.\\d+)?");
	if (nextLine[2].length() > 3 && !(isNumeric) ) {
	correos.setClaveAgente(nextLine[0]);
	correos.setPoliza(nextLine[1]);
	correos.setCorreos(nextLine[2]);
	
	listPolizas.add(correos);
	correos = null;
	}
	} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
	
	}
	}
	
	
	if (listPolizas.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	
	result.add(listPolizas); 
	}  catch (CsvBeanIntrospectionException e) {
	log.error("Error: "+e.getMessage());
	wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
	} finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
	} finally {
	csvReader.close();
	}
	return wrapper;
	
	}
	
	public void validacionArchivo(List<String> listHeaders) throws ParseException {
	 if(listHeaders.size() != 4) {
	 throw new ParseException("El formato que intenta procesar es incorrect", 117);
	 }
	}
	
	public void validacionArchivoCorreos(List<String> listHeaders) throws ParseException {
	 if(listHeaders.size() != 3) {
	 throw new ParseException("El formato que intenta procesar es incorrect", 117);
	 }
	}
	
	public void validacionArchivoCorreos(List<String> listHeaders, int columnas) throws ParseException {
	 if(listHeaders.size() != columnas) {
	 throw new ParseException("El formato que intenta procesar es incorrect", 117);
	 }
	}
	
	public void fillSpaces (String[] nextLine) {
	for(int i = 0; i < nextLine.length; i++) {
	if(nextLine[i].isEmpty()) {
	nextLine[i]="0";
	}
	}
	}
	
	public void validacionArchivoGrupos(List<String> listHeaders) throws ParseException {
	 if(listHeaders.size() != 2) {
	 throw new ParseException("El formato que intenta procesar es incorrect", 117);
	 }
	}
	
	public void validacionArchivoGeneral(List<String> listHeaders, int numero) throws ParseException {
	 if(listHeaders.size() != numero) {
	 throw new ParseException("El formato que intenta procesar es incorrecto, se esperan "+numero+"columnas.", 117);
	 }
	}
	
	
	public char getSeprator() {
	return seprator;
	}
	
	
	public void setSeprator(char seprator) {
	this.seprator = seprator;
	}
	
	@SuppressWarnings({ "deprecation" })
	public Map<String, Object> loadCSVGrupos(File file) throws IOException, ParseException {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	CSVReader csvReader = null;
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<Grupo> listGrupos = new ArrayList<Grupo>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo.");
	}
	
	validacionArchivoGrupos(listHeaders);
	String[] nextLine;
	
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	Grupo grupoNuevo = new Grupo();
	fillSpaces(nextLine);
	Estado edo = Estado.getEstadoService().objetoEstadoNombre(nextLine[0].toUpperCase());
	Grupo grupo = Grupo.getGrupoService().listaDeGrupoEdoNom(edo, nextLine[1]);
	if (grupo == null) {
	grupoNuevo.setEstado(edo);
	grupoNuevo.setHabilitado(true);
	grupoNuevo.setNombre(nextLine[1]);
	}
	
	listGrupos.add(grupoNuevo);
	grupoNuevo = null;
	}
	
	if (listGrupos.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	
	result.add(listGrupos); 
	}  catch (CsvBeanIntrospectionException e) {
	log.info("CsvBeanIntrospectionException: "+e);
	throw new CsvBeanIntrospectionException("El formato del archivo que intenta procesar es incorrecto");
	}  catch (IOException e) {
	log.info("IOException: "+e);
	throw new IOException("El formato del archivo que intenta procesar es incorrecto");
	} catch (IllegalArgumentException  e) {
	log.info("IllegalArgumentException: "+e);
	throw new IllegalArgumentException("El formato del archivo que intenta procesar es incorrecto");
	}   finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	} catch (ClassCastException e) {
	log.error(e);
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	}finally {
	csvReader.close();
	}
	return wrapper;
	
	}
	
	
	@SuppressWarnings({ "deprecation" })
	public Map<String, Object> loadCSVGruposTerminales(File file) throws IOException, ParseException {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	CSVReader csvReader = null;
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<GrupoTerminal> listGrupoTerminal = new ArrayList<GrupoTerminal>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo.");
	}
	
	//validacionArchivoGrupos(listHeaders);
	validacionArchivoGeneral(listHeaders,5);
	String[] nextLine;
	
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	try {
	GrupoTerminal grupoTerminalNuevo = new GrupoTerminal();
	fillSpaces(nextLine);
	Estado edo = Estado.getEstadoService().objetoEstadoNombre(nextLine[0].toUpperCase());
	Grupo grupo = Grupo.getGrupoService().listaDeGrupoEdoNom(edo, nextLine[1]);
	Terminal terminal = Terminal.getTerminalService().objetoTerminalParaProveedorYPasswd(nextLine[2], null);
	if (grupo != null && terminal != null) {
	if (terminal.getGrupo() == null) {
	grupoTerminalNuevo.setGrupo(grupo);
	grupoTerminalNuevo.setTerminal(terminal);
	
	terminal.setGrupo(grupo);
	try {
	if (nextLine[3] != null) {
	terminal.setDiaDescanso(nextLine[3]);
	} else {
	terminal.setDiaDescanso(null);
	}
	} catch (IndexOutOfBoundsException | ClassCastException | IllegalArgumentException e) {
	}
	try {
	if (nextLine[4] != null && StringUtils.isNotBlank(nextLine[4])) {
	if ( !nextLine[4].contains("null")) {
	terminal.setSubGrupo(nextLine[4]);
	} else {
	terminal.setSubGrupo(null);
	}
	}
	} catch (IndexOutOfBoundsException | ClassCastException | IllegalArgumentException e) {
	log.error("Error al cargar sub grupo*********************+e");
	}
	terminal.guardarObjeto();
	}
	}
	
	listGrupoTerminal.add(grupoTerminalNuevo);
	grupoTerminalNuevo = null;
	} catch (Exception e) {
	e.printStackTrace();
	}
	}
	
	if (listGrupoTerminal.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	
	result.add(listGrupoTerminal); 
	}  catch (CsvBeanIntrospectionException e) {
	log.info("CsvBeanIntrospectionException: "+e);
	throw new CsvBeanIntrospectionException("El formato del archivo que intenta procesar es incorrecto");
	}  catch (IOException e) {
	log.info("IOException: "+e);
	throw new IOException("El formato del archivo que intenta procesar es incorrecto");
	} catch (IllegalArgumentException  e) {
	log.info("IllegalArgumentException: "+e);
	throw new IllegalArgumentException("El formato del archivo que intenta procesar es incorrecto");
	}   finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	} catch (ClassCastException e) {
	log.error(e);
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	}finally {
	csvReader.close();
	}
	return wrapper;
	
	}
	
	
	
	@SuppressWarnings({ "deprecation" })
	public Map<String, Object> loadCSVHorarios(File file) throws IOException, ParseException {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	CSVReader csvReader = null;
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<Horarios> listaHorarios = new ArrayList<Horarios>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo.");
	}
	
	//validacionArchivoGrupos(listHeaders);
	validacionArchivoGeneral(listHeaders,9);
	String[] nextLine;
	
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	Horarios horarioL = new Horarios();
	Horarios horarioM = new Horarios();
	Horarios horarioMi = new Horarios();
	Horarios horarioJ = new Horarios();
	Horarios horarioV = new Horarios();
	Horarios horarioS = new Horarios();
	Horarios horarioD = new Horarios();
	
	fillSpaces(nextLine);
	Estado edo = Estado.getEstadoService().objetoEstadoNombre(nextLine[0].toUpperCase());
	List<Horarios> horario = Horarios.getHorariosService().listaDeHorarios(edo, nextLine[1]);
	if (horario.size() == 0) {
	horarioL.setIdentidad_(edo.getId());
	horarioL.setClave_horario(nextLine[1]);
	horarioM.setIdentidad_(edo.getId());
	horarioM.setClave_horario(nextLine[1]);
	horarioMi.setIdentidad_(edo.getId());
	horarioMi.setClave_horario(nextLine[1]);
	horarioJ.setIdentidad_(edo.getId());
	horarioJ.setClave_horario(nextLine[1]);
	horarioV.setIdentidad_(edo.getId());
	horarioV.setClave_horario(nextLine[1]);
	horarioS.setIdentidad_(edo.getId());
	horarioS.setClave_horario(nextLine[1]);
	horarioD.setIdentidad_(edo.getId());
	horarioD.setClave_horario(nextLine[1]);
	//*************** LUNES *************** 
	if (!nextLine[2].equalsIgnoreCase("DESCANSO")) {
	horarioL.setDia_semana("Lunes");
	horarioL.setDia_semana_num(1);
	        String[] horariosES = nextLine[2].split(",");
	        horarioL.setHora_entrada(horariosES[0]);
	        horarioL.setHora_salida(horariosES[1]);
	        horarioL.setEstado(edo);
	
	} else {
	horarioL.setDia_semana("Lunes");
	horarioL.setDia_semana_num(1);
	horarioL.setDescanso(true);
	horarioL.setEstado(edo);
	}
	//*************** Martes *************** 
	if (!nextLine[3].equalsIgnoreCase("DESCANSO")) {
	horarioM.setDia_semana("Martes");
	horarioM.setDia_semana_num(2);
	        String[] horariosES = nextLine[3].split(",");
	        horarioM.setHora_entrada(horariosES[0]);
	        horarioM.setHora_salida(horariosES[1]);
	        horarioM.setEstado(edo);
	
	} else {
	horarioM.setDia_semana("Martes");
	horarioM.setDia_semana_num(2);
	horarioM.setDescanso(true);
	horarioM.setEstado(edo);
	}
	//*************** Miercoles *************** 
	if (!nextLine[4].equalsIgnoreCase("DESCANSO")) {
	horarioMi.setDia_semana("Miércoles");
	horarioMi.setDia_semana_num(3);
	        String[] horariosES = nextLine[4].split(",");
	        horarioMi.setHora_entrada(horariosES[0]);
	        horarioMi.setHora_salida(horariosES[1]);
	        horarioMi.setEstado(edo);
	
	} else {
	horarioMi.setDia_semana("Miércoles");
	horarioMi.setDia_semana_num(3);
	horarioMi.setDescanso(true);
	horarioMi.setEstado(edo);
	}
	//*************** Jueves *************** 
	if (!nextLine[5].equalsIgnoreCase("DESCANSO")) {
	horarioJ.setDia_semana("Jueves");
	horarioJ.setDia_semana_num(4);
	        String[] horariosES = nextLine[5].split(",");
	        horarioJ.setHora_entrada(horariosES[0]);
	        horarioJ.setHora_salida(horariosES[1]);
	        horarioJ.setEstado(edo);
	
	} else {
	horarioJ.setDia_semana("Jueves");
	horarioJ.setDia_semana_num(4);
	horarioJ.setDescanso(true);
	horarioJ.setEstado(edo);
	}
	//*************** Viernes *************** 
	if (!nextLine[6].equalsIgnoreCase("DESCANSO")) {
	horarioV.setDia_semana("Viernes");
	horarioV.setDia_semana_num(5);
	        String[] horariosES = nextLine[6].split(",");
	        horarioV.setHora_entrada(horariosES[0]);
	        horarioV.setHora_salida(horariosES[1]);
	        horarioV.setEstado(edo);
	
	} else {
	horarioV.setDia_semana("Viernes");
	horarioV.setDia_semana_num(5);
	horarioV.setDescanso(true);
	horarioV.setEstado(edo);
	}
	//*************** Sabado *************** 
	if (!nextLine[7].equalsIgnoreCase("DESCANSO")) {
	horarioS.setDia_semana("Sábado");
	horarioS.setDia_semana_num(6);
	        String[] horariosES = nextLine[7].split(",");
	        horarioS.setHora_entrada(horariosES[0]);
	        horarioS.setHora_salida(horariosES[1]);
	        horarioS.setEstado(edo);
	
	} else {
	horarioS.setDia_semana("Sábado");
	horarioS.setDia_semana_num(6);
	horarioS.setDescanso(true);
	horarioS.setEstado(edo);
	}
	//*************** Domingo *************** 
	if (!nextLine[8].equalsIgnoreCase("DESCANSO")) {
	horarioD.setDia_semana("Domingo");
	horarioD.setDia_semana_num(7);
	        String[] horariosES = nextLine[8].split(",");
	        horarioD.setHora_entrada(horariosES[0]);
	        horarioD.setHora_salida(horariosES[1]);
	        horarioD.setEstado(edo);
	
	} else {
	horarioD.setDia_semana("Domingo");
	horarioD.setDia_semana_num(7);
	horarioD.setDescanso(true);
	horarioD.setEstado(edo);
	}
	
	}
	
	listaHorarios.add(horarioL);
	listaHorarios.add(horarioM);
	listaHorarios.add(horarioMi);
	listaHorarios.add(horarioJ);
	listaHorarios.add(horarioV);
	listaHorarios.add(horarioS);
	listaHorarios.add(horarioD);
	horarioL = null;
	horarioM = null;
	horarioMi = null;
	horarioJ = null;
	horarioV = null;
	horarioS = null;
	horarioD = null;
	}
	
	if (listaHorarios.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	
	result.add(listaHorarios); 
	}  catch (CsvBeanIntrospectionException e) {
	log.info("CsvBeanIntrospectionException: "+e);
	throw new CsvBeanIntrospectionException("El formato del archivo que intenta procesar es incorrecto");
	}  catch (IOException e) {
	log.info("IOException: "+e);
	throw new IOException("El formato del archivo que intenta procesar es incorrecto");
	} catch (IllegalArgumentException  e) {
	log.info("IllegalArgumentException: "+e);
	throw new IllegalArgumentException("El formato del archivo que intenta procesar es incorrecto");
	}   finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	} catch (ClassCastException e) {
	log.error(e);
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	}finally {
	csvReader.close();
	}
	return wrapper;
	
	}
	
	
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVMarcas(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<CatalogoMarca> list = new ArrayList<CatalogoMarca>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo");
	}
	validacionArchivoGeneral(listHeaders, 3);
	String[] nextLine;
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	fillSpaces(nextLine);
	CatalogoMarca obj = new CatalogoMarca();
	try {
	if ( StringUtils.isNotBlank(nextLine[1])) {
	obj.setClave(nextLine[0]);
	obj.setNombreMarca(nextLine[1]);
	obj.setDescripcion(nextLine[2]);
	obj.setHabilitado(Boolean.TRUE);;
	
	list.add(obj);
	obj = null;
	}
	} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
	
	}
	}
	
	if (list.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	
	result.add(list); 
	}  catch (CsvBeanIntrospectionException e) {
	log.error("Error: "+e.getMessage());
	wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
	} finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
	} finally {
	csvReader.close();
	}
	return wrapper;
	}
	
	
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVRecuperos(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<CatalogoRecuperaciones> list = new ArrayList<CatalogoRecuperaciones>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo");
	}
	validacionArchivoGeneral(listHeaders, 2);
	String[] nextLine;
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	fillSpaces(nextLine);
	CatalogoRecuperaciones obj = new CatalogoRecuperaciones();
	try {
	if ( StringUtils.isNotBlank(nextLine[0])) {
	obj.setClave(nextLine[0]);
	obj.setDescripcion(nextLine[1]);
	
	list.add(obj);
	obj = null;
	}
	} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
	
	}
	}
	if (list.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	result.add(list); 
	}  catch (CsvBeanIntrospectionException e) {
	log.error("Error: "+e.getMessage());
	wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
	} finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
	} finally {
	csvReader.close();
	}
	return wrapper;
	}
	
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVColores(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<CatalogoColores> list = new ArrayList<CatalogoColores>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo");
	}
	validacionArchivoGeneral(listHeaders, 2);
	String[] nextLine;
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	fillSpaces(nextLine);
	CatalogoColores obj = new CatalogoColores();
	try {
	if ( StringUtils.isNotBlank(nextLine[0])) {
	obj.setClave(nextLine[0]);
	obj.setDescripcion(nextLine[1]);
	
	list.add(obj);
	obj = null;
	}
	} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
	
	}
	}
	if (list.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	result.add(list); 
	}  catch (CsvBeanIntrospectionException e) {
	log.error("Error: "+e.getMessage());
	wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
	} finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
	} finally {
	csvReader.close();
	}
	return wrapper;
	}
	
	//************** ASEGURADORA *************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVAseguradora(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<CatalogoAseguradora> list = new ArrayList<CatalogoAseguradora>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo");
	}
	validacionArchivoGeneral(listHeaders, 2);
	String[] nextLine;
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	fillSpaces(nextLine);
	CatalogoAseguradora obj = new CatalogoAseguradora();
	try {
	if ( StringUtils.isNotBlank(nextLine[0])) {
	obj.setClave(nextLine[0]);
	obj.setDescripcion(nextLine[1]);
	
	list.add(obj);
	obj = null;
	}
	} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
	
	}
	}
	if (list.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	result.add(list); 
	}  catch (CsvBeanIntrospectionException e) {
	log.error("Error: "+e.getMessage());
	wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
	} finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
	} finally {
	csvReader.close();
	}
	return wrapper;
	}
	
	//************** VEHICULO TERCERO *************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVVehTerc(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<CatalogoVehTerc> list = new ArrayList<CatalogoVehTerc>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo");
	}
	validacionArchivoGeneral(listHeaders, 2);
	String[] nextLine;
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	fillSpaces(nextLine);
	CatalogoVehTerc obj = new CatalogoVehTerc();
	try {
	if ( StringUtils.isNotBlank(nextLine[0])) {
	obj.setClave(nextLine[0]);
	obj.setDescripcion(nextLine[1]);
	
	list.add(obj);
	obj = null;
	}
	} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
	
	}
	}
	if (list.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	result.add(list); 
	}  catch (CsvBeanIntrospectionException e) {
	log.error("Error: "+e.getMessage());
	wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
	} finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
	} finally {
	csvReader.close();
	}
	return wrapper;
	}
	
	//************** VEHICULO TERCERO *************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVTramoCarret(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<CatalogoTramoCar> list = new ArrayList<CatalogoTramoCar>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo");
	}
	validacionArchivoGeneral(listHeaders, 2);
	String[] nextLine;
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	fillSpaces(nextLine);
	CatalogoTramoCar obj = new CatalogoTramoCar();
	try {
	if ( StringUtils.isNotBlank(nextLine[0])) {
	obj.setClave(nextLine[0]);
	obj.setDescripcion(nextLine[1]);
	
	list.add(obj);
	obj = null;
	}
	} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
	
	}
	}
	if (list.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	result.add(list); 
	}  catch (CsvBeanIntrospectionException e) {
	log.error("Error: "+e.getMessage());
	wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
	} finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
	} finally {
	csvReader.close();
	}
	return wrapper;
	}
	
	//************** FaAQs*************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVFaq(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<CatalogoFaq> list = new ArrayList<CatalogoFaq>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo");
	}
	validacionArchivoGeneral(listHeaders, 4);
	String[] nextLine;
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	fillSpaces(nextLine);
	CatalogoFaq obj = new CatalogoFaq();
	try {
	if ( StringUtils.isNotBlank(nextLine[0])) {
	obj.setClave(nextLine[0]);
	obj.setMensaje(nextLine[1]);
	obj.setDescripcion(nextLine[2]);
	obj.setResponsable(nextLine[3]);
	
	list.add(obj);
	obj = null;
	}
	} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
	
	}
	}
	if (list.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	result.add(list); 
	}  catch (CsvBeanIntrospectionException e) {
	log.error("Error: "+e.getMessage());
	wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
	} finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
	} finally {
	csvReader.close();
	}
	return wrapper;
	}
	
	//************** FaAQs*************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVCoberturas(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
	try {
	List<Object> result = new ArrayList<Object>(); 
	
	List<CatalogoCoberturas> list = new ArrayList<CatalogoCoberturas>();
	
	csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
	
	String[] headerRow = csvReader.readNext();
	List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
	listHeaders.removeAll(Arrays.asList("",null));
	
	if (headerRow == null) {
	csvReader.close();
	throw new FileNotFoundException("No hay columnas definidas en el archivo");
	}
	validacionArchivoGeneral(listHeaders, 2);
	String[] nextLine;
	try {
	while((nextLine = csvReader.readNext()) != null ) {
	fillSpaces(nextLine);
	CatalogoCoberturas obj = new CatalogoCoberturas();
	try {
	if ( StringUtils.isNotBlank(nextLine[0])) {
	obj.setClave(nextLine[0]);
	obj.setDescripcion(nextLine[1]);
	
	list.add(obj);
	obj = null;
	}
	} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
	
	}
	}
	if (list.size() < 1) {
	wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	result.add(list); 
	}  catch (CsvBeanIntrospectionException e) {
	log.error("Error: "+e.getMessage());
	wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
	} finally {
	csvReader.close();
	}
	
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
	
	}  catch (CsvBadConverterException e) {
	log.error(e);
	throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
	log.error(e);
	}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	log.error(e);
	throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
	} finally {
	csvReader.close();
	}
	return wrapper;
	}
	
	//************** Clase Vehiculo*************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVClaseVeh(File file) throws IOException, ParseException {
		CSVReader csvReader = null;
		Map<String, Object> wrapper = new HashMap<String, Object>();
		try {
		List<Object> result = new ArrayList<Object>(); 
		
		List<CatalogoClaseVeh> list = new ArrayList<CatalogoClaseVeh>();
		
		csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
		
		String[] headerRow = csvReader.readNext();
		List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
		listHeaders.removeAll(Arrays.asList("",null));
		
		if (headerRow == null) {
			csvReader.close();
			throw new FileNotFoundException("No hay columnas definidas en el archivo");
		}
		validacionArchivoGeneral(listHeaders, 2);
		String[] nextLine;
		try {
		while((nextLine = csvReader.readNext()) != null ) {
		fillSpaces(nextLine);
		CatalogoClaseVeh obj = new CatalogoClaseVeh();
		try {
			if ( StringUtils.isNotBlank(nextLine[0])) {
				obj.setClave(nextLine[0]);
				obj.setDescripcion(nextLine[1]);
			list.add(obj);
			obj = null;
			}
		} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
		
		}
		}
		if (list.size() < 1) {
		wrapper.put("error", "Lista vacia para añadir");
		return wrapper;
		}
		result.add(list); 
		}  catch (CsvBeanIntrospectionException e) {
		log.error("Error: "+e.getMessage());
		wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
		} finally {
		csvReader.close();
		}
		
		wrapper.put("headers", listHeaders);
		wrapper.put("result", result);
		return wrapper;
		
		}  catch (CsvBadConverterException e) {
		log.error(e);
		throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
		}  catch (IOException e) {
		log.error(e);
		}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
		log.error(e);
		throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
		} finally {
		csvReader.close();
		}
		return wrapper;
		}
	//************** Clase Vehiculo*************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVCredenciales(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
		Map<String, Object> wrapper = new HashMap<String, Object>();
	try {
		List<Object> result = new ArrayList<Object>(); 
			
		List<CatalogoCredenciales> list = new ArrayList<CatalogoCredenciales>();
		csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
			
		String[] headerRow = csvReader.readNext();
		List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
		listHeaders.removeAll(Arrays.asList("",null));
			
		if (headerRow == null) {
			csvReader.close();
			throw new FileNotFoundException("No hay columnas definidas en el archivo");
		}
		validacionArchivoGeneral(listHeaders, 5);
		String[] nextLine;
	try {
		while((nextLine = csvReader.readNext()) != null ) {
		fillSpaces(nextLine);
		CatalogoCredenciales obj = new CatalogoCredenciales();
	try {
		if ( StringUtils.isNotBlank(nextLine[0])) {
			obj.setNombre(nextLine[0]);
			obj.setUrl(nextLine[1]);
			obj.setDireccion(nextLine[2]);
			obj.setUsuario(nextLine[3]);
			obj.setPwd(nextLine[4]);
		list.add(obj);
			obj = null;
			}
		} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
			
	  }
	}
	if (list.size() < 1) {
		wrapper.put("error", "Lista vacia para añadir");
	return wrapper;
	}
	result.add(list); 
	}  catch (CsvBeanIntrospectionException e) {
	log.error("Error: "+e.getMessage());
	wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
	} finally {
		csvReader.close();
	}
			
	wrapper.put("headers", listHeaders);
	wrapper.put("result", result);
	return wrapper;
			
	}  catch (CsvBadConverterException e) {
		log.error(e);
		throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
	}  catch (IOException e) {
		log.error(e);
	}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
		log.error(e);
		throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
	} finally {
		csvReader.close();
	}
		return wrapper;
	}
	
	//************** Clase Vehiculo*************
		@SuppressWarnings("deprecation")
		public Map<String, Object> loadCSVAccidentes(File file) throws IOException, ParseException {
		CSVReader csvReader = null;
			Map<String, Object> wrapper = new HashMap<String, Object>();
		try {
			List<Object> result = new ArrayList<Object>(); 
				
			List<CatalogoAccidentes> list = new ArrayList<CatalogoAccidentes>();
			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
				
			String[] headerRow = csvReader.readNext();
			List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
			listHeaders.removeAll(Arrays.asList("",null));
				
			if (headerRow == null) {
				csvReader.close();
				throw new FileNotFoundException("No hay columnas definidas en el archivo");
			}
			validacionArchivoGeneral(listHeaders, 3);
			String[] nextLine;
		try {
			while((nextLine = csvReader.readNext()) != null ) {
			fillSpaces(nextLine);
			CatalogoAccidentes obj = new CatalogoAccidentes();
		try {
			if ( StringUtils.isNotBlank(nextLine[0])) {
				obj.setClave(nextLine[0]);
				obj.setDescripcion(nextLine[1]);
				obj.setCodigo(nextLine[2]);
			list.add(obj);
				obj = null;
				}
			} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
				
		  }
		}
		if (list.size() < 1) {
			wrapper.put("error", "Lista vacia para añadir");
		return wrapper;
		}
		result.add(list); 
		}  catch (CsvBeanIntrospectionException e) {
		log.error("Error: "+e.getMessage());
		wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
		} finally {
			csvReader.close();
		}
				
		wrapper.put("headers", listHeaders);
		wrapper.put("result", result);
		return wrapper;
				
		}  catch (CsvBadConverterException e) {
			log.error(e);
			throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
		}  catch (IOException e) {
			log.error(e);
		}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
			log.error(e);
			throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
		} finally {
			csvReader.close();
		}
			return wrapper;
		}
		
		//************** RC BIENES*************
		@SuppressWarnings("deprecation")
		public Map<String, Object> loadCSVRCBienes(File file) throws IOException, ParseException {
		CSVReader csvReader = null;
			Map<String, Object> wrapper = new HashMap<String, Object>();
		try {
			List<Object> result = new ArrayList<Object>(); 
				
			List<CatalogoRCBienes> list = new ArrayList<CatalogoRCBienes>();
			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
				
			String[] headerRow = csvReader.readNext();
			List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
			listHeaders.removeAll(Arrays.asList("",null));
				
			if (headerRow == null) {
				csvReader.close();
				throw new FileNotFoundException("No hay columnas definidas en el archivo");
			}
			validacionArchivoGeneral(listHeaders, 3);
			String[] nextLine;
		try {
			while((nextLine = csvReader.readNext()) != null ) {
			fillSpaces(nextLine);
			CatalogoRCBienes obj = new CatalogoRCBienes();
		try {
			if ( StringUtils.isNotBlank(nextLine[0])) {
				obj.setClave(nextLine[0]);
				obj.setDescripcion(nextLine[1]);
				obj.setTipoAfecta(nextLine[2]);
			list.add(obj);
				obj = null;
				}
			} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
				
		  }
		}
		if (list.size() < 1) {
			wrapper.put("error", "Lista vacia para añadir");
		return wrapper;
		}
		result.add(list); 
		}  catch (CsvBeanIntrospectionException e) {
		log.error("Error: "+e.getMessage());
		wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
		} finally {
			csvReader.close();
		}
				
		wrapper.put("headers", listHeaders);
		wrapper.put("result", result);
		return wrapper;
				
		}  catch (CsvBadConverterException e) {
			log.error(e);
			throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
		}  catch (IOException e) {
			log.error(e);
		}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
			log.error(e);
			throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
		} finally {
			csvReader.close();
		}
			return wrapper;
	}
		
		//************** CATALOGO GRUA *************
		@SuppressWarnings("deprecation")
		public Map<String, Object> loadCSVGrua(File file) throws IOException, ParseException {
		CSVReader csvReader = null;
			Map<String, Object> wrapper = new HashMap<String, Object>();
		try {
			List<Object> result = new ArrayList<Object>(); 
				
			List<CatalogoGrua> list = new ArrayList<CatalogoGrua>();
			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
				
			String[] headerRow = csvReader.readNext();
			List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
			listHeaders.removeAll(Arrays.asList("",null));
				
			if (headerRow == null) {
				csvReader.close();
				throw new FileNotFoundException("No hay columnas definidas en el archivo");
			}
			validacionArchivoGeneral(listHeaders, 3);
			String[] nextLine;
		try {
			while((nextLine = csvReader.readNext()) != null ) {
			fillSpaces(nextLine);
			CatalogoGrua obj = new CatalogoGrua();
		try {
			if ( StringUtils.isNotBlank(nextLine[0])) {
				obj.setCodigo(nextLine[0]);
				obj.setClave(nextLine[1]);
				obj.setDescripcion(nextLine[2]);
				
			list.add(obj);
				obj = null;
				}
			} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
				
		  }
		}
		if (list.size() < 1) {
			wrapper.put("error", "Lista vacia para añadir");
		return wrapper;
		}
		result.add(list); 
		}  catch (CsvBeanIntrospectionException e) {
		log.error("Error: "+e.getMessage());
		wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
		} finally {
			csvReader.close();
		}
				
		wrapper.put("headers", listHeaders);
		wrapper.put("result", result);
		return wrapper;
				
		}  catch (CsvBadConverterException e) {
			log.error(e);
			throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
		}  catch (IOException e) {
			log.error(e);
		}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
			log.error(e);
			throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
		} finally {
			csvReader.close();
		}
			return wrapper;
	}
		
		//************** CATALOGO Hospitales *************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVHospitales(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
		try {
		List<Object> result = new ArrayList<Object>(); 
		List<CatalogoHospitales> list = new ArrayList<CatalogoHospitales>();
			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
						
		String[] headerRow = csvReader.readNext();
		List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
		listHeaders.removeAll(Arrays.asList("",null));
						
		if (headerRow == null) {
			csvReader.close();
			throw new FileNotFoundException("No hay columnas definidas en el archivo");
		}
		validacionArchivoGeneral(listHeaders, 4);
		String[] nextLine;
		try {
			while((nextLine = csvReader.readNext()) != null ) {
			fillSpaces(nextLine);
			CatalogoHospitales obj = new CatalogoHospitales();
		try {
			if ( StringUtils.isNotBlank(nextLine[0])) {
				obj.setClave(nextLine[0]);
				obj.setDescripcion(nextLine[1]);
				obj.setDireccion(nextLine[2]);
				obj.setTelefono(nextLine[3]);
				list.add(obj);
			obj = null;
			}
			} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
						
			}
		}
		if (list.size() < 1) {
			wrapper.put("error", "Lista vacia para añadir");
			return wrapper;
		}
		result.add(list); 
		}  catch (CsvBeanIntrospectionException e) {
			log.error("Error: "+e.getMessage());
			wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
			} finally {
			csvReader.close();
			}
						
		wrapper.put("headers", listHeaders);
		wrapper.put("result", result);
		return wrapper;
						
		}  catch (CsvBadConverterException e) {
			log.error(e);
			throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
		}  catch (IOException e) {
			log.error(e);
		}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
			log.error(e);
			throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
		} finally {
			csvReader.close();
		}
			return wrapper;
	}
	
	//************** CATALOGO Hospitales *************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVMarcaTerc(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
		try {
		List<Object> result = new ArrayList<Object>(); 
		List<CatalogoMarcaTerc> list = new ArrayList<CatalogoMarcaTerc>();
			csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
							
		String[] headerRow = csvReader.readNext();
		List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
		listHeaders.removeAll(Arrays.asList("",null));
							
		if (headerRow == null) {
			csvReader.close();
			throw new FileNotFoundException("No hay columnas definidas en el archivo");
		}
			validacionArchivoGeneral(listHeaders, 7);
			String[] nextLine;
			try {
				while((nextLine = csvReader.readNext()) != null ) {
				fillSpaces(nextLine);
				CatalogoMarcaTerc obj = new CatalogoMarcaTerc();
			try {
				if ( StringUtils.isNotBlank(nextLine[0])) {
					obj.setClave(nextLine[0]);
					obj.setDescripcion(nextLine[1]);
					if (StringUtils.isNoneBlank(nextLine[2])) {
						obj.setSubCompactos(nextLine[2].contains("SI") ? true:false);
					} else {obj.setSubCompactos(false);  }
					
					if (StringUtils.isNotBlank(nextLine[3])) {
						obj.setSemipesado(nextLine[3].contains("SI") ? true:false );
					} else { obj.setSemipesado(false);}
					
					if (StringUtils.isNotBlank(nextLine[4])) {
						obj.setPesado( nextLine[4].contains("SI") ?true:false);
					} else {obj.setPesado(false);}
					
					if (StringUtils.isNotBlank(nextLine[5])) {
						obj.setMotos( nextLine[5].contains("SI") ?true:false);
					} else {obj.setMotos(false);}
					
					if (StringUtils.isNotBlank(nextLine[6])) {
						obj.setBlindado( nextLine[6].contains("SI") ?true:false);
					} else {obj.setBlindado(false);}
					
					list.add(obj);
				obj = null;
				}
				} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
							
				}
			}
			if (list.size() < 1) {
				wrapper.put("error", "Lista vacia para añadir");
				return wrapper;
			}
			result.add(list); 
			}  catch (CsvBeanIntrospectionException e) {
				log.error("Error: "+e.getMessage());
				wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
				} finally {
				csvReader.close();
				}
							
			wrapper.put("headers", listHeaders);
			wrapper.put("result", result);
			return wrapper;
							
			}  catch (CsvBadConverterException e) {
				log.error(e);
				throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
			}  catch (IOException e) {
				log.error(e);
			}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
				log.error(e);
				throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
			} finally {
				csvReader.close();
			}
				return wrapper;
		}
	
	//************** CATALOGO PARTES AUTO *************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVPartesAuto(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
		try {
		List<Object> result = new ArrayList<Object>(); 
		List<CatalogoPartesAuto> list = new ArrayList<CatalogoPartesAuto>();
		csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
								
		String[] headerRow = csvReader.readNext();
		List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
		listHeaders.removeAll(Arrays.asList("",null));
								
		if (headerRow == null) {
			csvReader.close();
			throw new FileNotFoundException("No hay columnas definidas en el archivo");
		}
			validacionArchivoGeneral(listHeaders, 3);
			String[] nextLine;
		try {
			while((nextLine = csvReader.readNext()) != null ) {
				fillSpaces(nextLine);
				CatalogoPartesAuto obj = new CatalogoPartesAuto();
			try {
				if ( StringUtils.isNotBlank(nextLine[0])) {
				obj.setTipoParte(nextLine[0]);
				obj.setNumParte(nextLine[1]);
				obj.setNombreParte(nextLine[2]);
						
			list.add(obj);
			obj = null;
			}
			} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
								
			}
		}
		if (list.size() < 1) {
			wrapper.put("error", "Lista vacia para añadir");
			return wrapper;
			}
		result.add(list); 
		}  catch (CsvBeanIntrospectionException e) {
			log.error("Error: "+e.getMessage());
			wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
		} finally {
			csvReader.close();
			}
								
		wrapper.put("headers", listHeaders);
		wrapper.put("result", result);
		return wrapper;
								
		}  catch (CsvBadConverterException e) {
			log.error(e);
			throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
		}  catch (IOException e) {
			log.error(e);
		}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
			log.error(e);
			throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
		} finally {
		csvReader.close();
		}
		return wrapper;
		}

	//************** CATALOGO MP *************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVMP(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
		try {
		List<Object> result = new ArrayList<Object>(); 
		List<CatalogoMP> list = new ArrayList<CatalogoMP>();
		csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
									
		String[] headerRow = csvReader.readNext();
		List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
		listHeaders.removeAll(Arrays.asList("",null));
									
		if (headerRow == null) {
			csvReader.close();
			throw new FileNotFoundException("No hay columnas definidas en el archivo");
		}
		validacionArchivoGeneral(listHeaders, 8);
		String[] nextLine;
		try {
			while((nextLine = csvReader.readNext()) != null ) {
			fillSpaces(nextLine);
			CatalogoMP obj = new CatalogoMP();
				try {
					if ( StringUtils.isNotBlank(nextLine[0])) {
					obj.setClave(nextLine[0]);
					obj.setIdEntidad(nextLine[1]);
					obj.setIdMunicipio(nextLine[2]);
					obj.setDescripcion(nextLine[3]);
					obj.setDireccion(nextLine[4]);
					obj.setMunicipioLegal(nextLine[5]);
					obj.setEntidad(nextLine[6]);
					obj.setMunicipio(nextLine[7]);
							
				list.add(obj);
				obj = null;
				}
				} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
									
				}
			}
			if (list.size() < 1) {
				wrapper.put("error", "Lista vacia para añadir");
				return wrapper;
				}
			result.add(list); 
			}  catch (CsvBeanIntrospectionException e) {
				log.error("Error: "+e.getMessage());
				wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
			} finally {
				csvReader.close();
				}
									
			wrapper.put("headers", listHeaders);
			wrapper.put("result", result);
			return wrapper;
									
			}  catch (CsvBadConverterException e) {
				log.error(e);
				throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
			}  catch (IOException e) {
				log.error(e);
			}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
				log.error(e);
				throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
		} finally {
		csvReader.close();
		}
		return wrapper;
	}
		
	/****************** ESTADOS ***************/
	//************** CATALOGO MP *************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVEstados(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
		try {
		List<Object> result = new ArrayList<Object>(); 
		List<Estado> list = new ArrayList<Estado>();
		csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
									
		String[] headerRow = csvReader.readNext();
		List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
		listHeaders.removeAll(Arrays.asList("",null));
									
		if (headerRow == null) {
			csvReader.close();
			throw new FileNotFoundException("No hay columnas definidas en el archivo");
		}
		validacionArchivoGeneral(listHeaders, 4);
		String[] nextLine;
		try {
			while((nextLine = csvReader.readNext()) != null ) {
			fillSpaces(nextLine);
			Estado obj = new Estado();
				try {
					if ( StringUtils.isNotBlank(nextLine[0])) {
					obj.setNombre(nextLine[0]);
					obj.setClaveEntidad(nextLine[1]);
					try {
					obj.setIdentidad(Integer.valueOf(nextLine[2]));
					} catch (Exception e) {
						// TODO: handle exception
					}
					try  {
					obj.setHusoHorario(Integer.valueOf(nextLine[3]));
					} catch (Exception e) {
						// TODO: handle exception
					}	
				list.add(obj);
				obj = null;
				}
				} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
									
				}
			}
			if (list.size() < 1) {
				wrapper.put("error", "Lista vacia para añadir");
				return wrapper;
				}
			result.add(list); 
			}  catch (CsvBeanIntrospectionException e) {
				log.error("Error: "+e.getMessage());
				wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
			} finally {
				csvReader.close();
				}
									
			wrapper.put("headers", listHeaders);
			wrapper.put("result", result);
			return wrapper;
									
			}  catch (CsvBadConverterException e) {
				log.error(e);
				throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
			}  catch (IOException e) {
				log.error(e);
			}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
				log.error(e);
				throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
		} finally {
		csvReader.close();
		}
		return wrapper;
	}
	
	/******************* MUNICIPIOS *********/
	//************** CATALOGO MP *************
	@SuppressWarnings("deprecation")
	public Map<String, Object> loadCSVMunicipios(File file) throws IOException, ParseException {
	CSVReader csvReader = null;
	Map<String, Object> wrapper = new HashMap<String, Object>();
		try {
		List<Object> result = new ArrayList<Object>(); 
		List<Municipio> list = new ArrayList<Municipio>();
		csvReader = new CSVReader(new InputStreamReader(new FileInputStream(file), "ISO-8859-1"), this.seprator);
									
		String[] headerRow = csvReader.readNext();
		List<String> listHeaders = new ArrayList<String>(Arrays.asList(headerRow));
		listHeaders.removeAll(Arrays.asList("",null));
									
		if (headerRow == null) {
			csvReader.close();
			throw new FileNotFoundException("No hay columnas definidas en el archivo");
		}
		validacionArchivoGeneral(listHeaders, 4);
		String[] nextLine;
		try {
			while((nextLine = csvReader.readNext()) != null ) {
			fillSpaces(nextLine);
			Municipio obj = new Municipio();
				try {
					if ( StringUtils.isNotBlank(nextLine[0])) {
					try {
						obj.setIdmunicipio(Integer.valueOf(nextLine[0]));
					} catch (Exception e) {
					}
					try {
						Estado edo = Estado.getEstadoService().objetoEstado(nextLine[1]);
						obj.setEstado(edo);
					} catch (Exception e) {
					}
					obj.setNombre(nextLine[2]);
					obj.setClaveEntidad(nextLine[3]);
							
				list.add(obj);
				obj = null;
				}
				} catch ( IndexOutOfBoundsException | ClassCastException | NoClassDefFoundError | IllegalStateException e) {
									
				}
			}
			if (list.size() < 1) {
				wrapper.put("error", "Lista vacia para añadir");
				return wrapper;
				}
			result.add(list); 
			}  catch (CsvBeanIntrospectionException e) {
				log.error("Error: "+e.getMessage());
				wrapper.put("error","El formato del archivo que intenta procesar es incorrecto");
			} finally {
				csvReader.close();
				}
									
			wrapper.put("headers", listHeaders);
			wrapper.put("result", result);
			return wrapper;
									
			}  catch (CsvBadConverterException e) {
				log.error(e);
				throw new CsvBadConverterException("Ocurrio un error al leer el archivo. " + e.getMessage());
			}  catch (IOException e) {
				log.error(e);
			}  catch (IndexOutOfBoundsException | IllegalAccessError  e) {
				log.error(e);
				throw new Error("Ocurrio un error al leer el archivo. " + e.getMessage());
		} finally {
		csvReader.close();
		}
		return wrapper;
	}
}
