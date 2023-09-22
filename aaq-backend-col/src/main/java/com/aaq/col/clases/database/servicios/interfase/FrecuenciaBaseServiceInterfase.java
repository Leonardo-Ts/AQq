package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FrecuenciaBaseServiceInterfase extends JMServicioGenericoInterfase<FrecuenciaBase> {

	public abstract FrecuenciaBase objetoFrecuenciaBase(final String id) ;
	public abstract List<FrecuenciaBase> listaDeFrecuenciaBase(final Frecuencia frecuencia) ;
	public abstract  List<FrecuenciaBase> listaDeFrecuenciaBase(final Base base);
	public abstract JMResultadoOperacion eliminarObjeto(FrecuenciaBase t) ;
	public abstract JMResultadoOperacion guardarObjeto(FrecuenciaBase t) ;
	public abstract List<FrecuenciaBase> listaDeFrecuenciaBaseGH(final Frecuencia frecuencia) ;
}