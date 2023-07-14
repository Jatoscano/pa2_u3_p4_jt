package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.Matriculas;

public interface MatriculaRepository {
	
	public void insertar(Matriculas matricula);
	public void actualizar(Matriculas matricula);
    public Matriculas seleccionar(Integer id);
	public void eliminar(Integer id);
}
