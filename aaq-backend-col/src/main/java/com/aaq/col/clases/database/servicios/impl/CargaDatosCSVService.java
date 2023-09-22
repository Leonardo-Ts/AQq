	package com.aaq.col.clases.database.servicios.impl;
	
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	
	import org.apache.commons.logging.LogFactory;
	import org.apache.commons.logging.impl.Log4JLogger;
	//import org.apache.log4j.Logger;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Qualifier;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

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
import com.aaq.col.clases.database.repositorios.impl.CorreoPolizaAgenteDao;
	import com.aaq.col.clases.database.repositorios.impl.HorarioGrupoDao;
	import com.aaq.col.clases.database.servicios.interfase.CargaDatosCSVServiceInterfase;
	import com.aaq.col.clases.util.CargaCSV;
	
	@Service("cargaDatosCSVService")
	@Transactional
	public class CargaDatosCSVService implements CargaDatosCSVServiceInterfase {
	
	private final Log4JLogger logCargaMasiva = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.carga");
	
	
	@Autowired
	@Qualifier("horarioGrupoDao")
	HorarioGrupoDao horarioGrupoDao;
	
	@Autowired
	@Qualifier("correoPolizaAgenteDao")
	CorreoPolizaAgenteDao correoPolizaAgenteDao;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargaDatos(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	
	List<Object> result = null;
	
	try {
	CargaCSV datosCSV = new CargaCSV();
	//parametro false es para truncar la tabla antes de hacer insert, pero no esta implementado
	wrapper = datosCSV.loadCSV(file);
	result=(List<Object>)wrapper.get("result");
	List<HorarioGrupo> listaExistente= new ArrayList<HorarioGrupo>(); 
	listaExistente.addAll(HorarioGrupo.getHorarioGrupoService().listaDeHorarioGrupo());
	
	List<HorarioGrupo> horarios = (List<HorarioGrupo>) result.get(0);
	
	for (HorarioGrupo horarioGrupo : horarios) {
	horarioGrupo.guardarObjeto();
	}
	}catch (Exception e) {
	//log.error(e);
	wrapper.put("error", "error al procesar los registros");
	}
	
	return wrapper;
	}
	
	@SuppressWarnings({ "unchecked"})
	@Override
	public Map<String, Object> cargaDatosCorreos(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	
	List<Object> result = null;
	
	try {
	CargaCSV datosCSV = new CargaCSV();
	
	//parametro false es para truncar la tabla antes de hacer insert, pero no esta implementado
	//wrapper = datosCSV.loadCSVCorreos(file);
	try {
	wrapper = datosCSV.loadCSVCorreos(file);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	//log.error(e);
	} catch (FileNotFoundException e) {
	//log.error(e);
	}catch (Exception e) {
	//log.error(e);
	}
	String salida = (String) wrapper.get("error");
	if (salida != null) {
	wrapper.put("error", "error al procesar los registros");
	return wrapper;
	}
	result=(List<Object>)wrapper.get("result");
	List<CorreoPolizaAgente> listaExistente= new ArrayList<CorreoPolizaAgente>(); 
	listaExistente.addAll(CorreoPolizaAgente.getCorreoPolizaAgenteService().listaDeCorreoPolizaAgente());
	List<CorreoPolizaAgente> correosPolizas = (List<CorreoPolizaAgente>) result.get(0);
	
	for (CorreoPolizaAgente correoPolizaAgente : correosPolizas) {
	correoPolizaAgente.guardarObjeto(); 
	}
	
	}catch (Exception e) {
	//log.error(e);
	wrapper.put("error", "error al procesar los registros");
	}
	//FacesMessage message = new FacesMessage("Seleccione botón confirmar");
	//FacesContext.getCurrentInstance().addMessage(null, message);
	return wrapper;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargaDatosGrupos(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	
	List<Object> result = null;
	
	try {
	CargaCSV datosCSV = new CargaCSV();
	
	//parametro false es para truncar la tabla antes de hacer insert, pero no esta implementado
	wrapper = datosCSV.loadCSVGrupos(file);
	result=(List<Object>)wrapper.get("result");
	List<Grupo> listaExistente = new ArrayList<Grupo>(); 
	listaExistente.addAll(Grupo.getGrupoService().listaDeGrupo());
	
	List<Grupo> grupos = (List<Grupo>) result.get(0);
	
	for (Grupo gr : grupos) {
	gr.guardarObjeto();
	}
	}catch (Exception e) {
	//log.error(e);
	wrapper.put("error", "error al procesar los registros");
	}
	
	return wrapper;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargaDatosGruposTerminales(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	
	List<Object> result = null;
	
	try {
	CargaCSV datosCSV = new CargaCSV();
	
	//parametro false es para truncar la tabla antes de hacer insert, pero no esta implementado
	wrapper = datosCSV.loadCSVGruposTerminales(file);
	result=(List<Object>)wrapper.get("result");
	//List<grupoTerminalA> listaExistente= new ArrayList<grupoTerminalA>(); 
	//listaExistente.addAll(HorarioGrupo.getHorarioGrupoService().listaDeHorarioGrupo());
	
	List<GrupoTerminal> grupoTerminal = (List<GrupoTerminal>) result.get(0);
	
	for (GrupoTerminal grupoTerminalA : grupoTerminal) {
	grupoTerminalA.guardarObjeto();
	}
	}catch (Exception e) {
	//log.error(e);
	wrapper.put("error", "error al procesar los registros "+e);
	}
	
	return wrapper;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargaDatosHorarios(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	
	List<Object> result = null;
	
	try {
	CargaCSV datosCSV = new CargaCSV();
	
	//parametro false es para truncar la tabla antes de hacer insert, pero no esta implementado
	wrapper = datosCSV.loadCSVHorarios(file);
	result=(List<Object>)wrapper.get("result");
	//List<grupoTerminalA> listaExistente= new ArrayList<grupoTerminalA>(); 
	//listaExistente.addAll(HorarioGrupo.getHorarioGrupoService().listaDeHorarioGrupo());
	
	List<Horarios> horarioGuardar = (List<Horarios>) result.get(0);
	
	for (Horarios horarios : horarioGuardar) {
	horarios.guardarObjeto();
	}
	}catch (Exception e) {
	//log.error(e);
	wrapper.put("error", "error al procesar los registros");
	}
	
	return wrapper;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargaDatosMarcas(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	List<Object> result = null;
	try {
	CargaCSV datosCSV = new CargaCSV();
	try {
	wrapper = datosCSV.loadCSVMarcas(file);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	this.logCargaMasiva.error("ERROR: ",e);
	} catch (FileNotFoundException e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}
	String salida = (String) wrapper.get("error");
	if (salida != null) {
	wrapper.put("error", "error al procesar los registros");
	return wrapper;
	}
	
	result=(List<Object>)wrapper.get("result");
	List<CatalogoMarca> listaExistente= new ArrayList<CatalogoMarca>(); 
	listaExistente.addAll(CatalogoMarca.getCatalogoMarcaService().listaDeCatalogoMarca());
	List<CatalogoMarca> catMarcas = (List<CatalogoMarca>) result.get(0);
	
	for (CatalogoMarca marcas : catMarcas) {
	marcas.guardarObjeto(); 
	}
	
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	wrapper.put("error", "error al procesar los registros");
	}
	return wrapper;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargaDatosRecuperos(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	List<Object> result = null;
	try {
	CargaCSV datosCSV = new CargaCSV();
	try {
	wrapper = datosCSV.loadCSVRecuperos(file);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	this.logCargaMasiva.error("ERROR: ",e);
	} catch (FileNotFoundException e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}
	String salida = (String) wrapper.get("error");
	if (salida != null) {
	wrapper.put("error", "error al procesar los registros");
	return wrapper;
	}
	
	result=(List<Object>)wrapper.get("result");
	List<CatalogoRecuperaciones> listaExistente= new ArrayList<CatalogoRecuperaciones>(); 
	listaExistente.addAll(CatalogoRecuperaciones.getCatalogoRecuperacionesService().listaRecuperaciones(null, null));
	List<CatalogoRecuperaciones> cata = (List<CatalogoRecuperaciones>) result.get(0);
	
	for (CatalogoRecuperaciones rec : cata) {
	rec.guardarObjeto(); 
	}
	
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	wrapper.put("error", "error al procesar los registros. "+e.getMessage());
	}
	return wrapper;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosColores(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	List<Object> result = null;
	try {
	CargaCSV datosCSV = new CargaCSV();
	try {
	wrapper = datosCSV.loadCSVColores(file);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	this.logCargaMasiva.error("ERROR: ",e);
	} catch (FileNotFoundException e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}
	String salida = (String) wrapper.get("error");
	if (salida != null) {
	wrapper.put("error", "error al procesar los registros");
	return wrapper;
	}
	
	result=(List<Object>)wrapper.get("result");
	List<CatalogoColores> listaExistente= new ArrayList<CatalogoColores>(); 
	listaExistente.addAll(CatalogoColores.getCatalogoColoresService().listaDeCatalogoColores(null, null));
	List<CatalogoColores> cata = (List<CatalogoColores>) result.get(0);
	
	for (CatalogoColores rec : cata) {
	rec.guardarObjeto(); 
	}
	
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	wrapper.put("error", "error al procesar los registros. "+e.getMessage());
	}
	return wrapper;
	}
	
	//***** ASEGURADORA ****
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosAseguradora(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	List<Object> result = null;
	try {
	CargaCSV datosCSV = new CargaCSV();
	try {
	wrapper = datosCSV.loadCSVAseguradora(file);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	this.logCargaMasiva.error("ERROR: ",e);
	} catch (FileNotFoundException e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}
	String salida = (String) wrapper.get("error");
	if (salida != null) {
	wrapper.put("error", "error al procesar los registros");
	return wrapper;
	}
	
	result=(List<Object>)wrapper.get("result");
	List<CatalogoAseguradora> listaExistente= new ArrayList<CatalogoAseguradora>(); 
	listaExistente.addAll(CatalogoAseguradora.getCatalogoAseguradoraService().listaCatalogoAseguradora(null, null));
	List<CatalogoAseguradora> cata = (List<CatalogoAseguradora>) result.get(0);
	
	for (CatalogoAseguradora rec : cata) {
	rec.guardarObjeto(); 
	}
	
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	wrapper.put("error", "error al procesar los registros. "+e.getMessage());
	}
	return wrapper;
	}
	
	//***** VEHICULO TERCERO ****
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosVehTerc(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	List<Object> result = null;
	try {
	CargaCSV datosCSV = new CargaCSV();
	try {
	wrapper = datosCSV.loadCSVVehTerc(file);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	this.logCargaMasiva.error("ERROR: ",e);
	} catch (FileNotFoundException e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}
	String salida = (String) wrapper.get("error");
	if (salida != null) {
	wrapper.put("error", "error al procesar los registros");
	return wrapper;
	}
	
	result=(List<Object>)wrapper.get("result");
	List<CatalogoVehTerc> listaExistente= new ArrayList<CatalogoVehTerc>(); 
	listaExistente.addAll(CatalogoVehTerc.getCatalogoVehTercService().listaDeCatalogoVehTerc(null, null));
	List<CatalogoVehTerc> cata = (List<CatalogoVehTerc>) result.get(0);
	
	for (CatalogoVehTerc rec : cata) {
	rec.guardarObjeto(); 
	}
	
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	wrapper.put("error", "error al procesar los registros. "+e.getMessage());
	}
	return wrapper;
	}
	
	//***** TRAMO CARRETERO ****
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosTramoCarret(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	List<Object> result = null;
	try {
	CargaCSV datosCSV = new CargaCSV();
	try {
	wrapper = datosCSV.loadCSVTramoCarret(file);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	this.logCargaMasiva.error("ERROR: ",e);
	} catch (FileNotFoundException e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}
	String salida = (String) wrapper.get("error");
	if (salida != null) {
	wrapper.put("error", "error al procesar los registros");
	return wrapper;
	}
	
	result=(List<Object>)wrapper.get("result");
	List<CatalogoTramoCar> listaExistente= new ArrayList<CatalogoTramoCar>(); 
	listaExistente.addAll(CatalogoTramoCar.getCatalogoTramoCarService().listaDeCatalogoTramoCar(null, null));
	List<CatalogoTramoCar> cata = (List<CatalogoTramoCar>) result.get(0);
	
	for (CatalogoTramoCar rec : cata) {
	rec.guardarObjeto(); 
	}
	
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	wrapper.put("error", "error al procesar los registros. "+e.getMessage());
	}
	return wrapper;
	}
	//***** FAQs ****
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosFaq(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	List<Object> result = null;
	try {
	CargaCSV datosCSV = new CargaCSV();
	try {
	wrapper = datosCSV.loadCSVFaq(file);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	this.logCargaMasiva.error("ERROR: ",e);
	} catch (FileNotFoundException e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}
	String salida = (String) wrapper.get("error");
	if (salida != null) {
	wrapper.put("error", "error al procesar los registros");
	return wrapper;
	}
	
	result=(List<Object>)wrapper.get("result");
	List<CatalogoFaq> listaExistente= new ArrayList<CatalogoFaq>(); 
	listaExistente.addAll(CatalogoFaq.getCatalogoFaqService().listaDeCatalogoFaq(null, null));
	List<CatalogoFaq> cata = (List<CatalogoFaq>) result.get(0);
	
	for (CatalogoFaq rec : cata) {
	rec.guardarObjeto(); 
	}
	
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	wrapper.put("error", "error al procesar los registros. "+e.getMessage());
	}
	return wrapper;
	}
	
	//***** Coberturas ****
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosCoberturas(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	List<Object> result = null;
	try {
	CargaCSV datosCSV = new CargaCSV();
	try {
	wrapper = datosCSV.loadCSVCoberturas(file);
	} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
	this.logCargaMasiva.error("ERROR: ",e);
	} catch (FileNotFoundException e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	}
	String salida = (String) wrapper.get("error");
	if (salida != null) {
	wrapper.put("error", "error al procesar los registros");
	return wrapper;
	}
	
	result=(List<Object>)wrapper.get("result");
	List<CatalogoCoberturas> listaExistente= new ArrayList<CatalogoCoberturas>(); 
	listaExistente.addAll(CatalogoCoberturas.getCatalogoCoberturasService().listaDeCatalogoCoberturas(null, null));
	List<CatalogoCoberturas> cata = (List<CatalogoCoberturas>) result.get(0);
	
	for (CatalogoCoberturas rec : cata) {
	rec.guardarObjeto(); 
	}
	
	}catch (Exception e) {
	this.logCargaMasiva.error("ERROR: ",e);
	wrapper.put("error", "error al procesar los registros. "+e.getMessage());
	}
	return wrapper;
	}
	
	//***** Clase Vehiculo ****
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosClaseVeh(File file) {
		Map<String, Object> wrapper = new HashMap<String, Object>();
		List<Object> result = null;
		try {
		CargaCSV datosCSV = new CargaCSV();
		try {
		wrapper = datosCSV.loadCSVClaseVeh(file);
		} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
		this.logCargaMasiva.error("ERROR: ",e);
		} catch (FileNotFoundException e) {
		this.logCargaMasiva.error("ERROR: ",e);
		}catch (Exception e) {
		this.logCargaMasiva.error("ERROR: ",e);
		}
		String salida = (String) wrapper.get("error");
		if (salida != null) {
		wrapper.put("error", "error al procesar los registros");
		return wrapper;
		}
		
		result=(List<Object>)wrapper.get("result");
		List<CatalogoClaseVeh> listaExistente= new ArrayList<CatalogoClaseVeh>(); 
		listaExistente.addAll(CatalogoClaseVeh.getCatalogoClaseVehService().listaDeCatalogoClaseVeh(null, null));
		List<CatalogoClaseVeh> cata = (List<CatalogoClaseVeh>) result.get(0);
		
		for (CatalogoClaseVeh rec : cata) {
		rec.guardarObjeto(); 
		}
		
		}catch (Exception e) {
		this.logCargaMasiva.error("ERROR: ",e);
		wrapper.put("error", "error al procesar los registros. "+e.getMessage());
		}
		return wrapper;
		}
	
	//***** Clase Vehiculo ****
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosCredenciales(File file) {
		Map<String, Object> wrapper = new HashMap<String, Object>();
		List<Object> result = null;
		try {
			CargaCSV datosCSV = new CargaCSV();
		try {
			wrapper = datosCSV.loadCSVCredenciales(file);
			} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
			this.logCargaMasiva.error("ERROR: ",e);
			} catch (FileNotFoundException e) {
			this.logCargaMasiva.error("ERROR: ",e);
			}catch (Exception e) {
			this.logCargaMasiva.error("ERROR: ",e);
			}
			String salida = (String) wrapper.get("error");
			if (salida != null) {
			wrapper.put("error", "error al procesar los registros");
			return wrapper;
			}
			
			result=(List<Object>)wrapper.get("result");
			List<CatalogoCredenciales> listaExistente= new ArrayList<CatalogoCredenciales>(); 
			listaExistente.addAll(CatalogoCredenciales.getCatalogoCredencialesService().listaDeCatalogoCredenciales(null, null, null, null));
			List<CatalogoCredenciales> cata = (List<CatalogoCredenciales>) result.get(0);
			
			for (CatalogoCredenciales rec : cata) {
			rec.guardarObjeto(); 
			}
			
			}catch (Exception e) {
			this.logCargaMasiva.error("ERROR: ",e);
			wrapper.put("error", "error al procesar los registros. "+e.getMessage());
			}
			return wrapper;
			}
	//***** Accidentes ****
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> cargarDatosAccidentes(File file) {
			Map<String, Object> wrapper = new HashMap<String, Object>();
			List<Object> result = null;
			try {
				CargaCSV datosCSV = new CargaCSV();
			try {
				wrapper = datosCSV.loadCSVAccidentes(file);
				} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
				this.logCargaMasiva.error("ERROR: ",e);
				} catch (FileNotFoundException e) {
				this.logCargaMasiva.error("ERROR: ",e);
				}catch (Exception e) {
				this.logCargaMasiva.error("ERROR: ",e);
				}
				String salida = (String) wrapper.get("error");
				if (salida != null) {
				wrapper.put("error", "error al procesar los registros");
				return wrapper;
				}
				
				result=(List<Object>)wrapper.get("result");
				List<CatalogoAccidentes> listaExistente= new ArrayList<CatalogoAccidentes>(); 
				listaExistente.addAll(CatalogoAccidentes.getCatalogoAccidentesService().listaDeCatalogoAccidentes(null, null, null));
				List<CatalogoAccidentes> cata = (List<CatalogoAccidentes>) result.get(0);
				
				for (CatalogoAccidentes rec : cata) {
					rec.guardarObjeto(); 
				}
				
				}catch (Exception e) {
				this.logCargaMasiva.error("ERROR: ",e);
				wrapper.put("error", "error al procesar los registros. "+e.getMessage());
				}
				return wrapper;
			}
		
		//***** Accidentes ****
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosRCBienes(File file) {
		Map<String, Object> wrapper = new HashMap<String, Object>();
		List<Object> result = null;
		try {
		CargaCSV datosCSV = new CargaCSV();
		try {
			wrapper = datosCSV.loadCSVRCBienes(file);
			} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
				this.logCargaMasiva.error("ERROR: ",e);
			} catch (FileNotFoundException e) {
				this.logCargaMasiva.error("ERROR: ",e);
			}catch (Exception e) {
				this.logCargaMasiva.error("ERROR: ",e);
			}
		String salida = (String) wrapper.get("error");
		if (salida != null) {
			wrapper.put("error", "error al procesar los registros");
			return wrapper;
		}
						
		result=(List<Object>)wrapper.get("result");
		List<CatalogoRCBienes> listaExistente= new ArrayList<CatalogoRCBienes>(); 
		listaExistente.addAll(CatalogoRCBienes.getCatalogoRCBienesService().listaCatalogoRCBienes(null, null));
		List<CatalogoRCBienes> cata = (List<CatalogoRCBienes>) result.get(0);
						
		for (CatalogoRCBienes rec : cata) {
			rec.guardarObjeto(); 
		}
						
		}catch (Exception e) {
			this.logCargaMasiva.error("ERROR: ",e);
			wrapper.put("error", "error al procesar los registros. "+e.getMessage());
		}
			return wrapper;
		}		

	//***** Accidentes ****
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosGrua(File file) {
	Map<String, Object> wrapper = new HashMap<String, Object>();
	List<Object> result = null;
		try {
			CargaCSV datosCSV = new CargaCSV();
		try {
			wrapper = datosCSV.loadCSVGrua(file);
			} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
				this.logCargaMasiva.error("ERROR: ",e);
			} catch (FileNotFoundException e) {
				this.logCargaMasiva.error("ERROR: ",e);
			}catch (Exception e) {
				this.logCargaMasiva.error("ERROR: ",e);
			}
		String salida = (String) wrapper.get("error");
		if (salida != null) {
			wrapper.put("error", "error al procesar los registros");
			return wrapper;
		}
							
		result=(List<Object>)wrapper.get("result");
		List<CatalogoGrua> listaExistente= new ArrayList<CatalogoGrua>(); 
		listaExistente.addAll(CatalogoGrua.getCatalogoGruaService().listaDeCatalogoGrua(null, null, null));
		List<CatalogoGrua> cata = (List<CatalogoGrua>) result.get(0);
							
		for (CatalogoGrua rec : cata) {
			rec.guardarObjeto(); 
		}
	   }catch (Exception e) {
		   this.logCargaMasiva.error("ERROR: ",e);
			wrapper.put("error", "error al procesar los registros. "+e.getMessage());
		}
		return wrapper;
	}

	//***** Catalogo Hospitales ****
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosHospitales(File file) {
		Map<String, Object> wrapper = new HashMap<String, Object>();
		List<Object> result = null;
		try {
			CargaCSV datosCSV = new CargaCSV();
		try {
			wrapper = datosCSV.loadCSVHospitales(file);
			} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
				this.logCargaMasiva.error("ERROR: ",e);
			} catch (FileNotFoundException e) {
				this.logCargaMasiva.error("ERROR: ",e);
			}catch (Exception e) {
				this.logCargaMasiva.error("ERROR: ",e);
			}
		String salida = (String) wrapper.get("error");
		if (salida != null) {
			wrapper.put("error", "error al procesar los registros");
			return wrapper;
		}
								
		result=(List<Object>)wrapper.get("result");
		List<CatalogoHospitales> listaExistente= new ArrayList<CatalogoHospitales>(); 
		listaExistente.addAll(CatalogoHospitales.getCatalogoHospitalesService().listaDeCatalogoHospitales(null));
		List<CatalogoHospitales> cata = (List<CatalogoHospitales>) result.get(0);
								
		for (CatalogoHospitales rec : cata) {
			rec.guardarObjeto(); 
		}
	  }catch (Exception e) {
		this.logCargaMasiva.error("ERROR: ",e);
		wrapper.put("error", "error al procesar los registros. "+e.getMessage());
		}
		return wrapper;
	}
	
	//***** Catalogo Hospitales ****
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> cargarDatosMarcaTerc(File file) {
		Map<String, Object> wrapper = new HashMap<String, Object>();
		List<Object> result = null;
		try {
			CargaCSV datosCSV = new CargaCSV();
		try {
			wrapper = datosCSV.loadCSVMarcaTerc(file);
			} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
				this.logCargaMasiva.error("ERROR: ",e);
			} catch (FileNotFoundException e) {
				this.logCargaMasiva.error("ERROR: ",e);
			}catch (Exception e) {
				this.logCargaMasiva.error("ERROR: ",e);
			}
		String salida = (String) wrapper.get("error");
		if (salida != null) {
			wrapper.put("error", "error al procesar los registros");
			return wrapper;
		}
									
		result=(List<Object>)wrapper.get("result");
		List<CatalogoMarcaTerc> listaExistente= new ArrayList<CatalogoMarcaTerc>(); 
		listaExistente.addAll(CatalogoMarcaTerc.getCatalogoMarcaTercService().listaDeCatalogoMarcaTerc(null, null));
		List<CatalogoMarcaTerc> cata = (List<CatalogoMarcaTerc>) result.get(0);
								
		for (CatalogoMarcaTerc rec : cata) {
			rec.guardarObjeto(); 
		  }
		 }catch (Exception e) {
			this.logCargaMasiva.error("ERROR: ",e);
			wrapper.put("error", "error al procesar los registros. "+e.getMessage());
		}
		return wrapper;
		}
	
	//***** Catalogo Hospitales ****
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> cargarDatosPartesAuto(File file) {
			Map<String, Object> wrapper = new HashMap<String, Object>();
			List<Object> result = null;
			try {
				CargaCSV datosCSV = new CargaCSV();
			try {
				wrapper = datosCSV.loadCSVPartesAuto(file);
				} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
					this.logCargaMasiva.error("ERROR: ",e);
				} catch (FileNotFoundException e) {
					this.logCargaMasiva.error("ERROR: ",e);
				}catch (Exception e) {
					this.logCargaMasiva.error("ERROR: ",e);
				}
			String salida = (String) wrapper.get("error");
			if (salida != null) {
				wrapper.put("error", "error al procesar los registros");
				return wrapper;
			}
										
			result=(List<Object>)wrapper.get("result");
			List<CatalogoPartesAuto> listaExistente= new ArrayList<CatalogoPartesAuto>(); 
			listaExistente.addAll(CatalogoPartesAuto.getCatalogoPartesAutoService().listaDeCatalogoPartesAuto(null, null, null));
			List<CatalogoPartesAuto> cata = (List<CatalogoPartesAuto>) result.get(0);
									
			for (CatalogoPartesAuto rec : cata) {
				rec.guardarObjeto(); 
			  }
			 }catch (Exception e) {
				this.logCargaMasiva.error("ERROR: ",e);
				wrapper.put("error", "error al procesar los registros. "+e.getMessage());
			}
			return wrapper;
			}
		
		//***** Catalogo MP ****
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> cargarDatosMP(File file) {
			Map<String, Object> wrapper = new HashMap<String, Object>();
			List<Object> result = null;
			try {
				CargaCSV datosCSV = new CargaCSV();
			try {
				wrapper = datosCSV.loadCSVMP(file);
				} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
					this.logCargaMasiva.error("ERROR: ",e);
				} catch (FileNotFoundException e) {
					this.logCargaMasiva.error("ERROR: ",e);
				}catch (Exception e) {
					this.logCargaMasiva.error("ERROR: ",e);
				}
				String salida = (String) wrapper.get("error");
				if (salida != null) {
					wrapper.put("error", "error al procesar los registros");
					return wrapper;
				}
												
			result=(List<Object>)wrapper.get("result");
			List<CatalogoMP> listaExistente= new ArrayList<CatalogoMP>(); 
			listaExistente.addAll(CatalogoMP.getCatalogoMPService().listaDeCatalogoMP(null, null));
			List<CatalogoMP> cata = (List<CatalogoMP>) result.get(0);
											
			for (CatalogoMP rec : cata) {
				rec.guardarObjeto(); 
				}
			}catch (Exception e) {
				this.logCargaMasiva.error("ERROR: ",e);
				wrapper.put("error", "error al procesar los registros. "+e.getMessage());
			}
			return wrapper;
		}
		
		//***** Catalogo MP ****
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> cargarDatoEstados(File file) {
			Map<String, Object> wrapper = new HashMap<String, Object>();
			List<Object> result = null;
			try {
				CargaCSV datosCSV = new CargaCSV();
			try {
				wrapper = datosCSV.loadCSVEstados(file);
				} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
					this.logCargaMasiva.error("ERROR: ",e);
				} catch (FileNotFoundException e) {
					this.logCargaMasiva.error("ERROR: ",e);
				}catch (Exception e) {
					this.logCargaMasiva.error("ERROR: ",e);
				}
				String salida = (String) wrapper.get("error");
				if (salida != null) {
					wrapper.put("error", "error al procesar los registros");
					return wrapper;
				}
												
			result=(List<Object>)wrapper.get("result");
			List<Estado> listaExistente= new ArrayList<Estado>(); 
			listaExistente.addAll(Estado.getEstadoService().listaDeEstado());
			List<Estado> cata = (List<Estado>) result.get(0);
											
			for (Estado rec : cata) {
				rec.guardarObjeto(); 
				}
			}catch (Exception e) {
				this.logCargaMasiva.error("ERROR: ",e);
				wrapper.put("error", "error al procesar los registros. "+e.getMessage());
			}
			return wrapper;
		}
		
		//***** Catalogo Municipios ****
		@SuppressWarnings("unchecked")
		@Override
		public Map<String, Object> cargarDatosMunicipios(File file) {
			Map<String, Object> wrapper = new HashMap<String, Object>();
			List<Object> result = null;
			try {
				CargaCSV datosCSV = new CargaCSV();
			try {
				wrapper = datosCSV.loadCSVMunicipios(file);
				} catch (IndexOutOfBoundsException | IllegalAccessError  e) {
					this.logCargaMasiva.error("ERROR: ",e);
				} catch (FileNotFoundException e) {
					this.logCargaMasiva.error("ERROR: ",e);
				}catch (Exception e) {
					this.logCargaMasiva.error("ERROR: ",e);
				}
				String salida = (String) wrapper.get("error");
				if (salida != null) {
					wrapper.put("error", "error al procesar los registros");
					return wrapper;
				}
												
			result=(List<Object>)wrapper.get("result");
			List<Municipio> listaExistente= new ArrayList<Municipio>(); 
			listaExistente.addAll(Municipio.getMunicipioService().listaDeMunicipios(null));
			List<Municipio> cata = (List<Municipio>) result.get(0);
											
			for (Municipio rec : cata) {
				rec.guardarObjeto(); 
				}
			}catch (Exception e) {
				this.logCargaMasiva.error("ERROR: ",e);
				wrapper.put("error", "error al procesar los registros. "+e.getMessage());
			}
			return wrapper;
		}
}