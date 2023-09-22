 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.PuntoInteres;
import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface PuntoInteresDaoInterfase extends JMRepositorioGenericoInterfase<PuntoInteres> {

	public abstract PuntoInteres objetoPuntoInteres(final String id);
	public abstract List<PuntoInteres> listaDePuntoInteres(final Estado estado, final List<PuntoInteresTipo> tipo);

}