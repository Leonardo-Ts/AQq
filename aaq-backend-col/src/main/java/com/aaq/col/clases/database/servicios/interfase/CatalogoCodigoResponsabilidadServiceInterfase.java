package com.aaq.col.clases.database.servicios.interfase;

import com.aaq.col.clases.database.entidades.CatalogoCodigoResponsabilidad;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;

public interface CatalogoCodigoResponsabilidadServiceInterfase extends JMServicioGenericoInterfase<CatalogoCodigoResponsabilidad> {

	public abstract CatalogoCodigoResponsabilidad objetoCatalogoCodigoResponsabilidadClave(String codigo) ;
}