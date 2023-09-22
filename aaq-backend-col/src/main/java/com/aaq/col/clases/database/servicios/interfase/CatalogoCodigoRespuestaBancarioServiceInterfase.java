package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoCodigoRespuestaBancario;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoCodigoRespuestaBancarioServiceInterfase extends
		JMServicioGenericoInterfase<CatalogoCodigoRespuestaBancario> {

	public abstract CatalogoCodigoRespuestaBancario objetoCatalogoCodigoRespuestaBancario(String id) ;
	public abstract CatalogoCodigoRespuestaBancario objetoCatalogoCodigoRespuestaBancarioParaCodigo(String codigoiso);
	public abstract List<CatalogoCodigoRespuestaBancario> listaDeCatalogoCodigoRespuestaBancario() ;
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoCodigoRespuestaBancario t) ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoCodigoRespuestaBancario t) ;
}