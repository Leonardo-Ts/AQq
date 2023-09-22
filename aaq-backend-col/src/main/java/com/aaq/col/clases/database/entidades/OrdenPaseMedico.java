package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractOrdenPaseMedico;
import com.aaq.col.clases.database.servicios.interfase.OrdenPaseMedicoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "ordenPaseMedico")
@RequestScoped
@Entity(name = "ordenPaseMedico")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "orden_pase_medico")
public class OrdenPaseMedico extends AbstractOrdenPaseMedico {

	private static final long serialVersionUID = 8616450931397860477L;

	public OrdenPaseMedico() {
		super();
	}

	private static OrdenPaseMedicoServiceInterfase ordenPaseMedicoService;

	public static OrdenPaseMedicoServiceInterfase getOrdenPaseMedicoService() {
		if (OrdenPaseMedico.ordenPaseMedicoService == null) {
			OrdenPaseMedico.ordenPaseMedicoService = JMSIICAServerServiceSingleton.getInstance()
					.getOrdenPaseMedicoService();
		}
		return OrdenPaseMedico.ordenPaseMedicoService;
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return OrdenPaseMedico.getOrdenPaseMedicoService().guardarObjeto(this);

	}

}
