package com.aaq.col.clases.util;

import java.util.Date;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.text.StrBuilder;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

public class JMUtileriaExcepcion {
	private final Log4JLogger logger;

	/**
	 * @param deQuien
	 */
	public JMUtileriaExcepcion(final String deQuien) {
		this.logger = (Log4JLogger) LogFactory.getLog(deQuien);
	}

	/**
	 * @param ex
	 * @param clazz
	 * @param metodo
	 * @param params
	 */
	public void manejarExcepcion(final Exception ex, final Class<?> clazz, final String metodo, final Object... params) {
		final StrBuilder b = new StrBuilder();

		if (params != null) {
			for (final Object obj : params) {
				b.append("[" + ReflectionToStringBuilder.toString(obj) + "]");
			}
		}

		this.logger.error(new Date() + ", Clase ==> " + clazz.getSimpleName() + ", Metodo ==> " + metodo
				+ ", Params ==> " + b, ex);

	}

}
