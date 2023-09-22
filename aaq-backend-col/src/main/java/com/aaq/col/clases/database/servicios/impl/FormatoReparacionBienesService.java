package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoReparacionBienes;
import com.aaq.col.clases.database.repositorios.impl.FormatoReparacionBienesDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoReparacionBienesServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoReparacionBienesService")
@Transactional
public class FormatoReparacionBienesService implements FormatoReparacionBienesServiceInterfase {
	
	@Autowired
	@Qualifier("formatoReparacionBienesDao")
	FormatoReparacionBienesDao formatoReparacionBienesDao;

	@Override
	public FormatoReparacionBienes objetoFormatoReparacionBienes(String id) {
		return this.formatoReparacionBienesDao.objetoFormatoReparacionBienes(id);
	}

	@Override
	public String ejecutarFuncionInsertarReparacionBienes(

			Date fechaHora, String rbAsegurado, String rbCarMarca, String rbCarModelo, String rbClaveAjustador,
			Integer rbCuerpoA, String rbDanios, Integer rbDaniosPre, String rbDesDanios, String rbDomAfectado,
			String rbEmailRepara,

			String rbFolioElectro,

			String rbKm, String rbMaterial, String rbMedAlto, String rbMedAncho, String rbMedLong, String rbNomAfectado,
			String rbNomAjustador, String rbNomRepara, String rbNumEndoso, String rbNumFotos, String rbNumInciso,
			String rbNumPoliza, String rbNumReporte, String rbNumSiniestro, String rbObservaciones, String rbOtros,
			String rbRepreAfectado, String rbTelAfectado, String rbTelRepara,

			String rbTramo, String rbNomAsegurado, String rbMunicipio, String rbEstado,

			Integer enviadoEmail, ////
			String mensajeEmail, ///
			String rbEmailAfectado, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp,
			String nodoEnvio, Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador,
			String firmaAsegurado

	) {
		return this.formatoReparacionBienesDao.ejecutarFuncionInsertarReparacionBienes(

				fechaHora, rbAsegurado, rbCarMarca, rbCarModelo, rbClaveAjustador, rbCuerpoA, rbDanios, rbDaniosPre,
				rbDesDanios, rbDomAfectado, rbEmailRepara, rbFolioElectro, rbKm, rbMaterial, rbMedAlto, rbMedAncho,
				rbMedLong, rbNomAfectado, rbNomAjustador, rbNomRepara, rbNumEndoso, rbNumFotos, rbNumInciso,
				rbNumPoliza, rbNumReporte, rbNumSiniestro, rbObservaciones, rbOtros, rbRepreAfectado, rbTelAfectado,
				rbTelRepara, rbTramo, rbNomAsegurado, rbMunicipio, rbEstado, enviadoEmail, ////
				mensajeEmail, ///
				rbEmailAfectado, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaAjustador, firmaAsegurado

		);
	}

	@Override
	public List<FormatoReparacionBienes> listaDeFormatoReparacionBienes() {
		return this.formatoReparacionBienesDao.listaDeFormatoReparacionBienes();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoReparacionBienes t) {

		return this.formatoReparacionBienesDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoReparacionBienesDao.obtenerConsecutivo(reporte);
	}

}