package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Comunicado;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface ComunicadoDaoInterfase extends JMRepositorioGenericoInterfase<Comunicado> {

	public abstract Comunicado objetoComunicado(String id);
	public abstract List<Comunicado> listaDeComunicado(Estado estado, Base base, Terminal terminal,
			final Boolean soloActivos);

}