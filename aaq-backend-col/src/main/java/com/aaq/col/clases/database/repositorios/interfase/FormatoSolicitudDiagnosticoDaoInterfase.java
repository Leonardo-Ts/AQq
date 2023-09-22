package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoSolicitudDiagnostico;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoSolicitudDiagnostico;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
public interface FormatoSolicitudDiagnosticoDaoInterfase
		extends JMRepositorioGenericoInterfase<FormatoSolicitudDiagnostico> {

	public abstract FormatoSolicitudDiagnostico objetoFormatoSolicitudDiagnostico(final String id);
	public abstract List<FormatoSolicitudDiagnostico> listaDeFormatoSolicitudDiagnostico();
	public abstract String ejecutarFuncionInsertarSolicitudDiagnostico(
			String sdNumReporte, Timestamp sdFecha,
			String sdNumPoliza, String sdNumEndoso, String sdNumInciso,
			String sdNumSiniestro, String sdNomCliente, String sdEmailCliente, String sdTelCliente, String sdRazonEnvio,
			String sdRazonResponsable, String sdRazonTelefono, String sdRazonDomicilio, String sdRazonCobertura,
			String sdMarcaAuto, String sdTipoAuto, String sdModeloAuto,
			String sdKilometrajeAuto, String sdNumSerie, String sdColorAuto, String sdPlacaAuto, Integer sdTransmision,
			String sdDaniosUnidad, String sdDescripcionDanios,
			String sdDaniosPre, String sdNomAjustador, String sdClaveAjustador, Integer enviadoFtp, String ftpRespuesta,
			Integer enviadoEmail, String mensajesEmail, Integer proceso, Timestamp horaEnvioEmail,
			Timestamp horaEnvioSftp, Integer check1, Integer check2, Integer check3, Integer check4,
			String firmaAjustador, String firmaAsegurado, String sdOtro, Integer sdNivelInundacion
	);
	public abstract String InsertarFormatoSolicitudDiagnostico(DatosInsertarFormatoSolicitudDiagnostico entrada);
	public abstract String ejecutarFuncionWebserviceStoreFSD(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);

}