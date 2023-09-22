package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMarca;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoMarcaServiceInterfase extends JMServicioGenericoInterfase<CatalogoMarca> {

	public abstract CatalogoMarca objetoCatalogoMarca(String id);
	public abstract List<CatalogoMarca> listaDeCatalogoMarca();
	public abstract List<CatalogoMarca> listaDeCatalogoMarca(String clave, String nombre);
	public abstract CatalogoMarca objetoCatalogoMarcaParaClave(String clave);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoMarca t);
	public abstract JMResultadoOperacion guardarObjeto(CatalogoMarca t);
}