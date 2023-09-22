package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.OrdenPaseReclamacion;
import com.aaq.col.clases.database.entidades.abstracto.AbstractOrdenPaseReclamacion_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.OrdenPaseReclamacionDaoInterfase;

@org.springframework.stereotype.Repository(value = "ordenPaseReclamacionDao")
public class OrdenPaseReclamacionDao extends SIICAServerGenericDaoJpaImpl<OrdenPaseReclamacion>
		implements OrdenPaseReclamacionDaoInterfase {

	@Override
	public OrdenPaseReclamacion objetoOrdenPaseReclamacion(String id) {

		return StringUtils.isNotBlank(id) ? this.getEntityManager().find(OrdenPaseReclamacion.class, new Integer(id))
				: null;

	}

	@Override
	public String ejecutarFuncionInsertarPaseReclamacion(String usuario, String passwd, Date fechaHora, String reporte,
			String documentosFaltantes, String observaciones, Integer id_ajustador, String reporteNumeroPoliza) {
		String res = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inse_reclamac1");

			nat.registerStoredProcedureParameter("in_usuario", String.class, ParameterMode.IN);
			// nat.registerStoredProcedureParameter("in_passwd", String.class,
			// ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fecha_hora", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_documentos_faltantes", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_observaciones", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_id_ajustador", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_reporte_numero_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_usuario", usuario);
			// nat.setParameter("in_passwd", passwd);
			nat.setParameter("in_fecha_hora", fechaHora);
			nat.setParameter("in_reporte", reporte);
			nat.setParameter("in_documentos_faltantes", documentosFaltantes);
			nat.setParameter("in_observaciones", observaciones);
			nat.setParameter("in_id_ajustador", id_ajustador);
			nat.setParameter("in_reporte_numero_poliza", reporteNumeroPoliza);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarReclamaciones", usuario, passwd, fechaHora,
					reporte, documentosFaltantes, observaciones, reporteNumeroPoliza);

			return "ERROR: " + e.getMessage();
		}
		return res;
	}

	@Override
	public List<OrdenPaseReclamacion> listaDeOrdenPaseReclamacion() {
		TypedQuery<OrdenPaseReclamacion> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<OrdenPaseReclamacion> query = builder.createQuery(OrdenPaseReclamacion.class);
			final Root<OrdenPaseReclamacion> root = query.from(OrdenPaseReclamacion.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractOrdenPaseReclamacion_.respuestaFtp), "OK!"),
					builder.isNull(root.get(AbstractOrdenPaseReclamacion_.respuestaFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractOrdenPaseReclamacion_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeOrdenPaseReclamacion", 500);
		}
		return typedQ.getResultList();
	}

}