package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCartografia;
import com.aaq.col.clases.database.servicios.interfase.CartografiaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "cartografia")
@RequestScoped
@Entity(name = "Cartografia")
@Access(AccessType.FIELD)
@Table(name = "cartografia")
public class Cartografia extends AbstractCartografia {

	private static final long serialVersionUID = -8622571643875081586L;

	/** default constructor */
	public Cartografia() {
		super();
	}

	private static CartografiaServiceInterfase cartografiaService;

	public static CartografiaServiceInterfase getCartografiaService() {
		if (Cartografia.cartografiaService == null) {
			Cartografia.cartografiaService = JMSIICAServerServiceSingleton.getInstance().getCartografiaService();
		}
		return Cartografia.cartografiaService;
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
			return Cartografia.getCartografiaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
