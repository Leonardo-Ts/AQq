package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Grupo;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface GrupoServiceInterfase extends JMServicioGenericoInterfase<Grupo> {

	public abstract Grupo objetoGrupo(final String id) ;
	public abstract List<Grupo> listaDeGrupo() ;
	public abstract JMResultadoOperacion eliminarObjeto(Grupo t) ;
	public abstract JMResultadoOperacion guardarObjeto(Grupo t) ;
	public abstract Grupo objetoGrupoPorNombre(String nombre);
	public abstract List<Grupo> listaDeGrupo(Estado estado);
	public abstract Grupo listaDeGrupoEdoNom(Estado estado, String nombre);
}