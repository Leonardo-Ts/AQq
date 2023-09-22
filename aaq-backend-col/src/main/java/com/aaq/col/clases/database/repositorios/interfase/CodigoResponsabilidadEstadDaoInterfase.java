package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.CodigoResponsabilidadEstad;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface CodigoResponsabilidadEstadDaoInterfase extends JMRepositorioGenericoInterfase<CodigoResponsabilidadEstad>{
	
	public abstract CodigoResponsabilidadEstad objetoCRE(final String id);
	public abstract CodigoResponsabilidadEstad objetoCodigoResponsabilidad(String numeroReporte, String numeroAjustador );
	public abstract  List<EntidadObjeto>  listarCodigoResp(Date fechaInicial, Date fechaFinal, String estado, String base);
	public abstract List<CodigoResponsabilidadEstad> listarCodigoResponsabilidadEstad(final Date fechaInicial, final Date fechaFinal, final String estado , final String base);
}