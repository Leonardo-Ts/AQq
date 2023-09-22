package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractControlFotografias;
import com.aaq.col.clases.database.servicios.interfase.ControlFotografiasServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;

@ManagedBean(name = "controlFotografias")
@RequestScoped
@Entity(name = "ControlFotografias")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "CONTROL_FOTOGRAFIAS")
public class ControlFotografias extends AbstractControlFotografias {

	private static final long serialVersionUID = -315945045292267325L;

	public ControlFotografias() {
		super();
	}

	private static ControlFotografiasServiceInterfase controlFotografiasService;
	
	
	public static ControlFotografiasServiceInterfase getControlFotografiasService() {
		if (ControlFotografias.controlFotografiasService == null) {
			ControlFotografias.controlFotografiasService = JMSIICAServerServiceSingleton.getInstance().getControlFotografiasService();
		}
		return ControlFotografias.controlFotografiasService;
	}
	
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(
				new String[] { "Fecha,fecha,fecha","No. Reporte,numReporte", "Nombre Foto,nombreFoto", 
						"Clave Documental,claveDocumental","Afectado,afectado","Enviado,enviadoOk"}).getLista();
	}

	public String getEnviadoOk() {
		if (this.getEnviado() != null) {
			if (this.getEnviado()) {
				return "SI";
			}
		}
		return "NO";
	}
	
}
