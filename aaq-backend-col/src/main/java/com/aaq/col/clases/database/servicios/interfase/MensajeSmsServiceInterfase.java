 package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.MensajeSms;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface MensajeSmsServiceInterfase extends JMServicioGenericoInterfase<MensajeSms> {

	public abstract MensajeSms objetoMensajeSms(String id) ;
	public abstract List<MensajeSms> listaDeMensajeSms(Date fechaInicial, Date fechaFinal, String reporte,
			String oficina, String poliza, String agente, String asegurado, String gerente, Terminal terminal,
			Integer limite) ;
	public abstract JMResultadoOperacion eliminarObjeto(MensajeSms t) ;
	public abstract JMResultadoOperacion guardarObjeto(MensajeSms t) ;
	public abstract List<EntidadObjeto> listaDeMensajeSmsParaGrafica(Date fechaInicial, Date fechaFinal,
			String reporte, String oficina, String poliza, String agente, String asegurado, String gerente,
			String idterminal) ;
	
	
}