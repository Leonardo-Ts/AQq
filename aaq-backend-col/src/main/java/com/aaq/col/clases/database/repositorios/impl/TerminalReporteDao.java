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
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalReporte;
import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalReporte_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.TerminalReporteDaoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;

@org.springframework.stereotype.Repository(value = "terminalReporteDao")
public class TerminalReporteDao extends SIICAServerGenericDaoJpaImpl<TerminalReporte> implements
		TerminalReporteDaoInterfase {

	@Override
	public TerminalReporte objetoTerminalReporte(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(TerminalReporte.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminalReporte", id);
		}
		return null;
	}

	@Override
	public List<TerminalReporte> listaDeTerminalReporte(final Terminal terminal, final String ramo, final String anio,
			final String reporte, final String siniestro, final String identificadorUnico, final Date fechaInicial,
			final Date fechaFinal, final Integer limite) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<TerminalReporte> query = builder.createQuery(TerminalReporte.class);
			final Root<TerminalReporte> root = query.from(TerminalReporte.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (terminal != null) {
				predicates.add(builder.equal(root.get(AbstractTerminalReporte_.terminal), terminal));
			}

			if (StringUtils.isNotBlank(ramo)) {
				predicates.add(builder.equal(root.get(AbstractTerminalReporte_.ramo), ramo));
			}
			if (StringUtils.isNotBlank(anio)) {
				predicates.add(builder.equal(root.get(AbstractTerminalReporte_.anio), anio));
			}
			if (StringUtils.isNotBlank(reporte)) {
				predicates.add(builder.equal(root.get(AbstractTerminalReporte_.reporte), reporte));
			}

			if (StringUtils.isNotBlank(siniestro)) {
				predicates.add(builder.equal(root.get(AbstractTerminalReporte_.siniestro), siniestro));
			}

			if (StringUtils.isNotBlank(identificadorUnico)) {
				predicates
						.add(builder.equal(root.get(AbstractTerminalReporte_.identificadorunico), identificadorUnico));
			}

			if ((fechaInicial != null) && (fechaFinal != null)) {
				predicates.add(builder.between(root.get(AbstractTerminalReporte_.fecha), fechaInicial,
						DateUtils.ceiling(fechaFinal, Calendar.DATE)));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractTerminalReporte_.fecha)));
			final TypedQuery<TerminalReporte> typedQ = this.getEntityManager().createQuery(query);

			if (limite != null) {
				typedQ.setMaxResults(limite.intValue());
			} else {
				typedQ.setMaxResults(100);
			}

			return typedQ.getResultList();
		} catch (final Exception e) {

			this.documentarExcepcionParaMetodo(e, "listaDeTerminalReporte", terminal, ramo, anio, reporte, siniestro,
					identificadorUnico, fechaInicial, fechaFinal, limite);
		}
		return new Vector<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JMEntidadObjeto> listaDeTerminalReporteParaGrafica(final String idterminal, final String ramo,
			final String anio, final String reporte, final String siniestro, final String identificadorUnico,
			final Date fechaInicial, final Date fechaFinal) {

		if ((fechaInicial == null) || (fechaFinal == null)) {
			return null;
		}

		try {
			final StringBuilder query = new StringBuilder(
					"SELECT TRUNC(terminal_reporte.fecha,'day') , COUNT(*) FROM terminal_reporte");
			query.append(" WHERE terminal_reporte.fecha BETWEEN ");
			query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
			query.append(" AND ");
			query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");

			if (StringUtils.isNotBlank(idterminal)) {
				query.append(" AND terminal_reporte.idterminal=" + idterminal);
			}

			if (StringUtils.isNotBlank(reporte)) {
				query.append(" AND terminal_reporte.reporte='" + reporte + "'");
			}
			if (StringUtils.isNotBlank(siniestro)) {
				query.append(" AND terminal_reporte.siniestro='" + siniestro + "'");
			}
			if (StringUtils.isNotBlank(anio)) {
				query.append(" AND terminal_reporte.anio='" + anio + "'");
			}

			query.append(" GROUP BY TRUNC(terminal_reporte.fecha,'day') ORDER BY 1");

			return this.procesarResultadoEntidadObjeto(this.getEntityManager().createNativeQuery(query.toString())
					.getResultList());
		} catch (final Exception e) {

			this.documentarExcepcionParaMetodo(e, "listaDeTerminalReporteParaGrafica", idterminal, ramo, anio, reporte,
					siniestro, identificadorUnico, fechaInicial, fechaFinal);
		}
		return null;
	}

}