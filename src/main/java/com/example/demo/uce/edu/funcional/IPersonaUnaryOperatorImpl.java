package com.example.demo.uce.edu.funcional;

public class IPersonaUnaryOperatorImpl<T> implements IPersonaUnaryOperator<Integer>{

	@Override
	public Integer derivate(Integer arg) {
		Integer numero;
		Integer suma = 10;
		
		suma = suma + (suma*2);
		arg = (Integer) suma;
		numero = arg;
		
		return numero;
	}

}
