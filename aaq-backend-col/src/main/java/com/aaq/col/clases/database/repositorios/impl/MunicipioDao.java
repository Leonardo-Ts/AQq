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

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Municipio;
import com.aaq.col.clases.database.entidades.abstracto.AbstractMunicipio_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.MunicipioDaoInterfase;

@org.springframework.stereotype.Repository(value = "municipioDao")
public class MunicipioDao extends SIICAServerGenericDaoJpaImpl<Municipio> implements MunicipioDaoInterfase {

	@Override
	public Municipio objetoMunicipio(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Municipio.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoMunicipio", id);
		}
		return null;
	}

	@Override
	public Municipio objetoMunicipio(final Estado estado, final String idmunicipio) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Municipio> query = builder.createQuery(Municipio.class);
			final Root<Municipio> root = query.from(Municipio.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractMunicipio_.estado), estado));
			}
			if (StringUtils.isNotBlank(idmunicipio)) {
				predicates.add(builder.equal(root.get(AbstractMunicipio_.idmunicipio), idmunicipio));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractMunicipio_.id)));
			final TypedQuery<Municipio> typedQ = this.getEntityManager().createQuery(query);
			final List<Municipio> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoMunicipio", estado, idmunicipio);
		}
		return null;
	}

	@Override
	public List<Municipio> listaDeMunicipios(final Estado estado) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Municipio> query = builder.createQuery(Municipio.class);
			final Root<Municipio> root = query.from(Municipio.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractMunicipio_.estado), estado));	
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractMunicipio_.nombre)));
			final TypedQuery<Municipio> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeMunicipio", estado);
		}
		return new Vector<>();
	}

}