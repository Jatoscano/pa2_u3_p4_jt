package com.example.demo.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.PropietarioRepository;
import com.example.demo.uce.edu.repository.model.Propietario;

@Service
public class PropietarioServiceImpl implements PropietarioService{

	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@Override
	public void registrar(Propietario propietario) {
		
		this.propietarioRepository.insertar(propietario);
	}

	@Override
	public void guardar(Propietario propietario) {
		
		this.propietarioRepository.actualizar(propietario);
	}

	@Override
	public Propietario buscar(Integer id) {
		
		return this.propietarioRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.propietarioRepository.eliminar(id);
	}

}
