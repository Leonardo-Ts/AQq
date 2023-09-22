 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoTipoAsistencia;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


public interface CatalogoTipoAsistenciaServiceInterfase extends JMServicioGenericoInterfase<CatalogoTipoAsistencia> {

	public abstract CatalogoTipoAsistencia objetoCatalogoTipoAsistencia(final String id) ;
	public abstract List<CatalogoTipoAsistencia> listaDeCatalogoTipoAsistencia();
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoTipoAsistencia t) ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoTipoAsistencia t) ;
}