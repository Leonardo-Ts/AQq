package com.aaq.col.clases.database.repositorios.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aaq.col.clases.database.entidades.FormatoNuevosVehiculos;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoNuevosVehiculos_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoNuevosVehiculosDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoNuevosVehiculos;

@org.springframework.stereotype.Repository(value = "formatoNuevosVehiculosDao")
public class FormatoNuevosVehiculosDao extends SIICAServerGenericDaoJpaImpl<FormatoNuevosVehiculos>
		implements FormatoNuevosVehiculosDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoNuevosVehiculos objetoFormatoNuevosVehiculos(String id) {
		FormatoNuevosVehiculos re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoNuevosVehiculos.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoNuevosVehiculos", id);
			log.error("Formatos Error=> objetoFormatoNuevosVehiculos=> " + id, e);

		}
		return re;
	}

	@Override
	public List<FormatoNuevosVehiculos> listaDeFormatoNuevosVehiculos() {
		TypedQuery<FormatoNuevosVehiculos> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoNuevosVehiculos> query = builder.createQuery(FormatoNuevosVehiculos.class);
			final Root<FormatoNuevosVehiculos> root = query.from(FormatoNuevosVehiculos.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoNuevosVehiculos_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoNuevosVehiculos_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoNuevosVehiculos_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoNuevosVehiculos", 500);
			log.error("Formatos Error=> listaDeFormatoNuevosVehiculos", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarNuevosVehiculos(

			String nvPlacas, Integer nvId,

			String nvAsegurado, String nvClaveAjustador, Integer nvDerivadaAuto,

			String nvEmail, Date nvFecha, Date nvFechaInspeccion, Integer nvFotoMotor, Integer nvFotoSerie,
			Timestamp nvHora, String nvKilometrosAuto, String nvModeloAuto, String nvMotorAuto,
			String nvNombreAjustador, String nvNombreCliente, String nvNumInciso, String nvNumPoliza,
			String nvNumReporte, String nvNumSerieAuto, String nvObservacionesAuto, String nvOficna,
			Integer nvProcedenciaAuto, String nvPuertasAuto, String nvSolicitante, String nvTelSolicitante,
			String nvTipoAuto, Integer nvTipoEmpleado, Integer nvTotalFotos, String nvTransmisionAuto,
			String nvUbicacion, String nvUnidadAuto, Integer enviadoEmail, ////
			String mensajeEmail, ///
			String nvDaniosPre, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaCliente, String firmaAgente

	) {
		String res = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_nuevvos1");

			nat.registerStoredProcedureParameter("in_nv_placas", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_id", Integer.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_nv_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_clave_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_derivada_auto", Integer.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_nv_email", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_fecha", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_fecha_inspeccion", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_foto_motor", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_foto_serie", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_hora", Timestamp.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_kilometros_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_modelo_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_motor_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_nombre_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_nombre_cliente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_num_inciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_num_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_num_serie_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_observaciones_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_oficna", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_procedencia_auto", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_puertas_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_solicitante", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_tel_solicitante", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_tipo_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_tipo_empleado", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_total_fotos", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_transmision_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_ubicacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nv_unidad_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_nvDaniosPre", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_nv_placas", nvPlacas);
			nat.setParameter("in_nv_id", nvId);

			nat.setParameter("in_nv_asegurado", nvAsegurado);
			nat.setParameter("in_nv_clave_ajustador", nvClaveAjustador);
			nat.setParameter("in_nv_derivada_auto", nvDerivadaAuto);

			nat.setParameter("in_nv_email", nvEmail);
			nat.setParameter("in_nv_fecha", nvFecha);
			nat.setParameter("in_nv_fecha_inspeccion", nvFechaInspeccion);
			nat.setParameter("in_nv_foto_motor", nvFotoMotor);
			nat.setParameter("in_nv_foto_serie", nvFotoSerie);
			nat.setParameter("in_nv_hora", nvHora);
			nat.setParameter("in_nv_kilometros_auto", nvKilometrosAuto);
			nat.setParameter("in_nv_modelo_auto", nvModeloAuto);
			nat.setParameter("in_nv_motor_auto", nvMotorAuto);
			nat.setParameter("in_nv_nombre_ajustador", nvNombreAjustador);
			nat.setParameter("in_nv_nombre_cliente", nvNombreCliente);
			nat.setParameter("in_nv_num_inciso", nvNumInciso);
			nat.setParameter("in_nv_num_poliza", nvNumPoliza);
			nat.setParameter("in_nv_num_reporte", nvNumReporte);
			nat.setParameter("in_nv_num_serie_auto", nvNumSerieAuto);
			nat.setParameter("in_nv_observaciones_auto", nvObservacionesAuto);
			nat.setParameter("in_nv_oficna", nvOficna);
			nat.setParameter("in_nv_procedencia_auto", nvProcedenciaAuto);
			nat.setParameter("in_nv_puertas_auto", nvPuertasAuto);
			nat.setParameter("in_nv_solicitante", nvSolicitante);
			nat.setParameter("in_nv_tel_solicitante", nvTelSolicitante);
			nat.setParameter("in_nv_tipo_auto", nvTipoAuto);
			nat.setParameter("in_nv_tipo_empleado", nvTipoEmpleado);
			nat.setParameter("in_nv_total_fotos", nvTotalFotos);
			nat.setParameter("in_nv_transmision_auto", nvTransmisionAuto);
			nat.setParameter("in_nv_ubicacion", nvUbicacion);
			nat.setParameter("in_nv_unidad_auto", nvUnidadAuto);
			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_nvDaniosPre", nvDaniosPre);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarNuevosVehiculos",

					nvPlacas, nvId,

					nvAsegurado, nvClaveAjustador, nvDerivadaAuto,

					nvEmail, nvFecha, nvFechaInspeccion, nvFotoMotor, nvFotoSerie, nvHora, nvKilometrosAuto,
					nvModeloAuto, nvMotorAuto, nvNombreAjustador, nvNombreCliente, nvNumInciso, nvNumPoliza,
					nvNumReporte, nvNumSerieAuto, nvObservacionesAuto, nvOficna, nvProcedenciaAuto, nvPuertasAuto,
					nvSolicitante, nvTelSolicitante, nvTipoAuto, nvTipoEmpleado, nvTotalFotos, nvTransmisionAuto,
					nvUbicacion, nvUnidadAuto, enviadoEmail, ////
					mensajeEmail, nvDaniosPre, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2,
					check3, check4, firmaCliente, firmaAgente

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarNuevosVehiculos =>" + nvNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return res;
	}

	@Override
	public String InsertarFormatoNuevosVehiculos(DatosInsertarFormatoNuevosVehiculos entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("NV_SOLICITANTE", entrada.getNv_Solicitante());
		entry.put("NV_OFICNA", entrada.getNv_Oficna());
		entry.put("NV_HORA", entrada.getNv_Hora());
		entry.put("NV_UBICACION", entrada.getNv_Ubicacion());
		entry.put("NV_EMAIL", entrada.getNv_Email());
		entry.put("NV_UNIDAD_AUTO", entrada.getNv_Unidad_Auto());
		entry.put("NV_TIPO_AUTO", entrada.getNv_Tipo_Auto());
		entry.put("NV_MODELO_AUTO", entrada.getNv_Modelo_Auto());
		entry.put("NV_MOTOR_AUTO", entrada.getNv_Motor_Auto());
		entry.put("NV_NUM_SERIE_AUTO", entrada.getNv_Num_Serie_Auto());
		entry.put("NV_KILOMETROS_AUTO", entrada.getNv_Kilometros_Auto());
		entry.put("NV_PUERTAS_AUTO", entrada.getNv_Puertas_Auto());
		entry.put("NV_TRANSMISION_AUTO", entrada.getNv_Transmision_Auto());
		entry.put("NV_OBSERVACIONES_AUTO", entrada.getNv_Observaciones_Auto());
		entry.put("NV_PROCEDENCIA_AUTO", entrada.getNv_Procedencia_Auto());
		entry.put("NV_DERIVADA_AUTO", entrada.getNv_Derivada_Auto());
		entry.put("NV_FOTO_SERIE", entrada.getNv_Foto_Serie());
		entry.put("NV_FOTO_MOTOR", entrada.getNv_Foto_Motor());
		entry.put("NV_TOTAL_FOTOS", entrada.getNv_Total_Fotos());
		entry.put("NV_FECHA_INSPECCION", entrada.getNv_Fecha_Inspeccion());
		entry.put("NV_TIPO_EMPLEADO", entrada.getNv_Tipo_Empleado());
		entry.put("NV_NOMBRE_CLIENTE", entrada.getNv_Nombre_Cliente());
		entry.put("NV_NOMBRE_AJUSTADOR", entrada.getNv_Nombre_Ajustador());
		entry.put("NV_TEL_SOLICITANTE", entrada.getNv_Tel_Solicitante());
		entry.put("NV_CLAVE_AJUSTADOR", entrada.getNv_Clave_Ajustador());
		entry.put("NV_NUM_REPORTE", entrada.getNv_Num_Reporte());
		entry.put("NV_NUM_POLIZA", entrada.getNv_Num_Poliza());
		entry.put("NV_NUM_INCISO", entrada.getNv_Num_Inciso());
		entry.put("NV_ASEGURADO", entrada.getNv_Asegurado());
		entry.put("NV_FECHA", entrada.getNv_Fecha());
		entry.put("NV_PLACAS", entrada.getNv_Placas());
		entry.put("NV_DANIOS_PRE", entrada.getNv_Danios_Pre());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_CLIENTE", entrada.getFirma_Cliente());
		entry.put("FIRMA_AGENTE", entrada.getFirma_Agente());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFNV(entry);
		return result;
	}

	@Override
	public String ejecutarFuncionWebserviceStoreFNV(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FNV");

		String[] columnas = new String[] { "NV_SOLICITANTE", "NV_OFICNA", "NV_HORA", "NV_UBICACION", "NV_EMAIL",
				"NV_UNIDAD_AUTO", "NV_TIPO_AUTO", "NV_MODELO_AUTO", "NV_MOTOR_AUTO", "NV_NUM_SERIE_AUTO",
				"NV_KILOMETROS_AUTO", "NV_PUERTAS_AUTO", "NV_TRANSMISION_AUTO", "NV_OBSERVACIONES_AUTO",
				"NV_PROCEDENCIA_AUTO", "NV_DERIVADA_AUTO", "NV_FOTO_SERIE", "NV_FOTO_MOTOR", "NV_TOTAL_FOTOS",
				"NV_FECHA_INSPECCION", "NV_TIPO_EMPLEADO", "NV_NOMBRE_CLIENTE", "NV_NOMBRE_AJUSTADOR",
				"NV_TEL_SOLICITANTE", "NV_CLAVE_AJUSTADOR", "NV_NUM_REPORTE", "NV_NUM_POLIZA", "NV_NUM_INCISO",
				"NV_ASEGURADO", "NV_FECHA", "NV_PLACAS", "NV_DANIOS_PRE", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4",
				"FIRMA_CLIENTE", "FIRMA_AGENTE","CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6" };

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(43, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(43));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_NUEVOS_VEHICULOS where NV_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);
			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
		}
		return consecutivo;

	}

}