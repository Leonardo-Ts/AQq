package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.ControlFotografias;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;

public interface ControlFotografiasDaoInterfase  extends JMRepositorioGenericoInterfase<ControlFotografias> {

	public abstract ControlFotografias objetoControlFoto(final String id);
	public abstract List<ControlFotografias> listarControlFotografias(final Date fechaInicial, final Date fechaFinal, final String claveDocumental, final String numReporte, Estado estado, Base base);
	public abstract List<EntidadObjeto> listaParaGraficaFotos(final Date fechaInicial, final Date fechaFinal,
			String estado, String base, String reporte, String claveDocumental ) ;
	
}
