package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoGarantiaPrendaria;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoGarantiaPrendariaServiceInterfase
		extends JMServicioGenericoInterfase<FormatoGarantiaPrendaria> {

	public abstract FormatoGarantiaPrendaria objetoFormatoGarantiaPrendaria(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoGarantiaPrendaria t);
	public abstract List<FormatoGarantiaPrendaria> listaDeFormatoGarantiaPrendaria();
	public abstract String ejecutarFuncionInsertarGarantia(String gpSr, String gpSrCalle, String gpSrColonia,
			String gpSrMunicipio, String gpSrCp, String gpSrCiudad, String gpSrIdentificacion, String gpCantidad,
			String gpCantidadLetra, String gpMarcaAuto, String gpTipoAuto, String gpModeloAuto, String gpPlacasAuto,
			String gpColorAuto, String gpNumPoliza, String gpBienes, String gpFactura, String gpFacturaExpedida,
			Date gpFacturaFecha, String gpDias, Date gpFecha, Date gpFechaFirma, String gpNomDeudor,
			String gpNomAcreedor, String gpNumReporte, String gpNumInciso, String gpClaveAjustador, String gpAsegurado,
			String emailDefault, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaDeudor, String firmaAcreedor
	);
	public abstract int obtenerConsecutivo(String reporte);

}