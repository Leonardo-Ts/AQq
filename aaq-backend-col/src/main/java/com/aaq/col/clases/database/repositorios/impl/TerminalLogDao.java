package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalLog;
import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminalLog_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.TerminalLogDaoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;

@org.springframework.stereotype.Repository(value = "terminalLogDao")
public class TerminalLogDao extends SIICAServerGenericDaoJpaImpl<TerminalLog> implements TerminalLogDaoInterfase {

	@Override
	public TerminalLog objetoTerminalLog(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(TerminalLog.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoTerminalLog", id);
		}
		return null;
	}

	@Override
	public List<TerminalLog> listaDeTerminalLog(final Date fechaInicial, final Date fechaFinal) {
		return this.listaDeTerminalLog(null, fechaInicial, fechaFinal, false, false, null);
	}

	@Override
	public List<TerminalLog> listaDeTerminalLog(final List<Terminal> terminal, final Date fechaInicial,
			final Date fechaFinal, final boolean validez, final boolean esTraza, final Integer limite) {

		if ((fechaInicial == null) || (fechaFinal == null) || (terminal == null) || (terminal.size() < 1)) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<TerminalLog> query = builder.createQuery(TerminalLog.class);
			final Root<TerminalLog> root = query.from(TerminalLog.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (terminal.size() == 1) {
				predicates.add(builder.equal(root.get(AbstractTerminalLog_.terminal), terminal.get(0)));
			} else {
				predicates.add(root.get(AbstractTerminalLog_.terminal).in(terminal));

			}

			predicates.add(builder.between(root.get(AbstractTerminalLog_.fecha), fechaInicial, fechaFinal));

			if (validez) {
				predicates.add(builder.equal(root.get(AbstractTerminalLog_.posicionValida), Boolean.TRUE));
			}
			if (esTraza) {
				predicates.add(builder.greaterThan(root.get(AbstractTerminalLog_.metrosRecorridos), new Double(1)));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractTerminalLog_.fecha)));
			final TypedQuery<TerminalLog> typedQ = this.getEntityManager().createQuery(query);

