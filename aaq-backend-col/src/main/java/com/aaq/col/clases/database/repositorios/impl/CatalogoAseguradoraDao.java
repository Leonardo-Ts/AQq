package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.CatalogoAseguradora;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoAseguradora_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoAseguradoraDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoAseguradoraDao")
public class CatalogoAseguradoraDao extends SIICAServerGenericDaoJpaImpl<CatalogoAseguradora> implements
		CatalogoAseguradoraDaoInterfase {

	@Override
	public CatalogoAseguradora objetoCatalogoAseguradora(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager()
					.find(CatalogoAseguradora.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoAseguradora", id);
		}
		return null;
	}

	@Override
	public List<CatalogoAseguradora> listaCatalogoAseguradora(String clave, String descripcion) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoAseguradora> query = builder.createQuery(CatalogoAseguradora.class);
			final Root<CatalogoAseguradora> root = query.from(CatalogoAseguradora.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			if (StringUtils.isNotBlank(clave)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoAseguradora_.clave), clave));	
			}
			if (StringUtils.isNotBlank(descripcion)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoAseguradora_.descripcion), descripcion));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoAseguradora_.clave)));
			final TypedQuery<CatalogoAseguradora> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoAseguradoraClave", clave);
		}
		return null;
	}
	
	@Override
	public CatalogoAseguradora objetoCatalogoAseguradoraClave(String clave) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoAseguradora> query = builder.createQuery(CatalogoAseguradora.class);
			final Root<CatalogoAseguradora> root = query.from(CatalogoAseguradora.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoAseguradora_.clave), clave));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoAseguradora_.id)));
			final TypedQuery<CatalogoAseguradora> typedQ = this.getEntityManager().createQuery(query);

			final List<CatalogoAseguradora> l = typedQ.getResultList();
			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoAseguradoraClave", clave);
		}
		return null;
	}
}