package com.aaq.col.system.beans.catalogo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.PersistenceException;
import javax.servlet.ServletContext;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.dao.DataAccessException;

import com.aaq.col.clases.database.entidades.CorreoPolizaAgente;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;
import com.aaq.col.system.database.entidades.modelo.CorreoPolizaAgenteDataModel;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMListadoColumna;
import com.jmfg.jmlib.sistema.classes.jmlibreria.JMResultadoOperacion;

@ManagedBean(name = "beanCatalogoAvisosResumenAjustador")
@ViewScoped
public class JMBeanCatalogoAvisosResumenAjustador extends JMBeanExtensiblePrincipal<CorreoPolizaAgente> {
		private static final long serialVersionUID = -8267415766637489956L;
		
		private final Log4JLogger logCargaMasiva = (Log4JLogger) LogFactory.getLog("com.jmfg.jmlibrerias.logging.carga");

		private UploadedFile file;
		private String poliza;
		private String correos;
		private String claveAgente;
		private String _txtFiltroPoliza;
		private String _txtFiltroClave;

		public JMBeanCatalogoAvisosResumenAjustador() {
			super();
			this.actualizarListado();
		}

		@Override
		public void actualizarListado() {
			try {
			this.setListado(new CorreoPolizaAgenteDataModel(this.getCorreoPolizaAgenteService().listaDeCorreoPolizaAgente(_txtFiltroPoliza, _txtFiltroClave)));

			} catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "actualizarListado");
			} catch (Exception e) {
				this.getUtileriaExcepcion().manejarExcepcion(e, this.getClass(), "actualizarListado");
			}
		}
		

		
		public ArrayList<JMColumna> getColumnas() {
			return new JMListadoColumna(
					new String[] { "Poliza,poliza", "Correos,correos","Clave de agente,claveAgente"}).getLista();
//					new String[] { "Poliza,poliza", "Correos,correos"}).getLista();

		}


		@Override
		public void doAccionRegistroNuevo(final ActionEvent e) {
			this.doAccionLimpiarBusqueda();
			this.setObjetoABM(new CorreoPolizaAgente());
		}
		
		

		private void doAccionLimpiarBusqueda() {
			this.setPoliza(null);
			this.setCorreos(null);
			this.setClaveAgente(null);
		
		}
		@Override
		public boolean getPermisoABM() {
			return this.getTienePermisoParaPagina("/Catalogo/avisosResumenAjustador.siica");

		}
		
		public void doAccionRegistroEditarAvisos(final ActionEvent e) {
	        this.setObjetoABM(  this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id"))));
	        if (this.getObjetoABM() == null) {
	            this.ponerMensajeError("No se encontro registro para editar");
	            return;
	        }
	        try {
//	            this.getObjetoABM().editarObjeto();
	            this.setPoliza(this.getObjetoABM().getPoliza());
	            this.setCorreos(this.getObjetoABM().getCorreos());
	            this.setClaveAgente(this.getObjetoABM().getClaveAgente());
	            final JMResultadoOperacion r = this.getObjetoABM().editarObjeto();
	            if (r.isExito()) {
	                this.ponerMensajeInfo(r.getMensaje());
	            }
	            else {
	                this.ponerMensajeError("Registro No Guardado: " + r.getMensaje());
	            }
	        } catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
	            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroEditar -> " + ex.getMessage()), (Throwable)ex);
	        } catch (Exception ex) {
	            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroEditar -> " + ex.getMessage()), (Throwable)ex);
	        }
	    }
		
		
		public void doAccionRegistroEliminarAvisos(final ActionEvent e){
			CorreoPolizaAgente avisos = null;
			try {
				avisos =    this.getListado().getDataSource().get(NumberUtils.toInt(this.obtenerParametroDeRequest("id")));
//				Log.info("horarios "+horarios);

			} catch (PersistenceException ex) {
		        getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroEliminar-> " + ex.getMessage()), (Throwable)ex);
			} catch (NumberFormatException ex) {
		        getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroEliminar-> " + ex.getMessage()), (Throwable)ex);
			} catch (Exception ex) {
		        getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroEliminar-> " + ex.getMessage()), (Throwable)ex);
			}
			if (avisos != null) {
				avisos.eliminarObjeto();
				 this.actualizarListado();
			}
		}
		
		
		public void doAccionRegistroGuardarAvisos(final ActionEvent e) {
			 try {	
				 	this.getObjetoABM().setPoliza(poliza);
				 	this.getObjetoABM().setCorreos(correos);
				 	this.getObjetoABM().setClaveAgente(claveAgente);;
		            final JMResultadoOperacion r = this.getObjetoABM().guardarObjeto();
		            if (r.isExito()) {
		                this.ponerMensajeInfo(r.getMensaje());
		            }
		            else {
		                this.ponerMensajeError("Registro No Guardado: " + r.getMensaje());
		            }
		        } catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
		            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroGuardar -> " + ex.getMessage()), (Throwable)ex);
		        } catch (Exception ex) {
		            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroGuardar -> " + ex.getMessage()), (Throwable)ex);
		        }
		        this.actualizarListado();
		}
		
		
		@Override
	public void doAccionRegistroGuardar(final ActionEvent e) {
			 try {	
				 		this.getObjetoABM().setPoliza(poliza);	
				 	
				 		this.getObjetoABM().setClaveAgente(claveAgente);
				 		
				 		this.getObjetoABM().setCorreos(correos);
				 
//				 	this.getObjetoABM().setClaveAgente(claveAgente);
				 	   final JMResultadoOperacion r = this.getObjetoABM().guardarObjeto();
			            if (r.isExito()) {
			                this.ponerMensajeInfo(r.getMensaje());
			            }
			            else {
			                this.ponerMensajeError("Registro No Guardado: " + r.getMensaje());
			            }
				 	
		         
		        } catch ( IndexOutOfBoundsException | DataAccessException  | IllegalArgumentException | PersistenceException  ex) {
		            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroGuardar -> " + ex.getMessage()), (Throwable)ex);
		        }  catch (Exception ex) {
		            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> doAccionRegistroGuardar -> " + ex.getMessage()), (Throwable)ex);
		        }
		        this.actualizarListado();
		}
		

