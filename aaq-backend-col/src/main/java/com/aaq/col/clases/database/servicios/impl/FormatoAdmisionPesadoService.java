package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoAdmisionPesado;
import com.aaq.col.clases.database.repositorios.impl.FormatoAdmisionPesadoDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoAdmisionPesadoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoAdmisionPesadoService")
@Transactional
public class FormatoAdmisionPesadoService implements FormatoAdmisionPesadoServiceInterfase {
	
	@Autowired
	@Qualifier("formatoAdmisionPesadoDao")
	FormatoAdmisionPesadoDao formatoAdmisionPesadoDao;

	@Override
	public FormatoAdmisionPesado objetoFormatoAdmisionPesado(String id) {
		return this.formatoAdmisionPesadoDao.objetoFormatoAdmisionPesado(id);
	}

	@Override
	public String ejecutarFuncionInsertarAdmisionPesado(

			String opTelAsegurado, String opSiniestroCaja, String opNumEndoso, String opPlacasAutoAfe,
			String opNomAjustador, String opSerieAutoAfe, String opColorAutoAfe, String opNomTaller, String opModeloTer,
			Timestamp ofFecha, String opMotorAutoAse, String opMarcaAutoAfe, String opPlacasAutoAse,
			String opDaniosTanque, String opDirTaller, String opConductorAfe, String opCantidad, String opNumReporte,

			String opSiniestroTanque, String opTelTaller, String opFolioElectro, String opColorAutoAse,
			String opAsegurado, String opClaveAjustador, String opMarcaAutoAse, String opDedDias,
			String opAtencionTaller, String opDefinicion, String opDaniosCamion, String opSumaAsegurado,
			String opSerieAutoAse, String opTipoAutoAse, String opModeloAse, String opNumSiniestro,
			Timestamp opVigencia, String opNumPoliza, String opDaniosCaja, String opTelConAfe, Integer opTipoDeducible,

			String opNumInciso, Integer opDeducible, String opTipoAutoAfe, Integer opDedAdmin, String opSiniestroCamion,

			String opNomAsegurado, Integer opId, String opConductorAse, String opNomAfe, String opTelConAse,
			String opTelAfe,

			String opMotorAutoAfe, String emailDefault, Integer enviadoEmail, ////
			String mensajeEmail, ///
			String opEmailTercero, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador,
			String firmaAsegurado, String niu

	) {
		return this.formatoAdmisionPesadoDao.ejecutarFuncionInsertarAdmisionPesado(

				opTelAsegurado, opSiniestroCaja, opNumEndoso, opPlacasAutoAfe, opNomAjustador, opSerieAutoAfe,
				opColorAutoAfe, opNomTaller, opModeloTer, ofFecha, opMotorAutoAse, opMarcaAutoAfe, opPlacasAutoAse,
				opDaniosTanque, opDirTaller, opConductorAfe, opCantidad, opNumReporte,

				opSiniestroTanque, opTelTaller, opFolioElectro, opColorAutoAse, opAsegurado, opClaveAjustador,
				opMarcaAutoAse, opDedDias, opAtencionTaller, opDefinicion, opDaniosCamion, opSumaAsegurado,
				opSerieAutoAse, opTipoAutoAse, opModeloAse, opNumSiniestro, opVigencia, opNumPoliza, opDaniosCaja,
				opTelConAfe, opTipoDeducible,

				opNumInciso, opDeducible, opTipoAutoAfe, opDedAdmin, opSiniestroCamion,

				opNomAsegurado, opId, opConductorAse, opNomAfe, opTelConAse, opTelAfe,

				opMotorAutoAfe, emailDefault, enviadoEmail, ////
				mensajeEmail, ///
				opEmailTercero, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaAjustador, firmaAsegurado, niu

		);
	}

	@Override
	public List<FormatoAdmisionPesado> listaDeFormatoAdmisionPesado() {
		return this.formatoAdmisionPesadoDao.listaDeFormatoAdmisionPesado();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoAdmisionPesado t) {

		return this.formatoAdmisionPesadoDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoAdmisionPesadoDao.obtenerConsecutivo(reporte);

	}

}