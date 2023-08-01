package com.example.demo.uce.edu.funcional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IPersona persona = new IPersonaImpl();

		persona.caminar();

		// 1. Supplier

		// 2. Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOGGER.info("Supplier Clase : " + supplier.getId());

		// Lambdas
		IPersonaSupplier<String> supplier2 = () -> "17246093740";
		LOGGER.info("Supplier Lambda : " + supplier2.getId());

		IPersonaSupplier<String> supplier3 = () -> {
			String cedula = "1827049583";
			cedula = cedula + "1234567890";
			return cedula;
		};

		LOGGER.info("Supplier Lambda : " + supplier3.getId());
		
		//Metodos Referenciados
		MetodosReferenciados metodosReferenciados = new MetodosReferenciados();
		IPersonaSupplier<Integer> supplier4 = metodosReferenciados::devuelveId;
		LOGGER.info("Supplier Metodos Referenciados: " + supplier4.getId());
	

		// 2: Consumer
		// Clases
		IPersonaConsumer<String> consumer1 = new IPersonaConsumerImpl();
		LOGGER.info("Consumer Clase: ");
		consumer1.accept("Juan Toscano");

		// Lambdas
		IPersonaConsumer<String> consumer2 = cadena -> {
			LOGGER.info("1");
			LOGGER.info("2");
			LOGGER.info(cadena);
		};
		LOGGER.info("Consumer Lambda: ");
		consumer2.accept("Juan Toscano - Henry Coyago");
		
		//Metodos Referenciados
		MetodosReferenciados metodosReferenciados2 = new MetodosReferenciados();
		IPersonaConsumer<String> consumer3 = metodosReferenciados2::aceptar;
		LOGGER.info("Consumer Metodos Referenciados: ");
		consumer3.accept("Juan 3");

		// 3. Predicate
		// Lambdas
		IPersonaPredicate<Integer> predicate1 = valor -> valor.compareTo(8) == 0;
		LOGGER.info("Predicate Lambda: " + predicate1.evaluate(4));

		IPersonaPredicate<Integer> predicate2 = valor -> {
			Integer valor2 = 10;
			valor = valor + valor2;
			if (valor.compareTo(100) > 0) {
				return true;
			} else {
				return false;
			}
		};
		LOGGER.info("Predicate Lambda: " + predicate2.evaluate(400));

		//Interface Caracter
		IPersonaPredicate<String> predicate3 = caracter -> "Juan".contains(caracter);

		LOGGER.info("Predicate Lambda: " + predicate3.evaluate("j"));
		
		//Interface Caracter BiPredicate
		IPersonaBiPredicate<String, String> predicate4 = (caracter, cadena) -> cadena.contains(caracter);

		LOGGER.info("BiPredicate Lambda: " + predicate4.evaluate("J", "Juan"));
		
		
		//Metodos Referenciados
		MetodosReferenciados metodosReferenciados3 = new MetodosReferenciados();
		IPersonaPredicate<String> predicate5 = metodosReferenciados3::evaluaString;
		LOGGER.info("Predicate Metodos Referenciados: " + predicate5.evaluate("Juan"));
		
		
		//4. Function
		//IPersonaFunction<T, R> function
		
		//T-> Es el parametro que retorna
		//R -> Es el parametro que recibe
		
		IPersonaFunction<String, Integer> function1 = numero -> {
			String valorFinal = numero.toString().concat("valor");
			return valorFinal;
		};
		LOGGER.info("Function Lambda: " + function1.aplicate(8));
		
		//5. Unary Operator
		//Lambdas
		IPersonaUnaryOperator<Integer> unaryOperator1 = numero -> numero + (numero*2);
		LOGGER.info("Unary Operator Lambda: " + unaryOperator1.derivate(10));
		
		UnaryOperatorFunction<Integer> unaryOperator2 = numero -> numero + (numero*2);
		LOGGER.info("Unary Operator Function Lambda: " + unaryOperator2.aplicate(2));

	}

}
