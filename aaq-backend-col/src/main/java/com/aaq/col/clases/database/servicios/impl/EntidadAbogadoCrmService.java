package com.aaq.col.clases.database.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.EntidadAbogadoCrm;
import com.aaq.col.clases.database.repositorios.impl.EntidadAbogadoCrmDao;
import com.aaq.col.clases.database.servicios.interfase.EntidadAbogadoCrmServiceInterfase;


@Service("entidadAbogadoCrmService")
@Transactional
public class EntidadAbogadoCrmService implements EntidadAbogadoCrmServiceInterfase {
	
	@Autowired
	@Qualifier("entidadAbogadoCrmDao")
	EntidadAbogadoCrmDao entidadAbogadoCrmDao;

	@Override
	public EntidadAbogadoCrm objetoEntidadAbogadoCrm(String nombreEntidad) {
		return this.entidadAbogadoCrmDao.objetoEntidadAbogadoCrm(nombreEntidad);
	}
}