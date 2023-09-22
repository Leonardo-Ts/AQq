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

import com.aaq.col.clases.database.entidades.FormatoReciboIngresoSiniestro;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReciboIngresoSiniestro_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoReciboIngresoSiniestroDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReciboIngresoSiniestro;

@org.springframework.stereotype.Repository(value = "formatoReciboIngresoSiniestroDao")
public class FormatoReciboIngresoSiniestroDao extends SIICAServerGenericDaoJpaImpl<FormatoReciboIngresoSiniestro>
		implements FormatoReciboIngresoSiniestroDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoReciboIngresoSiniestro objetoFormatoReciboIngresoSiniestro(String id) {
		FormatoReciboIngresoSiniestro re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoReciboIngresoSiniestro.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			log.error("Formatos Error=> objetoFormatoReciboIngresoSiniestro=> " + id, e);

		}
		return re;
	}

	@Override
	public List<FormatoReciboIngresoSiniestro> listaDeFormatoReciboIngresoSiniestro() {
		TypedQuery<FormatoReciboIngresoSiniestro> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoReciboIngresoSiniestro> query = builder
					.createQuery(FormatoReciboIngresoSiniestro.class);
			final Root<FormatoReciboIngresoSiniestro> root = query.from(FormatoReciboIngresoSiniestro.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoReciboIngresoSiniestro_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoReciboIngresoSiniestro_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoReciboIngresoSiniestro_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			log.error("Formatos Error=> listaDeFormatoReciboIngresoSiniestro", e);
		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarReciboIngresoSiniestro(

			String riNumSiniestro, String riFolio, Date riFecha, String riNumPoliza, String riNumInciso,
			String riClaveProv, String riCobertura, String riAjustador, String riRecibimosDe, String riRfc,
			String riEmail, String riTelefono, String riDomicilio, String riCantidad, String riImporteLetra,
			String riConceptoDe, Integer riValores, String riBanco1, String riImporte1, String riAutorizacion1,
			String riNumTarjeta1, String riBanco2, String riImporte2, String riAutorizacion2, String riNumTarjeta2,
			String riBanco3, String riImporte3, String riAutorizacion3, String riNumTarjeta3, String riImporteTotal,
			String riFirmaAsegurado, String riFirmaTercero, String riFirmaAjustador, String riLugarExp,
			String riFirmaRecibido, String ftpRespuesta, Integer enviadoFtp, String mensajesEmail, Integer enviadoEmail,
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, Integer riId, String riNomTercero, String riNomAsegurado,
			Integer cancelado, String riNumReporte, Integer riNumTercero

	) {
		String re = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_ReciboIngresoSiniestro1");

			nat.registerStoredProcedureParameter("in_riNumSiniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riFolio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riFecha", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riNumPoliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riNumInciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riClaveProv", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riCobertura", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riRecibimosDe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riRfc", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riTelefono", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riDomicilio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riCantidad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riImporteLetra", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riConceptoDe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riValores", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riBanco1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riImporte1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riAutorizacion1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riNumTarjeta1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riBanco2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riImporte2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riAutorizacion2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riNumTarjeta2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riBanco3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riImporte3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riAutorizacion3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riNumTarjeta3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riImporteTotal", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riFirmaAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riFirmaTercero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riFirmaAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riLugarExp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riFirmaRecibido", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ftpRespuesta", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoFtp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_mensajesEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			// nat.registerStoredProcedureParameter("in_check1", String.class,
			// ParameterMode.IN);
			// nat.registerStoredProcedureParameter("in_check2", String.class,
			// ParameterMode.IN);
			// nat.registerStoredProcedureParameter("in_check3", String.class,
			// ParameterMode.IN);
			// nat.registerStoredProcedureParameter("in_check4", String.class,
			// ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riId", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riNomTercero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riNomAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_cancelado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riNumReporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_riNumTercero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_riNumSiniestro", riNumSiniestro);
			nat.setParameter("in_riFolio", riFolio);
			nat.setParameter("in_riFecha", riFecha);
			nat.setParameter("in_riNumPoliza", riNumPoliza);
			nat.setParameter("in_riNumInciso", riNumInciso);
			nat.setParameter("in_riClaveProv", riClaveProv);
			nat.setParameter("in_riCobertura", riCobertura);
			nat.setParameter("in_riAjustador", riAjustador);
			nat.setParameter("in_riRecibimosDe", riRecibimosDe);
			nat.setParameter("in_riRfc", riRfc);
			nat.setParameter("in_riEmail", riEmail);
			nat.setParameter("in_riTelefono", riTelefono);
			nat.setParameter("in_riDomicilio", riDomicilio);
			nat.setParameter("in_riCantidad", riDomicilio);
			nat.setParameter("in_riImporteLetra", riImporteLetra);
			nat.setParameter("in_riConceptoDe", riConceptoDe);
			nat.setParameter("in_riValores", riValores);
			nat.setParameter("in_riBanco1", riBanco1);
			nat.setParameter("in_riImporte1", riImporte1);
			nat.setParameter("in_riAutorizacion1", riAutorizacion1);
			nat.setParameter("in_riNumTarjeta1", riNumTarjeta1);
			nat.setParameter("in_riBanco2", riBanco2);
			nat.setParameter("in_riImporte2", riImporte2);
			nat.setParameter("in_riAutorizacion2", riAutorizacion2);
			nat.setParameter("in_riNumTarjeta2", riNumTarjeta2);
			nat.setParameter("in_riBanco3", riBanco3);
			nat.setParameter("in_riImporte3", riImporte3);
			nat.setParameter("in_riAutorizacion3", riAutorizacion3);
			nat.setParameter("in_riNumTarjeta3", riNumTarjeta3);
			nat.setParameter("in_riImporteTotal", riImporteTotal);
			nat.setParameter("in_riFirmaAsegurado", riFirmaAsegurado);
			nat.setParameter("in_riFirmaTercero", riFirmaTercero);
			nat.setParameter("in_riFirmaAjustador", riFirmaAjustador);
			nat.setParameter("in_riLugarExp", riLugarExp);
			nat.setParameter("in_riFirmaRecibido", riFirmaRecibido);
			nat.setParameter("in_ftpRespuesta", ftpRespuesta);
			nat.setParameter("in_enviadoFtp", enviadoFtp);
			nat.setParameter("in_mensajesEmail", mensajesEmail);
			nat.setParameter("in_enviadoEmail", enviadoEmail);
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);
			// nat.setParameter("in_check1",check1 );
			// nat.setParameter("in_check2",check2 );
			// nat.setParameter("in_check3", check3);
			// nat.setParameter("in_check4", check4);
			nat.setParameter("in_riId", riId);
			nat.setParameter("in_riNomTercero", riNomTercero);
			nat.setParameter("in_riNomAsegurado", riNomAsegurado);
			nat.setParameter("in_cancelado", cancelado);
			nat.setParameter("in_riNumReporte", riNumReporte);
			nat.setParameter("in_riNumTercero", riNumTercero);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			re = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionInsertarReciboIngresoSiniestro",

					riNumSiniestro, riFolio, riFecha, riNumPoliza, riNumInciso, riClaveProv, riCobertura, riAjustador,
					riRecibimosDe, riRfc, riEmail, riTelefono, riDomicilio, riCantidad, riImporteLetra, riConceptoDe,
					riValores, riBanco1, riImporte1, riAutorizacion1, riNumTarjeta1, riBanco2, riImporte2,
					riAutorizacion2, riNumTarjeta2, riBanco3, riImporte3, riAutorizacion3, riNumTarjeta3,
					riImporteTotal, riFirmaAsegurado, riFirmaTercero, riFirmaAjustador, riLugarExp, riFirmaRecibido,
					ftpRespuesta, enviadoFtp, mensajesEmail, enviadoEmail, proceso, horaEnvioEmail, horaEnvioSftp,
					nodoEnvio, check1, check2, check3, check4, riId, riNomTercero, riNomAsegurado, cancelado,
					riNumReporte, riNumTercero

			);
			log.error("Formatos Error=> ejecutarFuncionInsertarReciboIngresoSiniestro =>" + riNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return re;
	}

	@Override
	public String InsertarFormatoReciboIngresoSiniestro(DatosInsertarFormatoReciboIngresoSiniestro entrada) {
		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("RI_NUM_SINIESTRO", entrada.getRi_NumSiniestro());
		entry.put("RI_FOLIO", entrada.getRiFolio());
		entry.put("RI_FECHA", entrada.getRiFecha());
		entry.put("RI_NUM_POLIZA", entrada.getRiNumPoliza());
		entry.put("RI_NUM_INCISO", entrada.getRiNumInciso());
		entry.put("RI_CLAVE_PROV", entrada.getRiClaveProv());
		entry.put("RI_COBERTURA", entrada.getRiCobertura());
		entry.put("RI_AJUSTADOR", entrada.getRiAjustador());
		entry.put("RI_RECIBIMOS_DE", entrada.getRiRecibimosDe());
		entry.put("RI_RFC", entrada.getRiRfc());
		entry.put("RI_EMAIL", entrada.getRiEmail());
		entry.put("RI_TELEFONO", entrada.getRiTelefono());
		entry.put("RI_DOMICILIO", entrada.getRiDomicilio());
		entry.put("RI_CANTIDAD", entrada.getRiCantidad());
		entry.put("RI_IMPORTE_LETRA", entrada.getRiImporteLetra());
		entry.put("RI_CONCEPTO_DE", entrada.getRiConceptoDe());
		entry.put("RI_VALORES", entrada.getRiValores());
		entry.put("RI_BANCO1", entrada.getRiBanco1());
		entry.put("RI_BANCO2", entrada.getRiBanco2());
		entry.put("RI_BANCO3", entrada.getRiBanco3());
		entry.put("RI_IMPORTE1", entrada.getRiImporte1());
		entry.put("RI_IMPORTE2", entrada.getRiImporte2());
		entry.put("RI_IMPORTE3", entrada.getRiImporte3());
		entry.put("RI_AUTORIZACION1", entrada.getRiAutorizacion1());
		entry.put("RI_AUTORIZACION2", entrada.getRiAutorizacion2());
		entry.put("RI_AUTORIZACION3", entrada.getRiAutorizacion3());
		entry.put("RI_NUM_TARJETA1", entrada.getRiNumTarjeta1());
		entry.put("RI_NUM_TARJETA2", entrada.getRiNumTarjeta2());
		entry.put("RI_NUM_TARJETA3", entrada.getRiNumTarjeta3());
		entry.put("RI_IMPORTE_TOTAL", entrada.getRiImporteTotal());
		entry.put("RI_LUGAR_EXP", entrada.getRiLugarExp());
		entry.put("CHECK_1", entrada.getCheck1());
		entry.put("CHECK_2", entrada.getCheck2());
		entry.put("CHECK_3", entrada.getCheck3());
		entry.put("CHECK_4", entrada.getCheck4());
		entry.put("RI_FIRMA_AJUSTADOR", entrada.getRiFirmaAjustador());
		entry.put("RI_FIRMA_ASEGURADO", entrada.getRiFirmaAsegurado());
		entry.put("RI_FIRMA_TERCERO", entrada.getRiFirmaTercero());
		entry.put("RI_FIRMA_RECIBIDO", entrada.getRiFirmaRecibido());
		entry.put("RI_NOM_TERCERO", entrada.getRiNomTercero());
		entry.put("RI_NOM_ASEGURADO", entrada.getRiNomAsegurado());
		entry.put("CANCELADO", entrada.getCancelado());
		entry.put("RI_NUM_REPORTE", entrada.getRiNumReporte());
		entry.put("RI_NUM_TERCERO", entrada.getRiNumTercero());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFRIngreso(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFRIngreso(Map<String, String> entry) {
		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FRINGRESO");

		String[] columnas = new String[] { "RI_NUM_SINIESTRO", "RI_FOLIO", "RI_FECHA", "RI_NUM_POLIZA", "RI_NUM_INCISO",
				"RI_CLAVE_PROV", "RI_COBERTURA", "RI_AJUSTADOR", "RI_RECIBIMOS_DE", "RI_RFC", "RI_EMAIL", "RI_TELEFONO",
				"RI_DOMICILIO", "RI_CANTIDAD", "RI_IMPORTE_LETRA", "RI_CONCEPTO_DE", "RI_VALORES", "RI_BANCO1",
				"RI_BANCO2", "RI_BANCO3", "RI_IMPORTE1", "RI_IMPORTE2", "RI_IMPORTE3", "RI_AUTORIZACION1",
				"RI_AUTORIZACION2", "RI_AUTORIZACION3", "RI_NUM_TARJETA1", "RI_NUM_TARJETA2", "RI_NUM_TARJETA3",
				"RI_IMPORTE_TOTAL", "RI_LUGAR_EXP", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "RI_FIRMA_AJUSTADOR",
				"RI_FIRMA_ASEGURADO", "RI_FIRMA_TERCERO", "RI_FIRMA_RECIBIDO", "RI_NOM_TERCERO", "RI_NOM_ASEGURADO",
				"CANCELADO", "RI_NUM_REPORTE", "RI_NUM_TERCERO","CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6"

		};
		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(49, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(49));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_RECIBO_INGRESO where RI_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}