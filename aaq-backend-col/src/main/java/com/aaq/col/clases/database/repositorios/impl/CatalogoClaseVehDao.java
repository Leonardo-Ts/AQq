package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.aaq.col.clases.database.entidades.CatalogoClaseVeh;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoClaseVeh_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoClaseVehDaoInterfase;

@Repository("catalogoClaseVehDao")
public class CatalogoClaseVehDao extends SIICAServerGenericDaoJpaImpl<CatalogoClaseVeh> implements CatalogoClaseVehDaoInterfase{


	@Override
	public CatalogoClaseVeh objetoCatalogoClaseVeh(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoClaseVeh.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoClaseVeh", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoClaseVeh", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoClaseVeh", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoClaseVeh", id);
		}
		return null;
	}


	
	@Override
	public List<CatalogoClaseVeh> listaDeCatalogoClaseVeh(final String clave, final String descripcion) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoClaseVeh> query = builder.createQuery(CatalogoClaseVeh.class);
			final Root<CatalogoClaseVeh> root = query.from(CatalogoClaseVeh.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.isNotBlank(clave)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoClaseVeh_.clave), clave));
			}
			if (StringUtils.isNotBlank(descripcion)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoClaseVeh_.descripcion), descripcion));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoClaseVeh_.clave)));
			final TypedQuery<CatalogoClaseVeh> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoClaseVeh");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoClaseVeh");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoClaseVeh");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoClaseVeh");
		}
		return new Vector<>();
	}



}
