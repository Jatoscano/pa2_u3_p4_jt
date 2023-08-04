package com.example.demo.uce.edu.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {

	private static final Logger LOGGER = LoggerFactory.getLogger(MetodosHighOrder.class);
	
	public static void metodo(IPersonaSupplier<String> funcionSupplier) {
	
		funcionSupplier.getId();
		LOGGER.info("High Order Supplier: " + funcionSupplier.getId());
	}
	
	public static void metodoConsumer(IPersonaConsumer<String> funcionConsumer, String valor) {
		
		funcionConsumer.accept(valor);
	}
}
