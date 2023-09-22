package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;
import java.util.List;

public class InsertarCobertura implements Serializable {

	private static final long serialVersionUID = -3911361535517287535L;
	
	private List<Cobertura> coberturas;

	public List<Cobertura> getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(List<Cobertura> coberturas) {
		this.coberturas = coberturas;
	}
}
