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

import com.aaq.col.clases.database.entidades.FormatoResponsabilidadCivil;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoResponsabilidadCivil_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoResponsabilidadCivilDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoResponsabilidadCivil;

@org.springframework.stereotype.Repository(value = "formatoResponsabilidadCivilDao")
public class FormatoResponsabilidadCivilDao extends SIICAServerGenericDaoJpaImpl<FormatoResponsabilidadCivil>
		implements FormatoResponsabilidadCivilDaoInterfase {
	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoResponsabilidadCivil objetoFormatoResponsabilidadCivil(String id) {
		FormatoResponsabilidadCivil de = null;
		try {
			de = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoResponsabilidadCivil.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoResponsabilidadCivil",
			// id);
			log.error("Formatos Error=> objetoFormatoResponsabilidadCivil=> " + id, e);

		}
		return de;
	}

	@Override
	public List<FormatoResponsabilidadCivil> listaDeFormatoResponsabilidadCivil() {
		TypedQuery<FormatoResponsabilidadCivil> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoResponsabilidadCivil> query = builder
					.createQuery(FormatoResponsabilidadCivil.class);
			final Root<FormatoResponsabilidadCivil> root = query.from(FormatoResponsabilidadCivil.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoResponsabilidadCivil_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoResponsabilidadCivil_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoResponsabilidadCivil_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoResponsabilidadCivil",
			// 500);
			log.error("Formatos Error=> listaDeFormatoResponsabilidadCivil", e);
		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarResponsabilidadCivil(String rc_num_reporte, String rc_num_siniestro,
			String rc_num_poliza, String rc_num_asegurado, Date rc_fecha_siniestro, String rc_folio_dua,
			Integer rc_vehiculo_q, String rc_compania_trans_mer, String rc_reporte_vehiculo, String rc_nom_propietario,
			String rc_tel_propietario, String rc_correo_propietario, String rc_nom_transportista,
			String rc_tel_transportista, String rc_correo_transportista, String rc_dir_siniestro,
			String rc_entidad_siniestro, String rc_dir_resguardo, String rc_entidad_resguardo, String rc_responsable,
			String rc_entidad_resp, String rc_tel_responsable, Integer rc_tipo_siniestro, String rc_num_acta,
			String rc_descripcion_veh, String rc_nom_operador, Integer rc_opc_ebriedad, Integer rc_opc_licencia,
			String rc_dictamen, Integer rc_opc_carga_daniada, String rc_descripcion_merc, String rc_porcentaje_aprox,
			String rc_opc_seguro_trans, String rc_nom_aseguradora, Integer rc_opc_interviene_a,
			Integer rc_opc_traspaleo_c, String rc_folio_carta, String rc_folio_factura, String rc_folio_remision,
			String rc_folio_guia, String rc_folio_mapa, String rc_informe_ajustador, String rc_nom_ajustador,
			String rc_clave_ajustador, String rc_nom_asegurado_tercero, String rc_nom_asegurado,
			String rc_documentos_req, Integer check_1, Integer check_2, Integer check_3, Integer check_4,
			String croquis, String firma_ajustador, String firma_asegurado_tercero, String firma_asegurado,
			Integer enviadoEmail, String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail,
			Timestamp horaEnvioSftp, String nodoEnvio, Integer numConsecutivo

	) {
		String res = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_tarjeta_credito");

			nat.registerStoredProcedureParameter("in_tcNumReporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcNumSiniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcNumAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcNumAutorizacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcNombre", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcFecha", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcDireccion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcEstado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcCp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcTelefono", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcCantidadAutorizada", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcPagoOpcion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcNumTarjeta", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcVencimientoTarjeta", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_tcClaveAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_firmaTarjetahabiente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_check1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_check2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_check3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_check4", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			/*
			 * nat.setParameter("in_tcNumReporte", tcNumReporte );
			 * nat.setParameter("in_tcNumSiniestro", tcNumSiniestro);
			 * nat.setParameter("in_tcNumAsegurado",tcNumSiniestro );
			 * nat.setParameter("in_tcNumAutorizacion", tcNumAutorizacion);
			 * nat.setParameter("in_tcNombre", tcNombre); nat.setParameter("in_tcFecha",
			 * tcFecha ); nat.setParameter("in_tcDireccion",tcDireccion );
			 * nat.setParameter("in_tcEstado", tcEstado); nat.setParameter("in_tcCp",tcCp );
			 * nat.setParameter("in_tcTelefono", tcTelefono );
			 * nat.setParameter("in_tcCantidadAutorizada", tcCantidadAutorizada );
			 * nat.setParameter("in_tcPagoOpcion", tcPagoOpcion );
			 * nat.setParameter("in_tcNumTarjeta",tcNumTarjeta );
			 * nat.setParameter("in_tcVencimientoTarjeta", tcVencimientoTarjeta );
			 * nat.setParameter("in_tcClaveAjustador",tcClaveAjustador );
			 * nat.setParameter("in_firmaTarjetahabiente",firmaTarjetahabiente );
			 * nat.setParameter("in_enviadoEmail",enviadoEmail );
			 * nat.setParameter("in_mensajeEmail",mensajeEmail );
			 * nat.setParameter("in_proceso", proceso );
			 * nat.setParameter("in_horaEnvioEmail",horaEnvioEmail );
			 * nat.setParameter("in_horaEnvioSftp",horaEnvioSftp );
			 * nat.setParameter("in_nodoEnvio",nodoEnvio ); nat.setParameter("in_check1",
			 * check1); nat.setParameter("in_check2", check2 );
			 * nat.setParameter("in_check3", check3 ); nat.setParameter("in_check4", check4
			 * );
			 */
			////

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarResponsabilidadCivil",

					rc_num_reporte, rc_num_siniestro, rc_num_poliza, rc_num_asegurado, rc_fecha_siniestro, rc_folio_dua,
					rc_vehiculo_q, rc_compania_trans_mer, rc_reporte_vehiculo, rc_nom_propietario, rc_tel_propietario,
					rc_correo_propietario, rc_nom_transportista, rc_tel_transportista, rc_correo_transportista,
					rc_dir_siniestro, rc_entidad_siniestro, rc_dir_resguardo, rc_entidad_resguardo, rc_responsable,
					rc_entidad_resp, rc_tel_responsable, rc_tipo_siniestro, rc_num_acta, rc_descripcion_veh,
					rc_nom_operador, rc_opc_ebriedad, rc_opc_licencia, rc_dictamen, rc_opc_carga_daniada,
					rc_descripcion_merc, rc_porcentaje_aprox, rc_opc_seguro_trans, rc_nom_aseguradora,
					rc_opc_interviene_a, rc_opc_traspaleo_c, rc_folio_carta, rc_folio_factura, rc_folio_remision,
					rc_folio_guia, rc_folio_mapa, rc_informe_ajustador, rc_nom_ajustador, rc_clave_ajustador,
					rc_nom_asegurado_tercero, rc_nom_asegurado, rc_documentos_req, check_1, check_2, check_3, check_4,
					croquis, firma_ajustador, firma_asegurado_tercero, firma_asegurado, enviadoEmail, mensajeEmail,
					proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, numConsecutivo

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarResponsabilidadCivil =>" + rc_num_reporte, e);

			return "ERROR: " + e.getMessage();
		}
		return res;
	}

	@Override
	public String InsertarFormatoResponsabilidadCivil(DatosInsertarFormatoResponsabilidadCivil entrada) {

		Map<String, String> entry = new HashMap<String, String>();
		String result = null;

		entry.put("RC_NUM_REPORTE", entrada.getRc_num_reporte());
		entry.put("RC_NUM_SINIESTRO", entrada.getRc_num_siniestro());
		entry.put("RC_NUM_POLIZA", entrada.getRc_num_poliza());
		entry.put("RC_NUM_ASEGURADO", entrada.getRc_num_asegurado());
		entry.put("RC_FECHA_SINIESTRO", entrada.getRc_fecha_siniestro());
		entry.put("RC_FOLIO_DUA", entrada.getRc_folio_dua());
		entry.put("RC_VEHICULO_Q", entrada.getRc_vehiculo_q());
		entry.put("RC_COMPANIA_TRANS_MER", entrada.getRc_compania_trans_mer());
		entry.put("RC_REPORTE_VEHICULO", entrada.getRc_reporte_vehiculo());
		entry.put("RC_NOM_PROPIETARIO", entrada.getRc_nom_propietario());
		entry.put("RC_TEL_PROPIETARIO", entrada.getRc_tel_propietario());
		entry.put("RC_CORREO_PROPIETARIO", entrada.getRc_correo_propietario());
		entry.put("RC_NOM_TRANSPORTISTA", entrada.getRc_nom_transportista());
		entry.put("RC_TEL_TRANSPORTISTA", entrada.getRc_tel_transportista());
		entry.put("RC_CORREO_TRANSPORTISTA", entrada.getRc_correo_transportista());
		entry.put("RC_DIR_SINIESTRO", entrada.getRc_dir_siniestro());
		entry.put("RC_ENTIDAD_SINIESTRO", entrada.getRc_entidad_siniestro());
		entry.put("RC_DIR_RESGUARDO", entrada.getRc_dir_resguardo());
		entry.put("RC_ENTIDAD_RESGUARDO", entrada.getRc_entidad_resguardo());
		entry.put("RC_RESPONSABLE", entrada.getRc_responsable());
		entry.put("RC_ENTIDAD_RESP", entrada.getRc_entidad_resp());
		entry.put("RC_TEL_RESPONSABLE", entrada.getRc_tel_responsable());
		entry.put("RC_TIPO_SINIESTRO", entrada.getRc_tipo_siniestro());
		entry.put("RC_NUM_ACTA", entrada.getRc_num_acta());
		entry.put("RC_DESCRIPCION_VEH", entrada.getRc_descripcion_veh());
		entry.put("RC_NOM_OPERADOR", entrada.getRc_nom_operador());
		entry.put("RC_OPC_EBRIEDAD", entrada.getRc_opc_ebriedad());
		entry.put("RC_OPC_LICENCIA", entrada.getRc_opc_licencia());
		entry.put("RC_DICTAMEN", entrada.getRc_dictamen());
		entry.put("RC_OPC_CARGA_DANIADA", entrada.getRc_opc_carga_daniada());
		entry.put("RC_DESCRIPCION_MERC", entrada.getRc_descripcion_merc());
		entry.put("RC_PORCENTAJE_APROX", entrada.getRc_porcentaje_aprox());
		entry.put("RC_OPC_SEGURO_TRANS", entrada.getRc_opc_seguro_trans());
		entry.put("RC_NOM_ASEGURADORA", entrada.getRc_nom_aseguradora());
		entry.put("RC_OPC_INTERVIENE_A", entrada.getRc_opc_interviene_a());
		entry.put("RC_OPC_TRASPALEO_C", entrada.getRc_opc_traspaleo_c());
		entry.put("RC_FOLIO_CARTA", entrada.getRc_folio_carta());
		entry.put("RC_FOLIO_FACTURA", entrada.getRc_folio_factura());
		entry.put("RC_FOLIO_REMISION", entrada.getRc_folio_remision());
		entry.put("RC_FOLIO_GUIA", entrada.getRc_folio_guia());
		entry.put("RC_FOLIO_MAPA", entrada.getRc_folio_mapa());
		entry.put("RC_INFORME_AJUSTADOR", entrada.getRc_informe_ajustador());
		entry.put("RC_NOM_AJUSTADOR", entrada.getRc_nom_ajustador());
		entry.put("RC_CLAVE_AJUSTADOR", entrada.getRc_clave_ajustador());
		entry.put("RC_NOM_ASEGURADO_TERCERO", entrada.getRc_nom_asegurado_tercero());
		entry.put("RC_NOM_ASEGURADO", entrada.getRc_nom_asegurado());
		entry.put("RC_DOCUMENTOS_REQ", entrada.getRc_documentos_req());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("CROQUIS", entrada.getCroquis());
		entry.put("FIRMA_AJUSTADOR", entrada.getFirma_ajustador());
		entry.put("FIRMA_ASEGURADO_TERCERO", entrada.getFirma_asegurado_tercero());
		entry.put("FIRMA_ASEGURADO", entrada.getFirma_asegurado());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFRC(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFRC(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FRC");

		String[] columnas = new String[] { "RC_NUM_REPORTE", "RC_NUM_SINIESTRO", "RC_NUM_POLIZA", "RC_NUM_ASEGURADO",
				"RC_FECHA_SINIESTRO", "RC_FOLIO_DUA", "RC_VEHICULO_Q", "RC_COMPANIA_TRANS_MER", "RC_REPORTE_VEHICULO",
				"RC_NOM_PROPIETARIO", "RC_TEL_PROPIETARIO", "RC_CORREO_PROPIETARIO", "RC_NOM_TRANSPORTISTA",
				"RC_TEL_TRANSPORTISTA", "RC_CORREO_TRANSPORTISTA", "RC_DIR_SINIESTRO", "RC_ENTIDAD_SINIESTRO",
				"RC_DIR_RESGUARDO", "RC_ENTIDAD_RESGUARDO", "RC_RESPONSABLE", "RC_ENTIDAD_RESP", "RC_TEL_RESPONSABLE",
				"RC_TIPO_SINIESTRO", "RC_NUM_ACTA", "RC_DESCRIPCION_VEH", "RC_NOM_OPERADOR", "RC_OPC_EBRIEDAD",
				"RC_OPC_LICENCIA", "RC_DICTAMEN", "RC_OPC_CARGA_DANIADA", "RC_DESCRIPCION_MERC", "RC_PORCENTAJE_APROX",
				"RC_OPC_SEGURO_TRANS", "RC_NOM_ASEGURADORA", "RC_OPC_INTERVIENE_A", "RC_OPC_TRASPALEO_C",
				"RC_FOLIO_CARTA", "RC_FOLIO_FACTURA", "RC_FOLIO_REMISION", "RC_FOLIO_GUIA", "RC_FOLIO_MAPA",
				"RC_INFORME_AJUSTADOR", "RC_NOM_AJUSTADOR", "RC_CLAVE_AJUSTADOR", "RC_NOM_ASEGURADO_TERCERO",
				"RC_NOM_ASEGURADO", "RC_DOCUMENTOS_REQ", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "CROQUIS",
				"FIRMA_AJUSTADOR", "FIRMA_ASEGURADO_TERCERO", "FIRMA_ASEGURADO", "CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6"

		};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(60, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(60));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_RESPONSABILIDAD_CIVIL where RC_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}