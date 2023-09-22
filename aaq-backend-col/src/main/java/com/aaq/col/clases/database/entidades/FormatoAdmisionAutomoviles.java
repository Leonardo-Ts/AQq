package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoAdmisionAutomoviles;
import com.aaq.col.clases.database.servicios.interfase.FormatoAdmisionAutomovilesServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

 
@ManagedBean(name = "formatoAdmisionAutomoviles")
@RequestScoped
@Entity(name = "FormatoAdmisionAutomoviles")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_admision_automoviles")
public class FormatoAdmisionAutomoviles extends AbstractFormatoAdmisionAutomoviles {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoAdmisionAutomoviles() {
		super();
	}

	private static FormatoAdmisionAutomovilesServiceInterfase formatoAdmisionAutomovilesService;

	public static FormatoAdmisionAutomovilesServiceInterfase getFormatoAdmisionAutomovilesService() {
		if (FormatoAdmisionAutomoviles.formatoAdmisionAutomovilesService == null) {
			FormatoAdmisionAutomoviles.formatoAdmisionAutomovilesService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoAdmisionAutomovilesService();
		}
		return FormatoAdmisionAutomoviles.formatoAdmisionAutomovilesService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoAdmisionAutomoviles.getFormatoAdmisionAutomovilesService().guardarObjeto(this);

	}

}
