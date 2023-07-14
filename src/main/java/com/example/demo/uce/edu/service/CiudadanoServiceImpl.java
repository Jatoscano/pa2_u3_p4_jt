package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.CiudadanoRepository;
import com.example.demo.uce.edu.repository.model.Ciudadano;

@Service
public class CiudadanoServiceImpl implements CiudadanoService{

	@Autowired
	private CiudadanoRepository ciudadanoRepository;
	
	@Override
	public void registrar(Ciudadano ciudadano) {
		
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public void guardar(Ciudadano ciudadano) {
		
		this.ciudadanoRepository.actualizar(ciudadano);
	}

	@Override
	public Ciudadano buscar(Integer id) {
	
		return this.ciudadanoRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.ciudadanoRepository.eliminar(id);
	}

	@Override
	public List<Ciudadano> buscarInnerJoin() {
		
		return this.ciudadanoRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Ciudadano> buscarOuterRightJoin() {
		
		return this.ciudadanoRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Ciudadano> buscarOuterLeftJoin() {
		
		return this.ciudadanoRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Ciudadano> buscarOuterFullJoin() {
		
		return this.ciudadanoRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Ciudadano> buscarWhereJoin() {
		
		return this.ciudadanoRepository.seleccionarWhereJoin();
	}
	
	
	
}
