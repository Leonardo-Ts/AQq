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
import org.apache.commons.lang3.math.NumberUtils;

import com.aaq.col.clases.database.entidades.Colonia;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractColonia_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ColoniaDaoInterfase;


@org.springframework.stereotype.Repository(value = "coloniaDao")
public class ColoniaDao extends SIICAServerGenericDaoJpaImpl<Colonia> implements ColoniaDaoInterfase {

	@Override
	public Colonia objetoColonia(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Colonia.class, new Integer(id)) : null;
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoColonia", id);
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoColonia", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoColonia", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoColonia", id);
		}
		return null;
	}

	@Override
	public Colonia objetoColonia(final String idcolonia, final String idmunicipio) {
		if (StringUtils.isBlank(idmunicipio) || StringUtils.isBlank(idmunicipio)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Colonia> query = builder.createQuery(Colonia.class);
			final Root<Colonia> root = query.from(Colonia.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractColonia_.idcolonia),
					new Integer(NumberUtils.toInt(idcolonia))));
			predicates.add(builder.equal(root.get(AbstractColonia_.idmunicipio),
					new Integer(NumberUtils.toInt(idmunicipio))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractColonia_.id)));
			final TypedQuery<Colonia> typedQ = this.getEntityManager().createQuery(query);
			final List<Colonia> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoColonia", idcolonia, idmunicipio);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoColonia", idcolonia, idmunicipio);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoColonia", idcolonia, idmunicipio);
		} 
		return null;
	}

	@Override
	public List<Colonia> listaDeColonia(final Estado estado, final String idmunicipio) {
		if ((estado == null) || StringUtils.isBlank(idmunicipio)) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Colonia> query = builder.createQuery(Colonia.class);
			final Root<Colonia> root = query.from(Colonia.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractColonia_.estado), estado));
			predicates.add(builder.equal(root.get(AbstractColonia_.idmunicipio),
					new Integer(NumberUtils.toInt(idmunicipio))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractColonia_.nombre)));
			final TypedQuery<Colonia> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeColonia", estado, idmunicipio);
		}  catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeColonia", estado, idmunicipio);
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeColonia", estado, idmunicipio);
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeColonia", estado, idmunicipio);
		}
		return new Vector<>();
	}
}