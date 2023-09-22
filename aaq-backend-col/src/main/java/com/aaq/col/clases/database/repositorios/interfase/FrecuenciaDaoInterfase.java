package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FrecuenciaDaoInterfase extends JMRepositorioGenericoInterfase<Frecuencia> {

	public abstract Frecuencia objetoFrecuencia(String id);
	public abstract List<Frecuencia> listaDeFrecuencia(Estado estado);

}