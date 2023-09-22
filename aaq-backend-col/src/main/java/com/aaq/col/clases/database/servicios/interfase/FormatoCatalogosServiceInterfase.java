package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoCatalogos;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoCatalogosServiceInterfase extends JMServicioGenericoInterfase<FormatoCatalogos> {

	public abstract FormatoCatalogos objetoFormatoCatalogos(final String id);
	public abstract List<FormatoCatalogos> listaDeFormatoCatalogos();
	public abstract String ejecutarFuncionInsertarCatalogos(String nombre, String valores);
	public abstract JMResultadoOperacion eliminarObjeto(FormatoCatalogos t);
	public abstract JMResultadoOperacion guardarObjeto(FormatoCatalogos t);
	public abstract List<FormatoCatalogos> listaDeFormatoCatalogos(String nombre);
}