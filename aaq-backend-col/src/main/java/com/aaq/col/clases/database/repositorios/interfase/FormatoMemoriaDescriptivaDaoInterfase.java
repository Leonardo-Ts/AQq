package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoMemoriaDescriptiva;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoMemoriaDescriptiva;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface FormatoMemoriaDescriptivaDaoInterfase
		extends JMRepositorioGenericoInterfase<FormatoMemoriaDescriptiva> {

	public abstract FormatoMemoriaDescriptiva objetoFormatoMemoriaDescriptiva(final String id);
	public abstract List<FormatoMemoriaDescriptiva> listaDeFormatoMemoriaDescriptiva();
	public abstract String ejecutarFuncionInsertarMemoriaDescriptiva(
			Date fecha, String reporte, String siniestro, String folioElectro, Integer cobertura, String poliza,
			String endoso, String inciso, String nomSocial, Integer tipoAsegurado, String marca, String tipo,
			String modelo, String placas, String color, String duracionMan, Integer gruaLugar, Integer concesion,
			Integer estatalFede, String maniobras, String tipoGrua, Integer otraGrua, String otraGruaTexto,
			Integer cardan1, Integer cardan2, Integer cardan3, Integer cantidadGruas, Integer traspaleo,
			String tipoTraspaleo, String proveedor, String cantidadGruasTexto, String telefono, String domicilioProv,
			String ubicacionOrigen, String trasladoDestino, Integer camionToneladas, String horarioSolicitado,
			String horarioArribo, String horarioTraslado, String manEspeciales, Integer servicioDesacoplar,
			Integer servicioAbanderaM, Integer servicioAbanderaG, String manualHora, String gruaHora,
			Integer servicioEnganche, Integer servicioFueraC, Integer servicioSobreC, Integer servicioVolcadura,
			Integer servicioCarga, Integer servicioRescate, Integer servicioCustodia, Integer servicioManiobra,
			String firmaAsegurado, String nomEmpleado, String firmaEmpleado, String claveEmpleado,
			String nomOperadorGrua, String numEcoGrua, String firmaOperadorGrua, String croquis, String tipoGruaAbander,
			String correo, Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp

	);
	public abstract String ejecutarFuncionWebserviceStoreFMD(Map<String, String> entry);
	public abstract String InsertarFormatoMemoriaDescriptiva(DatosInsertarFormatoMemoriaDescriptiva entradas);
	public abstract int obtenerConsecutivo(String reporte);

}