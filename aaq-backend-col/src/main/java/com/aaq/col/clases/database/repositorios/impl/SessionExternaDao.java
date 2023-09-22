package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.aaq.col.clases.database.entidades.SessionExterna;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.abstracto.AbstractSessionExterna_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.SessionExternaDaoInterfase;
import com.aaq.col.clases.util.HoraConsultaUtil;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@org.springframework.stereotype.Repository(value = "sessionExternaDao")
public class SessionExternaDao extends SIICAServerGenericDaoJpaImpl<SessionExterna> implements
		SessionExternaDaoInterfase {
	
	

	@Override
	public SessionExterna objetoSessionExterna(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(SessionExterna.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoSessionExterna", id);
		}
		return null;
	}

	@Override
	public SessionExterna objetoSessionExternaParaTerminal(final Terminal terminal) {
		if (terminal == null) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<SessionExterna> query = builder.createQuery(SessionExterna.class);
			final Root<SessionExterna> root = query.from(SessionExterna.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractSessionExterna_.terminal), terminal));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractSessionExterna_.id)));
			final TypedQuery<SessionExterna> typedQ = this.getEntityManager().createQuery(query);
			final List<SessionExterna> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoSessionExternaParaTerminal", terminal);
		}
		return null;
	}

	@Override
	public List<SessionExterna> listaDeSessionExterna(final List<Terminal> listaTerminales, final Date fechaInicia,
			final Date fechaFinal) {

		if ((listaTerminales == null) || (listaTerminales.size() == 0)) {
			return new Vector<>();

		}
		Date dateInicio = null;
		Date dateFin = null;
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<SessionExterna> query = builder.createQuery(SessionExterna.class);
			final Root<SessionExterna> root = query.from(SessionExterna.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(root.get(AbstractSessionExterna_.terminal).in(listaTerminales));

			if ((fechaInicia != null) && (fechaFinal != null)) {
				
				HoraConsultaUtil utileria = new HoraConsultaUtil();
				try {
					dateInicio = utileria.formatInicial(fechaInicia);
					dateFin = utileria.formatFinal(fechaFinal);
				} catch (Exception e) {
					this.documentarExcepcionParaMetodo(e, "listaDeEncuestaAjustador");
				}
				
				predicates.add(builder.between(root.get(AbstractSessionExterna_.fecha), dateInicio,
						DateUtils.ceiling(dateFin, Calendar.DATE)));

			} else {
				predicates.add(builder.greaterThan(root.get(AbstractSessionExterna_.fecha),
						new Date(System.currentTimeMillis() - JMUtileriaFecha.TIEMPO_1_DIA)));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractSessionExterna_.fecha)));
			final TypedQuery<SessionExterna> tempQ = this.getEntityManager().createQuery(query);
			final List<SessionExterna> listaConectadas = tempQ.getResultList();

			final List<SessionExterna> listaNueva = new Vector<>();
			for (final Terminal terminal : listaTerminales) {
				final SessionExterna s = new SessionExterna();
				s.setBase(terminal.getBase().getNombre());
				s.setEstaConectado(Boolean.FALSE);
				s.setEstado(terminal.getEstado().getNombre());
				s.setFecha(terminal.getUltimoLocalizacionFecha());
				s.setOperacion(null);
				s.setNombre(terminal.getNombre());
				s.setProveedor(terminal.getNumeroproveedor());
				s.setRadio(terminal.getNumeroradio());
				s.setTerminal(terminal);
				s.setValida(Boolean.FALSE);
				s.setEstatus(terminal.getEstatus());
				//Nuevo
					s.setRazonEstatus(terminal.getRazonEstatus());
				s.setProveedorTelefonia(terminal.getProveedorTelefonia());
				s.setHorarioEntrada(terminal.getHorario());
                s.setHorarioSalida(terminal.getHorarioSalida());
				s.setFechaPrimerInicioSession(terminal.getFechaPrimerLoginDia());
                s.setFechaUltimoInicioSession(terminal.getFechaUltimoLoginDia());
                //Nuevo campos
                if (terminal.getConceptos() != null) {
					s.setAjustadoresEnFalta(terminal.getConceptos());
				}
                
                if (terminal.getReportesEsteDia() != null) {
                	try {
                	  s.setReportesEsteDia(Integer.toString(terminal.getReportesEsteDia()));
                	}catch (ClassCastException | NumberFormatException e) {
					}
				}
              
				for (final SessionExterna sessionExterna : listaConectadas) {
					if (sessionExterna.getTerminal().getId().intValue() == terminal.getId().intValue()) {
						s.setEstaConectado(Boolean.TRUE);
						s.setValida(Boolean.TRUE);
						s.setFecha(sessionExterna.getFecha());
						s.setOperacion(sessionExterna.getOperacion());
						s.setId(sessionExterna.getId());
					}
				}

				listaNueva.add(s);
			}

			return listaNueva;

		} catch (final Exception e) {

			this.documentarExcepcionParaMetodo(e, "listaDeSessionExterna", listaTerminales, fechaInicia, fechaFinal);
		}
		return new Vector<>();
	}

	@Override
	public void informacionDeSessionExterna(final Terminal terminal, final String operacion) {
		SessionExterna sess = this.objetoSessionExternaParaTerminal(terminal);
		if (terminal != null) {

			if (sess == null) {
				sess = new SessionExterna();
				sess.setTerminal(terminal);
				sess.setValida(Boolean.TRUE);
			}
			sess.setOperacion(operacion);
			sess.setFecha(new Date());

			if (terminal.getEstado() != null) {
				sess.setEstado(Objects.toString(terminal.getEstado(), ""));
			}
			if (terminal.getBase() != null) {
				sess.setBase(Objects.toString(terminal.getBase(), ""));
			}
			sess.setFechaPrimerInicioSession(terminal.getFechaPrimerLoginDia());
            sess.setFechaUltimoInicioSession(terminal.getFechaUltimoLoginDia());
			sess.setHorarioEntrada(terminal.getHorario());
            sess.setHorarioSalida(terminal.getHorarioSalida());
			sess.setProveedor(terminal.getNumeroproveedor());
			sess.setRadio(terminal.getNumeroradio());
			sess.setNombre(terminal.getNombre());
			sess.guardarObjeto();
		}
	}

}