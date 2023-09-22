package com.aaq.col.clases.util;

import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpHeaders;

public class RestAuthority {
	
	public HttpHeaders headersAuthority(final String username, final String password){
		HttpHeaders httpHeaders = new HttpHeaders();
		
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		
		httpHeaders.set("Authorization", authHeader);
		
		return httpHeaders; 
	}
}
