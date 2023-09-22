package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoRoles;
import com.aaq.col.clases.database.servicios.interfase.CatalogoRolesServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;


@ManagedBean(name = "catalogoRoles")
@RequestScoped
@Entity(name = "CatalogoRoles")
@Access(AccessType.FIELD)
@Table(name = "catalogo_roles")
public class CatalogoRoles extends AbstractCatalogoRoles {

	private static final long serialVersionUID = -6371874123196641655L;

	// **************************************************************//
	// Constructor
	// **************************************************************//

	/** default constructor */
	public CatalogoRoles() {
		super();
	}

	private static CatalogoRolesServiceInterfase catalogoRolesService;

	public static CatalogoRolesServiceInterfase getCatalogoRolesService() {
		if (CatalogoRoles.catalogoRolesService == null) {
			CatalogoRoles.catalogoRolesService = JMSIICAServerServiceSingleton.getInstance().getCatalogoRolesService();
		}
		return CatalogoRoles.catalogoRolesService;
	}

	public CatalogoRoles(final Integer id, final String nombre) {
		super(id, nombre);
	}

	public String getDescripcion() {
		return this.getNombre();
	}

	@Override
	public String toString() {
		return this.getNombre();
	}
}
