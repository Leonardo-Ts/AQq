package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReclamacionComprobantePeaje;
import com.aaq.col.clases.database.servicios.interfase.FormatoReclamacionComprobantePeajeServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

/**
 * 
 * @author jpestrategica6
 *
 */
@ManagedBean(name = "formatoReclamacionComprobantePeaje")
@RequestScoped
@Entity(name = "FormatoReclamacionComprobantePeaje")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_reclamacion_comprobante_peaje") 
public class FormatoReclamacionComprobantePeaje extends AbstractFormatoReclamacionComprobantePeaje {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoReclamacionComprobantePeaje() {
		super();
	}

	private static FormatoReclamacionComprobantePeajeServiceInterfase formatoReclamacionComprobantePeajeService;

	public static FormatoReclamacionComprobantePeajeServiceInterfase getFormatoReclamacionComprobantePeajeService() {
		if (FormatoReclamacionComprobantePeaje.formatoReclamacionComprobantePeajeService == null) {
			FormatoReclamacionComprobantePeaje.formatoReclamacionComprobantePeajeService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoReclamacionComprobantePeajeService();
		}
		return FormatoReclamacionComprobantePeaje.formatoReclamacionComprobantePeajeService;
	}
 
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoReclamacionComprobantePeaje.getFormatoReclamacionComprobantePeajeService().guardarObjeto(this);

	}

}
