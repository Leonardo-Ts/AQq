package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoGarantiaPrendaria;
import com.aaq.col.clases.database.repositorios.impl.FormatoGarantiaPrendariaDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoGarantiaPrendariaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoGarantiaPrendariaService")
@Transactional
public class FormatoGarantiaPrendariaService implements FormatoGarantiaPrendariaServiceInterfase {
	
	@Autowired
	@Qualifier("formatoGarantiaPrendariaDao")
	FormatoGarantiaPrendariaDao formatoGarantiaPrendariaDao;

	@Override
	public FormatoGarantiaPrendaria objetoFormatoGarantiaPrendaria(String id) {
		return this.formatoGarantiaPrendariaDao.objetoFormatoGarantiaPrendaria(id);
	}

	@Override
	public String ejecutarFuncionInsertarGarantia(

			String gpSr, String gpSrCalle, String gpSrColonia, String gpSrMunicipio, String gpSrCp, String gpSrCiudad,
			String gpSrIdentificacion, String gpCantidad, String gpCantidadLetra, String gpMarcaAuto, String gpTipoAuto,
			String gpModeloAuto, String gpPlacasAuto, String gpColorAuto, String gpNumPoliza, String gpBienes,
			String gpFactura, String gpFacturaExpedida, Date gpFacturaFecha, String gpDias, Date gpFecha,
			Date gpFechaFirma, String gpNomDeudor, String gpNomAcreedor, String gpNumReporte, String gpNumInciso,
			String gpClaveAjustador, String gpAsegurado,

			String emailDefault, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaDeudor, String firmaAcreedor

	) {
		return this.formatoGarantiaPrendariaDao.ejecutarFuncionInsertarGarantia(gpSr, gpSrCalle, gpSrColonia,
				gpSrMunicipio, gpSrCp, gpSrCiudad, gpSrIdentificacion, gpCantidad, gpCantidadLetra, gpMarcaAuto,
				gpTipoAuto, gpModeloAuto, gpPlacasAuto, gpColorAuto, gpNumPoliza, gpBienes, gpFactura,
				gpFacturaExpedida, gpFacturaFecha, gpDias, gpFecha, gpFechaFirma, gpNomDeudor, gpNomAcreedor,
				gpNumReporte, gpNumInciso, gpClaveAjustador, gpAsegurado,

				emailDefault, enviadoEmail, ////
				mensajeEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaDeudor, firmaAcreedor

		);
	}

	@Override
	public List<FormatoGarantiaPrendaria> listaDeFormatoGarantiaPrendaria() {
		return this.formatoGarantiaPrendariaDao.listaDeFormatoGarantiaPrendaria();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoGarantiaPrendaria t) {
		return this.formatoGarantiaPrendariaDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoGarantiaPrendariaDao.obtenerConsecutivo(reporte);
	}

}