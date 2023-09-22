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

import com.aaq.col.clases.database.entidades.FormatoCargoTarjetaCredito;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoCargoTarjetaCredito_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoCargoTarjetaCreditoDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoCargoTarjetaCredito;

@org.springframework.stereotype.Repository(value = "formatoCargoTarjetaCreditoDao")
public class FormatoCargoTarjetaCreditoDao extends SIICAServerGenericDaoJpaImpl<FormatoCargoTarjetaCredito>
		implements FormatoCargoTarjetaCreditoDaoInterfase {
	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoCargoTarjetaCredito objetoFormatoCargoTarjetaCredito(String id) {
		FormatoCargoTarjetaCredito de = null;
		try {
			de = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoCargoTarjetaCredito.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoCargoTarjetaCredito", id);
			log.error("Formatos Error=> objetoFormatoCargoTarjetaCredito=> " + id, e);

		}
		return de;
	}

	@Override
	public List<FormatoCargoTarjetaCredito> listaDeFormatoCargoTarjetaCredito() {
		TypedQuery<FormatoCargoTarjetaCredito> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoCargoTarjetaCredito> query = builder.createQuery(FormatoCargoTarjetaCredito.class);
			final Root<FormatoCargoTarjetaCredito> root = query.from(FormatoCargoTarjetaCredito.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoCargoTarjetaCredito_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoCargoTarjetaCredito_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoCargoTarjetaCredito_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoCargoTarjetaCredito", 500);
			log.error("Formatos Error=> listaDeFormatoCargoTarjetaCredito", e);
		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarCargoTarjetaCredito(
			String tcNumReporte,
			 String tcNumSiniestro,
			 String tcNumAsegurado,
			 String tcNumAutorizacion,
			 String tcNombre,
			 Date tcFecha,
			 String tcDireccion,
			 String tcEstado,
			 String tcCp,
			 String tcTelefono,
			 String tcCantidadAutorizada,
			 Integer tcPagoOpcion,
			 String tcNumTarjeta,
			 String tcVencimientoTarjeta,
			 String tcClaveAjustador,
			 String firmaTarjetahabiente,			
			 Integer enviadoEmail,
			 String mensajeEmail,
			 Integer proceso,
			 Timestamp horaEnvioEmail,
			 Timestamp horaEnvioSftp,
			 String nodoEnvio,
			 Integer check1,
			 Integer check2,
			 Integer check3,
			 Integer check4,
			 String tcNumPoliza,
			 String tcCorreo

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

			
			  nat.setParameter("in_tcNumReporte", tcNumReporte );
			  nat.setParameter("in_tcNumSiniestro",  tcNumSiniestro);
			  nat.setParameter("in_tcNumAsegurado",tcNumSiniestro  );
			  nat.setParameter("in_tcNumAutorizacion",  tcNumAutorizacion);
			  nat.setParameter("in_tcNombre",  tcNombre);
			  nat.setParameter("in_tcFecha", tcFecha );
			  nat.setParameter("in_tcDireccion",tcDireccion  );
			  nat.setParameter("in_tcEstado",  tcEstado);
			  nat.setParameter("in_tcCp",tcCp );
			  nat.setParameter("in_tcTelefono", tcTelefono );
			  nat.setParameter("in_tcCantidadAutorizada", tcCantidadAutorizada );
			  nat.setParameter("in_tcPagoOpcion", tcPagoOpcion );
			  nat.setParameter("in_tcNumTarjeta",tcNumTarjeta  );
			  nat.setParameter("in_tcVencimientoTarjeta", tcVencimientoTarjeta );
			  nat.setParameter("in_tcClaveAjustador",tcClaveAjustador  );
			  nat.setParameter("in_firmaTarjetahabiente",firmaTarjetahabiente  );		
			  nat.setParameter("in_enviadoEmail",enviadoEmail  );
			  nat.setParameter("in_mensajeEmail",mensajeEmail  );
			  nat.setParameter("in_proceso", proceso );
			  nat.setParameter("in_horaEnvioEmail",horaEnvioEmail  );
			  nat.setParameter("in_horaEnvioSftp",horaEnvioSftp  );
			  nat.setParameter("in_nodoEnvio",nodoEnvio  );
			  nat.setParameter("in_check1",  check1);
			  nat.setParameter("in_check2", check2 );
			  nat.setParameter("in_check3", check3 );
			  nat.setParameter("in_check4", check4 );
			  ////
		
			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarCargoTarjetaCredito",

					  tcNumReporte,
					  tcNumSiniestro,
					  tcNumAsegurado,
					  tcNumAutorizacion,
					  tcNombre,
					  tcFecha,
					  tcDireccion,
					  tcEstado,
					  tcCp,
					  tcTelefono,
					  tcCantidadAutorizada,
					  tcPagoOpcion,
					  tcNumTarjeta,
					  tcVencimientoTarjeta,
					  tcClaveAjustador,
					

					  firmaTarjetahabiente,
					
					  enviadoEmail,
					  mensajeEmail,

					  proceso,
					  horaEnvioEmail,
					  horaEnvioSftp,
					  nodoEnvio,

					  check1,
					  check2,
					  check3,
					  check4,
					  tcNumPoliza,
					  tcCorreo

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarCargoTarjetaCredito =>" + tcNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return res;
	}

	@Override
	public String InsertarFormatoCargoTarjetaCredito(DatosInsertarFormatoCargoTarjetaCredito entrada) {

		Map<String, String> entry = new HashMap<String, String>();
		String result = null;

		entry.put("TC_NUM_REPORTE", entrada.getTc_num_reporte());
		entry.put("TC_NUM_SINIESTRO", entrada.getTc_num_siniestro());
		entry.put("TC_NUM_ASEGURADO", entrada.getTc_num_asegurado());
		entry.put("TC_NUM_AUTORIZACION", entrada.getTc_num_autorizacion());
		entry.put("TC_NOMBRE", entrada.getTc_nombre());
		entry.put("TC_FECHA", entrada.getTc_fecha());
		entry.put("TC_DIRECCION", entrada.getTc_direccion());
		entry.put("TC_ESTADO", entrada.getTc_estado());
		entry.put("TC_CP", entrada.getTc_cp());
		entry.put("TC_TELEFONO", entrada.getTc_telefono());
		entry.put("TC_CANTIDAD_AUTORIZADA", entrada.getTc_cantidad_autorizada());
		entry.put("TC_PAGO_OPCION", entrada.getTc_pago_opcion());
		entry.put("TC_NUM_TARJETA", entrada.getTc_num_tarjeta());
		entry.put("TC_VENCIMIENTO_TARJETA", entrada.getTc_vencimiento_tarjeta());
		entry.put("TC_CLAVE_AJUSTADOR", entrada.getTc_clave_ajustador());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_TARJETAHABIENTE", entrada.getFirma_tarjetahabiente());
		entry.put("TC_NUM_POLIZA", entrada.getTc_num_poliza());
		entry.put("TC_CORREO", entrada.getTc_correo());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFCTarjeta(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFCTarjeta(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FCT");

		String[] columnas = new String[] { 
				"TC_NUM_REPORTE",
				"TC_NUM_SINIESTRO",
				"TC_NUM_ASEGURADO",
				"TC_NUM_AUTORIZACION",
				"TC_NOMBRE",
				"TC_FECHA",
				"TC_DIRECCION",
				"TC_ESTADO",
				"TC_CP",
				"TC_TELEFONO",
				"TC_CANTIDAD_AUTORIZADA",
				"TC_PAGO_OPCION",
				"TC_NUM_TARJETA",
				"TC_VENCIMIENTO_TARJETA",
				"TC_CLAVE_AJUSTADOR",
				"CHECK_1",
				"CHECK_2",
				"CHECK_3",
				"CHECK_4",
				"FIRMA_TARJETAHABIENTE",
				"TC_NUM_POLIZA",
				"TC_CORREO",
				"CORREO_OCULTO",
				"FUENTE_WS","CHECK_5", "CHECK_6"};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(27, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(27));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_CARGO_TARJETA_CREDITO where TC_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}