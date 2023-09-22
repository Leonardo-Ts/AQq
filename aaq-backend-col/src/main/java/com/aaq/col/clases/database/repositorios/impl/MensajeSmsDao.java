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
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import com.aaq.col.clases.database.entidades.MensajeSms;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.abstracto.AbstractMensajeSms_;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.MensajeSmsDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;

@org.springframework.stereotype.Repository(value = "mensajeSmsDao")
public class MensajeSmsDao extends SIICAServerGenericDaoJpaImpl<MensajeSms> implements MensajeSmsDaoInterfase {

	private final Log4JLogger logTiempos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.tiempos");

	@Override
	public MensajeSms objetoMensajeSms(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(MensajeSms.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoMensajeSms", id);
		}
		return null;
	}

	@Override
	public List<MensajeSms> listaDeMensajeSms(final Date fechaInicial, final Date fechaFinal, final String reporte,
			final String oficina, final String poliza, final String agente, final String asegurado,
			final String gerente, final Terminal terminal, final Integer limite) {

		if ((fechaInicial == null) || (fechaFinal == null)) {
			return new Vector<>();
		}
		
		Date dateInicio = null;
		Date dateFin = null;
		
		try {
			HoraConsultaUtil utileria = new HoraConsultaUtil();
			try {
				dateInicio = utileria.formatInicial(fechaInicial);
				dateFin = utileria.formatFinal(fechaFinal);
			} catch (Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeEncuestaAjustador");
			}
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<MensajeSms> query = builder.createQuery(MensajeSms.class);
			final Root<MensajeSms> root = query.from(MensajeSms.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.between(root.get(AbstractMensajeSms_.fecha), dateInicio,
					DateUtils.ceiling(dateFin, Calendar.DATE)));

			if (StringUtils.isNotBlank(reporte)) {
				predicates.add(builder.equal(root.get(AbstractMensajeSms_.numeroreporte), reporte));
			}
			if (StringUtils.isNotBlank(oficina)) {
				predicates.add(builder.equal(root.get(AbstractMensajeSms_.oficina), oficina));
			}
			if (StringUtils.isNotBlank(poliza)) {
				predicates.add(builder.equal(root.get(AbstractMensajeSms_.poliza), poliza));
			}
			if (StringUtils.isNotBlank(agente)) {
				predicates.add(builder.equal(root.get(AbstractMensajeSms_.agente), agente));
			}
			if (StringUtils.isNotBlank(asegurado)) {
				predicates.add(builder.equal(root.get(AbstractMensajeSms_.asegurado), asegurado));
			}
			if (StringUtils.isNotBlank(gerente)) {
				predicates.add(builder.equal(root.get(AbstractMensajeSms_.gerente), gerente));
			}
			if (terminal != null) {
				predicates.add(builder.equal(root.get(AbstractMensajeSms_.terminal), terminal));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractMensajeSms_.fecha)));
			
	this.logTiempos.info("INICIA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeMensajeSms");
	long startTime = System.currentTimeMillis();
	
			final TypedQuery<MensajeSms> typedQ = this.getEntityManager().createQuery(query);
			if (limite != null) {
				typedQ.setMaxResults(limite.intValue());
			}
			
   long endTime = System.currentTimeMillis() - startTime;
  this.logTiempos.info("TERMINA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeMensajeSms--> Tiempo: "+endTime);
  
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.logTiempos.info("Excepcion listaDeMensajeSms-> "+e);
			this.documentarExcepcionParaMetodo(e, "listaDeMensajeSms", fechaInicial, fechaFinal, reporte, oficina,
					poliza, agente, asegurado, gerente, terminal, limite);
		}
	this.logTiempos.info("TERMINA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeMensajeSms");
		return new Vector<>();
	}

