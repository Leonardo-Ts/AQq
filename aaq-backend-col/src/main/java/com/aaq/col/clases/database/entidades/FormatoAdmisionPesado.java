 package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoAdmisionPesado;
import com.aaq.col.clases.database.servicios.interfase.FormatoAdmisionPesadoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoAdmisionPesado")
@RequestScoped
@Entity(name = "FormatoAdmisionPesado")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_admision_pesado")
public class FormatoAdmisionPesado extends AbstractFormatoAdmisionPesado {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoAdmisionPesado() {
		super();
	}

	private static FormatoAdmisionPesadoServiceInterfase formatoAdmisionPesadoService;

	public static FormatoAdmisionPesadoServiceInterfase getFormatoAdmisionPesadoService() {
		if (FormatoAdmisionPesado.formatoAdmisionPesadoService == null) {
			FormatoAdmisionPesado.formatoAdmisionPesadoService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoAdmisionPesadoService();
		}
		return FormatoAdmisionPesado.formatoAdmisionPesadoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		return FormatoAdmisionPesado.getFormatoAdmisionPesadoService().guardarObjeto(this);
	}

}
