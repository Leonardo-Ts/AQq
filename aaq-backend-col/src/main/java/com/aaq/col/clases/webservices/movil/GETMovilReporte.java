package com.aaq.col.clases.webservices.movil;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.ReporteMovilSacGruas;
import com.aaq.col.clases.database.entidades.ReporteMovilSacTalleres;
import com.aaq.col.clases.database.entidades.ReporteMovilSacTerceros;
import com.aaq.col.clases.database.entidades.ReporteSise;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacGruasServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacTalleresServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ReporteMovilSacTercerosServiceInterfase;
import com.aaq.col.clases.webservices.movil.peticion.MovilReporteSise;
import com.aaq.col.clases.webservices.movil.peticion.MovilReporteSiseGrua;
import com.aaq.col.clases.webservices.movil.peticion.MovilReporteSiseTaller;
import com.aaq.col.clases.webservices.movil.peticion.MovilReporteSiseTercero;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

@XmlRootElement(name = "GETMovilReporte")
public class GETMovilReporte {
	
	private String resultado;

	private MovilReporteSise reporte;
	
	private boolean esAjustadorVulnerable;
	
//	private static ReportePortalGruaServiceInterfase reportePortalGruaDao = ReportePortalGrua
//			.getReportePortalGruaService();
	
	private static ReporteMovilSacTalleresServiceInterfase reporteMovilSacTalleresDao = ReporteMovilSacTalleres
			.getReporteMovilSacTalleresService();
	
	private static ReporteMovilSacTercerosServiceInterfase reporteMovilSacTercerosDao = ReporteMovilSacTerceros
			.getReporteMovilSacTercerosService();
	
	private static ReporteMovilSacGruasServiceInterfase reporteMovilSacGruasDao = ReporteMovilSacGruas
			.getReporteMovilSacGruasService();

	public GETMovilReporte() {
		super();
	}


