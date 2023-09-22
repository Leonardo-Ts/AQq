package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
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

import com.aaq.col.clases.database.entidades.TerminalReporte;
import com.aaq.col.clases.database.entidades.TerminalReporteDocumento;
import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalReporteDocumento_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.TerminalReporteDocumentoDaoInterfase;

@org.springframework.stereotype.Repository(value = "terminalReporteDocumentoDao")
public class TerminalReporteDocumentoDao extends SIICAServerGenericDaoJpaImpl<TerminalReporteDocumento> implements
		TerminalReporteDocumentoDaoInterfase {

	@Override
	public TerminalReporteDocumento objetoTerminalReporteDocumento(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(TerminalReporteDocumento.class,
					new Integer(id)) : null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminalReporteDocumento", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminalReporteDocumento", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminalReporteDocumento", id);
		}
		return null;
	}

	@Override
	public List<TerminalReporteDocumento> listaDeTerminalReporteDocumento(final TerminalReporte reporte) {

		if (reporte == null) {
			return new Vector<>();
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<TerminalReporteDocumento> query = builder.createQuery(TerminalReporteDocumento.class);
			final Root<TerminalReporteDocumento> root = query.from(TerminalReporteDocumento.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractTerminalReporteDocumento_.terminalReporte), reporte));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractTerminalReporteDocumento_.valor)));
			final TypedQuery<TerminalReporteDocumento> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminalReporteDocumento", reporte);
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminalReporteDocumento", reporte);
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminalReporteDocumento", reporte);
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminalReporteDocumento", reporte);
		}
		return new Vector<>();
	}

}