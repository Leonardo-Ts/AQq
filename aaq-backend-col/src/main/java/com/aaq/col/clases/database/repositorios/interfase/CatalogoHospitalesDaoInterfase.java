package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoHospitales;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoHospitalesDaoInterfase extends JMRepositorioGenericoInterfase<CatalogoHospitales> {

	public abstract CatalogoHospitales objetoCatalogoHospitales(final String id) ;
	public abstract List<CatalogoHospitales> listaDeCatalogoHospitales(final String clave);
}
