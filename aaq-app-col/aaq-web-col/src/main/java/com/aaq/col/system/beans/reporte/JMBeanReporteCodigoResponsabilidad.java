package com.aaq.col.system.beans.reporte;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.primefaces.model.chart.PieChartModel;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.CodigoResponsabilidadEstad;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.pojo.EntidadObjeto;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.CodigoResponsEstadDataModel;
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

@ManagedBean(name = "beanReporteCodigoResponsabilidad")
@ViewScoped
public class JMBeanReporteCodigoResponsabilidad extends JMBeanExtensiblePrincipal<CodigoResponsabilidadEstad> {

	private static final long serialVersionUID = -431579937630117184L;
	
//	Variables
	private String txtReporte;
    private PieChartModel pieModel;
    private CodigoResponsabilidadEstad objetoActua ;
//    private String duaConclusion = null;
    
    
    @PostConstruct  
    public void init() {  
    createPieModels();  
    }
    
	 public JMBeanReporteCodigoResponsabilidad() {
		 super();
			this.actualizarGrafica();
	 }

	
	@Override
	public void actualizarListado() {
		if((this.getTxtFechaInicio() != null)
			&& (this.getTxtFechaFin() != null)
			&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
				this.ponerMensajeAdvertencia("Los codigo de responsabilidad estan limitado a 31 días naturales.");
				return;
			}
		try {
		if (getPermisoTodosEstados() && getPermisoTodosBases()){
			if(!this.getIdEstado().equals("9999") ) {
				if(!getIdEstado().equals("null")) {
				Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
				Base base = getBaseService().objetoBase(this.getIdBase());
				CodigoResponsEstadDataModel data = new CodigoResponsEstadDataModel( this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(
						this.getTxtFechaInicio(), this.getTxtFechaFin(),edo.getNombre(), base.getNombre())
				);
				this.setListado(data);
				}
			}else {
				Base base = getBaseService().objetoBase(this.getIdBase());
				CodigoResponsEstadDataModel data = new CodigoResponsEstadDataModel( this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(
						this.getTxtFechaInicio(), this.getTxtFechaFin(),null, base.getNombre()));
				this.setListado(data);
			}
		
		} else {
			if (this.getIdEstado().equals("9999")){
				if (Integer.parseInt(this.getIdBase()) < 0)
				{
					Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
					CodigoResponsEstadDataModel data = new CodigoResponsEstadDataModel( this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(
							this.getTxtFechaInicio(), 
							this.getTxtFechaFin(),
							edo.getNombre(),
							null));
					this.setListado(data);
				} else {
					Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
					Base base = getBaseService().objetoBase(this.getIdBase());
					CodigoResponsEstadDataModel data = new CodigoResponsEstadDataModel( this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(
							this.getTxtFechaInicio(), 
							this.getTxtFechaFin(),
							edo.getNombre(),
							base.getNombre()));
					this.setListado(data);
				}
			} else {
				if (Integer.parseInt(this.getIdBase()) < 0)
				{
					CodigoResponsEstadDataModel data = new CodigoResponsEstadDataModel( this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(
							this.getTxtFechaInicio(), 
							this.getTxtFechaFin(),
							null,
							null));
					this.setListado(data);
				} else {	
					Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
					Base base = getBaseService().objetoBase(this.getIdBase());
					CodigoResponsEstadDataModel data = new CodigoResponsEstadDataModel( this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(
							this.getTxtFechaInicio(), 
							this.getTxtFechaFin(),
							edo.getNombre(),
							base.getNombre()));
					this.setListado(data);
				}
			}
		}
		
	} catch (Exception e) {
		this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "actualizarListado");
	}
	}

	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Reporte/reporteCodigoResponsabilidad.siica");

	}

	// **************************************************************//
		// Metodos para Grafica de Pastel
		// **************************************************************//


		public PieChartModel getPieModel() {  
			return pieModel;  
			}
		private void createPieModels() {  
			createPieModel();  
			} 
		private void createPieModel() {
			pieModel = new PieChartModel();
			List<EntidadObjeto> salida = null;
			try {
				if(!this.getIdEstado().equals("9999")) {
				// Estado trae valor
				Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
				Base base = getBaseService().objetoBase(this.getIdBase());
				 salida = getCodigoResponsabilidadEstad().listaDeCodigosParaGrafica(this.getTxtFechaInicio(), this.getTxtFechaFin(), edo.getNombre(), base.getNombre());
				} else {
					Base base = getBaseService().objetoBase(this.getIdBase());
					salida = getCodigoResponsabilidadEstad().listaDeCodigosParaGrafica(this.getTxtFechaInicio(), this.getTxtFechaFin(), null, base.getNombre());
				}
				if(salida != null && salida.size() >0) {
				for (EntidadObjeto objects : salida) {
					pieModel.set(objects.getValor0().toString(),  Integer.parseInt(objects.getValor1().toString()));
					}
				pieModel.setTitle("Códigos de Responsabilidad");  
				pieModel.setLegendPosition("c"); 
				pieModel.setShowDataLabels(true);
				pieModel.setSliceMargin(5);
				pieModel.setMouseoverHighlight(false);
				} else {
					pieModel.set("Sin Valores", 100);
					pieModel.setTitle("Sin códigos de responsabilidad");  
					pieModel.setLegendPosition("c"); 
					pieModel.setShowDataLabels(false);
					pieModel.setSliceMargin(5);
					pieModel.setMouseoverHighlight(false);
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
						this.ponerMensajeAdvertencia("Los codigo de responsabilidad estan limitado a 31 días naturales.");
						return;
					}
			try {
				this.actualizarListado();
				this.createPieModels();
			}catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getActualizarDatos");
			} catch (Exception e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getActualizarDatos");
			}
		}
		
		public void doAccionVerConclusionDUA(final ActionEvent e) {
//			objetoActua = new CodigoResponsabilidadEstad();
//			objetoActua = this.getCodigoResponsabilidadEstService().objetoCRE(this.obtenerParametroDeRequest("id"));
			if (StringUtils.isNotBlank(this.obtenerParametroDeRequest("id"))) {
			this.setObjetoActua(this.getCodigoResponsabilidadEstService().objetoCRE(this.obtenerParametroDeRequest("id")));
//				this.setObjetoABM(this.getCodigoResponsabilidadEstService().objetoCRE(this.obtenerParametroDeRequest("id")));
//				if (this.getObjetoABM() != null) {
//					this.setDuaConclusion(this.getObjetoABM().getConclusionDUA());
////				return;
//			} else {
//				this.setDuaConclusion(null);
////				return;
//			}
			
			}
	}
		
		public void doAccionRegistroCerrar(final ActionEvent e) {
			this.setObjetoABM(null);
//			this.setDuaConclusion(null);
		}
		
