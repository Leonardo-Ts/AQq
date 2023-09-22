package com.aaq.col.clases.database.servicios.interfase;


import com.aaq.col.clases.database.entidades.EntidadAbogadoCrm;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;

public interface EntidadAbogadoCrmServiceInterfase extends JMServicioGenericoInterfase<EntidadAbogadoCrm> {

	public abstract EntidadAbogadoCrm objetoEntidadAbogadoCrm(final String nombreEntidad) ;

}