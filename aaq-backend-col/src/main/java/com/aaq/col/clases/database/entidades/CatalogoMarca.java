package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoMarca;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMarcaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "catalogoMarcas")
@RequestScoped
@Entity(name = "CatalogoMarcas")
@Access(AccessType.FIELD)
@Table(name = "catalogo_marcas")
public class CatalogoMarca extends AbstractCatalogoMarca {

	private static final long serialVersionUID = 5679586282961498205L;

	/** default constructor */
	public CatalogoMarca() {
		super();
		this.setDescripcion("");
		this.setNombreMarca("");
		this.setClave("");
		this.setHabilitado(Boolean.TRUE);
	}

	private static CatalogoMarcaServiceInterfase catalogoMarcaService;

	public static CatalogoMarcaServiceInterfase getCatalogoMarcaService() {
		if (CatalogoMarca.catalogoMarcaService == null) {
			CatalogoMarca.catalogoMarcaService = JMSIICAServerServiceSingleton.getInstance().getCatalogoMarcaService();
		}
		return CatalogoMarca.catalogoMarcaService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Clave,clave","Nombre,nombreMarca","Descripcion,descripcion"}).getLista();
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
		this.setHabilitado(Boolean.FALSE);
		try {
			return CatalogoMarca.getCatalogoMarcaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoMarca.getCatalogoMarcaService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

}
