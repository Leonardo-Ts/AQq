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

import com.aaq.col.clases.database.entidades.FormatoMemoriaDescriptiva;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoMemoriaDescriptiva_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoMemoriaDescriptivaDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoMemoriaDescriptiva;

@org.springframework.stereotype.Repository(value = "formatoMemoriaDescriptivaDao")
public class FormatoMemoriaDescriptivaDao extends SIICAServerGenericDaoJpaImpl<FormatoMemoriaDescriptiva>
		implements FormatoMemoriaDescriptivaDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoMemoriaDescriptiva objetoFormatoMemoriaDescriptiva(String id) {
		FormatoMemoriaDescriptiva re = null;
		try {
			re = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoMemoriaDescriptiva.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "objetoFormatoMemoriaDescriptiva", id);
			log.error("Formatos Error=> objetoFormatoMemoriaDescriptiva=> " + id, e);
		}
		return re;
	}

	@Override
	public List<FormatoMemoriaDescriptiva> listaDeFormatoMemoriaDescriptiva() {
		TypedQuery<FormatoMemoriaDescriptiva> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoMemoriaDescriptiva> query = builder.createQuery(FormatoMemoriaDescriptiva.class);
			final Root<FormatoMemoriaDescriptiva> root = query.from(FormatoMemoriaDescriptiva.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoMemoriaDescriptiva_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoMemoriaDescriptiva_.enviadoFtp))));

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoMemoriaDescriptiva_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			// this.documentarExcepcionParaMetodo(e, "listaDeFormatoMemoriaDescriptiva",
			// 500);
			log.error("Formatos Error=> listaDeFormatoMemoriaDescriptiva", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarMemoriaDescriptiva(

			Date fecha, String reporte, String siniestro, String folioElectro, Integer cobertura, String poliza,
			String endoso, String inciso, String nomSocial, Integer tipoAsegurado, String marca, String tipo,
			String modelo, String placas, String color, String duracionMan, Integer gruaLugar, Integer concesion,
			Integer estatalFede, String maniobras, String tipoGrua, Integer otraGrua, String otraGruaTexto,
			Integer cardan1, Integer cardan2, Integer cardan3, Integer cantidadGruas, Integer traspaleo,
			String tipoTraspaleo, String proveedor, String cantidadGruasTexto, String telefono, String domicilioProv,
			String ubicacionOrigen, String trasladoDestino, Integer camionToneladas, String horarioSolicitado,
			String horarioArribo, String horarioTraslado, String manEspeciales, Integer servicioDesacoplar,
			Integer servicioAbanderaM, Integer servicioAbanderaG, String manualHora, String gruaHora,
			Integer servicioEnganche, Integer servicioFueraC, Integer servicioSobreC, Integer servicioVolcadura,
			Integer servicioCarga, Integer servicioRescate, Integer servicioCustodia, Integer servicioManiobra,
			String firmaAsegurado, String nomEmpleado, String firmaEmpleado, String claveEmpleado,
			String nomOperadorGrua, String numEcoGrua, String firmaOperadorGrua, String croquis, String tipoGruaAbander,
			String correo, Integer enviadoEmail, String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail,
			Timestamp horaEnvioSftp

	) {
		String res2 = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_memoriaDescriptiva");

			nat.registerStoredProcedureParameter("in_md_fecha", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_folioElectro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_cobertura", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_endoso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_inciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_nomSocial", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_tipoAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_marca", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_tipo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_ modelo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_placas", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_color", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_duracionMan", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_gruaLugar", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_concesion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_estatalFede", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_maniobras", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_tipoGrua", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_otraGrua", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_otraGruaTexto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_cardan1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_cardan2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_cardan3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_cantidadGruas", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_traspaleo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_tipoTraspaleo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_cantidadGruasTexto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_telefono", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_domicilioProv", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_ubicacionOrigen", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_trasladoDestino", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_camionToneladas", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_horarioSolicitado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_horarioArribo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_horarioTraslado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_manEspeciales", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_servicioDesacoplar", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_servicioAbanderaM", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_servicioAbanderaG", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_manualHora", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_gruaHora", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_servicioEnganche", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_servicioFueraC", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_servicioSobreC", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_servicioVolcadura", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_servicioCarga", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_servicioRescate", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_servicioCustodia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_servicioManiobra", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_firmaAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_nomEmpleado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_firmaEmpleado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_claveEmpleado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_nomOperadorGrua", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_numEcoGrua", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_firmaOperadorGrua", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_croquis", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_tipoGruaAbander", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_correo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_enviadoEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_mensajeEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_md_horaEnvioSftp", String.class, ParameterMode.IN);

			nat.setParameter("in_md_fecha", fecha);
			nat.setParameter("in_md_reporte", reporte);
			nat.setParameter("in_md_siniestro", siniestro);
			nat.setParameter("in_md_folioElectro", folioElectro);
			nat.setParameter("in_md_cobertura", cobertura);
			nat.setParameter("in_md_poliza", poliza);
			nat.setParameter("in_md_endoso", endoso);
			nat.setParameter("in_md_inciso", inciso);
			nat.setParameter("in_md_nomSocial", nomSocial);
			nat.setParameter("in_md_tipoAsegurado", tipoAsegurado);
			nat.setParameter("in_md_marca", marca);
			nat.setParameter("in_md_tipo", tipo);
			nat.setParameter("in_md_modelo", modelo);
			nat.setParameter("in_md_placas", placas);
			nat.setParameter("in_md_color", color);
			nat.setParameter("in_md_duracionMan", duracionMan);
			nat.setParameter("in_md_gruaLugar", gruaLugar);
			nat.setParameter("in_md_concesion", concesion);
			nat.setParameter("in_md_estatalFede", estatalFede);
			nat.setParameter("in_md_maniobras", maniobras);
			nat.setParameter("in_md_tipoGrua", tipoGrua);
			nat.setParameter("in_md_otraGrua", otraGrua);
			nat.setParameter("in_md_otraGruaTexto", otraGruaTexto);
			nat.setParameter("in_md_cardan1", cardan1);
			nat.setParameter("in_md_cardan2", cardan2);
			nat.setParameter("in_md_cardan3", cardan3);
			nat.setParameter("in_md_cantidadGruas", cantidadGruas);
			nat.setParameter("in_md_traspaleo", traspaleo);
			nat.setParameter("in_md_tipoTraspaleo", tipoTraspaleo);
			nat.setParameter("in_md_proveedor", proveedor);
			nat.setParameter("in_md_cantidadGruasTexto", cantidadGruasTexto);
			nat.setParameter("in_md_telefono", telefono);
			nat.setParameter("in_md_domicilioProv", domicilioProv);
			nat.setParameter("in_md_ubicacionOrigen", ubicacionOrigen);
			nat.setParameter("in_md_trasladoDestino", trasladoDestino);
			nat.setParameter("in_md_camionToneladas", camionToneladas);
			nat.setParameter("in_md_horarioSolicitado", horarioSolicitado);
			nat.setParameter("in_md_horarioArribo", horarioArribo);
			nat.setParameter("in_md_horarioTraslado", horarioTraslado);
			nat.setParameter("in_md_manEspeciales", manEspeciales);
			nat.setParameter("in_md_servicioDesacoplar", servicioDesacoplar);
			nat.setParameter("in_md_servicioAbanderaM", servicioAbanderaM);
			nat.setParameter("in_md_servicioAbanderaG", servicioAbanderaG);
			nat.setParameter("in_md_manualHora", manualHora);
			nat.setParameter("in_md_gruaHora", gruaHora);
			nat.setParameter("in_md_servicioEnganche", servicioEnganche);
			nat.setParameter("in_md_servicioFueraC", servicioFueraC);
			nat.setParameter("in_md_servicioSobreC", servicioSobreC);
			nat.setParameter("in_md_servicioVolcadura", servicioVolcadura);
			nat.setParameter("in_md_servicioCarga", servicioCarga);
			nat.setParameter("in_md_servicioRescate", servicioRescate);
			nat.setParameter("in_md_servicioCustodia", servicioCustodia);
			nat.setParameter("in_md_servicioManiobra", servicioManiobra);
			nat.setParameter("in_md_firmaAsegurado", firmaAsegurado);
			nat.setParameter("in_md_nomEmpleado", nomEmpleado);
			nat.setParameter("in_md_firmaEmpleado", firmaEmpleado);
			nat.setParameter("in_md_claveEmpleado", claveEmpleado);
			nat.setParameter("in_md_nomOperadorGrua", nomOperadorGrua);
			nat.setParameter("in_md_numEcoGrua", numEcoGrua);
			nat.setParameter("in_md_firmaOperadorGrua", firmaOperadorGrua);
			nat.setParameter("in_md_croquis", croquis);
			nat.setParameter("in_md_tipoGruaAbander", tipoGruaAbander);
			nat.setParameter("in_md_correo", correo);
			nat.setParameter("in_md_enviadoEmail", enviadoEmail);
			nat.setParameter("in_md_mensajeEmail", mensajeEmail);
			nat.setParameter("in_md_proceso", proceso);
			nat.setParameter("in_md_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_md_horaEnvioSftp", horaEnvioSftp);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res2 = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarMemoria", fecha, reporte, siniestro,
					folioElectro, cobertura, poliza, endoso, inciso, nomSocial, tipoAsegurado, marca, tipo, modelo,
					placas, color, duracionMan, gruaLugar, concesion, estatalFede, maniobras, tipoGrua, otraGrua,
					otraGruaTexto, cardan1, cardan2, cardan3, cantidadGruas, traspaleo, tipoTraspaleo, proveedor,
					cantidadGruasTexto, telefono, domicilioProv, ubicacionOrigen, trasladoDestino, camionToneladas,
					horarioSolicitado, horarioArribo, horarioTraslado, manEspeciales, servicioDesacoplar,
					servicioAbanderaM, servicioAbanderaG, manualHora, gruaHora, servicioEnganche, servicioFueraC,
					servicioSobreC, servicioVolcadura, servicioCarga, servicioRescate, servicioCustodia,
					servicioManiobra, firmaAsegurado, nomEmpleado, firmaEmpleado, claveEmpleado, nomOperadorGrua,
					numEcoGrua, firmaOperadorGrua, croquis, tipoGruaAbander, correo, enviadoEmail, mensajeEmail,
					proceso, horaEnvioEmail, horaEnvioSftp

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarMemoria =>" + reporte, e);

			return "ERROR: " + e.getMessage();
		}
		return res2;
	}

	@Override
	public String InsertarFormatoMemoriaDescriptiva(DatosInsertarFormatoMemoriaDescriptiva entrada) {

		Map<String, String> entry = new HashMap<>();
		String result = null;

		entry.put("SG_FECHA", entrada.getFecha());
		entry.put("SG_NUM_REPORTE", entrada.getReporte());
		entry.put("SG_NUM_SINIESTRO", entrada.getSiniestro());
		entry.put("SG_FOLIO_ELECTRO", entrada.getFolioElectro());
		entry.put("SG_COBERTURA", entrada.getCobertura());
		entry.put("SG_NUM_POLIZA", entrada.getPoliza());
		entry.put("SG_NUM_ENDOSO", entrada.getEndoso());
		entry.put("SG_NUM_INCISO", entrada.getInciso());
		entry.put("SG_NOM_ASEGURADO", entrada.getNomSocial());
		entry.put("SG_TIPO_ASEGURADO", entrada.getTipoAsegurado());
		entry.put("SG_MARCA_AUTO", entrada.getMarca());
		entry.put("SG_TIPO_AUTO", entrada.getTipo());
		entry.put("SG_MODELO_AUTO", entrada.getModelo());
		entry.put("SG_PLACAS_AUTO", entrada.getPlacas());
		entry.put("SG_COLOR_AUTO", entrada.getColor());
		entry.put("SG_DURACION_MANIOBRA", entrada.getDuracionMan());
		entry.put("SG_GRUA_LUGAR", entrada.getGruaLugar());
		entry.put("SG_CONCESION", entrada.getConcesion());
		entry.put("SG_ESTATAL_FEDERAL", entrada.getEstatalFede());
		entry.put("SG_TIPO_MANIOBRA", entrada.getManiobras());
		entry.put("SG_TIPO_GRUA", entrada.getTipoGrua());
		entry.put("OTRAGRUA", entrada.getOtraGrua());
		entry.put("SG_OTRA", entrada.getOtraGruaTexto());
		entry.put("CARDAN1", entrada.getCardan1());
		entry.put("CARDAN2", entrada.getCardan2());
		entry.put("CARDAN3", entrada.getCardan3());
		entry.put("ABAN_CANTIDAD_GRUAS", entrada.getCantidadGruas());
		entry.put("TRASPALEO", entrada.getTraspaleo());
		entry.put("TIPOTRASPALEO", entrada.getTipoTraspaleo());
		entry.put("SG_PROVEEDOR", entrada.getProveedor());
		entry.put("CANTIDADGRUASTEXTO", entrada.getCantidadGruasTexto());
		entry.put("TELEFONO", entrada.getTelefono());
		entry.put("DOMICILIOPROVEEDOR", entrada.getDomicilioProv());
		entry.put("SG_UBI_ORIGEN", entrada.getUbicacionOrigen());
		entry.put("SG_UBI_DESTINO", entrada.getTrasladoDestino());
		entry.put("CAMIONTONELADAS", entrada.getCamionToneladas());
		entry.put("HORARIOSOLICITADO", entrada.getHorarioSolicitado());
		entry.put("HORARIOARRIBO", entrada.getHorarioArribo());
		entry.put("HORARIOTRASLADO", entrada.getHorarioTraslado());
		entry.put("SG_MANIO_ESPECIALES", entrada.getManEspeciales());
		entry.put("SERVICIODESACOPLAR", entrada.getServicioDesacoplar());
		entry.put("SERVICIOABANDERAM", entrada.getServicioAbanderaM());
		entry.put("SERVICIOABANDERAG", entrada.getServicioAbanderaG());
		entry.put("MANUALHORA", entrada.getManualHora());
		entry.put("GRUAHORA", entrada.getGruaHora());
		entry.put("SERVICIOENGANCHE", entrada.getServicioEnganche());
		entry.put("SERVICIOFUERAC", entrada.getServicioFueraC());
		entry.put("SERVICIOSOBREC", entrada.getServicioSobreC());
		entry.put("SERVICIOVOLCADURA", entrada.getServicioVolcadura());
		entry.put("SERVICIOCARGA", entrada.getServicioCarga());
		entry.put("SERVICIORESCATE", entrada.getServicioRescate());
		entry.put("SERVICIOCUSTODIA", entrada.getServicioCustodia());
		entry.put("SERVICIOMANIOBRA", entrada.getServicioManiobra());
		entry.put("FIRMAASEGURADO", entrada.getFirmaAsegurado());
		entry.put("SG_NOM_EMPLEADO", entrada.getNomEmpleado());
		entry.put("FIRMAEMPLEADO", entrada.getFirmaEmpleado());
		entry.put("SG_CLAVE_EMPLEADO", entrada.getClaveEmpleado());
		entry.put("SG_NOM_OPERADOR", entrada.getNomOperadorGrua());
		entry.put("NUMECOGRUA", entrada.getNumEcoGrua());
		entry.put("FIRMAOPERADORGRUA", entrada.getFirmaOperadorGrua());
		entry.put("CROQUIS", entrada.getCroquis());
		entry.put("TIPOGRUAABANDERAMIENTO", entrada.getTipoGruaAbander());
		entry.put("EMAIL_DEFAULT", entrada.getCorreo());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFMD(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFMD(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FMD");

		String[] columnas = new String[] { "SG_FOLIO_ELECTRO", "SG_NUM_REPORTE", "SG_NUM_SINIESTRO", "SG_FECHA",
				"SG_NUM_POLIZA", "SG_NUM_ENDOSO", "SG_NUM_INCISO", "SG_NOM_ASEGURADO", "SG_TIPO_ASEGURADO",
				"SG_MARCA_AUTO", "SG_TIPO_AUTO", "SG_MODELO_AUTO", "SG_PLACAS_AUTO", "SG_COLOR_AUTO",
				"SG_DURACION_MANIOBRA", "SG_GRUA_LUGAR", "SG_CONCESION", "SG_ESTATAL_FEDERAL", "SG_TIPO_MANIOBRA",
				"SG_TIPO_GRUA", "SG_OTRA", "SG_PROVEEDOR", "SG_UBI_ORIGEN", "SG_UBI_DESTINO", "SG_MANIO_ESPECIALES",
				"SG_NOM_EMPLEADO", "SG_CLAVE_EMPLEADO", "SG_NOM_OPERADOR", "EMAIL_DEFAULT", "SG_COBERTURA", "OTRAGRUA",
				"CARDAN1", "CARDAN2", "CARDAN3", "TIPOGRUAABANDERAMIENTO", "TRASPALEO", "TIPOTRASPALEO",
				"CANTIDADGRUASTEXTO", "TELEFONO", "DOMICILIOPROVEEDOR", "HORARIOSOLICITADO", "HORARIOARRIBO",
				"HORARIOTRASLADO", "CAMIONTONELADAS", "SERVICIODESACOPLAR", "SERVICIOABANDERAM", "SERVICIOABANDERAG",
				"SERVICIOENGANCHE", "SERVICIOFUERAC", "SERVICIOSOBREC", "SERVICIOVOLCADURA", "SERVICIOCARGA",
				"SERVICIORESCATE", "SERVICIOCUSTODIA", "SERVICIOMANIOBRA", "NUMECOGRUA", "MANUALHORA", "GRUAHORA",
				"FIRMAASEGURADO", "FIRMAEMPLEADO", "FIRMAOPERADORGRUA", "CROQUIS", "ABAN_CANTIDAD_GRUAS",
				"CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4" ,"CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6"};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(72, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(72));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_MEMORIA_DESCRIPTIVA where SG_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}