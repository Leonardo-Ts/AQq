package com.aaq.col.system.beans.catalogo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;
import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.Base;
import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.clases.database.entidades.GrupoTerminal;
import com.aaq.col.clases.database.entidades.GuardiaGrupo;
import com.aaq.col.clases.database.entidades.HorarioGrupo;
import com.aaq.col.clases.database.entidades.Horarios;
import com.aaq.col.clases.database.entidades.Terminal;
import com.aaq.col.clases.siica.JMConstantes;
import com.aaq.col.clases.util.UtileriaFechas;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.GrupoDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.utilerias.JMUtileriaFecha;

@ManagedBean(name = "beanCatalogoGrupos")
@ViewScoped
public class JMBeanCatalogoGrupos extends JMBeanExtensiblePrincipal<Grupo> {
	private static final long serialVersionUID = -8267415766637489956L;
	
	public Log logCargaMasiva = LogFactory.getLog(JMBeanCatalogoGrupos.class);

	private UploadedFile file;
	private String idEstadoSeleccionadoDos="9";
	private String idBaseSeleccionadoDos="-9999";
	private String idTerminalSeleccionadoDos;
	private String claveHorarioSelecionado;
	private Date txtFechaInicio;
	private Date txtFechaFin;
	private String txtSubGrupo;
	private String[] txtDiaDescanso;
	private Boolean lunesGuardia;
	private Boolean martesGuardia;
	private Boolean miercolesGuardia;
	private Boolean juevesGuardia;
	private Boolean viernesGuardia;
	private Boolean sabadoGuardia;
	private Boolean domingoGuardia;
	private Boolean activarGuardia;
	private int idGuardi;
	private Calendar today = Calendar.getInstance();
	
	private static final int dia = 86400000;

	 
	public JMBeanCatalogoGrupos() {
		super();
		this.actualizarListado();
		this.txtFechaInicio = new Date(System.currentTimeMillis());
        this.txtFechaFin = new Date(System.currentTimeMillis() + ( 86400000L * 7));

	}

