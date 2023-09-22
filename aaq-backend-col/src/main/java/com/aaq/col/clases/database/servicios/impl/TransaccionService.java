package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Transaccion;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.repositorios.impl.TransaccionDao;
import com.aaq.col.clases.database.servicios.interfase.TransaccionServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("transaccionService")
@Transactional
public class TransaccionService implements TransaccionServiceInterfase {
	
	Log4JLogger loggerWS = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.webservices");

	@Autowired
	@Qualifier("transaccionDao")
	TransaccionDao transaccionDao;

	@Override
	public Transaccion objetoTransaccion(final String id) {
		return this.transaccionDao.objetoTransaccion(id);
	}

	@Override
	public Transaccion objetoTransaccionParaNumeroReporte(final String numeroreporte) {
		return this.transaccionDao.objetoTransaccionParaNumeroReporte(numeroreporte);
	}

	@Override
	public List<Transaccion> listaDeTransaccion(final String numeroreporte, final boolean aprobada) {
		return this.transaccionDao.listaDeTransaccion(numeroreporte, aprobada);
	}

	@Override
	public List<Transaccion> listaDeTransaccion(final String numeroreporte, final Terminal terminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas, final Object[] tiposPermitidos, final String edoTransaccion) {
		return this.transaccionDao.listaDeTransaccion(numeroreporte, terminal, fechaInicial, fechaFinal, soloAprobadas,
				tiposPermitidos);
	}

	@Override
	public List<JMEntidadObjeto> listaDeTransaccionParaGrafica(final String numeroreporte, final String idterminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas, int estado, int base, String ajustador) {
		return this.transaccionDao.listaDeTransaccionParaGrafica(numeroreporte, idterminal, fechaInicial, fechaFinal,
				soloAprobadas, estado, base, ajustador);
	}

	@Override
	public JMResultadoOperacion eliminarObjeto(final Transaccion t) {
		return this.transaccionDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Transaccion t) {
		return this.transaccionDao.guardarObjeto(t);
	}

	@Override
	public List<Transaccion> listaDeTransaccionNuevo(String numeroreporte, Terminal terminal, Date fechaInicial,
			Date fechaFinal, Boolean soloAprobadas, Object[] tiposPermitidos,final Estado estado, final Base base,
			String ajustador, String edoTransaccion) {
		return this.transaccionDao.listaDeTransaccionNuevo(numeroreporte, terminal, fechaInicial, fechaFinal, soloAprobadas,
				tiposPermitidos, estado, base, ajustador, edoTransaccion);
	}
	
	@Override
	public List<EntidadObjeto> listaDeTransaccionParaGraficaNueva(final String numeroreporte, final String idterminal,
			final Date fechaInicial, final Date fechaFinal, final Boolean soloAprobadas, int estado, int base, String ajustador) {
		return this.transaccionDao.listaDeTransaccionParaGraficaNuevo(numeroreporte, idterminal, fechaInicial, fechaFinal,
				soloAprobadas, estado, base, ajustador);
	}

	@Override
	public Transaccion objetoTransaccionReporteCobro(String numeroreporte, String tipoDeCobro, String fuente) {
		return this.transaccionDao.objetoTransaccionReporteCobro(numeroreporte, tipoDeCobro, fuente);
	}

	@Override
	public Map<String, Object> rtrimTarjeta(String fechaInicial, String fechaFinal) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Transaccion> lista = this.transaccionDao.listaParaDepu(fechaInicial, fechaFinal);
			if (lista != null) {
				if ( !lista.isEmpty()) {
					for (int i = 0; i < lista.size(); i++) {
						String[] varVoucher = null;
						String voucherAfter = "";
						String voucherARecorrer = lista.get(i).getVoucherGeneral().trim();
						varVoucher = voucherARecorrer.split("@");
				        for (int j = 1; j < varVoucher.length; j++) {
				        	if (varVoucher[j].contains("Tarjeta")) {
				        		voucherAfter =voucherAfter +"";
							} else {
								voucherAfter = voucherAfter + "@"+varVoucher[j];
								}
							}
				        //Aqui podemos guardar
				       try { 
				       lista.get(i).setVoucherGeneral(voucherAfter);
				       lista.get(i).setXmlTarjeta(null);
				       lista.get(i).guardarObjeto();
				       } catch (RollbackException | IllegalStateException | IndexOutOfBoundsException e) {
				    	   this.loggerWS.error("Ocurrio un error en rtrimTarjeta -> "+e);
				       } catch (PersistenceException | DataAccessException e) {
				    	   this.loggerWS.error("Ocurrio un error en rtrimTarjeta -> "+e);
					}
				}
					map.put("mensaje", "Exito en el proceso de suplantación de "+lista.size()+" reportes.");
					map.put("exito", true);
					return map;
			} else {
				map.put("mensaje", "Datos no encontrados en el rango de fechas.");
				map.put("exito", false);
				return map;
			}
			} else {
				map.put("mensaje", "Datos no encontrados en el rango de fechas.");
				map.put("exito", false);
				return map;
			}
		} catch (IndexOutOfBoundsException | IllegalStateException | ClassCastException | PersistenceException e) {
			this.loggerWS.error("Ocurrio un error en rtrimTarjeta -> "+e);
			map.put("mensaje", "Ocurrio un error en el proceso: "+e);
			map.put("exito", false);
			return map;
		}
		
	}
}