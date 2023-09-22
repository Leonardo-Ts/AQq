package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoDeclaracionUniversal;
import com.aaq.col.clases.database.servicios.interfase.FormatoDeclaracionUniversalServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoDeclaracionUniversal")
@RequestScoped
@Entity(name = "FormatoDeclaracionUniversal")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_declaracion_universal")
public class FormatoDeclaracionUniversal extends AbstractFormatoDeclaracionUniversal {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoDeclaracionUniversal() {
		super();
	}

	private static FormatoDeclaracionUniversalServiceInterfase formatoDeclaracionUniversalService;

	public static FormatoDeclaracionUniversalServiceInterfase getFormatoDeclaracionUniversalService() {
		if (FormatoDeclaracionUniversal.formatoDeclaracionUniversalService == null) {
			FormatoDeclaracionUniversal.formatoDeclaracionUniversalService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoDeclaracionUniversalService();
		}
		return FormatoDeclaracionUniversal.formatoDeclaracionUniversalService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoDeclaracionUniversal.getFormatoDeclaracionUniversalService().guardarObjeto(this);

	}

}
