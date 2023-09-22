 package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoCargoTarjetaCredito;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoCargoTarjetaCredito;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FormatoCargoTarjetaCreditoDaoInterfase
		extends JMRepositorioGenericoInterfase<FormatoCargoTarjetaCredito> {

	public abstract FormatoCargoTarjetaCredito objetoFormatoCargoTarjetaCredito(final String id);

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
	public abstract String InsertarFormatoCargoTarjetaCredito(DatosInsertarFormatoCargoTarjetaCredito entrada);
	public abstract String ejecutarFuncionWebserviceStoreFCTarjeta(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);

}