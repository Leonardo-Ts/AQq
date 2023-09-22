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
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.MetricaED;
import com.aaq.col.clases.database.entidades.abstracto.AbstractMetricaED_;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjetoQuinto;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.MetricaEDDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@org.springframework.stereotype.Repository(value = "metricaEDDao")
public class MetricaEDDao extends SIICAServerGenericDaoJpaImpl<MetricaED> implements MetricaEDDaoInterfase {

	private final Log4JLogger logTiempos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.tiempos");

	@Override
	public JMResultadoOperacion ejecutarMetricaED(String numReporte, String involucrado, int oaAuto, int dua, int oaMoto,
			int oAEP, String claveAjustador, int edua, String folio, boolean enviado) {

		if (StringUtils.isBlank(numReporte)) {
			return new JMResultadoOperacion(new Exception("Reporte es requerido"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"SP_METRICA_ED");

			nat.registerStoredProcedureParameter("IN_NUMERO_REPORTE", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_INVOLUCRADO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_OA_AUTO", Integer.class, ParameterMode.INOUT);
			nat.registerStoredProcedureParameter("IN_DUA", Integer.class, ParameterMode.INOUT);
			nat.registerStoredProcedureParameter("IN_OA_MOTO", Integer.class, ParameterMode.INOUT);
			nat.registerStoredProcedureParameter("IN_OA_EP", Integer.class, ParameterMode.INOUT);
			nat.registerStoredProcedureParameter("IN_CLAVE_AJUSTADOR", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("IN_EDUA", Integer.class, ParameterMode.INOUT);
			nat.registerStoredProcedureParameter("IN_FOLIO", String.class, ParameterMode.INOUT);
			nat.registerStoredProcedureParameter("IN_ENVIADO", String.class, ParameterMode.INOUT);
			nat.registerStoredProcedureParameter("OUT_RESPUESTA", String.class, ParameterMode.OUT);

			nat.setParameter("IN_NUMERO_REPORTE", numReporte);
			nat.setParameter("IN_INVOLUCRADO", involucrado);
			nat.setParameter("IN_OA_AUTO", oaAuto);
			nat.setParameter("IN_DUA", dua);
			nat.setParameter("IN_OA_MOTO", oaMoto);
			nat.setParameter("IN_OA_EP", oAEP);
			nat.setParameter("IN_CLAVE_AJUSTADOR", claveAjustador);
			nat.setParameter("IN_EDUA",edua );
			nat.setParameter("IN_FOLIO", folio );
			nat.setParameter("IN_ENVIADO", enviado ? "t" : "f");

			nat.execute();
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("OUT_RESPUESTA"))); 

		} catch (final ClassCastException | IndexOutOfBoundsException | IllegalArgumentException| RollbackException e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarMetricaED", numReporte);
			return new JMResultadoOperacion(e);
		} catch (final DataAccessException | PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarMetricaED", numReporte);
			return new JMResultadoOperacion(e);
		}

	}
	
	@Override
	public List<MetricaED> listaDeMetricasED(String edo, String base, String claveAjustador, 
			Date fechaInicio, Date fechaFin, String reporte, String nombreFormato) {
		
		if ((fechaInicio == null) || (fechaFin == null)) {
			return new Vector<>();
		}
		this.logTiempos.info("INICIA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeMetricasED");
		long startTime = System.currentTimeMillis();
		
		try {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<MetricaED> query = builder.createQuery(MetricaED.class);
		final Root<MetricaED> root = query.from(MetricaED.class);
		query.select(root);
		
		final List<Predicate> predicates = new ArrayList<>();

		Date dateInicio = null;
		Date dateFin = null;
		
			HoraConsultaUtil utileria = new HoraConsultaUtil();
			try {
				dateInicio = utileria.formatInicial(fechaInicio);
				dateFin = utileria.formatFinal(fechaFin);
			} catch (Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeMetricasED");
			}
			
			
		predicates.add(builder.between(root.get(AbstractMetricaED_.fecha), dateInicio,
				DateUtils.ceiling(dateFin, Calendar.DATE)));
		
		if (edo != null) {
			predicates.add(builder.equal(root.get(AbstractMetricaED_.entidad), edo));
		}
		if (base != null ) {
				predicates.add(builder.equal(root.get(AbstractMetricaED_.base), base));
		}
		 if (reporte != null) {
			 if (StringUtils.isNotBlank(reporte)) {
			 try {
				 if (reporte.trim() != null && reporte.trim() != "") {
				 predicates.add(builder.equal(root.get(AbstractMetricaED_.numeroReporte), reporte));
				 }
			 } catch (Exception e) {
				 this.documentarExcepcionParaMetodo(e, "listaDeMetricasED");
			}
			 }
		}
		
		if (claveAjustador != null) {
			predicates.add(builder.equal(root.get(AbstractMetricaED_.claveAjustador), claveAjustador));
		}
		if (nombreFormato != null) {
			 if ( StringUtils.isNotBlank(nombreFormato)  && !nombreFormato.contains("todos")) {
			 if ( nombreFormato.contains("Formato Admisión Autos")) {
			predicates.add(builder.notEqual(root.get(AbstractMetricaED_.oaAuto), 0));
			 }
			 if (nombreFormato.contains("Formato Admisión Motocicletas")) {
					predicates.add(builder.notEqual(root.get(AbstractMetricaED_.oaMoto), 0));
			}
			 if (nombreFormato.contains("Formato Admisión Pesado")) {
					predicates.add(builder.notEqual(root.get(AbstractMetricaED_.oaAuto), 0));
			 }
			 if (nombreFormato.contains("Formato Declaración Universal")) {
					predicates.add(builder.notEqual(root.get(AbstractMetricaED_.oaAuto), 0));
			 }
			 }
		}
		try {
		predicates.add(builder.notLike(builder.upper(root.get(AbstractMetricaED_.codigoCausa)),
				"%" + StringUtils.upperCase("ASISTENCIA VIAL") + "%"));
		predicates.add(builder.notLike(builder.upper(root.get(AbstractMetricaED_.codigoCausa)),
				"%" + StringUtils.upperCase("CRISTALES") + "%"));
		predicates.add(builder.notLike(builder.upper(root.get(AbstractMetricaED_.codigoCausa)),
				"%" + StringUtils.upperCase("AJUSTE EXPRES") + "%"));
		}catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException e) {
		}
		
		query.where(predicates.toArray(new Predicate[predicates.size()]));
		query.orderBy(builder.desc(root.get(AbstractMetricaED_.fecha)));
		final TypedQuery<MetricaED> typedQ = this.getEntityManager().createQuery(query);
		 List<MetricaED> resp = typedQ.getResultList();
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TERMINAL TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeMetricasED --> "+endTime+" ms.");
		this.logTiempos.info("listaDeExpedientesNoEnviado QUERY => "+typedQ.toString());
		return resp;
	} catch (final Exception e) {
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TERMINAL TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeMetricasED (EXCEPTION) --> "+endTime+" ms.");
		this.documentarExcepcionParaMetodo(e, "listaDeExpedientesNoEnviado");
	}
	return new Vector<>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EntidadObjeto> listaDeMetricaParaGrafica(Date fechaInicial, Date fechaFinal, Integer limite, String edo, String  base,
			String claveAjustador, String nombreFormato,  String reporte) {
		if(fechaInicial == null && fechaFinal == null ) {
			return new Vector<>();
		}
		
		try { 
				final StringBuilder query = new StringBuilder(
						"select NUMERO_REPORTE, count(*) from METRICA_ED");
					query.append(" where NUMERO_REPORTE is not NULL  ");
					
						 if (edo != null ) {
								query.append(" AND ENTIDAD = '"+edo+"'");
							 }
						 
						 if (base != null ) {
							query.append(" AND BASE = '"+base+"'");
						 }
						 
						 if (claveAjustador != null) {
							 query.append(" AND CLAVE_AJUSTADOR = '"+claveAjustador+"'");
						}
						 
						 if (nombreFormato != null) {
							 if ( StringUtils.isNotBlank(nombreFormato) && !nombreFormato.contains("todos")) {
							 if (nombreFormato.contains("Formato Admisión Autos")) {
								 query.append(" AND OA_AUTO != '0' ");
								}
							 if (nombreFormato.contains("Formato Admisión Motocicletas")) {
								 query.append(" AND OA_MOTO != '0' ");
							    }
							 if (nombreFormato.contains("Formato Admisión Pesado")) {
								 query.append(" AND OA_EP != '0' ");
								}
							if ( nombreFormato.contains("Formato Declaración Universal")) {
								 query.append(" AND OA_DUA != '0' ");
								 }
							 }
						}
						 
						 if (StringUtils.isNotBlank(reporte)) {
							 try {
								 if (reporte.trim() != null && reporte.trim() != "") {
									 query.append(" AND NUMERO_REPORTE = '"+reporte+"'");
								 }
							 } catch (ClassCastException | IndexOutOfBoundsException | NoResultException | RollbackException e) {
								 this.documentarExcepcionParaMetodo(e, "listaDeExpedientesNoEnviado");
							}
						}
						 
					query.append(" AND METRICA_ED.FECHA  BETWEEN ");
					query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
					query.append(" AND ");
					query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd 23:59:59''")+", 'yyyy-MM-dd HH24:mi:ss')");
					query.append(" group by METRICA_ED order by NUMERO_REPORTE");
					return procesarResultadoEntidadObjetoSIICA(this.getEntityManager().createNativeQuery(query.toString()).getResultList());

		} catch (ClassCastException | IllegalArgumentException | IllegalStateException | IndexOutOfBoundsException |
				RollbackException | NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFormatosParaGrafica");
		} catch (PersistenceException  e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFormatosParaGrafica");
		} catch (Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFormatosParaGrafica");
		}
		 return new Vector<>();
	}
	
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public  List<EntidadObjetoQuinto> obtenerContadorTotal(Date fechaInicial, Date fechaFinal, String edo, String  base,
			 String nombreFormato, String claveAjustador, String reporte) {
	try {
		final StringBuilder query = new StringBuilder(
				"SELECT SUM(CASE WHEN OA_AUTO !='0' THEN 1 ELSE 0 END) AS OAAUTOCONT, ");
		query.append("SUM (CASE WHEN OA_MOTO !='0' THEN 1 ELSE 0 END) AS OAMOTOCONT,  ");
		query.append("SUM (CASE WHEN OA_EP!='0' THEN 1 ELSE 0 END) AS OAEPCONT,  ");
		query.append("SUM (CASE WHEN DUA!='0' THEN 1 ELSE 0 END) AS DUACONT, "
				+ "count(*) ");
		query.append("FROM METRICA_ED WHERE NUMERO_REPORTE IS NOT NULL AND CODIGO_CAUSA  NOT LIKE '%ASISTENCIA VIAL%' AND CODIGO_CAUSA  NOT LIKE '%CRISTALES%'  AND CODIGO_CAUSA  NOT LIKE '%AJUSTE EXPRES%' ");
		 if (edo != null ) {
				query.append(" AND ENTIDAD = '"+edo+"'");
			 }
		 if (base != null ) {
			query.append(" AND BASE = '"+base+"'");
		 }
		 if (claveAjustador != null) {
			 query.append(" AND CLAVE_AJUSTADOR = '"+claveAjustador+"'");
		}
		 if (nombreFormato != null) {
				 if ( StringUtils.isNotBlank(nombreFormato) && !nombreFormato.contains("todos")) {
				 if (nombreFormato.contains("Formato Admisión Autos")) {
					 query.append(" AND OA_AUTO != '0' ");
					}
				 if (nombreFormato.contains("Formato Admisión Motocicletas")) {
					 query.append(" AND OA_MOTO != '0' ");
				    }
				 if (nombreFormato.contains("Formato Admisión Pesado")) {
					 query.append(" AND OA_EP != '0' ");
					}
				if ( nombreFormato.contains("Formato Declaración Universal")) {
					 query.append(" AND DUA != '0' ");
					 }
				 }
		}
		if (StringUtils.isNotBlank(reporte)) {
			try {
			 if (reporte.trim() != null && reporte.trim() != "") {
				 query.append(" AND NUMERO_REPORTE = '"+reporte+"'");
			 }
		 } catch (ClassCastException | IndexOutOfBoundsException | NoResultException | RollbackException e) {
			 this.documentarExcepcionParaMetodo(e, "obtenerContadorTotal");
		}
		 }
	query.append(" AND METRICA_ED.FECHA  BETWEEN ");
	query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
	query.append(" AND ");
	query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd 23:59:59''")+", 'yyyy-MM-dd HH24:mi:ss')");
	query.append(" GROUP BY 4 ");
 return procesarResultado( this.getEntityManager().createNativeQuery(query.toString()).getResultList());
	} catch (final Exception e) {
		this.documentarExcepcionParaMetodo(e, "obtenerContadorTotal", reporte);
	}
	return null;
	}
	
	public List<EntidadObjetoQuinto> procesarResultado(final List<Object[]> lista) {
        final List<EntidadObjetoQuinto> l = new Vector<EntidadObjetoQuinto>();
        if (lista != null && lista.size() > 0) {
            for (final Object obj : lista) {
                final Object[] o = (Object[])obj;
                l.add(new EntidadObjetoQuinto(o));
            }
        }
        return l;
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
	
	
}
