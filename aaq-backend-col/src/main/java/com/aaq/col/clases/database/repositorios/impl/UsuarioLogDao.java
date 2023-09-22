package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.aaq.col.clases.database.entidades.UsuarioLog;
import com.aaq.col.clases.database.entidades.abstracto.AbstractUsuarioLog_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.UsuarioLogDaoInterfase;

@org.springframework.stereotype.Repository(value = "usuarioLogDao")
public class UsuarioLogDao extends SIICAServerGenericDaoJpaImpl<UsuarioLog> implements UsuarioLogDaoInterfase {

	@Override
	public UsuarioLog objetoUsuarioLog(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(UsuarioLog.class, new Integer(id)) : null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioLog", id);
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioLog", id);
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioLog", id);
		}  
		return null;
	}

	@Override
	public List<UsuarioLog> listaDeUsuarioLog(final Date fechaInicial, final Date fechaFinal, final boolean validez,
			final Integer limite) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<UsuarioLog> query = builder.createQuery(UsuarioLog.class);
			final Root<UsuarioLog> root = query.from(UsuarioLog.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.between(root.get(AbstractUsuarioLog_.fecha), fechaInicial,
					DateUtils.ceiling(fechaFinal, Calendar.DATE)));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractUsuarioLog_.id)));
			final TypedQuery<UsuarioLog> typedQ = this.getEntityManager().createQuery(query);

			if (limite != null) {
				typedQ.setMaxResults(limite.intValue());
			}
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeUsuarioLog");
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeUsuarioLog");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeUsuarioLog");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeUsuarioLog");
		}
		return new Vector<>();
	}
}