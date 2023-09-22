package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import com.aaq.col.clases.database.entidades.abstracto.AbstractEncuestaAjustador;
import com.aaq.col.clases.database.servicios.interfase.EncuestaAjustadorServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMReporteOmitirMetodo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;


@ManagedBean(name = "encuestaAjustador")
@RequestScoped
@Entity(name = "EncuestaAjustador")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "encuesta_movil")
public class EncuestaAjustador extends AbstractEncuestaAjustador {
    private static final long serialVersionUID = -4802569510844617354L;

  
    public EncuestaAjustador() {
        super();

    }
    
    // **************************************************************//
    // Statico
    // **************************************************************//
    private static EncuestaAjustadorServiceInterfase encuestaAjustadorService;

    public static EncuestaAjustadorServiceInterfase getEncuestaAjustadorService() {
        if (EncuestaAjustador.encuestaAjustadorService == null) {
        	EncuestaAjustador.encuestaAjustadorService = JMSIICAServerServiceSingleton.getInstance().getEncuestaAjustadorService();
        }
        return EncuestaAjustador.encuestaAjustadorService;
    }
    
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte",
				"Clave Ajustador,claveAjustador", "Nombre Ajustador,nombreAjustador","Poliza,poliza",
			    "Fecha,fecha,fecha" })
				.getLista();
	}
	
	@JMReporteOmitirMetodo
	public String getClaveAjustador() {
		return this.getTerminal() != null ? this.getTerminal().getNumeroproveedor() : null;
	}
	
	@JMReporteOmitirMetodo
	public String getNombreAjustador() {
		return this.getTerminal() != null ? this.getTerminal().getNombre() : null;
	}

    
}
