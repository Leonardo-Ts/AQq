package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Municipio;
import com.aaq.col.clases.database.repositorios.impl.MunicipioDao;
import com.aaq.col.clases.database.servicios.interfase.MunicipioServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("municipioService")
@Transactional
public class MunicipioService implements MunicipioServiceInterfase {
	
	@Autowired
	@Qualifier("municipioDao")
	MunicipioDao municipioDao;

	@Override
	public Municipio objetoMunicipio(final String id) {
		return this.municipioDao.objetoMunicipio(id);
	}

	@Override
	public Municipio objetoMunicipio(final Estado estado, final String idmunicipio) {
		return this.municipioDao.objetoMunicipio(estado, idmunicipio);
	}

	@Override
	public List<Municipio> listaDeMunicipios(final Estado estado) {
		return this.municipioDao.listaDeMunicipios(estado);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Municipio t) {
		return this.municipioDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Municipio t) {
		return this.municipioDao.guardarObjeto(t);
	}
}