package com.aaq.col.system.webservices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.SessionExternaServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.UsuarioServiceInterfase;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public class SIICAExterno implements SIICAExternoInterface {

	@Autowired
	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase;

	@Autowired
	private SessionExternaServiceInterfase sessionExternaDao;

	@Autowired
	private TerminalServiceInterfase terminalDao;

	@Autowired
	private UsuarioServiceInterfase usuarioDao;
	

	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
			JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);

	private final String fuenteWS = "SIICA Servicios Web -> SIICA Externo -> ";
	
	public SIICAExterno() {
		super();

	}

	@Override
	public String ajustadoresCambiarEstatus(final String usuario, final String passwd, final String estatus) {

		if (StringUtils.isBlank(usuario)) {
			return "ERROR: Es necesario especificar un usuario";
		}
		if (StringUtils.isBlank(passwd)) {
			return "ERROR: Es necesario especificar una contrasena";
		}
		if (StringUtils.isBlank(estatus)) {
			return "ERROR: Es necesario especificar un estatus";
		}
		if (!StringUtils.equalsIgnoreCase(estatus, "Disponible") && !StringUtils.equalsIgnoreCase(estatus, "Ocupado")
				&& !StringUtils.equalsIgnoreCase(estatus, "Desconectado")) {
			return "ERROR: Es necesario especificar un estatus. Los valores disponibles son 'Disponible' 'Ocupado' 'Desconectado'";
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(usuario, passwd);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresCambiarEstatus => objetoTerminalParaProveedorYPasswd");
		}

		if (term == null) {
			return "ERROR: El usuario y contrasena indicados no son validos.";
		}
		String numReporte = null;
		if (term.getReporteSac() != null && term.getReporteSac().getGeneralNumeroReporte() != null) {
			numReporte = term.getReporteSac().getGeneralNumeroReporte();
		}
		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
					this.fuenteWS, "ajustadoresCambiarEstatus", "Se intenta cambiar de Estatus a: Usuario -> " + usuario + ", Passwd:" + passwd
							+ ", Estatus:" + estatus);
	
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresCambiarEstatus => ejecutarFuncionHistoricoTerminalNuevo");
		}

		try {
			this.sessionExternaDao.informacionDeSessionExterna(term, "Cambio de estatus a:  " + estatus);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresCambiarEstatus => informacionDeSessionExterna");
		}

		if (StringUtils.equalsIgnoreCase(estatus, "Disponible")) {

			if ((term.getReporteSise() != null)&&
					(StringUtils.isBlank(term.getReporteSise().getAjusteFechaArriboAjustador()) || StringUtils
							.isBlank(term.getReporteSise().getAjusteFechaTerminoAjustador()))) {

				try {
					this.historicoTerminalServiceInterfase
							.ejecutarFuncionHistoricoTerminalNuevo(
									null,
									term,
									term.getReporteSise().getGeneralNumeroReporte(),
									this.fuenteWS,
									"ajustadoresCambiarEstatus",
									"OVERRIDE!!! La terminal esta atendiendo el reporte "
											+ term.getReporteSise().getGeneralNumeroReporte()
											+ ", intento cambiar de estatus a 'Disponible', pero el reporte no tiene fecha de arribo o fecha de termino. Ignorando....");
				} catch (final Exception ex) {
					this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
							"ajustadoresCambiarEstatus => ejecutarFuncionHistoricoTerminalNuevo");
				}
				return "OK";
			}

			try {
				final JMResultadoOperacion r = this.terminalDao.ejecutarFuncionTerminalEstatusDisponible(usuario,
						JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "ajustadoresCambiarEstatus");

				return r != null ? r.getMensaje() : "ERROR";
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"ajustadoresCambiarEstatus => ejecutarFuncionTerminalEstatusDisponible");
				return "ERROR: " + ex.getMessage();
			}
		}

		if (StringUtils.equalsIgnoreCase(estatus, "Ocupado")) {
			// no hacer nada
		}

		if (StringUtils.equalsIgnoreCase(estatus, "Desconectado")) {
			JMResultadoOperacion r;
			try {
				//Validar si Ajustador tiene fecha y hora de Termino
				if(term.getReporteSac() != null && term.getFechaEstatusTermino() == null && term.getFechaEstatusDisponible() == null){
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, numReporte,
							this.fuenteWS, "ajustadoresCambiarEstatus", "Usuario -> " + usuario + ", Passwd:" + passwd
									+ ", Estatus:" + estatus + ", NO se puede Desconectar, reporte sin Termino (" + term.getUltimoLocalizacionReporte() + ")");
					return "No se puede Desconectar, reporte sin Termino (" + term.getUltimoLocalizacionReporte() + ")";
				}
				//Validar para Reporte SISE
				if(term.getReporteSise() != null){
					if(term.getUltimoLocalizacionReporte() != null && term.getFechaEstatusTermino() == null){
						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
								this.fuenteWS, "ajustadoresCambiarEstatus", "Usuario -> " + usuario + ", Passwd:" + passwd
										+ ", Estatus:" + estatus + ", NO se puede Desconectar, reporte sin Termino (" + term.getUltimoLocalizacionReporte() + ")");
						return "No se puede Desconectar, reporte sin Termino (" + term.getUltimoLocalizacionReporte() + ")";
					}
				}	
				r = this.terminalDao.ejecutarFuncionTerminalEstatusDesconectado(usuario,
						JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "ajustadoresCambiarEstatus", null);
				
				return (r != null ? r.getMensaje() : "ERROR");
				
				
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"ajustadoresCambiarEstatus => ejecutarFuncionTerminalEstatusDesconectado");
				return "ERROR: " + ex.getMessage();
			}

		}

		return "Sin Cambio de Estatus";

	}

	@Override
	public String ajustadoresIniciarSession(final String usuario, final String passwd) {
		if (StringUtils.isBlank(usuario)) {
			return "ERROR: Es necesario especificar un usuario";
		}
		if (StringUtils.isBlank(passwd)) {
			return "ERROR: Es necesario especificar una contrasena";
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(usuario, passwd);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresIniciarSession => objetoTerminalParaProveedorYPasswd");
		}

		if (term == null) {
			return "ERROR: El usuario y contrasena indicados no son validos.";
		}

		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
					this.fuenteWS, "ajustadoresIniciarSession", "Usuario -> " + usuario + ", Passwd:" + passwd);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresIniciarSession => ejecutarFuncionHistoricoTerminalNuevo");
		}

		try {
			this.sessionExternaDao.informacionDeSessionExterna(term, "Inicio de sesion con usuario y contraseña");
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresIniciarSession => informacionDeSessionExterna");
		}

		try {
			final JMResultadoOperacion r = this.terminalDao.ejecutarFuncionTerminalEstatusDisponible(usuario,
					JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "ajustadoresIniciarSesion");
			return r != null ? r.getMensaje() : "ERROR";
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresIniciarSession => ejecutarFuncionTerminalEstatusDisponible");
			return "ERROR: " + ex.getMessage();

		}

	}

	@Override
	public String ajustadoresInsertarCoordenadas(final String usuario, final String passwd, final String latitud,
			final String longitud, final String FechaLocalizacion, final String HoraLocalizacion,
			final String FechaRecepcion, final String HoraRecepcion, final String distanciaAlArribo) {

		if (StringUtils.isBlank(usuario)) {
			return "ERROR: Es necesario especificar un usuario";
		}
		if (StringUtils.isBlank(passwd)) {
			return "ERROR: Es necesario especificar una contrasena";
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(usuario, passwd);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarCoordenadas => objetoTerminalParaProveedorYPasswd");
		}

		if (term == null) {
			return "ERROR: El usuario y contrasena indicados no son validos.";
		}

		String respuesta =  this.ajustadoresInsertarCoordenadasConTelefono(term.getTelefono(), latitud, longitud, FechaLocalizacion,
				HoraLocalizacion, FechaRecepcion, HoraRecepcion);
		 
		return respuesta ;
		 

	}
	
	@Override
	public String ajustadoresInsertarCoordenadasConTelefono(final String telefono, final String latitud,
			final String longitud, final String FechaLocalizacion, final String HoraLocalizacion,
			final String FechaRecepcion, final String HoraRecepcion) {

		if (StringUtils.isBlank(telefono)) {
			return "ERROR: Es necesario especificar un telefono";
		}

		if (StringUtils.isBlank(latitud)) {
			return "ERROR: Es necesario especificar una latitud";
		}
		if (StringUtils.isBlank(longitud)) {
			return "ERROR: Es necesario especificar una longitud";
		}
		if (StringUtils.isBlank(FechaLocalizacion)) {
			return "ERROR: Es necesario especificar una fecha de localizacion";
		}
		if (StringUtils.isBlank(HoraLocalizacion)) {
			return "ERROR: Es necesario especificar una hora de localizacion";
		}
		if (StringUtils.isBlank(FechaRecepcion)) {
			return "ERROR: Es necesario especificar una fecha de recepcion";
		}
		if (StringUtils.isBlank(HoraRecepcion)) {
			return "ERROR: Es necesario especificar una hora de recepcion";
		}

		final DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date fechaLocalizacion = null;
		try {
			fechaLocalizacion = formatter.parse(FechaLocalizacion + " " + HoraLocalizacion);
		} catch (final ParseException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "ajustadoresInsertarCoordenadasConTelefono",
					"Telefono -> " + telefono + " Latitud:" + latitud + " Longitud:" + longitud + " FechaLocalizacion:"
							+ FechaLocalizacion + " HoraLocalizacion:" + HoraLocalizacion + " FechaRecepcion:"
							+ FechaRecepcion + " HoraRecepcion:" + HoraRecepcion);
			return "ERROR: La fecha no pudo ser interpretada correctamente. Por favor utilice el formato dd/MM/yyyy para fecha y HH:mm:ss para horario";
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaNumeroTelefono(telefono);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarCoordenadasConTelefono => objetoTerminalParaProveedorYPasswd");
		}

		if (term != null) {
			return term.procesarLatitudLongitud(latitud,longitud, 0, fechaLocalizacion);

		}

		Usuario usuario = null;
		try {
			usuario = this.usuarioDao.objetoUsuarioParaTelefono(telefono);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarCoordenadasConTelefono => objetoUsuarioParaTelefono");
		}

		if (usuario != null) {
			usuario.procesarLatitudLongitudFecha(latitud,longitud, fechaLocalizacion);
			return "OK";
		}

		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
					this.fuenteWS,
					"ajustadoresInsertarCoordenadasConTelefono. Identificador de Telefono NO encontrado", "Telefono "
							+ telefono + " Latitud:" + latitud + " Longitud:" + longitud + " FechaLocalizacion:"
							+ FechaLocalizacion + " HoraLocalizacion:" + HoraLocalizacion + " FechaRecepcion:"
							+ FechaRecepcion + " HoraRecepcion:" + HoraRecepcion);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarCoordenadasConTelefono => ejecutarFuncionHistoricoTerminalNuevo");

		}

		return "ERROR: El telefono indicado no fue encontrado en la base de datos.";

	}



}
