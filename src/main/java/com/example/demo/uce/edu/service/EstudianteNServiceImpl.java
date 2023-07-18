package com.example.demo.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.EstudianteNRepository;
import com.example.demo.uce.edu.repository.model.EstudianteN;

@Service
public class EstudianteNServiceImpl implements EstudianteNService{

	@Autowired
	private EstudianteNRepository estudianteNRepository;
	
	@Override
	public void registrar(EstudianteN estudianteN) {
		
		this.estudianteNRepository.insertar(estudianteN);
	}

	@Override
	public void guardar(EstudianteN estudianteN) {
		
		this.estudianteNRepository.actualizar(estudianteN);
	}

	@Override
	public EstudianteN buscar(Integer id) {
		
		return this.estudianteNRepository.seleccionar(id);
	}

}
