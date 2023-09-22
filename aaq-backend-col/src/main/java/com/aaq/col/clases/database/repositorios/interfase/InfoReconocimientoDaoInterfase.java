package com.aaq.col.clases.database.repositorios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.InfoReconocimiento;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface InfoReconocimientoDaoInterfase extends JMRepositorioGenericoInterfase<InfoReconocimiento> {
	
	public abstract InfoReconocimiento objetoInfoReconocimiento(String id);
	public abstract List<InfoReconocimiento> listaDeInfoReconocimiento (String reporte);
	

}
