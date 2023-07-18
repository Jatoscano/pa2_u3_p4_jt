package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.EstudianteN;

public interface EstudianteNRepository {

	public void insertar(EstudianteN estudianteN);
	public void actualizar(EstudianteN estudianteN);
	public EstudianteN seleccionar(Integer id);
}
