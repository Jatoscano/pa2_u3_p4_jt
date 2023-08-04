package com.example.demo.uce.edu.funcional;

public class IPersonaFunctionImpl<T,R> implements IPersonaFunction<String, Integer>{

	@Override
	public String aplicate(Integer arg) {
		
		String resultado;
		String cadena = "Juan";
		resultado = (String) arg.toString().concat(cadena);
		
	    return resultado;
	}

}
