 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.GuardiaGrupo;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface GuardiaGrupoDaoInterfase extends JMRepositorioGenericoInterfase<GuardiaGrupo> {

	public abstract GuardiaGrupo objetoGuardiaGrupo(final String id);
	public abstract List<GuardiaGrupo> listaDeGuardiaGrupo(final Grupo grupo);
	public abstract GuardiaGrupo objetoGuardiaPorGrupo(final Grupo grupo);
	

}