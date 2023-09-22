package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistencia;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoProveedorAsistencia_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoProveedorAsistenciaDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoProveedorAsistenciaDao")
public class CatalogoProveedorAsistenciaDao extends SIICAServerGenericDaoJpaImpl<CatalogoProveedorAsistencia> implements
		CatalogoProveedorAsistenciaDaoInterfase {

	@Override
	public CatalogoProveedorAsistencia objetoCatalogoProveedorAsistencia(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoProveedorAsistencia.class,
					new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoProveedorAsistencia", id);
		}
		return null;
	}

	@Override
	public CatalogoProveedorAsistencia objetoCatalogoProveedorAsistenciaParaUserYPassword(final String username,
			final String passwd) {

		if (StringUtils.isBlank(username) && StringUtils.isBlank(passwd)) {
			return null;
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoProveedorAsistencia> query = builder
					.createQuery(CatalogoProveedorAsistencia.class);
			final Root<CatalogoProveedorAsistencia> root = query.from(CatalogoProveedorAsistencia.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoProveedorAsistencia_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractCatalogoProveedorAsistencia_.passwd), passwd));
			predicates.add(builder.equal(root.get(AbstractCatalogoProveedorAsistencia_.usuario), username));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoProveedorAsistencia_.id)));
			final TypedQuery<CatalogoProveedorAsistencia> typedQ = this.getEntityManager().createQuery(query);
			final List<CatalogoProveedorAsistencia> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoProveedorAsistencia", username, passwd);
		}
		return null;
	}

	@Override
	public List<CatalogoProveedorAsistencia> listaDeCatalogoProveedorAsistencia(final Estado estado) {
		if (estado == null) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoProveedorAsistencia> query = builder
					.createQuery(CatalogoProveedorAsistencia.class);
			final Root<CatalogoProveedorAsistencia> root = query.from(CatalogoProveedorAsistencia.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoProveedorAsistencia_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractCatalogoProveedorAsistencia_.estado), estado));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoProveedorAsistencia_.nombreComercial)));
			final TypedQuery<CatalogoProveedorAsistencia> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoProveedorAsistencia", estado);
		}
		return new Vector<>();
	}

}