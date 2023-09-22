package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CorreoPolizaAgente;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CorreoPolizaAgenteDaoInterfase extends JMRepositorioGenericoInterfase<CorreoPolizaAgente> {

	public abstract CorreoPolizaAgente objetoCorreoPolizaAgente(String id);
	public abstract List<CorreoPolizaAgente> listaDeCorreoPolizaAgente();
	public abstract List<CorreoPolizaAgente> listaDeCorreoPolizaAgente(String poliza, String clave_agente);


}