package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoReparacionBienes;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoReparacionBienesServiceInterfase extends JMServicioGenericoInterfase<FormatoReparacionBienes> {

	public FormatoReparacionBienes objetoFormatoReparacionBienes(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoReparacionBienes t);
	public abstract List<FormatoReparacionBienes> listaDeFormatoReparacionBienes();
	public abstract String ejecutarFuncionInsertarReparacionBienes(
			Date fechaHora, String rbAsegurado, String rbCarMarca, String rbCarModelo, String rbClaveAjustador,
			Integer rbCuerpoA, String rbDanios, Integer rbDaniosPre, String rbDesDanios, String rbDomAfectado,
			String rbEmailRepara, String rbFolioElectro, String rbKm, String rbMaterial, String rbMedAlto,
			String rbMedAncho, String rbMedLong, String rbNomAfectado, String rbNomAjustador, String rbNomRepara,
			String rbNumEndoso, String rbNumFotos, String rbNumInciso, String rbNumPoliza, String rbNumReporte,
			String rbNumSiniestro, String rbObservaciones, String rbOtros, String rbRepreAfectado, String rbTelAfectado,
			String rbTelRepara, String rbTramo, String rbNomAsegurado, String rbMunicipio, String rbEstado,
			Integer enviadoEmail, ////
			String mensajeEmail, ///
			String rbEmailAfectado, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp,
			String nodoEnvio, Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador,
			String firmaAsegurado
	);
	public abstract int obtenerConsecutivo(String reporte);

}