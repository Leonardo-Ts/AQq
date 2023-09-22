 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Horarios;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface HorariosServiceInterfase extends JMServicioGenericoInterfase<Horarios> {

	public abstract Horarios objetoHorarios(String id) ;
	public abstract List<Horarios> listaDeHorarios(String clave_horario);
	public abstract JMResultadoOperacion eliminarObjeto(Horarios t) ;
	public abstract JMResultadoOperacion guardarObjeto(Horarios t) ;
	public abstract List<Horarios> listaDeHorarios();
	public abstract List<Horarios> listaDeHorariosAgroup(Estado estado) ;
	public abstract Horarios horarioDia(String clave_horario, int dia_num);
	public abstract List<Horarios> listaDeHorarios(Estado estado, String clave_horario);
	public abstract Horarios horarioDia(final String clave_horario, final int dia_num, final Estado edo) ;

}