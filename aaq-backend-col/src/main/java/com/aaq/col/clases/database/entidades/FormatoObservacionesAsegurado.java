package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoObservacionesAsegurado;
import com.aaq.col.clases.database.servicios.interfase.FormatoObservacionesAseguradoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "formatoObservacionesAsegurado")
@RequestScoped
@Entity(name = "FormatoObservacionesAsegurado")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_observaciones_asegurado")
public class FormatoObservacionesAsegurado extends AbstractFormatoObservacionesAsegurado {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoObservacionesAsegurado() {
		super();
	}

	// **************************************************************//
	private static FormatoObservacionesAseguradoServiceInterfase formatoObservacionesAseguradoService;

	public static FormatoObservacionesAseguradoServiceInterfase getFormatoObservacionesAseguradoService() {
		if (FormatoObservacionesAsegurado.formatoObservacionesAseguradoService == null) {
			FormatoObservacionesAsegurado.formatoObservacionesAseguradoService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoObservacionesAseguradoService();
		}
		return FormatoObservacionesAsegurado.formatoObservacionesAseguradoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoObservacionesAsegurado.getFormatoObservacionesAseguradoService().guardarObjeto(this);

	}

}
