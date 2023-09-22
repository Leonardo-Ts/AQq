 package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoGarantiaPrendaria;
import com.aaq.col.clases.database.servicios.interfase.FormatoGarantiaPrendariaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoGarantiaPrendaria")
@RequestScoped
@Entity(name = "FormatoGarantiaPrendaria")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_garantia_prendaria")
public class FormatoGarantiaPrendaria extends AbstractFormatoGarantiaPrendaria {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoGarantiaPrendaria() {
		super();
	}

	private static FormatoGarantiaPrendariaServiceInterfase formatoGarantiaPrendariaService;

	public static FormatoGarantiaPrendariaServiceInterfase getFormatoGarantiaPrendariaService() {
		if (FormatoGarantiaPrendaria.formatoGarantiaPrendariaService == null) {
			FormatoGarantiaPrendaria.formatoGarantiaPrendariaService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoGarantiaPrendariaService();
		}
		return FormatoGarantiaPrendaria.formatoGarantiaPrendariaService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoGarantiaPrendaria.getFormatoGarantiaPrendariaService().guardarObjeto(this);

	}

}
