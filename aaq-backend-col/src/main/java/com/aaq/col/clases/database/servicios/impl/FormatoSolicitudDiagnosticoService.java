package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoSolicitudDiagnostico;
import com.aaq.col.clases.database.repositorios.impl.FormatoSolicitudDiagnosticoDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoSolicitudDiagnosticoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoSolicitudDiagnosticoService")
@Transactional
public class FormatoSolicitudDiagnosticoService implements FormatoSolicitudDiagnosticoServiceInterfase {
	
	@Autowired
	@Qualifier("formatoSolicitudDiagnosticoDao")
	FormatoSolicitudDiagnosticoDao formatoSolicitudDiagnosticoDao;

	@Override
	public FormatoSolicitudDiagnostico objetoFormatoSolicitudDiagnostico(String id) {
		return this.formatoSolicitudDiagnosticoDao.objetoFormatoSolicitudDiagnostico(id);
	}

	@Override
	public String ejecutarFuncionInsertarSolicitudDiagnostico(

			String sdNumReporte, Timestamp sdFecha, String sdNumPoliza, String sdNumEndoso, String sdNumInciso,
			String sdNumSiniestro, String sdNomCliente, String sdEmailCliente, String sdTelCliente, String sdRazonEnvio,
			String sdRazonResponsable, String sdRazonTelefono, String sdRazonDomicilio, String sdRazonCobertura,
			String sdMarcaAuto, String sdTipoAuto, String sdModeloAuto, String sdKilometrajeAuto, String sdNumSerie,
			String sdColorAuto, String sdPlacaAuto, Integer sdTransmision, String sdDaniosUnidad,
			String sdDescripcionDanios, String sdDaniosPre, String sdNomAjustador, String sdClaveAjustador,
			Integer enviadoFtp, String ftpRespuesta, Integer enviadoEmail, String mensajesEmail, Integer proceso,
			Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, Integer check1, Integer check2, Integer check3,
			Integer check4, String firmaAjustador, String firmaAsegurado, String sdOtro, Integer sdNivelInundacion

	) {
		return this.formatoSolicitudDiagnosticoDao.ejecutarFuncionInsertarSolicitudDiagnostico(

				sdNumReporte, sdFecha, sdNumPoliza, sdNumEndoso, sdNumInciso, sdNumSiniestro, sdNomCliente,
				sdEmailCliente, sdTelCliente, sdRazonEnvio, sdRazonResponsable, sdRazonTelefono, sdRazonDomicilio,
				sdRazonCobertura, sdMarcaAuto, sdTipoAuto, sdModeloAuto, sdKilometrajeAuto, sdNumSerie, sdColorAuto,
				sdPlacaAuto, sdTransmision, sdDaniosUnidad, sdDescripcionDanios, sdDaniosPre, sdNomAjustador,
				sdClaveAjustador, enviadoFtp, ftpRespuesta, enviadoEmail, mensajesEmail, proceso, horaEnvioEmail,
				horaEnvioSftp, check1, check2, check3, check4, firmaAjustador, firmaAsegurado, sdOtro, sdNivelInundacion

		);
	}

	@Override
	public List<FormatoSolicitudDiagnostico> listaDeFormatoSolicitudDiagnostico() {
		return this.formatoSolicitudDiagnosticoDao.listaDeFormatoSolicitudDiagnostico();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoSolicitudDiagnostico t) {

		return this.formatoSolicitudDiagnosticoDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoSolicitudDiagnosticoDao.obtenerConsecutivo(reporte);
	}

}