package com.aaq.col.clases.database.entidades;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCalleCruce;
import com.aaq.col.clases.database.servicios.interfase.CalleCruceServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMPuntoGeografico;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import java.util.Objects;

@ManagedBean(name = "calleCruce")
@RequestScoped
@Entity(name = "CalleCruce")
@Access(AccessType.FIELD)
@Table(name = "calle_cruce")
public class CalleCruce extends AbstractCalleCruce {

	private static final long serialVersionUID = -9040833377810977103L;

	/** default constructor */
	public CalleCruce() {
		super();
	}

	private static CalleCruceServiceInterfase calleCruceService;

	public static CalleCruceServiceInterfase getCalleCruceService() {
		if (CalleCruce.calleCruceService == null) {
			CalleCruce.calleCruceService = JMSIICAServerServiceSingleton.getInstance().getCalleCruceService();
		}
		return CalleCruce.calleCruceService;
	}

	@JMReporteOmitirMetodo
	public JMPuntoGeografico toJMPuntoGeografico(){
		JMPuntoGeografico punto = new JMPuntoGeografico();
		punto.setEsArrastable(false);

		punto.setIconoNombre("punto_no_arrastrable");
		punto.setIconoArchivo("punto_no_arrastrable.png");

		punto.setLatitud(Objects.toString(this.getLatitud(), ""));
		punto.setLongitud(Objects.toString(this.getLongitud(), ""));
		punto.setDescripcionHTML(this.getHTML());
		punto.setEtiqueta(this.getNombreCalleUno() + " Y " + this.getNombreCalleDos());

		punto.setIdentificadorUnico("cruce" + Objects.toString(this.getId(), ""));
		return punto;

	}
	
	public String getNombreCruce() {
		return this.getNombreCalleUno() + " Y " + this.getNombreCalleDos();
	}

	public String getHTML() {
		return "<b>Nombre:</b>" + this.getNombreCruce() + "<br><b>Colonia:</b>" + this.getNombreColoniaUno()
				+ "<br>Municipio:</b>" + this.getNombreMunicipioUno();

	}

	@Override
	public JMResultadoOperacion editarObjeto() {
		return null;
	}

	@Override
	public JMResultadoOperacion eliminarObjeto() {
		return new JMResultadoOperacion(new Exception("No se puede Eliminar. Catalogo de Sistema"));
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CalleCruce.getCalleCruceService().guardarObjeto(this);
		} catch (final Exception ex) {
			return new JMResultadoOperacion(ex);
		}
	}

}
