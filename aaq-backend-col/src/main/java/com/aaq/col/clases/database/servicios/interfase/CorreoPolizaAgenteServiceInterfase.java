package com.aaq.col.clases.database.servicios.interfase;

import java.util.List;

import com.aaq.col.clases.database.entidades.CorreoPolizaAgente;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface CorreoPolizaAgenteServiceInterfase extends JMServicioGenericoInterfase<CorreoPolizaAgente> {

	public abstract CorreoPolizaAgente objetoCorreoPolizaAgente(String id);
	public abstract List<CorreoPolizaAgente> listaDeCorreoPolizaAgente();
	public abstract List<CorreoPolizaAgente> listaDeCorreoPolizaAgente(String poliza, String claveAgente);
	public abstract JMResultadoOperacion eliminarObjeto(CorreoPolizaAgente t);
	public abstract JMResultadoOperacion guardarObjeto(CorreoPolizaAgente t);

}