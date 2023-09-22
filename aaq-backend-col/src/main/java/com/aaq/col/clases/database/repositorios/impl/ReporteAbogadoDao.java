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

import com.aaq.col.clases.database.entidades.ReporteAbogado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteAbogado_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ReporteAbogadoDaoInterfase;

@org.springframework.stereotype.Repository(value = "reporteAbogadoDao")
public class ReporteAbogadoDao extends SIICAServerGenericDaoJpaImpl<ReporteAbogado> implements
		ReporteAbogadoDaoInterfase {

	@Override
	public ReporteAbogado objetoReporteAbogado(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(ReporteAbogado.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteAbogado", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteAbogado", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteAbogado", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteAbogado", id);
		}
		return null;
	}

	@Override
	public ReporteAbogado objetoReporteAbogadoParaNumeroReporte(final String reporte) {
		return this.objetoReporteAbogadoParaNumeroReporteYReporteLegal(reporte, null);
	}

	@Override
	public ReporteAbogado objetoReporteAbogadoParaNumeroReporteYReporteLegal(final String reporteSISE,
			final String reporteLegal) {

		if (StringUtils.isBlank(reporteLegal) && StringUtils.isBlank(reporteSISE)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteAbogado> query = builder.createQuery(ReporteAbogado.class);
			final Root<ReporteAbogado> root = query.from(ReporteAbogado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(reporteSISE)) {
				predicates.add(builder.equal(root.get(AbstractReporteAbogado_.numeroReporteSise), reporteSISE));
			}
			if (StringUtils.isNotBlank(reporteLegal)) {
				predicates.add(builder.equal(root.get(AbstractReporteAbogado_.numeroReporteLegal), reporteLegal));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractReporteAbogado_.id)));
			final TypedQuery<ReporteAbogado> typedQ = this.getEntityManager().createQuery(query);
			final List<ReporteAbogado> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteAbogadoParaNumeroReporteYReporteLegal", reporteSISE,
					reporteLegal);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteAbogadoParaNumeroReporteYReporteLegal", reporteSISE,
					reporteLegal);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteAbogadoParaNumeroReporteYReporteLegal", reporteSISE,
					reporteLegal);
		} 
		return null;
	}

	@Override
	public List<ReporteAbogado> listaDeReporteAbogado(final Integer limite) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteAbogado> query = builder.createQuery(ReporteAbogado.class);
			final Root<ReporteAbogado> root = query.from(ReporteAbogado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractReporteAbogado_.id)));
			final TypedQuery<ReporteAbogado> typedQ = this.getEntityManager().createQuery(query);
			typedQ.setMaxResults(limite != null ? limite.intValue() : 100);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteAbogado", limite);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteAbogado", limite);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteAbogado", limite);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteAbogado", limite);
		}
		return new Vector<>();
	}
}