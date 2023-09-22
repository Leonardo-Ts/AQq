package com.aaq.col.clases.database.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoVehiculoTipo;
import com.aaq.col.clases.database.servicios.interfase.CatalogoVehiculoTipoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Entity(name = "CatalogoVehiculoTipo")
@Access(AccessType.FIELD)
@Table(name = "catalogo_vehiculo_tipo")
public class CatalogoVehiculoTipo extends AbstractCatalogoVehiculoTipo {

	private static final long serialVersionUID = -5791922317292694413L;

	/** default constructor */
	public CatalogoVehiculoTipo() {
	}

	private static CatalogoVehiculoTipoServiceInterfase catalogoVehiculoTipoService;

	public static CatalogoVehiculoTipoServiceInterfase getCatalogoVehiculoTipoService() {
		if (CatalogoVehiculoTipo.catalogoVehiculoTipoService == null) {
			CatalogoVehiculoTipo.catalogoVehiculoTipoService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoVehiculoTipoService();
		}
		return CatalogoVehiculoTipo.catalogoVehiculoTipoService;
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
			return CatalogoVehiculoTipo.getCatalogoVehiculoTipoService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoVehiculoTipo.getCatalogoVehiculoTipoService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
