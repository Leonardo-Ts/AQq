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
import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Repository;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.ControlFotografias;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractControlFotografias_;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ControlFotografiasDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;


@Repository(value="controlFotografiasDao")
public class ControlFotografiasDao extends SIICAServerGenericDaoJpaImpl<ControlFotografias>
 implements ControlFotografiasDaoInterfase {
	
	@Override
	public ControlFotografias objetoControlFoto(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(ControlFotografias.class, new Integer(id)) : null;
		} catch (final ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | RollbackException e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminal", id);
		} catch (final IllegalStateException | PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminal", id);
		}
		return null;
	}
	
	
	@Override
	public List<ControlFotografias> listarControlFotografias(final Date fechaInicial, final Date fechaFinal, 
			final String claveDocumental, final String numReporte, Estado edo, Base base) {
		
		if ((fechaInicial == null) || (fechaFinal == null)) {
			return new Vector<>();
		}
		Date dateInicio = null;
		Date dateFin = null;
		
		try {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<ControlFotografias> query = builder.createQuery(ControlFotografias.class);
		final Root<ControlFotografias> root = query.from(ControlFotografias.class);
		query.select(root);
		
		final List<Predicate> predicates = new ArrayList<>();

		HoraConsultaUtil utileria = new HoraConsultaUtil();
		try {
			dateInicio = utileria.formatInicial(fechaInicial);
			dateFin = utileria.formatFinal(fechaFinal);
		} catch (ClassCastException | IndexOutOfBoundsException | IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listarControlFotografias");
		}
		
		predicates.add(builder.between(root.get(AbstractControlFotografias_.fecha), dateInicio,
				DateUtils.ceiling(dateFin, Calendar.DATE)));
		
		if (StringUtils.isNotBlank(numReporte)) {
			predicates.add(builder.equal(root.get(AbstractControlFotografias_.numReporte), numReporte));
		}
		
		if (StringUtils.isNotBlank(claveDocumental)) {
			predicates.add(builder.equal(root.get(AbstractControlFotografias_.claveDocumental), claveDocumental));
		}
		
		if (edo != null) {
			predicates.add(builder.equal(root.get(AbstractControlFotografias_.estado), edo));
		}
		
		if (base != null) {
			predicates.add(builder.equal(root.get(AbstractControlFotografias_.base), base));
		}
		

		query.where(predicates.toArray(new Predicate[predicates.size()]));
		query.orderBy(builder.desc(root.get(AbstractControlFotografias_.fecha)));
		final TypedQuery<ControlFotografias> typedQ = this.getEntityManager().createQuery(query);
		return typedQ.getResultList();
		} 	
		 catch (NoResultException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException | RollbackException e) {
			this.documentarExcepcionParaMetodo(e, "listarControlFotografias");
		} catch ( PersistenceException | DatabaseException | DataIntegrityViolationException | CannotGetJdbcConnectionException e) {
			this.documentarExcepcionParaMetodo(e, "listarControlFotografias");
		} catch ( DataAccessException e) {
			this.documentarExcepcionParaMetodo(e, "listarControlFotografias");
		}
		return new Vector<>();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EntidadObjeto> listaParaGraficaFotos(final Date fechaInicial, final Date fechaFinal,
		String estado, String base, String reporte, String claveDocumental ) {
	if ((fechaInicial == null) || (fechaFinal == null)) {
		return null;
	}
		try { 
			final StringBuilder query = new StringBuilder(
					"select CLAVE_DOCUMENTAL, count(*) from CONTROL_FOTOGRAFIAS");
				query.append(" where CLAVE_DOCUMENTAL is not NULL");
				
					 if( StringUtils.isNotBlank(estado) && !StringUtils.equals("9999", estado) ) {
						 query.append(" AND ID_IDENTIDAD = '"+estado+"'");
					 }
					 if (StringUtils.isNotBlank(base) ) {
							if((!base.equals("-- TODAS --")) && (!base.equals("INDEFINIDA")) && !StringUtils.equals("0", base) && !StringUtils.equals("-1", base)) {
						query.append(" AND ID_ZONA = '"+base+"'");
							}
					 }
					 if (StringUtils.isNotBlank(reporte)) {
						 query.append(" AND NUM_REPORTE = '"+reporte+"'");
					}
					 if (StringUtils.isNotBlank(claveDocumental)) {
						 query.append(" AND CLAVE_DOCUMENTAL = '"+claveDocumental+"'");
					}
				query.append(" AND CONTROL_FOTOGRAFIAS.FECHA  BETWEEN ");
				query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
				query.append(" AND ");
				query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd 23:59:59''")+", 'yyyy-MM-dd HH24:mi:ss')");
				query.append(" group by CLAVE_DOCUMENTAL order by CLAVE_DOCUMENTAL");
				
		return procesarResultadoEntidadObjetoSIICA(this.getEntityManager().createNativeQuery(query.toString()).getResultList());
	} catch (NoResultException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException | RollbackException e) {
		this.documentarExcepcionParaMetodo(e, "listaParaGraficaFotos");
	} catch ( PersistenceException | DatabaseException | DataIntegrityViolationException | CannotGetJdbcConnectionException e) {
		this.documentarExcepcionParaMetodo(e, "listaParaGraficaFotos");
	} catch ( DataAccessException e) {
		this.documentarExcepcionParaMetodo(e, "listaParaGraficaFotos");
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

}
