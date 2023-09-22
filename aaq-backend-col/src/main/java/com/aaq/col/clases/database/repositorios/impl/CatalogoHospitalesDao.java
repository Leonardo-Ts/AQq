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

import com.aaq.col.clases.database.entidades.CatalogoHospitales;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoHospitales_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoHospitalesDaoInterfase;

@Repository("catalogoHospitalesDao")
public class CatalogoHospitalesDao extends SIICAServerGenericDaoJpaImpl<CatalogoHospitales> implements CatalogoHospitalesDaoInterfase{

	@Override
	public CatalogoHospitales objetoCatalogoHospitales(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoHospitales.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoHospitales", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoHospitales", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoHospitales", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoHospitales", id);
		}
		return null;
	}

	@Override
	public List<CatalogoHospitales> listaDeCatalogoHospitales(final String clave) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoHospitales> query = builder.createQuery(CatalogoHospitales.class);
			final Root<CatalogoHospitales> root = query.from(CatalogoHospitales.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.isNotBlank(clave)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoHospitales_.clave), clave));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoHospitales_.id)));
			final TypedQuery<CatalogoHospitales> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoHospitales");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoHospitales");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoHospitales");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoHospitales");
		}
		return new Vector<>();
	}
	
}
