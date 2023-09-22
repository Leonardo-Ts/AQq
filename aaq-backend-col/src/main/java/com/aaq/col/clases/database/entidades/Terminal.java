package com.aaq.col.clases.database.entidades;

import com.aaq.col.clases.database.entidades.abstracto.AbstractTerminal;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.JMUtileriaNotificacion;
import com.aaq.col.clases.util.TiempoEstatusUtil;
import com.aaq.col.clases.webservices.json.Ajustador;
import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;
import com.jmfg.jmlib.sistema.classes.jmlibreria.*;
import com.jmfg.jmlib.sistema.classes.nmea.JMMensajeNMEAInformacion;
import com.jmfg.jmlib.sistema.classes.nmea.JMMensajeNMEAPosicion;
import com.jmfg.jmlib.sistema.classes.web.geocode.JMGoogleGeoCode;
import com.jmfg.jmlib.sistema.classes.web.geocode.JMMapQuestGeocode;
import com.jmfg.jmlib.sistema.classes.web.xml.google.GeocodeResponse;
import com.jmfg.jmlib.sistema.classes.web.xml.mapquest.Location;
import com.jmfg.jmlib.sistema.classes.web.xml.mapquest.Response;
import com.jmfg.jmlib.sistema.fabricas.mapas.JMMotorDeMapas;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaString;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

@ManagedBean(name = "terminal")
@RequestScoped
@Entity(name = "Terminal")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "terminal")
public class Terminal extends AbstractTerminal {
    private static final long serialVersionUID = -4902569510844617382L;

    @Transient
    private String _idEstado;

    @Transient
    private String _idBase;
    
    @Transient
    private String _idGeocerca;

    @Transient
    private Boolean estaConectada;

    @Transient
    private Double distanciaCalculada;
    
    @Transient
    private String _idOficina;
    
    @Transient
    private String _idDisMqp;
    
    @Transient
    private String _idDisMqs;
    
    @Transient
    private String _idVehiculoMar;
    
    @Transient
    private String _razonEstatus;
    
    @Transient
    private String _dirEstado;
    
    
    public Terminal() {
        super();

        this.setLatitud("0");
        this.setLongitud("0");
        this.setTelefono("Telefono");
        this.setUltimoLocalizacionFecha(new Date());
        this.setUltimoLocalizacionValida(Boolean.FALSE);
        this.setHabilitado(Boolean.TRUE);
        this.setIntervaloPoolMinutos(new Integer(5));
        this.setUltimoLocalizacionValida(Boolean.FALSE);
        this.setNombre("Nombre Ajustador");
        this.setFechaEstatusDesconectado(new Date());
        this.setFechaEstatusArribo(null);
        this.setFechaEstatusAsignado(null);
        this.setFechaEstatusDisponible(null);
        this.setFechaEstatusOcupado(null);
        this.setFechaEstatusTermino(null);
        this.setFechaEstatusOtros(null);
        this.setProximidad(null);
        this.setReporteSise(null);
        this.setUltimoLocalizacionReporte(null);
        this.setFuenteDisponible(null);
        this.setFuenteArribo(null);
        this.setFuenteAsignacion(null);
        this.setFuenteTermino(null);
        this.setEstatus("DISPONIBLE");
        this.setMoto(false);
        this.setRazonEstatus(null);
    }

    private static TerminalServiceInterfase terminalService;

    public static TerminalServiceInterfase getTerminalService() {
        if (Terminal.terminalService == null) {
            Terminal.terminalService = JMSIICAServerServiceSingleton.getInstance().getTerminalService();
        }
        return Terminal.terminalService;
    }

    public List<TerminalAlerta> getListaDeAlertas() {
        if (this.getId() != null) {
            try {
                return TerminalAlerta.getTerminalAlertaService().listaDeTerminalAlerta(this);
            } catch (final Exception ex) {
                JMEntidad.getLogger().error("getListaDeAlertas => listaDeTerminalAlerta", ex);
            }
        }
        return null;
    }

    public JMPuntoGeografico toJMPuntoGeografico(){

        final JMPuntoGeografico punto = new JMPuntoGeografico();
        punto.setEsArrastable(false);

        punto.setIconoNombre(this.getTipoPunto());
        punto.setIconoArchivo(this.getTipoPunto());

        punto.setLatitud(this.getLatitud());
        punto.setLongitud(this.getLongitud());

        punto.setDescripcionHTML(this.getHTML());
        punto.setIdentificadorUnico(Objects.toString(this.getId(), ""));
        punto.setEtiqueta(this.getNumeroproveedor());
        return punto;

    }

    public JMPuntoGeografico toJMPuntoGeograficoAlt() {
        final JMPuntoGeografico puntoAlt = new JMPuntoGeografico();
        puntoAlt.setEsArrastable(false);

        puntoAlt.setIconoNombre(this.getTipoPuntoAlterno());
        puntoAlt.setIconoArchivo(this.getTipoPuntoAlterno());

        puntoAlt.setLatitud(this.getLatitudAlterna());
        puntoAlt.setLongitud(this.getLongitudAlterna());

        puntoAlt.setDescripcionHTML(this.getHTML());
        puntoAlt.setIdentificadorUnico("alt_" + Objects.toString(this.getId(), ""));
        puntoAlt.setEtiqueta("ALTERNO: " + this.getNumeroproveedor());
        return puntoAlt;
    }

    public Ajustador toAjustador(final String latitud,final String longitud){
        Ajustador ajustador = new Ajustador();
        ajustador.setId(Objects.toString(getId(), ""));
        ajustador.setEstado(Objects.toString(getEstado(), ""));
        ajustador.setBase(Objects.toString(getBase(), ""));
        ajustador.setNombre(getNombre());
        ajustador.setNumeroRadio(getNumeroradio());
        ajustador.setNumeroProveedor(getNumeroproveedor());
        ajustador.setNumeroTelefono(getTelefono());
        ajustador.setEstatus(getEstatusMapa());
        ajustador.setLatitud(getLatitud());
        ajustador.setLongitud(getLongitud());
        ajustador.setMoto(getMoto());
        ajustador.setFechaLocalizacion(JMUtileriaString.quitarNoXML(Objects.toString(
                getUltimoLocalizacionFecha(), "")));
        if (getReporteSise() != null) {
            ajustador.setReporteAtiendiendoNumero(getReporteSise().getGeneralNumeroReporte());
            ajustador.setReporteAtiendiendoPlacasSerie(getReporteSise().getVehiculoPlacas() + ","
                    + getReporteSise().getVehiculoSerie());
        }
        ajustador.setDireccion(getUltimoLocalizacionDireccion());
        ajustador.setIcono(getTipoPunto());

        if (BooleanUtils.isTrue(getCoordenadasDesdeBase())){
            ajustador.setFuenteDeCoordenadas("COORDENADAS_DESDE_BASE");
        }
        ajustador.setDistanciaAlPunto("0.001");
        ajustador.setReporteEsteDia(getContadorReportesEsteDia());
        ajustador.setAv(getAsistenciaVial());
        ajustador.setTipoAv(getTipoAsistenciaVial());
        
        try {
        	ajustador.setGeocerca(getGeocercaByEstado().getGeocerca());
		} catch (Exception e) {
		}
        ajustador.setEquipoPesado(getEquipoPesado());
        return ajustador;
    }


