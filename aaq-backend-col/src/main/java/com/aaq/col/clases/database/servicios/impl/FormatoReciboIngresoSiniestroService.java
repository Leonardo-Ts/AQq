package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoReciboIngresoSiniestro;
import com.aaq.col.clases.database.repositorios.impl.FormatoReciboIngresoSiniestroDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoReciboIngresoSiniestroServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoReciboIngresoSiniestroService")
@Transactional
public class FormatoReciboIngresoSiniestroService implements FormatoReciboIngresoSiniestroServiceInterfase {
	
	@Autowired
	@Qualifier("formatoReciboIngresoSiniestroDao")
	FormatoReciboIngresoSiniestroDao formatoReciboIngresoSiniestroDao;

	@Override
	public FormatoReciboIngresoSiniestro objetoFormatoReciboIngresoSiniestro(String id) {
		return this.formatoReciboIngresoSiniestroDao.objetoFormatoReciboIngresoSiniestro(id);
	}

	@Override
	public String ejecutarFuncionInsertarReciboIngresoSiniestro(String riNumSiniestro, String riFolio, Date riFecha,
			String riNumPoliza, String riNumInciso, String riClaveProv, String riCobertura, String riAjustador,
			String riRecibimosDe, String riRfc, String riEmail, String riTelefono, String riDomicilio,
			String riCantidad, String riImporteLetra, String riConceptoDe, Integer riValores, String riBanco1,
			String riImporte1, String riAutorizacion1, String riNumTarjeta1, String riBanco2, String riImporte2,
			String riAutorizacion2, String riNumTarjeta2, String riBanco3, String riImporte3, String riAutorizacion3,
			String riNumTarjeta3, String riImporteTotal, String riFirmaAsegurado, String riFirmaTercero,
			String riFirmaAjustador, String riLugarExp, String riFirmaRecibido, String ftpRespuesta, Integer enviadoFtp,
			String mensajesEmail, Integer enviadoEmail, Integer proceso, Timestamp horaEnvioEmail,
			Timestamp horaEnvioSftp, String nodoEnvio, Integer check1, Integer check2, Integer check3, Integer check4,
			Integer riId, String riNomTercero, String riNomAsegurado, Integer cancelado, String riNumReporte,
			Integer riNumTercero

	) {
		return this.formatoReciboIngresoSiniestroDao.ejecutarFuncionInsertarReciboIngresoSiniestro(

				riNumSiniestro, riFolio, riFecha, riNumPoliza, riNumInciso, riClaveProv, riCobertura, riAjustador,
				riRecibimosDe, riRfc, riEmail, riTelefono, riDomicilio, riCantidad, riImporteLetra, riConceptoDe,
				riValores, riBanco1, riImporte1, riAutorizacion1, riNumTarjeta1, riBanco2, riImporte2, riAutorizacion2,
				riNumTarjeta2, riBanco3, riImporte3, riAutorizacion3, riNumTarjeta3, riImporteTotal, riFirmaAsegurado,
				riFirmaTercero, riFirmaAjustador, riLugarExp, riFirmaRecibido, ftpRespuesta, enviadoFtp, mensajesEmail,
				enviadoEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4, riId,
				riNomTercero, riNomAsegurado, cancelado, riNumReporte, riNumTercero

		);
	}

	@Override
	public List<FormatoReciboIngresoSiniestro> listaDeFormatoReciboIngresoSiniestro() {
		return this.formatoReciboIngresoSiniestroDao.listaDeFormatoReciboIngresoSiniestro();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoReciboIngresoSiniestro t) {

		return this.formatoReciboIngresoSiniestroDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoReciboIngresoSiniestroDao.obtenerConsecutivo(reporte);
	}

}