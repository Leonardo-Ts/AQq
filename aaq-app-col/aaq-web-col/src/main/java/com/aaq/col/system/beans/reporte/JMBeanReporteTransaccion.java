package com.aaq.col.system.beans.reporte;

import java.io.ByteArrayOutputStream;
import java.io.IOError;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Estado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Transaccion;
import com.aaq.col.clases.pojo.aaq.InformacionPago;
import com.aaq.col.clases.util.LinkDePago;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.TransaccionDataModel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontStyle;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.web.spring.JMProveedorApplicationContext;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@ManagedBean(name = "beanReporteTransaccion")
@ViewScoped
public class JMBeanReporteTransaccion extends JMBeanExtensiblePrincipal<Transaccion> {
	private static final long serialVersionUID = 3999627850831652042L;

	private String txtNumeroReporte;
	
	private String _idEstado;
	private String _idBase;
	private String _idTerminal;
	private String edoTransaccion;

	public JMBeanReporteTransaccion() {
		super();
		this.actualizarListado();

	}
    
	public List<Estado> getListaDeEstadosParaSeleccion() throws ClassCastException {
		try {
			return this.getEstadoService().listaDeEstado(null, null, null);
		} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeEstadosParaSeleccion");
		} catch (final ClassCastException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeEstadosParaSeleccion");
		} catch (final NoSuchElementException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeEstadosParaSeleccion");
		}catch (final Exception  ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeEstadosParaSeleccion");
		} 
		return null;
	}
	
	public void actualizarListado() {
		this.actualizarListadoNuevo();
//		this.getGrafica();
	}
	
