package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractPermiso;
import com.aaq.col.clases.database.servicios.interfase.PermisoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "permiso")
@RequestScoped
@Entity(name = "Permiso")
@Access(AccessType.FIELD)
@Table(name = "permiso")
public class Permiso extends AbstractPermiso {
	private static final long serialVersionUID = 7130196679137191711L;

	/** default constructor */
	public Permiso() {
		super();
	}

	private static PermisoServiceInterfase permisoService;

	public static PermisoServiceInterfase getPermisoService() {
		if (Permiso.permisoService == null) {
			Permiso.permisoService = JMSIICAServerServiceSingleton.getInstance().getPermisoService();
		}
		return Permiso.permisoService;
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
		try {
			return Permiso.getPermisoService().eliminarObjeto(this);
		} catch (final Exception ex) {
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
			return Permiso.getPermisoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
