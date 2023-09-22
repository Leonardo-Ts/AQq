package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReparacionBienesDiversos;
import com.aaq.col.clases.database.servicios.interfase.FormatoReparacionBienesDiversosServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoReparacionBienesDiversos")
@RequestScoped
@Entity(name = "FormatoReparacionBienesDiversos")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_reparacion_bienes_diversos")
public class FormatoReparacionBienesDiversos extends AbstractFormatoReparacionBienesDiversos {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoReparacionBienesDiversos() {
		super();
	}

	private static FormatoReparacionBienesDiversosServiceInterfase formatoReparacionBienesDiversosService;

	public static FormatoReparacionBienesDiversosServiceInterfase getFormatoReparacionBienesDiversosService() {
		if (FormatoReparacionBienesDiversos.formatoReparacionBienesDiversosService == null) {
			FormatoReparacionBienesDiversos.formatoReparacionBienesDiversosService = JMSIICAServerServiceSingleton
					.getInstance().getFormatoReparacionBienesDiversosService();
		}
		return FormatoReparacionBienesDiversos.formatoReparacionBienesDiversosService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		return FormatoReparacionBienesDiversos.getFormatoReparacionBienesDiversosService().guardarObjeto(this);
	}

}

