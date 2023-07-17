package com.example.demo.uce.edu.repository;

import com.example.demo.uce.edu.repository.model.Transferencia;

public interface TransferenciaRepository {

	public void insertar(Transferencia transferencia);
	public void actualizar(Transferencia transferencia);
    public Transferencia seleccionar(Integer id);
	public void eliminar(Integer id);
	
	
}
