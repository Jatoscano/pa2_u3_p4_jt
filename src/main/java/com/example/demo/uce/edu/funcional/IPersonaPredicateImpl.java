package com.example.demo.uce.edu.funcional;

public class IPersonaPredicateImpl<T> implements IPersonaPredicate<String>{

	@Override
	public boolean evaluate(String arg) {
		String cadena = "Juan";
		if(cadena.contains("F")) {
			return true;
		}
		
		else {
			return false;
		}
	}

}