	@SuppressWarnings({"unused" })
	public GETMovilReporte(final String resultado, final ReporteSise reporteSise, final ReporteMovilSac reporteSac, final boolean esAjustadorVulnerable) {
		SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-mm-dd");
		String fechaOcurrido = "";
		this.resultado = resultado;
		this.esAjustadorVulnerable= esAjustadorVulnerable;
		//REPORTE SAC
		if(reporteSac != null){
			
			this.reporte = new MovilReporteSise(
					null, null, 
					reporteSac.getFecha(),
					reporteSac.getGeneralNumeroReporte(), reporteSac.getGeneralNumeroPoliza(),
					reporteSac.getGeneralEndoso(), reporteSac.getGeneralInciso(),
					reporteSac.getGeneralNombreAsegurado(), reporteSac.getConductorNombre(),
					reporteSac.getVehiculoSerie(), reporteSac.getVehiculoPlacas(),
					reporteSac.getAjusteFechaPasadoAjustador(), // cambio
					reporteSac.getAjusteFechaArriboAjustador(),
					reporteSac.getAjusteFechaTerminoAjustador(), reporteSac.getGeneralComoOcurrio(),
					reporteSac.getAjusteHoraPasadoAjustador(), // cambio
					reporteSac.getAjusteHoraArriboAjustador(),
					reporteSac.getAjusteHoraTerminoAjustador(), reporteSac.getAjusteCodigoCausa(),
					reporteSac.getConductorTelefonoContacto(), reporteSac.getGeneralNumeroSiniestro(),
					reporteSac.getVehiculoMarca(), reporteSac.getVehiculoTipo(), reporteSac.getVehiculoModelo(),
					reporteSac.getVehiculoColor(), reporteSac.getGeneralUsuario(),
					reporteSac.getEsReasignadoNumero(), reporteSac.getEsSegundaAtencion(),
					reporteSac.getEsReasignado(), reporteSac.getCoordLatitudInicio(),
					reporteSac.getCoordLongitudInicio(), reporteSac.getCoordLatitudArribo(),
					reporteSac.getCoordLongitudArribo(), reporteSac.getCoordLatitudTermino(),
					reporteSac.getCoordLongitudTermino(), reporteSac.getGeneralOficinaReporte(),
					reporteSac.getGeneralFechaOcurrido(), reporteSac.getGeneralHoraOcurrido(),
					reporteSac.getGeneralAseguradoCodigo(), reporteSac.getGeneralAseguradoTelefonoEncuesta(),
					reporteSac.getGeneralAseguradoTelefono(), reporteSac.getGeneralReporto(),
					reporteSac.getGeneralObservacion(), reporteSac.getGeneralTipoReporte(),
					reporteSac.getConductorEdad(), reporteSac.getConductorSexo(),
					reporteSac.getUbicacionDireccion(), reporteSac.getUbicacionCarretera(),
					reporteSac.getUbicacionNacional(), reporteSac.getUbicacionCodigoPostal(),
					reporteSac.getUbicacionEntidad(), reporteSac.getUbicacionMunicipio(),
					reporteSac.getUbicacionColoniaCodigo(), reporteSac.getUbicacionColoniaDesc(),
					null, null,
					reporteSac.getVehiculoMotor(), reporteSac.getAjusteAjustadorCodigo(),
					reporteSac.getAjusteAjustadorNombre(), reporteSac.getAjusteAjustadorOficina(),
					null, null,	null, null,	null, null,
					reporteSac.getFechaReporteLecturaPorWs() != null ? true : false, reporteSac.getGeneralFechaRegistroSiniestro(),
					reporteSac.getGeneralMonedaClave(), reporteSac.getGeneralMonedaNombre(),
					reporteSac.getUbicacionReferencia(), reporteSac.getToken(),reporteSac.getLatitudTelefonia(),
					reporteSac.getLongitudTelefonia(),reporteSac.getLatitudRadio(),
					reporteSac.getLongitudRadio(), reporteSac.getGeneralCorreoAsegurado(), reporteSac.getDeducibleNocturno(),
					reporteSac.getTipoUnidadAsegurado(),
					((reporteSac.getServicioAmbulancia() != null && reporteSac.getServicioAmbulancia() == true) ? "SI" : "NO"));
//					,reporteSac.getGeneralPolizaEstatus());			
		}
		
		if ((this.reporte != null)) {
			
			// Insercion de Talleres
			if (StringUtils.isNotBlank(reporteSac.getGeneralNumeroReporte())) {
				List<ReporteMovilSacTalleres> lista = null;
				try {
					lista = GETMovilReporte.reporteMovilSacTalleresDao.listaDeReporteMovilSacTalleres(reporteSac.getGeneralNumeroReporte(), reporteSac.getAjusteAjustadorCodigo());
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("listaDeReporteMovilSacTalleres", ex);
				}
				if ((lista != null) && (lista.size() > 0)) {
					
					for (final ReporteMovilSacTalleres rmstaller : lista) {	
						this.reporte.getTalleres().add(
								new MovilReporteSiseTaller(
										rmstaller.getIdTalleres(), 
										rmstaller.getCodigo(),
										rmstaller.getNombre(), 
										rmstaller.getTipo(), 
										rmstaller.getTipoAfectado(), 
										rmstaller.getIndiceTercero(), 
										rmstaller.getVale(),
										rmstaller.getIdTalleres()));
					}
				}
			}
			
			// Insercion de Terceros
			if (StringUtils.isNotBlank(reporteSac.getGeneralNumeroReporte())) {
				List<ReporteMovilSacTerceros> lista = null;
				try {
					lista = GETMovilReporte.reporteMovilSacTercerosDao.listaDeReporteMovilSacTerceros(reporteSac.getGeneralNumeroReporte(), reporteSac.getAjusteAjustadorCodigo());
				} catch (final Exception ex) {
					JMEntidad.getLogger().error("listaDeReporteMovilSacTerceros", ex);
				}
				if ((lista != null) && (lista.size() > 0)) {
					Boolean containIDZero = false;
					
					for (final ReporteMovilSacTerceros rmst : lista) {	
						this.reporte.getTerceros().add(new MovilReporteSiseTercero(
								rmst.getIdTercero(),
								rmst.getVehiculoMarca(),
								rmst.getVehiculoTipo(),
								rmst.getVehiculoAnoModelo(),
								rmst.getVehiculoPlacas(),
								rmst.getVehiculoSerie(),
								rmst.getVehiculoColor(),
								rmst.getVehiculoConductor(),
								rmst.getTelefonoContacto(),
								null, null, null));
						
						try{
							if(rmst.getIdTercero().trim().replace("[{^0-9]", "").equals("0")){
								containIDZero = true;
							}
						}catch(Exception ex){
							JMEntidad.getLogger().error("ObtenerListaSacTerceros", ex);
						}
					}
					
					if(!containIDZero){
						this.reporte.getTerceros().add(new MovilReporteSiseTercero(
								"0",
								reporteSac.getVehiculoMarca(),
								reporteSac.getVehiculoTipo(),
								reporteSac.getVehiculoModelo(),
								reporteSac.getVehiculoPlacas(),
								reporteSac.getVehiculoSerie(),
								reporteSac.getVehiculoColor(),
								reporteSac.getConductorNombre(),
								reporteSac.getConductorTelefonoContacto(),
								null, null, null));
					}
				}
			}
			
			// Insercion de Gruas
			if (StringUtils.isNotBlank(reporteSac.getGeneralNumeroReporte())) {
				List<ReporteMovilSacGruas> lista = null;
				try {
					lista = GETMovilReporte.reporteMovilSacGruasDao.listaDeReporteMovilSacGruas(reporteSac.getGeneralNumeroReporte(), reporteSac.getAjusteAjustadorCodigo());
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
	
	/**
	 * Jose Miguel Jan 25, 2013 12:44:17 PM
	 * 
	 * @return the resultado
	 */
	public String getResultado() {
		return this.resultado;
	}

	/**
	 * Jose Miguel Jan 25, 2013 12:44:17 PM
	 * 
	 * @param resultado
	 *            the resultado to set
	 */
	public void setResultado(final String resultado) {
		this.resultado = resultado;
	}

	/**
	 *  Feb 25, 2013 10:56:46 AM
	 * 
	 * @return the reporte
	 */
	public MovilReporteSise getReporte() {
		return this.reporte;
	}

	/**
	 *  Feb 25, 2013 10:56:46 AM
	 * 
	 * @param reporte
	 *            the reporte to set
	 */
	public void setReporte(final MovilReporteSise reporte) {
		this.reporte = reporte;
	}

	public boolean isEsAjustadorVulnerable() {
		return esAjustadorVulnerable;
	}

	public void setEsAjustadorVulnerable(boolean esAjustadorVulnerable) {
		this.esAjustadorVulnerable = esAjustadorVulnerable;
	}

}
