package com.aaq.col.system.webservices;

import java.util.Date;

import javax.json.JsonException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.apache.axis.InternalException;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.google.gson.Gson;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMConstantesComunes;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.aaq.col.clases.database.entidades.CodigoResponsabilidadEstad;
import com.aaq.col.clases.database.entidades.ControlFotografias;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.database.entidades.pojo.FormatoServicioErrores;
import com.aaq.col.clases.database.servicios.interfase.CodigoResponsabilidadEstadServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.ControlFotografiasServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.HistoricoTerminalServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.SacSP_ServiceInterfase;
import com.aaq.col.clases.database.servicios.interfase.TerminalServiceInterfase;
import com.aaq.col.clases.pojo.aaq.DatosCodigosResponsabilidad;
import com.aaq.col.clases.pojo.aaq.ExamenTEP;
import com.aaq.col.clases.pojo.aaq.FotografiasReg;
import com.aaq.col.clases.util.FormatoEliminarClob;
import com.aaq.col.clases.util.JMUtileriaExcepcion;
import com.aaq.col.clases.util.UtileriaFechas;
import com.aaq.col.clases.webservices.movil.peticion.MovilResultadoOperacion;
import com.aaq.col.system.model.ExternoHistoricoT;

public class MovilRestService implements MovilRestServiceInterfase{


	private final JMUtileriaExcepcion utileriaExcepcion = new JMUtileriaExcepcion(
            JMConstantesComunes.LOG_JMLIB_UTILERIAS_WEB_SERVICES);
   
	private final String fuenteWS = "Servicios REST Movil -> ";
	FormatoEliminarClob limpiar= new FormatoEliminarClob();
	FormatoServicioErrores formatoServicioErrores = new FormatoServicioErrores();

	@Autowired
    private TerminalServiceInterfase terminalDao;
    
    @Autowired
    private CodigoResponsabilidadEstadServiceInterfase codigoResponsabilidadEstadService;
    
    @Autowired
	private HistoricoTerminalServiceInterfase historicoTerminalServiceInterfase;
    
    @Autowired
    private SacSP_ServiceInterfase sacService;
	
    @Autowired
    private ControlFotografiasServiceInterfase controlFotografiasService;
 
   
	@Override
	public MovilResultadoOperacion estadisticaCodigoResp(DatosCodigosResponsabilidad entrada) {
		if (entrada == null) {
			return new MovilResultadoOperacion(false, "Es necesario especificar los datos de entrada.");
		}
		if (StringUtils.isBlank(entrada.getUsuario())) {
			return new MovilResultadoOperacion(false, "Es necesario especificar 'usuario'.");
		}
		if (StringUtils.isBlank(entrada.getPwd())) {
			return new MovilResultadoOperacion(false, "Es necesario especificar 'pwd'.");
		}
		if (StringUtils.isBlank(entrada.getNumeroReporte())) {
			return new MovilResultadoOperacion(false, "Es necesario especificar 'numeroReporte'.");
		}
		if (entrada.getFechaOcurrido() != null) {
			UtileriaFechas utilfechas = new UtileriaFechas();
			boolean valida = utilfechas.validarFecha(entrada.getFechaOcurrido());
			if (!valida) {
				return new MovilResultadoOperacion(false, "Formato de fechaOcurrido no valida. Valido dd/MM/yyyy HH:mm:ss");
			}
		}
		
		Terminal terminal = null;
		try {
			terminal = this.terminalDao.objetoTerminalParaProveedorYPasswd(entrada.getUsuario(), entrada.getPwd());
		} catch (  DataAccessException | ClassCastException | RollbackException | CannotResolveClassException e1) {
    		this.utileriaExcepcion.manejarExcepcion(e1, this.getClass(), "Ocurrio un error en terminalDao.objetoTerminalParaNumeroReporte ->"+e1);
		}
		 
		if (terminal == null) {
            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o contraseña son invalidos");
	     }
		
		try {
        	Gson json = new Gson();
        	String peticion = json.toJson(entrada);
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumeroReporte(),
		               fuenteWS + "estadisticaCodigoResp", "Codigo de Responsabilidad estadistica V3", "Peticion: "+peticion);
    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
		} catch (PersistenceException | DataAccessException |JsonException ex) {
    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
		}
		
