package com.aaq.col.clases.pojo.aaq;

import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("reporteMovil")
public class ReportesM {

	private List<ReporteMovil> reporte;

	public List<ReporteMovil> getReporte() {
		return reporte;
	}

	public void setReporte(List<ReporteMovil> reporte) {
		this.reporte = reporte;
	}
	

	
}

