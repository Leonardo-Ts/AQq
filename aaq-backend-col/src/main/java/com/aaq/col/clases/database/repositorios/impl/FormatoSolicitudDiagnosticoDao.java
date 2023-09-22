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

import com.aaq.col.clases.database.entidades.FormatoSolicitudDiagnostico;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoSolicitudDiagnostico_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoSolicitudDiagnosticoDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoSolicitudDiagnostico;

@org.springframework.stereotype.Repository(value = "formatoSolicitudDiagnosticoDao")
public class FormatoSolicitudDiagnosticoDao extends SIICAServerGenericDaoJpaImpl<FormatoSolicitudDiagnostico>
		implements FormatoSolicitudDiagnosticoDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoSolicitudDiagnostico objetoFormatoSolicitudDiagnostico(String id) {
		FormatoSolicitudDiagnostico re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoSolicitudDiagnostico.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			log.error("Formatos Error=> objetoFormatoSolicitudDiagnostico=> " + id, e);

		}
		return re;
	}

	@Override
	public List<FormatoSolicitudDiagnostico> listaDeFormatoSolicitudDiagnostico() {
		TypedQuery<FormatoSolicitudDiagnostico> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoSolicitudDiagnostico> query = builder
					.createQuery(FormatoSolicitudDiagnostico.class);
			final Root<FormatoSolicitudDiagnostico> root = query.from(FormatoSolicitudDiagnostico.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoSolicitudDiagnostico_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoSolicitudDiagnostico_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoSolicitudDiagnostico_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			log.error("Formatos Error=> listaDeFormatoSolicitudDiagnostico", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarSolicitudDiagnostico(

			String sdNumReporte, Timestamp sdFecha,

			String sdNumPoliza, String sdNumEndoso, String sdNumInciso,

			String sdNumSiniestro, String sdNomCliente, String sdEmailCliente, String sdTelCliente, String sdRazonEnvio,
			String sdRazonResponsable, String sdRazonTelefono, String sdRazonDomicilio, String sdRazonCobertura,
			String sdMarcaAuto, String sdTipoAuto, String sdModeloAuto,

			String sdKilometrajeAuto, String sdNumSerie, String sdColorAuto, String sdPlacaAuto, Integer sdTransmision,
			String sdDaniosUnidad, String sdDescripcionDanios,

			String sdDaniosPre, String sdNomAjustador, String sdClaveAjustador, Integer enviadoFtp, String ftpRespuesta,
			Integer enviadoEmail, String mensajesEmail, Integer proceso, Timestamp horaEnvioEmail,
			Timestamp horaEnvioSftp, Integer check1, Integer check2, Integer check3, Integer check4,
			String firmaAjustador, String firmaAsegurado, String sdOtro, Integer sdNivelInundacion

	) {
		String respu = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_solicitudDiagnostico");

			nat.registerStoredProcedureParameter("in_sdNumReporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdFecha", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_sdNumPoliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdNumEndoso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdNumInciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdNumSiniestro", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_sdNomCliente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdEmailCliente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdTelCliente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdRazonEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdRazonResponsable", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdRazonTelefono", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdRazonDomicilio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdRazonCobertura", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdMarcaAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdTipoAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdModeloAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdKilometrajeAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdNumSerie", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_sdColorAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdPlacaAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdTransmision", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdDaniosUnidad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdDescripcionDanios", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdDaniosPre", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdNomAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdClaveAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoFtp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ftpRespuesta", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_mensajesEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_check1", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_check2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_check3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_check4", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_firmaAjustador", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_firmaAsegurado", String.class, ParameterMode.IN);///

			nat.registerStoredProcedureParameter("in_sdOtro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_sdid", String.class, ParameterMode.IN);

			nat.setParameter("in_sdNumReporte", sdNumReporte);
			nat.setParameter("in_sdFecha", sdFecha);

			nat.setParameter("in_sdNumPoliza", sdNumPoliza);
			nat.setParameter("in_sdNumEndoso", sdNumEndoso);
			nat.setParameter("in_sdNumInciso", sdNumInciso);

			nat.setParameter("in_sdNumSiniestro", sdNumSiniestro);
			nat.setParameter("in_sdNomCliente", sdNomCliente);
			nat.setParameter("in_sdEmailCliente", sdEmailCliente);
			nat.setParameter("in_sdTelCliente", sdTelCliente);
			nat.setParameter("in_sdRazonEnvio", sdRazonEnvio);
			nat.setParameter("in_sdRazonResponsable", sdRazonResponsable);
			nat.setParameter("in_sdRazonTelefono", sdRazonTelefono);
			nat.setParameter("in_sdRazonDomicilio", sdRazonDomicilio);
			nat.setParameter("in_sdRazonCobertura", sdRazonCobertura);
			nat.setParameter("in_sdMarcaAuto", sdMarcaAuto);
			nat.setParameter("in_sdTipoAuto", sdTipoAuto);
			nat.setParameter("in_sdModeloAuto", sdModeloAuto);
			nat.setParameter("in_sdKilometrajeAuto", sdKilometrajeAuto);

			nat.setParameter("in_sdNumSerie", sdNumSerie);
			nat.setParameter("in_sdColorAuto", sdColorAuto);
			nat.setParameter("in_sdPlacaAuto", sdPlacaAuto);
			nat.setParameter("in_sdTransmision", sdTransmision);
			nat.setParameter("in_sdDaniosUnidad", sdDaniosUnidad);
			nat.setParameter("in_sdDescripcionDanios", sdDescripcionDanios);
			nat.setParameter("in_sdDaniosPre", sdDaniosPre);
			nat.setParameter("in_sdNomAjustador", sdNomAjustador);
			nat.setParameter("in_sdClaveAjustador", sdClaveAjustador);
			nat.setParameter("in_enviadoFtp", enviadoFtp);
			nat.setParameter("in_ftpRespuesta", ftpRespuesta);
			nat.setParameter("in_enviadoEmail", enviadoEmail);
			nat.setParameter("in_mensajesEmail", mensajesEmail);
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("horaEnvioSftp", horaEnvioSftp);

			nat.setParameter("in_check1", check1);
			nat.setParameter("in_check2", check2);
			nat.setParameter("in_check3", check3);
			nat.setParameter("in_check4", check4);///
			nat.setParameter("in_firmaAjustador", firmaAjustador);///

			nat.setParameter("in_firmaAsegurado", firmaAsegurado);
			nat.setParameter("in_sdOtro", sdOtro);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			respu = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarSolicitudDiagnostico",

					sdNumReporte, sdFecha,

					sdNumPoliza, sdNumEndoso, sdNumInciso,

					sdNumSiniestro, sdNomCliente, sdEmailCliente, sdTelCliente, sdRazonEnvio, sdRazonResponsable,
					sdRazonTelefono, sdRazonDomicilio, sdRazonCobertura, sdMarcaAuto, sdTipoAuto, sdModeloAuto,

					sdKilometrajeAuto, sdNumSerie, sdColorAuto, sdPlacaAuto, sdTransmision, sdDaniosUnidad,
					sdDescripcionDanios,

					sdDaniosPre, sdNomAjustador, sdClaveAjustador, enviadoFtp, ftpRespuesta, enviadoEmail,
					mensajesEmail, proceso, horaEnvioEmail, horaEnvioSftp, check1, check2, check3, check4,
					firmaAjustador, firmaAsegurado, sdOtro, sdNivelInundacion

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarSolicitudDiagnostico =>" + sdNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return respu;
	}

	@Override
	public String InsertarFormatoSolicitudDiagnostico(DatosInsertarFormatoSolicitudDiagnostico entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("SD_NUM_REPORTE", entrada.getSd_Num_Reporte());
		entry.put("SD_FECHA", entrada.getSd_Fecha());
		entry.put("SD_NUM_POLIZA", entrada.getSd_Num_Poliza());
		entry.put("SD_NUM_ENDOSO", entrada.getSd_Num_Endoso());
		entry.put("SD_NUM_INCISO", entrada.getSd_Num_Inciso());
		entry.put("SD_NUM_SINIESTRO", entrada.getSd_Num_Siniestro());
		entry.put("SD_NOM_CLIENTE", entrada.getSd_Nom_Cliente());
		entry.put("SD_EMAIL_CLIENTE", entrada.getSd_Email_Cliente());
		entry.put("SD_TEL_CLIENTE", entrada.getSd_Tel_Cliente());
		entry.put("SD_RAZON_ENVIO", entrada.getSd_Razon_Envio());
		entry.put("SD_RAZON_RESPONSABLE", entrada.getSd_Razon_Responsable());
		entry.put("SD_RAZON_TELEFONO", entrada.getSd_Razon_Telefono());
		entry.put("SD_RAZON_DOMICILIO", entrada.getSd_Razon_Domicilio());
		entry.put("SD_RAZON_COBERTURA", entrada.getSd_Razon_Cobertura());
		entry.put("SD_MARCA_AUTO", entrada.getSd_Marca_Auto());
		entry.put("SD_TIPO_AUTO", entrada.getSd_Tipo_Auto());
		entry.put("SD_MODELO_AUTO", entrada.getSd_Modelo_Auto());
		entry.put("SD_KILOMETRAJE_AUTO", entrada.getSd_Kilometraje_Auto());
		entry.put("SD_NUM_SERIE", entrada.getSd_Num_Serie());
		entry.put("SD_COLOR_AUTO", entrada.getSd_Color_Auto());
		entry.put("SD_PLACA_AUTO", entrada.getSd_Placa_Auto());
		entry.put("SD_TRANSMISION", entrada.getSd_Transmision());
		entry.put("SD_DANIOS_UNIDAD", entrada.getSd_Danios_Unidad());
		entry.put("SD_DESCRIPCION_DANIOS", entrada.getSd_Descripcion_Danios());
		entry.put("SD_DANIOS_PRE", entrada.getSd_Danios_Pre());
		entry.put("SD_NOM_AJUSTADOR", entrada.getSd_Nom_Ajustador());
		entry.put("SD_CLAVE_AJUSTADOR", entrada.getSd_Clave_Ajustador());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_AJUSTADOR", entrada.getFirma_Ajustador());
		entry.put("FIRMA_ASEGURADO", entrada.getFirma_Asegurado());
		entry.put("SD_OTRO", entrada.getSd_Otro());
		entry.put("SD_NIVEL_INUNDACION", entrada.getSd_Nivel_Inundacion());
		entry.put("SD_DESCRIPCION_DANIOS_PRE", entrada.getSd_Descripcion_Danios_Pre());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFSD(entry);
		return result;
	}

	@Override
	public String ejecutarFuncionWebserviceStoreFSD(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FSD");

		String[] columnas = new String[] { "SD_NUM_REPORTE", "SD_FECHA", "SD_NUM_POLIZA", "SD_NUM_ENDOSO",
				"SD_NUM_INCISO", "SD_NUM_SINIESTRO", "SD_NOM_CLIENTE", "SD_EMAIL_CLIENTE", "SD_TEL_CLIENTE",
				"SD_RAZON_ENVIO", "SD_RAZON_RESPONSABLE", "SD_RAZON_TELEFONO", "SD_RAZON_DOMICILIO",
				"SD_RAZON_COBERTURA", "SD_MARCA_AUTO", "SD_TIPO_AUTO", "SD_MODELO_AUTO", "SD_KILOMETRAJE_AUTO",
				"SD_NUM_SERIE", "SD_COLOR_AUTO", "SD_PLACA_AUTO", "SD_TRANSMISION", "SD_DANIOS_UNIDAD",
				"SD_DESCRIPCION_DANIOS", "SD_DANIOS_PRE", "SD_NOM_AJUSTADOR", "SD_CLAVE_AJUSTADOR", "CHECK_1",
				"CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_AJUSTADOR", "FIRMA_ASEGURADO", "SD_OTRO", "SD_NIVEL_INUNDACION",
				"SD_DESCRIPCION_DANIOS_PRE","CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6" };

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(41, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(41));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_SOLICITUD_DIAGNOSTICO where SD_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}