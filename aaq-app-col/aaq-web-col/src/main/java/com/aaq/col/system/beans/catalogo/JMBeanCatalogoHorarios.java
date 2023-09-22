package com.aaq.col.system.beans.catalogo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Calendar;

import com.aaq.col.clases.database.entidades.Horarios;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.HorariosDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "beanCatalogoHorarios")
@ViewScoped
public class JMBeanCatalogoHorarios extends JMBeanExtensiblePrincipal<Horarios> {
	private static final long serialVersionUID = -8267415766637489956L;

	private String clave_horarioS;
	private Date hora_entradaL;
	private Date hora_salidaL;
	private Boolean descansoL;
	private Date hora_entradaLx;
	private Date hora_salidaLx;
	private Date hora_entradaM;
	private Date hora_salidaM;
	private Boolean descansoM;
	private Date hora_entradaMx;
	private Date hora_salidaMx;
	private Date hora_entradaMi;
	private Date hora_salidaMi;
	private Boolean descansoMi;
	
	private Date hora_entradaMix;
	private Date hora_salidaMix;
	
	private Date hora_entradaJ;
	private Date hora_salidaJ;
	private Boolean descansoJ;
	
	private Date hora_entradaJx;
	private Date hora_salidaJx;
	
	private Date hora_entradaV;
	private Date hora_salidaV;
	private Boolean descansoV;
	
	private Date hora_entradaVx;
	private Date hora_salidaVx;
	
	private Date hora_entradaS;
	private Date hora_salidaS;
	private Boolean descansoS;

	private Date hora_entradaSx;
	private Date hora_salidaSx;
	
	private Date hora_entradaD;
	private Date hora_salidaD;
	private Boolean descansoD;
	
	private Date hora_entradaDx;
	private Date hora_salidaDx;
	
	private Boolean extraL = false;
	private Boolean extraM= false;
	private Boolean extraMi= false;
	private Boolean extraJ= false;
	private Boolean extraV= false;
	private Boolean extraS= false;
	private Boolean extraD= false;
	
	private Date hora_entrada;
	private Date hora_salida;

	public JMBeanCatalogoHorarios() {
		super();
		this.actualizarListado();

	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new HorariosDataModel(this.getHorariosService().listaDeHorarios(
					StringUtils.isNotBlank(this.getIdEstado()) ? this.getEstadoService().objetoEstado(
							this.getIdEstado()) : null, null
							)));

