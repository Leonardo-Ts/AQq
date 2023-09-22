package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.exceptions.DatabaseException;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoProveedorAsistencia;
import com.aaq.col.clases.database.servicios.interfase.CatalogoProveedorAsistenciaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

/**
 * CatalogoProveedorAsistencia entity. @author mfernandez Fernandez
 */
@ManagedBean(name = "catalogoProveedorAsistencia")
@RequestScoped
@Entity(name = "CatalogoProveedorAsistencia")
@Access(AccessType.FIELD)
@Table(name = "catalogo_proveedor_asistencia")
public class CatalogoProveedorAsistencia extends AbstractCatalogoProveedorAsistencia {
	private static final long serialVersionUID = -4185380923750698761L;

	@Transient
	private String _idEstado;

	// Constructors

	/** default constructor */
	public CatalogoProveedorAsistencia() {
		super();
		this.setNombreComercial("Nombre...");
		this.setHabilitado(Boolean.TRUE);
	}

	private static CatalogoProveedorAsistenciaServiceInterfase catalogoProveedorAsistenciaService;

	public static CatalogoProveedorAsistenciaServiceInterfase getCatalogoProveedorAsistenciaService() {
		if (CatalogoProveedorAsistencia.catalogoProveedorAsistenciaService == null) {
			CatalogoProveedorAsistencia.catalogoProveedorAsistenciaService = JMSIICAServerServiceSingleton
					.getInstance().getCatalogoProveedorAsistenciaService();
		}
		return CatalogoProveedorAsistencia.catalogoProveedorAsistenciaService;
	}

	/**
	 * @return la lista
	 */
	public List<CatalogoProveedorAsistenciaIdentificador> getCatalogoProveedorAsistenciaIdentificadores() {
		try {
			return CatalogoProveedorAsistenciaIdentificador.getCatalogoProveedorAsistenciaIdentificadorService()
					.listaDeCatalogoProveedorAsistenciaIdentificador(this);
		} catch (final ClassCastException | IllegalArgumentException  | RollbackException | IndexOutOfBoundsException ex) {
			JMEntidad.getLogger().error(
					"getCatalogoProveedorAsistenciaIdentificadores ==> listaDeCatalogoProveedorAsistenciaIdentificador => "
							+ this.get_idEstado(), ex);
			return null;
		} catch (final PersistenceException | DatabaseException ex) {
			JMEntidad.getLogger().error(
					"getCatalogoProveedorAsistenciaIdentificadores ==> listaDeCatalogoProveedorAsistenciaIdentificador => "
							+ this.get_idEstado(), ex);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getNombreComercial();
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Clave Prestador,clavePrestador",
				"Nombre Comercial,nombreComercial", "Razon Social,razonSocial", "Telefono,telefono", "Email,email" })
				.getLista();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);

		for (final CatalogoProveedorAsistenciaIdentificador id : this.getCatalogoProveedorAsistenciaIdentificadores()) {
			id.eliminarObjeto();
		}

		try {
			return CatalogoProveedorAsistencia.getCatalogoProveedorAsistenciaService().guardarObjeto(this);
		} catch (final ClassCastException | IllegalArgumentException | RollbackException | DatabaseException ex) {
			return new JMResultadoOperacion(ex);
		} catch (final PersistenceException ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad #editarObjeto()
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		if (this.getEstado() != null) {
			this.set_idEstado(Objects.toString(this.getEstado().getId(), ""));
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {

		if (StringUtils.isBlank(this.getNombreComercial())) {
			return new JMResultadoOperacion(new Exception("Requerido escribir nombre del proveedor"));
		}
		if (StringUtils.isBlank(this.getRazonSocial())) {
			return new JMResultadoOperacion(new Exception("Requerido escribir razon social del proveedor"));
		}
		if (StringUtils.isBlank(this.getClavePrestador())) {
			return new JMResultadoOperacion(new Exception("Requerido escribir clave del prestador"));
		}
		if (StringUtils.isBlank(this.getPasswd())) {
			return new JMResultadoOperacion(new Exception("Requerido escribir contraseña del proveedor"));
		}
		if (StringUtils.length(this.getClavePrestador()) != 5) {
			return new JMResultadoOperacion(new Exception("Requerido escribir un numero de proveedor de 5 digitos"));
		}

		if (StringUtils.isNotBlank(this.get_idEstado())) {
			try {
				this.setEstado(Estado.getEstadoService().objetoEstado(this.get_idEstado()));
			} catch (final RollbackException|IndexOutOfBoundsException | ClassCastException | IllegalArgumentException ex) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoEstado => " + this.get_idEstado(), ex);
			} catch (final PersistenceException ex) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoEstado => " + this.get_idEstado(), ex);
			}
		}

		try {
			return CatalogoProveedorAsistencia.getCatalogoProveedorAsistenciaService().guardarObjeto(this);
		} catch (final  RollbackException|IndexOutOfBoundsException | ClassCastException | IllegalArgumentException  ex) {
			return new JMResultadoOperacion(ex);
		} catch (final PersistenceException ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	/**
	 * Mar 26, 2012
	 * 
	 * @return the _idEstado
	 */
	public String get_idEstado() {
		return this._idEstado;
	}

	/**
	 * Mar 26, 2012
	 * 
	 * @param _idEstado
	 *            the _idEstado to set
	 */
	public void set_idEstado(final String _idEstado) {
		this._idEstado = _idEstado;
	}

}
