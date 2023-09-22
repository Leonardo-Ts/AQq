package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistencia;
import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistenciaIdentificador;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoProveedorAsistenciaIdentificadorDaoInterfase extends
		JMRepositorioGenericoInterfase<CatalogoProveedorAsistenciaIdentificador> {

	public abstract CatalogoProveedorAsistenciaIdentificador objetoCatalogoProveedorAsistenciaIdentificador(
			final String id);
	public abstract CatalogoProveedorAsistenciaIdentificador objetoCatalogoProveedorAsistenciaIdentificadorParaNumero(
			final Integer numero);
	public abstract List<CatalogoProveedorAsistenciaIdentificador> listaDeCatalogoProveedorAsistenciaIdentificador(
			CatalogoProveedorAsistencia prov);

}