package com.aaq.col.system.beans.aplicacion.siica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;

import com.aaq.col.clases.database.entidades.MensajeSms;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.GenericoEnviarSMS;
import com.aaq.col.clases.util.JMUtileriaNotificacion;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;

@ManagedBean(name = "beanAplicacionSMS")
@ViewScoped
public class JMBeanAplicacionSMS extends JMBeanExtensiblePrincipal<MensajeSms> {
	private static final long serialVersionUID = 302465396944087152L;
	private String txtNumeroOriginal;
	private String txtNumeroDestino;
	private String txtMensaje;
	private String txtNumeroReporte;
	private String _idBaseFrecuencia;
	private String txtOpcion; 
	private String txtAsunto;
	private String txtCorreo;
	private boolean mostrar;
	private boolean permisoSMS;
	private boolean permisoPUSH;
	private boolean permisoCorreo;
	private int txtMaxLength;
	private final TerminalServiceInterfase terminalDao = Terminal.getTerminalService();
	private GenericoEnviarSMS genericoEnviarSMS = new GenericoEnviarSMS();

	public JMBeanAplicacionSMS() {
		super();

		try {
			this.txtNumeroOriginal = this.getConfiguracionService().obtenerCadena(
					JMConstantes.CONFIGURACION_SMS_SOCKET_NUMERO_TELEFONICO_ORIGEN_PARA_AJUSTADORES);
			this.permisoSMS = this.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_NOTIFICACIONES_PERMISO_SMS);
			this.permisoPUSH = this.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_NOTIFICACIONES_PERMISO_PUSH);
			this.permisoCorreo = this.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_NOTIFICACIONES_PERMISO_CORREO);
			this.txtMaxLength = this.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_NOTIFICACIONES_TAMANO_SMS);
			//this.getEstadoFrecuencia();
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "constructor");
		}
 		/*if ((JMBeanExtensiblePrincipal.getSpringSocketSMS() == null)
				|| !JMBeanExtensiblePrincipal.getSpringSocketSMS().getEstaConectado()) {
			this.ponerMensajeAdvertencia("El Socket de SMS no se encuentra conectado. Los mensajes no llegaran a su destino");
		}*/
	}

	public void actualizarFormulario(){
		if (this.getTxtOpcion().equals("3")){
			this.mostrar = true;
		}else{
			this.mostrar = false;
		}
	}
	
	@Override
	public void actualizarListado() {

	}


	@SuppressWarnings("unused")
	public void doAccionEnviarSMS(final ActionEvent e)  {
		final ArrayList<String> listaTelefono = new ArrayList<>();
		List <Terminal> listaCorreo = new ArrayList<>();
		List <Terminal> listaTerminalUID = new ArrayList<>();
		
		//Validar Opción de envío
		if(this.getTxtOpcion().equals("0")){
			this.ponerMensajeError("Error: No has seleccionado el tipo de Notificación.");
			return;
		}

		if (this.getTxtOpcion().equals("1")){
			// Validar telefono de destino
			if (StringUtils.length(this.getTxtNumeroDestino()) > 1) {
//				if (StringUtils.length(this.getTxtNumeroDestino()) == 10) {
				if (StringUtils.length(this.getTxtNumeroDestino()) > 8) { // Para Peru

					listaTelefono.add(this.getTxtNumeroDestino());
				} else {
					this.ponerMensajeAdvertencia("El numero de destino " + this.getTxtNumeroDestino()
							+ " no es de 10 digitos");
					return;
				}
			}
			
		}
		
		if (this.getTxtOpcion().equals("2") || this.getTxtOpcion().equals("1")){
			
			// validar ni texto ni reporte
			if ( StringUtils.isBlank(this.getTxtMensaje()) && StringUtils.isBlank(this.getTxtNumeroReporte())) {
				this.ponerMensajeError("ERROR: Debe capturar un numero de reporte o un texto libre para enviar una Notificación");
				return;
			}
			
			// validar texto y reporte al mismo tiempo
			if (StringUtils.isNotBlank(this.getTxtNumeroReporte()) && StringUtils.isNotBlank(this.getTxtMensaje())) {
				this.ponerMensajeError("ERROR: Debe elegir un numero de reporte o un texto libre para enviar una Notificación, pero NO ambos");
				return;
			}

			// validar texto libre
			if (StringUtils.length(this.getTxtMensaje()) > this.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_NOTIFICACIONES_TAMANO_SMS)) {
				this.ponerMensajeError("ERROR: El texto libre tiene un maximo de"+ this.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_NOTIFICACIONES_TAMANO_SMS) + "caracteres. Este mensaje tiene:"
						+ this.txtMensaje.length());
				return;
			}
		}
		
		if(this.getTxtOpcion().equals("3")){
			//validar asunto
			if(!StringUtils.isNotBlank(this.getTxtAsunto())){
				this.ponerMensajeError("Error: El correo debe llevar un Asunto.");
				return;
			}
			//validar cuerpo del correo
			if(!StringUtils.isNotBlank(this.getTxtCorreo())){
				this.ponerMensajeError("Error: No puedes enviar un correo vacio");
				return;
			}
		}
		
		
		// Validar base
		if (StringUtils.isNotBlank(this.getIdBase()) && StringUtils.isBlank(this.getIdTerminal())
				&& StringUtils.isBlank(this.getTxtNumeroDestino())) {
			
			if(!this.getPermisoTodosBases()&& !this.getPermisoTodosEstados()){
				for(final Terminal terminalFre : this.getObtenerTerminalFrecuencia()){
					if (StringUtils.length(terminalFre.getTelefono()) == 10) {
						listaTelefono.add(terminalFre.getTelefono());
					}
					if(StringUtils.isNotBlank(terminalFre.getCorreoElectronico())){
						listaCorreo.add(terminalFre);
					}
				}
				listaTerminalUID = this.getObtenerTerminalFrecuencia();
			}else{
				for (final Terminal terminal : this.getListaDeTerminalesParaSeleccion()) {
					if (StringUtils.length(terminal.getTelefono()) == 10) {
						listaTelefono.add(terminal.getTelefono());
					}
					if(StringUtils.isNotBlank(terminal.getCorreoElectronico())){
						listaCorreo.add(terminal);
					}
				}
				listaTerminalUID = this.getListaDeTerminalesParaSeleccion();
			}
		}
		
		

		// Validar terminal
		if (StringUtils.isNotBlank(this.getIdTerminal())) {
			Terminal t = null;
			try {
					t = this.getTerminalService().objetoTerminal(this.getIdTerminal());
				} catch (final Exception ex) {
					this.getUtileriaExcepcion()
							.manejarExcepcion(ex, this.getClass(), "doAccionEnviarSMS => ObjetoTerminal");
				}
			
			switch (this.getTxtOpcion()) {
			case "1":
				if ((t != null) && (StringUtils.length(t.getTelefono()) == 10)) {
					listaTelefono.add(t.getTelefono());
				} else {
					this.ponerMensajeError("La terminal " + t + " no tiene telefono de 10 digitos");
					return;
				}
				break;
				
			case "2":
				if ((t != null) && (StringUtils.isNotEmpty(t.getAndroidUid())) ){
					listaTerminalUID.add(t);
				}else{
					this.ponerMensajeError("La terminal "+ t + " no tiene U ID Androd");
					return;
				}
				break;
				
			case "3":
				if((t != null)&& (StringUtils.isNotEmpty(t.getCorreoElectronico()))){
					listaCorreo.add(t);
				}else{
					this.ponerMensajeError("La terminal " + t + " no tiene correo electronico");
				}
			}
		}

		
		
		ArrayList<String> listaMensaje = new ArrayList<>();

		// Mensaje de texto libre
		if (StringUtils.isNotBlank(this.getTxtMensaje())) {
			listaMensaje = JMUtileriaString.romperString(this.getTxtMensaje(), this.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_NOTIFICACIONES_TAMANO_SMS));
		}

		// Mensaje de Poliza
		if (StringUtils.isNotBlank(this.getTxtNumeroReporte())) {
//			final JMSISEWebServiceConsultaPort clienteWS = new JMSISEWebServiceConsultaPort();
			try {
//				final JMWSPoliza poliza = clienteWS.obtenerPolizaParaReporte(this.getTxtNumeroReporte());

//				final StringBuilder mensaje = new StringBuilder("Reporte: " + poliza.getNumReporte() + " Poliza: "
//						+ poliza.getNumPoliza());
//				mensaje.append("Asegurado: " + poliza.getNombreAseg() + " Vehiculo: " + poliza.getDatosVehiculo());
//				mensaje.append("Ubica: " + poliza.getDatosUbicacion());				
//				listaMensaje = JMUtileriaString.romperString(Objects.toString(mensaje, ""), this.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_NOTIFICACIONES_TAMANO_SMS));

			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionEnviarSMS");
				this.ponerMensajeError("ERROR: No fue posible obtener este reporte desde el SISE. Detalle: "
						+ ex.getMessage());
				return;
			}
		}

		if (listaTelefono.size() == 0 && this.getTxtOpcion().equals("1")) {
			this.ponerMensajeError("La lista de telefonos de destino no contiene telefonos de 10 digitos");
			return;
		}
		if (listaMensaje.size() == 0 && ( this.getTxtOpcion().equals("1") || this.getTxtOpcion().equals("2") )) {
			this.ponerMensajeError("El mensaje de envio no contiene informacion");
			return;
		}
		if(listaTerminalUID.size() == 0 && this.getTxtOpcion().equals("2")){
			this.ponerMensajeError("La lista de Uid Android de destino esta vacia.");
			return;
		}

		switch (this.getTxtOpcion()) {
		case "1":
			if(this.permisoSMS){
				for (final String telefono : listaTelefono) {
					
//					if (StringUtils.isNotBlank(txtMensaje) && (StringUtils.length(telefono) == 10)) {
					if (StringUtils.isNotBlank(txtMensaje) && (StringUtils.length(telefono) > 8)) { // Peru

						final ArrayList<String> listaMensajes = JMUtileriaString.romperString(txtMensaje, this.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_NOTIFICACIONES_TAMANO_SMS));
						final MensajeSms mensajeSMS = new MensajeSms();
						
						for (final String texto : listaMensajes) {
							try {
								mensajeSMS.setFecha(new Date());
								mensajeSMS.setMensajeoriginal(txtMensaje);
								mensajeSMS.setTelefonodestino(telefono);
								mensajeSMS.setTexto(texto);
								mensajeSMS.setTerminal(this.terminalDao.objetoTerminalParaNumeroTelefono(telefono));
								mensajeSMS.setUsuario(this.getUsuarioActual());
								mensajeSMS.setDireccionIp(this.obtenerDireccionIp());
								
								if(genericoEnviarSMS.enviarSMS(telefono, texto)){
									mensajeSMS.guardarObjeto();
									this.ponerMensajeInfo("Mensaje al telefono: " + telefono + " enviado OK");
								}else{
									this.ponerMensajeAdvertencia("Mensaje al telefono: " + telefono + " NO enviado");
								}
								
							} catch (Exception ex) {
								this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionEnviarSMS");
								this.ponerMensajeError("No se pueden enviar SMS en este momento. Intentolo más tarde.");
							}
						}
					}else{
						this.ponerMensajeAdvertencia("Mensaje al telefono: " + telefono + " NO enviado");
					}
				}
			}else{
				this.ponerMensajeError("No se pueden enviar SMS en este momento. Intentolo más tarde.");
				return;
			}
		break;
			
		case "2":
			if(this.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_NOTIFICACIONES_PERMISO_PUSH)){
				String textoCompleto = new String();
				for (final Terminal terminal : listaTerminalUID) {
					if (StringUtils.isNotBlank(txtMensaje) || StringUtils.isNotBlank(txtNumeroReporte)) {
						
						if(StringUtils.isNotBlank(txtMensaje)){
							final ArrayList<String> listaMensajes = JMUtileriaString.romperString(txtMensaje, this.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_NOTIFICACIONES_TAMANO_PUSH));
							textoCompleto = txtMensaje;
						}else{
							final ArrayList<String> listaMensajes = JMUtileriaString.romperString(txtNumeroReporte, this.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_NOTIFICACIONES_TAMANO_PUSH));
							textoCompleto = txtNumeroReporte;
						}
						
						
						final ArrayList<String> listaMensajes = JMUtileriaString.romperString(txtMensaje, this.getConfiguracionService().obtenerEntero(JMConstantes.CONFIGURACION_NOTIFICACIONES_TAMANO_PUSH));
						final MensajeSms mensajeSMS = new MensajeSms();
						
						for (final String texto : listaMensajes) {
							try {
								mensajeSMS.setFecha(new Date());
								mensajeSMS.setMensajeoriginal(textoCompleto);
								mensajeSMS.setTexto(texto);
								mensajeSMS.setTerminal(this.terminalDao.objetoTerminalParaNumeroTelefono(terminal.getTelefono()));
								mensajeSMS.setUsuario(this.getUsuarioActual());
								mensajeSMS.setDireccionIp(this.obtenerDireccionIp());
								mensajeSMS.setUid_android(terminal.getAndroidUid());
								
								if(genericoEnviarSMS.enviarPushNotificacion(terminal, textoCompleto)){
									mensajeSMS.guardarObjeto();
									this.ponerMensajeInfo("Mensaje Push enviado correctamente");
								}else{
									this.ponerMensajeAdvertencia("Mensaje al UID_Android: " + terminal.getAndroidUid() + " NO enviado");
								}
								
							} catch (Exception ex) {
								this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionEnviarSMS");
							}
						}
					}else{
						this.ponerMensajeAdvertencia("Mensaje al UId Android: " + terminal.getAndroidUid() + " NO enviado");
					}
				}
			}else{
				this.ponerMensajeError("No se pueden enviar PUSH en este momento. Intentalo más tarde.");
				return;
			}
		break;
		case "3":
			
			if(this.getConfiguracionService().obtenerBooleano(JMConstantes.CONFIGURACION_NOTIFICACIONES_PERMISO_CORREO)){
				ArrayList<String> listado = new ArrayList<>();
				
				for(final Terminal terminal : listaCorreo){
					listado.add(terminal.getCorreoElectronico());
				}
				try{
					new JMUtileriaNotificacion().enviarEmailSimple(listado, this.getTxtAsunto(), this.getTxtCorreo());
				}catch (Exception ex){
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionEnviarSMS");
				}
			}else{
				this.ponerMensajeError("No se pueden enviar Correos en este momento. Intentalo más tarde.");
				return;
			}
		break;
		}

	}
	
	public void onSelectEdoListener() {	
		setIdBase("0");
	}
	// **************************************************************//
	// Permisos
	// **************************************************************//
	/**
	 * @return el permiso
	 */

	public boolean getPermisoTodosEstados() {
		return this
				.getTienePermisoParaModulos("/SIICAGlobal/todosLosEstados.siica");

	}

	public boolean getPermisoTodosBases() {
		return this
				.getTienePermisoParaModulos("/SIICAGlobal/todasLasBases.siica");
	}


	// **************************************************************//
	// Getters y setters
	// **************************************************************//

	public boolean isPermisoSMS() {
		return permisoSMS;
	}

	public void setPermisoSMS(boolean permisoSMS) {
		this.permisoSMS = permisoSMS;
	}

	public boolean isPermisoPUSH() {
		return permisoPUSH;
	}

	public void setPermisoPUSH(boolean permisoPUSH) {
		this.permisoPUSH = permisoPUSH;
	}

	public boolean isPermisoCorreo() {
		return permisoCorreo;
	}

	public void setPermisoCorreo(boolean permisoCorreo) {
		this.permisoCorreo = permisoCorreo;
	}
	
	public String getTxtOpcion() {
		return this.txtOpcion;
	}

	public void setTxtOpcion(String txtOpcion) {
		this.txtOpcion = txtOpcion;
	}

	/**
	 * Metodo getter accesorio para el campo txtNumeroOriginal Apr 14, 2008
	 * 1:52:16 AM
	 * 
	 * @return retorna el campo txtNumeroOriginal
	 */
	public String getTxtNumeroOriginal() {
		return this.txtNumeroOriginal;
	}

	/**
	 * Metodo setter accesorio para el campo txtNumeroOriginal Apr 14, 2008
	 * 1:52:16 AM
	 * 
	 * @param txtNumeroOriginal
	 *            el txtNumeroOriginal para realizar un set
	 */
	public void setTxtNumeroOriginal(final String txtNumeroOriginal) {
		this.txtNumeroOriginal = txtNumeroOriginal;
	}

	/**
	 * Metodo getter accesorio para el campo txtNumeroDestino Apr 14, 2008
	 * 1:52:16 AM
	 * 
	 * @return retorna el campo txtNumeroDestino
	 */
	public String getTxtNumeroDestino() {
		return this.txtNumeroDestino;
	}

	/**
	 * Metodo setter accesorio para el campo txtNumeroDestino Apr 14, 2008
	 * 1:52:16 AM
	 * 
	 * @param txtNumeroDestino
	 *            el txtNumeroDestino para realizar un set
	 */
	public void setTxtNumeroDestino(final String txtNumeroDestino) {
		this.txtNumeroDestino = txtNumeroDestino;
	}

	/**
	 * Metodo getter accesorio para el campo txtMensaje Apr 14, 2008 1:52:16 AM
	 * Jose Miguel
	 * 
	 * @return retorna el campo txtMensaje
	 */
	public String getTxtMensaje() {
		return this.txtMensaje;
	}

	/**
	 * Metodo setter accesorio para el campo txtMensaje Apr 14, 2008 1:52:16 AM
	 * Jose Miguel
	 * 
	 * @param txtMensaje
	 *            el txtMensaje para realizar un set
	 */
	public void setTxtMensaje(final String txtMensaje) {
		this.txtMensaje = txtMensaje;
	}

	/**
	 * Metodo getter accesorio para el campo txtNumeroReporte Apr 14, 2008
	 * 1:52:16 AM
	 * 
	 * @return retorna el campo txtNumeroReporte
	 */
	public String getTxtNumeroReporte() {
		return this.txtNumeroReporte;
	}

	/**
	 * Metodo setter accesorio para el campo txtNumeroReporte Apr 14, 2008
	 * 1:52:16 AM
	 * 
	 * @param txtNumeroReporte
	 *            el txtNumeroReporte para realizar un set
	 */
	public void setTxtNumeroReporte(final String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}

	/**
	 * May 14, 2014 4:55:20 PM
	 * 
	 * @return the _idBaseFrecuencia
	 */
	public String get_idBaseFrecuencia() {
		return this._idBaseFrecuencia;
	}

	/**
	 * May 14, 2014 4:55:20 PM
	 * 
	 * @param _idBaseFrecuencia
	 *            the _idBaseFrecuencia to set
	 */
	public void set_idBaseFrecuencia(final String _idBaseFrecuencia) {
		this._idBaseFrecuencia = _idBaseFrecuencia;
	}

	/**
	 * Feb 14, 2018 4:55:20 PM
	 * 
	 * @param _idBaseFrecuencia
	 *            the _idBaseFrecuencia to set
	 */
	
	public String getTxtAsunto() {
		return txtAsunto;
	}

	public void setTxtAsunto(String txtAsunto) {
		this.txtAsunto = txtAsunto;
	}

	public String getTxtCorreo() {
		return txtCorreo;
	}

	public void setTxtCorreo(String txtCorreo) {
		this.txtCorreo = txtCorreo;
	}

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	public int getTxtMaxLength() {
		return txtMaxLength;
	}

	public void setTxtMaxLength(int txtMaxLength) {
		this.txtMaxLength = txtMaxLength;
	}
}
