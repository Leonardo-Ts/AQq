package com.aaq.col.system.beans.operacion;

import com.aaq.col.clases.database.entidades.TerminalReporte;
import com.aaq.col.clases.database.entidades.TerminalReporteDocumento;
import com.aaq.col.clases.database.entidades.TerminalReporteDocumentoTipo;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.PersistenceException;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

@ManagedBean(name = "beanOperacionControlDocumentacion")
@SessionScoped
public class JMBeanOperacionControlDocumentacion extends JMBeanExtensiblePrincipal<TerminalReporte> {
	private static final long serialVersionUID = -5264014076385540601L;

	// objetos db
	private TerminalReporte actualTerminalReporte;

	// cadenas string del componente
	private String nombreAjustador;

	// codigos de entidad y de municipio
	private String idCodigoEntidadSeleccionado;
	private String idCodigoMunicipioSeleccionado;
	private String idAseguradoraDamos;
	private String idAseguradoraRecibimos;
	private String idAseguradoraAmbos;
	private String txtBusquedaCodigoEntidad;
	private String txtBusquedaCodigoMunicipio;

	public JMBeanOperacionControlDocumentacion() {
		super();
		this.limpiarDatos(true);
	}

	@Override
	public void actualizarListado() {

	}

	private void limpiarDatos(final boolean todos) {
		this.setNombreAjustador(null);

		if (todos) {
			this.setActualTerminalReporte(new TerminalReporte());
			this.getActualTerminalReporte().setIdentificadorunico(
					(String) this.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_HASHCODE));
			this.getActualTerminalReporte().setTerminal(this.getTerminalActual());
			this.getActualTerminalReporte().setFecha(new Date());

			List<TerminalReporteDocumentoTipo> ldt = null;
			try {
				ldt = this.getTerminalReporteDocumentoTipoService().listaDeTerminalReporteDocumentoTipo();
			} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
//				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "limpiarDatos");
			}

			if (ldt != null) {
				for (final TerminalReporteDocumentoTipo documentoTipo : ldt) {
					final TerminalReporteDocumento reporteDoc = new TerminalReporteDocumento();
					reporteDoc.setTerminalReporte(this.getActualTerminalReporte());
					reporteDoc.setTerminalReporteDocumentoTipo(documentoTipo);
					reporteDoc.setValor(Boolean.FALSE);
					this.getActualTerminalReporte().getTerminalReporteDocumentos().add(reporteDoc);
				}

			}
		}
	}

	public String doAccionNuevoReporte() {
		this.limpiarDatos(true);
		return null;
	}

	public String doAccionTicketPDF() {
		Vector<TerminalReporte> listado = null;
		try {
			listado = (Vector<TerminalReporte>) this.getTerminalReporteService().listaDeTerminalReporte(null, null,
					null, null, null,
					Objects.toString(this.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_HASHCODE), ""), null,
					null, new Integer(3000));
		} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
//			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionTicketPDF");
		}

		if (listado != null) {
			return this.doReportePDF(listado, "ticket_de_operaciones");
		}
		return null;

	}

