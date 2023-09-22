package com.aaq.col.clases.database.servicios.interfase;

import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aaq.col.clases.database.entidades.HistoricoResumenAjustador;
import com.aaq.col.clases.database.entidades.pojo.ReporteResumenAjus;
import com.aaq.col.clases.pojo.conclusion.ReporteResumenAjustN;
import com.aaq.col.clases.pojo.conclusion.ResumenAjustadorInfo;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface HistoricoResumenAjustadorServiceInterfase
		extends JMServicioGenericoInterfase<HistoricoResumenAjustador> {

	public abstract JMResultadoOperacion ejecutarFuncionHistoricoResumenAjustadorNuevo(String cveAjustador,
			String nombreAjustador, String numReporte, String poliza, String incisoEstatus, String actividad,
			String usuario, String fuente, String descripcionActividad, String resultado) ;
	public abstract JMResultadoOperacion eliminarObjeto(HistoricoResumenAjustador historicoResumenAjustador);
	public abstract JMResultadoOperacion guardarObjeto(HistoricoResumenAjustador historicoResumenAjustador);
	public abstract List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustador(String reporte, String claveAjustador,
			String actividad, Date fechaInicial, Date fechaFinal);
	public abstract List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustador(String reporte);
	public abstract void generaReporteAjustadoresResumen(String reporte, String claveAjustador,
			String actividad, Date fechaInicial, Date fechaFinal,OutputStream ou,String ruta) ;
	List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustadorFreq(
			String reporte,
			List<String> clavesAjustadores,
			String actividad, Date fechaInicial, Date fechaFinal);
	void generaReporteAjustadoresResumenFreq(String reporte, List<String> claveAjustador, String actividad, Date fechaInicial,
			Date fechaFinal, OutputStream ou, String ruta);
	void notificacionTerminoAtencion(String reporte, String claveAjustador, String correo) ;
	void notificacionTerminoAtencionAgente(String reporte, String claveAjustador, String correo) ;
	public abstract ResumenAjustadorInfo consultarResumenAjustador  (String reporte) ;
	public List<HistoricoResumenAjustador> listaDeHistoricoResumenAjustadorGestion(String reporte, String actividad);
	public  ReporteResumenAjus parseaDatos(List<HistoricoResumenAjustador> datos,String numReporte,String ruta);
	public abstract void generaReporteAjustadoresResumenN(String reporte,
			String claveAjustador, String actividad, Date fechaInicial,
			Date fechaFinal, OutputStream ou, String ruta, String cedulaAjustador) ;
	public abstract boolean generaReporteDeslindeResponsabilidad(String reporte,String asegurado, String conductor,
			String siniestro,String ajustador,  Map<String, Object> dua, OutputStream ou, String ruta,  String responsable, String conclusiones) ;
	public abstract ReporteResumenAjustN parseaDatosN(List<HistoricoResumenAjustador> datos,String numReporte,String ruta,
			String claveAjustador, boolean equipoPesado);
	public abstract void generaReporteAjustadoresResumenWeb(String reporte, String claveAjustador, String actividad, Date fechaInicial, Date fechaFinal, OutputStream ou, String ruta);
	public abstract void generaReporteAjustadoresResumenFreqWeb(String reporte, List <String> claveAjustador, String actividad, Date fechaInicial, Date fechaFinal, OutputStream ou, String ruta) ;
}