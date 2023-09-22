package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.OrdenPaseEquipoPesado;
import com.aaq.col.clases.database.repositorios.impl.OrdenPaseEquipoPesadoDao;
import com.aaq.col.clases.database.servicios.interfase.OrdenPaseEquipoPesadoServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("ordenPaseEquipoPesadoService")
@Transactional
public class OrdenPaseEquipoPesadoService implements OrdenPaseEquipoPesadoServiceInterfase {

	@Autowired
	@Qualifier("ordenPaseEquipoPesadoDao")
	OrdenPaseEquipoPesadoDao ordenPaseEquipoPesadoDao;

	@Override
	public OrdenPaseEquipoPesado objetoOrdenPaseEquipoPesado(String id) {

		return this.ordenPaseEquipoPesadoDao.objetoOrdenPaseEquipoPesado(id);

	}

	@Override
	public String ejecutarFuncionInsertarPaseEquipoPesado(String usuario, String password, Date fechaHora,
			String numeroReporte, String tipoAtencion, String conductor, String telefonoConductor, String sumaAsegurada,
			String tipoDeducible, String porcentajeDeducible, String tipoProveedor, String claveProveedor,
			String responsableTaller, String telefonoTaller, String domicilioTaller, String marcaVehiculo,
			String modeloVehiculo, String serieVehiculo, String colorVehiculo, String placasVehiculo,
			Integer id_ajustador, String reporteNumeroPoliza) {

		return this.ordenPaseEquipoPesadoDao.ejecutarFuncionInsertarPaseEquipoPesado(usuario, password, fechaHora,
				numeroReporte, tipoAtencion, conductor, telefonoConductor, sumaAsegurada, tipoDeducible,
				porcentajeDeducible, tipoProveedor, claveProveedor, responsableTaller, telefonoTaller, domicilioTaller,
				marcaVehiculo, modeloVehiculo, serieVehiculo, colorVehiculo, placasVehiculo, id_ajustador,
				reporteNumeroPoliza);
	}

	@Override
	public List<OrdenPaseEquipoPesado> listaDeOrdenPaseEquipoPesado() {

		return this.ordenPaseEquipoPesadoDao.listaDeOrdenPaseEquipoPesado();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(OrdenPaseEquipoPesado t) {

		return this.ordenPaseEquipoPesadoDao.guardarObjeto(t);
	}

}