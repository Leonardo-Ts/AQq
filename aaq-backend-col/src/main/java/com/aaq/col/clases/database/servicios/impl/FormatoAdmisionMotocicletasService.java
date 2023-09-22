package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoAdmisionMotocicletas;
import com.aaq.col.clases.database.repositorios.impl.FormatoAdmisionMotocicletasDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoAdmisionMotocicletasServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoAdmisionMotocicletasService")
@Transactional
public class FormatoAdmisionMotocicletasService implements FormatoAdmisionMotocicletasServiceInterfase {
	
	@Autowired
	@Qualifier("formatoAdmisionMotocicletasDao")
	FormatoAdmisionMotocicletasDao formatoAdmisionMotocicletasDao;

	@Override
	public FormatoAdmisionMotocicletas objetoFormatoAdmisionMotocicletas(String id) {
		return this.formatoAdmisionMotocicletasDao.objetoFormatoAdmisionMotocicletas(id);
	}

	@Override
	public String ejecutarFuncionInsertarAdmisionMotocicletas(

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
			String mensajeEmail,

			Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio, Integer check1,
			Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado

	) {
		return this.formatoAdmisionMotocicletasDao.ejecutarFuncionInsertarAdmisionMotocicletas(

				oaTipoAuto, oaFolioElectro, oaNumEndoso, oaMarcaAuto, oaEmailCliente, oaDescDanios,

				oaDeducible, oaNumInciso, oaNumPoliza, oaNumReporte, oaTManual, oaPorcentajeDed, oaNumSerie,
				oaSumaAsegurada, oaAdminDeducible, oaNomAjustador, oaTelCliente, oaDaniosPre, oaRazonResponsable,

				oaNomCliente, oaRazonTelefono, oaRazonEnvio, oaPlacaAuto, oaRazonCobertura, oaModeloAuto, oaFecha,
				oaAsegurado, oaKilometraje, oaCantidad, oaTipoDeducible, oaClaveAjustador, oaPerdidaTotal,
				oaRazonDomicilio, oaNumSiniestro, oaColorAuto, oaAgravamiento, oaId, oaNivelInundacion, enviadoEmail, ////
				mensajeEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaAjustador, firmaAsegurado

		);
	}

	@Override
	public List<FormatoAdmisionMotocicletas> listaDeFormatoAdmisionMotocicletas() {
		return this.formatoAdmisionMotocicletasDao.listaDeFormatoAdmisionMotocicletas();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoAdmisionMotocicletas t) {

		return this.formatoAdmisionMotocicletasDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoAdmisionMotocicletasDao.obtenerConsecutivo(reporte);

	}

}