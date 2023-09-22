 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistencia;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoProveedorAsistenciaDaoInterfase extends
		JMRepositorioGenericoInterfase<CatalogoProveedorAsistencia> {

	public abstract CatalogoProveedorAsistencia objetoCatalogoProveedorAsistencia(final String id);
	public abstract CatalogoProveedorAsistencia objetoCatalogoProveedorAsistenciaParaUserYPassword(
			final String username, String passwd);
	public abstract List<CatalogoProveedorAsistencia> listaDeCatalogoProveedorAsistencia(final Estado estado);

}