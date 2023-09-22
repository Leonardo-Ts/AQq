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
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.aaq.col.clases.database.entidades.abstracto.AbstractPuntoInteres_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.PuntoInteresDaoInterfase;

@org.springframework.stereotype.Repository(value = "puntoInteresDao")
public class PuntoInteresDao extends SIICAServerGenericDaoJpaImpl<PuntoInteres> implements PuntoInteresDaoInterfase {

	@Override
	public PuntoInteres objetoPuntoInteres(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(PuntoInteres.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoPuntoInteres", id);
		}
		return null;
	}

	@Override
	public List<PuntoInteres> listaDePuntoInteres(final Estado estado, final List<PuntoInteresTipo> tipo) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<PuntoInteres> query = builder.createQuery(PuntoInteres.class);
			final Root<PuntoInteres> root = query.from(PuntoInteres.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractPuntoInteres_.habilitado), Boolean.TRUE));

			predicates.add(builder.isNotNull(root.get(AbstractPuntoInteres_.latitud)));
			predicates.add(builder.isNotNull(root.get(AbstractPuntoInteres_.longitud)));
			predicates.add(builder.isNotNull(root.get(AbstractPuntoInteres_.nombre)));

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractPuntoInteres_.estado), estado));

			}
			if ((tipo != null) && (tipo.size() > 0)) {
				predicates.add(root.get(AbstractPuntoInteres_.puntoInteresTipo).in(tipo));

			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractPuntoInteres_.nombre)));
			final TypedQuery<PuntoInteres> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDePuntoInteres", estado, tipo);
		}
		return new Vector<>();
	}
}