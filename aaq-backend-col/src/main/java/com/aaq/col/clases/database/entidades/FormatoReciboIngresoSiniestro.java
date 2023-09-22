package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReciboIngresoSiniestro;
import com.aaq.col.clases.database.servicios.interfase.FormatoReciboIngresoSiniestroServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "formatoReciboIngresoSiniestro")
@RequestScoped
@Entity(name = "FormatoReciboIngresoSiniestro")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_recibo_ingreso")
public class FormatoReciboIngresoSiniestro extends AbstractFormatoReciboIngresoSiniestro {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoReciboIngresoSiniestro() {
		super();
	}

	private static FormatoReciboIngresoSiniestroServiceInterfase formatoReciboIngresoSiniestroService;

	public static FormatoReciboIngresoSiniestroServiceInterfase getFormatoReciboIngresoSiniestroService() {
		if (FormatoReciboIngresoSiniestro.formatoReciboIngresoSiniestroService == null) {
			FormatoReciboIngresoSiniestro.formatoReciboIngresoSiniestroService = JMSIICAServerServiceSingleton
					.getInstance().getFormatoReciboIngresoSiniestroService();
		}
		return FormatoReciboIngresoSiniestro.formatoReciboIngresoSiniestroService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoReciboIngresoSiniestro.getFormatoReciboIngresoSiniestroService().guardarObjeto(this);

	}

}