public void handleFileUpload(FileUploadEvent event) throws IOException {
//	        FacesMessage message = new FacesMessage("Ok", "Fichero: " + event.getFile().getFileName() + " subido correctamente.");
//	        FacesContext.getCurrentInstance().addMessage(null, message);
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
//	        int read = 0;
//	        byte[] bytes = new byte[1024];
//	
//	        while ((read = inputStream.read(bytes)) != -1) {
//	            outputStream.write(bytes, 0, read);
//	        }
//
//	        this.getCargaDatosService().cargaDatosCorreos(file);
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
	        
	        salida = this.getCargaDatosService().cargaDatosCorreos(file);
	        String  error = (String) salida.get("error");
		     if (error != null) {
				this.ponerMensajeError("Verificar contenido del archivo. " +error);
			} else {
		       this.actualizarListado();
		    	   this.ponerMensajeInfo("Se añadieron nuevos datos para avisos resumen ajustador.");
			}
	        }catch (ClassCastException | Error e) {
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
		     try {
		    	 outputStream.close();
		     }catch (Exception e) {
		            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> handleFileUpload -> Cerrar archivo " + e.getMessage()), (Throwable)e);
			}
		}catch (Exception e) {
            getLogger().error((Object)(new Date() + " -> " + this.getClass().getCanonicalName() + "-> handleFileUpload -> " + e.getMessage()), (Throwable)e);
            this.ponerMensajeError("Ocurrio un error a subir el archivo: "+e);

		}
	        
	    }
		


		// **************************************************************//
		// Getters y setters
		// **************************************************************//
	

		/**
		 * @return the poliza
		 */
		public String getPoliza() {
			return poliza;
		}

		/**
		 * @param poliza the poliza to set
		 */
		public void setPoliza(String poliza) {
			this.poliza = poliza;
		}

		/**
		 * @return the correos
		 */
		public String getCorreos() {
			return correos;
		}

		/**
		 * @param correos the correos to set
		 */
		public void setCorreos(String correos) {
			this.correos = correos;
		}

		/**
		 * @return the claveAgente
		 */
		public String getClaveAgente() {
			return claveAgente;
		}

		/**
		 * @param claveAgente the claveAgente to set
		 */
		public void setClaveAgente(String claveAgente) {
			this.claveAgente = claveAgente;
		}

		/**
		 * @return the _txtFiltroPoliza
		 */
		public String get_txtFiltroPoliza() {
			return _txtFiltroPoliza;
		}

		/**
		 * @param _txtFiltroPoliza the _txtFiltroPoliza to set
		 */
		public void set_txtFiltroPoliza(String _txtFiltroPoliza) {
			this._txtFiltroPoliza = _txtFiltroPoliza;
		}

		/**
		 * @return the file
		 */
		public UploadedFile getFile() {
			return file;
		}

		/**
		 * @param file the file to set
		 */
		public void setFile(UploadedFile file) {
			this.file = file;
		}

		/**
		 * @return the _txtFiltroClave
		 */
		public String get_txtFiltroClave() {
			return _txtFiltroClave;
		}

		/**
		 * @param _txtFiltroClave the _txtFiltroClave to set
		 */
		public void set_txtFiltroClave(String _txtFiltroClave) {
			this._txtFiltroClave = _txtFiltroClave;
		}
		
	}

