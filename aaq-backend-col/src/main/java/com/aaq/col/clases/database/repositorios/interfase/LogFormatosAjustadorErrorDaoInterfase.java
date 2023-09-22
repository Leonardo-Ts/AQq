package com.aaq.col.clases.database.repositorios.interfase;


import java.sql.Timestamp;
import java.util.List;

import com.aaq.col.clases.database.entidades.LogFormatosAjustadorError;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;


public interface LogFormatosAjustadorErrorDaoInterfase extends JMRepositorioGenericoInterfase<LogFormatosAjustadorError> {
	
	public abstract LogFormatosAjustadorError objetoLogFormatosAjustadorError(final String id);
	public abstract List<LogFormatosAjustadorError> listaDeLogFormatosAjustadorError();
	public abstract String ejecutarFuncionInsertarLogFormatosAjustadorError(
			String descripcion,
			String nombreFormato,
			String folioFormato,
			Timestamp fechaHora,
			Integer id
			
			);

}