package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoTramoCar;
import com.aaq.col.clases.database.servicios.interfase.CatalogoTramoCarServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoTramoCarret")
@RequestScoped
@Entity(name = "CatalogoTramoCarret")
@Access(AccessType.FIELD)
@Table(name="CATALOGO_TRAMO_CARRET")
public class CatalogoTramoCar extends AbstractCatalogoTramoCar {
	
	private static final long serialVersionUID = -4064203450398639407L;

	public CatalogoTramoCar() {
		super();
		this.setDescripcion("");
		this.setClave("");
	}

	private static CatalogoTramoCarServiceInterfase CatalogoTramoCarService;

	public static CatalogoTramoCarServiceInterfase getCatalogoTramoCarService() {
		if (CatalogoTramoCar.CatalogoTramoCarService == null) {
			CatalogoTramoCar.CatalogoTramoCarService = JMSIICAServerServiceSingleton.getInstance().getCatalogoTramoCarService();
		}
		return CatalogoTramoCar.CatalogoTramoCarService;
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
			return CatalogoTramoCar.getCatalogoTramoCarService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoTramoCar.getCatalogoTramoCarService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}



}
