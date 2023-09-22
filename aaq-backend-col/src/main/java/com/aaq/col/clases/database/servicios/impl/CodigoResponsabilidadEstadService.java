package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.CodigoResponsabilidadEstad;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.repositorios.interfase.CodigoResponsabilidadEstadDaoInterfase;
import com.aaq.col.clases.database.servicios.interfase.CodigoResponsabilidadEstadServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("codigoResponsabilidadEstadService")
@Transactional
public class CodigoResponsabilidadEstadService implements CodigoResponsabilidadEstadServiceInterfase {

	@Autowired
	private CodigoResponsabilidadEstadDaoInterfase codigoResponsabilidadEstadDao;
	
	@Override
	public CodigoResponsabilidadEstad objetoCodigoResponsablidadEstad(String numeroReporte, String numeroAjustador) {
		return this.codigoResponsabilidadEstadDao.objetoCodigoResponsabilidad(numeroReporte,numeroAjustador);
	}
	
	@Override
	public JMResultadoOperacion guardarObjeto(final CodigoResponsabilidadEstad cre) {
		return  this.codigoResponsabilidadEstadDao.guardarObjeto(cre);
		   
	}
	
	@Override
	public List<CodigoResponsabilidadEstad> listarCodigoResponsabilidadEstad(Date fechaInicial, Date fechaFinal, String estado, String base) {
		return this.codigoResponsabilidadEstadDao.listarCodigoResponsabilidadEstad(fechaInicial, fechaFinal, estado, base);
	}

	@Override
	public List<EntidadObjeto> listaDeCodigosParaGrafica(Date fechaInicial, Date fechaFinal, String estado, String base) {
		return this.codigoResponsabilidadEstadDao.listarCodigoResp(fechaInicial, fechaFinal, estado, base);
	}

	@Override
	public CodigoResponsabilidadEstad objetoCRE(String id) {
		return this.codigoResponsabilidadEstadDao.objetoCRE(id);
	}
	
}