			if (limite != null) {
				typedQ.setMaxResults(limite.intValue());
			}
			return typedQ.getResultList();
		} catch (final Exception e) {

			this.documentarExcepcionParaMetodo(e, "listaDeTerminalLog", terminal, fechaInicial, fechaFinal,
					new Boolean(validez), new Boolean(esTraza), limite);
		}
		return new Vector<>();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TerminalLog> listaDeTerminalLogParaCoordenadas(final Date fechaInicial, final Date fechaFinal,
			final String latitud, final String longitud, final String radio) {
		if (StringUtils.isBlank(latitud) || StringUtils.isBlank(longitud) || (fechaInicial == null)
				|| (fechaFinal == null)) {
			return null;
		}

		try {
			final StrBuilder sql = new StrBuilder("SELECT * FROM terminal_log WHERE ");
			sql.append(" terminal_log.fecha BETWEEN ");
			sql.append("to_date("+DateFormatUtils.format(fechaInicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
			sql.append(" AND ");
			sql.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
			sql.append(" AND posicion_valida=TRUE AND LATITUD IS NOT NULL AND LONGITUD IS NOT NULL ");
			sql.append(" AND (SELECT (is_in_distance(longitud::float8,latitud::float8, " + latitud + "::float8,"
					+ longitud + "::float8) ) < " + radio + ") ");
			sql.append(" ORDER BY ID DESC LIMIT 1000");

			final Query nat = this.getEntityManager().createNativeQuery(sql.toString(), TerminalLog.class);
			return nat.getResultList();
		} catch (final Exception e) {

			this.documentarExcepcionParaMetodo(e, "listaDeTerminalLogParaCoordenadas", fechaInicial, fechaFinal,
					latitud, longitud, radio);
		}
		return new Vector<>();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JMEntidadObjeto> listaDeTerminalLogParaGrafica(final Date fechainicial, final Date fechaFinal,
			final String idterminal, final String reporte) {
		if ((fechainicial == null) || (fechaFinal == null)) {
			return null;
		}
		try {
			final StringBuilder query = new StringBuilder(
					"SELECT TRUNC(terminal_log.fecha,'day') , COUNT(*) FROM terminal_log ");
			query.append(" WHERE terminal_log.fecha BETWEEN ");
			query.append("to_date("+DateFormatUtils.format(fechainicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
			query.append(" AND ");
			query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");

			if (StringUtils.isNotBlank(idterminal)) {
				query.append(" AND terminal_log.idterminal='" + idterminal + "'");
			}
			if (StringUtils.isNotBlank(reporte)) {
				query.append(" AND terminal_log.reporte_numero='" + reporte + "'");
			}
			query.append(" GROUP BY TRUNC(terminal_log.fecha,'day') ORDER BY 1");

			return this.procesarResultadoEntidadObjeto(this.getEntityManager().createNativeQuery(query.toString())
					.getResultList());

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeTerminalLogParaGrafica", fechainicial, fechaFinal,
					idterminal, reporte);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JMEntidadObjeto> listaDeTerminalLogParaGraficaKMDia(final Date fechainicial, final Date fechaFinal,
			final String terminal) {
		if ((fechainicial == null) || (fechaFinal == null)) {
			return null;
		}
		try {
			final StringBuilder query = new StringBuilder(
					"SELECT TRUNC(terminal_log.fecha,'day') , Sum(terminal_log.metros_recorridos) / 1000 FROM terminal_log");
			query.append(" WHERE terminal_log.fecha BETWEEN ");
			query.append("to_date("+DateFormatUtils.format(fechainicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
			query.append(" AND ");
			query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");

			if (StringUtils.isNotBlank(terminal)) {
				query.append(" AND terminal_log.idterminal=" + terminal);
			}

			query.append(" GROUP BY TRUNC(terminal_log.fecha,'day') ORDER BY 1");

			return this.procesarResultadoEntidadObjeto(this.getEntityManager().createNativeQuery(query.toString())
					.getResultList());

		} catch (final Exception e) {

			this.documentarExcepcionParaMetodo(e, "listaDeTerminalLogParaGraficaKMDia", fechainicial, fechaFinal,
					terminal);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JMEntidadObjeto> listaDeTerminalLogParaTiempoDeParado(final Date fechainicial, final Date fechaFinal,
			final String terminal) {
		if ((fechainicial == null) || (fechaFinal == null)) {
			return null;
		}
		try {
			final StringBuilder query = new StringBuilder("");
			query.append(" SELECT  CAST(MIN(terminal_log.id) as varchar) AS ID,");
			query.append(" CAST( MIN(terminal_log.fecha) as varchar)  AS FECHA1, ");
			query.append(" CAST( MAX(terminal_log.fecha) as varchar) AS FECHA2,");
			query.append(" CAST( MAX(terminal_log.latitud) as varchar) AS POS1, ");
			query.append(" CAST( MAX(terminal_log.longitud) as varchar) AS POS2,  ");
			query.append(" CAST( (MAX(terminal_log.fecha) - MIN(terminal_log.fecha)) as varchar) AS DELAY, ");
			query.append(" COUNT(*) as CONTEO, terminal_log.posicion_direccion  FROM terminal_log");
			query.append(" WHERE terminal_log.fecha BETWEEN ");
			query.append("to_date("+DateFormatUtils.format(fechainicial, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
			query.append(" AND ");
			query.append("to_date("+DateFormatUtils.format(fechaFinal, "''yyyy-MM-dd HH:mm:ss''")+", 'yyyy-MM-dd HH24:mi:ss')");
			query.append(" and terminal_log.posicion_valida  = true");
			query.append(" and terminal_log.idterminal = " + terminal);
			query.append(" and terminal_log.metros_recorridos < 10");
			query.append(" group by terminal_log.posicion_direccion");
			query.append(" having  max(fecha) - min(fecha) > '00:05:00'");

			return this.procesarResultadoEntidadObjeto(this.getEntityManager().createNativeQuery(query.toString())
					.getResultList());

		} catch (final Exception e) {

			this.documentarExcepcionParaMetodo(e, "listaDeTerminalLogParaTiempoDeParado", fechainicial, fechaFinal,
					terminal);
		}
		return null;
	}

}