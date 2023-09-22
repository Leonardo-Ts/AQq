package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoSolicitudDiagnostico;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoSolicitudDiagnosticoServiceInterfase
		extends JMServicioGenericoInterfase<FormatoSolicitudDiagnostico> {

	public abstract FormatoSolicitudDiagnostico objetoFormatoSolicitudDiagnostico(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoSolicitudDiagnostico t);
	public abstract List<FormatoSolicitudDiagnostico> listaDeFormatoSolicitudDiagnostico();
	public abstract String ejecutarFuncionInsertarSolicitudDiagnostico(
			String sdNumReporte, Timestamp sdFecha,
			String sdNumPoliza, String sdNumEndoso, String sdNumInciso,
			String sdNumSiniestro, String sdNomCliente, String sdEmailCliente, String sdTelCliente, String sdRazonEnvio,
			String sdRazonResponsable, String sdRazonTelefono, String sdRazonDomicilio, String sdRazonCobertura,
			String sdMarcaAuto, String sdTipoAuto, String sdModeloAuto, String sdKilometrajeAuto, String sdNumSerie,
			String sdColorAuto, String sdPlacaAuto, Integer sdTransmision, String sdDaniosUnidad,
			String sdDescripcionDanios, String sdDaniosPre, String sdNomAjustador, String sdClaveAjustador,
			Integer enviadoFtp, String ftpRespuesta, Integer enviadoEmail, String mensajesEmail, Integer proceso,
			Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, Integer check1, Integer check2, Integer check3,
			Integer check4, String firmaAjustador, String firmaAsegurado, String sdOtro, Integer sdNivelInundacion
	);
	public abstract int obtenerConsecutivo(String reporte);

}