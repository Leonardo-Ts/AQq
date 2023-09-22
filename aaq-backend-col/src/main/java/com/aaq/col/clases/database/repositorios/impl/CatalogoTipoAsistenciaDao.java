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

import com.aaq.col.clases.database.entidades.CatalogoTipoAsistencia;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoTipoAsistencia_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoTipoAsistenciaDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoTipoAsistenciaDao")
public class CatalogoTipoAsistenciaDao extends SIICAServerGenericDaoJpaImpl<CatalogoTipoAsistencia> implements
		CatalogoTipoAsistenciaDaoInterfase {

	@Override
	public CatalogoTipoAsistencia objetoCatalogoTipoAsistencia(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoTipoAsistencia.class,
					new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoTipoAsistencia", id);
		}

		return null;
	}

	@Override
	public List<CatalogoTipoAsistencia> listaDeCatalogoTipoAsistencia() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoTipoAsistencia> query = builder.createQuery(CatalogoTipoAsistencia.class);
			final Root<CatalogoTipoAsistencia> root = query.from(CatalogoTipoAsistencia.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoTipoAsistencia_.habilitado), Boolean.TRUE));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoTipoAsistencia_.descripcion)));
			final TypedQuery<CatalogoTipoAsistencia> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoTipoAsistencia");
		}
		return new Vector<>();
	}

}