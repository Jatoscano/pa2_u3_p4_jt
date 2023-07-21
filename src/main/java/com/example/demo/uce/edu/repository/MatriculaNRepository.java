package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Matricula;

public interface MatriculaNRepository {

	public void insertar(Matricula matricula);
	public void actualizar(Matricula matricula);
    public Matricula seleccionar(Integer id);
    
    public List<Matricula> seleccionarMatricula();
}
