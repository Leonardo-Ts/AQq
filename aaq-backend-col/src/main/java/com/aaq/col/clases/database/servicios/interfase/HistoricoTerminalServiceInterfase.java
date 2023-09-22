package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface HistoricoTerminalServiceInterfase extends JMServicioGenericoInterfase<HistoricoTerminal> {

	public abstract HistoricoTerminal objetoHistoricoTerminal(String id);
	public abstract List<HistoricoTerminal> listaDeHistoricoTerminal(Terminal terminal, String reporte,
			String operacion, Date fechaInicial, Date fechaFinal, Integer limite) ;
	public abstract JMResultadoOperacion ejecutarFuncionHistoricoTerminalNuevo(Usuario usuario, Terminal terminal,
			String reporte, String fuente, String operacion, String detalles) ;
	public abstract JMResultadoOperacion eliminarObjeto(HistoricoTerminal t);
	public abstract JMResultadoOperacion guardarObjeto(HistoricoTerminal t) ;
	public abstract JMResultadoOperacion ejecutarFuncionHistoricoTerminal(final Usuario usuario, final Terminal terminal,
			final String reporte, final String fuente, final String operacion, final String detalles);
}