package com.aaq.col.clases.database.repositorios.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.aaq.col.clases.database.entidades.CatalogoCodigoDeCausa;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.ReporteSise;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteSise_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.ReporteSiseDaoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@org.springframework.stereotype.Repository(value = "reporteSiseDao")
public class ReporteSiseDao extends SIICAServerGenericDaoJpaImpl<ReporteSise> implements ReporteSiseDaoInterfase {

	@Override
	public ReporteSise objetoReporteSise(final String numeroReporte) {
		if (StringUtils.isBlank(numeroReporte)) {
			return null;
		}
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteSise> query = builder.createQuery(ReporteSise.class);
			final Root<ReporteSise> root = query.from(ReporteSise.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();
			predicates.add(builder.equal(root.get(AbstractReporteSise_.generalNumeroReporte), numeroReporte));
			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.asc(root.get(AbstractReporteSise_.id)));
			final TypedQuery<ReporteSise> typedQ = this.getEntityManager().createQuery(query);
			final List<ReporteSise> l = typedQ.getResultList();
			if ((l != null) && (l.size() > 0)) {
				return l.get(0);
			}

		} catch (final NoResultException e) {
			return null;
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "objetoReporteSise", numeroReporte);
		}
		return null;
	}

	@Override
	public List<ReporteSise> listaDeReporteSise(final Estado estado, final Terminal terminal,
			final CatalogoCodigoDeCausa codigoCausa, final Date fechaInicio, final Date fechaFinal,
			final String reporte, final String siniestro, final Boolean coordenadasValidasArribo,
			final Boolean coordenadasValidasTermino, final Integer limite) {

		if ((fechaInicio == null) || (fechaFinal == null)) {
			return new Vector<>();
		}

		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<ReporteSise> query = builder.createQuery(ReporteSise.class);
			final Root<ReporteSise> root = query.from(ReporteSise.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			if (estado != null) {
				predicates.add(builder.equal(root.get(AbstractReporteSise_.estado), estado));
			}

			if (terminal != null) {
				predicates.add(builder.equal(root.get(AbstractReporteSise_.terminal), terminal));
			}

			if (codigoCausa != null) {
				predicates.add(builder.equal(root.get(AbstractReporteSise_.catalogoCodigoDeCausa), codigoCausa));
			}

			if (StringUtils.isNotBlank(reporte)) {
				predicates.add(builder.equal(root.get(AbstractReporteSise_.generalNumeroReporte), reporte));
			}

			if (StringUtils.isNotBlank(siniestro)) {
				predicates.add(builder.equal(root.get(AbstractReporteSise_.generalNumeroSiniestro), siniestro));
			}

			predicates.add(builder.between(root.get(AbstractReporteSise_.fecha), fechaInicio,
					DateUtils.ceiling(fechaFinal, Calendar.DATE)));

			if (BooleanUtils.isTrue(coordenadasValidasArribo)) {
				predicates.add(builder.isNotNull(root.get(AbstractReporteSise_.coordLatitudArribo)));
				predicates.add(builder.isNotNull(root.get(AbstractReporteSise_.coordLongitudArribo)));

			}
			if (BooleanUtils.isTrue(coordenadasValidasTermino)) {
				predicates.add(builder.isNotNull(root.get(AbstractReporteSise_.coordLatitudTermino)));
				predicates.add(builder.isNotNull(root.get(AbstractReporteSise_.coordLongitudTermino)));
			}

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractReporteSise_.fecha)));
			final TypedQuery<ReporteSise> typedQ = this.getEntityManager().createQuery(query);

			if (limite != null) {
				typedQ.setMaxResults(limite.intValue());
			}
			return typedQ.getResultList();
		} catch (final Exception e) {

			this.documentarExcepcionParaMetodo(e, "listaDeReporteSise", estado, terminal, codigoCausa, fechaInicio,
					fechaFinal, reporte, siniestro, coordenadasValidasArribo, coordenadasValidasTermino);
		}
		return new Vector<>();
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionReporteSiseActualizarFechaReporteLecturaPorWs(final Integer id) {

		if (id == null) {
			return new JMResultadoOperacion(new Exception("Reporte Nulo"));
		}

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"reporte_sise_act_fecha_rpo_ws1");

			nat.registerStoredProcedureParameter("in_id", Integer.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_id", id);

			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncionReporteSiseActualizarFechaReporteLecturaPorWs", id);
			return new JMResultadoOperacion(e);
		}

	}

	@Override
	public JMResultadoOperacion ejecutarFuncionReporteSiseActualizar(final ReporteSise reporteSise) {
		if (reporteSise == null) {
			return new JMResultadoOperacion(new Exception("Reporte SISE Nulo"));
		}
		if (StringUtils.isBlank(reporteSise.getGeneralNumeroReporte())) {
			return new JMResultadoOperacion(new Exception("Numero Reporte Vacio"));
		}
		if (StringUtils.isBlank(reporteSise.getAjusteAjustadorCodigo())) {
			return new JMResultadoOperacion(new Exception("Numero Proveedor Vacio"));
		}

		final String idCodigoDeCausa = StringUtils.left(reporteSise.getAjusteCodigoCausa(), 2);
		final String idEstado = StringUtils.left(reporteSise.getUbicacionEntidad(), 2);

		try {
			final StoredProcedureQuery nat = this.getEntityManager().createStoredProcedureQuery(
					"reporte_sise_actualizar1");

			nat.registerStoredProcedureParameter("in_numero_proveedor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_numero_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_numero_poliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_endoso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_inciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_nombre_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_conductor_nombre", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_vehiculo_serie", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_vehiculo_placas", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_fecha_pasado_ajust", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_fecha_arribo_ajust", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_fecha_termino_ajust", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_como_ocurrio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_hora_pasado_ajust", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_hora_arribo_ajust", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_hora_termino_ajust", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_codigo_causa", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_conductor_telefono_contac", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_numero_siniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_vehiculo_marca", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_vehiculo_tipo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_vehiculo_modelo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_vehiculo_color", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_usuario", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_coord_latitud_inicio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_coord_longitud_inicio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_coord_latitud_arribo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_coord_longitud_arribo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_coord_latitud_termino", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_coord_longitud_termino", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_oficina_report", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_fecha_ocurrido", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_hora_ocurrido", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_asegurado_codigo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_asegurado_tel_ncue", String.class,
					ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_asegurado_telefono", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_reporto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_observacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_tipo_reporte", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_fecha_regist_sinie", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_conductor_edad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_conductor_sexo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ubicacion_direccion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ubicacion_carretera", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ubicacion_nacional", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ubicacion_codigo_postal", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ubicacion_entidad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ubicacion_municipio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ubicacion_colonia_codigo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ubicacion_colonia_desc", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_vehiculo_armadora_clave", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_vehiculo_armadora_nombre", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_vehiculo_motor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_ajustador_codigo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_ajustador_nombre", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_ajustador_oficina", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_averiguacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_deducible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_ministerio_publioc", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_pfp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_recupero_tipo", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ajuste_recupero_notas", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_consultado_ws", Boolean.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_estado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_codigo_de_causa", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_moneda_clave", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_moneda_nombre", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fecha_reporte_envio_sms", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_fecha_reporte_lectura_por_ws", Date.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_talleres", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_terceros", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_ubicacion_referencia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_token", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_correo_asegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_latitud_telefonia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_longitud_telefonia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_latitud_radio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_general_longitud_radio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_numero_proveedor", reporteSise.getTerminal() != null ? reporteSise.getTerminal()
					.getNumeroproveedor() : reporteSise.getAjusteAjustadorCodigo());
			nat.setParameter("in_general_numero_reporte", reporteSise.getGeneralNumeroReporte());
			nat.setParameter("in_general_numero_poliza", reporteSise.getGeneralNumeroPoliza());
			nat.setParameter("in_general_endoso", reporteSise.getGeneralEndoso());
			nat.setParameter("in_general_inciso", reporteSise.getGeneralInciso());
			nat.setParameter("in_general_nombre_asegurado", reporteSise.getGeneralNombreAsegurado());
			nat.setParameter("in_conductor_nombre", reporteSise.getConductorNombre());
			nat.setParameter("in_vehiculo_serie", reporteSise.getVehiculoSerie());
			nat.setParameter("in_vehiculo_placas", reporteSise.getVehiculoPlacas());
			nat.setParameter("in_ajuste_fecha_pasado_ajust", reporteSise.getAjusteFechaPasadoAjustador());
			nat.setParameter("in_ajuste_fecha_arribo_ajust", reporteSise.getAjusteFechaArriboAjustador());
			nat.setParameter("in_ajuste_fecha_termino_ajust", reporteSise.getAjusteFechaTerminoAjustador());
			nat.setParameter("in_general_como_ocurrio", reporteSise.getGeneralComoOcurrio());
			nat.setParameter("in_ajuste_hora_pasado_ajust", reporteSise.getAjusteHoraPasadoAjustador());
			nat.setParameter("in_ajuste_hora_arribo_ajust", reporteSise.getAjusteHoraArriboAjustador());
			nat.setParameter("in_ajuste_hora_termino_ajust", reporteSise.getAjusteHoraTerminoAjustador());
			nat.setParameter("in_ajuste_codigo_causa", reporteSise.getAjusteCodigoCausa());
			nat.setParameter("in_conductor_telefono_contac", reporteSise.getConductorTelefonoContacto());
			nat.setParameter("in_general_numero_siniestro", reporteSise.getGeneralNumeroSiniestro());
			nat.setParameter("in_vehiculo_marca", reporteSise.getVehiculoMarca());
			nat.setParameter("in_vehiculo_tipo", reporteSise.getVehiculoTipo());
			nat.setParameter("in_vehiculo_modelo", reporteSise.getVehiculoModelo());
			nat.setParameter("in_vehiculo_color", reporteSise.getVehiculoColor());
			nat.setParameter("in_general_usuario", reporteSise.getGeneralUsuario());
			nat.setParameter("in_coord_latitud_inicio", reporteSise.getCoordLatitudInicio());
			nat.setParameter("in_coord_longitud_inicio", reporteSise.getCoordLongitudInicio());
			nat.setParameter("in_coord_latitud_arribo", reporteSise.getCoordLatitudArribo());
			nat.setParameter("in_coord_longitud_arribo", reporteSise.getCoordLongitudArribo());
			nat.setParameter("in_coord_latitud_termino", reporteSise.getCoordLatitudTermino());
			nat.setParameter("in_coord_longitud_termino", reporteSise.getCoordLongitudTermino());
			nat.setParameter("in_general_oficina_report", reporteSise.getGeneralOficinaReporte());
			nat.setParameter("in_general_fecha_ocurrido", reporteSise.getGeneralFechaOcurrido());
			nat.setParameter("in_general_hora_ocurrido", reporteSise.getGeneralHoraOcurrido());
			nat.setParameter("in_general_asegurado_codigo", reporteSise.getGeneralAseguradoCodigo());
			nat.setParameter("in_general_asegurado_tel_ncue",
					reporteSise.getGeneralAseguradoTelefonoEncuesta());
			nat.setParameter("in_general_asegurado_telefono", reporteSise.getGeneralAseguradoTelefono());
			nat.setParameter("in_general_reporto", reporteSise.getGeneralReporto());
			nat.setParameter("in_general_observacion", reporteSise.getGeneralObservacion());
			nat.setParameter("in_general_tipo_reporte", reporteSise.getGeneralTipoReporte());
			nat.setParameter("in_general_fecha_regist_sinie", reporteSise.getGeneralFechaRegistroSiniestro());
			nat.setParameter("in_conductor_edad", reporteSise.getConductorEdad());
			nat.setParameter("in_conductor_sexo", reporteSise.getConductorSexo());
			nat.setParameter("in_ubicacion_direccion", reporteSise.getUbicacionDireccion());
			nat.setParameter("in_ubicacion_carretera", reporteSise.getUbicacionCarretera());
			nat.setParameter("in_ubicacion_nacional", reporteSise.getUbicacionNacional());
			nat.setParameter("in_ubicacion_codigo_postal", reporteSise.getUbicacionCodigoPostal());
			nat.setParameter("in_ubicacion_entidad", reporteSise.getUbicacionEntidad());
			nat.setParameter("in_ubicacion_municipio", reporteSise.getUbicacionMunicipio());
			nat.setParameter("in_ubicacion_colonia_codigo", reporteSise.getUbicacionColoniaCodigo());
			nat.setParameter("in_ubicacion_colonia_desc", reporteSise.getUbicacionColoniaDesc());
			nat.setParameter("in_vehiculo_armadora_clave", reporteSise.getVehiculoArmadoraClave());
			nat.setParameter("in_vehiculo_armadora_nombre", reporteSise.getVehiculoArmadoraNombre());
			nat.setParameter("in_vehiculo_motor", reporteSise.getVehiculoMotor());
			nat.setParameter("in_ajuste_ajustador_codigo", reporteSise.getAjusteAjustadorCodigo());
			nat.setParameter("in_ajuste_ajustador_nombre", reporteSise.getAjusteAjustadorNombre());
			nat.setParameter("in_ajuste_ajustador_oficina", reporteSise.getAjusteAjustadorOficina());
			nat.setParameter("in_ajuste_averiguacion", reporteSise.getAjusteAveriguacion());
			nat.setParameter("in_ajuste_deducible", reporteSise.getAjusteDeducible());
			nat.setParameter("in_ajuste_ministerio_publioc", reporteSise.getAjusteMinisterioPublioc());
			nat.setParameter("in_ajuste_pfp", reporteSise.getAjustePfp());
			nat.setParameter("in_ajuste_recupero_tipo", reporteSise.getAjusteRecuperoTipo());
			nat.setParameter("in_ajuste_recupero_notas", reporteSise.getAjusteRecuperoNotas());
			nat.setParameter("in_consultado_ws", reporteSise.getConsultadoWs());
			nat.setParameter("in_estado", idEstado);
			nat.setParameter("in_codigo_de_causa", idCodigoDeCausa);
			nat.setParameter("in_general_moneda_clave", reporteSise.getGeneralMonedaClave());
			nat.setParameter("in_general_moneda_nombre", reporteSise.getGeneralMonedaNombre());
			nat.setParameter("in_fecha_reporte_envio_sms", reporteSise.getFechaReporteEnvioSms());
			nat.setParameter("in_fecha_reporte_lectura_por_ws", reporteSise.getFechaReporteLecturaPorWs());
			nat.setParameter("in_talleres", reporteSise.getTalleres());
			nat.setParameter("in_terceros", reporteSise.getTerceros());
			nat.setParameter("in_ubicacion_referencia", reporteSise.getUbicacionReferencia());
			nat.setParameter("in_token", reporteSise.getToken());
			nat.setParameter("in_general_correo_asegurado", reporteSise.getGeneralCorreoAsegurado());
			nat.setParameter("in_general_latitud_telefonia", reporteSise.getGeneralAseguradoLatitudTelefonia());
			nat.setParameter("in_general_longitud_telefonia", reporteSise.getGeneralAseguradoLongitudTelefonia());
			nat.setParameter("in_general_latitud_radio", reporteSise.getGeneralAseguradoLatitudRadio());
			nat.setParameter("in_general_longitud_radio", reporteSise.getGeneralAseguradoLongitudRadio());
			nat.execute();

//			return new JMResultadoOperacion(this.procesarResultadoStoredProcedure(nat.getSingleResult()));
			return new JMResultadoOperacion(String.valueOf(nat.getOutputParameterValue("out_respuesta"))); 

		} catch (final Exception e) {
			this.getLogger().error(e);
			return new JMResultadoOperacion(e);
		}

	}

}