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

import com.aaq.col.clases.database.entidades.CatalogoCodigoDeCausa;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoCodigoDeCausa_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoCodigoDeCausaDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoCodigoDeCausaDao")
public class CatalogoCodigoDeCausaDao extends SIICAServerGenericDaoJpaImpl<CatalogoCodigoDeCausa> implements
		CatalogoCodigoDeCausaDaoInterfase {

	@Override
	public CatalogoCodigoDeCausa objetoCatalogoCodigoDeCausa(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoCodigoDeCausa.class,
					new Integer(id)) : null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCodigoDeCausa", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCodigoDeCausa", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCodigoDeCausa", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCodigoDeCausa", id);
		}
		return null;
	}

	@Override
	public CatalogoCodigoDeCausa objetoCatalogoCodigoDeCausaParaClave(final String clave) {
		if (StringUtils.isBlank(clave)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoCodigoDeCausa> query = builder.createQuery(CatalogoCodigoDeCausa.class);
			final Root<CatalogoCodigoDeCausa> root = query.from(CatalogoCodigoDeCausa.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoCodigoDeCausa_.habilitado), Boolean.TRUE));

			predicates.add(builder.equal(root.get(AbstractCatalogoCodigoDeCausa_.clave), clave));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoCodigoDeCausa_.id)));
			final TypedQuery<CatalogoCodigoDeCausa> typedQ = this.getEntityManager().createQuery(query);
			final List<CatalogoCodigoDeCausa> l = typedQ.getResultList();
			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoDeCausa", clave);
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoDeCausa", clave);
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoDeCausa", clave);
		}
		return null;
	}

	@Override
	public List<CatalogoCodigoDeCausa> listaDeCatalogoCodigoDeCausa() {
		return this.listaDeCatalogoCodigoDeCausa(null);
	}

	@Override
	public List<CatalogoCodigoDeCausa> listaDeCatalogoCodigoDeCausa(final Integer idPermitido) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoCodigoDeCausa> query = builder.createQuery(CatalogoCodigoDeCausa.class);
			final Root<CatalogoCodigoDeCausa> root = query.from(CatalogoCodigoDeCausa.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoCodigoDeCausa_.habilitado), Boolean.TRUE));

			if (idPermitido != null) {
				predicates.add(builder.equal(root.get(AbstractCatalogoCodigoDeCausa_.id), idPermitido));

			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoCodigoDeCausa_.descripcion)));
			final TypedQuery<CatalogoCodigoDeCausa> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoDeCausa", idPermitido);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoDeCausa", idPermitido);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoDeCausa", idPermitido);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoDeCausa", idPermitido);
		}
		return new Vector<>();
	}

}