package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractReporteMovilSacGruas;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacGruasServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "reporteMovilSacGruas")
@RequestScoped
@Entity(name = "ReporteMovilSacGruas")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "reporte_movil_sac_gruas")
public class ReporteMovilSacGruas extends AbstractReporteMovilSacGruas {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1966795787415473228L;

	/** default constructor */
	public ReporteMovilSacGruas() {
		super();

	}

	private static ReporteMovilSacGruasServiceInterfase reporteMovilSacGruasService;

	public static ReporteMovilSacGruasServiceInterfase getReporteMovilSacGruasService() {
		if (ReporteMovilSacGruas.reporteMovilSacGruasService == null) {
			ReporteMovilSacGruas.reporteMovilSacGruasService = JMSIICAServerServiceSingleton.getInstance().getReporteMovilSacGruasService();
		}
		return ReporteMovilSacGruas.reporteMovilSacGruasService;
	}
	
	 @Override
	 public JMResultadoOperacion guardarObjeto() {
	 	try {
	 		return ReporteMovilSacGruas.getReporteMovilSacGruasService().guardarObjeto(this);
	 	} catch (Exception e) {
			return new JMResultadoOperacion(e);
		}
	 		
	 	}

}
