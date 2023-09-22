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

import com.aaq.col.clases.database.entidades.FormatoPaseMedico;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoPaseMedico_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoPaseMedicoDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoPaseMedico;

@org.springframework.stereotype.Repository(value = "formatoPaseMedicoDao")
public class FormatoPaseMedicoDao extends SIICAServerGenericDaoJpaImpl<FormatoPaseMedico>
		implements FormatoPaseMedicoDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoPaseMedico objetoFormatoPaseMedico(String id) {
		FormatoPaseMedico res = null;
		try {
			res = StringUtils.isNotBlank(id) ? this.getEntityManager().find(FormatoPaseMedico.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoPaseMedico", id);
			log.error("Formatos Error=> objetoFormatoPaseMedico=> " + id, e);

		}
		return res;
	}

	@Override
	public List<FormatoPaseMedico> listaDeFormatoPaseMedico() {
		TypedQuery<FormatoPaseMedico> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoPaseMedico> query = builder.createQuery(FormatoPaseMedico.class);
			final Root<FormatoPaseMedico> root = query.from(FormatoPaseMedico.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoPaseMedico_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoPaseMedico_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoPaseMedico_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoPaseMedico", 500);
			log.error("Formatos Error=> listaDeFormatoPaseMedico", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarMedico(

			String pmNombreAjustador, String pmNomMedico, String pmOtraLesion, String pmTelClinica,
			Integer pmLugarEmision, String pmClaveClinica, String pmAsegurado, Integer pmCoberturaAfec,
			Integer pmMedicoRed, Integer pmConvenio, String pmOtroVehiculo, String pmIdeLesionado, Integer pmId,
			String pmClaveMedico,

			String pmClaveAjustador, String pmEmailAsegurado, Integer pmTipoClinica, String pmEdadLesionado,
			String pmFolioElectro, Integer pmAmbulatoria, String pmDomClinica, Date pmFechaSiniestro,
			String pmNomLesionado, String pmNumEndoso, String pmNumSiniestro, String pmTelLesionado,

			String pmTelMedico, Date pmFechaEmision, String pmNomClinica, String pmOtraCobertura, String pmNomAsegurado,
			String pmLugarEstado, String pmNumOcupantes, Integer pmCausaLesion, String pmLesionesAparentes,
			Integer pmTipoVehiculo, String pmNumLesionado, String pmNumInciso, String pmNumPoliza, String pmNumReporte,
			Integer enviadoEmail, ////
			String mensajeEmail, ///
			String pmEmailLesionado, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp,
			String nodoEnvio, Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador,
			String firmaAsegurado, String firmaLesionado

	)

	{
		String resp = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_paseMedico1");

			nat.registerStoredProcedureParameter("in_pm_nombre_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_nom_medico", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_otra_lesion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_tel_clinica", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_lugar_emision", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_clave_clinica", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_cobertura_afec", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_medico_red", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_convenio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_otro_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_ide_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_id", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_clave_medico", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_pm_clave_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_email_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_tipo_clinica", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_edad_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_folio_electro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_ambulatoria", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_dom_clinica", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_fecha_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_nom_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_num_endoso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_num_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_tel_lesionado", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_pm_tel_medico", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_fecha_emision", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_nom_clinica", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_otra_cobertura", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_nom_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_lugar_estado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_num_ocupantes", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_causa_lesion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_lesiones_aparentes", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_tipo_vehiculo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_num_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_num_inciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_num_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_pm_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("in_pm_email_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);

			nat.setParameter("in_pm_nombre_ajustador", pmNombreAjustador);
			nat.setParameter("in_pm_nom_medico", pmNomMedico);
			nat.setParameter("in_pm_otra_lesion", pmOtraLesion);
			nat.setParameter("in_pm_tel_clinica", pmTelClinica);
			nat.setParameter("in_pm_lugar_emision", pmLugarEmision);
			nat.setParameter("in_pm_clave_clinica", pmClaveClinica);
			nat.setParameter("in_pm_asegurado", pmAsegurado);
			nat.setParameter("in_pm_cobertura_afec", pmCoberturaAfec);
			nat.setParameter("in_pm_medico_red", pmMedicoRed);
			nat.setParameter("in_pm_convenio", pmConvenio);
			nat.setParameter("in_pm_otro_vehiculo", pmOtroVehiculo);
			nat.setParameter("in_pm_ide_lesionado", pmIdeLesionado);
			nat.setParameter("in_pm_id", pmId);
			nat.setParameter("in_pm_clave_medico", pmClaveMedico);

			nat.setParameter("in_pm_clave_ajustador", pmClaveAjustador);
			nat.setParameter("in_pm_email_asegurado", pmEmailAsegurado);
			nat.setParameter("in_pm_tipo_clinica", pmTipoClinica);
			nat.setParameter("in_pm_edad_lesionado", pmEdadLesionado);
			nat.setParameter("in_pm_folio_electro", pmFolioElectro);
			nat.setParameter("in_pm_ambulatoria", pmAmbulatoria);
			nat.setParameter("in_pm_dom_clinica", pmDomClinica);
			nat.setParameter("in_pm_fecha_siniestro", pmFechaSiniestro);
			nat.setParameter("in_pm_nom_lesionado", pmNomLesionado);
			nat.setParameter("in_pm_num_endoso", pmNumEndoso);
			nat.setParameter("in_pm_num_siniestro", pmNumSiniestro);
			nat.setParameter("in_pm_tel_lesionado", pmTelLesionado);

			nat.setParameter("in_pm_tel_medico", pmTelMedico);
			nat.setParameter("in_pm_fecha_emision", pmFechaEmision);
			nat.setParameter("in_pm_nom_clinica", pmNomClinica);
			nat.setParameter("in_pm_otra_cobertura", pmOtraCobertura);
			nat.setParameter("in_pm_nom_asegurado", pmNomAsegurado);
			nat.setParameter("in_pm_lugar_estado", pmLugarEstado);
			nat.setParameter("in_pm_num_ocupantes", pmNumOcupantes);
			nat.setParameter("in_pm_causa_lesion", pmCausaLesion);
			nat.setParameter("in_pm_lesiones_aparentes", pmLesionesAparentes);
			nat.setParameter("in_pm_tipo_vehiculo", pmTipoVehiculo);
			nat.setParameter("in_pm_num_lesionado", pmNumLesionado);
			nat.setParameter("in_pm_num_inciso", pmNumInciso);
			nat.setParameter("in_pm_num_poliza", pmNumPoliza);
			nat.setParameter("in_pm_num_reporte", pmNumReporte);
			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_pm_email_lesionado", pmEmailLesionado);

			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			resp = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarMedico",

					pmNombreAjustador, pmNomMedico, pmOtraLesion, pmTelClinica, pmLugarEmision, pmClaveClinica,
					pmAsegurado, pmCoberturaAfec, pmMedicoRed, pmConvenio, pmOtroVehiculo, pmIdeLesionado, pmId,
					pmClaveMedico,

					pmClaveAjustador, pmEmailAsegurado, pmTipoClinica, pmEdadLesionado, pmFolioElectro, pmAmbulatoria,
					pmDomClinica, pmFechaSiniestro, pmNomLesionado, pmNumEndoso, pmNumSiniestro, pmTelLesionado,

					pmTelMedico, pmFechaEmision, pmNomClinica, pmOtraCobertura, pmNomAsegurado, pmLugarEstado,
					pmNumOcupantes, pmCausaLesion, pmLesionesAparentes, pmTipoVehiculo, pmNumLesionado, pmNumInciso,
					pmNumPoliza, pmNumReporte, enviadoEmail, ////
					mensajeEmail, ////
					pmEmailLesionado, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
					firmaAjustador, firmaAsegurado, firmaLesionado

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarMedico =>" + pmNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return resp;
	}

	@Override
	public String InsertarFormatoPaseMedico(DatosInsertarFormatoPaseMedico entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("PM_FOLIO_ELECTRO", entrada.getPm_Folio_Electro());
		entry.put("PM_NUM_REPORTE", entrada.getPm_Num_Reporte());
		entry.put("PM_NUM_SINIESTRO", entrada.getPm_Num_Siniestro());
		entry.put("PM_NUM_POLIZA", entrada.getPm_Num_Poliza());
		entry.put("PM_NUM_INCISO", entrada.getPm_Num_Inciso());
		entry.put("PM_NUM_ENDOSO", entrada.getPm_Num_Endoso());
		entry.put("PM_NOM_ASEGURADO", entrada.getPm_Nom_Asegurado());
		entry.put("PM_EMAIL_ASEGURADO", entrada.getPm_Email_Asegurado());
		entry.put("PM_LUGAR_EMISION", entrada.getPm_Lugar_Emision());
		entry.put("PM_LUGAR_ESTADO", entrada.getPm_Lugar_Estado());
		entry.put("PM_FECHA_EMISION", entrada.getPm_Fecha_Emision());
		entry.put("PM_FECHA_SINIESTRO", entrada.getPm_Fecha_Siniestro());
		entry.put("PM_NUM_OCUPANTES", entrada.getPm_Num_Ocupantes());
		entry.put("PM_TIPO_VEHICULO", entrada.getPm_Tipo_Vehiculo());
		entry.put("PM_OTRO_VEHICULO", entrada.getPm_Otro_Vehiculo());
		entry.put("PM_CAUSA_LESION", entrada.getPm_Causa_Lesion());
		entry.put("PM_OTRA_LESION", entrada.getPm_Otra_Lesion());
		entry.put("PM_COBERTURA_AFEC", entrada.getPm_Cobertura_Afec());
		entry.put("PM_OTRA_COBERTURA", entrada.getPm_Otra_Cobertura());
		entry.put("PM_NOM_LESIONADO", entrada.getPm_Nom_Lesionado());
		entry.put("PM_EDAD_LESIONADO", entrada.getPm_Edad_Lesionado());
		entry.put("PM_TEL_LESIONADO", entrada.getPm_Tel_Lesionado());
		entry.put("PM_NUM_LESIONADO", entrada.getPm_Num_Lesionado());
		entry.put("PM_AMBULATORIA", entrada.getPm_Ambulatoria());
		entry.put("PM_IDE_LESIONADO", entrada.getPm_Ide_Lesionado());
		entry.put("PM_LESIONES_APARENTES", entrada.getPm_Lesiones_Aparentes());
		entry.put("PM_TIPO_CLINICA", entrada.getPm_Tipo_Clinica());
		entry.put("PM_CONVENIO", entrada.getPm_Convenio());
		entry.put("PM_CLAVE_CLINICA", entrada.getPm_Clave_Clinica());
		entry.put("PM_NOM_CLINICA", entrada.getPm_Nom_Clinica());
		entry.put("PM_DOM_CLINICA", entrada.getPm_Dom_Clinica());
		entry.put("PM_TEL_CLINICA", entrada.getPm_Tel_Clinica());
		entry.put("PM_MEDICO_RED", entrada.getPm_Medico_red());
		entry.put("PM_CLAVE_MEDICO", entrada.getPm_Clave_Medico());
		entry.put("PM_NOM_MEDICO", entrada.getPm_Nom_Medico());
		entry.put("PM_TEL_MEDICO", entrada.getPm_Tel_Medico());
		entry.put("PM_NOM_AJUSTADOR", entrada.getPm_Nom_Ajustador());
		entry.put("PM_CLAVE_AJUSTADOR", entrada.getPm_Clave_Ajustador());
		entry.put("PM_ASEGURADO", entrada.getPm_Asegurado());
		entry.put("PM_EMAIL_LESIONADO", entrada.getPm_Email_Lesionado());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_AJUSTADOR", entrada.getFirma_Ajustador());
		entry.put("FIRMA_ASEGURADO", entrada.getFirma_Asegurado());
		entry.put("FIRMA_LESIONADO", entrada.getFirma_Lesionado());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFPM(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFPM(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FPM");

		String[] columnas = new String[] { "PM_FOLIO_ELECTRO", "PM_NUM_REPORTE", "PM_NUM_SINIESTRO", "PM_NUM_POLIZA",
				"PM_NUM_INCISO", "PM_NUM_ENDOSO", "PM_NOM_ASEGURADO", "PM_EMAIL_ASEGURADO", "PM_LUGAR_EMISION",
				"PM_LUGAR_ESTADO", "PM_FECHA_EMISION", "PM_FECHA_SINIESTRO", "PM_NUM_OCUPANTES", "PM_TIPO_VEHICULO",
				"PM_OTRO_VEHICULO", "PM_CAUSA_LESION", "PM_OTRA_LESION", "PM_COBERTURA_AFEC", "PM_OTRA_COBERTURA",
				"PM_NOM_LESIONADO", "PM_EDAD_LESIONADO", "PM_TEL_LESIONADO", "PM_NUM_LESIONADO", "PM_AMBULATORIA",
				"PM_IDE_LESIONADO", "PM_LESIONES_APARENTES", "PM_TIPO_CLINICA", "PM_CONVENIO", "PM_CLAVE_CLINICA",
				"PM_NOM_CLINICA", "PM_DOM_CLINICA", "PM_TEL_CLINICA", "PM_MEDICO_RED", "PM_CLAVE_MEDICO",
				"PM_NOM_MEDICO", "PM_TEL_MEDICO", "PM_NOM_AJUSTADOR", "PM_CLAVE_AJUSTADOR", "PM_ASEGURADO",
				"PM_EMAIL_LESIONADO", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_AJUSTADOR", "FIRMA_ASEGURADO",
				"FIRMA_LESIONADO","CORREO_OCULTO","FUENTE_WS" ,"CHECK_5", "CHECK_6"};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(52, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(52));
	}

	@Override
	public int obtenerConsecutivo(String reporte, String tipoAfectado) {
		int consecutivo = 0;
		int original = 0;
		try {

			String afectadoTemp = "";

			if (tipoAfectado.equals("1")) {
				afectadoTemp = "1";
			} else {

				original = (Integer.parseInt(tipoAfectado)) - 1;
				afectadoTemp = "T" + original;
			}

			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery("select count(*) from FORMATO_PASE_MEDICO where PM_NUM_REPORTE='" + reporte
							+ "' AND PM_ASEGURADO='" + afectadoTemp + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}