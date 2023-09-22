package com.aaq.col.system.beans.aplicacion.siica;


import java.io.ByteArrayOutputStream;
import java.util.List;

import com.aaq.col.clases.database.entidades.EncuestaAjustador;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.EncuestaAjustadorDataModel;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

import org.apache.commons.lang3.time.DateFormatUtils;


@ManagedBean(name = "beanAplicacionEncuestaMovil")
@SessionScoped
public class JMBeanAplicacionEncuestaMovil extends
		JMBeanExtensiblePrincipal<EncuestaAjustador> {
	private static final long serialVersionUID = 312465396944087152L;

	private String txtAtencionRecibida;
	private String txtOportunidadAjustador;
	private String txtPresentacionAjustador;
	private String txtTratoAjustador;
	private String txtCapacidadAsistencia;
	private String txtTratoAjustadorTercero;
	private String txtServicioGrua;
	private String txtSeleccionTaller;
	
	private String filtroClaveAjustador;
	private String filtroReporte;
	
	private String txtNumeroReporte;
	private String txtPoliza;

	/**
	 * Constructor inicial del objeto
	 */
	public JMBeanAplicacionEncuestaMovil() {
		super();
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

		try {
			this.setListado(new EncuestaAjustadorDataModel(this
					.getEncuestaAjustadorService().listaDeEncuestaAjustador(this.getTxtFechaInicio(),this.getTxtFechaFin(),this.getTerminalService().objetoTerminal(this.getIdTerminal()),
							this.getTxtNumeroReporte(),this.getEstadoService().objetoEstado(this.getIdEstado()),this.getBaseService().objetoBase(this.getIdBase()),this.getTxtPoliza(),
							new Integer(1000))));
						
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"actualizarListado");
		}

	}

	// **************************************************************//
	// Permisos
	// **************************************************************//

	/**
	 * 
	 * @return permiso
	 */
	public boolean getPermisoEncuestaDetalle() {
		return this
				.getTienePermisoParaPagina(JMConstantes.MODULO_APLICACION_ENCUESTA_MOVIL);
	}

	// **************************************************************//
	// Acciones del Componente
	// **************************************************************//

	public String doAccionDetalleEncuesta() {

		try {
			this.setObjetoABM(this.getEncuestaAjustadorService()
					.objetoeEncuestaAjustador(
							this.obtenerParametroDeRequest("id")));
			if (this.getObjetoABM() != null) {

				int[] listaRespuestas = {
						this.getObjetoABM().getAtencionPersonalCabina(),
						this.getObjetoABM().getLlegadaAjustador(),
						this.getObjetoABM().getPresentacionAjustador(),
						this.getObjetoABM().getTratoAjustador(),
						this.getObjetoABM().getCapacidadAjustador(),
						this.getObjetoABM().getTratoAjustadorTercero(),
						this.getObjetoABM().getServicioGrua(),
						this.getObjetoABM().getSeleccionDeTaller()};
				int numeroPregunta = 1;

				for (int respuestas : listaRespuestas) {

					switch (numeroPregunta) {
					//Pregunta 1
					case 1:
						// Respuesta Pregunta 1
						switch (respuestas) {
						case 1: this.setTxtAtencionRecibida("Malo"); break;
						case 2: this.setTxtAtencionRecibida("Regular"); break;
						case 3: this.setTxtAtencionRecibida("Bueno"); break;
						case 4: this.setTxtAtencionRecibida("Excelente");break;
						default:
							break;
						}
						
						break;
						
					// Pregunta 2
					case 2:
						// Respuesta Pregunta 2
						switch (respuestas) {
						case 1: this.setTxtOportunidadAjustador("Malo"); break;
						case 2: this.setTxtOportunidadAjustador("Regular"); break;
						case 3: this.setTxtOportunidadAjustador("Bueno"); break;
						case 4: this.setTxtOportunidadAjustador("Excelente"); break;
						default:
							break;
						}

						break;
						
					// Pregunta 3	
					case 3:
						// Respuesta Pregunta 3
						switch (respuestas) {
						case 1: this.setTxtPresentacionAjustador("Malo"); break;
						case 2: this.setTxtPresentacionAjustador("Regular"); break;
						case 3: this.setTxtPresentacionAjustador("Bueno"); break;
						case 4: this.setTxtPresentacionAjustador("Excelente"); break;
                        default:
							break;
						}

						break;
						
					// Pregunta 4
					case 4:
						// Respuesta Pregunta 4
						switch (respuestas) {
						case 1: this.setTxtTratoAjustador("Malo"); break;
						case 2: this.setTxtTratoAjustador("Regular"); break;
						case 3: this.setTxtTratoAjustador("Bueno"); break;
						case 4: this.setTxtTratoAjustador("Excelente"); break;
						default:
							break;
						}
						
						break;
						
					// Pregunta 5
					case 5:
						// Respuesta Pregunta 5
						switch (respuestas) {
						case 1: this.setTxtCapacidadAsistencia("Malo"); break;
                        case 2: this.setTxtCapacidadAsistencia("Regular"); break;
						case 3: this.setTxtCapacidadAsistencia("Bueno"); break;
						case 4: this.setTxtCapacidadAsistencia("Excelente"); break;
						default:
							break;
						}
						break;
						
					// Pregunta 6
					case 6:
						// Respuesta Pregunta 6
						switch (respuestas) {
						case 1: this.setTxtTratoAjustadorTercero("Malo"); break;
						case 2: this.setTxtTratoAjustadorTercero("Regular"); break;
						case 3: this.setTxtTratoAjustadorTercero("Bueno"); break;
						case 4: this.setTxtTratoAjustadorTercero("Excelente"); break;
						default:
							break;
						}
						break;
						
				   // Pregunta 7
					case 7:
						// Respuesta Pregunta 7
						switch (respuestas) {
						case 0: this.setTxtServicioGrua("No Aplica"); break;
						case 1: this.setTxtServicioGrua("Malo"); break;
						case 2: this.setTxtServicioGrua("Regular"); break;
						case 3: this.setTxtServicioGrua("Bueno"); break;
						case 4: this.setTxtServicioGrua("Excelente"); break;
						default:
							break;
						}
						break;
						
						// Pregunta 8
					case 8:
						// Respuesta Pregunta 8
						switch (respuestas) {
						case 0: this.setTxtSeleccionTaller("No Aplica"); break;
						case 1: this.setTxtSeleccionTaller("Si"); break;
						case 2: this.setTxtSeleccionTaller("No"); break;
						default:
							break;
						}
						break;

					default:
						break;
					}

					numeroPregunta++;

				}
				

				return "encuestasDetalle";
			}

		} catch (Exception e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(),
					"ponerEncuestaEnPantalla==>objetoeEncuestaAjustador");
			this.ponerMensajeError("No se puede poner Detalles de Encuesta En pantalla con id: "
					+ this.obtenerParametroDeRequest("id"));
		}

		return null;

	}
	
	/**
	 * @return la accion del reporte
	 */
	@Override
	public String doAccionReporte() {
		return this.enviarArchivoACliente("Reporte_Encuesta.xls", this.obtenerReporte());
	}

	/**
	 * @return el report en excel en arreglo de bytes
	 */

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

			final WritableCellFormat estiloEncabezadoDatosAjustador = new WritableCellFormat(fuenteEncabezado);
			estiloEncabezadoDatosAjustador.setBackground(Colour.BLUE_GREY);
			estiloEncabezadoDatosAjustador.setAlignment(Alignment.CENTRE);
			estiloEncabezadoDatosAjustador.setVerticalAlignment(VerticalAlignment.CENTRE);
			estiloEncabezadoDatosAjustador.setLocked(true);

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

			final WritableSheet hoja = workbook.createSheet("Reporte Encuesta ", 0);

			// Titulo
			hoja.setRowView(0, 40 * 20);
			hoja.setRowView(1, 35 * 20);
			hoja.setRowView(2, 35 * 20);
			final Label labelTitulo = new Label(1, 0, "Reporte de Encuestas"+ "  del "
					+ DateFormatUtils.format(this.getTxtFechaInicio(), "yyyy/MM/dd HH:mm:ss") + " al "
					+ DateFormatUtils.format(this.getTxtFechaFin(), "yyyy/MM/dd HH:mm:ss"), estiloTitulo);
			hoja.addCell(labelTitulo);
			hoja.getSettings().setVerticalFreeze(2);
			hoja.mergeCells(1, 0, 22, 0);

			int contadorColumna = 0;

				hoja.addCell(new Label(contadorColumna++, 1, "DATOS AJUSTADOR", estiloEncabezadoDatosAjustador));
				hoja.mergeCells(0, 1, 4, 1);
				hoja.addCell(new Label(5, 1, "RESPUESTAS ENCUESTA", estiloEncabezadoRespuestaEncuesta));
				hoja.mergeCells(5, 1, 19, 1);
				
				contadorColumna = 0;
				
				hoja.addCell(new Label(contadorColumna++, 2, "Numero Reporte", estiloEncabezadoDatosAjustador));
				hoja.addCell(new Label(contadorColumna++, 2, "Clave Ajustador", estiloEncabezadoDatosAjustador));
				hoja.addCell(new Label(contadorColumna++, 2, "Nombre Ajustador", estiloEncabezadoDatosAjustador));
				hoja.addCell(new Label(contadorColumna++, 2, "Poliza", estiloEncabezadoDatosAjustador));
				hoja.addCell(new Label(contadorColumna++, 2, "Fecha Encuesta", estiloEncabezadoDatosAjustador));

				hoja.addCell(new Label(contadorColumna++, 2, "Pregunta 1", estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Pregunta 2", estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Pregunta 3", estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Pregunta 4", estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Pregunta 5", estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Pregunta 6", estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Pregunta 7", estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Pregunta 8", estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Pregunta 9", estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Pregunta 10",estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Observaciones",estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Nombre Conductor",estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Telefono Conductor",estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Correo Conductor",estiloEncabezadoRespuestaEncuesta));
				hoja.addCell(new Label(contadorColumna++, 2, "Fecha",estiloEncabezadoRespuestaEncuesta));
				
				final List<EncuestaAjustador> lista =this.getEncuestaAjustadorService().listaDeEncuestaAjustador(this.getTxtFechaInicio(),this.getTxtFechaFin(),this.getTerminalService().objetoTerminal(this.getIdTerminal()),
						this.getTxtNumeroReporte(),this.getEstadoService().objetoEstado(this.getIdEstado()),this.getBaseService().objetoBase(this.getIdBase()),this.getTxtPoliza(), new Integer(1000));
					
				int contadorFila = 3;
				if ((lista != null) && (lista.size() > 0)) {
					for (final EncuestaAjustador reporte : lista) {
						//final EncuestaAjustador r = reporte.getTerminal();
						contadorColumna = 0;
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getNumeroReporte(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getClaveAjustador(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getNombreAjustador(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getPoliza(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, DateFormatUtils.format(reporte.getFecha(), "dd/MM/yyyy") , estiloDatos));
						
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getAtencionPersonalCabina().toString() , estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getLlegadaAjustador().toString(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getPresentacionAjustador().toString(), estiloDatos));					
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getTratoAjustador().toString(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getCapacidadAjustador().toString(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getTratoAjustadorTercero().toString(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getServicioGrua().toString(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getSeleccionDeTaller().toString(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getObservoIrregularidadServicio().toString(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getRecibioCopiaDA().toString(), estiloDatos));
						
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getObservaciones(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getNombreConductor(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getTelefonoConductor(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getCorreoConductor(), estiloDatos));
						hoja.addCell(new Label(contadorColumna++, contadorFila, DateFormatUtils.format(reporte.getFecha(), "dd/MM/yyyy"), estiloDatos));

						contadorFila++;
					}
				}
				contadorFila++;
				contadorColumna = 0;
				
				hoja.addCell(new Label(contadorColumna++, contadorFila, "VALORES RESPUESTAS (1 a la 7)", estiloEncabezadoDatosAjustador));
				hoja.mergeCells(0, contadorFila, 3, contadorFila);
				contadorFila++;
				hoja.addCell(new Label(0, contadorFila, "RESPUESTAS", estiloEncabezadoValorRespuesta));
				hoja.mergeCells(0, contadorFila, 1, contadorFila);
				hoja.addCell(new Label(2, contadorFila, "VALORES", estiloEncabezadoValorRespuesta));
				hoja.mergeCells(2, contadorFila, 3, contadorFila);
				
				contadorFila++;
				hoja.addCell(new Label(0, contadorFila, "0", estiloDatos));
				hoja.mergeCells(0, contadorFila, 1, contadorFila);
				hoja.addCell(new Label(2, contadorFila, "NO aplica", estiloDatos));
				hoja.mergeCells(2, contadorFila, 3, contadorFila);
				
				contadorFila++;
				hoja.addCell(new Label(0, contadorFila, "1", estiloDatos));
				hoja.mergeCells(0, contadorFila, 1, contadorFila);
				hoja.addCell(new Label(2, contadorFila, "MALO", estiloDatos));
				hoja.mergeCells(2, contadorFila, 3, contadorFila);
				
				contadorFila++;
				hoja.addCell(new Label(0, contadorFila, "2", estiloDatos));
				hoja.mergeCells(0, contadorFila, 1, contadorFila);
				hoja.addCell(new Label(2, contadorFila, "REGULAR", estiloDatos));
				hoja.mergeCells(2, contadorFila, 3, contadorFila);
				
				contadorFila++;
				hoja.addCell(new Label(0, contadorFila, "3", estiloDatos));
				hoja.mergeCells(0, contadorFila, 1, contadorFila);
				hoja.addCell(new Label(2, contadorFila, "BUENO", estiloDatos));
				hoja.mergeCells(2, contadorFila, 3, contadorFila);
				
				contadorFila++;
				hoja.addCell(new Label(0, contadorFila, "4", estiloDatos));
				hoja.mergeCells(0, contadorFila, 1, contadorFila);
				hoja.addCell(new Label(2, contadorFila, "EXCELENTE", estiloDatos));
				hoja.mergeCells(2, contadorFila, 3, contadorFila);
				
				
				contadorFila++;
				contadorColumna = 0;
				contadorFila++;
				hoja.addCell(new Label(contadorColumna++, contadorFila, "VALORES RESPUESTA (8)", estiloEncabezadoDatosAjustador));
				hoja.mergeCells(0, contadorFila, 3, contadorFila);
				contadorFila++;
				hoja.addCell(new Label(0, contadorFila, "RESPUESTAS", estiloEncabezadoValorRespuesta));
				hoja.mergeCells(0, contadorFila, 1, contadorFila);
				hoja.addCell(new Label(2, contadorFila, "VALORES", estiloEncabezadoValorRespuesta));
				hoja.mergeCells(2, contadorFila, 3, contadorFila);
				
				contadorFila++;
				hoja.addCell(new Label(0, contadorFila, "0", estiloDatos));
				hoja.mergeCells(0, contadorFila, 1, contadorFila);
				hoja.addCell(new Label(2, contadorFila, "NO APLICA", estiloDatos));
				hoja.mergeCells(2, contadorFila, 3, contadorFila);
				
				contadorFila++;
				hoja.addCell(new Label(0, contadorFila, "1", estiloDatos));
				hoja.mergeCells(0, contadorFila, 1, contadorFila);
				hoja.addCell(new Label(2, contadorFila, "SI", estiloDatos));
				hoja.mergeCells(2, contadorFila, 3, contadorFila);
				
				contadorFila++;
				hoja.addCell(new Label(0, contadorFila, "2", estiloDatos));
				hoja.mergeCells(0, contadorFila, 1, contadorFila);
				hoja.addCell(new Label(2, contadorFila, "NO", estiloDatos));
				hoja.mergeCells(2, contadorFila, 3, contadorFila);
						
			workbook.write();
			workbook.close();
			return paraFuera.toByteArray();

		} catch (final Exception e) {
			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "Crear Reporte Excel");
			this.ponerMensajeError("Error al crear el reporte de Excel : " + e.getMessage());

		}
		return null;
	}

	// **************************************************************//
	// Getters and Setters
	// **************************************************************//

	/**
	 * @return the txtAtencionRecibida
	 */
	public String getTxtAtencionRecibida() {
		return this.txtAtencionRecibida;
	}

	/**
	 * @param txtAtencionRecibida
	 *            the txtAtencionRecibida to set
	 */
	public void setTxtAtencionRecibida(final String txtAtencionRecibida) {
		this.txtAtencionRecibida = txtAtencionRecibida;
	}

	/**
	 * @return the txtOportunidadAjustador
	 */
	public String getTxtOportunidadAjustador() {
		return this.txtOportunidadAjustador;
	}

	/**
	 * @param txtOportunidadAjustador
	 *            the txtOportunidadAjustador to set
	 */
	public void setTxtOportunidadAjustador(final String txtOportunidadAjustador) {
		this.txtOportunidadAjustador = txtOportunidadAjustador;
	}

	/**
	 * @return the txtPresentacionAjustador
	 */
	public String getTxtPresentacionAjustador() {
		return this.txtPresentacionAjustador;
	}

	/**
	 * @param txtPresentacionAjustador
	 *            the txtPresentacionAjustador to set
	 */
	public void setTxtPresentacionAjustador(
			final String txtPresentacionAjustador) {
		this.txtPresentacionAjustador = txtPresentacionAjustador;
	}

	/**
	 * @return the txtTratoAjustador
	 */
	public String getTxtTratoAjustador() {
		return this.txtTratoAjustador;
	}

	/**
	 * @param txtTratoAjustador
	 *            the txtTratoAjustador to set
	 */
	public void setTxtTratoAjustador(final String txtTratoAjustador) {
		this.txtTratoAjustador = txtTratoAjustador;
	}

	/**
	 * @return the txtCapacidadAsistencia
	 */
	public String getTxtCapacidadAsistencia() {
		return this.txtCapacidadAsistencia;
	}

	/**
	 * @param txtCapacidadAsistencia
	 *            the txtCapacidadAsistencia to set
	 */
	public void setTxtCapacidadAsistencia(final String txtCapacidadAsistencia) {
		this.txtCapacidadAsistencia = txtCapacidadAsistencia;
	}

	/**
	 * @return the txtTratoAjustadorTercero
	 */
	public String getTxtTratoAjustadorTercero() {
		return this.txtTratoAjustadorTercero;
	}

	/**
	 * @param txtTratoAjustadorTercero
	 *            the txtTratoAjustadorTercero to set
	 */
	public void setTxtTratoAjustadorTercero(
			final String txtTratoAjustadorTercero) {
		this.txtTratoAjustadorTercero = txtTratoAjustadorTercero;
	}

	/**
	 * @return the txtServicioGrua
	 */
	public String getTxtServicioGrua() {
		return this.txtServicioGrua;
	}

	/**
	 * @param txtServicioGrua
	 *            the txtServicioGrua to set
	 */
	public void setTxtServicioGrua(final String txtServicioGrua) {
		this.txtServicioGrua = txtServicioGrua;
	}

	/**
	 * @return the filtroClaveAjustador
	 */
	public String getFiltroClaveAjustador() {
		return this.filtroClaveAjustador;
	}

	/**
	 * @param filtroClaveAjustador the filtroClaveAjustador to set
	 */
	public void setFiltroClaveAjustador(final String filtroClaveAjustador) {
		this.filtroClaveAjustador = filtroClaveAjustador;
	}

	/**
	 * @return the filtroReporte
	 */
	public String getFiltroReporte() {
		return this.filtroReporte;
	}

	/**
	 * @param filtroReporte the filtroReporte to set
	 */
	public void setFiltroReporte(final String filtroReporte) {
		this.filtroReporte = filtroReporte;
	}

	/**
	 * @return the txtSeleccionTaller
	 */
	public String getTxtSeleccionTaller() {
		return this.txtSeleccionTaller;
	}

	/**
	 * @param txtSeleccionTaller the txtSeleccionTaller to set
	 */
	public void setTxtSeleccionTaller(final String txtSeleccionTaller) {
		this.txtSeleccionTaller = txtSeleccionTaller;
	}
	
	/**
	 * @return the txtNumeroReporte
	 */
	public String getTxtNumeroReporte() {
		return this.txtNumeroReporte;
	}

	/**
	 * @param txtNumeroReporte the txtNumeroReporte to set
	 */
	public void setTxtNumeroReporte(final String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}

	/**
	 * @return the txtPoliza
	 */
	public String getTxtPoliza() {
		return this.txtPoliza;
	}

	/**
	 * @param txtPoliza the txtPoliza to set
	 */
	public void setTxtPoliza(final String txtPoliza) {
		this.txtPoliza = txtPoliza;
	}

}
