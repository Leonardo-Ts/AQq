package com.aaq.col.clases.database.servicios.interfase;

import java.sql.Timestamp;
import java.util.List;

import com.aaq.col.clases.database.entidades.LogFormatosAjustadorError;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface LogFormatosAjustadorErrorServiceInterfase
		extends JMServicioGenericoInterfase<LogFormatosAjustadorError> {

	public abstract LogFormatosAjustadorError objetoLogFormatosAjustadorError(final String id);
	public abstract JMResultadoOperacion guardarObjeto(LogFormatosAjustadorError t);
	public abstract List<LogFormatosAjustadorError> listaDeLogFormatosAjustadorError();
	public abstract String ejecutarFuncionInsertarLogFormatosAjustadorError(
			String descripcion, String nombreFormato, String folioFormato, Timestamp fechaHora, Integer id
	);

}