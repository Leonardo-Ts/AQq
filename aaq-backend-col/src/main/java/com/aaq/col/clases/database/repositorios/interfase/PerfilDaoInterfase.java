 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Perfil;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface PerfilDaoInterfase extends JMRepositorioGenericoInterfase<Perfil> {


	public abstract Perfil objetoPerfil(final String id);
	public abstract List<Perfil> listaDePerfil();

}