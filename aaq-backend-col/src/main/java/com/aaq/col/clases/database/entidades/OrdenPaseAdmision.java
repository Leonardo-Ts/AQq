 package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractOrdenPaseAdmision;
import com.aaq.col.clases.database.servicios.interfase.OrdenPaseAdmisionServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "ordenPaseAdmision")
@RequestScoped
@Entity(name = "OrdenPaseAdmision")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "orden_pase_admision")
public class OrdenPaseAdmision extends AbstractOrdenPaseAdmision {

	private static final long serialVersionUID = -1750943915860651677L;

	public OrdenPaseAdmision() {
		super();
	}

	private static OrdenPaseAdmisionServiceInterfase ordenPaseAdmisionService;

	public static OrdenPaseAdmisionServiceInterfase getOrdenPaseAdmisionService() {
		if (OrdenPaseAdmision.ordenPaseAdmisionService == null) {
			OrdenPaseAdmision.ordenPaseAdmisionService = JMSIICAServerServiceSingleton.getInstance()
					.getOrdenPaseAdmisionService();
		}
		return OrdenPaseAdmision.ordenPaseAdmisionService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		return OrdenPaseAdmision.getOrdenPaseAdmisionService().guardarObjeto(this);

	}

}
