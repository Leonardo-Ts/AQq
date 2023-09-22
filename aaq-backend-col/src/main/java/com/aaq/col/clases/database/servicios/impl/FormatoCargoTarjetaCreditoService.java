package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoCargoTarjetaCredito;
import com.aaq.col.clases.database.repositorios.impl.FormatoCargoTarjetaCreditoDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoCargoTarjetaCreditoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoCargoTarjetaCreditoService")
@Transactional
public class FormatoCargoTarjetaCreditoService implements FormatoCargoTarjetaCreditoServiceInterfase {
	
	@Autowired
	@Qualifier("formatoCargoTarjetaCreditoDao")
	FormatoCargoTarjetaCreditoDao formatoCargoTarjetaCreditoDao;

	@Override
	public FormatoCargoTarjetaCredito objetoFormatoCargoTarjetaCredito(String id) {
		return this.formatoCargoTarjetaCreditoDao.objetoFormatoCargoTarjetaCredito(id);
	}

	@Override
	public String ejecutarFuncionInsertarCargoTarjetaCredito(
			 String tcNumReporte,
			 String tcNumSiniestro,
			 String tcNumAsegurado,
			 String tcNumAutorizacion,
			 String tcNombre,
			 Date tcFecha,
			 String tcDireccion,
			 String tcEstado,
			 String tcCp,
			 String tcTelefono,
			 String tcCantidadAutorizada,
			 Integer tcPagoOpcion,
			 String tcNumTarjeta,
			 String tcVencimientoTarjeta,
			 String tcClaveAjustador,
			 String firmaTarjetahabiente,		
			 Integer enviadoEmail,
			 String mensajeEmail,
			 Integer proceso,
			 Timestamp horaEnvioEmail,
			 Timestamp horaEnvioSftp,
			 String nodoEnvio,
			 Integer check1,
			 Integer check2,
			 Integer check3,
			 Integer check4,
			 String tcNumPoliza,
			 String tcCorreo

	) {
		return this.formatoCargoTarjetaCreditoDao.ejecutarFuncionInsertarCargoTarjetaCredito(
				  tcNumReporte,
				  tcNumSiniestro,
				  tcNumAsegurado,
				  tcNumAutorizacion,
				  tcNombre,
				  tcFecha,
				  tcDireccion,
				  tcEstado,
				  tcCp,
				  tcTelefono,
				  tcCantidadAutorizada,
				  tcPagoOpcion,
				  tcNumTarjeta,
				  tcVencimientoTarjeta,
				  tcClaveAjustador,
				  firmaTarjetahabiente,			
				  enviadoEmail,
				  mensajeEmail,
				  proceso,
				  horaEnvioEmail,
				  horaEnvioSftp,
				  nodoEnvio,
				  check1,
				  check2,
				  check3,
				  check4,
				  tcNumPoliza,
				  tcCorreo

		);
	}

	
	@Override
	public List<FormatoCargoTarjetaCredito> listaDeFormatoCargoTarjetaCredito() {
		return this.formatoCargoTarjetaCreditoDao.listaDeFormatoCargoTarjetaCredito();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoCargoTarjetaCredito t) {

		return this.formatoCargoTarjetaCreditoDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoCargoTarjetaCreditoDao.obtenerConsecutivo(reporte);

	}
}