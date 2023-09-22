package com.aaq.col.system.beans.aplicacion.alarma;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.math.NumberUtils;

import com.aaq.col.clases.database.entidades.NotasReporte;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "beanAplicacionNotaReporte")
@SessionScoped
public class BeanAplicacionNotaReporte extends JMBeanExtensiblePrincipal<Terminal> {

	private static final long serialVersionUID = -8410877266903193865L;
	
	private Terminal actualTerminal;
	private String txtNota;
	private NotasReporte objetoNotasReporte;
    private List<NotasReporte> notas =null;
    private String _causaNota;

	
	public BeanAplicacionNotaReporte() {
		super();
	}

	@Override
	public void actualizarListado() {
		
	}
	
	public void doAccionRegistroNotasBtn(final ActionEvent e) {
    	
    	if(this.getTxtNota() == null) {
	    	this.ponerMensajeError("Es necesario ingresar una nota del reporte.");
	    	return ;
    	}
    	
    	if (this.get_causaNota() == null) {
    		this.ponerMensajeError("Es necesario seleccionar 'Causa De Nota'.");
	    	return ;
		}
    	
    	if (this.get_causaNota().contains("seleccionar")) {
    		this.ponerMensajeError("Es necesario seleccionar 'Causa De Nota'.");
	    	return ;
		}
    	
		if (this.getActualTerminal() != null) {
			if (this.getActualTerminal().getReporteAtendiendo() != null) {
				
		NotasReporte notasReporte = new NotasReporte();
			notasReporte.setNotas(this.getTxtNota());
			notasReporte.setEstado(this.getActualTerminal().getEstado());
			notasReporte.setBase(this.getActualTerminal().getBase());
			notasReporte.setReporte(this.getActualTerminal().getReporteAtendiendo());
			notasReporte.setTerminal(this.getActualTerminal());
			notasReporte.setUsuario(this.getUsuarioActual().getUsername());
			notasReporte.setCausaNota(this.get_causaNota());
	    	JMResultadoOperacion salida = notasReporte.guardarObjeto();
	    	if (salida != null) {
	    		this.ponerMensajeResultado(salida);
	    		this.doAccionListaNotas(e);
	    		this.limpiarDatos();
				return ;
			} else {
				this.ponerMensajeError("Nota No Guardada.");
				this.limpiarDatos();
				this.doAccionListaNotas(e);
				return ;
			}
			} else {
				this.ponerMensajeError("Reporte SAC no encontrado.");
				this.limpiarDatos();
				this.doAccionListaNotas(e);
				return ;
			}
			
		} else {
			this.ponerMensajeError("Terminal no encontrada");
			this.doAccionListaNotas(e);
			this.limpiarDatos();
			return ;
		}
    	
	}
    
	public void doAccionListaNotas(final ActionEvent e) {
		if(this.getActualTerminal() == null){
			return;
		} else{
			this.notas  = this.getNotasReporteService().listarNotas(this.getActualTerminal(), this.getActualTerminal().getReporteAtendiendo());
		}
	}


	public NotasReporte getObjetoNotasReporte() {
		return objetoNotasReporte;
	}

	public void setObjetoNotasReporte(NotasReporte objetoNotasReporte) {
		this.objetoNotasReporte = objetoNotasReporte;
	}

	public List<NotasReporte> getNotas() {
		return notas;
	}

	public void setNotas(List<NotasReporte> notas) {
		this.notas = notas;
	}

	public String doAccionNotas() {
		this.limpiarDatos();

		Terminal terminal = null;
		try {
			terminal = this.getTerminalService().objetoTerminal(this.obtenerParametroDeRequest(JMConstantes.WEB_PARAMETRO_IDENTI));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionCobroWeb");
		}

		if (terminal != null) {
			this.setActualTerminal(terminal);
			this.doAccionListaNotas(null);
			return "notasReporte";
		}

		return null;
	}
	
	public void doAccionRegistroEliminarNota(final ActionEvent e){
		this.setObjetoNotasReporte(this.getNotas().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
		
		if (this.objetoNotasReporte == null) {
            this.ponerMensajeError("No se encontro registro para eliminar");
        }
        else {
            try {
                final JMResultadoOperacion r = this.objetoNotasReporte.eliminarObjeto();
                if (r.isExito()) {
                    this.ponerMensajeInfo(r.getMensaje());
                }
                else {
                    this.ponerMensajeError("Error al intentar eliminar el registro: " + r.getMensaje());
                }
            }
            catch (Exception ex) {
                getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroEliminar -> " + ex.getMessage()), (Throwable)ex);
                this.ponerMensajeError("Excepcion al intentar eliminar el registro: " + ex.getMessage());
            }
        }
		this.notas  = this.getNotasReporteService().listarNotas(this.getActualTerminal(), this.getActualTerminal().getReporteAtendiendo());
	}
	
	private void limpiarDatos() {
		this.setTxtNota(null);
		this.set_causaNota(null);
	}

	public Terminal getActualTerminal() {
		return actualTerminal;
	}

	public void setActualTerminal(Terminal actualTerminal) {
		this.actualTerminal = actualTerminal;
	}

	public String getTxtNota() {
		return txtNota;
	}

	public void setTxtNota(String txtNota) {
		this.txtNota = txtNota;
	}

	public String get_causaNota() {
		return _causaNota;
	}

	public void set_causaNota(String _causaNota) {
		this._causaNota = _causaNota;
	}

	
	
}
