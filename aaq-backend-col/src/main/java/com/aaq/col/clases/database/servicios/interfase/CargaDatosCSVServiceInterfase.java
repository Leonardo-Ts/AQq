package com.aaq.col.clases.database.servicios.interfase;

import java.io.File;
import java.util.Map;

public interface CargaDatosCSVServiceInterfase  {
	public abstract Map<String, Object> cargaDatos(File file);
	public abstract Map<String, Object> cargaDatosCorreos(File file);
	public abstract Map<String, Object> cargaDatosGrupos(File file);
	public abstract Map<String, Object> cargaDatosGruposTerminales(File file);
	public abstract Map<String, Object> cargaDatosHorarios(File file) ;
	public abstract Map<String, Object> cargaDatosMarcas(File file);
	public abstract Map<String, Object> cargaDatosRecuperos(File file);
	public abstract Map<String, Object> cargarDatosColores(File file);
	public abstract Map<String, Object> cargarDatosAseguradora(File file);
	public abstract Map<String, Object> cargarDatosVehTerc(File file);
	public abstract Map<String, Object> cargarDatosTramoCarret(File file);
	public abstract Map<String, Object> cargarDatosFaq(File file);
	public abstract Map<String, Object> cargarDatosCoberturas(File file);
	public abstract Map<String, Object> cargarDatosClaseVeh(File file);
	public abstract Map<String, Object> cargarDatosCredenciales(File file);
	public abstract Map<String, Object> cargarDatosAccidentes(File file);
	public abstract Map<String, Object> cargarDatosRCBienes(File file);
	public abstract Map<String, Object> cargarDatosGrua(File file);
	public abstract Map<String, Object> cargarDatosHospitales(File file);
	public abstract Map<String, Object> cargarDatosMarcaTerc(File file);
	public abstract Map<String, Object> cargarDatosPartesAuto(File file);
	public abstract Map<String, Object> cargarDatosMP(File file);
	public abstract Map<String, Object> cargarDatosMunicipios(File file);
	public abstract Map<String, Object> cargarDatoEstados(File file);
	
}