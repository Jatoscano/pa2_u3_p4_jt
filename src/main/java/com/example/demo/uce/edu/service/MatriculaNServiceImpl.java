package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.MatriculaNRepository;
import com.example.demo.uce.edu.repository.model.Matricula;

@Service
public class MatriculaNServiceImpl implements MatriculaNService{

	@Autowired
	private MatriculaNRepository matriculaNRepository;
	
	@Override
	public void registrar(Matricula matricula) {
		
		this.matriculaNRepository.insertar(matricula);
	}

	@Override
	public void guardar(Matricula matricula) {
		
		this.matriculaNRepository.actualizar(matricula);
	}

	@Override
	public Matricula buscar(Integer id) {
		
		return this.matriculaNRepository.seleccionar(id);
	}

	@Override
	public List<Matricula> buscarMatricula() {
		
		return this.matriculaNRepository.seleccionarMatricula();
	}

	
}
