package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Transaccion;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface TransaccionServiceInterfase extends JMServicioGenericoInterfase<Transaccion> {

	public abstract Transaccion objetoTransaccion(final String id) ;
	public abstract Transaccion objetoTransaccionParaNumeroReporte(final String numeroreporte) ;
	public abstract List<Transaccion> listaDeTransaccion(final String numeroreporte, final boolean aprobada);
	public abstract List<Transaccion> listaDeTransaccion(final String numeroreporte, final Terminal terminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas, final Object[] tiposPermitidos,
			final String edoTransaccion);
	public abstract List<JMEntidadObjeto> listaDeTransaccionParaGrafica(final String numeroreporte,
			final String idterminal, final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas,
			int estado, int base, String ajustador);
	public abstract JMResultadoOperacion eliminarObjeto(Transaccion t) ;
	public abstract JMResultadoOperacion guardarObjeto(Transaccion t) ;
	public abstract List<Transaccion> listaDeTransaccionNuevo(final String numeroreporte, final Terminal terminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas, final Object[] tiposPermitidos, 
			final Estado estado, final Base base,  String ajustador, final String edoTransaccion);
	public abstract List<EntidadObjeto> listaDeTransaccionParaGraficaNueva(final String numeroreporte, final String idterminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas, int estado, int base, String ajustador);
	public abstract Transaccion objetoTransaccionReporteCobro(final String numeroreporte, final String tipoDeCobro, final String fuente);
	public abstract Map<String, Object> rtrimTarjeta( final String fechaInicial, final String fechaFinal) ;
}