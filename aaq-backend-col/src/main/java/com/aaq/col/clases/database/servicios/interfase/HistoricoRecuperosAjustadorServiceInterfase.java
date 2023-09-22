package com.aaq.col.clases.database.servicios.interfase;


import com.aaq.col.clases.database.entidades.HistoricoRecuperosAjustador;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface HistoricoRecuperosAjustadorServiceInterfase extends JMServicioGenericoInterfase<HistoricoRecuperosAjustador> {

	public abstract HistoricoRecuperosAjustador objetoHistoricoRecuperosAjustador(String id) ;

	public abstract JMResultadoOperacion ejecutarFuncionHistoricoRecuperosAjustadorNuevo(final String claveRecupero, final String descripcionRecupero, final String totalVales, final String claveAseguradora,
			 final String descripcionAseguradora, final String claveAjustador, final String reporte, final String afectado, 
			 final String numeroSiniestro, final String folioVale, final String monto, final String descripcionMonto) ;

	public abstract JMResultadoOperacion eliminarObjeto(HistoricoRecuperosAjustador t) ;

	public abstract JMResultadoOperacion guardarObjeto(HistoricoRecuperosAjustador t) ;
}