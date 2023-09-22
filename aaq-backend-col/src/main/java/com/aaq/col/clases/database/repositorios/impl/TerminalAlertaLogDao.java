package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalAlertaLog;
import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalAlertaLog_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.TerminalAlertaLogDaoInterfase;

@org.springframework.stereotype.Repository(value = "terminalAlertaLogDao")
public class TerminalAlertaLogDao extends SIICAServerGenericDaoJpaImpl<TerminalAlertaLog> implements
		TerminalAlertaLogDaoInterfase {

	@Override
	public TerminalAlertaLog objetoTerminalAlertaLog(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(TerminalAlertaLog.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminalAlertaLog", id);
		}
		return null;
	}

	@Override
	public List<TerminalAlertaLog> listaDeTerminalAlertaLog(final Terminal terminal) {
		return this.listaDeTerminalAlertaLog(terminal, null, null);
	}

	@Override
	public List<TerminalAlertaLog> listaDeTerminalAlertaLog(final Terminal terminal, final Date fechaInicial,
			final Date fechaFinal) {

		if ((fechaInicial == null) || (fechaFinal == null)) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<TerminalAlertaLog> query = builder.createQuery(TerminalAlertaLog.class);
			final Root<TerminalAlertaLog> root = query.from(TerminalAlertaLog.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.between(root.get(AbstractTerminalAlertaLog_.fecha), fechaInicial,
					DateUtils.ceiling(fechaFinal, Calendar.DATE)));

			if (terminal != null) {
				predicates.add(builder.equal(root.get(AbstractTerminalAlertaLog_.terminal), terminal));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractTerminalAlertaLog_.id)));
			final TypedQuery<TerminalAlertaLog> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminalAlertaLog", terminal, fechaInicial, fechaFinal);
		}
		return new Vector<>();
	}

}