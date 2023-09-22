package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Calle;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CalleDaoInterfase extends JMRepositorioGenericoInterfase<Calle> {

	public abstract Calle objetoCalle(String id);
	public abstract List<Calle> listaDeCalle(Estado estado, String idmunicipio, String idcolonia, String nombre);

}