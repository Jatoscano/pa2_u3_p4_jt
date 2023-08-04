package com.example.demo.uce.edu.funcional;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
		IPersonaSupplier<Integer> supplier4 = MetodosReferenciados::devuelveId;
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
		IPersonaConsumer<String> consumer3 = MetodosReferenciados::aceptar;
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
		//Lambdas
		//IPersonaFunction<T, R> function
		
		//T-> Es el parametro que retorna
		//R -> Es el parametro que recibe
		
		IPersonaFunction<String, Integer> function1 = numero -> {
			String valorFinal = numero.toString().concat("valor");
			return valorFinal;
		};
		LOGGER.info("Function Lambda: " + function1.aplicate(8));
		
		//Metodos Referenciados
		MetodosReferenciados<String, Integer> metodosReferenciados4 = new MetodosReferenciados();
		IPersonaFunction<String, Integer> function2 = metodosReferenciados4::aplicacion;
		LOGGER.info("Function Metodos Referenciados: " + function2.aplicate(10));
		
		//5. Unary Operator
		//Lambdas
		IPersonaUnaryOperator<Integer> unaryOperator1 = numero -> numero + (numero*2);
		LOGGER.info("Unary Operator Lambda: " + unaryOperator1.derivate(10));
		
		UnaryOperatorFunction<Integer> unaryOperator2 = numero -> numero + (numero*2);
		LOGGER.info("Unary Operator Function Lambda: " + unaryOperator2.aplicate(2));
		
		//Metodos Referenciados
		MetodosReferenciados<Integer,Integer> metodosReferenciados5 = new MetodosReferenciados();
		IPersonaFunction<Integer, Integer> unaryOperator3 = metodosReferenciados5::derivacion;
		LOGGER.info("Unary Operator Metodos Referenciados: " + unaryOperator3.aplicate(10));
		
		//Metodos High Order =**************************************************
		
		//Supplier
		//1. Clases
		
		IPersonaSupplier<String> supplierO = new PersonaSupplierImpl();
		
		MetodosHighOrder.metodoSupplier(supplierO);
		
		//2. Lambdas
		MetodosHighOrder.metodoSupplier(()-> "1234567890");
		
		//3. Metodos Referenciados
		MetodosHighOrder.metodoSupplier(MetodosReferenciados::devuelveIdO);
		
		//Consumer
		//1. Clases
		MetodosHighOrder.metodoConsumer(new IPersonaConsumerImpl(), "Clases Consummer");
		//2. Lambdas
		MetodosHighOrder.metodoConsumer(valor -> LOGGER.info(valor), "Lambdas Consumer");
		//3. Metodos Referenciados
		MetodosHighOrder.metodoConsumer(MetodosReferenciados::aceptar, "Metodos Referenciados Consumer");
		
		//Predicate
		//1. Clases
		MetodosHighOrder.metodoPredicate(new IPersonaPredicateImpl<String>(), "Juan");
		//2. Lambdas
		MetodosHighOrder.metodoPredicate(cadena ->cadena.contains("J"), "Juan");
		//3. Metodos Referenciados
		MetodosHighOrder.metodoPredicate(MetodosReferenciados::evaluaStringO, "Juan");
		
		//Function
		//1. Clases
		MetodosHighOrder.metodoFunction(new IPersonaFunctionImpl<String, Integer>(),10);
		//2. Lambdas
		MetodosHighOrder.metodoFunction(valor -> valor.toString().concat("valor"), 8);
		//3. Metodos Referenciados
		MetodosHighOrder.metodoFunction(MetodosReferenciados::aplicacionO ,8);
		
		//Function
		//1. Clases
		MetodosHighOrder.metodoUnaryOperator(new IPersonaUnaryOperatorImpl<>(), 10);
		//2. Lambdas
		MetodosHighOrder.metodoUnaryOperator(numero -> numero + (numero*2), 8);
		//3. Metodos Referenciados
		MetodosHighOrder.metodoUnaryOperator(MetodosReferenciados::derivacionO, 10);
		
		//Interfaces Funcionales Java
		//Supplier
		Stream<String> lista = Stream.generate(() ->"12345678990").limit(10);
		lista.forEach(cadena -> LOGGER.info(cadena));
		IPersonaSupplier<String> supplier5 = MetodosReferenciados::devuelveIdO;
		supplier5.equals(lista);
		//Consummer
		List<Integer> listaNumeros = Arrays.asList(1,2,3,4,5,6,7,8,9,0);
		listaNumeros.forEach(cadena ->{

			LOGGER.info(""+ cadena);
		});
		
		//Predicate
		Stream<Integer> listaFinal = listaNumeros.stream().filter(numero -> numero >= 5);
		listaFinal.forEach(numero -> LOGGER.info("Valor: "+ numero));
		
		//Function
		Stream<String> listaCambiada =  listaNumeros.stream().map(numero ->{
			Integer num = 10;
			num =  numero + num;
			return "N: " + num;
		});
		listaCambiada.forEach(cadena -> LOGGER.info(cadena));
		
		//Unary Operator
		Stream<Integer> listaCambiada2 =  listaNumeros.stream().map(numero ->{
			Integer num = 10;
			num =  numero + num;
			return num;
		});
		listaCambiada2.forEach(cadena -> LOGGER.info(cadena.toString()));

	}

}
