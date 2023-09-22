package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.TransactionSystemException;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractEstado_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.EstadoDaoInterfase;

@org.springframework.stereotype.Repository(value = "estadoDao")
public class EstadoDao extends SIICAServerGenericDaoJpaImpl<Estado> implements EstadoDaoInterfase {

	@Override
	public Estado objetoEstado(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Estado.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoEstado", id);
		}
		return null;
	}
	
	@Override
	public Estado objetoEstadoNombre(final String nombre) {
			try {
				final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
				final CriteriaQuery<Estado> query = builder.createQuery(Estado.class);
				final Root<Estado> root = query.from(Estado.class);
				query.select(root);
				final List<Predicate> predicates = new ArrayList<>();

				if (StringUtils.isNotBlank(nombre)) {
					predicates.add(builder.equal(root.get(AbstractEstado_.nombre), nombre));
				}
				query.where(predicates.toArray(new Predicate[predicates.size()]));
				query.orderBy(builder.asc(root.get(AbstractEstado_.nombre)));
				final TypedQuery<Estado> typedQ = this.getEntityManager().createQuery(query);
				List<Estado> lista = typedQ.getResultList();
				if ((lista != null) && (lista.size() > 0)) {
					return lista.get(0);
				}
			
		} catch (final NoResultException | RollbackException | IndexOutOfBoundsException | IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoEstadoNombre", nombre);
		} catch (PersistenceException | IllegalStateException | DatabaseException | DataAccessException e) {
			this.documentarExcepcionParaMetodo(e, "objetoEstadoNombre", nombre);
		} catch (TransactionSystemException  e) {
			this.documentarExcepcionParaMetodo(e, "objetoEstadoNombre", nombre);
		}
			return null;
		
	}

	@Override
	public List<Estado> listaDeEstado() {
		return this.listaDeEstado(null, null, null);

	}

	@Override
	public List<Estado> listaDeEstado(final String nombre, final Integer identidad, final String orden) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Estado> query = builder.createQuery(Estado.class);
			final Root<Estado> root = query.from(Estado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(nombre)) {
				predicates.add(builder.equal(root.get(AbstractEstado_.nombre), nombre));
			}
			if (identidad != null) {
				predicates.add(builder.equal(root.get(AbstractEstado_.identidad), identidad));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractEstado_.nombre)));
			final TypedQuery<Estado> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeEstado", nombre, identidad, orden);
		}
		return new Vector<>();
	}

}