package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoFaq;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoFaqServiceInterfase extends JMServicioGenericoInterfase<CatalogoFaq> {
	
	public abstract CatalogoFaq objetoCatalogoFaq(final String id);
	public abstract JMResultadoOperacion eliminarObjeto(final CatalogoFaq t);
	public abstract JMResultadoOperacion guardarObjeto(final CatalogoFaq t);
	public abstract List<CatalogoFaq> listaDeCatalogoFaq(String clave, String descripcion) ;
	
}
