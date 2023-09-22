package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.CalleDireccion;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCalleDireccion_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CalleDireccionDaoInterfase;


@org.springframework.stereotype.Repository(value = "calleDireccionDao")
public class CalleDireccionDao extends SIICAServerGenericDaoJpaImpl<CalleDireccion> implements
		CalleDireccionDaoInterfase {

	@Override
	public CalleDireccion objetoCalleDireccion(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CalleDireccion.class, new Integer(id))
					: null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCalleDireccion", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCalleDireccion", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCalleDireccion", id);
		}
		return null;
	}

	@Override
	public CalleDireccion objetoCalleDireccionParaCoordenadas(final String latitud, final String longitud) {
		if (StringUtils.isBlank(latitud) || StringUtils.isBlank(longitud)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CalleDireccion> query = builder.createQuery(CalleDireccion.class);
			final Root<CalleDireccion> root = query.from(CalleDireccion.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCalleDireccion_.latitud), latitud));
			predicates.add(builder.equal(root.get(AbstractCalleDireccion_.longitud), longitud));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCalleDireccion_.id)));
			final TypedQuery<CalleDireccion> typedQ = this.getEntityManager().createQuery(query);

			final List<CalleDireccion> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCalleDireccionParaCoordenadas", latitud, longitud);
			return null;
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCalleDireccionParaCoordenadas", latitud, longitud);
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCalleDireccionParaCoordenadas", latitud, longitud);
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCalleDireccionParaCoordenadas", latitud, longitud);
		}
		return null;
	}

}