package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Municipio;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface MunicipioServiceInterfase extends JMServicioGenericoInterfase<Municipio> {

	public abstract Municipio objetoMunicipio(final String id);
	public abstract Municipio objetoMunicipio(final Estado estado, final String idmunicipio);
	public abstract List<Municipio> listaDeMunicipios(final Estado estado) ;
	public abstract JMResultadoOperacion eliminarObjeto(Municipio t) ;
	public abstract JMResultadoOperacion guardarObjeto(Municipio t);
}