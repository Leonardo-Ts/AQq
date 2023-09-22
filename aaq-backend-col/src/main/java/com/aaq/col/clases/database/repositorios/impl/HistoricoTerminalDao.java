package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

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
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.eclipse.persistence.exceptions.DatabaseException;

import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.abstracto.AbstractHistoricoTerminal_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.HistoricoTerminalDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@org.springframework.stereotype.Repository(value = "historicoTerminalDao")
public class HistoricoTerminalDao extends SIICAServerGenericDaoJpaImpl<HistoricoTerminal> implements
		HistoricoTerminalDaoInterfase {

	private final Log4JLogger logTiempos = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.tiempos");

	@Override
	public HistoricoTerminal objetoHistoricoTerminal(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(HistoricoTerminal.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoHistoricoTerminal", id);
		}
		return null;
	}

	@Override
	public List<HistoricoTerminal> listaDeHistoricoTerminal(final Terminal terminal, final String reporte,
			final String operacion, final Date fechaInicial, final Date fechaFinal, final Integer limite) {
		if ((fechaInicial == null) || (fechaFinal == null)) {
			return new Vector<>();
		}
		Date dateInicio = null;
		Date dateFin = null;
		this.logTiempos.info("INICIA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeHistoricoTerminal");
		long startTime = System.currentTimeMillis();
		
		try {
			HoraConsultaUtil utileria = new HoraConsultaUtil();
			try {
				dateInicio = utileria.formatInicial(fechaInicial);
				dateFin = utileria.formatFinal(fechaFinal);
			} catch (Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeEncuestaAjustador");
			}
	
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<HistoricoTerminal> query = builder.createQuery(HistoricoTerminal.class);
			final Root<HistoricoTerminal> root = query.from(HistoricoTerminal.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(
					builder.between(
							root.get(AbstractHistoricoTerminal_.fecha), dateInicio,
										DateUtils.ceiling(dateFin, Calendar.DATE)));

			if (terminal != null) {
				predicates.add(builder.equal(root.get(AbstractHistoricoTerminal_.terminal), terminal));
			}
			if (StringUtils.isNotBlank(reporte)) {
				predicates.add(builder.equal(root.get(AbstractHistoricoTerminal_.reporte), reporte));
			}
			if (StringUtils.isNotBlank(operacion)) {
				predicates.add(builder.equal(root.get(AbstractHistoricoTerminal_.operacion), operacion));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractHistoricoTerminal_.id)));
			final TypedQuery<HistoricoTerminal> typedQ = this.getEntityManager().createQuery(query);

			if (limite != null) {
				typedQ.setMaxResults(limite.intValue());
			}
	
	long endTime = System.currentTimeMillis() - startTime;
	this.logTiempos.info("TERMINA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeHistoricoTerminal -->Tiempo "+endTime);

			return typedQ.getResultList();
		} catch (final Exception e) {
		this.logTiempos.error("EXCEPCION EN listaDeHistoricoTerminal -> "+e);
			this.documentarExcepcionParaMetodo(e, "listaDeHistoricoTerminal", terminal, reporte, operacion,
					fechaInicial, fechaFinal, limite);
		}
	long endTime = System.currentTimeMillis() - startTime;
	this.logTiempos.info("TERMINA TIEMPO EN CREAR Y CONSULTAR QUERY PARA listaDeHistoricoTerminal--> Tiempo: "+endTime);

		return new Vector<>();
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionHistoricoTerminalNuevo(final Usuario usuario, final Terminal terminal,
			final String reporte, final String fuente, final String operacion, final String detalles) {

//		if (terminal == null) {
//			return new JMResultadoOperacion(new Exception("Terminal Nula"));
//		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"historico_terminal_nuevo1");

			nat.registerStoredProcedureParameter("in_id_terminal", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_id_usuario", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_detalles", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id_terminal", terminal.getId());
			nat.setParameter("in_id_usuario", usuario != null ? usuario.getId() : null);
			nat.setParameter("in_reporte", reporte);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_operacion", operacion);
			nat.setParameter("in_detalles", detalles);

			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionHistoricoTerminalNuevo", usuario, terminal, reporte,
					fuente, operacion, detalles);
			return new JMResultadoOperacion(e);
		}
	}

	
	@Override
	public JMResultadoOperacion ejecutarFuncionHistoricoTerminal(final Usuario usuario, final Terminal terminal,
			final String reporte, final String fuente, final String operacion, final String detalles) {

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"historico_terminal_nuevo1");

			nat.registerStoredProcedureParameter("in_id_terminal", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_id_usuario", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fuente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_operacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_detalles", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id_terminal", terminal != null ? terminal.getId() : null);
			nat.setParameter("in_id_usuario", usuario != null ? usuario.getId() : null);
			nat.setParameter("in_reporte", reporte);
			nat.setParameter("in_fuente", fuente);
			nat.setParameter("in_operacion", operacion);
			nat.setParameter("in_detalles", detalles);

			nat.execute();

			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final IllegalStateException | ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | RollbackException e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionHistoricoTerminalNuevo", usuario, terminal, reporte,
					fuente, operacion, detalles);
			return new JMResultadoOperacion(e);
		} catch (final DatabaseException |PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionHistoricoTerminalNuevo", usuario, terminal, reporte,
					fuente, operacion, detalles);
			return new JMResultadoOperacion(e);
		}
	}
}