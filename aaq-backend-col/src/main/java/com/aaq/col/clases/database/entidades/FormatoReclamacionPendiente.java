package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoReclamacionPendiente;
import com.aaq.col.clases.database.servicios.interfase.FormatoReclamacionPendienteServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoReclamacionPendiente")
@RequestScoped
@Entity(name = "FormatoReclamacionPendiente")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_reclamacion_pendiente")
public class FormatoReclamacionPendiente extends AbstractFormatoReclamacionPendiente {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoReclamacionPendiente() {
		super();
	}

	private static FormatoReclamacionPendienteServiceInterfase formatoReclamacionPendienteService;

	public static FormatoReclamacionPendienteServiceInterfase getFormatoReclamacionPendienteService() {
		if (FormatoReclamacionPendiente.formatoReclamacionPendienteService == null) {
			FormatoReclamacionPendiente.formatoReclamacionPendienteService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoReclamacionPendienteService();
		}
		return FormatoReclamacionPendiente.formatoReclamacionPendienteService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoReclamacionPendiente.getFormatoReclamacionPendienteService().guardarObjeto(this);

	}

}