    @Override
    public JMResultadoOperacion editarObjeto() {
        if (this.getEstado() != null) {
            this.set_idEstado(Objects.toString(this.getEstado().getId(), ""));
        }
        if (this.getBase() != null) {
            this.set_idBase(Objects.toString(this.getBase().getId(), ""));
        }
        
        if (this.getGeocercaByEstado() != null) {
            this.set_idGeocerca(Objects.toString(this.getGeocercaByEstado().getId(), ""));
        }
        
        if (this.getCatalogoOficina() != null) {
            this.set_idOficina(Objects.toString(this.getCatalogoOficina().getId(), ""));
        }
        
        if (this.getCatalogoMovil() != null) {
            this.set_idDisMqp(Objects.toString(this.getCatalogoMovil().getId(), ""));
        }
        
        if (this.getCatalogoMovil() != null) {
            this.set_idDisMqs(Objects.toString(this.getCatalogoMovil().getId(), ""));
        }
        
        if (this.getCatalogoVehiculoAjus() != null) {
            this.set_idVehiculoMar(Objects.toString(this.getCatalogoVehiculoAjus().getId(), ""));
        }
        if (this.getDirEstado() != null) {
			this.set_dirEstado(Objects.toString(this.getEstado().getNombre(), ""));
		}

        return null;
    }

    @Override
    public JMResultadoOperacion guardarObjeto() {
        if (StringUtils.isNotBlank(this.get_idEstado())) {
            try {
                this.setEstado(Estado.getEstadoService().objetoEstado(this.get_idEstado()));
            } catch (final Exception ex) {
                JMEntidad.getLogger().error("guardarObjeto => objetoEstado", ex);
            }
        }
        if (StringUtils.isNotBlank(this.get_idBase())) {
            try {
                this.setBase(Base.getBaseService().objetoBase(this.get_idBase()));
            } catch (final Exception ex) {
                JMEntidad.getLogger().error("guardarObjeto => objetoBase", ex);
            }
        }
        
        if (StringUtils.isNotBlank(this.get_idGeocerca())) {
            try {
                this.setGeocercaByEstado(GeocercaByEstado.getGeocercaByEstadoService().objetoGeocercaByEstado(this.get_idGeocerca()));
            } catch (final Exception ex) {
                JMEntidad.getLogger().error("guardarObjeto => objetoGeocercaByEstado", ex);
            }
        }
        
        
        if (StringUtils.isNotBlank(this.get_idOficina())) {
            try {
                this.setCatalogoOficina(CatalogoOficina.getCatalogoOficinaService().objetoCatalogoOficina(this.get_idOficina()));
            } catch (final Exception ex) {
                JMEntidad.getLogger().error("guardarObjeto => objetoCatalogoOficina", ex);
            }
        }
        
        if (StringUtils.isNotBlank(this.get_idDisMqp())) {
            try {
                this.setCatalogoMovil(CatalogoMovil.getCatalogoMovilService().objetoCatalogoMovil(this.get_idDisMqp()));
            } catch (final Exception ex) {
                JMEntidad.getLogger().error("guardarObjeto => objetoCatalogoMovil", ex);
            }
        }
        
        if (StringUtils.isNotBlank(this.get_idDisMqs())) {
            try {
                this.setCatalogoMovilS(CatalogoMovil.getCatalogoMovilService().objetoCatalogoMovil(this.get_idDisMqs()));
            } catch (final Exception ex) {
                JMEntidad.getLogger().error("guardarObjeto => objetoCatalogoMovil", ex);
            }
        }
        
        if (StringUtils.isNotBlank(this.get_idVehiculoMar())) {
            try {
                this.setCatalogoVehiculoAjus(CatalogoVehiculoAjus.getCatalogoVehiculoAjusService().objetoCatalogoVehiculoAjus(this.get_idVehiculoMar()));
            } catch (final Exception ex) {
                JMEntidad.getLogger().error("guardarObjeto => objetoCatalogoVehiculoAjus", ex);
            }
        }
        
        if (StringUtils.isNotBlank(this.get_dirEstado())) {
            try {
            	this.setDirEstado(Estado.getEstadoService().objetoEstadoNombre(this.get_dirEstado()));
            } catch (final Exception ex) {
                JMEntidad.getLogger().error("guardarObjeto => objetoCatalogoMovil", ex);
            }
        }
        
        
        try {
            return Terminal.getTerminalService().guardarObjeto(this);
        } catch (final Exception ex) {
            JMEntidad.getLogger().error("guardarObjeto", ex);
            return new JMResultadoOperacion(ex);
        }
    }

    @Override
    public JMResultadoOperacion eliminarObjeto() {
        this.setHabilitado(Boolean.FALSE);
        this.setNumeroproveedor(this.getNumeroproveedor() + " Eliminada en la fecha: " + new Date());
        this.setNumeroradio(this.getNumeroradio() + " Eliminada en la fecha: " + new Date());
        this.setNombre(this.getNombre() + " Eliminada en la fecha: " + new Date());
        this.setDispositivoNombre(this.getNumeroproveedor() + " Eliminada en la fecha: " + new Date());

        try {
            return Terminal.getTerminalService().guardarObjeto(this);
        } catch (final Exception ex) {
            JMEntidad.getLogger().error("EliminarObjeto => GuardarObjeto", ex);
            return new JMResultadoOperacion(ex);
        }
    }

    @Override
    public ArrayList<JMColumna> getColumnas() {
        return new JMListadoColumna(new String[]{"Departamento,estado", "Base,base", "Nombre,nombre",
                "Numero de Proveedor,numeroproveedor", "Numero de Radio,numeroradio","Modificado Por,strDatosModificacion"}).getLista();
    }

    @Override
    public String toString() {
        return this.getNombreCombo();
    }

 	@JMReporteOmitirMetodo
 	public String  getStrDatosModificacion(){
 		if (getUsuario() != null ){
 			if (getEstatus().equals("NO DISPONIBLE"))
 			{
 				return getUsuario().getNombre() +  (getFechaModificacion()!= null? ", " + DateFormatUtils.format(getFechaModificacion(),"yyyy/MM/dd HH:mm:ss"):"") + ", " + getRazonEstatus();
 			} else {
 				return getUsuario().getNombre() +  (getFechaModificacion()!= null? ", " + DateFormatUtils.format(getFechaModificacion(),"yyyy/MM/dd HH:mm:ss"):"");
 			}
 		}  
 		return null;
 	}
 	
