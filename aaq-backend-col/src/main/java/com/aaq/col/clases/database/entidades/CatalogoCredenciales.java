package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoCredenciales;
import com.aaq.col.clases.database.servicios.interfase.CatalogoCredencialesServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoCredenciales")
@RequestScoped
@Entity(name = "CatalogoCredenciales")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_CREDENCIALES")
public class CatalogoCredenciales extends AbstractCatalogoCredenciales {

	private static final long serialVersionUID = 1219280322729952988L;
	
	public CatalogoCredenciales() {
		super();
		this.setNombre("");
		this.setDireccion("");
		this.setPwd("");
		this.setUrl("");
		this.setUsuario("");
		
	}

	private static CatalogoCredencialesServiceInterfase catalogoCredencialesService;

	public static CatalogoCredencialesServiceInterfase getCatalogoCredencialesService() {
		if (CatalogoCredenciales.catalogoCredencialesService == null) {
			CatalogoCredenciales.catalogoCredencialesService = JMSIICAServerServiceSingleton.getInstance().getCatalogoCredencialesService();
		}
		return CatalogoCredenciales.catalogoCredencialesService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Nombre,nombre","URL,url","Usuario,usuario"}).getLista();
	}
	
	@Override
	public String toString() {
		return this.getNombre();
	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		try {
			return CatalogoCredenciales.getCatalogoCredencialesService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoCredenciales.getCatalogoCredencialesService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

}
