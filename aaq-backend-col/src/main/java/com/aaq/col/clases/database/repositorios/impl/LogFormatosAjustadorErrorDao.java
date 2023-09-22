package com.aaq.col.clases.database.repositorios.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.LogFormatosAjustadorError;
import com.aaq.col.clases.database.entidades.abstracto.AbstractLogFormatosAjustadorError_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.LogFormatosAjustadorErrorDaoInterfase;

@org.springframework.stereotype.Repository(value = "logFormatosAjustadorErrorDao")
public class LogFormatosAjustadorErrorDao extends SIICAServerGenericDaoJpaImpl<LogFormatosAjustadorError>
		implements LogFormatosAjustadorErrorDaoInterfase {

	@Override
	public LogFormatosAjustadorError objetoLogFormatosAjustadorError(String id) {
		LogFormatosAjustadorError re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(LogFormatosAjustadorError.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoLogFormatosAjustadorError", id);
		}
		return re;
	}

	@Override
	public List<LogFormatosAjustadorError> listaDeLogFormatosAjustadorError() {
		TypedQuery<LogFormatosAjustadorError> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<LogFormatosAjustadorError> query = builder.createQuery(LogFormatosAjustadorError.class);
			final Root<LogFormatosAjustadorError> root = query.from(LogFormatosAjustadorError.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			// predicates.add(builder.or(builder.notEqual(root.get(AbstractLogFormatosAjustadorError_.enviadoFtp),
			// 1),
			// builder.isNull(root.get(AbstractLogFormatosAjustadorError_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractLogFormatosAjustadorError_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeLogFormatosAjustadorError", 500);
		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarLogFormatosAjustadorError(

			String descripcion, String nombreFormato, String folioFormato, Timestamp fechaHora, Integer id

	) {
		String resp = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_logFormatos1");

			nat.registerStoredProcedureParameter("in_descripcion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nombreFormato", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_folioFormato", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fechaHora", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_id", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_descripcion", descripcion);
			nat.setParameter("in_nombreFormato", nombreFormato);
			nat.setParameter("in_folioFormato", folioFormato);
			nat.setParameter("in_fechaHora", fechaHora);
			nat.setParameter("in_id", id);
			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			resp = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionInsertarLogFormatosAjustadorError",

					descripcion, nombreFormato, folioFormato, fechaHora, id

			);

			return "ERROR: " + e.getMessage();
		}
		return resp;
	}
	/*
	 * 
	 * @Override public String
	 * InsertarFormatoAdmisionAutomoviles(DatosInsertarFormatoAdmisionAutomoviles
	 * entrada) {
	 * 
	 * Map<String, String> entry = new HashMap<String, String>();
	 * entry.put("OA_FOLIO_ELECTRO",entrada.getOa_Folio_Electro());
	 * entry.put("OA_NUM_REPORTE",entrada.getOa_Num_Reporte());
	 * entry.put("OA_NUM_SINIESTRO",entrada.getOa_Num_Siniestro());
	 * entry.put("OA_ASEGURADO",entrada.getOa_Asegurado());
	 * entry.put("OA_FECHA",entrada.getOa_Fecha());
	 * entry.put("OA_NUM_POLIZA",entrada.getOa_Num_Poliza());
	 * entry.put("OA_NUM_ENDOSO",entrada.getOa_Num_Endoso());
	 * entry.put("OA_NUM_INCISO",entrada.getOa_Num_Inciso());
	 * entry.put("OA_NOM_CLIENTE",entrada.getOa_Nom_Cliente());
	 * entry.put("OA_EMAIL_CLIENTE",entrada.getOa_Email_Cliente());
	 * entry.put("OA_TEL_CLIENTE",entrada.getOa_Tel_Cliente());
	 * entry.put("OA_RAZON_ENVIO",entrada.getOa_Razon_Envio());
	 * entry.put("OA_RAZON_RESPONSABLE",entrada.getOa_Razon_Responsable());
	 * entry.put("OA_RAZON_TELEFONO",entrada.getOa_Razon_Telefono());
	 * entry.put("OA_RAZON_DOMICILIO",entrada.getOa_Razon_Domicilio());
	 * entry.put("OA_RAZON_COBERTURA",entrada.getOa_Razon_Cobertura());
	 * entry.put("OA_MARCA_AUTO",entrada.getOa_Marca_Auto());
	 * entry.put("OA_TIPO_AUTO",entrada.getOa_Tipo_Auto());
	 * entry.put("OA_KILOMETRAJE",entrada.getOa_Kilometraje());
	 * entry.put("OA_NUM_SERIE",entrada.getOa_Num_Serie());
	 * entry.put("OA_COLOR_AUTO",entrada.getOa_Color_Auto());
	 * entry.put("OA_PLACA_AUTO",entrada.getOa_Placa_Auto());
	 * entry.put("OA_T_MANUAL",entrada.getOa_T_Manual());
	 * entry.put("OA_DEDUCIBLE",entrada.getOa_Deducible());
	 * entry.put("OA_TIPO_DEDUCIBLE",entrada.getOa_Tipo_Deducible());
	 * entry.put("OA_ADMIN_DEDUCIBLE",entrada.getOa_Admin_Deducible());
	 * entry.put("OA_SUMA_ASEGURADA",entrada.getOa_Suma_Asegurada());
	 * entry.put("OA_PORCENTAJE_DED",entrada.getOa_Porcentaje_Ded());
	 * entry.put("OA_CANTIDAD",entrada.getOa_Cantidad());
	 * entry.put("OA_DESC_DANIOS",entrada.getOa_Desc_Danios());
	 * entry.put("OA_NIVEL_INUNDACION",entrada.getOa_Nivel_Inundacion());
	 * entry.put("OA_PERDIDA_TOTAL",entrada.getOa_Perdida_Total());
	 * entry.put("OA_DANIOS_PRE",entrada.getOa_Danios_Pre());
	 * entry.put("OA_NOM_AJUSTADOR",entrada.getOa_Nom_Ajustador());
	 * entry.put("OA_CLAVE_AJUSTADOR",entrada.getOa_Clave_Ajustador());
	 * //entry.put("USUARIO",entrada.getUsuario());
	 * //entry.put("ID_AJUSTADOR",entrada.getId_Ajustador());
	 * entry.put("OA_MODELO_AUTO",entrada.getOa_Modelo_Auto());
	 * entry.put("OA_AGRAVAMIENTO",entrada.getOa_Agravamiento());
	 * 
	 * 
	 * ArrayList<SqlParameter> sqlParams = new ArrayList<SqlParameter>();
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); sqlParams.add(new SqlParameter(Types.VARCHAR));
	 * sqlParams.add(new SqlParameter(Types.VARCHAR)); //sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); //sqlParams.add(new
	 * SqlParameter(Types.VARCHAR)); String
	 * result=ejecutarFuncionWebserviceStoreFAAuto(entry); return result; }
	 * 
	 * //DB
	 * 
	 * @Override public String ejecutarFuncionWebserviceStoreFAAuto(Map<String,
	 * String> entry) { StoredProcedureQuery query = this.getEntityManager().
	 * createStoredProcedureQuery("WEBSERVICESTORE_FAAuto").
	 * registerStoredProcedureParameter(1, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(2, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(3, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(4, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(5, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(6, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(7, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(8, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(9, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(10, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(11, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(12, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(13, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(14, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(15, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(16, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(17, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(18, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(19, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(20, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(21, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(22, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(23, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(24, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(25, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(26, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(27, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(28, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(29, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(30, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(31, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(32, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(33, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(34, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(35, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(36, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(37, String.class, ParameterMode.IN).
	 * registerStoredProcedureParameter(38, String.class, ParameterMode.OUT)
	 * 
	 * .setParameter(1,entry.get("OA_FOLIO_ELECTRO"))
	 * .setParameter(2,entry.get("OA_NUM_REPORTE"))
	 * .setParameter(3,entry.get("OA_NUM_SINIESTRO"))
	 * .setParameter(4,entry.get("OA_ASEGURADO"))
	 * .setParameter(5,entry.get("OA_FECHA"))
	 * .setParameter(6,entry.get("OA_NUM_POLIZA"))
	 * .setParameter(7,entry.get("OA_NUM_ENDOSO"))
	 * .setParameter(8,entry.get("OA_NUM_INCISO"))
	 * .setParameter(9,entry.get("OA_NOM_CLIENTE"))
	 * .setParameter(10,entry.get("OA_EMAIL_CLIENTE"))
	 * .setParameter(11,entry.get("OA_TEL_CLIENTE"))
	 * .setParameter(12,entry.get("OA_RAZON_ENVIO"))
	 * .setParameter(13,entry.get("OA_RAZON_RESPONSABLE"))
	 * .setParameter(14,entry.get("OA_RAZON_TELEFONO"))
	 * .setParameter(15,entry.get("OA_RAZON_DOMICILIO"))
	 * .setParameter(16,entry.get("OA_RAZON_COBERTURA"))
	 * .setParameter(17,entry.get("OA_MARCA_AUTO"))
	 * .setParameter(18,entry.get("OA_TIPO_AUTO"))
	 * .setParameter(19,entry.get("OA_KILOMETRAJE"))
	 * .setParameter(20,entry.get("OA_NUM_SERIE"))
	 * .setParameter(21,entry.get("OA_COLOR_AUTO"))
	 * .setParameter(22,entry.get("OA_PLACA_AUTO"))
	 * .setParameter(23,entry.get("OA_T_MANUAL"))
	 * .setParameter(24,entry.get("OA_DEDUCIBLE"))
	 * .setParameter(25,entry.get("OA_TIPO_DEDUCIBLE"))
	 * .setParameter(26,entry.get("OA_ADMIN_DEDUCIBLE"))
	 * .setParameter(27,entry.get("OA_SUMA_ASEGURADA"))
	 * .setParameter(28,entry.get("OA_PORCENTAJE_DED"))
	 * .setParameter(29,entry.get("OA_CANTIDAD"))
	 * .setParameter(30,entry.get("OA_DESC_DANIOS"))
	 * .setParameter(31,entry.get("OA_NIVEL_INUNDACION"))
	 * .setParameter(32,entry.get("OA_PERDIDA_TOTAL"))
	 * .setParameter(33,entry.get("OA_DANIOS_PRE"))
	 * .setParameter(34,entry.get("OA_NOM_AJUSTADOR"))
	 * .setParameter(35,entry.get("OA_CLAVE_AJUSTADOR"))
	 * .setParameter(36,entry.get("OA_MODELO_AUTO"))
	 * .setParameter(37,entry.get("OA_AGRAVAMIENTO")); query.execute(); return
	 * String.valueOf(query.getOutputParameterValue(38)); }
	 * 
	 */
}