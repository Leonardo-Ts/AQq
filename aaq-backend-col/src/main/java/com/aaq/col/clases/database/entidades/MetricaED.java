package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractMetricaED;
import com.aaq.col.clases.database.servicios.interfase.MetricaEDServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;

@ManagedBean(name = "metricaED")
@RequestScoped
@Entity(name = "MetricaED")
@Access(AccessType.FIELD)
@Table(name = "METRICA_ED")
public class MetricaED extends AbstractMetricaED {

	private static final long serialVersionUID = 4676584496780111154L;

	public MetricaED() {
		super();
	}
	
	private static MetricaEDServiceInterfase metricaEDService;

	public static MetricaEDServiceInterfase getMetricaEDService() {
		if (MetricaED.metricaEDService == null) {
			MetricaED.metricaEDService = JMSIICAServerServiceSingleton.getInstance().getMetricaEDService(); 
		}
		return MetricaED.metricaEDService;
	}

	
	
}
