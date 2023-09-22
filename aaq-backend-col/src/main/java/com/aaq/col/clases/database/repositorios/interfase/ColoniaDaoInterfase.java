package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Colonia;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface ColoniaDaoInterfase extends JMRepositorioGenericoInterfase<Colonia> {

	public abstract Colonia objetoColonia(final String id);
	public abstract Colonia objetoColonia(final String idcolonia, String idmunicipio);
	public abstract List<Colonia> listaDeColonia(final Estado estado, final String idmunicipio);

}