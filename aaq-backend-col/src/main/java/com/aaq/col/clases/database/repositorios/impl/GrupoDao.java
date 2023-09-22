package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.abstracto.AbstractGrupo_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.GrupoDaoInterfase;

@org.springframework.stereotype.Repository(value = "grupoDao")
public class GrupoDao extends SIICAServerGenericDaoJpaImpl<Grupo> implements GrupoDaoInterfase {

	@Override
	public Grupo objetoGrupo(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Grupo.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoGrupo", id);
		}
		return null;
	}
	
	@Override
	public Grupo objetoGrupoPorNombre(final String nombre) {
		try {
			return StringUtils.isNotBlank(nombre) ? this.getEntityManager().find(Grupo.class, nombre) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoGrupo", nombre);
		}
		return null;
	}

	@Override
	public List<Grupo> listaDeGrupo() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Grupo> query = builder.createQuery(Grupo.class);
			final Root<Grupo> root = query.from(Grupo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractGrupo_.habilitado), Boolean.TRUE));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractGrupo_.nombre)));
			final TypedQuery<Grupo> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeGrupo");
		}
		return new Vector<>();
	}
	
	@Override
	public List<Grupo> listaDeGrupo(Estado estado) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Grupo> query = builder.createQuery(Grupo.class);
			final Root<Grupo> root = query.from(Grupo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractGrupo_.habilitado), Boolean.TRUE));
			
			if(estado != null) {
				predicates.add(builder.equal(root.get(AbstractGrupo_.estado), estado));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractGrupo_.nombre)));
			final TypedQuery<Grupo> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeGrupo");
		}
		return new Vector<>();
	}
	
	@Override
	public Grupo grupoEncontrado(String nombre) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Grupo> query = builder.createQuery(Grupo.class);
			final Root<Grupo> root = query.from(Grupo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractGrupo_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractGrupo_.nombre), nombre));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			final TypedQuery<Grupo> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getSingleResult();
		} catch (Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeGrupo");
		}
		return null;
	}
	
	@Override
	public Grupo listaDeGrupoEdoNom(Estado estado, String nombre) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Grupo> query = builder.createQuery(Grupo.class);
			final Root<Grupo> root = query.from(Grupo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractGrupo_.habilitado), Boolean.TRUE));
			
			if(estado != null) {
				predicates.add(builder.equal(root.get(AbstractGrupo_.estado), estado));
			}
			
			if (nombre != null) {
				predicates.add(builder.equal(root.get(AbstractGrupo_.nombre), nombre));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractGrupo_.nombre)));
			final TypedQuery<Grupo> typedQ = this.getEntityManager().createQuery(query);
			typedQ.setMaxResults(1);
			return typedQ.getSingleResult();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeGrupo");
		}
		return null;
	}
	

}