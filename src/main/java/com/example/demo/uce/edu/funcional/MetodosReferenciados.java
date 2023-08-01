package com.example.demo.uce.edu.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosReferenciados<T,R> {

	private static final Logger LOGGER = LoggerFactory.getLogger(MetodosReferenciados.class);
	public Integer devuelveId() {
		
		return 10;
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
	public T aplicacion(R arg) {
		 
		T resultado;
		String cadena = "Juan";
		resultado = (T) arg.toString().concat(cadena);
		
	    return resultado;
	}
	
	public T derivacion(T arg) {
		T numero;
		Integer suma = 10;
		
		suma = suma + (suma*2);
		arg = (T) suma;
		numero = arg;
		
		return numero;
	}
	
}