 	public List<Horarios> getListaHorario() {
 		Date current = new Date();
 		
 		HorarioGrupo ref = HorarioGrupo.getHorarioGrupoService().horarioGrupoFecha(this.getGrupo(), current);
 		try {
 			if(ref != null) {
 				List<Horarios> semana = Horarios.getHorariosService().listaDeHorarios(ref.getClaveHorario());
 				return semana; 				
 			}
		} catch (Exception e) {
		}
 		
 		return new Vector<>();
 	}
 	
 	public String getNombreDiaDescanso() {
 		String nombre="";
 		
	      if (StringUtils.isBlank(this.getDiaDescanso())) {
	 			nombre = "";
	 		} else {
	 		    String[] diasDesc = this.getDiaDescanso().split("\\|");
	 	        ArrayList<String> lista = new ArrayList<>();
	 		      for (int i = 0; i < diasDesc.length; i++) {
	 						lista.add(diasDesc[i]); 
	 					}
	      if (lista.contains("0")) {
	    	  nombre="No aplica";
	      	}
	      if(lista.contains("1")) {
	    	  nombre= " Lunes";
	      }
	      if(lista.contains("2")) {
	    	  nombre= nombre + " Martes";
	      }
	      if(lista.contains("3")) {
	    	  nombre= nombre + " Miércoles";
	      }
	      if(lista.contains("4")) {
	    	  nombre= nombre + " Jueves";
	      }
	      if(lista.contains("5")) {
	    	  nombre= nombre + " Viernes";
	      }
	      if(lista.contains("6")) {
	    	  nombre= nombre + " Sábado";
	      }
	      if(lista.contains("7")) {
	    	  nombre= nombre + " Domingo";
	      }
	 }
 		return nombre;
	 		
 	}
 	
 	public String getNombreSubGrupo() {
 		String nombre;
 		if (StringUtils.isBlank(this.getSubGrupo())) {
 			nombre = "";
 		} else {
 			switch (this.getSubGrupo()) {
 			case "0":
 				nombre="No aplica";
 				break;

			default:
				nombre=this.getSubGrupo();
				break;
			}
 		}
 		return nombre;
 	}
 	
 	public String getGuardiaTexto() {
 		String texto;
 		if (this.getGuardia() != null) {
			if (this.getGuardia()) {
				texto = "Activada";
			} else {
				texto = "Desactivada";
			}
		} else {
			texto = "No tiene guardia";
		}
 		return texto;
 	}

 	public String getEstatusMapa() {
        if (this.getFechaEstatusDesconectado() != null) {
            return "Desconectado";
        }
        if (this.getFechaEstatusOcupado() != null) {
            return "Ocupado";
        }

        if (this.getFechaEstatusDisponible() != null) {
            if ((this.getUltimoLocalizacionFecha() != null)
                    && ((System.currentTimeMillis() - this.getUltimoLocalizacionFecha().getTime()) > 480000)) {
                return "VPosicion";
            }
            return "Disponible";
        }
        if (this.getFechaEstatusTermino() != null) {
            return "Arribo";
        }
        if (this.getFechaEstatusArribo() != null) {
            return "Arribo";
        }

        return "Desconectado";
    }

    @JMReporteOmitirMetodo
    public String getEstatusHTML() {
        if (this.getFechaEstatusDesconectado() != null) {
            return "Desconectado";
        }
        if (this.getFechaEstatusOcupado() != null) {
            return "Ocupado";
        }
        
        TiempoEstatusUtil estatusUtileria = new TiempoEstatusUtil();
        String estatusD = estatusUtileria.estatusDisponibles(this.getUltimoLocalizacionFecha(), 
        		this.getFechaEstatusDisponible(), this.getBase(), this.getEstado());
        if (StringUtils.isNotBlank(estatusD)) {
        	return  estatusD;
		}
		
//        if (this.getBase().getNombre().contains("GUADALAJARA") || this.getBase().getNombre().contains("guadalajara") ) {
//        	 if (this.getFechaEstatusDisponible() != null) {
//        		 //Validacion para poner en DISPONIBLE despues de tiempo de la  bandera.
//        		 try {
//        			 int tiempoDisponible = this.configuracionDao
//        						.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
//        			 long millisTiempoD =  tiempoDisponible * 60 * 1000;
//	        		 if ((this.getUltimoLocalizacionFecha() != null)
//	                         && ((System.currentTimeMillis() - this.getUltimoLocalizacionFecha().getTime()) > millisTiempoD )) {
//	                     return "Disponible";
//	                 }
//        		 } catch (RollbackException e) {
//        		 }
//                 if ((this.getUltimoLocalizacionFecha() != null)
//                         && ((System.currentTimeMillis() - this.getUltimoLocalizacionFecha().getTime()) > 360000)) {
//                     return "VPosicion";
//                 }
//                 return "Disponible";
//             }
//		} else {
//	        if (this.getFechaEstatusDisponible() != null) {
//	        	try {
//       			 int tiempoDisponible = this.configuracionDao
//       						.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
//       			 long millisTiempoD =  tiempoDisponible * 60 * 1000;
//	        		 if ((this.getUltimoLocalizacionFecha() != null)
//	                         && ((System.currentTimeMillis() - this.getUltimoLocalizacionFecha().getTime()) > millisTiempoD )) {
//	                     return "Disponible";
//	                 }
//	       		 } catch ( RollbackException e) {
//	       		 }
//	        	
//	            if ((this.getUltimoLocalizacionFecha() != null)
//	                    && ((System.currentTimeMillis() - this.getUltimoLocalizacionFecha().getTime()) > 300000)) { 
//	                return "VPosicion";
//	            }
//	            return "Disponible";
//	        }
//		}
        
        if (this.getFechaEstatusTermino() != null) {
            return "Arribo";
        }
        if (this.getFechaEstatusArribo() != null) {
            return "Arribo";
        }

        return "Desconectado";
    }

