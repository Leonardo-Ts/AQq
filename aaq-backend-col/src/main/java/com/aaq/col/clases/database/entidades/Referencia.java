package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractReferencia;
import com.aaq.col.clases.database.servicios.interfase.ReferenciaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "referencia")
@RequestScoped
@Entity(name = "Referencia")
@Access(AccessType.FIELD)
@Table(name = "referencia")
public class Referencia extends AbstractReferencia {

	// Constructors

	private static final long serialVersionUID = 1951486865577128329L;

	/** default constructor */
	public Referencia() {
		super();
	}

	private static ReferenciaServiceInterfase referenciaService;

	public static ReferenciaServiceInterfase getReferenciaService() {
		if (Referencia.referenciaService == null) {
			Referencia.referenciaService = JMSIICAServerServiceSingleton.getInstance().getReferenciaService();
		}
		return Referencia.referenciaService;
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
		return new JMResultadoOperacion(new Exception("No se puede Eliminar. Catalogo de Sistema"));
	}

	/*
	 * (non-Javadoc)
	 * #guardarObjeto()
	 */
	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return Referencia.getReferenciaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
