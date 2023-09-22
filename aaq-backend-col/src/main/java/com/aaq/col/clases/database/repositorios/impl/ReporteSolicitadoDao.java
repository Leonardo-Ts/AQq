package com.aaq.col.clases.database.repositorios.impl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.aaq.col.clases.database.entidades.ReporteSolicitado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteSolicitado_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ReporteSolicitadoDaoInterfase;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@org.springframework.stereotype.Repository(value = "reporteSolicitadoDao")
public class ReporteSolicitadoDao extends SIICAServerGenericDaoJpaImpl<ReporteSolicitado> implements
		ReporteSolicitadoDaoInterfase {

	@Override
	public ReporteSolicitado objetoReporteSolicitado(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(ReporteSolicitado.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteSolicitado", id);
		}
		return null;
	}

	@Override
	public List<ReporteSolicitado> listaDeReporteSolicitado(final String clavePrestador, final String tipoDeServicio,
			final String numeroReporte, final Date fechaInicial, final Date fechaFinal) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteSolicitado> query = builder.createQuery(ReporteSolicitado.class);
			final Root<ReporteSolicitado> root = query.from(ReporteSolicitado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(clavePrestador)) {
				predicates.add(builder.equal(root.get(AbstractReporteSolicitado_.claveProveedor), clavePrestador));
			}

			if (StringUtils.isNotBlank(tipoDeServicio)) {
				if (StringUtils.equalsIgnoreCase(tipoDeServicio, "Ambulancia / Hospital")) {
					predicates.add(root.get(AbstractReporteSolicitado_.tipoDeServicio).in(
							 "Ambulancia", "Hospital" ));

				} else {
					predicates.add(builder.equal(root.get(AbstractReporteSolicitado_.tipoDeServicio), tipoDeServicio));
				}
			}

			if (StringUtils.isNotBlank(numeroReporte)) {
				predicates.add(builder.equal(root.get(AbstractReporteSolicitado_.numeroReporte), numeroReporte));
			}

			if ((fechaInicial != null) && (fechaFinal != null)) {
				predicates.add(builder.between(root.get(AbstractReporteSolicitado_.fechaInsertado), fechaInicial,
						DateUtils.ceiling(fechaFinal, Calendar.DATE)));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractReporteSolicitado_.fechaInsertado)));
			final TypedQuery<ReporteSolicitado> typedQ = this.getEntityManager().createQuery(query);

			if ((fechaFinal == null) || (fechaInicial == null)) {
				typedQ.setMaxResults(1000);
			}

			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReporteSolicitado", clavePrestador, tipoDeServicio,
					numeroReporte, fechaInicial, fechaFinal);
		}
		return new Vector<>();
	}

}