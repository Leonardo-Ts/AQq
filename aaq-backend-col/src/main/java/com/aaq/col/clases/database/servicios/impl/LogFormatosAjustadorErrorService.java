package com.aaq.col.clases.database.servicios.impl;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aaq.col.clases.database.entidades.LogFormatosAjustadorError;
import com.aaq.col.clases.database.repositorios.impl.LogFormatosAjustadorErrorDao;
import com.aaq.col.clases.database.servicios.interfase.LogFormatosAjustadorErrorServiceInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@Service("logFormatosAjustadorErrorService")
@Transactional
public class LogFormatosAjustadorErrorService implements LogFormatosAjustadorErrorServiceInterfase {
	
	@Autowired
	@Qualifier("logFormatosAjustadorErrorDao")
	LogFormatosAjustadorErrorDao logFormatosAjustadorErrorDao;

	@Override
	public LogFormatosAjustadorError objetoLogFormatosAjustadorError(String id) {
		return this.logFormatosAjustadorErrorDao.objetoLogFormatosAjustadorError(id);
	}

	@Override
	public String ejecutarFuncionInsertarLogFormatosAjustadorError(

			String descripcion, String nombreFormato, String folioFormato, Timestamp fechaHora, Integer id

	) {
		return this.logFormatosAjustadorErrorDao.ejecutarFuncionInsertarLogFormatosAjustadorError(

				descripcion, nombreFormato, folioFormato, fechaHora, id

		);
	}

	@Override
	public List<LogFormatosAjustadorError> listaDeLogFormatosAjustadorError() {
		return this.logFormatosAjustadorErrorDao.listaDeLogFormatosAjustadorError();
	}

	@Override
	public JMResultadoOperacion guardarObjeto(LogFormatosAjustadorError t) {

		return this.logFormatosAjustadorErrorDao.guardarObjeto(t);
	}

}