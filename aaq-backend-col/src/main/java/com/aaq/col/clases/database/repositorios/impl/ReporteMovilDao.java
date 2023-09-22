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

import com.aaq.col.clases.database.entidades.ReporteMovil;
import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteMovil_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ReporteMovilDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;

@org.springframework.stereotype.Repository(value = "reporteMovilDao")
public class ReporteMovilDao extends SIICAServerGenericDaoJpaImpl<ReporteMovil> implements ReporteMovilDaoInterfase {


	@Override
	public ReporteMovil objetoReporteMovil(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(ReporteMovil.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteMovil", id);
		}
		return null;
	}

	@Override
	public List<ReporteMovil> listaDeReporteMovil(final Date fechaInicio, final Date fechaFin, final boolean soloActivos) {
		Date dateInicio = null;
		Date dateFin = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteMovil> query = builder.createQuery(ReporteMovil.class);
			final Root<ReporteMovil> root = query.from(ReporteMovil.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if ((fechaInicio != null) && (fechaFin != null)) {
				HoraConsultaUtil utileria = new HoraConsultaUtil();
				try {
					dateInicio = utileria.formatInicial(fechaInicio);
					dateFin = utileria.formatFinal(fechaFin);
				} catch (Exception e) {
					this.documentarExcepcionParaMetodo(e, "listaDeEncuestaAjustador");
				}
				
				predicates.add(builder.between(root.get(AbstractReporteMovil_.fecha), dateInicio,
						DateUtils.ceiling(dateFin, Calendar.DATE)));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractReporteMovil_.fecha)));
			final TypedQuery<ReporteMovil> typedQ = this.getEntityManager().createQuery(query);
			typedQ.setMaxResults(1000);
			return typedQ.getResultList();
		} catch (final Exception e) {

			this.documentarExcepcionParaMetodo(e, "listaDeReporteMovil", fechaInicio, fechaFin,
					new Boolean(soloActivos));
		}
		return new Vector<>();
	}
}