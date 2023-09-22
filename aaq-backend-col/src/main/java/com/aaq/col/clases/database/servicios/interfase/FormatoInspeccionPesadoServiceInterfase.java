package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoInspeccionPesado;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoInspeccionPesadoServiceInterfase extends JMServicioGenericoInterfase<FormatoInspeccionPesado> {

	public abstract FormatoInspeccionPesado objetoFormatoInspeccionPesado(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoInspeccionPesado t);
	public abstract List<FormatoInspeccionPesado> listaDeFormatoInspeccionPesado();
	public abstract String ejecutarFuncionInsertarInspeccionPesado(
			String ipAsegurado, Date ipFecha, Integer ipEquipo, String ipTipo, Integer ipPagoSiNo, String ipUbicacion,
			Date ipDiaHora, Integer ipAdaptaciones, String ipAtencion, String ipColor, String ipNomAjustador,
			Integer ipImportacion1, Integer ipImportacion2, Integer ipPago, String ipModelo, String ipNumPoliza,
			Integer ipTipoEncargado, String ipEstandarT, Integer ipEquipoSiNo, String ipEmail, String ipOficina,
			String ipNomCliente, Integer ipCalificacion, String ipKilometraje, Integer ipAdaptacionesSiNo,
			Integer ipCirculacion, Integer ipTCirculacion1, Integer ipTCirculacion2, String ipTotalFotos,
			Integer ipDocumentacion1, Integer ipDocumentacion2, Integer ipProcedencia, String ipTelefono,
			String ipPuertasD, Date ipFechaInspeccion, Integer ipAseguradoCompa, String ipClaveAjustador,
			String ipPlacas, String ipCompania, String ipSolicitante, String ipNumSerie, String ipObservaciones,
			Integer ipSalvamentos, String ipNumReporte, String ipNumInciso, String ipNumSiniestro, String ipMarca,
			Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaCliente, String firmaAgente
	);
	public abstract int obtenerConsecutivo(String reporte);

}