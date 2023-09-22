package com.aaq.col.system.beans.aplicacion.alarma;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import javax.el.MethodNotFoundException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.FrecuenciaBase;
import com.aaq.col.clases.database.entidades.HorarioGrupo;
import com.aaq.col.clases.database.entidades.Horarios;
import com.aaq.col.clases.database.entidades.ReporteSolicitado;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.UsuarioFrecuencia;
import com.aaq.col.clases.database.repositorios.impl.TerminalDao;
import com.aaq.col.clases.pojo.edocta.CoberturasEdoCta;
import com.aaq.col.clases.pojo.edocta.EstadoCuenta;
import com.aaq.col.clases.pojo.edocta.ReciboEdoCta;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.GenericoEnviarSMS;
import com.aaq.col.clases.util.UtileriaFechas;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.TerminalDataModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@ManagedBean(name = "beanAplicacionAlarma")
@SessionScoped
public class JMBeanAplicacionAlarma extends JMBeanExtensiblePrincipal<Terminal> {

	private static final long serialVersionUID = 8270265879185962276L;

	private String idFrecuenciaBase;

    private String txtPoliza;
    private String txtRamo;
    private String txtInciso;
    private String txtTelefono;
    private String txtEstatus;
    private String txtFiltroEstado;
    private Date txtFecha;
    private EstadoCuenta edoCta;
    private Terminal terminalNotas;
    private static final int dia = 86400000;

    private String[] selectedBases = null;
    private boolean esCombo;
    
    public JMBeanAplicacionAlarma() {
        super();
        this.setTxtFiltroEstado(this.getIdEstado());
        this.actualizarListado();
    }

	@Override
    public void actualizarListado() {
        if (!this.getPermisoVistaClasica()) {
            if ((this.getListaFrecuenciaBaseSeleccionada() != null)
                    && (this.getListaFrecuenciaBaseSeleccionada().size() > 0)) {
                final List<Base> bases = new Vector<>();
                
                for (final UsuarioFrecuencia freq : this.getListaFrecuenciaBaseSeleccionada()) {
                    if (freq.getFrecuenciaBase().getBase().getId().intValue() <= 0) {

                        List<Base> lb = null;
                        try {
                            lb = this.getBaseService().listaDeBase(freq.getFrecuenciaBase().getBase().getEstado());
                        } catch (final Exception ex) {
                            this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
                                    "actualizarListado => Lista de Bases");
                        }

                        if (lb != null) {
                            for (final Base base : lb) {
                                bases.add(base);

                            }
                        }
                    } else {
                        bases.add(freq.getFrecuenciaBase().getBase());
                    }
                }

                try {
                    this.setListado(new TerminalDataModel(this.getTerminalService().listaDeTerminalModulo(null, null, bases,
                            null, null, null, null, null, Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenAlarma,
                            this.getTxtEstatus(), null, null, null, null)));
                } catch (final Exception ex) {
                    this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
                            "actualizarListado => Set Listado");
                }
            } else {
                this.setListado(new TerminalDataModel(new Vector<Terminal>()));

            }

        } else {
            try {
            	List<Base> lb = new ArrayList<>();
            	ArrayList<String> lista = new ArrayList<>();
            	boolean selectTodas= false;
            	if (this.getSelectedBases() != null) {
                	if (this.getSelectedBases().length > 0) {
    
			    for (int i = 0; i < this.getSelectedBases().length; i++) {
					lista.add(this.getSelectedBases()[i]);
				}
				
				if (lista.size() > 0) {
					for (int i = 0; i < lista.size(); i++) {
						if (Integer.parseInt(lista.get(i)) > 0) {
							lb.add(this.getBaseService().objetoBase(lista.get(i)));
						} else {
							selectTodas = true;
						}
						
					}
				}
	
				}
					
				}
            	
            	if ( !this.isEsCombo()) {
					lb = null;
				}
            	
            	if (StringUtils.isNotBlank(this.getTxtEstatus())) {
            		
            		if ( !this.isEsCombo()) {
    					lb = null;
    				}
            		
            		if (selectTodas) {
            			List <Terminal> terminales = this.getTerminalService().listaDeTerminal(
            					this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),this.getBaseService().objetoBase(this.getIdBase()),
            					null, null, null, null, null, null, Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenAlarma,
            					StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : "",
            							null, null, null, null);
                		
                		List<Terminal> terminalesFiltro = this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),
            					this.getBaseService().objetoBase(this.getIdBase()), null, null, null, null, null, null, Boolean.FALSE,
            					Boolean.FALSE, TerminalDao.ordenAlarma,StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : this
            					.getTxtEstatus(), null, null, null, null);
                		
                		if (this.getTxtEstatus().equals("filtroAlarmaProximidad")) {            			
                			
                			for (Terminal terminal : terminales) {
                				if (terminal.getReporteSac() != null) {
                					if (terminal.getReporteSac().getProximidad()) {
                						terminalesFiltro.add(terminal);
                					}            					
                				}
    						}
                			
                			this.setListado(new TerminalDataModel( terminalesFiltro));
                			return;
                		}
                		
                		if (this.getTxtEstatus().equals("filtroAvqReporte")) {
                			for (Terminal terminal : terminales) {
    							if (terminal.getReporteSac() != null) {
    								if (StringUtils.contains(terminal.getReporteSac().getAjusteCodigoCausa(), "51") ) {
    									terminalesFiltro.add(terminal);
    								}
    							}
    						}
                			this.setListado(new TerminalDataModel ( terminalesFiltro));
                			return;
                		}
                		this.setListado(new TerminalDataModel (terminalesFiltro));
            			
//            			this.setListado(new TerminalDataModel(this.getTerminalService().listaDeTerminal(
//                				this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),
//                				this.getBaseService().objetoBase(this.getIdBase()), null ,null,null,null,null,null,Boolean.FALSE,Boolean.FALSE,
//                				TerminalDao.ordenAlarma,StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : this
//                						.getTxtEstatus(), null, null, null, null)));
					} else {
						List <Terminal> terminales = this.getTerminalService().listaDeTerminal(
	        					this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),this.getBaseService().objetoBase(this.getIdBase()),
	        					lb, null, null, null, null, null, Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenAlarma,
	        					StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : "",
	        							null, null, null, null);
	            		
	            		List<Terminal> terminalesFiltro = this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),
	        					this.getBaseService().objetoBase(this.getIdBase()), lb, null, null, null, null, null, Boolean.FALSE,
	        					Boolean.FALSE, TerminalDao.ordenAlarma,StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : this
	        					.getTxtEstatus(), null, null, null, null);
	            		
	            		if (this.getTxtEstatus().equals("filtroAlarmaProximidad")) {            			
	            			
	            			for (Terminal terminal : terminales) {
	            				if (terminal.getReporteSac() != null) {
	            					if (terminal.getReporteSac().getProximidad()) {
	            						terminalesFiltro.add(terminal);
	            					}            					
	            				}
							}
	            			
	            			this.setListado(new TerminalDataModel( terminalesFiltro));
	            			return;
	            		}
	            		
	            		if (this.getTxtEstatus().equals("filtroAvqReporte")) {
	            			for (Terminal terminal : terminales) {
								if (terminal.getReporteSac() != null) {
									if (StringUtils.contains(terminal.getReporteSac().getAjusteCodigoCausa(), "51") ) {
										terminalesFiltro.add(terminal);
									}
								}
							}
	            			this.setListado(new TerminalDataModel ( terminalesFiltro));
	            			return;
	            		}
	            		this.setListado(new TerminalDataModel (terminalesFiltro));
