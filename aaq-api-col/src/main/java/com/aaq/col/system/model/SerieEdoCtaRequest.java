package com.aaq.col.system.model;

import java.util.List;

import com.aaq.col.clases.pojo.edocta.Serie6EdoCta;
import com.aaq.col.clases.pojo.edocta.SerieEdoCta;

public class SerieEdoCtaRequest {

	private boolean success;
	private List<SerieEdoCta> data;
	private List<Serie6EdoCta> data6;
	private String mensaje;
	
	public SerieEdoCtaRequest() {
		super();
	}

	public SerieEdoCtaRequest(boolean success, String mensaje) {
		super();
		this.success = success;
		this.mensaje = mensaje;
	}


	public SerieEdoCtaRequest(boolean success, List<SerieEdoCta> data, List<Serie6EdoCta> data6, String mensaje) {
		super();
		this.success = success;
		this.data = data;
		this.data6 = data6;
		this.mensaje = mensaje;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public List<SerieEdoCta> getData() {
		return data;
	}

	public void setData(List<SerieEdoCta> data) {
		this.data = data;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<Serie6EdoCta> getData6() {
		return data6;
	}

	public void setData6(List<Serie6EdoCta> data6) {
		this.data6 = data6;
	}

}
