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

import com.aaq.col.clases.database.entidades.FormatoGarantiaPrendaria;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoGarantiaPrendaria_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoGarantiaPrendariaDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoGarantiaPrendaria;

@org.springframework.stereotype.Repository(value = "formatoGarantiaPrendariaDao")
public class FormatoGarantiaPrendariaDao extends SIICAServerGenericDaoJpaImpl<FormatoGarantiaPrendaria>
		implements FormatoGarantiaPrendariaDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoGarantiaPrendaria objetoFormatoGarantiaPrendaria(String id) {
		FormatoGarantiaPrendaria re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoGarantiaPrendaria.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoGarantiaPrendaria", id);
			log.error("Formatos Error=> objetoFormatoGarantiaPrendaria=> " + id, e);
		}
		return re;
	}

	@Override
	public List<FormatoGarantiaPrendaria> listaDeFormatoGarantiaPrendaria() {
		TypedQuery<FormatoGarantiaPrendaria> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoGarantiaPrendaria> query = builder.createQuery(FormatoGarantiaPrendaria.class);
			final Root<FormatoGarantiaPrendaria> root = query.from(FormatoGarantiaPrendaria.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoGarantiaPrendaria_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoGarantiaPrendaria_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoGarantiaPrendaria_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFormatoGarantiaPrendaria", 500);
			log.error("Formatos Error=> listaDeFormatoGarantiaPrendaria", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarGarantia(String gpSr, String gpSrCalle, String gpSrColonia,
			String gpSrMunicipio, String gpSrCp, String gpSrCiudad, String gpSrIdentificacion, String gpCantidad,
			String gpCantidadLetra, String gpMarcaAuto, String gpTipoAuto, String gpModeloAuto, String gpPlacasAuto,
			String gpColorAuto, String gpNumPoliza, String gpBienes, String gpFactura, String gpFacturaExpedida,
			Date gpFacturaFecha, String gpDias, Date gpFecha, Date gpFechaFirma, String gpNomDeudor,
			String gpNomAcreedor, String gpNumReporte, String gpNumInciso, String gpClaveAjustador, String gpAsegurado,

			String emailDefault, Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaDeudor, String firmaAcreedor

	) {
		String re = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_garantia1");

			//
			nat.registerStoredProcedureParameter("in_gp_sr", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_sr_calle", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_sr_colonia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_sr_municipio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_sr_cp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_sr_ciudad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_sr_identificacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_cantidad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_cantidad_letra", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_marca_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_tipo_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_modelo_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_placas_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_color_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_num_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_bienes", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_factura", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_factura_expedida", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_factura_fecha", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_dias", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_fecha", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_fecha_firma", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_nom_deudor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_nom_acreedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_num_inciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_clave_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_gp_asegurado", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_emailDefault", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///

			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_gp_sr", gpSr);
			nat.setParameter("in_gp_sr_calle", gpSrCalle);
			nat.setParameter("in_gp_sr_colonia", gpSrColonia);
			nat.setParameter("in_gp_sr_municipio", gpSrMunicipio);
			nat.setParameter("in_gp_sr_cp", gpSrCp);
			nat.setParameter("in_gp_sr_ciudad", gpSrCiudad);
			nat.setParameter("in_gp_sr_identificacion", gpSrIdentificacion);
			nat.setParameter("in_gp_cantidad", gpCantidad);
			nat.setParameter("in_gp_cantidad_letra", gpCantidadLetra);
			nat.setParameter("in_gp_marca_auto", gpMarcaAuto);
			nat.setParameter("in_gp_tipo_auto", gpTipoAuto);
			nat.setParameter("in_gp_modelo_auto", gpModeloAuto);
			nat.setParameter("in_gp_placas_uto", gpPlacasAuto);
			nat.setParameter("in_gp_color_auto", gpColorAuto);
			nat.setParameter("in_gp_num_poliza", gpNumPoliza);
			nat.setParameter("in_gp_bienes", gpBienes);
			nat.setParameter("in_gp_factura", gpFactura);
			nat.setParameter("in_gp_factura_expedida", gpFacturaExpedida);
			nat.setParameter("in_gp_factura_fecha", gpFacturaFecha);
			nat.setParameter("in_gp_dias", gpDias);
			nat.setParameter("in_gp_fecha", gpFecha);
			nat.setParameter("in_gp_fecha_firma", gpFechaFirma);
			nat.setParameter("in_gp_nom_deudor", gpNomDeudor);
			nat.setParameter("in_gp_nom_acreedor", gpNomAcreedor);
			nat.setParameter("in_gp_num_reporte", gpNumReporte);
			nat.setParameter("in_gp_num_inciso", gpNumInciso);

			nat.setParameter("in_gp_clave_ajustador", gpClaveAjustador);

			nat.setParameter("in_emailDefault", emailDefault);
			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			re = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionInsertarGarantia",

					gpSr, gpSrCalle, gpSrColonia, gpSrMunicipio, gpSrCp, gpSrCiudad, gpSrIdentificacion, gpCantidad,
					gpCantidadLetra, gpMarcaAuto, gpTipoAuto, gpModeloAuto, gpPlacasAuto, gpColorAuto, gpNumPoliza,
					gpBienes, gpFactura, gpFacturaExpedida, gpFacturaFecha, gpDias, gpFecha, gpFechaFirma, gpNomDeudor,
					gpNomAcreedor, gpNumReporte, gpNumInciso, gpClaveAjustador, gpAsegurado,

					emailDefault, enviadoEmail, ////
					mensajeEmail, ////
					proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaDeudor,
					firmaAcreedor

			);
			log.error("Formatos Error=> ejecutarFuncionInsertarGarantia =>" + gpNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return re;
	}

	@Override
	public String InsertarFormatoGarantiaPrendaria(DatosInsertarFormatoGarantiaPrendaria entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("GP_SR", entrada.getGp_Sr());
		entry.put("GP_SR_CALLE", entrada.getGp_Sr_Calle());
		entry.put("GP_SR_COLONIA", entrada.getGp_Sr_Colonia());
		entry.put("GP_SR_MUNICIPIO", entrada.getGp_Sr_Municipio());
		entry.put("GP_SR_CP", entrada.getGp_Sr_Cp());
		entry.put("GP_SR_CIUDAD", entrada.getGp_Sr_Ciudad());
		entry.put("GP_SR_IDENTIFICACION", entrada.getGp_Sr_Identificacion());
		entry.put("GP_CANTIDAD", entrada.getGp_Cantidad());
		entry.put("GP_CANTIDAD_LETRA", entrada.getGp_Cantidad_Letra());
		entry.put("GP_MARCA_AUTO", entrada.getGp_Marca_Auto());
		entry.put("GP_TIPO_AUTO", entrada.getGp_Tipo_Auto());
		entry.put("GP_MODELO_AUTO", entrada.getGp_Modelo_Auto());
		entry.put("GP_PLACAS_AUTO", entrada.getGp_Placas_Auto());
		entry.put("GP_COLOR_AUTO", entrada.getGp_Color_Auto());
		entry.put("GP_NUM_POLIZA", entrada.getGp_Num_Poliza());
		entry.put("GP_BIENES", entrada.getGp_Bienes());
		entry.put("GP_FACTURA", entrada.getGp_Factura());
		entry.put("GP_FACTURA_EXPEDIDA", entrada.getGp_Factura_Expedida());
		entry.put("GP_FACTURA_FECHA", entrada.getGp_Factura_Fecha());
		entry.put("GP_DIAS", entrada.getGp_Dias());
		entry.put("GP_FECHA", entrada.getGp_Fecha());
		entry.put("GP_FECHA_FIRMA", entrada.getGp_Fecha_Firma());
		entry.put("GP_NOM_DEUDOR", entrada.getGp_Nom_Deudor());
		entry.put("GP_NOM_ACREEDOR", entrada.getGp_Nom_Acreedor());
		entry.put("GP_NUM_REPORTE", entrada.getGp_Num_Reporte());
		entry.put("GP_NUM_INCISO", entrada.getGp_Num_Inciso());
		entry.put("EMAIL_DEFAULT", entrada.getEmail_Default());
		entry.put("GP_ASEGURADO", entrada.getGp_Asegurado());
		entry.put("GP_CLAVE_AJUSTADOR", entrada.getGp_Clave_Ajustador());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_DEUDOR", entrada.getFirma_Deudor());
		entry.put("FIRMA_ACREEDOR", entrada.getFirma_Acreedor());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFGP(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFGP(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FGP");

		String[] columnas = new String[] { "GP_SR", "GP_SR_CALLE", "GP_SR_COLONIA", "GP_SR_MUNICIPIO", "GP_SR_CP",
				"GP_SR_CIUDAD", "GP_SR_IDENTIFICACION", "GP_CANTIDAD", "GP_CANTIDAD_LETRA", "GP_MARCA_AUTO",
				"GP_TIPO_AUTO", "GP_MODELO_AUTO", "GP_PLACAS_AUTO", "GP_COLOR_AUTO", "GP_NUM_POLIZA", "GP_BIENES",
				"GP_FACTURA", "GP_FACTURA_EXPEDIDA", "GP_FACTURA_FECHA", "GP_DIAS", "GP_FECHA", "GP_FECHA_FIRMA",
				"GP_NOM_DEUDOR", "GP_NOM_ACREEDOR", "GP_NUM_REPORTE", "GP_NUM_INCISO", "EMAIL_DEFAULT", "GP_ASEGURADO",
				"GP_CLAVE_AJUSTADOR", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_DEUDOR", "FIRMA_ACREEDOR",
				"CORREO_OCULTO","FUENTE_WS" ,"CHECK_5", "CHECK_6"};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(40, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(40));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_GARANTIA_PRENDARIA where GP_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
		}
		return consecutivo;

	}

}