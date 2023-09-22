 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoMarca;
import com.aaq.col.clases.database.entidades.CatalogoMarcaEstilo;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoMarcaEstiloServiceInterfase extends JMServicioGenericoInterfase<CatalogoMarcaEstilo> {

	public abstract CatalogoMarcaEstilo objetoCatalogoMarcaEstilo(String id) ;
	public abstract List<CatalogoMarcaEstilo> listaDeCatalogoMarcaEstilo(CatalogoMarca catalogoMarca) ;
	public abstract CatalogoMarcaEstilo objetoCatalogoMarcaEstiloParaClave(CatalogoMarca catalogoMarca, String clave);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoMarcaEstilo t) ;
	public abstract JMResultadoOperacion guardarObjeto(CatalogoMarcaEstilo t) ;
}