package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoInventarioAutomoviles;
import com.aaq.col.clases.database.servicios.interfase.FormatoInventarioAutomovilesServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoInventarioAutomoviles")
@RequestScoped
@Entity(name = "FormatoInventarioAutomoviles")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_inventario_automoviles")
public class FormatoInventarioAutomoviles extends AbstractFormatoInventarioAutomoviles {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoInventarioAutomoviles() {
		super();
	}

	private static FormatoInventarioAutomovilesServiceInterfase formatoInventarioAutomovilesService;

	public static FormatoInventarioAutomovilesServiceInterfase getFormatoInventarioAutomovilesService() {
		if (FormatoInventarioAutomoviles.formatoInventarioAutomovilesService == null) {
			FormatoInventarioAutomoviles.formatoInventarioAutomovilesService = JMSIICAServerServiceSingleton
					.getInstance().getFormatoInventarioAutomovilesService();
		}
		return FormatoInventarioAutomoviles.formatoInventarioAutomovilesService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoInventarioAutomoviles.getFormatoInventarioAutomovilesService().guardarObjeto(this);

	}

}
