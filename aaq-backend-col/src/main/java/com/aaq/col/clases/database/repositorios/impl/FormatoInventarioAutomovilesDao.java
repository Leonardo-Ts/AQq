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

import com.aaq.col.clases.database.entidades.FormatoInventarioAutomoviles;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoInventarioAutomoviles_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoInventarioAutomovilesDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoInventarioAutomoviles;

@org.springframework.stereotype.Repository(value = "formatoInventarioAutomovilesDao")
public class FormatoInventarioAutomovilesDao extends SIICAServerGenericDaoJpaImpl<FormatoInventarioAutomoviles>
		implements FormatoInventarioAutomovilesDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoInventarioAutomoviles objetoFormatoInventarioAutomoviles(String id) {
		FormatoInventarioAutomoviles res = null;
		try {
			res = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoInventarioAutomoviles.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			log.error("Formatos Error=> objetoFormatoInventarioAutomoviles=> " + id, e);
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoInventarioAutomoviles",
			// id);
		}
		return res;
	}

	@Override
	public List<FormatoInventarioAutomoviles> listaDeFormatoInventarioAutomoviles() {
		TypedQuery<FormatoInventarioAutomoviles> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoInventarioAutomoviles> query = builder
					.createQuery(FormatoInventarioAutomoviles.class);
			final Root<FormatoInventarioAutomoviles> root = query.from(FormatoInventarioAutomoviles.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoInventarioAutomoviles_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoInventarioAutomoviles_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoInventarioAutomoviles_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoInventarioAutomoviles",
			// 500);
			log.error("Formatos Error=> listaDeFormatoInventarioAutomoviles", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarInventarioAutomoviles(

			String iaNumReporte, String iaTipoAuto, String iaAsegurado, Timestamp iaHora, String iaInventario1,
			String iaInventario2, String iaInventario3, String iaInventario4, String iaInventario5,
			String iaNomAjustador, String iaNumMotor, String iaAnioAuto, String iaNomAsegurado, String iaNumSiniestro,
			String iaDirDestino, String iaCantidad, String iaObservacion, Integer iaId, Integer iaPuertasAuto,
			String iaClaveAjustador, String iaColorAuto, String iaMarcaAuto, String iaNomDestino, String iaKilometraje,
			Integer iaVidaLlantas, String iaNumSerie, Integer iaCombustible, String iaNumInciso, String iaNumPoliza,
			String iaDesAuto,

			String iaNomOperador,

			String iaNomRazon,

			Integer iaLlaves, String iaPlacasAuto, Integer iaTManual, Integer iaDestino, String emailDefault,
			Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer iaObjetosPer, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAsegurado,
			String firmaOperRecibe, String firmaAjusRecibe, String niu, String iaCorreoGrua, String iaCorreoTaller

	) {
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_inventario1");

			nat.registerStoredProcedureParameter("in_iaNumReporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaTipoAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaHora", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaInventario1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaInventario2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaInventario3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaInventario4", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaInventario5", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaNomAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaNumMotor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaAnioAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaNomAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaNumSiniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaDirDestino", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaCantidad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaObservacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaId", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaPuertasAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaClaveAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaColorAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaMarcaAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaNomDestino", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaKilometraje", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaVidaLlantas", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaNumSerie", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaCombustible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaNumInciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaNumPoliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaDesAuto", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_iaNomOperador", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_iaNomRazon", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_iaLlaves", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaPlacasAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaTManual", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaDestino", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_emailDefault", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_iaObjetosPer", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_niu", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaCorreoGrua", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_iaCorreoTaller", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_iaNumReporte", iaNumReporte);
			nat.setParameter("in_iaTipoAuto", iaTipoAuto);
			nat.setParameter("in_iaAsegurado", iaAsegurado);
			nat.setParameter("in_iaHora", iaHora);
			nat.setParameter("in_iaInventario1", iaInventario1);
			nat.setParameter("in_iaInventario2", iaInventario2);
			nat.setParameter("in_iaInventario3", iaInventario3);
			nat.setParameter("in_iaInventario4", iaInventario4);
			nat.setParameter("in_iaInventario5", iaInventario5);
			nat.setParameter("in_iaNomAjustador", iaNomAjustador);
			nat.setParameter("in_iaNumMotor", iaNumMotor);
			nat.setParameter("in_iaAnioAuto", iaAnioAuto);
			nat.setParameter("in_iaNomAsegurado", iaNomAsegurado);
			nat.setParameter("in_iaNumSiniestro", iaNumSiniestro);
			nat.setParameter("in_iaDirDestino", iaDirDestino);
			nat.setParameter("in_iaCantidad", iaCantidad);
			nat.setParameter("in_iaObservacion", iaObservacion);
			nat.setParameter("in_iaId", iaId);
			nat.setParameter("in_iaPuertasAuto", iaPuertasAuto);
			nat.setParameter("in_iaClaveAjustador", iaClaveAjustador);
			nat.setParameter("in_iaColorAuto", iaColorAuto);
			nat.setParameter("in_iaMarcaAuto", iaMarcaAuto);
			nat.setParameter("in_iaNomDestino", iaNomDestino);
			nat.setParameter("in_iaKilometraje", iaKilometraje);
			nat.setParameter("in_iaVidaLlantas", iaVidaLlantas);
			nat.setParameter("in_iaNumSerie", iaNumSerie);
			nat.setParameter("in_iaCombustible", iaCombustible);
			nat.setParameter("in_iaNumInciso", iaNumInciso);
			nat.setParameter("in_iaNumPoliza", iaNumPoliza);
			nat.setParameter("in_iaDesAuto", iaDesAuto);

			nat.setParameter("in_iaNomOperador", iaNomOperador);

			nat.setParameter("in_iaNomRazon", iaNomRazon);

			nat.setParameter("in_iaLlaves", iaLlaves);
			nat.setParameter("in_iaPlacasAuto", iaPlacasAuto);
			nat.setParameter("in_iaTManual", iaTManual);
			nat.setParameter("in_iaDestino", iaDestino);

			nat.setParameter("in_emailDefault", emailDefault);
			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_iaObjetosPer", iaObjetosPer);
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);
			nat.setParameter("in_niu", niu);
			nat.setParameter("in_iaCorreoGrua", iaCorreoGrua);
			nat.setParameter("in_iaCorreoTaller", iaCorreoTaller);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			return String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarInventarioAutomoviles",

					iaNumReporte, iaTipoAuto, iaAsegurado, iaHora, iaInventario1, iaInventario2, iaInventario3,
					iaInventario4, iaInventario5, iaNomAjustador, iaNumMotor, iaAnioAuto, iaNomAsegurado,
					iaNumSiniestro, iaDirDestino, iaCantidad, iaObservacion, iaId, iaPuertasAuto, iaClaveAjustador,
					iaColorAuto, iaMarcaAuto, iaNomDestino, iaKilometraje, iaVidaLlantas, iaNumSerie, iaCombustible,
					iaNumInciso, iaNumPoliza, iaDesAuto,

					iaNomOperador,

					iaNomRazon,

					iaLlaves, iaPlacasAuto, iaTManual, iaDestino, emailDefault, enviadoEmail, ////
					mensajeEmail, ////
					iaObjetosPer, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
					firmaAsegurado, firmaOperRecibe, firmaAjusRecibe, niu, iaCorreoGrua, iaCorreoTaller

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarInventarioAutomoviles =>" + iaNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
	}

	@Override
	public String InsertarFormatoInventarioAutomoviles(DatosInsertarFormatoInventarioAutomoviles entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("IA_NUM_REPORTE", entrada.getIa_Num_Reporte());
		entry.put("IA_NUM_SINIESTRO", entrada.getIa_Num_Siniestro());
		entry.put("IA_NOM_RAZON", entrada.getIa_Nom_Razon());
		entry.put("IA_ASEGURADO", entrada.getIa_Asegurado());
		entry.put("IA_LLAVES", entrada.getIa_Llaves());
		entry.put("IA_CANTIDAD", entrada.getIa_Cantidad());
		entry.put("IA_HORA", entrada.getIa_Hora());
		entry.put("IA_NUM_POLIZA", entrada.getIa_Num_Poliza());
		entry.put("IA_DESTINO", entrada.getIa_Destino());
		entry.put("IA_NOM_DESTINO", entrada.getIa_Nom_Destino());
		entry.put("IA_DIR_DESTINO", entrada.getIa_Dir_Destino());
		entry.put("IA_MARCA_AUTO", entrada.getIa_Marca_Auto());
		entry.put("IA_TIPO_AUTO", entrada.getIa_Tipo_Auto());
		entry.put("IA_PUERTAS_AUTO", entrada.getIa_Puertas_Auto());
		entry.put("IA_ANIO_AUTO", entrada.getIa_Anio_Auto());
		entry.put("IA_NUM_MOTOR", entrada.getIa_Num_Motor());
		entry.put("IA_NUM_SERIE", entrada.getIa_Num_Serie());
		entry.put("IA_COLOR_AUTO", entrada.getIa_Color_Auto());
		entry.put("IA_PLACAS_AUTO", entrada.getIa_Placas_Auto());
		entry.put("IA_T_MANUAL", entrada.getIa_T_Manual());
		entry.put("IA_KILOMETRAJE", entrada.getIa_Kilometraje());
		entry.put("IA_COMBUSTIBLE", entrada.getIa_Combustible());
		entry.put("IA_DES_AUTO", entrada.getIa_Des_Auto());
		entry.put("IA_VIDA_LLANTAS", entrada.getIa_Vida_Llantas());
		entry.put("IA_OBSERVACION", entrada.getIa_Observacion());
		entry.put("IA_NOM_OPERADOR", entrada.getIa_Nom_Operador());
		entry.put("EMAIL_DEFAULT", entrada.getEmail_Default());
		entry.put("IA_NOM_ASEGURADO", entrada.getIa_Nom_Asegurado());
		entry.put("IA_INVENTARIO_1", entrada.getIa_Inventario_1());
		entry.put("IA_INVENTARIO_2", entrada.getIa_Inventario_2());
		entry.put("IA_INVENTARIO_3", entrada.getIa_Inventario_3());
		entry.put("IA_INVENTARIO_4", entrada.getIa_Inventario_4());
		entry.put("IA_INVENTARIO_5", entrada.getIa_Inventario_5());
		entry.put("IA_NUM_INCISO", entrada.getIa_Num_Inciso());
		entry.put("IA_NOM_AJUSTADOR", entrada.getIa_Nom_Ajustador());
		entry.put("IA_CLAVE_AJUSTADOR", entrada.getIa_Clave_Ajustador());
		entry.put("IA_OBJETOS_PER", entrada.getIa_Objetos_Per());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_ASEGURADO", entrada.getFirma_Asegurado());
		entry.put("FIRMA_OPER_RECIBE", entrada.getFirma_Oper_Recibe());
		entry.put("FIRMA_AJUS_RECIBE", entrada.getFirma_Ajus_Recibe());
		entry.put("NIU", entrada.getNiu());
		entry.put("IA_CORREO_GRUA", entrada.getIaCorreoGrua());
		entry.put("IA_CORREO_TALLER", entrada.getIaCorreoTaller());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFIA(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFIA(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FIA");

		String[] columnas = new String[] { "IA_NUM_REPORTE", "IA_NUM_SINIESTRO", "IA_NOM_RAZON", "IA_ASEGURADO",
				"IA_LLAVES", "IA_CANTIDAD", "IA_HORA", "IA_NUM_POLIZA", "IA_DESTINO", "IA_NOM_DESTINO",
				"IA_DIR_DESTINO", "IA_MARCA_AUTO", "IA_TIPO_AUTO", "IA_PUERTAS_AUTO", "IA_ANIO_AUTO", "IA_NUM_MOTOR",
				"IA_NUM_SERIE", "IA_COLOR_AUTO", "IA_PLACAS_AUTO", "IA_T_MANUAL", "IA_KILOMETRAJE", "IA_COMBUSTIBLE",
				"IA_DES_AUTO", "IA_VIDA_LLANTAS", "IA_OBSERVACION", "IA_NOM_OPERADOR", "EMAIL_DEFAULT",
				"IA_NOM_ASEGURADO", "IA_INVENTARIO_1", "IA_INVENTARIO_2", "IA_INVENTARIO_3", "IA_INVENTARIO_4",
				"IA_INVENTARIO_5", "IA_NUM_INCISO", "IA_NOM_AJUSTADOR", "IA_CLAVE_AJUSTADOR", "IA_OBJETOS_PER",
				"CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_ASEGURADO", "FIRMA_OPER_RECIBE", "FIRMA_AJUS_RECIBE",
				"NIU", "IA_CORREO_GRUA", "IA_CORREO_TALLER","CORREO_OCULTO" ,"FUENTE_WS","CHECK_5", "CHECK_6"};

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
			resultado = Objects.toString(this.getEntityManager().createNativeQuery(
					"select count(*) from FORMATO_INVENTARIO_AUTOMOVILES where IA_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}
}