//						this.setListado(new TerminalDataModel(this.getTerminalService().listaDeTerminal(
//	            				this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),
//	            				this.getBaseService().objetoBase(this.getIdBase()), lb ,null,null,null,null,null,Boolean.FALSE,Boolean.FALSE,
//	            				TerminalDao.ordenAlarma,StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : this
//	            						.getTxtEstatus(), null, null, null, null)));
					}
            		
            		
            		List <Terminal> terminales = this.getTerminalService().listaDeTerminal(
        					this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),this.getBaseService().objetoBase(this.getIdBase()),
        					lb, null, null, null, null, null, Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenAlarma,
        					StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : "",
        							null, null, null, null);
            		
            		List<Terminal> terminalesFiltro = this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),
        					this.getBaseService().objetoBase(this.getIdBase()), lb, null, null, null, null, null, Boolean.FALSE,
        					Boolean.FALSE, TerminalDao.ordenAlarma,StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : this
        					.getTxtEstatus(), null, null, null, null);
            		
            		if (this.getTxtEstatus().equals("filtroAlarmaProximidad")) {            			
            			
            			for (Terminal terminal : terminales) {
            				if (terminal.getReporteSac() != null) {
            					if (terminal.getReporteSac().getProximidad()) {
            						terminalesFiltro.add(terminal);
            					}            					
            				}
						}
            			
            			this.setListado(new TerminalDataModel( terminalesFiltro));
            			return;
            		}
            		
            		if (this.getTxtEstatus().equals("filtroAvqReporte")) {
            			for (Terminal terminal : terminales) {
							if (terminal.getReporteSac() != null) {
								if (StringUtils.contains(terminal.getReporteSac().getAjusteCodigoCausa(), "51") ) {
									terminalesFiltro.add(terminal);
								}
							}
						}
            			this.setListado(new TerminalDataModel ( terminalesFiltro));
            			return;
            		}
            		this.setListado(new TerminalDataModel (terminalesFiltro));
            	} else {
            		if ( !this.isEsCombo()) {
    					lb = null;
    				}
            		if (selectTodas) {
            			this.setListado(new TerminalDataModel(this.getTerminalService().listaDeTerminal(
                				this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),
                				this.getBaseService().objetoBase(this.getIdBase()), null ,null,null,null,null,null,Boolean.FALSE,Boolean.FALSE,
                				TerminalDao.ordenAlarma,StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : this
                						.getTxtEstatus(), null, null, null, null)));
					} else {
						this.setListado(new TerminalDataModel(this.getTerminalService().listaDeTerminal(
	            				this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),
	            				this.getBaseService().objetoBase(this.getIdBase()), lb ,null,null,null,null,null,Boolean.FALSE,Boolean.FALSE,
	            				TerminalDao.ordenAlarma,StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : this
	            						.getTxtEstatus(), null, null, null, null)));
					}
            		
            	}
            	
            } catch (final Exception ex) {
                this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado => SetListado");
            }
        }
        }
//}

//    }


    // **************************************************************//
    // Permisos
    // **************************************************************//
    public boolean getPermisoAlarmaDetalle() {
        return this.getTienePermisoParaPagina(JMConstantes.MODULO_APLICACION_ALARMA_DATOS_EXTENDIDOS);
    }

    public boolean getPermisoNotificacionPersonal(){
    	return this.getTienePermisoParaPagina(JMConstantes.MODULO_APLICACION_ALARMA_NOTIFICACION);
    }
    
    public boolean getPermisoNotas() {
    	return this.getTienePermisoParaPagina(JMConstantes.MODULO_APLICACION_ALARMA_NOTAS);
    }
    public boolean getPermisoAlarmaEstatusAjustador() {
        return this.getTienePermisoParaPagina(JMConstantes.MODULO_APLICACION_ALARMA_ESTATUS_AJUSTADOR);
    }
    public boolean getPermisoCheckBox() {
        return this.getTienePermisoParaPagina(JMConstantes.MODULO_APLICACION_ALARMA_CHECKBOX);
    }

    public boolean getPermisoVistaClasica() {
        return this.getTienePermisoParaPagina(JMConstantes.MODULO_APLICACION_ALARMA_VISTA_CLASICA);
    }

    public boolean getPermisoCobroWeb() {
        return this.getTienePermisoParaPagina(JMConstantes.MODULO_APLICACION_COBRO_WEB);
    }

    public boolean getPuedeEnviarSMS() {
        return (this.getEdoCta() != null) && (this.getEdoCta().getCoberturas() != null);
    }
    
    public boolean getPermisoNotificaciones() {
        return this.getTienePermisoParaPagina("/Aplicacion/sms.siica");
    }

    // **************************************************************//
    // Listas
    // **************************************************************//
    @Override
    public List<Base> getListaDeBases(final String estado) {
        if (StringUtils.isNotBlank(estado)) {

            try {
                return this.getBaseService().listaDeBase(this.getEstadoService().objetoEstado(estado), null, true,
                        StringUtils.equals(estado, "1000"), null, null);
            } catch (final Exception ex) {
                this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeBases");
            }
        }
        return new Vector<>();
    }

    public boolean getPermisoComboBases(final String estado) {
        if (StringUtils.isNotBlank(estado)) {
            try {
            	if (StringUtils.equalsIgnoreCase(estado, "9")) {
            		this.setEsCombo(true);
					return true;
				}
            } catch (final ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
                this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getEstadoCDMX");
            }
    		this.setEsCombo(false);
            return false;
        }
        if (this.getUsuarioActual().getEstado() != null) {
			if (this.getUsuarioActual().getEstado().getId() == 9) {
        		this.setEsCombo(true);
				return true;
			}	
		}
		this.setEsCombo(true);
        return false;
    }
    
