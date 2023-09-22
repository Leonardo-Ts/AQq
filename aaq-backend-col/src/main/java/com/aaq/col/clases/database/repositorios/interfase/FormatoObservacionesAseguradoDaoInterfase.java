package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoObservacionesAsegurado;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoObservacionesAsegurado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FormatoObservacionesAseguradoDaoInterfase
		extends JMRepositorioGenericoInterfase<FormatoObservacionesAsegurado> {

	public abstract FormatoObservacionesAsegurado objetoFormatoObservacionesAsegurado(final String id);
	public abstract List<FormatoObservacionesAsegurado> listaDeFormatoObservacionesAsegurado();
	public abstract String InsertarFormatoObservacionesAsegurado(DatosInsertarFormatoObservacionesAsegurado entrada);
	public abstract String ejecutarFuncionWebserviceStoreFOA(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);

}