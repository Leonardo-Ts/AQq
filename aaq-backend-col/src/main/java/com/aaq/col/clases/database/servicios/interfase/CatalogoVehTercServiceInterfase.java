package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoVehTerc;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoVehTercServiceInterfase extends JMServicioGenericoInterfase<CatalogoVehTerc> {

	public abstract CatalogoVehTerc objetoCatalogoVehTerc(String id);
	public abstract List<CatalogoVehTerc> listaDeCatalogoVehTerc(String clave, String descripcion);
	public abstract JMResultadoOperacion eliminarObjeto(CatalogoVehTerc t);
	public abstract JMResultadoOperacion guardarObjeto(CatalogoVehTerc t);
	
}
