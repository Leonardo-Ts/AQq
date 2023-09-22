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

import com.aaq.col.clases.database.entidades.CatalogoVehiculoUso;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoVehiculoUso_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoVehiculoUsoDaoInterfase;


@org.springframework.stereotype.Repository(value = "catalogoVehiculoUsoDao")
public class CatalogoVehiculoUsoDao extends SIICAServerGenericDaoJpaImpl<CatalogoVehiculoUso> implements
		CatalogoVehiculoUsoDaoInterfase {

	@Override
	public CatalogoVehiculoUso objetoCatalogoVehiculoUso(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager()
					.find(CatalogoVehiculoUso.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoVehiculoUso", id);
		}
		return null;
	}

	@Override
	public CatalogoVehiculoUso objetoCatalogoVehiculoUsoParaClave(final String clave) {
		if (StringUtils.isBlank(clave)) {
			return null;
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoVehiculoUso> query = builder.createQuery(CatalogoVehiculoUso.class);
			final Root<CatalogoVehiculoUso> root = query.from(CatalogoVehiculoUso.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoVehiculoUso_.clave), clave));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoVehiculoUso_.id)));
			final TypedQuery<CatalogoVehiculoUso> typedQ = this.getEntityManager().createQuery(query);
			final List<CatalogoVehiculoUso> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoVehiculoUsoParaClave", clave);
		}
		return null;
	}

	@Override
	public List<CatalogoVehiculoUso> listaDeCatalogoVehiculoUso() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoVehiculoUso> query = builder.createQuery(CatalogoVehiculoUso.class);
			final Root<CatalogoVehiculoUso> root = query.from(CatalogoVehiculoUso.class);
			query.select(root);
			query.orderBy(builder.asc(root.get(AbstractCatalogoVehiculoUso_.descripcion)));
			final TypedQuery<CatalogoVehiculoUso> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoVehiculoUso");
		}
		return new Vector<>();
	}

}