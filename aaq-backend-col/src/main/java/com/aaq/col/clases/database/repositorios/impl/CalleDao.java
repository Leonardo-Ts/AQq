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

import com.aaq.col.clases.database.entidades.Calle;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCalle_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CalleDaoInterfase;


@org.springframework.stereotype.Repository(value = "calleDao")
public class CalleDao extends SIICAServerGenericDaoJpaImpl<Calle> implements CalleDaoInterfase {

	@Override
	public Calle objetoCalle(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Calle.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCalle", id);
		}
		return null;
	}

	@Override
	public List<Calle> listaDeCalle(final Estado estado, final String municipio, final String colonia,
			final String nombre) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Calle> query = builder.createQuery(Calle.class);
			final Root<Calle> root = query.from(Calle.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractCalle_.estado), estado));
			}
			if (StringUtils.isNotBlank(municipio)) {
				predicates.add(builder.equal(root.get(AbstractCalle_.idmunicipio), municipio));
			}
			if (StringUtils.isNotBlank(colonia)) {
				predicates.add(builder.equal(root.get(AbstractCalle_.idcolonia), colonia));
			}

			if (StringUtils.isNotBlank(nombre)) {
				predicates.add(builder.and(builder.like(root.get(AbstractCalle_.nombre),
						"%" + StringUtils.upperCase(nombre) + "%")));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCalle_.nombre)),
					builder.asc(root.get(AbstractCalle_.nombreMunicipio)),
					builder.asc(root.get(AbstractCalle_.nombreColonia)));
			final TypedQuery<Calle> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCalle", estado, municipio, colonia, nombre);
		}
		return new Vector<>();
	}

}