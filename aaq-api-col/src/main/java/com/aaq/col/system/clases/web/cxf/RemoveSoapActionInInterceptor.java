package com.aaq.col.system.clases.web.cxf;

import java.util.List;
import java.util.Map;

import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapActionInInterceptor;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;

public class RemoveSoapActionInInterceptor extends AbstractSoapInterceptor {
	
	public RemoveSoapActionInInterceptor() {
		super(Phase.READ);
		this.addBefore(SoapActionInInterceptor.class.getName());
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleMessage(final SoapMessage message) throws Fault {

		if (message.getVersion() instanceof Soap11) {
			final Map<String, List<String>> headers = CastUtils.cast((Map<String, List<String>>) message
					.get(Message.PROTOCOL_HEADERS));
			headers.remove("SOAPAction");
		}
	}
}
