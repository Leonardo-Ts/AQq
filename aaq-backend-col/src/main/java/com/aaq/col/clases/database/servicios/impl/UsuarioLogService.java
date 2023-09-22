 package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.UsuarioLog;
import com.aaq.col.clases.database.repositorios.impl.UsuarioLogDao;
import com.aaq.col.clases.database.servicios.interfase.UsuarioLogServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("usuarioLogService")
@Transactional
public class UsuarioLogService implements UsuarioLogServiceInterfase {
	
	@Autowired
	@Qualifier("usuarioLogDao")
	UsuarioLogDao usuarioLogDao;

	@Override
	public UsuarioLog objetoUsuarioLog(final String id) {
		return this.usuarioLogDao.objetoUsuarioLog(id);
	}

	@Override
	public List<UsuarioLog> listaDeUsuarioLog(final Date fechaInicial, final Date fechaFinal, final boolean validez,
			final Integer limite) {
		return this.usuarioLogDao.listaDeUsuarioLog(fechaInicial, fechaFinal, validez, limite);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final UsuarioLog t) {
		return this.usuarioLogDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final UsuarioLog t) {
		return this.usuarioLogDao.guardarObjeto(t);
	}
}