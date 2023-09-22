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

import com.aaq.col.clases.database.entidades.CatalogoTramoCar;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoTramoCar_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoTramoCarDaoInterfase;

@Repository("catalogoTramoCarDao")
public class CatalogoTramoCarDao extends SIICAServerGenericDaoJpaImpl<CatalogoTramoCar> implements CatalogoTramoCarDaoInterfase{

	@Override
	public CatalogoTramoCar objetoCatalogoTramoCar(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoTramoCar.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoTramoCar", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoTramoCar", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoTramoCar", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoTramoCar", id);
		}
		return null;
	}


	
	@Override
	public List<CatalogoTramoCar> listaDeCatalogoTramoCar(final String clave, final String descripcion) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoTramoCar> query = builder.createQuery(CatalogoTramoCar.class);
			final Root<CatalogoTramoCar> root = query.from(CatalogoTramoCar.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.isNotBlank(clave)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoTramoCar_.clave), clave));
			}
			if (StringUtils.isNotBlank(descripcion)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoTramoCar_.descripcion), descripcion));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoTramoCar_.clave)));
			final TypedQuery<CatalogoTramoCar> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoTramoCar");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoTramoCar");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoTramoCar");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoTramoCar");
		}
		return new Vector<>();
	}
}
