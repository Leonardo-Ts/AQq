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
import com.aaq.col.clases.database.entidades.Referencia;
import com.aaq.col.clases.database.entidades.abstracto.AbstractReferencia_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ReferenciaDaoInterfase;

@org.springframework.stereotype.Repository(value = "referenciaDao")
public class ReferenciaDao extends SIICAServerGenericDaoJpaImpl<Referencia> implements ReferenciaDaoInterfase {

	@Override
	public Referencia objetoReferencia(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Referencia.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoReferencia", id);
		}
		return null;
	}

	@Override
	public List<Referencia> listaDeReferencia(final Estado estado, final String nombre) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Referencia> query = builder.createQuery(Referencia.class);
			final Root<Referencia> root = query.from(Referencia.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractReferencia_.estado), estado));
			}
			if (StringUtils.isNotBlank(nombre)) {
				predicates.add(builder.like(builder.upper(root.get(AbstractReferencia_.nombre)),
						StringUtils.upperCase("%" + nombre + "%")));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractReferencia_.nombre)));
			final TypedQuery<Referencia> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReferencia");
		}
		return new Vector<>();
	}
}