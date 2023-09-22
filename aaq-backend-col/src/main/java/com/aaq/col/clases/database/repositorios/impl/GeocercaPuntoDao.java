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

import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.GeocercaPunto;
import com.aaq.col.clases.database.entidades.abstracto.AbstractGeocercaPunto_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.GeocercaPuntoDaoInterfase;

@org.springframework.stereotype.Repository(value = "geocercaPuntoDao")
public class GeocercaPuntoDao extends SIICAServerGenericDaoJpaImpl<GeocercaPunto> implements GeocercaPuntoDaoInterfase {

	@Override
	public GeocercaPunto objetoGeocercaPunto(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(GeocercaPunto.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoGeocercaPunto", id);
		}
		return null;
	}

	@Override
	public List<GeocercaPunto> listaDeGeocercaPunto(final Geocerca geocerca) {
		if (geocerca == null) {
			return new Vector<>();
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<GeocercaPunto> query = builder.createQuery(GeocercaPunto.class);
			final Root<GeocercaPunto> root = query.from(GeocercaPunto.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractGeocercaPunto_.geocerca), geocerca));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractGeocercaPunto_.id)));
			final TypedQuery<GeocercaPunto> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeGeocercaPunto", geocerca);
		}
		return new Vector<>();
	}

}