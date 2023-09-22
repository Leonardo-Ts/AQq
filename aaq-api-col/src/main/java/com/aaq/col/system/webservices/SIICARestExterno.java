package com.aaq.col.system.webservices;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.QueryTimeoutException;
import javax.persistence.RollbackException;
import javax.persistence.TransactionRequiredException;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.aaq.col.clases.database.entidades.ReporteAbogado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Transaccion;
import com.aaq.col.clases.database.entidades.Usuario;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteAbogadoServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.SessionExternaServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.UsuarioServiceInterfase;
import com.aaq.col.clases.pojo.aaq.AjustAInsertarArriboAbog;
import com.aaq.col.clases.pojo.aaq.AjustRealizarCobro;
import com.aaq.col.clases.pojo.aaq.CambiarEstatus;
import com.aaq.col.clases.pojo.aaq.InsertarAbogAsignado;
import com.aaq.col.clases.pojo.aaq.InsertarCoordenadas;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.JMUtileriaBancaria;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.webservices.movil.MovilResultadoOp;

public class SIICARestExterno implements SIICARestExternoInterface {

	private final String fuenteWS = "SIICA REST Externo -> ";
	
	@Autowired
	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase;

	@Autowired
	private SessionExternaServiceInterfase sessionExternaDao;

	@Autowired
	private TerminalServiceInterfase terminalDao;

	@Autowired
	private UsuarioServiceInterfase usuarioDao;
	
