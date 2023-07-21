package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.Semestre;

public interface SemestreRepository {

	public void insertar(Semestre semestre);
	public void actualizar(Semestre semestre);
	public Semestre seleccionar(Integer id);
}
