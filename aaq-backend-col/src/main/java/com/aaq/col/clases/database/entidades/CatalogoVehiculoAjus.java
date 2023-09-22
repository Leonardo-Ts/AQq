package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoVehiculoAjus;
import com.aaq.col.clases.database.servicios.interfase.CatalogoVehiculoAjusServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;

@ManagedBean(name = "catalogoVehiculoAjus")
@RequestScoped
@Entity(name = "CatalogoVehiculoAjus")
@Access(AccessType.FIELD)
@Table(name="CATALOGO_VEHICULO_AJUS")
public class CatalogoVehiculoAjus extends AbstractCatalogoVehiculoAjus{

	private static final long serialVersionUID = 4670602043239688015L;
	
	private static CatalogoVehiculoAjusServiceInterfase catalogoVehiculoAjusService;

	public CatalogoVehiculoAjus() {
		super();
	}
	
	public static CatalogoVehiculoAjusServiceInterfase getCatalogoVehiculoAjusService() {
		if (CatalogoVehiculoAjus.catalogoVehiculoAjusService == null) {
			CatalogoVehiculoAjus.catalogoVehiculoAjusService = JMSIICAServerServiceSingleton.getInstance().getCatalogoVehiculoAjusService();
		}
		return CatalogoVehiculoAjus.catalogoVehiculoAjusService;
	}

}