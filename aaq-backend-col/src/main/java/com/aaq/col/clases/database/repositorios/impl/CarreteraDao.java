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

import com.aaq.col.clases.database.entidades.Carretera;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCarretera_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CarreteraDaoInterfase;

@org.springframework.stereotype.Repository(value = "carreteraDao")
public class CarreteraDao extends SIICAServerGenericDaoJpaImpl<Carretera> implements CarreteraDaoInterfase {

	@Override
	public Carretera objetoCarretera(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Carretera.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCarretera", id);
		}
		return null;
	}

	@Override
	public List<Carretera> listaDeCarretera(final Estado estado, final String nombre) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Carretera> query = builder.createQuery(Carretera.class);
			final Root<Carretera> root = query.from(Carretera.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractCarretera_.estado), estado));

			}
			if (StringUtils.isNotBlank(nombre)) {
				predicates.add(builder.like(root.get(AbstractCarretera_.nombre),
						StringUtils.upperCase("%" + nombre + "%")));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCarretera_.nombre)));
			final TypedQuery<Carretera> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCarretera", estado, nombre);
		}
		return new Vector<>();
	}

}