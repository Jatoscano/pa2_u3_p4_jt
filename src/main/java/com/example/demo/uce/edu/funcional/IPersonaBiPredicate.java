package com.example.demo.uce.edu.funcional;

@FunctionalInterface
public interface IPersonaBiPredicate<T,R> {

	public boolean evaluate(T arg1, R arg2);
}
