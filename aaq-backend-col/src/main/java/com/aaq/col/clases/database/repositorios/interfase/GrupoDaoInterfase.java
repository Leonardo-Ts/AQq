 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Grupo;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface GrupoDaoInterfase extends JMRepositorioGenericoInterfase<Grupo> {

	public abstract Grupo objetoGrupo(final String id);
	public abstract List<Grupo> listaDeGrupo();
	public abstract Grupo objetoGrupoPorNombre(String nombre);
	public abstract Grupo grupoEncontrado(String nombre);
	public abstract List<Grupo> listaDeGrupo(Estado estado);
	public abstract Grupo listaDeGrupoEdoNom(Estado estado, String nombre);

}