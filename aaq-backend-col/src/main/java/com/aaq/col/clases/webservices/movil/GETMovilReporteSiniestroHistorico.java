package com.aaq.col.clases.webservices.movil;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="GETMovilReporteSiniestroHistorico")
public class GETMovilReporteSiniestroHistorico {
	
	private String resultado;
	private List<String> lista;

	public GETMovilReporteSiniestroHistorico() {
		super();

	}
	
	public GETMovilReporteSiniestroHistorico(String resultado) {
		super();
		this.resultado = resultado;
	}


	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}

	
}
