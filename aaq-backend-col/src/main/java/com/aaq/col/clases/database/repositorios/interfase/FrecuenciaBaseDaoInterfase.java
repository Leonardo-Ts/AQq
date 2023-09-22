 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FrecuenciaBaseDaoInterfase extends JMRepositorioGenericoInterfase<FrecuenciaBase> {

	/**
	 * @author mfernandez Jun 17, 2009 9:22:53 AM
	 * @param id
	 * @return el objeto
	 */

	public abstract FrecuenciaBase objetoFrecuenciaBase(final String id);

	/**
	 * @author mfernandez Jun 4, 2009 4:45:26 AM
	 * @param frecuencia
	 * @return la lista de frecuencia base
	 */

	public abstract List<FrecuenciaBase> listaDeFrecuenciaBase(final Frecuencia frecuencia);
	
	public abstract List<FrecuenciaBase> listaDeFrecuenciaBase(final Base base);
	
	public abstract List<FrecuenciaBase> listaDeFrecuenciaBaseGH(final Frecuencia frecuencia);

}