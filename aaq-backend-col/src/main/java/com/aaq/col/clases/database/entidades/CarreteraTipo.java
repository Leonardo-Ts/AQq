package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCarreteraTipo;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "carreteraTipo")
@RequestScoped
@Entity(name = "CarreteraTipo")
@Access(AccessType.FIELD)
@Table(name = "carretera_tipo")
public class CarreteraTipo extends AbstractCarreteraTipo {

	private static final long serialVersionUID = 8312274092639421520L;

	public CarreteraTipo() {
		super();
	}

	public String getDescripcion() {
		return this.getNombre();
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
		return new JMResultadoOperacion(new Exception("No se puede Eliminar. Catalogo de Sistema"));

	}

	/*
	 * (non-Javadoc)
	 * @see com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		return new JMResultadoOperacion(new Exception("No se puede Guardar. Catalogo de Sistema Inamovible"));

	}
}
