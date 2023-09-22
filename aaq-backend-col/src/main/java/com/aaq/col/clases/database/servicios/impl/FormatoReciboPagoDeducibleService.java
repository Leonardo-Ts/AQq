package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoReciboPagoDeducible;
import com.aaq.col.clases.database.repositorios.impl.FormatoReciboPagoDeducibleDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoReciboPagoDeducibleServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoReciboPagoDeducibleService")
@Transactional
public class FormatoReciboPagoDeducibleService implements FormatoReciboPagoDeducibleServiceInterfase {

	@Autowired
	@Qualifier("formatoReciboPagoDeducibleDao")
	FormatoReciboPagoDeducibleDao formatoReciboPagoDeducibleDao;

	@Override
	public FormatoReciboPagoDeducible objetoFormatoReciboPagoDeducible(String id) {
		return this.formatoReciboPagoDeducibleDao.objetoFormatoReciboPagoDeducible(id);
	}

	@Override
	public String ejecutarFuncionInsertarReciboPagoDeducible(String rdNumSiniestro, String rdNumReporte, String rdFolio,
			Date rdFecha, String rdNumPoliza, String rdNumInciso, String rdClave, String rdAjustador,
			String rdRecibimosDe, String rdRfc, String rdEmail, String rdTelefono, String rdDomicilio,
			String rdCantidad, String rdImporteLetra, String rdConceptoDe, Integer rdValores, String rdNumCuenta1,
			String rdNumCuenta2, String rdBanco1, String rdBanco2, String rdImporte1, String rdImporte2,
			String rdAutorizacion1, String rdAutorizacion2, String rdNumTarjeta1, String rdNumTarjeta2,
			String rdBanco1B, String rdBanco2B, String rdImporte1B, String rdImporte2B, String rdImporteTotal,
			String rdLugarExp, String rdFirmaRecibido, Integer check1, Integer check2, Integer check3, Integer check4,
			String ftpRespuesta, Integer enviadoFtp, String mensajesEmail, Integer enviadoEmail, Integer proceso,
			Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer rdId, Integer cancelado

	) {
		return this.formatoReciboPagoDeducibleDao.ejecutarFuncionInsertarReciboPagoDeducible(

				rdNumSiniestro, rdNumReporte, rdFolio, rdFecha, rdNumPoliza, rdNumInciso, rdClave, rdAjustador,
				rdRecibimosDe, rdRfc, rdEmail, rdTelefono, rdDomicilio, rdCantidad, rdImporteLetra, rdConceptoDe,
				rdValores, rdNumCuenta1, rdNumCuenta2, rdBanco1, rdBanco2, rdImporte1, rdImporte2, rdAutorizacion1,
				rdAutorizacion2, rdNumTarjeta1, rdNumTarjeta2, rdBanco1B, rdBanco2B, rdImporte1B, rdImporte2B,
				rdImporteTotal, rdLugarExp, rdFirmaRecibido, check1, check2, check3, check4, ftpRespuesta, enviadoFtp,
				mensajesEmail, enviadoEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, rdId, cancelado

		);
	}

	@Override
	public List<FormatoReciboPagoDeducible> listaDeFormatoReciboPagoDeducible() {
		return this.formatoReciboPagoDeducibleDao.listaDeFormatoReciboPagoDeducible();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoReciboPagoDeducible t) {

		return this.formatoReciboPagoDeducibleDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoReciboPagoDeducibleDao.obtenerConsecutivo(reporte);
	}

}