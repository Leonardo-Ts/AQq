package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.CodigoResponsabilidadEstad;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CodigoResponsabilidadEstadServiceInterfase extends JMServicioGenericoInterfase<CodigoResponsabilidadEstad>{

	public abstract CodigoResponsabilidadEstad objetoCRE(final String id);
	public abstract CodigoResponsabilidadEstad objetoCodigoResponsablidadEstad(String numeroReporte, String numeroAjustador) ;
	public abstract JMResultadoOperacion guardarObjeto(final CodigoResponsabilidadEstad rms);
	public abstract List<CodigoResponsabilidadEstad> listarCodigoResponsabilidadEstad(Date fechaInicial, Date fechaFinal, String estado, String base) ;
	public abstract List<EntidadObjeto> listaDeCodigosParaGrafica(Date fechaInicial, Date fechaFinal, String estado, String base);
	
}
