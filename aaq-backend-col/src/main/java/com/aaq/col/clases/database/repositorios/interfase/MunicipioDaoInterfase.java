package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Municipio;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface MunicipioDaoInterfase extends JMRepositorioGenericoInterfase<Municipio> {
	public abstract Municipio objetoMunicipio(final String id);
	public abstract Municipio objetoMunicipio(final Estado estado, final String idmunicipio);
	public abstract List<Municipio> listaDeMunicipios(final Estado estado);

}