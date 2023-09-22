package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoRecuperaciones;
import com.aaq.col.clases.database.servicios.interfase.CatalogoRecuperacionesServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "catalogoRecuperaciones")
@RequestScoped
@Entity(name = "CatalogoRecuperaciones")
@Access(AccessType.FIELD)
@Table(name = "catalogo_recuperaciones")
public class CatalogoRecuperaciones extends AbstractCatalogoRecuperaciones {

	private static final long serialVersionUID = 3373643434561846566L;

	public CatalogoRecuperaciones() {
		super();
		this.setClave("");
		this.setDescripcion("");
	}

	private static CatalogoRecuperacionesServiceInterfase catalogoRecuperacionesService;

	public static CatalogoRecuperacionesServiceInterfase getCatalogoRecuperacionesService() {
		if (CatalogoRecuperaciones.catalogoRecuperacionesService == null) {
			CatalogoRecuperaciones.catalogoRecuperacionesService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoRecuperacionesService();
		}
		return CatalogoRecuperaciones.catalogoRecuperacionesService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Clave,clave","Nombre,descripcion"}).getLista();
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
			return CatalogoRecuperaciones.getCatalogoRecuperacionesService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoRecuperaciones.getCatalogoRecuperacionesService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}
	
	
}
