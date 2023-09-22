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

import com.aaq.col.clases.database.entidades.FormatoDeclaracionUniversal;
import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoDeclaracionUniversal_;
import com.aaq.col.clases.database.repositorios.SIICAServerGenericDaoJpaImpl;
import com.aaq.col.clases.database.repositorios.interfase.FormatoDeclaracionUniversalDaoInterfase;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoDeclaracionUniversal;


@org.springframework.stereotype.Repository(value = "formatoDeclaracionUniversalDao")
public class FormatoDeclaracionUniversalDao extends SIICAServerGenericDaoJpaImpl<FormatoDeclaracionUniversal>
		implements FormatoDeclaracionUniversalDaoInterfase {

	public static Log log = LogFactory.getLog("EXPEDIENTE_DIGITAL");

	@Override
	public FormatoDeclaracionUniversal objetoFormatoDeclaracionUniversal(String id) {
		FormatoDeclaracionUniversal res = null;
		try {
			res = StringUtils.isNotBlank(id)
					? this.getEntityManager().find(FormatoDeclaracionUniversal.class, new Integer(id))
					: null;
		} catch (final Exception e) {
			log.error("Formatos Error=> objetoFormatoDeclaracionUniversal=> " + id, e);
		}
		return res;
	}

	@Override
	public List<FormatoDeclaracionUniversal> listaDeFormatoDeclaracionUniversal() {
		TypedQuery<FormatoDeclaracionUniversal> typedQ = null;
		try {
			final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
			final CriteriaQuery<FormatoDeclaracionUniversal> query = builder
					.createQuery(FormatoDeclaracionUniversal.class);
			final Root<FormatoDeclaracionUniversal> root = query.from(FormatoDeclaracionUniversal.class);
			query.select(root);
			final List<Predicate> predicates = new ArrayList<>();

			predicates.add(builder.or(builder.notEqual(root.get(AbstractFormatoDeclaracionUniversal_.enviadoFtp), 1),
					builder.isNull(root.get(AbstractFormatoDeclaracionUniversal_.enviadoFtp))));
			

			query.where(predicates.toArray(new Predicate[predicates.size()]));
			query.orderBy(builder.desc(root.get(AbstractFormatoDeclaracionUniversal_.id)));
			typedQ = this.getEntityManager().createQuery(query);

			typedQ.setMaxResults(50);
			// return typedQ.getResultList();
		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "listaDeFormatoDeclaracionUniversal", 500);
			log.error("Formatos Error=> listaDeFormatoDeclaracionUniversal", e);

		}
		return typedQ.getResultList();
	}

	@Override
	public String ejecutarFuncionInsertarDeclaracionUniversal(

			String duModeloAutoA, String duModeloAutoB, String duUsoAutoA, String duUsoAutoB, String duPlacasAuto,
			Integer duPregunta18b, String duDaniosPreB, String duNumInciso, String duRecuperacion,
			Integer duPregunta10a, String duOcupante1, Integer duPregunta10b, String duOcupante5, String duOcupante4,
			String duAcciPersonales, String duOcupante3, String duOcupante2, Integer duOtrosRec, Integer duPregunta5b,
			String duTipoAuto, Integer duInformeAdicional, String duLugarB, Integer duPreguntaBBool,
			Integer duPregunta5a, Integer duPregunta19b, Integer duPregunta19a, Timestamp duVigenciaDe,
			Integer duPregunta17b, String duNumReporteB, Integer duPregunta17a, String duAsegurado, String duOtro,
			Timestamp duFechaAtencion, String duResPersonas, String duGastosLegales, String duPlacasAutoB,
			String duDirConductorB, Integer duVehicuoCorralon, String duTipoLicenciaB, Integer duSipacRec,
			String duClaveAjustadorGral, Integer duPregunta4a, Integer duSipac, Integer duPregunta4b,
			String duAplicoDeducible, String duRcViajero, String duNomAsegurado, String duInc,
			Timestamp duCaducidadLicenciaB, String duNumPolizaB, String duNomConductor, String duSerie,
			String duNomAseguradoB, Integer duPregunta18a,

			String duCondicionadoA, String duColorAuto, Integer duTradicionalRec, String duDaniosPre,
			Integer duPregunta12a, String duCobranzaB, String duNumSiniestro, Integer duPregunta12b, String duNumEndoso,
			String duEdadConductorB, String duNomSupervisor, Timestamp duVigenciaDeB, String duOcupante5B,
			String duNumReporte,

			String duTipoLicencia, String duNomCiaB, Integer duPregunta7b, String duRoboTotal, String duNumRc,
			Integer duPregunta7a, String duNarracion, String duLugar, Integer duPregunta11b, Integer duPregunta11a,
			String duDaniosApre, String duTelAseguradoB, String duCobertura, String duLicenciaNum,
			Integer duPreguntaABool, String duDaniosMateriales, String duIncB, Timestamp duArriboAjustador,
			String duAutoridad, String duNumActa, String duOcupante4B, String duEmailConductor, Timestamp duVigenciaAl,
			Integer duEstadoAjuste, String duCoberturaB, Integer duPregunta6a, Integer duPregunta6b,
			String duGastosMedicos, Integer duPregunta14a, Integer duPregunta14b, String duMarcaAutoB,
			String duLicenciaEstado, Timestamp duHoraAmbulancia, Integer duSipacEnt, String duNomAbogado,
			Integer duEnEspera, String duLicenciaNumB, Integer duPregunta1a, String duCristales, String duNumOcupantes,
			String duOcupante3B, String duClaveAjustador, Integer duPregunta1b, Integer duPregunta9a,
			String duNumPersonas,

			String duDaniosApreB, String duEmailConductorB, String duConclusiones, String duNomConductorB,
			Integer duPregunta9b, String duEquipoEspecial, String duResBienes, String duSerieB, Integer duPregunta13b,
			Timestamp duFechaOcurrido, Integer duPregunta13a, Integer duOtrosEnt, String duTipoAutoB,
			Integer duTradicionalEnt, Timestamp duTerminoAjustadorB, String duLicenciaEstadoB, String duColorAutoB,
			String duOcupante2B, String duDirConductor, String duTelAsegurado, Integer duId,

			Integer duPregunta8a, Integer duPregunta8b, String duTelConductor, String duMarcaAuto,
			String duNomAjustadorGral, Integer duPregunta16a, String duNumSiniestroB,

			Integer duPregunta16b,

			String duNomAjustadorB, Timestamp duArriboAjustadorB, String duPreguntaA,

			Integer duPregunta3b, Timestamp duTerminoAjustador, Integer duResponsableA, Integer duPregunta3a,
			Integer duVolanteAdmison, Timestamp duFechaOcurridoB, String duNomCia, String duOcupante1B,
			String duNumPersonales, Timestamp duHoraGrua, String duNumReporteAut, Integer duPregunta15b,
			Timestamp duCaducidadLicencia, Integer duPregunta15a, String duOtros,

			String duCobranza, String duEdadConductor, String duClaveAjustadorB, Timestamp duFechaAtencionB,
			Timestamp duVigenciaAlB, String duTelConductorB, String duNarracionB, String duNomAjustador,
			Integer duPregunta2a, Integer duPregunta2b, String duOtroEspecificar,

			String duNumPoliza, Timestamp duHoraAbogado, Integer enviadoEmail, ////
			String mensajeEmail, ///

			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaConA, String firmaConB, String firmaResponsable,
			String firmaAjusA, String firmaAjusB, String firmaAjusQualitas, String duFolioInforme, String duCroquis,
			String duCalcaA, String duCalcaB, String duDescripcionCroquis

	) {
		String res2 = null;
		try {
			final StoredProcedureQuery nat = this.getEntityManager()
					.createStoredProcedureQuery("orden_movil_ws_inser_declaracionUn1");

			nat.registerStoredProcedureParameter("in_duUsoAutoA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duModeloAutoA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duModeloAutoB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duUsoAutoB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPlacasAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta18b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duDaniosPreB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumInciso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duRecuperacion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta10a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOcupante1", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta10b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOcupante5", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOcupante4", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duAcciPersonales", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOcupante3", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOcupante2", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOtrosRec", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta5b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duTipoAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duInformeAdicional", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duLugarB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPreguntaBBool", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta5a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta19b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta19a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duVigenciaDe", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta17b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumReporteB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta17a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOtro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duFechaAtencion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duResPersonas", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duGastosLegales", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPlacasAutoB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duDirConductorB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duVehicuoCorralon", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duTipoLicenciaB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duSipacRec", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duClaveAjustadorGral", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta4a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duSipac", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta4b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duAplicoDeducible", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duRcViajero", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNomAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duInc", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duCaducidadLicenciaB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumPolizaB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNomConductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duSerie", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNomAseguradoB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta18a", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_duCondicionadoA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duColorAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duTradicionalRec", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duDaniosPre", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta12a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duCobranzaB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumSiniestro", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta12b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumEndoso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duEdadConductorB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNomSupervisor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duVigenciaDeB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOcupante5B", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumReporte", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_duTipoLicencia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNomCiaB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta7b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duRoboTotal", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumRc", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta7a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNarracion", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duLugar", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta11b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta11a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duDaniosApre", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duTelAseguradoB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duCobertura", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duLicenciaNum", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPreguntaABool", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duDaniosMateriales", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duIncB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duArriboAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duAutoridad", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumActa", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOcupante4B", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duEmailConductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duVigenciaAl", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duEstadoAjuste", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duCoberturaB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta6a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta6b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duGastosMedicos", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta14a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta14b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duMarcaAutoB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duLicenciaEstado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duHoraAmbulancia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duSipacEnt", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNomAbogado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duEnEspera", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duLicenciaNumB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta1a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duCristales", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumOcupantes", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOcupante3B", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duClaveAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta1b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta9a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumPersonas", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_duDaniosApreB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duEmailConductorB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duConclusiones", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNomConductorB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta9b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duEquipoEspecial", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duResBienes", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duSerieB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta13b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duFechaOcurrido", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta13a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOtrosEnt", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duTipoAutoB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duTradicionalEnt", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duTerminoAjustadorB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duLicenciaEstadoB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duColorAutoB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOcupante2B", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duDirConductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duTelAsegurado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duId", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_duPregunta8a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta8b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duTelConductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duMarcaAuto", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNomAjustadorGral", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta16a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumSiniestroB", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_duPregunta16b", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_duNomAjustadorB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duArriboAjustadorB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPreguntaA", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_duPregunta3b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duTerminoAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duResponsableA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta3a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duVolanteAdmison", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duFechaOcurridoB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNomCia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOcupante1B", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumPersonales", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duHoraGrua", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNumReporteAut", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta15b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duCaducidadLicencia", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta15a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOtros", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_duCobranza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duEdadConductor", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duClaveAjustadorB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duFechaAtencionB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duVigenciaAlB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duTelConductorB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNarracionB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duNomAjustador", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta2a", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duPregunta2b", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duOtroEspecificar", String.class, ParameterMode.IN);

			nat.registerStoredProcedureParameter("in_duNumPoliza", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duHoraAbogado", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_enviadoEmail", String.class, ParameterMode.IN);////
			nat.registerStoredProcedureParameter("in_mensajeEmail", String.class, ParameterMode.IN);///
			nat.registerStoredProcedureParameter("in_proceso", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioEmail", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_horaEnvioSftp", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_nodoEnvio", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duFolioInforme", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duCroquis", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duCalcaA", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duCalcaB", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("in_duDescripcionCroquis", String.class, ParameterMode.IN);
			nat.registerStoredProcedureParameter("out_respuesta", String.class, ParameterMode.OUT);

			nat.setParameter("in_duModeloAutoA", duModeloAutoA);
			nat.setParameter("in_duModeloAutoB", duModeloAutoB);
			nat.setParameter("in_duUsoAutoA", duUsoAutoA);
			nat.setParameter("in_duUsoAutoB", duUsoAutoB);
			nat.setParameter("in_duPlacasAuto", duPlacasAuto);
			nat.setParameter("in_duPregunta18b", duPregunta18b);
			nat.setParameter("in_duDaniosPreB", duDaniosPreB);
			nat.setParameter("in_duNumInciso", duNumInciso);
			nat.setParameter("in_duRecuperacion", duRecuperacion);
			nat.setParameter("in_duPregunta10a", duPregunta10a);
			nat.setParameter("in_duOcupante1", duOcupante1);
			nat.setParameter("in_duPregunta10b", duPregunta10b);
			nat.setParameter("in_duOcupante5", duOcupante5);
			nat.setParameter("in_duOcupante4", duOcupante4);
			nat.setParameter("in_duAcciPersonales", duAcciPersonales);
			nat.setParameter("in_duOcupante3", duOcupante3);
			nat.setParameter("in_duOcupante2", duOcupante2);
			nat.setParameter("in_duOtrosRec", duOtrosRec);
			nat.setParameter("in_duPregunta5b", duPregunta5b);
			nat.setParameter("in_duTipoAuto", duTipoAuto);
			nat.setParameter("in_duInformeAdicional", duInformeAdicional);
			nat.setParameter("in_duLugarB", duLugarB);
			nat.setParameter("in_duPreguntaBBool", duPreguntaBBool);
			nat.setParameter("in_duPregunta5a", duPregunta5a);
			nat.setParameter("in_duPregunta19b", duPregunta19b);
			nat.setParameter("in_duPregunta19a", duPregunta19a);
			nat.setParameter("in_duVigenciaDe", duVigenciaDe);
			nat.setParameter("in_duPregunta17b", duPregunta17b);
			nat.setParameter("in_duNumReporteB", duNumReporteB);
			nat.setParameter("in_duPregunta17a", duPregunta17a);
			nat.setParameter("in_duAsegurado", duAsegurado);
			nat.setParameter("in_duOtro", duOtro);
			nat.setParameter("in_duFechaAtencion", duFechaAtencion);
			nat.setParameter("in_duResPersonas", duResPersonas);
			nat.setParameter("in_duGastosLegales", duGastosLegales);
			nat.setParameter("in_duPlacasAutoB", duPlacasAutoB);
			nat.setParameter("in_duDirConductorB", duDirConductorB);
			nat.setParameter("in_duVehicuoCorralon", duVehicuoCorralon);
			nat.setParameter("in_duTipoLicenciaB", duTipoLicenciaB);
			nat.setParameter("in_duSipacRec", duSipacRec);
			nat.setParameter("in_duClaveAjustadorGral", duClaveAjustadorGral);
			nat.setParameter("in_duPregunta4a", duPregunta4a);
			nat.setParameter("in_duSipac", duSipac);
			nat.setParameter("in_duPregunta4b", duPregunta4b);
			nat.setParameter("in_duAplicoDeducible", duAplicoDeducible);
			nat.setParameter("in_duRcViajero", duRcViajero);
			nat.setParameter("in_duNomAsegurado", duNomAsegurado);
			nat.setParameter("in_duInc", duInc);
			nat.setParameter("in_duCaducidadLicenciaB", duCaducidadLicenciaB);
			nat.setParameter("in_duNumPolizaB", duNumPolizaB);
			nat.setParameter("in_duNomConductor", duNomConductor);
			nat.setParameter("in_duSerie", duSerie);
			nat.setParameter("in_duNomAseguradoB", duNomAseguradoB);
			nat.setParameter("in_duPregunta18a", duPregunta18a);

			nat.setParameter("in_duCondicionadoA", duCondicionadoA);
			nat.setParameter("in_duColorAuto", duColorAuto);
			nat.setParameter("in_duTradicionalRec", duTradicionalRec);
			nat.setParameter("in_duDaniosPre", duDaniosPre);
			nat.setParameter("in_duPregunta12a", duPregunta12a);
			nat.setParameter("in_duCobranzaB", duCobranzaB);
			nat.setParameter("in_duNumSiniestro", duNumSiniestro);
			nat.setParameter("in_duPregunta12b", duPregunta12b);
			nat.setParameter("in_duNumEndoso", duNumEndoso);
			nat.setParameter("in_duEdadConductorB", duEdadConductorB);
			nat.setParameter("in_duNomSupervisor", duNomSupervisor);
			nat.setParameter("in_duVigenciaDeB", duVigenciaDeB);
			nat.setParameter("in_duOcupante5B", duOcupante5B);
			nat.setParameter("in_duNumReporte", duNumReporte);

			nat.setParameter("in_duTipoLicencia", duTipoLicencia);
			nat.setParameter("in_duNomCiaB", duNomCiaB);
			nat.setParameter("in_duPregunta7b", duPregunta7b);
			nat.setParameter("in_duRoboTotal", duRoboTotal);
			nat.setParameter("in_duNumRc", duNumRc);
			nat.setParameter("in_duPregunta7a", duPregunta7a);
			nat.setParameter("in_duNarracion", duNarracion);
			nat.setParameter("in_duLugar", duLugar);
			nat.setParameter("in_duPregunta11b", duPregunta11b);
			nat.setParameter("in_duPregunta11a", duPregunta11a);
			nat.setParameter("in_duDaniosApre", duDaniosApre);
			nat.setParameter("in_duTelAseguradoB", duTelAseguradoB);
			nat.setParameter("in_duCobertura", duCobertura);
			nat.setParameter("in_duLicenciaNum", duLicenciaNum);
			nat.setParameter("in_duPreguntaABool", duPreguntaABool);
			nat.setParameter("in_duDaniosMateriales", duDaniosMateriales);
			nat.setParameter("in_duIncB", duIncB);
			nat.setParameter("in_duArriboAjustador", duArriboAjustador);
			nat.setParameter("in_duAutoridad", duAutoridad);
			nat.setParameter("in_duNumActa", duNumActa);
			nat.setParameter("in_duOcupante4B", duOcupante4B);
			nat.setParameter("in_duEmailConductor", duEmailConductor);
			nat.setParameter("in_duVigenciaAl", duVigenciaAl);
			nat.setParameter("in_duEstadoAjuste", duEstadoAjuste);
			nat.setParameter("in_duCoberturaB", duCoberturaB);
			nat.setParameter("in_duPregunta6a", duPregunta6a);
			nat.setParameter("in_duPregunta6b", duPregunta6b);
			nat.setParameter("in_duGastosMedicos", duGastosMedicos);
			nat.setParameter("in_duPregunta14a", duPregunta14a);
			nat.setParameter("in_duPregunta14b", duPregunta14b);
			nat.setParameter("in_duMarcaAutoB", duMarcaAutoB);
			nat.setParameter("in_duLicenciaEstado", duLicenciaEstado);
			nat.setParameter("in_duHoraAmbulancia", duHoraAmbulancia);
			nat.setParameter("in_duSipacEnt", duSipacEnt);
			nat.setParameter("in_duNomAbogado", duNomAbogado);
			nat.setParameter("in_duEnEspera", duEnEspera);
			nat.setParameter("in_duLicenciaNumB", duLicenciaNumB);
			nat.setParameter("in_duPregunta1a", duPregunta1a);
			nat.setParameter("in_duCristales", duCristales);
			nat.setParameter("in_duNumOcupantes", duNumOcupantes);
			nat.setParameter("in_duOcupante3B", duOcupante3B);
			nat.setParameter("in_duClaveAjustador", duClaveAjustador);
			nat.setParameter("in_duPregunta1b", duPregunta1b);
			nat.setParameter("in_duPregunta9a", duPregunta9a);
			nat.setParameter("in_duNumPersonas", duNumPersonas);

			nat.setParameter("in_duDaniosApreB", duDaniosApreB);
			nat.setParameter("in_duEmailConductorB", duEmailConductorB);
			nat.setParameter("in_duConclusiones", duConclusiones);
			nat.setParameter("in_duNomConductorB", duNomConductorB);
			nat.setParameter("in_duPregunta9b", duPregunta9b);
			nat.setParameter("in_duEquipoEspecial", duEquipoEspecial);
			nat.setParameter("in_duResBienes", duResBienes);
			nat.setParameter("in_duSerieB", duSerieB);
			nat.setParameter("in_duPregunta13b", duPregunta13b);
			nat.setParameter("in_duFechaOcurrido", duFechaOcurrido);
			nat.setParameter("in_duPregunta13a", duPregunta13a);
			nat.setParameter("in_duOtrosEnt", duOtrosEnt);
			nat.setParameter("in_duTipoAutoB", duTipoAutoB);
			nat.setParameter("in_duTradicionalEnt", duTradicionalEnt);
			nat.setParameter("in_duTerminoAjustadorB", duTerminoAjustadorB);
			nat.setParameter("in_duLicenciaEstadoB", duLicenciaEstadoB);
			nat.setParameter("in_duColorAutoB", duColorAutoB);
			nat.setParameter("in_duOcupante2B", duOcupante2B);
			nat.setParameter("in_duDirConductor", duDirConductor);
			nat.setParameter("in_duTelAsegurado", duTelAsegurado);
			nat.setParameter("in_duId", duId);

			nat.setParameter("in_duPregunta8a", duPregunta8a);
			nat.setParameter("in_duPregunta8b", duPregunta8b);
			nat.setParameter("in_duTelConductor", duTelConductor);
			nat.setParameter("in_duMarcaAuto", duMarcaAuto);
			nat.setParameter("in_duNomAjustadorGral", duNomAjustadorGral);
			nat.setParameter("in_duPregunta16a", duPregunta16a);
			nat.setParameter("in_duNumSiniestroB", duNumSiniestroB);

			nat.setParameter("in_duPregunta16b", duPregunta16b);

			nat.setParameter("in_duNomAjustadorB", duNomAjustadorB);
			nat.setParameter("in_duArriboAjustadorB", duArriboAjustadorB);
			nat.setParameter("in_duPreguntaA", duPreguntaA);

			nat.setParameter("in_duPregunta3b", duPregunta3b);
			nat.setParameter("in_duTerminoAjustador", duTerminoAjustador);
			nat.setParameter("in_duResponsableA", duResponsableA);
			nat.setParameter("in_duPregunta3a", duPregunta3a);
			nat.setParameter("in_duVolanteAdmison", duVolanteAdmison);
			nat.setParameter("in_duFechaOcurridoB", duFechaOcurridoB);
			nat.setParameter("in_duNomCia", duNomCia);
			nat.setParameter("in_duOcupante1B", duOcupante1B);
			nat.setParameter("in_duNumPersonales", duNumPersonales);
			nat.setParameter("in_duHoraGrua", duHoraGrua);
			nat.setParameter("in_duNumReporteAut", duNumReporteAut);
			nat.setParameter("in_duPregunta15b", duPregunta15b);
			nat.setParameter("in_duCaducidadLicencia", duCaducidadLicencia);
			nat.setParameter("in_duPregunta15a", duPregunta15a);
			nat.setParameter("in_duOtros", duOtros);

			nat.setParameter("in_duCobranza", duCobranza);
			nat.setParameter("in_duEdadConductor", duEdadConductor);
			nat.setParameter("in_duClaveAjustadorB", duClaveAjustadorB);
			nat.setParameter("in_duFechaAtencionB", duFechaAtencionB);
			nat.setParameter("in_duVigenciaAlB", duVigenciaAlB);
			nat.setParameter("in_duTelConductorB", duTelConductorB);
			nat.setParameter("in_duNarracionB", duNarracionB);
			nat.setParameter("in_duNomAjustador", duNomAjustador);
			nat.setParameter("in_duPregunta2a", duPregunta2a);
			nat.setParameter("in_duPregunta2b", duPregunta2b);
			nat.setParameter("in_duOtroEspecificar", duOtroEspecificar);

			nat.setParameter("in_duNumPoliza", duNumPoliza);
			nat.setParameter("in_duHoraAbogado", duHoraAbogado);
			nat.setParameter("in_enviadoEmail", enviadoEmail);///
			nat.setParameter("in_mensajeEmail", mensajeEmail);///
			nat.setParameter("in_proceso", proceso);
			nat.setParameter("in_horaEnvioEmail", horaEnvioEmail);
			nat.setParameter("in_horaEnvioSftp", horaEnvioSftp);
			nat.setParameter("in_nodoEnvio", nodoEnvio);
			nat.setParameter("in_duFolioInforme", duFolioInforme);
			nat.setParameter("in_duCroquis", duCroquis);
			nat.setParameter("in_duCalcaA", duCalcaA);
			nat.setParameter("in_duCalcaB", duCalcaB);
			nat.setParameter("in_duDescripcionCroquis", duDescripcionCroquis);

			nat.execute();

			// return this.procesarResultadoStoredProcedure(nat.getSingleResult());
			res2 = String.valueOf(nat.getOutputParameterValue("out_respuesta"));

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "ejecutarFuncioninsertarDeclaracionUniversal",

					duModeloAutoA, duModeloAutoB, duUsoAutoA, duUsoAutoB, duPlacasAuto, duPregunta18b, duDaniosPreB,
					duNumInciso, duRecuperacion, duPregunta10a, duOcupante1, duPregunta10b, duOcupante5, duOcupante4,
					duAcciPersonales, duOcupante3, duOcupante2, duOtrosRec, duPregunta5b, duTipoAuto,
					duInformeAdicional, duLugarB, duPreguntaBBool, duPregunta5a, duPregunta19b, duPregunta19a,
					duVigenciaDe, duPregunta17b, duNumReporteB, duPregunta17a, duAsegurado, duOtro, duFechaAtencion,
					duResPersonas, duGastosLegales, duPlacasAutoB, duDirConductorB, duVehicuoCorralon, duTipoLicenciaB,
					duSipacRec, duClaveAjustadorGral, duPregunta4a, duSipac, duPregunta4b, duAplicoDeducible,
					duRcViajero, duNomAsegurado, duInc, duCaducidadLicenciaB, duNumPolizaB, duNomConductor, duSerie,
					duNomAseguradoB, duPregunta18a,

					duCondicionadoA, duColorAuto, duTradicionalRec, duDaniosPre, duPregunta12a, duCobranzaB,
					duNumSiniestro, duPregunta12b, duNumEndoso, duEdadConductorB, duNomSupervisor, duVigenciaDeB,
					duOcupante5B, duNumReporte,

					duTipoLicencia, duNomCiaB, duPregunta7b, duRoboTotal, duNumRc, duPregunta7a, duNarracion, duLugar,
					duPregunta11b, duPregunta11a, duDaniosApre, duTelAseguradoB, duCobertura, duLicenciaNum,
					duPreguntaABool, duDaniosMateriales, duIncB, duArriboAjustador, duAutoridad, duNumActa,
					duOcupante4B, duEmailConductor, duVigenciaAl, duEstadoAjuste, duCoberturaB, duPregunta6a,
					duPregunta6b, duGastosMedicos, duPregunta14a, duPregunta14b, duMarcaAutoB, duLicenciaEstado,
					duHoraAmbulancia, duSipacEnt, duNomAbogado, duEnEspera, duLicenciaNumB, duPregunta1a, duCristales,
					duNumOcupantes, duOcupante3B, duClaveAjustador, duPregunta1b, duPregunta9a, duNumPersonas,

					duDaniosApreB, duEmailConductorB, duConclusiones, duNomConductorB, duPregunta9b, duEquipoEspecial,
					duResBienes, duSerieB, duPregunta13b, duFechaOcurrido, duPregunta13a, duOtrosEnt, duTipoAutoB,
					duTradicionalEnt, duTerminoAjustadorB, duLicenciaEstadoB, duColorAutoB, duOcupante2B,
					duDirConductor, duTelAsegurado, duId,

					duPregunta8a, duPregunta8b, duTelConductor, duMarcaAuto, duNomAjustadorGral, duPregunta16a,
					duNumSiniestroB,

					duPregunta16b,

					duNomAjustadorB, duArriboAjustadorB, duPreguntaA,

					duPregunta3b, duTerminoAjustador, duResponsableA, duPregunta3a, duVolanteAdmison, duFechaOcurridoB,
					duNomCia, duOcupante1B, duNumPersonales, duHoraGrua, duNumReporteAut, duPregunta15b,
					duCaducidadLicencia, duPregunta15a, duOtros,

					duCobranza, duEdadConductor, duClaveAjustadorB, duFechaAtencionB, duVigenciaAlB, duTelConductorB,
					duNarracionB, duNomAjustador, duPregunta2a, duPregunta2b, duOtroEspecificar,

					duNumPoliza, duHoraAbogado, enviadoEmail, ////
					mensajeEmail, ////
					proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaConA,
					firmaConB, firmaResponsable, firmaAjusA, firmaAjusB, firmaAjusQualitas, duFolioInforme, duCroquis,
					duCalcaA, duCalcaB, duDescripcionCroquis

			);
			log.error("Formatos Error=> ejecutarFuncioninsertarDeclaracionUniversal =>" + duNumReporte, e);

			return "ERROR: " + e.getMessage();
		}
		return res2;
	}

	@Override
	public String InsertarFormatoDeclaracionUniversal(DatosInsertarFormatoDeclaracionUniversal entrada) {

		Map<String, String> entry = new HashMap<String, String>();
		String result = null;

		entry.put("DU_FECHA_OCURRIDO", entrada.getDu_Fecha_Ocurrido());
		entry.put("DU_FECHA_ATENCION", entrada.getDu_Fecha_Atencion());
		entry.put("DU_LUGAR", entrada.getDu_Lugar());
		entry.put("DU_NOM_CIA", entrada.getDu_Nom_Cia());
		entry.put("DU_NUM_POLIZA", entrada.getDu_Num_Poliza());
		entry.put("DU_INC", entrada.getDu_Inc());
		entry.put("DU_NUM_SINIESTRO", entrada.getDu_Num_Siniestro());
		entry.put("DU_NUM_REPORTE", entrada.getDu_Num_Reporte());
		entry.put("DU_VIGENCIA_DE", entrada.getDu_Vigencia_De());
		entry.put("DU_VIGENCIA_AL", entrada.getDu_Vigencia_Al());
		entry.put("DU_COBERTURA", entrada.getDu_Cobertura());
		entry.put("DU_COBRANZA", entrada.getDu_Cobranza());
		entry.put("DU_NOM_ASEGURADO", entrada.getDu_Nom_Asegurado());
		entry.put("DU_TEL_ASEGURADO", entrada.getDu_Tel_Asegurado());
		entry.put("DU_NOM_CONDUCTOR", entrada.getDu_Nom_Conductor());
		entry.put("DU_EDAD_CONDUCTOR", entrada.getDu_Edad_Conductor());
		entry.put("DU_TEL_CONDUCTOR", entrada.getDu_Tel_Conductor());
		entry.put("DU_DIR_CONDUCTOR", entrada.getDu_Dir_Conductor());
		entry.put("DU_EMAIL_CONDUCTOR", entrada.getDu_Email_Conductor());
		entry.put("DU_LICENCIA_NUM", entrada.getDu_Licencia_Num());
		entry.put("DU_LICENCIA_ESTADO", entrada.getDu_Licencia_Estado());
		entry.put("DU_TIPO_LICENCIA", entrada.getDu_Tipo_Licencia());
		entry.put("DU_CADUCIDAD_LICENCIA", entrada.getDu_Caducidad_Licencia());
		entry.put("DU_MARCA_AUTO", entrada.getDu_Marca_Auto());
		entry.put("DU_TIPO_AUTO", entrada.getDu_Tipo_Auto());
		entry.put("DU_COLOR_AUTO", entrada.getDu_Color_Auto());
		entry.put("DU_PLACAS_AUTO", entrada.getDu_Placas_Auto());
		entry.put("DU_SERIE", entrada.getDu_Serie());
		entry.put("DU_NARRACION", entrada.getDu_Narracion());
		entry.put("DU_ARRIBO_AJUSTADOR", entrada.getDu_Arribo_Ajustador());
		entry.put("DU_TERMINO_AJUSTADOR", entrada.getDu_Termino_Ajustador());
		entry.put("DU_DANIOS_APRE", entrada.getDu_Danios_Apre());
		entry.put("DU_DANIOS_PRE", entrada.getDu_Danios_Pre());
		entry.put("DU_FECHA_OCURRIDO_B", entrada.getDu_Fecha_Ocurrido_B());
		entry.put("DU_FECHA_ATENCION_B", entrada.getDu_Fecha_Atencion_B());
		entry.put("DU_LUGAR_B", entrada.getDu_Lugar_B());
		entry.put("DU_NOM_CIA_B", entrada.getDu_Nom_Cia_B());
		entry.put("DU_NUM_POLIZA_B", entrada.getDu_Num_Poliza_B());
		entry.put("DU_INC_B", entrada.getDu_Inc_B());
		entry.put("DU_NUM_SINIESTRO_B", entrada.getDu_Num_Siniestro_B());
		entry.put("DU_NUM_REPORTE_B", entrada.getDu_Num_Reporte_B());
		entry.put("DU_VIGENCIA_DE_B", entrada.getDu_Vigencia_De_B());
		entry.put("DU_VIGENCIA_AL_B", entrada.getDu_Vigencia_Al_B());
		entry.put("DU_COBERTURA_B", entrada.getDu_Cobertura_B());
		entry.put("DU_COBRANZA_B", entrada.getDu_Cobranza_B());
		entry.put("DU_NOM_ASEGURADO_B", entrada.getDu_Nom_Asegurado_B());
		entry.put("DU_NOM_CONDUCTOR_B", entrada.getDu_Nom_Conductor_B());
		entry.put("DU_EDAD_CONDUCTOR_B", entrada.getDu_Edad_Conductor_B());
		entry.put("DU_TEL_CONDUCTOR_B", entrada.getDu_Tel_Conductor_B());
		entry.put("DU_DIR_CONDUCTOR_B", entrada.getDu_Dir_Conductor_B());
		entry.put("DU_EMAIL_CONDUCTOR_B", entrada.getDu_Email_Conductor_B());
		entry.put("DU_LICENCIA_NUM_B", entrada.getDu_Licencia_Num_B());
		entry.put("DU_LICENCIA_ESTADO_B", entrada.getDu_Licencia_Estado_B());
		entry.put("DU_TIPO_LICENCIA_B", entrada.getDu_Tipo_Licencia_B());
		entry.put("DU_CADUCIDAD_LICENCIA_B", entrada.getDu_Caducidad_Licencia_B());
		entry.put("DU_MARCA_AUTO_B", entrada.getDu_Marca_Auto_B());
		entry.put("DU_TIPO_AUTO_B", entrada.getDu_Tipo_Auto_B());
		entry.put("DU_COLOR_AUTO_B", entrada.getDu_Color_Auto_B());
		entry.put("DU_PLACAS_AUTO_B", entrada.getDu_Placas_Auto_B());
		entry.put("DU_SERIE_B", entrada.getDu_Serie_B());
		entry.put("DU_NARRACION_B", entrada.getDu_Narracion_B());
		entry.put("DU_ARRIBO_AJUSTADOR_B", entrada.getDu_Arribo_Ajustador_B());
		entry.put("DU_TERMINO_AJUSTADOR_B", entrada.getDu_Termino_Ajustador_B());
		entry.put("DU_DANIOS_APRE_B", entrada.getDu_Danios_Apre_B());
		entry.put("DU_DANIOS_PRE_B", entrada.getDu_Danios_Pre_B());
		entry.put("DU_TEL_ASEGURADO_B", entrada.getDu_Tel_Asegurado_B());
		entry.put("DU_RESPONSABLE_A", entrada.getDu_Responsable_A());
		entry.put("DU_SIPAC", entrada.getDu_Sipac());
		entry.put("DU_EN_ESPERA", entrada.getDu_En_Espera());
		entry.put("DU_NOM_AJUSTADOR", entrada.getDu_Nom_Ajustador());
		entry.put("DU_CLAVE_AJUSTADOR", entrada.getDu_Clave_Ajustador());
		entry.put("DU_NOM_AJUSTADOR_B", entrada.getDu_Nom_Ajustador_B());
		entry.put("DU_CLAVE_AJUSTADOR_B", entrada.getDu_Clave_Ajustador_B());
		entry.put("DU_OCUPANTE_1", entrada.getDu_Ocupante_1());
		entry.put("DU_OCUPANTE_2", entrada.getDu_Ocupante_2());
		entry.put("DU_OCUPANTE_3", entrada.getDu_Ocupante_3());
		entry.put("DU_OCUPANTE_4", entrada.getDu_Ocupante_4());
		entry.put("DU_OCUPANTE_5", entrada.getDu_Ocupante_5());
		entry.put("DU_OCUPANTE_1_B", entrada.getDu_Ocupante_1_B());
		entry.put("DU_OCUPANTE_2_B", entrada.getDu_Ocupante_2_B());
		entry.put("DU_OCUPANTE_3_B", entrada.getDu_Ocupante_3_B());
		entry.put("DU_OCUPANTE_4_B", entrada.getDu_Ocupante_4_B());
		entry.put("DU_OCUPANTE_5_B", entrada.getDu_Ocupante_5_B());
		entry.put("DU_VOLANTE_ADMISON", entrada.getDu_Volante_Admison());
		entry.put("DU_APLICO_DEDUCIBLE", entrada.getDu_Aplico_Deducible());
		entry.put("DU_HORA_GRUA", entrada.getDu_Hora_Grua());
		entry.put("DU_VEHICUO_CORRALON", entrada.getDu_Vehicuo_Corralon());
		entry.put("DU_HORA_AMBULANCIA", entrada.getDu_Hora_Ambulancia());
		entry.put("DU_HORA_ABOGADO", entrada.getDu_Hora_Abogado());
		entry.put("DU_TRADICIONAL_ENT", entrada.getDu_Tradicional_Ent());
		entry.put("DU_TRADICIONAL_REC", entrada.getDu_Tradicional_Rec());
		entry.put("DU_SIPAC_ENT", entrada.getDu_Sipac_Ent());
		entry.put("DU_SIPAC_REC", entrada.getDu_Sipac_Rec());
		entry.put("DU_OTROS", entrada.getDu_Otros());
		entry.put("DU_OTROS_REC", entrada.getDu_Otros_Rec());
		entry.put("DU_OTROS_ENT", entrada.getDu_Otros_Ent());
		entry.put("DU_RECUPERACION", entrada.getDu_Recuperacion());
		entry.put("DU_AUTORIDAD", entrada.getDu_Autoridad());
		entry.put("DU_NUM_ACTA", entrada.getDu_Num_Acta());
		entry.put("DU_NUM_REPORTE_AUT", entrada.getDu_Num_Reporte_Aut());
		entry.put("DU_NOM_ABOGADO", entrada.getDu_Nom_Abogado());
		entry.put("DU_DANIOS_MATERIALES", entrada.getDu_Danios_Materiales());
		entry.put("DU_EQUIPO_ESPECIAL", entrada.getDu_Equipo_Especial());
		entry.put("DU_ROBO_TOTAL", entrada.getDu_Robo_Total());
		entry.put("DU_RES_BIENES", entrada.getDu_Res_Bienes());
		entry.put("DU_RES_PERSONAS", entrada.getDu_Res_Personas());
		entry.put("DU_NUM_PERSONAS", entrada.getDu_Num_Personas());
		entry.put("DU_GASTOS_MEDICOS", entrada.getDu_Gastos_Medicos());
		entry.put("DU_NUM_OCUPANTES", entrada.getDu_Num_Ocupantes());
		entry.put("DU_GASTOS_LEGALES", entrada.getDu_Gastos_Legales());
		entry.put("DU_ACCI_PERSONALES", entrada.getDu_Acci_Personales());
		entry.put("DU_NUM_PERSONALES", entrada.getDu_Num_Personales());
		entry.put("DU_RC_VIAJERO", entrada.getDu_Rc_Viajero());
		entry.put("DU_NUM_RC", entrada.getDu_Num_Rc());
		entry.put("DU_CRISTALES", entrada.getDu_Cristales());
		entry.put("DU_OTRO", entrada.getDu_Otro());
		entry.put("DU_OTRO_ESPECIFICAR", entrada.getDu_Otro_Especificar());
		entry.put("DU_NOM_SUPERVISOR", entrada.getDu_Nom_Supervisor());
		entry.put("DU_ESTADO_AJUSTE", entrada.getDu_Estado_Ajuste());
		entry.put("DU_CONDICIONADO_A", entrada.getDu_Condicionado_A());
		entry.put("DU_CONCLUSIONES", entrada.getDu_Conclusiones());
		entry.put("DU_INFORME_ADICIONAL", entrada.getDu_Informe_Adicional());
		entry.put("DU_PREGUNTA_1A", entrada.getDu_Pregunta_1a());
		entry.put("DU_PREGUNTA_2A", entrada.getDu_Pregunta_2a());
		entry.put("DU_PREGUNTA_3A", entrada.getDu_Pregunta_3a());
		entry.put("DU_PREGUNTA_4A", entrada.getDu_Pregunta_4a());
		entry.put("DU_PREGUNTA_5A", entrada.getDu_Pregunta_5a());
		entry.put("DU_PREGUNTA_6A", entrada.getDu_Pregunta_6a());
		entry.put("DU_PREGUNTA_7A", entrada.getDu_Pregunta_7a());
		entry.put("DU_PREGUNTA_8A", entrada.getDu_Pregunta_8a());
		entry.put("DU_PREGUNTA_9A", entrada.getDu_Pregunta_9a());
		entry.put("DU_PREGUNTA_10A", entrada.getDu_Pregunta_10a());
		entry.put("DU_PREGUNTA_11A", entrada.getDu_Pregunta_11a());
		entry.put("DU_PREGUNTA_12A", entrada.getDu_Pregunta_12a());
		entry.put("DU_PREGUNTA_13A", entrada.getDu_Pregunta_13a());
		entry.put("DU_PREGUNTA_14A", entrada.getDu_Pregunta_14a());
		entry.put("DU_PREGUNTA_15A", entrada.getDu_Pregunta_15a());
		entry.put("DU_PREGUNTA_16A", entrada.getDu_Pregunta_16a());
		entry.put("DU_PREGUNTA_17A", entrada.getDu_Pregunta_17a());
		entry.put("DU_PREGUNTA_18A", entrada.getDu_Pregunta_18a());
		entry.put("DU_PREGUNTA_19A", entrada.getDu_Pregunta_19a());
		entry.put("DU_PREGUNTA_1B", entrada.getDu_Pregunta_1b());
		entry.put("DU_PREGUNTA_2B", entrada.getDu_Pregunta_2b());
		entry.put("DU_PREGUNTA_3B", entrada.getDu_Pregunta_3b());
		entry.put("DU_PREGUNTA_4B", entrada.getDu_Pregunta_4b());
		entry.put("DU_PREGUNTA_5B", entrada.getDu_Pregunta_5b());
		entry.put("DU_PREGUNTA_6B", entrada.getDu_Pregunta_6b());
		entry.put("DU_PREGUNTA_7B", entrada.getDu_Pregunta_7b());
		entry.put("DU_PREGUNTA_8B", entrada.getDu_Pregunta_8b());
		entry.put("DU_PREGUNTA_9B", entrada.getDu_Pregunta_9b());
		entry.put("DU_PREGUNTA_10B", entrada.getDu_Pregunta_10b());
		entry.put("DU_PREGUNTA_11B", entrada.getDu_Pregunta_11b());
		entry.put("DU_PREGUNTA_12B", entrada.getDu_Pregunta_12b());
		entry.put("DU_PREGUNTA_13B", entrada.getDu_Pregunta_13b());
		entry.put("DU_PREGUNTA_14B", entrada.getDu_Pregunta_14b());
		entry.put("DU_PREGUNTA_15B", entrada.getDu_Pregunta_15b());
		entry.put("DU_PREGUNTA_16B", entrada.getDu_Pregunta_16b());
		entry.put("DU_PREGUNTA_17B", entrada.getDu_Pregunta_17b());
		entry.put("DU_PREGUNTA_18B", entrada.getDu_Pregunta_18b());
		entry.put("DU_PREGUNTA_19B", entrada.getDu_Pregunta_19b());
		entry.put("DU_PREGUNTA_A", entrada.getDu_Pregunta_A());
		entry.put("DU_FOLIO", entrada.getDu_Folio());
		entry.put("DU_NUM_INCISO", entrada.getDu_Num_Inciso());
		entry.put("DU_ASEGURADO", entrada.getDu_Asegurado());
		entry.put("DU_NUM_ENDOSO", entrada.getDu_Num_Endoso());
		entry.put("DU_NOM_AJUSTADOR_GRAL", entrada.getDu_Nom_Ajustador_Gral());
		entry.put("DU_CLAVE_AJUSTADOR_GRAL", entrada.getDu_Clave_Ajustador_Gral());
		entry.put("DU_PREGUNTA_A_BOOL", entrada.getDu_Pregunta_A_Bool());
		entry.put("DU_PREGUNTA_B_BOOL", entrada.getDu_Pregunta_B_Bool());
		entry.put("DU_MODELO_AUTO_A", entrada.getDu_Modelo_Auto_A());
		entry.put("DU_MODELO_AUTO_B", entrada.getDu_Modelo_Auto_B());
		entry.put("DU_USO_AUTO_A", entrada.getDu_Uso_Auto_A());
		entry.put("DU_USO_AUTO_B", entrada.getDu_Uso_Auto_B());
		entry.put("CHECK_1", entrada.getCheck_1());
		entry.put("CHECK_2", entrada.getCheck_2());
		entry.put("CHECK_3", entrada.getCheck_3());
		entry.put("CHECK_4", entrada.getCheck_4());
		entry.put("FIRMA_CON_A", entrada.getFirma_Con_A());
		entry.put("FIRMA_CON_B", entrada.getFirma_Con_B());
		entry.put("FIRMA_RESPONSABLE", entrada.getFirma_Responsable());
		entry.put("FIRMA_AJUS_A", entrada.getFirma_Ajus_A());
		entry.put("FIRMA_AJUS_B", entrada.getFirma_Ajus_B());
		entry.put("FIRMA_AJUS_QUALITAS", entrada.getFirma_Ajus_Qualitas());
		entry.put("DU_FOLIO_INFORME", entrada.getDu_Folio_Informe());
		entry.put("DU_CROQUIS", entrada.getDu_Croquis());
		entry.put("DU_CALCA_A", entrada.getDu_Calca_A());
		entry.put("DU_CALCA_B", entrada.getDu_Calca_B());
		entry.put("DU_DESCRIPCION_CROQUIS", entrada.getDu_Descripcion_Croquis());
		entry.put("DU_CODIGO_RESPONSABILIDAD", entrada.getDu_codigo_responsabilidad());
		entry.put("CORREO_OCULTO", entrada.getCorreo_oculto());
		entry.put("FUENTE_WS", entrada.getFuente_ws());
		entry.put("CHECK_5", entrada.getCheck_5());
		entry.put("CHECK_6", entrada.getCheck_6());

		result = ejecutarFuncionWebserviceStoreFDU(entry);
		return result;
	}

	// DB
	@Override
	public String ejecutarFuncionWebserviceStoreFDU(Map<String, String> entry) {

		StoredProcedureQuery query = this.getEntityManager().createStoredProcedureQuery("WEBSERVICESTORE_FDU");

		String[] columnas = new String[] { "DU_FECHA_OCURRIDO", "DU_FECHA_ATENCION", "DU_LUGAR", "DU_NOM_CIA",
				"DU_NUM_POLIZA", "DU_INC", "DU_NUM_SINIESTRO", "DU_NUM_REPORTE", "DU_VIGENCIA_DE", "DU_VIGENCIA_AL",
				"DU_COBERTURA", "DU_COBRANZA", "DU_NOM_ASEGURADO", "DU_TEL_ASEGURADO", "DU_NOM_CONDUCTOR",
				"DU_EDAD_CONDUCTOR", "DU_TEL_CONDUCTOR", "DU_DIR_CONDUCTOR", "DU_EMAIL_CONDUCTOR", "DU_LICENCIA_NUM",
				"DU_LICENCIA_ESTADO", "DU_TIPO_LICENCIA", "DU_CADUCIDAD_LICENCIA", "DU_MARCA_AUTO", "DU_TIPO_AUTO",
				"DU_COLOR_AUTO", "DU_PLACAS_AUTO", "DU_SERIE", "DU_NARRACION", "DU_ARRIBO_AJUSTADOR",
				"DU_TERMINO_AJUSTADOR", "DU_DANIOS_APRE", "DU_DANIOS_PRE", "DU_FECHA_OCURRIDO_B", "DU_FECHA_ATENCION_B",
				"DU_LUGAR_B", "DU_NOM_CIA_B", "DU_NUM_POLIZA_B", "DU_INC_B", "DU_NUM_SINIESTRO_B", "DU_NUM_REPORTE_B",
				"DU_VIGENCIA_DE_B", "DU_VIGENCIA_AL_B", "DU_COBERTURA_B", "DU_COBRANZA_B", "DU_NOM_ASEGURADO_B",
				"DU_NOM_CONDUCTOR_B", "DU_EDAD_CONDUCTOR_B", "DU_TEL_CONDUCTOR_B", "DU_DIR_CONDUCTOR_B",
				"DU_EMAIL_CONDUCTOR_B", "DU_LICENCIA_NUM_B", "DU_LICENCIA_ESTADO_B", "DU_TIPO_LICENCIA_B",
				"DU_CADUCIDAD_LICENCIA_B", "DU_MARCA_AUTO_B", "DU_TIPO_AUTO_B", "DU_COLOR_AUTO_B", "DU_PLACAS_AUTO_B",
				"DU_SERIE_B", "DU_NARRACION_B", "DU_ARRIBO_AJUSTADOR_B", "DU_TERMINO_AJUSTADOR_B", "DU_DANIOS_APRE_B",
				"DU_DANIOS_PRE_B", "DU_TEL_ASEGURADO_B", "DU_RESPONSABLE_A", "DU_SIPAC", "DU_EN_ESPERA",
				"DU_NOM_AJUSTADOR", "DU_CLAVE_AJUSTADOR", "DU_NOM_AJUSTADOR_B", "DU_CLAVE_AJUSTADOR_B", "DU_OCUPANTE_1",
				"DU_OCUPANTE_2", "DU_OCUPANTE_3", "DU_OCUPANTE_4", "DU_OCUPANTE_5", "DU_OCUPANTE_1_B",
				"DU_OCUPANTE_2_B", "DU_OCUPANTE_3_B", "DU_OCUPANTE_4_B", "DU_OCUPANTE_5_B", "DU_VOLANTE_ADMISON",
				"DU_APLICO_DEDUCIBLE", "DU_HORA_GRUA", "DU_VEHICUO_CORRALON", "DU_HORA_AMBULANCIA", "DU_HORA_ABOGADO",
				"DU_TRADICIONAL_ENT", "DU_TRADICIONAL_REC", "DU_SIPAC_ENT", "DU_SIPAC_REC", "DU_OTROS", "DU_OTROS_REC",
				"DU_OTROS_ENT", "DU_RECUPERACION", "DU_AUTORIDAD", "DU_NUM_ACTA", "DU_NUM_REPORTE_AUT",
				"DU_NOM_ABOGADO", "DU_DANIOS_MATERIALES", "DU_EQUIPO_ESPECIAL", "DU_ROBO_TOTAL", "DU_RES_BIENES",
				"DU_RES_PERSONAS", "DU_NUM_PERSONAS", "DU_GASTOS_MEDICOS", "DU_NUM_OCUPANTES", "DU_GASTOS_LEGALES",
				"DU_ACCI_PERSONALES", "DU_NUM_PERSONALES", "DU_RC_VIAJERO", "DU_NUM_RC", "DU_CRISTALES", "DU_OTRO",
				"DU_OTRO_ESPECIFICAR", "DU_NOM_SUPERVISOR", "DU_ESTADO_AJUSTE", "DU_CONDICIONADO_A", "DU_CONCLUSIONES",
				"DU_INFORME_ADICIONAL", "DU_PREGUNTA_1A", "DU_PREGUNTA_2A", "DU_PREGUNTA_3A", "DU_PREGUNTA_4A",
				"DU_PREGUNTA_5A", "DU_PREGUNTA_6A", "DU_PREGUNTA_7A", "DU_PREGUNTA_8A", "DU_PREGUNTA_9A",
				"DU_PREGUNTA_10A", "DU_PREGUNTA_11A", "DU_PREGUNTA_12A", "DU_PREGUNTA_13A", "DU_PREGUNTA_14A",
				"DU_PREGUNTA_15A", "DU_PREGUNTA_16A", "DU_PREGUNTA_17A", "DU_PREGUNTA_18A", "DU_PREGUNTA_19A",
				"DU_PREGUNTA_1B", "DU_PREGUNTA_2B", "DU_PREGUNTA_3B", "DU_PREGUNTA_4B", "DU_PREGUNTA_5B",
				"DU_PREGUNTA_6B", "DU_PREGUNTA_7B", "DU_PREGUNTA_8B", "DU_PREGUNTA_9B", "DU_PREGUNTA_10B",
				"DU_PREGUNTA_11B", "DU_PREGUNTA_12B", "DU_PREGUNTA_13B", "DU_PREGUNTA_14B", "DU_PREGUNTA_15B",
				"DU_PREGUNTA_16B", "DU_PREGUNTA_17B", "DU_PREGUNTA_18B", "DU_PREGUNTA_19B", "DU_PREGUNTA_A", "DU_FOLIO",
				"DU_NUM_INCISO", "DU_ASEGURADO", "DU_NUM_ENDOSO", "DU_NOM_AJUSTADOR_GRAL", "DU_CLAVE_AJUSTADOR_GRAL",
				"DU_PREGUNTA_A_BOOL", "DU_PREGUNTA_B_BOOL", "DU_MODELO_AUTO_A", "DU_MODELO_AUTO_B", "DU_USO_AUTO_A",
				"DU_USO_AUTO_B", "CHECK_1", "CHECK_2", "CHECK_3", "CHECK_4", "FIRMA_CON_A", "FIRMA_CON_B",
				"FIRMA_RESPONSABLE", "FIRMA_AJUS_A", "FIRMA_AJUS_B", "FIRMA_AJUS_QUALITAS", "DU_FOLIO_INFORME",
				"DU_CROQUIS", "DU_CALCA_A", "DU_CALCA_B", "DU_DESCRIPCION_CROQUIS" ,"DU_CODIGO_RESPONSABILIDAD",
				"CORREO_OCULTO","FUENTE_WS","CHECK_5", "CHECK_6"};

		for (int i = 0; i < columnas.length; i++) {
			query.registerStoredProcedureParameter((i + 1), String.class, ParameterMode.IN);
		}
		query.registerStoredProcedureParameter(194, String.class, ParameterMode.OUT);

		for (int x = 0; x < columnas.length; x++) {
			query.setParameter((x + 1), entry.get(columnas[x]));
		}
		query.execute();
		return String.valueOf(query.getOutputParameterValue(194));
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		int consecutivo = 0;
		try {
			String resultado = "";
			resultado = Objects.toString(this.getEntityManager()
					.createNativeQuery(
							"select count(*) from FORMATO_DECLARACION_UNIVERSAL where DU_NUM_REPORTE='" + reporte + "'")
					.getSingleResult());

			consecutivo = Integer.parseInt(resultado);

		} catch (final Exception e) {
			this.documentarExcepcionParaMetodo(e, "obtieneConsecutivo", reporte);
			log.error("Formatos Error=> obtenerConsecutivo =>" + reporte, e);

		}
		return consecutivo;

	}

}