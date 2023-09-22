package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Modulo;
import com.aaq.col.clases.database.entidades.ModuloPadre;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ModuloServiceInterfase extends JMServicioGenericoInterfase<Modulo> {

	public abstract Modulo objetoModulo(final String id) ;
	public abstract List<Modulo> listaDeModulo() ;
	public abstract List<Modulo> listaDeModulo(final ModuloPadre moduloPadre, final String[] paginas,
			final boolean conNombres) ;
	public abstract List<Modulo> listaDeModulo(List<Integer> listaNoPermitida, final ModuloPadre moduloPadre,
			final String nombre, final String nombresiicav3, final Object[] pagina, final boolean conNombres);
	public abstract JMResultadoOperacion eliminarObjeto(Modulo t) ;
	public abstract JMResultadoOperacion guardarObjeto(Modulo t) ;
}