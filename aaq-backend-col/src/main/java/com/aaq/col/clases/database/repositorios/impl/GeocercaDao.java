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

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.abstracto.AbstractGeocerca_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.GeocercaDaoInterfase;

@org.springframework.stereotype.Repository(value = "geocercaDao")
public class GeocercaDao extends SIICAServerGenericDaoJpaImpl<Geocerca> implements GeocercaDaoInterfase {

	@Override
	public Geocerca objetoGeocerca(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Geocerca.class, new Integer(id)) : null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoGeocerca", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoGeocerca", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoGeocerca", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoGeocerca", id);
		}
		return null;
	}

	@Override
	public List<Geocerca> listaDeGeocerca(final Estado estado) {
		if (estado == null) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Geocerca> query = builder.createQuery(Geocerca.class);
			final Root<Geocerca> root = query.from(Geocerca.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractGeocerca_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractGeocerca_.estado), estado));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractGeocerca_.id)));
			final TypedQuery<Geocerca> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeGeocerca", estado);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeGeocerca", estado);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeGeocerca", estado);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeGeocerca", estado);
		}
		return new Vector<>();
	}

}