//	@Override
	public void actualizarListadoNuevo() {
		
		String ajustador =  null;
			if((this.getTxtFechaInicio() != null)
					&& (this.getTxtFechaFin() != null)
					&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
						this.ponerMensajeAdvertencia("Los reportes bancarios estan limitados a 31 días naturales.");
						return;
					}
			
				try {
				if (getPermisoTodosEstados() && getPermisoTodosBases()){
					if (this.get_idEstado() == null) {
						TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccion(this.getTxtNumeroReporte(),
								this.getTerminalService().objetoTerminal(this.get_idTerminal()), this.getTxtFechaInicio(), this.getTxtFechaFin(),
								Boolean.FALSE, null, this.getEdoTransaccion()));
						this.setListado(data);
					}  else {
					if(!this.get_idEstado().equals("9999") ) {
						if(!get_idEstado().equals("null")) {
							if ( this.get_idTerminal() != "" && this.get_idTerminal() != null) {
								Terminal term = this.getTerminalService().objetoTerminal(this.get_idTerminal());
								if (term != null) {
									 ajustador = term.getNumeroproveedor();
									 TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
												this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
												this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,this.getEstadoService().objetoEstado(this.get_idEstado()),
												this.getBaseService().objetoBase(this.get_idBase()), ajustador, this.getEdoTransaccion()));
									 this.setListado(data);
								}
							} else {
							TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
									this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
									this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,this.getEstadoService().objetoEstado(this.get_idEstado()),
									this.getBaseService().objetoBase(this.get_idBase()), null, this.getEdoTransaccion()));
							this.setListado(data);
							}
						
						}
					}else {
						if( this.get_idTerminal() != "" && this.get_idTerminal() != null) {
							Terminal term = this.getTerminalService().objetoTerminal(this.get_idTerminal());
							if (term != null) {
								 ajustador = term.getNumeroproveedor();
								 TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
								this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
								this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,null,
								this.getBaseService().objetoBase(this.get_idBase()), ajustador, this.getEdoTransaccion()));
						this.setListado(data);
							}
						}else 
						{
							TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
									this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
									this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,null,
									this.getBaseService().objetoBase(this.get_idBase()), null, this.getEdoTransaccion()));
							this.setListado(data);
						}
					}
				
				} // importante
				} else {
					if (this.get_idEstado() == null) {
						if ( this.get_idTerminal() != "" && this.get_idTerminal() != null) {
							Terminal term = this.getTerminalService().objetoTerminal(this.get_idTerminal());
							if (term != null) {
								 ajustador = term.getNumeroproveedor();
								 TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
											this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
											this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,null,
											null, ajustador, this.getEdoTransaccion()));
								 this.setListado(data);
							}
						} else {						
						TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
								this.getTxtNumeroReporte(), null,
								this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,null,
								null, null, this.getEdoTransaccion()));
						this.setListado(data);
						}
					} 
					if (this.getIdEstado().equals("9999")){
						if (Integer.parseInt(this.get_idBase()) < 0)
						{
							if ( this.get_idTerminal() != "" && this.get_idTerminal() != null) {
								Terminal term = this.getTerminalService().objetoTerminal(this.get_idTerminal());
								if (term != null) {
									 ajustador = term.getNumeroproveedor();
									 TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
												this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
												this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,this.getEstadoService().objetoEstado(this.get_idEstado()),
												null, ajustador, this.getEdoTransaccion()));
										this.setListado(data);
								}
							} else 
							{
								 TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
											this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
											this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,this.getEstadoService().objetoEstado(this.get_idEstado()),
											null, null, this.getEdoTransaccion()));	
								 this.setListado(data);
							}
							
						} else {
							if ( this.get_idTerminal() != "" && this.get_idTerminal() != null) {
								Terminal term = this.getTerminalService().objetoTerminal(this.get_idTerminal());
								if(term != null) {
									ajustador = term.getNumeroproveedor();
									TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
											this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
											this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,this.getEstadoService().objetoEstado(this.get_idEstado()),
											this.getBaseService().objetoBase(this.get_idBase()), ajustador, this.getEdoTransaccion()));
									this.setListado(data);
								}
								
							} else {
								TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
										this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
										this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,this.getEstadoService().objetoEstado(this.get_idEstado()),
										this.getBaseService().objetoBase(this.get_idBase()), null, this.getEdoTransaccion()));
								this.setListado(data);
							}
							
						}
					} else {
						if (StringUtils.isNotBlank(this.get_idBase())) {
						if (Integer.parseInt(this.get_idBase()) < 0)
						{
							if( this.get_idTerminal() != "" && this.get_idTerminal() != null) {
							Terminal term = this.getTerminalService().objetoTerminal(this.get_idTerminal());
							if (term != null) {
							ajustador = term.getNumeroproveedor();
							TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
									this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
									this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,null,
									null, ajustador, this.getEdoTransaccion()));
							this.setListado(data);
							}
							} else {
								TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
										this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
										this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,null,
										null, null, this.getEdoTransaccion()));
								this.setListado(data);
							}
						} else {	
							if( this.get_idTerminal() != "" && this.get_idTerminal() != null ) {
								Terminal term = this.getTerminalService().objetoTerminal(this.get_idTerminal());
								if(term != null) {
									ajustador = term.getNumeroproveedor();
								TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
										this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
										this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,this.getEstadoService().objetoEstado(this.get_idEstado()),
										this.getBaseService().objetoBase(this.get_idBase()), ajustador, this.getEdoTransaccion()));
								this.setListado(data);
								}
							} else {
								TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
										this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
										this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,this.getEstadoService().objetoEstado(this.get_idEstado()),
										this.getBaseService().objetoBase(this.get_idBase()), null, this.getEdoTransaccion()));
								this.setListado(data);
							}
						} 
						}else {
							
							Estado estado = null;
							if (StringUtils.isNotBlank(this.get_idEstado())) {
								estado = this.getEstadoService().objetoEstado(this.get_idEstado());
							}
							Base base = null;
							if (StringUtils.isNotBlank(this.get_idBase())) {
								base = this.getBaseService().objetoBase(this.get_idBase());
							}
							Terminal terminal = null;
//							String ajustador = null;
							if (StringUtils.isNotBlank(this.get_idTerminal())) {
								terminal = this.getTerminalService().objetoTerminal(this.get_idTerminal());
								ajustador = terminal.getNumeroproveedor();
							}
							
								 TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
												this.getTxtNumeroReporte(), terminal, this.getTxtFechaInicio(), this.getTxtFechaFin(),
												Boolean.FALSE, null,estado, base, ajustador, this.getEdoTransaccion()));
										this.setListado(data);
							
							
							
							// Cuando nula la base
