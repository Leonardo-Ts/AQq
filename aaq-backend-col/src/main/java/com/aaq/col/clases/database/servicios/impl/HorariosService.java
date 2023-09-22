package com.aaq.col.clases.database.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Horarios;
import com.aaq.col.clases.database.repositorios.impl.HorariosDao;
import com.aaq.col.clases.database.servicios.interfase.HorariosServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("horariosService")
@Transactional
public class HorariosService implements HorariosServiceInterfase {
	
	@Autowired
	@Qualifier("horariosDao")
	HorariosDao horariosDao;

	@Override
	public Horarios objetoHorarios(final String id) {
		return this.horariosDao.objetoHorario(id);
	}

	@Override
	public List<Horarios> listaDeHorarios(final String clave_horario) {
		return this.horariosDao.listaDeHorarios(clave_horario);
	}
	
	@Override
	public List<Horarios> listaDeHorarios(final Estado estado, String clave_horario) {
		return this.horariosDao.listaDeHorarios(estado, clave_horario);
	}
	
	@Override
	public Horarios horarioDia(final String clave_horario, final int dia_num) {
		return this.horariosDao.horarioDia(clave_horario, dia_num);
	}
	
	@Override
	public List<Horarios> listaDeHorarios() {
		return this.horariosDao.listaDeHorarios();
	}
	
	@Override
	public List<Horarios> listaDeHorariosAgroup(Estado estado) {
		return this.horariosDao.listaDeHorariosAgroup(estado);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Horarios t) {
		return this.horariosDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Horarios t) {
		return this.horariosDao.guardarObjeto(t);
	}

	@Override
	public Horarios horarioDia(String clave_horario, int dia_num, Estado edo) {
		return this.horariosDao.horarioDia(clave_horario, dia_num, edo);
	}
}