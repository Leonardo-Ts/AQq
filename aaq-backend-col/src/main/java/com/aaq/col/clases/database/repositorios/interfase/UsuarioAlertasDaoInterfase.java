package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Frecuencia;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.UsuarioAlertas;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface UsuarioAlertasDaoInterfase extends JMRepositorioGenericoInterfase<UsuarioAlertas> {

	public abstract UsuarioAlertas objetoUsuarioAlertas(final String id);
	public abstract UsuarioAlertas objetoUsuarioAlertasParaUsuario(final Usuario usuario);
	public abstract List<UsuarioAlertas> usuarioAlertaParaFrecuencia(final Frecuencia frecuencia, String filtroAlerta);
}
