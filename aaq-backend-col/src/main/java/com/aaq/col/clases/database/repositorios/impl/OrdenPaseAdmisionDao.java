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

import com.aaq.col.clases.database.entidades.OrdenPaseAdmision;
import com.aaq.col.clases.database.entidades.abstracto.AbstractOrdenPaseAdmision_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.OrdenPaseAdmisionDaoInterfase;

@org.springframework.stereotype.Repository(value = "ordenPaseAdmisionDao")
public class OrdenPaseAdmisionDao extends SIICAServerGenericDaoJpaImpl<OrdenPaseAdmision>
		implements OrdenPaseAdmisionDaoInterfase {

	@Override
	public OrdenPaseAdmision objetoOrdenPaseAdmision(String id) {
		OrdenPaseAdmision re=null;

		try {
			re= StringUtils.isNotBlank(id) ? this.getEntityManager().find(OrdenPaseAdmision.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoOrdenPaseAdmision", id);
		}
		return re;
	}

	@Override
	public List<OrdenPaseAdmision> listaDeOrdenPaseAdmision() {
		 TypedQuery<OrdenPaseAdmision> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<OrdenPaseAdmision> query = builder.createQuery(OrdenPaseAdmision.class);
			final Root<OrdenPaseAdmision> root = query.from(OrdenPaseAdmision.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractOrdenPaseAdmision_.respuestaFtp), "OK!"),
					builder.isNull(root.get(AbstractOrdenPaseAdmision_.respuestaFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractOrdenPaseAdmision_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			//return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeOrdenPaseAdmision", 500);
		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarPaseAdmision(String usuario, String passwd, String reporte, Date fechaHora,
			String tipoOrden, String tipoAfectado, String conductor, String telefonoConductor, String oficina,
			String ubicacion, String tipoProveedor, String claveProveedor, String responsableTaller,
			String telefonoTaller, String domicilioTaller, String cobertura, String marcaVehiculo, String tipoVehiculo,
			String modeloVehiculo, String serieVehiculo, String colorVehiculo, String placasVehiculo,
			String danosPreexistentes, String danosSiniestro, Boolean deducible, String tipoDeducible,
			String sumaAsegurada, String porcentajeDeducible, String monto, String observaciones, Integer id_ajustador,
			String reportePolizaNumero) {
		String re=null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_admision1");

			nat.registerStoredProcedureParameter("in_usuario", String.class, ParameterMode.IN);
			// nat.registerStoredProcedureParameter("in_passwd", String.class,
			// ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fecha_hora", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_numero_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo_orden", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo_afectado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_telefono_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oficina", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ubicacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_clave_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_responsable_taller", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_telefono_taller", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_domicilio_taller", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_cobertura", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_marca_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipoVehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_modelo_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_serie_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_color_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_placas_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_danos_preexistentes", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_danos_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_deducible", Boolean.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo_deducible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_suma_asegurada", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_porcentaje_deducible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_monto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_observaciones", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_id_ajustador", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_reporte_poliza_numero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_usuario", usuario);
			// nat.setParameter("in_passwd",passwd);
			nat.setParameter("in_fecha_hora", fechaHora);
			nat.setParameter("in_numero_reporte", reporte);
			nat.setParameter("in_tipo_orden", tipoOrden);
			nat.setParameter("in_tipo_afectado", tipoAfectado);
			nat.setParameter("in_conductor", conductor);
			nat.setParameter("in_telefono_conductor", telefonoConductor);
			nat.setParameter("in_oficina", oficina);
			nat.setParameter("in_ubicacion", ubicacion);
			nat.setParameter("in_tipo_proveedor", tipoProveedor);
			nat.setParameter("in_clave_proveedor", claveProveedor);
			nat.setParameter("in_responsable_taller", responsableTaller);
			nat.setParameter("in_telefono_taller", telefonoTaller);
			nat.setParameter("in_domicilio_taller", domicilioTaller);
			nat.setParameter("in_cobertura", cobertura);
			nat.setParameter("in_marca_vehiculo", marcaVehiculo);
			nat.setParameter("in_tipoVehiculo", tipoVehiculo);
			nat.setParameter("in_modelo_vehiculo", modeloVehiculo);
			nat.setParameter("in_serie_vehiculo", serieVehiculo);
			nat.setParameter("in_color_vehiculo", colorVehiculo);
			nat.setParameter("in_placas_vehiculo", placasVehiculo);
			nat.setParameter("in_danos_preexistentes", danosPreexistentes);
			nat.setParameter("in_danos_siniestro", danosSiniestro);
			nat.setParameter("in_deducible", deducible);
			nat.setParameter("in_tipo_deducible", tipoDeducible);
			nat.setParameter("in_suma_asegurada", sumaAsegurada);
			nat.setParameter("in_porcentaje_deducible", porcentajeDeducible);
			nat.setParameter("in_monto", monto);
			nat.setParameter("in_observaciones", observaciones);
			nat.setParameter("in_id_ajustador", id_ajustador);
			nat.setParameter("in_reporte_poliza_numero", reportePolizaNumero);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			re= String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarPaseAdmision", usuario, passwd, fechaHora,
					tipoOrden, tipoAfectado, conductor, telefonoConductor, oficina, ubicacion, tipoProveedor,
					claveProveedor, responsableTaller, telefonoTaller, domicilioTaller, cobertura, marcaVehiculo,
					tipoVehiculo, modeloVehiculo, serieVehiculo, colorVehiculo, placasVehiculo, danosPreexistentes,
					danosSiniestro, deducible, tipoDeducible, sumaAsegurada, porcentajeDeducible, monto, observaciones,
					id_ajustador, reportePolizaNumero);

			return "ERROR: " + e.getMessage();
		}
		return re;
	}

}