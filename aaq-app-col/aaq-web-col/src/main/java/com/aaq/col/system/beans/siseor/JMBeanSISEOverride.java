package com.aaq.col.system.beans.siseor;

import java.util.List;
import java.util.NoSuchElementException;

import com.aaq.col.clases.database.entidades.ReporteMovilSac;
import com.aaq.col.clases.database.entidades.ReporteMovilSacTerceros;
import com.aaq.col.clases.database.entidades.ReporteSise;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.siica.JMConstantesError;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.TransactionSystemException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;

@ManagedBean(name = "beanSISEOverride")
@ViewScoped
public class JMBeanSISEOverride extends JMBeanExtensiblePrincipal<Terminal> {	
	private String txtNumeroReporte;
	private String cmbTipoReporte;
	private String _filtroCausa;

	private static final long serialVersionUID = -1055259831400629169L;
	Log4JLogger loggerCancelarReporte = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.cancelarReportes");

	public JMBeanSISEOverride() {
		super();
	}

	@Override
	public void actualizarListado() {

	}

	// **************************************************************//
	// Asignar Reporte
	// **************************************************************//

	public void doAccionAsignarReporte(final ActionEvent e) {

		if (StringUtils.isBlank(this.txtNumeroReporte)) {
			this.ponerMensajeError("ERROR: Es necesario capturar un numero de reporte");
			return;
		}
		if (StringUtils.isBlank(this.getIdTerminal())) {
			this.ponerMensajeError("ERROR: Es necesario seleccionar un ajustador de la lista");
			return;
		}
		Terminal term = null;
		try {
			term = this.getTerminalService().objetoTerminal(this.getIdTerminal());
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"doAccionAsignarReporte => objetoTerminal");
		}

		ReporteMovilSac rptSac = null;
		ReporteSise rptSise = null;
		List<ReporteMovilSacTerceros> rptSacTerceros = null;
		
