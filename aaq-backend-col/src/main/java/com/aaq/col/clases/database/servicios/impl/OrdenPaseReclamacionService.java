package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.OrdenPaseReclamacion;
import com.aaq.col.clases.database.repositorios.impl.OrdenPaseReclamacionDao;
import com.aaq.col.clases.database.servicios.interfase.OrdenPaseReclamacionServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("ordenPaseReclamacionService")
@Transactional
public class OrdenPaseReclamacionService implements OrdenPaseReclamacionServiceInterfase {
	
	@Autowired
	@Qualifier("ordenPaseReclamacionDao")
	OrdenPaseReclamacionDao ordenPaseReclamacionDao;

	@Override
	public OrdenPaseReclamacion objetoOrdenPaseReclamacion(String id) {
		return this.ordenPaseReclamacionDao.objetoOrdenPaseReclamacion(id);
	}

	@Override
	public String ejecutarFuncionInsertarPaseReclamacion(String usuario, String passwd, Date fechaHora, String reporte,
			String documentosFaltantes, String observaciones, Integer id_ajustador, String reporteNumeroPoliza) {
		return this.ordenPaseReclamacionDao.ejecutarFuncionInsertarPaseReclamacion(usuario, passwd, fechaHora, reporte,
				documentosFaltantes, observaciones, id_ajustador, reporteNumeroPoliza);
	}

	@Override
	public List<OrdenPaseReclamacion> listaDeOrdenPaseReclamacion() {

		return this.ordenPaseReclamacionDao.listaDeOrdenPaseReclamacion();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(OrdenPaseReclamacion t) {

		return this.ordenPaseReclamacionDao.guardarObjeto(t);
	}

}