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

import com.aaq.col.clases.database.entidades.Geocerca;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalAlerta;
import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalAlerta_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.TerminalAlertaDaoInterfase;

@org.springframework.stereotype.Repository(value = "terminalAlertaDao")
public class TerminalAlertaDao extends SIICAServerGenericDaoJpaImpl<TerminalAlerta> implements
		TerminalAlertaDaoInterfase {

	@Override
	public TerminalAlerta objetoTerminalAlerta(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(TerminalAlerta.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminalAlerta", id);
		}
		return null;
	}

	@Override
	public List<TerminalAlerta> listaDeTerminalAlerta(final Terminal terminal) {
		return this.listaDeTerminalAlerta(terminal, null, null);
	}

	@Override
	public List<TerminalAlerta> listaDeTerminalAlerta(final Terminal terminal, final PuntoInteres puntoInteres,
			final Geocerca geocerca) {

		if (terminal == null) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<TerminalAlerta> query = builder.createQuery(TerminalAlerta.class);
			final Root<TerminalAlerta> root = query.from(TerminalAlerta.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractTerminalAlerta_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractTerminalAlerta_.terminal), terminal));

			if (puntoInteres != null) {
				predicates.add(builder.equal(root.get(AbstractTerminalAlerta_.puntoInteres), puntoInteres));
			}

			if (geocerca != null) {
				predicates.add(builder.or(
						builder.equal(root.get(AbstractTerminalAlerta_.geocercaByPorIdGeocercaEntra), geocerca),
						builder.equal(root.get(AbstractTerminalAlerta_.geocercaByPorIdGeocercaEntra), geocerca)));

			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractTerminalAlerta_.id)));
			final TypedQuery<TerminalAlerta> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminalAlerta", terminal, puntoInteres, geocerca);
		}
		return new Vector<>();
	}
}