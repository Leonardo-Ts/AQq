package com.aaq.col.clases.database.repositorios.interfase;

import com.aaq.col.clases.database.entidades.EntidadAbogadoCrm;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

/**
 *
 */
public interface EntidadAbogadoCrmDaoInterfase extends JMRepositorioGenericoInterfase<EntidadAbogadoCrm> {

	public abstract EntidadAbogadoCrm objetoEntidadAbogadoCrm(final String nombreEntidad);
}