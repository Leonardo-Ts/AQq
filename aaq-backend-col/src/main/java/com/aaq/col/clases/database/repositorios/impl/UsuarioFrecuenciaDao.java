package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.UsuarioFrecuencia;
import com.aaq.col.clases.database.entidades.abstracto.AbstractUsuarioFrecuencia_;
import com.aaq.col.clases.database.entidades.abstracto.AbstractUsuario_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.UsuarioFrecuenciaDaoInterfase;

@org.springframework.stereotype.Repository(value = "usuarioFrecuenciaDao")
public class UsuarioFrecuenciaDao extends SIICAServerGenericDaoJpaImpl<UsuarioFrecuencia> implements
		UsuarioFrecuenciaDaoInterfase {

	@Override
	public UsuarioFrecuencia objetoUsuarioFrecuencia(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(UsuarioFrecuencia.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioFrecuencia", id);
		}
		return null;
	}

	@Override
	public List<UsuarioFrecuencia> listaDeUsuarioFrecuencia(final Usuario usuario) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<UsuarioFrecuencia> query = builder.createQuery(UsuarioFrecuencia.class);
			final Root<UsuarioFrecuencia> root = query.from(UsuarioFrecuencia.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (usuario != null) {
				predicates.add(builder.equal(root.get(AbstractUsuarioFrecuencia_.usuario), usuario));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractUsuarioFrecuencia_.frecuenciaBase)));
			final TypedQuery<UsuarioFrecuencia> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeUsuarioFrecuencia");
		}
		return new Vector<>();
	}

//	@Override
//	public JMResultadoOperacion eliminarObjeto(UsuarioFrecuencia arg0) {
//		return null;
//	}

//	@Override
//	public JMResultadoOperacion guardarObjeto(UsuarioFrecuencia arg0) {
//		return null;
//	}

	@Override
	public List<UsuarioFrecuencia> listaDeUsuarioFrecuenciaEncuesta(Frecuencia frecuencia, Usuario usuario) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<UsuarioFrecuencia> query = builder.createQuery(UsuarioFrecuencia.class);
			final Root<UsuarioFrecuencia> root = query.from(UsuarioFrecuencia.class);
			final Join<UsuarioFrecuencia, Usuario> usua = root.join(AbstractUsuarioFrecuencia_.usuario);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if(frecuencia != null) {
				predicates.add(builder.equal(usua.get(AbstractUsuario_.frecuencia), frecuencia));
				predicates.add(builder.equal(usua.get(AbstractUsuario_.habilitado), Boolean.TRUE));
			}
						
				query.where(predicates.toArray(new Predicate[predicates.size()]));
			final TypedQuery<UsuarioFrecuencia> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "usuarioFrecuencia");
		}
		return new Vector<>();
	}

}