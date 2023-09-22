package com.aaq.col.clases.database.repositorios.interfase;

import com.aaq.col.clases.database.entidades.Siniestro;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface SiniestroDaoInterfase extends JMRepositorioGenericoInterfase<Siniestro> {

	public abstract Siniestro objetoSiniestro(final String id);
	public abstract Siniestro objetoSiniestro(String numeroReporte, String identificadorUnico);

}