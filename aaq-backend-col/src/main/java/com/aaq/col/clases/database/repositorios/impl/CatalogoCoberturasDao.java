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

import com.aaq.col.clases.database.entidades.CatalogoCoberturas;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoCoberturas_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoCoberturasDaoInterfase;


@org.springframework.stereotype.Repository(value = "catalogoCoberturasDao")
public class CatalogoCoberturasDao extends SIICAServerGenericDaoJpaImpl<CatalogoCoberturas> implements
		CatalogoCoberturasDaoInterfase {

	@Override
	public CatalogoCoberturas objetoCatalogoCoberturasClave(String clave) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoCoberturas> query = builder.createQuery(CatalogoCoberturas.class);
			final Root<CatalogoCoberturas> root = query.from(CatalogoCoberturas.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractCatalogoCoberturas_.clave), clave));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoCoberturas_.id)));
			final TypedQuery<CatalogoCoberturas> typedQ = this.getEntityManager().createQuery(query);

			final List<CatalogoCoberturas> l = typedQ.getResultList();
			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoCoberturasClave", clave);
		}
		return null;
	}
	
	@Override
	public List<CatalogoCoberturas> listaDeCatalogoCoberturas(final String clave, final String descripcion) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoCoberturas> query = builder.createQuery(CatalogoCoberturas.class);
			final Root<CatalogoCoberturas> root = query.from(CatalogoCoberturas.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			
			if (StringUtils.isNotBlank(clave)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoCoberturas_.clave), clave));
			}
			if (StringUtils.isNotBlank(descripcion)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoCoberturas_.descripcion), descripcion));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoCoberturas_.clave)));
			final TypedQuery<CatalogoCoberturas> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCoberturas");
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCoberturas");
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCoberturas");
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCatalogoCoberturas");
		}
		return new Vector<>();
	}
}