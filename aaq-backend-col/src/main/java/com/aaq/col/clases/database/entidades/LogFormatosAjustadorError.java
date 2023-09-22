package com.aaq.col.clases.database.entidades;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aaq.col.clases.database.entidades.abstracto.AbstractLogFormatosAjustadorError;
import com.aaq.col.clases.database.servicios.interfase.LogFormatosAjustadorErrorServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


 
@ManagedBean(name = "logFormatosAjustadorError")
@RequestScoped
@Entity(name = "LogFormatosAjustadorError")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "log_formatos_ajustador_error")
public class LogFormatosAjustadorError extends AbstractLogFormatosAjustadorError {

	private static final long serialVersionUID = -1750943915860651677L;

	public LogFormatosAjustadorError() {
		super();
	}

	private static LogFormatosAjustadorErrorServiceInterfase logFormatosAjustadorErrorService;

	public static LogFormatosAjustadorErrorServiceInterfase getLogFormatosAjustadorErrorService() {
		if (LogFormatosAjustadorError.logFormatosAjustadorErrorService == null) {
			LogFormatosAjustadorError.logFormatosAjustadorErrorService = JMSIICAServerServiceSingleton.getInstance()
					.getLogFormatosAjustadorErrorService();
		}
		return LogFormatosAjustadorError.logFormatosAjustadorErrorService;
	}

	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Numero Reporte,numeroReporte", "Clave Ajustador,claveProveedor",
				"Tipo de Orden,tipoOrden", "Fecha,fechaHora,fecha" }).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {

		return LogFormatosAjustadorError.getLogFormatosAjustadorErrorService().guardarObjeto(this);

	}

}
