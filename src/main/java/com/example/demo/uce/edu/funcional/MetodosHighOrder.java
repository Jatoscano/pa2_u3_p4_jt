package com.example.demo.uce.edu.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MetodosHighOrder {

	private static final Logger LOGGER = LoggerFactory.getLogger(MetodosHighOrder.class);
	
	public static void metodoSupplier(IPersonaSupplier<String> funcionSupplier) {
	
		funcionSupplier.getId();
		LOGGER.info("High Order Supplier: " + funcionSupplier.getId());
	}
	
	public static void metodoConsumer(IPersonaConsumer<String> funcionConsumer, String valor) {
		
		funcionConsumer.accept(valor);
	}
	

	public static void metodoPredicate(IPersonaPredicate<String> funcionPredicate, String cadena) {
		
		LOGGER.info("High Order Predicate: " + funcionPredicate.evaluate(cadena));
	}

	public static void metodoFunction(IPersonaFunction<String,Integer> funcionFunction, Integer numero) {
		
		LOGGER.info("High Order Function: " + funcionFunction.aplicate(numero));
	}
	

	public static void metodoUnaryOperator(IPersonaUnaryOperator<Integer> funcionUnaryOperator, Integer numero) {
		
		LOGGER.info("High Order Unary Operator: " + funcionUnaryOperator.derivate(numero));
	}
}
