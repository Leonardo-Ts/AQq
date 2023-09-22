package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Carretera;
import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface CarreteraDaoInterfase extends JMRepositorioGenericoInterfase<Carretera> {

	public abstract Carretera objetoCarretera(String id);
	public abstract List<Carretera> listaDeCarretera(Estado estado, String nombre);

}