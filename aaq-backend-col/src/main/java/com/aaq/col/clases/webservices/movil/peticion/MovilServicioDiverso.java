package com.aaq.col.clases.webservices.movil.peticion;

public class MovilServicioDiverso {
	private String usuario;
	private String passwd;
	private String tipoDeServicioSolicitado;
	private String atencionA;
	private String claveDeProveedor;
	private String folioValeTalonario;
	private String lesionadoNombre;
	private String lesionadoSexo;
	private String lesionadoEdad;
	private String claveDeAmbulancia;
	private String codigoME;
	private String cobertura;
	private String montoMedico;
	private String polizaTerceroQualitas;
	private String incisoTerceroQualitas;
	private String endosoTerceroQualitas;
	private String nombreDeProveedor;
	private String carrilExpress;
	private Boolean persona;
	private String idObjeto;
	private String danioMenor;
	
	private String folioAMIS;
	private String nombreAjustadorTercero;
	private String polizaTercero;
	private String incisoPolizaTercero;
	
	private String nombreSupervisor;
	private String mailSupervisor;
	private String telefonoSupervisor;
	    
	private String ptEvidente;
	private String abandonoEvidente;
	
	private String correoTercero;
	
	/**
	 * Constructor
	 */
	public MovilServicioDiverso() {
		super();
	}

	public MovilServicioDiverso(String usuario, String passwd, String tipoDeServicioSolicitado, String atencionA,
			String claveDeProveedor, String folioValeTalonario, String lesionadoNombre, String lesionadoSexo,
			String lesionadoEdad, String claveDeAmbulancia, String codigoME, String cobertura, String montoMedico,
			String polizaTerceroQualitas, String incisoTerceroQualitas, String endosoTerceroQualitas,
			String nombreDeProveedor, String carrilExpress, Boolean persona, String idObjeto, String danioMenor,
			String folioAMIS, String nombreAjustadorTercero, String polizaTercero, String incisoPolizaTercero,
			String nombreSupervisor, String mailSupervisor, String telefonoSupervisor, String ptEvidente,
			String abandonoEvidente, String correoTercero) {
		super();
		this.usuario = usuario;
		this.passwd = passwd;
		this.tipoDeServicioSolicitado = tipoDeServicioSolicitado;
		this.atencionA = atencionA;
		this.claveDeProveedor = claveDeProveedor;
		this.folioValeTalonario = folioValeTalonario;
		this.lesionadoNombre = lesionadoNombre;
		this.lesionadoSexo = lesionadoSexo;
		this.lesionadoEdad = lesionadoEdad;
		this.claveDeAmbulancia = claveDeAmbulancia;
		this.codigoME = codigoME;
		this.cobertura = cobertura;
		this.montoMedico = montoMedico;
		this.polizaTerceroQualitas = polizaTerceroQualitas;
		this.incisoTerceroQualitas = incisoTerceroQualitas;
		this.endosoTerceroQualitas = endosoTerceroQualitas;
		this.nombreDeProveedor = nombreDeProveedor;
		this.carrilExpress = carrilExpress;
		this.persona = persona;
		this.idObjeto = idObjeto;
		this.danioMenor = danioMenor;
		this.folioAMIS = folioAMIS;
		this.nombreAjustadorTercero = nombreAjustadorTercero;
		this.polizaTercero = polizaTercero;
		this.incisoPolizaTercero = incisoPolizaTercero;
		this.nombreSupervisor = nombreSupervisor;
		this.mailSupervisor = mailSupervisor;
		this.telefonoSupervisor = telefonoSupervisor;
		this.ptEvidente = ptEvidente;
		this.abandonoEvidente = abandonoEvidente;
		this.correoTercero = correoTercero;
	}

	public String getCodigoME() {
		return codigoME;
	}

