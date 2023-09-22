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

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFrecuenciaBase_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FrecuenciaBaseDaoInterfase;

@org.springframework.stereotype.Repository(value = "frecuenciaBaseDao")
public class FrecuenciaBaseDao extends SIICAServerGenericDaoJpaImpl<FrecuenciaBase> implements
		FrecuenciaBaseDaoInterfase {

	@Override
	public FrecuenciaBase objetoFrecuenciaBase(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(FrecuenciaBase.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoFrecuenciaBase", id);
		}
		return null;
	}

	@Override
	public List<FrecuenciaBase> listaDeFrecuenciaBase(final Frecuencia frecuencia) {
		return this.listaDeFrecuenciaBase(frecuencia, null);
	}

	@Override
	public List<FrecuenciaBase> listaDeFrecuenciaBase(final Base base) {
		return this.listaDeFrecuenciaBase(null, base);
	}
	
	private List<FrecuenciaBase> listaDeFrecuenciaBase(Frecuencia frecuencia, Base base){
		if(frecuencia != null || base != null){
			try {
				final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
				final CriteriaQuery<FrecuenciaBase> query = builder.createQuery(FrecuenciaBase.class);
				final Root<FrecuenciaBase> root = query.from(FrecuenciaBase.class);
				query.select(root);
				final List<Predicate> predicates = new ArrayList<>();
				
				if (frecuencia != null) {
					predicates.add(builder.equal(root.get(AbstractFrecuenciaBase_.frecuencia), frecuencia));
				}
				
				if (base != null) {
					predicates.add(builder.equal(root.get(AbstractFrecuenciaBase_.base), base));
				}
				
				predicates.add(builder.equal(root.get(AbstractFrecuenciaBase_.base).get("habilitado"), Boolean.TRUE));
				
				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.asc(root.get(AbstractFrecuenciaBase_.base).get("nombre")));
				final TypedQuery<FrecuenciaBase> typedQ = this.getEntityManager().createQuery(query);
				return typedQ.getResultList();
			} catch (final Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeFrecuenciaBase", frecuencia);
			}
		}
		else{
			return new Vector<>();
		}
		return new Vector<>();
	}
	
	@Override
	public List<FrecuenciaBase> listaDeFrecuenciaBaseGH(final Frecuencia frecuencia) {
		if(frecuencia != null ){
			try {
				final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
				final CriteriaQuery<FrecuenciaBase> query = builder.createQuery(FrecuenciaBase.class);
				final Root<FrecuenciaBase> root = query.from(FrecuenciaBase.class);
				query.select(root);
				final List<Predicate> predicates = new ArrayList<>();
				
				if (frecuencia != null) {
					predicates.add(builder.equal(root.get(AbstractFrecuenciaBase_.frecuencia), frecuencia));
				}
				
				predicates.add(builder.equal(root.get(AbstractFrecuenciaBase_.base).get("habilitado"), Boolean.TRUE));
				
				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.asc(root.get(AbstractFrecuenciaBase_.base).get("estado").get("nombre")));
				final TypedQuery<FrecuenciaBase> typedQ = this.getEntityManager().createQuery(query);
				return typedQ.getResultList();
			} catch (final Exception e) {
				this.documentarExcepcionParaMetodo(e, "listaDeFrecuenciaBase", frecuencia);
			}
		}
		else{
			return new Vector<>();
		}
		return new Vector<>();
	}

}