    /**
     * 05/08/2008 02:02:27
     *
     * @return el HTML
     */
    /**
     * 05/08/2008 02:02:44
     *
     * @return el html
     */
    @JMReporteOmitirMetodo
    public String getHTML() {
        final StringBuilder builder = new StringBuilder();

        builder.append("<b>Nombre:</b> " + JMUtileriaString.quitarNoXML(this.getNombre()));
        builder.append("<br /><b>Radio:</b> " + JMUtileriaString.quitarNoXML(this.getNumeroradio()));
        builder.append("<br /><b>Proveedor:</b> " + JMUtileriaString.quitarNoXML(this.getNumeroproveedor()));
        builder.append("<br /><b>Telefono:</b> " + JMUtileriaString.quitarNoXML(this.getTelefono()));

        builder.append("<br /><b>Fecha Ultima Loc:</b> "
                + JMUtileriaString.quitarNoXML(DateFormatUtils.format(this.getUltimoLocalizacionFecha(),
                "dd-MM-yyyy HH:mm:ss")));

        if (this.getReporteSise() != null) {
            builder.append("<br /><b>Reporte:</b> "
                    + JMUtileriaString.quitarNoXML(this.getReporteSise().getGeneralNumeroReporte()));
            builder.append("<br /><b>Placas, Serie:</b> "
                    + JMUtileriaString.quitarNoXML(this.getReporteSise().getVehiculoPlacas() + ","
                    + this.getReporteSise().getVehiculoSerie()));
        }
        if (this.getReporteSac() != null) {
            builder.append("<br /><b>Reporte:</b> "
                    + JMUtileriaString.quitarNoXML(this.getReporteSac().getGeneralNumeroReporte()));
            builder.append("<br /><b>Placas, Serie:</b> "
                    + JMUtileriaString.quitarNoXML(this.getReporteSac().getVehiculoPlacas() + ","
                    + this.getReporteSac().getVehiculoSerie()));
        }
        builder.append("<br /><b>Estatus:</b> " + JMUtileriaString.quitarNoXML(this.getEstatusHTML()));
        if(this.getEstatusHTML().equals("Ocupado")){
        	builder.append("<br /><b>Tiempo en Atención:</b> " + JMUtileriaString.quitarNoXML(this.getTiempoDeAtencion()));
        }
//        builder.append("<br /><b>Velocidad:</b> " + JMUtileriaString.quitarNoXML(this.getVelocidadKMH()));
        builder.append("<br /><b>Reportes Este Dia:</b> " + this.getReportesEsteDia());
        if (this.getUltimoLocalizacionTiempo() != null) {
            builder.append("<br /><b>Tiempo en estatus:</b> "
                    + JMUtileriaString.quitarNoXML(this.getUltimoLocalizacionTiempo()));
        }
        return Objects.toString(builder, "");
    }

    /**
     * 05/08/2008 02:02:19
     *
     * @return el icono
     */
    public String getIcono() {
        return this.getTipoPunto();
    }

    /**
     * @return la imagen del listado
     * @author mfernandez Mar 24, 2009 1:53:50 AM
     */
    public String getImagenListado() {

        if ((this.getLatitud() != null) && (this.getLongitud() != null)) {
            if (this.getCoordenadasValidas()) {
                if ((System.currentTimeMillis() - this.getUltimoLocalizacionFecha().getTime()) <= (this
                        .getIntervaloPoolMinutos().intValue() * 60000)) {
                    return "../diseno/imagenes/iconos/u_conectada.png";
                }
                return "../diseno/imagenes/iconos/u_desconectada.png";
            }
            return "../diseno/imagenes/iconos/u_sin_posicion.png";
        }
        return "../diseno/imagenes/iconos/u_desconectada.png";
    }

    // **************************************************************//
    // Especifico
    // **************************************************************//

    /**
     * @return el nombre
     */
    public String getNombreCombo() {
        return "Radio: " + this.getNumeroradio() + ", Proveedor: " + this.getNumeroproveedor()+ ", Tel: "+ this.getTelefono();
    }
    
    public String getNumeroProv() {
        return this.getNumeroproveedor();
    }


    /**
     * @return el reporte que se encuentra atendiendo la terminal
     * @author mfernandez Feb 4, 2009 3:31:20 PM
     */
    public String getReporteAtendiendo() {

    	if(this.getReporteSac() != null){
    		return this.getReporteSac() != null ? this.getReporteSac().getGeneralNumeroReporte() : this
                    .getUltimoLocalizacionReporte();
    	}else{
    		return this.getReporteSise() != null ? this.getReporteSise().getGeneralNumeroReporte() : this
                    .getUltimoLocalizacionReporte();
    	}
        
    }

    /**
     * getTipoPunto Mar 12, 2008 12:25:59 AM
     *
     * @return el tipo de punto
     */
//    public String getTipoPunto() {
//
//        if (this.getFechaEstatusDesconectado() != null) {
//        	if (BooleanUtils.isTrue(getCoordenadasDesdeBase())){
//        		return JMConstantes.ICONO_VEHICULO_DESCONECTADO_BASE;
//        	}
//        	
//        	if ( BooleanUtils.isTrue(getMoto()) ) {
//        		return JMConstantes.ICONO_MOTO_DESCONECTADO;
//        	}
//        	
//            return JMConstantes.ICONO_VEHICULO_DESCONECTADO;
//        }
//        
//        if (this.getFechaEstatusOcupado() != null) {
//        	
//            if (BooleanUtils.isTrue(getCoordenadasDesdeBase())){
//                return JMConstantes.ICONO_VEHICULO_OCUPADO_BASE;
//            }
//            
//            if ( BooleanUtils.isTrue(getMoto()) ) {
//            	return JMConstantes.ICONO_MOTO_OCUPADO;
//            }
//            
//            return JMConstantes.ICONO_VEHICULO_OCUPADO;
//        }
//        
//        if (this.getFechaEstatusDisponible() != null) {
//
//            if (BooleanUtils.isTrue(getCoordenadasDesdeBase())){
//                return JMConstantes.ICONO_VEHICULO_DISPONIBLE_BASE;
//            }
//            
//            if ((this.getUltimoLocalizacionFecha() != null)
//                    && ((System.currentTimeMillis() - this.getUltimoLocalizacionFecha().getTime()) > 360000)) {
//            	
//            	if ( BooleanUtils.isTrue(getMoto()) ) {
//            		return JMConstantes.ICONO_MOTO_SIN_GPS;
//            	}
//            	
//                return JMConstantes.ICONO_VEHICULO_SIN_GPS;
//            }
//            
//            if ( BooleanUtils.isTrue(getMoto()) ) {
//        		return JMConstantes.ICONO_MOTO_DISPONIBLE;
//        	}
//            
//            return JMConstantes.ICONO_VEHICULO_DISPONIBLE;
//        }
//        
//        if (this.getFechaEstatusOtros() != null) {
//            return JMConstantes.ICONO_VEHICULO_BLANCO;
//        }
//        
//        
//        if ( BooleanUtils.isTrue(getMoto()) ) {
//    		return JMConstantes.ICONO_MOTO_DESCONECTADO;
//    	}
//        
//        return JMConstantes.ICONO_VEHICULO_DESCONECTADO;
//
//    }

