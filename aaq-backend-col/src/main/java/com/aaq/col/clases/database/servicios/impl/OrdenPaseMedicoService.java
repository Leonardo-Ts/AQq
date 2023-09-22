package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.OrdenPaseMedico;
import com.aaq.col.clases.database.repositorios.impl.OrdenPaseMedicoDao;
import com.aaq.col.clases.database.servicios.interfase.OrdenPaseMedicoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("ordenPaseMedicoService")
@Transactional
public class OrdenPaseMedicoService implements OrdenPaseMedicoServiceInterfase {
	
	@Autowired
	@Qualifier("ordenPaseMedicoDao")
	OrdenPaseMedicoDao ordenPaseMedicoDao;

	@Override
	public OrdenPaseMedico objetoOrdenPaseMedico(String id) {
		return this.ordenPaseMedicoDao.objetoOrdenPaseMedico(id);
	}

	@Override
	public String ejecutarFuncionInsertarPaseMedico(String usuario, String passwd, Date fechaHora, String reporte,
			String tipoAtencion, String numeroOcupantes, String numeroLesionados, String cobertura, String causasLesion,
			String identificacion, String nombreLesionado, String telefonoLesionado, String sexoLesionado,
			String edadLesionado, String tipoAtencionMedica, String lesionesAparentes, String tipoProveedor,
			String claveProveedor, String hospital, String telefonoHospital, String domicilioHospital,
			Integer id_ajustador, String reporteNumeroPoliza, String email_lesionado) {
		return this.ordenPaseMedicoDao.ejecutarFuncionInsertarPaseMedico(usuario, passwd, fechaHora, reporte,
				tipoAtencion, numeroOcupantes, numeroLesionados, cobertura, causasLesion, identificacion,
				nombreLesionado, telefonoLesionado, sexoLesionado, edadLesionado, tipoAtencionMedica, lesionesAparentes,
				tipoProveedor, claveProveedor, hospital, telefonoHospital, domicilioHospital, id_ajustador,
				reporteNumeroPoliza);
	}

	@Override
	public List<OrdenPaseMedico> listaDeOrdenPaseMedico() {

		return this.ordenPaseMedicoDao.listaDeOrdenPaseMedico();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(OrdenPaseMedico t) {

		return this.ordenPaseMedicoDao.guardarObjeto(t);
	}

}