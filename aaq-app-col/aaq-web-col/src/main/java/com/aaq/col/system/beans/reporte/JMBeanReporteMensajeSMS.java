package com.aaq.col.system.beans.reporte;

import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.MensajeSms;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.MensajeSmsDataModel;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;

@ManagedBean(name = "beanReporteMensajeSMS")
@ViewScoped
public class JMBeanReporteMensajeSMS extends JMBeanExtensiblePrincipal<MensajeSms> {
	private static final long serialVersionUID = -255790133647100879L;

	private String txtNumeroReporte;
	private String txtAsegurado;
	private String txtPoliza;
	private String txtGerente;
	private String txtOficina;
	private String txtAgente;
	private BarChartModel barModel;
    private ChartSeries smsData;

	// **************************************************************//
	// Constructor
	// **************************************************************//

	 @PostConstruct  
	   public void init() {  
	   createBarModels();  
	   }
	
	public JMBeanReporteMensajeSMS() {
		super();
	//	this.actualizarListado();
		this.actualizarGrafica();
	}


	// **************************************************************//
	// Listado
	// **************************************************************//

	/**
	 * Lista de resultado del reporte SMS
	 */
	@Override
	public void actualizarListado() {
		if ((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
			this.ponerMensajeAdvertencia("Los reportes estan limitados a 31 dias naturales de datos. Para obtener reportes de meses multiples, es necesario crear el reporte uno por uno del mes que se solicita.");
			return;
		}

		try {
			this.setListado(new MensajeSmsDataModel(this.getMensajeSmsService().listaDeMensajeSms(
					this.getTxtFechaInicio(), this.getTxtFechaFin(), this.getTxtNumeroReporte(), this.getTxtOficina(),
					this.getTxtPoliza(), this.getTxtAgente(), this.getTxtAsegurado(), this.getTxtGerente(),
					this.getTerminalService().objetoTerminal(this.getIdTerminal()), new Integer(25000))));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}
    @Override
    public void doAccionRegistroNuevo (final ActionEvent arg0) {
        // nada
    }


    // **************************************************************//
	// Grafica
	// **************************************************************//

	public BarChartModel getBarModel() {  
		return barModel;  
		}
	
	private void createBarModels() {  
		createBarModel();  
		} 
	
	private void createBarModel() {
		barModel = new BarChartModel();
		List<EntidadObjeto> salida = null;
		int numeroMayor = 0;

		try {
			// Estado trae valor
			salida = this.getMensajeSmsService().listaDeMensajeSmsParaGrafica(this.getTxtFechaInicio(),
					this.getTxtFechaFin(), this.getTxtNumeroReporte(), this.getTxtOficina(),
					this.getTxtPoliza(), this.getTxtAgente(), this.getTxtAsegurado(), this.getTxtGerente(),
					this.getIdTerminal());
			
			BarChartModel model = new BarChartModel();
			 
	        smsData = new ChartSeries();
			
			if(salida != null && salida.size() >0) {
	          for (final EntidadObjeto objects : salida) {
		        	String str = null;
			        str = this.getFecha(objects.getValor0());
			        smsData.set(str, Integer.parseInt(objects.getValor1().toString()));
			        if (Integer.parseInt(objects.getValor1().toString()) > numeroMayor) {
						numeroMayor = Integer.parseInt(objects.getValor1().toString());
					}
			        smsData.setLabel(str);
			}
	          //Añadir valores para espacios
	          if (salida.size() < 3) {
			        smsData.set("", 0);
			        smsData.set(" ", 0);
			}
	          
		     model.addSeries(smsData);
		     model.setSeriesColors("008C99, 9F85B8, 939BA1, 2980B9, 1ABC9C,"
				  					+ "D68ECC, 5D6D7E, 7FB3D5, 2CA8B5, EACCE8,"
				 		 			+ "7C7782, D6EAF8, 78CAD1, 91278F, E2E2E2,"
				 		 			+ "21618C, B1EDF2, 884EA0, CACACC, 3498DB,"
				 		 			+ "B3E5E5, D6C5E8, 566573, 5499C7, 7DCEA0,"
				 		 			+ "C39BD3, 797D7F, 1B4F72, 229954, BB8FCE,"
				 		 			+ "B2BABB");
		     model.setExtender("chartExtender");
		     model.setAnimate(true);
		     barModel = model;
		    
			barModel.setTitle("Grafica SMS");
			barModel.setMouseoverHighlight(false);
	        barModel.setShowDatatip(true);
	        barModel.setAnimate(true);
	        barModel.setBarMargin(5);
	        barModel.setZoom(false);


			Axis xAxis = barModel.getAxis(AxisType.X);
			xAxis.setLabel("FECHA");
			xAxis.setMin(0);
			xAxis.setMax(10);

			Axis yAxis = barModel.getAxis(AxisType.Y);
			yAxis.setLabel("CANTIDAD");
			yAxis.setMin(0);
			yAxis.setMax(numeroMayor + 5);
			
			} else {
				ChartSeries sms  = new ChartSeries("Sin Datos");
				sms.set("No existen datos", 0);
		        barModel.addSeries(sms);

				barModel.setTitle("Grafica SMS");
				barModel.setMouseoverHighlight(false);
				Axis xAxis = barModel.getAxis(AxisType.X);
				xAxis.setLabel("FECHA");

				Axis yAxis = barModel.getAxis(AxisType.Y);
				yAxis.setLabel("CANTIDAD");
				yAxis.setMin(0);
				yAxis.setMax(numeroMayor + 5);
			}
			
		} catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getGrafica");
			} catch (Exception e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getGrafica");
				} 
		}
	


	public void actualizarGrafica() {
		if((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
					this.ponerMensajeAdvertencia("Los fechas estan limitado a 31 días naturales.");
					return;
				}
		try {
			this.actualizarListado();
			this.createBarModels();
		}catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getActualizarDatos");
		} catch (Exception e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getActualizarDatos");
		}
	}
	
	public String getFecha(Object obj) {
			String str = null;
			str = Objects.toString(obj, "");
	        str = StringUtils.replace(str, " 00:00:00.0", "");
	        str = StringUtils.replace(str, " 00:00:00", "");
	        str = JMUtileriaString.quitarNoJavascript(str);
	        return str;
	}
		
		

	// **************************************************************//
	// Getter y Setter
	// **************************************************************//

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @return the txtNumeroReporte
	 */
	public String getTxtNumeroReporte() {
		return this.txtNumeroReporte;
	}

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @param txtNumeroReporte
	 *            the txtNumeroReporte to set
	 */
	public void setTxtNumeroReporte(final String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @return the txtAsegurado
	 */
	public String getTxtAsegurado() {
		return this.txtAsegurado;
	}

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @param txtAsegurado
	 *            the txtAsegurado to set
	 */
	public void setTxtAsegurado(final String txtAsegurado) {
		this.txtAsegurado = txtAsegurado;
	}

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @return the txtPoliza
	 */
	public String getTxtPoliza() {
		return this.txtPoliza;
	}

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @param txtPoliza
	 *            the txtPoliza to set
	 */
	public void setTxtPoliza(final String txtPoliza) {
		this.txtPoliza = txtPoliza;
	}

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @return the txtGerente
	 */
	public String getTxtGerente() {
		return this.txtGerente;
	}

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @param txtGerente
	 *            the txtGerente to set
	 */
	public void setTxtGerente(final String txtGerente) {
		this.txtGerente = txtGerente;
	}

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @return the txtOficina
	 */
	public String getTxtOficina() {
		return this.txtOficina;
	}

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @param txtOficina
	 *            the txtOficina to set
	 */
	public void setTxtOficina(final String txtOficina) {
		this.txtOficina = txtOficina;
	}

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @return the txtAgente
	 */
	public String getTxtAgente() {
		return this.txtAgente;
	}

	/**
	 * Feb 26, 2011 7:39:26 PM
	 * 
	 * @param txtAgente
	 *            the txtAgente to set
	 */
	public void setTxtAgente(final String txtAgente) {
		this.txtAgente = txtAgente;
	}

}
