package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoTipoAsistencia;
import com.aaq.col.clases.database.servicios.interfase.CatalogoTipoAsistenciaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoTipoAsistencia")
@RequestScoped
@Entity(name = "CatalogoTipoAsistencia")
@Access(AccessType.FIELD)
@Table(name = "catalogo_tipo_asistencia")
public class CatalogoTipoAsistencia extends AbstractCatalogoTipoAsistencia {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1892051004842331370L;

	/** default constructor */
	public CatalogoTipoAsistencia() {
		super();
		this.setHabilitado(Boolean.TRUE);
	}

	private static CatalogoTipoAsistenciaServiceInterfase catalogoTipoAsistenciaService;

	public static CatalogoTipoAsistenciaServiceInterfase getCatalogoTipoAsistenciaService() {
		if (CatalogoTipoAsistencia.catalogoTipoAsistenciaService == null) {
			CatalogoTipoAsistencia.catalogoTipoAsistenciaService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoTipoAsistenciaService();
		}
		return CatalogoTipoAsistencia.catalogoTipoAsistenciaService;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getDescripcion();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);
		try {
			return CatalogoTipoAsistencia.getCatalogoTipoAsistenciaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoTipoAsistencia.getCatalogoTipoAsistenciaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
}
