package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoInspeccionMoto;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoInspeccionMotoServiceInterfase extends JMServicioGenericoInterfase<FormatoInspeccionMoto> {

	public abstract FormatoInspeccionMoto objetoFormatoInspeccionMoto(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoInspeccionMoto t);
	public abstract List<FormatoInspeccionMoto> listaDeFormatoInspeccionMoto();
	public abstract String ejecutarFuncionInsertarInspeccionMoto(
			String imNumSerie, Integer imAseguradoCompa, String imCompania,
			String imAsegurado, String imEstandarT, Integer imPago, Integer imAdaptaciones, String imPlacas,
			String imNomAjustador, Integer enviadoEmail, Integer imTCirculacion1, String imMarca, String imNumSiniestro,
			String imTipo, Integer imEquipoSiNo, Integer imImportacion1, String imSolicitante, String imNumReporte,
			String imEmail, String imModelo, String imClaveAjustador, String imUbicacion, String imKilometraje,
			String imTelefono, Integer imTipoEncargado, Date imFecha, Date imFechaInspeccion,
			Integer imAdaptacionesSiNo, String imOficina, Integer imCirculacion, String imColor, Integer imProcedencia,
			String mensajeEmail, Integer imPagoSiNo, Integer imDocumentacion2, Integer imDocumentacion1,
			String imNumInciso, String imNumPoliza, String imTotalFotos, Date imDiaHora, String imObservaciones,
			String imAtencion, String imNomCliente, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp,
			String nodoEnvio, Integer check1, Integer check2, Integer check3, Integer check4, String firmaCliente,
			String firmaAgente );
	public abstract int obtenerConsecutivo(String reporte);

}