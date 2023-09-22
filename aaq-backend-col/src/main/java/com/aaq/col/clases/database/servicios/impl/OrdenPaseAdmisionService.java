package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.OrdenPaseAdmision;
import com.aaq.col.clases.database.repositorios.impl.OrdenPaseAdmisionDao;
import com.aaq.col.clases.database.servicios.interfase.OrdenPaseAdmisionServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("ordenPaseAdmisionService")
@Transactional
public class OrdenPaseAdmisionService implements OrdenPaseAdmisionServiceInterfase {
	
	@Autowired
	@Qualifier("ordenPaseAdmisionDao")
	OrdenPaseAdmisionDao ordenPaseAdmisionDao;

	@Override
	public OrdenPaseAdmision objetoOrdenPaseAdmision(String id) {
		return this.ordenPaseAdmisionDao.objetoOrdenPaseAdmision(id);
	}

	@Override
	public String ejecutarFuncionInsertarPaseAdmision(String usuario, String passwd, String reporte, Date fechaHora,
			String tipoOrden, String tipoAfectado, String conductor, String telefonoConductor, String oficina,
			String ubicacion, String tipoProveedor, String claveProveedor, String responsableTaller,
			String telefonoTaller, String domicilioTaller, String cobertura, String marcaVehiculo, String tipoVehiculo,
			String modeloVehiculo, String serieVehiculo, String colorVehiculo, String placasVehiculo,
			String danosPreexistentes, String danosSiniestro, Boolean deducible, String tipoDeducible,
			String sumaAsegurada, String porcentajeDeducible, String monto, String observaciones, Integer id_ajustador,
			String reportePolizaNumero) {
		return this.ordenPaseAdmisionDao.ejecutarFuncionInsertarPaseAdmision(usuario, passwd, reporte, fechaHora,
				tipoOrden, tipoAfectado, conductor, telefonoConductor, oficina, ubicacion, tipoProveedor,
				claveProveedor, responsableTaller, telefonoTaller, domicilioTaller, cobertura, marcaVehiculo,
				tipoVehiculo, modeloVehiculo, serieVehiculo, colorVehiculo, placasVehiculo, danosPreexistentes,
				danosSiniestro, deducible, tipoDeducible, sumaAsegurada, porcentajeDeducible, monto, observaciones,
				id_ajustador, reportePolizaNumero);
	}

	@Override
	public List<OrdenPaseAdmision> listaDeOrdenPaseAdmision() {
		return this.ordenPaseAdmisionDao.listaDeOrdenPaseAdmision();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(OrdenPaseAdmision t) {

		return this.ordenPaseAdmisionDao.guardarObjeto(t);
	}

}