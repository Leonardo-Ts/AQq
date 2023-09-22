package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoNuevosVehiculos;
import com.aaq.col.clases.database.servicios.interfase.FormatoNuevosVehiculosServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoNuevosVehiculos")
@RequestScoped
@Entity(name = "FormatoNuevosVehiculos")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_nuevos_vehiculos")
public class FormatoNuevosVehiculos extends AbstractFormatoNuevosVehiculos {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoNuevosVehiculos() {
		super();
	}

	private static FormatoNuevosVehiculosServiceInterfase formatoNuevosVehiculosService;

	public static FormatoNuevosVehiculosServiceInterfase getFormatoNuevosVehiculosService() {
		if (FormatoNuevosVehiculos.formatoNuevosVehiculosService == null) {
			FormatoNuevosVehiculos.formatoNuevosVehiculosService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoNuevosVehiculosService();
		}
		return FormatoNuevosVehiculos.formatoNuevosVehiculosService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoNuevosVehiculos.getFormatoNuevosVehiculosService().guardarObjeto(this);

	}

}
