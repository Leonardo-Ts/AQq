package com.aaq.col.clases.webservices.formatos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FormatoOdaAuto {
	private String asegurado;
	private String tercero;
	/*private Integer NO_AVISO;
	private Integer FOLIO;
	private Integer TERCERO_ASEGURADO_Q;
	private Integer NO_SINIESTRO;
	private Integer FOLIO_ELECTRONICO;
	private Integer NO_POLIZA;
	private String NO_ENDOSO;
	private Integer NO_INCISO;
	private String NOMBRE_RAZON_SOCIAL;
	private String EMAIL;
	private Integer TELEFONO;
	private String TALLER;
	private String RESPONSABLE;
	private Integer TELEFONO_RESP;
	private String DIRECCION;
	private String COBERTURA;
	private String MARCA;
	private String LINEA;
	private String MODELO_ANIO;
	private String KILOMETRAJE;
	private Integer NO_SERIE;
	private String COLOR;
	private String PLACAS;
	private String TRANSMISION;
	private String CD_DC_CLIENTE;
	private String CD_PAGADO_QUALITAS;
	private Integer VALOR_ASEGURADO;
	private String CHXCH;
	private String ACUERDO_Q;
	private String CADE;
	private String ERO3_SIN_POLIZA;
	private Integer FIJO;
	private Integer FIJO_2;
	private Integer PORCENTAJE_PERDIDO;
	private Integer V_A;
	private String POSIBLE_AGRAVACION;
	private String CASO_INUNDACION_LV1;
	private String CASO_INUNDACION_LV2;
	private String CASO_INUNDACION_LV3;
	private String PERDIDA_TOTAL_DANIOS;
	private String DANIO_PREEXISTENTE;
	private String CEDULA_CIUDADANIA;
	private String TITULAR_DATOS;
	private String FIRMA_ABOGADO;
	private String DESC_DANIOS;
	private String NOMBRE_PERITO;
	private String FIRMA_PERITO;
	private String NOMBRE_RECLAM;
	private String FIRMA_RECLAM;
	private String CEDULA_CIUDADANIAPERITO;
	private String FECHA;*/
	


	public FormatoOdaAuto() {
		super();
	}


	//	Asegurado
	public String getAsegurado() {
		return asegurado;
	}

	public void setAsegurado(String asegurado) {
		this.asegurado = asegurado;
	}

	
	//	Tercero
	public String getTercero() {
		return tercero;
	}

	public void setTercero(String tercero) {
		this.tercero = tercero;
	}
	
	
	@Override
	public String toString() {
		/*return "FormatoOdaAuto [asegurado=" + asegurado + ", tercero=" + tercero + ", getTercero()=" + getTercero()
				+ ", getAsegurado()=" + getAsegurado() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";*/
		return "FormatoOdaAuto [asegurado=" + getAsegurado() + ", tercero=" + getTercero() + "]";
	}
	
	
	/*public String getTERCERO() {
		return TERCERO;
	}
	public void setTERCERO(String tERCERO) {
		TERCERO = tERCERO;
	}
	public Integer getNO_AVISO() {
		return NO_AVISO;
	}
	public void setNO_AVISO(Integer nO_AVISO) {
		NO_AVISO = nO_AVISO;
	}
	public Integer getFOLIO() {
		return FOLIO;
	}
	public void setFOLIO(Integer fOLIO) {
		FOLIO = fOLIO;
	}
	public Integer getTERCERO_ASEGURADO_Q() {
		return TERCERO_ASEGURADO_Q;
	}
	public void setTERCERO_ASEGURADO_Q(Integer tERCERO_ASEGURADO_Q) {
		TERCERO_ASEGURADO_Q = tERCERO_ASEGURADO_Q;
	}
	public Integer getNO_SINIESTRO() {
		return NO_SINIESTRO;
	}
	public void setNO_SINIESTRO(Integer nO_SINIESTRO) {
		NO_SINIESTRO = nO_SINIESTRO;
	}
	public Integer getFOLIO_ELECTRONICO() {
		return FOLIO_ELECTRONICO;
	}
	public void setFOLIO_ELECTRONICO(Integer fOLIO_ELECTRONICO) {
		FOLIO_ELECTRONICO = fOLIO_ELECTRONICO;
	}
	public Integer getNO_POLIZA() {
		return NO_POLIZA;
	}
	public void setNO_POLIZA(Integer nO_POLIZA) {
		NO_POLIZA = nO_POLIZA;
	}
	public String getNO_ENDOSO() {
		return NO_ENDOSO;
	}
	public void setNO_ENDOSO(String nO_ENDOSO) {
		NO_ENDOSO = nO_ENDOSO;
	}
	public Integer getNO_INCISO() {
		return NO_INCISO;
	}
	public void setNO_INCISO(Integer nO_INCISO) {
		NO_INCISO = nO_INCISO;
	}
	public String getNOMBRE_RAZON_SOCIAL() {
		return NOMBRE_RAZON_SOCIAL;
	}
	public void setNOMBRE_RAZON_SOCIAL(String nOMBRE_RAZON_SOCIAL) {
		NOMBRE_RAZON_SOCIAL = nOMBRE_RAZON_SOCIAL;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public Integer getTELEFONO() {
		return TELEFONO;
	}
	public void setTELEFONO(Integer tELEFONO) {
		TELEFONO = tELEFONO;
	}
	public String getTALLER() {
		return TALLER;
	}
	public void setTALLER(String tALLER) {
		TALLER = tALLER;
	}
	public String getRESPONSABLE() {
		return RESPONSABLE;
	}
	public void setRESPONSABLE(String rESPONSABLE) {
		RESPONSABLE = rESPONSABLE;
	}
	public Integer getTELEFONO_RESP() {
		return TELEFONO_RESP;
	}
	public void setTELEFONO_RESP(Integer tELEFONO_RESP) {
		TELEFONO_RESP = tELEFONO_RESP;
	}
	public String getDIRECCION() {
		return DIRECCION;
	}
	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}
	public String getCOBERTURA() {
		return COBERTURA;
	}
	public void setCOBERTURA(String cOBERTURA) {
		COBERTURA = cOBERTURA;
	}
	public String getMARCA() {
		return MARCA;
	}
	public void setMARCA(String mARCA) {
		MARCA = mARCA;
	}
	public String getLINEA() {
		return LINEA;
	}
	public void setLINEA(String lINEA) {
		LINEA = lINEA;
	}
	public String getMODELO_ANIO() {
		return MODELO_ANIO;
	}
	public void setMODELO_ANIO(String mODELO_ANIO) {
		MODELO_ANIO = mODELO_ANIO;
	}
	public String getKILOMETRAJE() {
		return KILOMETRAJE;
	}
	public void setKILOMETRAJE(String kILOMETRAJE) {
		KILOMETRAJE = kILOMETRAJE;
	}
	public Integer getNO_SERIE() {
		return NO_SERIE;
	}
	public void setNO_SERIE(Integer nO_SERIE) {
		NO_SERIE = nO_SERIE;
	}
	public String getCOLOR() {
		return COLOR;
	}
	public void setCOLOR(String cOLOR) {
		COLOR = cOLOR;
	}
	public String getPLACAS() {
		return PLACAS;
	}
	public void setPLACAS(String pLACAS) {
		PLACAS = pLACAS;
	}
	public String getTRANSMISION() {
		return TRANSMISION;
	}
	public void setTRANSMISION(String tRANSMISION) {
		TRANSMISION = tRANSMISION;
	}
	public String getCD_DC_CLIENTE() {
		return CD_DC_CLIENTE;
	}
	public void setCD_DC_CLIENTE(String cD_DC_CLIENTE) {
		CD_DC_CLIENTE = cD_DC_CLIENTE;
	}
	public String getCD_PAGADO_QUALITAS() {
		return CD_PAGADO_QUALITAS;
	}
	public void setCD_PAGADO_QUALITAS(String cD_PAGADO_QUALITAS) {
		CD_PAGADO_QUALITAS = cD_PAGADO_QUALITAS;
	}
	public Integer getVALOR_ASEGURADO() {
		return VALOR_ASEGURADO;
	}
	public void setVALOR_ASEGURADO(Integer vALOR_ASEGURADO) {
		VALOR_ASEGURADO = vALOR_ASEGURADO;
	}
	public String getCHXCH() {
		return CHXCH;
	}
	public void setCHXCH(String cHXCH) {
		CHXCH = cHXCH;
	}
	public String getACUERDO_Q() {
		return ACUERDO_Q;
	}
	public void setACUERDO_Q(String aCUERDO_Q) {
		ACUERDO_Q = aCUERDO_Q;
	}
	public String getCADE() {
		return CADE;
	}
	public void setCADE(String cADE) {
		CADE = cADE;
	}
	public String getERO3_SIN_POLIZA() {
		return ERO3_SIN_POLIZA;
	}
	public void setERO3_SIN_POLIZA(String eRO3_SIN_POLIZA) {
		ERO3_SIN_POLIZA = eRO3_SIN_POLIZA;
	}
	public Integer getFIJO() {
		return FIJO;
	}
	public void setFIJO(Integer fIJO) {
		FIJO = fIJO;
	}
	public Integer getFIJO_2() {
		return FIJO_2;
	}
	public void setFIJO_2(Integer fIJO_2) {
		FIJO_2 = fIJO_2;
	}
	public Integer getPORCENTAJE_PERDIDO() {
		return PORCENTAJE_PERDIDO;
	}
	public void setPORCENTAJE_PERDIDO(Integer pORCENTAJE_PERDIDO) {
		PORCENTAJE_PERDIDO = pORCENTAJE_PERDIDO;
	}
	public Integer getV_A() {
		return V_A;
	}
	public void setV_A(Integer v_A) {
		V_A = v_A;
	}
	public String getPOSIBLE_AGRAVACION() {
		return POSIBLE_AGRAVACION;
	}
	public void setPOSIBLE_AGRAVACION(String pOSIBLE_AGRAVACION) {
		POSIBLE_AGRAVACION = pOSIBLE_AGRAVACION;
	}
	public String getCASO_INUNDACION_LV1() {
		return CASO_INUNDACION_LV1;
	}
	public void setCASO_INUNDACION_LV1(String cASO_INUNDACION_LV1) {
		CASO_INUNDACION_LV1 = cASO_INUNDACION_LV1;
	}
	public String getCASO_INUNDACION_LV2() {
		return CASO_INUNDACION_LV2;
	}
	public void setCASO_INUNDACION_LV2(String cASO_INUNDACION_LV2) {
		CASO_INUNDACION_LV2 = cASO_INUNDACION_LV2;
	}
	public String getCASO_INUNDACION_LV3() {
		return CASO_INUNDACION_LV3;
	}
	public void setCASO_INUNDACION_LV3(String cASO_INUNDACION_LV3) {
		CASO_INUNDACION_LV3 = cASO_INUNDACION_LV3;
	}
	public String getPERDIDA_TOTAL_DANIOS() {
		return PERDIDA_TOTAL_DANIOS;
	}
	public void setPERDIDA_TOTAL_DANIOS(String pERDIDA_TOTAL_DANIOS) {
		PERDIDA_TOTAL_DANIOS = pERDIDA_TOTAL_DANIOS;
	}
	public String getDANIO_PREEXISTENTE() {
		return DANIO_PREEXISTENTE;
	}
	public void setDANIO_PREEXISTENTE(String dANIO_PREEXISTENTE) {
		DANIO_PREEXISTENTE = dANIO_PREEXISTENTE;
	}
	public String getCEDULA_CIUDADANIA() {
		return CEDULA_CIUDADANIA;
	}
	public void setCEDULA_CIUDADANIA(String cEDULA_CIUDADANIA) {
		CEDULA_CIUDADANIA = cEDULA_CIUDADANIA;
	}
	public String getTITULAR_DATOS() {
		return TITULAR_DATOS;
	}
	public void setTITULAR_DATOS(String tITULAR_DATOS) {
		TITULAR_DATOS = tITULAR_DATOS;
	}
	public String getFIRMA_ABOGADO() {
		return FIRMA_ABOGADO;
	}
	public void setFIRMA_ABOGADO(String fIRMA_ABOGADO) {
		FIRMA_ABOGADO = fIRMA_ABOGADO;
	}
	public String getDESC_DANIOS() {
		return DESC_DANIOS;
	}
	public void setDESC_DANIOS(String dESC_DANIOS) {
		DESC_DANIOS = dESC_DANIOS;
	}
	public String getNOMBRE_PERITO() {
		return NOMBRE_PERITO;
	}
	public void setNOMBRE_PERITO(String nOMBRE_PERITO) {
		NOMBRE_PERITO = nOMBRE_PERITO;
	}
	public String getFIRMA_PERITO() {
		return FIRMA_PERITO;
	}
	public void setFIRMA_PERITO(String fIRMA_PERITO) {
		FIRMA_PERITO = fIRMA_PERITO;
	}
	public String getNOMBRE_RECLAM() {
		return NOMBRE_RECLAM;
	}
	public void setNOMBRE_RECLAM(String nOMBRE_RECLAM) {
		NOMBRE_RECLAM = nOMBRE_RECLAM;
	}
	public String getFIRMA_RECLAM() {
		return FIRMA_RECLAM;
	}
	public void setFIRMA_RECLAM(String fIRMA_RECLAM) {
		FIRMA_RECLAM = fIRMA_RECLAM;
	}
	public String getCEDULA_CIUDADANIAPERITO() {
		return CEDULA_CIUDADANIAPERITO;
	}
	public void setCEDULA_CIUDADANIAPERITO(String cEDULA_CIUDADANIAPERITO) {
		CEDULA_CIUDADANIAPERITO = cEDULA_CIUDADANIAPERITO;
	}
	public String getFECHA() {
		return FECHA;
	}
	public void setFECHA(String fECHA) {
		FECHA = fECHA;
	}*/

	
}
