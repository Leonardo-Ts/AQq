package com.aaq.col.system.beans.aplicacion.alarma;

import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.Transaccion;
import com.aaq.col.clases.pojo.pagos.CargoAbierto;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.LinkDePago;
import com.aaq.col.clases.util.UtileriaNumerosLetras;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaRegex;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.validator.routines.EmailValidator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
//import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "beanAplicacionCobroWeb")
@SessionScoped
public class JMBeanAplicacionCobroWeb extends JMBeanExtensiblePrincipal<Terminal> {
	private static final long serialVersionUID = -7762883932296414941L;


	private String txtMonto;
	private String txtTipoDePagoSeleccionado;
	private String txtNumeroLetra;
//	private JMWSPoliza actualPoliza;
	private Transaccion actualTransaccion;
	private Terminal actualTerminal;
	private String txtClaveOficina;
	private String txtCoberturaAfectada;
	private Integer txtClaveAbogado;
	private Boolean abogado;
	
	// Variables para link de pago
	private String txtCorreo;
	private String txtCelular;
	private boolean deducible;
	private String txtSiniestro;
	private String txtMoneda;
	private String txtRazonSocial;
	private String txtCalle;
	private String txtNoExt;
	private String txtNoInt;
	private String txtColonia;
	private String txtDelPob;
	private String txtCp;
	private String txtEstado;
	private String txtDomicilioRef;
	private String txtRfc;
	private String estatus = null;

	public JMBeanAplicacionCobroWeb() {
		super();
		this.limpiarDatos();
	}

	@Override
	public void actualizarListado() {

	}

	public ArrayList<SelectItem> getListaCoberturaAfectada() {
		final ArrayList<SelectItem> lista = new ArrayList<>();
		if (estatus.equals("1")){
			lista.add(new SelectItem("RC Bienes", "RC Bienes"));
		}
//		if (this.getEsPaginaPD()) {
//			lista.add(new SelectItem("RC Bienes", "RC Bienes"));
//		}
//		if (this.getEsPaginaPR()) {
		if (estatus.equals("0")){
			lista.add(new SelectItem("Daños Materiales", "Daños Materiales"));
			lista.add(new SelectItem("Gastos Médicos","Gastos Médicos"));
			lista.add(new SelectItem("Daños Materiales Adaptaciones","Daños Materiales Adaptaciones"));
		}
//		}
		return lista;
	}
	
	public ArrayList<SelectItem> getListaAnoExpiracion() {
		final ArrayList<SelectItem> lista = new ArrayList<>();
		try {
				int anioActual = this.getActualYear();
				int anioOnce = anioActual + 11;
				for ( int i = anioActual ; i < anioOnce ; i ++) { // int i = this.getActualYear(); i < (this.getActualYear() + 11); i++
					final String valor = StringUtils.right(Integer.toString(i), 2);
					final String etiqueta = Integer.toString(i);
					lista.add(new SelectItem(valor, etiqueta));
				}
			
		} catch ( ClassCastException | NumberFormatException | IndexOutOfBoundsException e) {
		} catch ( IllegalArgumentException   e) {
		}
		return lista;
	}

	public boolean getEsPaginaPP() {
		return StringUtils.equals(this.getTxtTipoDePagoSeleccionado(), "P.P.");
	}

	public boolean getEsPaginaPD() {
		return StringUtils.equals(this.getTxtTipoDePagoSeleccionado(), "P.D.");
	}

	public boolean getEsPaginaPR() {
		return StringUtils.equals(this.getTxtTipoDePagoSeleccionado(), "P.R.");
	}

	public String doAccionCobroWeb() {
		this.limpiarDatos();

		Terminal terminal = null;
		try {
			terminal = this.getTerminalService().objetoTerminal(
					this.obtenerParametroDeRequest(JMConstantes.WEB_PARAMETRO_IDENTI));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionCobroWeb");
		}

		if (terminal != null) {
			this.setActualTerminal(terminal);
			return "cobroWeb";
		}

		return null;
	}
	
	public String doAccionCobroWebDeducible() {
		this.limpiarDatos();

		Terminal terminal = null;
		try {
			terminal = this.getTerminalService().objetoTerminal(
					this.obtenerParametroDeRequest(JMConstantes.WEB_PARAMETRO_IDENTI));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionCobroWeb");
		}

		if (terminal != null) {
			this.setActualTerminal(terminal);
			return "cobroWebDeducible";
		}

		return null;
	}

