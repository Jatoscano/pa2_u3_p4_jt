package com.example.demo.uce.edu.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados {

	private static final Logger LOGGER = LoggerFactory.getLogger(MetodosReferenciados.class);
	public Integer devuelveId() {
		
		return 8;
	}
	
	public void aceptar(String arg) {
		String cadena = "Juan";
		LOGGER.info(cadena + " " + arg);
	}
	
	public boolean evaluaString(String arg) {
		String cadena = "Juan";
		if(cadena.contains("F")) {
			return true;
		}
		
		else {
			return false;
		}
	}
}
