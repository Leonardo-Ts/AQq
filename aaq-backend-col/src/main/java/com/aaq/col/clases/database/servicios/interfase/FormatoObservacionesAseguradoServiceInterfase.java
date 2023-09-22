package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoObservacionesAsegurado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoObservacionesAseguradoServiceInterfase
		extends JMServicioGenericoInterfase<FormatoObservacionesAsegurado> {

	
	public abstract FormatoObservacionesAsegurado objetoFormatoObservacionesAsegurado(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoObservacionesAsegurado t);
	public abstract List<FormatoObservacionesAsegurado> listaDeFormatoObservacionesAsegurado();
	public abstract int obtenerConsecutivo(String reporte);
}