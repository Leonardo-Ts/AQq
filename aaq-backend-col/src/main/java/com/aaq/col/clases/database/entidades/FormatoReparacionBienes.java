package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReparacionBienes;
import com.aaq.col.clases.database.servicios.interfase.FormatoReparacionBienesServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoReparacionBienes")
@RequestScoped
@Entity(name = "formatoReparacionBienes")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_reparacion_bienes")
public class FormatoReparacionBienes extends AbstractFormatoReparacionBienes {

	private static final long serialVersionUID = -1344152880765008126L;

	public FormatoReparacionBienes() {
		super();
	}

	private static FormatoReparacionBienesServiceInterfase formatoReparacionBienesService;

	public static FormatoReparacionBienesServiceInterfase getFormatoReparacionBienesService() {
		if (FormatoReparacionBienes.formatoReparacionBienesService == null) {
			FormatoReparacionBienes.formatoReparacionBienesService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoReparacionBienesService();
		}
		return FormatoReparacionBienes.formatoReparacionBienesService;
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoReparacionBienes.getFormatoReparacionBienesService().guardarObjeto(this);

	}

}
