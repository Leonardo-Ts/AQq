 package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoResponsabilidadCivil;
import com.aaq.col.clases.database.servicios.interfase.FormatoResponsabilidadCivilServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoResponsabilidadCivil")
@RequestScoped
@Entity(name = "FormatoResponsabilidadCivil")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_responsabilidad_civil")
public class FormatoResponsabilidadCivil extends AbstractFormatoResponsabilidadCivil {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoResponsabilidadCivil() {
		super();
	}

	private static FormatoResponsabilidadCivilServiceInterfase formatoResponsabilidadCivilService;

	public static FormatoResponsabilidadCivilServiceInterfase getFormatoResponsabilidadCivilService() {
		if (FormatoResponsabilidadCivil.formatoResponsabilidadCivilService == null) {
			FormatoResponsabilidadCivil.formatoResponsabilidadCivilService = JMSIICAServerServiceSingleton
					.getInstance().getFormatoResponsabilidadCivilService();
		}
		return FormatoResponsabilidadCivil.formatoResponsabilidadCivilService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoResponsabilidadCivil.getFormatoResponsabilidadCivilService().guardarObjeto(this);

	}

}

