 package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoCargoTarjetaCredito;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoCargoTarjetaCreditoServiceInterfase
		extends JMServicioGenericoInterfase<FormatoCargoTarjetaCredito> {
	public abstract FormatoCargoTarjetaCredito objetoFormatoCargoTarjetaCredito(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoCargoTarjetaCredito t);
	public abstract List<FormatoCargoTarjetaCredito> listaDeFormatoCargoTarjetaCredito();
	public abstract String ejecutarFuncionInsertarCargoTarjetaCredito(
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
	);
	public abstract int obtenerConsecutivo(String reporte);
}