package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoInspeccionMoto;
import com.aaq.col.clases.database.servicios.interfase.FormatoInspeccionMotoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

/**
 * 
 * @author jpestrategica6
 *
 */
@ManagedBean(name = "formatoInspeccionMoto")
@RequestScoped
@Entity(name = "FormatoInspeccionMoto")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_inspeccion_moto")
public class FormatoInspeccionMoto extends AbstractFormatoInspeccionMoto {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoInspeccionMoto() {
		super();
	}

	// **************************************************************//
	// Statico
	// **************************************************************//
	private static FormatoInspeccionMotoServiceInterfase formatoInspeccionMotoService;

	public static FormatoInspeccionMotoServiceInterfase getFormatoInspeccionMotoService() {
		if (FormatoInspeccionMoto.formatoInspeccionMotoService == null) {
			FormatoInspeccionMoto.formatoInspeccionMotoService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoInspeccionMotoService();
		}
		return FormatoInspeccionMoto.formatoInspeccionMotoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		return FormatoInspeccionMoto.getFormatoInspeccionMotoService().guardarObjeto(this);
	}

}
