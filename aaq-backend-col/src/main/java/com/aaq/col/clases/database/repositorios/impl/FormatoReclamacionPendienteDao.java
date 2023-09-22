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

import com.aaq.col.clases.database.entidades.FormatoReclamacionPendiente;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReclamacionPendiente_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoReclamacionPendienteDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReclamacionPendiente;

@org.springframework.stereotype.Repository(value = "formatoReclamacionPendienteDao")
public class FormatoReclamacionPendienteDao extends SIICAServerGenericDaoJpaImpl<FormatoReclamacionPendiente>
		implements FormatoReclamacionPendienteDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoReclamacionPendiente objetoFormatoReclamacionPendiente(String id) {
		FormatoReclamacionPendiente re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoReclamacionPendiente.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			log.error("Formatos Error=> objetoFormatoReclamacionPendiente=> " + id, e);

		}
		return re;
	}

	@Override
	public List<FormatoReclamacionPendiente> listaDeFormatoReclamacionPendiente() {
		TypedQuery<FormatoReclamacionPendiente> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoReclamacionPendiente> query = builder
					.createQuery(FormatoReclamacionPendiente.class);
			final Root<FormatoReclamacionPendiente> root = query.from(FormatoReclamacionPendiente.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoReclamacionPendiente_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoReclamacionPendiente_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoReclamacionPendiente_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(10000);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			log.error("Formatos Error=> listaDeFormatoReclamacionPendiente", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarReclamacionPendiente(String rpNumReporte, String rpNombreConductor,
			Integer rpDfEndoso, String rpAsegurado, String rpObservaciones, String rpObsEndosoAclara, Integer rpOtros,
			String rpNumReclamacion, Integer rpId, String rpNomAjustador, Integer rpCopiaActaMp, Date rpFecha,
			Integer rpReciboPago, Integer rpLicencia, String rpClaveAjustador, String rpNomConductor,
			String rpNumInciso, String rpNumPoliza, String emailDefault, Integer rpPolizaVigencia, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, ///
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado

	) {
		String resp = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_reclamacion1");

			nat.registerStoredProcedureParameter("in_rp_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_nombre_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_df_endoso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_observaciones", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_obs_endoso_aclara", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_otros", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_num_reclamacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_id", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_nom_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_copia_acta_mp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_fecha", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_recibo_pago", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_licencia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_clave_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_nom_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_num_inciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rp_num_poliza", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_emailDefault", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rpPolizaVigencia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_rp_num_reporte", rpNumReporte);
			nat.setParameter("in_rp_nombre_conductor", rpNombreConductor);
			nat.setParameter("in_rp_df_endoso", rpDfEndoso);
			nat.setParameter("in_rp_asegurado", rpAsegurado);
			nat.setParameter("in_rp_observaciones", rpObservaciones);
			nat.setParameter("in_rp_obs_endoso_aclara", rpObsEndosoAclara);
			nat.setParameter("in_rp_otros", rpOtros);
			nat.setParameter("in_rp_num_reclamacion", rpNumReclamacion);
			nat.setParameter("in_rp_id", rpId);
			nat.setParameter("in_rp_nom_ajustador", rpNomAjustador);
			nat.setParameter("in_rp_copia_acta_mp", rpCopiaActaMp);
			nat.setParameter("in_rp_fecha", rpFecha);
			nat.setParameter("in_rp_recibo_pago", rpReciboPago);
			nat.setParameter("in_rp_licencia", rpLicencia);
			nat.setParameter("in_rp_clave_ajustador", rpClaveAjustador);
			nat.setParameter("in_rp_nom_conductor", rpNomConductor);
			nat.setParameter("in_rp_num_inciso", rpNumInciso);
			nat.setParameter("in_rp_num_poliza", rpNumPoliza);

			nat.setParameter("in_emailDefault", emailDefault);
			nat.setParameter("in_rpPolizaVigencia", rpPolizaVigencia);
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
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarReclamacionPendiente", rpNumReporte,
					rpNombreConductor, rpDfEndoso, rpAsegurado, rpObservaciones, rpObsEndosoAclara, rpOtros,
					rpNumReclamacion, rpId, rpNomAjustador, rpCopiaActaMp, rpFecha, rpReciboPago, rpLicencia,
					rpClaveAjustador, rpNomConductor, rpNumInciso, rpNumPoliza, emailDefault, rpPolizaVigencia,
					enviadoEmail, ////
					mensajeEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
					firmaAjustador, firmaAsegurado

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarReclamacionPendiente =>" + rpNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return resp;
	}

	@Override
	public String InsertarFormatoReclamacionPendiente(DatosInsertarFormatoReclamacionPendiente entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("RP_NOM_AJUSTADOR", entrada.getRp_Nom_Ajustador());
		entry.put("RP_FECHA", entrada.getRp_Fecha());
		entry.put("RP_NUM_RECLAMACION", entrada.getRp_Num_Reclamacion());
		entry.put("RP_NUM_POLIZA", entrada.getRp_Num_Poliza());
		entry.put("RP_RECIBO_PAGO", entrada.getRp_Recibo_Pago());
		entry.put("RP_LICENCIA", entrada.getRp_Licencia());
		entry.put("RP_COPIA_ACTA_MP", entrada.getRp_Copia_Acta_Mp());
		entry.put("RP_OTROS", entrada.getRp_Otros());
		entry.put("RP_OBS_ENDOSO_ACLARA", entrada.getRp_Obs_Endoso_Aclara());
		entry.put("RP_OBSERVACIONES", entrada.getRp_Observaciones());
		entry.put("RP_NOM_CONDUCTOR", entrada.getRp_Nom_Conductor());
		entry.put("RP_NUM_REPORTE", entrada.getRp_Num_Reporte());
		entry.put("RP_NUM_INCISO", entrada.getRp_Num_Inciso());
		entry.put("EMAIL_DEFAULT", entrada.getEmail_Default());
		entry.put("RP_ASEGURADO", entrada.getRp_Asegurado());
		entry.put("RP_DF_ENDOSO", entrada.getRp_Df_Endoso());
		entry.put("RP_NOMBRE_CONDUCTOR", entrada.getRp_Nombre_Conductor());
		entry.put("RP_CLAVE_AJUSTADOR", entrada.getRp_Clave_Ajustador());
		entry.put("RP_POLIZA_VIGENTE", entrada.getRp_Poliza_Vigente());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_ASEGURADO", entrada.getFirma_Asegurado());
		entry.put("FIRMA_AJUSTADOR", entrada.getFirma_Ajustador());
		entry.put("RP_DATOS_OFICINA", entrada.getRp_datos_oficina());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFRP(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFRP(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FRP");

		String[] columnas = new String[] { "RP_NOM_AJUSTADOR", "RP_FECHA", "RP_NUM_RECLAMACION", "RP_NUM_POLIZA",
				"RP_RECIBO_PAGO", "RP_LICENCIA", "RP_COPIA_ACTA_MP", "RP_OTROS", "RP_OBS_ENDOSO_ACLARA",
				"RP_OBSERVACIONES", "RP_NOM_CONDUCTOR", "RP_NUM_REPORTE", "RP_NUM_INCISO", "EMAIL_DEFAULT",
				"RP_ASEGURADO", "RP_DF_ENDOSO", "RP_NOMBRE_CONDUCTOR", "RP_CLAVE_AJUSTADOR", "RP_POLIZA_VIGENTE",
				"CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_ASEGURADO", "FIRMA_AJUSTADOR","RP_DATOS_OFICINA",
				"CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6" };

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(31, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(31));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_RECLAMACION_PENDIENTE where RP_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}
}