//		public CodigoResponsabilidadEstad getObjetoABM() {
//			return super.getObjetoABM();
//		}
//		
		/**
		 * @return la accion del reporte
		 */
		@Override
		public String doAccionReporte() {
			return this.enviarArchivoACliente("reportes_codigo_responsabilidad.xls", this.obtenerReporte());
		}		
		
		public byte[] obtenerReporte() {

			if ((!this.getListadoConDatos())) {
				return null;
			}

			final ByteArrayOutputStream paraFuera = new ByteArrayOutputStream();
			try {
				final WritableWorkbook workbook = Workbook.createWorkbook(paraFuera);
				workbook.setProtected(false);

				// primero los formatos

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

				final WritableSheet hoja = workbook.createSheet("Reporte Codigo de Responsabilidad", 0);

				// Titulo
				hoja.setRowView(0, 40 * 20);
				hoja.setRowView(1, 35 * 20);
				hoja.setRowView(2, 35 * 20);
				final Label labelTitulo = new Label(1, 0, "Reportes Codigo de Responsabilidad"+ "  del "
						+ DateFormatUtils.format(this.getTxtFechaInicio(), "yyyy/MM/dd HH:mm:ss") + " al "
						+ DateFormatUtils.format(this.getTxtFechaFin(), "yyyy/MM/dd HH:mm:ss"), estiloTitulo);
				hoja.addCell(labelTitulo);
				hoja.getSettings().setVerticalFreeze(2);
				hoja.mergeCells(1, 0, 22, 0);

				int contadorColumna = 0;

					contadorColumna = 0;
					//Nuevo
					hoja.addCell(new Label(contadorColumna++, 2, "Ticket",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Fecha",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Numero Reporte",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Poliza",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Inciso",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Fecha Ocurrido",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Codigo-Causa",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Estado",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Municipio",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Clave Ajustador",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Nombre Ajustador",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Codigo Responsabilidad",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Matriz",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Codigo Matriz",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Codigo de Responsabilidad DUA",estiloEncabezadoDatosColumna));
					hoja.addCell(new Label(contadorColumna++, 2, "Folio Orden EDUA",estiloEncabezadoDatosColumna));
					hoja.addCell(new Label(contadorColumna++, 2, "Conclusiones DUA",estiloEncabezadoDatosColumna));
					

					 List<CodigoResponsabilidadEstad> lista = null;
					if (getPermisoTodosEstados() && getPermisoTodosBases()){
						if(!this.getIdEstado().equals("9999") ) {
							if(!getIdEstado().equals("null")) {
							Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
							Base base = getBaseService().objetoBase(this.getIdBase());
							lista = this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(this.getTxtFechaInicio(), this.getTxtFechaFin(), edo.getNombre(), base.getNombre());
							}
						}else {
							Base base = getBaseService().objetoBase(this.getIdBase());
							lista = this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(this.getTxtFechaInicio(), this.getTxtFechaFin(),null, base.getNombre());
						}
					
					} else {
						if (this.getIdEstado().equals("9999")){
							if (Integer.parseInt(this.getIdBase()) < 0)
							{
								Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
								lista = this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(this.getTxtFechaInicio(), this.getTxtFechaFin(), edo.getNombre(),null);
							} else {
								Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
								Base base = getBaseService().objetoBase(this.getIdBase());
								lista = this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(this.getTxtFechaInicio(), this.getTxtFechaFin(), edo.getNombre(), base.getNombre());
							}
						} else {
							if (Integer.parseInt(this.getIdBase()) < 0)
							{
								lista = this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(this.getTxtFechaInicio(), this.getTxtFechaFin(),null,null);
							} else {	
								Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
								Base base = getBaseService().objetoBase(this.getIdBase());
								lista = this.getCodigoResponsabilidadEstad().listarCodigoResponsabilidadEstad(this.getTxtFechaInicio(), this.getTxtFechaFin(), edo.getNombre(), base.getNombre());
							}
						}
					}
						
					int contadorFila = 3;
					if ((lista != null) && (lista.size() > 0)) {
						for (final CodigoResponsabilidadEstad reporte : lista) {
							
							contadorColumna = 0;
							
							hoja.addCell(new Label(contadorColumna++, contadorFila, Integer.toString(reporte.getId()), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, DateFormatUtils.format(reporte.getFecha(), "dd/MM/yyyy HH:mm:ss"), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getNumeroReporte(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getNumeroPoliza(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getNumeroInciso(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getFechaOcurrido() , estiloDatos));	
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getCodigoCausa() , estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getEstado() , estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getMunicipio(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getClaveAjustador(), estiloDatos));					
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getNombreAjustador(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getCodigoResponsabilidad(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getMatriz().toString(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getCodigoMatriz(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getCodigoResponsabilidadDUA(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getFolioEDUA(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getConclusionDUA(), estiloDatos));
							//*** AQUI VA EL CODIGO DUA, FOLIO EDUA, Y CONLCUSION DUA
//							InfoeDUA infoDUA = new InfoeDUA();
//							try {
//								infoDUA = this.getHistoricoResumenAjustadorAmisService().obtenerFolios(reporte.getGeneralNumeroReporte());;
//							}catch (Exception e) {
//								this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getHistoricoResumenAjustadorAmisService().obtenerFolios");
//							}
//							hoja.addCell(new Label(contadorColumna++, contadorFila, infoDUA.getCodigoResponsabilidadDUA(), estiloDatos));
//							hoja.addCell(new Label(contadorColumna++, contadorFila, infoDUA.getFolioEDUA(), estiloDatos));
//							hoja.addCell(new Label(contadorColumna++, contadorFila, infoDUA.getConclusionDUA(), estiloDatos));
							
							contadorFila++;
						}
					}
					contadorFila++;
					contadorColumna = 0;
					
				workbook.write();
				workbook.close();
				return paraFuera.toByteArray();

			} catch (final IOException e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Codigo de Responsabilidad Excel");
				this.ponerMensajeError("Error al crear el reporte codigo de responsabilidad de Excel : " + e.getMessage());
			}  catch (final WriteException e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Codigo de Responsabilidad Excel");
				this.ponerMensajeError("Error al crear el reporte codigo de responsabilidad de Excel : " + e.getMessage());
			}  catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Codigo de Responsabilidad Excel");
				this.ponerMensajeError("Error al crear el reporte codigo de responsabilidad de Excel : " + e.getMessage());
			}  catch (final Exception e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Codigo de Responsabilidad Excel");
				this.ponerMensajeError("Error al crear el reporte codigo de responsabilidad de Excel : " + e.getMessage());

			}
			return null;
			
		}
		
		
	/* @return the txtReporte
	 */
	public String getTxtReporte() {
		return txtReporte;
	}


	/**
	 * @param txtReporte the txtReporte to set
	 */
	public void setTxtReporte(String txtReporte) {
		this.txtReporte = txtReporte;
	}

	public CodigoResponsabilidadEstad getObjetoActua() {
		return objetoActua;
	}

	public void setObjetoActua(CodigoResponsabilidadEstad objetoActua) {
		this.objetoActua = objetoActua;
	}

//	public String getDuaConclusion() {
//		return duaConclusion;
//	}
//
//	public void setDuaConclusion(String duaConclusion) {
//		this.duaConclusion = duaConclusion;
//	}
	
	


	
}