			if (this.getClaveHorario().equals("-9999") ) {
				this.setListado(new HorariosDataModel(this.getHorariosService().listaDeHorarios(
						StringUtils.isNotBlank(this.getIdEstado()) ? this.getEstadoService().objetoEstado(
										this.getIdEstado()) : null, null)));
			} else {
				this.setListado(new HorariosDataModel(this.getHorariosService().listaDeHorarios(this.getClaveHorario())));
			}
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}
	
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(
				new String[] { "Estado,estado", "Nombre de Horario,clave_horario", "Día,dia_semana", "Hora Entrada,horarioEntrada", "Hora Salida,horarioSalida" }).getLista();
	}


	
	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		// generar N objetos tipo Horarios y los voy agregar en una lista 
		// barrer la lista y mandar el objeto orario set objeto abm
		if(this.getPermisoSIICAGlobalEstados()) {
			this.setObjetoABM(new Horarios());
			this.getObjetoABM().get_idEstado();
		} else {
			this.setObjetoABM(new Horarios(this.getIdEstado()));		}
	}
	
	public void doAccionRegistroEditarHora(final ActionEvent e) {
        this.setObjetoABM(  this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
        if (this.getObjetoABM() == null) {
            this.ponerMensajeError("No se encontro registro para editar");
            return;
        }
        try {
            this.getObjetoABM().editarObjeto();
            this.setHora_entrada(obtenerFecha(this.getObjetoABM().getHora_entrada()));
            this.setHora_salida(obtenerFecha(this.getObjetoABM().getHora_salida()));
        }
        catch (Exception ex) {
            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroEditar -> " + ex.getMessage()), (Throwable)ex);
        }
    }
		
	public void doAccionRegistroGuardarHora(final ActionEvent e) {
		 try {	
			 	this.getObjetoABM().setHora_entrada(obtenCadenaHora(hora_entrada));
			 	this.getObjetoABM().setHora_salida(obtenCadenaHora(hora_salida));
	            final JMResultadoOperacion r = this.getObjetoABM().guardarObjeto();
	            if (r.isExito()) {
	                this.ponerMensajeInfo(r.getMensaje());
	            }
	            else {
	                this.ponerMensajeError("Registro No Guardado: " + r.getMensaje());
	            }
	        }
	        catch (Exception ex) {
	            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroGuardar -> " + ex.getMessage()), (Throwable)ex);
	        }
	        this.actualizarListado();
	}
	
	@Override
    public void doAccionRegistroGuardar(final ActionEvent e) {
    	Horarios horarioL = new Horarios();
    	Horarios horarioM = new Horarios();
    	Horarios horarioMi = new Horarios();
    	Horarios horarioJ = new Horarios();
    	Horarios horarioV = new Horarios();
    	Horarios horarioS = new Horarios();
    	Horarios horarioD = new Horarios();
    	Horarios horarioLx = new Horarios();
    	Horarios horarioMx = new Horarios();
    	Horarios horarioMix = new Horarios();
    	Horarios horarioJx = new Horarios();
    	Horarios horarioVx = new Horarios();
    	Horarios horarioSx = new Horarios();
    	Horarios horarioDx = new Horarios();
    	List<Horarios> horarioSemana = new ArrayList<>();
    	
    	horarioL.setClave_horario(clave_horarioS);
    	horarioL.setDia_semana_num(1);
    	horarioL.setDia_semana("Lunes");
    	horarioL.setHora_entrada(this.obtenCadenaHora(hora_entradaL));
    	horarioL.setHora_salida(this.obtenCadenaHora(hora_salidaL));
    	horarioL.setDescanso(descansoL);
    	horarioL.set_idEstado(this.getObjetoABM().get_idEstado());
    	horarioSemana.add(horarioL);
    	if (extraL) {
    		horarioLx.setClave_horario(clave_horarioS);
        	horarioLx.setDia_semana_num(1);
        	horarioLx.setDia_semana("Lunes");
        	horarioLx.setHora_entrada(this.obtenCadenaHora(hora_entradaLx));
        	horarioLx.setHora_salida(this.obtenCadenaHora(hora_salidaLx));
        	horarioLx.setDescanso(descansoL);
        	horarioLx.set_idEstado(this.getObjetoABM().get_idEstado());
        	horarioSemana.add(horarioLx);
		}
    	
    	horarioM.setClave_horario(clave_horarioS);
    	horarioM.setDia_semana_num(2);
    	horarioM.setDia_semana("Martes");
    	horarioM.setHora_entrada(this.obtenCadenaHora(hora_entradaM));
    	horarioM.setHora_salida(this.obtenCadenaHora(hora_salidaM));
    	horarioM.setDescanso(descansoM);
    	horarioM.set_idEstado(this.getObjetoABM().get_idEstado());
    	horarioSemana.add(horarioM);
    	
    	if (extraM) {
    		horarioMx.setClave_horario(clave_horarioS);
        	horarioMx.setDia_semana_num(2);
        	horarioMx.setDia_semana("Martes");
        	horarioMx.setHora_entrada(this.obtenCadenaHora(hora_entradaMx));
        	horarioMx.setHora_salida(this.obtenCadenaHora(hora_salidaMx));
        	horarioMx.setDescanso(descansoM);
        	horarioMx.set_idEstado(this.getObjetoABM().get_idEstado());
        	horarioSemana.add(horarioMx);
		}
    	
    	horarioMi.setClave_horario(clave_horarioS);
    	horarioMi.setDia_semana_num(3);
    	horarioMi.setDia_semana("Miércoles");
    	horarioMi.setHora_entrada(this.obtenCadenaHora(hora_entradaMi));
    	horarioMi.setHora_salida(this.obtenCadenaHora(hora_salidaMi));
    	horarioMi.setDescanso(descansoMi);
    	horarioMi.set_idEstado(this.getObjetoABM().get_idEstado());
    	horarioSemana.add(horarioMi);
    	
    	if (extraMi) {
    		horarioMix.setClave_horario(clave_horarioS);
        	horarioMix.setDia_semana_num(3);
        	horarioMix.setDia_semana("Miércoles");
        	horarioMix.setHora_entrada(this.obtenCadenaHora(hora_entradaMix));
        	horarioMix.setHora_salida(this.obtenCadenaHora(hora_salidaMix));
        	horarioMix.setDescanso(descansoMi);
        	horarioMix.set_idEstado(this.getObjetoABM().get_idEstado());
        	horarioSemana.add(horarioMix);
		}
    	
    	horarioJ.setClave_horario(clave_horarioS);
    	horarioJ.setDia_semana_num(4);
    	horarioJ.setDia_semana("Jueves");
    	horarioJ.setHora_entrada(this.obtenCadenaHora(hora_entradaJ));
    	horarioJ.setHora_salida(this.obtenCadenaHora(hora_salidaJ));
    	horarioJ.setDescanso(descansoJ);
    	horarioJ.set_idEstado(this.getObjetoABM().get_idEstado());
    	horarioSemana.add(horarioJ);
    	
    	if (extraJ) {
    		horarioJx.setClave_horario(clave_horarioS);
        	horarioJx.setDia_semana_num(4);
        	horarioJx.setDia_semana("Jueves");
        	horarioJx.setHora_entrada(this.obtenCadenaHora(hora_entradaJx));
        	horarioJx.setHora_salida(this.obtenCadenaHora(hora_salidaJx));
        	horarioJx.setDescanso(descansoJ);
        	horarioJx.set_idEstado(this.getObjetoABM().get_idEstado());
        	horarioSemana.add(horarioJx);
		}
    	
    	horarioV.setClave_horario(clave_horarioS);
    	horarioV.setDia_semana_num(5);
    	horarioV.setDia_semana("Viernes");
    	horarioV.setHora_entrada(this.obtenCadenaHora(hora_entradaV));
    	horarioV.setHora_salida(this.obtenCadenaHora(hora_salidaV));
    	horarioV.setDescanso(descansoV);
    	horarioV.set_idEstado(this.getObjetoABM().get_idEstado());
    	horarioSemana.add(horarioV);
    	
    	if (extraV) {
    		horarioVx.setClave_horario(clave_horarioS);
        	horarioVx.setDia_semana_num(5);
        	horarioVx.setDia_semana("Viernes");
        	horarioVx.setHora_entrada(this.obtenCadenaHora(hora_entradaVx));
        	horarioVx.setHora_salida(this.obtenCadenaHora(hora_salidaVx));
        	horarioVx.setDescanso(descansoV);
        	horarioVx.set_idEstado(this.getObjetoABM().get_idEstado());
        	horarioSemana.add(horarioVx);
		}
    	
    	horarioS.setClave_horario(clave_horarioS);
    	horarioS.setDia_semana_num(6);
    	horarioS.setDia_semana("Sábado");
    	horarioS.setHora_entrada(this.obtenCadenaHora(hora_entradaS));
    	horarioS.setHora_salida(this.obtenCadenaHora(hora_salidaS));
    	horarioS.setDescanso(descansoS);
    	horarioS.set_idEstado(this.getObjetoABM().get_idEstado());
    	horarioSemana.add(horarioS);
    	
    	if (extraS) {
    		horarioSx.setClave_horario(clave_horarioS);
        	horarioSx.setDia_semana_num(6);
        	horarioSx.setDia_semana("Sábado");
        	horarioSx.setHora_entrada(this.obtenCadenaHora(hora_entradaSx));
        	horarioSx.setHora_salida(this.obtenCadenaHora(hora_salidaSx));
        	horarioSx.setDescanso(descansoS);
        	horarioSx.set_idEstado(this.getObjetoABM().get_idEstado());
        	horarioSemana.add(horarioSx);
		}
    	
    	horarioD.setClave_horario(clave_horarioS);
    	horarioD.setDia_semana_num(7);
    	horarioD.setDia_semana("Domingo");
    	horarioD.setHora_entrada(this.obtenCadenaHora(hora_entradaD));
    	horarioD.setHora_salida(this.obtenCadenaHora(hora_salidaD));
    	horarioD.setDescanso(descansoD);
    	horarioD.set_idEstado(this.getObjetoABM().get_idEstado());
    	horarioSemana.add(horarioD);
    	
    	if (extraD) {
    		horarioDx.setClave_horario(clave_horarioS);
        	horarioDx.setDia_semana_num(7);
        	horarioDx.setDia_semana("Domingo");
        	horarioDx.setHora_entrada(this.obtenCadenaHora(hora_entradaDx));
        	horarioDx.setHora_salida(this.obtenCadenaHora(hora_salidaDx));
        	horarioDx.setDescanso(descansoS);
        	horarioDx.set_idEstado(this.getObjetoABM().get_idEstado());
        	horarioSemana.add(horarioDx);
        	
		}
    	
        try {
        	for (Horarios horarios : horarioSemana) {
				this.setObjetoABM(horarios);
        		 final JMResultadoOperacion r = horarios.guardarObjeto();
        		if (r.isExito()) {
        			this.ponerMensajeInfo(r.getMensaje());
        		}
        		else {
        			this.ponerMensajeError("Registro No Guardado: " + r.getMensaje());
        		}
//				super.doAccionRegistroGuardar(e);
			}
        }
        catch (Exception ex) {
            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroGuardar -> " + ex.getMessage()), (Throwable)ex);
        }
        this.actualizarListado();
        
        this.setClave_horarioS("");
        this.setHora_entradaL(null);
        this.setHora_salidaL(null);
        this.setDescansoL(false);
        
        this.setHora_entradaM(null);
        this.setHora_salidaM(null);
        this.setDescansoM(false);
        
        this.setHora_entradaMi(null);
        this.setHora_salidaMi(null);
        this.setDescansoMi(false);
        
        this.setHora_entradaJ(null);
        this.setHora_salidaJ(null);
        this.setDescansoJ(false);
        
        this.setHora_entradaV(null);
        this.setHora_salidaV(null);
        this.setDescansoV(false);

        this.setHora_entradaS(null);
        this.setHora_salidaS(null);
        this.setDescansoS(false);
        
        this.setHora_entradaD(null);
        this.setHora_salidaD(null);
        this.setDescansoD(false);
        
        this.setHora_entradaLx(null);
        this.setHora_salidaLx(null);
        this.setExtraL(false);
        
        this.setHora_entradaMx(null);
        this.setHora_salidaMx(null);
        this.setExtraM(false);
        
        this.setHora_entradaMix(null);
        this.setHora_salidaMix(null);
        this.setExtraMi(false);
        
        this.setHora_entradaJx(null);
        this.setHora_salidaJx(null);
        this.setExtraJ(false);
        
        this.setHora_entradaVx(null);
        this.setHora_salidaVx(null);
        this.setExtraV(false);

        this.setHora_entradaSx(null);
        this.setHora_salidaSx(null);
        this.setExtraS(false);
        
        this.setHora_entradaDx(null);
        this.setHora_salidaDx(null);
        this.setExtraD(false);
    }
	
	private String obtenCadenaHora(Date hora) {
		String cadenaHora = null;
		if ( hora == null) {
			cadenaHora = null;
		} else {
			cadenaHora = DateFormatUtils.format(hora, "HH:mm");			
		}
		
		return cadenaHora;
	}
	
	private Date obtenerFecha(String horario){	
		String horasplit []= horario.split(":");
		
		Calendar rightNow = Calendar.getInstance();
		rightNow.set(Calendar.HOUR_OF_DAY, Integer.parseInt(horasplit[0]));
		rightNow.set(Calendar.MINUTE, Integer.parseInt(horasplit[1]));
		Date now = rightNow.getTime();

		return now;
	}

//	Eliminar horarios 
	
	@Override
public void doAccionRegistroEliminar( final ActionEvent e ) {
	Horarios horarios = null;
	try {
		horarios =    this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id")));
//		Log.info("horarios "+horarios);

	} catch (Exception ex) {
        getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroEliminar-> " + ex.getMessage()), (Throwable)ex);
	}
	if (horarios != null) {
		horarios.eliminarObjeto();
		 this.actualizarListado();
	}
}
	
	// **************************************************************//
	// Permisos
	// **************************************************************//

	/**
	 * @return el permiso
	 */

	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogo/horarios.siica");

	}

	// **************************************************************//
	// Getters y setters
	// **************************************************************//
	public Date getHora_entradaL() {
		return hora_entradaL;
	}

	public void setHora_entradaL(Date hora_entradaL) {
		this.hora_entradaL = hora_entradaL;
	}

	public Date getHora_salidaL() {
		return hora_salidaL;
	}

	public void setHora_salidaL(Date hora_salidaL) {
		this.hora_salidaL = hora_salidaL;
	}

	public Boolean getDescansoL() {
		return descansoL;
	}

	public void setDescansoL(Boolean descansoL) {
		this.descansoL = descansoL;
	}

	public Date getHora_entradaM() {
		return hora_entradaM;
	}

	public void setHora_entradaM(Date hora_entradaM) {
		this.hora_entradaM = hora_entradaM;
	}

	public Date getHora_salidaM() {
		return hora_salidaM;
	}

	public void setHora_salidaM(Date hora_salidaM) {
		this.hora_salidaM = hora_salidaM;
	}

	public Boolean getDescansoM() {
		return descansoM;
	}

	public void setDescansoM(Boolean descansoM) {
		this.descansoM = descansoM;
	}

	public Date getHora_entradaMi() {
		return hora_entradaMi;
	}

	public void setHora_entradaMi(Date hora_entradaMi) {
		this.hora_entradaMi = hora_entradaMi;
	}

	public Date getHora_salidaMi() {
		return hora_salidaMi;
	}

	public void setHora_salidaMi(Date hora_salidaMi) {
		this.hora_salidaMi = hora_salidaMi;
	}

	public Boolean getDescansoMi() {
		return descansoMi;
	}

	public void setDescansoMi(Boolean descansoMi) {
		this.descansoMi = descansoMi;
	}

	public Date getHora_entradaJ() {
		return hora_entradaJ;
	}

	public void setHora_entradaJ(Date hora_entradaJ) {
		this.hora_entradaJ = hora_entradaJ;
	}

	public Date getHora_salidaJ() {
		return hora_salidaJ;
	}

	public void setHora_salidaJ(Date hora_salidaJ) {
		this.hora_salidaJ = hora_salidaJ;
	}

	public Boolean getDescansoJ() {
		return descansoJ;
	}

	public void setDescansoJ(Boolean descansoJ) {
		this.descansoJ = descansoJ;
	}

	public Date getHora_entradaV() {
		return hora_entradaV;
	}

	public void setHora_entradaV(Date hora_entradaV) {
		this.hora_entradaV = hora_entradaV;
	}

	public Date getHora_salidaV() {
		return hora_salidaV;
	}

	public void setHora_salidaV(Date hora_salidaV) {
		this.hora_salidaV = hora_salidaV;
	}

	public Boolean getDescansoV() {
		return descansoV;
	}

	public void setDescansoV(Boolean descansoV) {
		this.descansoV = descansoV;
	}

	public Date getHora_entradaS() {
		return hora_entradaS;
	}

	public void setHora_entradaS(Date hora_entradaS) {
		this.hora_entradaS = hora_entradaS;
	}

	public Date getHora_salidaS() {
		return hora_salidaS;
	}

	public void setHora_salidaS(Date hora_salidaS) {
		this.hora_salidaS = hora_salidaS;
	}

	public Boolean getDescansoS() {
		return descansoS;
	}

	public void setDescansoS(Boolean descansoS) {
		this.descansoS = descansoS;
	}

	public Date getHora_entradaD() {
		return hora_entradaD;
	}

	public void setHora_entradaD(Date hora_entradaD) {
		this.hora_entradaD = hora_entradaD;
	}

	public Date getHora_salidaD() {
		return hora_salidaD;
	}

	public void setHora_salidaD(Date hora_salidaD) {
		this.hora_salidaD = hora_salidaD;
	}

	public Boolean getDescansoD() {
		return descansoD;
	}

	public void setDescansoD(Boolean descansoD) {
		this.descansoD = descansoD;
	}

	public String getClave_horarioS() {
		return clave_horarioS;
	}

	public void setClave_horarioS(String clave_horarioS) {
		this.clave_horarioS = clave_horarioS;
	}

	public Date getHora_entradaLx() {
		return hora_entradaLx;
	}

	public void setHora_entradaLx(Date hora_entradaLx) {
		this.hora_entradaLx = hora_entradaLx;
	}

	public Date getHora_salidaLx() {
		return hora_salidaLx;
	}

	public void setHora_salidaLx(Date hora_salidaLx) {
		this.hora_salidaLx = hora_salidaLx;
	}

	public Date getHora_entradaMx() {
		return hora_entradaMx;
	}

	public void setHora_entradaMx(Date hora_entradaMx) {
		this.hora_entradaMx = hora_entradaMx;
	}

	public Date getHora_salidaMx() {
		return hora_salidaMx;
	}

	public void setHora_salidaMx(Date hora_salidaMx) {
		this.hora_salidaMx = hora_salidaMx;
	}

	public Date getHora_entradaMix() {
		return hora_entradaMix;
	}

	public void setHora_entradaMix(Date hora_entradaMix) {
		this.hora_entradaMix = hora_entradaMix;
	}

	public Date getHora_salidaMix() {
		return hora_salidaMix;
	}

	public void setHora_salidaMix(Date hora_salidaMix) {
		this.hora_salidaMix = hora_salidaMix;
	}

	public Date getHora_entradaJx() {
		return hora_entradaJx;
	}

	public void setHora_entradaJx(Date hora_entradaJx) {
		this.hora_entradaJx = hora_entradaJx;
	}

	public Date getHora_salidaJx() {
		return hora_salidaJx;
	}

	public void setHora_salidaJx(Date hora_salidaJx) {
		this.hora_salidaJx = hora_salidaJx;
	}

	public Date getHora_entradaVx() {
		return hora_entradaVx;
	}

	public void setHora_entradaVx(Date hora_entradaVx) {
		this.hora_entradaVx = hora_entradaVx;
	}

	public Date getHora_salidaVx() {
		return hora_salidaVx;
	}

	public void setHora_salidaVx(Date hora_salidaVx) {
		this.hora_salidaVx = hora_salidaVx;
	}

	public Date getHora_entradaSx() {
		return hora_entradaSx;
	}

	public void setHora_entradaSx(Date hora_entradaSx) {
		this.hora_entradaSx = hora_entradaSx;
	}

	public Date getHora_salidaSx() {
		return hora_salidaSx;
	}

	public void setHora_salidaSx(Date hora_salidaSx) {
		this.hora_salidaSx = hora_salidaSx;
	}

	public Date getHora_entradaDx() {
		return hora_entradaDx;
	}

	public void setHora_entradaDx(Date hora_entradaDx) {
		this.hora_entradaDx = hora_entradaDx;
	}

	public Date getHora_salidaDx() {
		return hora_salidaDx;
	}

	public void setHora_salidaDx(Date hora_salidaDx) {
		this.hora_salidaDx = hora_salidaDx;
	}

	public Boolean getExtraL() {
		return extraL;
	}

	public void setExtraL(Boolean extraL) {
		if (extraL) {
			this.setHora_salidaLx(null);
			this.setHora_entradaLx(null);			
		}
		this.extraL = extraL;
	}

	public Boolean getExtraM() {
		return extraM;
	}

	public void setExtraM(Boolean extraM) {
		this.extraM = extraM;
	}

	public Boolean getExtraMi() {
		return extraMi;
	}

	public void setExtraMi(Boolean extraMi) {
		this.extraMi = extraMi;
	}

	public Boolean getExtraJ() {
		return extraJ;
	}

	public void setExtraJ(Boolean extraJ) {
		this.extraJ = extraJ;
	}

	public Boolean getExtraV() {
		return extraV;
	}

	public void setExtraV(Boolean extraV) {
		this.extraV = extraV;
	}

	public Boolean getExtraS() {
		return extraS;
	}

	public void setExtraS(Boolean extraS) {
		this.extraS = extraS;
	}

	public Boolean getExtraD() {
		return extraD;
	}

	public void setExtraD(Boolean extraD) {
		this.extraD = extraD;
	}

	public Date getHora_entrada() {
		return hora_entrada;
	}

	public void setHora_entrada(Date hora_entrada) {
		this.hora_entrada = hora_entrada;
	}

	public Date getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(Date hora_salida) {
		this.hora_salida = hora_salida;
	}
	
	
	
}
