package com.aaq.col.system.beans.reporte;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.aaq.col.clases.database.entidades.HistoricoTerminal;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.HistoricoTerminalDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMEntidadObjeto;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
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

@ManagedBean(name = "beanReporteHistoricoTerminal")
@ViewScoped
public class JMBeanReporteHistoricoTerminal extends JMBeanExtensiblePrincipal<HistoricoTerminal> {
	private static final long serialVersionUID = -3750936506582449831L;

	private String idOperacionSeleccionada;
	private String txtNumeroReporte;

	public JMBeanReporteHistoricoTerminal() {
		super();
		this.actualizarListado();		
	}

	// **************************************************************//
	// Listado
	// **************************************************************//

	@Override
	public void actualizarListado() {
		Calendar calendar = Calendar.getInstance();
		this.setTxtFechaFin(calendar.getTime());
		calendar.add(Calendar.HOUR_OF_DAY, -1);
		this.setTxtFechaInicio(calendar.getTime());
		
		if ((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
			this.ponerMensajeAdvertencia("Los reportes estan limitados a 31 dias naturales de datos. Para obtener reportes de meses multiples, es necesario crear el reporte uno por uno del mes que se solicita.");
			return;
		}

		try {
			this.setListado(new HistoricoTerminalDataModel(this.getHistoricoTerminalService().listaDeHistoricoTerminal(
					this.getTerminalService().objetoTerminal(this.getIdTerminal()), this.getTxtNumeroReporte(),
					this.getIdOperacionSeleccionada(), this.getTxtFechaInicio(), this.getTxtFechaFin(),
					new Integer(1000))));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}

	}
	
	public void crearReporte() {
		
		if ((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)
				&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
			this.ponerMensajeAdvertencia("Los reportes estan limitados a 31 dias naturales de datos. Para obtener reportes de meses multiples, es necesario crear el reporte uno por uno del mes que se solicita.");
			return;
		}

		try {
			this.setListado(new HistoricoTerminalDataModel(this.getHistoricoTerminalService().listaDeHistoricoTerminal(
					this.getTerminalService().objetoTerminal(this.getIdTerminal()), this.getTxtNumeroReporte(),
					this.getIdOperacionSeleccionada(), this.getTxtFechaInicio(), this.getTxtFechaFin(),
					new Integer(1000))));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}

	}
    @Override
    public void doAccionRegistroNuevo (final ActionEvent arg0) {
        // nada
    }

	@Override
	public String doReporteExcel(final List<HistoricoTerminal> lista, final String nombre, final String descripcion) {

		if ((lista == null) || (lista.size() == 0)) {
			this.ponerMensajeAdvertencia("Lista de objetos vacia");
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

			final WritableCellFormat estiloEncabezado = new WritableCellFormat(fuenteEncabezado);
			estiloEncabezado.setBackground(Colour.PLUM);
			estiloEncabezado.setAlignment(Alignment.CENTRE);
			estiloEncabezado.setVerticalAlignment(VerticalAlignment.CENTRE);
			estiloEncabezado.setLocked(true);

			final WritableCellFormat estiloDatos = new WritableCellFormat(fuenteDatos);
			estiloDatos.setBackground(Colour.WHITE);
			estiloDatos.setAlignment(Alignment.CENTRE);
			estiloDatos.setVerticalAlignment(VerticalAlignment.CENTRE);
			estiloDatos.setBorder(Border.ALL, BorderLineStyle.THIN);
			estiloDatos.setLocked(true);

			final WritableSheet hoja = workbook.createSheet("Reporte Historico de Terminal", 0);

			// Titulo
			hoja.setRowView(0, 40 * 20);
			hoja.setRowView(1, 35 * 20);
			final Label labelTitulo = new Label(1, 0, "Reporte Historico de Terminal del "
					+ DateFormatUtils.format(DateUtils.addDays(new Date(), -30), "yyyy/MM/dd HH:mm:ss") + " al "
					+ DateFormatUtils.format(new Date(), "yyyy/MM/dd HH:mm:ss"), estiloTitulo);
			hoja.addCell(labelTitulo);
			hoja.getSettings().setHorizontalFreeze(1);
			hoja.getSettings().setVerticalFreeze(2);

			hoja.mergeCells(1, 0, 10, 0);

			int contadorColumna = 0;

			hoja.addCell(new Label(contadorColumna++, 1, "Ticket", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Estado", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Base", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Proveedor", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Reporte", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Fecha / Hora", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Detalles", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Fuente", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Operacion", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Ticket Grua", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "TAG", estiloEncabezado));

			int contadorFila = 2;

			for (final HistoricoTerminal reporte : lista) {
				contadorColumna = 0;
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(reporte.getId(), ""),
						estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(reporte.getTerminal()
						.getEstado().getNombre(), ""), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(reporte.getTerminal()
						.getBase().getNombre(), ""), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(reporte.getTerminal()
						.getNumeroproveedor(), ""), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(reporte.getReporte(), ""),
						estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(
						DateFormatUtils.format(reporte.getFecha(), "yyyy/MM/dd HH:mm:ss"), ""), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getDetalles(), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getFuente(), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, reporte.getOperacion(), estiloDatos));

				if (StringUtils.equals(reporte.getOperacion(), "Solicitar Grua Movil V3")) {
					hoja.addCell(new Label(contadorColumna++, contadorFila, StringUtils.substring(
							reporte.getDetalles(), StringUtils.indexOf(reporte.getDetalles(), "OK -"),
							StringUtils.indexOf(reporte.getDetalles(), "</mensajeError>")), estiloDatos));

				} else {
					hoja.addCell(new Label(contadorColumna++, contadorFila, "", estiloDatos));

				}

				if (StringUtils.equals(reporte.getOperacion(), "Arribo Movil V3")) {
					hoja.addCell(new Label(contadorColumna++, contadorFila, StringUtils.contains(reporte.getDetalles(),
							"<tag>true</tag>") ? "TRUE" : "FALSE", estiloDatos));

				} else {
					hoja.addCell(new Label(contadorColumna++, contadorFila, "", estiloDatos));

				}

				contadorFila++;
			}

			workbook.write();
			workbook.close();

			return this.enviarArchivoACliente("Reporte_Historico_terminal.xls", paraFuera.toByteArray());

		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doReporteExcel");
			this.ponerMensajeError("Error al crear el reporte de excel: " + ex.getMessage());
		}

		return null;

	}
	
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(new String[] { "Ticket,id", "Fecha,fecha,fecha", "Ajustador,terminal",
				"Reporte,reporte", "Operacion,operacion", "Fuente,fuente", "Usuario,usuario", "Detalles,detalles" })
				.getLista();
	}

