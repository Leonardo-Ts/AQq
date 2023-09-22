package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.aaq.col.clases.database.entidades.CatalogoCodigoResponsabilidad;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoCodigoResponsabilidad_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoCodigoResponsabilidadDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoCodigoResponsabilidadDao")
public class CatalogoCodigoResponsabilidadDao extends SIICAServerGenericDaoJpaImpl<CatalogoCodigoResponsabilidad> implements
		CatalogoCodigoResponsabilidadDaoInterfase {

	@Override
	public CatalogoCodigoResponsabilidad objetoCatalogoCodigoResponsabilidadClave(String codigo) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoCodigoResponsabilidad> query = builder.createQuery(CatalogoCodigoResponsabilidad.class);
			final Root<CatalogoCodigoResponsabilidad> root = query.from(CatalogoCodigoResponsabilidad.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoCodigoResponsabilidad_.codigo), codigo));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoCodigoResponsabilidad_.id)));
			final TypedQuery<CatalogoCodigoResponsabilidad> typedQ = this.getEntityManager().createQuery(query);

			final List<CatalogoCodigoResponsabilidad> l = typedQ.getResultList();
			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCodigoResponsabilidadClave", codigo);
		}
		return null;
	}
}