//	@Override
//	public List<JMEntidadObjeto> listaDeMensajeSmsParaGrafica(final Date fechaInicial, final Date fechaFinal,
//			final String reporte, final String oficina, final String poliza, final String agente,
//			final String asegurado, final String gerente, final String idterminal) {
//
//		if ((fechaInicial == null) || (fechaFinal == null)) {
//			return null;
//		}
//
//		try {
//
//			final StringBuilder query = new StringBuilder(
//					"SELECT TRUNC(mensaje_sms.fecha,'DDD') , COUNT(*) FROM mensaje_sms");
//			query.append(" WHERE mensaje_sms.fecha BETWEEN ");
//			query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
//			query.append(" AND ");
//			query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd 23:59:59''")+", 'yyyy-MM-dd HH24:mi:ss')");
//
//			if (StringUtils.isNotBlank(reporte)) {
//				query.append(" AND mensaje_sms.numeroreporte='" + reporte + "'");
//			}
//			if (StringUtils.isNotBlank(oficina)) {
//				query.append(" AND mensaje_sms.oficina='" + oficina + "'");
//			}
//			if (StringUtils.isNotBlank(poliza)) {
//				query.append(" AND mensaje_sms.poliza='" + poliza + "'");
//			}
//			if (StringUtils.isNotBlank(agente)) {
//				query.append(" AND mensaje_sms.agente='" + agente + "'");
//			}
//			if (StringUtils.isNotBlank(asegurado)) {
//				query.append(" AND mensaje_sms.asegurado='" + asegurado + "'");
//			}
//			if (StringUtils.isNotBlank(gerente)) {
//				query.append(" AND mensaje_sms.gerente='" + gerente + "'");
//			}
//			if (StringUtils.isNotBlank(idterminal)) {
//				query.append(" AND mensaje_sms.id_terminal='" + idterminal + "'");
//			}
//
//			query.append(" GROUP BY TRUNC(mensaje_sms.fecha,'DDD') ORDER BY 1");
//			return this.procesarResultadoEntidadObjeto(this.getEntityManager().createNativeQuery(query.toString())
//					.getResultList());
//
//		} catch (final Exception e) {
//
//			this.documentarExcepcionParaMetodo(e, "listaDeMensajeSmsParaGrafica", fechaInicial, fechaFinal, reporte,
//					oficina, poliza, agente, asegurado, gerente, idterminal);
//		}
//		return null;
//	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<EntidadObjeto> listaDeMensajeSmsParaGrafica(final Date fechaInicial, final Date fechaFinal,
		final String reporte, final String oficina, final String poliza, final String agente,
		final String asegurado, final String gerente, final String idterminal) {
	
	if ((fechaInicial == null) || (fechaFinal == null)) {
		return null;
	}
	
	try {
	
		final StringBuilder query = new StringBuilder(
				"SELECT TRUNC(mensaje_sms.fecha,'DDD') , COUNT(*) FROM mensaje_sms");
		query.append(" WHERE mensaje_sms.fecha BETWEEN ");
		query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
		query.append(" AND ");
		query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd 23:59:59''")+", 'yyyy-MM-dd HH24:mi:ss')");
	
		if (StringUtils.isNotBlank(reporte)) {
			query.append(" AND mensaje_sms.numeroreporte='" + reporte + "'");
		}
		if (StringUtils.isNotBlank(oficina)) {
			query.append(" AND mensaje_sms.oficina='" + oficina + "'");
		}
		if (StringUtils.isNotBlank(poliza)) {
			query.append(" AND mensaje_sms.poliza='" + poliza + "'");
		}
		if (StringUtils.isNotBlank(agente)) {
			query.append(" AND mensaje_sms.agente='" + agente + "'");
		}
		if (StringUtils.isNotBlank(asegurado)) {
			query.append(" AND mensaje_sms.asegurado='" + asegurado + "'");
		}
		if (StringUtils.isNotBlank(gerente)) {
			query.append(" AND mensaje_sms.gerente='" + gerente + "'");
		}
		if (StringUtils.isNotBlank(idterminal)) {
			query.append(" AND mensaje_sms.id_terminal='" + idterminal + "'");
		}
	
		query.append(" GROUP BY TRUNC(mensaje_sms.fecha,'DDD') ORDER BY 1");
	//	return this.procesarResultadoEntidadObjeto(this.getEntityManager().createNativeQuery(query.toString())
	//			.getResultList());
	
		return this.procesarResultadoEntidadObjetoSIICA(this.getEntityManager().createNativeQuery(query.toString()).getResultList());
	
	} catch (final Exception e) {
	
		this.documentarExcepcionParaMetodo(e, "listaDeMensajeSmsParaGrafica", fechaInicial, fechaFinal, reporte,
				oficina, poliza, agente, asegurado, gerente, idterminal);
	}
	return null;
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