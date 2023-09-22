package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.CatalogoColores;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoColores_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoColoresDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoColoresDao")
public class CatalogoColoresDao extends SIICAServerGenericDaoJpaImpl<CatalogoColores> implements CatalogoColoresDaoInterfase{


	@Override
	public CatalogoColores objetoCatalogoColores(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoColores.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoColores", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoColores", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoColores", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoColores", id);
		}
		return null;
	}


	
	@Override
	public List<CatalogoColores> listaDeCatalogoColores(final String clave, final String descripcion) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoColores> query = builder.createQuery(CatalogoColores.class);
			final Root<CatalogoColores> root = query.from(CatalogoColores.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.isNotBlank(clave)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoColores_.clave), clave));
			}
			if (StringUtils.isNotBlank(descripcion)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoColores_.descripcion), descripcion));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoColores_.clave)));
			final TypedQuery<CatalogoColores> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoColores");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoColores");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoColores");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoColores");
		}
		return new Vector<>();
	}
}
