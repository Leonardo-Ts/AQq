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

import com.aaq.col.clases.database.entidades.FormatoReparacionBienes;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReparacionBienes_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoReparacionBienesDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReparacionBienes;

@org.springframework.stereotype.Repository(value = "formatoReparacionBienesDao")
public class FormatoReparacionBienesDao extends SIICAServerGenericDaoJpaImpl<FormatoReparacionBienes>
		implements FormatoReparacionBienesDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoReparacionBienes objetoFormatoReparacionBienes(String id) {
		FormatoReparacionBienes re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoReparacionBienes.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			log.error("Formatos Error=> objetoFormatoReparacionBienes=> " + id, e);

		}
		return re;
	}

	@Override
	public List<FormatoReparacionBienes> listaDeFormatoReparacionBienes() {
		TypedQuery<FormatoReparacionBienes> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoReparacionBienes> query = builder.createQuery(FormatoReparacionBienes.class);
			final Root<FormatoReparacionBienes> root = query.from(FormatoReparacionBienes.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoReparacionBienes_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoReparacionBienes_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoReparacionBienes_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			log.error("Formatos Error=> listaDeFormatoReparacionBienes", e);

		}
		return typedQ.getResultList();
	}

	@Override

	public String ejecutarFuncionInsertarReparacionBienes(

			Date fechaHora, String rbAsegurado, String rbCarMarca, String rbCarModelo, String rbClaveAjustador,
			Integer rbCuerpoA, String rbDanios, Integer rbDaniosPre, String rbDesDanios, String rbDomAfectado,
			String rbEmailRepara,

			String rbFolioElectro,

			String rbKm, String rbMaterial, String rbMedAlto, String rbMedAncho, String rbMedLong, String rbNomAfectado,
			String rbNomAjustador, String rbNomRepara, String rbNumEndoso, String rbNumFotos, String rbNumInciso,
			String rbNumPoliza, String rbNumReporte, String rbNumSiniestro, String rbObservaciones, String rbOtros,
			String rbRepreAfectado, String rbTelAfectado, String rbTelRepara,

			String rbTramo, String rbNomAsegurado, String rbMunicipio, String rbEstado,

			Integer enviadoEmail, ////
			String mensajeEmail, ///
			String rbEmailAfectado, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp,
			String nodoEnvio, Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador,
			String firmaAsegurado

	) {
		String resp = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_reparacion1");

			nat.registerStoredProcedureParameter("in_FECHA_HORA", Date.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_RB_ASEGURADO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_CAR_MARCA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_CAR_MODELO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_CLAVE_AJUSTADOR", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_CUERPO_A", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_DANIOS", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_DANIOS_PRE", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_DES_DANIOS", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_DOM_AFECTADO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_EMAIL_REPARA", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_RB_FOLIO_ELECTRO", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_RB_KM", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_MATERIAL", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_MED_ALTO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_MED_ANCHO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_MED_LONG", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_NOM_AFECTADO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_NOM_AJUSTADOR", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_NOM_REPARA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_NUM_ENDOSO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_NUM_FOTOS", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_NUM_INCISO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_NUM_POLIZA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_NUM_REPORTE", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_NUM_SINIESTRO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_OBSERVACIONES", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_OTROS", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_REPRE_AFECTADO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_TEL_AFECTADO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_TEL_REPARA", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_RB_TRAMO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_NOM_ASEGURADO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_MUNICIPIO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_RB_ESTADO", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);
			nat.registerStoredProcedureParameter("in_RB_EMAIL_AFECTADO", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);

			nat.setParameter("in_FECHA_HORA", fechaHora);
			nat.setParameter("in_RB_ASEGURADO", rbAsegurado);
			nat.setParameter("in_RB_CAR_MARCA", rbCarMarca);
			nat.setParameter("in_RB_CAR_MODELO", rbCarModelo);
			nat.setParameter("in_RB_CLAVE_AJUSTADOR", rbClaveAjustador);
			nat.setParameter("in_RB_CUERPO_A", rbCuerpoA);
			nat.setParameter("in_RB_DANIOS", rbDanios);
			nat.setParameter("in_RB_DANIOS_PRE", rbDaniosPre);
			nat.setParameter("in_RB_DES_DANIOS", rbDesDanios);
			nat.setParameter("in_RB_DOM_AFECTADO", rbDomAfectado);
			nat.setParameter("in_RB_EMAIL_REPARA", rbEmailRepara);

			nat.setParameter("in_RB_FOLIO_ELECTRO", rbFolioElectro);

			nat.setParameter("in_RB_KM", rbKm);
			nat.setParameter("in_RB_MATERIAL", rbMaterial);
			nat.setParameter("in_RB_MED_ALTO", rbMedAlto);
			nat.setParameter("in_RB_MED_ANCHO", rbMedAncho);
			nat.setParameter("in_RB_MED_LONG", rbMedLong);
			nat.setParameter("in_RB_NOM_AFECTADO", rbNomAfectado);
			nat.setParameter("in_RB_NOM_AJUSTADOR", rbNomAjustador);
			nat.setParameter("in_RB_NOM_REPARA", rbNomRepara);
			nat.setParameter("in_RB_NUM_ENDOSO", rbNumEndoso);
			nat.setParameter("in_RB_NUM_FOTOS", rbNumFotos);
			nat.setParameter("in_RB_NUM_INCISO", rbNumInciso);
			nat.setParameter("in_RB_NUM_POLIZA", rbNumPoliza);
			nat.setParameter("in_RB_NUM_REPORTE", rbNumReporte);
			nat.setParameter("in_RB_NUM_SINIESTRO", rbNumSiniestro);
			nat.setParameter("in_RB_OBSERVACIONES", rbObservaciones);
			nat.setParameter("in_RB_OTROS", rbOtros);
			nat.setParameter("in_RB_REPRE_AFECTADO", rbRepreAfectado);
			nat.setParameter("in_RB_TEL_AFECTADO", rbTelAfectado);
			nat.setParameter("in_RB_TEL_REPARA", rbTelRepara);

			nat.setParameter("in_RB_TRAMO", rbTramo);
			nat.setParameter("in_RB_NOM_ASEGURADO", rbNomAsegurado);
			nat.setParameter("in_RB_MUNICIPIO", rbMunicipio);
			nat.setParameter("in_RB_ESTADO", rbEstado);

			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			resp = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarReparacionBienes",

					fechaHora, rbAsegurado, rbCarMarca, rbCarModelo, rbClaveAjustador, rbCuerpoA, rbDanios, rbDaniosPre,
					rbDesDanios, rbDomAfectado, rbEmailRepara,

					rbFolioElectro,

					rbKm, rbMaterial, rbMedAlto, rbMedAncho, rbMedLong, rbNomAfectado, rbNomAjustador, rbNomRepara,
					rbNumEndoso, rbNumFotos, rbNumInciso, rbNumPoliza, rbNumReporte, rbNumSiniestro, rbObservaciones,
					rbOtros, rbRepreAfectado, rbTelAfectado, rbTelRepara,

					rbTramo, rbNomAsegurado, rbMunicipio, rbEstado,

					enviadoEmail, mensajeEmail, ////
					rbEmailAfectado, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
					firmaAjustador, firmaAsegurado

			);

			log.error("Formatos Error=> ejecutarFuncioninsertarReparacionBienes =>" + rbNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return resp;
	}

	@Override
	public String InsertarFormatoReparacionBienes(DatosInsertarFormatoReparacionBienes entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("RB_NUM_REPORTE", entrada.getRb_Num_Reporte());
		entry.put("RB_NUM_SINIESTRO", entrada.getRb_Num_Siniestro());
		entry.put("RB_FOLIO_ELECTRO", entrada.getRb_Folio_Electro());
		entry.put("RB_NUM_POLIZA", entrada.getRb_Num_Poliza());
		entry.put("RB_NUM_ENDOSO", entrada.getRb_Num_Endoso());
		entry.put("RB_NUM_INCISO", entrada.getRb_Num_Inciso());
		entry.put("RB_NOM_REPARA", entrada.getRb_Nom_Repara());
		entry.put("RB_EMAIL_REPARA", entrada.getRb_Email_Repara());
		entry.put("RB_TEL_REPARA", entrada.getRb_Tel_Repara());
		entry.put("RB_NOM_AFECTADO", entrada.getRb_Nom_Afectado());
		entry.put("RB_REPRE_AFECTADO", entrada.getRb_Repre_Afectado());
		entry.put("RB_TEL_AFECTADO", entrada.getRb_Tel_Afectado());
		entry.put("RB_DOM_AFECTADO", entrada.getRb_Dom_Afectado());
		entry.put("RB_DANIOS", entrada.getRb_Danios());
		entry.put("RB_MATERIAL", entrada.getRb_Material());
		entry.put("RB_MED_LONG", entrada.getRb_Med_Long());
		entry.put("RB_MED_ALTO", entrada.getRb_Med_Alto());
		entry.put("RB_MED_ANCHO", entrada.getRb_Med_Ancho());
		entry.put("RB_CAR_MARCA", entrada.getRb_Car_Marca());
		entry.put("RB_CAR_MODELO", entrada.getRb_Car_Modelo());
		entry.put("RB_TRAMO", entrada.getRb_Tramo());
		entry.put("RB_KM", entrada.getRb_Km());
		entry.put("RB_CUERPO_A", entrada.getRb_Cuerpo_A());
		entry.put("RB_OBSERVACIONES", entrada.getRb_Observaciones());
		entry.put("RB_DES_DANIOS", entrada.getRb_Des_Danios());
		entry.put("RB_NUM_FOTOS", entrada.getRb_Num_Fotos());
		entry.put("RB_DANIOS_PRE", entrada.getRb_Danios_Pre());
		entry.put("RB_OTROS", entrada.getRb_Otros());
		entry.put("RB_NOM_AJUSTADOR", entrada.getRb_Nom_Ajustador());
		entry.put("RB_CLAVE_AJUSTADOR", entrada.getRb_Clave_Ajustador());
		entry.put("RB_ASEGURADO", entrada.getRb_Asegurado());
		entry.put("FECHA_HORA", entrada.getFecha_Hora());
		entry.put("RB_MUNICIPIO", entrada.getRb_Municipio());
		entry.put("RB_ESTADO", entrada.getRb_Estado());
		entry.put("RB_NOM_ASEGURADO", entrada.getRb_Nom_Asegurado());
		entry.put("RB_EMAIL_AFECTADO", entrada.getRb_Email_Afectado());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_AJUSTADOR", entrada.getFirma_Ajustador());
		entry.put("FIRMA_ASEGURADO", entrada.getFirma_Asegurado());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFRB(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFRB(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FRB");

		String[] columnas = new String[] { "RB_NUM_REPORTE", "RB_NUM_SINIESTRO", "RB_FOLIO_ELECTRO", "RB_NUM_POLIZA",
				"RB_NUM_ENDOSO", "RB_NUM_INCISO", "RB_NOM_REPARA", "RB_EMAIL_REPARA", "RB_TEL_REPARA",
				"RB_NOM_AFECTADO", "RB_REPRE_AFECTADO", "RB_TEL_AFECTADO", "RB_DOM_AFECTADO", "RB_DANIOS",
				"RB_MATERIAL", "RB_MED_LONG", "RB_MED_ALTO", "RB_MED_ANCHO", "RB_CAR_MARCA", "RB_CAR_MODELO",
				"RB_TRAMO", "RB_KM", "RB_CUERPO_A", "RB_OBSERVACIONES", "RB_DES_DANIOS", "RB_NUM_FOTOS",
				"RB_DANIOS_PRE", "RB_OTROS", "RB_NOM_AJUSTADOR", "RB_CLAVE_AJUSTADOR", "RB_ASEGURADO", "FECHA_HORA",
				"RB_MUNICIPIO", "RB_ESTADO", "RB_NOM_ASEGURADO", "RB_EMAIL_AFECTADO", "CHECK_1", "CHECK_2", "CHECK_3",
				"CHECK_4", "FIRMA_AJUSTADOR", "FIRMA_ASEGURADO","CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6" };

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(47, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(47));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_REPARACION_BIENES where RB_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}
}