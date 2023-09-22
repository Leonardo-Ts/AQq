package com.aaq.col.clases.database.entidades;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCalleDireccion;
import com.aaq.col.clases.database.servicios.interfase.CalleDireccionServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "calleDireccion")
@RequestScoped
@Entity(name = "CalleDireccion")
@Access(AccessType.FIELD)
@Table(name = "calle_direccion")
public class CalleDireccion extends AbstractCalleDireccion {

	private static final long serialVersionUID = -2096871824184488866L;

	/** default constructor */
	public CalleDireccion() {
		super();
		this.setPrec(new Integer(0));
		this.setFecha(new Date());
	}

	private static CalleDireccionServiceInterfase calleDireccionService;

	public static CalleDireccionServiceInterfase getCalleDireccionService() {
		if (CalleDireccion.calleDireccionService == null) {
			CalleDireccion.calleDireccionService = JMSIICAServerServiceSingleton.getInstance()
					.getCalleDireccionService();
		}
		return CalleDireccion.calleDireccionService;
	}

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

		try {
			return CalleDireccion.getCalleDireccionService().eliminarObjeto(this);
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
			return CalleDireccion.getCalleDireccionService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
}
