package com.aaq.col.system.webservices;

import java.io.IOError;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.aaq.col.clases.database.entidades.ReporteMovil;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.GenericoEnviarSMS;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.util.JMUtileriaNotificacion;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
public class EmergenciaMovilWebService implements EmergenciaMovilInterfase {

	@Autowired
	private ConfiguracionServiceInterfase configuracionDao;

	@Autowired
	private HistoricoTerminalServiceInterfase historicoTerminalDao;

	private final String fuenteWS = "SIICA Servicios Web -> Emergencia Movil Web Service ->";

	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
			JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
	
	private GenericoEnviarSMS genericoEnviarSMS = new GenericoEnviarSMS();

	@Override
	public MovilResultadoOperacion insertarReporte(final String usuario, final String passwd, final String poliza,
			final String endoso, final String inciso, final String latitud, final String longitud, final String causa,
			final String nombre, final String descripcion, final String referencia, final String contacto,
			final String agente) {
		if (StringUtils.isBlank(usuario)) {
			return new MovilResultadoOperacion(false, "Error: Usuario requerido");
		}
		if (StringUtils.isBlank(passwd)) {
			return new MovilResultadoOperacion(false, "Error: Passwd requerido");
		}
		if ((StringUtils.length(poliza) < 10) || (StringUtils.length(poliza) > 13)) {
			return new MovilResultadoOperacion(false, "Error: Poliza requerido de 10 a 13 caracteres");
		}
		if (StringUtils.isBlank(inciso)) {
			return new MovilResultadoOperacion(false, "Error: Inciso requerido");
		}
		if (StringUtils.isBlank(latitud)) {
			return new MovilResultadoOperacion(false, "Error: latitud requerida");
		}
		if (StringUtils.isBlank(longitud)) {
			return new MovilResultadoOperacion(false, "Error: longitud requerida");
		}
		if (StringUtils.isBlank(contacto)) {
			return new MovilResultadoOperacion(false, "Error: telefono de contacto requerido");
		}

		try {
			this.historicoTerminalDao.ejecutarFuncionHistoricoTerminalNuevo(null, null, null, this.fuenteWS,
					"insertarReporte", "Usuario -> " + usuario + ", Passwd -> " + passwd + ", Poliza-> " + poliza
							+ ", Inciso -> " + inciso + ", Endoso-> " + endoso + ", latitud-> " + latitud
							+ ", Longitud -> " + longitud + ", Contacto-> " + contacto + ", Agente->" + agente);
		}  	catch (RollbackException | DataIntegrityViolationException | CannotGetJdbcConnectionException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),
					"insertarReporte => ejecutarFuncionHistoricoTerminalNuevo");
		} catch(DataAccessException ex){
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
					"insertarReporte => ejecutarFuncionHistoricoTerminalNuevo");
		}

		final ReporteMovil reporte = new ReporteMovil();
		reporte.setCausa(causa);
		reporte.setFecha(new Date());
		reporte.setDescripcion("Iphone");
		reporte.setFuente("I-PHONE");
		reporte.setEndoso(endoso);
		reporte.setInciso(inciso);
		reporte.setLatitud(longitud);
		reporte.setLongitud(latitud);
		reporte.setNombreConductor("");
		reporte.setNombreReporta("");
		reporte.setPoliza(poliza);
		reporte.setTelefonoContacto(contacto);
		reporte.setAgente(agente);
		reporte.guardarObjeto();

		Boolean mensajeEnviado = false;
		try{
			mensajeEnviado = genericoEnviarSMS.enviarSMS("5541812391", "Emergencia Q ha solicitado atencion para un Asegurado. El telefono del contacto es: "
								+ reporte.getTelefonoContacto());
		} catch(Exception ex){
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "InsertarReporte => genericoEnviarSMS");
		}

		final ArrayList<String> p = new ArrayList<>();
		String[] correos = null;
		try {
			correos = StringUtils
					.split(this.configuracionDao
							.obtenerCadena(JMConstantes.CONFIGURACION_WEBSERVICES_JAXB_SIICASERVER_SIICA_EMERGENCIA_MOVIL_CORREO_CC),
							',');
		}  catch (ClassCastException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "InsertarReporte => ObtenerCadena");
		} catch (final PersistenceException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "InsertarReporte => ObtenerCadena");
		} catch (final IOError ex) {
//			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "InsertarReporte => ObtenerCadena");
		} catch (final InternalError ex) {
//			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "InsertarReporte => ObtenerCadena");
		} catch (final UnknownError ex) {
//			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "InsertarReporte => ObtenerCadena");
		} catch (final Exception ex) {
//			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "InsertarReporte => ObtenerCadena");
		}
		if ((correos != null) && (correos.length > 0)) {
			for (final String correo : correos) {
				if (StringUtils.isNotBlank(correo)) {
					p.add(correo);

				}
			}
			new JMUtileriaNotificacion().enviarEmailSimple(p, "Emergencia Q - Nuevo Reporte",
					"Emergencia Q ha solicitado atencion para un Asegurado. El telefono del contacto es: "
							+ reporte.getTelefonoContacto());

		}
		return new MovilResultadoOperacion(mensajeEnviado, "OK");
	}

}
