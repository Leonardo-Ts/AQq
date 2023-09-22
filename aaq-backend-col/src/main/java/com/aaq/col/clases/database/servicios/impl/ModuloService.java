package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Modulo;
import com.aaq.col.clases.database.entidades.ModuloPadre;
import com.aaq.col.clases.database.repositorios.impl.ModuloDao;
import com.aaq.col.clases.database.servicios.interfase.ModuloServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("moduloService")
@Transactional
public class ModuloService implements ModuloServiceInterfase {
	
	@Autowired
	@Qualifier("moduloDao")
	ModuloDao moduloDao;

	@Override
	public Modulo objetoModulo(final String id) {
		return this.moduloDao.objetoModulo(id);
	}

	@Override
	public List<Modulo> listaDeModulo() {
		return this.moduloDao.listaDeModulo();
	}

	@Override
	public List<Modulo> listaDeModulo(final ModuloPadre moduloPadre, final String[] paginas, final boolean conNombres) {
		return this.moduloDao.listaDeModulo(moduloPadre, paginas, conNombres);
	}

	@Override
	public List<Modulo> listaDeModulo(final List<Integer> listaNoPermitida, final ModuloPadre moduloPadre,
			final String nombre, final String nombresiicav3, final Object[] pagina, final boolean conNombres) {
		return this.moduloDao.listaDeModulo(listaNoPermitida, moduloPadre, nombre, nombresiicav3, pagina, conNombres);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Modulo t) {
		return this.moduloDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Modulo t) {
		return this.moduloDao.guardarObjeto(t);
	}
}