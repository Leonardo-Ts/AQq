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

import com.aaq.col.clases.database.entidades.FormatoInspeccionPesado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoInspeccionPesado_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoInspeccionPesadoDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoInspeccionPesado;

@org.springframework.stereotype.Repository(value = "formatoInspeccionPesadoDao")
public class FormatoInspeccionPesadoDao extends SIICAServerGenericDaoJpaImpl<FormatoInspeccionPesado>
		implements FormatoInspeccionPesadoDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoInspeccionPesado objetoFormatoInspeccionPesado(String id) {
		FormatoInspeccionPesado re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoInspeccionPesado.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoInspeccionPesado", id);
			log.error("Formatos Error=> objetoFormatoInspeccionPesado=> " + id, e);

		}
		return re;
	}

	@Override
	public List<FormatoInspeccionPesado> listaDeFormatoInspeccionPesado() {
		TypedQuery<FormatoInspeccionPesado> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoInspeccionPesado> query = builder.createQuery(FormatoInspeccionPesado.class);
			final Root<FormatoInspeccionPesado> root = query.from(FormatoInspeccionPesado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoInspeccionPesado_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoInspeccionPesado_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoInspeccionPesado_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoInspeccionPesado", 500);
			log.error("Formatos Error=> listaDeFormatoInspeccionPesado", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarInspeccionPesado(

			String ipAsegurado, Date ipFecha, Integer ipEquipo, String ipTipo,

			Integer ipPagoSiNo, String ipUbicacion, Date ipDiaHora, Integer ipAdaptaciones, String ipAtencion,
			String ipColor,

			String ipNomAjustador, Integer ipImportacion1,

			Integer ipImportacion2, Integer ipPago, String ipModelo, String ipNumPoliza, Integer ipTipoEncargado,
			String ipEstandarT, Integer ipEquipoSiNo, String ipEmail,

			String ipOficina, String ipNomCliente, Integer ipCalificacion, String ipKilometraje,
			Integer ipAdaptacionesSiNo, Integer ipCirculacion, Integer ipTCirculacion1, Integer ipTCirculacion2,

			String ipTotalFotos, Integer ipDocumentacion1, Integer ipDocumentacion2,

			Integer ipProcedencia, String ipTelefono, String ipPuertasD, Date ipFechaInspeccion,
			Integer ipAseguradoCompa, String ipClaveAjustador, String ipPlacas, String ipCompania, String ipSolicitante,
			String ipNumSerie, String ipObservaciones, Integer ipSalvamentos, String ipNumReporte, String ipNumInciso,
			String ipNumSiniestro, String ipMarca, Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaCliente, String firmaAgente

	) {
		String res2 = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_admision1");

			nat.registerStoredProcedureParameter("in_ip_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_fecha", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_equipo", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_tipo", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_ip_pago_si_no", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_ubicacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_dia_hora", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_adaptaciones", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_atencion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_color", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_ip_nom_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_importacion_1", Integer.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_ip_importacion_2", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_pago", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_modelo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_num_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_tipo_encargado", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_estandar_t", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_equipo_si_no", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_email", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_ip_oficina", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_nom_cliente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_calificacion", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_kilometraje", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_adaptaciones_si_no", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_circulacion", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_t_circulacion_1", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_t_circulacion_2", Integer.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_ip_total_fotos", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_documentacion_1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_documentacion_2", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_ip_procedencia", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_telefono", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_puertas_d", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_fecha_inspeccion", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_asegurado_compa", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_clave_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_placas", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_compania", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_solicitante", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_numSerie", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_observaciones", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_salvamentos", Integer.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_ip_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_num_inciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ip_num_siniestro", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_ip_marca", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_ip_asegurado", ipAsegurado);
			nat.setParameter("in_ip_fecha", ipFecha);
			nat.setParameter("in_ip_equipo", ipEquipo);
			nat.setParameter("in_ip_tipo", ipTipo);

			nat.setParameter("in_ip_pago_si_no", ipPagoSiNo);
			nat.setParameter("in_ip_ubicacion", ipUbicacion);
			nat.setParameter("in_ip_dia_hora", ipDiaHora);
			nat.setParameter("in_ip_adaptaciones", ipAdaptaciones);
			nat.setParameter("in_ip_atencion", ipAtencion);
			nat.setParameter("in_ip_color", ipColor);

			nat.setParameter("in_ip_nom_ajustador", ipNomAjustador);
			nat.setParameter("in_ip_importacion_1", ipImportacion1);

			nat.setParameter("in_ip_importacion_2", ipImportacion2);
			nat.setParameter("in_ip_pago", ipPago);
			nat.setParameter("in_ip_modelo", ipModelo);
			nat.setParameter("in_ip_num_poliza", ipNumPoliza);
			nat.setParameter("in_ip_tipo_encargado", ipTipoEncargado);
			nat.setParameter("in_ip_estandar_t", ipEstandarT);
			nat.setParameter("in_ip_equipo_si_no", ipEquipoSiNo);
			nat.setParameter("in_ip_email", ipEmail);

			nat.setParameter("in_ip_oficina", ipOficina);
			nat.setParameter("in_ip_nom_cliente", ipNomCliente);
			nat.setParameter("in_ip_calificacion", ipCalificacion);
			nat.setParameter("in_ip_kilometraje", ipKilometraje);
			nat.setParameter("in_ip_adaptaciones_si_no", ipAdaptacionesSiNo);
			nat.setParameter("in_ip_circulacion", ipCirculacion);
			nat.setParameter("in_ip_t_circulacion_1", ipTCirculacion1);
			nat.setParameter("in_ip_t_circulacion_2", ipTCirculacion2);

			nat.setParameter("in_ip_total_fotos", ipTotalFotos);
			nat.setParameter("in_ip_documentacion_1", ipDocumentacion1);
			nat.setParameter("in_ip_documentacion_2", ipDocumentacion2);

			nat.setParameter("in_ip_procedencia", ipProcedencia);
			nat.setParameter("in_ip_telefono", ipTelefono);
			nat.setParameter("in_ip_puertas_d", ipPuertasD);
			nat.setParameter("in_ip_fecha_inspeccion", ipFechaInspeccion);
			nat.setParameter("in_ip_asegurado_compa", ipAseguradoCompa);
			nat.setParameter("in_ip_clave_ajustador", ipClaveAjustador);
			nat.setParameter("in_ip_placas", ipPlacas);
			nat.setParameter("in_ip_compania", ipCompania);
			nat.setParameter("in_ip_solicitante", ipSolicitante);
			nat.setParameter("in_ip_num_serie", ipNumSerie);
			nat.setParameter("in_ip_observaciones", ipObservaciones);
			nat.setParameter("in_ip_salvamentos", ipSalvamentos);

			nat.setParameter("in_ip_num_reporte", ipNumReporte);
			nat.setParameter("in_ip_num_inciso", ipNumInciso);
			nat.setParameter("in_ip_num_siniestro", ipNumSiniestro);
			nat.setParameter("in_ip_marca", ipMarca);
			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);
			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res2 = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarInspeccionPesado",

					ipAsegurado, ipFecha, ipEquipo, ipTipo,

					ipPagoSiNo, ipUbicacion, ipDiaHora, ipAdaptaciones, ipAtencion, ipColor,

					ipNomAjustador, ipImportacion1,

					ipImportacion2, ipPago, ipModelo, ipNumPoliza, ipTipoEncargado, ipEstandarT, ipEquipoSiNo, ipEmail,

					ipOficina, ipNomCliente, ipCalificacion, ipKilometraje, ipAdaptacionesSiNo, ipCirculacion,
					ipTCirculacion1, ipTCirculacion2,

					ipTotalFotos, ipDocumentacion1, ipDocumentacion2,

					ipProcedencia, ipTelefono, ipPuertasD, ipFechaInspeccion, ipAseguradoCompa, ipClaveAjustador,
					ipPlacas, ipCompania, ipSolicitante, ipNumSerie, ipObservaciones, ipSalvamentos, ipNumReporte,
					ipNumInciso, ipNumSiniestro, ipMarca, enviadoEmail, ////
					mensajeEmail, ////
					proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaCliente,
					firmaAgente

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarInspeccionPesado =>" + ipNumReporte, e);
			return "ERROR: " + e.getMessage();
		}
		return res2;
	}

	@Override
	public String InsertarFormatoInspeccionPesado(DatosInsertarFormatoInspeccionPesado entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("IP_SOLICITANTE", entrada.getIp_Solicitante());
		entry.put("IP_OFICINA", entrada.getIp_Oficina());
		entry.put("IP_TELEFONO", entrada.getIp_Telefono());
		entry.put("IP_FECHA", entrada.getIp_Fecha());
		entry.put("IP_ATENCION", entrada.getIp_Atencion());
		entry.put("IP_DIA_HORA", entrada.getIp_Dia_hora());
		entry.put("IP_UBICACION", entrada.getIp_Ubicacion());
		entry.put("IP_EMAIL", entrada.getIp_Email());
		entry.put("IP_TIPO", entrada.getIp_Tipo());
		entry.put("IP_MODELO", entrada.getIp_Modelo());
		entry.put("IP_PLACAS", entrada.getIp_Placas());
		entry.put("IP_PUERTAS_D", entrada.getIp_Puertas_D());
		entry.put("IP_ESTANDAR_T", entrada.getIp_Estandar_T());
		entry.put("IP_COLOR", entrada.getIp_Color());
		entry.put("IP_NUM_SERIE", entrada.getIp_Num_Serie());
		entry.put("IP_KILOMETRAJE", entrada.getIp_Kilometraje());
		entry.put("IP_OBSERVACIONES", entrada.getIp_Observaciones());
		entry.put("IP_PROCEDENCIA", entrada.getIp_Procedencia());
		entry.put("IP_SALVAMENTOS", entrada.getIp_Salvamentos());
		entry.put("IP_TOTAL_FOTOS", entrada.getIp_Total_Fotos());
		entry.put("IP_FECHA_INSPECCION", entrada.getIp_Fecha_Inspeccion());
		entry.put("IP_TIPO_ENCARGADO", entrada.getIp_Tipo_Encargado());
		entry.put("IP_NOM_CLIENTE", entrada.getIp_Nom_Cliente());
		entry.put("IP_NOM_AJUSTADOR", entrada.getIp_Nom_Ajustador());
		entry.put("IP_CIRCULACION", entrada.getIp_Circulacion());
		entry.put("IP_IMPORTACION_1", entrada.getIp_Importacion_1());
		entry.put("IP_T_CIRCULACION_1", entrada.getIp_T_Circulacion_1());
		entry.put("IP_T_CIRCULACION_2", entrada.getIp_T_Circulacion_2());
		entry.put("IP_IMPORTACION_2", entrada.getIp_Importacion_2());
		entry.put("IP_CALIFICACION", entrada.getIp_Calificacion());
		entry.put("IP_PAGO", entrada.getIp_Pago());
		entry.put("IP_EQUIPO", entrada.getIp_Equipo());
		entry.put("IP_ADAPTACIONES", entrada.getIp_Adaptaciones());
		entry.put("IP_PAGO_SI_NO", entrada.getIp_Pago_Si_No());
		entry.put("IP_EQUIPO_SI_NO", entrada.getIp_Equipo_Si_No());
		entry.put("IP_ADAPTACIONES_SI_NO", entrada.getIp_Adaptaciones_Si_No());
		entry.put("IP_DOCUMENTACION_1", entrada.getIp_Documentacion_1());
		entry.put("IP_DOCUMENTACION_2", entrada.getIp_Documentacion_2());
		entry.put("IP_ASEGURADO_COMPA", entrada.getIp_Asegurado_Compa());
		entry.put("IP_NUM_POLIZA", entrada.getIp_Num_Poliza());
		entry.put("IP_COMPANIA", entrada.getIp_Compania());
		entry.put("IP_CLAVE_AJUSTADOR", entrada.getIp_Clave_Ajustador());
		entry.put("IP_ASEGURADO", entrada.getIp_Asegurado());
		entry.put("IP_NUM_REPORTE", entrada.getIp_Num_Reporte());
		entry.put("IP_NUM_SINIESTRO", entrada.getIp_Num_Siniestro());
		entry.put("IP_NUM_INCISO", entrada.getIp_Num_Inciso());
		entry.put("IP_MARCA", entrada.getIp_Marca());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_CLIENTE", entrada.getFirma_Cliente());
		entry.put("FIRMA_AGENTE", entrada.getFirma_Agente());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFIP(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFIP(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FIP");

		String[] columnas = new String[] { "IP_SOLICITANTE", "IP_OFICINA", "IP_TELEFONO", "IP_FECHA", "IP_ATENCION",
				"IP_DIA_HORA", "IP_UBICACION", "IP_EMAIL", "IP_TIPO", "IP_MODELO", "IP_PLACAS", "IP_PUERTAS_D",
				"IP_ESTANDAR_T", "IP_COLOR", "IP_NUM_SERIE", "IP_KILOMETRAJE", "IP_OBSERVACIONES", "IP_PROCEDENCIA",
				"IP_SALVAMENTOS", "IP_TOTAL_FOTOS", "IP_FECHA_INSPECCION", "IP_TIPO_ENCARGADO", "IP_NOM_CLIENTE",
				"IP_NOM_AJUSTADOR", "IP_CIRCULACION", "IP_IMPORTACION_1", "IP_T_CIRCULACION_1", "IP_T_CIRCULACION_2",
				"IP_IMPORTACION_2", "IP_CALIFICACION", "IP_PAGO", "IP_EQUIPO", "IP_ADAPTACIONES", "IP_PAGO_SI_NO",
				"IP_EQUIPO_SI_NO", "IP_ADAPTACIONES_SI_NO", "IP_DOCUMENTACION_1", "IP_DOCUMENTACION_2",
				"IP_ASEGURADO_COMPA", "IP_NUM_POLIZA", "IP_COMPANIA", "IP_CLAVE_AJUSTADOR", "IP_ASEGURADO",
				"IP_NUM_REPORTE", "IP_NUM_SINIESTRO", "IP_NUM_INCISO", "IP_MARCA", "CHECK_1", "CHECK_2", "CHECK_3",
				"CHECK_4", "FIRMA_CLIENTE", "FIRMA_AGENTE","CORREO_OCULTO","FUENTE_WS" ,"CHECK_5", "CHECK_6"};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(58, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(58));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_INSPECCION_PESADO where IP_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
		}
		return consecutivo;

	}

}