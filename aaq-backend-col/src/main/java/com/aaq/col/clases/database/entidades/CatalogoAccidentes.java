package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoAccidentes;
import com.aaq.col.clases.database.servicios.interfase.CatalogoAccidentesServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoAccidentes")
@RequestScoped
@Entity(name = "CatalogoAccidentes")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_ACCIDENTES")
public class CatalogoAccidentes extends AbstractCatalogoAccidentes {

	private static final long serialVersionUID = 5110502543428779554L;

	public CatalogoAccidentes() {
		super();
		this.setDescripcion("");
		this.setClave("");
		this.setCodigo("");
	}

	private static CatalogoAccidentesServiceInterfase catalogoAccidentesService;

	public static CatalogoAccidentesServiceInterfase getCatalogoAccidentesService() {
		if (CatalogoAccidentes.catalogoAccidentesService == null) {
			CatalogoAccidentes.catalogoAccidentesService = JMSIICAServerServiceSingleton.getInstance().getCatalogoAccidentesService();
		}
		return CatalogoAccidentes.catalogoAccidentesService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Clave,clave","Descripcion,descripcion","Codigo,codigo"}).getLista();
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
			return CatalogoAccidentes.getCatalogoAccidentesService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoAccidentes.getCatalogoAccidentesService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}
	
}
