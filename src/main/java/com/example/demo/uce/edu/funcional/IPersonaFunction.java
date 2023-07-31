package com.example.demo.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaFunction<T,R> {

	public T aplicate(R arg);
}
