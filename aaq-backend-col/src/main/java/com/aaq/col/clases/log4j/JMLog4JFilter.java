package com.aaq.col.clases.log4j;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.varia.StringMatchFilter;

/**
 * May 26, 2014 4:35:31 PM
 * 
 * @author mfernandez
 */
public class JMLog4JFilter extends StringMatchFilter {

	/**
	 * May 26, 2014 4:35:31 PM
	 */
	public JMLog4JFilter() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.apache.log4j.varia.StringMatchFilter#decide(org.apache.log4j.spi.
	 * LoggingEvent)
	 */
	@Override
	public int decide(final LoggingEvent event) {
		if ((event.getThrowableInformation() != null) && (event.getThrowableInformation().getThrowable() != null)) {
			if (StringUtils.contains(ExceptionUtils.getStackTrace(event.getThrowableInformation().getThrowable()),
					"Broken pipe")) {
				return -1;
			}
			if (StringUtils.contains(ExceptionUtils.getStackTrace(event.getThrowableInformation().getThrowable()),
					"Socket read failed")) {
				return -1;
			}
			
		}

		return super.decide(event);
	}
}
