package com.aaq.col.clases.database.repositorios.impl;

import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.CatalogoMovil;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoMovil_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoMovilDaoInterfase;


@org.springframework.stereotype.Repository(value = "catalogoMovilDao")
public class CatalogoMovilDao extends SIICAServerGenericDaoJpaImpl<CatalogoMovil> implements CatalogoMovilDaoInterfase {

	@Override
	public CatalogoMovil objetoCatalogoMovil(String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoMovil.class, new Integer(id)):null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMovil", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMovil", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMovil", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMovil", id);
		}
		return null;
	}

	@Override
	public List<CatalogoMovil> listaDeCatalogoMovil() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoMovil> query = builder.createQuery(CatalogoMovil.class);
			final Root<CatalogoMovil> root = query.from(CatalogoMovil.class);
			query.select(root);
						
			query.orderBy(builder.asc(root.get(AbstractCatalogoMovil_.marca)));
			final TypedQuery<CatalogoMovil> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMovil");
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMovil");
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMovil");
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMovil");
		}
		return new Vector<>();
	}

}
