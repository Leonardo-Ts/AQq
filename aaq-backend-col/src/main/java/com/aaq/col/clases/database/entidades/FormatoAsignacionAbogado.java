 package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoAsignacionAbogado;
import com.aaq.col.clases.database.servicios.interfase.FormatoAsignacionAbogadoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoAsignacionAbogado")
@RequestScoped
@Entity(name = "FormatoAsignacionAbogado")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_asignacion_abogado")
public class FormatoAsignacionAbogado extends AbstractFormatoAsignacionAbogado {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoAsignacionAbogado() {
		super();
	}

	private static FormatoAsignacionAbogadoServiceInterfase formatoAsignacionAbogadoService;

	public static FormatoAsignacionAbogadoServiceInterfase getFormatoAsignacionAbogadoService() {
		if (FormatoAsignacionAbogado.formatoAsignacionAbogadoService == null) {
			FormatoAsignacionAbogado.formatoAsignacionAbogadoService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoAsignacionAbogadoService();
		}
		return FormatoAsignacionAbogado.formatoAsignacionAbogadoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoAsignacionAbogado.getFormatoAsignacionAbogadoService().guardarObjeto(this);

	}

}
