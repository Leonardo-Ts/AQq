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

import com.aaq.col.clases.database.entidades.FormatoOrdenServicio;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoOrdenServicio_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoOrdenServicioDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoOrdenServicio;

@org.springframework.stereotype.Repository(value = "formatoOrdenServicioDao")
public class FormatoOrdenServicioDao extends SIICAServerGenericDaoJpaImpl<FormatoOrdenServicio>
		implements FormatoOrdenServicioDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoOrdenServicio objetoFormatoOrdenServicio(String id) {
		FormatoOrdenServicio re = null;
		try {
			re = StringUtils.isNotBlank(id) ? this.getEntityManager().find(FormatoOrdenServicio.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			log.error("Formatos Error=> objetoFormatoOrdenServicio=> " + id, e);
		}
		return re;
	}

	@Override
	public List<FormatoOrdenServicio> listaDeFormatoOrdenServicio() {
		TypedQuery<FormatoOrdenServicio> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoOrdenServicio> query = builder.createQuery(FormatoOrdenServicio.class);
			final Root<FormatoOrdenServicio> root = query.from(FormatoOrdenServicio.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoOrdenServicio_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoOrdenServicio_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoOrdenServicio_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoOrdenServicio", 500);
			log.error("Formatos Error=> listaDeFormatoOrdenServicio", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarFormatoServicio(

			Date osFechaAtencion, String osSexoConductor, String osPoliza, String osTipoAuto, String osNumInciso,
			String osPlacasAuto, String osNumReporte, Integer osEdadConductor, Timestamp osHoraArribo,
			String osNomAjustador, String osTelConductor, Timestamp osHoraTermino, Integer osTipoServicio,
			String osEmailConductor, String osLugarServicio, Integer osSurtidoCombustible, Timestamp osHoraReporte,
			Integer osId, String osNumSiniestro, String osInformeAjustador, String osNomConductor, String osModeloAuto,
			String osClave, String osNumSerieAuto, String osAsegurado, String osMarcaAuto, String osAnioAuto,

			Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado

	) {
		String res = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_ordenServicio1");

			nat.registerStoredProcedureParameter("in_ os_fecha_atencion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_sexo_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_os_tipo_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_num_inciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_placas_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_os_edad_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_hora_arribo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_nom_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_tel_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_hora_termino", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_os_tipo_servicio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_email_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_lugar_servicio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_os_surtido_combustible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_hora_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_os_id", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_num_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_informe_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_nom_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_os_modelo_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_clave", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ os_num_serie_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_os_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_os_marca_auto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_os_anio_auto", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_ os_fecha_atencion", osFechaAtencion);
			nat.setParameter("in_ os_sexo_conductor", osSexoConductor);
			nat.setParameter("in_ os_poliza", osPoliza);
			nat.setParameter("in_os_tipo_auto", osTipoAuto);
			nat.setParameter("in_ os_num_inciso", osNumInciso);
			nat.setParameter("in_ os_placas_auto", osPlacasAuto);
			nat.setParameter("in_ os_num_reporte", osNumReporte);
			nat.setParameter("in_os_edad_conductor", osEdadConductor);
			nat.setParameter("in_ os_hora_arribo", osHoraArribo);
			nat.setParameter("in_ os_nom_ajustador", osNomConductor);
			nat.setParameter("in_ os_tel_conductor", osTelConductor);
			nat.setParameter("in_ os_hora_termino", osHoraTermino);
			nat.setParameter("in_os_tipo_servicio", osTipoServicio);
			nat.setParameter("in_ os_email_conductor", osEmailConductor);
			nat.setParameter("in_ os_lugar_servicio", osLugarServicio);
			nat.setParameter("in_os_surtido_combustible", osSurtidoCombustible);
			nat.setParameter("in_ os_hora_reporte", osHoraReporte);
			nat.setParameter("in_os_id", osId);
			nat.setParameter("in_ os_num_siniestro", osNumSiniestro);
			nat.setParameter("in_ os_informe_ajustador", osInformeAjustador);
			nat.setParameter("in_ os_nom_conductor", osNomConductor);
			nat.setParameter("in_os_modelo_auto", osModeloAuto);
			nat.setParameter("in_ os_clave", osClave);
			nat.setParameter("in_ os_num_serie_auto", osNumSerieAuto);
			nat.setParameter("in_os_asegurado", osAsegurado);
			nat.setParameter("in_os_marca_auto", osMarcaAuto);
			nat.setParameter("in_os_anio_auto", osAnioAuto);

			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);
			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarPaseAdmision",

					osFechaAtencion, osSexoConductor, osPoliza, osTipoAuto, osNumInciso, osPlacasAuto, osNumReporte,
					osEdadConductor, osHoraArribo, osNomAjustador, osTelConductor, osHoraTermino, osTipoServicio,
					osEmailConductor, osLugarServicio, osSurtidoCombustible, osHoraReporte, osId, osNumSiniestro,
					osInformeAjustador, osNomConductor, osModeloAuto, osClave, osNumSerieAuto, osAsegurado, osMarcaAuto,
					osAnioAuto,

					enviadoEmail, ////
					mensajeEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, ////
					check1, check2, check3, check4, firmaAjustador, firmaAsegurado

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarPaseAdmision =>" + osNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return res;
	}

	@Override
	public String InsertarFormatoOrdenServicio(DatosInsertarFormatoOrdenServicio entradas) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("OS_POLIZA", entradas.getOs_Poliza());
		entry.put("OS_NUM_REPORTE", entradas.getOs_Num_reporte());
		entry.put("OS_NUM_SINIESTRO", entradas.getOs_Num_siniestro());
		entry.put("OS_FECHA_ATENCION", entradas.getOs_Fecha_Atencion());
		entry.put("OS_NOM_CONDUCTOR", entradas.getOs_Nom_Conductor());
		entry.put("OS_LUGAR_SERVICIO", entradas.getOs_Lugar_Servicio());
		entry.put("OS_TEL_CONDUCTOR", entradas.getOs_Tel_Conductor());
		entry.put("OS_EDAD_CONDUCTOR", entradas.getOs_Edad_Conductor());
		entry.put("OS_SEXO_CONDUCTOR", entradas.getOs_Sexo_Conductor());
		entry.put("OS_EMAIL_CONDUCTOR", entradas.getOs_Email_Conductor());
		entry.put("OS_MARCA_AUTO", entradas.getOs_Marca_Auto());
		entry.put("OS_TIPO_AUTO", entradas.getOs_Tipo_Auto());
		entry.put("OS_ANIO_AUTO", entradas.getOs_Anio_Auto());
		entry.put("OS_MODELO_AUTO", entradas.getOs_Modelo_Auto());
		entry.put("OS_PLACAS_AUTO", entradas.getOs_Placas_Auto());
		entry.put("OS_NUM_SERIE_AUTO", entradas.getOs_Num_Serie_Auto());
		entry.put("OS_SURTIDO_COMBUSTIBLE", entradas.getOs_Surtido_Combustible());
		entry.put("OS_TIPO_SERVICIO", entradas.getOs_Tipo_Servicio());
		entry.put("OS_HORA_REPORTE", entradas.getOs_Hora_Reporte());
		entry.put("OS_HORA_ARRIBO", entradas.getOs_Hora_Arribo());
		entry.put("OS_HORA_TERMINO", entradas.getOs_Hora_Termino());
		entry.put("OS_INFORME_AJUSTADOR", entradas.getOs_Informe_Ajustador());
		entry.put("OS_NOM_AJUSTADOR", entradas.getOs_Nom_Ajustador());
		entry.put("OS_CLAVE", entradas.getOs_Clave());
		entry.put("OS_NUM_INCISO", entradas.getOs_Num_Inciso());
		entry.put("OS_ASEGURADO", entradas.getOs_Asegurado());
		entry.put("CHECK_1", entradas.getCheck_1());
		entry.put("CHECK_2", entradas.getCheck_2());
		entry.put("CHECK_3", entradas.getCheck_3());
		entry.put("CHECK_4", entradas.getCheck_4());
		entry.put("FIRMA_AJUSTADOR", entradas.getFirma_Ajustador());
		entry.put("FIRMA_ASEGURADO", entradas.getFirma_Asegurado());
		entry.put("CORREO_OCULTO", entradas.getCorreo_oculto());
		entry.put("FUENTE_WS", entradas.getFuente_ws());
		entry.put("CHECK_5", entradas.getCheck_5());
		entry.put("CHECK_6", entradas.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFOS(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFOS(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FOS");

		String[] columnas = new String[] { "OS_POLIZA", "OS_NUM_REPORTE", "OS_NUM_SINIESTRO", "OS_FECHA_ATENCION",
				"OS_NOM_CONDUCTOR", "OS_LUGAR_SERVICIO", "OS_TEL_CONDUCTOR", "OS_EDAD_CONDUCTOR", "OS_SEXO_CONDUCTOR",
				"OS_EMAIL_CONDUCTOR", "OS_MARCA_AUTO", "OS_TIPO_AUTO", "OS_ANIO_AUTO", "OS_MODELO_AUTO",
				"OS_PLACAS_AUTO", "OS_NUM_SERIE_AUTO", "OS_SURTIDO_COMBUSTIBLE", "OS_TIPO_SERVICIO", "OS_HORA_REPORTE",
				"OS_HORA_ARRIBO", "OS_HORA_TERMINO", "OS_INFORME_AJUSTADOR", "OS_NOM_AJUSTADOR", "OS_CLAVE",
				"OS_NUM_INCISO", "OS_ASEGURADO", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_AJUSTADOR",
				"FIRMA_ASEGURADO" ,"CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6"};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(37, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(37));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_ORDEN_SERVICIO where OS_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}
}
