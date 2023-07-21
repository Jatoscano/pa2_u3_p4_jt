package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.Provincia;

public interface ProvinciaRepository {

	public void insertar(Provincia provincia);
	public void actualizar(Provincia provincia);
	public Provincia seleccionar(Integer id);
}
