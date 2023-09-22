package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoGarantiaPrendaria;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoGarantiaPrendaria;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FormatoGarantiaPrendariaDaoInterfase extends JMRepositorioGenericoInterfase<FormatoGarantiaPrendaria> {

	
	public abstract FormatoGarantiaPrendaria objetoFormatoGarantiaPrendaria(final String id);
	public abstract List<FormatoGarantiaPrendaria> listaDeFormatoGarantiaPrendaria();
	public abstract String ejecutarFuncionInsertarGarantia(
			String gpSr, String gpSrCalle, String gpSrColonia, String gpSrMunicipio, String gpSrCp, String gpSrCiudad,
			String gpSrIdentificacion, String gpCantidad, String gpCantidadLetra, String gpMarcaAuto, String gpTipoAuto,
			String gpModeloAuto, String gpPlacasAuto, String gpColorAuto, String gpNumPoliza, String gpBienes,
			String gpFactura, String gpFacturaExpedida, Date gpFacturaFecha, String gpDias, Date gpFecha,
			Date gpFechaFirma, String gpNomDeudor, String gpNomAcreedor, String gpNumReporte, String gpNumInciso,
			String gpClaveAjustador, String gpAsegurado,
			String emailDefault, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaDeudor, String firmaAcreedor
	);
	public abstract String InsertarFormatoGarantiaPrendaria(DatosInsertarFormatoGarantiaPrendaria entrada);
	public abstract String ejecutarFuncionWebserviceStoreFGP(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);

}