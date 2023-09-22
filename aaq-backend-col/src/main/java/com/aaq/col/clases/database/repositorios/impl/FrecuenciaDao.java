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

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFrecuencia_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FrecuenciaDaoInterfase;

@org.springframework.stereotype.Repository(value = "frecuenciaDao")
public class FrecuenciaDao extends SIICAServerGenericDaoJpaImpl<Frecuencia> implements FrecuenciaDaoInterfase {

	@Override
	public Frecuencia objetoFrecuencia(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Frecuencia.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoFrecuencia", id);
		}
		return null;
	}

	@Override
	public List<Frecuencia> listaDeFrecuencia(final Estado estado) {
		if (estado == null) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Frecuencia> query = builder.createQuery(Frecuencia.class);
			final Root<Frecuencia> root = query.from(Frecuencia.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractFrecuencia_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractFrecuencia_.estado), estado));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractFrecuencia_.nombre)));
			final TypedQuery<Frecuencia> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFrecuencia", estado);
		}
		return new Vector<>();
	}

}