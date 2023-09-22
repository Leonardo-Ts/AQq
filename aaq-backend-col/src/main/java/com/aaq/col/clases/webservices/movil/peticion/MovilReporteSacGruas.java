package com.aaq.col.clases.webservices.movil.peticion;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MovilReporteSacGruas {

	@XmlElement(name = "Grua")
	private List<MovilReporteSacGrua> grua;

	/**
	 * @return the grua
	 */
	public List<MovilReporteSacGrua> getGrua() {
		return grua;
	}

	/**
	 * @param grua the grua to set
	 */
	public void setGrua(List<MovilReporteSacGrua> grua) {
		this.grua = grua;
	}

}
