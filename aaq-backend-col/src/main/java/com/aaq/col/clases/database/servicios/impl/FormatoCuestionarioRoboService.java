package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoCuestionarioRobo;
import com.aaq.col.clases.database.repositorios.impl.FormatoCuestionarioRoboDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoCuestionarioRoboServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoCuestionarioRoboService")
@Transactional
public class FormatoCuestionarioRoboService implements FormatoCuestionarioRoboServiceInterfase {
	
	@Autowired
	@Qualifier("formatoCuestionarioRoboDao")
	FormatoCuestionarioRoboDao formatoCuestionarioRoboDao;

	@Override
	public FormatoCuestionarioRobo objetoFormatoCuestionarioRobo(String id) {
		return this.formatoCuestionarioRoboDao.objetoFormatoCuestionarioRobo(id);
	}

	@Override
	public String ejecutarFuncionInsertarCuestionarioRobo(String crO16Emergencia, String crPregunta13,
			String crPregunta12, String crPregunta11, String crOtros, String crPregunta17, Integer crO16Particular,
			String crPregunta15, String crAsegurado, Integer crBool9, String crPregunta14, String crDirAsegurado,
			Integer crBool29, String crNumSiniestro, String crNumReporte, String crNumPoliza, String crPregunta282,
			String crPregunta281, Integer crBool30, String crClaveAjustador, Integer crBool31, String crPregunta283,
			Integer crEstacionado, String crPregunta24, String crPregunta23, String crPregunta22,
			String crEmailAsegurado, String crPregunta21, String crPregunta27, String crPregunta26, String crPregunta25,
			String crTelCelularAsegurado, String crNumEndoso, Integer crBool8, String crPregunta19, Integer crBool5,
			Integer crO16Carga, String crPregunta18, Integer crBool3, Integer crBool2, String crOcuAsegurado,
			String crPregunta32, Integer crId, String crNomAsegurado, String crPregunta31, String crPregunta30,
			Integer crO16Otros, Integer crBool12, String crPregunta101, String crPregunta4, Integer crBool13,
			String crPregunta3, String crPregunta2, Integer crBool11, String crPregunta1, String crPregunta102,

			String crPregunta7, Integer crBool14, String crPregunta6, Integer crBool15, String crPregunta5,
			String crTelOfiAsegurado, Integer crO16Enseñanza, String crIncAsegurado, String crPregunta29,
			Timestamp crHora, String crNumInciso, String crPregunta82, String crPregunta81, Integer crBool19,
			String crPregunta9, String crPregunta83, Integer crBool27, Integer crBool28, Integer crBool26,
			Integer crBool20, String crTelCasaAsegurado, Integer crO16Publico, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAsegurado

	) {
		return this.formatoCuestionarioRoboDao.ejecutarFuncionInsertarCuestionarioRobo(

				crO16Emergencia, crPregunta13, crPregunta12, crPregunta11, crOtros, crPregunta17, crO16Particular,
				crPregunta15, crAsegurado, crBool9, crPregunta14, crDirAsegurado, crBool29, crNumSiniestro,
				crNumReporte, crNumPoliza, crPregunta282, crPregunta281, crBool30, crClaveAjustador, crBool31,
				crPregunta283, crEstacionado, crPregunta24, crPregunta23, crPregunta22, crEmailAsegurado, crPregunta21,
				crPregunta27, crPregunta26, crPregunta25, crTelCelularAsegurado, crNumEndoso, crBool8, crPregunta19,
				crBool5, crO16Carga, crPregunta18, crBool3, crBool2, crOcuAsegurado, crPregunta32, crId, crNomAsegurado,
				crPregunta31, crPregunta30, crO16Otros, crBool12, crPregunta101, crPregunta4, crBool13, crPregunta3,
				crPregunta2, crBool11, crPregunta1, crPregunta102,

				crPregunta7, crBool14, crPregunta6, crBool15, crPregunta5, crTelOfiAsegurado, crO16Enseñanza,
				crIncAsegurado, crPregunta29, crHora, crNumInciso, crPregunta82, crPregunta81, crBool19, crPregunta9,
				crPregunta83, crBool27, crBool28, crBool26, crBool20, crTelCasaAsegurado, crO16Publico, enviadoEmail, ////
				mensajeEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaAsegurado

		);
	}

	@Override
	public List<FormatoCuestionarioRobo> listaDeFormatoCuestionarioRobo() {
		return this.formatoCuestionarioRoboDao.listaDeFormatoCuestionarioRobo();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoCuestionarioRobo t) {

		return this.formatoCuestionarioRoboDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoCuestionarioRoboDao.obtenerConsecutivo(reporte);

	}
}