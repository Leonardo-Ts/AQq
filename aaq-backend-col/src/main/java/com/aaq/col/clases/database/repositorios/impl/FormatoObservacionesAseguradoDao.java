package com.aaq.col.clases.database.repositorios.impl;

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

import com.aaq.col.clases.database.entidades.FormatoObservacionesAsegurado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoObservacionesAsegurado_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoObservacionesAseguradoDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoObservacionesAsegurado;

@org.springframework.stereotype.Repository(value = "formatoObservacionesAseguradoDao")
public class FormatoObservacionesAseguradoDao extends SIICAServerGenericDaoJpaImpl<FormatoObservacionesAsegurado>
		implements FormatoObservacionesAseguradoDaoInterfase {
	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoObservacionesAsegurado objetoFormatoObservacionesAsegurado(String id) {
		FormatoObservacionesAsegurado de = null;
		try {
			de = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoObservacionesAsegurado.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoObservacionesAsegurado",
			// id);
			log.error("Formatos Error=> objetoFormatoObservacionesAsegurado=> " + id, e);

		}
		return de;
	}

	@Override
	public List<FormatoObservacionesAsegurado> listaDeFormatoObservacionesAsegurado() {
		TypedQuery<FormatoObservacionesAsegurado> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoObservacionesAsegurado> query = builder
					.createQuery(FormatoObservacionesAsegurado.class);
			final Root<FormatoObservacionesAsegurado> root = query.from(FormatoObservacionesAsegurado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoObservacionesAsegurado_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoObservacionesAsegurado_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoObservacionesAsegurado_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoObservacionesAsegurado",
			// 500);
			log.error("Formatos Error=> listaDeFormatoObservacionesAsegurado", e);
		}
		return typedQ.getResultList();
	}

	@Override
	public String InsertarFormatoObservacionesAsegurado(DatosInsertarFormatoObservacionesAsegurado entrada) {

		Map<String, String> entry = new HashMap<String, String>();
		String result = null;

		entry.put("FOA_NUM_REPORTE", entrada.getFOA_NUM_REPORTE());
		entry.put("FOA_NUM_SINIESTRO", entrada.getFOA_NUM_SINIESTRO());
		entry.put("FOA_NUM_POLIZA", entrada.getFOA_NUM_POLIZA());
		entry.put("FOA_NUM_ASEGURADO", entrada.getFOA_NUM_ASEGURADO());
		entry.put("FOA_NOM_AJUSTADOR", entrada.getFOA_NOM_AJUSTADOR());
		entry.put("FOA_OBSERVACIONES", entrada.getFOA_OBSERVACIONES());
		entry.put("FOA_NOM_CONDUCTOR", entrada.getFOA_NOM_CONDUCTOR());
		entry.put("FOA_TELEFONO", entrada.getFOA_TELEFONO());
		entry.put("FOA_CORREO_CONDUCTOR", entrada.getFOA_CORREO_CONDUCTOR());
		entry.put("FOA_CLAVE_AJUSTADOR", entrada.getFOA_CLAVE_AJUSTADOR());
		entry.put("FOA_FECHA", entrada.getFOA_FECHA());
		entry.put("FOA_LUGAR", entrada.getFOA_LUGAR());
		entry.put("CHECK_1", entrada.getCHECK_1());
		entry.put("CHECK_2", entrada.getCHECK_2());
		entry.put("CHECK_3", entrada.getCHECK_3());
		entry.put("CHECK_4", entrada.getCHECK_4());
		entry.put("FIRMA_CONDUCTOR", entrada.getFIRMA_CONDUCTOR());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFOA(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFOA(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FOA");

		String[] columnas = new String[] { "FOA_NUM_REPORTE", "FOA_NUM_SINIESTRO", "FOA_NUM_POLIZA",
				"FOA_NUM_ASEGURADO", "FOA_NOM_AJUSTADOR", "FOA_OBSERVACIONES", "FOA_NOM_CONDUCTOR", "FOA_TELEFONO",
				"FOA_CORREO_CONDUCTOR", "FOA_CLAVE_AJUSTADOR", "FOA_FECHA", "FOA_LUGAR", "CHECK_1", "CHECK_2",
				"CHECK_3", "CHECK_4", "FIRMA_CONDUCTOR", "CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6"

		};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(22, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(22));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager().createNativeQuery(
					"select count(*) from FORMATO_OBSERVACIONES_ASEGURADO where FOA_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}