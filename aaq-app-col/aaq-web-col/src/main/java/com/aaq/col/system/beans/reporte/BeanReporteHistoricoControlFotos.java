package com.aaq.col.system.beans.reporte;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.ControlFotografias;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.clases.util.UtileriaNumeros;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.ControlFotografiasDataModel;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

@ManagedBean(name="beanReporteHistoricoControlFotos")
@ViewScoped
public class BeanReporteHistoricoControlFotos extends JMBeanExtensiblePrincipal<ControlFotografias> {

	private static final long serialVersionUID = 6521227226689645179L;

	private String txtNumeroReporte;
	private String txtClaveDocumental;
	
	private BarChartModel barModel;
    private ChartSeries smsData;

	public BeanReporteHistoricoControlFotos() {
		super();
//		this.actualizarListado();
		this.actualizarGrafica();
	}

	 @PostConstruct  
	   public void init() {  
	   createBarModels();  
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
	 
	@Override
	public void actualizarListado() {
		if((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
					this.ponerMensajeAdvertencia("Los reportes estan limitados a 31 días naturales.");
					return;
				}
			try {
			if (getPermisoTodosEstados() && getPermisoTodosBases()){
					Estado edo = null;
					if (this.getIdEstado() != null && StringUtils.isNotBlank(this.getIdEstado()) && !this.getIdEstado().equals("9999")) {
						edo = getEstadoService().objetoEstado(this.getIdEstado());
					}
					Base base = null;
					if (this.getIdBase() != null && Integer.valueOf(this.getIdBase()) > 0) {
						 base = getBaseService().objetoBase(this.getIdBase());
					}
					
					ControlFotografiasDataModel data = new ControlFotografiasDataModel(this.getControlFotografiasService().listarControlFotografias(
						this.getTxtFechaInicio(),this.getTxtFechaFin(), this.getTxtClaveDocumental(),
						this.getTxtNumeroReporte(), edo, base));
					this.setListado(data);
			} else {
				Estado edo = null;
				if (this.getIdEstado() != null && StringUtils.isNotBlank(this.getIdEstado()) && !this.getIdEstado().equals("9999")) {
					edo = getEstadoService().objetoEstado(this.getIdEstado());
				}
				Base base = null;
				if (this.getIdBase() != null && Integer.valueOf(this.getIdBase()) > 0) {
					 base = getBaseService().objetoBase(this.getIdBase());
				}
				
				ControlFotografiasDataModel data = new ControlFotografiasDataModel(this.getControlFotografiasService().listarControlFotografias(
						this.getTxtFechaInicio(),this.getTxtFechaFin(), this.getTxtClaveDocumental(), 
						this.getTxtNumeroReporte(), edo, base));
				this.setListado(data);
			}
		} catch (ClassCastException | IllegalArgumentException |IndexOutOfBoundsException | 
				IllegalStateException | RollbackException e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "actualizarListado");
		} catch (DataAccessException | PersistenceException e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "actualizarListado");
		}	
		
	}
	
	@Override
	public String doAccionReporte() {
		return this.enviarArchivoACliente("reporte_control_fotografico.xls", this.obtenerReporte());
	}		
	
