package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoCargoTarjetaCredito;
import com.aaq.col.clases.database.servicios.interfase.FormatoCargoTarjetaCreditoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoCargoTarjetaCredito")
@RequestScoped
@Entity(name = "FormatoCargoTarjetaCredito")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_cargo_tarjeta_credito")
public class FormatoCargoTarjetaCredito extends AbstractFormatoCargoTarjetaCredito {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoCargoTarjetaCredito() {
		super();
	}

	private static FormatoCargoTarjetaCreditoServiceInterfase formatoCargoTarjetaCreditoService;

	public static FormatoCargoTarjetaCreditoServiceInterfase getFormatoCargoTarjetaCreditoService() {
		if (FormatoCargoTarjetaCredito.formatoCargoTarjetaCreditoService == null) {
			FormatoCargoTarjetaCredito.formatoCargoTarjetaCreditoService = JMSIICAServerServiceSingleton
					.getInstance().getFormatoCargoTarjetaCreditoService();
		}
		return FormatoCargoTarjetaCredito.formatoCargoTarjetaCreditoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		return FormatoCargoTarjetaCredito.getFormatoCargoTarjetaCreditoService().guardarObjeto(this);
	}

}

