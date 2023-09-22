package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractOrdenPaseReclamacion;
import com.aaq.col.clases.database.servicios.interfase.OrdenPaseReclamacionServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "ordenPaseReclamacion")
@RequestScoped
@Entity(name = "ordenPaseReclamacion")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "orden_pase_reclamacion")
public class OrdenPaseReclamacion extends AbstractOrdenPaseReclamacion {

	private static final long serialVersionUID = -1344152880765008126L;

	public OrdenPaseReclamacion() {
		super();
	}

	private static OrdenPaseReclamacionServiceInterfase ordenPaseReclamacionService;

	public static OrdenPaseReclamacionServiceInterfase getOrdenPaseReclamacionService() {
		if (OrdenPaseReclamacion.ordenPaseReclamacionService == null) {
			OrdenPaseReclamacion.ordenPaseReclamacionService = JMSIICAServerServiceSingleton.getInstance()
					.getOrdenPaseReclamacionService();
		}
		return OrdenPaseReclamacion.ordenPaseReclamacionService;
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return OrdenPaseReclamacion.getOrdenPaseReclamacionService().guardarObjeto(this);

	}

}
