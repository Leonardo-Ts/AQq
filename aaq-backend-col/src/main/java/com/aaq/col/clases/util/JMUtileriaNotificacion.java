package com.aaq.col.clases.util;

import com.aaq.col.clases.database.entidades.Configuracion;
import com.aaq.col.clases.database.entidades.TerminalAlertaLog;
import com.aaq.col.clases.database.servicios.interfase.ConfiguracionServiceInterfase;
import com.aaq.col.clases.siica.JMConstantes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaEmail;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import java.util.ArrayList;
import java.util.Objects;

import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

public class JMUtileriaNotificacion {
	private final ConfiguracionServiceInterfase configuracionDao = Configuracion.getConfiguracionService();

	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(JMConstantesComunes.LOG_JMLIB_BEANS);

	EmailValidator validar = EmailValidator.getInstance();

	/**
	 * @param alerta
	 */
	public void notificarAlertaEmail(final TerminalAlertaLog alerta) {
		
		try{
		
		if (StringUtils.isNotBlank(alerta.getTerminalAlerta().getDireccionCorreo())) {
			final String asunto = new String("Notificacion de Alerta SIICA -" + alerta.getDescripcion());
			final StringBuilder builderBody = new StringBuilder("");

			builderBody.append("<p><b>Notificacion de Alerta SIICA</b></p>");
			builderBody
					.append("<p>Fecha: " + DateFormatUtils.format(alerta.getFecha(), "yyyy/MM/dd HH:mm:ss") + "</p>");
			builderBody.append("<p>Unidad: " + alerta.getTerminal().getNombre() + "</p>");
			builderBody.append("<p>Tipo: " + alerta.getTipo() + "</p>");
			builderBody.append("<p>Descripcion: " + alerta.getDescripcion() + "</p>");

			if ((StringUtils.length(alerta.getLatitud()) > 4) && (StringUtils.length(alerta.getLongitud()) > 4)) {
				builderBody.append("<p>Mapa: <a href=\"http://maps.google.com/maps?f=q&source=s_q&hl=es&q="
						+ alerta.getLongitud() + ",+" + alerta.getLatitud() + "\">Ver Mapa</a></p></fieldset>");
			}

			final ArrayList<String> personasTo = new ArrayList<>();
			personasTo.add(alerta.getTerminalAlerta().getDireccionCorreo());

			this.getUtileriaEmail().enviarEmail(personasTo, Objects.toString(asunto, ""),
					Objects.toString(builderBody, ""));

		}
		
		} catch (final ClassCastException | IllegalArgumentException | DatabaseException | RollbackException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "notificarAlertaEmail");
		} catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "notificarAlertaEmail");
		}


	}

	public void enviarEmailSimple(final ArrayList<String> personas, final String asunto, final String cuerpo) {
		
		try{
			this.getUtileriaEmail().enviarEmail(personas, asunto, cuerpo);

		} catch (final ClassCastException | IllegalArgumentException | DatabaseException | RollbackException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "enviarEmailSimple");
		} catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "enviarEmailSimple");
		}
	}

	public void enviarEmailSimple(final String persona, final String asunto, final String cuerpo,
			final byte[] attachByte, final String attachName) {
		final ArrayList<String> personas = new ArrayList<>();
		personas.add(persona);
		
		try{
			this.getUtileriaEmail().enviarEmail(personas, asunto, cuerpo, attachByte, attachName);
		}  catch (final ClassCastException | IllegalArgumentException | DatabaseException | RollbackException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "enviarEmailSimple");
		} catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "enviarEmailSimple");
		}
	}

	public void enviarEmailSimple(final ArrayList<String> personas, final String asunto, final String cuerpo,
			final byte[] attachByte, final String attachName) {
		
		try{
			this.getUtileriaEmail().enviarEmail(personas, asunto, cuerpo, attachByte, attachName);	
		}  catch (final ClassCastException | IllegalArgumentException | DatabaseException | RollbackException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "enviarEmailSimple");
		} catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "enviarEmailSimple");
		}
	}

	private JMUtileriaEmail getUtileriaEmail() {
		try {
			return new JMUtileriaEmail(
					this.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_HOST),
					this.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_DIRECCION_EMAIL),
					this.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_USUARIO),
					this.configuracionDao.obtenerCadena(JMConstantes.CONFIGURACION_MAIL_SERVER_PASSWD),
					this.configuracionDao.obtenerEntero(JMConstantes.CONFIGURACION_MAIL_SERVER_PUERTO),
					this.configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_CONEXION_SEGURA),
					this.configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_LOGIN),
					this.configuracionDao.obtenerBooleano(JMConstantes.CONFIGURACION_MAIL_SERVER_DEBUG));
		}  catch (final ClassCastException | IllegalArgumentException | DatabaseException | RollbackException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "getUtileriaEmail");
			return null;
		} catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
			this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(), "getUtileriaEmail");
			return null;
		}
	}

}
