package com.aaq.col.clases.database.entidades.pojo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.MethodUtils;

import com.jmfg.jmlib.sistema.classes.dao.entidad.JMEntidad;

public class EntidadObjeto  extends JMEntidad {

	private static final long serialVersionUID = -8793711875386035056L;
	
	private Object valor0;
    private Object valor1;
    
    public EntidadObjeto() {
    }
    
    @SuppressWarnings("unused")
	public EntidadObjeto(final Object[] obj) {
        if (obj != null && obj.length > 0) {
            int i = 0;
            for (final Object objeto : obj) {
                try {
                    MethodUtils.invokeMethod((Object)this, "setValor" + i, new Object[] { objeto });
                }
                catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex3) {
                    final ReflectiveOperationException ex2 = null;
                    final ReflectiveOperationException ex = ex2;
                }
                ++i;
            }
        }
    }
    
    
    
	@Override
	public Integer getId() {
		return null;
	}
	
	public Object getValor0() {
		return valor0;
	}

	/**
	 * @param valor0 the valor0 to set
	 */
	public void setValor0(Object valor0) {
		this.valor0 = valor0;
	}

	/**
	 * @return the valor1
	 */
	public Object getValor1() {
		return valor1;
	}

	/**
	 * @param valor1 the valor1 to set
	 */
	public void setValor1(Object valor1) {
		this.valor1 = valor1;
	}

	
}
