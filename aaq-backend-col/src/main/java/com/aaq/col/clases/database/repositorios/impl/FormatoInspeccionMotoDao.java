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

import com.aaq.col.clases.database.entidades.FormatoInspeccionMoto;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoInspeccionMoto_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoInspeccionMotoDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoInspeccionMoto;

@org.springframework.stereotype.Repository(value = "formatoInspeccionMotoDao")
public class FormatoInspeccionMotoDao extends SIICAServerGenericDaoJpaImpl<FormatoInspeccionMoto>
		implements FormatoInspeccionMotoDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoInspeccionMoto objetoFormatoInspeccionMoto(String id) {
		FormatoInspeccionMoto re = null;
		try {
			re = StringUtils.isNotBlank(id) ? this.getEntityManager().find(FormatoInspeccionMoto.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoInspeccionMoto", id);
			log.error("Formatos Error=> objetoFormatoInspeccionMoto=> " + id, e);

		}
		return re;
	}

	@Override
	public List<FormatoInspeccionMoto> listaDeFormatoInspeccionMoto() {
		TypedQuery<FormatoInspeccionMoto> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoInspeccionMoto> query = builder.createQuery(FormatoInspeccionMoto.class);
			final Root<FormatoInspeccionMoto> root = query.from(FormatoInspeccionMoto.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoInspeccionMoto_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoInspeccionMoto_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoInspeccionMoto_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFormatoInspeccionMoto", 500);
			log.error("Formatos Error=> listaDeFormatoInspeccionMoto", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarInspeccionMoto(

			String imNumSerie, Integer imAseguradoCompa, String imCompania,

			String imAsegurado, String imEstandarT, Integer imPago, Integer imAdaptaciones, String imPlacas,

			String imNomAjustador, Integer enviadoEmail, Integer imTCirculacion1, String imMarca, String imNumSiniestro,
			String imTipo, Integer imEquipoSiNo, Integer imImportacion1, String imSolicitante, String imNumReporte,
			String imEmail, String imModelo, String imClaveAjustador, String imUbicacion,

			String imKilometraje, String imTelefono, Integer imTipoEncargado, Date imFecha, Date imFechaInspeccion,
			Integer imAdaptacionesSiNo, String imOficina, Integer imCirculacion, String imColor, Integer imProcedencia,
			String mensajeEmail, Integer imPagoSiNo, Integer imDocumentacion2, Integer imDocumentacion1,
			String imNumInciso,

			String imNumPoliza,

			String imTotalFotos, Date imDiaHora, String imObservaciones, String imAtencion, String imNomCliente,
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaCliente, String firmaAgente

	) {
		String res = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_moto1");

			nat.registerStoredProcedureParameter("in_ im_num_serie", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_asegurado_compa", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_compania", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_im_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_estandar_t", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_pago", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_adaptaciones", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_placas", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_id_ajustador", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_im_nom_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviado_email", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_t_circulacion_1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_marca", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_num_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_tipo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_equipo_si_no", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_importacion_1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_solicitante", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_email", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_modelo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_clave_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_ubicacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_usuario", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_kilometraje", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_telefono", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_tipo_encargado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_fecha", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_fecha_inspeccion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_adaptaciones_si_no", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_oficina", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_circulacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_color", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_procedencia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_mensaje_email", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_pago_si_no", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_documentacion_2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_documentacion_1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_num_inciso", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_im_num_poliza", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_im_total_fotos", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_dia_hora", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_observaciones", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_atencion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_im_nom_cliente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_ im_num_serie", imNumSerie);
			nat.setParameter("in_im_asegurado_compa", imAseguradoCompa);
			nat.setParameter("in_im_compania", imCompania);

			nat.setParameter("in_im_asegurado", imAsegurado);
			nat.setParameter("in_im_estandar_t", imEstandarT);
			nat.setParameter("in_im_pago", imPago);
			nat.setParameter("in_im_adaptaciones", imAdaptaciones);
			nat.setParameter("in_im_placas", imPlacas);

			nat.setParameter("in_im_nom_ajustador", imNomAjustador);
			nat.setParameter("in_enviado_email", enviadoEmail);
			nat.setParameter("in_im_t_circulacion_1", imTCirculacion1);
			nat.setParameter("in_im_marca", imMarca);
			nat.setParameter("in_im_num_siniestro", imNumSiniestro);
			nat.setParameter("in_im_tipo", imTipo);
			nat.setParameter("in_im_equipo_si_no", imEquipoSiNo);
			nat.setParameter("in_im_importacion_1", imImportacion1);
			nat.setParameter("in_im_solicitante", imSolicitante);
			nat.setParameter("in_im_num_reporte", imNumReporte);
			nat.setParameter("in_im_email", imEmail);
			nat.setParameter("in_im_modelo", imModelo);
			nat.setParameter("in_im_clave_ajustador", imClaveAjustador);
			nat.setParameter("in_im_ubicacion", imUbicacion);

			nat.setParameter("in_im_kilometraje", imKilometraje);
			nat.setParameter("in_im_telefono", imTelefono);
			nat.setParameter("in_im_tipo_encargado", imTipoEncargado);
			nat.setParameter("in_im_fecha", imFecha);
			nat.setParameter("in_im_fecha_inspeccion", imFechaInspeccion);
			nat.setParameter("in_im_adaptaciones_si_no", imAdaptacionesSiNo);
			nat.setParameter("in_im_oficina", imOficina);
			nat.setParameter("in_im_circulacion", imCirculacion);
			nat.setParameter("in_im_color", imColor);
			nat.setParameter("in_im_procedencia", imProcedencia);
			nat.setParameter("in_mensaje_email", mensajeEmail);
			nat.setParameter("in_im_pago_si_no", imPagoSiNo);
			nat.setParameter("in_im_documentacion_2", imDocumentacion2);
			nat.setParameter("in_im_documentacion_1", imDocumentacion1);
			nat.setParameter("in_im_num_inciso", imNumInciso);

			nat.setParameter("in_im_num_poliza", imNumPoliza);

			nat.setParameter("in_im_total_fotos", imTotalFotos);
			nat.setParameter("in_im_dia_hora", imDiaHora);
			nat.setParameter("in_im_observaciones", imObservaciones);
			nat.setParameter("in_im_atencion", imAtencion);
			nat.setParameter("in_im_nom_cliente", imNomCliente);
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarInspeccionMoto",

					imNumSerie, imAseguradoCompa, imCompania,

					imAsegurado, imEstandarT, imPago, imAdaptaciones, imPlacas,

					imNomAjustador, enviadoEmail, imTCirculacion1, imMarca, imNumSiniestro, imTipo, imEquipoSiNo,
					imImportacion1, imSolicitante, imNumReporte, imEmail, imModelo, imClaveAjustador, imUbicacion,

					imKilometraje, imTelefono, imTipoEncargado, imFecha, imFechaInspeccion, imAdaptacionesSiNo,
					imOficina, imCirculacion, imColor, imProcedencia, mensajeEmail, imPagoSiNo, imDocumentacion2,
					imDocumentacion1, imNumInciso,

					imNumPoliza,

					imTotalFotos, imDiaHora, imObservaciones, imAtencion, imNomCliente, proceso, horaEnvioEmail,
					horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaCliente, firmaAgente

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarInspeccionMoto =>" + imNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return res;
	}

	@Override
	public String InsertarFormatoInspeccionMoto(DatosInsertarFormatoInspeccionMoto entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("IM_SOLICITANTE", entrada.getIm_Solicitante());
		entry.put("IM_OFICINA", entrada.getIm_Oficina());
		entry.put("IM_TELEFONO", entrada.getIm_Telefono());
		entry.put("IM_FECHA", entrada.getIm_Fecha());
		entry.put("IM_ATENCION", entrada.getIm_Atencion());
		entry.put("IM_DIA_HORA", entrada.getIm_Dia_Hora());
		entry.put("IM_UBICACION", entrada.getIm_Ubicacion());
		entry.put("IM_EMAIL", entrada.getIm_Email());
		entry.put("IM_MARCA", entrada.getIm_Marca());
		entry.put("IM_TIPO", entrada.getIm_Tipo());
		entry.put("IM_MODELO", entrada.getIm_Modelo());
		entry.put("IM_PLACAS", entrada.getIm_Placas());
		entry.put("IM_ESTANDAR_T", entrada.getIm_Estandar_T());
		entry.put("IM_COLOR", entrada.getIm_Color());
		entry.put("IM_NUM_SERIE", entrada.getIm_Num_Serie());
		entry.put("IM_KILOMETRAJE", entrada.getIm_Kilometraje());
		entry.put("IM_OBSERVACIONES", entrada.getIm_Observaciones());
		entry.put("IM_PROCEDENCIA", entrada.getIm_Procedencia());
		entry.put("IM_TOTAL_FOTOS", entrada.getIm_Total_Fotos());
		entry.put("IM_FECHA_INSPECCION", entrada.getIm_Fecha_Inspeccion());
		entry.put("IM_TIPO_ENCARGADO", entrada.getIm_Tipo_Encargado());
		entry.put("IM_NOM_CLIENTE", entrada.getIm_Nom_Cliente());
		entry.put("IM_NOM_AJUSTADOR", entrada.getIm_Nom_Ajustador());
		entry.put("IM_CIRCULACION", entrada.getIm_Circulacion());
		entry.put("IM_IMPORTACION_1", entrada.getIm_Importacion_1());
		entry.put("IM_T_CIRCULACION_1", entrada.getIm_T_Circulacion_1());
		entry.put("IM_PAGO", entrada.getIm_Pago());
		entry.put("IM_ADAPTACIONES", entrada.getIm_Adaptaciones());
		entry.put("IM_PAGO_SI_NO", entrada.getIm_Pago_Si_No());
		entry.put("IM_EQUIPO_SI_NO", entrada.getIm_Equipo_Si_No());
		entry.put("IM_ADAPTACIONES_SI_NO", entrada.getIm_Adaptaciones_Si_No());
		entry.put("IM_DOCUMENTACION_1", entrada.getIm_Documentacion_1());
		entry.put("IM_DOCUMENTACION_2", entrada.getIm_Documentacion_2());
		entry.put("IM_ASEGURADO_COMPA", entrada.getIm_Asegurado_Compa());
		entry.put("IM_NUM_POLIZA", entrada.getIm_Num_Poliza());
		entry.put("IM_COMPANIA", entrada.getIm_Compania());
		entry.put("IM_CLAVE_AJUSTADOR", entrada.getIm_Clave_Ajustador());
		entry.put("IM_ASEGURADO", entrada.getIm_Asegurado());
		entry.put("IM_NUM_REPORTE", entrada.getIm_Num_Reporte());
		entry.put("IM_NUM_INCISO", entrada.getIm_Num_Inciso());
		entry.put("IM_NUM_SINIESTRO", entrada.getIm_Num_Siniestro());
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

		result = ejecutarFuncionWebserviceStoreFIM(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFIM(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FIM");

		String[] columnas = new String[] { "IM_SOLICITANTE", "IM_OFICINA", "IM_TELEFONO", "IM_FECHA", "IM_ATENCION",
				"IM_DIA_HORA", "IM_UBICACION", "IM_EMAIL", "IM_MARCA", "IM_TIPO", "IM_MODELO", "IM_PLACAS",
				"IM_ESTANDAR_T", "IM_COLOR", "IM_NUM_SERIE", "IM_KILOMETRAJE", "IM_OBSERVACIONES", "IM_PROCEDENCIA",
				"IM_TOTAL_FOTOS", "IM_FECHA_INSPECCION", "IM_TIPO_ENCARGADO", "IM_NOM_CLIENTE", "IM_NOM_AJUSTADOR",
				"IM_CIRCULACION", "IM_IMPORTACION_1", "IM_T_CIRCULACION_1", "IM_PAGO", "IM_ADAPTACIONES",
				"IM_PAGO_SI_NO", "IM_EQUIPO_SI_NO", "IM_ADAPTACIONES_SI_NO", "IM_DOCUMENTACION_1", "IM_DOCUMENTACION_2",
				"IM_ASEGURADO_COMPA", "IM_NUM_POLIZA", "IM_COMPANIA", "IM_CLAVE_AJUSTADOR", "IM_ASEGURADO",
				"IM_NUM_REPORTE", "IM_NUM_INCISO", "IM_NUM_SINIESTRO", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4",
				"FIRMA_CLIENTE", "FIRMA_AGENTE" ,"CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6"};

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
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_INSPECCION_MOTO where IM_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}
}