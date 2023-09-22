package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoClaveDeEntidad;
import com.aaq.col.clases.database.servicios.interfase.CatalogoClaveDeEntidadServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "catalogoClaveDeEntidad")
@RequestScoped
@Entity(name = "CatalogoClaveDeEntidad")
@Access(AccessType.FIELD)
@Table(name = "catalogo_clave_de_entidad")
public class CatalogoClaveDeEntidad extends AbstractCatalogoClaveDeEntidad {

	private static final long serialVersionUID = -2836102600903124609L;

	/** default constructor */
	public CatalogoClaveDeEntidad() {
		super();
		this.setDescripcion("Descripcion");
		this.setHabilitado(Boolean.TRUE);

	}

	private static CatalogoClaveDeEntidadServiceInterfase catalogoClaveDeEntidadService;

	public static CatalogoClaveDeEntidadServiceInterfase getCatalogoClaveDeEntidadService() {
		if (CatalogoClaveDeEntidad.catalogoClaveDeEntidadService == null) {
			CatalogoClaveDeEntidad.catalogoClaveDeEntidadService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoClaveDeEntidadService();
		}
		return CatalogoClaveDeEntidad.catalogoClaveDeEntidadService;
	}

	// **************************************************************//
	// Overriders
	// **************************************************************//

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
		this.setHabilitado(Boolean.FALSE);
		try {
			return CatalogoClaveDeEntidad.getCatalogoClaveDeEntidadService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoClaveDeEntidad.getCatalogoClaveDeEntidadService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
