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

import com.aaq.col.clases.database.entidades.FormatoInventarioUnicoPesado;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoInventarioUnicoPesado_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoInventarioUnicoPesadoDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoInventarioUnicoPesado;

@org.springframework.stereotype.Repository(value = "formatoInventarioUnicoPesadoDao")
public class FormatoInventarioUnicoPesadoDao extends SIICAServerGenericDaoJpaImpl<FormatoInventarioUnicoPesado>
		implements FormatoInventarioUnicoPesadoDaoInterfase {
	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoInventarioUnicoPesado objetoFormatoInventarioUnicoPesado(String id) {
		FormatoInventarioUnicoPesado de = null;
		try {
			de = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoInventarioUnicoPesado.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoInventarioUnicoPesado", id);
			log.error("Formatos Error=> objetoFormatoInventarioUnicoPesado=> " + id, e);

		}
		return de;
	}

	@Override
	public List<FormatoInventarioUnicoPesado> listaDeFormatoInventarioUnicoPesado() {
		TypedQuery<FormatoInventarioUnicoPesado> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoInventarioUnicoPesado> query = builder.createQuery(FormatoInventarioUnicoPesado.class);
			final Root<FormatoInventarioUnicoPesado> root = query.from(FormatoInventarioUnicoPesado.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
 
			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoInventarioUnicoPesado_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoInventarioUnicoPesado_.enviadoFtp))));

		 
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoInventarioUnicoPesado_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoInventarioUnicoPesado", 500);
			log.error("Formatos Error=> listaDeFormatoInventarioUnicoPesado", e);
		}
		return typedQ.getResultList();
	}


	@Override
	public String InsertarFormatoInventarioUnicoPesado(DatosInsertarFormatoInventarioUnicoPesado entrada) {

		Map<String, String> entry = new HashMap<String, String>();
		String result = null;
		
		    entry.put("INP_FOLIO_E" , entrada.getInp_folio_e());
			entry.put("INP_SERIE", entrada.getInp_serie());
			entry.put("INP_COLOR" , entrada.getInp_color());
			entry.put("INP_PLACAS" ,entrada.getInp_placas());
		 	entry.put("INP_NUM_REPORTE" , entrada.getInp_num_reporte());
			entry.put("INP_NUM_SINIESTRO", entrada.getInp_num_siniestro());
			entry.put("INP_NUM_POLIZA", entrada.getInp_num_poliza());
			entry.put("INP_NUM_ASEGURADO", entrada.getInp_num_asegurado());
			entry.put("INP_NOMBRE_AFECTADO", entrada.getInp_nombre_afectado());
			entry.put("INP_LLAVES" ,entrada.getInp_llaves());
			entry.put("INP_FECHA" ,entrada.getInp_fecha());
			entry.put("INP_NUM_ENDOSO",entrada.getInp_num_endoso());
			entry.put("INP_NUM_INCISO", entrada.getInp_num_inciso());
			entry.put("INP_MARCA", entrada.getInp_marca());
			entry.put("INP_TIPO", entrada.getInp_tipo());
			entry.put("INP_PUERTAS", entrada.getInp_puertas());
			entry.put("INP_MODELO", entrada.getInp_modelo());
			entry.put("INP_NUM_MOTOR", entrada.getInp_num_motor());
			entry.put("INP_KILOMETRAJE",entrada.getInp_kilometraje());
			entry.put("INP_COMBUSTIBLE", entrada.getInp_combustible());
			entry.put("INP_CORREO",entrada.getInp_correo());
			entry.put("INP_TRACTOCAMION_PIEZA", entrada.getInp_tractocamion_pieza());
			entry.put("INP_ORIGINALES_CAMION", entrada.getInp_originales_camion());
			entry.put("INP_RENOVADAS_CAMION" ,entrada.getInp_renovadas_camion());
			entry.put("INP_DANIADAS_CAMION" ,entrada.getInp_daniadas_camion());
			entry.put("INP_FALTANTES_CAMION", entrada.getInp_faltantes_camion());
			entry.put("INP_DANIADAS_REMOLQUE" ,entrada.getInp_daniadas_remolque());
			entry.put("INP_FALTANTES_REMOLQUE" ,entrada.getInp_faltantes_remolque());
			entry.put("INP_NOMBRE_CONDUCTOR",entrada.getInp_nombre_conductor());
			entry.put("INP_NOMBRE_OPERADOR_GRUA" ,entrada.getInp_nombre_operador_grua());
			entry.put("INP_CASO1_FECHA" ,entrada.getInp_caso1_fecha());
			entry.put("INP_CASO1_LUGAR" ,entrada.getInp_caso1_lugar());
			entry.put("INP_CASO1_OBSERVACIONES" ,entrada.getInp_caso1_observaciones());
			entry.put("INP_CASO1_NOM_ENTREGA",entrada.getInp_caso1_nom_entrega());
			entry.put("INP_CASO1_NOM_RECIBE",entrada.getInp_caso1_nom_recibe());		
			entry.put("INP_CASO2_FECHA" ,entrada.getInp_caso2_fecha());
			entry.put("INP_CASO2_LUGAR" ,entrada.getInp_caso2_lugar());
			entry.put("INP_CASO2_OBSERVACIONES" ,entrada.getInp_caso2_observaciones());
			entry.put("INP_CASO2_NOM_ENTREGA",entrada.getInp_caso2_nom_entrega());
			entry.put("INP_CASO2_NOM_RECIBE", entrada.getInp_caso2_nom_recibe());					
			entry.put("INP_CASO3_FECHA", entrada.getInp_caso3_fecha());
			entry.put("INP_CASO3_LUGAR"  ,entrada.getInp_caso3_lugar());
			entry.put("INP_CASO3_OBSERVACIONES",entrada.getInp_caso3_observaciones());
			entry.put("INP_CASO3_NOM_ENTREGA",entrada.getInp_caso3_nom_entrega());
			entry.put("INP_CASO3_NOM_RECIBE" ,entrada.getInp_caso3_nom_recibe());		
			entry.put("FIRMA_AJUSTADOR" ,entrada.getFirma_ajustador());
			entry.put("FIRMA_CONDUCTOR",entrada.getFirma_conductor());
			entry.put("FIRMA_OPERADOR_GRUA" ,entrada.getFirma_operador_grua());			
			entry.put("FIRMA_CASO1_ENTREGA",entrada.getFirma_caso1_entrega());
			entry.put("FIRMA_CASO1_RECIBE" , entrada.getFirma_caso1_recibe());
			entry.put("FIRMA_CASO2_ENTREGA" , entrada.getFirma_caso2_entrega());
			entry.put("FIRMA_CASO2_RECIBE",entrada.getFirma_caso2_recibe());
			entry.put("FIRMA_CASO3_ENTREGA", entrada.getFirma_caso3_entrega());
			entry.put("FIRMA_CASO3_RECIBE", entrada.getFirma_caso3_recibe());
			entry.put("INP_NOM_AJUSTADOR", entrada.getInp_nom_ajustador());
			entry.put("INP_CLAVE_AJUSTADOR" , entrada.getInp_clave_ajustador());
			entry.put("CHECK_1" , entrada.getCheck_1());
			entry.put("CHECK_2", entrada.getCheck_2());
			entry.put("CHECK_3",entrada.getCheck_3());
			entry.put("CHECK_4", entrada.getCheck_4());
		
			entry.put("INP_CORREO_GRUA",entrada.getInp_correo_grua() );
			entry.put("INP_CORREO_TALLER",entrada.getInp_correo_taller() );
			entry.put("INP_CASO_1_UBICACION_FLECHA",entrada.getInp_caso_1_ubicacion_flecha() );
			entry.put("INP_CASO_1_A_LUGAR",entrada.getInp_caso_1_a_lugar() );
			entry.put("INP_CASO_1_PRESTADOR",entrada.getInp_caso_1_prestador() );
			entry.put("INP_CASO_1_DANIOS_FALTANTES",entrada.getInp_caso_1_danios_faltantes() );
			entry.put("INP_CASO_1_CRUCERO",entrada.getInp_caso_1_crucero() );
			entry.put("INP_CASO_1_TALLER",entrada.getInp_caso_1_taller() );
			entry.put("INP_CASO_1_MP",entrada.getInp_caso_1_mp() );
			entry.put("INP_CASO_1_AJUSTADOR",entrada.getInp_caso_1_ajustador() );
			
			entry.put("INP_CASO_2_UBICACION_FLECHA",entrada.getInp_caso_2_ubicacion_flecha() );
			entry.put("INP_CASO_2_A_LUGAR",entrada.getInp_caso_2_a_lugar() );
			entry.put("INP_CASO_2_PRESTADOR",entrada.getInp_caso_2_prestador() );
			entry.put("INP_CASO_2_DANIOS_FALTANTES",entrada.getInp_caso_2_danios_faltantes() );
			entry.put("INP_CASO_2_CRUCERO",entrada.getInp_caso_2_crucero() );
			entry.put("INP_CASO_2_TALLER",entrada.getInp_caso_2_taller() );
			entry.put("INP_CASO_2_MP",entrada.getInp_caso_2_mp() );
			entry.put("INP_CASO_2_AJUSTADOR",entrada.getInp_caso_2_ajustador() );
			
			entry.put("INP_CASO_3_UBICACION_FLECHA",entrada.getInp_caso_3_ubicacion_flecha() );
			entry.put("INP_CASO_3_A_LUGAR",entrada.getInp_caso_3_a_lugar() );
			entry.put("INP_CASO_3_PRESTADOR",entrada.getInp_caso_3_prestador() );
			entry.put("INP_CASO_3_DANIOS_FALTANTES",entrada.getInp_caso_3_danios_faltantes() );
			entry.put("INP_CASO_3_CRUCERO",entrada.getInp_caso_3_crucero() );
			entry.put("INP_CASO_3_TALLER",entrada.getInp_caso_3_taller() );
			entry.put("INP_CASO_3_MP",entrada.getInp_caso_3_mp() );
			entry.put("INP_CASO_3_AJUSTADOR",entrada.getInp_caso_3_ajustador() );
			
			entry.put("INP_NOM_ENTREGA_GRAL",entrada.getInp_nom_entrega_gral() );
			entry.put("INP_NOM_RECIBE_GRAL",entrada.getInp_nom_recibe_gral() );
			entry.put("FIRMA_RECIBE_GRAL",entrada.getFirma_recibe_gral() );
			entry.put("FIRMA_ENTREGA_GRAL",entrada.getFirma_entrega_gral() );
			entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
			entry.put("FUENTE_WS", entrada.getFuente_ws());
			entry.put("CHECK_5", entrada.getCheck_5());
			entry.put("CHECK_6", entrada.getCheck_6());
		  


		result = ejecutarFuncionWebserviceStoreFINP(entry);
		return result;
	}
 
	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFINP(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FIUP");

		String[] columnas = new String[] { 
				 "INP_FOLIO_E" , 
		          "INP_SERIE", 
		           "INP_COLOR" , 
		            "INP_PLACAS" , 
				"INP_NUM_REPORTE",
				"INP_NUM_SINIESTRO",
				"INP_NUM_POLIZA",
				"INP_NUM_ASEGURADO",
				"INP_NOMBRE_AFECTADO",
				"INP_LLAVES",
				"INP_FECHA",
				"INP_NUM_ENDOSO",
				"INP_NUM_INCISO",
				"INP_MARCA",
				"INP_TIPO",
				"INP_PUERTAS",
				"INP_MODELO",
				"INP_NUM_MOTOR",
				"INP_KILOMETRAJE",
				"INP_COMBUSTIBLE",
				"INP_CORREO",
				"INP_TRACTOCAMION_PIEZA",
				"INP_ORIGINALES_CAMION",
				"INP_RENOVADAS_CAMION",
				"INP_DANIADAS_CAMION",
				"INP_FALTANTES_CAMION",
				"INP_DANIADAS_REMOLQUE",
				"INP_FALTANTES_REMOLQUE",
				"INP_NOMBRE_CONDUCTOR",
				"INP_NOMBRE_OPERADOR_GRUA",
				"INP_CASO1_FECHA",
				"INP_CASO1_LUGAR",
				"INP_CASO1_OBSERVACIONES",
				"INP_CASO1_NOM_ENTREGA",
				"INP_CASO1_NOM_RECIBE",
				"INP_CASO2_FECHA",
				"INP_CASO2_LUGAR",
				"INP_CASO2_OBSERVACIONES",
				"INP_CASO2_NOM_ENTREGA",
				"INP_CASO2_NOM_RECIBE",
				"INP_CASO3_FECHA",
				"INP_CASO3_LUGAR",
				"INP_CASO3_OBSERVACIONES",
				"INP_CASO3_NOM_ENTREGA",
				"INP_CASO3_NOM_RECIBE",
				"FIRMA_AJUSTADOR",
				"FIRMA_CONDUCTOR",
				"FIRMA_OPERADOR_GRUA",
				"FIRMA_CASO1_ENTREGA",
				"FIRMA_CASO1_RECIBE",
				"FIRMA_CASO2_ENTREGA",
				"FIRMA_CASO2_RECIBE",
				"FIRMA_CASO3_ENTREGA",
				"FIRMA_CASO3_RECIBE",
				"INP_NOM_AJUSTADOR",
				"INP_CLAVE_AJUSTADOR",
				"CHECK_1",
				"CHECK_2",
				"CHECK_3",
				"CHECK_4",
				"INP_CORREO_GRUA",
				"INP_CORREO_TALLER",
				"INP_CASO_1_UBICACION_FLECHA",
				"INP_CASO_1_A_LUGAR",
				"INP_CASO_1_PRESTADOR",
				"INP_CASO_1_DANIOS_FALTANTES",
				"INP_CASO_1_CRUCERO",
				"INP_CASO_1_TALLER",
				"INP_CASO_1_MP",
				"INP_CASO_1_AJUSTADOR",
				"INP_CASO_2_UBICACION_FLECHA",
				"INP_CASO_2_A_LUGAR",
				"INP_CASO_2_PRESTADOR",
				"INP_CASO_2_DANIOS_FALTANTES",
				"INP_CASO_2_CRUCERO",
				"INP_CASO_2_TALLER",
				"INP_CASO_2_MP",
				"INP_CASO_2_AJUSTADOR",
				"INP_CASO_3_UBICACION_FLECHA",
				"INP_CASO_3_A_LUGAR",
				"INP_CASO_3_PRESTADOR",
				"INP_CASO_3_DANIOS_FALTANTES",
				"INP_CASO_3_CRUCERO",
				"INP_CASO_3_TALLER",
				"INP_CASO_3_MP",
				"INP_CASO_3_AJUSTADOR",
				"INP_NOM_ENTREGA_GRAL",
				"INP_NOM_RECIBE_GRAL",
				"FIRMA_RECIBE_GRAL",
				"FIRMA_ENTREGA_GRAL",
				"CORREO_OCULTO",
				"FUENTE_WS","CHECK_5", "CHECK_6"
				  
};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(95, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(95));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_INVENTARIO_UNICO_PESADO where INP_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}