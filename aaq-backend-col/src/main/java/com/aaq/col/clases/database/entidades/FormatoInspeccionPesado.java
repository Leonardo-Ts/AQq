package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoInspeccionPesado;
import com.aaq.col.clases.database.servicios.interfase.FormatoInspeccionPesadoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "formatoInspeccionPesado")
@RequestScoped
@Entity(name = "FormatoInspeccionPesado")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_inspeccion_pesado")
public class FormatoInspeccionPesado extends AbstractFormatoInspeccionPesado {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoInspeccionPesado() {
		super();
	}

	private static FormatoInspeccionPesadoServiceInterfase formatoInspeccionPesadoService;

	public static FormatoInspeccionPesadoServiceInterfase getFormatoInspeccionPesadoService() {
		if (FormatoInspeccionPesado.formatoInspeccionPesadoService == null) {
			FormatoInspeccionPesado.formatoInspeccionPesadoService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoInspeccionPesadoService();
		}
		return FormatoInspeccionPesado.formatoInspeccionPesadoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoInspeccionPesado.getFormatoInspeccionPesadoService().guardarObjeto(this);

	}

}
