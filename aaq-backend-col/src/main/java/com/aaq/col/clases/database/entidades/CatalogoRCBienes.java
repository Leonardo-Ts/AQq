package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoRCBienes;
import com.aaq.col.clases.database.servicios.interfase.CatalogoRCBienesServiceInterface;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoRCBienes")
@RequestScoped
@Entity(name = "CatalogoRCBienes")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_RC_BIENES")
public class CatalogoRCBienes extends AbstractCatalogoRCBienes {

	private static final long serialVersionUID = 1949833807651369636L;

	public CatalogoRCBienes() {
		super();
		this.setClave("");
		this.setDescripcion("");
		this.setTipoAfecta("");
	}

	private static CatalogoRCBienesServiceInterface catalogoRCBienesService;

	public static CatalogoRCBienesServiceInterface getCatalogoRCBienesService() {
		if (CatalogoRCBienes.catalogoRCBienesService == null) {
			CatalogoRCBienes.catalogoRCBienesService = JMSIICAServerServiceSingleton.getInstance()
					.getCatalogoRCBienesService();
		}
		return CatalogoRCBienes.catalogoRCBienesService;
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
			return CatalogoRCBienes.getCatalogoRCBienesService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoRCBienes.getCatalogoRCBienesService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}
	
}
