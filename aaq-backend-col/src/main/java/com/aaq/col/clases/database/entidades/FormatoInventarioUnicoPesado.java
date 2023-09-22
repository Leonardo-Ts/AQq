package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoInventarioUnicoPesado;
import com.aaq.col.clases.database.servicios.interfase.FormatoInventarioUnicoPesadoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "formatoInventarioUnicoPesado")
@RequestScoped
@Entity(name = "FormatoInventarioUnicoPesado")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_inventario_unico_pesado")
public class FormatoInventarioUnicoPesado extends AbstractFormatoInventarioUnicoPesado {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoInventarioUnicoPesado() {
		super();
	}

	private static FormatoInventarioUnicoPesadoServiceInterfase formatoInventarioUnicoPesadoService;

	public static FormatoInventarioUnicoPesadoServiceInterfase getFormatoInventarioUnicoPesadoService() {
		if (FormatoInventarioUnicoPesado.formatoInventarioUnicoPesadoService == null) {
			FormatoInventarioUnicoPesado.formatoInventarioUnicoPesadoService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoInventarioUnicoPesadoService();
		}
		return FormatoInventarioUnicoPesado.formatoInventarioUnicoPesadoService;
	}
 
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoInventarioUnicoPesado.getFormatoInventarioUnicoPesadoService().guardarObjeto(this);

	}

}
