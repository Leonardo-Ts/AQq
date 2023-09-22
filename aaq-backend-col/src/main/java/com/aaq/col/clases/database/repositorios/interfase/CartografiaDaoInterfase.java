package com.aaq.col.clases.database.repositorios.interfase;

import com.aaq.col.clases.database.entidades.Cartografia;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CartografiaDaoInterfase extends JMRepositorioGenericoInterfase<Cartografia> {

	public abstract Cartografia objetoCartografia(final String id);
	public abstract Cartografia objetoCartografia(final Estado estado, final Integer tipo);

}