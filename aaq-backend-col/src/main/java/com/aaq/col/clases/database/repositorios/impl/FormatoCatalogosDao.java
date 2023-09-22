package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.FormatoCatalogos;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoCatalogos_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoCatalogosDaoInterfase;

@org.springframework.stereotype.Repository(value = "formatoCatalogosDao")
public class FormatoCatalogosDao extends SIICAServerGenericDaoJpaImpl<FormatoCatalogos>
		implements FormatoCatalogosDaoInterfase {

	@Override
	public FormatoCatalogos objetoFormatoCatalogos(String id) {
		FormatoCatalogos re = null;
		try {
			re = StringUtils.isNotBlank(id) ? this.getEntityManager().find(FormatoCatalogos.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoFormatoCatalogos", id);
		}
		return re;
	}

	@Override
	public List<FormatoCatalogos> listaDeFormatoCatalogos() {
		TypedQuery<FormatoCatalogos> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoCatalogos> query = builder.createQuery(FormatoCatalogos.class);
			final Root<FormatoCatalogos> root = query.from(FormatoCatalogos.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoCatalogos_.id), 100),
					builder.isNull(root.get(AbstractFormatoCatalogos_.id))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoCatalogos_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(10000);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFormatoCatalogos", 500);
		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarCatalogos(

			String nombre, String valores

	) {
		String sa = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_catalogos1");

			nat.registerStoredProcedureParameter("in_id", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nombre", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_catalogos", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_nombre", nombre);
			nat.setParameter("in_catalogos", valores);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			sa = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarCatalogos", nombre, valores);

			return "ERROR: " + e.getMessage();
		}
		return sa;
	}
	
	@Override
	public List<FormatoCatalogos> listaDeFormatoCatalogos(final String nombre) {
		TypedQuery<FormatoCatalogos> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoCatalogos> query = builder.createQuery(FormatoCatalogos.class);
			final Root<FormatoCatalogos> root = query.from(FormatoCatalogos.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (StringUtils.isNotBlank(nombre)) {
				predicates.add(builder.equal(root.get(AbstractFormatoCatalogos_.nombre), nombre));
			}
			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoCatalogos_.id), 100),
					builder.isNull(root.get(AbstractFormatoCatalogos_.id))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoCatalogos_.nombre)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(10000);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFormatoCatalogos", 500);
		}
		return typedQ.getResultList();
	}
}
