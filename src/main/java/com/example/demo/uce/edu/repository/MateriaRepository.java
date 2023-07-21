package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.Materia;

public interface MateriaRepository {

	public void insertar(Materia materia);
	public void actualizar(Materia materia);
	public Materia seleccionar(Integer id);
	
}
