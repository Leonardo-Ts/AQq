 package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoCodigoRespuestaBancario;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCodigoRespuestaBancarioServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "catalogoCodigoRespuestaBancario")
@RequestScoped
@Entity(name = "CatalogoCodigoRespuestaBancario")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_CODIGO_RESPUESTA_BANC")
public class CatalogoCodigoRespuestaBancario extends AbstractCatalogoCodigoRespuestaBancario {
	private static final long serialVersionUID = -7506512363570285309L;

	/** default constructor */
	public CatalogoCodigoRespuestaBancario() {
		super();
		this.setCodigoiso("00");
		this.setCodigob24("00");
		this.setDescripcion("Descripcion");
		this.setAdvertencia(Boolean.FALSE);
		this.setHabilitado(Boolean.TRUE);
	}

	private static CatalogoCodigoRespuestaBancarioServiceInterfase catalogoCodigoRespuestaBancarioService;

	public static CatalogoCodigoRespuestaBancarioServiceInterfase getCatalogoCodigoRespuestaBancarioService() {
		if (CatalogoCodigoRespuestaBancario.catalogoCodigoRespuestaBancarioService == null) {
			CatalogoCodigoRespuestaBancario.catalogoCodigoRespuestaBancarioService = JMSIICAServerServiceSingleton
					.getInstance().getCatalogoCodigoRespuestaBancarioService();
		}
		return CatalogoCodigoRespuestaBancario.catalogoCodigoRespuestaBancarioService;
	}

	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
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

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #eliminarObjeto()
	 */
	@Override
	public JMResultadoOperacion eliminarObjeto() {
		this.setHabilitado(Boolean.FALSE);
		try {
			return CatalogoCodigoRespuestaBancario.getCatalogoCodigoRespuestaBancarioService().guardarObjeto(this);
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
			return CatalogoCodigoRespuestaBancario.getCatalogoCodigoRespuestaBancarioService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
