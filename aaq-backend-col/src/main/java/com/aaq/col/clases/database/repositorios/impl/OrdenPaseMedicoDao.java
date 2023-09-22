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

import com.aaq.col.clases.database.entidades.OrdenPaseMedico;
import com.aaq.col.clases.database.entidades.abstracto.AbstractOrdenPaseMedico_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.OrdenPaseMedicoDaoInterfase;

@org.springframework.stereotype.Repository(value = "ordenPaseMedicoDao")
public class OrdenPaseMedicoDao extends SIICAServerGenericDaoJpaImpl<OrdenPaseMedico>
		implements OrdenPaseMedicoDaoInterfase {

	@Override
	public OrdenPaseMedico objetoOrdenPaseMedico(String id) {

		OrdenPaseMedico re = null;
		try {
			re = StringUtils.isNotBlank(id) ? this.getEntityManager().find(OrdenPaseMedico.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoOrdenPaseMedico", id);
		}
		return re;
	}

	@Override
	public String ejecutarFuncionInsertarPaseMedico(String usuario, String passwd, Date fechaHora, String reporte,
			String tipoAtencion, String numeroOcupantes, String numeroLesionados, String cobertura, String causasLesion,
			String identificacion, String nombreLesionado, String telefonoLesionado, String sexoLesionado,
			String edadLesionado, String tipoAtencionMedica, String lesionesAparentes, String tipoProveedor,
			String claveProveedor, String hospital, String telefonoHospital, String domicilioHospital,
			Integer id_ajustador, String reporteNumeroPoliza) {
		String respu = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_medico1");

			nat.registerStoredProcedureParameter("in_usuario", String.class, ParameterMode.IN);
			// nat.registerStoredProcedureParameter("in_passwd", String.class,
			// ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fecha_hora", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo_atencion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_ocupantes", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_lesionados", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_cobertura", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_causas_lesion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_identificacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nombre_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_telefono_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sexo_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_edad_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo_atencion_medica", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_lesiones_aparentes", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_clave_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_hospital", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_telefono_hospital", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_domicilio_hospital", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_id_ajustador", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_reporte_numero_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_usuario", usuario);
			// nat.setParameter("in_passwd",passwd);
			nat.setParameter("in_fecha_hora", fechaHora);
			nat.setParameter("in_numero_reporte", reporte);
			nat.setParameter("in_tipo_atencion", tipoAtencion);
			nat.setParameter("in_numero_ocupantes", numeroOcupantes);
			nat.setParameter("in_numero_lesionados", numeroLesionados);
			nat.setParameter("in_cobertura", cobertura);
			nat.setParameter("in_causas_lesion", causasLesion);
			nat.setParameter("in_identificacion", identificacion);
			nat.setParameter("in_nombre_lesionado", nombreLesionado);
			nat.setParameter("in_telefono_lesionado", telefonoLesionado);
			nat.setParameter("in_sexo_lesionado", sexoLesionado);
			nat.setParameter("in_edad_lesionado", edadLesionado);
			nat.setParameter("in_tipo_atencion_medica", tipoAtencionMedica);
			nat.setParameter("in_lesiones_aparentes", lesionesAparentes);
			nat.setParameter("in_tipo_proveedor", tipoProveedor);
			nat.setParameter("in_clave_proveedor", claveProveedor);
			nat.setParameter("in_hospital", hospital);
			nat.setParameter("in_telefono_hospital", telefonoHospital);
			nat.setParameter("in_domicilio_hospital", domicilioHospital);
			nat.setParameter("in_reporte_numero_poliza", reporteNumeroPoliza);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			respu = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarPaseMedico", usuario, passwd, fechaHora,
					reporte, tipoAtencion, numeroOcupantes, numeroLesionados, cobertura, causasLesion, identificacion,
					nombreLesionado, telefonoLesionado, sexoLesionado, edadLesionado, tipoAtencionMedica,
					lesionesAparentes, tipoProveedor, claveProveedor, hospital, telefonoHospital, domicilioHospital,
					reporteNumeroPoliza);

			return "ERROR: " + e.getMessage();
		}
		return respu;
	}

	@Override
	public List<OrdenPaseMedico> listaDeOrdenPaseMedico() {
		TypedQuery<OrdenPaseMedico> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<OrdenPaseMedico> query = builder.createQuery(OrdenPaseMedico.class);
			final Root<OrdenPaseMedico> root = query.from(OrdenPaseMedico.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractOrdenPaseMedico_.respuestaFtp), "OK!"),
					builder.isNull(root.get(AbstractOrdenPaseMedico_.respuestaFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractOrdenPaseMedico_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeOrdenPaseMedico", 500);
		}
		return typedQ.getResultList();
	}

}