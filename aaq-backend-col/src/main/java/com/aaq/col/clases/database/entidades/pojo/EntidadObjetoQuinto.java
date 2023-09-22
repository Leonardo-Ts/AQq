package com.aaq.col.clases.database.entidades.pojo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.MethodUtils;

public class EntidadObjetoQuinto {
	

	private Object valor0;
    private Object valor1;
    private Object valor2;
    private Object valor3;
    private Object valor4;
    
    public EntidadObjetoQuinto() {
    }
    
    public EntidadObjetoQuinto(final Object[] obj) {
        if (obj != null && obj.length > 0) {
            int i = 0;
            for (final Object objeto : obj) {
                try {
                    MethodUtils.invokeMethod((Object)this, "setValor" + i, new Object[] { objeto });
                }
                catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex3) {
                    final ReflectiveOperationException ex2 = null;
                    @SuppressWarnings("unused")
					final ReflectiveOperationException ex = ex2;
                }
                ++i;
            }
        }
    }

	public Object getValor0() {
		return valor0;
	}

	public void setValor0(Object valor0) {
		this.valor0 = valor0;
	}

	public Object getValor1() {
		return valor1;
	}

	public void setValor1(Object valor1) {
		this.valor1 = valor1;
	}

	public Object getValor2() {
		return valor2;
	}

	public void setValor2(Object valor2) {
		this.valor2 = valor2;
	}

	public Object getValor3() {
		return valor3;
	}

	public void setValor3(Object valor3) {
		this.valor3 = valor3;
	}

	public Object getValor4() {
		return valor4;
	}

	public void setValor4(Object valor4) {
		this.valor4 = valor4;
	}
    
    
    

}