		if (term != null) {
			try{
				
				rptSac = this.getReporteMovilSacService().objetoReporteMovilSac(this.getTxtNumeroReporte(), null);
				if (rptSac == null) {
					rptSise = this.getReporteSiseService().objetoReporteSise(this.getTxtNumeroReporte());
				}
				
				
				JMResultadoOperacion result = null;
				
				if(rptSac != null){
					try {
						rptSacTerceros = this.getReporteMovilSacTercerosService().listaDeReporteMovilSacTerceros(this.getTxtNumeroReporte(), rptSac.getAjusteAjustadorCodigo());
						if (StringUtils.isNotBlank(this.get_filtroCausa()) && !(this.get_filtroCausa().contains("sinCausa"))) {
						 result = this.getTerminalService().ejecutarFuncionTerminalAsignarReporteSac(this.getUsuarioActual(), term.getNumeroproveedor(),
								this.getTxtNumeroReporte(), JMConstantes.SOCKET_FUENTE_SIICA_WEB,
								"SIICA Web -> JMBeanSISEOverride -> DoAccionAsignarReporte -> seleccionTipoReporte [SAC] -> "+this.get_filtroCausa());
						} else {
							result = this.getTerminalService().ejecutarFuncionTerminalAsignarReporteSac(this.getUsuarioActual(), term.getNumeroproveedor(),
									this.getTxtNumeroReporte(), JMConstantes.SOCKET_FUENTE_SIICA_WEB,
									"SIICA Web -> JMBeanSISEOverride -> DoAccionAsignarReporte -> seleccionTipoReporte [SAC] ");
						}
							if(result.isExito()){
								Terminal terminalReasignacion = null;
								try {
									terminalReasignacion = this.getTerminalService().objetoTerminalParaNumeroProveedor(null, term.getNumeroproveedor());
									
									if(terminalReasignacion != null){
										rptSac.setAjusteAjustadorCodigo(terminalReasignacion.getNumeroproveedor());
										rptSac.setAjusteAjustadorNombre(terminalReasignacion.getNombre());
										rptSac.setAjusteAjustadorOficina(terminalReasignacion.getClaveOficina());
										rptSac.setFechaReporteLecturaPorWs(null);
										rptSac.guardarObjeto();
										for (ReporteMovilSacTerceros reporteMovilSacTerceros : rptSacTerceros) {
											reporteMovilSacTerceros.setAjusteAjustadorCodigo(terminalReasignacion.getNumeroproveedor());
											reporteMovilSacTerceros.guardarObjeto();
										}
						this.ponerMensajeInfo("El reporte " + rptSac.getGeneralNumeroReporte() + " fue asignado correctamente");
						return;
									}else{
										this.ponerMensajeError("La clave de proveedor " + term.getNumeroproveedor() + " no existe.");
										return;
									}
									
								} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  nullEx) {
									this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + JMConstantesError.ERROR_NULL_POINTER 
											+ "-" + this.getTxtNumeroReporte() + "]");
									this.getUtileriaExcepcion().manejarExcepcion(nullEx, this.getClass(),
											"doAccionAsignarReporte => ejecutarFuncionTerminalAsignarReporte -> seleccionTipoReporte [SAC] => " + this.txtNumeroReporte);
									return;
								} catch (TransactionSystemException transactionEx) {
									this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + JMConstantesError.ERROR_TRANSACTION 
											+ "-" + this.getTxtNumeroReporte() + "]");
									this.getUtileriaExcepcion().manejarExcepcion(transactionEx, this.getClass(),
											"doAccionAsignarReporte => ejecutarFuncionTerminalAsignarReporte -> seleccionTipoReporte [SAC] => " + this.txtNumeroReporte);
									return;
								} catch (final Exception ex) {
									this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + JMConstantesError.ERROR_UNDEFINED 
											+ "-" + this.getTxtNumeroReporte() + "]");
									this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
											"doAccionAsignarReporte => ejecutarFuncionTerminalAsignarReporte -> seleccionTipoReporte [SAC] => " + this.txtNumeroReporte);
									return;
								}
							}else{
								this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + 
										JMConstantesError.ERROR_RESPUESTA_FUNCION + "-" + rptSac.getGeneralNumeroReporte() + "]");
								return;
							}
					}  catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  nullEx) {
						this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + JMConstantesError.ERROR_NULL_POINTER 
								+ "-" +this.getTxtNumeroReporte() + "]");
						this.getUtileriaExcepcion().manejarExcepcion(nullEx, this.getClass(),
								"doAccionAsignarReporte => ejecutarFuncionTerminalAsignarReporte -> seleccionTipoReporte [SAC] => " + this.txtNumeroReporte);
						return;
					} catch (TransactionSystemException transactionEx) {
						this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + JMConstantesError.ERROR_TRANSACTION 
								+ "-" + this.getTxtNumeroReporte() + "]");
						this.getUtileriaExcepcion().manejarExcepcion(transactionEx, this.getClass(),
								"doAccionAsignarReporte => ejecutarFuncionTerminalAsignarReporte -> seleccionTipoReporte [SAC] => " + this.txtNumeroReporte);
						return;
					} catch (final Exception ex) {
						this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + JMConstantesError.ERROR_UNDEFINED 
								+ "-" + this.getTxtNumeroReporte() + "]");
						this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
								"doAccionAsignarReporte => ejecutarFuncionTerminalAsignarReporte -> seleccionTipoReporte [SAC] => " + this.txtNumeroReporte);
						return;
					}
				}
				if(rptSac == null && rptSise == null){
					this.ponerMensajeError("El reporte " + this.txtNumeroReporte + " no se encuentra registrado en SIICA.");
					return;
				}
			}  catch (final IndexOutOfBoundsException nullEx) {
				this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + JMConstantesError.ERROR_NULL_POINTER 
						+ "-" +this.getTxtNumeroReporte() + "]");
				return;
			} catch (final  DataAccessException  | IllegalArgumentException | PersistenceException  nullEx) {
				this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + JMConstantesError.ERROR_NULL_POINTER 
						+ "-" + this.getTxtNumeroReporte() + "]");
				this.getUtileriaExcepcion().manejarExcepcion(nullEx, this.getClass(),
						"doAccionAsignarReporte => ejecutarFuncionTerminalAsignarReporte -> seleccionTipoReporte [SISE] => " + this.txtNumeroReporte);
				return;
			} catch (TransactionSystemException transactionEx) {
				this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + JMConstantesError.ERROR_TRANSACTION 
						+ "-" + this.getTxtNumeroReporte() + "]");
				this.getUtileriaExcepcion().manejarExcepcion(transactionEx, this.getClass(),
						"doAccionAsignarReporte => ejecutarFuncionTerminalAsignarReporte -> seleccionTipoReporte [SISE] => " + this.txtNumeroReporte);
				return;
			} catch (final ClassCastException ex) {
				this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + JMConstantesError.ERROR_UNDEFINED 
						+ "-" + this.getTxtNumeroReporte() + "]");
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"doAccionAsignarReporte => ejecutarFuncionTerminalAsignarReporte -> seleccionTipoReporte [SISE] => " + this.txtNumeroReporte);
				return;
			} catch (final Exception ex) {
				this.ponerMensajeError("Reporte no asignado, reportar el siguiente código [" + JMConstantesError.ERROR_UNDEFINED 
						+ "-" + this.getTxtNumeroReporte() + "]");
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"doAccionAsignarReporte => ejecutarFuncionTerminalAsignarReporte -> seleccionTipoReporte [SISE] => " + this.txtNumeroReporte);
				return;
			}
		} else {
			this.ponerMensajeError("ERROR: La terminal no puede ser nula. Por favor, seleccione otra terminal");
			return;
		}

	}

	// **************************************************************//
	// Cancelar Reporte
	// **************************************************************//

	/**
	 * Cancela un reporte a una terminal doSISECancelarReporte Apr 6, 2008
	 * 9:11:35 AM
	 * 
	 * @param e  es el evento de Ajax que dispara este metodo desde la interfaz web
	 */
	public void doAccionCancelarReporte(final ActionEvent e) {

		if (StringUtils.isBlank(this.txtNumeroReporte)) {
			this.ponerMensajeError("SIICA SISE OR / Cancelar Reporte dice: ERROR: Es necesario capturar un numero de reporte");
			return;
		}
		if (StringUtils.isBlank(this.getIdTerminal())) {
			this.ponerMensajeError("SIICA SISE OR / Cancelar Reporte dice: ERROR: Es necesario seleccionar un ajustador de la lista");
			return;
		}
		Terminal term = null;
		try {
			term = this.getTerminalService().objetoTerminal(this.getIdTerminal());
		} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"doAccionCancelarReporte => objetoTerminal");
		} catch (final NoSuchElementException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"doAccionCancelarReporte => objetoTerminal");
		} catch (final ClassCastException ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
					"doAccionCancelarReporte => objetoTerminal");
		}

		if (term != null) {

			if(term.getReporteSise() != null){
				try {
					final JMResultadoOperacion r = this.getTerminalService().ejecutarFuncionTerminalCancelarReporte(this.getUsuarioActual(),
							term.getNumeroproveedor(), this.getTxtNumeroReporte(), JMConstantes.SOCKET_FUENTE_SIICA_WEB,
							"SIICA SISE OR -> Cancelar Reporte-> CancelarReporteParaProveedor");
					this.ponerMensajeResultado(r);
				} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
							"ejecutarFuncionTerminalCancelarReporte");
					this.ponerMensajeResultado(new JMResultadoOperacion(ex));
				} catch (final NoSuchElementException ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
						"ejecutarFuncionTerminalCancelarReporte");
				this.ponerMensajeResultado(new JMResultadoOperacion(ex));
				} catch (final ClassCastException ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
							"ejecutarFuncionTerminalCancelarReporte");
					this.ponerMensajeResultado(new JMResultadoOperacion(ex));
				} catch (final Exception ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
							"ejecutarFuncionTerminalCancelarReporte");
					this.ponerMensajeResultado(new JMResultadoOperacion(ex));
				}
				
		}else{
				try {
					final JMResultadoOperacion r = this.getTerminalService().ejecutarFuncionTerminalCancelarReporteSac(this.getUsuarioActual(),
							term.getNumeroproveedor(), this.getTxtNumeroReporte(), JMConstantes.SOCKET_FUENTE_SIICA_WEB,
							"SIICA SISE OR -> Cancelar Reporte-> CancelarReporteParaProveedor");
					this.ponerMensajeResultado(r);
				} catch (final  IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
							"ejecutarFuncionTerminalCancelarReporte");
					this.ponerMensajeResultado(new JMResultadoOperacion(ex));
				} catch (final NoSuchElementException ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
							"ejecutarFuncionTerminalCancelarReporte");
					this.ponerMensajeResultado(new JMResultadoOperacion(ex));
				} catch (final ClassCastException ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
							"ejecutarFuncionTerminalCancelarReporte");
					this.ponerMensajeResultado(new JMResultadoOperacion(ex));
				} catch (final Exception ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
							"ejecutarFuncionTerminalCancelarReporte");
					this.ponerMensajeResultado(new JMResultadoOperacion(ex));
				}
			}

		} else {
			this.ponerMensajeError("SIICA SISE OR / Cancelar Reporte dice: ERROR: La terminal no puede ser nula. Por favor, seleccione otra terminal");
		}

	}

	// **************************************************************//
	// GETTERS Y Setters
	// **************************************************************//

	public String getTxtNumeroReporte() {
		return this.txtNumeroReporte;
	}

	public void setTxtNumeroReporte(final String txtNumeroReporte) {
		this.txtNumeroReporte = txtNumeroReporte;
	}
	
	public String getCmbTipoReporte() {
		return cmbTipoReporte;
	}
	
	public void setCmbTipoReporte(String cmbTipoReporte) {
		this.cmbTipoReporte = cmbTipoReporte;
	}

	public String get_filtroCausa() {
		return _filtroCausa;
	}

	public void set_filtroCausa(String _filtroCausa) {
		this._filtroCausa = _filtroCausa;
	}
	

}