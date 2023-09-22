package com.aaq.col.clases.database.repositorios.interfase;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.FormatoPaseMedico;
import com.aaq.col.clases.sac.model.DatosInsertarFormatoPaseMedico;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface FormatoPaseMedicoDaoInterfase extends JMRepositorioGenericoInterfase<FormatoPaseMedico> {

	public abstract FormatoPaseMedico objetoFormatoPaseMedico(final String id);
	public abstract List<FormatoPaseMedico> listaDeFormatoPaseMedico();
	public abstract String ejecutarFuncionInsertarMedico(
			String pmNombreAjustador, String pmNomMedico, String pmOtraLesion, String pmTelClinica,
			Integer pmLugarEmision, String pmClaveClinica, String pmAsegurado, Integer pmCoberturaAfec,
			Integer pmMedicoRed, Integer pmConvenio, String pmOtroVehiculo, String pmIdeLesionado, Integer pmId,
			String pmClaveMedico,
			String pmClaveAjustador, String pmEmailAsegurado, Integer pmTipoClinica, String pmEdadLesionado,
			String pmFolioElectro, Integer pmAmbulatoria, String pmDomClinica, Date pmFechaSiniestro,
			String pmNomLesionado, String pmNumEndoso, String pmNumSiniestro, String pmTelLesionado,
			String pmTelMedico, Date pmFechaEmision, String pmNomClinica, String pmOtraCobertura, String pmNomAsegurado,
			String pmLugarEstado, String pmNumOcupantes, Integer pmCausaLesion, String pmLesionesAparentes,
			Integer pmTipoVehiculo, String pmNumLesionado, String pmNumInciso, String pmNumPoliza, String pmNumReporte,
			Integer enviadoEmail, ////
			String mensajeEmail, ///
			String pmEmailLesionado, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp,
			String nodoEnvio, Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador,
			String firmaAsegurado, String firmaLesionado
	);
	public abstract String InsertarFormatoPaseMedico(DatosInsertarFormatoPaseMedico entrada);
	public abstract String ejecutarFuncionWebserviceStoreFPM(Map<String, String> entry);
	public abstract int obtenerConsecutivo(String reporte, String tipoAfectado);
}