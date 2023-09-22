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

import com.aaq.col.clases.database.entidades.CatalogoPartesAuto;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoPartesAuto_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoPartesAutoDaoInterfase;

@Repository("catalogoPartesAutoDao")
public class CatalogoPartesAutoDao extends SIICAServerGenericDaoJpaImpl<CatalogoPartesAuto>
	implements CatalogoPartesAutoDaoInterfase {

	@Override
	public CatalogoPartesAuto objetoCatalogoPartesAuto(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoPartesAuto.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoPartesAuto", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoPartesAuto", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoPartesAuto", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoPartesAuto", id);
		}
		return null;
	}

	@Override
	public List<CatalogoPartesAuto> listaDeCatalogoPartesAuto(final String tipoParte, final String numParte, final String nombreParte) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoPartesAuto> query = builder.createQuery(CatalogoPartesAuto.class);
			final Root<CatalogoPartesAuto> root = query.from(CatalogoPartesAuto.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.isNotBlank(numParte)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoPartesAuto_.numParte), numParte));
			}
			if (StringUtils.isNotBlank(tipoParte)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoPartesAuto_.tipoParte), tipoParte));
			}
			if (StringUtils.isNotBlank(nombreParte)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoPartesAuto_.nombreParte), nombreParte));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoPartesAuto_.id)));
			final TypedQuery<CatalogoPartesAuto> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoPartesAuto");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoPartesAuto");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoPartesAuto");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoPartesAuto");
		}
		return new Vector<>();
	}
	
}
