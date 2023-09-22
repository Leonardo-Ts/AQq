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

import com.aaq.col.clases.database.entidades.OrdenPaseAmbulancia;
import com.aaq.col.clases.database.entidades.abstracto.AbstractOrdenPaseAmbulancia_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.OrdenPaseAmbulanciaDaoInterfase;

@org.springframework.stereotype.Repository(value = "ordenPaseAmbulanciaDao")
public class OrdenPaseAmbulanciaDao extends SIICAServerGenericDaoJpaImpl<OrdenPaseAmbulancia>
		implements OrdenPaseAmbulanciaDaoInterfase {

	@Override
	public OrdenPaseAmbulancia objetoOrdenPaseAmbulancia(String id) {
		OrdenPaseAmbulancia res = null;
		try {
			res = StringUtils.isNotBlank(id) ? this.getEntityManager().find(OrdenPaseAmbulancia.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoOrdenPaseAmbulancia", id);
		}
		return res;
	}

	@Override
	public String ejecutarFuncioninsertarValeAmbulancia(String usuario, String passwd, Date fechaHora, String reporte,
			String tipoAtencion, String claveHospital, String claveAmbulancia, String hospital,
			String direccionTraslado, String telefonoHospital, String nombreLesionado, String ubicacionLesionado,
			String edadLesionado, String sexoLesionado, String telefonoLesionado, String diagnostico,
			Integer id_ajustador, String reporteNumeroPoliza) {
		String re = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_insr_ambulanci1");

			nat.registerStoredProcedureParameter("in_usuario", String.class, ParameterMode.IN);
			// nat.registerStoredProcedureParameter("in_passwd", String.class,
			// ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fecha_hora", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo_atencion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_clave_hospital", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_clave_ambulancia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_hospital", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_direccionTraslado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_telefono_hospital", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nombre_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ubicacion_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_edad_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sexo_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_telefono_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_diagnostico", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_id_ajustador", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_reporte_numero_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_usuario", usuario);
			// nat.setParameter("in_passwd",passwd);
			nat.setParameter("in_fecha_hora", fechaHora);
			nat.setParameter("in_reporte", reporte);
			nat.setParameter("in_tipo_atencion", tipoAtencion);
			nat.setParameter("in_clave_hospital", claveHospital);
			nat.setParameter("in_clave_ambulancia", claveAmbulancia);
			nat.setParameter("in_hospital", hospital);
			nat.setParameter("in_direccionTraslado", direccionTraslado);
			nat.setParameter("in_telefono_hospital", telefonoHospital);
			nat.setParameter("in_nombre_lesionado", nombreLesionado);
			nat.setParameter("in_ubicacion_lesionado", ubicacionLesionado);
			nat.setParameter("in_edad_lesionado", edadLesionado);
			nat.setParameter("in_sexo_lesionado", sexoLesionado);
			nat.setParameter("in_telefono_lesionado", telefonoLesionado);
			nat.setParameter("in_diagnostico", diagnostico);
			nat.setParameter("in_id_ajustador", id_ajustador);
			nat.setParameter("in_reporte_numero_poliza", reporteNumeroPoliza);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			re = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarValeAmbulancia", usuario, passwd, fechaHora,
					reporte, tipoAtencion, claveHospital, claveAmbulancia, hospital, direccionTraslado,
					telefonoHospital, nombreLesionado, ubicacionLesionado, edadLesionado, sexoLesionado,
					telefonoLesionado, diagnostico, reporteNumeroPoliza);

			return "ERROR: " + e.getMessage();
		}
		return re;
	}

	@Override
	public List<OrdenPaseAmbulancia> listaDeOrdenPaseAmbulancia() {
		TypedQuery<OrdenPaseAmbulancia> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<OrdenPaseAmbulancia> query = builder.createQuery(OrdenPaseAmbulancia.class);
			final Root<OrdenPaseAmbulancia> root = query.from(OrdenPaseAmbulancia.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractOrdenPaseAmbulancia_.respuestaFtp), "OK!"),
					builder.isNull(root.get(AbstractOrdenPaseAmbulancia_.respuestaFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractOrdenPaseAmbulancia_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeOrdenPaseAmbulancia", 500);
		}
		return typedQ.getResultList();
	}

}