	@Autowired
	private ReporteAbogadoServiceInterfase reporteAbogadoDao;


	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
			JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);

	public SIICARestExterno() {
		super();

	}
	@Override
	public MovilResultadoOp ajustadoresIniciarSession(final String usuario, final String passwd) {
		if (StringUtils.isBlank(usuario)) {
			return new MovilResultadoOp("ERROR: Es necesario especificar un usuario");
		}
		if (StringUtils.isBlank(passwd)) {
			return new MovilResultadoOp( "ERROR: Es necesario especificar una contrasena");
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(usuario, passwd);
		} catch (final ClassCastException | RollbackException | DataAccessException | IllegalArgumentException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresIniciarSession => objetoTerminalParaProveedorYPasswd");
		} catch (final IllegalStateException | PersistenceException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresIniciarSession => objetoTerminalParaProveedorYPasswd");
		}

		if (term == null) {
			return  new MovilResultadoOp("ERROR: El usuario y contrasena indicados no son validos.");
		}

		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
					this.fuenteWS, "ajustadoresIniciarSession", "Usuario -> " + usuario + ", Passwd:" + passwd);
		} catch (final RollbackException | IllegalArgumentException | QueryTimeoutException | TransactionRequiredException | NoResultException | NonUniqueResultException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),"ajustadoresIniciarSession => ejecutarFuncionHistoricoTerminalNuevo");
		} catch (PersistenceException | DataAccessException | ClassCastException | IndexOutOfBoundsException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"ajustadoresIniciarSession => ejecutarFuncionHistoricoTerminalNuevo");
		}

		try {
			this.sessionExternaDao.informacionDeSessionExterna(term, "Inicio de sesion con usuario y contraseña");
		} catch (final RollbackException | IllegalArgumentException | QueryTimeoutException | TransactionRequiredException | NoResultException | NonUniqueResultException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),"ajustadoresIniciarSession => informacionDeSessionExterna");
		} catch (PersistenceException | DataAccessException | ClassCastException | IndexOutOfBoundsException e) {
			 this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"ajustadoresIniciarSession => informacionDeSessionExterna");
		}

		try {
			final JMResultadoOperacion r = this.terminalDao.ejecutarFuncionTerminalEstatusDisponible(usuario,
					JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "ajustadoresIniciarSesion");
//			 r != null ? r.getMensaje() : "ERROR";
			return new MovilResultadoOp( r != null ? r.getMensaje() : "ERROR");
		} catch (final RollbackException | IllegalArgumentException | QueryTimeoutException | TransactionRequiredException | NoResultException | NonUniqueResultException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),"ajustadoresIniciarSession => ejecutarFuncionTerminalEstatusDisponible");
			return new MovilResultadoOp("ERROR: " + ex.getMessage());
		} catch (PersistenceException | DataAccessException | ClassCastException | IndexOutOfBoundsException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"ajustadoresIniciarSession => ejecutarFuncionTerminalEstatusDisponible");
			return new MovilResultadoOp("ERROR: " + e.getMessage());

		}
	}
	
	@Override
	public MovilResultadoOp ajustadoresInsertarCoordenadas(InsertarCoordenadas serv) {

		if (StringUtils.isBlank(serv.getUsuario())) {
			return new  MovilResultadoOp("ERROR: Es necesario especificar un usuario");
		}
		if (StringUtils.isBlank(serv.getPasswd())) {
			return new MovilResultadoOp("ERROR: Es necesario especificar una contrasena");
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarCoordenadas => objetoTerminalParaProveedorYPasswd");
		}

		if (term == null) {
			return new MovilResultadoOp("ERROR: El usuario y contrasena indicados no son validos.");
		}

//		return this.ajustadoresInsertarCoordenadasConTelefono(term.getTelefono(), latitud, longitud, FechaLocalizacion,
//				HoraLocalizacion, FechaRecepcion, HoraRecepcion);
		String respuesta =  this.ajustadoresInsertarCoordenadasConTelefono(term.getTelefono(), serv.getLatitud(), 
				serv.getLongitud(), serv.getFechaLocalizacion(),
				serv.getHoraLocalizacion(), serv.getFechaRecepcion(), serv.getHoraRecepcion());
		return new MovilResultadoOp(respuesta) ;
	}

	
	public String ajustadoresInsertarCoordenadasConTelefono(final String telefono, final String latitud,
			final String longitud, final String FechaLocalizacion, final String HoraLocalizacion,
			final String FechaRecepcion, final String HoraRecepcion) {

		if (StringUtils.isBlank(telefono)) {
			return  "ERROR: Es necesario especificar un telefono";
		}

		if (StringUtils.isBlank(latitud)) {
		return  "ERROR: Es necesario especificar una latitud";
		}
		if (StringUtils.isBlank(longitud)) {
			return "ERROR: Es necesario especificar una longitud";
		}
		if (StringUtils.isBlank(FechaLocalizacion)) {
			return "ERROR: Es necesario especificar una fecha de localizacion";
		}
		if (StringUtils.isBlank(HoraLocalizacion)) {
			return  "ERROR: Es necesario especificar una hora de localizacion";
		}
		if (StringUtils.isBlank(FechaRecepcion)) {
			return  "ERROR: Es necesario especificar una fecha de recepcion";
		}
		if (StringUtils.isBlank(HoraRecepcion)) {
			return  "ERROR: Es necesario especificar una hora de recepcion";
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
			return  term.procesarLatitudLongitud(longitud, latitud, 0, fechaLocalizacion);

		}

		Usuario usuario = null;
		try {
			usuario = this.usuarioDao.objetoUsuarioParaTelefono(telefono);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarCoordenadasConTelefono => objetoUsuarioParaTelefono");
		}

		if (usuario != null) {
			usuario.procesarLatitudLongitudFecha(longitud, latitud, fechaLocalizacion);
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
	
	@Override
	public MovilResultadoOp ajustadoresCambiarEstatus(CambiarEstatus serv) {

		if (StringUtils.isBlank(serv.getUsuario())) {
			return new MovilResultadoOp( "ERROR: Es necesario especificar un usuario");
		}
		if (StringUtils.isBlank(serv.getPasswd())) {
			return  new MovilResultadoOp("ERROR: Es necesario especificar una contrasena");
		}
		if (StringUtils.isBlank(serv.getEstatus())) {
			return new MovilResultadoOp( "ERROR: Es necesario especificar un estatus");
		}
		if (!StringUtils.equalsIgnoreCase(serv.getEstatus(), "Disponible") && !StringUtils.equalsIgnoreCase(serv.getEstatus(), "Ocupado")
				&& !StringUtils.equalsIgnoreCase(serv.getEstatus(), "Desconectado")) {
			return new MovilResultadoOp( "ERROR: Es necesario especificar un estatus. Los valores disponibles son 'Disponible' 'Ocupado' 'Desconectado'");
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresCambiarEstatus => objetoTerminalParaProveedorYPasswd");
		}

		if (term == null) {
			return new MovilResultadoOp( "ERROR: El usuario y contrasena indicados no son validos.");
		}

		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
					this.fuenteWS, "ajustadoresCambiarEstatus", "Se intenta cambiar de Estatus a: Usuario -> " 
							+ serv.getUsuario() + ", Passwd:" + serv.getPasswd()
							+ ", Estatus:" + serv.getEstatus());
	
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresCambiarEstatus => ejecutarFuncionHistoricoTerminalNuevo");
		}

		try {
			this.sessionExternaDao.informacionDeSessionExterna(term, "Cambio de estatus a:  " + serv.getEstatus());
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresCambiarEstatus => informacionDeSessionExterna");
		}

		if (StringUtils.equalsIgnoreCase(serv.getEstatus(), "Disponible")) {

			if ((term.getReporteSise() != null)

					&&

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
				return new MovilResultadoOp("OK");
			}

			try {
				final JMResultadoOperacion r = this.terminalDao.ejecutarFuncionTerminalEstatusDisponible(serv.getUsuario(),
						JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "ajustadoresCambiarEstatus");

				return new MovilResultadoOp( r != null ? r.getMensaje() : "ERROR");
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"ajustadoresCambiarEstatus => ejecutarFuncionTerminalEstatusDisponible");
				return  new MovilResultadoOp("ERROR: " + ex.getMessage());
			}
		}

		if (StringUtils.equalsIgnoreCase(serv.getEstatus(), "Ocupado")) {
			// no hacer nada
		}

		if (StringUtils.equalsIgnoreCase(serv.getEstatus(), "Desconectado")) {
			JMResultadoOperacion r;
			try {
				
				//Validar si Ajustador tiene fecha y hora de Termino
				if(term.getReporteSac() != null && term.getFechaEstatusTermino() == null && term.getFechaEstatusDisponible() == null){
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
							this.fuenteWS, "ajustadoresCambiarEstatus", "Usuario -> " + serv.getUsuario() + ", Passwd:" + serv.getPasswd()
									+ ", Estatus:" + serv.getEstatus() + ", NO se puede Desconectar, reporte sin Termino (" + term.getUltimoLocalizacionReporte() + ")");
					return  new MovilResultadoOp("No se puede Desconectar, reporte sin Termino (" + term.getUltimoLocalizacionReporte() + ")");
				}
				
				//Validar para Reporte SISE
				if(term.getReporteSise() != null){
					if(term.getUltimoLocalizacionReporte() != null && term.getFechaEstatusTermino() == null){
						this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, null,
								this.fuenteWS, "ajustadoresCambiarEstatus", "Usuario -> " + serv.getUsuario() + ", Passwd:" + serv.getPasswd()
										+ ", Estatus:" + serv.getEstatus() + ", NO se puede Desconectar, reporte sin Termino (" + term.getUltimoLocalizacionReporte() + ")");
						return new MovilResultadoOp ("No se puede Desconectar, reporte sin Termino (" + term.getUltimoLocalizacionReporte() + ")");
					}
				}	
				r = this.terminalDao.ejecutarFuncionTerminalEstatusDesconectado(serv.getUsuario(),
						JMConstantes.SOCKET_FUENTE_CELULAR, this.fuenteWS + "ajustadoresCambiarEstatus", null);
				
