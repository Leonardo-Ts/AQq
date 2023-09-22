package com.aaq.col.clases.database.repositorios.impl;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.abstracto.AbstractConfiguracion_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ConfiguracionDaoInterfase;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/**
 * @author mfernandez Aug 8, 2014 10:22:44 PM mfernandez
 */
@org.springframework.stereotype.Repository(value = "configuracionDao")
public class ConfiguracionDao extends SIICAServerGenericDaoJpaImpl<Configuracion> implements ConfiguracionDaoInterfase {

	@Override
	public Configuracion objetoConfiguracion(final String id) {
		try {
			return StringUtils.isNotBlank(id) ? this.getEntityManager().find(Configuracion.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoConfiguracion", id);
		}
		return null;
	}

	@Override
	public boolean obtenerBooleano(final String llave) {
		if (StringUtils.isBlank(llave)) {
			return false;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Configuracion> query = builder.createQuery(Configuracion.class);
			final Root<Configuracion> root = query.from(Configuracion.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractConfiguracion_.llave), llave));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractConfiguracion_.id)));
			final TypedQuery<Configuracion> typedQ = this.getEntityManager().createQuery(query);
			final Configuracion cnf = typedQ.getSingleResult();
			if (cnf != null) {
				return BooleanUtils.toBoolean(cnf.getValor());
			}

		} catch (final NoResultException e) {
			return false;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "obtenerBooleano", llave);
		}
		return false;
	}

	@Override
	public int obtenerEntero(final String llave) {
		if (StringUtils.isBlank(llave)) {
			return 0;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Configuracion> query = builder.createQuery(Configuracion.class);
			final Root<Configuracion> root = query.from(Configuracion.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractConfiguracion_.llave), llave));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractConfiguracion_.id)));
			final TypedQuery<Configuracion> typedQ = this.getEntityManager().createQuery(query);

			final Configuracion cnf = typedQ.getSingleResult();
			if (cnf != null) {
				return NumberUtils.toInt(cnf.getValor());
			}
		} catch (final NoResultException e) {
			return 0;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "obtenerEntero", llave);
		}
		return 0;
	}

	@Override
	public double obtenerDoble(final String llave) {
		if (StringUtils.isBlank(llave)) {
			return 0;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Configuracion> query = builder.createQuery(Configuracion.class);
			final Root<Configuracion> root = query.from(Configuracion.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractConfiguracion_.llave), llave));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractConfiguracion_.id)));
			final TypedQuery<Configuracion> typedQ = this.getEntityManager().createQuery(query);
			final Configuracion cnf = typedQ.getSingleResult();

			if (cnf != null) {
				return NumberUtils.toDouble(cnf.getValor());
			}
		} catch (final NoResultException e) {
			return 0;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "obtenerDoble", llave);
		}
		return 0;
	}

	@Override
	public String obtenerCadena(final String llave) {
		if (StringUtils.isBlank(llave)) {
			return null;
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Configuracion> query = builder.createQuery(Configuracion.class);
			final Root<Configuracion> root = query.from(Configuracion.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractConfiguracion_.llave), llave));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractConfiguracion_.id)));

			final TypedQuery<Configuracion> typedQ = this.getEntityManager().createQuery(query);
			final Configuracion cnf = typedQ.getSingleResult();

			if (cnf != null) {
				return cnf.getValor();
			}
		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "obtenerCadena", llave);
		}
		return null;
	}

	@Override
	public List<Configuracion> listaDeConfiguracion() {
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<Configuracion> query = builder.createQuery(Configuracion.class);
			final Root<Configuracion> root = query.from(Configuracion.class);
			query.select(root);
			query.orderBy(builder.asc(root.get(AbstractConfiguracion_.nombre)));
			final TypedQuery<Configuracion> typedQ = this.getEntityManager().createQuery(query);
			return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeConfiguracion");
		}
		return new Vector<>();
	}

	@Override
	public String obtenerUltimoId(final String tabla) {
		if (StringUtils.isBlank(tabla)) {
			return null;
		}

		try {
			return Objects.toString(this.getEntityManager().createNativeQuery("SELECT MAX(id) -1 FROM " + tabla)
					.getSingleResult());

		} catch (final Exception ex) {
			this.getLogger().error("obtenerUltimoId", ex);
		}
		return null;
	}

}