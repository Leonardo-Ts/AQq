package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoAdmisionMotocicletas;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoAdmisionMotocicletas;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FormatoAdmisionMotocicletasDaoInterfase
		extends JMRepositorioGenericoInterfase<FormatoAdmisionMotocicletas> {

	public abstract FormatoAdmisionMotocicletas objetoFormatoAdmisionMotocicletas(final String id);
	public abstract List<FormatoAdmisionMotocicletas> listaDeFormatoAdmisionMotocicletas();
	public abstract String ejecutarFuncionInsertarAdmisionMotocicletas(

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
			String mensajeEmail, ///
			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado

	);

	public abstract String InsertarFormatoAdmisionMotocicletas(DatosInsertarFormatoAdmisionMotocicletas entrada);
	public abstract String ejecutarFuncionWebserviceStoreFAM(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);

}