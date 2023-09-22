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

import com.aaq.col.clases.database.entidades.CatalogoClaveDeEntidad;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoClaveDeEntidad_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoClaveDeEntidadDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoClaveDeEntidadDao")
public class CatalogoClaveDeEntidadDao extends SIICAServerGenericDaoJpaImpl<CatalogoClaveDeEntidad> implements
		CatalogoClaveDeEntidadDaoInterfase {

	@Override
	public CatalogoClaveDeEntidad objetoCatalogoClaveDeEntidad(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoClaveDeEntidad.class,
					new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoClaveDeEntidad", id);
		}
		return null;
	}

	@Override
	public List<CatalogoClaveDeEntidad> listaDeCatalogoClaveDeEntidad() {
		return this.listaDeCatalogoClaveDeEntidad(null, false);
	}

	@Override
	public List<CatalogoClaveDeEntidad> listaDeCatalogoClaveDeEntidad(final String llave, final boolean soloConLlave) {

		if (StringUtils.isBlank(llave) && soloConLlave) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoClaveDeEntidad> query = builder.createQuery(CatalogoClaveDeEntidad.class);
			final Root<CatalogoClaveDeEntidad> root = query.from(CatalogoClaveDeEntidad.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoClaveDeEntidad_.habilitado), Boolean.TRUE));

			if (StringUtils.isNotBlank(llave)) {
				predicates.add(builder.like(builder.upper(root.get(AbstractCatalogoClaveDeEntidad_.descripcion)),
						StringUtils.upperCase("%" + llave + "%")));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoClaveDeEntidad_.clave)),
					builder.asc(root.get(AbstractCatalogoClaveDeEntidad_.descripcion)));
			final TypedQuery<CatalogoClaveDeEntidad> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoClaveDeEntidad", llave, new Boolean(soloConLlave));
		}
		return new Vector<>();
	}

}