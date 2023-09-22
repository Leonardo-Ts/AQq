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

import com.aaq.col.clases.database.entidades.CatalogoVehiculoTipo;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoVehiculoTipo_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoVehiculoTipoDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoVehiculoTipoDao")
public class CatalogoVehiculoTipoDao extends SIICAServerGenericDaoJpaImpl<CatalogoVehiculoTipo> implements
		CatalogoVehiculoTipoDaoInterfase {

	@Override
	public CatalogoVehiculoTipo objetoCatalogoVehiculoTipo(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoVehiculoTipo.class,
					new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoVehiculoTipo", id);
		}
		return null;
	}

	@Override
	public CatalogoVehiculoTipo objetoCatalogoVehiculoParaClave(final String clave) {
		if (StringUtils.isBlank(clave)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoVehiculoTipo> query = builder.createQuery(CatalogoVehiculoTipo.class);
			final Root<CatalogoVehiculoTipo> root = query.from(CatalogoVehiculoTipo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoVehiculoTipo_.clave), clave));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoVehiculoTipo_.id)));
			final TypedQuery<CatalogoVehiculoTipo> typedQ = this.getEntityManager().createQuery(query);
			final List<CatalogoVehiculoTipo> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoVehiculoParaClave", clave);
		}
		return null;
	}

	@Override
	public List<CatalogoVehiculoTipo> listaDeCatalogoVehiculoTipo() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoVehiculoTipo> query = builder.createQuery(CatalogoVehiculoTipo.class);
			final Root<CatalogoVehiculoTipo> root = query.from(CatalogoVehiculoTipo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoVehiculoTipo_.descripcion)));
			final TypedQuery<CatalogoVehiculoTipo> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoVehiculoTipo");
		}
		return new Vector<>();
	}

}