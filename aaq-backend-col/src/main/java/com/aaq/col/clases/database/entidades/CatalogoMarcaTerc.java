package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;


import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoMarcaTerc;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMarcaTercServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoMarcaTerc")
@RequestScoped
@Entity(name = "CatalogoMarcaTerc")
@Access(AccessType.FIELD)
@Table(name="CATALOGO_MARCA_TERC")
public class CatalogoMarcaTerc extends AbstractCatalogoMarcaTerc{

	private static final long serialVersionUID = -439556643514875766L;

	public CatalogoMarcaTerc() {
		super();
		this.setDescripcion("");
		this.setClave("");
	}

	private static CatalogoMarcaTercServiceInterfase catalogoMarcaTercService;

	public static CatalogoMarcaTercServiceInterfase getCatalogoMarcaTercService() {
		if (CatalogoMarcaTerc.catalogoMarcaTercService == null) {
			CatalogoMarcaTerc.catalogoMarcaTercService = JMSIICAServerServiceSingleton.getInstance().getCatalogoMarcaTercService();
		}
		return CatalogoMarcaTerc.catalogoMarcaTercService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Clave,clave","Descripcion,descripcion","Autos y Subcompactos,subComp",
				"Semipesado,semiPesad","Pesado,pesad","Motos,moto","Blindado,blinda"}).getLista();
	}
	
	public String getSubComp() {
		if (this.getSubCompactos() != null) {
			return this.getSubCompactos() == true ? "SI" : "NO";
		}
		return "NO";
	}
	
	public String getPesad() {
		if (this.getPesado() != null) {
			return this.getPesado() == true ? "SI" : "NO";
		}
		return "NO";
	}
	
	public String getSemiPesad() {
		if (this.getSemipesado() != null) {
			return this.getSemipesado() == true ? "SI" : "NO";
		}
		return "NO";
	}
	
	public String getMoto() {
		if (this.getMotos() != null) {
			return this.getMotos() == true ? "SI" : "NO";
		}
		return "NO";
	}
	
	public String getBlinda() {
		if (this.getBlindado() != null) {
			return this.getBlindado() == true ? "SI" : "NO";
		}
		return "NO";
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
			return CatalogoMarcaTerc.getCatalogoMarcaTercService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoMarcaTerc.getCatalogoMarcaTercService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

	
}
