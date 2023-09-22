package com.aaq.col.clases.path;

import java.util.Hashtable;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
public class ProveedorApplicationContextFormatos implements ApplicationContextAware {
	
    private static ApplicationContext ctxFormatos;
    private static Hashtable<String, String> configuracionFormatos;
    
    public ProveedorApplicationContextFormatos(final Hashtable<String, String> cnf) {
    	ProveedorApplicationContextFormatos.configuracionFormatos = cnf;
    }
    
    public void setApplicationContext(final ApplicationContext ctxFormatos) throws BeansException {
    	ProveedorApplicationContextFormatos.ctxFormatos = ctxFormatos;
    }
    
    public static ApplicationContext getApplicationContext() {
        return ProveedorApplicationContextFormatos.ctxFormatos;
    }
    
    public static Hashtable<String, String> getConfiguracionFormatos() {
        return ProveedorApplicationContextFormatos.configuracionFormatos;
    }
    
    public static void setConfiguracionFormatos(final Hashtable<String, String> configuracionFormatos) {
    	ProveedorApplicationContextFormatos.configuracionFormatos = configuracionFormatos;
    }
}