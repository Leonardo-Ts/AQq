package com.aaq.col.clases.database.entidades;

import com.aaq.col.clases.database.entidades.abstracto.AbstractCorreoPolizaAgente;
import com.aaq.col.clases.database.servicios.interfase.CorreoPolizaAgenteServiceInterfase;
import com.aaq.col.clases.database.singleton.JMSIICAServerServiceSingleton;
import com.jmfg.jmlib.sistema.classes.jmlibreria.*;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

import org.springframework.dao.DataAccessException;


@ManagedBean(name = "correoPolizaAgente")
@RequestScoped
@Entity(name = "CorreoPolizaAgente")
@Cacheable(false)
@Access(AccessType.FIELD)
@Table(name = "correo_poliza_agente")
public class CorreoPolizaAgente extends AbstractCorreoPolizaAgente {
    private static final long serialVersionUID = -4902569510844617382L;

    @Transient
    private String _poliza;
    

    // **************************************************************//
    // Constructor
    // **************************************************************//

    /**
     * default constructor
     */
    public CorreoPolizaAgente() {
        super();
        this.setPoliza("");
        this.setCorreos("");
        this.setClaveAgente("");
        }

    // **************************************************************//
    private static CorreoPolizaAgenteServiceInterfase correoPolizaAgenteService;

    public static CorreoPolizaAgenteServiceInterfase getCorreoPolizaAgenteService() {
        if (CorreoPolizaAgente.correoPolizaAgenteService == null) {
            CorreoPolizaAgente.correoPolizaAgenteService = JMSIICAServerServiceSingleton.getInstance().getCorreoPolizaAgenteService();
        }
        return CorreoPolizaAgente.correoPolizaAgenteService;
    }

	@Override
	public JMResultadoOperacion editarObjeto() {
		try {
			return CorreoPolizaAgente.getCorreoPolizaAgenteService().guardarObjeto(this);
		}  catch (PersistenceException | IndexOutOfBoundsException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		}  catch ( DataAccessException e) {
			return new JMResultadoOperacion(e.getMessage());
		} 
	}

	public JMResultadoOperacion eliminarObjeto() {
		try {
			return CorreoPolizaAgente.getCorreoPolizaAgenteService().eliminarObjeto(this);
			
		} catch (IndexOutOfBoundsException | RollbackException e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		} 	catch ( DataAccessException e) {
			return new JMResultadoOperacion(e.getMessage());
		} 
	}
	
	@Override
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(
				new String[] {  "Poliza,poliza", "Correos,correos", "Clave de agente,claveAgente"}).getLista();
	}

	@Override
	public JMResultadoOperacion guardarObjeto() {
		try {
			return CorreoPolizaAgente.getCorreoPolizaAgenteService().guardarObjeto(this);
		} catch (IndexOutOfBoundsException | RollbackException e) {
			return new JMResultadoOperacion(e);
		}  catch (PersistenceException e) {
			return new JMResultadoOperacion(e);
		}   catch (ClassCastException | UnsupportedOperationException | IllegalArgumentException | IllegalStateException e) {
			return new JMResultadoOperacion(e);
		}  catch (ClassFormatError |InternalError | OutOfMemoryError | UnknownError e) {
			return new JMResultadoOperacion(e.getMessage());
		} catch (DataAccessException e) {
			return new JMResultadoOperacion(e.getMessage());
		} 
			
	}
	
	@Override
	public int hashCode() {
		return this.getId() != null ? this.getId().intValue() : super.hashCode();
	}

	public String get_poliza() {
		return _poliza;
	}

	public void set_poliza(String _poliza) {
		this._poliza = _poliza;
	}
   
	
}
