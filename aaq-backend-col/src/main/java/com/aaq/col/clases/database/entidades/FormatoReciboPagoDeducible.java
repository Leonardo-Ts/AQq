package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReciboPagoDeducible;
import com.aaq.col.clases.database.servicios.interfase.FormatoReciboPagoDeducibleServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoReciboPagoDeducible")
@RequestScoped
@Entity(name = "FormatoReciboPagoDeducible")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_recibo_deducible")
public class FormatoReciboPagoDeducible extends AbstractFormatoReciboPagoDeducible {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoReciboPagoDeducible() {
		super();
	}

	private static FormatoReciboPagoDeducibleServiceInterfase formatoReciboPagoDeducibleService;

	public static FormatoReciboPagoDeducibleServiceInterfase getFormatoReciboPagoDeducibleService() {
		if (FormatoReciboPagoDeducible.formatoReciboPagoDeducibleService == null) {
			FormatoReciboPagoDeducible.formatoReciboPagoDeducibleService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoReciboPagoDeducibleService();
		}
		return FormatoReciboPagoDeducible.formatoReciboPagoDeducibleService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoReciboPagoDeducible.getFormatoReciboPagoDeducibleService().guardarObjeto(this);

	}

}
