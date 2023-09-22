package com.aaq.col.clases.database.repositorios.impl;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.ModuloPadre;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ModuloPadreDaoInterfase;

@org.springframework.stereotype.Repository(value = "moduloPadreDao")
public class ModuloPadreDao extends SIICAServerGenericDaoJpaImpl<ModuloPadre> implements ModuloPadreDaoInterfase {

	@Override
	public ModuloPadre objetoModuloPadre(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(ModuloPadre.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoModuloPadre", id);
		}
		return null;
	}

}