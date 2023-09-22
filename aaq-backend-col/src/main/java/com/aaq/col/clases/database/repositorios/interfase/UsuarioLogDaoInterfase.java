package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.UsuarioLog;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface UsuarioLogDaoInterfase extends JMRepositorioGenericoInterfase<UsuarioLog> {

	public abstract UsuarioLog objetoUsuarioLog(String id);
	public abstract List<UsuarioLog> listaDeUsuarioLog(Date fechaInicial, Date fechaFinal, boolean validez,
			Integer limite);

}