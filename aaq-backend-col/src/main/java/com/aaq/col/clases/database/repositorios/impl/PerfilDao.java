package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.abstracto.AbstractPerfil_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.PerfilDaoInterfase;

@org.springframework.stereotype.Repository(value = "perfilDao")
public class PerfilDao extends SIICAServerGenericDaoJpaImpl<Perfil> implements PerfilDaoInterfase {

	@Override
	public Perfil objetoPerfil(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Perfil.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoPerfil", id);
		}
		return null;
	}

	@Override
	public List<Perfil> listaDePerfil() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Perfil> query = builder.createQuery(Perfil.class);
			final Root<Perfil> root = query.from(Perfil.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractPerfil_.habilitado), Boolean.TRUE));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractPerfil_.nombre)));
			final TypedQuery<Perfil> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDePerfil");
		}
		return new Vector<>();
	}

}