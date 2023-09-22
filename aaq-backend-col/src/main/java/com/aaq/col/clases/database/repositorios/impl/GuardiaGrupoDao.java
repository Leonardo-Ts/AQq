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

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.GuardiaGrupo;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.abstracto.AbstractGuardiaGrupo_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.GuardiaGrupoDaoInterfase;


@org.springframework.stereotype.Repository(value = "guardiaGrupoDao")
public class GuardiaGrupoDao extends SIICAServerGenericDaoJpaImpl<GuardiaGrupo> implements
GuardiaGrupoDaoInterfase {

	@Override
	public GuardiaGrupo objetoGuardiaGrupo(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(GuardiaGrupo.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoGrupoTerminal", id);
		}
		return null;
	}
	
	@Override
	public GuardiaGrupo objetoGuardiaPorGrupo(final Grupo grupo) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<GuardiaGrupo> query = builder.createQuery(GuardiaGrupo.class);
			final Root<GuardiaGrupo> root = query.from(GuardiaGrupo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			predicates.add(builder.equal(root.get(AbstractGuardiaGrupo_.grupo), grupo));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			final TypedQuery<GuardiaGrupo> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getSingleResult();
		} catch (Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeGrupoTerminal", grupo);
		}
		
		return null;
	}

	@Override
	public List<GuardiaGrupo> listaDeGuardiaGrupo(final Grupo grupo) {
		return this.listaDeGuardiaGrupo(grupo, null);
	}

	private List<GuardiaGrupo> listaDeGuardiaGrupo(Grupo grupo, Terminal terminal){
		if(grupo != null || terminal != null){
			try {
				final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
				final CriteriaQuery<GuardiaGrupo> query = builder.createQuery(GuardiaGrupo.class);
				final Root<GuardiaGrupo> root = query.from(GuardiaGrupo.class);
				query.select(root);
				final List<Predicate> predicates = new ArrayList<>();
				
				if (grupo != null) {
					predicates.add(builder.equal(root.get(AbstractGuardiaGrupo_.grupo), grupo));
				}
		
				query.where(predicates.toArray(new Predicate[predicates.size()]));
				final TypedQuery<GuardiaGrupo> typedQ = this.getEntityManager().createQuery(query);
				return typedQ.getResultList();
			} catch (final Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeGrupoTerminal", grupo);
			}
		}
		else{
			return new Vector<>();
		}
		return new Vector<>();
	}





}