	@Override
	public void actualizarListado() {
		try {
			this.setListado(new GrupoDataModel(this.getGrupoService().listaDeGrupo(StringUtils.isNotBlank(this.getIdEstado()) ? this
					.getEstadoService().objetoEstado(
							this.getIdEstado()) : null)));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "actualizarListado");
		}
	}
	
	public ArrayList<JMColumna> getColumnas() {
		return new JMListadoColumna(
				new String[] { "Estado,estado", "Grupo,nombre", "Terminales Que Incluye,terminalesIncluidas", "Horarios,horariosIncluidos" }).getLista();

	}

	public List<GrupoTerminal> getListaDeGrupoTerminal() {
		if ((this.getObjetoABM() != null) && (this.getObjetoABM().getId() != null)) {
			try {
				return this.getGrupoTerminalService().listaDeGrupoTerminal(this.getObjetoABM());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeGrupoTerminal");
			}
		}
		return null;
	}
	
	public List<HorarioGrupo> getListaDeHorarioGrupo() {
		if ((this.getObjetoABM() != null) && (this.getObjetoABM().getId() != null)) {
			try {
				return this.getHorarioGrupoService().listaDeHorarioGrupo(getObjetoABM());
						//this.getGrupoTerminalService().listaDeGrupoTerminal(this.getObjetoABM());
			} catch (final Exception ex) {
				this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeGrupoTerminal");
			}
		}
		return null;
	}

	@Override
	public List<Base> getListaDeBasesTodas() {
		try {
			
			return this.getBaseService().listaDeBase(this.getEstadoService().objetoEstado(this.getIdEstadoDos()));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeBasesTodas");
		}
		return null;
	}
	
	@Override
	public List<Terminal> getListaDeTerminalesParaSeleccion() {
		try {
			return this.getTerminalService().listaDeTerminal(this.getEstadoService().objetoEstado(this.getIdEstadoDos()),
					  this.getBaseService().objetoBase( this.getIdBaseSeleccionadoDos()));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeTerminalesTodas");
		}
		return null;
	}
	
	@Override
	public List<Horarios> getListaDeHorariosParaSeleccion() {
		try {
			List<Horarios> regreso = this.getHorariosService().listaDeHorariosAgroup(StringUtils.isNotBlank(this.getIdEstado()) ? this
					.getEstadoService().objetoEstado(
							this.getIdEstado()) : null);
			return regreso;
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "getListaDeHorarios");
		}
		return null;
	}

	
	@Override
	public void doAccionRegistroNuevo(final ActionEvent e) {
		if (this.getPermisoSIICAGlobalEstados() )
		{
			this.setObjetoABM(new Grupo( ));
			
		}	else {
			this.setObjetoABM(new Grupo( this.getIdEstado() ));
	
		}
		
	}
	@Override
	public void doAccionRegistroEliminar( final ActionEvent e ) {
		try {
			this.setObjetoABM (this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
			if (this.getObjetoABM() == null) {
				this.ponerMensajeError("No se encontro el registro para eliminar");
			} else {
				try {
					List<GrupoTerminal> terminales = GrupoTerminal.getGrupoTerminalService().listaDeGrupoTerminal(this.getObjetoABM());
					if ( terminales.size() > 0) {
						for (GrupoTerminal terminalGrupo : terminales) {
							Terminal terminal = Terminal.getTerminalService().objetoTerminal(String.valueOf(terminalGrupo.getTerminal().getId()));
							terminal.setGrupo(null);
							terminal.setSubGrupo(null);
							terminal.setGuardia(false);
							terminal.guardarObjeto();
							terminalGrupo.eliminarObjeto();
						}
					}
					
					this.ponerMensajeResultado( this.getObjetoABM().eliminarObjeto());					
				} catch (Exception ex) {
					this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionEliminarGrupos con Terminales");
				}
			}
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionRegistroEliminar");
		}
		this.actualizarListado();
	}

	public void doAccionGrupoAgregarTerminal(final ActionEvent e) {
		Terminal terminal = null;
		try {
			terminal = this.getTerminalService().objetoTerminal(this.getIdTerminalSeleccionadoDos());
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionGrupoAgregarTerminal");
		}
		
		if (terminal != null) {
			if (terminal.getGrupo() != null) {
				this.ponerMensajeError("La terminal ya esta asociado a un grupo.");
			} else {
				final GrupoTerminal grupo = new GrupoTerminal();
				grupo.setGrupo(this.getObjetoABM());
				grupo.setTerminal(terminal);
				this.ponerMensajeResultado(grupo.guardarObjeto());
				String tmpDiaD = "";
				String suffix = "|";
				int i = 1;
				if(this.getTxtDiaDescanso().length > 0){
					for (String diaDesc : txtDiaDescanso) {
						tmpDiaD += diaDesc + (i < this.getTxtDiaDescanso().length ? suffix : "");
						i++;
					}
				}else{
					tmpDiaD = null;
				}
				terminal.setDiaDescanso(tmpDiaD);
//				terminal.setDiaDescanso(txtDiaDescanso);
				terminal.setSubGrupo(txtSubGrupo);
				terminal.setGrupo(grupo.getGrupo());
				this.ponerMensajeResultado(terminal.guardarObjeto());				
			}
		}
	}

	public void doAccionGrupoEliminarTerminal(final ActionEvent e) {
		GrupoTerminal grupz = null;
		try {
			grupz = this.getGrupoTerminalService().objetoGrupoTerminal(
					this.obtenerParametroDeRequest(JMConstantes.WEB_PARAMETRO_IDENTI));
		} catch (final Exception ex) {
			this.getUtileriaExcepcion().manejarExcepcion(ex, this.getClass(), "doAccionGrupoEliminarTerminal");
		}

		if (grupz != null) {
			try {
				Terminal terminal = Terminal.getTerminalService().objetoTerminal(String.valueOf(grupz.getTerminal().getId()));
				terminal.setGrupo(null);
				terminal.setSubGrupo(null);
				terminal.setGuardia(false);
				this.ponerMensajeResultado(terminal.guardarObjeto());
				this.ponerMensajeResultado(grupz.eliminarObjeto());
			} catch (Exception e2) {
				this.getUtileriaExcepcion().manejarExcepcion(e2, this.getClass(), "Eliminar una terminal del grupo");
			}
		}

	}
	
	public void doAccionGrupoAgregarHorario(final ActionEvent e) {
		Date now = new Date();
		if ((this.getTxtFechaInicio() != null)
				&& (this.getTxtFechaFin() != null)) {
			//Cambiar formato de fecha final de 00:000:00 a 23:59:59
			this.setTxtFechaFin(this.formatFinal(this.getTxtFechaFin()));
			
			if((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) < ((JMUtileriaFecha.TIEMPO_1_DIA * 7)- 3600) ) {
				this.ponerMensajeAdvertencia("La programación de horarios debe de ser de 7 días. UNO");
				return;
			}
			
			if (((this.getTxtFechaFin().getTime() - this.getTxtFechaInicio().getTime()) >= (JMUtileriaFecha.TIEMPO_1_DIA * 8))) {
				this.ponerMensajeAdvertencia("La programación de horarios debe de ser de 7 días.");
				return;
			}
		}
		
		HorarioGrupo horario = HorarioGrupo.getHorarioGrupoService().horarioGrupoFecha(this.getObjetoABM(), now);
		
		
		if ( horario != null ) {
			
			UtileriaFechas utileria = new UtileriaFechas();
			if (horario.getFechaFin() != null && this.getTxtFechaInicio() != null) {
				//Validamos que la fecha de inicio del nuevo horario no sea la misma que la fecha final del horario
				if (utileria.fechasIguales(this.txtFechaInicio, horario.getFechaFin())) {
					this.ponerMensajeAdvertencia("Ya existe un horario, dentro de este rango de fechas.");
					return;
				}
				
				int dif = utileria.numeroDiasEntreDosFechas(horario.getFechaFin(), this.getTxtFechaInicio());
				if (dif != 0) {
					this.ponerMensajeAdvertencia("Ya existe un horario, dentro de este rango de fechas.");
					return;
				} else {
					final HorarioGrupo horariog = new HorarioGrupo();
					horariog.setClaveHorario(this.getClaveHorarioSelecionado());
					horariog.setGrupo(this.getObjetoABM());
					horariog.setFechaInicio(this.getTxtFechaInicio());
					horariog.setFechaFin(this.getTxtFechaFin());
					this.ponerMensajeResultado(horariog.guardarObjeto());
				}
			}
		} else {
				
			final HorarioGrupo horariog = new HorarioGrupo();
			horariog.setClaveHorario(this.getClaveHorarioSelecionado());
			horariog.setGrupo(this.getObjetoABM());
			horariog.setFechaInicio(this.getTxtFechaInicio());
			horariog.setFechaFin(this.getTxtFechaFin());
			this.ponerMensajeResultado(horariog.guardarObjeto());
		}
	}
	
	public void doAccionGrupoEliminarHorario(final ActionEvent e) {
		HorarioGrupo gruph = null;
		try {
			gruph = this.getHorarioGrupoService().objetoHorarioGrupo(
					this.obtenerParametroDeRequest(JMConstantes.WEB_PARAMETRO_IDENTI));
		} catch (final Exception e2) {
			this.getUtileriaExcepcion().manejarExcepcion(e2, this.getClass(), "doAccionGrupoEliminarHorario");
		}
		
		if (gruph != null) {
			this.ponerMensajeResultado(gruph.eliminarObjeto());
		}
	}
	
	public void doAccionGrupoAgregaGuardia( final ActionEvent e ) {
		//this.setObjetoABM(this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
		GuardiaGrupo guar = null;
		try {
			guar =  GuardiaGrupo.getGuardiaGrupoService().objetoGuardiaPorGrupo(this.getObjetoABM());
		} catch (Exception e1) {
		
		}
		
		if (guar != null) {
			final GuardiaGrupo guardia = new GuardiaGrupo();
			guardia.setActivarGuardia(activarGuardia);
			guardia.setLunesGuardia(lunesGuardia);
			guardia.setMartesGuardia(martesGuardia);
			guardia.setMiercolesGuardia(miercolesGuardia);
			guardia.setJuevesGuardia(juevesGuardia);
			guardia.setViernesGuardia(viernesGuardia);
			guardia.setSabadoGuardia(sabadoGuardia);
			guardia.setDomingoGuardia(domingoGuardia);
			guardia.setGrupo(this.getObjetoABM());
			guardia.setId(guar.getId());
			this.ponerMensajeResultado(guardia.guardarObjeto());

		} else {
			final GuardiaGrupo guardia = new GuardiaGrupo();
			guardia.setActivarGuardia(activarGuardia);
			guardia.setLunesGuardia(lunesGuardia);
			guardia.setMartesGuardia(martesGuardia);
			guardia.setMiercolesGuardia(miercolesGuardia);
			guardia.setJuevesGuardia(juevesGuardia);
			guardia.setViernesGuardia(viernesGuardia);
			guardia.setSabadoGuardia(sabadoGuardia);
			guardia.setDomingoGuardia(domingoGuardia);
			guardia.setGrupo(this.getObjetoABM());
			this.ponerMensajeResultado(guardia.guardarObjeto());
			
		}
		List<GrupoTerminal> Gterminales = getListaDeGrupoTerminal();
		
		for (GrupoTerminal grupoTerminal : Gterminales) {
			Terminal term = grupoTerminal.getTerminal();
			term.setGuardia(activarGuardia);
			term.guardarObjeto();
		}
		
		
	}
	
	public void doAccionRegistroEditarGuardia(final ActionEvent e) {
        GuardiaGrupo guardia;
		try {
			this.setObjetoABM(this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
			guardia = GuardiaGrupo.getGuardiaGrupoService().objetoGuardiaPorGrupo(this.getObjetoABM());
			
			if (guardia != null) {
	        	  setLunesGuardia(guardia.getLunesGuardia());
	        	  setMartesGuardia(guardia.getMartesGuardia());
	        	  setMiercolesGuardia(guardia.getMiercolesGuardia());
	        	  setJuevesGuardia(guardia.getJuevesGuardia());
	        	  setViernesGuardia(guardia.getViernesGuardia());
	        	  setSabadoGuardia(guardia.getSabadoGuardia());
	        	  setDomingoGuardia(guardia.getDomingoGuardia());
	        	  setActivarGuardia(guardia.getActivarGuardia());
	        	  setIdGuardi(guardia.getId());
			} else {
				setLunesGuardia(false);
	        	  setMartesGuardia(false);
	        	  setMiercolesGuardia(false);
	        	  setJuevesGuardia(false);
	        	  setViernesGuardia(false);
	        	  setSabadoGuardia(false);
	        	  setDomingoGuardia(false);
	        	  setActivarGuardia(false);
			}
		} catch (Exception e1) {
			this.getUtileriaExcepcion().manejarExcepcion(e1, this.getClass(), "doAccionRegistroEditarGuardia");
		}
        
        

    }
	
	public void handleFileUpload(FileUploadEvent event) throws IOException {
//      FacesMessage message = new FacesMessage("Ok", "Fichero: " + event.getFile().getFileName() + " subido correctamente.");
//      FacesContext.getCurrentInstance().addMessage(null, message);
	try {
		Map<String, Object>  salida = null;
      this.setFile(event.getFile());

      String name = file.getFileName();

      InputStream inputStream = file.getInputstream();
      OutputStream outputStream = null;
      try {
      FacesContext context = FacesContext.getCurrentInstance();
      ServletContext servletContext = (ServletContext) context
              .getExternalContext().getContext();
      String path = servletContext.getRealPath("");
      File file = new File(path+"/"+ name);
      
      	outputStream = new FileOutputStream(file);
    
//      int read = 0;
//      byte[] bytes = new byte[1024];
//
//      while ((read = inputStream.read(bytes)) != -1) {
//          outputStream.write(bytes, 0, read);
//      }
//
//      this.getCargaDatosService().cargaDatosCorreos(file);
//      
    
    int read = 0;
      byte[] bytes = new byte[1024];
   try  {
      while ((read = inputStream.read(bytes)) != -1) {
          outputStream.write(bytes, 0, read);
      }
	} catch (ArrayIndexOutOfBoundsException e) {
		this.logCargaMasiva.info("Ocurrio un error: "+e);
		this.ponerMensajeError("Ocurrio un error a subir al leer el archivo: "+e);
	}
      salida = this.getCargaDatosService().cargaDatos(file);
      String  error = (String) salida.get("error");
	     if (error != null) {
			this.ponerMensajeError("Verificar contenido del archivo.");
		} else {
	    	this.ponerMensajeInfo("Se añadieron nuevos datos.");
		       this.actualizarListado();
		}
	     try {
	    	 outputStream.close();
	     }catch (Exception e) {
	            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> handleFileUpload -> Cerrar archivo " + e.getMessage()), (Throwable)e);
		} finally {
			
				if (file.exists()) {
					file.delete();
				}
			
		}
	     
      }catch (ClassCastException | Error  e) {
			this.logCargaMasiva.info("Ocurrio un error -> "+e);
			this.ponerMensajeError("Ocurrio un error a subir el archivo: "+e);
		} catch (FileNotFoundException e) {
			this.logCargaMasiva.info("Ocurrio un error -> "+e);
			this.ponerMensajeError("Ocurrio un error a subir el archivo: "+e);
		}  catch (IOException ex) {
			this.logCargaMasiva.info("Ocurrio un error -> "+ex);
			this.ponerMensajeError("Ocurrio un error a subir el archivo: "+ex);
		} finally {
			outputStream.close();
		} 
	}catch (Exception e) {
      getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> handleFileUpload -> " + e.getMessage()), (Throwable)e);
      this.ponerMensajeError("Ocurrio un error a subir el archivo: "+e);

	}
      
  }
	
	public void cargaMasivaGrupos(FileUploadEvent event) throws IOException {
	try {
		Map<String, Object>  salida = null;
		this.setFile(event.getFile());
		String name = file.getFileName();

	      InputStream inputStream = file.getInputstream();
	      OutputStream outputStream = null;
	      try {
	      FacesContext context = FacesContext.getCurrentInstance();
	      ServletContext servletContext = (ServletContext) context
	              .getExternalContext().getContext();
	      String path = servletContext.getRealPath("");
	      File file = new File(path+"/"+ name);
	      
	    outputStream = new FileOutputStream(file);
	    int read = 0;
	    byte[] bytes = new byte[1024];
	   try  {
	      while ((read = inputStream.read(bytes)) != -1) {
	          outputStream.write(bytes, 0, read);
	      }
		} catch (ArrayIndexOutOfBoundsException e) {
			this.logCargaMasiva.info("Ocurrio un error: "+e);
			this.ponerMensajeError("Ocurrio un error a subir al leer el archivo de carga masiva de grupos: "+e);
		}
	      salida = this.getCargaDatosService().cargaDatos(file);
	      String  error = (String) salida.get("error");
		     if (error != null) {
				this.ponerMensajeError("Verificar contenido del archivo.");
			} else {
		    	this.ponerMensajeInfo("Se añadieron nuevos datos.");
			       this.actualizarListado();
			}
		     try {
		    	 outputStream.close();
		     }catch (Exception e) {
		            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> handleFileUpload -> Cerrar archivo " + e.getMessage()), (Throwable)e);
			} finally {
				
					if (file.exists()) {
						file.delete();
					}
				
			}
		     
	      }catch (ClassCastException | Error  e) {
				this.logCargaMasiva.info("Ocurrio un error -> "+e);
				this.ponerMensajeError("Ocurrio un error a subir el archivo: "+e);
			} catch (FileNotFoundException e) {
				this.logCargaMasiva.info("Ocurrio un error -> "+e);
				this.ponerMensajeError("Ocurrio un error a subir el archivo: "+e);
			}  catch (IOException ex) {
				this.logCargaMasiva.info("Ocurrio un error -> "+ex);
				this.ponerMensajeError("Ocurrio un error a subir el archivo: "+ex);
			} finally {
				outputStream.close();
			} 
		}catch (Exception e) {
	      getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> handleFileUpload -> " + e.getMessage()), (Throwable)e);
	      this.ponerMensajeError("Ocurrio un error a subir el archivo: "+e);
	
		}
      
  }
	
	
	public String getCadenaToday() {
		String fecha =  DateFormatUtils.format(new Date(), "dd/MM/yyyy");
		return fecha;
	}
	
	public String getVigenciaGrupo(Grupo grupo) {
		 HorarioGrupo grupz;
		try {
		grupz = HorarioGrupo.getHorarioGrupoService().horarioGrupoFecha(grupo, null);
		
		if(grupz.getFechaFin() != null) {
			long diferenciaTiempo =  grupz.getFechaFin().getTime() - System.currentTimeMillis();
			if( (diferenciaTiempo >  dia) && (diferenciaTiempo < (3 * dia)))  {
	         	return "AMARILLO";
			}
            if( (diferenciaTiempo > (3 * dia)) && (diferenciaTiempo < (7 * dia))) {
            	return "VERDE";
			} 
		}
		} catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
			
		} catch (Exception e) {
		}
		return "ROJO";

	}
	
	public synchronized Date formatFinal(Date date) {
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
		 cal.set(Calendar.HOUR_OF_DAY, 23);
		 cal.set(Calendar.MINUTE, 59);
		 cal.set(Calendar.SECOND, 59);
			 try {
				 Date endDate = cal.getTime();
				 return endDate;
			 } catch (Exception e) {
			}
		return date;
	}
	
	@Override
	public boolean getPermisoABM() {
		return this.getTienePermisoParaPagina("/Catalogo/grupos.siica");

	}

	@Override
	public Grupo getObjetoABM() {
		return super.getObjetoABM();
	}
	
	public String getIdEstadoDos() {
		return this.idEstadoSeleccionadoDos;
	}

	public void setIdEstadoDos(final String idEstadoSeleccionadoDos) {
		this.idEstadoSeleccionadoDos = idEstadoSeleccionadoDos;
	}

	public String getIdBaseSeleccionadoDos() {
		return this.idBaseSeleccionadoDos;
	}

	public void setIdBaseSeleccionadoDos(final String idBaseSeleccionadoDos) {
		this.idBaseSeleccionadoDos = idBaseSeleccionadoDos;
	}

	public String getIdTerminalSeleccionadoDos() {
		return idTerminalSeleccionadoDos;
	}

	public void setIdTerminalSeleccionadoDos(String idTerminalSeleccionadoDos) {
		this.idTerminalSeleccionadoDos = idTerminalSeleccionadoDos;
	}

	public String getClaveHorarioSelecionado() {
		return claveHorarioSelecionado;
	}

	public void setClaveHorarioSelecionado(String claveHorarioSelecionado) {
		this.claveHorarioSelecionado = claveHorarioSelecionado;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public Date getTxtFechaInicio() {
		return txtFechaInicio;
	}

	public void setTxtFechaInicio(Date txtFechaInicio) {
		this.txtFechaInicio = txtFechaInicio;
	}

	public Date getTxtFechaFin() {
		return txtFechaFin;
	}

	public void setTxtFechaFin(Date txtFechaFin) {
		this.txtFechaFin = txtFechaFin;
	}

	public String getTxtSubGrupo() {
		return txtSubGrupo;
	}

	public void setTxtSubGrupo(String txtSubGrupo) {
		this.txtSubGrupo = txtSubGrupo;
	}

	

	/**
	 * @return the txtDiaDescanso
	 */
	public String[] getTxtDiaDescanso() {
		return txtDiaDescanso;
	}

	/**
	 * @param txtDiaDescanso the txtDiaDescanso to set
	 */
	public void setTxtDiaDescanso(String[] txtDiaDescanso) {
		this.txtDiaDescanso = txtDiaDescanso;
	}

	public Boolean getLunesGuardia() {
		return lunesGuardia;
	}

	public void setLunesGuardia(Boolean lunesGuardia) {
		this.lunesGuardia = lunesGuardia;
	}

	public Boolean getMartesGuardia() {
		return martesGuardia;
	}

	public void setMartesGuardia(Boolean martesGuardia) {
		this.martesGuardia = martesGuardia;
	}

	public Boolean getMiercolesGuardia() {
		return miercolesGuardia;
	}

	public void setMiercolesGuardia(Boolean miercolesGuardia) {
		this.miercolesGuardia = miercolesGuardia;
	}

	public Boolean getJuevesGuardia() {
		return juevesGuardia;
	}

	public void setJuevesGuardia(Boolean juevesGuardia) {
		this.juevesGuardia = juevesGuardia;
	}

	public Boolean getViernesGuardia() {
		return viernesGuardia;
	}

	public void setViernesGuardia(Boolean viernesGuardia) {
		this.viernesGuardia = viernesGuardia;
	}

	public Boolean getSabadoGuardia() {
		return sabadoGuardia;
	}

	public void setSabadoGuardia(Boolean sabadoGuardia) {
		this.sabadoGuardia = sabadoGuardia;
	}

	public Boolean getDomingoGuardia() {
		return domingoGuardia;
	}

	public void setDomingoGuardia(Boolean domingoGuardia) {
		this.domingoGuardia = domingoGuardia;
	}

	public Boolean getActivarGuardia() {
		return activarGuardia;
	}

	public void setActivarGuardia(Boolean activarGuardia) {
		this.activarGuardia = activarGuardia;
	}

	public int getIdGuardi() {
		return idGuardi;
	}

	public void setIdGuardi(int idGuardi) {
		this.idGuardi = idGuardi;
	}
	
	public Calendar getToday() {
		return today;
	}

}
