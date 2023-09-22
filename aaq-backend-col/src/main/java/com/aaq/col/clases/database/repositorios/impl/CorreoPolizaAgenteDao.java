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

import com.aaq.col.clases.database.entidades.CorreoPolizaAgente;
import com.aaq.col.clases.database.entidades.abstracto.AbstractCorreoPolizaAgente_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.CorreoPolizaAgenteDaoInterfase;

@org.springframework.stereotype.Repository(value = "correoPolizaAgenteDao")
public class CorreoPolizaAgenteDao extends SIICAServerGenericDaoJpaImpl<CorreoPolizaAgente> implements CorreoPolizaAgenteDaoInterfase {

	@Override
	public CorreoPolizaAgente objetoCorreoPolizaAgente(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(CorreoPolizaAgente.class, new Integer(id)) : null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoEstado", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoEstado", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoEstado", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoEstado", id);
		}
		return null;
	}

	@Override
	public List<CorreoPolizaAgente> listaDeCorreoPolizaAgente() {
		return this.listaDeCorreoPolizaAgente(null, null);

	}

	@Override
	public List<CorreoPolizaAgente> listaDeCorreoPolizaAgente(final String poliza, final String claveAgente) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<CorreoPolizaAgente> query = builder.createQuery(CorreoPolizaAgente.class);
			final Root<CorreoPolizaAgente> root = query.from(CorreoPolizaAgente.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(poliza)) {
				predicates.add(builder.equal(root.get(AbstractCorreoPolizaAgente_.poliza), poliza));
			}
			if (StringUtils.isNotBlank(claveAgente)) {
				predicates.add(builder.equal(root.get(AbstractCorreoPolizaAgente_.claveAgente), claveAgente));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			if(StringUtils.isNotBlank(poliza)) {
			query.orderBy(builder.asc(root.get(AbstractCorreoPolizaAgente_.poliza)));
			} else if(StringUtils.isNotBlank(claveAgente)) {
				query.orderBy(builder.asc(root.get(AbstractCorreoPolizaAgente_.claveAgente)));
			}
			
			final TypedQuery<CorreoPolizaAgente> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCorreoPolizaAgente", poliza, claveAgente);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCorreoPolizaAgente", poliza, claveAgente);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCorreoPolizaAgente", poliza, claveAgente);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeCorreoPolizaAgente", poliza, claveAgente);
		}
		return new Vector<>();
	}

}