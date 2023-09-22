package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalLog;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;


public interface TerminalLogDaoInterfase extends JMRepositorioGenericoInterfase<TerminalLog> {

	public abstract TerminalLog objetoTerminalLog(final String id);
	public abstract List<TerminalLog> listaDeTerminalLog(final Date fechaInicial, final Date fechaFinal);
	public abstract List<TerminalLog> listaDeTerminalLog(List<Terminal> terminal, final Date fechaInicial,
			final Date fechaFinal, final boolean validez, final boolean esTraza, final Integer limite);
	public abstract List<JMEntidadObjeto> listaDeTerminalLogParaGrafica(final Date fechainicial, final Date fechaFinal,
			final String idterminal, final String reporte);
	public abstract List<JMEntidadObjeto> listaDeTerminalLogParaGraficaKMDia(final Date fechainicial,
			final Date fechaFinal, final String terminal);
	public abstract List<JMEntidadObjeto> listaDeTerminalLogParaTiempoDeParado(final Date fechainicial,
			final Date fechaFinal, final String terminal);
	public abstract List<TerminalLog> listaDeTerminalLogParaCoordenadas(Date fechaInicial, Date fechaFinal,
			String latitud, String longitud, String radio);
	

}