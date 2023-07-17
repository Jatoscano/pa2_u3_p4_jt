package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.Propietario;

public interface PropietarioRepository {

	public void insertar(Propietario propietario);
	public void actualizar(Propietario propietario);
    public Propietario seleccionar(Integer id);
	public void eliminar(Integer id);
}
