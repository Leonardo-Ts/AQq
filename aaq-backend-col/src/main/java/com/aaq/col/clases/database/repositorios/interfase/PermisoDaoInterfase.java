 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.Permiso;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface PermisoDaoInterfase extends JMRepositorioGenericoInterfase<Permiso> {

	public abstract Permiso objetoPermiso(final String id);
	public abstract List<Permiso> listaDePermiso(final Perfil perfil);

}