 public byte[] obtenerReporte() {
	if ((!this.getListadoConDatos())) {
	 return null;
	}
	final ByteArrayOutputStream paraFuera = new ByteArrayOutputStream();
	 try {
	  final WritableWorkbook workbook = Workbook.createWorkbook(paraFuera);
		workbook.setProtected(false);
		// fuentes
		final WritableFont fuenteTitulo = new WritableFont(WritableFont.ARIAL, 18, WritableFont.BOLD);
		final WritableFont fuenteEncabezado = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, false,
			UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
		final WritableFont fuenteDatos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);

		final WritableCellFormat estiloTitulo = new WritableCellFormat(fuenteTitulo);
		estiloTitulo.setBackground(Colour.WHITE);
		estiloTitulo.setAlignment(Alignment.CENTRE);
		estiloTitulo.setVerticalAlignment(VerticalAlignment.CENTRE);
		estiloTitulo.setLocked(true);

		final WritableCellFormat estiloEncabezadoDatosColumna = new WritableCellFormat(fuenteEncabezado);
		estiloEncabezadoDatosColumna.setBackground(Colour.GREEN);
		estiloEncabezadoDatosColumna.setAlignment(Alignment.CENTRE);
		estiloEncabezadoDatosColumna.setVerticalAlignment(VerticalAlignment.CENTRE);
		estiloEncabezadoDatosColumna.setLocked(true);

		final WritableCellFormat estiloEncabezadoRespuestaEncuesta = new WritableCellFormat(fuenteEncabezado);
		estiloEncabezadoRespuestaEncuesta.setBackground(Colour.CORAL);
		estiloEncabezadoRespuestaEncuesta.setAlignment(Alignment.CENTRE);
		estiloEncabezadoRespuestaEncuesta.setVerticalAlignment(VerticalAlignment.CENTRE);
		estiloEncabezadoRespuestaEncuesta.setLocked(true);
			
		final WritableCellFormat estiloEncabezadoValorRespuesta = new WritableCellFormat(fuenteEncabezado);
		estiloEncabezadoValorRespuesta.setBackground(Colour.GREY_25_PERCENT);
		estiloEncabezadoValorRespuesta.setAlignment(Alignment.CENTRE);
		estiloEncabezadoValorRespuesta.setVerticalAlignment(VerticalAlignment.CENTRE);
		estiloEncabezadoValorRespuesta.setLocked(true);


		final WritableCellFormat estiloDatos = new WritableCellFormat(fuenteDatos);
		estiloDatos.setBackground(Colour.WHITE);
		estiloDatos.setAlignment(Alignment.CENTRE);
		estiloDatos.setVerticalAlignment(VerticalAlignment.CENTRE);
		estiloDatos.setBorder(Border.ALL, BorderLineStyle.THIN);
		estiloDatos.setLocked(true);

		final WritableSheet hoja = workbook.createSheet("Reporte Control Fotográfico", 0);

		// Titulo
		hoja.setRowView(0, 40 * 20);
		hoja.setRowView(1, 35 * 20);
		hoja.setRowView(2, 35 * 20);
		final Label labelTitulo = new Label(1, 0, "CONTROL FOTOGRÁFICO"+ "  DEL "
			+ DateFormatUtils.format(this.getTxtFechaInicio(), "yyyy/MM/dd HH:mm:ss") + " al "
			+ DateFormatUtils.format(this.getTxtFechaFin(), "yyyy/MM/dd HH:mm:ss"), estiloTitulo);
		hoja.addCell(labelTitulo);
		hoja.getSettings().setVerticalFreeze(2);
		hoja.mergeCells(1, 0, 22, 0);

		int contadorColumna = 0;

		  contadorColumna = 0;
				//Nuevo
			hoja.addCell(new Label(contadorColumna++, 2, "Ticket",estiloEncabezadoDatosColumna ));
			hoja.addCell(new Label(contadorColumna++, 2, "Nombre Foto",estiloEncabezadoDatosColumna ));
			hoja.addCell(new Label(contadorColumna++, 2, "Numero Reporte",estiloEncabezadoDatosColumna ));
			hoja.addCell(new Label(contadorColumna++, 2, "Clave Documental",estiloEncabezadoDatosColumna ));
			hoja.addCell(new Label(contadorColumna++, 2, "Afectado",estiloEncabezadoDatosColumna ));
			hoja.addCell(new Label(contadorColumna++, 2, "Fecha",estiloEncabezadoDatosColumna ));
			hoja.addCell(new Label(contadorColumna++, 2, "Estado",estiloEncabezadoDatosColumna ));
			hoja.addCell(new Label(contadorColumna++, 2, "Base",estiloEncabezadoDatosColumna ));
			hoja.addCell(new Label(contadorColumna++, 2, "Detalle",estiloEncabezadoDatosColumna ));
			hoja.addCell(new Label(contadorColumna++, 2, "Enviado",estiloEncabezadoDatosColumna ));
				
		List<ControlFotografias> lista = null;
		 if (getPermisoTodosEstados() && getPermisoTodosBases()){
			Estado edo = null;
			if (this.getIdEstado() != null && StringUtils.isNotBlank(this.getIdEstado()) && !this.getIdEstado().equals("9999")) {
				edo = getEstadoService().objetoEstado(this.getIdEstado());
			}
			Base base = null;
			if (this.getIdBase() != null && Integer.valueOf(this.getIdBase()) > 0) {
				base = getBaseService().objetoBase(this.getIdBase());
			}
					
			lista = this.getControlFotografiasService().listarControlFotografias(this.getTxtFechaInicio(),
				this.getTxtFechaFin(), this.getTxtClaveDocumental(), this.getTxtNumeroReporte(),
				edo, base);
			} else {
			   Estado edo = null;
				if (this.getIdEstado() != null && StringUtils.isNotBlank(this.getIdEstado()) && !this.getIdEstado().equals("9999")) {
					edo = getEstadoService().objetoEstado(this.getIdEstado());
				}
				Base base = null;
				if (this.getIdBase() != null && Integer.valueOf(this.getIdBase()) > 0) {
					 base = getBaseService().objetoBase(this.getIdBase());
				}
					
			lista = this.getControlFotografiasService().listarControlFotografias(this.getTxtFechaInicio(),
					this.getTxtFechaFin(), this.getTxtClaveDocumental(), this.getTxtNumeroReporte(),
					edo, base);
			}
					
		int contadorFila = 3;
		 if ((lista != null) && (lista.size() > 0)) {
			for (final ControlFotografias reporte : lista) {
				contadorColumna = 0;
				hoja.addCell(new Label(contadorColumna++, contadorFila, Integer.toString(reporte.getId()), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getNombreFoto(), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getNumReporte(), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getClaveDocumental(), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getAfectado(), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, DateFormatUtils.format(reporte.getFecha(), "dd/MM/yyyy HH:mm:ss"), estiloDatos));
				if (reporte.getEstado() != null) {
					hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getEstado().getNombre(), estiloDatos));
				} else {
					hoja.addCell(new Label(contadorColumna++, contadorFila, "", estiloDatos));
				}
				if (reporte.getBase() != null) {
					hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getBase().getNombre(), estiloDatos));
				} else {
					hoja.addCell(new Label(contadorColumna++, contadorFila, "", estiloDatos));
				}
				hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getDetalle(), estiloDatos));
						
				if (reporte.getEnviado() != null) {
					if (reporte.getEnviado()) {
						hoja.addCell(new Label(contadorColumna++, contadorFila, Integer.toString(reporte.getId()), estiloDatos));
					} else {
						hoja.addCell(new Label(contadorColumna++, contadorFila, Integer.toString(reporte.getId()), estiloDatos));
						}
					} else {
						hoja.addCell(new Label(contadorColumna++, contadorFila, Integer.toString(reporte.getId()), estiloDatos));
					}
						contadorFila++;
					}
				}
				contadorFila++;
				contadorColumna = 0;
				
			workbook.write();
			workbook.close();
			return paraFuera.toByteArray();

		} catch (final IOException | RollbackException e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Notas Excel");
			this.ponerMensajeError("Error al crear Reporte Notas de Excel : " + e.getMessage());
		}  catch (final WriteException e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Notas Excel");
			this.ponerMensajeError("Error al crear Reporte Notas Excel : " + e.getMessage());
		}  catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Notas Excel");
			this.ponerMensajeError("Error al crear Reporte Notas de Excel : " + e.getMessage());
		}  catch (final ClassCastException  e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Notas Excel");
			this.ponerMensajeError("Error al crear Reporte NotasExcel : " + e.getMessage());

		}
		return null;
		
	}

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
			salida = this.getControlFotografiasService().listaParaGraficaFotos(this.getTxtFechaInicio(), this.getTxtFechaFin(), this.getIdEstado(), this.getIdBase(), this.getTxtNumeroReporte(), this.getTxtClaveDocumental()); 
			
			BarChartModel model = new BarChartModel();
	        smsData = new ChartSeries();
			if(salida != null && salida.size() >0) {
	          for (final EntidadObjeto objects : salida) {
		        	String str = String.valueOf(objects.getValor0().toString());
		       
			        smsData.set(objects.getValor0(), Integer.parseInt(objects.getValor1().toString()));
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
		    
			barModel.setTitle("Gráfica Fotografías Clave Documental");
			barModel.setMouseoverHighlight(false);
	        barModel.setShowDatatip(true);
	        barModel.setAnimate(true);
	        barModel.setBarMargin(5);
	        barModel.setZoom(false);
//	        barModel.setLegendPlacement(LegendPlacement.OUTSIDEGRID);
//	        barModel.setStacked(true);
//	        barModel.setLegendPosition("ne");
//	        barModel.setShowPointLabels(true);
	        
			Axis xAxis = barModel.getAxis(AxisType.X);
			xAxis.setLabel("Clave Documental");
			xAxis.setMin(0);
			xAxis.setMax(10);
			
			Axis yAxis = barModel.getAxis(AxisType.Y);
			yAxis.setLabel("Cantidad");
			yAxis.setMin(0);
			UtileriaNumeros utilNum = new UtileriaNumeros();
			yAxis.setMax(utilNum.obtenerMultiplo(numeroMayor));
			
			} else {
				ChartSeries sms  = new ChartSeries("Sin Datos");
				sms.set("No existen datos", 0);
		        barModel.addSeries(sms);

				barModel.setTitle("Gráfica Fotografías Clave Documental");
				barModel.setMouseoverHighlight(false);
				Axis xAxis = barModel.getAxis(AxisType.X);
				xAxis.setLabel("Clave Documental");

				Axis yAxis = barModel.getAxis(AxisType.Y);
				yAxis.setLabel("Cantidad");
				yAxis.setMin(0);
				yAxis.setMax(numeroMayor + 5);
			}
			
		} catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getGrafica");
			} catch (Exception e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getGrafica");
				} 
		}

 
	public String getTxtNumeroReporte() {
		return txtNumeroReporte;
	}



	public void setTxtNumeroReporte(String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}

	public String getTxtClaveDocumental() {
		return txtClaveDocumental;
	}

	public void setTxtClaveDocumental(String txtClaveDocumental) {
		this.txtClaveDocumental = txtClaveDocumental;
	}

	

	
}
