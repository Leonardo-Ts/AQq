package com.aaq.col.clases.database.servicios.interfase;


import java.util.Date;
import java.util.List;

import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.jmfg.jmlib.sistema.classes.dao.servicio.JMServicioGenericoInterfase;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

public interface ReporteMovilSacServiceInterfase extends JMServicioGenericoInterfase<ReporteMovilSac> {

	
	public abstract ReporteMovilSac objetoReporteMovilSac(final String numeroReporte, final String numeroAjustador) ;
	public abstract JMResultadoOperacion guardarObjeto(ReporteMovilSac rms);
	public abstract JMResultadoOperacion ejecutarFuncionReporteSacActualizarFechaReporteLecturaPorWs(Integer id) ;
	public abstract JMResultadoOperacion ejecutarFuncionReporteSacActualizarServiciosDiversosConsecutivos(final Integer id, final String data);
	public abstract List<ReporteMovilSac> listarReporteMovilSac(Date fechaInicial, Date fechaFinal, String estado, String base);
	public abstract List<EntidadObjeto> listaDeCodigosParaGrafica(Date fechaInicial, Date fechaFinal, String estado, String base);
	public abstract  Boolean verificarReporte(String reporte);
	public abstract String segundasAtenciones (String reporte,String ajustado, String usuarioAlta, String observacion, String edo, String colonia, 
				String calle, String entre, String refer);
	public abstract String nuevoReporteParaProveedor(final String numeroReporte, final String numeroProveedor, final String usuario, final String fuente, final Boolean reporteApartado);
	public abstract JMResultadoOperacion actualizarReporteSegundaAtencion(String reporte, String colonia, String calle, String entreCalle,
			String referencia, String observacion) ;
}