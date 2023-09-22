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

import com.aaq.col.clases.database.entidades.FormatoValeAmbulancia;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoValeAmbulancia_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoValeAmbulanciaDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoValeAmbulancia;

@org.springframework.stereotype.Repository(value = "formatoValeAmbulanciaDao")
public class FormatoValeAmbulanciaDao extends SIICAServerGenericDaoJpaImpl<FormatoValeAmbulancia>
		implements FormatoValeAmbulanciaDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoValeAmbulancia objetoFormatoValeAmbulancia(String id) {
		FormatoValeAmbulancia re = null;
		try {
			re = StringUtils.isNotBlank(id) ? this.getEntityManager().find(FormatoValeAmbulancia.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			log.error("Formatos Error=> objetoFormatoValeAmbulancia=> " + id, e);

		}
		return re;
	}

	@Override
	public List<FormatoValeAmbulancia> listaDeFormatoValeAmbulancia() {
		TypedQuery<FormatoValeAmbulancia> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoValeAmbulancia> query = builder.createQuery(FormatoValeAmbulancia.class);
			final Root<FormatoValeAmbulancia> root = query.from(FormatoValeAmbulancia.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoValeAmbulancia_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoValeAmbulancia_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoValeAmbulancia_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			log.error("Formatos Error=> listaDeFormatoValeAmbulancia", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarValeAmbulancia(

			String vaAsegurado, String vaClaveAjustador, String vaDatosConductor, String vaDatosLesionado,
			String vaDiagnostico, String vaDirPaciente, String vaEdadPaciente,

			String vaFolioElectro, Date vaHora, String vaHospital, String vaLugar, String vaNomAjustador,
			String vaNomPaciente, String vaNomRazon, String vaNumEndoso, String vaNumInciso, String vaNumPoliza,
			String vaNumReporte, String vaNumSiniestro, String vaSexo, String vaTelPaciente,

			String emailDefault, Integer enviadoEmail, ////
			String mensajeEmail, ///
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaConductor,
			String firmaLesionado)

	{
		String respu = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_ambulancia1");

			nat.registerStoredProcedureParameter("in_va_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_clave_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_datos_conductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_datos_lesionado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_diagnostico", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_dir_paciente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_edad_paciente", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_va_folio_electro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_hora", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_hospital", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_lugar", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_nom_ajustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_nom_paciente", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_nom_razon", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_num_endoso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_num_inciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_num_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_num_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_num_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_sexo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_va_tel_paciente", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_emailDefault", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_va_asegurado", vaAsegurado);
			nat.setParameter("in_va_clave_ajustador", vaClaveAjustador);
			nat.setParameter("in_va_datos_conductor", vaDatosConductor);
			nat.setParameter("in_va_datos_lesionado", vaDatosLesionado);
			nat.setParameter("in_va_diagnostico", vaDiagnostico);
			nat.setParameter("in_va_dir_paciente", vaDirPaciente);
			nat.setParameter("in_va_edad_paciente", vaEdadPaciente);

			nat.setParameter("in_va_folio_electro", vaFolioElectro);
			nat.setParameter("in_va_hora", vaHora);
			nat.setParameter("in_va_hospital", vaHospital);
			nat.setParameter("in_va_lugar", vaLugar);
			nat.setParameter("in_va_nom_ajustador", vaNomAjustador);
			nat.setParameter("in_va_nom_paciente", vaNomPaciente);
			nat.setParameter("in_va_nom_razon", vaNomRazon);
			nat.setParameter("in_va_num_endoso", vaNumEndoso);
			nat.setParameter("in_va_num_inciso", vaNumInciso);
			nat.setParameter("in_va_num_poliza", vaNumPoliza);
			nat.setParameter("in_va_num_reporte", vaNumReporte);
			nat.setParameter("in_va_num_siniestro", vaNumSiniestro);
			nat.setParameter("in_va_sexo", vaSexo);
			nat.setParameter("in_va_tel_paciente", vaTelPaciente);

			nat.setParameter("in_emailDefault", emailDefault);
			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			respu = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarValeAmbulancia",

					vaAsegurado, vaClaveAjustador, vaDatosConductor, vaDatosLesionado, vaDiagnostico, vaDirPaciente,
					vaEdadPaciente,

					vaFolioElectro, vaHora, vaHospital, vaLugar, vaNomAjustador, vaNomPaciente, vaNomRazon, vaNumEndoso,
					vaNumInciso, vaNumPoliza, vaNumReporte, vaNumSiniestro, vaSexo, vaTelPaciente,

					emailDefault, enviadoEmail, ////
					mensajeEmail, ////
					proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaAjustador,
					firmaConductor, firmaLesionado);

			log.error("Formatos Error=> ejecutarFuncioninsertarValeAmbulancia =>" + vaNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return respu;
	}

	@Override
	public String InsertarFormatoValeAmbulancia(DatosInsertarFormatoValeAmbulancia entradas) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("VA_NUM_REPORTE", entradas.getVa_Num_Reporte());
		entry.put("VA_NUM_SINIESTRO", entradas.getVa_Num_Siniestro());
		entry.put("VA_FOLIO_ELECTRO", entradas.getVa_Folio_Electro());
		entry.put("VA_ASEGURADO", entradas.getVa_Asegurado());
		entry.put("VA_HORA", entradas.getVa_Hora());
		entry.put("VA_NUM_POLIZA", entradas.getVa_Num_Poliza());
		entry.put("VA_NUM_ENDOSO", entradas.getVa_Num_Endoso());
		entry.put("VA_NUM_INCISO", entradas.getVa_Num_Inciso());
		entry.put("VA_NOM_RAZON", entradas.getVa_Nom_Razon());
		entry.put("VA_HOSPITAL", entradas.getVa_Hospital());
		entry.put("VA_NOM_PACIENTE", entradas.getVa_Nom_Paciente());
		entry.put("VA_TEL_PACIENTE", entradas.getVa_Tel_Paciente());
		entry.put("VA_DIR_PACIENTE", entradas.getVa_Dir_Paciente());
		entry.put("VA_EDAD_PACIENTE", entradas.getVa_Edad_Paciente());
		entry.put("VA_SEXO", entradas.getVa_Sexo());
		entry.put("VA_DIAGNOSTICO", entradas.getVa_Diagnostico());
		entry.put("VA_LUGAR", entradas.getVa_Lugar());
		entry.put("VA_NOM_AJUSTADOR", entradas.getVa_Nom_Ajustador());
		entry.put("VA_DATOS_CONDUCTOR", entradas.getVa_Datos_Conductor());
		entry.put("VA_DATOS_LESIONADO", entradas.getVa_Datos_Lesionado());
		entry.put("EMAIL_DEFAULT", entradas.getEmail_Default());
		entry.put("VA_CLAVE_AJUSTADOR", entradas.getVa_Clave_Ajustador());
		entry.put("CHECK_1", entradas.getCheck_1());
		entry.put("CHECK_2", entradas.getCheck_2());
		entry.put("CHECK_3", entradas.getCheck_3());
		entry.put("CHECK_4", entradas.getCheck_4());
		entry.put("FIRMA_AJUSTADOR", entradas.getFirma_Ajustador());
		entry.put("FIRMA_CONDUCTOR", entradas.getFirma_Conductor());
		entry.put("FIRMA_LESIONADO", entradas.getFirma_Lesionado());
		entry.put("CORREO_OCULTO", entradas.getCorreo_oculto());
		entry.put("FUENTE_WS", entradas.getFuente_ws());
		entry.put("CHECK_5", entradas.getCheck_5());
		entry.put("CHECK_6", entradas.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFVA(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFVA(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FVA");

		String[] columnas = new String[] { "VA_NUM_REPORTE", "VA_NUM_SINIESTRO", "VA_FOLIO_ELECTRO", "VA_ASEGURADO",
				"VA_HORA", "VA_NUM_POLIZA", "VA_NUM_ENDOSO", "VA_NUM_INCISO", "VA_NOM_RAZON", "VA_HOSPITAL",
				"VA_NOM_PACIENTE", "VA_TEL_PACIENTE", "VA_DIR_PACIENTE", "VA_EDAD_PACIENTE", "VA_SEXO",
				"VA_DIAGNOSTICO", "VA_LUGAR", "VA_NOM_AJUSTADOR", "VA_DATOS_CONDUCTOR", "VA_DATOS_LESIONADO",
				"EMAIL_DEFAULT", "VA_CLAVE_AJUSTADOR", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_AJUSTADOR",
				"FIRMA_CONDUCTOR", "FIRMA_LESIONADO", "CORREO_OCULTO","FUENTE_WS" ,"CHECK_5", "CHECK_6"};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(34, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		// return entry.toString();
		return String.valueOf(query.getOutputParameterValue(34));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_VALE_AMBULANCIA where VA_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}