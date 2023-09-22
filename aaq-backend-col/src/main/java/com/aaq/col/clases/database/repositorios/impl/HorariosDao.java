package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Horarios;
import com.aaq.col.clases.database.entidades.abstracto.AbstractHorarios_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.HorariosDaoInterfase;

@org.springframework.stereotype.Repository(value = "horariosDao")
public class HorariosDao extends SIICAServerGenericDaoJpaImpl<Horarios> implements HorariosDaoInterfase {

	@Override
	public Horarios objetoHorario(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Horarios.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoHorarios", id);
		}
		return null;
	}

	@Override
	public List<Horarios> listaDeHorarios(final String clave_horario) {
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Horarios> query = builder.createQuery(Horarios.class);
			final Root<Horarios> root = query.from(Horarios.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			// predicates.add(builder.equal(root.get(AbstractFrecuencia_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractHorarios_.clave_horario), clave_horario));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractHorarios_.id)));
			final TypedQuery<Horarios> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHorarios", clave_horario);
		}
		return new Vector<>();
	}
	
	
	@Override
	public List<Horarios> listaDeHorarios(final Estado estado, final String clave_horario) {
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Horarios> query = builder.createQuery(Horarios.class);
			final Root<Horarios> root = query.from(Horarios.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			// predicates.add(builder.equal(root.get(AbstractFrecuencia_.habilitado), Boolean.TRUE));
			if (StringUtils.isNotBlank(clave_horario)) {
				
				predicates.add(builder.equal(root.get(AbstractHorarios_.clave_horario), clave_horario));
			}
			
			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractHorarios_.estado), estado));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractHorarios_.id)));
			final TypedQuery<Horarios> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHorarios", clave_horario);
		}
		return new Vector<>();
	}
	
	@Override
	public Horarios horarioDia(final String clave_horario, final int dia_num) {
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Horarios> query = builder.createQuery(Horarios.class);
			final Root<Horarios> root = query.from(Horarios.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractHorarios_.clave_horario), clave_horario));
			predicates.add(builder.equal(root.get(AbstractHorarios_.dia_semana_num), dia_num));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			final TypedQuery<Horarios> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getSingleResult();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHorarios", clave_horario);
		}
		return null;
	}
	
	@Override
	public List<Horarios> listaDeHorarios() {
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Horarios> query = builder.createQuery(Horarios.class);
			final Root<Horarios> root = query.from(Horarios.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			final List <Order> orderList = new ArrayList<>();

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			orderList.add(builder.asc(root.get(AbstractHorarios_.clave_horario)));
			orderList.add(builder.asc(root.get(AbstractHorarios_.id)));
			query.orderBy(orderList);
			final TypedQuery<Horarios> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHorarios" );
		}
		return new Vector<>();
	}
	
	@Override
	public List<Horarios> listaDeHorariosAgroup(Estado estado) {
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Horarios> query = builder.createQuery(Horarios.class);
			final Root<Horarios> root = query.from(Horarios.class);
			query.select(root.get("clave_horario")).groupBy(root.get("clave_horario"));
			final List <Order> orderList = new ArrayList<>();
			final List <Predicate> predicates = new ArrayList<>();
			
			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractHorarios_.estado), estado));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			orderList.add(builder.asc(root.get(AbstractHorarios_.clave_horario)));
			query.orderBy(orderList);;
			final TypedQuery<Horarios> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHorarios" );
		}
		return new Vector<>();
	}
	
	@Override
	public Horarios horarioDia(final String clave_horario, final int dia_num, final Estado edo) {
		
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Horarios> query = builder.createQuery(Horarios.class);
			final Root<Horarios> root = query.from(Horarios.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractHorarios_.clave_horario), clave_horario));
			predicates.add(builder.equal(root.get(AbstractHorarios_.dia_semana_num), dia_num));
			if (edo != null) {
				predicates.add(builder.equal(root.get(AbstractHorarios_.estado), edo));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			final TypedQuery<Horarios> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getSingleResult();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeHorarios", clave_horario);
		}
		return null;
	}


}