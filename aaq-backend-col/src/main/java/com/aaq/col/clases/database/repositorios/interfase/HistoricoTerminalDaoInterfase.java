package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


public interface HistoricoTerminalDaoInterfase extends JMRepositorioGenericoInterfase<HistoricoTerminal> {


	public abstract HistoricoTerminal objetoHistoricoTerminal(String id);
	public abstract List<HistoricoTerminal> listaDeHistoricoTerminal(Terminal terminal, String reporte,
			String operacion, Date fechaInicial, Date fechaFinal, Integer limite);
	public abstract JMResultadoOperacion ejecutarFuncionHistoricoTerminalNuevo(Usuario usuario, Terminal terminal,
			String reporte, String fuente, String operacion, String detalles);
	public abstract JMResultadoOperacion ejecutarFuncionHistoricoTerminal(final Usuario usuario, final Terminal terminal,
			final String reporte, final String fuente, final String operacion, final String detalles);

}