//	public void doAccionConsultarReporteSISE(final ActionEvent e) {
//		this.limpiarDatos(false);
//
//		// 1. validar ano
//		if (StringUtils.isBlank(this.getActualTerminalReporte().getAnio())) {
//			this.ponerMensajeError("ERROR: Es necesario capturar el anio del reporte");
//			return;
//		}
//
//		// 2. validar reporte o siniestro
//		if (StringUtils.isBlank(this.getActualTerminalReporte().getReporte())
//				&& StringUtils.isBlank(this.getActualTerminalReporte().getSiniestro())) {
//			this.ponerMensajeError("ERROR: Es necesario capturar el numero de reporte o el numero de siniestro");
//			return;
//		}
//
//		// 3. validar reporte y siniestro
//		if (StringUtils.isNotBlank(this.getActualTerminalReporte().getReporte())
//				&& StringUtils.isNotBlank(this.getActualTerminalReporte().getSiniestro())) {
//			this.ponerMensajeError("ERROR: Es necesario capturar el numero de reporte o un numero de siniestro, pero NO ambos");
//			return;
//		}
//
//		// 4. validar numero de reporte
//		if (StringUtils.isNotBlank(this.getActualTerminalReporte().getReporte())) {
//			this.getActualTerminalReporte().setReporte(
//					JMUtileriaString.rellenarConCaracter(this.getActualTerminalReporte().getReporte(), "0", 7));
//		}
//
//		// 5. validar numero de siniestro
//		if (StringUtils.isNotBlank(this.getActualTerminalReporte().getSiniestro())) {
//			this.getActualTerminalReporte().setSiniestro(
//					JMUtileriaString.rellenarConCaracter(this.getActualTerminalReporte().getSiniestro(), "0", 7));
//		}
//
//		// 7. validar reporte no capturado ya
//		List<TerminalReporte> lista = null;
//		try {
//			lista = this.getTerminalReporteService().listaDeTerminalReporte(null,
//					this.getActualTerminalReporte().getRamo(), this.getActualTerminalReporte().getAnio(),
//					this.getActualTerminalReporte().getReporte(), this.getActualTerminalReporte().getSiniestro(), null,
//					null, null, null);
//		} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionConsultarReporteSISE");
//		}
//		if ((lista != null) && (lista.size() > 0)) {
//			this.limpiarDatos(true);
//			this.ponerMensajeError("ERROR: Este reporte ya ha sido capturado con anterioridad. Intente con otro reporte.");
//			return;
//		}
//
//		// 8. verificar el reporte
//		final Reporte reporte = new Reporte();
//		reporte.setAnio(this.getActualTerminalReporte().getAnio());
//		reporte.setRamo(this.getActualTerminalReporte().getRamo());
//
//		// 8.1 por numero de reporte
//		if (StringUtils.isNotBlank(this.getActualTerminalReporte().getReporte())) {
//
//			reporte.setReporte(this.getActualTerminalReporte().getReporte());
//			reporte.setSiniestro("");
//
//			final String numrep = this.getActualTerminalReporte().getRamo() + this.getActualTerminalReporte().getAnio()
//					+ this.getActualTerminalReporte().getReporte();
//
//			// 8.1.1 poliza
//			try {
//				this.getActualTerminalReporte().setPoliza(
//						new JMSISEWebServiceConsultaPort().obtenerPolizaParaReporte(numrep));
//
//				if (this.getPolizaExiste() && (this.getActualTerminalReporte().getPoliza().getCodCausa() != null)) {
//					this.getActualTerminalReporte().setCatalogoCodigoDeCausa(
//							this.getCatalogoCodigoDeCausaService().objetoCatalogoCodigoDeCausaParaClave(
//									this.getActualTerminalReporte().getPoliza().getCodCausa()));
//				}
//			} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionConsultarReporteSISE",
////						"Reporte : " + this.getActualTerminalReporte());
//				this.ponerMensajeError("Error al consultar en SISE: " + ex.getMessage());
//
//			}
//
//			// 8.1.3 poliza
//			List<Transaccion> listaTransaccion = null;
//			try {
//				listaTransaccion = this.getTransaccionService().listaDeTransaccion(numrep, true);
//			} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
////						"doAccionConsultarReporteSISE => listaTransaccion");
//
//			}
//			if ((listaTransaccion != null) && (listaTransaccion.size() > 0)) {
//				this.getActualTerminalReporte().setTransaccion(listaTransaccion.get(0));
//			}
//		}
//
//		// 8.2 por numero de siniestro
//		if (StringUtils.isNotBlank(this.getActualTerminalReporte().getSiniestro())) {
//			reporte.setSiniestro(this.getActualTerminalReporte().getSiniestro());
//			reporte.setReporte("");
//		}
//
//		// 9 Ejecucion del WS
//		try {
//			this.getActualTerminalReporte().setResultado(
//					new Controldoc(new URL(this.getConfiguracionService().obtenerCadena(
//							JMConstantes.CONFIGURACION_WEBSERVICES_JAXB_CONTROL_DOCS_SERVICE_END_POINT)))
//							.getControlPort().consultaDoctos(reporte));
//
//			if (this.getResultadoExiste()) {
//				this.getActualTerminalReporte().setAjustadorOriginal(
//						this.getActualTerminalReporte().getResultado().getAjustador());
//				this.getActualTerminalReporte().setAjustadorNuevo(this.getTerminalActual().getNumeroproveedor());
//
//				// 9.1 validacion de ajustador
//				if (StringUtils.isNotBlank(this.getActualTerminalReporte().getResultado().getAjustador())) {
//
//					final Terminal termaju = this.getTerminalService().objetoTerminalParaProveedorYPasswd(
//							this.getActualTerminalReporte().getResultado().getAjustador(), null);
//					if (termaju != null) {
//						this.setNombreAjustador(termaju.getNombre());
//					}
//
//					final String ajustadorNow = this.getTerminalActual().getNumeroproveedor().replaceAll("0", "");
//					final String ajustadorThere = this.getActualTerminalReporte().getResultado().getAjustador()
//							.replaceAll("0", "");
//
//					if (!StringUtils.equals(ajustadorThere, ajustadorNow)) {
//						this.ponerMensajeAdvertencia("Este reporte esta asignado al ajustador "
//								+ this.getActualTerminalReporte().getResultado().getAjustador()
//								+ ". Si continua con la captura, este dato se sobre escribira en el SISE.");
//					}
//				}
//			} else {
//				this.ponerMensajeError("ERROR: Este reporte no fue localizado en el sistema de operaciones");
//			}
//		} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException | MalformedURLException ex) {
////			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionConsultarReporteSISE",
////					"Reporte : " + this.getActualTerminalReporte());
//
//			this.ponerMensajeError("ERROR: Error al consultar el reporte. Detalles: " + ex.getMessage());
//
//		}
//
//	}
//
//	public void doAccionCambiarValor(final ActionEvent e) {
//
//		final String id = this.obtenerParametroDeRequest(JMConstantes.WEB_PARAMETRO_IDENTI);
//
//		if (id != null) {
//			for (final TerminalReporteDocumento doc : this.getActualTerminalReporte().getTerminalReporteDocumentos()) {
//
//				if (doc != null) {
//					if (StringUtils.equals(doc.getTerminalReporteDocumentoTipo().getClave(), id)) {
//						if (doc.getValor() != null) {
//							if (BooleanUtils.isTrue(doc.getValor())) {
//								doc.setValor(Boolean.FALSE);
//							} else {
//								doc.setValor(Boolean.TRUE);
//							}
//						}
//						break;
//					}
//				}
//			}
//		}
//	}
//
//	public String doAccionConfirmarReporte() {
//
//		// 1. validar ano
//		if (StringUtils.isBlank(this.getActualTerminalReporte().getAnio())) {
//			this.ponerMensajeError("ERROR: Es necesario capturar el anio del reporte");
//			return null;
//		}
//
//		// 2. validar reporte o siniestro
//		if (StringUtils.isBlank(this.getActualTerminalReporte().getReporte())
//				&& StringUtils.isBlank(this.getActualTerminalReporte().getSiniestro())) {
//			this.ponerMensajeError("ERROR: Es necesario capturar el numero de reporte o el numero de siniestro");
//			return null;
//		}
//
//		// 3. validar reporte y siniestro
//		if (StringUtils.isNotBlank(this.getActualTerminalReporte().getReporte())
//				&& StringUtils.isNotBlank(this.getActualTerminalReporte().getSiniestro())) {
//			this.ponerMensajeError("ERROR: Es necesario capturar el numero de reporte o un numero de siniestro, pero NO ambos");
//			return null;
//		}
//
//		// 4. Validar reporte actual
//		if (!this.getReporteExiste()) {
//			this.ponerMensajeError("ERROR: El reporte actual no ha sido consultado en el SISE");
//			return null;
//		}
//
//		// 6. Validar Fecha
//		if (StringUtils.isNotBlank(this.getActualTerminalReporte().getDepositoFecha())) {
//			if (!JMUtileriaRegex.validarFechaDDMMAA(this.getActualTerminalReporte().getDepositoFecha())) {
//				this.ponerMensajeError("ERROR: Es necesario capturar la fecha en formato DIA/MES/ANIO (Ejemplo: 31/01/2008)");
//				return null;
//			}
//		}
//
//		// 7. validar banco
//		if (StringUtils.isBlank(this.getActualTerminalReporte().getDepositoFecha())
//				&& StringUtils.isBlank(this.getActualTerminalReporte().getDepositoHora())
//				&& StringUtils.isBlank(this.getActualTerminalReporte().getDepositoImporte())) {
//			this.getActualTerminalReporte().setDepositoBanco("");
//			this.getActualTerminalReporte().setDepositoTipoPago("");
//		}
//
//		// 7.1 sipac
//		if (StringUtils.isNotBlank(this.getIdAseguradoraDamos())) {
//			try {
//				this.getActualTerminalReporte().setCatalogoAseguradoraBySipacDimosId(
//						this.getCatalogoAseguradoraService().objetoCatalogoAseguradora(this.getIdAseguradoraDamos()));
//			} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
////						"doAccionConfirmarReporte => objetoCatalogoAseguradora");
//			}
//		}
//		if (StringUtils.isNotBlank(this.getIdAseguradoraRecibimos())) {
//			try {
//				this.getActualTerminalReporte().setCatalogoAseguradoraBySipacRecibimosId(
//						this.getCatalogoAseguradoraService()
//								.objetoCatalogoAseguradora(this.getIdAseguradoraRecibimos()));
//			} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
////						"doAccionConfirmarReporte => objetoCatalogoAseguradora");
//			}
//		}
//		if (StringUtils.isNotBlank(this.getIdAseguradoraAmbos())) {
//			try {
//				this.getActualTerminalReporte().setCatalogoAseguradoraBySipacAmbosId(
//						this.getCatalogoAseguradoraService().objetoCatalogoAseguradora(this.getIdAseguradoraAmbos()));
//			} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
////						"doAccionConfirmarReporte => objetoCatalogoAseguradora");
//			}
//		}
//
//		// 8. validar si es reporte de robo
//		if ((this.getActualTerminalReporte().getPoliza() != null)
//				&& this.getActualTerminalReporte().getPoliza().getEsReporteDeRobo()) {
//
//			try {
//				this.getActualTerminalReporte().setCatalogoClaveDeEntidadByCodigoDeEntidad(
//						this.getCatalogoClaveDeEntidadService().objetoCatalogoClaveDeEntidad(
//								this.getIdCodigoEntidadSeleccionado()));
//			} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
////						"doAccionConfirmarReporte => objetoCatalogoClaveDeEntidad");
//			}
//
//			try {
//				this.getActualTerminalReporte().setCatalogoClaveDeEntidadByCodigoDeMunicipio(
//						this.getCatalogoClaveDeEntidadService().objetoCatalogoClaveDeEntidad(
//								this.getIdCodigoMunicipioSeleccionado()));
//			} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
////						"doAccionConfirmarReporte => objetoCatalogoClaveDeEntidad");
//			}
//
//			// 8.1 validar fecha de averiguacion
//			if (!JMUtileriaRegex.validarFechaDDMMAAAA(this.getActualTerminalReporte().getAveriguacionPreviaFecha())) {
//				this.ponerMensajeError("ERROR: Es necesario capturar la fecha de Averiguacion Previa en formato DIA/MES/ANIO (Ejemplo: 31/01/2008)");
//				return null;
//			}
//
//			// 8.2 validar clave de entidad
//			if ((this.getActualTerminalReporte().getCatalogoClaveDeEntidadByCodigoDeEntidad() == null)) {
//				this.ponerMensajeError("ERROR: Es necesario capturar el numero la clave de entidad de entidad del reporte de robo");
//				return null;
//
//			}
//
//			// 8.3 validar codigo de municipio
//			if (this.getActualTerminalReporte().getCatalogoClaveDeEntidadByCodigoDeMunicipio() == null) {
//				this.ponerMensajeError("ERROR: Es necesario capturar la clave de entidad de municipio del reporte de robo");
//				return null;
//
//			}
//
//			// 8.4 validar fecha de averiguacion previa
//			if (StringUtils.isBlank(this.getActualTerminalReporte().getAveriguacionPreviaFecha())) {
//
//				this.ponerMensajeError("ERROR: Es necesario capturar la fecha de averiguacion previa del reporte de robo");
//				return null;
//			}
//
//			// 8.5 validar numero de averiguacion previa
//			if (StringUtils.isBlank(this.getActualTerminalReporte().getAveriguacionPreviaNumero())) {
//
//				this.ponerMensajeError("ERROR: Es necesario capturar el numero de averiguacion previa del reporte de robo");
//				return null;
//			}
//		}
//
//		return "documentacionConfirmacion";
//	}
//
//	public void doAccionGuardarReporte(final ActionEvent ev) {
//
//		// 1. validar ano
//		if (StringUtils.isBlank(this.getActualTerminalReporte().getAnio())) {
//			this.ponerMensajeError("ERROR: Es necesario capturar el año del reporte");
//			return;
//		}
//
//		// 2. validar reporte o siniestro
//		if (StringUtils.isBlank(this.getActualTerminalReporte().getReporte())
//				&& StringUtils.isBlank(this.getActualTerminalReporte().getSiniestro())) {
//			this.ponerMensajeError("ERROR: Es necesario capturar el numero de reporte o el numero de siniestro");
//			return;
//		}
//
//		// 3. validar reporte y siniestro
//		if (StringUtils.isNotBlank(this.getActualTerminalReporte().getReporte())
//				&& StringUtils.isNotBlank(this.getActualTerminalReporte().getSiniestro())) {
//			this.ponerMensajeError("ERROR: Es necesario capturar el numero de reporte o un numero de siniestro, pero NO ambos");
//			return;
//		}
//
//		// 4. Validar reporte actual
//		if (!this.getReporteExiste()) {
//			this.ponerMensajeError("ERROR: El reporte actual no ha sido consultado en el SISE");
//			return;
//		}
//
//		// 6. Validar Fecha
//		if (StringUtils.isNotBlank(this.getActualTerminalReporte().getDepositoFecha())) {
//			if (!JMUtileriaRegex.validarFechaDDMMAA(this.getActualTerminalReporte().getDepositoFecha())) {
//				this.ponerMensajeError("ERROR: Es necesario capturar la fecha en formato DIA/MES/ANIO (Ejemplo: 31/01/08)");
//				return;
//			}
//		}
//
//		// 7. validar banco
//		if (StringUtils.isBlank(this.getActualTerminalReporte().getDepositoFecha())
//				&& StringUtils.isBlank(this.getActualTerminalReporte().getDepositoHora())
//				&& StringUtils.isBlank(this.getActualTerminalReporte().getDepositoImporte())) {
//			this.getActualTerminalReporte().setDepositoBanco("");
//			this.getActualTerminalReporte().setDepositoTipoPago("");
//		}
//
//		// 8. validar si es reporte de robo
//		if ((this.getActualTerminalReporte().getPoliza() != null)
//				&& this.getActualTerminalReporte().getPoliza().getEsReporteDeRobo()) {
//
//			try {
//				this.getActualTerminalReporte().setCatalogoClaveDeEntidadByCodigoDeEntidad(
//						this.getCatalogoClaveDeEntidadService().objetoCatalogoClaveDeEntidad(
//								this.getIdCodigoEntidadSeleccionado()));
//				this.getActualTerminalReporte().setCatalogoClaveDeEntidadByCodigoDeMunicipio(
//						this.getCatalogoClaveDeEntidadService().objetoCatalogoClaveDeEntidad(
//								this.getIdCodigoMunicipioSeleccionado()));
//			} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
////						"doAccionGuardarReporte => objetoCatalogoClaveDeEntidad");
//			}
//
//			// 8.1 validar fecha de averiguacion
//			if (!JMUtileriaRegex.validarFechaDDMMAAAA(this.getActualTerminalReporte().getAveriguacionPreviaFecha())) {
//				this.ponerMensajeError("ERROR: Es necesario capturar la fecha de Averiguacion Previa en formato DIA/MES/ANIO (Ejemplo: 31/01/2008)");
//				return;
//			}
//
//			// 8.2 validar clave de entidad
//			if ((this.getActualTerminalReporte().getCatalogoClaveDeEntidadByCodigoDeEntidad() == null)) {
//				this.ponerMensajeError("ERROR: Es necesario capturar el numero la clave de entidad de entidad del reporte de robo");
//				return;
//
//			}
//
//			// 8.3 validar codigo de municipio
//			if ((this.getActualTerminalReporte().getCatalogoClaveDeEntidadByCodigoDeMunicipio() == null)) {
//				this.ponerMensajeError("ERROR: Es necesario capturar la clave de entidad de municipio del reporte de robo");
//				return;
//
//			}
//
//			// 8.4 validar fecha de averiguacion previa
//			if (StringUtils.isBlank(this.getActualTerminalReporte().getAveriguacionPreviaFecha())) {
//
//				this.ponerMensajeError("ERROR: Es necesario capturar la fecha de averiguacion previa del reporte de robo");
//				return;
//			}
//
//			// 8.5 validar numero de averiguacion previa
//			if (StringUtils.isBlank(this.getActualTerminalReporte().getAveriguacionPreviaNumero())) {
//
//				this.ponerMensajeError("ERROR: Es necesario capturar el numero de averiguacion previa del reporte de robo");
//				return;
//			}
//		}
//
//		// 9 guardar reporte
//		final JMResultadoOperacion res = this.getActualTerminalReporte().guardarObjeto();
//
//		// 10.0 checar si se guardo bien el reporte
//		if (res.isExito()) {
//			// 10.1 guardar sus documentos
//			for (final TerminalReporteDocumento doc : this.getActualTerminalReporte().getTerminalReporteDocumentos()) {
//				doc.guardarObjeto();
//
//			}
//
//			// 10.2.1 WebService de Documentos - creacion
//			final InDocumento documento = new InDocumento();
//			final InDocumento.Reporte temprep = new InDocumento.Reporte();
//			temprep.setAnio(this.getActualTerminalReporte().getAnio());
//			temprep.setNumRepo(this.getActualTerminalReporte().getReporte());
//			temprep.setNumStro(this.getActualTerminalReporte().getSiniestro());
//			temprep.setRamo(this.getActualTerminalReporte().getRamo());
//
//			// 10.2.1.5 WebService de Documentos - sipac
//			final SIPAC sipac = new SIPAC();
//			sipac.setEsSipac(BooleanUtils.isTrue(this.getActualTerminalReporte().getSipacAplica()));
//			sipac.setDimos(BooleanUtils.isTrue(this.getActualTerminalReporte().getSipacDimos()));
//			sipac.setRecibimos(BooleanUtils.isTrue(this.getActualTerminalReporte().getSipacRecibimos()));
//
//			if (this.getActualTerminalReporte().getCatalogoAseguradoraBySipacDimosId() != null) {
//
//				sipac.setCodigoCiaDimos(this.getActualTerminalReporte().getCatalogoAseguradoraBySipacDimosId()
//						.getClave());
//			} else {
//
//				sipac.setCodigoCiaDimos("");
//			}
//
//			if (this.getActualTerminalReporte().getCatalogoAseguradoraBySipacRecibimosId() != null) {
//				sipac.setCodigoCiaRecibimos(this.getActualTerminalReporte().getCatalogoAseguradoraBySipacRecibimosId()
//						.getClave());
//
//			} else {
//				sipac.setCodigoCiaRecibimos("");
//
//			}
//
//			temprep.setSIPAC(sipac);
//
//			// 10.2.2 WebService de Documentos - lista de documentos
//			final Documentos listaDocumentos = new Documentos();
//			for (final TerminalReporteDocumento terminalDocumento : this.getActualTerminalReporte()
//					.getTerminalReporteDocumentos()) {
//				final Documento docto = new Documento();
//				docto.setId(terminalDocumento.getTerminalReporteDocumentoTipo().getClave());
//				docto.setValor(BooleanUtils.isTrue(terminalDocumento.getValor()));
//				listaDocumentos.getDocumento().add(docto);
//			}
//
//			// 10.2.3 Depositos
//			final Deposito tempdepo = new Deposito();
//			tempdepo.setFecha(this.getActualTerminalReporte().getDepositoFecha());
//			tempdepo.setFolio(this.getActualTerminalReporte().getDepositoFolio());
//			tempdepo.setHora(this.getActualTerminalReporte().getDepositoHora());
//			tempdepo.setMonto(this.getActualTerminalReporte().getDepositoImporte());
//			tempdepo.setTipoPago(this.getActualTerminalReporte().getDepositoTipoPago());
//
//			// 10.2.4 Transaccion bancaria
//			if (this.getTransaccionExiste()) {
//				tempdepo.setFecha(DateFormatUtils.format(new Date(this.getActualTerminalReporte().getTransaccion()
//						.getFecha().getTime()), "dd/MM/yyyy"));
//				tempdepo.setHora(DateFormatUtils.format(this.getActualTerminalReporte().getTransaccion().getFecha(),
//						"HH:mm"));
//				tempdepo.setFolio(this.getActualTerminalReporte().getTransaccion().getNumeroOperacion());
//				tempdepo.setMonto(this.getActualTerminalReporte().getTransaccion().getMonto());
//				tempdepo.setTipoPago(this.getActualTerminalReporte().getTransaccion().getTipoDeCobro());
//			}
//			documento.setDeposito(tempdepo);
//
//			// 10.2.5 Miscelaneos
//			documento.setReporte(temprep);
//
//			documento.setDocumentos(listaDocumentos);
//			documento.setFechaRecepcion(DateFormatUtils.format(new Date(), "dd/MM/yyyy"));
//			documento.setHoraRecepcion(DateFormatUtils.format(new Date(), "HH:mm"));
//
//			// 10.2.6 Ejecucion del WebService
//			try {
//				final ControlBindingPort port = new Controldoc(new URL(this.getConfiguracionService().obtenerCadena(
//						JMConstantes.CONFIGURACION_WEBSERVICES_JAXB_CONTROL_DOCS_SERVICE_END_POINT))).getControlPort();
//				port.actualizaDocto(documento);
//			} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException | MalformedURLException ex) {
//
////				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionGuardarReporte",
////						"Reporte : " + this.getActualTerminalReporte());
//
//				this.ponerMensajeError("Error al actualizar el reporte en el SISE. Por favor intentelo de nuevo. Detalles: "
//						+ ex.getMessage());
//				return;
//			}
//
//			// 10.3 WebService de Robos para REPUVE
//			if ((this.getActualTerminalReporte().getPoliza() != null)
//					&& this.getActualTerminalReporte().getPoliza().getEsReporteDeRobo()) {
//
//				// 10.3.1 WebService de Robos para REPUVE - Entrada
//				final Entrada repuve_entrada = new Entrada();
//				repuve_entrada.setCodEntidad(this.getActualTerminalReporte()
//						.getCatalogoClaveDeEntidadByCodigoDeEntidad().getClave());
//				repuve_entrada.setCodMunicipio(this.getActualTerminalReporte()
//						.getCatalogoClaveDeEntidadByCodigoDeMunicipio().getClave());
//				repuve_entrada.setNumAveriguacion(this.getActualTerminalReporte().getAveriguacionPreviaNumero());
//				repuve_entrada.setFecha(this.getActualTerminalReporte().getAveriguacionPreviaFecha());
//				repuve_entrada.setReporte(this.getActualTerminalReporte().getRamo()
//						+ this.getActualTerminalReporte().getAnio() + this.getActualTerminalReporte().getReporte());
//
//				// 10.3.2 WebService de Robos para REPUVE - Parametros
//				final GrabaRepuve parametros = new ObjectFactory().createGrabaRepuve();
//				GrabaRepuveResponse respuesta = null;
//				parametros.setEntrada(repuve_entrada);
//
//				// 10.3.4 WebService de Robos para REPUVE - Ejecucion
//				try {
//					final WSSiniestros_Service repuve_stub = new WSSiniestros_Service(new URL(this
//							.getConfiguracionService().obtenerCadena(
//									JMConstantes.CONFIGURACION_WEBSERVICES_JAXB_REPUVE_END_POINT)));
//					respuesta = repuve_stub.getWSSiniestros().grabaRepuve(parametros);
//
//				} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException | MalformedURLException ex) {
////					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionGuardarReporte",
////							"Reporte : " + this.getActualTerminalReporte());
//
//					this.ponerMensajeError("Error al actualizar el reporte en el SISE REPUVE. Por favor intentelo de nuevo. Detalles: "
//							+ ex.getMessage());
//					return;
//				}
//
//				// 10.3.5 WebService de Robos para REPUVE - Lectura de
//				// respuesta
//				if (respuesta != null) {
//					this.getActualTerminalReporte().setRepuveRespuestaDelWs("Resultado: " + respuesta.getResultado());
//
//					if (respuesta.getError() != null) {
//						this.getActualTerminalReporte().setRepuveRespuestaDelWs(
//								"Resultado: " + respuesta.getResultado() + " Clave: " + respuesta.getError().getClave()
//										+ ". Descripcion: " + respuesta.getError().getDescripcion() + " ");
//					}
//				}
//
//				this.getActualTerminalReporte().setRepuveFechaDeEnviado(new Date());
//
//				this.getActualTerminalReporte().guardarObjeto();
//
//			}
//		}
//
//		else {
//			this.ponerMensajeError("Error al intentar guardar en la base de datos. Detalles: " + res.getMensaje());
//			return;
//		}
//
//	}
//
//	// **************************************************************//
//	// Acciones de la pagina de resultado
//	// **************************************************************//
//	/**
//	 * doContinuar Mar 24, 2008 9:38:15 PM
//	 *
//	 * @return continuar
//	 */
//	@Override
//	public String doAccionContinuar() {
//		this.setActualTerminalReporte(null);
//		this.limpiarDatos(false);
//
//		return "documentacion";
//	}
//
//	// **************************************************************//
//	// Acciones con los componentes
//	// **************************************************************//
//
//	/**
//	 * @return el conteo de tickets
//	 */
//	public int getConteoDeTickets() {
//
//		if (StringUtils.isNotBlank(Objects.toString(
//				(this.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_HASHCODE)), ""))) {
//
//			List<TerminalReporte> listado = null;
//			try {
//				listado = this.getTerminalReporteService().listaDeTerminalReporte(null, null, null, null, null,
//						Objects.toString(this.obtenerObjetoDeSession(JMConstantes.SESSION_WEB_OBJETO_HASHCODE), ""),
//						null, null, new Integer(3000));
//			} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
////						"getConteoDeTickets => listaDeTerminalReporte");
//			}
//
//			return listado != null ? listado.size() : 0;
//		}
//		this.ponerMensajeError("Su sesion ha terminado. Por favor inicie sesion de nuevo");
//		return 0;
//
//	}
//
//	// **************************************************************//
//	// Acciones mayores de navegacion
//	// **************************************************************//
//
//	// **************************************************************//
//	// Listados del componente
//	// **************************************************************//
//
//	/**
//	 * @return la lista
//	 */
//	public List<CatalogoClaveDeEntidad> getListaDeCatalogoClaveDeEntidad() {
//		try {
//			return this.getCatalogoClaveDeEntidadService().listaDeCatalogoClaveDeEntidad(
//					this.getTxtBusquedaCodigoEntidad(), true);
//		} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
////					"getListaDeCatalogoClaveDeEntidad => listaDeCatalogoClaveDeEntidad");
//			return null;
//		}
//	}
//
//	/**
//	 * @return la lista
//	 */
//	public List<CatalogoClaveDeEntidad> getListaDeCatalogoClaveDeEntidadMunicipio() {
//		try {
//			return
//
//			this.getCatalogoClaveDeEntidadService().listaDeCatalogoClaveDeEntidad(this.getTxtBusquedaCodigoMunicipio(),
//					true);
//		} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
////					"getListaDeCatalogoClaveDeEntidadMunicipio => listaDeCatalogoClaveDeEntidad");
//			return null;
//		}
//	}
//
//	/**
//	 * @return la lista
//	 */
//	public List<CatalogoAseguradora> getListaDeCatalogoAseguradora() {
//		try {
//			return this.getCatalogoAseguradoraService().listaDeCatalogoAseguradora();
//		} catch (final IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException | IllegalAccessError | ClassCastException | PersistenceException ex) {
////			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeCatalogoAseguradora");
//			return null;
//		}
//
//	}

	// **************************************************************//
	// Propiedades booleanas del componente
	// **************************************************************//

	/**
	 * getReporteExiste Mar 24, 2008 8:04:16 PM
	 *
	 * @return si existe el reporte
	 */
	public boolean getReporteExiste() {
		return this.getActualTerminalReporte() != null;
	}

