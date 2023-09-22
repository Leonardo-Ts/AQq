package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistencia;
import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistenciaIdentificador;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoProveedorAsistenciaIdentificadorServiceInterfase extends
		JMServicioGenericoInterfase<CatalogoProveedorAsistenciaIdentificador> {

	public abstract CatalogoProveedorAsistenciaIdentificador objetoCatalogoProveedorAsistenciaIdentificador(
			final String id);
	public abstract CatalogoProveedorAsistenciaIdentificador objetoCatalogoProveedorAsistenciaIdentificadorParaNumero(
			final Integer numero);
	public abstract List<CatalogoProveedorAsistenciaIdentificador> listaDeCatalogoProveedorAsistenciaIdentificador(
			CatalogoProveedorAsistencia prov);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoProveedorAsistenciaIdentificador t) ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoProveedorAsistenciaIdentificador t) ;
}