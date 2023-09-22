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

import com.aaq.col.clases.database.entidades.FormatoReclamacionComprobantePeaje;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReclamacionComprobantePeaje_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoReclamacionComprobantePeajeDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReclamacionComprobantePeaje;

@org.springframework.stereotype.Repository(value = "formatoReclamacionComprobantePeajeDao")
public class FormatoReclamacionComprobantePeajeDao
		extends SIICAServerGenericDaoJpaImpl<FormatoReclamacionComprobantePeaje>
		implements FormatoReclamacionComprobantePeajeDaoInterfase {
	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoReclamacionComprobantePeaje objetoFormatoReclamacionComprobantePeaje(String id) {
		FormatoReclamacionComprobantePeaje de = null;
		try {
			de = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoReclamacionComprobantePeaje.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e,
			// "objetoFormatoReclamacionComprobantePeaje", id);
			log.error("Formatos Error=> objetoFormatoReclamacionComprobantePeaje=> " + id, e);

		}
		return de;
	}

	@Override
	public List<FormatoReclamacionComprobantePeaje> listaDeFormatoReclamacionComprobantePeaje() {
		TypedQuery<FormatoReclamacionComprobantePeaje> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoReclamacionComprobantePeaje> query = builder
					.createQuery(FormatoReclamacionComprobantePeaje.class);
			final Root<FormatoReclamacionComprobantePeaje> root = query.from(FormatoReclamacionComprobantePeaje.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(
					builder.or(builder.notEqual(root.get(AbstractFormatoReclamacionComprobantePeaje_.enviadoFtp), 1),
							builder.isNull(root.get(AbstractFormatoReclamacionComprobantePeaje_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoReclamacionComprobantePeaje_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e,
			// "listaDeFormatoReclamacionComprobantePeaje", 500);
			log.error("Formatos Error=> listaDeFormatoReclamacionComprobantePeaje", e);
		}
		return typedQ.getResultList();
	}

	@Override
	public String InsertarFormatoReclamacionComprobantePeaje(DatosInsertarFormatoReclamacionComprobantePeaje entrada) {

		Map<String, String> entry = new HashMap<String, String>();
		String result = null;

		entry.put("RCP_NUM_REPORTE", entrada.getRcp_num_reporte());
		entry.put("RCP_NUM_SINIESTRO", entrada.getRcp_num_siniestro());
		entry.put("RCP_NUM_POLIZA", entrada.getRcp_num_poliza());
		entry.put("RCP_NUM_ASEGURADO", entrada.getRcp_num_asegurado());
		entry.put("RCP_NOM_USUARIO", entrada.getRcp_nom_usuario());
		entry.put("RCP_SEXO_USUARIO", entrada.getRcp_sexo_usuario());
		entry.put("RCP_EDAD_USUARIO", entrada.getRcp_edad_usuario());
		entry.put("RCP_ESTADO_CIVIL_USUARIO", entrada.getRcp_estado_civil_usuario());
		entry.put("RCP_OCUPACION_USUARIO", entrada.getRcp_ocupacion_usuario());
		entry.put("RCP_TELEFONO_USUARIO", entrada.getRcp_telefono_usuario());
		entry.put("RCP_CORREO_USUARIO", entrada.getRcp_correo_usuario());
		entry.put("RCP_CALLE_USUARIO", entrada.getRcp_calle_usuario());
		entry.put("RCP_COLONIA_USUARIO", entrada.getRcp_colonia_usuario());
		entry.put("RCP_CP_USUARIO", entrada.getRcp_cp_usuario());
		entry.put("RCP_ESTADO_USUARIO", entrada.getRcp_estado_usuario());
		entry.put("RCP_POBLACION_USUARIO", entrada.getRcp_poblacion_usuario());
		entry.put("RCP_DELEGACION_USUARIO", entrada.getRcp_delegacion_usuario());
		entry.put("RCP_CALLE_OFICINA", entrada.getRcp_calle_oficina());
		entry.put("RCP_COLONIA_OFICINA", entrada.getRcp_colonia_oficina());
		entry.put("RCP_CP_OFICINA", entrada.getRcp_cp_oficina());
		entry.put("RCP_ESTADO_OFICINA", entrada.getRcp_estado_oficina());
		entry.put("RCP_POBLACION_OFICINA", entrada.getRcp_poblacion_oficina());
		entry.put("RCP_DELEGACION_OFICINA", entrada.getRcp_delegacion_oficina());
		entry.put("RCP_RAZON_CIRCULA_AUTO", entrada.getRcp_razon_circula_auto());
		entry.put("RCP_FECHA_SINIESTRO", entrada.getRcp_fecha_siniestro());
		entry.put("RCP_MARCA_VEHICULO", entrada.getRcp_marca_vehiculo());
		entry.put("RCP_VEHICULO_PROPIO", entrada.getRcp_vehiculo_propio());
		entry.put("RCP_LICENCIA", entrada.getRcp_licencia());
		entry.put("RCP_ORIGEN_VIAJE", entrada.getRcp_origen_viaje());
		entry.put("RCP_DESTINO_VIAJE", entrada.getRcp_destino_viaje());
		entry.put("RCP_MOTIVO_NO_COMPROB", entrada.getRcp_motivo_no_comprob());
		entry.put("RCP_NOM_AJUSTADOR", entrada.getRcp_nom_ajustador());
		entry.put("RCP_CLAVE_AJUSTADOR", entrada.getRcp_clave_ajustador());
		entry.put("RCP_NOM_ADMINISTRACION", entrada.getRcp_nom_administracion());
		entry.put("RCP_TESTIGO_1", entrada.getRcp_testigo_1());
		entry.put("RCP_TESTIGO_2", entrada.getRcp_testigo_2());
		entry.put("RCP_PAGO_PREVIO_PEAJE", entrada.getRcp_pago_previo_peaje());
		entry.put("RCP_NOM_PLAZA_1", entrada.getRcp_nom_plaza_1());
		entry.put("RCP_NOM_PLAZA_2", entrada.getRcp_nom_plaza_2());
		entry.put("RCP_CANTIDAD_PLAZA_1", entrada.getRcp_cantidad_plaza_1());
		entry.put("RCP_CANTIDAD_PLAZA_2", entrada.getRcp_cantidad_plaza_2());
		entry.put("RCP_FRECUENCIA_CIRCULA", entrada.getRcp_frecuencia_circula());
		entry.put("RCP_TARJETA_IAVE", entrada.getRcp_tarjeta_iave());
		entry.put("RCP_PAGO_TARJETA_CREDITO", entrada.getRcp_pago_tarjeta_credito());
		entry.put("RCP_VIA_INGRESO", entrada.getRcp_via_ingreso());
		entry.put("RCP_MOTIVO_DANIO", entrada.getRcp_motivo_danio());
		entry.put("RCP_CAUSA_METEOROLOGICA", entrada.getRcp_causa_meteorologica());
		entry.put("RCP_CAUSA_EVENTO", entrada.getRcp_causa_evento());
		entry.put("RCP_INGIRIO_SUSTANCIA", entrada.getRcp_ingirio_sustancia());
		entry.put("RCP_VEHICULO_ASEGURADO", entrada.getRcp_vehiculo_asegurado());
		entry.put("RCP_VEHICULO_ASEGURADO_POLIZA", entrada.getRcp_vehiculo_asegurado_poliza());
		entry.put("RCP_VEHICULO_ASEGURADO_COMPANIA", entrada.getRcp_vehiculo_asegurado_compania());
		entry.put("RCP_ANEXO_IDENTIFICACION", entrada.getRcp_anexo_identificacion());
		entry.put("RCP_ANEXO_LICENCIA", entrada.getRcp_anexo_licencia());
		entry.put("RCP_ANEXO_NARRACION", entrada.getRcp_anexo_narracion());
		entry.put("RCP_NOM_TESTIGO", entrada.getRcp_nom_testigo());
		entry.put("RCP_RELACION_TESTIGO", entrada.getRcp_relacion_testigo());
		entry.put("RCP_TELEFONO_TESTIGO", entrada.getRcp_telefono_testigo());
		entry.put("RCP_CALLE_TESTIGO", entrada.getRcp_calle_testigo());
		entry.put("RCP_COLONIA_TESTIGO", entrada.getRcp_colonia_testigo());
		entry.put("RCP_CP_TESTIGO", entrada.getRcp_cp_testigo());
		entry.put("RCP_ESTADO_TESTIGO", entrada.getRcp_estado_testigo());
		entry.put("RCP_POBLACION_TESTIGO", entrada.getRcp_poblacion_testigo());
		entry.put("RCP_DELEGACION_TESTIGO", entrada.getRcp_delegacion_testigo());
		entry.put("RCP_DECLARACION_TESTIGO", entrada.getRcp_declaracion_testigo());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());

		entry.put("FIRMA_AJUSTADOR", entrada.getFirma_ajustador());
		entry.put("FIRMA_ADMINISTRACION", entrada.getFirma_administracion());
		entry.put("FIRMA_USUARIO", entrada.getFirma_usuario());
		entry.put("FIRMA_TESTIGO1", entrada.getFirma_testigo1());
		entry.put("FIRMA_TESTIGO2", entrada.getFirma_testigo2());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFRCP(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFRCP(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FRCP");

		String[] columnas = new String[] { "RCP_NUM_REPORTE", "RCP_NUM_SINIESTRO", "RCP_NUM_POLIZA",
				"RCP_NUM_ASEGURADO", "RCP_NOM_USUARIO", "RCP_SEXO_USUARIO", "RCP_EDAD_USUARIO",
				"RCP_ESTADO_CIVIL_USUARIO", "RCP_OCUPACION_USUARIO", "RCP_TELEFONO_USUARIO", "RCP_CORREO_USUARIO",
				"RCP_CALLE_USUARIO", "RCP_COLONIA_USUARIO", "RCP_CP_USUARIO", "RCP_ESTADO_USUARIO",
				"RCP_POBLACION_USUARIO", "RCP_DELEGACION_USUARIO", "RCP_CALLE_OFICINA", "RCP_COLONIA_OFICINA",
				"RCP_CP_OFICINA", "RCP_ESTADO_OFICINA", "RCP_POBLACION_OFICINA", "RCP_DELEGACION_OFICINA",
				"RCP_RAZON_CIRCULA_AUTO", "RCP_FECHA_SINIESTRO", "RCP_MARCA_VEHICULO", "RCP_VEHICULO_PROPIO",
				"RCP_LICENCIA", "RCP_ORIGEN_VIAJE", "RCP_DESTINO_VIAJE", "RCP_MOTIVO_NO_COMPROB", "RCP_NOM_AJUSTADOR",
				"RCP_CLAVE_AJUSTADOR", "RCP_NOM_ADMINISTRACION", "RCP_TESTIGO_1", "RCP_TESTIGO_2",
				"RCP_PAGO_PREVIO_PEAJE", "RCP_NOM_PLAZA_1", "RCP_NOM_PLAZA_2", "RCP_CANTIDAD_PLAZA_1",
				"RCP_CANTIDAD_PLAZA_2", "RCP_FRECUENCIA_CIRCULA", "RCP_TARJETA_IAVE", "RCP_PAGO_TARJETA_CREDITO",
				"RCP_VIA_INGRESO", "RCP_MOTIVO_DANIO", "RCP_CAUSA_METEOROLOGICA", "RCP_CAUSA_EVENTO",
				"RCP_INGIRIO_SUSTANCIA", "RCP_VEHICULO_ASEGURADO", "RCP_VEHICULO_ASEGURADO_POLIZA",
				"RCP_VEHICULO_ASEGURADO_COMPANIA", "RCP_ANEXO_IDENTIFICACION", "RCP_ANEXO_LICENCIA",
				"RCP_ANEXO_NARRACION", "RCP_NOM_TESTIGO", "RCP_RELACION_TESTIGO", "RCP_TELEFONO_TESTIGO",
				"RCP_CALLE_TESTIGO", "RCP_COLONIA_TESTIGO", "RCP_CP_TESTIGO", "RCP_ESTADO_TESTIGO",
				"RCP_POBLACION_TESTIGO", "RCP_DELEGACION_TESTIGO", "RCP_DECLARACION_TESTIGO", "CHECK_1", "CHECK_2",
				"CHECK_3", "CHECK_4", "FIRMA_AJUSTADOR", "FIRMA_ADMINISTRACION", "FIRMA_USUARIO", "FIRMA_TESTIGO1",
				"FIRMA_TESTIGO2","CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6"

		};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(79, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(79));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_RECLAMACION_COMPROBANTE_PEAJE where RCP_NUM_REPORTE='"
									+ reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}
	
	
	 

}