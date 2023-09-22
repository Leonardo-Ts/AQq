package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCarretera;
import com.aaq.col.clases.database.servicios.interfase.CarreteraServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "carretera")
@RequestScoped
@Entity(name = "Carretera")
@Access(AccessType.FIELD)
@Table(name = "carretera")
public class Carretera extends AbstractCarretera {

	private static final long serialVersionUID = -127462819053667235L;

	/** default constructor */
	public Carretera() {
		super();
	}

	private static CarreteraServiceInterfase carreteraService;

	public static CarreteraServiceInterfase getCarreteraService() {
		if (Carretera.carreteraService == null) {
			Carretera.carreteraService = JMSIICAServerServiceSingleton.getInstance().getCarreteraService();
		}
		return Carretera.carreteraService;
	}

	public String getDescripcion() {
		return this.getNombre();
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
			return Carretera.getCarreteraService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
