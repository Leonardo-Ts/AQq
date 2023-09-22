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
import com.aaq.col.clases.database.entidades.CatalogoProveedorAsistenciaIdentificador;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoProveedorAsistenciaIdentificador_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoProveedorAsistenciaIdentificadorDaoInterfase;


@org.springframework.stereotype.Repository(value = "catalogoProveedorAsistenciaIdentificadorDao")
public class CatalogoProveedorAsistenciaIdentificadorDao extends
		SIICAServerGenericDaoJpaImpl<CatalogoProveedorAsistenciaIdentificador> implements
		CatalogoProveedorAsistenciaIdentificadorDaoInterfase {

	@Override
	public CatalogoProveedorAsistenciaIdentificador objetoCatalogoProveedorAsistenciaIdentificador(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(
					CatalogoProveedorAsistenciaIdentificador.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoProveedorAsistenciaIdentificador", id);
		}
		return null;
	}

	@Override
	public CatalogoProveedorAsistenciaIdentificador objetoCatalogoProveedorAsistenciaIdentificadorParaNumero(
			final Integer numero) {

		if (numero == null) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoProveedorAsistenciaIdentificador> query = builder
					.createQuery(CatalogoProveedorAsistenciaIdentificador.class);
			final Root<CatalogoProveedorAsistenciaIdentificador> root = query
					.from(CatalogoProveedorAsistenciaIdentificador.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractCatalogoProveedorAsistenciaIdentificador_.numero), numero));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoProveedorAsistenciaIdentificador_.id)));
			final TypedQuery<CatalogoProveedorAsistenciaIdentificador> typedQ = this.getEntityManager().createQuery(
					query);

			final List<CatalogoProveedorAsistenciaIdentificador> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoProveedorAsistenciaIdentificadorParaNumero", numero);
		}
		return null;
	}

	@Override
	public List<CatalogoProveedorAsistenciaIdentificador> listaDeCatalogoProveedorAsistenciaIdentificador(
			final CatalogoProveedorAsistencia prov) {

		if (prov == null) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoProveedorAsistenciaIdentificador> query = builder
					.createQuery(CatalogoProveedorAsistenciaIdentificador.class);
			final Root<CatalogoProveedorAsistenciaIdentificador> root = query
					.from(CatalogoProveedorAsistenciaIdentificador.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(
					root.get(AbstractCatalogoProveedorAsistenciaIdentificador_.catalogoProveedorAsistencia), prov));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoProveedorAsistenciaIdentificador_.numero)));
			final TypedQuery<CatalogoProveedorAsistenciaIdentificador> typedQ = this.getEntityManager().createQuery(
					query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoProveedorAsistenciaIdentificador", prov);
		}
		return new Vector<>();
	}

}