//	public boolean getPolizaExiste() {
//		return (this.getActualTerminalReporte() != null) && (this.getActualTerminalReporte().getPoliza() != null);
//	}

	public boolean getResultadoExiste() {
		return (this.getActualTerminalReporte() != null) && (this.getActualTerminalReporte().getResultado() != null);
	}

	/**
	 * getTransaccionExiste Mar 26, 2008 3:31:31 PM
	 *
	 * @return si existe transasccion
	 */
	public boolean getTransaccionExiste() {
		return (this.getActualTerminalReporte() != null) && (this.getActualTerminalReporte().getTransaccion() != null);
	}

	/**
	 * getGruaExiste Apr 1, 2008 5:37:45 PM
	 *
	 * @return si existe grua
	 */
	public boolean getGruaExiste() {
		return false;
	}

	// **************************************************************//
	// Getters y settes del componente
	// **************************************************************//

	/**
	 * Metodo getter accesorio para el campo actualTerminalReporte Mar 26, 2008
	 * 3:10:31 PM
	 *
	 * @return retorna el campo actualTerminalReporte
	 */
	public TerminalReporte getActualTerminalReporte() {
		return this.actualTerminalReporte;
	}

	/**
	 * Metodo setter accesorio para el campo actualTerminalReporte Mar 26, 2008
	 * 3:10:31 PM
	 *
	 * @param actualTerminalReporte
	 *            el actualTerminalReporte para realizar un set
	 */
	public void setActualTerminalReporte(final TerminalReporte actualTerminalReporte) {
		this.actualTerminalReporte = actualTerminalReporte;
	}

	/**
	 * Metodo getter accesorio para el campo nombreAjustador Mar 31, 2008
	 * 7:10:52 PM
	 *
	 * @return retorna el campo nombreAjustador
	 */
	public String getNombreAjustador() {
		return this.nombreAjustador;
	}

	/**
	 * Metodo setter accesorio para el campo nombreAjustador Mar 31, 2008
	 * 7:10:52 PM
	 *
	 * @param nombreAjustador
	 *            el nombreAjustador para realizar un set
	 */
	public void setNombreAjustador(final String nombreAjustador) {
		this.nombreAjustador = nombreAjustador;
	}

	/**
	 * Oct 15, 2008
	 *
	 * @return the idCodigoEntidadSeleccionado
	 */
	public String getIdCodigoEntidadSeleccionado() {
		return this.idCodigoEntidadSeleccionado;
	}

	/**
	 * Oct 15, 2008
	 *
	 * @param idCodigoEntidadSeleccionado
	 *            the idCodigoEntidadSeleccionado to set
	 */
	public void setIdCodigoEntidadSeleccionado(final String idCodigoEntidadSeleccionado) {
		this.idCodigoEntidadSeleccionado = idCodigoEntidadSeleccionado;
	}

	/**
	 * Oct 15, 2008
	 *
	 * @return the idCodigoMunicipioSeleccionado
	 */
	public String getIdCodigoMunicipioSeleccionado() {
		return this.idCodigoMunicipioSeleccionado;
	}

	/**
	 * Oct 15, 2008
	 *
	 * @param idCodigoMunicipioSeleccionado
	 *            the idCodigoMunicipioSeleccionado to set
	 */
	public void setIdCodigoMunicipioSeleccionado(final String idCodigoMunicipioSeleccionado) {
		this.idCodigoMunicipioSeleccionado = idCodigoMunicipioSeleccionado;
	}

	/**
	 * Oct 15, 2008
	 *
	 * @return the txtBusquedaCodigoEntidad
	 */
	public String getTxtBusquedaCodigoEntidad() {
		return this.txtBusquedaCodigoEntidad;
	}

	/**
	 * Oct 15, 2008
	 *
	 * @param txtBusquedaCodigoEntidad
	 *            the txtBusquedaCodigoEntidad to set
	 */
	public void setTxtBusquedaCodigoEntidad(final String txtBusquedaCodigoEntidad) {
		this.txtBusquedaCodigoEntidad = txtBusquedaCodigoEntidad;
	}

	/**
	 * Oct 15, 2008
	 *
	 * @return the txtBusquedaCodigoMunicipio
	 */
	public String getTxtBusquedaCodigoMunicipio() {
		return this.txtBusquedaCodigoMunicipio;
	}

	/**
	 * Oct 15, 2008
	 *
	 * @param txtBusquedaCodigoMunicipio
	 *            the txtBusquedaCodigoMunicipio to set
	 */
	public void setTxtBusquedaCodigoMunicipio(final String txtBusquedaCodigoMunicipio) {
		this.txtBusquedaCodigoMunicipio = txtBusquedaCodigoMunicipio;
	}

	/**
	 * @return the idAseguradoraDamos
	 */
	public String getIdAseguradoraDamos() {
		return this.idAseguradoraDamos;
	}

	/**
	 * @param idAseguradoraDamos
	 *            the idAseguradoraDamos to set
	 */
	public void setIdAseguradoraDamos(final String idAseguradoraDamos) {
		this.idAseguradoraDamos = idAseguradoraDamos;
	}

	/**
	 * @return the idAseguradoraRecibimos
	 */
	public String getIdAseguradoraRecibimos() {
		return this.idAseguradoraRecibimos;
	}

	/**
	 * @param idAseguradoraRecibimos
	 *            the idAseguradoraRecibimos to set
	 */
	public void setIdAseguradoraRecibimos(final String idAseguradoraRecibimos) {
		this.idAseguradoraRecibimos = idAseguradoraRecibimos;
	}

	/**
	 * @return the idAseguradoraAmbos
	 */
	public String getIdAseguradoraAmbos() {
		return this.idAseguradoraAmbos;
	}

	/**
	 * @param idAseguradoraAmbos
	 *            the idAseguradoraAmbos to set
	 */
	public void setIdAseguradoraAmbos(final String idAseguradoraAmbos) {
		this.idAseguradoraAmbos = idAseguradoraAmbos;
	}

}
