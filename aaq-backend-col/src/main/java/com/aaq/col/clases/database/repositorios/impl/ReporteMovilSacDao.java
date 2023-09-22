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
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteMovilSac_;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ReporteMovilSacDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@org.springframework.stereotype.Repository(value = "reporteMovilSacDao")
public class ReporteMovilSacDao extends SIICAServerGenericDaoJpaImpl<ReporteMovilSac> implements ReporteMovilSacDaoInterfase {

	@Override
	public ReporteMovilSac objetoReporteMovilSac(String numeroReporte, String numeroAjustador ) {
		
		if (StringUtils.isBlank(numeroReporte)) {
			return null;
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteMovilSac> query = builder.createQuery(ReporteMovilSac.class);
			final Root<ReporteMovilSac> root = query.from(ReporteMovilSac.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.or(builder.equal(root.get(AbstractReporteMovilSac_.generalNumeroReporte), numeroReporte),
					builder.equal(root.get(AbstractReporteMovilSac_.generalNumeroReporteSise), numeroReporte)));
			
			if (numeroAjustador != null) {
				predicates.add(builder.equal(root.get(AbstractReporteMovilSac_.ajusteAjustadorCodigo), numeroAjustador));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractReporteMovilSac_.id)));
			final TypedQuery<ReporteMovilSac> typedQ = this.getEntityManager().createQuery(query);
			final List<ReporteMovilSac> l = typedQ.getResultList();
			
			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteMovilSac", numeroReporte, numeroAjustador);
		}
		return null;
	}
	
	@Override
	public JMResultadoOperacion ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs(final Integer id) {

		if (id == null) {
			return new JMResultadoOperacion(new Exception("Reporte Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"reporte_sac_actualiza_fcha_ws1");

			nat.registerStoredProcedureParameter("in_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id", id);

			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs", id);
			return new JMResultadoOperacion(e);
		}

	}
	
	@Override
	public JMResultadoOperacion ejecutarFuncionReporteSacActualizarServiciosDiversosConsecutivos(final Integer id, final String data) {

		if (id == null) {
			return new JMResultadoOperacion(new Exception("Reporte Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"reporte_sac_actua_ser_div_con1");

			nat.registerStoredProcedureParameter("in_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_data", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id", id);
			nat.setParameter("in_data", data);

			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionReporteSacActualizarServiciosDiversosConsecutivos", id);
			return new JMResultadoOperacion(e);
		}

	}
	
	@SuppressWarnings("unchecked")
	public  List<EntidadObjeto>  listarCodigoResp(Date fechaInicial, Date fechaFinal, String estado, String base) {
		if(fechaInicial == null && fechaFinal == null ) {
			return new Vector<>();
		}
		try { 
				final StringBuilder query = new StringBuilder(
						"select CODIGO_RESPONSABILIDAD, count(*) from REPORTE_MOVIL_SAC");
					query.append(" where CODIGO_RESPONSABILIDAD is not NULL");
					
						 if( StringUtils.isNotBlank(estado)) {
							 query.append(" AND UBICACION_ENTIDAD = '"+estado+"'");
						 }
						 if (StringUtils.isNotBlank(base) ) {
								if((!base.equals("-- TODAS --")) && (!base.equals("INDEFINIDA"))) {
							query.append(" AND UBICACION_MUNICIPIO = '"+base+"'");
								}
						 }
					query.append(" AND REPORTE_MOVIL_SAC.FECHA  BETWEEN ");
					query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
					query.append(" AND ");
					query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd 23:59:59''")+", 'yyyy-MM-dd HH24:mi:ss')");
					query.append(" group by CODIGO_RESPONSABILIDAD order by CODIGO_RESPONSABILIDAD");
					return procesarResultadoEntidadObjetoSIICA(this.getEntityManager().createNativeQuery(query.toString()).getResultList());

		} catch (Exception e) {
			this.documentarExcepcionParaMetodo(e, "CodigosDeResponsabilidad");
		}
		 return new Vector<>();
	}
	
	public List<EntidadObjeto> procesarResultadoEntidadObjetoSIICA(final List<Object[]> lista) {
        final List<EntidadObjeto> l = new Vector<EntidadObjeto>();
        if (lista != null && lista.size() > 0) {
            for (final Object obj : lista) {
                final Object[] o = (Object[])obj;
                l.add(new EntidadObjeto(o));
            }
        }
        return l;
    }
	
	public List<ReporteMovilSac> listarReporteMovilSac(final Date fechaInicial, final Date fechaFinal, final String estado , final String base) {
		
		if ((fechaInicial == null) || (fechaFinal == null)) {
			return new Vector<>();
		}
		Date dateInicio = null;
		Date dateFin = null;
		try {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<ReporteMovilSac> query = builder.createQuery(ReporteMovilSac.class);
		final Root<ReporteMovilSac> root = query.from(ReporteMovilSac.class);
		query.select(root);
		final List<Predicate> predicates = new ArrayList<>();
		HoraConsultaUtil utileria = new HoraConsultaUtil();
		try {
			dateInicio = utileria.formatInicial(fechaInicial);
			dateFin = utileria.formatFinal(fechaFinal);
		} catch (Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeEncuestaAjustador");
		}
		
		predicates.add(builder.between(root.get(AbstractReporteMovilSac_.fecha), dateInicio,
				DateUtils.ceiling(dateFin, Calendar.DATE)));
		
		if (StringUtils.isNotBlank(estado)) {
			predicates.add(builder.equal(root.get(AbstractReporteMovilSac_.ubicacionEntidad), estado));
		}
		
		if (StringUtils.isNotBlank(base) ) {
			if((!base.equals("-- TODAS --")) && (!base.equals("INDEFINIDA"))) {
				predicates.add(builder.equal(root.get(AbstractReporteMovilSac_.ubicacionMunicipio), base));
			} 
		}
		
		predicates.add(builder.isNotNull(root.get(AbstractReporteMovilSac_.codigoResponsabilidad)));

		query.where(predicates.toArray(new Predicate[predicates.size()]));
		query.orderBy(builder.desc(root.get(AbstractReporteMovilSac_.fecha)));
		final TypedQuery<ReporteMovilSac> typedQ = this.getEntityManager().createQuery(query);
		return typedQ.getResultList();
	} catch (final Exception e) {
		this.documentarExcepcionParaMetodo(e, "listaDeReporteMovilSac");
	}
	return new Vector<>();
}
	
	
	@Override
	public List<ReporteMovilSac> listaDeReportesModi(final String reporte) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteMovilSac> query = builder.createQuery(ReporteMovilSac.class);
			final Root<ReporteMovilSac> root = query.from(ReporteMovilSac.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(reporte)) {
				predicates.add(builder.equal(root.get(AbstractReporteMovilSac_.generalNumeroReporte), reporte));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			
			final TypedQuery<ReporteMovilSac> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeReportes", reporte);
		}
		return new Vector<>();
	}
	
	@Override
	public JMResultadoOperacion actualizarReporteSegundaAtencion(final String reporte, final String colonia, final String calles,
						final String refObs) {

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery("SEGUNDA_ATENCION");

			nat.registerStoredProcedureParameter("in_numero_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_colonia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_observaciones_referencia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_info_calles", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_numero_reporte", reporte);
			nat.setParameter("in_colonia", colonia);
			nat.setParameter("in_observaciones_referencia", refObs);
			nat.setParameter("in_info_calles", calles);
			
			nat.execute();

			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final RollbackException e) {
			this.documentarExcepcionParaMetodo(e, "actualizarReporteSegundaAtencion", reporte);
			return new JMResultadoOperacion(e);
		} catch (final  IndexOutOfBoundsException | DataAccessException e) {
			this.documentarExcepcionParaMetodo(e, "actualizarReporteSegundaAtencion", reporte);
			return new JMResultadoOperacion(e);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "actualizarReporteSegundaAtencion", reporte);
			return new JMResultadoOperacion(e);
		}  catch (final ClassCastException e) {
			this.documentarExcepcionParaMetodo(e, "actualizarReporteSegundaAtencion", reporte);
			return new JMResultadoOperacion(e);
		}

	}
	
//	@Override
//	public List<ReporteMovilSac> listaDeReportesACancelar() {
//		try {
//			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
//			final CriteriaQuery<ReporteMovilSac> query = builder.createQuery(ReporteMovilSac.class);
//			final Root<ReporteMovilSac> root = query.from(ReporteMovilSac.class);
//			query.select(root);
//			final List<Predicate> predicates = new ArrayList<>();
////			if (causa != null) {
////				predicates.add(builder.equal(root.get(AbstractReporteMovilSac_.causaSA), causa));
////			}
//			predicates.add(builder.isNotNull(root.get(AbstractReporteMovilSac_.causaSA)));
//			predicates.add(builder.isNotNull(root.get(AbstractReporteMovilSac_.fechaSA)));
//			
////			try {
////			HoraConsultaUtil utileria = new HoraConsultaUtil(); 
////			List<Date> salida = utileria.fechasInicioFin();
////			if (salida != null) {
////				predicates.add(builder.between(root.get(AbstractReporteMovilSac_.fecha), salida.get(0),
////						DateUtils.ceiling(salida.get(1), Calendar.DATE)));
////				}
////			} catch (NumberFormatException| ClassCastException | IndexOutOfBoundsException e) {
////			}
//			
//			
//			query.where(predicates.toArray(new Predicate[predicates.size()]));
//			query.orderBy(builder.asc(root.get(AbstractReporteMovilSac_.id)));
//			final TypedQuery<ReporteMovilSac> typedQ = this.getEntityManager().createQuery(query);
//			final List<ReporteMovilSac> l = typedQ.getResultList();
//				return l;
//		} catch (final NoResultException | RollbackException | IndexOutOfBoundsException | ClassCastException e) {
//			this.documentarExcepcionParaMetodo(e, "listaDeReportesACancelar");
//			return null;
//		} catch (final PersistenceException  | DataAccessException e) {
//			this.documentarExcepcionParaMetodo(e, "listaDeReportesACancelar");
//		}
//		return null;
//	}

}