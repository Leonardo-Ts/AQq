package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoInspeccionPesado;
import com.aaq.col.clases.database.repositorios.impl.FormatoInspeccionPesadoDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoInspeccionPesadoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoInspeccionPesadoService")
@Transactional
public class FormatoInspeccionPesadoService implements FormatoInspeccionPesadoServiceInterfase {
	
	@Autowired
	@Qualifier("formatoInspeccionPesadoDao")
	FormatoInspeccionPesadoDao formatoInspeccionPesadoDao;

	@Override
	public FormatoInspeccionPesado objetoFormatoInspeccionPesado(String id) {
		return this.formatoInspeccionPesadoDao.objetoFormatoInspeccionPesado(id);
	}

	@Override
	public String ejecutarFuncionInsertarInspeccionPesado(

			String ipAsegurado, Date ipFecha, Integer ipEquipo, String ipTipo,

			Integer ipPagoSiNo, String ipUbicacion, Date ipDiaHora, Integer ipAdaptaciones, String ipAtencion,
			String ipColor,

			String ipNomAjustador, Integer ipImportacion1,

			Integer ipImportacion2, Integer ipPago, String ipModelo, String ipNumPoliza, Integer ipTipoEncargado,
			String ipEstandarT, Integer ipEquipoSiNo, String ipEmail,

			String ipOficina, String ipNomCliente, Integer ipCalificacion, String ipKilometraje,
			Integer ipAdaptacionesSiNo, Integer ipCirculacion, Integer ipTCirculacion1, Integer ipTCirculacion2,

			String ipTotalFotos, Integer ipDocumentacion1, Integer ipDocumentacion2,

			Integer ipProcedencia, String ipTelefono, String ipPuertasD, Date ipFechaInspeccion,
			Integer ipAseguradoCompa, String ipClaveAjustador, String ipPlacas, String ipCompania, String ipSolicitante,
			String ipNumSerie, String ipObservaciones, Integer ipSalvamentos, String ipNumReporte, String ipNumInciso,
			String ipNumSiniestro, String ipMarca, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaCliente, String firmaAgente

	) {
		return this.formatoInspeccionPesadoDao.ejecutarFuncionInsertarInspeccionPesado(

				ipAsegurado, ipFecha, ipEquipo, ipTipo,

				ipPagoSiNo, ipUbicacion, ipDiaHora, ipAdaptaciones, ipAtencion, ipColor,

				ipNomAjustador, ipImportacion1,

				ipImportacion2, ipPago, ipModelo, ipNumPoliza, ipTipoEncargado, ipEstandarT, ipEquipoSiNo, ipEmail,

				ipOficina, ipNomCliente, ipCalificacion, ipKilometraje, ipAdaptacionesSiNo, ipCirculacion,
				ipTCirculacion1, ipTCirculacion2,

				ipTotalFotos, ipDocumentacion1, ipDocumentacion2,

				ipProcedencia, ipTelefono, ipPuertasD, ipFechaInspeccion, ipAseguradoCompa, ipClaveAjustador, ipPlacas,
				ipCompania, ipSolicitante, ipNumSerie, ipObservaciones, ipSalvamentos, ipNumReporte, ipNumInciso,
				ipNumSiniestro, ipMarca, enviadoEmail, ////
				mensajeEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaCliente, firmaAgente

		);
	}

	@Override
	public List<FormatoInspeccionPesado> listaDeFormatoInspeccionPesado() {
		return this.formatoInspeccionPesadoDao.listaDeFormatoInspeccionPesado();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoInspeccionPesado t) {

		return this.formatoInspeccionPesadoDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoInspeccionPesadoDao.obtenerConsecutivo(reporte);
	}

}