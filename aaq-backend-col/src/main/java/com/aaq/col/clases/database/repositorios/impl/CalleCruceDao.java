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
import org.apache.commons.lang3.math.NumberUtils;

import com.aaq.col.clases.database.entidades.CalleCruce;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCalleCruce_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CalleCruceDaoInterfase;


@org.springframework.stereotype.Repository(value = "calleCruceDao")
public class CalleCruceDao extends SIICAServerGenericDaoJpaImpl<CalleCruce> implements CalleCruceDaoInterfase {

	@Override
	public CalleCruce objetoCalleCruce(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CalleCruce.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCalleCruce", id);
		}
		return null;
	}

	@Override
	public List<CalleCruce> listaDeCalleCruce(final Estado estado, final String municipio, final String colonia,
			final String nombrecalleuno, final String nombrecalledos) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CalleCruce> query = builder.createQuery(CalleCruce.class);
			final Root<CalleCruce> root = query.from(CalleCruce.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractCalleCruce_.estado), estado));
			}

			if (StringUtils.isNotBlank(municipio)) {
				predicates.add(builder.or(
						builder.equal(root.get(AbstractCalleCruce_.idmunicipioUno),
								new Integer(NumberUtils.toInt(municipio))),
						builder.equal(root.get(AbstractCalleCruce_.idmunicipioDos),
								new Integer(NumberUtils.toInt(municipio)))));
			}

			if (StringUtils.isNotBlank(colonia)) {
				predicates.add(builder.or(
						builder.equal(root.get(AbstractCalleCruce_.idcoloniaUno),
								new Integer(NumberUtils.toInt(colonia))),
						builder.equal(root.get(AbstractCalleCruce_.idcoloniaDos),
								new Integer(NumberUtils.toInt(colonia)))));
			}
			if (StringUtils.isNotBlank(nombrecalleuno) && StringUtils.isNotBlank(nombrecalledos)) {

				predicates.add(builder.and(builder.like(root.get(AbstractCalleCruce_.nombreCalleUno),
						StringUtils.upperCase("%" + nombrecalleuno + "%"))));
				predicates.add(builder.and(builder.like(root.get(AbstractCalleCruce_.nombreCalleDos),
						StringUtils.upperCase("%" + nombrecalledos + "%"))));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCalleCruce_.nombreCalleUno)),
					builder.asc(root.get(AbstractCalleCruce_.nombreCalleDos)),
					builder.asc(root.get(AbstractCalleCruce_.nombreMunicipioUno)),
					builder.asc(root.get(AbstractCalleCruce_.nombreMunicipioDos)));
			final TypedQuery<CalleCruce> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCalleCruce", estado, municipio, colonia, nombrecalleuno,
					nombrecalledos);
		}
		return new Vector<>();
	}
}