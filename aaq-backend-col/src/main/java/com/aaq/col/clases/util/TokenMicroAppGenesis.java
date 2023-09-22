package com.aaq.col.clases.util;

public class TokenMicroAppGenesis {
	
	public static String getToken(String reporte) {
		
		String token = "";
		int primero = Integer.parseInt(reporte.substring(10,11));
		
		int aux = 0;
		int suma = 0;
		int residuo = 0;
		int cociente = 0;
		for(int i = 0;i<11;i++) {
			aux = Integer.parseInt(reporte.substring(i, i+1));
			suma += aux;
		}
		cociente = suma/10;
		residuo = suma%10;
		
		switch(primero) {
		case 0:
			token = token.concat("q");
			break;
		case 1:
			token = token.concat("a");
			break;
		case 2:
			token = token.concat("b");
			break;
		case 3:
			token = token.concat("c");
			break;
		case 4:
			token = token.concat("d");
			break;
		case 5:
			token = token.concat("e");
			break;
		case 6:
			token = token.concat("f");
			break;
		case 7:
			token = token.concat("g");
			break;
		case 8:
			token = token.concat("h");
			break;
		case 9:
			token = token.concat("i");
			break;
		}
		
		switch(cociente) {
		case 0:
			token = token.concat("q");
			break;
		case 1:
			token = token.concat("a");
			break;
		case 2:
			token = token.concat("b");
			break;
		case 3:
			token = token.concat("c");
			break;
		case 4:
			token = token.concat("d");
			break;
		case 5:
			token = token.concat("e");
			break;
		case 6:
			token = token.concat("f");
			break;
		case 7:
			token = token.concat("g");
			break;
		case 8:
			token = token.concat("h");
			break;
		case 9:
			token = token.concat("i");
			break;
		}
		
		switch(residuo) {
		case 0:
			token = token.concat("q");
			break;
		case 1:
			token = token.concat("a");
			break;
		case 2:
			token = token.concat("b");
			break;
		case 3:
			token = token.concat("c");
			break;
		case 4:
			token = token.concat("d");
			break;
		case 5:
			token = token.concat("e");
			break;
		case 6:
			token = token.concat("f");
			break;
		case 7:
			token = token.concat("g");
			break;
		case 8:
			token = token.concat("h");
			break;
		case 9:
			token = token.concat("i");
			break;
		}
		
		return token;
	}

}
