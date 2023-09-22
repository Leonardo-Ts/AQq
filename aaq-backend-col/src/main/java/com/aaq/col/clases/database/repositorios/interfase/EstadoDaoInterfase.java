package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface EstadoDaoInterfase extends JMRepositorioGenericoInterfase<Estado> {

	public abstract Estado objetoEstado(String id);
	public abstract List<Estado> listaDeEstado();
	public abstract List<Estado> listaDeEstado(String nombre, Integer identidad, String orden);
	public abstract Estado objetoEstadoNombre(final String nombre);

}