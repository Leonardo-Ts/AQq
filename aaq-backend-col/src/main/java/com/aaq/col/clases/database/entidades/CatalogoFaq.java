package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCatalogoFaq;
import com.aaq.col.clases.database.servicios.interfase.CatalogoFaqServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "catalogoFaq")
@RequestScoped
@Entity(name = "CatalogoFaq")
@Access(AccessType.FIELD)
@Table(name = "CATALOGO_FAQ")
public class CatalogoFaq extends AbstractCatalogoFaq {

	private static final long serialVersionUID = -4558833812749528499L;

	public CatalogoFaq() {
		super();
		this.setDescripcion("");
		this.setClave("");
		this.setMensaje("");
		this.setResponsable("");
	}

	private static CatalogoFaqServiceInterfase catalogoFaqService;

	public static CatalogoFaqServiceInterfase getCatalogoFaqService() {
		if (CatalogoFaq.catalogoFaqService == null) {
			CatalogoFaq.catalogoFaqService = JMSIICAServerServiceSingleton.getInstance().getCatalogoFaqService();
		}
		return CatalogoFaq.catalogoFaqService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] {"Clave,clave","Mensaje,mensaje","Descripcion,descripcion","Responsable,responsable"}).getLista();
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
			return CatalogoFaq.getCatalogoFaqService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CatalogoFaq.getCatalogoFaqService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}

	}
}
