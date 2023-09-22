package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.aaq.col.clases.database.entidades.CatalogoRCBienes;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoRCBienes_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoRCBienesDaoInterfase;

@Repository("catalogoRCBienesDao")
public class CatalogoRCBienesDao extends SIICAServerGenericDaoJpaImpl<CatalogoRCBienes>
implements CatalogoRCBienesDaoInterfase {

	
	@Override
	public CatalogoRCBienes objetoCatalogoRCBienes(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoRCBienes.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoRCBienes", id);
		}
		return null;
	}

	@Override
	public List<CatalogoRCBienes> listaCatalogoRCBienes(final String clave, final String descripcion) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoRCBienes> query = builder.createQuery(CatalogoRCBienes.class);
			final Root<CatalogoRCBienes> root = query.from(CatalogoRCBienes.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(clave)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoRCBienes_.clave), clave));
			}
			if (StringUtils.isNotBlank(descripcion)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoRCBienes_.descripcion), descripcion));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoRCBienes_.clave)));
			final TypedQuery<CatalogoRCBienes> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoRCBienes", clave, descripcion);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoRCBienes", clave, descripcion);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoRCBienes", clave, descripcion);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoRCBienes", clave, descripcion);
		}
		return null;
	}
	

}
