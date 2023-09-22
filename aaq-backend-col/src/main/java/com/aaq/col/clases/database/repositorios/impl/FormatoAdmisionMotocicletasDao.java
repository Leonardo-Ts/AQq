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

import com.aaq.col.clases.database.entidades.FormatoAdmisionMotocicletas;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoAdmisionMotocicletas_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoAdmisionMotocicletasDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoAdmisionMotocicletas;

@org.springframework.stereotype.Repository(value = "formatoAdmisionMotocicletasDao")
public class FormatoAdmisionMotocicletasDao extends SIICAServerGenericDaoJpaImpl<FormatoAdmisionMotocicletas>
		implements FormatoAdmisionMotocicletasDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoAdmisionMotocicletas objetoFormatoAdmisionMotocicletas(String id) {
		FormatoAdmisionMotocicletas re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoAdmisionMotocicletas.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			log.error("Formatos Error=> objetoFormatoAdmisionMotocicletas=> " + id, e);
		}
		return re;
	}

	@Override
	public List<FormatoAdmisionMotocicletas> listaDeFormatoAdmisionMotocicletas() {
		TypedQuery<FormatoAdmisionMotocicletas> typedQ = null;

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoAdmisionMotocicletas> query = builder
					.createQuery(FormatoAdmisionMotocicletas.class);
			final Root<FormatoAdmisionMotocicletas> root = query.from(FormatoAdmisionMotocicletas.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoAdmisionMotocicletas_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoAdmisionMotocicletas_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoAdmisionMotocicletas_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			log.error("Formatos Error=> listaDeFormatoAdmisionMotocicletas", e);
		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarAdmisionMotocicletas(

			String oaTipoAuto, String oaFolioElectro, String oaNumEndoso, String oaMarcaAuto, String oaEmailCliente,
			String oaDescDanios,

			Integer oaDeducible, String oaNumInciso, String oaNumPoliza, String oaNumReporte, Integer oaTManual,
			String oaPorcentajeDed, String oaNumSerie, String oaSumaAsegurada, Integer oaAdminDeducible,
			String oaNomAjustador, String oaTelCliente, String oaDaniosPre, String oaRazonResponsable,

			String oaNomCliente, String oaRazonTelefono, String oaRazonEnvio, String oaPlacaAuto,
			String oaRazonCobertura, String oaModeloAuto, Timestamp oaFecha, String oaAsegurado, String oaKilometraje,
			String oaCantidad, Integer oaTipoDeducible, String oaClaveAjustador, Integer oaPerdidaTotal,
			String oaRazonDomicilio, String oaNumSiniestro, String oaColorAuto, String oaAgravamiento, Integer oaId,
			Integer oaNivelInundacion, Integer enviadoEmail, ////
			String mensajeEmail, ///

			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado

	) {
		String respu = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_admisionAutos1");

			nat.registerStoredProcedureParameter("in_oaTipoAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaFolioElectro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaNumEndoso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaMarcaAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaEmailCliente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaDescDanios", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_oaDeducible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaNumInciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaNumPoliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaNumReporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaTManual", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaPorcentajeDed", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaNumSerie", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaSumaAsegurada", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaAdminDeducible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaNomAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaTelCliente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaDaniosPre", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaRazonResponsable", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_oaNomCliente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaRazonTelefono", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaRazonEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaPlacaAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaRazonCobertura", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaModeloAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaFecha", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaKilometraje", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaCantidad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaTipoDeducible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaClaveAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaPerdidaTotal", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaRazonDomicilio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaNumSiniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaColorAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_usuario", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaAgravamiento", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaId", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_oaNivelInundacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_oaTipoAuto", oaTipoAuto);
			nat.setParameter("in_oaFolioElectro", oaFolioElectro);
			nat.setParameter("in_oaNumEndoso", oaNumEndoso);
			nat.setParameter("in_oaMarcaAuto", oaMarcaAuto);
			nat.setParameter("in_oaEmailCliente", oaEmailCliente);
			nat.setParameter("in_oaDescDanios", oaDescDanios);

			nat.setParameter("in_oaDeducible", oaDeducible);
			nat.setParameter("in_oaNumInciso", oaNumInciso);
			nat.setParameter("in_oaNumPoliza", oaNumPoliza);
			nat.setParameter("in_oaNumReporte", oaNumReporte);
			nat.setParameter("in_oaTManual", oaTManual);
			nat.setParameter("in_oaPorcentajeDed", oaPorcentajeDed);
			nat.setParameter("in_oaNumSerie", oaNumSerie);
			nat.setParameter("in_oaSumaAsegurada", oaSumaAsegurada);
			nat.setParameter("in_oaAdminDeducible", oaAdminDeducible);
			nat.setParameter("in_oaNomAjustador", oaNomAjustador);
			nat.setParameter("in_oaTelCliente", oaTelCliente);
			nat.setParameter("in_oaDaniosPre", oaDaniosPre);
			nat.setParameter("in_oaRazonResponsable", oaRazonResponsable);

			nat.setParameter("in_oaNomCliente", oaNomCliente);
			nat.setParameter("in_oaRazonTelefono", oaRazonTelefono);
			nat.setParameter("in_oaRazonEnvio", oaRazonEnvio);
			nat.setParameter("in_oaPlacaAuto", oaPlacaAuto);
			nat.setParameter("in_oaRazonCobertura", oaRazonCobertura);
			nat.setParameter("in_oaModeloAuto", oaModeloAuto);
			nat.setParameter("in_oaFecha", oaFecha);
			nat.setParameter("in_oaAsegurado", oaAsegurado);
			nat.setParameter("in_oaKilometraje", oaKilometraje);
			nat.setParameter("in_oaCantidad", oaCantidad);
			nat.setParameter("in_oaTipoDeducible", oaTipoDeducible);
			nat.setParameter("in_oaClaveAjustador", oaClaveAjustador);
			nat.setParameter("in_oaPerdidaTotal", oaPerdidaTotal);
			nat.setParameter("in_oaRazonDomicilio", oaRazonDomicilio);
			nat.setParameter("in_oaNumSiniestro", oaNumSiniestro);
			nat.setParameter("in_oaColorAuto", oaColorAuto);

			nat.setParameter("in_oaAgravamiento", oaAgravamiento);
			nat.setParameter("in_oaId", oaId);
			nat.setParameter("in_oaNivelInundacion", oaNivelInundacion);
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
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarAdmisionMotocicletas",

					oaTipoAuto, oaFolioElectro, oaNumEndoso, oaMarcaAuto, oaEmailCliente, oaDescDanios,

					oaDeducible, oaNumInciso, oaNumPoliza, oaNumReporte, oaTManual, oaPorcentajeDed, oaNumSerie,
					oaSumaAsegurada, oaAdminDeducible, oaNomAjustador, oaTelCliente, oaDaniosPre, oaRazonResponsable,

					oaNomCliente, oaRazonTelefono, oaRazonEnvio, oaPlacaAuto, oaRazonCobertura, oaModeloAuto, oaFecha,
					oaAsegurado, oaKilometraje, oaCantidad, oaTipoDeducible, oaClaveAjustador, oaPerdidaTotal,
					oaRazonDomicilio, oaNumSiniestro, oaColorAuto, oaAgravamiento, oaId, oaNivelInundacion,
					enviadoEmail, ////
					mensajeEmail, ////

					proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaAjustador,
					firmaAsegurado

			);
			log.error("Formatos Error=> ejecutarFuncionInsertarAdmisionMotocicletas =>" + oaNumReporte, e);
			return "ERROR: " + e.getMessage();
		}
		return respu;
	}

	@Override
	public String InsertarFormatoAdmisionMotocicletas(DatosInsertarFormatoAdmisionMotocicletas entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("OA_FOLIO_ELECTRO", entrada.getOa_Folio_Electro());
		entry.put("OA_NUM_REPORTE", entrada.getOa_Num_Reporte());
		entry.put("OA_NUM_SINIESTRO", entrada.getOa_Num_Siniestro());
		entry.put("OA_ASEGURADO", entrada.getOa_Asegurado());
		entry.put("OA_FECHA", entrada.getOa_Fecha());
		entry.put("OA_NUM_POLIZA", entrada.getOa_Num_Poliza());
		entry.put("OA_NUM_ENDOSO", entrada.getOa_Num_Endoso());
		entry.put("OA_NUM_INCISO", entrada.getOa_Num_Inciso());
		entry.put("OA_NOM_CLIENTE", entrada.getOa_Nom_Cliente());
		entry.put("OA_EMAIL_CLIENTE", entrada.getOa_Email_Cliente());
		entry.put("OA_TEL_CLIENTE", entrada.getOa_Tel_Cliente());
		entry.put("OA_RAZON_ENVIO", entrada.getOa_Razon_Envio());
		entry.put("OA_RAZON_RESPONSABLE", entrada.getOa_Razon_Responsable());
		entry.put("OA_RAZON_TELEFONO", entrada.getOa_Razon_Telefono());
		entry.put("OA_RAZON_DOMICILIO", entrada.getOa_Razon_Domicilio());
		entry.put("OA_RAZON_COBERTURA", entrada.getOa_Razon_Cobertura());
		entry.put("OA_MARCA_AUTO", entrada.getOa_Marca_Auto());
		entry.put("OA_TIPO_AUTO", entrada.getOa_Tipo_Auto());
		entry.put("OA_KILOMETRAJE", entrada.getOa_Kilometraje());
		entry.put("OA_NUM_SERIE", entrada.getOa_Num_Serie());
		entry.put("OA_COLOR_AUTO", entrada.getOa_Color_Auto());
		entry.put("OA_PLACA_AUTO", entrada.getOa_Placa_Auto());
		entry.put("OA_T_MANUAL", entrada.getOa_T_Manual());
		entry.put("OA_DEDUCIBLE", entrada.getOa_Deducible());
		entry.put("OA_TIPO_DEDUCIBLE", entrada.getOa_Tipo_Deducible());
		entry.put("OA_ADMIN_DEDUCIBLE", entrada.getOa_Admin_Deducible());
		entry.put("OA_SUMA_ASEGURADA", entrada.getOa_Suma_Asegurada());
		entry.put("OA_PORCENTAJE_DED", entrada.getOa_Porcentaje_Ded());
		entry.put("OA_CANTIDAD", entrada.getOa_Cantidad());
		entry.put("OA_DESC_DANIOS", entrada.getOa_Desc_Danios());
		entry.put("OA_NIVEL_INUNDACION", entrada.getOa_Nivel_Inundacion());
		entry.put("OA_PERDIDA_TOTAL", entrada.getOa_Perdida_Total());
		entry.put("OA_DANIOS_PRE", entrada.getOa_Danios_Pre());
		entry.put("OA_NOM_AJUSTADOR", entrada.getOa_Nom_Ajustador());
		entry.put("OA_CLAVE_AJUSTADOR", entrada.getOa_Clave_Ajustador());
		entry.put("OA_MODELO_AUTO", entrada.getOa_Modelo_Auto());
		entry.put("OA_AGRAVAMIENTO", entrada.getOa_Agravamiento());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_AJUSTADOR", entrada.getFirma_Ajustador());
		entry.put("FIRMA_ASEGURADO", entrada.getFirma_Asegurado());
		entry.put("OA_CODIGO_QR", entrada.getOa_codigo_qr());
		entry.put("OA_PT_EVIDENTE", entrada.getOa_pt_evidente());
		entry.put("OA_ABANDONO", entrada.getOa_abandono());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFAM(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFAM(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FAM");
		String[] columnas = new String[] { "OA_FOLIO_ELECTRO", "OA_NUM_REPORTE", "OA_NUM_SINIESTRO", "OA_ASEGURADO",
				"OA_FECHA", "OA_NUM_POLIZA", "OA_NUM_ENDOSO", "OA_NUM_INCISO", "OA_NOM_CLIENTE", "OA_EMAIL_CLIENTE",
				"OA_TEL_CLIENTE", "OA_RAZON_ENVIO", "OA_RAZON_RESPONSABLE", "OA_RAZON_TELEFONO", "OA_RAZON_DOMICILIO",
				"OA_RAZON_COBERTURA", "OA_MARCA_AUTO", "OA_TIPO_AUTO", "OA_KILOMETRAJE", "OA_NUM_SERIE",
				"OA_COLOR_AUTO", "OA_PLACA_AUTO", "OA_T_MANUAL", "OA_DEDUCIBLE", "OA_TIPO_DEDUCIBLE",
				"OA_ADMIN_DEDUCIBLE", "OA_SUMA_ASEGURADA", "OA_PORCENTAJE_DED", "OA_CANTIDAD", "OA_DESC_DANIOS",
				"OA_NIVEL_INUNDACION", "OA_PERDIDA_TOTAL", "OA_DANIOS_PRE", "OA_NOM_AJUSTADOR", "OA_CLAVE_AJUSTADOR",
				"OA_MODELO_AUTO", "OA_AGRAVAMIENTO", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_AJUSTADOR",
				"FIRMA_ASEGURADO","OA_CODIGO_QR","OA_PT_EVIDENTE","OA_ABANDONO","CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6" };

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(51, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(51));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_ADMISION_MOTOCICLETAS where OA_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}
}