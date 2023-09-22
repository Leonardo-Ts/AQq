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

import com.aaq.col.clases.database.entidades.CatalogoRoles;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoRoles_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CatalogoRolesDaoInterfase;


@org.springframework.stereotype.Repository(value = "catalogoRolesDao")
public class CatalogoRolesDao extends SIICAServerGenericDaoJpaImpl<CatalogoRoles> implements CatalogoRolesDaoInterfase {

	@Override
	public CatalogoRoles objetoRol(String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CatalogoRoles.class, new Integer(id)) : null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoRoles", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoRoles", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoRoles", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoCatalogoRoles", id);
		}
		return null;
	}

	@Override
	public List<CatalogoRoles> listaDeRoles() {
		return this.listaDeRoles(null, null);
	}

	@Override
	public List<CatalogoRoles> listaDeRoles(String nombre, String orden) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CatalogoRoles> query = builder.createQuery(CatalogoRoles.class);
			final Root<CatalogoRoles> root = query.from(CatalogoRoles.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(nombre)) {
				predicates.add(builder.equal(root.get(AbstractCatalogoRoles_.nombre), nombre));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractCatalogoRoles_.nombre)));
			final TypedQuery<CatalogoRoles> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeRoles", nombre, orden);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeRoles", nombre, orden);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeRoles", nombre, orden);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeRoles", nombre, orden);
		}
		return null;
	}

}