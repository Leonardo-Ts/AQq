package com.aaq.col.clases.webservices.movil.peticion;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.ReporteMovilSacGruas;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacGruasServiceInterfase;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MovilDatosGrua {

	private String resultado;
	
	private MovilReporteSiseGruas reporte;
	
	private static ReporteMovilSacGruasServiceInterfase reporteMovilSacGruasDao = ReporteMovilSacGruas
			.getReporteMovilSacGruasService();
	
//	private static ReportePortalGruaServiceInterfase reportePortalGruaDao = ReportePortalGrua
//			.getReportePortalGruaService();

	public MovilDatosGrua() {
		super();
	}
	
//	@SuppressWarnings("unchecked")
	public MovilDatosGrua(final String resultado,  final ReporteMovilSac reporteSac) {
		this.resultado = resultado;
		
		
		//REPORTE SAC
		if(reporteSac != null){
			
			this.reporte = new MovilReporteSiseGruas();
//					,reporteSac.getGeneralPolizaEstatus());			
		
		if ((this.reporte != null)) {
			
				List<ReporteMovilSacGruas> lista = null;
				try {
					lista = MovilDatosGrua.reporteMovilSacGruasDao.listaDeReporteMovilSacGruas(reporteSac.getGeneralNumeroReporte(), reporteSac.getAjusteAjustadorCodigo());
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("listaDeReporteMovilSacGruas", ex);
				}
				if ((lista != null) && (lista.size() > 0)) {
					for (final ReporteMovilSacGruas rmsg : lista) {	
						this.reporte.getGruas().add(new MovilReporteSiseGrua(rmsg.getClave(), rmsg.getEstatus(), 
								rmsg.getProveedorClave(), rmsg.getProveedorNombre(), rmsg.getFechaEstimada(), rmsg.getHoraEstimada(),
								rmsg.getTipoAfectado()));
					}
				}
			}
		}
	}
	
	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public static ReporteMovilSacGruasServiceInterfase getReporteMovilSacGruasDao() {
		return reporteMovilSacGruasDao;
	}

	public static void setReporteMovilSacGruasDao(ReporteMovilSacGruasServiceInterfase reporteMovilSacGruasDao) {
		MovilDatosGrua.reporteMovilSacGruasDao = reporteMovilSacGruasDao;
	}

}
