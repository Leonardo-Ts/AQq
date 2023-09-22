package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Modulo;
import com.aaq.col.clases.database.entidades.ModuloPadre;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface ModuloDaoInterfase extends JMRepositorioGenericoInterfase<Modulo> {

	public abstract Modulo objetoModulo(final String id);
	public abstract List<Modulo> listaDeModulo();
	public abstract List<Modulo> listaDeModulo(final ModuloPadre moduloPadre, final String[] paginas,
			final boolean conNombres);
	public abstract List<Modulo> listaDeModulo(List<Integer> listaNoPermitida, final ModuloPadre moduloPadre,
			final String nombre, final String nombresiicav3, final Object[] pagina, final boolean conNombres);

}