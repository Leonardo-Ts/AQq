package com.aaq.col.system.beans.catalogo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.aaq.col.clases.database.entidades.Grupo;
import com.aaq.col.system.beans.extensibles.JMBeanExtensiblePrincipal;

@ManagedBean(name = "beanAplicacioCargaMasiva")
@SessionScoped
public class BeanAplicacioCargaMasiva extends JMBeanExtensiblePrincipal<Grupo>{

	public Log logCargaMasiva = LogFactory.getLog(BeanAplicacioCargaMasiva.class);
	private static final long serialVersionUID = -3833414121454001056L;
//	private UploadedFile file;
	private UploadedFile fileGrupos;
	private UploadedFile fileHorarios;
	private UploadedFile fileGrupoHorario;
	private UploadedFile fileTerminalGrupo;
	
	@Override
	public void actualizarListado() {
		
	}

	public String doAccionCarga() {
			return "cargaMasiva";
	}
	

	public void cargaMasivaHorarioGrupos(FileUploadEvent event) throws IOException {
	try {
		Map<String, Object>  salida = null;
      this.setFileGrupoHorario(event.getFile());

      String name = fileGrupoHorario.getFileName();

      InputStream inputStream = fileGrupoHorario.getInputstream();
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
		this.setFileGrupos(event.getFile());
		String name = fileGrupos.getFileName();

	      InputStream inputStream = fileGrupos.getInputstream();
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
	      salida = this.getCargaDatosService().cargaDatosGrupos(file);
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

	public void cargaMasivaHorarios(FileUploadEvent event) throws IOException {
		try {
			Map<String, Object>  salida = null;
			this.setFileHorarios(event.getFile());
			String name = fileHorarios.getFileName();

		      InputStream inputStream = fileHorarios.getInputstream();
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
		      salida = this.getCargaDatosService().cargaDatosHorarios(file);
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

	public void cargaMasivaTerminalesGrupos(FileUploadEvent event) throws IOException {
		try {
			Map<String, Object>  salida = null;
			this.setFileTerminalGrupo(event.getFile());
			String name = fileTerminalGrupo.getFileName();

		      InputStream inputStream = fileTerminalGrupo.getInputstream();
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
				this.ponerMensajeError("Ocurrio un error a subir al leer el archivo de carga masiva de grupos-terminales: "+e);
			}
		      salida = this.getCargaDatosService().cargaDatosGruposTerminales(file);
		      String  error = (String) salida.get("error");
			     if (error != null) {
					this.ponerMensajeError("Verificar contenido del archivo. "+ error);
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

	public UploadedFile getFileGrupos() {
		return fileGrupos;
	}

	public void setFileGrupos(UploadedFile fileGrupos) {
		this.fileGrupos = fileGrupos;
	}

	public UploadedFile getFileHorarios() {
		return fileHorarios;
	}

	public void setFileHorarios(UploadedFile fileHorarios) {
		this.fileHorarios = fileHorarios;
	}

	
	public UploadedFile getFileGrupoHorario() {
		return fileGrupoHorario;
	}

	public void setFileGrupoHorario(UploadedFile fileGrupoHorario) {
		this.fileGrupoHorario = fileGrupoHorario;
	}

	public UploadedFile getFileTerminalGrupo() {
		return fileTerminalGrupo;
	}

	public void setFileTerminalGrupo(UploadedFile fileTerminalGrupo) {
		this.fileTerminalGrupo = fileTerminalGrupo;
	}
	
	
	
	
	
}
