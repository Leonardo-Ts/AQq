package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoEncuestaServicio;
import com.aaq.col.clases.database.servicios.interfase.FormatoEncuestaServicioServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoEncuestaServicio")
@RequestScoped
@Entity(name = "FormatoEncuestaServicio")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_encuesta_servicio")
public class FormatoEncuestaServicio extends AbstractFormatoEncuestaServicio {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoEncuestaServicio() {
		super();
	}

	private static FormatoEncuestaServicioServiceInterfase formatoEncuestaServicioService;

	public static FormatoEncuestaServicioServiceInterfase getFormatoEncuestaServicioService() {
		if (FormatoEncuestaServicio.formatoEncuestaServicioService == null) {
			FormatoEncuestaServicio.formatoEncuestaServicioService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoEncuestaServicioService();
		}
		return FormatoEncuestaServicio.formatoEncuestaServicioService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		return FormatoEncuestaServicio.getFormatoEncuestaServicioService().guardarObjeto(this);
	}

}
