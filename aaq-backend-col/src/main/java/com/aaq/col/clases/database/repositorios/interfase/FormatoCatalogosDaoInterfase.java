package com.aaq.col.clases.database.repositorios.interfase;


import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoCatalogos;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface FormatoCatalogosDaoInterfase extends JMRepositorioGenericoInterfase<FormatoCatalogos> {
	
	
	public abstract FormatoCatalogos objetoFormatoCatalogos(final String id);
	public abstract List<FormatoCatalogos> listaDeFormatoCatalogos();
	public abstract String ejecutarFuncionInsertarCatalogos(String nombre, String valores);
	public abstract List<FormatoCatalogos> listaDeFormatoCatalogos(final String nombre);
	
	

}