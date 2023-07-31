package com.example.demo.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaUnaryOperator<T> {

	public T derivate(T arg);
}
