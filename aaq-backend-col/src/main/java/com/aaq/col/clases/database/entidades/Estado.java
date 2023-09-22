package com.aaq.col.clases.database.entidades;

import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractEstado;
import com.aaq.col.clases.database.servicios.interfase.EstadoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;

/**
 * Estado entity.
 * 
 * @author mfernandez Fernandez
 */
@ManagedBean(name = "estado")
@RequestScoped
@Entity(name = "Estado")
@Access(AccessType.FIELD)
@Table(name = "estado")
public class Estado extends AbstractEstado {

	private static final long serialVersionUID = -6371874123196641655L;

	// **************************************************************//
	// Constructor
	// **************************************************************//

	/** default constructor */
	public Estado() {
		super();
	}

	private static EstadoServiceInterfase estadoService;

	public static EstadoServiceInterfase getEstadoService() {
		if (Estado.estadoService == null) {
			Estado.estadoService = JMSIICAServerServiceSingleton.getInstance().getEstadoService();
		}
		return Estado.estadoService;
	}

	public Estado(final Integer id, final Integer identidad, final Integer husoHorario, final String nombre) {
		super(id, identidad, husoHorario, nombre);
	}

	public String getDescripcion() {
		return this.getNombre();
	}

	public String getNombreEntidad() {
		return JMUtileriaString.rellenarConCaracter(Objects.toString(this.getId(), ""), "0", 2) + " "
				+ this.getNombre();
	}

	@Override
	public String toString() {
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
			return Estado.getEstadoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
}
