package com.aaq.col.clases.database.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoCodigoResponsabilidad;
import com.aaq.col.clases.database.repositorios.impl.CatalogoCodigoResponsabilidadDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCodigoResponsabilidadServiceInterfase;

@Service("catalogoCodigoResponsabilidadService")
@Transactional
public class CatalogoCodigoResponsabilidadService implements CatalogoCodigoResponsabilidadServiceInterfase {
	@Autowired
	@Qualifier("catalogoCodigoResponsabilidadDao")
	CatalogoCodigoResponsabilidadDao catalogoCodigoResponsabilidadDao;

	@Override
	public CatalogoCodigoResponsabilidad objetoCatalogoCodigoResponsabilidadClave(String codigo)  {
		return this.catalogoCodigoResponsabilidadDao.objetoCatalogoCodigoResponsabilidadClave(codigo);
	}
}