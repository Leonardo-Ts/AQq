 package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoAsistenciaVial;
import com.aaq.col.clases.database.servicios.interfase.FormatoAsistenciaVialServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoAsistenciaVial")
@RequestScoped
@Entity(name = "FormatoAsistenciaVial")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_asistencia_vial")
public class FormatoAsistenciaVial extends AbstractFormatoAsistenciaVial {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoAsistenciaVial() {
		super();
	}

	private static FormatoAsistenciaVialServiceInterfase formatoAsistenciaVialService;

	public static FormatoAsistenciaVialServiceInterfase getFormatoAsistenciaVialService() {
		if (FormatoAsistenciaVial.formatoAsistenciaVialService == null) {
			FormatoAsistenciaVial.formatoAsistenciaVialService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoAsistenciaVialService();
		}
		return FormatoAsistenciaVial.formatoAsistenciaVialService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		return FormatoAsistenciaVial.getFormatoAsistenciaVialService().guardarObjeto(this);
	}

}
