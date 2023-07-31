package com.example.demo.uce.edu.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IPersona persona = new IPersonaImpl();
		
		persona.caminar();
		
		//1. Supplier
		
		//2. Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOGGER.info("Supplier Clase : "+ supplier.getId());
		
		
		//Lambdas
		IPersonaSupplier<String> supplier2 = () -> "17246093740"; 
		LOGGER.info("Supplier Lambda : "+ supplier2.getId());
		
		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1827049583";
			cedula = cedula + "1234567890";
			return cedula;
		}; 
		
		LOGGER.info("Supplier Lambda : "+ supplier3.getId());
	}

}
