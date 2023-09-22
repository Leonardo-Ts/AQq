package com.aaq.col.clases.database.entidades.pojo;

import net.sf.jasperreports.engine.JRDataSource;

public class ReportePadre {

	JRDataSource dataSource;
	
	public ReportePadre() {
		super();
	}

	public ReportePadre(JRDataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public JRDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(JRDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
}