    public String getTipoPunto() {

        if (this.getFechaEstatusDesconectado() != null) {
        	if (BooleanUtils.isTrue(getCoordenadasDesdeBase())){
        		return JMConstantes.ICONO_VEHICULO_DESCONECTADO_BASE;
        	}

//        	if (this.getBase().getNombre().contains(JMConstantes.AJUSTADOR_EXPRES)) {
        	if (this.getBase().getVulnerable()) {
				return JMConstantes.ICONO_EXPRES_DESCONECTADO;
			}
        	
        	if ( BooleanUtils.isTrue(getMoto()) ) {
        		return JMConstantes.ICONO_MOTO_DESCONECTADO;
        	}
        	
        	if ( BooleanUtils.isTrue(getEquipoPesado()) ) {
        		return JMConstantes.ICONO_EQUIPO_PESADO_DESCONECTADO;
        	}
        	
            return JMConstantes.ICONO_VEHICULO_DESCONECTADO;
        }
        
        if (this.getFechaEstatusOcupado() != null) {
        	
            if (BooleanUtils.isTrue(getCoordenadasDesdeBase())){
                return JMConstantes.ICONO_VEHICULO_OCUPADO_BASE;
            }
            
//            if (this.getBase().getNombre().contains(JMConstantes.AJUSTADOR_EXPRES)) {
            if (this.getBase().getVulnerable()) {
				return JMConstantes.ICONO_EXPRES_OCUPADO;
			}
            
            if ( BooleanUtils.isTrue(getMoto()) ) {
            	return JMConstantes.ICONO_MOTO_OCUPADO;
            }
            
            if ( BooleanUtils.isTrue(getEquipoPesado()) ) {
        		return JMConstantes.ICONO_EQUIPO_PESADO_OCUPADO;
        	}
            
            return JMConstantes.ICONO_VEHICULO_OCUPADO;
        }
        
        if (this.getFechaEstatusDisponible() != null) {

            if (BooleanUtils.isTrue(getCoordenadasDesdeBase())){
                return JMConstantes.ICONO_VEHICULO_DISPONIBLE_BASE;
            }
            //Se cambia logica para V.9.20.7 para Guadalajara 360000 (6 min) y demas bases 300000(5 min)
            TiempoEstatusUtil estatusUtileria = new TiempoEstatusUtil();
	        String estatusD = estatusUtileria.iconoEstatus(this.getBase(), this.getUltimoLocalizacionFecha(), getMoto(),
	        		this.getBase().getVulnerable(), this.getEstado(), getEquipoPesado());
	        if (StringUtils.isNotBlank(estatusD)) {
	        	return  estatusD;
			}
            if (this.getBase().getVulnerable()) {
				return JMConstantes.ICONO_EXPRES_DISPONIBLE;
			}
            
            if ( BooleanUtils.isTrue(getMoto()) ) {
        		return JMConstantes.ICONO_MOTO_DISPONIBLE;
        	}
            
            if ( BooleanUtils.isTrue(getEquipoPesado()) ) {
        		return JMConstantes.ICONO_EQUIPO_PESADO_DISPONIBLE;
        	}
           
            return JMConstantes.ICONO_VEHICULO_DISPONIBLE;
        }
        
        if (this.getFechaEstatusOtros() != null) {
            return JMConstantes.ICONO_VEHICULO_BLANCO;
        }
        
        if (this.getBase().getVulnerable()) {
			return JMConstantes.ICONO_EXPRES_DESCONECTADO;
		}
        
        if ( BooleanUtils.isTrue(getMoto()) ) {
    		return JMConstantes.ICONO_MOTO_DESCONECTADO;
    	}
        
        if ( BooleanUtils.isTrue(getEquipoPesado()) ) {
    		return JMConstantes.ICONO_EQUIPO_PESADO_DESCONECTADO;
    	}
        
        
        return JMConstantes.ICONO_VEHICULO_DESCONECTADO;

    }
	
    
    
    /**
     * getTipoPunto Mar 12, 2008 12:25:59 AM
     *
     * @return el tipo de punto
     */
    public String getTipoPuntoAlterno() {
        if (this.getFechaEstatusDesconectado() != null) {
            return "alt_" + JMConstantes.ICONO_VEHICULO_DESCONECTADO;
        }
        if (this.getFechaEstatusOcupado() != null) {
            return "alt_" + JMConstantes.ICONO_VEHICULO_OCUPADO;
        }
        
        
        //Se cambia logica para V.9.20.7 para Guadalajara 360000 (6 min) y demas bases 300000(5 min)
        if (this.getFechaEstatusDisponible() != null) {
	        TiempoEstatusUtil estatusUtileria = new TiempoEstatusUtil();
	        String estatusD = estatusUtileria.puntoAlterno(this.getBase(), this.getUltimoLocalizacionFecha(),
	        		this.getFechaEstatusDisponible(), this.getEstado());
	        if (StringUtils.isNotBlank(estatusD)) {
	        	return  estatusD;
			}
        }
//        if (this.getBase().getNombre().contains("GUADALAJARA") || this.getBase().getNombre().contains("guadalajara") ) {
//        	
//        	try {
//    			 int tiempoDisponible = this.configuracionDao
//    						.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
//    			 long millisTiempoD =  tiempoDisponible * 60 * 1000;
//	        		 if ((this.getUltimoLocalizacionFecha() != null)
//	                         && ((System.currentTimeMillis() - this.getUltimoLocalizacionFecha().getTime()) > millisTiempoD )) {
//	        			 return "alt_" + JMConstantes.ICONO_VEHICULO_DISPONIBLE;
//	   	                 }
//	       		 } catch ( RollbackException e) {
//	       		 }
//        	
//        	 if (this.getFechaEstatusDisponible() != null) {
//                 if ((this.getUltimoLocalizacionFecha() != null)
//                         && ((System.currentTimeMillis() - this.getUltimoLocalizacionFecha().getTime()) > 360000)) {
//                     return "alt_" + JMConstantes.ICONO_VEHICULO_SIN_GPS;
//                 }
//
//                 return "alt_" + JMConstantes.ICONO_VEHICULO_DISPONIBLE;
//             }
//        }else  {
//           if (this.getFechaEstatusDisponible() != null) {
//        	   
//        	   try {
//      			 int tiempoDisponible = this.configuracionDao
//      						.obtenerEntero(JMConstantes.TIEMPO_ESTATUS_DISPONIBLE);
//      			 long millisTiempoD =  tiempoDisponible * 60 * 1000;
//  	        		 if ((this.getUltimoLocalizacionFecha() != null)
//  	                         && ((System.currentTimeMillis() - this.getUltimoLocalizacionFecha().getTime()) > millisTiempoD )) {
//  	        			 return "alt_" + JMConstantes.ICONO_VEHICULO_DISPONIBLE;
//  	   	                 }
//  	       		 } catch ( RollbackException e) {
//  	       		 }
//        	   
//            if ((this.getUltimoLocalizacionFecha() != null)
//                    && ((System.currentTimeMillis() - this.getUltimoLocalizacionFecha().getTime()) > 300000)) {
//                return "alt_" + JMConstantes.ICONO_VEHICULO_SIN_GPS;
//            }
//
//            return "alt_" + JMConstantes.ICONO_VEHICULO_DISPONIBLE;
//          }
//        }
        
        
        if (this.getFechaEstatusOtros() != null) {
            return JMConstantes.ICONO_VEHICULO_BLANCO;
        }
        return "alt_" + JMConstantes.ICONO_VEHICULO_DESCONECTADO;

    }

