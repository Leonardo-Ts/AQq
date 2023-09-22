package com.aaq.col.clases.database.repositorios.interfase;

import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.ExpedienteEjecutivo;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjetoQuinto;
import com.aaq.col.clases.database.entidades.pojo.ErrorFormatos;
import com.jmfg.jmlib.sistema.classes.dao.repositorio.JMRepositorioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ExpedienteEjecutivoDaoInterfase extends JMRepositorioGenericoInterfase<ExpedienteEjecutivo> {

	public abstract ExpedienteEjecutivo objetoExpediente(String id, String nombreFormato, String reporte);
	public abstract List<ExpedienteEjecutivo> listaDeExpedientesNoEnviado(Estado edo, Integer base, Integer terminal, 
			Date fechaInicio, Date fechaFin, String reporte, String nombreFormato, Boolean noSftp, Boolean noEmail,
			Boolean sftp, Boolean email);
	public abstract JMResultadoOperacion funcionExpedienteError(ErrorFormatos datos);
	public abstract ExpedienteEjecutivo funcionSeleccionaByIdFormato(int id);
	public abstract List<EntidadObjeto> obtenerContador(String reporte) ;
	public abstract JMResultadoOperacion ejecutarFuncionTableroEjecutivo(Terminal term, String nombreFormato, String claveProveedor,
			String reporte, Integer folio, boolean esAjusteExpres);
	public abstract List<EntidadObjeto> listaDeFormatosParaGrafica(Date fechaInicial, Date fechaFinal, Integer limite, Integer edo, Integer  base,
			String claveAjustador, String nombreFormato, Integer terminal, String reporte);
	public abstract List<EntidadObjetoQuinto> obtenerContadorTotal(Date fechaInicial, Date fechaFinal, Integer edo, Integer  base,
			String nombreFormato, Terminal terminal, String reporte) ;
	public abstract List<ExpedienteEjecutivo> listaDocumentos(String reporte, String claveAjustador);
	public abstract List<ExpedienteEjecutivo> listaDeExpedientesExcel(Estado edo, Integer base, Integer terminal, 
			Date fechaInicio, Date fechaFin, String reporte, String nombreFormato);
	public abstract List<EntidadObjeto> docEnviado(String nombreFormato, Terminal term,String reporte);

	

}
