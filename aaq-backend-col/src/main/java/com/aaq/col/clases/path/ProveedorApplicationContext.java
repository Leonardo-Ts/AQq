package com.aaq.col.clases.path;

import java.util.Hashtable;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ProveedorApplicationContext implements ApplicationContextAware {
	
    private static ApplicationContext ctx;
    private static Hashtable<String, String> configuracion2;
    
    public ProveedorApplicationContext(final Hashtable<String, String> cnf) {
    	ProveedorApplicationContext.configuracion2 = cnf;
    }
    
    public void setApplicationContext(final ApplicationContext ctx) throws BeansException {
    	ProveedorApplicationContext.ctx = ctx;
    }
    
    public static ApplicationContext getApplicationContext() {
        return ProveedorApplicationContext.ctx;
    }
    
    public static Hashtable<String, String> getConfiguracion2() {
        return ProveedorApplicationContext.configuracion2;
    }
    
    public static void setConfiguracion2(final Hashtable<String, String> configuracion2) {
    	ProveedorApplicationContext.configuracion2 = configuracion2;
    }
}
