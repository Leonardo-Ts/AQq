 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoRoles;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;

public interface CatalogoRolesServiceInterfase extends JMServicioGenericoInterfase<CatalogoRoles> {

	public abstract CatalogoRoles objetoRol(String id);
	public abstract List<CatalogoRoles> listaDeRoles();
	public abstract List<CatalogoRoles> listaDeRoles(String nombre, String orden);
}