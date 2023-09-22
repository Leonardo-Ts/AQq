package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionSystemException;

import com.aaq.col.clases.database.entidades.HistoricoResumenAjustador;
import com.aaq.col.clases.database.entidades.abstracto.AbstractHistoricoResumenAjustador_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.HistoricoResumenAjustadorDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@org.springframework.stereotype.Repository(value = "historicoResumenAjustadorDao")
public class HistoricoResumenAjustadorDao extends SIICAServerGenericDaoJpaImpl<HistoricoResumenAjustador>
		implements HistoricoResumenAjustadorDaoInterfase {

	@Override
	public JMResultadoOperacion ejecutarFuncionHistoricoResumenAjustadorNuevo(String cveAjustador, String nombreAjustador,
			String numReporte, String poliza, String incisoEstatus, String actividad, String usuario, String fuente,
			String descripcionActividad, String resultado) {

		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("hist_resumen_ajus_nuevo");

			nat.registerStoredProcedureParameter("IN_CVE_AJUSTADOR", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_NOMBRE_AJUSTADOR", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_NUM_REPORTE", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_POLIZA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_INCISO_ESTATUS", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_ACTIVIDAD", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_USUARIO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_FUENTE", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_DESCRIPCION", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_RESULTADO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("OUT_RESPUESTA", String.class, ParameterMode.OUT);

			nat.setParameter("IN_CVE_AJUSTADOR", cveAjustador);
			nat.setParameter("IN_NOMBRE_AJUSTADOR", nombreAjustador);
			nat.setParameter("IN_NUM_REPORTE", numReporte);
			nat.setParameter("IN_POLIZA", poliza);
			nat.setParameter("IN_INCISO_ESTATUS", incisoEstatus);
			nat.setParameter("IN_ACTIVIDAD", actividad);
			nat.setParameter("IN_USUARIO", usuario);
			nat.setParameter("IN_FUENTE", fuente);
			nat.setParameter("IN_DESCRIPCION", descripcionActividad);
			nat.setParameter("IN_RESULTADO", resultado);
			
			nat.execute();
			
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("OUT_RESPUESTA"))); 
			
		} catch (NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs", numReporte);
			return new JMResultadoOperacion(e);
		} catch (IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs", numReporte);
			return new JMResultadoOperacion(e);
		} catch (RollbackException e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs", numReporte);
			return new JMResultadoOperacion(e);
		} catch ( PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs", numReporte);
			return new JMResultadoOperacion(e);
		}
	}

	@Override
	public List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustador(String reporte, String claveAjustador,
			String actividad, Date fechaInicial, Date fechaFinal)  {
		
		Date dateInicio = null;
		Date dateFin = null;
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<HistoricoResumenAjustador> query = builder.createQuery(HistoricoResumenAjustador.class);
			final Root<HistoricoResumenAjustador> root = query.from(HistoricoResumenAjustador.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (fechaInicial != null && fechaFinal != null) {
				
				HoraConsultaUtil utileria = new HoraConsultaUtil();
				try {
					dateInicio = utileria.formatInicial(fechaInicial);
					dateFin = utileria.formatFinal(fechaFinal);
				} catch (Exception e) {
					this.documentarExcepcionParaMetodo(e, "listaDeEncuestaAjustador");
				}
				
				predicates.add(builder.between(root.get(AbstractHistoricoResumenAjustador_.fechaActividad), dateInicio,
					DateUtils.ceiling(dateFin, Calendar.DATE)));
			}
			if (StringUtils.isNotBlank(reporte)) {
				predicates.add(builder.equal(root.get(AbstractHistoricoResumenAjustador_.generalNumeroReporte), reporte));
			}
			if (StringUtils.isNotBlank(claveAjustador)) {
				predicates.add(builder.equal(root.get(AbstractHistoricoResumenAjustador_.claveAjustador), claveAjustador));
			}
			if (StringUtils.isNotBlank(actividad)) {
				predicates.add(builder.equal(root.get(AbstractHistoricoResumenAjustador_.actividad), actividad));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractHistoricoResumenAjustador_.fechaActividad)));
			final TypedQuery<HistoricoResumenAjustador> typedQ = this.getEntityManager().createQuery(query);

			return typedQ.getResultList();
		} catch (final NoResultException | RollbackException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHistoricoResumenAjustador", reporte, claveAjustador, actividad,
					fechaInicial, fechaFinal);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHistoricoResumenAjustador", reporte, claveAjustador, actividad,
					fechaInicial, fechaFinal);
		} catch (final IllegalStateException | TransactionSystemException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHistoricoResumenAjustador", reporte, claveAjustador, actividad,
					fechaInicial, fechaFinal);
		} catch (final PersistenceException  | TransactionException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHistoricoResumenAjustador", reporte, claveAjustador, actividad,
					fechaInicial, fechaFinal);
		}
		return new Vector<>();
	}
	
	
	public List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustadorFreq(String reporte, List<String> claveAjustador,
			String actividad, Date fechaInicial, Date fechaFinal) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<HistoricoResumenAjustador> query = builder.createQuery(HistoricoResumenAjustador.class);
			final Root<HistoricoResumenAjustador> root = query.from(HistoricoResumenAjustador.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (fechaInicial != null && fechaFinal != null) {
				predicates.add(builder.between(root.get(AbstractHistoricoResumenAjustador_.fechaActividad), fechaInicial,
					DateUtils.ceiling(fechaFinal, Calendar.DATE)));
			}
			if (StringUtils.isNotBlank(reporte)) {
				predicates.add(builder.equal(root.get(AbstractHistoricoResumenAjustador_.generalNumeroReporte), reporte));
			}
			if (claveAjustador.size()!=0) {
		//	predicates.add(builder.equal(root.get(AbstractHistoricoResumenAjustador_.claveAjustador).in(claveAjustador));
				predicates.add(root.get(AbstractHistoricoResumenAjustador_.claveAjustador).in(claveAjustador));
			}
			if (StringUtils.isNotBlank(actividad)) {
				predicates.add(builder.equal(root.get(AbstractHistoricoResumenAjustador_.actividad), actividad));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractHistoricoResumenAjustador_.fechaActividad)));
			final TypedQuery<HistoricoResumenAjustador> typedQ = this.getEntityManager().createQuery(query);

			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHistoricoResumenAjustador", reporte, claveAjustador, actividad,
					fechaInicial, fechaFinal);
		}
		return new Vector<>();
	}
	
	@Override
	public List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustadorGestion (String reporte, String actividad) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<HistoricoResumenAjustador> query = builder.createQuery(HistoricoResumenAjustador.class);
			final Root<HistoricoResumenAjustador> root = query.from(HistoricoResumenAjustador.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			
			if (StringUtils.isNotBlank(reporte)) {
				predicates.add(builder.equal(root.get(AbstractHistoricoResumenAjustador_.generalNumeroReporte), reporte));
			}
			if (StringUtils.isNotBlank(actividad)) {
				predicates.add(builder.equal(root.get(AbstractHistoricoResumenAjustador_.actividad), actividad));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractHistoricoResumenAjustador_.fechaActividad)));
			final TypedQuery<HistoricoResumenAjustador> typedQ = this.getEntityManager().createQuery(query);

			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHistoricoResumenAjustador", reporte, actividad);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHistoricoResumenAjustador", reporte, actividad);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHistoricoResumenAjustador", reporte, actividad);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHistoricoResumenAjustador", reporte, actividad);
		}
		return new Vector<>();
	}
	
	public List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustadorFreqWeb(String reporte, List<String> claveAjustador, String actividad, Date fechaInicial, Date fechaFinal) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<HistoricoResumenAjustador> query = builder.createQuery(HistoricoResumenAjustador.class);
			final Root<HistoricoResumenAjustador> root = query.from(HistoricoResumenAjustador.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (fechaInicial != null && fechaFinal != null) {
				predicates.add(builder.between(root.get(AbstractHistoricoResumenAjustador_.fechaActividad), fechaInicial,
					DateUtils.ceiling(fechaFinal, Calendar.DATE)));
			}
			if (StringUtils.isNotBlank(reporte)) {
				predicates.add(builder.equal(root.get(AbstractHistoricoResumenAjustador_.generalNumeroReporte), reporte));
			}
			if (claveAjustador.size()!=0) {
				predicates.add(root.get(AbstractHistoricoResumenAjustador_.claveAjustador).in(claveAjustador));
			}
			if (StringUtils.isNotBlank(actividad)) {
				predicates.add(builder.equal(root.get(AbstractHistoricoResumenAjustador_.actividad), actividad));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractHistoricoResumenAjustador_.fechaActividad)));
			final TypedQuery<HistoricoResumenAjustador> typedQ = this.getEntityManager().createQuery(query);

			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHistoricoResumenAjustadorFreqWeb", reporte, claveAjustador, actividad,
					fechaInicial, fechaFinal);
		}
		return new Vector<>();
	}
	
}