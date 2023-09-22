package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.HorarioGrupo;
import com.aaq.col.clases.database.repositorios.impl.HorarioGrupoDao;
import com.aaq.col.clases.database.servicios.interfase.HorarioGrupoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("horarioGrupoService")
@Transactional
public class HorarioGrupoService implements HorarioGrupoServiceInterfase {
	
	@Autowired
	@Qualifier("horarioGrupoDao")
	HorarioGrupoDao horarioGrupoDao;

	@Override
	public HorarioGrupo objetoHorarioGrupo(final String id) {
		return this.horarioGrupoDao.objetoHorarioGrupo(id);
	}

	@Override
	public List<HorarioGrupo> listaDeHorarioGrupo() {
		return this.horarioGrupoDao.listaDeHorarioGrupo();
	}
	
	@Override
	public List<HorarioGrupo> listaDeHorarioGrupo(final Grupo grupo) {
		return this.horarioGrupoDao.listaDeHorarioGrupo(grupo);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final HorarioGrupo t) {
		return this.horarioGrupoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final HorarioGrupo t) {
		return this.horarioGrupoDao.guardarObjeto(t);
	}

	@Override
	public List<HorarioGrupo> listaDeHorarioGrupo(String claveHorario) {
		return this.horarioGrupoDao.listaDeHorarioGrupo(claveHorario);
	}

	@Override
	public HorarioGrupo horarioGrupoFecha(Grupo grupo, Date current) {
		return this.horarioGrupoDao.horarioGrupoFecha(grupo, current);
	}
	
	@Override
	public List<HorarioGrupo> listaDeHorarioGrupoFechaAsc(Grupo grupo) {
		return this.horarioGrupoDao.listaDeHorarioGrupoFechaAsc(grupo);
	}

}