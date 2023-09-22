package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoAsignacionAbogado;
import com.aaq.col.clases.database.repositorios.impl.FormatoAsignacionAbogadoDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoAsignacionAbogadoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoAsignacionAbogadoService")
@Transactional
public class FormatoAsignacionAbogadoService implements FormatoAsignacionAbogadoServiceInterfase {
	
	@Autowired
	@Qualifier("formatoAsignacionAbogadoDao")
	FormatoAsignacionAbogadoDao formatoAsignacionAbogadoDao;

	@Override
	public FormatoAsignacionAbogado objetoFormatoAsignacionAbogado(String id) {
		return this.formatoAsignacionAbogadoDao.objetoFormatoAsignacionAbogado(id);
	}

	@Override
	public String ejecutarFuncionInsertarAsignacionAbogado(

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
			String firmaAsegurado, String firmaAbogado, Integer aaPregunta7A, Integer aaPregunta7B

	) {
		return this.formatoAsignacionAbogadoDao.ejecutarFuncionInsertarAsignacionAbogado(

				aaNomConductor, aaMarcaAuto, aaColorAuto, aaNomAjustador, aaGrua,

				aaPagado, aaDaniosNa, aaTelOficina, aaTelCasa, aaPaseMedico, aaClaveAbogado, aaAutoridad, aaAsegurado,
				aaEmail, aaDescripcionDanios, aaHoraSiniestro, aaNomLesionados, aaPregunta1A, aaPregunta1, aaPregunta1B,
				aaTelOficinaTercero,

				aaPregunta3, aaNumSiniestro, aaPregunta2, aaNomTercero, aaPregunta5, aaPregunta4, aaPregunta6,
				aaTipoAuto, aaPresuAsegurado, aaInforme, aaCopiaLicencia,

				aaDaniosEstimados, aaGruaTercero, aaLugarSiniestro, aaOtros, aaPropietario, aaNomAbogado, aaNumPoliza,
				aaDeducibleRc, aaUbicacionActual, aaNumInciso, aaOrdenAdmision, aaHoraAbogado, aaClaveAjustador,
				aaCopiaPoliza, aaMontoCrucero, aaParteAcciden, aaNumAccidente, aaMontoDeducible, aaNomAsegurado,
				aaPlacaAuto, aaHoraTurnado, aaDesDaniosTer, aaTelCasaTercero, aaId, aaDeclaracionConduc, aaNumReporte,
				aaComentarios, enviadoEmail, ////
				mensajeEmail,

				proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaAjustador,
				firmaAsegurado, firmaAbogado, aaPregunta7A, aaPregunta7B

		);
	}

	@Override
	public List<FormatoAsignacionAbogado> listaDeFormatoAsignacionAbogado() {
		return this.formatoAsignacionAbogadoDao.listaDeFormatoAsignacionAbogado();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoAsignacionAbogado t) {

		return this.formatoAsignacionAbogadoDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoAsignacionAbogadoDao.obtenerConsecutivo(reporte);

	}

}