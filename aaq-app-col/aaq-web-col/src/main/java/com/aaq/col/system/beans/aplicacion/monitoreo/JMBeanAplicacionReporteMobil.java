package com.aaq.col.system.beans.aplicacion.monitoreo;

import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;
import com.thoughtworks.xstream.XStream;

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

import java.io.*;
import com.jmfg.jmlib.sistema.classes.jmlibreria.*;
import org.springframework.core.annotation.AnnotationUtils;

import com.itextpdf.text.pdf.*;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.time.*;

import java.beans.*;
import java.lang.reflect.*;

import com.aaq.col.clases.database.entidades.ReporteMovil;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.pojo.aaq.ReportesM;
import com.aaq.col.system.beans.extensibles.JMBeanExtensibleMapa;
import com.aaq.col.system.database.entidades.modelo.ReporteMovilDataModel;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;

import java.util.*;



@ManagedBean(name = "beanAplicacionReporteMobil")
@ViewScoped
public class JMBeanAplicacionReporteMobil extends JMBeanExtensibleMapa<ReporteMovil> {

	private static final long serialVersionUID = -2345031445875846824L;

   	private String dataJson = null;
   	
	public JMBeanAplicacionReporteMobil() {
		super();
		this.setMostrarGeocercas(Boolean.TRUE);
		this.setMostrarObjetosActualizables(Boolean.TRUE);
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {
		if ((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
			this.ponerMensajeAdvertencia("Los reportes estan limitados a 31 dias naturales de datos. Para obtener reportes de meses multiples, es necesario crear el reporte uno por uno del mes que se solicita.");
			return;
		}
		this.crearReporte();
	}
	
	public void crearReporte() {
		if ((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
			this.ponerMensajeAdvertencia("Los reportes estan limitados a 31 dias naturales de datos. Para obtener reportes de meses multiples, es necesario crear el reporte uno por uno del mes que se solicita.");
			return;
		}
		try {
			this.setListado(new ReporteMovilDataModel(this.getReporteMovilService().listaDeReporteMovil(this.getTxtFechaInicio(), this.getTxtFechaFin(),
					true)));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}

	@Override
	public String getMarcadoresActualizacionManual() {
		final StringBuilder marcadores = new StringBuilder("{markers}");
		if (this.getObjetoABM() != null) {
			this.acercarMapa(this.getObjetoABM().getLatitud(), this.getObjetoABM().getLongitud());
			marcadores.append("{marker id=\"" + this.getObjetoABM().getId() + "\"  lat=\""
					+ this.getObjetoABM().getLongitud() + "\" lng=\"" + this.getObjetoABM().getLatitud() + "\" html=\""
					+ JMUtileriaString.quitarNoXML(this.getObjetoABM().getDescripcionHTML()) + "\"  labelContent=\""
					+ this.getObjetoABM().getPoliza() + "\" label=\"punto_arrastrable\" /}");
		}

		marcadores.append("{/markers}");
		return Objects.toString(marcadores, "");

	}
	
	@Override
	public String getMarcadoresActualizacionManualUnico() {
		final StringBuilder marcadores = new StringBuilder("{markers}");
		if (this.getObjetoABM() != null) {
			this.acercarMapa(this.getObjetoABM().getLatitud(), this.getObjetoABM().getLongitud());
			marcadores.append("{marker id=\"" + this.getObjetoABM().getId() + "\"  lat=\""
					+ this.getObjetoABM().getLongitud() + "\" lng=\"" + this.getObjetoABM().getLatitud() + "\" html=\""
					+ JMUtileriaString.quitarNoXML(this.getObjetoABM().getDescripcionHTML()) + "\"  labelContent=\""
					+ this.getObjetoABM().getPoliza() + "\" label=\"punto_arrastrable\" /}");
		}

		marcadores.append("{/markers}");
		return Objects.toString(marcadores, "");

	}
	
	

	
	@Override
	public String getMarcadoresActualizacionAutomaticaUnico() {
		final StringBuilder marcadores = new StringBuilder("{markers}");

		if ((this.getObjetoABM() != null) && StringUtils.isNotBlank(this.getObjetoABM().getLatitud())
				&& StringUtils.isNotBlank(this.getObjetoABM().getLongitud())) {
			for (final Terminal term : this.getListaAutomaticaDeTerminal(this.getObjetoABM().getLatitud(), this
					.getObjetoABM().getLongitud())) {
				marcadores.append("{marker id=\"term_" + term.getId() + "\"  lat=\"" + term.getLongitud() + "\" lng=\""
						+ term.getLatitud() + "\" html=\"" + JMUtileriaString.quitarNoXML(term.getHTML())
						+ "\"  label=\"" + term.getIconoUbicacion() + "\" /}");
				
				this.acercarMapa2(this.getObjetoABM().getLatitud(), this.getObjetoABM().getLongitud());
			}

		}
		marcadores.append("{/markers}");
		return Objects.toString(marcadores, "");

	}

	public String getImagenSatelital() {
		return super.getImagenSatelital(null, null);
	}

	
	public boolean getTieneReportesNuevos() {
		if ((this.getListado() != null) && (this.getListado().getDataSource() != null)) {
			for (final ReporteMovil rep : this.getListado().getDataSource()) {
				if (rep.getFechaVisto() == null) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void doAccionRegistroEditar(final ActionEvent e) {
		super.doAccionRegistroEditar(e);
		if (this.getObjetoABM() != null) {
			this.getObjetoABM().setFechaVisto(new Date());
			this.getObjetoABM().guardarObjeto();
			try {
			this.alejarMapa(Objects.toString(this.getObjetoABM().getLatitud(), ""), Objects.toString(this.getObjetoABM().getLongitud(), ""));
			} catch (Exception ex) {
			}
			this.actualizarListado();
		}
	}

	@Override
	public ReporteMovil getObjetoABM() {
		return super.getObjetoABM();
	}
	
	// Crear metodo para descargar pdf, excel y xml
	 public String doAccionReporte() {
				return this.doReporte(this.obtenerParametroDeRequest("id"), "reporte", this.obtenerParametroDeRequest("descripcion"));
	    }
	 
	 public String doReporte( final String id, final String nombre, final String descripcion) {
		 List<ReporteMovil> lista = null;
		 try {
			 lista = this.getReporteMovilService().listaDeReporteMovil(this.getTxtFechaInicio(), this.getTxtFechaFin(), true);
		 } catch (Exception e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "doReporte");
		}
		 if (lista != null && lista.size() > 0) {
	        if (StringUtils.equals((CharSequence)id, (CharSequence)"xml")) {
	            return this.reporteXML(lista, nombre);
	        }
	        if (StringUtils.equals((CharSequence)id, (CharSequence)"excel")) {
	            return this.reporteExcel(lista, nombre);
	        }
	        if (StringUtils.equals((CharSequence)id, (CharSequence)"pdf")) {
	            return this.reportePDF(lista, nombre);
	        }
		 } else {
			this.ponerMensajeAdvertencia("No hay datos para descargar");
	       }
	        return null;
	    }
	    
	  public String reporteXML(List<ReporteMovil> lista,  String nombre) {
	        final String attachment = this.obtenerString(lista);
	        if (StringUtils.isNotBlank((CharSequence)attachment)) {
	            this.enviarArchivoACliente("attachment; filename=" + nombre + ".xml", attachment.getBytes());
	        }
	        return null;
	    }
	  
	    public String obtenerString(List<ReporteMovil> lista) {
	        return this.obtenerString(lista, true);
	    }
	    
	    public String obtenerString(List<ReporteMovil> lista, final boolean conheader) {
	    ReportesM rep = new ReportesM();
	    XStream xstream = new XStream();
		    rep.setReporte(lista);
		    xstream.alias("reporteMovil", ReportesM.class);
		    dataJson = xstream.toXML(rep);
        return dataJson;
	    }
	    
	    
	    public String reportePDF(List<ReporteMovil> lista, String nombre) {
	        final byte[] attachment = this.obtenerReportePDF(lista);
	        if (attachment != null) {
	            this.enviarArchivoACliente("attachment; filename=" + nombre + ".pdf", attachment);
	        }
	        return null;
	    }
	    
	    public String reporteExcel( List<ReporteMovil> lista,  String nombre) {
	         return  this.enviarArchivoACliente(nombre + ".xls", obtenerReporteExcel(lista));
	    }
	    
	    
	    @SuppressWarnings({ "unchecked", "rawtypes" })
		public byte[] obtenerReportePDF(final List<ReporteMovil> lista) {
	        if (lista != null && lista.size() > 0) {
	            try {
	                final Document document = new Document(PageSize.LETTER.rotate());
	                document.addAuthor("Integracion de Sistemas de Avanzada Tecnologia SA de CV");
	                document.addTitle("Reporte generado desde los sistemas de Integracion de Sistemas de Avanzada Tecnologia SA de CV");
	                document.addSubject("Reporte generado desde los sistemas de Integracion de Sistemas de Avanzada Tecnologia SA de CV");
	                document.addKeywords("Reporte en PDF, Integracion de Sistemas de Avanzada Tecnologia SA de CV");
	                document.addCreationDate();
	                document.addCreator("Sistema Integracion de Sistemas de Avanzada Tecnologia SA de CV");
	                document.setMargins(0.0f, 0.0f, 0.0f, 0.0f);
	                final ByteArrayOutputStream baos = new ByteArrayOutputStream();
	                PdfWriter.getInstance(document, (OutputStream)baos);
	                document.open();
	                document.newPage();
	                int numerodecolumnas = 0;
	                final Object objeto = lista.get(0);
	                final Object[] invoker = new Object[0];
	                if (objeto instanceof Object[]) {
	                    numerodecolumnas = ((Object[])objeto).length;
	                }
	                else {
	                    for (final PropertyDescriptor f : Introspector.getBeanInfo(objeto.getClass()).getPropertyDescriptors()) {
	                        if (JMUtileriaString.validarNombreDeCampo(f.getName()) && AnnotationUtils.findAnnotation(f.getReadMethod(), (Class)JMReporteOmitirMetodo.class) == null) {
	                            ++numerodecolumnas;
	                        }
	                    }
	                }
	                final Font fonttitulo = FontFactory.getFont("Helvetica", 10.0f, 1, new BaseColor(255, 255, 255));
	                final Font fontencabezado = FontFactory.getFont("Helvetica", 7.0f, 1, new BaseColor(0, 0, 0));
	                final Font font7 = FontFactory.getFont("Helvetica", 6.0f);
	                final PdfPTable table = new PdfPTable(numerodecolumnas);
	                table.setWidthPercentage(100.0f);
	                final Phrase p = new Phrase("Reporte Generado: " + JMUtileriaFecha.obtenerFechaActual(true), fonttitulo);
	                final PdfPCell cell = new PdfPCell(p);
	                cell.setBackgroundColor(new BaseColor(80, 80, 80));
	                cell.setColspan(numerodecolumnas);
	                table.addCell(cell);
	                table.getDefaultCell().setBackgroundColor(new BaseColor(219, 219, 219));
	                final Vector<PropertyDescriptor> lpd = new Vector<PropertyDescriptor>();
	                for (final PropertyDescriptor f2 : Introspector.getBeanInfo(objeto.getClass()).getPropertyDescriptors()) {
	                    if (JMUtileriaString.validarNombreDeCampo(f2.getName()) && AnnotationUtils.findAnnotation(f2.getReadMethod(), (Class)JMReporteOmitirMetodo.class) == null) {
	                        lpd.add(f2);
	                    }
	                }
	                for (final PropertyDescriptor f3 : lpd) {
	                    final Phrase phrase = new Phrase(Objects.toString(JMUtileriaString.obtenerNombreCorrectoDeCampo(f3.getName()), ""), fontencabezado);
	                    table.addCell(phrase);
	                }
	                int i = 0;
	                for (final Object fila : lista) {
	                    if (++i % 2 == 0) {
	                        table.getDefaultCell().setBackgroundColor(new BaseColor(246, 246, 246));
	                    }
	                    else {
	                        table.getDefaultCell().setBackgroundColor(new BaseColor(220, 231, 241));
	                    }
	                    if (fila instanceof Object[]) {
	                        for (final Object object2 : (Object[])fila) {
	                            table.addCell(new Phrase(Objects.toString(object2, ""), font7));
	                        }
	                    }
	                    else {
	                        for (final PropertyDescriptor f4 : lpd) {
	                            final Object objval = f4.getReadMethod().invoke(fila, invoker);
	                            String valor = Objects.toString(objval, "");
	                            if (objval != null) {
	                                if (objval instanceof Boolean) {
	                                    valor = BooleanUtils.toString((boolean)objval, "Si", "No");
	                                }
	                                if (objval instanceof Date) {
	                                    valor = DateFormatUtils.format((Date)objval, "yyyy/MM/dd HH:mm:ss");
	                                }
	                            }
	                            table.addCell(new Phrase(Objects.toString(valor, ""), font7));
	                        }
	                    }
	                }
	                document.add((com.itextpdf.text.Element)table);
	                document.close();
	                return baos.toByteArray();
	            }
	            catch (DocumentException e) {
					this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "obtenerReportePDF");
	            }
	            catch (IntrospectionException | IllegalAccessException | InvocationTargetException ex2) {
					this.getUtileriaExcepcion().manejarExcepcion(ex2, this.getClass(), "obtenerReportePDF");
	            }
	        }
	        return null;
	    }
	    
	    
	    public byte[] obtenerReporteExcel(final List<ReporteMovil> lista) {
	    	
	        if (lista == null || lista.size() == 0) {
	            return null;
	        }
	        final ByteArrayOutputStream out = new ByteArrayOutputStream();
	        
	        try {
	        	final WritableWorkbook workbook = Workbook.createWorkbook(out);
	        	workbook.setProtected(false);
	        	
	        	//Fuentes
	        	final WritableFont fuenteTitulo	= new WritableFont(WritableFont.ARIAL, 18, WritableFont.BOLD);
	        	final WritableFont fuenteEncabezado = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD, false,
						UnderlineStyle.NO_UNDERLINE, Colour.WHITE);
				final WritableFont fuenteDatos = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD);

				final WritableCellFormat estiloTitulo = new WritableCellFormat(fuenteTitulo);
				estiloTitulo.setBackground(Colour.WHITE);
				estiloTitulo.setAlignment(Alignment.CENTRE);
				estiloTitulo.setVerticalAlignment(VerticalAlignment.CENTRE);
				estiloTitulo.setLocked(true);

				final WritableCellFormat estiloEncabezadoDatosColumna = new WritableCellFormat(fuenteEncabezado);
				estiloEncabezadoDatosColumna.setBackground(Colour.VIOLET);
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

				final WritableSheet hoja = workbook.createSheet("Reporte de Reportes Móviles", 0);

				// Titulo
				hoja.setRowView(0, 40 * 20);
				hoja.setRowView(1, 35 * 20);
				hoja.setRowView(2, 35 * 20);
				final Label labelTitulo = new Label(1, 0, "Reporte de Reportes Móviles", estiloTitulo);
				hoja.addCell(labelTitulo);
				hoja.getSettings().setVerticalFreeze(2);
				hoja.mergeCells(1, 0, 22, 0);

				int contadorColumna = 0;

					contadorColumna = 0;
					//Nuevo
					hoja.addCell(new Label(contadorColumna++, 2, "Ticket",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Agente",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Causa",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Descripcion",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Endoso",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Fecha",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Fecha Visto",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Fuente",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Inciso",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Latitud",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Longitud",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Nombre Conductor",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Nombre reporta",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Poliza",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Sise reporte",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Sise siniestro",estiloEncabezadoDatosColumna ));
					hoja.addCell(new Label(contadorColumna++, 2, "Telefono contacto",estiloEncabezadoDatosColumna ));

					int contadorFila = 3;
					if (lista != null && lista.size() > 0) {
						for (final ReporteMovil reporte : lista) {
							contadorColumna = 0 ;
							
							hoja.addCell(new Label(contadorColumna++, contadorFila,Integer.toString(reporte.getId()), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getAgente(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getCausa(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getDescripcion(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getEndoso(), estiloDatos));
							if (reporte.getFecha()  != null   ) {
								hoja.addCell(new Label(contadorColumna++, contadorFila, DateFormatUtils.format(reporte.getFecha(), "dd/MM/yyyy HH:mm:ss"), estiloDatos));
							} else {
								hoja.addCell(new Label(contadorColumna++, contadorFila, null , estiloDatos));
							}
							if (reporte.getFechaVisto() != null) {
								hoja.addCell(new Label(contadorColumna++, contadorFila, DateFormatUtils.format(reporte.getFechaVisto(), "dd/MM/yyyy HH:mm:ss"), estiloDatos));
							} else  {
								hoja.addCell(new Label(contadorColumna++, contadorFila, null, estiloDatos));
							}
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getFuente(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getInciso(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getLongitud(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getLatitud(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getNombreConductor(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getNombreReporta(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getPoliza(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getSiseReporte(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getSiseSiniestro(), estiloDatos));
							hoja.addCell(new Label(contadorColumna++, contadorFila,reporte.getTelefonoContacto(), estiloDatos));

							contadorFila++;

						}
					}
					
					contadorFila++;
					contadorColumna = 0;
					
				workbook.write();
				workbook.close();
				return out.toByteArray();

			} catch (final Exception e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear reporte movil  Excel");
				this.ponerMensajeError("Error al crear el reporte  movil  Excel : " + e);

			}
			return null;
	        	
	        }

}
