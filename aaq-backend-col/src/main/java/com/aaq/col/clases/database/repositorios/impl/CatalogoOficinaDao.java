package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.CatalogoOficina;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoOficina_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoOficinaDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoOficinaDao")
public class CatalogoOficinaDao extends SIICAServerGenericDaoJpaImpl<CatalogoOficina> implements
		CatalogoOficinaDaoInterfase {

	@Override
	public CatalogoOficina objetoCatalogoOficina(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoOficina.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoOficina", id);
		}
		return null;
	}

	@Override
	public CatalogoOficina objetoCatalogoOficinaParaClave(final String clave) {
		if (StringUtils.isBlank(clave)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoOficina> query = builder.createQuery(CatalogoOficina.class);
			final Root<CatalogoOficina> root = query.from(CatalogoOficina.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoOficina_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractCatalogoOficina_.clave), clave));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoOficina_.id)));
			final TypedQuery<CatalogoOficina> typedQ = this.getEntityManager().createQuery(query);
			final List<CatalogoOficina> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoOficinaParaClave", clave);
		}
		return null;
	}

	@Override
	public List<CatalogoOficina> listaDeCatalogoOficina(final Estado estado) {
		if (estado == null) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoOficina> query = builder.createQuery(CatalogoOficina.class);
			final Root<CatalogoOficina> root = query.from(CatalogoOficina.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoOficina_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractCatalogoOficina_.estado), estado));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoOficina_.descripcion)));
			final TypedQuery<CatalogoOficina> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoOficina", estado);
		}
		return new Vector<>();
	}

}