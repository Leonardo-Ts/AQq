package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoDependencias;
import com.aaq.col.clases.database.servicios.interfase.CatalogoDependenciasServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoDependencias")
@RequestScoped
@Entity(name = "CatalogoDependencias")
@Access(AccessType.FIELD)
@Table(name = "catalogo_dependencias")
public class CatalogoDependencias extends AbstractCatalogoDependencias{

	private static final long serialVersionUID = -1823163473543381306L;


	public CatalogoDependencias() {
		super();
		this.setDescripcion("");
		this.setClave("");
	}

	private static CatalogoDependenciasServiceInterfase CatalogoDependenciasService;

	public static CatalogoDependenciasServiceInterfase getCatalogoDependenciasService() {
		if (CatalogoDependencias.CatalogoDependenciasService == null) {
			CatalogoDependencias.CatalogoDependenciasService = JMSIICAServerServiceSingleton.getInstance().getCatalogoDependenciasService();
		}
		return CatalogoDependencias.CatalogoDependenciasService;
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
			return CatalogoDependencias.getCatalogoDependenciasService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoDependencias.getCatalogoDependenciasService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}


}