	public void setCodigoME(final String codigoME) {
		this.codigoME = codigoME;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(final String usuario) {
		this.usuario = usuario;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(final String passwd) {
		this.passwd = passwd;
	}

	public String getTipoDeServicioSolicitado() {
		return this.tipoDeServicioSolicitado;
	}

	public void setTipoDeServicioSolicitado(final String tipoDeServicioSolicitado) {
		this.tipoDeServicioSolicitado = tipoDeServicioSolicitado;
	}

	public String getAtencionA() {
		return this.atencionA;
	}

	public void setAtencionA(final String atencionA) {
		this.atencionA = atencionA;
	}

	public String getClaveDeProveedor() {
		return this.claveDeProveedor;
	}

	public void setClaveDeProveedor(final String claveDeProveedor) {
		this.claveDeProveedor = claveDeProveedor;
	}

	public String getFolioValeTalonario() {
		return this.folioValeTalonario;
	}

	public void setFolioValeTalonario(final String folioValeTalonario) {
		this.folioValeTalonario = folioValeTalonario;
	}

	public String getLesionadoNombre() {
		return this.lesionadoNombre;
	}

	public void setLesionadoNombre(final String lesionadoNombre) {
		this.lesionadoNombre = lesionadoNombre;
	}

	public String getLesionadoSexo() {
		return this.lesionadoSexo;
	}

	public void setLesionadoSexo(final String lesionadoSexo) {
		this.lesionadoSexo = lesionadoSexo;
	}

	public String getLesionadoEdad() {
		return this.lesionadoEdad;
	}

	public void setLesionadoEdad(final String lesionadoEdad) {
		this.lesionadoEdad = lesionadoEdad;
	}

	public String getClaveDeAmbulancia() {
		return this.claveDeAmbulancia;
	}

	public void setClaveDeAmbulancia(final String claveDeAmbulancia) {
		this.claveDeAmbulancia = claveDeAmbulancia;
	}

	public String getCobertura() {
		return cobertura;
	}

	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}

	public String getMontoMedico() {
		return montoMedico;
	}
	
	public void setMontoMedico(String montoMedico) {
		this.montoMedico = montoMedico;
	}

	public String getPolizaTerceroQualitas() {
		return polizaTerceroQualitas;
	}

	public void setPolizaTerceroQualitas(String polizaTerceroQualitas) {
		this.polizaTerceroQualitas = polizaTerceroQualitas;
	}

	public String getIncisoTerceroQualitas() {
		return incisoTerceroQualitas;
	}

	public void setIncisoTerceroQualitas(String incisoTerceroQualitas) {
		this.incisoTerceroQualitas = incisoTerceroQualitas;
	}

	public String getEndosoTerceroQualitas() {
		return endosoTerceroQualitas;
	}

	public void setEndosoTerceroQualitas(String endosoTerceroQualitas) {
		this.endosoTerceroQualitas = endosoTerceroQualitas;
	}

	public String getNombreDeProveedor() {
		return nombreDeProveedor;
	}

	public void setNombreDeProveedor(String nombreDeProveedor) {
		this.nombreDeProveedor = nombreDeProveedor;
	}

	public String getCarrilExpress() {
		return carrilExpress;
	}

	public void setCarrilExpress(String carrilExpress) {
		this.carrilExpress = carrilExpress;
	}

	public Boolean getPersona() {
		return persona;
	}

	public void setPersona(Boolean persona) {
		this.persona = persona;
	}

	public String getIdObjeto() {
		return idObjeto;
	}

	public void setIdObjeto(String idObjeto) {
		this.idObjeto = idObjeto;
	}

	

	public String getDanioMenor() {
		return danioMenor;
	}


	public void setDanioMenor(String danioMenor) {
		this.danioMenor = danioMenor;
	}


	public String getFolioAMIS() {
		return folioAMIS;
	}

	public void setFolioAMIS(String folioAMIS) {
		this.folioAMIS = folioAMIS;
	}

	public String getNombreAjustadorTercero() {
		return nombreAjustadorTercero;
	}

	public void setNombreAjustadorTercero(String nombreAjustadorTercero) {
		this.nombreAjustadorTercero = nombreAjustadorTercero;
	}

	public String getPolizaTercero() {
		return polizaTercero;
	}

	public void setPolizaTercero(String polizaTercero) {
		this.polizaTercero = polizaTercero;
	}

	public String getIncisoPolizaTercero() {
		return incisoPolizaTercero;
	}

	public void setIncisoPolizaTercero(String incisoPolizaTercero) {
		this.incisoPolizaTercero = incisoPolizaTercero;
	}

	public String getNombreSupervisor() {
		return nombreSupervisor;
	}

	public void setNombreSupervisor(String nombreSupervisor) {
		this.nombreSupervisor = nombreSupervisor;
	}

	public String getMailSupervisor() {
		return mailSupervisor;
	}

	public void setMailSupervisor(String mailSupervisor) {
		this.mailSupervisor = mailSupervisor;
	}

	public String getTelefonoSupervisor() {
		return telefonoSupervisor;
	}

	public void setTelefonoSupervisor(String telefonoSupervisor) {
		this.telefonoSupervisor = telefonoSupervisor;
	}


	public String getPtEvidente() {
		return ptEvidente;
	}


	public void setPtEvidente(String ptEvidente) {
		this.ptEvidente = ptEvidente;
	}


	public String getAbandonoEvidente() {
		return abandonoEvidente;
	}


	public void setAbandonoEvidente(String abandonoEvidente) {
		this.abandonoEvidente = abandonoEvidente;
	}

	public String getCorreoTercero() {
		return correoTercero;
	}

	public void setCorreoTercero(String correoTercero) {
		this.correoTercero = correoTercero;
	}


	
	
}
