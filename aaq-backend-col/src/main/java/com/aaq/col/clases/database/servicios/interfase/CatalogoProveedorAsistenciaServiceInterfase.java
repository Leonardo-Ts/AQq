package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistencia;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


public interface CatalogoProveedorAsistenciaServiceInterfase extends
		JMServicioGenericoInterfase<CatalogoProveedorAsistencia> {

	
	public abstract CatalogoProveedorAsistencia objetoCatalogoProveedorAsistencia(final String id) ;
	public abstract CatalogoProveedorAsistencia objetoCatalogoProveedorAsistenciaParaUserYPassword(
			final String username, String passwd) ;
	public abstract List<CatalogoProveedorAsistencia> listaDeCatalogoProveedorAsistencia(final Estado estado);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoProveedorAsistencia t) ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoProveedorAsistencia t);
}