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

import com.aaq.col.clases.database.entidades.abstracto.AbstractCalle;
import com.aaq.col.clases.database.servicios.interfase.CalleServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

import java.util.Objects;

@ManagedBean(name = "calle")
@RequestScoped
@Entity(name = "Calle")
@Access(AccessType.FIELD)
@Table(name = "calle")
public class Calle extends AbstractCalle {

	private static final long serialVersionUID = 895458076575692767L;

	/** default constructor */
	public Calle() {
		super();
	}

	private static CalleServiceInterfase calleService;

	
	public static CalleServiceInterfase getCalleService() {
		if (Calle.calleService == null) {
			Calle.calleService = JMSIICAServerServiceSingleton.getInstance().getCalleService();
		}
		return Calle.calleService;
	}

	@JMReporteOmitirMetodo
	public JMPuntoGeografico toJMPuntoGeografico(){
		JMPuntoGeografico punto = new JMPuntoGeografico();
		punto.setEsArrastable(false);

		punto.setIconoNombre("punto_no_arrastrable");
		punto.setIconoArchivo("punto_no_arrastrable.png");

		punto.setLatitud(Objects.toString(this.getLatitud(), ""));
		punto.setLongitud(Objects.toString(this.getLongitud(), ""));
		punto.setDescripcionHTML(this.getHTML());
		punto.setEtiqueta(this.getNombre());

		punto.setIdentificadorUnico("calle" + Objects.toString(this.getId(), ""));
		return punto;
	}
	/**
	 * @return el nombre html
	 */
	@JMReporteOmitirMetodo
	public String getHTML() {
		return "<b>Nombre:</b>" + this.getNombre() + "<br><b>Colonia:</b>" + this.getNombreColonia()
				+ "<br>Municipio:</b>" + this.getNombreMunicipio();

	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad #editarObjeto()
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		return new JMResultadoOperacion(new Exception("No se puede Eliminar. Catalogo de Sistema"));
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return Calle.getCalleService().guardarObjeto(this);
		} catch (ClassCastException | IndexOutOfBoundsException |RollbackException e) {
			return new JMResultadoOperacion(e);
		} catch (final CannotGetJdbcConnectionException | DataIntegrityViolationException | PersistenceException ex) {
			return new JMResultadoOperacion(ex);
		} catch (final DataAccessException ex) {
			return new JMResultadoOperacion(ex);
		} 
	}

}
