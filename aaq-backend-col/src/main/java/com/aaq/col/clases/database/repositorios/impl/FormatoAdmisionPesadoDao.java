package com.aaq.col.clases.database.repositorios.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
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

import com.aaq.col.clases.database.entidades.FormatoAdmisionPesado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoAdmisionPesado_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoAdmisionPesadoDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoAdmisionPesado;


@org.springframework.stereotype.Repository(value = "formatoAdmisionPesadoDao")
public class FormatoAdmisionPesadoDao extends SIICAServerGenericDaoJpaImpl<FormatoAdmisionPesado>
		implements FormatoAdmisionPesadoDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoAdmisionPesado objetoFormatoAdmisionPesado(String id) {
		FormatoAdmisionPesado re = null;
		try {
			re = StringUtils.isNotBlank(id) ? this.getEntityManager().find(FormatoAdmisionPesado.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			log.error("Formatos Error=> objetoFormatoAdmisionPesado=> " + id, e);
		}
		return re;
	}

	@Override
	public List<FormatoAdmisionPesado> listaDeFormatoAdmisionPesado() {
		TypedQuery<FormatoAdmisionPesado> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoAdmisionPesado> query = builder.createQuery(FormatoAdmisionPesado.class);
			final Root<FormatoAdmisionPesado> root = query.from(FormatoAdmisionPesado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoAdmisionPesado_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoAdmisionPesado_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoAdmisionPesado_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoAdmisionPesado", 500);
			log.error("Formatos Error=> listaDeFormatoAdmisionPesado", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarAdmisionPesado(

			String opTelAsegurado, String opSiniestroCaja, String opNumEndoso, String opPlacasAutoAfe,
			String opNomAjustador, String opSerieAutoAfe, String opColorAutoAfe, String opNomTaller, String opModeloTer,
			Timestamp ofFecha, String opMotorAutoAse, String opMarcaAutoAfe, String opPlacasAutoAse,
			String opDaniosTanque, String opDirTaller, String opConductorAfe, String opCantidad, String opNumReporte,

			String opSiniestroTanque, String opTelTaller, String opFolioElectro, String opColorAutoAse,
			String opAsegurado, String opClaveAjustador, String opMarcaAutoAse, String opDedDias,
			String opAtencionTaller, String opDefinicion, String opDaniosCamion, String opSumaAsegurado,
			String opSerieAutoAse, String opTipoAutoAse, String opModeloAse, String opNumSiniestro,
			Timestamp opVigencia, String opNumPoliza, String opDaniosCaja, String opTelConAfe, Integer opTipoDeducible,

			String opNumInciso, Integer opDeducible, String opTipoAutoAfe, Integer opDedAdmin, String opSiniestroCamion,

			String opNomAsegurado, Integer opId, String opConductorAse, String opNomAfe, String opTelConAse,
			String opTelAfe,

			String opMotorAutoAfe, String emailDefault, Integer enviadoEmail, ////
			String mensajeEmail, ///
			String opEmailTercero,

			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado, String niu

	) {
		String res = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_admisionAutos1");

			nat.registerStoredProcedureParameter("in_opTelAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opSiniestroCaja", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opNumEndoso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opPlacasAutoAfe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opNomAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opSerieAutoAfe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opColorAutoAfe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opNomTaller", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opModeloTer", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ofFecha", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opMotorAutoAse", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opMarcaAutoAfe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opPlacasAutoAse", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opDaniosTanque", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opDirTaller", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opConductorAfe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opCantidad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opNumReporte", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_opSiniestroTanque", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opTelTaller", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opFolioElectro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opColorAutoAse", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opClaveAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opMarcaAutoAse", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opDedDias", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opAtencionTaller", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opDefinicion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opDaniosCamion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opSumaAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opSerieAutoAse", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opTipoAutoAse", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opModeloAse", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opNumSiniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opVigencia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opNumPoliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opDaniosCaja", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opTelConAfe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opTipoDeducible", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_opNumInciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opDeducible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opTipoAutoAfe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opDedAdmin", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opSiniestroCamion", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_opNomAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opId", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opConductorAse", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opNomAfe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opTelConAse", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_opTelAfe", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_opMotorAutoAfe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_emailDefault", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///

			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_niu", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.registerStoredProcedureParameter("in_opEmailTercero", String.class, ParameterMode.IN);

			nat.setParameter("in_opTelAsegurado", opTelAsegurado);
			nat.setParameter("in_opSiniestroCaja", opSiniestroCaja);
			nat.setParameter("in_opNumEndoso", opNumEndoso);
			nat.setParameter("in_opPlacasAutoAfe", opPlacasAutoAfe);
			nat.setParameter("in_opNomAjustador", opNomAjustador);
			nat.setParameter("in_opSerieAutoAfe", opSerieAutoAfe);
			nat.setParameter("in_opColorAutoAfe", opColorAutoAfe);
			nat.setParameter("in_opNomTaller", opNomTaller);
			nat.setParameter("in_opModeloTer", opModeloTer);
			nat.setParameter("in_ofFecha", ofFecha);
			nat.setParameter("in_opMotorAutoAse", opMotorAutoAse);
			nat.setParameter("in_opMarcaAutoAfe", opMarcaAutoAfe);
			nat.setParameter("in_opPlacasAutoAse", opPlacasAutoAse);
			nat.setParameter("in_opDaniosTanque", opDaniosTanque);
			nat.setParameter("in_opDirTaller", opDirTaller);
			nat.setParameter("in_opConductorAfe", opConductorAfe);
			nat.setParameter("in_opCantidad", opCantidad);
			nat.setParameter("in_opNumReporte", opNumReporte);

			nat.setParameter("in_opSiniestroTanque", opSiniestroTanque);
			nat.setParameter("in_opTelTaller", opTelTaller);
			nat.setParameter("in_opFolioElectro", opFolioElectro);
			nat.setParameter("in_opColorAutoAse", opColorAutoAse);
			nat.setParameter("in_opAsegurado", opAsegurado);
			nat.setParameter("in_opClaveAjustador", opClaveAjustador);
			nat.setParameter("in_opMarcaAutoAse", opMarcaAutoAse);
			nat.setParameter("in_opDedDias", opDedDias);
			nat.setParameter("in_opAtencionTaller", opAtencionTaller);
			nat.setParameter("in_opDefinicion", opDefinicion);
			nat.setParameter("in_opDaniosCamion", opDaniosCamion);
			nat.setParameter("in_opSumaAsegurado", opSumaAsegurado);
			nat.setParameter("in_opSerieAutoAse", opSerieAutoAse);
			nat.setParameter("in_opTipoAutoAse", opTipoAutoAse);
			nat.setParameter("in_opModeloAse", opModeloAse);
			nat.setParameter("in_opNumSiniestro", opNumSiniestro);
			nat.setParameter("in_opVigencia", opVigencia);
			nat.setParameter("in_opNumPoliza", opNumPoliza);
			nat.setParameter("in_opDaniosCaja", opDaniosCaja);
			nat.setParameter("in_opTelConAfe", opTelConAfe);
			nat.setParameter("in_opTipoDeducible", opTipoDeducible);

			nat.setParameter("in_opNumInciso", opNumInciso);
			nat.setParameter("in_opDeducible", opDeducible);
			nat.setParameter("in_opTipoAutoAfe", opTipoAutoAfe);
			nat.setParameter("in_opDedAdmin", opDedAdmin);
			nat.setParameter("in_opSiniestroCamion", opSiniestroCamion);

			nat.setParameter("in_opNomAsegurado", opNomAsegurado);
			nat.setParameter("in_opId", opId);
			nat.setParameter("in_opConductorAse", opConductorAse);
			nat.setParameter("in_opNomAfe", opNomAfe);
			nat.setParameter("in_opTelConAse", opTelConAse);
			nat.setParameter("in_opTelAfe", opTelAfe);

			nat.setParameter("in_opMotorAutoAfe", opMotorAutoAfe);
			nat.setParameter("in_emailDefault", emailDefault);
			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);
			nat.setParameter("in_niu", niu);
			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarAdmisionPesado",

					opTelAsegurado, opSiniestroCaja, opNumEndoso, opPlacasAutoAfe, opNomAjustador, opSerieAutoAfe,
					opColorAutoAfe, opNomTaller, opModeloTer, ofFecha, opMotorAutoAse, opMarcaAutoAfe, opPlacasAutoAse,
					opDaniosTanque, opDirTaller, opConductorAfe, opCantidad, opNumReporte,

					opSiniestroTanque, opTelTaller, opFolioElectro, opColorAutoAse, opAsegurado, opClaveAjustador,
					opMarcaAutoAse, opDedDias, opAtencionTaller, opDefinicion, opDaniosCamion, opSumaAsegurado,
					opSerieAutoAse, opTipoAutoAse, opModeloAse, opNumSiniestro, opVigencia, opNumPoliza, opDaniosCaja,
					opTelConAfe, opTipoDeducible,

					opNumInciso, opDeducible, opTipoAutoAfe, opDedAdmin, opSiniestroCamion,

					opNomAsegurado, opId, opConductorAse, opNomAfe, opTelConAse, opTelAfe,

					opMotorAutoAfe, emailDefault, enviadoEmail, ////
					mensajeEmail, ////
					proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaAjustador,
					firmaAsegurado, niu

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarAdmisionPesado =>" + opNumReporte, e);
			return "ERROR: " + e.getMessage();
		}
		return res;
	}

	@Override
	public String InsertarFormatoAdmisionPesado(DatosInsertarFormatoAdmisionPesado entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("OP_FOLIO_ELECTRO", entrada.getOp_Folio_Electro());
		entry.put("OP_NUM_REPORTE", entrada.getOp_Num_Reporte());
		entry.put("OP_NUM_SINIESTRO", entrada.getOp_Num_Siniestro());
		entry.put("OP_NUM_POLIZA", entrada.getOp_Num_Poliza());
		entry.put("OP_NUM_INCISO", entrada.getOp_Num_Inciso());
		entry.put("OP_NUM_ENDOSO", entrada.getOp_Num_Endoso());
		entry.put("OP_VIGENCIA", entrada.getOp_Vigencia());
		entry.put("OP_NOM_ASEGURADO", entrada.getOp_Nom_Asegurado());
		entry.put("OP_TEL_ASEGURADO", entrada.getOp_Tel_Asegurado());
		entry.put("OP_CONDUCTOR_ASE", entrada.getOp_Conductor_Ase());
		entry.put("OP_TEL_CON_ASE", entrada.getOp_Tel_Con_Ase());
		entry.put("OP_MARCA_AUTO_ASE", entrada.getOp_Marca_Auto_Ase());
		entry.put("OP_TIPO_AUTO_ASE", entrada.getOp_Tipo_Auto_Ase());
		entry.put("OP_COLOR_AUTO_ASE", entrada.getOp_Color_Auto_Ase());
		entry.put("OP_PLACAS_AUTO_ASE", entrada.getOp_Placas_Auto_Ase());
		entry.put("OP_MOTOR_AUTO_ASE", entrada.getOp_Motor_Auto_Ase());
		entry.put("OP_SERIE_AUTO_ASE", entrada.getOp_Serie_Auto_Ase());
		entry.put("OP_SUMA_ASEGURADO", entrada.getOp_Suma_Asegurado());
		entry.put("OP_NOM_AFE", entrada.getOp_Nom_Afe());
		entry.put("OP_TEL_AFE", entrada.getOp_Tel_Afe());
		entry.put("OP_CONDUCTOR_AFE", entrada.getOp_Conductor_Afe());
		entry.put("OP_TEL_CON_AFE", entrada.getOp_Tel_Con_Afe());
		entry.put("OP_MARCA_AUTO_AFE", entrada.getOp_Marca_Auto_Afe());
		entry.put("OP_TIPO_AUTO_AFE", entrada.getOp_Tipo_Auto_Afe());
		entry.put("OP_COLOR_AUTO_AFE", entrada.getOp_Color_Auto_Afe());
		entry.put("OP_PLACAS_AUTO_AFE", entrada.getOp_Placas_Auto_Afe());
		entry.put("OP_MOTOR_AUTO_AFE", entrada.getOp_Motor_Auto_Afe());
		entry.put("OP_SERIE_AUTO_AFE", entrada.getOp_Serie_Auto_Afe());
		entry.put("OP_DEDUCIBLE", entrada.getOp_Deducible());
		entry.put("OP_TIPO_DEDUCIBLE", entrada.getOp_Tipo_Deducible());
		entry.put("OP_DED_ADMIN", entrada.getOp_Ded_Admin());
		entry.put("OP_DEFINICION", entrada.getOp_Definicion());
		entry.put("OP_CANTIDAD", entrada.getOp_Cantidad());
		entry.put("OP_DED_DIAS", entrada.getOp_Ded_Dias());
		entry.put("OP_DANIOS_CAMION", entrada.getOp_Danios_Camion());
		entry.put("OP_DANIOS_CAJA", entrada.getOp_Danios_Caja());
		entry.put("OP_DANIOS_TANQUE", entrada.getOp_Danios_Tanque());
		entry.put("OP_NOM_TALLER", entrada.getOp_Nom_Taller());
		entry.put("OP_TEL_TALLER", entrada.getOp_Tel_Taller());
		entry.put("OP_DIR_TALLER", entrada.getOp_Dir_Taller());
		entry.put("OP_ATENCION_TALLER", entrada.getOp_Atencion_Taller());
		entry.put("OP_SINIESTRO_CAMION", entrada.getOp_Siniestro_Camion());
		entry.put("OP_SINIESTRO_CAJA", entrada.getOp_Siniestro_Caja());
		entry.put("OP_SINIESTRO_TANQUE", entrada.getOp_Siniestro_Tanque());
		entry.put("OP_NOM_AJUSTADOR", entrada.getOp_Nom_Ajustador());
		entry.put("EMAIL_DEFAULT", entrada.getEmail_Default());
		entry.put("OP_ASEGURADO", entrada.getOp_Asegurado());
		entry.put("OP_MODELO_ASE", entrada.getOp_Modelo_Ase());
		entry.put("OP_MODELO_TER", entrada.getOp_Modelo_Ter());
		entry.put("OF_FECHA", entrada.getOf_Fecha());
		entry.put("OP_CLAVE_AJUSTADOR", entrada.getOp_Clave_Ajustador());
		entry.put("OP_EMAIL_TERCERO", entrada.getOp_Email_Tercero());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_AJUSTADOR", entrada.getFirma_Ajustador());
		entry.put("FIRMA_ASEGURADO", entrada.getFirma_Asegurado());
		entry.put("NIU", entrada.getNiu());
		entry.put("OP_CODIGO_QR", entrada.getOp_codigo_qr());
		entry.put("OP_PT_EVIDENTE", entrada.getOp_pt_evidente());
		entry.put("OP_ABANDONO", entrada.getOp_abandono());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFAP(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFAP(Map<String, String> entry) {
		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FAP");

		String[] columnas = new String[] { "OP_FOLIO_ELECTRO", "OP_NUM_REPORTE", "OP_NUM_SINIESTRO", "OP_NUM_POLIZA",
				"OP_NUM_INCISO", "OP_NUM_ENDOSO", "OP_VIGENCIA", "OP_NOM_ASEGURADO", "OP_TEL_ASEGURADO",
				"OP_CONDUCTOR_ASE", "OP_TEL_CON_ASE", "OP_MARCA_AUTO_ASE", "OP_TIPO_AUTO_ASE", "OP_COLOR_AUTO_ASE",
				"OP_PLACAS_AUTO_ASE", "OP_MOTOR_AUTO_ASE", "OP_SERIE_AUTO_ASE", "OP_SUMA_ASEGURADO", "OP_NOM_AFE",
				"OP_TEL_AFE", "OP_CONDUCTOR_AFE", "OP_TEL_CON_AFE", "OP_MARCA_AUTO_AFE", "OP_TIPO_AUTO_AFE",
				"OP_COLOR_AUTO_AFE", "OP_PLACAS_AUTO_AFE", "OP_MOTOR_AUTO_AFE", "OP_SERIE_AUTO_AFE", "OP_DEDUCIBLE",
				"OP_TIPO_DEDUCIBLE", "OP_DED_ADMIN", "OP_DEFINICION", "OP_CANTIDAD", "OP_DED_DIAS", "OP_DANIOS_CAMION",
				"OP_DANIOS_CAJA", "OP_DANIOS_TANQUE", "OP_NOM_TALLER", "OP_TEL_TALLER", "OP_DIR_TALLER",
				"OP_ATENCION_TALLER", "OP_SINIESTRO_CAMION", "OP_SINIESTRO_CAJA", "OP_SINIESTRO_TANQUE",
				"OP_NOM_AJUSTADOR", "EMAIL_DEFAULT", "OP_ASEGURADO", "OP_MODELO_ASE", "OP_MODELO_TER", "OF_FECHA",
				"OP_CLAVE_AJUSTADOR", "OP_EMAIL_TERCERO", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_AJUSTADOR",
				"FIRMA_ASEGURADO", "NIU","OP_CODIGO_QR","OP_PT_EVIDENTE","OP_ABANDONO","CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6" };

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(67, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(67));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_ADMISION_PESADO where OP_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);
		}
		return consecutivo;

	}
}