package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoReciboPagoDeducible;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoReciboPagoDeducible;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface FormatoReciboPagoDeducibleDaoInterfase
		extends JMRepositorioGenericoInterfase<FormatoReciboPagoDeducible> {

	public abstract FormatoReciboPagoDeducible objetoFormatoReciboPagoDeducible(final String id);
	public abstract List<FormatoReciboPagoDeducible> listaDeFormatoReciboPagoDeducible();
	public abstract String ejecutarFuncionInsertarReciboPagoDeducible(
			String rdNumSiniestro, String rdNumReporte, String rdFolio, Date rdFecha, String rdNumPoliza,
			String rdNumInciso, String rdClave, String rdAjustador, String rdRecibimosDe, String rdRfc, String rdEmail,
			String rdTelefono, String rdDomicilio, String rdCantidad, String rdImporteLetra, String rdConceptoDe,
			Integer rdValores, String rdNumCuenta1, String rdNumCuenta2, String rdBanco1, String rdBanco2,
			String rdImporte1, String rdImporte2, String rdAutorizacion1, String rdAutorizacion2, String rdNumTarjeta1,
			String rdNumTarjeta2, String rdBanco1B, String rdBanco2B, String rdImporte1B, String rdImporte2B,
			String rdImporteTotal, String rdLugarExp, String rdFirmaRecibido, Integer check1, Integer check2,
			Integer check3, Integer check4, String ftpRespuesta, Integer enviadoFtp, String mensajesEmail,
			Integer enviadoEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer rdId, Integer cancelado

	);
	public abstract String InsertarFormatoReciboPagoDeducible(DatosInsertarFormatoReciboPagoDeducible entrada);
	public abstract String ejecutarFuncionWebserviceStoreFRDeducible(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);
}