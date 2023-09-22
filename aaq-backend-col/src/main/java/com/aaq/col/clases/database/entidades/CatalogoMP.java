package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoMP;
import com.aaq.col.clases.database.servicios.interfase.CatalogoMPServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "catalogoMp")
@RequestScoped
@Entity(name = "CatalogoMp")
@Access(AccessType.FIELD)
@Table(name="CATALOGO_MP")
public class CatalogoMP extends AbstractCatalogoMP{

	private static final long serialVersionUID = 5048900253509896280L;

	public CatalogoMP() {
		super();
		this.setDescripcion("");
		this.setClave("");
		this.setIdEntidad("");
		this.setIdMunicipio("");
		this.setDireccion("");
		this.setMunicipioLegal("");
		this.setEntidad("");
		this.setMunicipio("");
	}

	private static CatalogoMPServiceInterfase catalogoMPService;

	public static CatalogoMPServiceInterfase getCatalogoMPService() {
		if (CatalogoMP.catalogoMPService == null) {
			CatalogoMP.catalogoMPService = JMSIICAServerServiceSingleton.getInstance().getCatalogoMPService();
		}
		return CatalogoMP.catalogoMPService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Clave,clave","Descripcion,descripcion","Dirección,direccion","Entidad,entidad","Municipio,municipio"}).getLista();
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
			return CatalogoMP.getCatalogoMPService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoMP.getCatalogoMPService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}

	
}
