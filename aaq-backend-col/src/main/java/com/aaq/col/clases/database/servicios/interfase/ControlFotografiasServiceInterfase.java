package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.ControlFotografias;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ControlFotografiasServiceInterfase extends JMServicioGenericoInterfase<ControlFotografias> {
	
	public abstract ControlFotografias objetoControlFotos(String id);
	public abstract List<ControlFotografias> listarControlFotografias(Date fechaInicial, Date fechaFinal, String tipoFoto, String numReporte, Estado edo, Base base);
	public abstract JMResultadoOperacion eliminarObjeto(ControlFotografias t);
	public abstract JMResultadoOperacion guardarObjeto(ControlFotografias t) ;
	public abstract List<EntidadObjeto> listaParaGraficaFotos(final Date fechaInicial, final Date fechaFinal,
			String estado, String base, String reporte, String claveDocumental);
	
}
