 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Transaccion;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;


public interface TransaccionDaoInterfase extends JMRepositorioGenericoInterfase<Transaccion> {

	public abstract Transaccion objetoTransaccion(final String id);
	public abstract Transaccion objetoTransaccionParaNumeroReporte(final String numeroreporte);
	public abstract List<Transaccion> listaDeTransaccion(final String numeroreporte, final boolean aprobada);
	public abstract List<Transaccion> listaDeTransaccion(final String numeroreporte, final Terminal terminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas, final Object[] tiposPermitidos);
	public abstract List<JMEntidadObjeto> listaDeTransaccionParaGrafica(final String numeroreporte,
			final String idterminal, final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas, int estado, int base, String ajustador);
	public abstract List<Transaccion> listaDeTransaccionNuevo(final String numeroreporte, final Terminal terminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas, final Object[] tiposPermitidos,
			final Estado estado, final Base base, String ajustador, final String edoTransaccion);
	public abstract List<EntidadObjeto> listaDeTransaccionParaGraficaNuevo(final String numeroreporte, final String idterminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas,
			int estado, int  base, String ajustador );
	public abstract Transaccion objetoTransaccionReporteCobro(final String numeroreporte, final String tipoDeCobro, final String fuente);
	public abstract List<Transaccion> listaParaDepu( final String fechaInicial, final String fechaFinal);

}