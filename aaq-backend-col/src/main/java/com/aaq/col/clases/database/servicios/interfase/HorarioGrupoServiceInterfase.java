package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.HorarioGrupo;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface HorarioGrupoServiceInterfase extends JMServicioGenericoInterfase<HorarioGrupo> {

	public abstract HorarioGrupo objetoHorarioGrupo(final String id) ;
	public abstract List<HorarioGrupo> listaDeHorarioGrupo() ;
	public abstract List<HorarioGrupo> listaDeHorarioGrupo(final Grupo grupo) ;
	public abstract  List<HorarioGrupo> listaDeHorarioGrupo(final String claveHorario) ;
	public abstract JMResultadoOperacion eliminarObjeto(HorarioGrupo t) ;
	public abstract JMResultadoOperacion guardarObjeto(HorarioGrupo t) ;
	public abstract HorarioGrupo horarioGrupoFecha(Grupo grupo, Date current);
	public abstract List<HorarioGrupo> listaDeHorarioGrupoFechaAsc(Grupo grupo);

}