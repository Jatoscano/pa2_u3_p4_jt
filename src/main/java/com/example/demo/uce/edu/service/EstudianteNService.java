package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.model.EstudianteN;

public interface EstudianteNService {

	public void registrar(EstudianteN estudianteN);
	public void guardar(EstudianteN estudianteN);
	public EstudianteN buscar(Integer id);
}