	public String doAccionRegresarAlarma() {
		this.limpiarDatos();
		this.setActualTerminal(null);
		return "alarma";
	}

	// Se limpin los datos
	private void limpiarDatos() {
		this.setPaso(1);
//		this.setActualPoliza(null);
		this.setActualTransaccion(null);
		this.setTxtClaveOficina(null);
		this.setTxtTipoDePagoSeleccionado("P.R.");
		this.setTxtTipoDePagoSeleccionado("P.D.");
		//Nuevo campo 
		this.setTxtTipoDePagoSeleccionado("P.P.");
		this.setTxtNumeroLetra(null);
		this.setTxtMonto(null);
		this.setTxtClaveOficina(null);
		this.setTxtCoberturaAfectada(null);
		this.setTxtClaveAbogado(null);
		this.setTxtCelular(null);
		this.setTxtCorreo(null);
		this.setTxtSiniestro(null);
		this.setTxtMoneda("MXN");
		this.setTxtRazonSocial(null);
		this.setTxtCalle(null);
		this.setTxtNoExt(null);
		this.setTxtNoInt(null);
		this.setTxtColonia(null);
		this.setTxtDelPob(null);
		this.setTxtCp(null);
		this.setTxtEstado(null);
		this.setTxtDomicilioRef(null);
		this.setTxtRfc(null);
	}


	public void doAccionPaginaConfirmar(final ActionEvent ev) {
		if (this.getActualTransaccion() != null) {
			this.ponerMensajeAdvertencia("La accion de F5, Recargar/Refresh y Atras/Back han sido deshabilitadas. Por favor ya no le pique");
			return;
		}

		if (this.getActualTerminal() == null) {
			this.ponerMensajeAdvertencia("La accion de F5, Recargar/Refresh y Atras/Back han sido deshabilitadas. Por favor ya no le pique");
			return;
		}

		if (StringUtils.isNotBlank(this.getTxtCelular())
				&& !JMUtileriaRegex.validarNumerosConMinimo(this.getTxtCelular(), 10)) {
			this.ponerMensajeError("ERROR: El numero de telefono celular debe ser de 10 digitos numericos sin 044.");
			return;
		}

		try {
			this.setTxtNumeroLetra(UtileriaNumerosLetras.toLetras(NumberUtils.toDouble(this.getTxtMonto()), this.getTxtMoneda()));

		} catch (final Exception e) {
			this.getUtileriaExcepcion().manejarExcepcion(
					e,
					this.getClass(),
					"doAccionPaginaConfirmar",
					"Celular -> " + this.txtCelular +  ", Correo -> " + this.txtCorreo +
					", Monto -> " + this.txtMonto);
			this.ponerMensajeError("Error al Generar Link de Pago:" + e.getMessage());

		}
		return;
	}

//	public void doAccionPonerMontoPorTipoDePago(final AjaxBehaviorEvent e) {
//
//			try {
//				if (this.getEsPaginaPD()) {
//					this.setActualPoliza(new JMSISEWebServiceConsultaPort().obtenerDeducibleParaReporte(this
//							.getActualTerminal().getReporteAtendiendo()));
//					if (this.getActualPoliza() != null) {
//						this.setTxtMonto(this.getActualPoliza().getMontoDeducibleRC().replaceAll(",", ""));
//					}
//				}
//			} catch (final Exception ex) {
//				final JMWSPoliza poliza = new JMWSPoliza();
//				this.setTxtMonto("0");
//				poliza.setCantRecibos("ERROR AL CONSULTAR EN SISE (" + ex.getMessage()
//						+ "), POR FAVOR CAPTURE MANUALMENTE COMO PAGO PR");
//				poliza.setNombreAseg("ERROR AL CONSULTAR EN SISE (" + ex.getMessage()
//						+ "), POR FAVOR CAPTURE MANUALMENTE COMO PAGO PR");
//				poliza.setNumPoliza("ERROR AL CONSULTAR EN SISE (" + ex.getMessage()
//						+ "), POR FAVOR CAPTURE MANUALMENTE COMO PAGO PR");
//				poliza.setMonto("ERROR AL CONSULTAR EN SISE (" + ex.getMessage()
//						+ "), POR FAVOR CAPTURE MANUALMENTE COMO PAGO PR");
//				poliza.setMontoDeducibleRC("ERROR AL CONSULTAR EN SISE (" + ex.getMessage()
//						+ "), POR FAVOR CAPTURE MANUALMENTE COMO PAGO PR");
//				this.ponerMensajeError("ERROR AL CONSULTAR EN SISE (" + ex.getMessage()
//						+ "), POR FAVOR CAPTURE MANUALMENTE COMO PAGO PR");
//				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionPonerMontoPorTipoDePago");
//
//				this.setActualPoliza(poliza);
//
//			}
//	}

