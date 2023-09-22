package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Perfil;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface PerfilServiceInterfase extends JMServicioGenericoInterfase<Perfil> {

	public abstract Perfil objetoPerfil(final String id);
	public abstract List<Perfil> listaDePerfil() ;
	public abstract JMResultadoOperacion eliminarObjeto(Perfil t);
	public abstract JMResultadoOperacion guardarObjeto(Perfil t) ;
}