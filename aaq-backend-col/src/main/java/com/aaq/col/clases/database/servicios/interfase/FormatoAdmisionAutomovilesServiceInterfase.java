 package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoAdmisionAutomoviles;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoAdmisionAutomovilesServiceInterfase
		extends JMServicioGenericoInterfase<FormatoAdmisionAutomoviles> {

	public abstract FormatoAdmisionAutomoviles objetoFormatoAdmisionAutomoviles(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoAdmisionAutomoviles t);
	public abstract List<FormatoAdmisionAutomoviles> listaDeFormatoAdmisionAutomoviles();
	public abstract String ejecutarFuncionInsertarAdmisionAutomoviles(
			String oaTipoAuto, String oaFolioElectro, String oaNumEndoso, String oaMarcaAuto, String oaEmailCliente,
			String oaDescDanios,
			Integer oaDeducible, String oaNumInciso, String oaNumPoliza, String oaNumReporte, Integer oaTManual,
			String oaPorcentajeDed, String oaNumSerie, String oaSumaAsegurada, Integer oaAdminDeducible,
			String oaNomAjustador, String oaTelCliente, String oaDaniosPre, String oaRazonResponsable,
			String oaNomCliente, String oaRazonTelefono, String oaRazonEnvio, String oaPlacaAuto,
			String oaRazonCobertura, String oaModeloAuto, Timestamp oaFecha, String oaAsegurado, String oaKilometraje,
			String oaCantidad, Integer oaTipoDeducible, String oaClaveAjustador, Integer oaPerdidaTotal,
			String oaRazonDomicilio, String oaNumSiniestro, String oaColorAuto, String oaAgravamiento, Integer oaId,
			Integer oaNivelInundacion, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador,
			String firmaAsegurado, String niu, Integer oaCarrilExpres, Boolean oaDanioMenor);
	public abstract int obtenerConsecutivo(String reporte);
}