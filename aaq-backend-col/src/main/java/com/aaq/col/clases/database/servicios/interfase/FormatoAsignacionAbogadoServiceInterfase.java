package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoAsignacionAbogado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoAsignacionAbogadoServiceInterfase
		extends JMServicioGenericoInterfase<FormatoAsignacionAbogado> {

	public abstract FormatoAsignacionAbogado objetoFormatoAsignacionAbogado(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoAsignacionAbogado t);
	public abstract List<FormatoAsignacionAbogado> listaDeFormatoAsignacionAbogado();
	public abstract String ejecutarFuncionInsertarAsignacionAbogado(
			String aaNomConductor, String aaMarcaAuto, String aaColorAuto, String aaNomAjustador, Integer aaGrua,
			Integer aaPagado, Double aaDaniosNa, String aaTelOficina, String aaTelCasa, Integer aaPaseMedico,
			String aaClaveAbogado, String aaAutoridad, String aaAsegurado, String aaEmail, String aaDescripcionDanios,
			Timestamp aaHoraSiniestro, String aaNomLesionados, Integer aaPregunta1A, Integer aaPregunta1,
			Integer aaPregunta1B, String aaTelOficinaTercero,
			Integer aaPregunta3, String aaNumSiniestro, Integer aaPregunta2, String aaNomTercero, Integer aaPregunta5,
			Integer aaPregunta4, Integer aaPregunta6, String aaTipoAuto, Integer aaPresuAsegurado, String aaInforme,
			Integer aaCopiaLicencia,
			String aaDaniosEstimados, Integer aaGruaTercero, String aaLugarSiniestro, String aaOtros,
			Integer aaPropietario, String aaNomAbogado, String aaNumPoliza, Integer aaDeducibleRc,
			String aaUbicacionActual, String aaNumInciso, Integer aaOrdenAdmision, Timestamp aaHoraAbogado,
			String aaClaveAjustador, Integer aaCopiaPoliza, Double aaMontoCrucero, Integer aaParteAcciden,
			String aaNumAccidente, Double aaMontoDeducible, String aaNomAsegurado, String aaPlacaAuto,
			Timestamp aaHoraTurnado, String aaDesDaniosTer, String aaTelCasaTercero, Integer aaId,
			Integer aaDeclaracionConduc, String aaNumReporte, String aaComentarios, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador,
			String firmaAsegurado, String firmaAbogado, Integer aaPregunta7A, Integer aaPregunta7B);
	public abstract int obtenerConsecutivo(String reporte);
}