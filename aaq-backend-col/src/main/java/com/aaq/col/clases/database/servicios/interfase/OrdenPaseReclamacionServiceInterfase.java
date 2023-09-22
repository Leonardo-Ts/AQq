 package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.OrdenPaseReclamacion;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface OrdenPaseReclamacionServiceInterfase extends JMServicioGenericoInterfase<OrdenPaseReclamacion> {

	public abstract OrdenPaseReclamacion objetoOrdenPaseReclamacion(final String id);
	public abstract JMResultadoOperacion guardarObjeto(OrdenPaseReclamacion t);
	public abstract List<OrdenPaseReclamacion> listaDeOrdenPaseReclamacion();
	public abstract String ejecutarFuncionInsertarPaseReclamacion(String usuario, String passwd, Date fechaHora,
			String reporte, String documentosFaltantes, String observaciones, Integer id_ajustador,
			String reporteNumeroPoliza);

}