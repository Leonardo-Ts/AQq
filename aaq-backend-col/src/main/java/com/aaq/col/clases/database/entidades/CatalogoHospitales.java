package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoHospitales;
import com.aaq.col.clases.database.servicios.interfase.CatalogoHospitalesServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoHospitales")
@RequestScoped
@Entity(name = "CatalogoHospitales")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_HOSPITALES")
public class CatalogoHospitales extends AbstractCatalogoHospitales {

	private static final long serialVersionUID = 5164463427745773245L;

	public CatalogoHospitales() {
		super();
		this.setDescripcion("");
		this.setClave("");
		this.setDireccion("");
		this.setTelefono("");
	}

	private static CatalogoHospitalesServiceInterfase CatalogoHospitalesService;

	public static CatalogoHospitalesServiceInterfase getCatalogoHospitalesService() {
		if (CatalogoHospitales.CatalogoHospitalesService == null) {
			CatalogoHospitales.CatalogoHospitalesService = JMSIICAServerServiceSingleton.getInstance().getCatalogoHospitalesService();
		}
		return CatalogoHospitales.CatalogoHospitalesService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Clave,clave","Descripción,descripcion","Dirección,direccion","Teléfono,telefono"}).getLista();
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
			return CatalogoHospitales.getCatalogoHospitalesService().eliminarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoHospitales.getCatalogoHospitalesService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}
	
}
