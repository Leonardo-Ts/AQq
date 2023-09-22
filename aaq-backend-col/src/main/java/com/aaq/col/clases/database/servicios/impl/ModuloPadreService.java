package com.aaq.col.clases.database.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.ModuloPadre;
import com.aaq.col.clases.database.repositorios.impl.ModuloPadreDao;
import com.aaq.col.clases.database.servicios.interfase.ModuloPadreServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("moduloPadreService")
@Transactional
public class ModuloPadreService implements ModuloPadreServiceInterfase {
	
	@Autowired
	@Qualifier("moduloPadreDao")
	ModuloPadreDao moduloPadreDao;

	@Override
	public ModuloPadre objetoModuloPadre(final String id) {
		return this.moduloPadreDao.objetoModuloPadre(id);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final ModuloPadre t) {
		return this.moduloPadreDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final ModuloPadre t) {
		return this.moduloPadreDao.guardarObjeto(t);
	}
}