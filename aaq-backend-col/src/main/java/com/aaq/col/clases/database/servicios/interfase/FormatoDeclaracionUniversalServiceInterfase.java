package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoDeclaracionUniversal;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoDeclaracionUniversalServiceInterfase
		extends JMServicioGenericoInterfase<FormatoDeclaracionUniversal> {

	public abstract FormatoDeclaracionUniversal objetoFormatoDeclaracionUniversal(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoDeclaracionUniversal t);
	public abstract List<FormatoDeclaracionUniversal> listaDeFormatoDeclaracionUniversal();
	public abstract String ejecutarFuncionInsertarDeclaracionUniversal(String duModeloAutoA, String duModeloAutoB,
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
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaConA, String firmaConB,
			String firmaResponsable, String firmaAjusA, String firmaAjusB, String firmaAjusQualitas,
			String duFolioInforme, String duCroquis, String duCalcaA, String duCalcaB, String duDescripcionCroquis
	);
	public abstract int obtenerConsecutivo(String reporte);

}