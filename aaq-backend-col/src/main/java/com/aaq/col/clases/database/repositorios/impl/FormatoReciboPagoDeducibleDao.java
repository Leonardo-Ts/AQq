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

import com.aaq.col.clases.database.entidades.FormatoReciboPagoDeducible;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReciboPagoDeducible_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoReciboPagoDeducibleDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReciboPagoDeducible;

@org.springframework.stereotype.Repository(value = "formatoReciboPagoDeducibleDao")
public class FormatoReciboPagoDeducibleDao extends SIICAServerGenericDaoJpaImpl<FormatoReciboPagoDeducible>
		implements FormatoReciboPagoDeducibleDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoReciboPagoDeducible objetoFormatoReciboPagoDeducible(String id) {
		FormatoReciboPagoDeducible re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoReciboPagoDeducible.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			log.error("Formatos Error=> objetoFormatoReciboPagoDeducible=> " + id, e);

		}
		return re;
	}

	@Override
	public List<FormatoReciboPagoDeducible> listaDeFormatoReciboPagoDeducible() {
		TypedQuery<FormatoReciboPagoDeducible> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoReciboPagoDeducible> query = builder
					.createQuery(FormatoReciboPagoDeducible.class);
			final Root<FormatoReciboPagoDeducible> root = query.from(FormatoReciboPagoDeducible.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoReciboPagoDeducible_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoReciboPagoDeducible_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoReciboPagoDeducible_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			log.error("Formatos Error=> listaDeFormatoReciboPagoDeducible", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarReciboPagoDeducible(String rdNumSiniestro, String rdNumReporte, String rdFolio,
			Date rdFecha, String rdNumPoliza, String rdNumInciso, String rdClave, String rdAjustador,
			String rdRecibimosDe, String rdRfc, String rdEmail, String rdTelefono, String rdDomicilio,
			String rdCantidad, String rdImporteLetra, String rdConceptoDe, Integer rdValores, String rdNumCuenta1,
			String rdNumCuenta2, String rdBanco1, String rdBanco2, String rdImporte1, String rdImporte2,
			String rdAutorizacion1, String rdAutorizacion2, String rdNumTarjeta1, String rdNumTarjeta2,
			String rdBanco1B, String rdBanco2B, String rdImporte1B, String rdImporte2B, String rdImporteTotal,
			String rdLugarExp, String rdFirmaRecibido, Integer check1, Integer check2, Integer check3, Integer check4,
			String ftpRespuesta, Integer enviadoFtp, String mensajesEmail, Integer enviadoEmail, Integer proceso,
			Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer rdId, Integer cancelado

	) {
		String re = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_ReciboPagoDeducible1");

			nat.registerStoredProcedureParameter("in_rdNumSiniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdNumReporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdFolio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdFecha", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdNumPoliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdNumInciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdClave", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdRecibimosDe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdRfc", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdTelefono", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdDomicilio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdCantidad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdImporteLetra", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdConceptoDe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdValores", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdNumCuenta1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdNumCuenta2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdBanco1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdBanco2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdImporte1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdImporte2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdAutorizacion1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdAutorizacion2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdNumTarjeta1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdNumTarjeta2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdBanco1B", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdBanco2B", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdImporte1B", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdImporte2B", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdImporteTotal", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdLugarExp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdFirmaRecibido", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_check1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_check2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_check3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_check4", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ftpRespuesta", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoFtp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_mensajesEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_rdId", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_cancelado", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_rdNumSiniestro", rdNumSiniestro);
			nat.setParameter("in_rdNumReporte", rdNumReporte);
			nat.setParameter("in_rdFolio", rdFolio);
			nat.setParameter("in_rdFecha", rdFecha);
			nat.setParameter("in_rdNumPoliza", rdNumPoliza);
			nat.setParameter("in_rdNumInciso", rdNumInciso);
			nat.setParameter("in_rdClave", rdClave);
			nat.setParameter("in_rdAjustador", rdAjustador);
			nat.setParameter("in_rdRecibimosDe", rdRecibimosDe);
			nat.setParameter("in_rdRfc", rdRfc);
			nat.setParameter("in_rdEmail", rdEmail);
			nat.setParameter("in_rdTelefono", rdTelefono);
			nat.setParameter("in_rdDomicilio", rdDomicilio);
			nat.setParameter("in_rdCantidad", rdCantidad);
			nat.setParameter("in_rdImporteLetra", rdImporteLetra);
			nat.setParameter("in_rdConceptoDe", rdConceptoDe);
			nat.setParameter("in_rdValores", rdValores);
			nat.setParameter("in_rdNumCuenta1", rdNumCuenta1);
			nat.setParameter("in_rdNumCuenta2", rdNumCuenta2);
			nat.setParameter("in_rdBanco1", rdBanco1);
			nat.setParameter("in_rdBanco2", rdBanco2);
			nat.setParameter("in_rdImporte1", rdImporte1);
			nat.setParameter("in_rdImporte2", rdImporte2);
			nat.setParameter("in_rdAutorizacion1", rdAutorizacion1);
			nat.setParameter("in_rdAutorizacion2", rdAutorizacion2);
			nat.setParameter("in_rdNumTarjeta1", rdNumTarjeta1);
			nat.setParameter("in_rdNumTarjeta2", rdNumTarjeta2);
			nat.setParameter("in_rdBanco1B", rdBanco1B);
			nat.setParameter("in_rdBanco2B", rdBanco2B);
			nat.setParameter("in_rdImporte1B", rdImporte1B);
			nat.setParameter("in_rdImporte2B", rdImporte2B);
			nat.setParameter("in_rdImporteTotal", rdImporteTotal);
			nat.setParameter("in_rdLugarExp", rdLugarExp);
			nat.setParameter("in_rdFirmaRecibido", rdFirmaRecibido);
			nat.setParameter("in_check1", check1);
			nat.setParameter("in_check2", check2);
			nat.setParameter("in_check3", check3);
			nat.setParameter("in_check4", check4);
			nat.setParameter("in_ftpRespuesta", ftpRespuesta);
			nat.setParameter("in_enviadoFtp", enviadoFtp);
			nat.setParameter("in_mensajesEmail", mensajesEmail);
			nat.setParameter("in_enviadoEmail", enviadoEmail);
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);
			nat.setParameter("in_rdId", rdId);
			nat.setParameter("in_cancelado", cancelado);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			re = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarFormatoReciboPago",

					rdNumSiniestro, rdNumReporte, rdFolio, rdFecha, rdNumPoliza, rdNumInciso, rdClave, rdAjustador,
					rdRecibimosDe, rdRfc, rdEmail, rdTelefono, rdDomicilio, rdCantidad, rdImporteLetra, rdConceptoDe,
					rdValores, rdNumCuenta1, rdNumCuenta2, rdBanco1, rdBanco2, rdImporte1, rdImporte2, rdAutorizacion1,
					rdAutorizacion2, rdNumTarjeta1, rdNumTarjeta2, rdBanco1B, rdBanco2B, rdImporte1B, rdImporte2B,
					rdImporteTotal, rdLugarExp, rdFirmaRecibido, check1, check2, check3, check4, ftpRespuesta,
					enviadoFtp, mensajesEmail, enviadoEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, rdId,
					cancelado

			);
			log.error("Formatos Error=> ejecutarFuncionInsertarReciboPagoDeducible =>" + rdNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return re;
	}

	@Override
	public String InsertarFormatoReciboPagoDeducible(DatosInsertarFormatoReciboPagoDeducible entrada) {
		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("RD_NUM_SINIESTRO", entrada.getRd_NumSiniestro());
		entry.put("RD_NUM_REPORTE", entrada.getRd_NumReporte());
		entry.put("RD_FOLIO", entrada.getRd_Folio());
		entry.put("RD_FECHA", entrada.getRd_Fecha());
		entry.put("RD_NUM_POLIZA", entrada.getRd_NumPoliza());
		entry.put("RD_NUM_INCISO", entrada.getRd_NumInciso());
		entry.put("RD_CLAVE", entrada.getRd_Clave());
		entry.put("RD_AJUSTADOR", entrada.getRd_Ajustador());
		entry.put("RD_RECIBIMOS_DE", entrada.getRd_RecibimosDe());
		entry.put("RD_RFC", entrada.getRd_Rfc());
		entry.put("RD_EMAIL", entrada.getRd_Email());
		entry.put("RD_TELEFONO", entrada.getRd_Telefono());
		entry.put("RD_DOMICILIO", entrada.getRd_Domicilio());
		entry.put("RD_CANTIDAD", entrada.getRd_Cantidad());
		entry.put("RD_IMPORTE_LETRA", entrada.getRd_ImporteLetra());
		entry.put("RD_CONCEPTO_DE", entrada.getRd_ConceptoDe());
		entry.put("RD_VALORES", entrada.getRd_Valores());
		entry.put("RD_NUM_CUENTA1", entrada.getRd_NumCuenta1());
		entry.put("RD_NUM_CUENTA2", entrada.getRd_NumCuenta2());
		entry.put("RD_BANCO1", entrada.getRd_Banco1());
		entry.put("RD_BANCO2", entrada.getRd_Banco2());
		entry.put("RD_IMPORTE1", entrada.getRd_Importe1());
		entry.put("RD_IMPORTE2", entrada.getRd_Importe2());
		entry.put("RD_AUTORIZACION1", entrada.getRd_Autorizacion1());
		entry.put("RD_AUTORIZACION2", entrada.getRd_Autorizacion2());
		entry.put("RD_NUM_TARJETA1", entrada.getRd_NumTarjeta1());
		entry.put("RD_NUM_TARJETA2", entrada.getRd_NumTarjeta2());
		entry.put("RD_BANCO1B", entrada.getRd_Banco1B());
		entry.put("RD_BANCO2B", entrada.getRd_Banco2B());
		entry.put("RD_IMPORTE1B", entrada.getRd_Importe1B());
		entry.put("RD_IMPORTE2B", entrada.getRd_Importe2B());
		entry.put("RD_IMPORTE_TOTAL", entrada.getRd_ImporteTotal());
		entry.put("RD_LUGAR_EXP", entrada.getRd_LugarExp());
		entry.put("RD_FIRMA_RECIBIDO", entrada.getRd_FirmaRecibido());
		entry.put("CHECK_1", entrada.getCheck1());
		entry.put("CHECK_2", entrada.getCheck2());
		entry.put("CHECK_3", entrada.getCheck3());
		entry.put("CHECK_4", entrada.getCheck4());
		entry.put("CANCELADO", entrada.getCancelado());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFRDeducible(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFRDeducible(Map<String, String> entry) {
		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FRDEDUCIBLE");

		String[] columnas = new String[] { "RD_NUM_SINIESTRO", "RD_NUM_REPORTE", "RD_FOLIO", "RD_FECHA",
				"RD_NUM_POLIZA", "RD_NUM_INCISO", "RD_CLAVE", "RD_AJUSTADOR", "RD_RECIBIMOS_DE", "RD_RFC", "RD_EMAIL",
				"RD_TELEFONO", "RD_DOMICILIO", "RD_CANTIDAD", "RD_IMPORTE_LETRA", "RD_CONCEPTO_DE", "RD_VALORES",
				"RD_NUM_CUENTA1", "RD_NUM_CUENTA2", "RD_BANCO1", "RD_BANCO2", "RD_IMPORTE1", "RD_IMPORTE2",
				"RD_AUTORIZACION1", "RD_AUTORIZACION2", "RD_NUM_TARJETA1", "RD_NUM_TARJETA2", "RD_BANCO1B",
				"RD_BANCO2B", "RD_IMPORTE1B", "RD_IMPORTE2B", "RD_IMPORTE_TOTAL", "RD_LUGAR_EXP", "RD_FIRMA_RECIBIDO",
				"CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "CANCELADO","CORREO_OCULTO","FUENTE_WS" ,"CHECK_5", "CHECK_6"};
		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(44, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(44));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_RECIBO_DEDUCIBLE where RD_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}