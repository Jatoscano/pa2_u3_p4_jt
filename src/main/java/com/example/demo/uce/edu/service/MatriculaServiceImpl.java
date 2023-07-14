package com.example.demo.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.MatriculaRepository;
import com.example.demo.uce.edu.repository.model.Matriculas;

@Service
public class MatriculaServiceImpl implements MatriculaService{

	@Autowired
	private MatriculaRepository matriculaRepository;
	@Override
	public void registrar(Matriculas matricula) {
		
		this.matriculaRepository.insertar(matricula);
	}

	@Override
	public void guardar(Matriculas matricula) {
		
		this.matriculaRepository.actualizar(matricula);
	}

	@Override
	public Matriculas buscar(Integer id) {
		
		return this.matriculaRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.matriculaRepository.eliminar(id);
	}

}
