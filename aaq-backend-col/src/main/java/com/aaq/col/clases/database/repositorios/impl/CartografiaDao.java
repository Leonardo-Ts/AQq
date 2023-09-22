package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Cartografia;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCartografia_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CartografiaDaoInterfase;


@org.springframework.stereotype.Repository(value = "cartografiaDao")
public class CartografiaDao extends SIICAServerGenericDaoJpaImpl<Cartografia> implements CartografiaDaoInterfase {

	@Override
	public Cartografia objetoCartografia(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Cartografia.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCartografia", id);
		}
		return null;
	}

	@Override
	public Cartografia objetoCartografia(final Estado estado, final Integer tipo) {
		if (estado == null) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Cartografia> query = builder.createQuery(Cartografia.class);
			final Root<Cartografia> root = query.from(Cartografia.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractCartografia_.estado), estado));
			if (tipo != null) {
				predicates.add(builder.equal(root.get(AbstractCartografia_.tipo), tipo));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCartografia_.id)));
			final TypedQuery<Cartografia> typedQ = this.getEntityManager().createQuery(query);
			final List<Cartografia> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCartografia", estado, tipo);
		}
		return null;
	}

}