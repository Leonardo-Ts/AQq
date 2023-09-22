package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Session;
import com.aaq.col.clases.database.entidades.abstracto.AbstractSession_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.SessionDaoInterfase;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@org.springframework.stereotype.Repository(value = "sessionDao")
public class SessionDao extends SIICAServerGenericDaoJpaImpl<Session> implements SessionDaoInterfase {

	@Override
	public Session objetoSession(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Session.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoSession", id);
		}
		return null;
	}

	@Override
	public Session objetoSessionParaIdentificador(final String id) {
		if (StringUtils.isBlank(id)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Session> query = builder.createQuery(Session.class);
			final Root<Session> root = query.from(Session.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractSession_.identificadorDeSession), id));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractSession_.id)));
			final TypedQuery<Session> typedQ = this.getEntityManager().createQuery(query);
			final List<Session> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoSessionParaIdentificador", id);
		}
		return null;
	}

	@Override
	public List<Session> listaDeSession() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Session> query = builder.createQuery(Session.class);
			final Root<Session> root = query.from(Session.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.isNotNull(root.get(AbstractSession_.usuario)));
			predicates.add(builder.greaterThan(root.get(AbstractSession_.fechaUltimoMovimiento),
					new Date(System.currentTimeMillis() - JMUtileriaFecha.TIEMPO_01_HORA)));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractSession_.fechaUltimoMovimiento)));
			final TypedQuery<Session> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeSession");
		}
		return new Vector<>();
	}
}