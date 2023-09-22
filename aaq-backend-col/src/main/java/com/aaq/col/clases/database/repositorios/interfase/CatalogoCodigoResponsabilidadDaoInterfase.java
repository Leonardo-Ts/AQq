package com.aaq.col.clases.database.repositorios.interfase;

import com.aaq.col.clases.database.entidades.CatalogoCodigoResponsabilidad;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoCodigoResponsabilidadDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoCodigoResponsabilidad> {

	public abstract CatalogoCodigoResponsabilidad objetoCatalogoCodigoResponsabilidadClave(String codigo);

}