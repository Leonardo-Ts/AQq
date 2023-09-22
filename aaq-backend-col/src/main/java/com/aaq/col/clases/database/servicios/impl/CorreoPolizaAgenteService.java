package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CorreoPolizaAgente;
import com.aaq.col.clases.database.repositorios.impl.CorreoPolizaAgenteDao;
import com.aaq.col.clases.database.servicios.interfase.CorreoPolizaAgenteServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("correoPolizaAgenteService")
@Transactional
public class CorreoPolizaAgenteService implements CorreoPolizaAgenteServiceInterfase {
	
	@Autowired
	@Qualifier("correoPolizaAgenteDao")
	CorreoPolizaAgenteDao correoPolizaAgenteDao;

	@Override
	public CorreoPolizaAgente objetoCorreoPolizaAgente(final String id) {
		return this.correoPolizaAgenteDao.objetoCorreoPolizaAgente(id);
	}

	@Override
	public List<CorreoPolizaAgente> listaDeCorreoPolizaAgente() {
		return this.correoPolizaAgenteDao.listaDeCorreoPolizaAgente();
	}

	@Override
	public List<CorreoPolizaAgente> listaDeCorreoPolizaAgente(final String poliza, final String claveAgente) {
		return this.correoPolizaAgenteDao.listaDeCorreoPolizaAgente(poliza, claveAgente);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final CorreoPolizaAgente t) {
		return this.correoPolizaAgenteDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final CorreoPolizaAgente t) {
		return this.correoPolizaAgenteDao.guardarObjeto(t);
	}
}