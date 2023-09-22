package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.PuntoInteresTipo;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface PuntoInteresTipoDaoInterfase extends JMRepositorioGenericoInterfase<PuntoInteresTipo> {

	public abstract PuntoInteresTipo objetoPuntoInteresTipo(String id);
	public abstract PuntoInteresTipo objetoPuntoInteresTipoParaNombre(String nombre);
	public abstract List<PuntoInteresTipo> listaDePuntoInteresTipo();
	public abstract List<PuntoInteresTipo> listaDePuntoInteresTipo(String idPermitido, String idNoPermitido);

}