/**
 * @author Arturo de la Cruz
 */
package com.aaq.col.clases.webservices.ordenes;

//import java.util.Arrays;

/**
 * @author Arturo de la Cruz
 *
 */
public class ReporteOrdenes {

	private String numeroReporte;
	private String tipoServicio;
	private Object servicio;
	private byte[] bytesPDF;
	private String nombrePDF;

	public ReporteOrdenes() {
		super();
	}

	/**
	 * @param numeroReporte
	 * @param tipoServicio
	 * @param servicio
	 * @param bytesPDF
	 * @param nombrePDF
	 */
	public ReporteOrdenes(String numeroReporte, String tipoServicio, Object servicio, byte[] bytesPDF, String nombrePDF) {
		super();
		this.numeroReporte = numeroReporte;
		this.tipoServicio = tipoServicio;
		this.servicio = servicio;
		this.bytesPDF = bytesPDF;
		this.nombrePDF = nombrePDF;
	}

	/**
	 * @return the numeroReporte
	 */
	public String getNumeroReporte() {
		return numeroReporte;
	}

	/**
	 * @param numeroReporte
	 *            the numeroReporte to set
	 */
	public void setNumeroReporte(String numeroReporte) {
		this.numeroReporte = numeroReporte;
	}

	/**
	 * @return the tipoServicio
	 */
	public String getTipoServicio() {
		return tipoServicio;
	}

	/**
	 * @param tipoServicio
	 *            the tipoServicio to set
	 */
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	/**
	 * @return the servicio
	 */
	public Object getServicio() {
		return servicio;
	}

	/**
	 * @param servicio
	 *            the servicio to set
	 */
	public void setServicio(Object servicio) {
		this.servicio = servicio;
	}

	/**
	 * @return the bytesPDF
	 */
	public byte[] getBytesPDF() {
		return bytesPDF;
	}

	/**
	 * @param bytesPDF
	 *            the bytesPDF to set
	 */
	public void setBytesPDF(byte[] bytesPDF) {
		this.bytesPDF = bytesPDF;
	}

	/**
	 * @return the nombrePDF
	 */
	public String getNombrePDF() {
		return nombrePDF;
	}

	/**
	 * @param nombrePDF
	 *            the nombrePDF to set
	 */
	public void setNombrePDF(String nombrePDF) {
		this.nombrePDF = nombrePDF;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "ReporteOrdenes [numeroReporte=" + numeroReporte + ", tipoServicio=" + tipoServicio + ", servicio=" + servicio + ", bytesPDF=" + Arrays.toString(bytesPDF) + ", nombrePDF=" + nombrePDF
				+ "]";
	}*/
	
	@Override
	public String toString() {
		return numeroReporte + ", " + tipoServicio;
	}
}
