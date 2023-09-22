package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoReciboIngresoSiniestro;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoReciboIngresoSiniestroServiceInterfase
		extends JMServicioGenericoInterfase<FormatoReciboIngresoSiniestro> {

	public abstract FormatoReciboIngresoSiniestro objetoFormatoReciboIngresoSiniestro(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoReciboIngresoSiniestro t);
	public abstract List<FormatoReciboIngresoSiniestro> listaDeFormatoReciboIngresoSiniestro();
	public abstract String ejecutarFuncionInsertarReciboIngresoSiniestro(
			String riNumSiniestro, String riFolio, Date riFecha, String riNumPoliza, String riNumInciso,
			String riClaveProv, String riCobertura, String riAjustador, String riRecibimosDe, String riRfc,
			String riEmail, String riTelefono, String riDomicilio, String riCantidad, String riImporteLetra,
			String riConceptoDe, Integer riValores, String riBanco1, String riImporte1, String riAutorizacion1,
			String riNumTarjeta1, String riBanco2, String riImporte2, String riAutorizacion2, String riNumTarjeta2,
			String riBanco3, String riImporte3, String riAutorizacion3, String riNumTarjeta3, String riImporteTotal,
			String riFirmaAsegurado, String riFirmaTercero, String riFirmaAjustador, String riLugarExp,
			String riFirmaRecibido, String ftpRespuesta, Integer enviadoFtp, String mensajesEmail, Integer enviadoEmail,
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, Integer riId, String riNomTercero, String riNomAsegurado,
			Integer cancelado, String riNumReporte, Integer riNumTercero
	);
	public abstract int obtenerConsecutivo(String reporte);

}