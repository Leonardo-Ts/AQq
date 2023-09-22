package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractFormatoMemoriaDescriptiva;
import com.aaq.col.clases.database.servicios.interfase.FormatoMemoriaDescriptivaServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "formatoMemoriaDescriptiva")
@RequestScoped
@Entity(name = "FormatoMemoriaDescriptiva")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "formato_memoria_descriptiva")
public class FormatoMemoriaDescriptiva extends AbstractFormatoMemoriaDescriptiva {

	private static final long serialVersionUID = -1750943915860651677L;

	public FormatoMemoriaDescriptiva() {
		super();
	}

	private static FormatoMemoriaDescriptivaServiceInterfase formatoMemoriaDescriptivaService;

	public static FormatoMemoriaDescriptivaServiceInterfase getFormatoMemoriaDescriptivaService() {
		if (FormatoMemoriaDescriptiva.formatoMemoriaDescriptivaService == null) {
			FormatoMemoriaDescriptiva.formatoMemoriaDescriptivaService = JMSIICAServerServiceSingleton.getInstance()
					.getFormatoMemoriaDescriptivaService();
		}
		return FormatoMemoriaDescriptiva.formatoMemoriaDescriptivaService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return FormatoMemoriaDescriptiva.getFormatoMemoriaDescriptivaService().guardarObjeto(this);

	}

}
