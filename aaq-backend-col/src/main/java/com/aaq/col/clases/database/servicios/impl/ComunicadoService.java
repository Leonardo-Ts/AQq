package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Comunicado;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.repositorios.impl.ComunicadoDao;
import com.aaq.col.clases.database.servicios.interfase.ComunicadoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("comunicadoService")
@Transactional
public class ComunicadoService implements ComunicadoServiceInterfase {
	
	@Autowired
	@Qualifier("comunicadoDao")
	ComunicadoDao comunicadoDao;

	@Override
	public Comunicado objetoComunicado(final String id) {
		return this.comunicadoDao.objetoComunicado(id);
	}

	@Override
	public List<Comunicado> listaDeComunicado(final Estado estado, final Base base, final Terminal terminal,
			final Boolean soloActivos) {
		return this.comunicadoDao.listaDeComunicado(estado, base, terminal, soloActivos);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Comunicado t) {
		return this.comunicadoDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Comunicado t) {
		return this.comunicadoDao.guardarObjeto(t);
	}
}