    /**
     * 08/08/2008 04:17:36
     *
     * @return la velocidad en kmh
     */
    public String getVelocidadKMH() {

        if (this.getUltimoLocalizacionVelocidad() != null) {
            double toKilometers = NumberUtils.toDouble(this.getUltimoLocalizacionVelocidad()) * 1.852;
            toKilometers = Math.round(toKilometers * 100) / 100;
            return toKilometers + " km/h";
        }
        return "0 km/h";

    }

    @JMReporteOmitirMetodo
    public String getTiempoDeAtencion() {
        if ((this.getFechaEstatusAsignado() != null) && (this.getFechaEstatusTermino() == null)) {
            final long diferencia = System.currentTimeMillis() - this.getFechaEstatusAsignado().getTime();

            if (diferencia > 60000 * 90) {
                return "ATRASO: " + JMUtileriaFecha.obtenerHoraMinutoSegundoParaLong(diferencia);
            }
            if (diferencia > 60000 * 60) {
                return "TARDE: " + JMUtileriaFecha.obtenerHoraMinutoSegundoParaLong(diferencia);
            }

            return "EN TIEMPO: " + JMUtileriaFecha.obtenerHoraMinutoSegundoParaLong(diferencia);
        }
        return "";
    }

    @JMReporteOmitirMetodo
    public String getTiempoAtencionTool(){
        if (getFechaEstatusAsignado() != null){
            String retorno ="Se le asignó el reporte: " + DateFormatUtils.format(getFechaEstatusAsignado(),"dd/MM/yyyy HH:mm:ss");

            if (getFechaEstatusTermino() == null){
                retorno += "<br/>La fecha actual es: " + DateFormatUtils.format(new Date(),"dd/MM/yyyy HH:mm:ss");
            }else {
                retorno += "<br/>La fecha de termino fue : " + DateFormatUtils.format(getFechaEstatusTermino(),"dd/MM/yyyy HH:mm:ss");

            }
            return retorno;
        }
        return null;
    }
    
    @JMReporteOmitirMetodo
    public String getTiempoSinAtencion() {
        if (this.getFechaEstatusDisponible() != null) {
            final long diferencia = System.currentTimeMillis() - this.getFechaEstatusDisponible().getTime();

//            return "TIEMPO DISPONIBLE: " + JMUtileriaFecha.obtenerHoraMinutoSegundoParaLong(diferencia);
            return JMUtileriaFecha.obtenerHoraMinutoSegundoParaLong(diferencia);
        }
        return "";
    }
    
    @JMReporteOmitirMetodo
    public String getTiempoSinAtencionTool(){
        if (getFechaEstatusAsignado() != null){
            String retorno ="Se le asignó el reporte: " + DateFormatUtils.format(getFechaEstatusDisponible(),"dd/MM/yyyy HH:mm:ss");
            getLeido();
            return retorno;
        }
        return null;
    }
    
    
    @JMReporteOmitirMetodo
    public String getLeido(){
    	if (this.getReporteSac().getFechaReporteLecturaPorWs() != null){
    		
    		String retorno ="Se leyo el reporte el: " + DateFormatUtils.format(this.getReporteSac().getFechaReporteLecturaPorWs(),"dd/MM/yyyy HH:mm:ss");
    		return retorno;
    	}
    	
    	return "No lo ha leido aun";
    }
    
    @JMReporteOmitirMetodo
    public String getFechaConsultaTool() {
        if (getFechaEstatusAsignado() != null && getReporteSise() != null){
            String retorno ="Se le asignó el reporte: " + DateFormatUtils.format(getFechaEstatusAsignado(),"dd/MM/yyyy HH:mm:ss");

            if (getReporteSise().getFechaReporteLecturaPorWs() == null){
                retorno += "<br/>La fecha actual es: " + DateFormatUtils.format(new Date(),"dd/MM/yyyy HH:mm:ss");
            }else {
                retorno += "<br/>La fecha de lectura fue: " + DateFormatUtils.format(getReporteSise().getFechaReporteLecturaPorWs(),"dd/MM/yyyy HH:mm:ss");

            }
            return retorno;


        }
        return null;
    }


    @JMReporteOmitirMetodo
    public String getFechaAsignadoTool() {
        if (getFechaEstatusAsignado() != null && getReporteSise() != null){
            String retorno ="Se le asignó el reporte: " + DateFormatUtils.format(getFechaEstatusAsignado(),"dd/MM/yyyy HH:mm:ss");

            if (getReporteSise().getFechaCreacion() != null){
                retorno += "<br/>La fecha de generación del reporte en SISE fue: " + DateFormatUtils.format(getReporteSise().getFechaCreacion(),"dd/MM/yyyy HH:mm:ss");
            }else {
                retorno += "<br/>La fecha de generación del reporte en SIICA fue: " + DateFormatUtils.format(getReporteSise().getFecha(),"dd/MM/yyyy HH:mm:ss");

            }

            return retorno;


        }
        return null;
    }

    public boolean getTieneUltimoReporte() {
        return (this.getUltimoLocalizacionReporte() != null) || (this.getReporteSise() != null);
    }

    public boolean getCoordenadasValidas() {
        return JMUtileriaString.validarPosicion(this.getLatitud())
                && JMUtileriaString.validarPosicion(this.getLongitud());
    }

    public boolean getTieneMarcaAgua() {
        return !StringUtils.equalsIgnoreCase(this.getEstatus(), "AUTOPISTA")
                && !StringUtils.containsIgnoreCase(this.getEstatus(), "EQUIPO")
                && !StringUtils.equalsIgnoreCase(this.getEstatus(), "DISPONIBLE");
    }

    // **************************************************************//
    // Procesadores de Objetos
    // **************************************************************//

