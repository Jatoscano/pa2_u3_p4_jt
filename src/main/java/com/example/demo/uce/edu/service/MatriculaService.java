package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.model.Matriculas;

public interface MatriculaService {

	public void registrar(Matriculas matricula);
	public void guardar(Matriculas matricula);
    public Matriculas buscar(Integer id);
	public void borrar(Integer id);
}