	// **************************************************************//
	// Acciones Paso 3
	// **************************************************************//

	/**
	 * doAccionPaginaCobrar Apr 14, 2008 5:53:18 AM
	 * 
	 * @param ev
	 */
	public void doAccionPaginaCobrar(final ActionEvent ev) {
		try {
			
			if(this.getTxtCelular() != null && this.getTxtCorreo() != null) {
				if(!this.getTxtCelular().isEmpty() && !this.getTxtCorreo().isEmpty()) {				
					this.ponerMensajeAdvertencia("Solo se permite con número de teléfono ó correo.");
					return;
				}
				if(this.getTxtCelular().isEmpty()) this.setTxtCelular(null);
				if(this.getTxtCorreo().isEmpty())  this.setTxtCorreo(null); 
			}
			
			if (this.getTxtMonto() == null) {
				this.ponerMensajeAdvertencia("Es requerido ingresar monto a cobrar.");
				return;
			}
			
			if (this.getTxtMoneda() == null) {
				this.ponerMensajeAdvertencia("Es requerido ingresar el tipo de moneda.");
				return;
			}
			
			if (this.getTxtCorreo() != null) {
				 if ((StringUtils.length(this.getTxtCorreo()) > 0) && !EmailValidator.getInstance().isValid(this.getTxtCorreo() )) {
			        this.ponerMensajeAdvertencia("El formato correo electrónico es incorrecto.");
					return;
					}
			}
			
			if (this.getTxtCelular() != null) {
				if ( this.getTxtCelular().isEmpty()) {
					if ((StringUtils.length(this.getTxtCelular()) != 10)) {
				        this.ponerMensajeAdvertencia("El número telefónico es incorrecto.");
						return;
						}
				}
			}
			
			if (this.getTxtTipoDePagoSeleccionado() == null) {
				this.ponerMensajeAdvertencia("Es obligatorio Tipo de Cobro.");
				return;
			}
			
			if (this.getTxtTipoDePagoSeleccionado().contains("1000")) {
				this.ponerMensajeAdvertencia("Seleccione 'Tipo de Cobro'");
				return;
			}
			
			LinkDePago linkDeCaja = new LinkDePago();
			int abogadoC = 0;
			if (this.getTxtClaveAbogado() != null) {
				abogadoC = this.getTxtClaveAbogado();
			}
			// Validar que no haya un Link de Pago para este Reporte
			 Transaccion transaccionAct = this.getTransaccionService().objetoTransaccionReporteCobro(this.getActualTerminal().getReporteAtendiendo(), this.getTxtTipoDePagoSeleccionado(), JMConstantes.FUENTE_LINK_PAGO);
			if (transaccionAct != null) {
				if (transaccionAct.getTransaccionAprobada()) {
					this.ponerMensajeError("ERROR: El "+this.getActualTerminal().getReporteAtendiendo()+" ya cuenta con un link de pago.");
					return;
				}
			}	
			CargoAbierto datos = new CargoAbierto();
				datos.setReporte(this.getActualTerminal().getReporteAtendiendo());
				datos.setMonto(this.getTxtMonto());
				datos.setCorreo(this.getTxtCorreo());
				datos.setTelefono(this.getTxtCelular());
				datos.setSiniestro(this.getTxtSiniestro());
				if (this.getTxtCoberturaAfectada().contains("Bienes")) {
					datos.setCobertura("19"); // Mandar clave cobertura dependiendo la cobertura afectada
					datos.setDeducible( "1");
				}
				if (StringUtils.equalsIgnoreCase(this.getTxtCoberturaAfectada(), "Daños Materiales")) {
					datos.setCobertura("01"); // Mandar clave cobertura dependiendo la cobertura afectada
					datos.setDeducible( "0");
				}
				if (StringUtils.equalsIgnoreCase(this.getTxtCoberturaAfectada(), "Gastos Médicos")) {
					datos.setCobertura("04"); // Mandar clave cobertura dependiendo la cobertura afectada
					datos.setDeducible( "0");
				}
				if (StringUtils.equalsIgnoreCase(this.getTxtCoberturaAfectada(), "Daños Materiales Adaptaciones")) {
					datos.setCobertura("06"); // Mandar clave cobertura --> Daños Materiales Adaptaciones
					datos.setDeducible( "0");
				}
				
				datos.setMoneda(this.getTxtMoneda());
				datos.setClaveProveedor(this.getActualTerminal().getNumeroproveedor());
				datos.setRazonSocial(this.getTxtRazonSocial());
				datos.setCalle(this.getTxtCalle());
				datos.setNoExt(this.getTxtNoExt());
				datos.setNoInt(this.getTxtNoInt());
				datos.setColonia(this.getTxtColonia());
				datos.setDelPob(this.getTxtDelPob());
				datos.setCp(this.getTxtCp());
				datos.setEstado(this.getTxtEstado());
				datos.setDomicilioRef(this.getTxtDomicilioRef());
				datos.setRfc(this.getTxtRfc());
				datos.setTipoDeCobro(this.getTxtTipoDePagoSeleccionado());
				datos.setCoberturaAfectada(this.getTxtCoberturaAfectada().toUpperCase());
				datos.setTerminal(this.getActualTerminal());
				datos.setUsuario(this.getUsuarioActual());
				datos.setFuente("Cabina Nacional");
				datos.setOficina(this.getTxtClaveOficina());
				datos.setAbogado(abogadoC);
			
		    List<Object> respuesta = linkDeCaja.genLinkCaja(datos );

		   boolean envio = (boolean) respuesta.get(0);
		    if (envio) {
				this.ponerMensajeInfo((String)respuesta.get(1));
			} else {
				this.ponerMensajeError((String) respuesta.get(1));
			}
		    
			this.setPaso(3);

		} catch (final Exception ex) {
			this.ponerMensajeError("ERROR : " + ex.getMessage());
			this.getUtileriaExcepcion().manejarExcepcion(
					ex,
					this.getClass(),
					"doAccionPaginaCobrar",
					"Correo -> " + this.txtCorreo + ", Celular -> " + this.txtCelular + 
//					", Deducible -> " + this.txtDeducible + 
					", Monto -> " + this.txtMonto);

		}

	}

