 package com.aaq.col.clases.database.repositorios.interfase;

import com.aaq.col.clases.database.entidades.ModuloPadre;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface ModuloPadreDaoInterfase extends JMRepositorioGenericoInterfase<ModuloPadre> {

	public abstract ModuloPadre objetoModuloPadre(String id);

}