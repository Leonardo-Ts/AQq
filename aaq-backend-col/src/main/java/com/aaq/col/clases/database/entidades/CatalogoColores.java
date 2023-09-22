package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoColores;
import com.aaq.col.clases.database.servicios.interfase.CatalogoColoresServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoColores")
@RequestScoped
@Entity(name = "CatalogoColores")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_COLOR_OCRA")
public class CatalogoColores extends AbstractCatalogoColores {

	private static final long serialVersionUID = -4558833812749528499L;

	public CatalogoColores() {
		super();
		this.setDescripcion("");
		this.setClave("");
	}

	private static CatalogoColoresServiceInterfase catalogoColoresService;

	public static CatalogoColoresServiceInterfase getCatalogoColoresService() {
		if (CatalogoColores.catalogoColoresService == null) {
			CatalogoColores.catalogoColoresService = JMSIICAServerServiceSingleton.getInstance().getCatalogoColoresService();
		}
		return CatalogoColores.catalogoColoresService;
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
			return CatalogoColores.getCatalogoColoresService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoColores.getCatalogoColoresService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}


}
