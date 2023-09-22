package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoAdmisionPesado;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoAdmisionPesado;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FormatoAdmisionPesadoDaoInterfase extends JMRepositorioGenericoInterfase<FormatoAdmisionPesado> {

	
	public abstract FormatoAdmisionPesado objetoFormatoAdmisionPesado(final String id);
	public abstract List<FormatoAdmisionPesado> listaDeFormatoAdmisionPesado();
	public abstract String ejecutarFuncionInsertarAdmisionPesado(

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

	);
	public abstract String InsertarFormatoAdmisionPesado(DatosInsertarFormatoAdmisionPesado entrada);
	public abstract String ejecutarFuncionWebserviceStoreFAP(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte);

}