//    public boolean getPermisoComboBases() {
//		if (this.getUsuarioActual().getEstado() != null) {
//			if (this.getUsuarioActual().getEstado().getId() == 9) {
//				return true;
//			}	
//			
//		}
//		return false;
		
		//
//	}

    
    /**
     * La lista de frecuencias por base que no han sido seleccionadas
     *
     * @return la lista
     */
    public List<SelectItem> getListaDeFrecuenciaBaseNoSeleccionada() {
        final List<SelectItem> retorno = new Vector<>();
        for (final FrecuenciaBase freq : this.getUsuarioActual().getFrecuencia().getFrecuenciaBases()) {

            boolean encontrada = false;
            for (final UsuarioFrecuencia base : this.getListaFrecuenciaBaseSeleccionada()) {
                if (base.getFrecuenciaBase().getId().intValue() == freq.getId().intValue()) {
                    encontrada = true;
                    break;
                }
            }

            if (!encontrada) {
                final SelectItem s = new SelectItem();
                s.setLabel(freq.getBase().getEstado().getNombre() + ":" + freq.getBase().getNombre());
                s.setValue(Objects.toString(freq.getId(), ""));
                retorno.add(s);
            }
        }
        return retorno;
    }

    /**
     * La lista de bases frecuencia que han sido seleccionadas
     *
     * @return la lista de usuario frecuencia seleccionada
     */
    public List<UsuarioFrecuencia> getListaFrecuenciaBaseSeleccionada() {
        try {
            return this.getUsuarioFrecuenciaService().listaDeUsuarioFrecuencia(this.getUsuarioActual());
        } catch (final Exception ex) {
            this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaFrecuenciaBaseSeleccionada");
            return null;
        }
    }

    /**
     * La lista de reportes solicitados para el ajustador
     *
     * @return la lista
     */
    public List<ReporteSolicitado> getListaReporteSolicitado() {
        if (this.getObjetoABM().getReporteSise() != null) {
            try {
                return this.getReporteSolicitadoService().listaDeReporteSolicitado(null, null,
                        this.getObjetoABM().getReporteSise().getGeneralNumeroReporte(), null, null);
            } catch (final Exception ex) {
                this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaReporteSolicitado");
            }

        }
        return null;

    }
    
    public void doAccionAgregarFrecuenciaBaseALista(final ActionEvent e) {

        if (StringUtils.isNotBlank(this.getIdFrecuenciaBase())) {

            FrecuenciaBase frecuencia = null;
            try {
                frecuencia = this.getFrecuenciaBaseService().objetoFrecuenciaBase(this.getIdFrecuenciaBase());
            } catch (final Exception ex) {
                this.getUtileriaExcepcion()
                        .manejarExcepcion(ex, this.getClass(), "doAccionAgregarFrecuenciaBaseALista");
            }

            if (frecuencia != null) {
                final UsuarioFrecuencia usuarioFrecuencia = new UsuarioFrecuencia();
                usuarioFrecuencia.setFrecuenciaBase(frecuencia);
                usuarioFrecuencia.setUsuario(this.getUsuarioActual());
                usuarioFrecuencia.guardarObjeto();

                this.actualizarListado();

            }
        }
    }

    public void doAccionQuitarFrecuenciaBaseALista(final ActionEvent e) {

        if (StringUtils.isNotBlank(this.obtenerParametroDeRequest("id"))) {
            UsuarioFrecuencia ufreq = null;
            try {
                ufreq = this.getUsuarioFrecuenciaService()
                        .objetoUsuarioFrecuencia(this.obtenerParametroDeRequest("id"));
            } catch (final Exception ex) {
                this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
                        "doAccionAgregarFrecuenciaBaseALista", this.obtenerParametroDeRequest("id"));
            }
            if (ufreq != null) {
                ufreq.eliminarObjeto();
                this.actualizarListado();
            }
        }

    }

    // **************************************************************//
    // Acciones con las columnas
    // **************************************************************//

    public void doAccionCambiarEstatusTerminal(final AjaxBehaviorEvent e) {
        this.doAccionRegistroEditar(null);
        if (this.getObjetoABM() != null) {
            try {
                this.getTerminalService().ejecutarFuncionTerminalEstatus(this.getObjetoABM().getId(),
                        this.getObjetoABM().getEstatus(),
                        "JMBeanAplicacionAlarma [" + this.getUsuarioActual().getNombre() + "]",
                        JMConstantes.SOCKET_FUENTE_SIICA_WEB, this.getObjetoABM().getNumeroproveedor(), 
                        "SIICA-AJUSTADORES  [" + this.getUsuarioActual().getNombre() + "]");
            } catch (final Exception ex) {
                this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionCambiarEstatusTerminal");
            }

            if (StringUtils.equalsIgnoreCase(this.getObjetoABM().getEstatus(), "DISPONIBLE SIN EQUIPO")
                    ) {
                try {
                    final JMResultadoOperacion r = this
                            .getTerminalService()
                            .ejecutarFuncionTerminalEstatusDisponible(
                                    this.getObjetoABM().getNumeroproveedor(),
                                    "SIICA-AJUSTADORES  [" + this.getUsuarioActual().getNombre() + "]",
                                    "SIICA Server -> SIICA Web -> JMBeanAplicacionAlarma -> DoAccionCambiarEstatusTerminal -> " + this.getObjetoABM().getEstatus());
                    this.ponerMensajeResultado(r);
                } catch (final Exception ex) {
                    this.ponerMensajeResultado(new JMResultadoOperacion(ex));
                }

            }

            if (StringUtils.equalsIgnoreCase(this.getObjetoABM().getEstatus(), "NO DISPONIBLE")) {

                try {
                    final JMResultadoOperacion r = this
                            .getTerminalService()
                            .ejecutarFuncionTerminalEstatusDesconectado(
                                    this.getObjetoABM().getNumeroproveedor(),
                                    "SIICA-AJUSTADORES  [" + this.getUsuarioActual().getNombre() + "]",
                                    "SIICA Server -> SIICA Web -> JMBeanAplicacionAlarma -> DoAccionCambiarEstatusTerminal",
                                    this.getObjetoABM().getEstatus());
                    this.ponerMensajeResultado(r);
                } catch (final Exception ex) {
                    this.ponerMensajeResultado(new JMResultadoOperacion(ex));
                }

            }
        }
    }

    public String doAccionDetalleReporte() {
        this.doAccionRegistroEditar(null);

        if (this.getObjetoABM() != null) {
            this.setTxtFecha(new Date());
            this.setTxtInciso("0001");
            this.setTxtRamo("04");
            this.setTxtTelefono(this.getObjetoABM().getTelefono());

            if (this.getObjetoABM().getReporteSise() != null) {
                this.setTxtPoliza(this.getObjetoABM().getReporteSise().getGeneralNumeroPoliza());
            }
            
            if (this.getObjetoABM().getReporteSac() != null) {
				this.setTxtPoliza(this.getObjetoABM().getReporteSac().getGeneralNumeroPoliza());
			}

            this.setEdoCta(null);
            return "alarmaDetalle";
        }

        return null;

    }
    
    public String doAccionNotificaciones() {
    	this.doAccionRegistroEditar(null);
    	
    	if(this.getObjetoABM() != null){
    		return "notificacionPersonal";
    	}
    		return null;
    }
    
    
    // **************************************************************//
    // Acciones el detalle del reporte
    // **************************************************************//
    public void doAccionEnviarSMS(final ActionEvent e) {
        if ((this.getEdoCta() == null) || (this.getEdoCta().getCoberturas() == null)) {
            this.ponerMensajeError("No hay coberturas para esta poliza");
            return;
        }

        if (StringUtils.isBlank(this.getTxtTelefono())) {
            this.ponerMensajeError("Es requerido escribir un numero de telefono para enviar los mensajes");
            return;
        }
        GenericoEnviarSMS smsUtil = new GenericoEnviarSMS();
        String envio = "";
        if (this.getEdoCta() != null && this.getEdoCta().getPoliza() != null) {
			 envio = "Poliza: "+this.getEdoCta().getGeneral().getPoliza()+
					", Inciso: "+this.getEdoCta().getGeneral().getInciso()+ ", Estatus: "+this.getEdoCta().getGeneral().getStatus()+
					", V. Inicia: "+this.getEdoCta().getGeneral().getFechaInicioVigencia()+", V. Terminal: "+this.getEdoCta().getGeneral().getFechaFinVigencia();
		}

        if ((this.getEdoCta().getRecibos() != null) && (this.getEdoCta().getRecibos().size() > 0)) {
        	try {
             ReciboEdoCta r = this.getEdoCta().getRecibos().get(this.getEdoCta().getRecibos().size()-1);
            envio = envio +", Remesa: " + r.getRemesa()+
            ", Pago: " + r.getFechaPago();
        	} catch (ClassCastException | IllegalArgumentException | IndexOutOfBoundsException | IllegalStateException ex) {
			}
        }
        envio = envio +", Lista de Coberturas: ";
        String nombreC ="";
        for (final CoberturasEdoCta c : this.getEdoCta().getCoberturas()) {
        	nombreC= nombreC +", " + c.getNombre();
        }
        envio = envio +nombreC;

        if (smsUtil.enviarSMS(this.getTxtTelefono(), envio)) {
            this.ponerMensajeInfo("Envio de SMS exitoso");
        } else {
            this.ponerMensajeError("Envio de SMS NO exitoso");
        }
    }

    @SuppressWarnings("unused")
	public void doAccionDetalleCobranza(final ActionEvent e) {
        try {
            UtileriaFechas util = new UtileriaFechas();
            String fecha = util.formatoDateEdoCta(this.getTxtFecha());
            boolean respaldoSise=true;
            EstadoCuenta respuesta = null;// this.getSiseSP_ServiceInterfase().obtenerEdoCta(this.getTxtPoliza(), this.getTxtInciso(), fecha, null, null,respaldoSise);
            if (respuesta != null && respuesta.getCoberturas() != null && respuesta.getCoberturas().size() > 0) {
                this.setEdoCta(respuesta);
                if (respuesta.getPoliza() != null) {
                  this.ponerMensajeInfo(respuesta.getPoliza().getStatus());
                }
            } else {
                this.ponerMensajeError("La poliza resultante es nula");
            }
        } catch (final Exception ex) {
            this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionDetalleCobranza");
            this.ponerMensajeError("Error al intentar consultar la cobranza. Detalles: " + ex.getMessage());
        }
    }

    // **************************************************************//
    // Propiedades CSS
    // **************************************************************//
    public String getCSSClaseColumnaDescripcion(final Terminal obj) {
        if (obj != null) {
            if (obj.getTieneMarcaAgua()) {
            	
            //*** Validacion Posicion Actual
                try {
                     	if (obj.getSinPosicionActual() != null) {
             			this.setObjetoABM(this.getTerminalService()
             					.objetoTerminal(obj.getId().toString()));
             			this.getObjetoABM().setSinPosicionActual(null);
             			this.getObjetoABM().guardarObjeto();

             			this.setObjetoABM(null);
             			
                    	}
             	} catch (Exception e) {
             			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getCSSClaseColumnaDescripcion");
             	}
            //***
                
                return "css_marca_agua";
            }
            if (obj.getUltimoLocalizacionFecha() != null) {
                final long diffconectado = System.currentTimeMillis() - obj.getUltimoLocalizacionFecha().getTime();
                
                if (diffconectado >= JMUtileriaFecha.TIEMPO_15_MINUTOS) {
                	
                	//----- SinPosicionActual ----- 
                	//*** Validacion Posicion Actual
					try {
						if (obj.getSinPosicionActual() == null) {
							this.setObjetoABM(this.getTerminalService()
									.objetoTerminal(obj.getId().toString()));
							this.getObjetoABM().setSinPosicionActual("1");
							this.getObjetoABM().guardarObjeto();

							this.setObjetoABM(null);	
							
						}
					} catch (Exception e) {
						this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getCSSClaseColumnaDescripcion");
					}
					//***
                	//--------
                	               	
                    return JMConstantes.CSS_COLUMNA_1_DEMORA;
                }
                
            }
            
          //*** Validacion Posicion Actual
            try {
                 	if (obj.getSinPosicionActual() != null) {
         			this.setObjetoABM(this.getTerminalService()
         					.objetoTerminal(obj.getId().toString()));
         			this.getObjetoABM().setSinPosicionActual(null);
         			this.getObjetoABM().guardarObjeto();

         			this.setObjetoABM(null);
         			
                	}
         	} catch (Exception e) {
         			this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getCSSClaseColumnaDescripcion");
         	}
         //***
            
        }
        
		
        return JMConstantes.CSS_COLUMNA_1_OK;
    }

    public String getCSSClaseFechaArribo(final Terminal obj) {

        if (obj != null) {
            if (obj.getTieneMarcaAgua()) {
                return "css_marca_agua";
            }

            if (obj.getFechaEstatusAsignado() != null) {
                final long diffconectado = obj.getFechaEstatusArribo() != null ? obj.getFechaEstatusArribo().getTime()
                        - obj.getFechaEstatusAsignado().getTime() : System.currentTimeMillis()
                        - obj.getFechaEstatusAsignado().getTime();
                if (diffconectado >= (60000 * 30)) {
                    return "css_rojo";
                }
                if (diffconectado >= (60000 * 25)) {
                    return "css_amarillo";
                }
                return "css_verde";
            }

        }

        return "css_blanco";

    }

    public String getCSSClaseFechaAsignado(final Terminal obj) {

        if (obj != null) {
            if (obj.getTieneMarcaAgua()) {
                return "css_marca_agua";
            }

            if (obj.getReporteSise() != null && obj.getFechaEstatusAsignado() != null) {
                Date fechaInicial = obj.getReporteSise().getFechaCreacion() != null ?
                        obj.getReporteSise().getFechaCreacion() :
                        obj.getReporteSise().getFecha();
                Date fechaFinal = obj.getFechaEstatusAsignado();

                final long diffconectado = fechaFinal.getTime() - fechaInicial.getTime();

                if (diffconectado >= JMUtileriaFecha.TIEMPO_05_MINUTOS) {
                    return "css_rojo";
                }
                if (diffconectado >= 120000) {
                    return "css_amarillo";
                }
                return "css_verde";
            }
            
            if (obj.getReporteSac() != null && obj.getFechaEstatusAsignado() != null) {
                Date fechaInicial = obj.getReporteSac().getFechaCreacion() != null ?
                        obj.getReporteSac().getFechaCreacion() :
                        obj.getReporteSac().getFecha();
                Date fechaFinal = obj.getFechaEstatusAsignado();

                final long diffconectado = fechaFinal.getTime() - fechaInicial.getTime();

                if (diffconectado >= JMUtileriaFecha.TIEMPO_05_MINUTOS) {
                    return "css_rojo";
                }
                if (diffconectado >= 120000) {
                    return "css_amarillo";
                }
                return "css_verde";
            }
            
        }

        return "css_blanco";
    }

    public String getCSSClaseTiempoAtencion(final Terminal obj) {
        if (obj != null) {
            if (obj.getTieneMarcaAgua()) {
                return "css_marca_agua";
            }

            if ((obj.getFechaEstatusAsignado() != null) && (obj.getFechaEstatusTermino() == null)) {
                final long diff = System.currentTimeMillis() - obj.getFechaEstatusAsignado().getTime();
                if (diff >= (JMUtileriaFecha.TIEMPO_01_HORA + JMUtileriaFecha.TIEMPO_30_MINUTOS)) {
                    return "css_rojo";
                }
                if (diff >= (JMUtileriaFecha.TIEMPO_01_HORA)) {
                    return "css_amarillo";
                }
                return "css_verde";

            }

        }

        return "css_blanco";
    }
    
    public String getCSSClaseFechaConsulta(final Terminal obj) {
        if (obj != null) {
            if (obj.getTieneMarcaAgua()) {
                return "css_marca_agua";
            }

            if (obj.getFechaEstatusAsignado() != null && obj.getReporteSise() != null) {

                // El inicio es cuando fue pasado al ajustador
                Date fechaInicial = obj.getFechaEstatusAsignado();

                // El termino es cuando lo leyo o ahora mismo
                Date fechaFinal = obj.getReporteSise().getFechaReporteLecturaPorWs() != null ? obj.getReporteSise().getFechaReporteLecturaPorWs() : new Date();

                Long diff = fechaFinal.getTime() - fechaInicial.getTime();

                if (diff >= (60000 * 2)) {
                    return "css_rojo";
                }
                return "css_verde";

            }
            
            if (obj.getFechaEstatusAsignado() != null && obj.getReporteSac() != null) {

                // El inicio es cuando fue pasado al ajustador
                Date fechaInicial = obj.getFechaEstatusAsignado();

                // El termino es cuando lo leyo o ahora mismo
                Date fechaFinal = obj.getReporteSac().getFechaReporteLecturaPorWs() != null ? obj.getReporteSac().getFechaReporteLecturaPorWs() : new Date();

                Long diff = fechaFinal.getTime() - fechaInicial.getTime();


                if (diff >= (60000 * 2)) {
                    return "css_rojo";
                }
                return "css_verde";

            }
        }

        return "css_blanco";
    }
    
    public String obtenerDatosReporteApartado(final Terminal obj){
    	String datosReporteApartado = null;
    	
    	if(obj.getReporteApartado() != null){
    		JsonObject json = null;
        	JsonParser parser = new JsonParser();
        	
        	json = (JsonObject) parser.parse(obj.getReporteApartado());
        	
    		datosReporteApartado = "Reporte apartado: " + json.get("numeroReporte").getAsString() + 
    				", Fecha: " + json.get("fechaApartado").getAsString() + 
    				", " + json.get("fuente").getAsString() + " Usuario ->" + json.get("usuario").getAsString();
    	}
    	
    	return datosReporteApartado;
    }

    /* ALARMAS DE AJUSTADORES - REPORTE NO VISTO*/
    public boolean getTieneReportesNuevos() {
      if (getPermisoAlarmaVisto()) {
    	List<Terminal> terminal = null;
    	try {
    		terminal = this.obtenerListaParaAlerta();
    	}catch (Exception e) {
    		 this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getTieneReportesNuevos");
		}
    	try {
	    	if (terminal != null) {
			for (final Terminal term :  terminal) {
				if (term.getReporteSac() != null) {
				if (term.getReporteSac().getFechaReporteLecturaPorWs() == null) {
					if ( !term.getVistoAlarma()) {
						// Diferencia entre fechaSistema - fechaAsignacion
						if (term.getFechaEstatusAsignado() != null) {
						  Date fechaAsig = term.getFechaEstatusAsignado();
						  final long diffconectado = System.currentTimeMillis() - fechaAsig.getTime();
			                if (diffconectado >= JMUtileriaFecha.TIEMPO_10_MINUTOS) {
			                	return true;
			                }
			              }
						}
					}
				  }
				}
			}
    	}catch (Exception e) {
//    		log.info("Ocurrio un error-> "+e);
    		 this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "getTieneReportesNuevos");
		}
		return false;
      }
      return false;
	}
	
    
    public boolean getEsAdministradorCabina() {
    	try {
		if (this.getUsuarioActual() != null) {
			if (this.getUsuarioActual().getPerfil() != null) {
				if (this.getUsuarioActual().getPerfil().getNombre().contains("Administrador Cabina")) {
	//				log.info("Es administrador de cabina");
					return true;
				}
			}
		}
		return false;
    	} catch (RollbackException e) {
    		return false;
		} catch (PersistenceException e) {
			return false;
		} catch (ClassCastException | IndexOutOfBoundsException e) {
			return false;
		} catch (Exception e) {
			return false;
		}
    }
   
    public boolean getMostrarBotonCancelar(final Terminal obj) {
    try {
	if (getPermisoAlarmaVisto()) {
		if(obj != null){
			if ( (obj.getFechaEstatusAsignado() != null) && (obj.getFechaEstatusTermino() == null)) {
			if (obj.getReporteSac() != null) {
					if (obj.getReporteSac().getFechaReporteLecturaPorWs() == null) {
						if ( !(obj.getVistoAlarma())) {
							  final long diffconectado = System.currentTimeMillis() - obj.getFechaEstatusAsignado().getTime();
//							  log.info("Diferencia de tiempo: "+diffconectado);
//							  log.info("Proveedor: "+obj.getNumeroproveedor());
				                if (diffconectado > JMUtileriaFecha.TIEMPO_10_MINUTOS) {
				                	return true;
				                }
							}
					}
    		   }
			}
		  }
		return false;
		} return false;
    }catch (ClassCastException | IndexOutOfBoundsException e) {
		return false;
	} catch (RollbackException e) {
		 return	false;
	} catch (PersistenceException  e) {
		return	false;
	}catch (Exception  e) {
	 return	false;
		} 
    }
    
    public String doAccionRegistroAlerta(final ActionEvent e) {
		this.setObjetoABM(this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
		if (this.getObjetoABM() == null) {
			this.ponerMensajeError("No se encontro registro para cancelar alarma.");
            return null;
		}
		else {
//			log.info("Si se encontro objeto "+this.getObjetoABM().getNumeroproveedor());
			//Procedemos a cancelar la alarma
//			log.info("Procedemos a cancelar la alarma");
			try {
				 try {	
					 	this.getObjetoABM().setVistoAlarma(true);;
			            final JMResultadoOperacion r = this.getObjetoABM().guardarObjeto();
			            if (r.isExito()) {
			                this.ponerMensajeInfo("Se cancelo la alarma del ajustador: "+this.getObjetoABM().getNumeroproveedor());
			            }
			            else {
			                this.ponerMensajeError("Registro No Guardado: " + r.getMensaje());
			            }
			        }
			        catch (Exception ex) {
			            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionCancelarAlarmaBtn -> " + ex.getMessage()), (Throwable)ex);
			        }
				 
			        this.actualizarListado();
			}catch (Exception ex) {
				this.ponerMensajeError("Ocurrio un error al cancelar la alarma. "+ex);
			}
			return this.getObjetoABM().getNumeroproveedor();
			
		}
		
	}
    
    public List<Terminal> obtenerListaParaAlerta() {
    	List<Terminal> terminal = null;
    	  if (!this.getPermisoVistaClasica()) {
              if ((this.getListaFrecuenciaBaseSeleccionada() != null)
                      && (this.getListaFrecuenciaBaseSeleccionada().size() > 0)) {
                  final List<Base> bases = new Vector<>();

                  for (final UsuarioFrecuencia freq : this.getListaFrecuenciaBaseSeleccionada()) {
                      if (freq.getFrecuenciaBase().getBase().getId().intValue() <= 0) {

                          List<Base> lb = null;
                          try {
                              lb = this.getBaseService().listaDeBase(freq.getFrecuenciaBase().getBase().getEstado());
                          } catch (final Exception ex) {
                              this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
                                      "actualizarListado => Lista de Bases");
                          }

                          if (lb != null) {
                              for (final Base base : lb) {
                                  bases.add(base);

                              }
                          }
                      } else {
                          bases.add(freq.getFrecuenciaBase().getBase());
                      }
                  }

                  try {
                     terminal = this.getTerminalService().listaDeTerminal(null, null, bases,
                              null, null, null, null, null, Boolean.FALSE, Boolean.FALSE, TerminalDao.ordenAlarma,
                              this.getTxtEstatus(), null, null, null, null);
                     return terminal;
                  } catch (final Exception ex) {
                      this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(),
                              "actualizarListado => Set Listado");
                  }
              } else {
                 return new Vector<Terminal>();

              }

          } else {
              try {
              	if (StringUtils.isNotBlank(this.getTxtEstatus())) {
              		List <Terminal> terminales = this.getTerminalService().listaDeTerminal(
          					this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),
          					this.getBaseService().objetoBase(this.getIdBase()),
          					null,
          					null,
          					null,
          					null,
          					null,
          					null,
          					Boolean.FALSE,
          					Boolean.FALSE,
          					TerminalDao.ordenAlarma,
          					StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : "",
          							null, null, null, null);
              		
              		List<Terminal> terminalesFiltro = this.getTerminalService().listaDeTerminal(
          					this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),
          					this.getBaseService().objetoBase(this.getIdBase()),
          					null,
          					null,
          					null,
          					null,
          					null,
          					null,
          					Boolean.FALSE,
          					Boolean.FALSE,
          					TerminalDao.ordenAlarma,
          					StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : this
          							.getTxtEstatus(), null, null, null, null);
              		
              		
              		if (this.getTxtEstatus().equals("filtroAlarmaProximidad")) {            			
              			
              			for (Terminal terminal1 : terminales) {
              				if (terminal1.getReporteSac() != null) {
              					if (terminal1.getReporteSac().getProximidad()) {
              						terminalesFiltro.add(terminal1);
              					}            					
              				}
  						}
              			
              			terminal = terminalesFiltro;
              			return terminal;
              		}
              		
              		if (this.getTxtEstatus().equals("filtroAvqReporte")) {
              			for (Terminal terminal1 : terminales) {
  							if (terminal1.getReporteSac() != null) {
  								if (StringUtils.contains(terminal1.getReporteSac().getAjusteCodigoCausa(), "51") ) {
  									terminalesFiltro.add(terminal1);
  								}
  							}
  						}
              			terminal =terminalesFiltro;
              			return terminal;
              		}
//              		this.setListado(new TerminalDataModel (terminalesFiltro));
              		terminal = terminalesFiltro;
              		return terminal;
              	} else {
              		terminal = this.getTerminalService().listaDeTerminal(
              				this.getEstadoService().objetoEstado(this.getTxtFiltroEstado()),
              				this.getBaseService().objetoBase(this.getIdBase()),
              				null,
              				null,
              				null,
              				null,
              				null,
              				null,
              				Boolean.FALSE,
              				Boolean.FALSE,
              				TerminalDao.ordenAlarma,
              				StringUtils.equals(this.getTxtFiltroEstado(), "1000") ? TerminalDao.filtroAlarmaForaneo : this
              						.getTxtEstatus(), null, null, null, null);
              		
              	
              		return terminal;
              	}
              	
              } catch (final Exception ex) {
                  this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado => SetListado");
              }

          }
		return terminal;
    }
 
    public String getGrupoHorarioAjustador(final Terminal obj) {
        if (obj != null) {
        	HorarioGrupo primerCaso;
        	List<HorarioGrupo> grupz;
            if (obj.getGrupo() != null) {
            	primerCaso = this.getHorarioGrupoService().horarioGrupoFecha(obj.getGrupo(), new Date());
            		if ( primerCaso != null ) {
            			Horarios catalogoHorarios  = null;
                		UtileriaFechas util = new UtileriaFechas();
						 catalogoHorarios = this.getHorariosService().horarioDia(primerCaso.getClaveHorario(), util.diaSemana(), obj.getEstado());
						if (catalogoHorarios != null) {
							if ( catalogoHorarios.getDescanso()) {
								return "Descanso";
							} 
							return catalogoHorarios.getHora_entrada()+ " - "+catalogoHorarios.getHora_salida();
						}
					} 
        		grupz = HorarioGrupo.getHorarioGrupoService().listaDeHorarioGrupoFechaAsc(obj.getGrupo());
        		if (grupz != null) {
        		  if (grupz.size() > 0) {
                			Horarios catalogoHorarios  = null;
                    		UtileriaFechas util = new UtileriaFechas();
    						 catalogoHorarios = this.getHorariosService().horarioDia(grupz.get(0).getClaveHorario(), util.diaSemana(), obj.getEstado());
    						if (catalogoHorarios != null) {
    							if ( catalogoHorarios.getDescanso()) {
    								return "Descanso";
    							} 
    							return catalogoHorarios.getHora_entrada()+ " - "+catalogoHorarios.getHora_salida();
    						}
        		  } else {
		            	return "Sin horario asignado.";
				}
        		}  else {
	            	return "Sin horario asignado.";
			}
            } else {
            	return "Sin horario asignado.";
            }
        }
        return "";
    }
    
    public String getVigenciaGrupo(final Terminal terminal) {
    	HorarioGrupo primerCaso;
    	List<HorarioGrupo> grupz;
		try {
		if (terminal.getGrupo() != null) {
			//Primero revisar si la fecha actual esta dentro de las fechas del horario.
			 primerCaso = HorarioGrupo.getHorarioGrupoService().horarioGrupoFecha(terminal.getGrupo(), new Date());
			 if (primerCaso != null) {
						if(primerCaso.getFechaFin() != null) {
							long diferenciaTiempo =  primerCaso.getFechaFin().getTime() - System.currentTimeMillis();
							if( (diferenciaTiempo >  dia) && (diferenciaTiempo < (3 * dia)))  {
					         	return "AMARILLO";
							}
				            if( (diferenciaTiempo > (3 * dia)) && (diferenciaTiempo < (7 * dia))) {
				            	return "VERDE";
							} 
						}
						return "ROJO";
			}
			
			grupz = HorarioGrupo.getHorarioGrupoService().listaDeHorarioGrupoFechaAsc(terminal.getGrupo());
		if (grupz != null) {
		  if (grupz.size() > 0) {
			if(grupz.get(0).getFechaFin() != null) {
				long diferenciaTiempo =  grupz.get(0).getFechaFin().getTime() - System.currentTimeMillis();
				if( (diferenciaTiempo >  dia) && (diferenciaTiempo < (3 * dia)))  {
		         	return "AMARILLO";
				}
	            if( (diferenciaTiempo > (3 * dia)) && (diferenciaTiempo < (7 * dia))) {
	            	return "VERDE";
				} 
			}
			return "ROJO";
			}
		}
		
		} 
			
		} catch (ClassCastException | MethodNotFoundException  e) {
			
		}
		return "NINGUNO";

	}

	@Override
	public void doAccionRegistroEditar(final ActionEvent e) {				
		super.doAccionRegistroEditar(e);
		this.getObjetoABM().setUsuario(getUsuarioActual());
		this.getObjetoABM().setFechaModificacion(new Date());
	}

	
    /* ALARMAS DE AJUSTADORES - REPORTE NO VISTO*/
    public boolean getVerIconoNotas(Terminal terminal) {
	     try {
	    	 if (terminal != null) {
				if (terminal.getReporteSac() != null) {
					if (terminal.getReporteSac().getAjusteFechaTerminoAjustador() == null) {
						return true;
					}
				}
			}
	     } catch (ClassCastException | IndexOutOfBoundsException | NoResultException e) {
		}
     return false;
	}
    
    public boolean getNotaTerminal(Terminal terminal) {
	     try {
	    	 if (terminal != null) {
				this.setTerminalNotas(terminal);
			}
	     } catch (ClassCastException | IndexOutOfBoundsException | NoResultException e) {
		}
    return false;
	}
    
    
	
    
    // **************************************************************//
    // GETTERS Y SETTERS
    // **************************************************************//

    /**
     * /**
     *
     * @return the idFrecuenciaBaseSeleccionada
     *
     * @author mfernandez Jan 22, 2009 4:40:37 PM
     */
    public String getIdFrecuenciaBase() {
        return this.idFrecuenciaBase;
    }

    /**
     * @param idFrecuenciaBase the idFrecuenciaBaseSeleccionada to set
     *
     * @author mfernandez Jan 22, 2009 4:40:37 PM
     */
    public void setIdFrecuenciaBase(final String idFrecuenciaBase) {
        this.idFrecuenciaBase = idFrecuenciaBase;
    }

    /**
     * Jun 3, 2010 6:31:57 PM
     *
     * @return the txtPoliza
     */
    public String getTxtPoliza() {
        return this.txtPoliza;
    }

    /**
     * Jun 3, 2010 6:31:57 PM
     *
     * @param txtPoliza the txtPoliza to set
     */
    public void setTxtPoliza(final String txtPoliza) {
        this.txtPoliza = txtPoliza;
    }

    /**
     * Jun 3, 2010 6:31:57 PM
     *
     * @return the txtRamo
     */
    public String getTxtRamo() {
        return this.txtRamo;
    }

    /**
     * Jun 3, 2010 6:31:57 PM
     *
     * @param txtRamo the txtRamo to set
     */
    public void setTxtRamo(final String txtRamo) {
        this.txtRamo = txtRamo;
    }

    /**
     * Jun 3, 2010 6:31:57 PM
     *
     * @return the txtInciso
     */
    public String getTxtInciso() {
        return this.txtInciso;
    }

    /**
     * Jun 3, 2010 6:31:57 PM
     *
     * @param txtInciso the txtInciso to set
     */
    public void setTxtInciso(final String txtInciso) {
        this.txtInciso = txtInciso;
    }

    /**
     * Jun 3, 2010 6:31:57 PM
     *
     * @return the txtFecha
     */
    public Date getTxtFecha() {
        return this.txtFecha;
    }

    /**
     * Jun 3, 2010 6:31:57 PM
     *
     * @param txtFecha the txtFecha to set
     */
    public void setTxtFecha(final Date txtFecha) {
        this.txtFecha = txtFecha;
    }

    /**
     * Jun 4, 2010 1:43:17 PM
     *
     * @return the txtTelefono
     */
    public String getTxtTelefono() {
        return this.txtTelefono;
    }

    /**
     * Jun 4, 2010 1:43:17 PM
     *
     * @param txtTelefono the txtTelefono to set
     */
    public void setTxtTelefono(final String txtTelefono) {
        this.txtTelefono = txtTelefono;
    }
    
    @Override
    public Terminal getObjetoABM() {
        return super.getObjetoABM();
    }

    /**
     * @return the txtEstatus
     */
    public String getTxtEstatus() {
        return this.txtEstatus;
    }

    /**
     * @param txtEstatus the txtEstatus to set
     */
    public void setTxtEstatus(final String txtEstatus) {
        this.txtEstatus = txtEstatus;
    }

    /**
     * Jose Miguel Oct 9, 2012 3:30:22 PM
     *
     * @return the txtFiltroEstado
     */
    public String getTxtFiltroEstado() {
        return this.txtFiltroEstado;
    }

    /**
     * Jose Miguel Oct 9, 2012 3:30:22 PM
     *
     * @param txtFiltroEstado the txtFiltroEstado to set
     */
    public void setTxtFiltroEstado(final String txtFiltroEstado) {
        this.txtFiltroEstado = txtFiltroEstado;
    }

	public Terminal getTerminalNotas() {
		return terminalNotas;
	}

	public void setTerminalNotas(Terminal terminalNotas) {
		this.terminalNotas = terminalNotas;
	}

	public String[] getSelectedBases() {
		return selectedBases;
	}

	public void setSelectedBases(String[] selectedBases) {
		this.selectedBases = selectedBases;
	}

	public boolean isEsCombo() {
		return esCombo;
	}

	public void setEsCombo(boolean esCombo) {
		this.esCombo = esCombo;
	}

	public EstadoCuenta getEdoCta() {
		return edoCta;
	}

	public void setEdoCta(EstadoCuenta edoCta) {
		this.edoCta = edoCta;
	}

}
