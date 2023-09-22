 package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractOrdenPaseAmbulancia;
import com.aaq.col.clases.database.servicios.interfase.OrdenPaseAmbulanciaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "ordenPaseAmbulancia")
@RequestScoped
@Entity(name = "OrdenPaseAmbulancia")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "orden_pase_ambulancia")
public class OrdenPaseAmbulancia extends AbstractOrdenPaseAmbulancia {

	private static final long serialVersionUID = 8648458625868154424L;

	public OrdenPaseAmbulancia() {
		super();
	}

	private static OrdenPaseAmbulanciaServiceInterfase ordenPaseAmbulanciaService;

	public static OrdenPaseAmbulanciaServiceInterfase getOrdenPaseAmbulanciaService() {
		if (OrdenPaseAmbulancia.ordenPaseAmbulanciaService == null) {
			OrdenPaseAmbulancia.ordenPaseAmbulanciaService = JMSIICAServerServiceSingleton.getInstance()
					.getOrdenPaseAmbulanciaService();
		}
		return OrdenPaseAmbulancia.ordenPaseAmbulanciaService;
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return OrdenPaseAmbulancia.getOrdenPaseAmbulanciaService().guardarObjeto(this);

	}

}
