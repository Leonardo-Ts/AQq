package com.aaq.col.system.database.entidades.modelo;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistencia;
import com.jmfg.jmlib.sistema.classes.dao.modelo.JMModeloBasico;

public class CatalogoProveedorAsistenciaDataModel extends JMModeloBasico<CatalogoProveedorAsistencia> {
	
	private static final long serialVersionUID = -6487871078506162778L;

	public CatalogoProveedorAsistenciaDataModel(final List<CatalogoProveedorAsistencia> datasource) {
		super(datasource);
	}
}