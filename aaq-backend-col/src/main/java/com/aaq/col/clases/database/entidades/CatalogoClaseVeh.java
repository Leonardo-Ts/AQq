package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoClaseVeh;
import com.aaq.col.clases.database.servicios.interfase.CatalogoClaseVehServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoClaseVeh")
@RequestScoped
@Entity(name = "CatalogoClaseVeh")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_CLASE_VEH")
public class CatalogoClaseVeh extends AbstractCatalogoClaseVeh {

	private static final long serialVersionUID = -3270892462170717965L;

	public CatalogoClaseVeh() {
		super();
		this.setDescripcion("");
		this.setClave("");
	}

	private static CatalogoClaseVehServiceInterfase catalogoClaseVehService;

	public static CatalogoClaseVehServiceInterfase getCatalogoClaseVehService() {
		if (CatalogoClaseVeh.catalogoClaseVehService == null) {
			CatalogoClaseVeh.catalogoClaseVehService = JMSIICAServerServiceSingleton.getInstance().getCatalogoClaseVehService();
		}
		return CatalogoClaseVeh.catalogoClaseVehService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Clave,clave","Descripcion,descripcion"}).getLista();
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
			return CatalogoClaseVeh.getCatalogoClaseVehService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoClaseVeh.getCatalogoClaseVehService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

}
