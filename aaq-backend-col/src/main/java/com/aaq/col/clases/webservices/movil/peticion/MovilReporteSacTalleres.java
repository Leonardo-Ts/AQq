package com.aaq.col.clases.webservices.movil.peticion;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MovilReporteSacTalleres {

	@XmlElement(name = "Taller")
	private List<MovilReporteSacTaller> taller;

	/**
	 * @return the taller
	 */
	public List<MovilReporteSacTaller> getTaller() {
		return taller;
	}

	/**
	 * @param taller the taller to set
	 */
	public void setTaller(List<MovilReporteSacTaller> taller) {
		this.taller = taller;
	}


}
