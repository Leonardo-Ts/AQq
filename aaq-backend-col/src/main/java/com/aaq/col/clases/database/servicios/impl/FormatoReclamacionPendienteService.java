package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.FormatoReclamacionPendiente;
import com.aaq.col.clases.database.repositorios.impl.FormatoReclamacionPendienteDao;
import com.aaq.col.clases.database.servicios.interfase.FormatoReclamacionPendienteServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("formatoReclamacionPendienteService")
@Transactional
public class FormatoReclamacionPendienteService implements FormatoReclamacionPendienteServiceInterfase {
	
	@Autowired
	@Qualifier("formatoReclamacionPendienteDao")
	FormatoReclamacionPendienteDao formatoReclamacionPendienteDao;

	@Override
	public FormatoReclamacionPendiente objetoFormatoReclamacionPendiente(String id) {
		return this.formatoReclamacionPendienteDao.objetoFormatoReclamacionPendiente(id);
	}

	@Override
	public String ejecutarFuncionInsertarReclamacionPendiente(String rpNumReporte, String rpNombreConductor,
			Integer rpDfEndoso, String rpAsegurado, String rpObservaciones, String rpObsEndosoAclara, Integer rpOtros,
			String rpNumReclamacion, Integer rpId, String rpNomAjustador, Integer rpCopiaActaMp, Date rpFecha,
			Integer rpReciboPago, Integer rpLicencia, String rpClaveAjustador, String rpNomConductor,
			String rpNumInciso, String rpNumPoliza, String emailDefault, Integer rpPolizaVigente, Integer enviadoEmail, ////
			String mensajeEmail, Integer proceso, Timestamp horaEnvioEmail, Timestamp horaEnvioSftp, String nodoEnvio,
			Integer check1, Integer check2, Integer check3, Integer check4, String firmaAjustador, String firmaAsegurado

	) {
		return this.formatoReclamacionPendienteDao.ejecutarFuncionInsertarReclamacionPendiente(rpNumReporte,
				rpNombreConductor, rpDfEndoso, rpAsegurado, rpObservaciones, rpObsEndosoAclara, rpOtros,
				rpNumReclamacion, rpId, rpNomAjustador, rpCopiaActaMp, rpFecha, rpReciboPago, rpLicencia,
				rpClaveAjustador, rpNomConductor, rpNumInciso, rpNumPoliza, emailDefault, rpPolizaVigente, enviadoEmail, ////
				mensajeEmail, proceso, horaEnvioEmail, horaEnvioSftp, nodoEnvio, check1, check2, check3, check4,
				firmaAjustador, firmaAsegurado

		);
	}

	@Override
	public List<FormatoReclamacionPendiente> listaDeFormatoReclamacionPendiente() {
		return this.formatoReclamacionPendienteDao.listaDeFormatoReclamacionPendiente();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(FormatoReclamacionPendiente t) {

		return this.formatoReclamacionPendienteDao.guardarObjeto(t);
	}

	@Override
	public int obtenerConsecutivo(String reporte) {
		return formatoReclamacionPendienteDao.obtenerConsecutivo(reporte);
	}

}