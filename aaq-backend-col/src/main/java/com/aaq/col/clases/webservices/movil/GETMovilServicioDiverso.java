package com.aaq.col.clases.webservices.movil;

public class GETMovilServicioDiverso {
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

	public GETMovilServicioDiverso() {
		super();
	}

    public GETMovilServicioDiverso (final String usuario, final String passwd, final String tipoDeServicioSolicitado, final String atencionA, final String claveDeProveedor, final String folioValeTalonario, final String lesionadoNombre, final String lesionadoSexo, final String lesionadoEdad, final String claveDeAmbulancia, final String codigoME) {
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
    }

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getTipoDeServicioSolicitado() {
		return tipoDeServicioSolicitado;
	}

	public void setTipoDeServicioSolicitado(String tipoDeServicioSolicitado) {
		this.tipoDeServicioSolicitado = tipoDeServicioSolicitado;
	}

	public String getAtencionA() {
		return atencionA;
	}

	public void setAtencionA(String atencionA) {
		this.atencionA = atencionA;
	}

	public String getClaveDeProveedor() {
		return claveDeProveedor;
	}

	public void setClaveDeProveedor(String claveDeProveedor) {
		this.claveDeProveedor = claveDeProveedor;
	}

	public String getFolioValeTalonario() {
		return folioValeTalonario;
	}

	public void setFolioValeTalonario(String folioValeTalonario) {
		this.folioValeTalonario = folioValeTalonario;
	}

	public String getLesionadoNombre() {
		return lesionadoNombre;
	}

	public void setLesionadoNombre(String lesionadoNombre) {
		this.lesionadoNombre = lesionadoNombre;
	}

	public String getLesionadoSexo() {
		return lesionadoSexo;
	}

	public void setLesionadoSexo(String lesionadoSexo) {
		this.lesionadoSexo = lesionadoSexo;
	}

	public String getLesionadoEdad() {
		return lesionadoEdad;
	}

	public void setLesionadoEdad(String lesionadoEdad) {
		this.lesionadoEdad = lesionadoEdad;
	}

	public String getClaveDeAmbulancia() {
		return claveDeAmbulancia;
	}

	public void setClaveDeAmbulancia(String claveDeAmbulancia) {
		this.claveDeAmbulancia = claveDeAmbulancia;
	}

	public String getCodigoME() {
		return codigoME;
	}

	public void setCodigoME(String codigoME) {
		this.codigoME = codigoME;
	}

}
