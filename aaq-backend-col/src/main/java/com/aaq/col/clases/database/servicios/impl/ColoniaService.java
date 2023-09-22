package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Colonia;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.repositorios.impl.ColoniaDao;
import com.aaq.col.clases.database.servicios.interfase.ColoniaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("coloniaService")
@Transactional
public class ColoniaService implements ColoniaServiceInterfase {
	
	@Autowired
	@Qualifier("coloniaDao")
	ColoniaDao coloniaDao;

	@Override
	public Colonia objetoColonia(final String id) {
		return this.coloniaDao.objetoColonia(id);
	}

	@Override
	public Colonia objetoColonia(final String idcolonia, final String idmunicipio) {
		return this.coloniaDao.objetoColonia(idcolonia, idmunicipio);
	}

	@Override
	public List<Colonia> listaDeColonia(final Estado estado, final String idmunicipio) {
		return this.coloniaDao.listaDeColonia(estado, idmunicipio);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Colonia t) {
		return this.coloniaDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Colonia t) {
		return this.coloniaDao.guardarObjeto(t);
	}
}