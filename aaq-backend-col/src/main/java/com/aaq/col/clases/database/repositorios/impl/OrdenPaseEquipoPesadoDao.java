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

import com.aaq.col.clases.database.entidades.OrdenPaseEquipoPesado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractOrdenPaseEquipoPesado_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.OrdenPaseEquipoPesadoDaoInterfase;

@org.springframework.stereotype.Repository(value = "ordenPaseEquipoPesadoDao")
public class OrdenPaseEquipoPesadoDao extends SIICAServerGenericDaoJpaImpl<OrdenPaseEquipoPesado>
		implements OrdenPaseEquipoPesadoDaoInterfase {

	@Override
	public OrdenPaseEquipoPesado objetoOrdenPaseEquipoPesado(String id) {
		OrdenPaseEquipoPesado re = null;
		try {
			re = StringUtils.isNotBlank(id) ? this.getEntityManager().find(OrdenPaseEquipoPesado.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoOrdenPaseEquipoPesado", id);
		}
		return re;
	}

	@Override
	public String ejecutarFuncionInsertarPaseEquipoPesado(String usuario, String password, Date fechaHora,
			String numeroReporte, String tipoAtencion, String conductor, String telefonoConductor, String sumaAsegurada,
			String tipoDeducible, String porcentajeDeducible, String tipoProveedor, String claveProveedor,
			String responsableTaller, String telefonoTaller, String domicilioTaller, String marcaVehiculo,
			String modeloVehiculo, String serieVehiculo, String colorVehiculo, String placasVehiculo,
			Integer id_ajustador, String reporteNumeroPoliza) {

		String res = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_equipo1");

			nat.registerStoredProcedureParameter("in_usuario", String.class, ParameterMode.IN);
			// nat.registerStoredProcedureParameter("in_passwd", String.class,
			// ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fecha_hora", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo_atencion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_telefono_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_suma_asegurada", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo_deducible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_porcentaje_deducible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tipo_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_clave_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_responsable_taller", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_telefono_taller", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_domicilio_taller", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_marca_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_modelo_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_serie_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_color_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_placas_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_id_ajustador", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_reporte_numero_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_usuario", usuario);
			// nat.setParameter("in_passwd", passwd);
			nat.setParameter("in_fecha_hora", fechaHora);
			nat.setParameter("in_reporte", numeroReporte);
			nat.setParameter("in_tipo_atencion", tipoAtencion);
			nat.setParameter("in_conductor", conductor);
			nat.setParameter("in_telefono_conductor", telefonoConductor);
			nat.setParameter("in_suma_asegurada", sumaAsegurada);
			nat.setParameter("in_tipo_deducible", tipoDeducible);
			nat.setParameter("in_porcentaje_deducible", porcentajeDeducible);
			nat.setParameter("in_tipo_proveedor", tipoProveedor);
			nat.setParameter("in_clave_proveedor", claveProveedor);
			nat.setParameter("in_responsable_taller", responsableTaller);
			nat.setParameter("in_telefono_taller", telefonoTaller);
			nat.setParameter("in_domicilio_taller", domicilioTaller);
			nat.setParameter("in_marca_vehiculo", marcaVehiculo);
			nat.setParameter("in_modelo_vehiculo", modeloVehiculo);
			nat.setParameter("in_serie_vehiculo", serieVehiculo);
			nat.setParameter("in_color_vehiculo", colorVehiculo);
			nat.setParameter("in_placas_vehiculo", placasVehiculo);
			nat.setParameter("in_id_ajustador", id_ajustador);
			nat.setParameter("in_reporte_numero_poliza", reporteNumeroPoliza);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {

			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarEquipoPesado", usuario, password, fechaHora,
					numeroReporte, tipoAtencion, conductor, telefonoConductor, sumaAsegurada, tipoDeducible,
					porcentajeDeducible, tipoProveedor, claveProveedor, responsableTaller, telefonoTaller,
					domicilioTaller, marcaVehiculo, modeloVehiculo, serieVehiculo, colorVehiculo, placasVehiculo,
					reporteNumeroPoliza);

			return "ERROR: " + e.getMessage();
		}
		return res;

	}

	@Override
	public List<OrdenPaseEquipoPesado> listaDeOrdenPaseEquipoPesado() {
		TypedQuery<OrdenPaseEquipoPesado> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<OrdenPaseEquipoPesado> query = builder.createQuery(OrdenPaseEquipoPesado.class);
			final Root<OrdenPaseEquipoPesado> root = query.from(OrdenPaseEquipoPesado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractOrdenPaseEquipoPesado_.respuestaFtp), "OK!"),
					builder.isNull(root.get(AbstractOrdenPaseEquipoPesado_.respuestaFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractOrdenPaseEquipoPesado_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeOrdenPaseEquipoPesado", 500);
		}
		return typedQ.getResultList();
	}

}