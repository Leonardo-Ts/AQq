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
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoMarca_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoMarcaDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoMarcaDao")
public class CatalogoMarcaDao extends SIICAServerGenericDaoJpaImpl<CatalogoMarca> implements CatalogoMarcaDaoInterfase {

	@Override
	public CatalogoMarca objetoCatalogoMarca(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoMarca.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMarca", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMarca", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMarca", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoMarca", id);
		}
		return null;
	}

	@Override
	public CatalogoMarca objetoCatalogoMarcaParaClave(final String clave) {
		if (StringUtils.isBlank(clave)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoMarca> query = builder.createQuery(CatalogoMarca.class);
			final Root<CatalogoMarca> root = query.from(CatalogoMarca.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoMarca_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractCatalogoMarca_.clave), clave));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoMarca_.descripcion)));
			final TypedQuery<CatalogoMarca> typedQ = this.getEntityManager().createQuery(query);
			final List<CatalogoMarca> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarca", clave);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarca", clave);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarca", clave);
		} 
		return null;
	}

	@Override
	public List<CatalogoMarca> listaDeCatalogoMarca() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoMarca> query = builder.createQuery(CatalogoMarca.class);
			final Root<CatalogoMarca> root = query.from(CatalogoMarca.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoMarca_.habilitado), Boolean.TRUE));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoMarca_.descripcion)));
			final TypedQuery<CatalogoMarca> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarca");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarca");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarca");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarca");
		}
		return new Vector<>();
	}
	
	@Override
	public List<CatalogoMarca> listaDeCatalogoMarca(final String clave, final String nombre) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoMarca> query = builder.createQuery(CatalogoMarca.class);
			final Root<CatalogoMarca> root = query.from(CatalogoMarca.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoMarca_.habilitado), Boolean.TRUE));
			if (StringUtils.isNotBlank(clave)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoMarca_.clave), clave));
			}
			if (StringUtils.isNotBlank(nombre)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoMarca_.nombreMarca), nombre));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoMarca_.descripcion)));
			final TypedQuery<CatalogoMarca> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarca");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarca");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarca");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoMarca");
		}
		return new Vector<>();
	}

}