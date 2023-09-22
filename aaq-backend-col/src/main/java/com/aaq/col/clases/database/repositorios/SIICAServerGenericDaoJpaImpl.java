package com.aaq.col.clases.database.repositorios;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoJpa;


public abstract class SIICAServerGenericDaoJpaImpl<T extends JMEntidad> extends JMRepositorioGenericoJpa<T> {
	
	@PersistenceContext(type=PersistenceContextType.TRANSACTION, unitName = "AAQColServer")
	private EntityManager entityManager;

	@Override
	public EntityManager getEntityManager() {		
		return this.entityManager;
	}

	@Override
	public void setEntityManager(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
