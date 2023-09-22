 package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractColonia;
import com.aaq.col.clases.database.servicios.interfase.ColoniaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "colonia")
@RequestScoped
@Entity(name = "Colonia")
@Access(AccessType.FIELD)
@Table(name = "colonia")
public class Colonia extends AbstractColonia {

	private static final long serialVersionUID = -7926628644729101846L;

	/** default constructor */
	public Colonia() {
		super();
	}

	private static ColoniaServiceInterfase coloniaService;

	public static ColoniaServiceInterfase getColoniaService() {
		if (Colonia.coloniaService == null) {
			Colonia.coloniaService = JMSIICAServerServiceSingleton.getInstance().getColoniaService();
		}
		return Colonia.coloniaService;
	}

	public String getDescripcion() {
		return this.getNombre();
	}
	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		return new JMResultadoOperacion(new Exception("No se puede Eliminar. Catalogo de Sistema"));
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return Colonia.getColoniaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
