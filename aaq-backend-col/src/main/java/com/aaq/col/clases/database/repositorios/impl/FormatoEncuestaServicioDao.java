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

import com.aaq.col.clases.database.entidades.FormatoEncuestaServicio;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoEncuestaServicio_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoEncuestaServicioDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoEncuestaServicio;


@org.springframework.stereotype.Repository(value = "formatoEncuestaServicioDao")
public class FormatoEncuestaServicioDao extends SIICAServerGenericDaoJpaImpl<FormatoEncuestaServicio>
		implements FormatoEncuestaServicioDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoEncuestaServicio objetoFormatoEncuestaServicio(String id) {
		FormatoEncuestaServicio re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoEncuestaServicio.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoEncuestaServicio", id);
			log.error("Formatos Error=> objetoFormatoEncuestaServicio=> " + id, e);

		}
		return re;
	}

	@Override
	public List<FormatoEncuestaServicio> listaDeFormatoEncuestaServicio() {
		TypedQuery<FormatoEncuestaServicio> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoEncuestaServicio> query = builder.createQuery(FormatoEncuestaServicio.class);
			final Root<FormatoEncuestaServicio> root = query.from(FormatoEncuestaServicio.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoEncuestaServicio_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoEncuestaServicio_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoEncuestaServicio_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoEncuestaServicio", 500);
			log.error("Formatos Error=> listaDeFormatoEncuestaServicio", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarEncuestaServicio(

			String esTelConductor, Integer esId, String esNumSiniestro, String esNumReporte, String esNomAsegurado,

			String esLugar, String esClaveAjustador, Integer esPregunta8, Integer esPregunta9, Integer esPregunta6,
			String esNomConductor, Integer esPregunta7, Integer esPregunta4, Integer esPregunta5, Integer esPregunta2,
			Integer esPregunta3, Integer esPregunta1, String esNumInciso, String esNumPoliza, String esAsegurado,
			Date esFecha, Integer esPregunta10, String esObservaciones, String esEmailConductor,

			Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaAsegurado

	) {
		String res3 = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_encuesta1");

			nat.registerStoredProcedureParameter("in_es_tel_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_num_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_nom_asegurado", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_es_lugar", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_clave_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_pregunta8", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_pregunta9", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_pregunta6", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_nom_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_pregunta7", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_pregunta4", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_pregunta5", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_pregunta2", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_pregunta3", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_pregunta1", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_num_inciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_num_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_fecha", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_pregunta10", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_observaciones", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_es_email_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_es_tel_conductor", esTelConductor);
			nat.setParameter("in_es_id", esId);
			nat.setParameter("in_es_num_siniestro", esNumSiniestro);
			nat.setParameter("in_es_num_reporte", esNumReporte);
			nat.setParameter("in_es_nom_asegurado", esNomAsegurado);

			nat.setParameter("in_es_lugar", esLugar);
			nat.setParameter("in_es_clave_ajustador", esClaveAjustador);
			nat.setParameter("in_es_pregunta8", esPregunta8);
			nat.setParameter("in_es_pregunta9", esPregunta9);
			nat.setParameter("in_es_pregunta6", esPregunta6);
			nat.setParameter("in_es_nom_conductor", esNomConductor);
			nat.setParameter("in_es_pregunta7", esPregunta7);
			nat.setParameter("in_es_pregunta4", esPregunta4);
			nat.setParameter("in_es_pregunta5", esPregunta5);
			nat.setParameter("in_es_pregunta2", esPregunta2);
			nat.setParameter("in_es_pregunta3", esPregunta3);
			nat.setParameter("in_es_pregunta1", esPregunta1);
			nat.setParameter("in_es_num_inciso", esNumInciso);
			nat.setParameter("in_es_num_poliza", esNumPoliza);
			nat.setParameter("in_es_asegurado", esAsegurado);
			nat.setParameter("in_es_fecha", esFecha);
			nat.setParameter("in_es_pregunta10", esPregunta10);
			nat.setParameter("in_es_observaciones", esObservaciones);
			nat.setParameter("in_es_email_conductor", esEmailConductor);

			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res3 = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarEncuestaServicio",

					esTelConductor, esId, esNumSiniestro, esNumReporte, esNomAsegurado,

					esLugar, esClaveAjustador, esPregunta8, esPregunta9, esPregunta6, esNomConductor, esPregunta7,
					esPregunta4, esPregunta5, esPregunta2, esPregunta3, esPregunta1, esNumInciso, esNumPoliza,
					esAsegurado, esFecha, esPregunta10, esObservaciones, esEmailConductor, enviadoEmail, ////
					mensajeEmail, ////
					proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaAsegurado

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarEncuestaServicio =>" + esNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return res3;
	}

	@Override
	public String InsertarFormatoEncuestaServicio(DatosInsertarFormatoEncuestaServicio entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("ES_NUM_REPORTE", entrada.getEs_Num_Reporte());
		entry.put("ES_NUM_SINIESTRO", entrada.getEs_Num_Siniestro());
		entry.put("ES_NOM_ASEGURADO", entrada.getEs_Nom_Asegurado());
		entry.put("ES_PREGUNTA_1", entrada.getEs_Pregunta_1());
		entry.put("ES_PREGUNTA_2", entrada.getEs_Pregunta_2());
		entry.put("ES_PREGUNTA_3", entrada.getEs_Pregunta_3());
		entry.put("ES_PREGUNTA_4", entrada.getEs_Pregunta_4());
		entry.put("ES_PREGUNTA_5", entrada.getEs_Pregunta_5());
		entry.put("ES_PREGUNTA_6", entrada.getEs_Pregunta_6());
		entry.put("ES_PREGUNTA_7", entrada.getEs_Pregunta_7());
		entry.put("ES_PREGUNTA_8", entrada.getEs_Pregunta_8());
		entry.put("ES_PREGUNTA_9", entrada.getEs_Pregunta_9());
		entry.put("ES_PREGUNTA_10", entrada.getEs_Pregunta_10());
		entry.put("ES_OBSERVACIONES", entrada.getEs_Observaciones());
		entry.put("ES_NOM_CONDUCTOR", entrada.getEs_Nom_Conductor());
		entry.put("ES_TEL_CONDUCTOR", entrada.getEs_Tel_Conductor());
		entry.put("ES_EMAIL_CONDUCTOR", entrada.getEs_Email_Conductor());
		entry.put("ES_LUGAR", entrada.getEs_Lugar());
		entry.put("ES_FECHA", entrada.getEs_Fecha());
		entry.put("ES_NUM_POLIZA", entrada.getEs_Num_Poliza());
		entry.put("ES_NUM_INCISO", entrada.getEs_Num_Inciso());
		entry.put("ES_CLAVE_AJUSTADOR", entrada.getEs_Clave_Ajustador());
		entry.put("ES_ASEGURADO", entrada.getEs_Asegurado());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_ASEGURADO", entrada.getFirma_Asegurado());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFES(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFES(Map<String, String> entry) {
		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FES");

		String[] columnas = new String[] { "ES_NUM_REPORTE", "ES_NUM_SINIESTRO", "ES_NOM_ASEGURADO", "ES_PREGUNTA_1",
				"ES_PREGUNTA_2", "ES_PREGUNTA_3", "ES_PREGUNTA_4", "ES_PREGUNTA_5", "ES_PREGUNTA_6", "ES_PREGUNTA_7",
				"ES_PREGUNTA_8", "ES_PREGUNTA_9", "ES_PREGUNTA_10", "ES_OBSERVACIONES", "ES_NOM_CONDUCTOR",
				"ES_TEL_CONDUCTOR", "ES_EMAIL_CONDUCTOR", "ES_LUGAR", "ES_FECHA", "ES_NUM_POLIZA", "ES_NUM_INCISO",
				"ES_CLAVE_AJUSTADOR", "ES_ASEGURADO", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_ASEGURADO",
				"CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6" };

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(33, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(33));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_ENCUESTA_SERVICIO where ES_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}