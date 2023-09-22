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

import com.aaq.col.clases.database.entidades.TerminalReporteDocumentoTipo;
import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalReporteDocumentoTipo_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.TerminalReporteDocumentoTipoDaoInterfase;

@org.springframework.stereotype.Repository(value = "terminalReporteDocumentoTipoDao")
public class TerminalReporteDocumentoTipoDao extends SIICAServerGenericDaoJpaImpl<TerminalReporteDocumentoTipo>
		implements TerminalReporteDocumentoTipoDaoInterfase {

	@Override
	public TerminalReporteDocumentoTipo objetoTerminalReporteDocumentoTipo(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(TerminalReporteDocumentoTipo.class,
					new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminalReporteDocumentoTipo", id);
		}
		return null;
	}

	@Override
	public List<TerminalReporteDocumentoTipo> listaDeTerminalReporteDocumentoTipo() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<TerminalReporteDocumentoTipo> query = builder
					.createQuery(TerminalReporteDocumentoTipo.class);
			final Root<TerminalReporteDocumentoTipo> root = query.from(TerminalReporteDocumentoTipo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractTerminalReporteDocumentoTipo_.habilitado), Boolean.TRUE));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractTerminalReporteDocumentoTipo_.clave)));
			final TypedQuery<TerminalReporteDocumentoTipo> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminalReporteDocumentoTipo");
		}
		return new Vector<>();
	}

}