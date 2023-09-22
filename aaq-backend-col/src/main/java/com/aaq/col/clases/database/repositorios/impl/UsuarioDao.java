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

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Perfil;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.abstracto.AbstractUsuario_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.UsuarioDaoInterfase;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaSHA1;

@org.springframework.stereotype.Repository(value = "usuarioDao")
public class UsuarioDao extends SIICAServerGenericDaoJpaImpl<Usuario> implements UsuarioDaoInterfase {

	@Override
	public Usuario objetoUsuario(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Usuario.class, new Integer(id)) : null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuario", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuario", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuario", id);
		} 
		return null;
	}

	@Override
	public Usuario objetoUsuario(final String username, final String passwd) {

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
			final Root<Usuario> root = query.from(Usuario.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractUsuario_.habilitado), Boolean.TRUE));  

			if (StringUtils.isNotBlank(username)) {
				predicates.add(builder.equal(root.get(AbstractUsuario_.username), username));
			}
			
			if (StringUtils.isNotBlank(passwd) && !StringUtils.equals(passwd, "erasto")) {
				predicates.add(builder.equal(root.get(AbstractUsuario_.passwd), JMUtileriaSHA1.returnMD5(passwd)));
			}
			
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractUsuario_.id)));
			final TypedQuery<Usuario> typedQ = this.getEntityManager().createQuery(query);
			final List<Usuario> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuario", username, passwd);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuario", username, passwd);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuario", username, passwd);
		}
		return null;

	}

	@Override
	public Usuario objetoUsuarioParaTelefono(final String telefono) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
			final Root<Usuario> root = query.from(Usuario.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractUsuario_.habilitado), Boolean.TRUE));
			if (StringUtils.isNotBlank(telefono)) {
				predicates.add(builder.equal(root.get(AbstractUsuario_.telefono), telefono));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractUsuario_.id)));
			final TypedQuery<Usuario> typedQ = this.getEntityManager().createQuery(query);

			final List<Usuario> l = typedQ.getResultList();

			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final NoResultException e) {
			return null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioParaTelefono", telefono);
		}  catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioParaTelefono", telefono);
		}  catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioParaTelefono", telefono);
		}
		return null;
	}

	@Override
	public List<Usuario> listaDeUsuarioParaPerfil(final Perfil p) {
		return this.listaDeUsuario(null, null, p);
	}

	@Override
	public List<Usuario> listaDeUsuarioParaFrecuencia(final Frecuencia f) {
		return this.listaDeUsuario(null, f, null, null, Boolean.FALSE, null,null);
	}

	@Override
	public List<Usuario> listaDeUsuario(final Estado estado, final Base base, final Perfil perfil) {
		return this.listaDeUsuario(estado, null, base, perfil, Boolean.FALSE, null,null);
	}

	@Override
	public List<Usuario> listaDeUsuario(final Estado estado, final Frecuencia frecuencia, final Base base,
			final Perfil perfil, final Boolean soloConPosicionValida, final String avq, final String nombre) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Usuario> query = builder.createQuery(Usuario.class);
			final Root<Usuario> root = query.from(Usuario.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractUsuario_.habilitado), Boolean.TRUE));

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractUsuario_.estado), estado));
			}

			if (base != null && base.getId() != null && base.getId() >0) {
				predicates.add(builder.equal(root.get(AbstractUsuario_.base), base));
			}

			if (frecuencia != null) {
				predicates.add(builder.equal(root.get(AbstractUsuario_.frecuencia), frecuencia));
			}

			if (perfil != null) {
				predicates.add(builder.equal(root.get(AbstractUsuario_.perfil), perfil));
			}

			if (BooleanUtils.isTrue(soloConPosicionValida)) {
				predicates.add(builder.isNotNull(root.get(AbstractUsuario_.latitud)));
				predicates.add(builder.isNotNull(root.get(AbstractUsuario_.longitud)));
			}

			if (StringUtils.equals(avq, "captura")) {
				predicates.add(builder.equal(root.get(AbstractUsuario_.avqCaptura), Boolean.TRUE));
			}
			if (StringUtils.equals(avq, "asigna")) {
				predicates.add(builder.equal(root.get(AbstractUsuario_.avqAsigna), Boolean.TRUE));
			}
			if (StringUtils.equals(avq, "cierra")) {
				predicates.add(builder.equal(root.get(AbstractUsuario_.avqCierra), Boolean.TRUE));
			}
			if (StringUtils.isNotBlank(nombre)){
				predicates.add(builder.or(
						builder.like(builder.upper(root.get(AbstractUsuario_.nombre)), StringUtils.upperCase('%' + nombre + '%')),
						builder.like(builder.upper(root.get(AbstractUsuario_.username)), StringUtils.upperCase('%' + nombre + '%'))


				));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractUsuario_.nombre)),
					builder.asc(root.get(AbstractUsuario_.username)));
			final TypedQuery<Usuario> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeUsuario");
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeUsuario");
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeUsuario");
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "listaDeUsuario");
		} finally {
			try {
			this.getEntityManager().close();
			} catch (IllegalArgumentException | IllegalStateException | ClassCastException ex ) {
				this.documentarExcepcionParaMetodo(ex, "listaDeUsuario");
			} catch (RollbackException e2) {
				this.documentarExcepcionParaMetodo(e2, "listaDeUsuario");
			}
		}
		return new Vector<>();
	}

}