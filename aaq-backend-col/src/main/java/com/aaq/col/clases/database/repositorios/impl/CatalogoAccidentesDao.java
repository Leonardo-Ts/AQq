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
import org.springframework.stereotype.Repository;

import com.aaq.col.clases.database.entidades.CatalogoAccidentes;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoAccidentes_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoAccidentesDaoInterfase;

@Repository("catalogoAccidentesDao")
public class CatalogoAccidentesDao extends SIICAServerGenericDaoJpaImpl<CatalogoAccidentes> 
	implements CatalogoAccidentesDaoInterfase{

	@Override
	public CatalogoAccidentes objetoCatalogoAccidentes(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoAccidentes.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoAccidentes", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoAccidentes", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoAccidentes", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoAccidentes", id);
		}
		return null;
	}


	
	@Override
	public List<CatalogoAccidentes> listaDeCatalogoAccidentes(final String clave, final String descripcion, final String codigo) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoAccidentes> query = builder.createQuery(CatalogoAccidentes.class);
			final Root<CatalogoAccidentes> root = query.from(CatalogoAccidentes.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.isNotBlank(clave)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoAccidentes_.clave), clave));
			}
			if (StringUtils.isNotBlank(descripcion)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoAccidentes_.descripcion), descripcion));
			}
			if (StringUtils.isNotBlank(codigo)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoAccidentes_.codigo), codigo));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoAccidentes_.clave)));
			final TypedQuery<CatalogoAccidentes> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoAccidentes");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoAccidentes");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoAccidentes");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoAccidentes");
		}
		return new Vector<>();
	}
}
