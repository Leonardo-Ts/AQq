package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoInventarioUnicoPesado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoInventarioUnicoPesadoServiceInterfase
		extends JMServicioGenericoInterfase<FormatoInventarioUnicoPesado> {

	public abstract FormatoInventarioUnicoPesado objetoFormatoInventarioUnicoPesado(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoInventarioUnicoPesado t);
	public abstract List<FormatoInventarioUnicoPesado> listaDeFormatoInventarioUnicoPesado();
	public abstract int obtenerConsecutivo(String reporte);

}