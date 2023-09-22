package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoPaseMedico;
import com.aaq.col.clases.database.servicios.interfase.FormatoPaseMedicoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "formatoPaseMedico")
@RequestScoped
@Entity(name = "FormatoPaseMedico")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_pase_medico")
public class FormatoPaseMedico extends AbstractFormatoPaseMedico {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoPaseMedico() {
		super();
	}

	private static FormatoPaseMedicoServiceInterfase formatoPaseMedicoService;

	public static FormatoPaseMedicoServiceInterfase getFormatoPaseMedicoService() {
		if (FormatoPaseMedico.formatoPaseMedicoService == null) {
			FormatoPaseMedico.formatoPaseMedicoService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoPaseMedicoService();
		}
		return FormatoPaseMedico.formatoPaseMedicoService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoPaseMedico.getFormatoPaseMedicoService().guardarObjeto(this);

	}

}
