package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoMovil;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMovilServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;

@ManagedBean(name = "catalogoMovil")
@RequestScoped
@Entity(name = "CatalogoMovil")
@Access(AccessType.FIELD)
@Table(name="CATALOGO_MOVIL")
public class CatalogoMovil extends AbstractCatalogoMovil{

	private static final long serialVersionUID = 6765890480608284778L;
	
	private static CatalogoMovilServiceInterfase catalogoMovilService;

	/** default constructor */
	public CatalogoMovil() {
		super();
	}

	public static CatalogoMovilServiceInterfase getCatalogoMovilService() {
		if (CatalogoMovil.catalogoMovilService == null) {
			CatalogoMovil.catalogoMovilService = JMSIICAServerServiceSingleton.getInstance().getCatalogoMovilService();
		}
		return CatalogoMovil.catalogoMovilService;
	}
	
}