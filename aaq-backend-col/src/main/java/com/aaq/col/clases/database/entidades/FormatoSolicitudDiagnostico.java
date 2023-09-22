package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoSolicitudDiagnostico;
import com.aaq.col.clases.database.servicios.interfase.FormatoSolicitudDiagnosticoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoSolicitudDiagnostico")
@RequestScoped
@Entity(name = "FormatoSolicitudDiagnostico")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_solicitud_diagnostico")
public class FormatoSolicitudDiagnostico extends AbstractFormatoSolicitudDiagnostico {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoSolicitudDiagnostico() {
		super();
	}

	private static FormatoSolicitudDiagnosticoServiceInterfase formatoSolicitudDiagnosticoService;

	public static FormatoSolicitudDiagnosticoServiceInterfase getFormatoSolicitudDiagnosticoService() {
		if (FormatoSolicitudDiagnostico.formatoSolicitudDiagnosticoService == null) {
			FormatoSolicitudDiagnostico.formatoSolicitudDiagnosticoService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoSolicitudDiagnosticoService();
		}
		return FormatoSolicitudDiagnostico.formatoSolicitudDiagnosticoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoSolicitudDiagnostico.getFormatoSolicitudDiagnosticoService().guardarObjeto(this);
	}

}
