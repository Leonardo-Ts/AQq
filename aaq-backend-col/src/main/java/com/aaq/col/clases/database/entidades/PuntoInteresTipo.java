package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractPuntoInteresTipo;
import com.aaq.col.clases.database.servicios.interfase.PuntoInteresTipoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "puntoInteresTipo")
@RequestScoped
@Entity(name = "PuntoInteresTipo")
@Access(AccessType.FIELD)
@Table(name = "punto_interes_tipo")
public class PuntoInteresTipo extends AbstractPuntoInteresTipo {
	private static final long serialVersionUID = -5006266419617017824L;

	/** default constructor */
	public PuntoInteresTipo() {
		super();
	}

	private static PuntoInteresTipoServiceInterfase puntoInteresTipoService;

	public static PuntoInteresTipoServiceInterfase getPuntoInteresTipoService() {
		if (PuntoInteresTipo.puntoInteresTipoService == null) {
			PuntoInteresTipo.puntoInteresTipoService = JMSIICAServerServiceSingleton.getInstance()
					.getPuntoInteresTipoService();
		}
		return PuntoInteresTipo.puntoInteresTipoService;
	}

	public JMPuntoGeografico toJMPuntoGeografico(final String ruta){
		final JMPuntoGeografico punto = new JMPuntoGeografico();
		punto.setIconoArchivo(ruta +this.getIcono());
		punto.setIconoNombre(this.getNombre());
		punto.setEtiqueta(this.getDescripcion());
		punto.setLatitud(this.getLargo());
		punto.setLongitud(this.getAncho());
		return punto;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getDescripcion();
	}

	/*
	 * (non-Javadoc)
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);
		try {
			return PuntoInteresTipo.getPuntoInteresTipoService().guardarObjeto(this);
		} 	catch ( ClassCastException | IndexOutOfBoundsException | RollbackException e) {
				return new JMResultadoOperacion(e);
		}	catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
				return new JMResultadoOperacion(ex);
		}	catch (final DataAccessException ex) {
			return new JMResultadoOperacion(ex);
	}

	}

	/*
	 * (non-Javadoc)
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return PuntoInteresTipo.getPuntoInteresTipoService().guardarObjeto(this);
		}	catch ( ClassCastException | IndexOutOfBoundsException | RollbackException e) {
				return new JMResultadoOperacion(e);
		}	catch (final PersistenceException | DataIntegrityViolationException | CannotGetJdbcConnectionException ex) {
				return new JMResultadoOperacion(ex);
		}	catch (final DataAccessException ex) {
				return new JMResultadoOperacion(ex);
		}
	}

}
