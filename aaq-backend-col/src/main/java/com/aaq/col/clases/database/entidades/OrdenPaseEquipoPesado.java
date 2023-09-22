 package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractOrdenPaseEquipoPesado;
import com.aaq.col.clases.database.servicios.interfase.OrdenPaseEquipoPesadoServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


@ManagedBean(name = "ordenPaseEquipoPesado")
@RequestScoped
@Entity(name = "ordenPaseEquipoPesado")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "orden_pase_equipesado")
public class OrdenPaseEquipoPesado extends AbstractOrdenPaseEquipoPesado {

	private static final long serialVersionUID = -2708677428129959695L;

	public OrdenPaseEquipoPesado() {
		super();
	}

	private static OrdenPaseEquipoPesadoServiceInterfase ordenPaseEquipoPesadoService;

	/**
	 * 
	 * @return
	 */
	public static OrdenPaseEquipoPesadoServiceInterfase getOrdenPaseEquipoPesadoService() {
		if (OrdenPaseEquipoPesado.ordenPaseEquipoPesadoService == null) {
			OrdenPaseEquipoPesado.ordenPaseEquipoPesadoService = JMSIICAServerServiceSingleton.getInstance()
					.getOrdenPaseEquipoPesadoService();
		}
		return OrdenPaseEquipoPesado.ordenPaseEquipoPesadoService;
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return OrdenPaseEquipoPesado.getOrdenPaseEquipoPesadoService().guardarObjeto(this);

	}

}