	/**
	 *  Aug 14, 2013 9:37:01 AM
	 *
	 * @return el reporte
	 */
	public String doAccionReporteUso() {
		if (StringUtils.isBlank(this.getIdEstado())) {
			this.ponerMensajeAdvertencia("Seleccione primero un estado");
			return null;
		}

		List<JMEntidadObjeto> lista = null;
		try {
			lista = this.getBaseService().listaDeReporteDeUso(this.getEstadoService().objetoEstado(this.getIdEstado()));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionReporteUso");
		}

		if ((lista == null) || (lista.size() == 0)) {
			this.ponerMensajeAdvertencia("Lista de objetos vacia");
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

			final WritableCellFormat estiloEncabezado = new WritableCellFormat(fuenteEncabezado);
			estiloEncabezado.setBackground(Colour.PLUM);
			estiloEncabezado.setAlignment(Alignment.CENTRE);
			estiloEncabezado.setVerticalAlignment(VerticalAlignment.CENTRE);
			estiloEncabezado.setLocked(true);

			final WritableCellFormat estiloDatos = new WritableCellFormat(fuenteDatos);
			estiloDatos.setBackground(Colour.WHITE);
			estiloDatos.setAlignment(Alignment.CENTRE);
			estiloDatos.setVerticalAlignment(VerticalAlignment.CENTRE);
			estiloDatos.setBorder(Border.ALL, BorderLineStyle.THIN);
			estiloDatos.setLocked(true);

			final WritableSheet hoja = workbook.createSheet("Reporte ", 0);

			int contadorColumna = 0;
			hoja.addCell(new Label(contadorColumna++, 1, "Estado", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Base", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Total Terminales", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Total de Movimientos", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Terminales Que Iniciarion Sesion", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Terminales Que Dieron Arribo a Un reporte", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Porcentaje Uso x Sesion", estiloEncabezado));
			hoja.addCell(new Label(contadorColumna++, 1, "Porcentaje Uso x Arribo", estiloEncabezado));

			int contadorFila = 2;

			for (final JMEntidadObjeto reporte : lista) {
				contadorColumna = 0;
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(reporte.getValor0(), ""),
						estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(reporte.getValor1(), ""),
						estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(reporte.getValor2(), ""),
						estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(reporte.getValor3(), ""),
						estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(reporte.getValor4(), ""),
						estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, Objects.toString(reporte.getValor5(), ""),
						estiloDatos));

				final int numeroAjustadores = NumberUtils.toInt(Objects.toString(reporte.getValor2(), ""));
				final int iniciaronSesion = NumberUtils.toInt(Objects.toString(reporte.getValor4(), ""));
				final int iniciaronArribo = NumberUtils.toInt(Objects.toString(reporte.getValor5(), ""));

				final double porcentajeSesion = numeroAjustadores > 0 ? ((iniciaronSesion * 100) / numeroAjustadores)
						: 0;
				final double porcentajeArribo = numeroAjustadores > 0 ? ((iniciaronArribo * 100) / numeroAjustadores)
						: 0;

				hoja.addCell(new Label(contadorColumna++, contadorFila, Double.toString(porcentajeSesion), estiloDatos));
				hoja.addCell(new Label(contadorColumna++, contadorFila, Double.toString(porcentajeArribo), estiloDatos));

				contadorFila++;
			}

			workbook.write();
			workbook.close();

			return this.enviarArchivoACliente("Reporte_Uso.xls", paraFuera.toByteArray());
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionReporteUso");
			this.ponerMensajeError("Error al crear el reporte de excel: " + ex.getMessage());
		}

		return null;

	}

	// **************************************************************//
	// Getter y Setter
	// **************************************************************//

	/**
	 * Feb 26, 2011 7:59:13 PM
	 *
	 * @return the idOperacionSeleccionada
	 */
	public String getIdOperacionSeleccionada() {
		return this.idOperacionSeleccionada;
	}

	/**
	 * Feb 26, 2011 7:59:13 PM
	 *
	 * @param idOperacionSeleccionada
	 *            the idOperacionSeleccionada to set
	 */
	public void setIdOperacionSeleccionada(final String idOperacionSeleccionada) {
		this.idOperacionSeleccionada = idOperacionSeleccionada;
	}

	/**
	 * Feb 26, 2011 7:59:13 PM
	 *
	 * @return the txtNumeroReporte
	 */
	public String getTxtNumeroReporte() {
		return this.txtNumeroReporte;
	}

	/**
	 * Feb 26, 2011 7:59:13 PM
	 *
	 * @param txtNumeroReporte
	 *            the txtNumeroReporte to set
	 */
	public void setTxtNumeroReporte(final String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}

}
