package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoOficina;
import com.aaq.col.clases.database.servicios.interfase.CatalogoOficinaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoOficina")
@RequestScoped
@Entity(name = "CatalogoOficina")
@Access(AccessType.FIELD)
@Table(name = "catalogo_oficina")
public class CatalogoOficina extends AbstractCatalogoOficina {
	private static final long serialVersionUID = -1852857055760504573L;

	@Transient
	private String _idEstado;

	public CatalogoOficina() {
		super();
		this.setHabilitado(Boolean.TRUE);
	}

	private static CatalogoOficinaServiceInterfase catalogoOficinaService;

	public static CatalogoOficinaServiceInterfase getCatalogoOficinaService() {
		if (CatalogoOficina.catalogoOficinaService == null) {
			CatalogoOficina.catalogoOficinaService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoOficinaService();
		}
		return CatalogoOficina.catalogoOficinaService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Estado,estado", "Clave,clave", "Descripción,descripcion" })
				.getLista();
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);
		try {
			return CatalogoOficina.getCatalogoOficinaService().guardarObjeto(this);
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
		if (StringUtils.isNotBlank(this.get_idEstado())) {
			try {
				this.setEstado(Estado.getEstadoService().objetoEstado(this.get_idEstado()));
			} catch (final Exception ex) {
				JMEntidad.getLogger().error("guardarObjeto ==> objetoEstado => " + this.get_idEstado(), ex);
			}
		}

		try {
			return CatalogoOficina.getCatalogoOficinaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

	public String get_idEstado() {
		return this._idEstado;
	}
	public void set_idEstado(final String _idEstado) {
		this._idEstado = _idEstado;
	}
}
