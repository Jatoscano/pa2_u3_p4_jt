package com.example.demo.uce.edu.service;

import com.example.demo.uce.edu.repository.model.Materia;

public interface MateriaService {

	public void registrar(Materia materia);
	public void guardar(Materia materia);
	public Materia buscar(Integer id);
}
