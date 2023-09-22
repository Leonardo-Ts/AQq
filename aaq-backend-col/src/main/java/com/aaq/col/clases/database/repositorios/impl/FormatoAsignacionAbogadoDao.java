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

import com.aaq.col.clases.database.entidades.FormatoAsignacionAbogado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoAsignacionAbogado_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoAsignacionAbogadoDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoAsignacionAbogado;


@org.springframework.stereotype.Repository(value = "formatoAsignacionAbogadoDao")
public class FormatoAsignacionAbogadoDao extends SIICAServerGenericDaoJpaImpl<FormatoAsignacionAbogado>
		implements FormatoAsignacionAbogadoDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoAsignacionAbogado objetoFormatoAsignacionAbogado(String id) {
		FormatoAsignacionAbogado res = null;
		try {
			res = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoAsignacionAbogado.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoAsignacionAbogado", id);
			log.error("Formatos Error=> objetoFormatoAsignacionAbogado=> " + id, e);

		}
		return res;
	}

	@Override
	public List<FormatoAsignacionAbogado> listaDeFormatoAsignacionAbogado() {
		TypedQuery<FormatoAsignacionAbogado> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoAsignacionAbogado> query = builder.createQuery(FormatoAsignacionAbogado.class);
			final Root<FormatoAsignacionAbogado> root = query.from(FormatoAsignacionAbogado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoAsignacionAbogado_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoAsignacionAbogado_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoAsignacionAbogado_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoAsignacionAbogado",
			// 500);
			log.error("Formatos Error=> listaDeFormatoAsignacionAbogado", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarAsignacionAbogado(

			String aaNomConductor, String aaMarcaAuto, String aaColorAuto, String aaNomAjustador, Integer aaGrua,

			Integer aaPagado, Double aaDaniosNa, String aaTelOficina, String aaTelCasa, Integer aaPaseMedico,
			String aaClaveAbogado, String aaAutoridad, String aaAsegurado, String aaEmail, String aaDescripcionDanios,
			Timestamp aaHoraSiniestro, String aaNomLesionados, Integer aaPregunta1A, Integer aaPregunta1,
			Integer aaPregunta1B, String aaTelOficinaTercero,

			Integer aaPregunta3, String aaNumSiniestro, Integer aaPregunta2, String aaNomTercero, Integer aaPregunta5,
			Integer aaPregunta4, Integer aaPregunta6, String aaTipoAuto, Integer aaPresuAsegurado, String aaInforme,
			Integer aaCopiaLicencia,

			String aaDaniosEstimados, Integer aaGruaTercero, String aaLugarSiniestro, String aaOtros,
			Integer aaPropietario, String aaNomAbogado, String aaNumPoliza, Integer aaDeducibleRc,
			String aaUbicacionActual, String aaNumInciso, Integer aaOrdenAdmision, Timestamp aaHoraAbogado,
			String aaClaveAjustador, Integer aaCopiaPoliza, Double aaMontoCrucero, Integer aaParteAcciden,
			String aaNumAccidente, Double aaMontoDeducible, String aaNomAsegurado, String aaPlacaAuto,
			Timestamp aaHoraTurnado, String aaDesDaniosTer, String aaTelCasaTercero, Integer aaId,
			Integer aaDeclaracionConduc, String aaNumReporte, String aaComentarios, Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado,
			String firmaAbogado, Integer aaPregunta7A, Integer aaPregunta7B

	) {
		String respu = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_admision1");

			nat.registerStoredProcedureParameter("in_aa_nom_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_marca_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_color_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_nom_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_grua", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_aa_pagado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_danios_na", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_tel_oficina", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_tel_casa", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_pase_medico", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_clave_abogado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_autoridad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_email", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_descripcion_danios", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_hora_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_nom_lesionados", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_pregunta_1A", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_pregunta_1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_pregunta_1B", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_tel_oficina_tercero", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_aa_pregunta_3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_num_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_pregunta_2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_nom_tercero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_pregunta_5", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_pregunta_4", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_pregunta_6", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_tipo_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_presu_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_informe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_copia_licencia", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_aa_danios_estimados", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_grua_tercero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_lugar_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_otros", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_propietario", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_nom_abogado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_num_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_deducible_rc", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_ubicacion_actual", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_num_inciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_orden_admision", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_hora_abogado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_clave_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_copia_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_monto_crucero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_parte_acciden", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_num_accidente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_monto_deducible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_nom_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_placa_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_hora_turnado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_des_danios_ter", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_tel_casa_tercero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_id", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_declaracion_conduc", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_aa_comentarios", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_aa_nom_conductor", aaNomConductor);
			nat.setParameter("in_aa_marca_auto", aaMarcaAuto);
			nat.setParameter("in_aa_color_auto", aaColorAuto);
			nat.setParameter("in_aa_nom_ajustador", aaNomAjustador);
			nat.setParameter("in_aa_grua", aaGrua);

			nat.setParameter("in_aa_pagado", aaPagado);
			nat.setParameter("in_aa_danios_na", aaDaniosNa);
			nat.setParameter("in_aa_tel_oficina", aaTelOficina);
			nat.setParameter("in_aa_tel_casa", aaTelCasa);
			nat.setParameter("in_aa_pase_medico", aaPaseMedico);
			nat.setParameter("in_aa_clave_abogado", aaClaveAbogado);
			nat.setParameter("in_aa_autoridad", aaAutoridad);
			nat.setParameter("in_aa_asegurado", aaAsegurado);
			nat.setParameter("in_aa_email", aaEmail);
			nat.setParameter("in_aa_descripcion_danios", aaDescripcionDanios);
			nat.setParameter("in_aa_hora_siniestro", aaHoraSiniestro);
			nat.setParameter("in_aa_nom_lesionados", aaNomLesionados);
			nat.setParameter("in_aa_pregunta_1A", aaPregunta1A);
			nat.setParameter("in_aa_pregunta_1", aaPregunta1);
			nat.setParameter("in_aa_pregunta_1B", aaPregunta1B);
			nat.setParameter("in_aa_tel_oficina_tercero", aaTelOficinaTercero);

			nat.setParameter("in_aa_pregunta_3", aaPregunta3);
			nat.setParameter("in_aa_num_siniestro", aaNumSiniestro);
			nat.setParameter("in_aa_pregunta_2", aaPregunta2);
			nat.setParameter("in_aa_nom_tercero", aaNomTercero);
			nat.setParameter("in_aa_pregunta_5", aaPregunta5);
			nat.setParameter("in_aa_pregunta_4", aaPregunta4);
			nat.setParameter("in_aa_pregunta_6", aaPregunta6);
			nat.setParameter("in_aa_tipo_auto", aaTipoAuto);
			nat.setParameter("in_aa_presu_asegurado", aaPresuAsegurado);
			nat.setParameter("in_aa_informe", aaInforme);
			nat.setParameter("in_aa_copia_licencia", aaCopiaLicencia);

			nat.setParameter("in_aa_danios_estimados", aaDaniosEstimados);
			nat.setParameter("in_aa_grua_tercero", aaGruaTercero);
			nat.setParameter("in_aa_lugar_siniestro", aaLugarSiniestro);
			nat.setParameter("in_aa_otros", aaOtros);
			nat.setParameter("in_aa_propietario", aaPropietario);
			nat.setParameter("in_aa_nom_abogado", aaNomAbogado);
			nat.setParameter("in_aa_num_poliza", aaNumPoliza);
			nat.setParameter("in_aa_deducible_rc", aaDeducibleRc);
			nat.setParameter("in_aa_ubicacion_actual", aaUbicacionActual);
			nat.setParameter("in_aa_num_inciso", aaNumInciso);
			nat.setParameter("in_aa_orden_admision", aaOrdenAdmision);
			nat.setParameter("in_aa_hora_abogado", aaHoraAbogado);
			nat.setParameter("in_aa_clave_ajustador", aaClaveAjustador);
			nat.setParameter("in_aa_copia_poliza", aaCopiaPoliza);
			nat.setParameter("in_aa_monto_crucero", aaMontoCrucero);
			nat.setParameter("in_aa_parte_acciden", aaParteAcciden);
			nat.setParameter("in_aa_num_accidente", aaNumAccidente);
			nat.setParameter("in_aa_monto_deducible", aaMontoDeducible);
			nat.setParameter("in_aa_nom_asegurado", aaNomAsegurado);
			nat.setParameter("in_aa_placa_auto", aaPlacaAuto);
			nat.setParameter("in_aa_hora_turnado", aaHoraTurnado);
			nat.setParameter("in_aa_des_danios_ter", aaDesDaniosTer);
			nat.setParameter("in_aa_tel_casa_tercero", aaTelCasaTercero);
			nat.setParameter("in_aa_id", aaId);
			nat.setParameter("in_aa_declaracion_conduc", aaDeclaracionConduc);
			nat.setParameter("in_aa_num_reporte", aaNumReporte);
			nat.setParameter("in_aa_comentarios", aaComentarios);
			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			respu = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarAsignacionAbogado",

					aaNomConductor, aaMarcaAuto, aaColorAuto, aaNomAjustador, aaGrua,

					aaPagado, aaDaniosNa, aaTelOficina, aaTelCasa, aaPaseMedico, aaClaveAbogado, aaAutoridad,
					aaAsegurado, aaEmail, aaDescripcionDanios, aaHoraSiniestro, aaNomLesionados, aaPregunta1A,
					aaPregunta1, aaPregunta1B, aaTelOficinaTercero,

					aaPregunta3, aaNumSiniestro, aaPregunta2, aaNomTercero, aaPregunta5, aaPregunta4, aaPregunta6,
					aaTipoAuto, aaPresuAsegurado, aaInforme, aaCopiaLicencia,

					aaDaniosEstimados, aaGruaTercero, aaLugarSiniestro, aaOtros, aaPropietario, aaNomAbogado,
					aaNumPoliza, aaDeducibleRc, aaUbicacionActual, aaNumInciso, aaOrdenAdmision, aaHoraAbogado,
					aaClaveAjustador, aaCopiaPoliza, aaMontoCrucero, aaParteAcciden, aaNumAccidente, aaMontoDeducible,
					aaNomAsegurado, aaPlacaAuto, aaHoraTurnado, aaDesDaniosTer, aaTelCasaTercero, aaId,
					aaDeclaracionConduc, aaNumReporte, aaComentarios, enviadoEmail, ////
					mensajeEmail, ////
					proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaAjustador,
					firmaAsegurado, firmaAbogado, aaPregunta7A, aaPregunta7B

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarAsignacionAbogado =>" + aaNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return respu;
	}

	@Override
	public String InsertarFormatoAsignacionAbogado(DatosInsertarFormatoAsignacionAbogado entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("AA_PREGUNTA_1A", entrada.getAa_Pregunta_1a());
		entry.put("AA_PREGUNTA_2", entrada.getAa_Pregunta_2());
		entry.put("AA_PREGUNTA_3", entrada.getAa_Pregunta_3());
		entry.put("AA_PREGUNTA_4", entrada.getAa_Pregunta_4());
		entry.put("AA_PREGUNTA_5", entrada.getAa_Pregunta_5());
		entry.put("AA_PREGUNTA_6", entrada.getAa_Pregunta_6());
		entry.put("AA_HORA_SINIESTRO", entrada.getAa_Hora_Siniestro());
		entry.put("AA_HORA_TURNADO", entrada.getAa_Hora_Turnado());
		entry.put("AA_HORA_ABOGADO", entrada.getAa_Hora_Abogado());
		entry.put("AA_NUM_SINIESTRO", entrada.getAa_Num_Siniestro());
		entry.put("AA_NUM_REPORTE", entrada.getAa_Num_Reporte());
		entry.put("AA_NUM_POLIZA", entrada.getAa_Num_Poliza());
		entry.put("AA_MARCA_AUTO", entrada.getAa_Marca_Auto());
		entry.put("AA_TIPO_AUTO", entrada.getAa_Tipo_Auto());
		entry.put("AA_COLOR_AUTO", entrada.getAa_Color_Auto());
		entry.put("AA_PLACA_AUTO", entrada.getAa_Placa_Auto());
		entry.put("AA_DANIOS_NA", entrada.getAa_Danios_Na());
		entry.put("AA_MONTO_CRUCERO", entrada.getAa_Monto_Crucero());
		entry.put("AA_MONTO_DEDUCIBLE", entrada.getAa_Monto_Deducible());
		entry.put("AA_DEDUCIBLE_RC", entrada.getAa_Deducible_Rc());
		entry.put("AA_PAGADO", entrada.getAa_Pagado());
		entry.put("AA_NOM_ASEGURADO", entrada.getAa_Nom_Asegurado());
		entry.put("AA_NOM_CONDUCTOR", entrada.getAa_Nom_Conductor());
		entry.put("AA_PROPIETARIO", entrada.getAa_Propietario());
		entry.put("AA_TEL_OFICINA", entrada.getAa_Tel_Oficina());
		entry.put("AA_UBICACION_ACTUAL", entrada.getAa_Ubicacion_Actual());
		entry.put("AA_DESCRIPCION_DANIOS", entrada.getAa_Descripcion_Danios());
		entry.put("AA_TEL_CASA", entrada.getAa_Tel_Casa());
		entry.put("AA_EMAIL", entrada.getAa_Email());
		entry.put("AA_LUGAR_SINIESTRO", entrada.getAa_Lugar_Siniestro());
		entry.put("AA_AUTORIDAD", entrada.getAa_Autoridad());
		entry.put("AA_NUM_ACCIDENTE", entrada.getAa_Num_Accidente());
		entry.put("AA_GRUA", entrada.getAa_Grua());
		entry.put("AA_NOM_TERCERO", entrada.getAa_Nom_Tercero());
		entry.put("AA_TEL_CASA_TERCERO", entrada.getAa_Tel_Casa_Tercero());
		entry.put("AA_TEL_OFICINA_TERCERO", entrada.getAa_Tel_Oficina_Tercero());
		entry.put("AA_DANIOS_ESTIMADOS", entrada.getAa_Danios_Estimados());
		entry.put("AA_COMENTARIOS", entrada.getAa_Comentarios());
		entry.put("AA_DES_DANIOS_TER", entrada.getAa_Des_Danios_Ter());
		entry.put("AA_NOM_LESIONADOS", entrada.getAa_Nom_Lesionados());
		entry.put("AA_INFORME", entrada.getAa_Informe());
		entry.put("AA_OTROS", entrada.getAa_Otros());
		entry.put("AA_GRUA_TERCERO", entrada.getAa_Grua_Tercero());
		entry.put("AA_DECLARACION_CONDUC", entrada.getAa_Declaracion_Conduc());
		entry.put("AA_PARTE_ACCIDEN", entrada.getAa_Parte_Acciden());
		entry.put("AA_COPIA_POLIZA", entrada.getAa_Copia_Poliza());
		entry.put("AA_PRESU_ASEGURADO", entrada.getAa_Presu_Asegurado());
		entry.put("AA_COPIA_LICENCIA", entrada.getAa_Copia_Licencia());
		entry.put("AA_ORDEN_ADMISION", entrada.getAa_Orden_Admision());
		entry.put("AA_PASE_MEDICO", entrada.getAa_Pase_Medico());
		entry.put("AA_CLAVE_AJUSTADOR", entrada.getAa_Clave_Ajustador());
		entry.put("AA_NOM_AJUSTADOR", entrada.getAa_Nom_Ajustador());
		entry.put("AA_CLAVE_ABOGADO", entrada.getAa_Clave_Abogado());
		entry.put("AA_NOM_ABOGADO", entrada.getAa_Nom_Abogado());
		entry.put("AA_NUM_INCISO", entrada.getAa_Num_Inciso());
		entry.put("AA_ASEGURADO", entrada.getAa_Asegurado());
		entry.put("AA_PREGUNTA_1B", entrada.getAa_Pregunta_1b());
		entry.put("AA_PREGUNTA_1", entrada.getAa_Pregunta_1());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_AJUSTADOR", entrada.getFirma_Ajustador());
		entry.put("FIRMA_ABOGADO", entrada.getFirma_Abogado());
		entry.put("FIRMA_ASEGURADO", entrada.getFirma_Asegurado());
		entry.put("AA_PREGUNTA_7A", entrada.getAa_Pregunta_7a());
		entry.put("AA_PREGUNTA_7B", entrada.getAa_Pregunta_7b());
		entry.put("FIRMA_TERCERO", entrada.getFirma_tercero());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFAAbogado(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFAAbogado(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FAABOGADO");

		String[] columnas = new String[] { "AA_PREGUNTA_1A", "AA_PREGUNTA_2", "AA_PREGUNTA_3", "AA_PREGUNTA_4",
				"AA_PREGUNTA_5", "AA_PREGUNTA_6", "AA_HORA_SINIESTRO", "AA_HORA_TURNADO", "AA_HORA_ABOGADO",
				"AA_NUM_SINIESTRO", "AA_NUM_REPORTE", "AA_NUM_POLIZA", "AA_MARCA_AUTO", "AA_TIPO_AUTO", "AA_COLOR_AUTO",
				"AA_PLACA_AUTO", "AA_DANIOS_NA", "AA_MONTO_CRUCERO", "AA_MONTO_DEDUCIBLE", "AA_DEDUCIBLE_RC",
				"AA_PAGADO", "AA_NOM_ASEGURADO", "AA_NOM_CONDUCTOR", "AA_PROPIETARIO", "AA_TEL_OFICINA",
				"AA_UBICACION_ACTUAL", "AA_DESCRIPCION_DANIOS", "AA_TEL_CASA", "AA_EMAIL", "AA_LUGAR_SINIESTRO",
				"AA_AUTORIDAD", "AA_NUM_ACCIDENTE", "AA_GRUA", "AA_NOM_TERCERO", "AA_TEL_CASA_TERCERO",
				"AA_TEL_OFICINA_TERCERO", "AA_DANIOS_ESTIMADOS", "AA_COMENTARIOS", "AA_DES_DANIOS_TER",
				"AA_NOM_LESIONADOS", "AA_INFORME", "AA_OTROS", "AA_GRUA_TERCERO", "AA_DECLARACION_CONDUC",
				"AA_PARTE_ACCIDEN", "AA_COPIA_POLIZA", "AA_PRESU_ASEGURADO", "AA_COPIA_LICENCIA", "AA_ORDEN_ADMISION",
				"AA_PASE_MEDICO", "AA_CLAVE_AJUSTADOR", "AA_NOM_AJUSTADOR", "AA_CLAVE_ABOGADO", "AA_NOM_ABOGADO",
				"AA_NUM_INCISO", "AA_ASEGURADO", "AA_PREGUNTA_1B", "AA_PREGUNTA_1", "CHECK_1", "CHECK_2", "CHECK_3",
				"CHECK_4", "FIRMA_AJUSTADOR", "FIRMA_ABOGADO", "FIRMA_ASEGURADO", "AA_PREGUNTA_7A", "AA_PREGUNTA_7B",
				"FIRMA_TERCERO","CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6"};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(73, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(73));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_ASIGNACION_ABOGADO where AA_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}