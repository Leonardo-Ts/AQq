package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.UsuarioAlertas;
import com.aaq.col.clases.database.entidades.abstracto.AbstractUsuarioAlertas_;
import com.aaq.col.clases.database.entidades.abstracto.AbstractUsuario_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.UsuarioAlertasDaoInterfase;


@org.springframework.stereotype.Repository(value = "usuarioAlertasDao")
public class UsuarioAlertasDao extends SIICAServerGenericDaoJpaImpl<UsuarioAlertas> implements UsuarioAlertasDaoInterfase {

	/** filtro **/
	public static String filtroTiempoLibre = "filtroTiempoLibre";
	
	/** filtro **/
	public static String filtroTiempoOcupado = "filtroTiempoOcupado";
	
	/** filtro **/
	public static String filtroArriboPostTiempo = "filtroArriboPostTiempo";
	
	/** filtro **/
	public static String filtroLogin = "filtroLogin";
	
	/** filtro **/
	public static String filtroLogout = "filtroLogout";
	
	/** filtro **/
	public static String filtroNoDisponibles = "filtroNoDisponibles";
	
	@Override
	public UsuarioAlertas objetoUsuarioAlertas(String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(UsuarioAlertas.class, new Integer(id)) : null;
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioAlertas", id);
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioAlertas", id);
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioAlertas", id);
		}
		return null;
	}

	@Override
	public UsuarioAlertas objetoUsuarioAlertasParaUsuario(Usuario usuario) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<UsuarioAlertas> query = builder.createQuery(UsuarioAlertas.class);
			final Root<UsuarioAlertas> root = query.from(UsuarioAlertas.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (usuario != null) {
				predicates.add(builder.equal(root.get(AbstractUsuarioAlertas_.usuario), usuario));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			final TypedQuery<UsuarioAlertas> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getSingleResult();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioAlertasParaUsuario");
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioAlertasParaUsuario");
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioAlertasParaUsuario");
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "objetoUsuarioAlertasParaUsuario");
		}
		return null;
	}

	@Override
	public List<UsuarioAlertas> usuarioAlertaParaFrecuencia(Frecuencia frecuencia, String filtroAlerta) {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<UsuarioAlertas> query = builder.createQuery(UsuarioAlertas.class);
			final Root<UsuarioAlertas> root = query.from(UsuarioAlertas.class);
			final Join<UsuarioAlertas, Usuario> usuario = root.join(AbstractUsuarioAlertas_.usuario);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.equals(filtroAlerta, UsuarioAlertasDao.filtroTiempoLibre)) {
				predicates.add(builder.equal(root.get(AbstractUsuarioAlertas_.tiempoLibre), Boolean.TRUE));
			}			
			if (StringUtils.equals(filtroAlerta, UsuarioAlertasDao.filtroTiempoOcupado)) {
				predicates.add(builder.equal(root.get(AbstractUsuarioAlertas_.tiempoOcupado), Boolean.TRUE));
			}
			if (StringUtils.equals(filtroAlerta, UsuarioAlertasDao.filtroArriboPostTiempo)) {
				predicates.add(builder.equal(root.get(AbstractUsuarioAlertas_.arriboPostTiempo), Boolean.TRUE));
			}
			if (StringUtils.equals(filtroAlerta, UsuarioAlertasDao.filtroLogin)) {
				predicates.add(builder.equal(root.get(AbstractUsuarioAlertas_.login), Boolean.TRUE));
			}
			if (StringUtils.equals(filtroAlerta, UsuarioAlertasDao.filtroLogout)) {
				predicates.add(builder.equal(root.get(AbstractUsuarioAlertas_.logout), Boolean.TRUE));
			}
			if (StringUtils.equals(filtroAlerta, UsuarioAlertasDao.filtroNoDisponibles)) {
				predicates.add(builder.equal(root.get(AbstractUsuarioAlertas_.noDisponibles), Boolean.TRUE));
				predicates.add(builder.equal(usuario.get(AbstractUsuario_.habilitado), Boolean.TRUE));
			}
			
			if(frecuencia != null) {
				predicates.add(builder.equal(usuario.get(AbstractUsuario_.frecuencia), frecuencia));
				predicates.add(builder.equal(usuario.get(AbstractUsuario_.habilitado), Boolean.TRUE));
			}
						
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			
			final TypedQuery<UsuarioAlertas> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final NoResultException e) {
			this.documentarExcepcionParaMetodo(e, "usuarioAlertaParaFrecuencia");
		} catch (final IllegalArgumentException e) {
			this.documentarExcepcionParaMetodo(e, "usuarioAlertaParaFrecuencia");
		} catch (final IllegalStateException e) {
			this.documentarExcepcionParaMetodo(e, "usuarioAlertaParaFrecuencia");
		} catch (final PersistenceException e) {
			this.documentarExcepcionParaMetodo(e, "usuarioAlertaParaFrecuencia");
		}
		return new Vector<>();
	}

}