//				if (serv.getEstatus().equals("Desconectado")){
//					try {
//						this.alertasService.logoutAlerta(term);
//					} catch (Exception ex) {
//						this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
//								"AlertaLogOut => Error al enviar alerta de Logout.");
//					}	
//				}
				return  new MovilResultadoOp ((r != null ? r.getMensaje() : "ERROR"));
				
				
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"ajustadoresCambiarEstatus => ejecutarFuncionTerminalEstatusDesconectado");
				return new MovilResultadoOp ( "ERROR: " + ex.getMessage());
			}

		}

		return new MovilResultadoOp( "Sin Cambio de Estatus");
	}
	
	
	@Override
	public MovilResultadoOp ajustadoresRealizarCobro(AjustRealizarCobro serv) {

		if (StringUtils.isBlank(serv.getUsuario())) {
			return new MovilResultadoOp( "ERROR: Es necesario especificar un usuario");
		}
		if (StringUtils.isBlank(serv.getPasswd())) {
			return new MovilResultadoOp( "ERROR: Es necesario especificar una contrasena");
		}
		if (StringUtils.isBlank(serv.getReporte())) {
			return new MovilResultadoOp("ERROR: Es necesario especificar un numero de reporte");
		}
		if (StringUtils.isBlank(serv.getTipoCobro())) {
			return new MovilResultadoOp("ERROR: Es necesario especificar un tipo de cobro. Pago de Prima, Pago de Deducible o Pago de Poliza (P.P. P.D. P.R)");
		}
		if (StringUtils.length(serv.getTarjetaNumero()) < 5) {
			return new MovilResultadoOp("ERROR: El nombre especificado es muy corto");
		}
		if (StringUtils.length(serv.getTarjetaCVV()) != 3) {
			return new MovilResultadoOp( "ERROR: El codigo CVV debe de tener solamente 3 digitos numerico");
		}

		if (StringUtils.length(serv.getTarjetaExpiraAno()) != 2) {
			return new MovilResultadoOp("ERROR: El anio de expiracion de la tarjeta debe de contener solamente 2 digitos numericos");
		}
		if (StringUtils.length(serv.getTarjetaExpiraMes()) != 2) {
			return new MovilResultadoOp("ERROR: El mes de expiracion de la tarjeta debe de contener solamente 2 digitos numericos");
		}

		if (StringUtils.isBlank(serv.getTarjetaNumero())) {
			return new MovilResultadoOp( "ERROR: Es necesario especificar el numero de 16 digitos de la tarjeta de credito");
		}
		if (StringUtils.isBlank(serv.getTarjetaTipo())) {
			return new MovilResultadoOp( "ERROR: Es necesario especificar el tipo de la tarjeta de credito");
		}
		if (StringUtils.isBlank(serv.getMonto())) {
			return new MovilResultadoOp("ERROR: Es necesario especificar el monto a cobrar de la tarjeta de credito");
		}

		if (!StringUtils.equalsIgnoreCase(serv.getTipoCobro(), "P.P.") && !StringUtils.equalsIgnoreCase(serv.getTipoCobro(), "P.D.")
				&& !StringUtils.equalsIgnoreCase(serv.getTipoCobro(), "P.R.")) {
			return new MovilResultadoOp("ERROR: El tipo de cobro no es correcto. Los valores permitidos son 'P.P.', 'P.D.', 'P.R.'");
		}

		if (!StringUtils.equalsIgnoreCase(serv.getTarjetaTipo(), "V/MC") && !StringUtils.equalsIgnoreCase(serv.getTarjetaTipo(), "AMEX")) {
			return new MovilResultadoOp("ERROR: El tipo de tarjeta. Los valores permitidos son 'V/MC', 'AMEX'");
		}

		if (StringUtils.length(serv.getTelefono()) != 10) {
			return new MovilResultadoOp("ERROR: El numero de telefono celular debe ser en formato de 10 digitos numericos sin 044.");
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresRealizarCobro => objetoTerminalParaProveedorYPasswd");
		}
		if (term == null) {
			return new MovilResultadoOp("ERROR: El usuario y contrasena indicados no son validos.");
		}

		try {
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getReporte(), this
					.getClass().getSimpleName(), "ajustadoresRealizarCobro", "Usuario -->" + serv.getUsuario() + "pass -->"
					+ serv.getPasswd() + ", rep -->" + serv.getReporte() + ", tipo-->" + serv.getTipoCobro()
					+ ", num--> *************************, nomb -->" + serv.getTarjetaNombre() 
					+ ", expm -->" + serv.getTarjetaExpiraMes() + ", expa -->" + serv.getTarjetaExpiraAno() + ", tipo -->" + serv.getTarjetaTipo()
					+ ", monto -->" + serv.getMonto() + ", telefono -->" + serv.getTelefono() + ", correo -->" + serv.getCorreoElectronico());
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),"ajustadoresRealizarCobro => ejecutarFuncionHistoricoTerminalNuevo");
		}

		try {
			this.sessionExternaDao.informacionDeSessionExterna(term, "Cobro con tarjeta de credito");
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresRealizarCobro => informacionDeSessionExterna");
		}

		try {
			final Transaccion transaccion = JMUtileriaBancaria.realizarCobro(term, null, serv.getTipoCobro(),
					serv.getTarjetaNombre(), serv.getTarjetaNumero(), serv.getTarjetaExpiraMes(),
					serv.getTarjetaExpiraAno(), serv.getTarjetaCVV(), serv.getTarjetaTipo(), serv.getMonto(), term
							.getReporteAtendiendo(), term.getReporteSise() != null ? term.getReporteSise()
							.getGeneralNumeroPoliza() : null, null, null, serv.getTelefono(), serv.getCorreoElectronico(),
					JMConstantes.TRANSACCION_FUENTE_CELULAR, null, null, null);

			if (transaccion != null) {
				if (BooleanUtils.isTrue(transaccion.getTransaccionAprobada())) {
					return new MovilResultadoOp("APROBADA. FECHA: " + transaccion.getFecha() + " OPERACION: "
							+ transaccion.getNumeroOperacion() + "  AUTORIZACION: "
							+ transaccion.getNumeroAutorizacion() + " MONTO: " + transaccion.getMonto());
				}
				return new MovilResultadoOp("NO APROBADA: " + transaccion.getRespuestaAmigable());

			}

		} catch (final Exception e) {
			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getReporte(),
						this.fuenteWS, "ajustadoresRealizarCobro", "Excepcion de LINK2B -->" + e.getMessage());
			} catch (final Exception ex) {
				this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
						"ajustadoresRealizarCobro => ejecutarFuncionHistoricoTerminalNuevo");
			}

			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "ajustadoresRealizarCobro", "Usuario -> "
					+ serv.getUsuario(), " Passwd: " + serv.getPasswd(), " rep -->" + serv.getReporte(), ", tipo-->" + serv.getTipoCobro(),", nomb -->" + serv.getTarjetaNombre()
					 +", monto -->"+ serv.getMonto()+ ", telefono -->" + serv.getTelefono(), ", correo -->" + serv.getCorreoElectronico());
			return new MovilResultadoOp("Error al hacer el cobro. Detalles: " + e.getMessage());
		}

		return new MovilResultadoOp("DECLINADA.");
	}

	
	
	@Override
	public MovilResultadoOp ajustadoresInsertarArriboAbogado(final AjustAInsertarArriboAbog serv){
		if (StringUtils.isBlank(serv.getUsuario())) {
			return new MovilResultadoOp("ERROR: Es necesario especificar un usuario");
		}
		if (StringUtils.isBlank(serv.getPasswd())) {
			return new MovilResultadoOp("ERROR: Es necesario especificar una contrasena");
		}

		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(serv.getUsuario(), serv.getPasswd());
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarArriboAbogado => objetoTerminalParaProveedorYPasswd");
		}

		if (term == null) {
			return new MovilResultadoOp("ERROR: El usuario y contrasena indicados no son validos.");
		}

		if (StringUtils.isBlank(serv.getNumeroReporte())) {
			return new MovilResultadoOp("ERROR: Es necesario especificar el numero de reporte");
		}
		if (StringUtils.isBlank(serv.getFechaHora())) {
			return new MovilResultadoOp("ERROR: Es necesario especificar la fecha y la hora en formato dd/MM/yyyy HH:mm:ss");
		}

		ReporteAbogado reporte = null;
		try {
			reporte = this.reporteAbogadoDao.objetoReporteAbogadoParaNumeroReporte(serv.getNumeroReporte());
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarArriboAbogado => objetoReporteAbogadoParaNumeroReporte");
		}

		try {
			Gson json = new Gson();
			String peticion = json.toJson(serv);
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, term, serv.getNumeroReporte(),
					this.fuenteWS, "ajustadoresInsertarArriboAbogado", peticion);
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarArriboAbogado => ejecutarFuncionHistoricoTerminalNuevo");
		}

		if (reporte != null) {
			if (reporte.getFechaArribo() == null) {
				reporte.setFechaArribo(new Date());
				return new MovilResultadoOp(reporte.guardarObjeto().getMensaje());
			}
			return new MovilResultadoOp("ERROR: El reporte especificado ya cuenta con fecha de arribo: " + reporte.getFechaArribo());
		}
		return new MovilResultadoOp("ERROR: El reporte no fue encontrado en la base de datos de reporte de abogados");
	}

	@Override
	public MovilResultadoOp insertarAbogadoAsignado(final InsertarAbogAsignado serv) {

		if (StringUtils.isBlank(serv.getNumeroReporteSISE())) {
			return new MovilResultadoOp( "ERROR: Es necesario especificar el numero de reporte SISE");
		}
		if (StringUtils.isBlank(serv.getClaveAbogado())) {
			return new MovilResultadoOp("ERROR: Es necesario especificar la clave del abogado");
		}


		ReporteAbogado reporte = null;
		try {
			reporte = this.reporteAbogadoDao.objetoReporteAbogadoParaNumeroReporte(serv.getNumeroReporteSISE());
		} catch (final Exception ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"ajustadoresInsertarNombreClaveAbogado => objetoReporteAbogadoParaNumeroReporte");
		}

		if (reporte == null) {
			return new MovilResultadoOp("ERROR: NO PERTENCE EL REPORTE A LA BD SIICA");
		}

		if (StringUtils.isNotBlank(reporte.getNumeroProveedorAbogado())) {
			final String anterior = reporte.getNumeroProveedorAbogado();
			reporte.setNumeroProveedorAbogado("*** REASIGNADO A: " + serv.getClaveAbogado() + " " + serv.getNombreAbogado()
					+ "**** ( anterior era: " + anterior + ")");
			reporte.setTelefonoAbogado(serv.getTelefonoAbogado());
		} else {
			reporte.setNumeroProveedorAbogado(serv.getClaveAbogado() + " " + serv.getNombreAbogado());
			reporte.setTelefonoAbogado(serv.getTelefonoAbogado());
		}
		reporte.setFechaAsignado(new Date());

		final JMResultadoOperacion resultado = reporte.guardarObjeto();

		return new MovilResultadoOp( resultado.isExito() ? "OK" : "ERROR: " + resultado.getMensaje());
	}

	
}
