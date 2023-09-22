package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoGrua;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoGruaServiceInterface extends JMServicioGenericoInterfase<CatalogoGrua> {

	public abstract CatalogoGrua objetoCatalogoGrua(final String id);
	public abstract JMResultadoOperacion eliminarObjeto(final CatalogoGrua t);
	public abstract JMResultadoOperacion guardarObjeto(final CatalogoGrua t);
	public abstract List<CatalogoGrua> listaDeCatalogoGrua(String clave, String descripcion, String codigo) ;
	
}