	public String doAccionVoucherPDF() {
		if (this.getActualTransaccion() != null) {
			try {

				this.enviarArchivoACliente(this.getActualTransaccion().getNumeroReporte() + ".pdf", this
						.getActualTransaccion().getVoucher());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionVoucherPDF");
			}

		}

		return null;
	}

	public void redirectDeducible() throws IOException {
	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    String urlDeducible = this.getConfiguracionService().obtenerCadena(JMConstantes.LINK_PAGO_URL_DEDUCIBLE);
	    externalContext.redirect(urlDeducible);
	}
	
	public void redirectPrima() throws IOException {
	    ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    String urlPrima = this.getConfiguracionService().obtenerCadena(JMConstantes.LINK_PAGO_URL_PRIMA);
	    externalContext.redirect(urlPrima);
	}
	
	
	public String getTxtMonto() {
		return this.txtMonto;
	}

	public void setTxtMonto(final String txtMonto) {
		this.txtMonto = txtMonto;
	}

	public Terminal getActualTerminal() {
		return this.actualTerminal;
	}

	public void setActualTerminal(final Terminal actualTerminal) {
		this.actualTerminal = actualTerminal;
	}

	public String getTxtTipoDePagoSeleccionado() {
		return this.txtTipoDePagoSeleccionado;
	}

	public void setTxtTipoDePagoSeleccionado(final String txtTipoDePagoSeleccionado) {
		if (StringUtils.isNotBlank(txtTipoDePagoSeleccionado)) {
			this.txtTipoDePagoSeleccionado = txtTipoDePagoSeleccionado;
		}
	}

//	public JMWSPoliza getActualPoliza() {
//		return this.actualPoliza;
//	}

//	public void setActualPoliza(final JMWSPoliza actualPoliza) {
//		this.actualPoliza = actualPoliza;
//	}

	public Transaccion getActualTransaccion() {
		return this.actualTransaccion;
	}

	/**
	 * Metodo setter accesorio para el campo actualTransaccion Apr 15, 2008
	 * 1:39:14 PM
	 * 
	 * @param actualTransaccion
	 *            el actualTransaccion para realizar un set
	 */
	public void setActualTransaccion(final Transaccion actualTransaccion) {
		this.actualTransaccion = actualTransaccion;
	}

	/**
	 * Metodo getter accesorio para el campo txtNumeroLetra Jun 7, 2008 3:18:05
	 * AM
	 * 
	 * @return retorna el campo txtNumeroLetra
	 */
	public String getTxtNumeroLetra() {
		return this.txtNumeroLetra;
	}