    /**
     * @param latitud
     * @param longitud
     * @param velocidad
     * @param fecha
     * @return x
     */
    public String procesarLatitudLongitud(final String latitud, final String longitud, final double velocidad,
                                          final Date fecha) {

        String direccion = "";

        try {
            final String latEn4 = StringUtils.left(latitud, StringUtils.indexOf(latitud, ".") + 4);
            final String longEn4 = StringUtils.left(longitud, StringUtils.indexOf(longitud, ".") + 4);

            CalleDireccion dire = CalleDireccion.getCalleDireccionService().objetoCalleDireccionParaCoordenadas(latEn4,
                    longEn4);
            if (dire == null) {
            	try {
	                final GeocodeResponse r = JMGoogleGeoCode.geocodificarCoordenadas(latitud, longitud);
	
	                if ((r != null) && (r.getResult() != null) && (r.getResult().get(0) != null)
	                        && StringUtils.isNotBlank(r.getResult().get(0).getFormatted_address())) {
	                    direccion = r.getResult().get(0).getFormatted_address();
	                } else {
	                    final Response rs = JMMapQuestGeocode.geocodificarCoordenadas(latitud, longitud);
	                    if ((rs != null) && (rs.getResults() != null) && (rs.getResults()[0] != null)
	                            && (rs.getResults()[0].getLocations() != null)
	                            && (rs.getResults()[0].getLocations().length > 0)
	                            && (rs.getResults()[0].getLocations()[0] != null)) {
	                        final Location l = rs.getResults()[0].getLocations()[0];
	                        direccion = l.getStreet() + " " + l.getAdminArea5() + " " + l.getAdminArea4() + " "
	                                + l.getAdminArea3() + " " + l.getAdminArea2();
	                    }
	                }
	
	                if (StringUtils.isNotBlank(direccion)) {
	                    dire = new CalleDireccion();
	                    dire.setDireccion(direccion);
	                    dire.setLatitud(latEn4);
	                    dire.setLongitud(longEn4);
	                    dire.guardarObjeto();
	                }
            	} catch (Exception e) {
				}

            } else {
                direccion = dire.getDireccion();
            }
        } catch (final Exception e) {
            JMEntidad.getLogger().error("procesarLatitudLongitud", e);
        }
        JMResultadoOperacion res = null;
        try {
            res = Terminal.getTerminalService().ejecutarFuncionTerminalInsertarCoordenadas(this.getId(),
                    fecha != null ? fecha : new Date(), Double.toString(velocidad), latitud, longitud, direccion);
        } catch (final Exception ex) {
        	ex.printStackTrace();
            JMEntidad.getLogger().error("procesasrLatitudLongitud => ejecutarFuncionTerminalInsertarCoordenadas", ex);
        }

        if (StringUtils.isNotBlank(this.getLatitud()) && StringUtils.isNotBlank(this.getLongitud())) {
            this.verificarAlertas(velocidad, latitud, longitud);
        }
        return res != null ? res.getMensaje() : "Resultado NULO";

    }

    public String procesarObjetoBlackBerry(final String objeto) {
        return objeto;
    }

    public void procesarObjetoDeInformacion(final JMMensajeNMEAInformacion obj, final String ip) {
        try {
            Terminal.getTerminalService().ejecutarFuncionTerminalInsertarFechaLocalizacion(this.getId());
        } catch (final Exception ex) {
            JMEntidad.getLogger().error(
                    "procesarObjetoDeInformacion => ejecutarFuncionTerminalInsertarFechaLocalizacion", ex);

        }
    }

    public void procesarObjetoDePosicion(final JMMensajeNMEAPosicion obj, final String ip) {
        double velocidad = 0;
        velocidad = obj.getVelocidad() != null ? NumberUtils.toDouble(obj.getVelocidad()) * 1.852 : 0;
        final double velocidadKMHR = Math.round(velocidad * 100) / 100;

        this.procesarLatitudLongitud(obj.getLongitudM2S(), obj.getLatitudM2S(), velocidadKMHR, obj.getFecha());

    }

    public void procesarObjetoGenerico(final String command, final String ip) {
        try {
            Terminal.getTerminalService().ejecutarFuncionTerminalInsertarFechaLocalizacion(this.getId());
        } catch (final Exception ex) {
            JMEntidad.getLogger().error("procesarObjetoGenerico => ejecutarFuncionTerminalInsertarFechaLocalizacion",
                    ex);
        }

    }

