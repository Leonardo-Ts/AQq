package com.aaq.col.clases.database.entidades.pojo;

import java.io.Serializable;
import java.util.List;

public class InsertarGestion implements Serializable{

	private static final long serialVersionUID = 6637596915031300508L;
	
	private List<Recupero> recuperos;
	private List<Tercero> terceros;
		
	public List<Recupero> getRecuperos() {
		return recuperos;
	}
	public void setRecuperos(List<Recupero> recuperos) {
		this.recuperos = recuperos;
	}
	public List<Tercero> getTerceros() {
		return terceros;
	}
	public void setTerceros(List<Tercero> terceros) {
		this.terceros = terceros;
	}
}
