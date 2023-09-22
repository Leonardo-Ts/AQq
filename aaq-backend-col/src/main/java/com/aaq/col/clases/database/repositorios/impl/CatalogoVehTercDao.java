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

import com.aaq.col.clases.database.entidades.CatalogoVehTerc;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoVehTerc_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoVehTercDaoInterfase;

@org.springframework.stereotype.Repository(value = "catalogoVehTercDao")
public class CatalogoVehTercDao extends SIICAServerGenericDaoJpaImpl<CatalogoVehTerc> implements CatalogoVehTercDaoInterfase {

	@Override
	public CatalogoVehTerc objetoCatalogoVehTerc(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoVehTerc.class, new Integer(id))
					: null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoVehTerc", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoVehTerc", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoVehTerc", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoVehTerc", id);
		}
		return null;
	}

	@Override
	public List<CatalogoVehTerc> listaDeCatalogoVehTerc(final String clave, final String descripcion) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoVehTerc> query = builder.createQuery(CatalogoVehTerc.class);
			final Root<CatalogoVehTerc> root = query.from(CatalogoVehTerc.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			if (StringUtils.isNotBlank(clave)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoVehTerc_.clave), clave));
			}
			if (StringUtils.isNotBlank(descripcion)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoVehTerc_.descripcion), descripcion));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoVehTerc_.descripcion)));
			final TypedQuery<CatalogoVehTerc> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoVehTerc");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoVehTerc");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoVehTerc");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoVehTerc");
		}
		return new Vector<>();
	}
}
