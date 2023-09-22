package com.aaq.col.clases.util;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class TrustAllHosts  implements HostnameVerifier {

	  public boolean verify( String hostname, SSLSession sslSession ) {
	    return true;
	  }


}
