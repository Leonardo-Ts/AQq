package com.aaq.col.clases.database.servicios.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.pojo.EstadisticaMonitorDataModel;
import com.aaq.col.clases.database.repositorios.impl.TerminalDao;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("terminalService")
@Transactional
public class TerminalService implements TerminalServiceInterfase {
	
	@Autowired
	@Qualifier("terminalDao")
	TerminalDao terminalDao;

	@Override
	public Terminal objetoTerminal(final String id) {
		return this.terminalDao.objetoTerminal(id);
	}

	@Override
	public Terminal objetoTerminalParaNumeroProveedor(final Estado estado, final String numeroProveedor) {
		return this.terminalDao.objetoTerminalParaNumeroProveedor(estado, numeroProveedor);
	}

	@Override
	public Terminal objetoTerminalParaNumeroRadio(final Estado estado, final String numeroRadio) {
		return this.terminalDao.objetoTerminalParaNumeroRadio(estado, numeroRadio);
	}

	@Override
	public Terminal objetoTerminalParaNumeroReporte(final String numeroReporte) {
		return this.terminalDao.objetoTerminalParaNumeroReporte(numeroReporte);
	}

	@Override
	public Terminal objetoTerminalParaNumeroTelefono(final String numeroTelefono) {
		return this.terminalDao.objetoTerminalParaNumeroTelefono(numeroTelefono);
	}

	@Override
	public Terminal objetoTerminalParaProveedorYPasswd(final String numeroProveedor, final String passwd) {
		return this.terminalDao.objetoTerminalParaProveedorYPasswd(numeroProveedor, passwd);
	}

	@Override
	public Terminal objetoTerminalParaDispositivoNombre(final String dispositivoNombre) {
		return this.terminalDao.objetoTerminalParaDispositivoNombre(dispositivoNombre);
	}

	@Override
	public Terminal objetoTerminalParaParametros(final Estado estado, final String numeroTerminal,
			final String numeroRadio, final String numeroProveedor, final String passwd, final String numeroReporte,

			final String numeroTelefono, final String dispositivoNombre) {
		return this.terminalDao.objetoTerminalParaParametros(estado, numeroTerminal, numeroRadio, numeroProveedor,
				passwd, numeroReporte, numeroTelefono, dispositivoNombre);
	}

	@Override
	public List<Terminal> listaDeTerminalParaCoordenadas(final String latitud, final String longitud, final boolean soloDisponibles ) {
		return this.terminalDao.listaDeTerminalParaCoordenadas(latitud, longitud, soloDisponibles);
	}

	@Override
	public List<Terminal> listaDeTerminal() {
		return this.terminalDao.listaDeTerminal();
	}
	
	@Override
	public List<Terminal> listaDeTerminalSIICAWeb(String fuente) {
		return this.terminalDao.listaDeTerminal(null, null, null, null, null, null, null,
				null, false, false, null, null, null, null,false,false, fuente);
	}

	@Override
	public List<Terminal> listaDeTerminal(final Estado estado, final Base base) {
		return this.terminalDao.listaDeTerminal(estado, base);
	}

	@Override
	public List<Terminal> listaDeTerminal(final Estado estado, final Base base, final Boolean soloValidasEnPosicion) {
		return this.terminalDao.listaDeTerminal(estado, base, soloValidasEnPosicion);
	}

	@Override
	public List<Terminal> listaDeTerminal(final Estado estado, final Base base, final Boolean soloValidasEnPosicion,
			final Boolean soloValidasEnFecha) {
		return this.terminalDao.listaDeTerminal(estado, base, soloValidasEnPosicion, soloValidasEnFecha);
	}

