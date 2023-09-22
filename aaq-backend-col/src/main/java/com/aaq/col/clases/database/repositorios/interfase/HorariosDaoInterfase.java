package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Horarios;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface HorariosDaoInterfase extends JMRepositorioGenericoInterfase<Horarios> {

	public abstract Horarios objetoHorario(String id);
	public abstract List<Horarios> listaDeHorarios(String clave_horario);
	public abstract List<Horarios> listaDeHorarios();
	public abstract List<Horarios> listaDeHorariosAgroup(Estado estado);
	public abstract Horarios horarioDia(String clave_horario, int dia_num);
	public abstract List<Horarios> listaDeHorarios(Estado estado, String clave_horario);
	public abstract Horarios horarioDia(final String clave_horario, final int dia_num, final Estado edo) ;


}