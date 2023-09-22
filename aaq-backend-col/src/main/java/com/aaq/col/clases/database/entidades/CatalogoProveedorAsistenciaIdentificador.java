package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoProveedorAsistenciaIdentificador;
import com.aaq.col.clases.database.servicios.interfase.CatalogoProveedorAsistenciaIdentificadorServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "catalogoProveedorAsistenciaIdentificador")
@RequestScoped
@Entity(name = "CatalogoProveedorAsistenciaIdentificador")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_PROVEEDOR_ASIST_ID")
public class CatalogoProveedorAsistenciaIdentificador extends AbstractCatalogoProveedorAsistenciaIdentificador {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -8015130092982131333L;

	/** default constructor */
	public CatalogoProveedorAsistenciaIdentificador() {
		super();
	}

	private static CatalogoProveedorAsistenciaIdentificadorServiceInterfase catalogoProveedorAsistenciaIdentificadorService;

	public static CatalogoProveedorAsistenciaIdentificadorServiceInterfase getCatalogoProveedorAsistenciaIdentificadorService() {
		if (CatalogoProveedorAsistenciaIdentificador.catalogoProveedorAsistenciaIdentificadorService == null) {
			CatalogoProveedorAsistenciaIdentificador.catalogoProveedorAsistenciaIdentificadorService = JMSIICAServerServiceSingleton
					.getInstance().getCatalogoProveedorAsistenciaIdentificadorService();
		}
		return CatalogoProveedorAsistenciaIdentificador.catalogoProveedorAsistenciaIdentificadorService;
	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return CatalogoProveedorAsistenciaIdentificador.getCatalogoProveedorAsistenciaIdentificadorService()
					.eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
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
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoProveedorAsistenciaIdentificador.getCatalogoProveedorAsistenciaIdentificadorService()
					.guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
