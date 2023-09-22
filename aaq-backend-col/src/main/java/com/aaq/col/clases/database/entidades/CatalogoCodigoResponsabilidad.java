package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoCodigoResponsabilidad;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCodigoResponsabilidadServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "catalogoCodigoResponsabilidad")
@RequestScoped
@Entity(name = "CatalogoCodigoResponsabilidad")
@Access(AccessType.FIELD)
@Table(name = "catalogo_codigo_respons")
public class CatalogoCodigoResponsabilidad extends AbstractCatalogoCodigoResponsabilidad {

	private static final long serialVersionUID = 3373643434561846566L;

	/** default constructor */
	public CatalogoCodigoResponsabilidad() {
		super();
	}

	private static CatalogoCodigoResponsabilidadServiceInterfase catalogoCodigoResponsabilidadService;

	/**
	 * 
	 * @return the catalogoRecuperosService
	 */
	public static CatalogoCodigoResponsabilidadServiceInterfase getCatalogoCodigoResponsabilidadService() {
		if (CatalogoCodigoResponsabilidad.catalogoCodigoResponsabilidadService == null) {
			CatalogoCodigoResponsabilidad.catalogoCodigoResponsabilidadService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoCodigoResponsabilidadService();
		}
		return CatalogoCodigoResponsabilidad.catalogoCodigoResponsabilidadService;
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
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad #editarObjeto()
	 */
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}
}
