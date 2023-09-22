package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Referencia;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface ReferenciaDaoInterfase extends JMRepositorioGenericoInterfase<Referencia> {

	public abstract Referencia objetoReferencia(String id);
	public abstract List<Referencia> listaDeReferencia(Estado estado, String nombre);

}