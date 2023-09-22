package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoCoberturas;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCoberturasServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "catalogoCoberturas")
@RequestScoped
@Entity(name = "CatalogoCoberturas")
@Access(AccessType.FIELD)
@Table(name = "catalogo_coberturas")
public class CatalogoCoberturas extends AbstractCatalogoCoberturas {

	private static final long serialVersionUID = 3373643434561846566L;

	public CatalogoCoberturas() {
		super();
	}

	private static CatalogoCoberturasServiceInterfase catalogoCoberturasService;

	public static CatalogoCoberturasServiceInterfase getCatalogoCoberturasService() {
		if (CatalogoCoberturas.catalogoCoberturasService == null) {
			CatalogoCoberturas.catalogoCoberturasService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoCoberturasService();
		}
		return CatalogoCoberturas.catalogoCoberturasService;
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
			return CatalogoCoberturas.getCatalogoCoberturasService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoCoberturas.getCatalogoCoberturasService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}
}
