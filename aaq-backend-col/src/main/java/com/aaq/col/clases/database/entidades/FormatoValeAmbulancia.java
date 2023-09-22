package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoValeAmbulancia;
import com.aaq.col.clases.database.servicios.interfase.FormatoValeAmbulanciaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

/**
 * 
 * @author jpestrategica6
 *
 */
@ManagedBean(name = "formatoValeAmbulancia")
@RequestScoped
@Entity(name = "FormatoValeAmbulancia")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_vale_ambulancia")
public class FormatoValeAmbulancia extends AbstractFormatoValeAmbulancia {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoValeAmbulancia() {
		super();
	}

	private static FormatoValeAmbulanciaServiceInterfase formatoValeAmbulanciaService;

	public static FormatoValeAmbulanciaServiceInterfase getFormatoValeAmbulanciaService() {
		if (FormatoValeAmbulancia.formatoValeAmbulanciaService == null) {
			FormatoValeAmbulancia.formatoValeAmbulanciaService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoValeAmbulanciaService();
		}
		return FormatoValeAmbulancia.formatoValeAmbulanciaService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		return FormatoValeAmbulancia.getFormatoValeAmbulanciaService().guardarObjeto(this);
	}

}
