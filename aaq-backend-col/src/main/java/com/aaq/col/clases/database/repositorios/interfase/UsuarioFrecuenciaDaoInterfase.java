package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.UsuarioFrecuencia;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface UsuarioFrecuenciaDaoInterfase extends JMRepositorioGenericoInterfase<UsuarioFrecuencia> {


	public abstract UsuarioFrecuencia objetoUsuarioFrecuencia(final String id);
	public abstract List<UsuarioFrecuencia> listaDeUsuarioFrecuencia(final Usuario usuario);
	public abstract List<UsuarioFrecuencia> listaDeUsuarioFrecuenciaEncuesta(Frecuencia frecuencia, Usuario usuario);

}