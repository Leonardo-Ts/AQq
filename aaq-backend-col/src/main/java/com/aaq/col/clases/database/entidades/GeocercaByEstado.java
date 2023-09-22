 package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.IdValidation;
import org.eclipse.persistence.annotations.PrimaryKey;

import com.aaq.col.clases.database.entidades.abstracto.AbstractGeocercaByEstado;
import com.aaq.col.clases.database.servicios.interfase.GeocercaByEstadoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;


@ManagedBean(name = "geocerca_by_estado")
@RequestScoped
@PrimaryKey(validation = IdValidation.NULL)
@Entity(name = "GeocercaByEstado")
@Access(AccessType.FIELD)
@Table(name = "geocerca_by_estado")
public class GeocercaByEstado extends AbstractGeocercaByEstado {

	private static final long serialVersionUID = 8382504690392969414L;
	
	
	private static GeocercaByEstadoServiceInterfase geocercaByEstadoService;

	
	public static GeocercaByEstadoServiceInterfase getGeocercaByEstadoService() {
		if (GeocercaByEstado.geocercaByEstadoService == null) {
			GeocercaByEstado.geocercaByEstadoService = JMSIICAServerServiceSingleton.getInstance().getGeocercaByEstadoService();
		}
		return GeocercaByEstado.geocercaByEstadoService;
	}
	
	@Override
	public String toString() {
		return this.getGeocerca();

	}


	

}
