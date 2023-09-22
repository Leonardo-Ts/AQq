package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractEntidadAbogadoCrm;
import com.aaq.col.clases.database.servicios.interfase.EntidadAbogadoCrmServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;


@ManagedBean(name = "entidadAbogadoCrm")
@RequestScoped
@Entity(name = "EntidadAbogadoCrm")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "entidad_abogado_crm")
public class EntidadAbogadoCrm extends AbstractEntidadAbogadoCrm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3128459577940914421L;
	

	/** default constructor */
	public EntidadAbogadoCrm() {
		super();

	}

	private static EntidadAbogadoCrmServiceInterfase entidadAbogadoCrmService;

	public static EntidadAbogadoCrmServiceInterfase getEntidadAbogadoCrmService() {
		if (EntidadAbogadoCrm.entidadAbogadoCrmService == null) {
			EntidadAbogadoCrm.entidadAbogadoCrmService = JMSIICAServerServiceSingleton.getInstance().getEntidadAbogadoCrmService();
		}
		return EntidadAbogadoCrm.entidadAbogadoCrmService;
	}
}
