package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoCodigoRespuestaBancario;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CatalogoCodigoRespuestaBancarioDaoInterfase extends
		JMRepositorioGenericoInterfase<CatalogoCodigoRespuestaBancario> {

	public abstract CatalogoCodigoRespuestaBancario objetoCatalogoCodigoRespuestaBancario(String id);
	public abstract CatalogoCodigoRespuestaBancario objetoCatalogoCodigoRespuestaBancarioParaCodigo(String codigoiso);
	public abstract List<CatalogoCodigoRespuestaBancario> listaDeCatalogoCodigoRespuestaBancario();

}