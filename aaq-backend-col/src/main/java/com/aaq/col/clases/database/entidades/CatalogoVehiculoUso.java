 package com.aaq.col.clases.database.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoVehiculoUso;
import com.aaq.col.clases.database.servicios.interfase.CatalogoVehiculoUsoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@Entity(name = "CatalogoVehiculoUso")
@Access(AccessType.FIELD)
@Table(name = "catalogo_vehiculo_uso")
public class CatalogoVehiculoUso extends AbstractCatalogoVehiculoUso {

	private static final long serialVersionUID = -8385364319811214491L;

	/** default constructor */
	public CatalogoVehiculoUso() {
	}

	private static CatalogoVehiculoUsoServiceInterfase catalogoVehiculoUsoService;

	public static CatalogoVehiculoUsoServiceInterfase getCatalogoVehiculoUsoService() {
		if (CatalogoVehiculoUso.catalogoVehiculoUsoService == null) {
			CatalogoVehiculoUso.catalogoVehiculoUsoService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoVehiculoUsoService();
		}
		return CatalogoVehiculoUso.catalogoVehiculoUsoService;
	}

	@Override
	public String toString() {
		return this.getDescripcion();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return CatalogoVehiculoUso.getCatalogoVehiculoUsoService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoVehiculoUso.getCatalogoVehiculoUsoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}
}
