package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoCuestionarioRobo;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoCuestionarioRoboServiceInterfase extends JMServicioGenericoInterfase<FormatoCuestionarioRobo> {

	public abstract FormatoCuestionarioRobo objetoFormatoCuestionarioRobo(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoCuestionarioRobo t);
	public abstract List<FormatoCuestionarioRobo> listaDeFormatoCuestionarioRobo();
	public abstract String ejecutarFuncionInsertarCuestionarioRobo(String crO16Emergencia, String crPregunta13,
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

	);

	public abstract int obtenerConsecutivo(String reporte);

}