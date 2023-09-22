package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.OrdenPaseAmbulancia;
import com.aaq.col.clases.database.repositorios.impl.OrdenPaseAmbulanciaDao;
import com.aaq.col.clases.database.servicios.interfase.OrdenPaseAmbulanciaServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("ordenPaseAmbulanciaService")
@Transactional
public class OrdenPaseAmbulanciaService implements OrdenPaseAmbulanciaServiceInterfase {
	
	@Autowired
	@Qualifier("ordenPaseAmbulanciaDao")
	OrdenPaseAmbulanciaDao ordenPaseAmbulanciaDao;

	@Override
	public OrdenPaseAmbulancia objetoOrdenPaseAmbulancia(String id) {

		return this.ordenPaseAmbulanciaDao.objetoOrdenPaseAmbulancia(id);
	}

	@Override
	public List<OrdenPaseAmbulancia> listaDeOrdenPaseAmbulancia() {

		return this.ordenPaseAmbulanciaDao.listaDeOrdenPaseAmbulancia();
	}

	@Override
	public String ejecutarFuncioninsertarValeAmbulancia(String usuario, String passwd, Date fechaHora, String reporte,
			String tipoAtencion, String claveHospital, String claveAmbulancia, String hospital,
			String direccionTraslado, String telefonoHospital, String nombreLesionado, String ubicacionLesionado,
			String edadLesionado, String sexoLesionado, String telefonoLesionado, String diagnostico,
			Integer id_ajustador, String reporteNumeroPoliza) {

		return this.ordenPaseAmbulanciaDao.ejecutarFuncioninsertarValeAmbulancia(usuario, passwd, fechaHora, reporte,
				tipoAtencion, claveHospital, claveAmbulancia, hospital, direccionTraslado, telefonoHospital,
				nombreLesionado, ubicacionLesionado, edadLesionado, sexoLesionado, telefonoLesionado, diagnostico,
				id_ajustador, reporteNumeroPoliza);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(OrdenPaseAmbulancia t) {

		return this.ordenPaseAmbulanciaDao.guardarObjeto(t);
	}

}