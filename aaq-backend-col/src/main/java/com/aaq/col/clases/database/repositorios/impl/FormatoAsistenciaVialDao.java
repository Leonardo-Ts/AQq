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

import com.aaq.col.clases.database.entidades.FormatoAsistenciaVial;
import com.aaq.col.clases.database.entidades.FormatoAsistenciaVial_;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoAsistenciaVial_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoAsistenciaVialDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoAsistenciaVial;

@org.springframework.stereotype.Repository(value = "formatoAsistenciaVialDao")
public class FormatoAsistenciaVialDao extends SIICAServerGenericDaoJpaImpl<FormatoAsistenciaVial>
		implements FormatoAsistenciaVialDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoAsistenciaVial objetoFormatoAsistenciaVial(String id) {
		FormatoAsistenciaVial re = null;
		try {
			re = StringUtils.isNotBlank(id) ? this.getEntityManager().find(FormatoAsistenciaVial.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoAsistenciaVial", id);
			log.error("Formatos Error=> objetoFormatoAsistenciaVial=> " + id, e);

		}
		return re;
	}

	@Override
	public List<FormatoAsistenciaVial> listaDeFormatoAsistenciaVial() {
		TypedQuery<FormatoAsistenciaVial> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoAsistenciaVial> query = builder.createQuery(FormatoAsistenciaVial.class);
			final Root<FormatoAsistenciaVial> root = query.from(FormatoAsistenciaVial.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoAsistenciaVial_.enviadoFtp), 1),
					builder.isNull(root.get(FormatoAsistenciaVial_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoAsistenciaVial_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoAsistenciaVial", 500);
			log.error("Formatos Error=> listaDeFormatoAsistenciaVial", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarAsistenciaVial(

			String avAsegurado, String avNumInciso, String avNomAsegurado, Date avFecha, String avNumPoliza,
			String avClaveAjustador, String avEmail, Integer avPregunta6, String avPregunta5, Integer avPregunta4,
			Integer avPregunta3, Integer avPregunta2, Integer avPregunta1, String avNumReporte, Integer avId,
			String avComentarios, Integer avPregunta7, Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado

	) {
		String re2 = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_asistencia1");

			nat.registerStoredProcedureParameter("in_av_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_nom_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_fecha", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_num_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_clave_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_email", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_pregunta_6", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_pregunta_5", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_pregunta_4", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_pregunta_3", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_pregunta_2", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_pregunta_1", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_usuario", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_comentarios", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_av_pregunta_7", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_av_asegurado", avAsegurado);
			nat.setParameter("in_av_num_reporte", avNumReporte);
			nat.setParameter("in_av_nom_asegurado", avNomAsegurado);
			nat.setParameter("in_av_fecha", avFecha);
			nat.setParameter("in_av_num_poliza", avNumPoliza);
			nat.setParameter("in_av_clave_ajustador", avClaveAjustador);
			nat.setParameter("in_av_email", avEmail);
			nat.setParameter("in_av_pregunta_6", avPregunta6);
			nat.setParameter("in_av_pregunta_5", avPregunta5);
			nat.setParameter("in_av_pregunta_4", avPregunta4);
			nat.setParameter("in_av_pregunta_3", avPregunta3);
			nat.setParameter("in_av_pregunta_2", avPregunta2);
			nat.setParameter("in_av_pregunta_1", avPregunta1);
			nat.setParameter("in_av_num_reporte", avNumReporte);

			nat.setParameter("in_av_id", avId);
			nat.setParameter("in_av_comentarios", avComentarios);
			nat.setParameter("in_av_pregunta_7", avPregunta7);
			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			re2 = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarAsistenciaVial",

					avAsegurado, avNumInciso, avNomAsegurado, avFecha, avNumPoliza, avClaveAjustador, avEmail,
					avPregunta6, avPregunta5, avPregunta4, avPregunta3, avPregunta2, avPregunta1, avNumReporte, avId,
					avComentarios, avPregunta7, enviadoEmail, ////
					mensajeEmail, ////
					proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaAjustador,
					firmaAsegurado

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarAsistenciaVial =>" + avNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return re2;
	}

	@Override
	public String InsertarFormatoAsistenciaVial(DatosInsertarFormatoAsistenciaVial entradas) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("AV_NUM_REPORTE", entradas.getAvNumReporte());
		entry.put("AV_FECHA", entradas.getAvFecha());
		entry.put("AV_NUM_POLIZA", entradas.getAvNumPoliza());
		entry.put("AV_NUM_INCISO", entradas.getAvNumInciso());
		entry.put("AV_PREGUNTA_1", entradas.getAvPregunta1());
		entry.put("AV_PREGUNTA_2", entradas.getAvPregunta2());
		entry.put("AV_PREGUNTA_3", entradas.getAvPregunta3());
		entry.put("AV_PREGUNTA_4", entradas.getAvPregunta4());
		entry.put("AV_PREGUNTA_6", entradas.getAvPregunta6());
		entry.put("AV_PREGUNTA_7", entradas.getAvPregunta7());
		entry.put("AV_PREGUNTA_5", entradas.getAvPregunta5());
		entry.put("AV_COMENTARIOS", entradas.getAvComentarios());
		entry.put("AV_NOM_ASEGURADO", entradas.getAvNomAsegurado());
		entry.put("AV_EMAIL", entradas.getAvEmail());
		entry.put("AV_CLAVE_AJUSTADOR", entradas.getAvClaveAjustador());
		entry.put("AV_ASEGURADO", entradas.getAvAsegurado());
		entry.put("CHECK_1", entradas.getCheck_1());
		entry.put("CHECK_2", entradas.getCheck_2());
		entry.put("CHECK_3", entradas.getCheck_3());
		entry.put("CHECK_4", entradas.getCheck_4());
		entry.put("FIRMA_ASEGURADO", entradas.getFirma_Asegurado());
		entry.put("CORREO_OCULTO", entradas.getCorreo_oculto());
		entry.put("FUENTE_WS", entradas.getFuente_ws());
		entry.put("CHECK_5", entradas.getCheck_5());
		entry.put("CHECK_6", entradas.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFAV(entry);
		return result;
	}

	@Override
	public String ejecutarFuncionWebserviceStoreFAV(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FAV");

		String[] columnas = new String[] { "AV_NUM_REPORTE", "AV_FECHA", "AV_NUM_POLIZA", "AV_NUM_INCISO",
				"AV_PREGUNTA_1", "AV_PREGUNTA_2", "AV_PREGUNTA_3", "AV_PREGUNTA_4", "AV_PREGUNTA_6", "AV_PREGUNTA_7",
				"AV_PREGUNTA_5", "AV_COMENTARIOS", "AV_NOM_ASEGURADO", "AV_EMAIL", "AV_CLAVE_AJUSTADOR", "AV_ASEGURADO",
				"CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_ASEGURADO","CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6" };
		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(26, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(26));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_ASISTENCIA_VIAL where AV_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
		}
		return consecutivo;

	}
}