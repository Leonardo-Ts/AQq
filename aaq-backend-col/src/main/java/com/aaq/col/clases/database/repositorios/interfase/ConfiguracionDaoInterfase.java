package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface ConfiguracionDaoInterfase extends JMRepositorioGenericoInterfase<Configuracion> {

	public abstract Configuracion objetoConfiguracion(String id);
	public abstract boolean obtenerBooleano(String llave);
	public abstract int obtenerEntero(String llave);
	public abstract double obtenerDoble(String llave);
	public abstract String obtenerCadena(String llave);
	public abstract String obtenerUltimoId(String tabla);
	public abstract List<Configuracion> listaDeConfiguracion();

}