package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoReparacionBienesDiversos;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoReparacionBienesDiversosServiceInterfase
		extends JMServicioGenericoInterfase<FormatoReparacionBienesDiversos> {

	
	public abstract FormatoReparacionBienesDiversos objetoFormatoReparacionBienesDiversos(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoReparacionBienesDiversos t);
	public abstract List<FormatoReparacionBienesDiversos> listaDeFormatoReparacionBienesDiversos();
	public abstract int obtenerConsecutivo(String reporte);
}