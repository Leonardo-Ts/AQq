package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.TerminalLog;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface TerminalLogServiceInterfase extends JMServicioGenericoInterfase<TerminalLog> {

	public abstract TerminalLog objetoTerminalLog(final String id) ;
	public abstract List<TerminalLog> listaDeTerminalLog(final Date fechaInicial, final Date fechaFinal);
	public abstract List<TerminalLog> listaDeTerminalLog(List<Terminal> terminal, final Date fechaInicial,
			final Date fechaFinal, final boolean validez, final boolean esTraza, final Integer limite) ;
	public abstract List<TerminalLog> listaDeTerminalLogParaCoordenadas(Date fechaInicial, Date fechaFinal,
			String latitud, String longitud, String radio) ;
	public abstract List<JMEntidadObjeto> listaDeTerminalLogParaGrafica(final Date fechainicial, final Date fechaFinal,
			final String idterminal, final String reporte) ;
	public abstract List<JMEntidadObjeto> listaDeTerminalLogParaGraficaKMDia(final Date fechainicial,
			final Date fechaFinal, final String terminal) ;
	public abstract List<JMEntidadObjeto> listaDeTerminalLogParaTiempoDeParado(final Date fechainicial,
			final Date fechaFinal, final String terminal) ;
	public abstract JMResultadoOperacion eliminarObjeto(TerminalLog t) ;
	public abstract JMResultadoOperacion guardarObjeto(TerminalLog t) ;
}