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

import com.aaq.col.clases.database.entidades.CatalogoCodigoRespuestaBancario;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoCodigoRespuestaBancario_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoCodigoRespuestaBancarioDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoCodigoRespuestaBancarioDao")
public class CatalogoCodigoRespuestaBancarioDao extends SIICAServerGenericDaoJpaImpl<CatalogoCodigoRespuestaBancario>
		implements CatalogoCodigoRespuestaBancarioDaoInterfase {

	@Override
	public CatalogoCodigoRespuestaBancario objetoCatalogoCodigoRespuestaBancario(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoCodigoRespuestaBancario.class,
					new Integer(id)) : null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCodigoRespuestaBancario", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCodigoRespuestaBancario", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCodigoRespuestaBancario", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCodigoRespuestaBancario", id);
		}
		return null;
	}

	@Override
	public CatalogoCodigoRespuestaBancario objetoCatalogoCodigoRespuestaBancarioParaCodigo(final String codigoiso) {
		if (StringUtils.isBlank(codigoiso)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoCodigoRespuestaBancario> query = builder
					.createQuery(CatalogoCodigoRespuestaBancario.class);
			final Root<CatalogoCodigoRespuestaBancario> root = query.from(CatalogoCodigoRespuestaBancario.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoCodigoRespuestaBancario_.habilitado), Boolean.TRUE));
			predicates.add(builder.equal(root.get(AbstractCatalogoCodigoRespuestaBancario_.codigoiso), codigoiso));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoCodigoRespuestaBancario_.id)));
			final TypedQuery<CatalogoCodigoRespuestaBancario> typedQ = this.getEntityManager().createQuery(query);
			final List<CatalogoCodigoRespuestaBancario> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoRespuestaBancario", codigoiso);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoRespuestaBancario", codigoiso);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoRespuestaBancario", codigoiso);
		}
		return null;
	}

	@Override
	public List<CatalogoCodigoRespuestaBancario> listaDeCatalogoCodigoRespuestaBancario() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoCodigoRespuestaBancario> query = builder
					.createQuery(CatalogoCodigoRespuestaBancario.class);
			final Root<CatalogoCodigoRespuestaBancario> root = query.from(CatalogoCodigoRespuestaBancario.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoCodigoRespuestaBancario_.habilitado), Boolean.TRUE));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoCodigoRespuestaBancario_.codigoiso)));
			final TypedQuery<CatalogoCodigoRespuestaBancario> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoRespuestaBancario");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoRespuestaBancario");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoRespuestaBancario");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCodigoRespuestaBancario");
		}
		return new Vector<>();
	}

}