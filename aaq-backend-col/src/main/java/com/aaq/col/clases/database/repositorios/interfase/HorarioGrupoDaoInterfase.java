package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.HorarioGrupo;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface HorarioGrupoDaoInterfase extends JMRepositorioGenericoInterfase<HorarioGrupo> {

	public abstract HorarioGrupo objetoHorarioGrupo(final String id);

	public abstract List<HorarioGrupo> listaDeHorarioGrupo(final Grupo grupo);
	
	public abstract List<HorarioGrupo> listaDeHorarioGrupo(final String claveHorario);

	public abstract List<HorarioGrupo> listaDeHorarioGrupo();

	public abstract HorarioGrupo horarioEncontrado(Grupo idgrupo);
	
	public abstract List<HorarioGrupo> listaDeHorarioGrupo(Grupo grupo, String claveHorario);

	public abstract HorarioGrupo horarioGrupoFecha(Grupo grupo, Date fecha);
	
	public abstract List<HorarioGrupo> listaDeHorarioGrupoFechaAsc(Grupo grupo);

}