	@Override
	public List<Terminal> listaDeTerminal(final Estado estado, final Base base, final List<Base> bases,
			final String nombre, final String terminal, final String numeroradio, final String numeroproveedor,
			final String passwd, final Boolean soloValidasEnPosicion, final Boolean soloValidasEnFecha,
			final String orden, final String filtro, final String idPermitido,final String estatus, final Boolean coordenadasDesdeBase, final Boolean coordenadasDesdeServicioWeb) {

		return this.terminalDao.listaDeTerminal(estado, base, bases, nombre, terminal, numeroradio, numeroproveedor,
				passwd, soloValidasEnPosicion, soloValidasEnFecha, orden, filtro, idPermitido,estatus,coordenadasDesdeBase,coordenadasDesdeServicioWeb, null);
	}

	@Override
	public List<Terminal> listaDeTerminalModulo(final Estado estado, final Base base, final List<Base> bases,
			final String nombre, final String terminal, final String numeroradio, final String numeroproveedor,
			final String passwd, final Boolean soloValidasEnPosicion, final Boolean soloValidasEnFecha,
			final String orden, final String filtro, final String idPermitido,final String estatus, final Boolean coordenadasDesdeBase, final Boolean coordenadasDesdeServicioWeb) {
		
		return this.terminalDao.listaDeTerminalModulo(estado, base, bases, nombre, terminal, numeroradio, numeroproveedor,
				passwd, soloValidasEnPosicion, soloValidasEnFecha, orden, filtro, idPermitido,estatus,coordenadasDesdeBase,coordenadasDesdeServicioWeb, null);
	}
	
//	@Override
//	public JMResultadoOperacion ejecutarFuncionTerminalEstatus(final Integer id, final String estatus,
//			final String fuenteOperacion, final String fuente) {
//		return this.terminalDao.ejecutarFuncionTerminalEstatus(id, estatus, fuenteOperacion, fuente);
//	}
	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatus(final Integer id, final String estatus,
			final String fuenteOperacion, final String fuente, final String numeroProveedor, final String fuenteEstatus) {
		return this.terminalDao.ejecutarFuncionTerminalEstatus(id, estatus, fuenteOperacion, fuente, numeroProveedor, fuenteEstatus);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusTermino(final Date fecha, final String numeroProveedor,
			final String fuente, final String fuenteOperacion) {
		return this.terminalDao.ejecutarFuncionTerminalEstatusTermino(fecha, numeroProveedor, fuente, fuenteOperacion);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusOtros(final String numeroProveedor, final String fuente,
			final String fuenteOperacion) {
		return this.terminalDao.ejecutarFuncionTerminalEstatusOtros(numeroProveedor, fuente, fuenteOperacion);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusOcupado(final String numeroProveedor,
			final String fuente, final String fuenteOperacion) {
		return this.terminalDao.ejecutarFuncionTerminalEstatusOcupado(numeroProveedor, fuente, fuenteOperacion);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusDisponible(final String numeroProveedor,
			final String fuente, final String fuenteOperacion) {
		return this.terminalDao.ejecutarFuncionTerminalEstatusDisponible(numeroProveedor, fuente, fuenteOperacion);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalCancelarReporte(final Usuario usuario, final String numeroProveedor,
			final String numeroReporte, final String fuente, final String fuenteOperacion) {
		return this.terminalDao.ejecutarFuncionTerminalCancelarReporte(usuario, numeroProveedor, numeroReporte, fuente,
				fuenteOperacion);
	}
	
	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalCancelarReporteSac(final Usuario usuario, final String numeroProveedor,
			final String numeroReporte, final String fuente, final String fuenteOperacion) {
		return this.terminalDao.ejecutarFuncionTerminalCancelarReporteSac(usuario, numeroProveedor, numeroReporte, fuente,
				fuenteOperacion);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusDesconectado(final String numeroProveedor,
			final String fuente, final String fuenteOperacion, final String estatus) {
		return this.terminalDao.ejecutarFuncionTerminalEstatusDesconectado(numeroProveedor, fuente, fuenteOperacion,
				estatus);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalEstatusArribo(final Date fecha, final String numeroProveedor,
			final String fuente, final String fuenteOperacion) {
		return this.terminalDao.ejecutarFuncionTerminalEstatusArribo(fecha, numeroProveedor, fuente, fuenteOperacion);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalAsignarReporte(final Usuario usuario, final String numeroProveedor,
			final String numeroReporte, final String fuente, final String fuenteOperacion, final Boolean proximidad) {
		return this.terminalDao.ejecutarFuncionTerminalAsignarReporte(usuario, numeroProveedor, numeroReporte, fuente,
				fuenteOperacion, proximidad);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalAsignarReporteSac(final Usuario usuario, final String numeroProveedor,
			final String numeroReporte, final String fuente, final String fuenteOperacion) {
		return this.terminalDao.ejecutarFuncionTerminalAsignarReporteSac(usuario, numeroProveedor, numeroReporte, fuente,
				fuenteOperacion);
	}
	
	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalAsignarProximidad(final Integer id, final String fuente,
			final String fuenteOperacion) {
		return this.terminalDao.ejecutarFuncionTerminalAsignarProximidad(id, fuente, fuenteOperacion);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarCoordenadas(final Integer id,
			final Date ultimoLocalizacionFecha, final String ultimoLocalizacionVelocidad, final String latitud,
			final String longitud, final String direccion) {
		return this.terminalDao.ejecutarFuncionTerminalInsertarCoordenadas(id, ultimoLocalizacionFecha,
				ultimoLocalizacionVelocidad, latitud, longitud, direccion);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarUltimoSiniestro(final Integer id, final String siniestro) {
		return this.terminalDao.ejecutarFuncionTerminalInsertarUltimoSiniestro(id, siniestro);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarFechaLocalizacion(final Integer id) {
		return this.terminalDao.ejecutarFuncionTerminalInsertarFechaLocalizacion(id);
	}

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarFechaUltimoLoginDia(final Integer id) {
		return this.terminalDao.ejecutarFuncionTerminalInsertarFechaUltimoLoginDia(id);
	}
	
	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarUidAndroid(final Integer id,final String uid) {
		return this.terminalDao.ejecutarFuncionTerminalInsertarUidAndroid(id, uid);
	}	

	@Override
	public JMResultadoOperacion eliminarObjeto(final Terminal t) {
		return this.terminalDao.eliminarObjeto(t);
	}

	@Override
	public JMResultadoOperacion guardarObjeto(final Terminal t) {
		return this.terminalDao.guardarObjeto(t);
	}
	
	@Override
	public List<Terminal> listaTodoDeTerminal(){
		return this.terminalDao.listaTodoDeTerminal();
	}
	
	@Override
	public List<Terminal> listaTodoDeTerminal(Boolean esReporteApartado){
		return this.terminalDao.listaTodoDeTerminal(esReporteApartado);
	}

	@Override
	public EstadisticaMonitorDataModel obtenerEstadisticas(Integer idEntidad,
			Integer idBase) {
		return this.terminalDao.obtenerEstadisticas(idEntidad, idBase);
	}
	
	@Override
	public EstadisticaMonitorDataModel obtenerEstadisticasFrecuencia(Integer idEntidad,
			String idBases){
		return this.terminalDao.obtenerEstadisticasFrecuencia(idEntidad, idBases);
	}
	

	@Override
	public JMResultadoOperacion ejecutarFuncionTerminalInsertarFechaPush(
			Integer id) {
		return this.terminalDao.ejecutarFuncionTerminalInsertarFechaPush(id);
	}
	
	@Override
	public List<Terminal> listaDeAjustadoresTerminal( Estado estado,  Base base,  String estatus) {
		return this.terminalDao.listarDeAjustadores(estado, base, estatus);
	}

	@Override
	public JMResultadoOperacion ejecutarIntercambioReporte( String numeroProveedorA,
			String numeroReporteA, String numeroProveedorB, String numeroReporteB, String fuente,
			String fuenteOperacion) {
		return this.terminalDao.ejecutarIntercambioReporte(numeroProveedorA, numeroReporteA,
				numeroProveedorB, numeroReporteB, fuente, fuenteOperacion);
	}
}