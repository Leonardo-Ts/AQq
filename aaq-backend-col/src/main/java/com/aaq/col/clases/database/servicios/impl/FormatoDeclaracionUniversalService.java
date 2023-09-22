package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoDeclaracionUniversal;
import com.aaq.col.clases.database.repositorios.impl.FormatoDeclaracionUniversalDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoDeclaracionUniversalServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoDeclaracionUniversalService")
@Transactional
public class FormatoDeclaracionUniversalService implements FormatoDeclaracionUniversalServiceInterfase {
	
	@Autowired
	@Qualifier("formatoDeclaracionUniversalDao")
	FormatoDeclaracionUniversalDao formatoDeclaracionUniversalDao;

	@Override
	public FormatoDeclaracionUniversal objetoFormatoDeclaracionUniversal(String id) {
		return this.formatoDeclaracionUniversalDao.objetoFormatoDeclaracionUniversal(id);
	}

	@Override
	public String ejecutarFuncionInsertarDeclaracionUniversal(String duModeloAutoA, String duModeloAutoB,
			String duUsoAutoA, String duUsoAutoB, String duPlacasAuto, Integer duPregunta18b, String duDaniosPreB,
			String duNumInciso, String duRecuperacion, Integer duPregunta10a, String duOcupante1, Integer duPregunta10b,
			String duOcupante5, String duOcupante4, String duAcciPersonales, String duOcupante3, String duOcupante2,
			Integer duOtrosRec, Integer duPregunta5b, String duTipoAuto, Integer duInformeAdicional, String duLugarB,
			Integer duPreguntaBBool, Integer duPregunta5a, Integer duPregunta19b, Integer duPregunta19a,
			Timestamp duVigenciaDe, Integer duPregunta17b, String duNumReporteB, Integer duPregunta17a,
			String duAsegurado, String duOtro, Timestamp duFechaAtencion, String duResPersonas, String duGastosLegales,
			String duPlacasAutoB, String duDirConductorB, Integer duVehicuoCorralon, String duTipoLicenciaB,
			Integer duSipacRec, String duClaveAjustadorGral, Integer duPregunta4a, Integer duSipac,
			Integer duPregunta4b, String duAplicoDeducible, String duRcViajero, String duNomAsegurado, String duInc,
			Timestamp duCaducidadLicenciaB, String duNumPolizaB, String duNomConductor, String duSerie,
			String duNomAseguradoB, Integer duPregunta18a, String duCondicionadoA, String duColorAuto,
			Integer duTradicionalRec, String duDaniosPre, Integer duPregunta12a, String duCobranzaB,
			String duNumSiniestro, Integer duPregunta12b, String duNumEndoso, String duEdadConductorB,
			String duNomSupervisor, Timestamp duVigenciaDeB, String duOcupante5B, String duNumReporte,
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
			String duNumPersonas, String duDaniosApreB, String duEmailConductorB, String duConclusiones,
			String duNomConductorB, Integer duPregunta9b, String duEquipoEspecial, String duResBienes, String duSerieB,
			Integer duPregunta13b, Timestamp duFechaOcurrido, Integer duPregunta13a, Integer duOtrosEnt,
			String duTipoAutoB, Integer duTradicionalEnt, Timestamp duTerminoAjustadorB, String duLicenciaEstadoB,
			String duColorAutoB, String duOcupante2B, String duDirConductor, String duTelAsegurado, Integer duId,
			Integer duPregunta8a, Integer duPregunta8b, String duTelConductor, String duMarcaAuto,
			String duNomAjustadorGral, Integer duPregunta16a, String duNumSiniestroB, Integer duPregunta16b,
			String duNomAjustadorB, Timestamp duArriboAjustadorB, String duPreguntaA, Integer duPregunta3b,
			Timestamp duTerminoAjustador, Integer duResponsableA, Integer duPregunta3a, Integer duVolanteAdmison,
			Timestamp duFechaOcurridoB, String duNomCia, String duOcupante1B, String duNumPersonales,
			Timestamp duHoraGrua, String duNumReporteAut, Integer duPregunta15b, Timestamp duCaducidadLicencia,
			Integer duPregunta15a, String duOtros, String duCobranza, String duEdadConductor, String duClaveAjustadorB,
			Timestamp duFechaAtencionB, Timestamp duVigenciaAlB, String duTelConductorB, String duNarracionB,
			String duNomAjustador, Integer duPregunta2a, Integer duPregunta2b, String duOtroEspecificar,
			String duNumPoliza, Timestamp duHoraAbogado, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaConA, String firmaConB,
			String firmaResponsable, String firmaAjusA, String firmaAjusB, String firmaAjusQualitas,
			String duFolioInforme, String duCroquis, String duCalcaA, String duCalcaB, String duDescripcionCroquis

	) {
		return this.formatoDeclaracionUniversalDao.ejecutarFuncionInsertarDeclaracionUniversal(

				duModeloAutoA, duModeloAutoB, duUsoAutoA, duUsoAutoB, duPlacasAuto, duPregunta18b, duDaniosPreB,
				duNumInciso, duRecuperacion, duPregunta10a, duOcupante1, duPregunta10b, duOcupante5, duOcupante4,
				duAcciPersonales, duOcupante3, duOcupante2, duOtrosRec, duPregunta5b, duTipoAuto, duInformeAdicional,
				duLugarB, duPreguntaBBool, duPregunta5a, duPregunta19b, duPregunta19a, duVigenciaDe, duPregunta17b,
				duNumReporteB, duPregunta17a, duAsegurado, duOtro, duFechaAtencion, duResPersonas, duGastosLegales,
				duPlacasAutoB, duDirConductorB, duVehicuoCorralon, duTipoLicenciaB, duSipacRec, duClaveAjustadorGral,
				duPregunta4a, duSipac, duPregunta4b, duAplicoDeducible, duRcViajero, duNomAsegurado, duInc,
				duCaducidadLicenciaB, duNumPolizaB, duNomConductor, duSerie, duNomAseguradoB, duPregunta18a,

				duCondicionadoA, duColorAuto, duTradicionalRec, duDaniosPre, duPregunta12a, duCobranzaB, duNumSiniestro,
				duPregunta12b, duNumEndoso, duEdadConductorB, duNomSupervisor, duVigenciaDeB, duOcupante5B,
				duNumReporte,

				duTipoLicencia, duNomCiaB, duPregunta7b, duRoboTotal, duNumRc, duPregunta7a, duNarracion, duLugar,
				duPregunta11b, duPregunta11a, duDaniosApre, duTelAseguradoB, duCobertura, duLicenciaNum,
				duPreguntaABool, duDaniosMateriales, duIncB, duArriboAjustador, duAutoridad, duNumActa, duOcupante4B,
				duEmailConductor, duVigenciaAl, duEstadoAjuste, duCoberturaB, duPregunta6a, duPregunta6b,
				duGastosMedicos, duPregunta14a, duPregunta14b, duMarcaAutoB, duLicenciaEstado, duHoraAmbulancia,
				duSipacEnt, duNomAbogado, duEnEspera, duLicenciaNumB, duPregunta1a, duCristales, duNumOcupantes,
				duOcupante3B, duClaveAjustador, duPregunta1b, duPregunta9a, duNumPersonas,

				duDaniosApreB, duEmailConductorB, duConclusiones, duNomConductorB, duPregunta9b, duEquipoEspecial,
				duResBienes, duSerieB, duPregunta13b, duFechaOcurrido, duPregunta13a, duOtrosEnt, duTipoAutoB,
				duTradicionalEnt, duTerminoAjustadorB, duLicenciaEstadoB, duColorAutoB, duOcupante2B, duDirConductor,
				duTelAsegurado, duId,

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
				mensajeEmail,

				proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaConA, firmaConB,
				firmaResponsable, firmaAjusA, firmaAjusB, firmaAjusQualitas, duFolioInforme, duCroquis, duCalcaA,
				duCalcaB, duDescripcionCroquis

		);
	}

	@Override
	public List<FormatoDeclaracionUniversal> listaDeFormatoDeclaracionUniversal() {
		return this.formatoDeclaracionUniversalDao.listaDeFormatoDeclaracionUniversal();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoDeclaracionUniversal t) {

		return this.formatoDeclaracionUniversalDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoDeclaracionUniversalDao.obtenerConsecutivo(reporte);

	}

//	@Override
//	public List<FormatoDeclaracionUniversal> obtenerFormatoDUA(String reporte) {
//		return this.formatoDeclaracionUniversalDao.obtenerFormatoDUA(reporte);
//	}

}