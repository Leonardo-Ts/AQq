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

import com.aaq.col.clases.database.entidades.FormatoCuestionarioRobo;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoCuestionarioRobo_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoCuestionarioRoboDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoCuestionarioRobo;


@org.springframework.stereotype.Repository(value = "formatoCuestionarioRoboDao")
public class FormatoCuestionarioRoboDao extends SIICAServerGenericDaoJpaImpl<FormatoCuestionarioRobo>
		implements FormatoCuestionarioRoboDaoInterfase {
	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoCuestionarioRobo objetoFormatoCuestionarioRobo(String id) {
		FormatoCuestionarioRobo de = null;
		try {
			de = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoCuestionarioRobo.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoCuestionarioRobo", id);
			log.error("Formatos Error=> objetoFormatoCuestionarioRobo=> " + id, e);

		}
		return de;
	}

	@Override
	public List<FormatoCuestionarioRobo> listaDeFormatoCuestionarioRobo() {
		TypedQuery<FormatoCuestionarioRobo> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoCuestionarioRobo> query = builder.createQuery(FormatoCuestionarioRobo.class);
			final Root<FormatoCuestionarioRobo> root = query.from(FormatoCuestionarioRobo.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoCuestionarioRobo_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoCuestionarioRobo_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoCuestionarioRobo_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoCuestionarioRobo", 500);
			log.error("Formatos Error=> listaDeFormatoCuestionarioRobo", e);
		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarCuestionarioRobo(

			String crO16Emergencia, String crPregunta13, String crPregunta12, String crPregunta11, String crOtros,
			String crPregunta17, Integer crO16Particular, String crPregunta15, String crAsegurado, Integer crBool9,
			String crPregunta14, String crDirAsegurado, Integer crBool29, String crNumSiniestro, String crNumReporte,
			String crNumPoliza, String crPregunta282, String crPregunta281, Integer crBool30, String crClaveAjustador,
			Integer crBool31, String crPregunta283, Integer crEstacionado, String crPregunta24, String crPregunta23,
			String crPregunta22, String crEmailAsegurado, String crPregunta21, String crPregunta27, String crPregunta26,
			String crPregunta25, String crTelCelularAsegurado, String crNumEndoso, Integer crBool8, String crPregunta19,
			Integer crBool5, Integer crO16Carga, String crPregunta18, Integer crBool3, Integer crBool2,
			String crOcuAsegurado, String crPregunta32, Integer crId, String crNomAsegurado, String crPregunta31,
			String crPregunta30, Integer crO16Otros, Integer crBool12, String crPregunta101, String crPregunta4,
			Integer crBool13, String crPregunta3, String crPregunta2, Integer crBool11, String crPregunta1,
			String crPregunta102,

			String crPregunta7, Integer crBool14, String crPregunta6, Integer crBool15, String crPregunta5,
			String crTelOfiAsegurado, Integer crO16Enseñanza, String crIncAsegurado, String crPregunta29,
			Timestamp crHora, String crNumInciso, String crPregunta82, String crPregunta81, Integer crBool19,
			String crPregunta9, String crPregunta83, Integer crBool27, Integer crBool28, Integer crBool26,
			Integer crBool20, String crTelCasaAsegurado, Integer crO16Publico, Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaAsegurado

	) {
		String res = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_cuestionario1");

			nat.registerStoredProcedureParameter("in_ crO16Emergencia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta13", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta12", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta11", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crOtros", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta17", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crO16Particular", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta15", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool9", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta14", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crDirAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool29", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crNumSiniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crNumReporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crNumPoliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta282", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta281", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool30", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crClaveAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool31", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta283", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crEstacionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta24", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta23", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta22", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crEmailAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta21", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta27", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta26", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta25", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crTelCelularAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crNumEndoso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool8", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta19", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool5", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crO16Carga", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta18", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crOcuAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta32", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crId", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crNomAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta31", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta30", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crO16Otros", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool12", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta101", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta4", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool13", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool11", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta102", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_crPregunta7", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool14", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta6", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool15", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta5", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crTelOfiAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crO16Enseñanza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crIncAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta29", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crHora", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crNumInciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta82", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta81", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool19", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta9", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crPregunta83", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool27", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool28", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool26", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crBool20", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_crTelCasaAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ crO16Publico", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_crO16Enseñanza", crO16Emergencia);
			nat.setParameter("in_crPregunta13", crPregunta13);
			nat.setParameter("in_crPregunta12", crPregunta12);
			nat.setParameter("in_crPregunta11", crPregunta11);
			nat.setParameter("in_crOtros", crOtros);
			nat.setParameter("in_crPregunta17", crPregunta17);
			nat.setParameter("in_crO16Particular", crO16Particular);
			nat.setParameter("in_crPregunta15", crPregunta15);
			nat.setParameter("in_crAsegurado", crAsegurado);
			nat.setParameter("in_crBool9", crBool9);
			nat.setParameter("in_crPregunta14", crPregunta14);
			nat.setParameter("in_crDirAsegurado", crDirAsegurado);
			nat.setParameter("in_crBool29", crBool29);
			nat.setParameter("in_crNumSiniestro", crNumSiniestro);
			nat.setParameter("in_crNumReporte", crNumReporte);
			nat.setParameter("in_crNumPoliza", crNumPoliza);
			nat.setParameter("in_crPregunta282", crPregunta282);
			nat.setParameter("in_crPregunta281", crPregunta281);
			nat.setParameter("in_crBool30", crBool30);
			nat.setParameter("in_crClaveAjustador", crClaveAjustador);
			nat.setParameter("in_crBool31", crBool31);
			nat.setParameter("in_crPregunta283", crPregunta283);
			nat.setParameter("in_crEstacionado", crEstacionado);
			nat.setParameter("in_crPregunta24", crPregunta24);
			nat.setParameter("in_crPregunta23", crPregunta23);
			nat.setParameter("in_crPregunta22", crPregunta22);
			nat.setParameter("in_crEmailAsegurado", crEmailAsegurado);
			nat.setParameter("in_crPregunta21", crPregunta21);
			nat.setParameter("in_crPregunta27", crPregunta27);
			nat.setParameter("in_crPregunta26", crPregunta26);
			nat.setParameter("in_crPregunta25", crPregunta25);
			nat.setParameter("in_crTelCelularAsegurado", crTelCelularAsegurado);
			nat.setParameter("in_crNumEndoso", crNumEndoso);
			nat.setParameter("in_crBool8", crBool8);
			nat.setParameter("in_crPregunta19", crPregunta19);
			nat.setParameter("in_crBool5", crBool5);
			nat.setParameter("in_crO16Carga", crO16Carga);
			nat.setParameter("in_crPregunta18", crPregunta18);
			nat.setParameter("in_crBool3", crBool3);
			nat.setParameter("in_crBool2", crBool2);
			nat.setParameter("in_crOcuAsegurado", crOcuAsegurado);
			nat.setParameter("in_crPregunta32", crPregunta32);
			nat.setParameter("in_crId", crId);
			nat.setParameter("in_crNomAsegurado", crNomAsegurado);
			nat.setParameter("in_crPregunta31", crPregunta31);
			nat.setParameter("in_crPregunta30", crPregunta30);
			nat.setParameter("in_crO16Otros", crO16Otros);
			nat.setParameter("in_crBool12", crBool12);
			nat.setParameter("in_crPregunta101", crPregunta101);
			nat.setParameter("in_crPregunta4", crPregunta4);
			nat.setParameter("in_crBool13", crBool13);
			nat.setParameter("in_crPregunta3", crPregunta3);
			nat.setParameter("in_crPregunta2", crPregunta2);
			nat.setParameter("in_crBool11", crBool11);
			nat.setParameter("in_crPregunta1", crPregunta1);
			nat.setParameter("in_crPregunta102", crPregunta102);

			nat.setParameter("in_crPregunta7", crPregunta7);
			nat.setParameter("in_crBool14", crBool14);
			nat.setParameter("in_crPregunta6", crPregunta6);
			nat.setParameter("in_crBool15", crBool15);
			nat.setParameter("in_crPregunta5", crPregunta5);
			nat.setParameter("in_crTelOfiAsegurado", crTelOfiAsegurado);
			nat.setParameter("in_crO16Enseñanza", crO16Enseñanza);
			nat.setParameter("in_crIncAsegurado", crIncAsegurado);
			nat.setParameter("in_crPregunta29", crPregunta29);
			nat.setParameter("in_crHora", crHora);
			nat.setParameter("in_crNumInciso", crNumInciso);
			nat.setParameter("in_crPregunta82", crPregunta82);
			nat.setParameter("in_crPregunta81", crPregunta81);
			nat.setParameter("in_crBool19", crBool19);
			nat.setParameter("in_crPregunta9", crPregunta9);
			nat.setParameter("in_crPregunta83", crPregunta83);
			nat.setParameter("in_crBool27", crBool27);
			nat.setParameter("in_crBool28", crBool28);
			nat.setParameter("in_crBool26", crBool26);
			nat.setParameter("in_crBool20", crBool20);
			nat.setParameter("in_crTelCasaAsegurado", crTelCasaAsegurado);
			nat.setParameter("in_crO16Publico", crO16Publico);
			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarCuestionarioRobo",

					crO16Emergencia, crPregunta13, crPregunta12, crPregunta11, crOtros, crPregunta17, crO16Particular,
					crPregunta15, crAsegurado, crBool9, crPregunta14, crDirAsegurado, crBool29, crNumSiniestro,
					crNumReporte, crNumPoliza, crPregunta282, crPregunta281, crBool30, crClaveAjustador, crBool31,
					crPregunta283, crEstacionado, crPregunta24, crPregunta23, crPregunta22, crEmailAsegurado,
					crPregunta21, crPregunta27, crPregunta26, crPregunta25, crTelCelularAsegurado, crNumEndoso, crBool8,
					crPregunta19, crBool5, crO16Carga, crPregunta18, crBool3, crBool2, crOcuAsegurado, crPregunta32,
					crId, crNomAsegurado, crPregunta31, crPregunta30, crO16Otros, crBool12, crPregunta101, crPregunta4,
					crBool13, crPregunta3, crPregunta2, crBool11, crPregunta1, crPregunta102,

					crPregunta7, crBool14, crPregunta6, crBool15, crPregunta5, crTelOfiAsegurado, crO16Enseñanza,
					crIncAsegurado, crPregunta29, crHora, crNumInciso, crPregunta82, crPregunta81, crBool19,
					crPregunta9, crPregunta83, crBool27, crBool28, crBool26, crBool20, crTelCasaAsegurado, crO16Publico,
					enviadoEmail, ////
					mensajeEmail, ////

					proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaAsegurado

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarCuestionarioRobo =>" + crNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return res;
	}

	@Override
	public String InsertarFormatoCuestionarioRobo(DatosInsertarFormatoCuestionarioRobo entrada) {

		Map<String, String> entry = new HashMap<String, String>();
		String result = null;

		entry.put("CR_NUM_REPORTE", entrada.getCr_Num_Reporte());
		entry.put("CR_NUM_POLIZA", entrada.getCr_Num_Poliza());
		entry.put("CR_NUM_SINIESTRO", entrada.getCr_Num_Siniestro());
		entry.put("CR_INC_ASEGURADO", entrada.getCr_Inc_Asegurado());
		entry.put("CR_ESTACIONADO", entrada.getCr_Estacionado());
		entry.put("CR_PREGUNTA_1", entrada.getCr_Pregunta_1());
		entry.put("CR_PREGUNTA_2", entrada.getCr_Pregunta_2());
		entry.put("CR_BOOL_2", entrada.getCr_Bool_2());
		entry.put("CR_PREGUNTA_3", entrada.getCr_Pregunta_3());
		entry.put("CR_BOOL_3", entrada.getCr_Bool_3());
		entry.put("CR_PREGUNTA_4", entrada.getCr_Pregunta_4());
		entry.put("CR_PREGUNTA_5", entrada.getCr_Pregunta_5());
		entry.put("CR_BOOL_5", entrada.getCr_Bool_5());
		entry.put("CR_PREGUNTA_6", entrada.getCr_Pregunta_6());
		entry.put("CR_PREGUNTA_7", entrada.getCr_Pregunta_7());
		entry.put("CR_PREGUNTA_8_1", entrada.getCr_Pregunta_8_1());
		entry.put("CR_PREGUNTA_8_2", entrada.getCr_Pregunta_8_2());
		entry.put("CR_PREGUNTA_8_3", entrada.getCr_Pregunta_8_3());
		entry.put("CR_BOOL_8", entrada.getCr_Bool_8());
		entry.put("CR_PREGUNTA_9", entrada.getCr_Pregunta_9());
		entry.put("CR_BOOL_9", entrada.getCr_Bool_9());
		entry.put("CR_PREGUNTA_10_1", entrada.getCr_Pregunta_10_1());
		entry.put("CR_PREGUNTA_10_2", entrada.getCr_Pregunta_10_2());
		entry.put("CR_PREGUNTA_11", entrada.getCr_Pregunta_11());
		entry.put("CR_BOOL_11", entrada.getCr_Bool_11());
		entry.put("CR_PREGUNTA_12", entrada.getCr_Pregunta_12());
		entry.put("CR_BOOL_12", entrada.getCr_Bool_12());
		entry.put("CR_PREGUNTA_13", entrada.getCr_Pregunta_13());
		entry.put("CR_BOOL_13", entrada.getCr_Bool_13());
		entry.put("CR_PREGUNTA_14", entrada.getCr_Pregunta_14());
		entry.put("CR_BOOL_14", entrada.getCr_Bool_14());
		entry.put("CR_PREGUNTA_15", entrada.getCr_Pregunta_15());
		entry.put("CR_BOOL_15", entrada.getCr_Bool_15());
		entry.put("CR_O16_PARTICULAR", entrada.getCr_O16_Particular());
		entry.put("CR_O16_PUBLICO", entrada.getCr_O16_Publico());
		entry.put("CR_O16_CARGA", entrada.getCr_O16_Carga());
		entry.put("CR_O16_ENSEÑANZA", entrada.getCr_O16_Enseñanza());
		entry.put("CR_O16_OTROS", entrada.getCr_O16_Otros());
		entry.put("CR_OTROS", entrada.getCr_Otros());
		entry.put("CR_PREGUNTA_17", entrada.getCr_Pregunta_17());
		entry.put("CR_PREGUNTA_18", entrada.getCr_Pregunta_18());
		entry.put("CR_PREGUNTA_19", entrada.getCr_Pregunta_19());
		entry.put("CR_BOOL_19", entrada.getCr_Bool_19());
		entry.put("CR_BOOL_20", entrada.getCr_Bool_20());
		entry.put("CR_PREGUNTA_21", entrada.getCr_Pregunta_21());
		entry.put("CR_PREGUNTA_22", entrada.getCr_Pregunta_22());
		entry.put("CR_PREGUNTA_23", entrada.getCr_Pregunta_23());
		entry.put("CR_PREGUNTA_24", entrada.getCr_Pregunta_24());
		entry.put("CR_PREGUNTA_25", entrada.getCr_Pregunta_25());
		entry.put("CR_PREGUNTA_26", entrada.getCr_Pregunta_26());
		entry.put("CR_BOOL_26", entrada.getCr_Bool_26());
		entry.put("CR_PREGUNTA_27", entrada.getCr_Pregunta_27());
		entry.put("CR_BOOL_27", entrada.getCr_Bool_27());
		entry.put("CR_PREGUNTA_28_1", entrada.getCr_Pregunta_28_1());
		entry.put("CR_PREGUNTA_28_2", entrada.getCr_Pregunta_28_2());
		entry.put("CR_PREGUNTA_28_3", entrada.getCr_Pregunta_28_3());
		entry.put("CR_BOOL_28", entrada.getCr_Bool_28());
		entry.put("CR_PREGUNTA_29", entrada.getCr_Pregunta_29());
		entry.put("CR_BOOL_29", entrada.getCr_Bool_29());
		entry.put("CR_PREGUNTA_30", entrada.getCr_Pregunta_30());
		entry.put("CR_BOOL_30", entrada.getCr_Bool_30());
		entry.put("CR_PREGUNTA_31", entrada.getCr_Pregunta_31());
		entry.put("CR_BOOL_31", entrada.getCr_Bool_31());
		entry.put("CR_PREGUNTA_32", entrada.getCr_Pregunta_32());
		entry.put("CR_NOM_ASEGURADO", entrada.getCr_Nom_Asegurado());
		entry.put("CR_DIR_ASEGURADO", entrada.getCr_Dir_Asegurado());
		entry.put("CR_TEL_CASA_ASEGURADO", entrada.getCr_Tel_Casa_Asegurado());
		entry.put("CR_TEL_OFI_ASEGURADO", entrada.getCr_Tel_Ofi_Asegurado());
		entry.put("CR_TEL_CELULAR_ASEGURADO", entrada.getCr_Tel_Celular_Asegurado());
		entry.put("CR_OCU_ASEGURADO", entrada.getCr_Ocu_Asegurado());
		entry.put("CR_EMAIL_ASEGURADO", entrada.getCr_Email_Asegurado());
		entry.put("CR_HORA", entrada.getCr_Hora());
		entry.put("CR_NUM_INCISO", entrada.getCr_Num_Inciso());
		entry.put("CR_CLAVE_AJUSTADOR", entrada.getCr_Clave_Ajustador());
		entry.put("CR_ASEGURADO", entrada.getCr_Asegurado());
		entry.put("CR_NUM_ENDOSO", entrada.getCr_Num_Endoso());
		entry.put("CR_O16_EMERGENCIA", entrada.getCr_O16_Emergencia());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_ASEGURADO", entrada.getFirma_Asegurado());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());
		

		result = ejecutarFuncionWebserviceStoreFCR(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFCR(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FCR");

		String[] columnas = new String[] { "CR_NUM_REPORTE", "CR_NUM_POLIZA", "CR_NUM_SINIESTRO", "CR_INC_ASEGURADO",
				"CR_ESTACIONADO", "CR_PREGUNTA_1", "CR_PREGUNTA_2", "CR_BOOL_2", "CR_PREGUNTA_3", "CR_BOOL_3",
				"CR_PREGUNTA_4", "CR_PREGUNTA_5", "CR_BOOL_5", "CR_PREGUNTA_6", "CR_PREGUNTA_7", "CR_PREGUNTA_8_1",
				"CR_PREGUNTA_8_2", "CR_PREGUNTA_8_3", "CR_BOOL_8", "CR_PREGUNTA_9", "CR_BOOL_9", "CR_PREGUNTA_10_1",
				"CR_PREGUNTA_10_2", "CR_PREGUNTA_11", "CR_BOOL_11", "CR_PREGUNTA_12", "CR_BOOL_12", "CR_PREGUNTA_13",
				"CR_BOOL_13", "CR_PREGUNTA_14", "CR_BOOL_14", "CR_PREGUNTA_15", "CR_BOOL_15", "CR_O16_PARTICULAR",
				"CR_O16_PUBLICO", "CR_O16_CARGA", "CR_O16_ENSEÑANZA", "CR_O16_OTROS", "CR_OTROS", "CR_PREGUNTA_17",
				"CR_PREGUNTA_18", "CR_PREGUNTA_19", "CR_BOOL_19", "CR_BOOL_20", "CR_PREGUNTA_21", "CR_PREGUNTA_22",
				"CR_PREGUNTA_23", "CR_PREGUNTA_24", "CR_PREGUNTA_25", "CR_PREGUNTA_26", "CR_BOOL_26", "CR_PREGUNTA_27",
				"CR_BOOL_27", "CR_PREGUNTA_28_1", "CR_PREGUNTA_28_2", "CR_PREGUNTA_28_3", "CR_BOOL_28",
				"CR_PREGUNTA_29", "CR_BOOL_29", "CR_PREGUNTA_30", "CR_BOOL_30", "CR_PREGUNTA_31", "CR_BOOL_31",
				"CR_PREGUNTA_32", "CR_NOM_ASEGURADO", "CR_DIR_ASEGURADO", "CR_TEL_CASA_ASEGURADO",
				"CR_TEL_OFI_ASEGURADO", "CR_TEL_CELULAR_ASEGURADO", "CR_OCU_ASEGURADO", "CR_EMAIL_ASEGURADO", "CR_HORA",
				"CR_NUM_INCISO", "CR_CLAVE_AJUSTADOR", "CR_ASEGURADO", "CR_NUM_ENDOSO", "CR_O16_EMERGENCIA", "CHECK_1",
				"CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_ASEGURADO" ,"CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6"};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(87, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(87));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_CUESTIONARIO_ROBO where CR_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}