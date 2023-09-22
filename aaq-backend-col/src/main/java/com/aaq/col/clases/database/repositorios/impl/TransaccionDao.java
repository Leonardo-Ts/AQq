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

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Transaccion;
import com.aaq.col.clases.database.entidades.abstracto.AbstractTransaccion_;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.TransaccionDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;

@org.springframework.stereotype.Repository(value = "transaccionDao")
public class TransaccionDao extends SIICAServerGenericDaoJpaImpl<Transaccion> implements TransaccionDaoInterfase {

	@Override
	public Transaccion objetoTransaccion(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Transaccion.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoTransaccion", id);
		}
		return null;
	}

	@Override
	public Transaccion objetoTransaccionParaNumeroReporte(final String numeroreporte) {
		if (StringUtils.isBlank(numeroreporte)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Transaccion> query = builder.createQuery(Transaccion.class);
			final Root<Transaccion> root = query.from(Transaccion.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractTransaccion_.numeroReporte), numeroreporte));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractTransaccion_.id)));
			final TypedQuery<Transaccion> typedQ = this.getEntityManager().createQuery(query);
			final List<Transaccion> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoTransaccionParaNumeroReporte", numeroreporte);
		}
		return null;
	}

	@Override
	public List<Transaccion> listaDeTransaccion(final String numeroreporte, final boolean aprobada) {
		return this.listaDeTransaccion(numeroreporte, null, null, null, new Boolean(aprobada), null);
	}

	@Override
	public List<Transaccion> listaDeTransaccion(final String numeroreporte, final Terminal terminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas, final Object[] tiposPermitidos) {
		try {
			Date dateInicio = null;
			Date dateFin = null;
			
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Transaccion> query = builder.createQuery(Transaccion.class);
			final Root<Transaccion> root = query.from(Transaccion.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(numeroreporte)) {
				predicates.add(builder.equal(root.get(AbstractTransaccion_.numeroReporte), numeroreporte));
			}

			if (terminal != null) {
				predicates.add(builder.equal(root.get(AbstractTransaccion_.terminal), terminal));
			}

			if ((fechaInicial != null) && (fechaFinal != null)) {
				HoraConsultaUtil utileria = new HoraConsultaUtil();
				try {
					dateInicio = utileria.formatInicial(fechaInicial);
					dateFin = utileria.formatFinal(fechaFinal);
				} catch (Exception e) {
					this.documentarExcepcionParaMetodo(e, "listaDeEncuestaAjustador");
				}
				
				predicates.add(builder.between(root.get(AbstractTransaccion_.fecha), dateInicio,
						DateUtils.ceiling(dateFin, Calendar.DATE)));

			}

			if (BooleanUtils.isTrue(soloAprobadas)) {
				predicates.add(builder.equal(root.get(AbstractTransaccion_.transaccionAprobada), Boolean.TRUE));
			}
			if (ArrayUtils.isNotEmpty(tiposPermitidos)) {
				predicates.add(root.get(AbstractTransaccion_.tipoDeCobro).in(tiposPermitidos));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractTransaccion_.fecha)));
			final TypedQuery<Transaccion> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTransaccion");
		}
		return new Vector<>();
	}
	
	@Override
	public List<Transaccion> listaDeTransaccionNuevo(final String numeroreporte, final Terminal terminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas, final Object[] tiposPermitidos,
			final Estado estado, final Base base, String ajustador, String edoTransaccion) {
		
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
			final CriteriaQuery<Transaccion> query = builder.createQuery(Transaccion.class);
			final Root<Transaccion> root = query.from(Transaccion.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(numeroreporte)) {
				predicates.add(builder.equal(root.get(AbstractTransaccion_.numeroReporte), numeroreporte));
			}

			if (terminal != null) {
				predicates.add(builder.equal(root.get(AbstractTransaccion_.terminal), terminal));
			}

//			if ((fechaInicial != null) && (fechaFinal != null)) {
//				predicates.add(builder.between(root.get(AbstractTransaccion_.fecha), fechaInicial,
//						DateUtils.ceiling(fechaFinal, Calendar.DATE)));
//			}
			
			predicates.add(builder.between(root.get(AbstractTransaccion_.fecha), dateInicio,
					DateUtils.ceiling(dateFin, Calendar.DATE)));

			if (BooleanUtils.isTrue(soloAprobadas)) {
				predicates.add(builder.equal(root.get(AbstractTransaccion_.transaccionAprobada), Boolean.TRUE));
			}
			if (ArrayUtils.isNotEmpty(tiposPermitidos)) {
				predicates.add(root.get(AbstractTransaccion_.tipoDeCobro).in(tiposPermitidos));
			}
			//Nuevas condiciones 
			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractTransaccion_.terminal).get("estado"), estado));
			}
			
			if ((base != null) && (base.getId().intValue() > 0)) {
				predicates.add(builder.equal(root.get(AbstractTransaccion_.terminal).get("base"), base));
			}
			
			if (ajustador != null) {
				predicates.add(builder.equal(root.get(AbstractTransaccion_.terminal).get("numeroproveedor"), ajustador));
			}
			
			if (StringUtils.isNotBlank(edoTransaccion)) {
				if (edoTransaccion.contains("aprobado")) {
					predicates.add(builder.equal(root.get(AbstractTransaccion_.transaccionAprobada), Boolean.TRUE));
				} else if (edoTransaccion.contains("declinada")) {
					Predicate edoCondition = builder.like(root.get(AbstractTransaccion_.xmlRespuesta), "<response>denied</response>");
					predicates.add(edoCondition);
				}  else if (edoTransaccion.contains("error")) {
					Predicate edoCondition = builder.like(root.get(AbstractTransaccion_.xmlRespuesta),  "%<response>error</response>%" );
					predicates.add(edoCondition);
				}
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractTransaccion_.fecha)));
			final TypedQuery<Transaccion> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTransaccion");
		}
		return new Vector<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JMEntidadObjeto> listaDeTransaccionParaGrafica(final String numeroreporte, final String idterminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas,
			int estado, int  base, String ajustador ) {

		if ((fechaInicial == null) || (fechaFinal == null)) {
			return new Vector<>();
		}

		try {
			
			final StringBuilder query = new StringBuilder(
					"SELECT TRUNC(Transaccion.fecha,'DDD') , SUM(CAST(Transaccion.monto AS double precision)) FROM Transaccion");
			if (estado > 0) {
				query.append(" INNER JOIN terminal ON ( Transaccion.id_terminal = terminal.id AND terminal.identidad ="+estado+" )");
				if(base >0) {
					query.append(" AND  terminal.idzona = "+base);
				} 
				if(ajustador != null) {
					query.append(" AND terminal.numeroproveedor =" +ajustador);
				}
			}
			query.append(" WHERE Transaccion.transaccion_aprobada='t' AND Transaccion.fecha BETWEEN ");
			query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
			query.append(" AND ");
//			query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
			query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd 23:59:59''")+", 'yyyy-MM-dd HH24:mi:ss')");

			if (StringUtils.isNotBlank(numeroreporte)) {
				query.append(" AND Transaccion.numero_reporte = '" + numeroreporte + "'");
			}
			
//			if ((base > 0) ) {
//				query.append(" AND Terminal.idzona ="+base);
//			}
//			
//			if (ajustador != null) {
//				query.append(" AND Terminal.numeroproveedor ="+ajustador);
//			}
			

			if (StringUtils.isNotBlank(idterminal)) {
				query.append(" AND Transaccion.id_terminal=" + idterminal);
			}
			query.append(" GROUP BY TRUNC(Transaccion.fecha,'DDD') ORDER BY 1");
			return this.procesarResultadoEntidadObjeto(this.getEntityManager().createNativeQuery(query.toString())
					.getResultList());

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTransaccionParaGrafica", numeroreporte, idterminal,
					fechaInicial, fechaFinal, soloAprobadas);
		}
		return null;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<EntidadObjeto> listaDeTransaccionParaGraficaNuevo(final String numeroreporte, final String idterminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas,
			int estado, int  base, String ajustador ) {

		if ((fechaInicial == null) || (fechaFinal == null)) {
			return new Vector<>();
		}

		try {
			
			final StringBuilder query = new StringBuilder(
					"SELECT TRUNC(Transaccion.fecha,'DDD') , SUM(CAST(Transaccion.monto AS double precision)) FROM Transaccion");
			if (estado > 0) {
				query.append(" INNER JOIN terminal ON ( Transaccion.id_terminal = terminal.id AND terminal.identidad ="+estado+" )");
				if(base >0) {
					query.append(" AND  terminal.idzona = "+base);
				} 
				if(ajustador != null) {
					query.append(" AND terminal.numeroproveedor =" +ajustador);
				}
			}
			query.append(" WHERE Transaccion.transaccion_aprobada='t' AND Transaccion.fecha BETWEEN ");
			query.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
			query.append(" AND ");
//			query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
			query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd 23:59:59''")+", 'yyyy-MM-dd HH24:mi:ss')");

			if (StringUtils.isNotBlank(numeroreporte)) {
				query.append(" AND Transaccion.numero_reporte = '" + numeroreporte + "'");
			}
			

			if (StringUtils.isNotBlank(idterminal)) {
				query.append(" AND Transaccion.id_terminal=" + idterminal);
			}
			query.append(" GROUP BY TRUNC(Transaccion.fecha,'DDD') ORDER BY 1");
//			return this.procesarResultadoEntidadObjeto(this.getEntityManager().createNativeQuery(query.toString())
//					.getResultList());
			return this.procesarResultadoEntidadObjetoSIICA(this.getEntityManager().createNativeQuery(query.toString()).getResultList());


		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTransaccionParaGrafica", numeroreporte, idterminal,
					fechaInicial, fechaFinal, soloAprobadas);
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
	
	@Override
	public Transaccion objetoTransaccionReporteCobro(final String numeroreporte, final String tipoDeCobro, String fuente) {
		if (StringUtils.isBlank(numeroreporte)) {
			return null;
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Transaccion> query = builder.createQuery(Transaccion.class);
			final Root<Transaccion> root = query.from(Transaccion.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractTransaccion_.numeroReporte), numeroreporte));
			predicates.add(builder.equal(root.get(AbstractTransaccion_.tipoDeCobro), tipoDeCobro));
			if (StringUtils.isNotBlank(fuente)) {
				predicates.add(builder.like(builder.upper(root.get(AbstractTransaccion_.fuente)),
						"%"+fuente.trim()+"%"));
			
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractTransaccion_.id)));
			final TypedQuery<Transaccion> typedQ = this.getEntityManager().createQuery(query);
			final List<Transaccion> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final DataAccessException | RollbackException | IndexOutOfBoundsException | IllegalStateException | NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoTransaccionReporteCobro", numeroreporte);
		} catch (final PersistenceException   e) {
			this.documentarExcepcionParaMetodo(e, "objetoTransaccionReporteCobro", numeroreporte);
		}
		return null;
	}
	
	@Override
	public List<Transaccion> listaParaDepu( final String fechaInicial, final String fechaFinal) {
		if ((fechaInicial == null) || (fechaFinal == null)) {
			return new Vector<>();
		}
		Date dateInicio = null;
		Date dateFin = null;
		try {
			
			HoraConsultaUtil utileria = new HoraConsultaUtil();
			try {
				dateInicio = utileria.convertirFecha(fechaInicial, true);
				dateFin = utileria.convertirFecha(fechaFinal, false);
			} catch (Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaParaDepu");
			}

			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Transaccion> query = builder.createQuery(Transaccion.class);
			final Root<Transaccion> root = query.from(Transaccion.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.isNotNull(root.get(AbstractTransaccion_.voucherGeneral)));
			predicates.add(builder.equal(root.get(AbstractTransaccion_.transaccionAprobada), Boolean.TRUE));
			
			predicates.add(builder.like(builder.upper(root.get(AbstractTransaccion_.voucherGeneral)),
						"%" + StringUtils.upperCase("No.Tarjeta: xxxxxxxxxxxx") + "%"));
			
			predicates.add(builder.between(root.get(AbstractTransaccion_.fecha), dateInicio,
					DateUtils.ceiling(dateFin, Calendar.DATE)));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractTransaccion_.fecha)));
			final TypedQuery<Transaccion> typedQ = this.getEntityManager().createQuery(query);
			final List<Transaccion> listaR = typedQ.getResultList();
//			return typedQ.getResultList();
			return listaR;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaParaDepu");
		}
		return new Vector<>();
	}

}