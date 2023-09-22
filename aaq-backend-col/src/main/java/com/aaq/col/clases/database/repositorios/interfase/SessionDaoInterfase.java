package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Session;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface SessionDaoInterfase extends JMRepositorioGenericoInterfase<Session> {

	public abstract Session objetoSession(String id);
	public abstract Session objetoSessionParaIdentificador(String id);
	public abstract List<Session> listaDeSession();

}