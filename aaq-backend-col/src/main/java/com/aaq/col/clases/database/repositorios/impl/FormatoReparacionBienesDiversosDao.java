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

import com.aaq.col.clases.database.entidades.FormatoReparacionBienesDiversos;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReparacionBienesDiversos_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoReparacionBienesDiversosDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReparacionBienesDiversos;

@org.springframework.stereotype.Repository(value = "formatoReparacionBienesDiversosDao")
public class FormatoReparacionBienesDiversosDao extends SIICAServerGenericDaoJpaImpl<FormatoReparacionBienesDiversos>
		implements FormatoReparacionBienesDiversosDaoInterfase {
	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoReparacionBienesDiversos objetoFormatoReparacionBienesDiversos(String id) {
		FormatoReparacionBienesDiversos de = null;
		try {
			de = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoReparacionBienesDiversos.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e,
			// "objetoFormatoReparacionBienesDiversos", id);
			log.error("Formatos Error=> objetoFormatoReparacionBienesDiversos=> " + id, e);

		}
		return de;
	}

	@Override
	public List<FormatoReparacionBienesDiversos> listaDeFormatoReparacionBienesDiversos() {
		TypedQuery<FormatoReparacionBienesDiversos> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoReparacionBienesDiversos> query = builder
					.createQuery(FormatoReparacionBienesDiversos.class);
			final Root<FormatoReparacionBienesDiversos> root = query.from(FormatoReparacionBienesDiversos.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates
					.add(builder.or(builder.notEqual(root.get(AbstractFormatoReparacionBienesDiversos_.enviadoFtp), 1),
							builder.isNull(root.get(AbstractFormatoReparacionBienesDiversos_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoReparacionBienesDiversos_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e,
			// "listaDeFormatoReparacionBienesDiversos", 500);
			log.error("Formatos Error=> listaDeFormatoReparacionBienesDiversos", e);
		}
		return typedQ.getResultList();
	}

	@Override
	public String InsertarFormatoReparacionBienesDiversos(DatosInsertarFormatoReparacionBienesDiversos entrada) {

		Map<String, String> entry = new HashMap<String, String>();
		String result = null;

		entry.put("BD_NUM_REPORTE", entrada.getBd_num_reporte());
		entry.put("BD_NUM_SINIESTRO", entrada.getBd_num_siniestro());
		entry.put("BD_NUM_POLIZA", entrada.getBd_num_poliza());
		entry.put("BD_NUM_ASEGURADO", entrada.getBd_num_asegurado());
		entry.put("BD_FECHA", entrada.getBd_fecha());
		entry.put("BD_NOMBRE_AFECTADO", entrada.getBd_nombre_afectado());
		entry.put("BD_TEL_AFECTADO", entrada.getBd_tel_afectado());
		entry.put("BD_UBICACION_SINIESTRO", entrada.getBd_ubicacion_siniestro());
		entry.put("BD_DOMICILIO_SINIESTRO", entrada.getBd_domicilio_siniestro());
		entry.put("BD_TELEFONO_SINIESTRO", entrada.getBd_telefono_siniestro());
		entry.put("BD_UBICACION_RESGUARDO", entrada.getBd_ubicacion_resguardo());
		entry.put("BD_DOMICILIO_RESGUARDO", entrada.getBd_domicilio_resguardo());
		entry.put("BD_TELEFONO_RESGUARDO", entrada.getBd_telefono_resguardo());
		entry.put("BD_RESPONSABLE", entrada.getBd_responsable());
		entry.put("BD_DANIOS_DIVERSOS", entrada.getBd_danios_diversos());
		entry.put("BD_OBSERVACIONES", entrada.getBd_observaciones());
		entry.put("BD_LONG", entrada.getBd_long());
		entry.put("BD_ALTO", entrada.getBd_alto());
		entry.put("BD_ANCHO", entrada.getBd_ancho());
		entry.put("BD_TIPO", entrada.getBd_tipo());
		entry.put("BD_SERIE", entrada.getBd_serie());
		entry.put("BD_TRAMO", entrada.getBd_tramo());
		entry.put("BD_KM", entrada.getBd_km());
		entry.put("BD_DESCRIPCION_DANIOS_CAN", entrada.getBd_descripcion_danios_can());
		entry.put("BD_DES_DANIOS_PRE", entrada.getBd_des_danios_pre());
		entry.put("BD_MOTIVO", entrada.getBd_motivo());
		entry.put("BD_CORREO", entrada.getBd_correo());
		entry.put("BD_NOM_AJUSTADOR", entrada.getBd_nom_ajustador());
		entry.put("BD_CLAVE_AJUSTADOR", entrada.getBd_clave_ajustador());
		entry.put("BD_NOM_ASEGURADO_TERCERO", entrada.getBd_nom_asegurado_tercero());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("ILUSTRACION", entrada.getIlustracion());
		entry.put("FIRMA_AJUSTADOR", entrada.getFirma_ajustador());
		entry.put("FIRMA_ASEGURADO_TERCERO", entrada.getFirma_asegurado_tercero());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFBD(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFBD(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FBD");

		String[] columnas = new String[] { "BD_NUM_REPORTE", "BD_NUM_SINIESTRO", "BD_NUM_POLIZA", "BD_NUM_ASEGURADO",
				"BD_FECHA", "BD_NOMBRE_AFECTADO", "BD_TEL_AFECTADO", "BD_UBICACION_SINIESTRO", "BD_DOMICILIO_SINIESTRO",
				"BD_TELEFONO_SINIESTRO", "BD_UBICACION_RESGUARDO", "BD_DOMICILIO_RESGUARDO", "BD_TELEFONO_RESGUARDO",
				"BD_RESPONSABLE", "BD_DANIOS_DIVERSOS", "BD_OBSERVACIONES", "BD_LONG", "BD_ALTO", "BD_ANCHO", "BD_TIPO",
				"BD_SERIE", "BD_TRAMO", "BD_KM", "BD_DESCRIPCION_DANIOS_CAN", "BD_DES_DANIOS_PRE", "BD_MOTIVO",
				"BD_CORREO", "BD_NOM_AJUSTADOR", "BD_CLAVE_AJUSTADOR", "BD_NOM_ASEGURADO_TERCERO", "CHECK_1", "CHECK_2",
				"CHECK_3", "CHECK_4", "ILUSTRACION", "FIRMA_AJUSTADOR", "FIRMA_ASEGURADO_TERCERO", "CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6"

		};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(42, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(42));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager().createNativeQuery(
					"select count(*) from FORMATO_REPARACION_BIENES_DIVERSOS where BD_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}