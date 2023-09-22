 package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.FormatoReclamacionComprobantePeaje;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface FormatoReclamacionComprobantePeajeServiceInterfase
		extends JMServicioGenericoInterfase<FormatoReclamacionComprobantePeaje> {

	public abstract FormatoReclamacionComprobantePeaje objetoFormatoReclamacionComprobantePeaje(final String id);
	public abstract JMResultadoOperacion guardarObjeto(FormatoReclamacionComprobantePeaje t);
	public abstract List<FormatoReclamacionComprobantePeaje> listaDeFormatoReclamacionComprobantePeaje();
	public abstract int obtenerConsecutivo(String reporte);

}