package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
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
import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.aaq.col.clases.database.entidades.CodigoResponsabilidadEstad;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCodigoResponsabilidadEstad_;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CodigoResponsabilidadEstadDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;


@org.springframework.stereotype.Repository(value = "codigoResponsabilidadEstadDao")
public class CodigoResponsabilidadEstadDao extends SIICAServerGenericDaoJpaImpl<CodigoResponsabilidadEstad> implements CodigoResponsabilidadEstadDaoInterfase{

	private final Log4JLogger logTiempos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.tiempos");

	@Override
	public CodigoResponsabilidadEstad objetoCRE(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CodigoResponsabilidadEstad.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminal", id);
		}
		return null;
	}
	
	@Override
	public CodigoResponsabilidadEstad objetoCodigoResponsabilidad(String numeroReporte, String numeroAjustador ) {
		if (StringUtils.isBlank(numeroReporte)) {
			return null;
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CodigoResponsabilidadEstad> query = builder.createQuery(CodigoResponsabilidadEstad.class);
			final Root<CodigoResponsabilidadEstad> root = query.from(CodigoResponsabilidadEstad.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCodigoResponsabilidadEstad_.numeroReporte), numeroReporte));
			if (numeroAjustador != null) {
				predicates.add(builder.equal(root.get(AbstractCodigoResponsabilidadEstad_.claveAjustador), numeroAjustador));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCodigoResponsabilidadEstad_.id)));
			final TypedQuery<CodigoResponsabilidadEstad> typedQ = this.getEntityManager().createQuery(query);
			final List<CodigoResponsabilidadEstad> l = typedQ.getResultList();
			
			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCodigoResponsabilidadEstad", numeroReporte, numeroAjustador);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public  List<EntidadObjeto>  listarCodigoResp(Date fechaInicial, Date fechaFinal, String estado, String base) {
		if(fechaInicial == null && fechaFinal == null ) {
			return new Vector<>();
		}
		
		this.logTiempos.info("INICIA TIEMPO EN CREAR Y CONSULTAR QUERY PARA LISTARCODIGRESP");
		long startTime = System.currentTimeMillis();
		
		try { 
				final StringBuilder query = new StringBuilder(
						"select CODIGO_RESPONSABILIDAD, count(*) from CODIGO_RESPONSABILIDAD_ESTADISTICA");
					query.append(" where CODIGO_RESPONSABILIDAD is not NULL");
					
						 if( StringUtils.isNotBlank(estado)) {
							 query.append(" AND ESTADO = '"+estado+"'");
						 }
						 if (StringUtils.isNotBlank(base) ) {
								if((!base.equals("-- TODAS --")) && (!base.equals("INDEFINIDA"))) {
							query.append(" AND MUNICIPIO = '"+base+"'");
								}
						 }
					query.append(" AND CODIGO_RESPONSABILIDAD_ESTADISTICA.FECHA  BETWEEN ");
					query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
					query.append(" AND ");
					query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd 23:59:59''")+", 'yyyy-MM-dd HH24:mi:ss')");
					query.append(" group by CODIGO_RESPONSABILIDAD order by CODIGO_RESPONSABILIDAD");
		
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TERMINAL TIEMPO EN CREAR Y CONSULTAR QUERY PARA LISTARCODIGRESP --> "+endTime);
					return procesarResultadoEntidadObjetoSIICA(this.getEntityManager().createNativeQuery(query.toString()).getResultList());

		} catch (NoResultException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException | RollbackException e) {
			this.documentarExcepcionParaMetodo(e, "CodigosDeResponsabilidad");
			this.logTiempos.error("EXCEPCION EN LISTARCODIGRESP-> "+e);
		} catch ( PersistenceException | DatabaseException | DataIntegrityViolationException | CannotGetJdbcConnectionException e) {
			this.documentarExcepcionParaMetodo(e, "CodigosDeResponsabilidad");
			this.logTiempos.error("EXCEPCION EN LISTARCODIGRESP-> "+e);
		} catch ( DataAccessException e) {
			this.documentarExcepcionParaMetodo(e, "CodigosDeResponsabilidad");
			this.logTiempos.error("EXCEPCION EN LISTARCODIGRESP-> "+e);
		}
	this.logTiempos.info("TERMINAL TIEMPO EN CREAR Y CONSULTAR QUERY PARA LISTARCODIGRESP");
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
	
	@Override
	public List<CodigoResponsabilidadEstad> listarCodigoResponsabilidadEstad(final Date fechaInicial, final Date fechaFinal, final String estado , final String base) {
		
		if ((fechaInicial == null) || (fechaFinal == null)) {
			return new Vector<>();
		}
		Date dateInicio = null;
		Date dateFin = null;
		
	this.logTiempos.info("INICIA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listarCodigoResponsabilidadEstad");
	long startTime = System.currentTimeMillis();
		  
		try {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<CodigoResponsabilidadEstad> query = builder.createQuery(CodigoResponsabilidadEstad.class);
		final Root<CodigoResponsabilidadEstad> root = query.from(CodigoResponsabilidadEstad.class);
		query.select(root);
//		.where(root.get(AbstractCodigoResponsabilidadEstad_.codigoResponsabilidad).isNotNull());
//		query.where(builder.notEqual(root.get(AbstractCodigoResponsabilidadEstad_.codigoResponsabilidad), null));
		
		final List<Predicate> predicates = new ArrayList<>();

		HoraConsultaUtil utileria = new HoraConsultaUtil();
		try {
			dateInicio = utileria.formatInicial(fechaInicial);
			dateFin = utileria.formatFinal(fechaFinal);
		} catch (Exception e) {
			this.documentarExcepcionParaMetodo(e, "listarCodigoResponsabilidadEstad");
		}
		
		predicates.add(builder.between(root.get(AbstractCodigoResponsabilidadEstad_.fecha), dateInicio,
				DateUtils.ceiling(dateFin, Calendar.DATE)));
		
		if (StringUtils.isNotBlank(estado)) {
			predicates.add(builder.equal(root.get(AbstractCodigoResponsabilidadEstad_.estado), estado));
		}
		
		if (StringUtils.isNotBlank(base) ) {
			if((!base.equals("-- TODAS --")) && (!base.equals("INDEFINIDA"))) {
				predicates.add(builder.equal(root.get(AbstractCodigoResponsabilidadEstad_.municipio), base));
			} 
		}
		
//		predicates.add(builder.isNotNull(root.get(AbstractCodigoResponsabilidadEstad_.codigoResponsabilidad)));

		query.where(predicates.toArray(new Predicate[predicates.size()]));
		query.orderBy(builder.desc(root.get(AbstractCodigoResponsabilidadEstad_.fecha)));
		final TypedQuery<CodigoResponsabilidadEstad> typedQ = this.getEntityManager().createQuery(query);
	
	long endTime = System.currentTimeMillis() - startTime;
	this.logTiempos.info("TERMINA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listarCodigoResponsabilidadEstad--> "+endTime);
		return typedQ.getResultList();
	} 	
		 catch (NoResultException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException | RollbackException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCodigoResponsabilidadEstad");
			this.logTiempos.error("EXCEPCION EN listarCodigoResponsabilidadEstad -> "+e);
		} catch ( PersistenceException | DatabaseException | DataIntegrityViolationException | CannotGetJdbcConnectionException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCodigoResponsabilidadEstad");
			this.logTiempos.error("EXCEPCION EN listarCodigoResponsabilidadEstad -> "+e);
		} catch ( DataAccessException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCodigoResponsabilidadEstad");
			this.logTiempos.error("EXCEPCION EN listarCodigoResponsabilidadEstad -> "+e);
		}
		
		long endTime = System.currentTimeMillis() - startTime;
		this.logTiempos.info("TERMINA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listarCodigoResponsabilidadEstad--> "+endTime);
		
	return new Vector<>();
}
	
	
}
