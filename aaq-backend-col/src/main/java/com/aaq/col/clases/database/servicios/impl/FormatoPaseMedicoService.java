package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoPaseMedico;
import com.aaq.col.clases.database.repositorios.impl.FormatoPaseMedicoDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoPaseMedicoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoPaseMedicoService")
@Transactional
public class FormatoPaseMedicoService implements FormatoPaseMedicoServiceInterfase {
	
	@Autowired
	@Qualifier("formatoPaseMedicoDao")
	FormatoPaseMedicoDao formatoPaseMedicoDao;

	@Override
	public FormatoPaseMedico objetoFormatoPaseMedico(String id) {
		return this.formatoPaseMedicoDao.objetoFormatoPaseMedico(id);
	}

	@Override
	public String ejecutarFuncionInsertarMedico(

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

	) {
		return this.formatoPaseMedicoDao.ejecutarFuncionInsertarMedico(

				pmNombreAjustador, pmNomMedico, pmOtraLesion, pmTelClinica, pmLugarEmision, pmClaveClinica, pmAsegurado,
				pmCoberturaAfec, pmMedicoRed, pmConvenio, pmOtroVehiculo, pmIdeLesionado, pmId, pmClaveMedico,

				pmClaveAjustador, pmEmailAsegurado, pmTipoClinica, pmEdadLesionado, pmFolioElectro, pmAmbulatoria,
				pmDomClinica, pmFechaSiniestro, pmNomLesionado, pmNumEndoso, pmNumSiniestro, pmTelLesionado,

				pmTelMedico, pmFechaEmision, pmNomClinica, pmOtraCobertura, pmNomAsegurado, pmLugarEstado,
				pmNumOcupantes, pmCausaLesion, pmLesionesAparentes, pmTipoVehiculo, pmNumLesionado, pmNumInciso,
				pmNumPoliza, pmNumReporte, enviadoEmail, ////
				mensajeEmail, ///
				pmEmailLesionado, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaAjustador, firmaAsegurado, firmaLesionado

		);
	}

	@Override
	public List<FormatoPaseMedico> listaDeFormatoPaseMedico() {
		return this.formatoPaseMedicoDao.listaDeFormatoPaseMedico();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoPaseMedico t) {

		return this.formatoPaseMedicoDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte, String tipoAfectado) {
		return formatoPaseMedicoDao.obtenerConsecutivo(reporte, tipoAfectado);
	}

}