    private void verificarAlertas(final double velocidadKMHR, final String latitud, final String longitud) {
        final List<TerminalAlerta> lista = this.getListaDeAlertas();

        if ((lista != null) && (lista.size() > 0)) {
            // Ciclar todas las alertas
            for (final TerminalAlerta TerminalAlerta : lista) {
                if ((TerminalAlerta.getPorVelocidadMayorKmh() != null)
                        && (TerminalAlerta.getPorVelocidadMayorKmh().intValue() > 0)) {

                    if ((velocidadKMHR > TerminalAlerta.getPorVelocidadMayorKmh().intValue())
                            && !(velocidadKMHR == NumberUtils.toDouble(this.getVelocidadKMH()))) {
                        final TerminalAlertaLog alerta = new TerminalAlertaLog();
                        alerta.setTerminal(this);
                        alerta.setTerminalAlerta(TerminalAlerta);
                        alerta.setLatitud(latitud);
                        alerta.setLongitud(longitud);
                        alerta.setTipo("Alerta por Velocidad Excedida");
                        alerta.setDescripcion("Se excedio la velocidad limite de "
                                + TerminalAlerta.getPorVelocidadMayorKmh() + " a: " + velocidadKMHR);
                        try {
                            TerminalAlertaLog.getTerminalAlertaLogService().guardarObjeto(alerta);
                        } catch (final Exception ex) {
                            JMEntidad.getLogger().error(
                                    "verificarAlertas => getTerminalAlertaLogService => GuardarObjeto", ex);
                        }
                        new JMUtileriaNotificacion().notificarAlertaEmail(alerta);
                    }
                }

                // Alerta por punto de interes
                if ((TerminalAlerta.getPuntoInteres() != null)
                        && (TerminalAlerta.getPorIdPuntoInteresDistanciaMetros() != null)) {
                    try {

                        // Distancia actual del punto de interes
                        final double distanciaActual = JMMotorDeMapas.obtenerDistanciaEntreDosCoordenadas(
                                this.getLatitud(), this.getLongitud(), TerminalAlerta.getPuntoInteres().getLatitud(),
                                TerminalAlerta.getPuntoInteres().getLongitud());

                        final double distanciaNueva = JMMotorDeMapas.obtenerDistanciaEntreDosCoordenadas(latitud,
                                longitud, TerminalAlerta.getPuntoInteres().getLatitud(), TerminalAlerta
                                        .getPuntoInteres().getLongitud());

                        // si tenia mas distancia
                        if (distanciaActual >= TerminalAlerta.getPorIdPuntoInteresDistanciaMetros().doubleValue()) {
                            if (distanciaNueva <= TerminalAlerta.getPorIdPuntoInteresDistanciaMetros().doubleValue()) {

                                final TerminalAlertaLog alerta = new TerminalAlertaLog();
                                alerta.setTerminal(this);
                                alerta.setTerminalAlerta(TerminalAlerta);
                                alerta.setLatitud(latitud);
                                alerta.setLongitud(longitud);
                                alerta.setTipo("Alerta por Entrada a Punto de Interes: "
                                        + TerminalAlerta.getPuntoInteres().getNombre());
                                alerta.setDescripcion("La unidad entro al Punto de Interes: "
                                        + TerminalAlerta.getPuntoInteres().getNombre()
                                        + ". Actualmente se encuentra a una distancia en metros de : " + distanciaNueva);
                                TerminalAlertaLog.getTerminalAlertaLogService().guardarObjeto(alerta);
                                new JMUtileriaNotificacion().notificarAlertaEmail(alerta);
                            }

                        }
                    } catch (final Exception ex) {
                        JMEntidad.getLogger().error("VerificarAlertas", ex);
                    }
                }

                // Por geocerca - entra
                if (TerminalAlerta.getGeocercaByPorIdGeocercaEntra() != null) {
                    // verificamos que no este dentro ya de la geocerca
                    final JMPuntoGeografico puntoActual = new JMPuntoGeografico(null, null, null, null,
                            this.getLatitud(), this.getLongitud(), this.getNombre(), false);
                    final JMPuntoGeografico puntoNuevo = new JMPuntoGeografico(null, null, null, null, latitud,
                            longitud, this.getNombre(), false);

                    boolean estabaAdentro = false;
                    boolean estaAdentroAhora = false;

                    try {
                        estabaAdentro = JMMotorDeMapas.puntoEnPoligono(TerminalAlerta.getGeocercaByPorIdGeocercaEntra()
                                .toPoligonoGeografico(), puntoActual);
                        estaAdentroAhora = JMMotorDeMapas.puntoEnPoligono(TerminalAlerta
                                .getGeocercaByPorIdGeocercaEntra().toPoligonoGeografico(), puntoNuevo);
                    } catch (final Exception ex) {
                        JMEntidad.getLogger().error("VerificarAlertas", ex);
                    }

                    // Si no estaba adentro y ahora si
                    if (!estabaAdentro && estaAdentroAhora) {
                        final TerminalAlertaLog alerta = new TerminalAlertaLog();
                        alerta.setTerminal(this);
                        alerta.setTerminalAlerta(TerminalAlerta);
                        alerta.setLatitud(latitud);
                        alerta.setLongitud(longitud);
                        alerta.setTipo("Alerta por Entrada a Geocerca: "
                                + TerminalAlerta.getGeocercaByPorIdGeocercaEntra().getNombre());
                        alerta.setDescripcion("La unidad entro a la Geocerca: "
                                + TerminalAlerta.getGeocercaByPorIdGeocercaEntra().getNombre());
                        try {
                            TerminalAlertaLog.getTerminalAlertaLogService().guardarObjeto(alerta);
                        } catch (final Exception ex) {
                            JMEntidad.getLogger().error(
                                    "verificarAlertas => getTerminalAlertaLogService => GuardarObjeto", ex);
                        }
                        new JMUtileriaNotificacion().notificarAlertaEmail(alerta);
                    }
                }

                // Por geocerca - sale
                if (TerminalAlerta.getGeocercaByPorIdGeocercaSale() != null) {

                    final JMPuntoGeografico puntoActual = new JMPuntoGeografico(null, null, null, null,
                            this.getLatitud(), this.getLongitud(), this.getNombre(), false);
                    final JMPuntoGeografico puntoNuevo = new JMPuntoGeografico(null, null, null, null, latitud,
                            longitud, this.getNombre(), false);
                    boolean estabaAfuera = false;
                    boolean estaAfueraAhora = false;

                    try {
                        estabaAfuera = !JMMotorDeMapas.puntoEnPoligono(TerminalAlerta.getGeocercaByPorIdGeocercaSale()
                                .toPoligonoGeografico(), puntoActual);
                        estaAfueraAhora = !JMMotorDeMapas.puntoEnPoligono(TerminalAlerta
                                .getGeocercaByPorIdGeocercaSale().toPoligonoGeografico(), puntoNuevo);
                    } catch (final Exception ex) {
                        JMEntidad.getLogger().error("VerificarAlertas", ex);
                    }

                    // Si no estaba adentro y ahora si
                    if (!estabaAfuera && estaAfueraAhora) {
                        final TerminalAlertaLog alerta = new TerminalAlertaLog();
                        alerta.setTerminal(this);
                        alerta.setTerminalAlerta(TerminalAlerta);
                        alerta.setLatitud(latitud);
                        alerta.setLongitud(longitud);
                        alerta.setTipo("Alerta por Salida a Geocerca: "
                                + TerminalAlerta.getGeocercaByPorIdGeocercaSale().getNombre());
                        alerta.setDescripcion("La unidad salio de la Geocerca: "
                                + TerminalAlerta.getGeocercaByPorIdGeocercaSale().getNombre());
                        try {
                            TerminalAlertaLog.getTerminalAlertaLogService().guardarObjeto(alerta);
                        } catch (final Exception ex) {
                            JMEntidad.getLogger().error(
                                    "verificarAlertas => getTerminalAlertaLogService => GuardarObjeto", ex);
                        }
                        new JMUtileriaNotificacion().notificarAlertaEmail(alerta);
                    }
                }
            }
        }
    }

    public String getIconoUbicacion() {
        return JMConstantes.ICONO_UBICACION;

    }
    
    public String get_idEstado() {
        return this._idEstado;
    }
    
    public void set_idEstado(final String _idEstado) {
        this._idEstado = _idEstado;
    }

    public String get_idBase() {
        return this._idBase;
    }

    public void set_idBase(final String _idBase) {
        this._idBase = _idBase;
    }

    public Boolean getEstaConectada() {
        return this.estaConectada;
    }

    public void setEstaConectada(final Boolean estaConectada) {
        this.estaConectada = estaConectada;
    }

    public Double getDistanciaCalculada() {
        return this.distanciaCalculada;
    }

    public void setDistanciaCalculada(final Double distanciaCalculada) {
        this.distanciaCalculada = distanciaCalculada;
    }

    public int getContadorReportesEsteDia() {
        return this.getReportesEsteDia() != null ? this.getReportesEsteDia().intValue() : 0;
    }
	
	public String get_idGeocerca() {
		return this._idGeocerca;
	}

	public void set_idGeocerca(final String _idGeocerca) {
		this._idGeocerca = _idGeocerca;
	}

	public String get_idOficina() {
		return _idOficina;
	}

	public void set_idOficina(String _idOficina) {
		this._idOficina = _idOficina;
	}

	public String get_idDisMqp() {
		return _idDisMqp;
	}

	public void set_idDisMqp(String _idDisMqp) {
		this._idDisMqp = _idDisMqp;
	}

	public String get_idDisMqs() {
		return _idDisMqs;
	}

	public void set_idDisMqs(String _idDisMqs) {
		this._idDisMqs = _idDisMqs;
	}

	public String get_idVehiculoMar() {
		return _idVehiculoMar;
	}

	public void set_idVehiculoMar(String _idVehiculoMar) {
		this._idVehiculoMar = _idVehiculoMar;
	}

	public String get_razonEstatus() {
		return _razonEstatus;
	}

	public void set_razonEstatus(String _razonEstatus) {
		this._razonEstatus = _razonEstatus;
	}

	public String get_dirEstado() {
		return _dirEstado;
	}

	public void set_dirEstado(String _dirEstado) {
		this._dirEstado = _dirEstado;
	}
	
	
	
}
