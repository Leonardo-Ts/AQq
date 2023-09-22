package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoEncuestaServicio;
import com.aaq.col.clases.database.repositorios.impl.FormatoEncuestaServicioDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoEncuestaServicioServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoEncuestaServicioService")
@Transactional
public class FormatoEncuestaServicioService implements FormatoEncuestaServicioServiceInterfase {
	
	@Autowired
	@Qualifier("formatoEncuestaServicioDao")
	FormatoEncuestaServicioDao formatoEncuestaServicioDao;

	@Override
	public FormatoEncuestaServicio objetoFormatoEncuestaServicio(String id) {
		return this.formatoEncuestaServicioDao.objetoFormatoEncuestaServicio(id);
	}

	@Override
	public String ejecutarFuncionInsertarEncuestaServicio(

			String esTelConductor, Integer esId, String esNumSiniestro, String esNumReporte, String esNomAsegurado,

			String esLugar, String esClaveAjustador, Integer esPregunta8, Integer esPregunta9, Integer esPregunta6,
			String esNomConductor, Integer esPregunta7, Integer esPregunta4, Integer esPregunta5, Integer esPregunta2,
			Integer esPregunta3, Integer esPregunta1, String esNumInciso, String esNumPoliza, String esAsegurado,
			Date esFecha, Integer esPregunta10, String esObservaciones, String esEmailConductor, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAsegurado) {
		return this.formatoEncuestaServicioDao.ejecutarFuncionInsertarEncuestaServicio(

				esTelConductor, esId, esNumSiniestro, esNumReporte, esNomAsegurado,

				esLugar, esClaveAjustador, esPregunta8, esPregunta9, esPregunta6, esNomConductor, esPregunta7,
				esPregunta4, esPregunta5, esPregunta2, esPregunta3, esPregunta1, esNumInciso, esNumPoliza, esAsegurado,
				esFecha, esPregunta10, esObservaciones, esEmailConductor, enviadoEmail, ////
				mensajeEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaAsegurado

		);
	}

	@Override
	public List<FormatoEncuestaServicio> listaDeFormatoEncuestaServicio() {
		return this.formatoEncuestaServicioDao.listaDeFormatoEncuestaServicio();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoEncuestaServicio t) {

		return this.formatoEncuestaServicioDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoEncuestaServicioDao.obtenerConsecutivo(reporte);

	}

}