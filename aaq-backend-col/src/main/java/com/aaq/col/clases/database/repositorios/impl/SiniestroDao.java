package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Siniestro;
import com.aaq.col.clases.database.entidades.abstracto.AbstractSiniestro_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.SiniestroDaoInterfase;

@org.springframework.stereotype.Repository(value = "siniestroDao")
public class SiniestroDao extends SIICAServerGenericDaoJpaImpl<Siniestro> implements SiniestroDaoInterfase {

	@Override
	public Siniestro objetoSiniestro(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Siniestro.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoSiniestro", id);
		}
		return null;
	}

	@Override
	public Siniestro objetoSiniestro(final String numeroReporte, final String identificadorUnico) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Siniestro> query = builder.createQuery(Siniestro.class);
			final Root<Siniestro> root = query.from(Siniestro.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(identificadorUnico)
					&& !StringUtils.containsIgnoreCase(identificadorUnico, "null")) {

				predicates.add(builder.or(
						builder.equal(root.get(AbstractSiniestro_.numeroReporte), identificadorUnico),
						builder.equal(root.get(AbstractSiniestro_.identificadorUnico), identificadorUnico)

				));

				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.asc(root.get(AbstractSiniestro_.id)));

				try {
					final TypedQuery<Siniestro> typedQ = this.getEntityManager().createQuery(query);
					final List<Siniestro> l = typedQ.getResultList();

					if ((l != null) && (l.size() > 0)) {
						return l.get(0);
					}
				} catch (final Exception ex) {
					// nada
				}
			}

			if (StringUtils.isNotBlank(numeroReporte) && !StringUtils.containsIgnoreCase(numeroReporte, "null")) {

				predicates.add(builder.or(builder.equal(root.get(AbstractSiniestro_.numeroReporte), numeroReporte),
						builder.equal(root.get(AbstractSiniestro_.identificadorUnico), numeroReporte)

				));

				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.asc(root.get(AbstractSiniestro_.id)));

				try {
					final TypedQuery<Siniestro> typedQ = this.getEntityManager().createQuery(query);
					final List<Siniestro> l = typedQ.getResultList();

					if ((l != null) && (l.size() > 0)) {
						return l.get(0);
					}
				} catch (final Exception ex) {
					// nada
				}
			}

			if (StringUtils.isNotBlank(numeroReporte) && StringUtils.isNotBlank(identificadorUnico)) {

				predicates.add(builder.or(builder.equal(root.get(AbstractSiniestro_.numeroReporte), numeroReporte),
						builder.equal(root.get(AbstractSiniestro_.identificadorUnico), identificadorUnico)

				));

				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.asc(root.get(AbstractSiniestro_.id)));

				try {
					final TypedQuery<Siniestro> typedQ = this.getEntityManager().createQuery(query);
					final List<Siniestro> l = typedQ.getResultList();

					if ((l != null) && (l.size() > 0)) {
						return l.get(0);
					}

				} catch (final Exception ex) {
					// nada
				}

			}

			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoSiniestro");
		}
		return null;
	}
}