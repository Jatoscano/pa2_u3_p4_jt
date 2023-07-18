package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.model.Matricula;

public interface MatriculaNService {

	public void registrar(Matricula matricula);
	public void guardar(Matricula matricula);
    public Matricula buscar(Integer id);
}
