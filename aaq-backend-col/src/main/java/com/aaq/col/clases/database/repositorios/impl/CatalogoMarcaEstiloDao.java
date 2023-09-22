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

import com.aaq.col.clases.database.entidades.CatalogoMarca;
import com.aaq.col.clases.database.entidades.CatalogoMarcaEstilo;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoMarcaEstilo_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoMarcaEstiloDaoInterfase;


@org.springframework.stereotype.Repository(value = "catalogoMarcaEstiloDao")
public class CatalogoMarcaEstiloDao extends SIICAServerGenericDaoJpaImpl<CatalogoMarcaEstilo> implements
		CatalogoMarcaEstiloDaoInterfase {

	@Override
	public CatalogoMarcaEstilo objetoCatalogoMarcaEstilo(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager()
					.find(CatalogoMarcaEstilo.class, new Integer(id)) : null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMarcaEstilo", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMarcaEstilo", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMarcaEstilo", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMarcaEstilo", id);
		}
		return null;
	}

	@Override
	public CatalogoMarcaEstilo objetoCatalogoMarcaEstiloParaClave(final CatalogoMarca catalogoMarca, final String clave) {
		if (StringUtils.isBlank(clave) && (catalogoMarca == null)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoMarcaEstilo> query = builder.createQuery(CatalogoMarcaEstilo.class);
			final Root<CatalogoMarcaEstilo> root = query.from(CatalogoMarcaEstilo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractCatalogoMarcaEstilo_.catalogoMarca), catalogoMarca));
			predicates.add(builder.equal(root.get(AbstractCatalogoMarcaEstilo_.clave), clave));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoMarcaEstilo_.descripcion)));
			final TypedQuery<CatalogoMarcaEstilo> typedQ = this.getEntityManager().createQuery(query);
			final List<CatalogoMarcaEstilo> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMarcaEstiloParaClave", catalogoMarca, clave);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMarcaEstiloParaClave", catalogoMarca, clave);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMarcaEstiloParaClave", catalogoMarca, clave);
		}
		return null;
	}

	@Override
	public List<CatalogoMarcaEstilo> listaDeCatalogoMarcaEstilo(final CatalogoMarca catalogoMarca) {
		if ((catalogoMarca == null)) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoMarcaEstilo> query = builder.createQuery(CatalogoMarcaEstilo.class);
			final Root<CatalogoMarcaEstilo> root = query.from(CatalogoMarcaEstilo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoMarcaEstilo_.catalogoMarca), catalogoMarca));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoMarcaEstilo_.descripcion)));
			final TypedQuery<CatalogoMarcaEstilo> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarcaEstilo", catalogoMarca);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarcaEstilo", catalogoMarca);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarcaEstilo", catalogoMarca);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarcaEstilo", catalogoMarca);
		}
		return new Vector<>();
	}

}