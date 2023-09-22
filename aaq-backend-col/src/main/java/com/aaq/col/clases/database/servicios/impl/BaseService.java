 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.repositorios.impl.BaseDao;
import com.aaq.col.clases.database.servicios.interfase.BaseServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("baseService")
@Transactional
public class BaseService implements BaseServiceInterfase {
	@Autowired
	@Qualifier("baseDao")
	BaseDao baseDao;

	@Override
	public Base objetoBase(final String id) {
		return this.baseDao.objetoBase(id);
	}

	@Override
	public List<Base> listaDeBase(final Estado estado) {
		return this.baseDao.listaDeBase(estado);
	}

	@Override
	public List<Base> listaDeBase(final Estado estado, final boolean todas) {
		return this.baseDao.listaDeBase(estado, todas);
	}

	@Override
	public List<Base> listaDeBase(final Estado estado, final String idPermitido, final boolean todas,
			final boolean foraneo, final Boolean conLatitudLongitud, final Boolean habilitadasEnMapa) {
		return this.baseDao.listaDeBase(estado, idPermitido, todas, foraneo,conLatitudLongitud,habilitadasEnMapa);
	}

	@Override
	public List<JMEntidadObjeto> listaDeReporteDeUso(final Estado estado) {
		return this.baseDao.listaDeReporteDeUso(estado);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Base t) {
		return this.baseDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Base t) {
		return this.baseDao.guardarObjeto(t);
	}
}