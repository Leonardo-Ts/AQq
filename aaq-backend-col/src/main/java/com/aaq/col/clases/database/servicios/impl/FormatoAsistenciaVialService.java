package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoAsistenciaVial;
import com.aaq.col.clases.database.repositorios.impl.FormatoAsistenciaVialDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoAsistenciaVialServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoAsistenciaVialService")
@Transactional
public class FormatoAsistenciaVialService implements FormatoAsistenciaVialServiceInterfase {
	
	@Autowired
	@Qualifier("formatoAsistenciaVialDao")
	FormatoAsistenciaVialDao formatoAsistenciaVialDao;

	@Override
	public FormatoAsistenciaVial objetoFormatoAsistenciaVial(String id) {
		return this.formatoAsistenciaVialDao.objetoFormatoAsistenciaVial(id);
	}

	@Override
	public String ejecutarFuncionInsertarAsistenciaVial(

			String avAsegurado, String avNumInciso, String avNomAsegurado, Date avFecha, String avNumPoliza,
			String avClaveAjustador, String avEmail, Integer avPregunta6, String avPregunta5, Integer avPregunta4,
			Integer avPregunta3, Integer avPregunta2, Integer avPregunta1, String avNumReporte, Integer avId,
			String avComentarios, Integer avPregunta7, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado

	) {
		return this.formatoAsistenciaVialDao.ejecutarFuncionInsertarAsistenciaVial(

				avAsegurado, avNumInciso, avNomAsegurado, avFecha, avNumPoliza, avClaveAjustador, avEmail, avPregunta6,
				avPregunta5, avPregunta4, avPregunta3, avPregunta2, avPregunta1, avNumReporte, avId, avComentarios,
				avPregunta7, enviadoEmail, ////
				mensajeEmail,

				proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaAjustador,
				firmaAsegurado

		);
	}

	@Override
	public List<FormatoAsistenciaVial> listaDeFormatoAsistenciaVial() {
		return this.formatoAsistenciaVialDao.listaDeFormatoAsistenciaVial();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoAsistenciaVial t) {

		return this.formatoAsistenciaVialDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoAsistenciaVialDao.obtenerConsecutivo(reporte);

	}

}