		try {
			CodigoResponsabilidadEstad est = new CodigoResponsabilidadEstad();
				est.setClaveAjustador(entrada.getUsuario());
				est.setCodigoCausa(entrada.getCodigoCausa());
				est.setCodigoMatriz(entrada.getCodigoMatriz());
				est.setCodigoResponsabilidad(entrada.getCodigoResponsabilidad());
				est.setCodigoResponsabilidadDUA(entrada.getCodigoResponsabilidadDUA());
				est.setConclusionDUA(entrada.getConclusionDUA());
				est.setEstado(entrada.getEstado());
				est.setFechaOcurrido(entrada.getFechaOcurrido());
				est.setFolioEDUA(entrada.getFolioEDUA());
				est.setMatriz(entrada.isMatriz());
				est.setMunicipio(entrada.getMunicipioDelegacion());
				est.setNombreAjustador(terminal.getNombre());
				est.setNumeroInciso(entrada.getNumeroInciso());
				est.setNumeroPoliza(entrada.getNumeroPoliza());
				est.setNumeroReporte(entrada.getNumeroReporte());
				est.setFecha(new Date());
				est.setTerminal(terminal);
			JMResultadoOperacion respuesta = codigoResponsabilidadEstadService.guardarObjeto(est);
			if (respuesta != null) {
				try {
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumeroReporte(),
				               fuenteWS + "estadisticaCodigoResp", "Codigo de Responsabilidad estadistica V3", "Respuesta: "+respuesta.getMensaje());
		    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
		    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                     "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
				} catch (PersistenceException | DataAccessException |JsonException ex) {
		    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                     "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
				}
				
				if (respuesta.isExito()) {
					return new MovilResultadoOperacion(true, "Información exitosa. "+respuesta.getMensaje());
				} else {
					return new MovilResultadoOperacion(false, "Información erronea. "+respuesta.getMensaje());
				}
			}
		} catch (final NoResultException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException | RollbackException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "MovilRestService => estadisticaCodigoResp"); 
			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumeroReporte(),
			               fuenteWS + "estadisticaCodigoResp", "Codigo de Responsabilidad estadistica V3", "Respuesta: "+e.getMessage());
	    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
			} catch (PersistenceException | DataAccessException |JsonException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
			}
			return new MovilResultadoOperacion(false, "Ocurrio un error en ->"+e);
		} catch (final PersistenceException | DatabaseException | DataIntegrityViolationException | CannotGetJdbcConnectionException e) {
			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumeroReporte(),
			               fuenteWS + "estadisticaCodigoResp", "Codigo de Responsabilidad estadistica V3", "Respuesta: "+e.getMessage());
	    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
			} catch (PersistenceException | DataAccessException |JsonException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
			}
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "MovilRestService => estadisticaCodigoResp");
			return new MovilResultadoOperacion(false, "Ocurrio un error en ->"+e);
		} catch (final  DataAccessException | InternalException e) {
			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumeroReporte(),
			               fuenteWS + "estadisticaCodigoResp", "Codigo de Responsabilidad estadistica V3", "Respuesta: "+e.getMessage());
	    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
			} catch (PersistenceException | DataAccessException |JsonException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "pagoReferenciado => ejecutarFuncionHistoricoTerminalNuevo");
			}
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "MovilRestService => estadisticaCodigoResp");
			return new MovilResultadoOperacion(false, "Ocurrio un error en ->"+e);
		}
		return new MovilResultadoOperacion(false, "Ocurrio un error. Intente más tarde.");
	}


	@Override
	public MovilResultadoOperacion examenTEP(ExamenTEP entrada) {
		if (entrada == null) {
			return new MovilResultadoOperacion(false, "Es necesario especificar los datos de entrada.");
		}
		if (StringUtils.isBlank(entrada.getUsuario())) {
			return new MovilResultadoOperacion(false, "Es necesario especificar 'usuario'.");
		}
		if (StringUtils.isBlank(entrada.getPwd())) {
			return new MovilResultadoOperacion(false, "Es necesario especificar 'pwd'.");
		}
		if (StringUtils.isBlank(entrada.getNumeroReporte())) {
			return new MovilResultadoOperacion(false, "Es necesario especificar 'numeroReporte'.");
		}
		
		
		Terminal terminal = null;
		try {
			terminal = this.terminalDao.objetoTerminalParaProveedorYPasswd(entrada.getUsuario(), entrada.getPwd());
		} catch (  DataAccessException | ClassCastException | RollbackException | CannotResolveClassException e1) {
    		this.utileriaExcepcion.manejarExcepcion(e1, this.getClass(), "Ocurrio un error en terminalDao.objetoTerminalParaNumeroReporte ->"+e1);
		}
		 
		if (terminal == null) {
            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o contraseña son invalidos");
	     }
		
		try {
        	Gson json = new Gson();
        	String peticion = json.toJson(entrada);
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumeroReporte(),
		               fuenteWS + "examenTEP", "Examen Toxicologico EP V3", "Peticion: "+peticion);
    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "examenTEP => ejecutarFuncionHistoricoTerminalNuevo");
		} catch (PersistenceException | DataAccessException |JsonException ex) {
    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "examenTEP => ejecutarFuncionHistoricoTerminalNuevo");
		}
		
		try {
			String respuesta = this.sacService.examenToxicologicoSAC(terminal, entrada);
			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumeroReporte(),
			               fuenteWS + "examenTEP", "Examen Toxicologico EP V3", "Respuesta SAC: "+respuesta);
	    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "examenTEP => ejecutarFuncionHistoricoTerminalNuevo");
			} catch (PersistenceException | DataAccessException |JsonException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "examenTEP => ejecutarFuncionHistoricoTerminalNuevo");
			}
			
			if (respuesta != null) {
				if (StringUtils.containsIgnoreCase(respuesta, "ERROR")) {
					return new MovilResultadoOperacion(false, respuesta);
				}
				return new MovilResultadoOperacion(true, respuesta);
			}
			return new MovilResultadoOperacion(false, "No se obtuvo respuesta de SAC.");
		} catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
   		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                 "examenTEP => ejecutarFuncionHistoricoTerminalNuevo");
   		return new MovilResultadoOperacion(false, "Ocurrio un error: "+ex.getMessage());
	} catch (PersistenceException | DataAccessException |JsonException ex) {
		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                 "examenTEP => ejecutarFuncionHistoricoTerminalNuevo");
		 return new MovilResultadoOperacion(false, "Ocurrio un error: "+ex.getMessage());
	}
  }

	@Override
	public MovilResultadoOperacion controlFotografias(FotografiasReg entrada) {
		if (entrada == null) {
			return new MovilResultadoOperacion(false, "Es necesario especificar los datos de entrada.");
		}
		if (StringUtils.isBlank(entrada.getUsuario())) {
			return new MovilResultadoOperacion(false, "Es necesario especificar 'usuario'.");
		}
		if (StringUtils.isBlank(entrada.getPwd())) {
			return new MovilResultadoOperacion(false, "Es necesario especificar 'pwd'.");
		}
		if (StringUtils.isBlank(entrada.getNumReporte())) {
			return new MovilResultadoOperacion(false, "Es necesario especificar 'numReporte'.");
		}
		
		
		Terminal terminal = null;
		try {
			terminal = this.terminalDao.objetoTerminalParaProveedorYPasswd(entrada.getUsuario(), entrada.getPwd());
		} catch (  DataAccessException | ClassCastException | RollbackException | CannotResolveClassException e1) {
    		this.utileriaExcepcion.manejarExcepcion(e1, this.getClass(), "Ocurrio un error en terminalDao.objetoTerminalParaNumeroReporte ->"+e1);
		}
		 
		if (terminal == null) {
            return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o contraseña son invalidos");
	     }
		
		try {
        	Gson json = new Gson();
        	String peticion = json.toJson(entrada);
			this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumReporte(),
		               fuenteWS + "controlFotografias", "Control Fotografias V3", "Peticion: "+peticion);
    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "controlFotografias => ejecutarFuncionHistoricoTerminalNuevo");
		} catch (PersistenceException | DataAccessException |JsonException ex) {
    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
                     "controlFotografias => ejecutarFuncionHistoricoTerminalNuevo");
		}
		
		try {
			JMResultadoOperacion respuesta = new JMResultadoOperacion();
				if (entrada.getDatosFotos() != null) {
					for (int i = 0; i < entrada.getDatosFotos().size(); i++) {
						ControlFotografias controlF = new ControlFotografias();
						controlF.setAjustador(terminal.getNumeroproveedor()+"-"+terminal.getNombre());
						controlF.setFecha(new Date());
						controlF.setAfectado(entrada.getDatosFotos().get(i).getAfectado());
						controlF.setNombreFoto(entrada.getDatosFotos().get(i).getNombreFoto());
						controlF.setNumReporte(entrada.getNumReporte());
						controlF.setTerminal(terminal);
						controlF.setClaveDocumental(entrada.getDatosFotos().get(i).getClaveDocumental());
						controlF.setDetalle(entrada.getDatosFotos().get(i).getDetalle());
						controlF.setEnviado(entrada.getDatosFotos().get(i).isEnviado());
						controlF.setEstado(terminal.getEstado());
						controlF.setBase(terminal.getBase());
						respuesta = controlFotografiasService.guardarObjeto(controlF);
					}
				}
			
			if (respuesta != null) {
				try {
					this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumReporte(),
				               fuenteWS + "controlFotografias", "Control Fotografias V3", "Respuesta: "+respuesta.getMensaje());
		    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
		    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                     "controlFotografias => ejecutarFuncionHistoricoTerminalNuevo");
				} catch (PersistenceException | DataAccessException |JsonException ex) {
		    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
		                     "controlFotografias => ejecutarFuncionHistoricoTerminalNuevo");
				}
				
				if (respuesta.isExito()) {
					return new MovilResultadoOperacion(true, "Información exitosa. "+respuesta.getMensaje());
				} else {
					return new MovilResultadoOperacion(false, "Información erronea. "+respuesta.getMensaje());
				}
			}
		} catch (final NoResultException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException | RollbackException e) {
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "MovilRestService => controlFotografias"); 
			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumReporte(),
			               fuenteWS + "controlFotografias", "Control Fotografia V3", "Respuesta: "+e.getMessage());
	    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "controlFotografias => ejecutarFuncionHistoricoTerminalNuevo");
			} catch (PersistenceException | DataAccessException |JsonException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "controlFotografias => ejecutarFuncionHistoricoTerminalNuevo");
			}
			return new MovilResultadoOperacion(false, "Ocurrio un error en ->"+e);
		} catch (final PersistenceException | DatabaseException | DataIntegrityViolationException | CannotGetJdbcConnectionException e) {
			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumReporte(),
			               fuenteWS + "controlFotografias", "Control Fotografia V3", "Respuesta: "+e.getMessage());
	    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "controlFotografias => ejecutarFuncionHistoricoTerminalNuevo");
			} catch (PersistenceException | DataAccessException |JsonException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "controlFotografias => ejecutarFuncionHistoricoTerminalNuevo");
			}
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "MovilRestService => controlFotografias");
			return new MovilResultadoOperacion(false, "Ocurrio un error en ->"+e);
		} catch (final  DataAccessException | InternalException e) {
			try {
				this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminalNuevo(null, terminal, entrada.getNumReporte(),
			               fuenteWS + "controlFotografias", "Control Fotografia V3", "Respuesta: "+e.getMessage());
	    	}catch (RollbackException | ClassCastException | IndexOutOfBoundsException | IllegalArgumentException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "controlFotografias => ejecutarFuncionHistoricoTerminalNuevo");
			} catch (PersistenceException | DataAccessException |JsonException ex) {
	    		 this.utileriaExcepcion.manejarExcepcion(ex, this.getClass(),
	                     "controlFotografias => ejecutarFuncionHistoricoTerminalNuevo");
			}
			this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "MovilRestService => controlFotografias");
			return new MovilResultadoOperacion(false, "Ocurrio un error en ->"+e);
		}
		return new MovilResultadoOperacion(false, "Ocurrio un error. Intente más tarde.");
	}

	@Override
	public MovilResultadoOperacion historicoTerminal(ExternoHistoricoT entrada) {
		if (entrada == null) {
			return new MovilResultadoOperacion(false, "Es necesario enviar información.");
		}
		if (StringUtils.isBlank(entrada.getUsuario())) {
			return new MovilResultadoOperacion(false, "Es necesario enviar el campo 'usuario'.");
		}
		if (StringUtils.isBlank(entrada.getPwd())) {
			return new MovilResultadoOperacion(false, "Es necesario enviar el campo 'pwd'.");
		}
		if (StringUtils.isBlank(entrada.getNumReporte())) {
			return new MovilResultadoOperacion(false, "Es necesario enviar el campo 'numReporte'.");
		}
		if (StringUtils.isBlank(entrada.getFuente())) {
			return new MovilResultadoOperacion(false, "Es necesario enviar el campo 'fuente'.");
		}
		Terminal term = null;
		try {
			term = this.terminalDao.objetoTerminalParaProveedorYPasswd(entrada.getUsuario(), entrada.getPwd());
		} catch (ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException | RollbackException e) {
			 this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"historicoTerminal => objetoTerminalParaProveedorYPasswd");
			 return new MovilResultadoOperacion(false, "ERROR: Ocurrio un error al obtener la Terminal. "+e.getMessage());
		} catch (PersistenceException | DatabaseException  e) {
			 this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "historicoTerminal => objetoTerminalParaProveedorYPasswd");
			 return new MovilResultadoOperacion(false, "ERROR: Ocurrio un error al obtener la Terminal. "+e.getMessage());
		}
		if (term == null) {
	      return new MovilResultadoOperacion(false, "ERROR: El nombre de usuario o contraseña son invalidos.");
		}
		try {
				JMResultadoOperacion respuesta = this.historicoTerminalServiceInterfase.ejecutarFuncionHistoricoTerminal(null, term,entrada.getNumReporte(),
						 entrada.getFuente(), entrada.getOperacion(), entrada.getDetalle());
				if (respuesta != null) {
					return new MovilResultadoOperacion(respuesta.isExito(), respuesta.getMensaje());
				}
			}  catch (ClassCastException | IndexOutOfBoundsException | IllegalArgumentException | IllegalStateException | RollbackException e) {
				 this.utileriaExcepcion.manejarExcepcion(e, this.getClass(),"historicoTerminal => ejecutarFuncionHistoricoTerminal");
				 return new MovilResultadoOperacion(false, "ERROR: Ocurrio un error al ejecuctar función historico. "+e.getMessage());
			} catch (PersistenceException | DatabaseException  e) {
				 this.utileriaExcepcion.manejarExcepcion(e, this.getClass(), "historicoTerminal => ejecutarFuncionHistoricoTerminal");
				 return new MovilResultadoOperacion(false, "ERROR: Ocurrio un error al ejecuctar función historico. "+e.getMessage());
			}
		return new MovilResultadoOperacion(false, "Ocurrio un error al ejecutar función histórico.");
	}
	
	

}
