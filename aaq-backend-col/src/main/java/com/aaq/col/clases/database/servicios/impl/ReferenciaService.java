package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Referencia;
import com.aaq.col.clases.database.repositorios.impl.ReferenciaDao;
import com.aaq.col.clases.database.servicios.interfase.ReferenciaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("referenciaService")
@Transactional
public class ReferenciaService implements ReferenciaServiceInterfase {
	
	@Autowired
	@Qualifier("referenciaDao")
	ReferenciaDao referenciaDao;

	@Override
	public Referencia objetoReferencia(final String id) {
		return this.referenciaDao.objetoReferencia(id);
	}

	@Override
	public List<Referencia> listaDeReferencia(final Estado estado, final String nombre) {
		return this.referenciaDao.listaDeReferencia(estado, nombre);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Referencia t) {
		return this.referenciaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Referencia t) {
		return this.referenciaDao.guardarObjeto(t);
	}
}