package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CatalogoHospitales;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CatalogoHospitalesServiceInterfase extends JMServicioGenericoInterfase<CatalogoHospitales> {

	public abstract CatalogoHospitales objetoCatalogoHospitales(final String id);
	public abstract JMResultadoOperacion eliminarObjeto(final CatalogoHospitales t);
	public abstract JMResultadoOperacion guardarObjeto(final CatalogoHospitales t);
	public abstract List<CatalogoHospitales> listaDeCatalogoHospitales(String clave) ;
	
}
