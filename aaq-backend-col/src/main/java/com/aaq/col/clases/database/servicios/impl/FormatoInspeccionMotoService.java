package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoInspeccionMoto;
import com.aaq.col.clases.database.repositorios.impl.FormatoInspeccionMotoDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoInspeccionMotoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoInspeccionMotoService")
@Transactional
public class FormatoInspeccionMotoService implements FormatoInspeccionMotoServiceInterfase {
	
	@Autowired
	@Qualifier("formatoInspeccionMotoDao")
	FormatoInspeccionMotoDao formatoInspeccionMotoDao;

	@Override
	public FormatoInspeccionMoto objetoFormatoInspeccionMoto(String id) {
		return this.formatoInspeccionMotoDao.objetoFormatoInspeccionMoto(id);
	}

	@Override
	public String ejecutarFuncionInsertarInspeccionMoto(

			String imNumSerie, Integer imAseguradoCompa, String imCompania,

			String imAsegurado, String imEstandarT, Integer imPago, Integer imAdaptaciones, String imPlacas,

			String imNomAjustador, Integer enviadoEmail, Integer imTCirculacion1, String imMarca, String imNumSiniestro,
			String imTipo, Integer imEquipoSiNo, Integer imImportacion1, String imSolicitante, String imNumReporte,
			String imEmail, String imModelo, String imClaveAjustador, String imUbicacion,

			String imKilometraje, String imTelefono, Integer imTipoEncargado, Date imFecha, Date imFechaInspeccion,
			Integer imAdaptacionesSiNo, String imOficina, Integer imCirculacion, String imColor, Integer imProcedencia,
			String mensajeEmail, Integer imPagoSiNo, Integer imDocumentacion2, Integer imDocumentacion1,
			String imNumInciso,

			String imNumPoliza,

			String imTotalFotos, Date imDiaHora, String imObservaciones, String imAtencion, String imNomCliente,
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaCliente, String firmaAgente

	) {
		return this.formatoInspeccionMotoDao.ejecutarFuncionInsertarInspeccionMoto(

				imNumSerie, imAseguradoCompa, imCompania,

				imAsegurado, imEstandarT, imPago, imAdaptaciones, imPlacas,

				imNomAjustador, enviadoEmail, imTCirculacion1, imMarca, imNumSiniestro, imTipo, imEquipoSiNo,
				imImportacion1, imSolicitante, imNumReporte, imEmail, imModelo, imClaveAjustador, imUbicacion,

				imKilometraje, imTelefono, imTipoEncargado, imFecha, imFechaInspeccion, imAdaptacionesSiNo, imOficina,
				imCirculacion, imColor, imProcedencia, mensajeEmail, imPagoSiNo, imDocumentacion2, imDocumentacion1,
				imNumInciso,

				imNumPoliza,

				imTotalFotos, imDiaHora, imObservaciones, imAtencion, imNomCliente, proceso, horaEnvioEmail,
				horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, firmaCliente, firmaAgente

		);
	}

	@Override
	public List<FormatoInspeccionMoto> listaDeFormatoInspeccionMoto() {
		return this.formatoInspeccionMotoDao.listaDeFormatoInspeccionMoto();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoInspeccionMoto t) {

		return this.formatoInspeccionMotoDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoInspeccionMotoDao.obtenerConsecutivo(reporte);
	}

}