//							if( this.get_idTerminal() != "" && this.get_idTerminal() != null ) {
//								Terminal term = this.getTerminalService().objetoTerminal(this.get_idTerminal());
//								if(term != null) {
//									ajustador = term.getNumeroproveedor();
//								TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
//										this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
//										this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,this.getEstadoService().objetoEstado(this.get_idEstado()),
//										this.getBaseService().objetoBase(this.get_idBase()), ajustador, this.getEdoTransaccion()));
//								this.setListado(data);
//								}
//							} else {
//								TransaccionDataModel data = new TransaccionDataModel(this.getTransaccionService().listaDeTransaccionNuevo(
//										this.getTxtNumeroReporte(), this.getTerminalService().objetoTerminal(this.get_idTerminal()),
//										this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.FALSE, null,this.getEstadoService().objetoEstado(this.get_idEstado()),
//										null, null, this.getEdoTransaccion()));
//								this.setListado(data);
//							}
						}
					}
				}
			
		} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		} catch (final NoSuchElementException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		} catch (final ClassCastException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}  catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}  
	}

	// **************************************************************//
	// Acciones
	// **************************************************************//

	/**
	 * @return el reporte
	 */
	public String doAccionGenerarReporteAutorizacionTecnica() {
		List<Transaccion> lista = null;
		try {
			lista = this.getTransaccionService().listaDeTransaccion(this.getTxtNumeroReporte(),
					this.getTerminalService().objetoTerminal(this.getIdTerminal()), this.getTxtFechaInicio(),
					this.getTxtFechaFin(), Boolean.TRUE, new String[] { "P.R.", "P.D." }, null);
		} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"doAccionGenerarReporteAutorizacionTecnica => listaDeTransaccion");
		}  catch (final NoSuchElementException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"doAccionGenerarReporteAutorizacionTecnica => listaDeTransaccion");
		}  catch (final ClassCastException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"doAccionGenerarReporteAutorizacionTecnica => listaDeTransaccion");
		}  catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"doAccionGenerarReporteAutorizacionTecnica => listaDeTransaccion");
		}  

		final DateFormat f = new SimpleDateFormat("ddMMy");

		if ((lista != null) && (lista.size() > 0)) {
			final StringBuilder builder = new StringBuilder("");
			for (final Transaccion transaccion : lista) {
				builder.append(StringUtils.substring(transaccion.getNumeroReporte(), 2, 4) + "|");
				builder.append(StringUtils.defaultString(transaccion.getNumeroSiniestro()) + "|");
				builder.append(StringUtils.equalsIgnoreCase(transaccion.getTipoDeCobro(), "P.R.") ? "R" : "D");
				builder.append("|");
				builder.append(StringUtils.defaultString(transaccion.getCoberturaAfectada()) + "|");
				builder.append(transaccion.getMonto() + "|");
				builder.append(StringUtils.equalsIgnoreCase(transaccion.getTipoDeCobro(), "P.R") ? transaccion
						.getTerminal().getNumeroproveedor() : "");
				builder.append("|");
				builder.append(StringUtils.right(transaccion.getNumeroReferencia(), 9) + "|");
				builder.append(StringUtils.right(transaccion.getNumeroAutorizacion(), 4) + "|");
				builder.append(f.format(transaccion.getFecha()));
				builder.append("\n");

			}
			return this.enviarArchivoACliente("Reporte_Autorizacion_Tecnica.txt", Objects.toString(builder, "")
					.getBytes());
		}
		return null;
	}

	/**
	 * Generacion del voucher PDF doVoucherPDF Apr 6, 2008 7:56:27 AM Jose
	 * Miguel
	 * 
	 * @return voucher
	 */
	public String doAccionVoucherPDF() {
		this.doAccionRegistroEditar(null);
		if (this.getObjetoABM() != null) {
			try {
				try {
					if (this.getObjetoABM() != null && StringUtils.isNotBlank(this.getObjetoABM().getFuente()) && this.getObjetoABM().getFuente().contains("Link De Pago") && this.getObjetoABM().getTransaccionAprobada() ) {
						this.enviarArchivoACliente(this.getObjetoABM().getNumeroReporte() + ".pdf", this.detallesPago(this.getObjetoABM().getTerminal(), "04223328808"));
						return null;
					}
				} catch (ClassCastException | IndexOutOfBoundsException | IllegalStateException | IllegalArgumentException e) {
				}
				if (this.getObjetoABM() != null && StringUtils.isNotBlank(this.getObjetoABM().getFuente()) && !this.getObjetoABM().getFuente().contains("Link De Pago")) {
					this.enviarArchivoACliente(this.getObjetoABM().getNumeroReporte() + ".pdf", this.getObjetoABM()
						.getVoucher());
				}
				return null;
			} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionVoucherPDF",
						this.getObjetoABM());
				this.ponerMensajeError("Error al generar el Voucher en PDF: " + ex.getMessage());
			} catch (final IOError ex) {
//				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionVoucherPDF",
//						this.getObjetoABM());
				this.ponerMensajeError("Error al generar el Voucher en PDF: " + ex.getMessage());
			} catch (final IllegalStateException  ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionVoucherPDF",
				this.getObjetoABM());
				this.ponerMensajeError("Error al generar el Voucher en PDF: " + ex.getMessage());
			} catch (final Exception  ex) {
//				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionVoucherPDF",
//				this.getObjetoABM());
				this.ponerMensajeError("Error al generar el Voucher en PDF: " + ex.getMessage());
			}  
		}
		return null;
	}
	
	public byte[] detallesPago(Terminal term, String numReporte) {
		LinkDePago linkP = new LinkDePago();
		InformacionPago resp = linkP.detallesPagoLP(term, numReporte, "Cabina Nacional");
		if (resp != null && resp.getDetalles() != null) {
		  final ByteArrayOutputStream out = new ByteArrayOutputStream();
			try {
			  String ruta = JMProveedorApplicationContext.getApplicationContext().getResource("/resumen").getFile().getPath() + "/";
	          Image img = Image.getInstance(ruta+"25_qualitas.png");
	          img.setBorder(0);
	          img.setAlignment(Element.ALIGN_CENTER);
	          float percentage = 0.0f;
	          percentage = 150 / img.getWidth();
	          img.scalePercent(percentage * 100);
	   		 final Font fuenteNormal = FontFactory.getFont(FontFactory.HELVETICA, 10);
			 final Font fuenteBold = FontFactory.getFont(FontFactory.HELVETICA, 10);
			 fuenteBold.setStyle(FontStyle.BOLD.getValue());

			final Document document = new Document();
			PdfWriter.getInstance(document, out);
			document.open();
			 // Insertamos la imagen en el documento
			document.add(img);
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			
		 try {
				for (int i = 0; i < resp.getDetalles().size(); i++) {
				  final PdfPTable tablavoucher = new PdfPTable(1);
					tablavoucher.setSpacingAfter(30f);
					tablavoucher.getDefaultCell().setBorder(Rectangle.LEFT);
					tablavoucher.getDefaultCell().setBorderColor(BaseColor.BLUE);
					tablavoucher.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
					tablavoucher.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);	
						
					tablavoucher.addCell(new Phrase("Referencia de cobro: " + resp.getDetalles().get(i).getReferenciaDeCobro(), fuenteNormal));
					tablavoucher.addCell(new Phrase("Status: " +resp.getDetalles().get(i).getStatus(), fuenteNormal));
					tablavoucher.addCell(new Phrase("Tipo de Tarjeta: " +resp.getDetalles().get(i).getTipoDeTarjeta(), fuenteNormal));
					tablavoucher.addCell(new Phrase("Monto Cobrado: "+resp.getDetalles().get(i).getMontoCobrado(), fuenteNormal));
					tablavoucher.addCell(new Phrase("Fecha de Pago: "+resp.getDetalles().get(i).getFechaPago(),fuenteNormal));
					tablavoucher.addCell(new Phrase("Hora de Pago: "+resp.getDetalles().get(i).getHoraPago(),fuenteNormal));
					tablavoucher.addCell(new Phrase("No. de Autorización: "+resp.getDetalles().get(i).getNoAutorizacion(),fuenteNormal));
					tablavoucher.addCell(new Phrase("Folio de Transacción: "+resp.getDetalles().get(i).getFolioTransaccion(),fuenteNormal));
				  document.add(tablavoucher);	
				}
				document.add(new Paragraph(" "));
				document.add(new Paragraph(" "));
				} catch (final ClassCastException | IndexOutOfBoundsException ex) {
								JMEntidad.getLogger().error("getVoucher", ex);
				} catch (final  Exception ex) {
								JMEntidad.getLogger().error("getVoucher", ex);
				}

				document.close();
				} catch ( ClassCastException | IndexOutOfBoundsException e) {
				} catch (DocumentException e) {
				} catch (MalformedURLException e) {
				} catch (IOException e) {
				}
				return out.toByteArray();
		} else {
			this.ponerMensajeError(resp.getStatus());
		}
		return null;
	}

	
	// **************************************************************//
		// Nueva grafica
		// **************************************************************//
