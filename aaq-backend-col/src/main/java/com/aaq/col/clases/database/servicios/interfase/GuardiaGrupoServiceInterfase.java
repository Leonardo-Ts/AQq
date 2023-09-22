package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.GuardiaGrupo;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface GuardiaGrupoServiceInterfase extends JMServicioGenericoInterfase<GuardiaGrupo> {

	public abstract GuardiaGrupo objetoGuardiaGrupo(final String id) ;
	public abstract List<GuardiaGrupo> listaDeGuardiaGrupo(final Grupo grupo) ;
	public abstract  List<GuardiaGrupo> listaDeGuardiaGrupo(final Terminal terminal) ;
	public abstract JMResultadoOperacion eliminarObjeto(GuardiaGrupo t) ;
	public abstract JMResultadoOperacion guardarObjeto(GuardiaGrupo t) ;
	public abstract GuardiaGrupo objetoGuardiaPorGrupo(Grupo idGrupo) ;
}