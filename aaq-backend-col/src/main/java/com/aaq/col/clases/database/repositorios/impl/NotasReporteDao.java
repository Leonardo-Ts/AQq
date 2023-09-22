package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.NotasReporte;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.abstracto.AbstractNotasReporte_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.NotasReporteDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;

@org.springframework.stereotype.Repository(value = "notasReporteDao")
public class NotasReporteDao extends SIICAServerGenericDaoJpaImpl<NotasReporte> implements NotasReporteDaoInterfase{

	@Override
	public NotasReporte objetoNotasReporte(String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(NotasReporte.class, new Integer(id)): null;
		} catch (final ClassCastException | IndexOutOfBoundsException  | RollbackException e) {
			this.documentarExcepcionParaMetodo(e, "objetoNotasReporte", id);
		} catch (final PersistenceException | DataAccessException e) {
			this.documentarExcepcionParaMetodo(e, "objetoNotasReporte", id);
		}
		return null;
	}

	@Override
	public List<NotasReporte> listaDeNotasReportes(Date fechaInicio, Date fechaFin, String reporte, Terminal terminal,
			Estado estado, Base base) {

			try {
				final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
				final CriteriaQuery<NotasReporte> query = builder.createQuery(NotasReporte.class);
				final Root<NotasReporte> root = query.from(NotasReporte.class);
				query.select(root);
				final List<Predicate> predicates = new ArrayList<>();
				
				Date dateInicio = null;
				Date dateFin = null;
				try {
					HoraConsultaUtil utileria = new HoraConsultaUtil();
					try {
						dateInicio = utileria.formatInicial(fechaInicio);
						dateFin = utileria.formatFinal(fechaFin);
					} catch (ClassCastException | IndexOutOfBoundsException  e) {
						this.documentarExcepcionParaMetodo(e, "listaDeNotasReportes");
					}
				predicates.add(builder.between(root.get(AbstractNotasReporte_.fecha), dateInicio,
												DateUtils.ceiling(dateFin, Calendar.DATE)));
					
				if (terminal != null) {
					predicates.add(builder.equal(root.get(AbstractNotasReporte_.terminal), terminal));
				}
				if (estado != null) {
					predicates.add(builder.equal(root.get(AbstractNotasReporte_.estado), estado));
				}
				if (base != null) {
					predicates.add(builder.equal(root.get(AbstractNotasReporte_.base), base));
				}
				if (reporte != null) {
					if (StringUtils.isNotBlank(reporte)) {
						predicates.add(builder.equal(root.get(AbstractNotasReporte_.reporte), reporte));
					}
				}

				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.desc(root.get(AbstractNotasReporte_.fecha)));
				final TypedQuery<NotasReporte> typedQ = this.getEntityManager().createQuery(query);
				return typedQ.getResultList();
			} catch (final Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeNotasReportes", terminal);
			} 
		}catch (final Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeNotasReportes", terminal);
			} 
			return new Vector<>();
	}

	
	@Override
	public List<NotasReporte> listarNotas( Terminal terminal, String reporte) {

			try {
				final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
				final CriteriaQuery<NotasReporte> query = builder.createQuery(NotasReporte.class);
				final Root<NotasReporte> root = query.from(NotasReporte.class);
				query.select(root);
				final List<Predicate> predicates = new ArrayList<>();
				
				if (terminal != null) {
					predicates.add(builder.equal(root.get(AbstractNotasReporte_.terminal), terminal));
				}
				
				if (reporte != null) {
					predicates.add(builder.equal(root.get(AbstractNotasReporte_.reporte), reporte));
				}

				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.desc(root.get(AbstractNotasReporte_.fecha)));
				final TypedQuery<NotasReporte> typedQ = this.getEntityManager().createQuery(query);
				return typedQ.getResultList();
			
		}catch (final Exception e) {
				this.documentarExcepcionParaMetodo(e, "listarNotas", terminal);
			}
			return new Vector<>();
	}
}
