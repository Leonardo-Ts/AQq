 package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.HistoricoResumenAjustador;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;


public interface HistoricoResumenAjustadorDaoInterfase extends
		JMRepositorioGenericoInterfase<HistoricoResumenAjustador> {
	
	public abstract JMResultadoOperacion ejecutarFuncionHistoricoResumenAjustadorNuevo(String cveAjustador, String nombreAjustador, String numReporte, String poliza, 
			String incisoEstatus, String actividad, String usuario, String fuente, String descripcionActividad, String resultado);
	
	public abstract List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustador(String reporte, String claveAjustador,
			String actividad, Date fechaInicial, Date fechaFinal);
	
	public abstract List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustadorGestion (String reporte, String actividad);
	
	public abstract List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustadorFreqWeb(String reporte, List<String> claveAjustador, String actividad, Date fechaInicial, Date fechaFinal);

}