//		public BarChartModel getBarModel() {  
//			return barModel;  
//			}
//		
//		private void createBarModels() {  
//			createBarModel();  
//			} 
//		
//		private void createBarModel() {
//			barModel = new BarChartModel();
//			List<EntidadObjeto> salida = null;
//			int numeroMayor = 0;
//
//			try {
//				try {
//					String ajustador = null;
//					Estado edo = null;
//					Base base= null;
//					
//					if (this.get_idEstado() == null) {
//						salida = this.getTransaccionService().listaDeTransaccionParaGraficaNueva(this.getTxtNumeroReporte(),
//								this.get_idTerminal(), this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.TRUE, 0, 0, null);
//					}
//					
//					if ((this.getEdoTransaccion().contains("error")) || (this.getEdoTransaccion().contains("declinada"))  ) {
//						salida = this.getTransaccionService().listaDeTransaccionParaGraficaNueva(null,
//										this.get_idTerminal(), null, null, Boolean.FALSE, 0, 0, null);
//					}
//					
//					if(this.get_idEstado() != null) {
//					edo = getEstadoService().objetoEstado(this.get_idEstado());
//					}
//					if (this.get_idBase() != null) {
//					base = getBaseService().objetoBase(this.get_idBase());
//					}
//					if (this.get_idTerminal() != null && this.get_idTerminal() != "") {
//						Terminal term = this.getTerminalService().objetoTerminal(this.get_idTerminal());
//						if (term != null) {
//							ajustador = term.getNumeroproveedor();
//						}
//					}
//					
//					if(edo != null  )	{
//						if(base != null) {
//							if (ajustador != null) {
//								salida = this.getTransaccionService().listaDeTransaccionParaGraficaNueva(this.getTxtNumeroReporte(),
//												this.getIdTerminal(), this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.TRUE, edo.getId(), base.getId(), ajustador);
//							} else {
//								salida = this.getTransaccionService().listaDeTransaccionParaGraficaNueva(this.getTxtNumeroReporte(),
//												this.getIdTerminal(), this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.TRUE, edo.getId(), base.getId(), null);
//							}
//						} else {
//							salida = this.getTransaccionService().listaDeTransaccionParaGraficaNueva(this.getTxtNumeroReporte(),
//											this.getIdTerminal(), this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.TRUE, edo.getId(),0, null);
//						}
//						
//					} else {
//							salida = this.getTransaccionService().listaDeTransaccionParaGraficaNueva(this.getTxtNumeroReporte(),
//										this.getIdTerminal(), this.getTxtFechaInicio(), this.getTxtFechaFin(), Boolean.TRUE, 0, 0, null);
//					}
//				} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
//					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getGrafica");
//				} catch (final PersistenceException ex) {
//					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getGrafica");
//				} catch (final NoSuchFieldError ex) {
//				} catch (final ClassCastException ex) {
//					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getGrafica");
//				}  
//				
//				BarChartModel model = new BarChartModel();
//		        smsData = new ChartSeries();
//				if(salida != null && salida.size() >0) {
//		          for (final EntidadObjeto objects : salida) {
//			        	String str = null;
//				        str = this.getFecha(objects.getValor0());
//				        smsData.set(str, Integer.parseInt(objects.getValor1().toString()));
//				        if (Integer.parseInt(objects.getValor1().toString()) > numeroMayor) {
//							numeroMayor = Integer.parseInt(objects.getValor1().toString());
//						}
//				}
//		          //Añadir valores para espacios
//		          if (salida.size() < 3) {
//				        smsData.set("", 0);
//				        smsData.set(" ", 0);
//				}
//		          
//			     model.addSeries(smsData);
//			     model.setSeriesColors("008C99, 9F85B8, 939BA1, 2980B9, 1ABC9C,"
//					  					+ "D68ECC, 5D6D7E, 7FB3D5, 2CA8B5, EACCE8,"
//					 		 			+ "7C7782, D6EAF8, 78CAD1, 91278F, E2E2E2,"
//					 		 			+ "21618C, B1EDF2, 884EA0, CACACC, 3498DB,"
//					 		 			+ "B3E5E5, D6C5E8, 566573, 5499C7, 7DCEA0,"
//					 		 			+ "C39BD3, 797D7F, 1B4F72, 229954, BB8FCE,"
//					 		 			+ "B2BABB");
//			     model.setExtender("chartExtender");
//			     model.setAnimate(true);
//			     barModel = model;
//			    
//				barModel.setTitle("Grafica Bancaria");
//				barModel.setMouseoverHighlight(false);
//		        barModel.setShowDatatip(true);
//		        barModel.setAnimate(true);
//		        barModel.setBarMargin(5);
//		        barModel.setZoom(false);
//
//
//				Axis xAxis = barModel.getAxis(AxisType.X);
//				xAxis.setLabel("DIA");
//				xAxis.setMin(0);
//				xAxis.setMax(10);
//
//				Axis yAxis = barModel.getAxis(AxisType.Y);
//				yAxis.setLabel("RECUPERACION");
//				yAxis.setMin(0);
//				yAxis.setMax(numeroMayor + 5);
//				
//				} else {
//					ChartSeries sms  = new ChartSeries("Sin Datos");
//					sms.set("No existen datos", 0);
//			        barModel.addSeries(sms);
//
//					barModel.setTitle("Grafica Bancaria");
//					barModel.setMouseoverHighlight(false);
//					Axis xAxis = barModel.getAxis(AxisType.X);
//					xAxis.setLabel("DIA");
//
//					Axis yAxis = barModel.getAxis(AxisType.Y);
//					yAxis.setLabel("RECUPERACION");
//					yAxis.setMin(0);
//					yAxis.setMax(numeroMayor + 5);
//				}
//				
//			} catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
//				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getGrafica");
//				} catch (PersistenceException e) {
//					this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getGrafica");
//					} catch (NumberFormatException e) {
//						this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getGrafica");
//					}
//			}
//		
//
//
//		public void actualizarGrafica() {
//			if((this.getTxtFechaInicio() != null)
//					&& (this.getTxtFechaFin() != null)
//					&& ((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) > (JMUtileriaFecha.TIEMPO_1_DIA * 31))) {
//						this.ponerMensajeAdvertencia("Los fechas estan limitado a 31 días naturales.");
//						return;
//					}
//			try {
//				this.actualizarListado();
//				this.createBarModels();
//			}catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
//				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getActualizarDatos");
//			} catch (PersistenceException e) {
//				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getActualizarDatos");
//			}
//		}
//		
//		public String getFecha(Object obj) {
//				String str = null;
//				str = Objects.toString(obj, "");
//		        str = StringUtils.replace(str, " 00:00:00.0", "");
//		        str = StringUtils.replace(str, " 00:00:00", "");
//		        str = JMUtileriaString.quitarNoJavascript(str);
//		        return str;
//		}

	
	// **************************************************************//
	// Getter y Setter - Objeto BM
	// **************************************************************//

	@Override
	public Transaccion getObjetoABM() {
		return super.getObjetoABM();
	}

	// **************************************************************//
	// Getter y Setter
	// **************************************************************//

	/**
	 * Feb 26, 2011 7:34:25 PM
	 * 
	 * @return the txtNumeroReporte
	 */
	public String getTxtNumeroReporte() {
		return this.txtNumeroReporte;
	}

	/**
	 * Feb 26, 2011 7:34:25 PM
	 * 
	 * @param txtNumeroReporte
	 *            the txtNumeroReporte to set
	 */
	public void setTxtNumeroReporte(final String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}

	public String get_idEstado() {
		return _idEstado;
	}

	public void set_idEstado(String _idEstado) {
		this._idEstado = _idEstado;
	}

	public String get_idBase() {
		return _idBase;
	}

	public void set_idBase(String _idBase) {
		this._idBase = _idBase;
	}

	public String get_idTerminal() {
		return _idTerminal;
	}

	public void set_idTerminal(String _idTerminal) {
		this._idTerminal = _idTerminal;
	}

	public String getEdoTransaccion() {
		return edoTransaccion;
	}

	public void setEdoTransaccion(String edoTransaccion) {
		this.edoTransaccion = edoTransaccion;
	}

	

}
