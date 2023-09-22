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

import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.aaq.col.clases.database.entidades.abstracto.AbstractPuntoInteresTipo_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.PuntoInteresTipoDaoInterfase;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;

@org.springframework.stereotype.Repository(value = "puntoInteresTipoDao")
public class PuntoInteresTipoDao extends SIICAServerGenericDaoJpaImpl<PuntoInteresTipo> implements
		PuntoInteresTipoDaoInterfase {

	@Override
	public PuntoInteresTipo objetoPuntoInteresTipo(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(PuntoInteresTipo.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoPuntoInteresTipo", id);
		}
		return null;
	}

	@Override
	public PuntoInteresTipo objetoPuntoInteresTipoParaNombre(final String nombre) {
		if (StringUtils.isBlank(nombre)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<PuntoInteresTipo> query = builder.createQuery(PuntoInteresTipo.class);
			final Root<PuntoInteresTipo> root = query.from(PuntoInteresTipo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractPuntoInteresTipo_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractPuntoInteresTipo_.nombre), nombre));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractPuntoInteresTipo_.id)));
			final TypedQuery<PuntoInteresTipo> typedQ = this.getEntityManager().createQuery(query);
			final List<PuntoInteresTipo> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoPuntoInteresTipoParaNombre", nombre);
		}
		return null;

	}

	@Override
	public List<PuntoInteresTipo> listaDePuntoInteresTipo() {
		return this.listaDePuntoInteresTipo(null, null);
	}

	@Override
	public List<PuntoInteresTipo> listaDePuntoInteresTipo(final String idPermitido, final String idNoPermitido) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<PuntoInteresTipo> query = builder.createQuery(PuntoInteresTipo.class);
			final Root<PuntoInteresTipo> root = query.from(PuntoInteresTipo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractPuntoInteresTipo_.habilitado), Boolean.TRUE));

			if (StringUtils.isNotBlank(idPermitido)) {
				predicates.add(root.get(AbstractPuntoInteresTipo_.id).in(
						JMUtileriaString.listaDeInteger(idPermitido, ",")));
			}
			if (StringUtils.isNotBlank(idNoPermitido)) {
				predicates.add(builder.not(root.get(AbstractPuntoInteresTipo_.id).in(
						JMUtileriaString.listaDeInteger(idNoPermitido, ","))));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractPuntoInteresTipo_.nombre)));
			final TypedQuery<PuntoInteresTipo> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDePuntoInteresTipo", idPermitido, idNoPermitido);
		}
		return new Vector<>();
	}
}