	/**
	 * Metodo setter accesorio para el campo txtNumeroLetra Jun 7, 2008 3:18:05
	 * AM
	 * 
	 * @param txtNumeroLetra
	 *            el txtNumeroLetra para realizar un set
	 */
	public void setTxtNumeroLetra(final String txtNumeroLetra) {
		this.txtNumeroLetra = txtNumeroLetra;
	}

	/**
	 * 10/07/2008 08:43:00
	 * 
	 * @return el campo de la variable txtTipoDeTarjeta
	 */
//	public String getTxtTipoDeTarjeta() {
//		return this.txtTipoDeTarjeta;
//	}
//
//	/**
//	 * 10/07/2008 08:43:00
//	 * 
//	 * @param txtTipoDeTarjeta
//	 *            el parametro para el campo txtTipoDeTarjeta
//	 */
//	public void setTxtTipoDeTarjeta(final String txtTipoDeTarjeta) {
//		if (StringUtils.isNotBlank(txtTipoDeTarjeta)) {
//			this.txtTipoDeTarjeta = txtTipoDeTarjeta;
//		}
//	}

	public String getTxtClaveOficina() {
		return this.txtClaveOficina;
	}

	public void setTxtClaveOficina(final String txtClaveOficina) {
		this.txtClaveOficina = txtClaveOficina;
	}

	public String getTxtCoberturaAfectada() {
		return this.txtCoberturaAfectada;
	}

	public void setTxtCoberturaAfectada(final String txtCoberturaAfectada) {
		this.txtCoberturaAfectada = txtCoberturaAfectada;
	}

	public Integer getTxtClaveAbogado() {
		return txtClaveAbogado;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	public void setTxtClaveAbogado(Integer txtClaveAbogado) {
		this.txtClaveAbogado = txtClaveAbogado;
	}

	public Boolean getAbogado() {
		return abogado;
	}

	public void setAbogado(Boolean abogado) {
		this.abogado = abogado;
	}

	public String getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(String txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public String getTxtCelular() {
		return txtCelular;
	}

	public void setTxtCelular(String txtCelular) {
		this.txtCelular = txtCelular;
	}

	public boolean isDeducible() {
		return deducible;
	}

	public void setDeducible(boolean deducible) {
		this.deducible = deducible;
	}

	public String getTxtSiniestro() {
		return txtSiniestro;
	}

	public void setTxtSiniestro(String txtSiniestro) {
		this.txtSiniestro = txtSiniestro;
	}

	public String getTxtMoneda() {
		return txtMoneda;
	}

	public void setTxtMoneda(String txtMoneda) {
		this.txtMoneda = txtMoneda;
	}

	public String getTxtRazonSocial() {
		return txtRazonSocial;
	}

	public void setTxtRazonSocial(String txtRazonSocial) {
		this.txtRazonSocial = txtRazonSocial;
	}

	public String getTxtCalle() {
		return txtCalle;
	}

	public void setTxtCalle(String txtCalle) {
		this.txtCalle = txtCalle;
	}

	public String getTxtNoExt() {
		return txtNoExt;
	}

	public void setTxtNoExt(String txtNoExt) {
		this.txtNoExt = txtNoExt;
	}

	public String getTxtNoInt() {
		return txtNoInt;
	}

	public void setTxtNoInt(String txtNoInt) {
		this.txtNoInt = txtNoInt;
	}

	public String getTxtColonia() {
		return txtColonia;
	}

	public void setTxtColonia(String txtColonia) {
		this.txtColonia = txtColonia;
	}

	public String getTxtDelPob() {
		return txtDelPob;
	}

	public void setTxtDelPob(String txtDelPob) {
		this.txtDelPob = txtDelPob;
	}

	public String getTxtCp() {
		return txtCp;
	}

	public void setTxtCp(String txtCp) {
		this.txtCp = txtCp;
	}

	public String getTxtEstado() {
		return txtEstado;
	}

	public void setTxtEstado(String txtEstado) {
		this.txtEstado = txtEstado;
	}

	public String getTxtDomicilioRef() {
		return txtDomicilioRef;
	}

	public void setTxtDomicilioRef(String txtDomicilioRef) {
		this.txtDomicilioRef = txtDomicilioRef;
	}

	public String getTxtRfc() {
		return txtRfc;
	}

	public void setTxtRfc(String txtRfc) {
		this.txtRfc = txtRfc;
	}

	

	
	
}
