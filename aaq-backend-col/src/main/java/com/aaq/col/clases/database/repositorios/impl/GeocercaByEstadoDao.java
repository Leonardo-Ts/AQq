package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.GeocercaByEstado;
import com.aaq.col.clases.database.entidades.GeocercaByEstado_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.GeocercaByEstadoDaoInterfase;

@org.springframework.stereotype.Repository(value = "geocercaByEstadoDao")
public class GeocercaByEstadoDao extends SIICAServerGenericDaoJpaImpl<GeocercaByEstado> implements GeocercaByEstadoDaoInterfase {

	@Override
	public GeocercaByEstado objetoGeocercaByEstado(String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(GeocercaByEstado.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoGeocercaByEstado", id);
		}
		return null;
	}

	@Override
	public List<GeocercaByEstado> listaDeGeocercaByEstado(String id) {
		if (id == null) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<GeocercaByEstado> query = builder.createQuery(GeocercaByEstado.class);
			final Root<GeocercaByEstado> root = query.from(GeocercaByEstado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(GeocercaByEstado_.identidad), id));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(GeocercaByEstado_.id)));
			final TypedQuery<GeocercaByEstado> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeGeocercaByEstado", id);
		}
		return new Vector<>();
	}

}