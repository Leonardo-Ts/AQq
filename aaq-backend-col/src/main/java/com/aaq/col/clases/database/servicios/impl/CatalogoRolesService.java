 package com.aaq.col.clases.database.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CatalogoRoles;
import com.aaq.col.clases.database.repositorios.impl.CatalogoRolesDao;
import com.aaq.col.clases.database.servicios.interfase.CatalogoRolesServiceInterfase;

@Service("catalogoRolesService")
@Transactional
public class CatalogoRolesService implements CatalogoRolesServiceInterfase {
	
	@Autowired
	@Qualifier("catalogoRolesDao")
	CatalogoRolesDao catalogoRolesDao;

	@Override
	public CatalogoRoles objetoRol(String id)  {
		return this.catalogoRolesDao.objetoRol(id);
	}

	@Override
	public List<CatalogoRoles> listaDeRoles() {
		return this.catalogoRolesDao.listaDeRoles();
	}

	@Override
	public List<CatalogoRoles> listaDeRoles(String nombre, String orden) {
		return this.catalogoRolesDao.listaDeRoles(nombre, orden);
	}
}