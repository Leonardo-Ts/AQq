package com.aaq.col.clases.database.servicios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.entidades.pojo.EstadisticaMonitorDataModel;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface TerminalServiceInterfase extends JMServicioGenericoInterfase<Terminal> {

	public abstract Terminal objetoTerminal(final String id);
	public abstract Terminal objetoTerminalParaNumeroProveedor(final Estado estado, final String numeroProveedor);
	public abstract Terminal objetoTerminalParaNumeroRadio(final Estado estado, final String numeroRadio);
	public abstract Terminal objetoTerminalParaNumeroReporte(final String numeroReporte);
	public abstract Terminal objetoTerminalParaNumeroTelefono(final String numeroTelefono)  ;
	public abstract Terminal objetoTerminalParaProveedorYPasswd(final String numeroProveedor, final String passwd) ;
	public abstract Terminal objetoTerminalParaDispositivoNombre(String string);
	public abstract Terminal objetoTerminalParaParametros(final Estado estado, final String numeroTerminal,
			final String numeroRadio, final String numeroProveedor, final String passwd, final String numeroReporte,
			final String numeroTelefono, final String dispositivoNombre) ;
	public abstract List<Terminal> listaDeTerminalParaCoordenadas(final String latitud, final String longitud, final boolean soloDisponibles);
	public abstract List<Terminal> listaDeTerminal() ;
	public abstract List<Terminal> listaDeTerminal(final Estado estado, final Base base) ;
	public abstract List<Terminal> listaDeTerminal(final Estado estado, final Base base,
			final Boolean soloValidasEnPosicion) ;
	public abstract List<Terminal> listaDeTerminal(final Estado estado, final Base base,
			final Boolean soloValidasEnPosicion, final Boolean soloValidasEnFecha);
	public abstract List<Terminal> listaDeTerminal(final Estado estado, final Base base, final List<Base> bases,
			final String nombre, final String terminal, final String numeroradio, final String numeroproveedor,
			final String passwd, final Boolean soloValidasEnPosicion, final Boolean soloValidasEnFecha,
			final String orden, final String filtro, final String idPermitido, final String estatus, final Boolean coordenadasDesdeBase, final Boolean coordenadasDesdeServicioWeb);
	public abstract JMResultadoOperacion ejecutarFuncionTerminalEstatus(Integer id, String estatus,
			String fuenteOperacion, String fuente, String numeroProveedor, String fuente_estatus) ;
	public abstract JMResultadoOperacion ejecutarFuncionTerminalEstatusTermino(Date fecha, String numeroProveedor,
			String fuente, String fuenteOperacion) ;
	public abstract JMResultadoOperacion ejecutarFuncionTerminalEstatusOtros(String numeroProveedor, String fuente,
			String fuenteOperacion) ;
	public abstract JMResultadoOperacion ejecutarFuncionTerminalEstatusOcupado(String numeroProveedor, String fuente,
			String fuenteOperacion);
	public abstract JMResultadoOperacion ejecutarFuncionTerminalEstatusDisponible(String numeroProveedor,
			String fuente, String fuenteOperacion) ;

	public abstract JMResultadoOperacion ejecutarFuncionTerminalCancelarReporte(Usuario usuario, String numeroProveedor,
			String numeroReporte, String fuente, String fuenteOperacion) ;
	public abstract JMResultadoOperacion ejecutarFuncionTerminalCancelarReporteSac(Usuario usuario, String numeroProveedor,
			String numeroReporte, String fuente, String fuenteOperacion) ;
	public abstract JMResultadoOperacion ejecutarFuncionTerminalEstatusDesconectado(String numeroProveedor,
			String fuente, String fuenteOperacion, final String estatus) ;
	public abstract JMResultadoOperacion ejecutarFuncionTerminalEstatusArribo(Date fecha, String numeroProveedor,
			String fuente, String fuenteOperacion);
	public abstract JMResultadoOperacion ejecutarFuncionTerminalAsignarReporte(Usuario usuario, String numeroProveedor,
			String numeroReporte, String fuente, String fuenteOperacion, Boolean proximidad) ;
	public abstract JMResultadoOperacion ejecutarFuncionTerminalAsignarReporteSac(Usuario usuario, String numeroProveedor,
			String numeroReporte, String fuente, String fuenteOperacion) ;
	public abstract JMResultadoOperacion ejecutarFuncionTerminalAsignarProximidad(final Integer id,
			final String fuente, final String fuenteOperacion) ;
	public abstract JMResultadoOperacion ejecutarFuncionTerminalInsertarCoordenadas(Integer id,
			Date ultimoLocalizacionFecha, String ultimoLocalizacionVelocidad, String latitud, String longitud,
			String direccion);
	public abstract JMResultadoOperacion ejecutarFuncionTerminalInsertarUltimoSiniestro(Integer id, String siniestro);
	public abstract JMResultadoOperacion ejecutarFuncionTerminalInsertarFechaLocalizacion(Integer id) ;
	public abstract JMResultadoOperacion ejecutarFuncionTerminalInsertarFechaUltimoLoginDia(Integer id);
	public abstract JMResultadoOperacion ejecutarFuncionTerminalInsertarUidAndroid(Integer id, String uid);
	public abstract JMResultadoOperacion eliminarObjeto(Terminal t) ;
	public abstract JMResultadoOperacion guardarObjeto(Terminal t);
	public List<Terminal> listaTodoDeTerminal() ;
	public List<Terminal> listaTodoDeTerminal(Boolean esReporteApartado);
	public EstadisticaMonitorDataModel obtenerEstadisticas(Integer idEntidad, Integer idBase);
	public EstadisticaMonitorDataModel obtenerEstadisticasFrecuencia(Integer idEntidad, String idBases);
	public abstract JMResultadoOperacion ejecutarFuncionTerminalInsertarFechaPush(Integer id);
	public abstract List<Terminal> listaDeTerminalSIICAWeb(String fuente);
	public abstract List<Terminal> listaDeAjustadoresTerminal(final Estado estado,final Base base,  final String estatus);
	public abstract JMResultadoOperacion ejecutarIntercambioReporte( String numeroProveedorA,
			String numeroReporteA, String numeroProveedorB, String numeroReporteB, String fuente,
			String fuenteOperacion);
	public abstract List<Terminal> listaDeTerminalModulo(final Estado estado, final Base base, final List<Base> bases,
			final String nombre, final String terminal, final String numeroradio, final String numeroproveedor,
			final String passwd, final Boolean soloValidasEnPosicion, final Boolean soloValidasEnFecha,
			final String orden, final String filtro, final String idPermitido,final String estatus, final Boolean coordenadasDesdeBase, final Boolean coordenadasDesdeServicioWeb);

}