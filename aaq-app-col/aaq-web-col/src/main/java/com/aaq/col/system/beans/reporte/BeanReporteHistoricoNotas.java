package com.aaq.col.system.beans.reporte;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.NotasReporte;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.NotasReporteDataModel;
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

@ManagedBean(name = "beanReporteHistoricoNotas")
@ViewScoped
public class BeanReporteHistoricoNotas extends JMBeanExtensiblePrincipal<NotasReporte> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2047748671374978145L;

	// Variables
	private String txtNumeroReporte;
	
	
	
	public BeanReporteHistoricoNotas() {
		super();
		this.actualizarListado();
	}



	@Override
	public void actualizarListado() {
		
		if((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
					this.ponerMensajeAdvertencia("Las notas de reportes estan limitados a 31 días naturales.");
					return;
				}
			try {
			if (getPermisoTodosEstados() && getPermisoTodosBases()){
				if(!this.getIdEstado().equals("9999") ) {
					if(!getIdEstado().equals("null")) {
					Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
					
					
					if (Integer.valueOf(this.getIdBase()) > 0) {
						Base base = getBaseService().objetoBase(this.getIdBase());
						NotasReporteDataModel data = new NotasReporteDataModel(this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), 
								this.getTxtNumeroReporte(), null, edo, base));
						this.setListado(data);
					} else {
						NotasReporteDataModel data = new NotasReporteDataModel(this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), 
								this.getTxtNumeroReporte(), null, edo, null));
						this.setListado(data);
					}
					
					
					}
				}else {
					Base base = getBaseService().objetoBase(this.getIdBase());
					NotasReporteDataModel data = new NotasReporteDataModel(this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), 
							this.getTxtNumeroReporte(), null, null, base));
					this.setListado(data);
				}
			
			} else {
				if (this.getIdEstado().equals("9999")){
					if (Integer.parseInt(this.getIdBase()) < 0)
					{
						Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
						NotasReporteDataModel data = new NotasReporteDataModel(this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), 
								this.getTxtNumeroReporte(), null, edo, null));
						this.setListado(data);
					} else {
						Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
						Base base = getBaseService().objetoBase(this.getIdBase());
						NotasReporteDataModel data = new NotasReporteDataModel(this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), 
								this.getTxtNumeroReporte(), null, edo, base));
						this.setListado(data);
					}
				} else {
					if (Integer.parseInt(this.getIdBase()) < 0)
					{
						NotasReporteDataModel data = new NotasReporteDataModel(this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), 
								this.getTxtNumeroReporte(), null, null, null));
						this.setListado(data);
					} else {	
						Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
						Base base = getBaseService().objetoBase(this.getIdBase());
						NotasReporteDataModel data = new NotasReporteDataModel(this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), 
								this.getTxtNumeroReporte(), null, edo, base));
						this.setListado(data);
					}
				}
			}
		} catch (Exception e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "actualizarListado");
		}		
	}

	@Override
	public String doAccionReporte() {
		return this.enviarArchivoACliente("reporte_notas.xls", this.obtenerReporte());
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

			final WritableSheet hoja = workbook.createSheet("Reporte Notas", 0);

			// Titulo
			hoja.setRowView(0, 40 * 20);
			hoja.setRowView(1, 35 * 20);
			hoja.setRowView(2, 35 * 20);
			final Label labelTitulo = new Label(1, 0, "NOTAS DE REPORTES"+ "  DEL "
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
				hoja.addCell(new Label(contadorColumna++, 2, "Clave Ajustador",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Nombre Ajustador",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Estado",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Base",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Causa Nota",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Nota",estiloEncabezadoDatosColumna ));
				hoja.addCell(new Label(contadorColumna++, 2, "Usuario",estiloEncabezadoDatosColumna ));
				

				 List<NotasReporte> lista = null;
				if (getPermisoTodosEstados() && getPermisoTodosBases()){
					if( !this.getIdEstado().equals("9999") ) {
						if(!getIdEstado().equals("null")) {
						Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
						if (this.getIdBase() != null) {
							if (Integer.parseInt(this.getIdBase()) < 0) {
								lista = this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), this.getTxtNumeroReporte(), null, edo, null);
							} else {
								Base base = getBaseService().objetoBase(this.getIdBase());
								lista = this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), this.getTxtNumeroReporte(), null, edo, base);
							}
						} else {
						lista = this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), this.getTxtNumeroReporte(), null, edo, null);
						}
						}
					} else {
						Base base = getBaseService().objetoBase(this.getIdBase());
						lista = this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), this.getTxtNumeroReporte(), null, null, base);
					}
				
				} else {
					if (this.getIdEstado().equals("9999")){
						if (Integer.parseInt(this.getIdBase()) < 0)
						{
							Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
							lista = this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), this.getTxtNumeroReporte(), null, edo, null);
						} else {
							Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
							Base base = getBaseService().objetoBase(this.getIdBase());
							lista = this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), this.getTxtNumeroReporte(), null, edo, base);
						}
					} else {
						if (Integer.parseInt(this.getIdBase()) < 0)
						{
							lista = this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), this.getTxtNumeroReporte(), null, null, null);
						} else {	
							Estado edo = getEstadoService().objetoEstado(this.getIdEstado());
							Base base = getBaseService().objetoBase(this.getIdBase());
							lista = this.getNotasReporteService().listaDeNotasReporte(this.getTxtFechaInicio(),  this.getTxtFechaFin(), this.getTxtNumeroReporte(), null, edo, base);
						}
					}
				}
					
				int contadorFila = 3;
				if ((lista != null) && (lista.size() > 0)) {
					for (final NotasReporte reporte : lista) {
						
						contadorColumna = 0;
						
						hoja.addCell(new Label(contadorColumna++, contadorFila, Integer.toString(reporte.getId()), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, DateFormatUtils.format(reporte.getFecha(), "dd/MM/yyyy HH:mm:ss"), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getReporte(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getTerminal().getNumeroproveedor(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getTerminal().getNombre(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getEstado().getNombre(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getBase().getNombre(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getCausaNota(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getNotas(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getUsuario(), estiloDatos));
						
						contadorFila++;
					}
				}
				contadorFila++;
				contadorColumna = 0;
				
			workbook.write();
			workbook.close();
			return paraFuera.toByteArray();

		} catch (final IOException e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Notas Excel");
			this.ponerMensajeError("Error al crear Reporte Notas de Excel : " + e.getMessage());
		}  catch (final WriteException e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Notas Excel");
			this.ponerMensajeError("Error al crear Reporte Notas Excel : " + e.getMessage());
		}  catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Notas Excel");
			this.ponerMensajeError("Error al crear Reporte Notas de Excel : " + e.getMessage());
		}  catch (final Exception e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Notas Excel");
			this.ponerMensajeError("Error al crear Reporte NotasExcel : " + e.getMessage());

		}
		return null;
		
	}


	public String getTxtNumeroReporte() {
		return txtNumeroReporte;
	}



	public void setTxtNumeroReporte(String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}




	
	
}
