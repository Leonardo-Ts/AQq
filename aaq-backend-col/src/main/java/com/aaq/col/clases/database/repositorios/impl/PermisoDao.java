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
import com.aaq.col.clases.database.entidades.Permiso;
import com.aaq.col.clases.database.entidades.abstracto.AbstractPermiso_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.PermisoDaoInterfase;

@org.springframework.stereotype.Repository(value = "permisoDao")
public class PermisoDao extends SIICAServerGenericDaoJpaImpl<Permiso> implements PermisoDaoInterfase {

	@Override
	public Permiso objetoPermiso(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Permiso.class, new Integer(id)) : null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoPermiso", id);
		}
		return null;
	}

	@Override
	public List<Permiso> listaDePermiso(final Perfil perfil) {
		if (perfil == null) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Permiso> query = builder.createQuery(Permiso.class);
			final Root<Permiso> root = query.from(Permiso.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.equal(root.get(AbstractPermiso_.perfil), perfil));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractPermiso_.modulo).get("moduloPadre")),
					builder.asc(root.get(AbstractPermiso_.modulo).get("nombrecorto")),
					builder.asc(root.get(AbstractPermiso_.modulo).get("nombre")));

			final TypedQuery<Permiso> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDePermiso", perfil);
		}
		return new Vector<>();
	}

}