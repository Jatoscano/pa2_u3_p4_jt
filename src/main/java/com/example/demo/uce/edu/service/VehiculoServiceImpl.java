package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.VehiculoRepository;
import com.example.demo.uce.edu.repository.model.Vehiculo;

@Service
public class VehiculoServiceImpl implements VehiculoService{

	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	@Override
	public void registrar(Vehiculo vehiculo) {
		
		this.vehiculoRepository.insertar(vehiculo);
	}

	@Override
	public void guardar(Vehiculo vehiculo) {
		
		this.vehiculoRepository.actualizar(vehiculo);
	}

	@Override
	public Vehiculo buscar(Integer id) {
		
		return this.vehiculoRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.vehiculoRepository.eliminar(id);
	}

	@Override
	public List<Vehiculo> buscarInnerJoin() {
		
		return this.vehiculoRepository.seleccionarInnerJoin();
	}

	@Override
	public List<Vehiculo> buscarOuterRightJoin() {
		
		return this.vehiculoRepository.seleccionarOuterRightJoin();
	}

	@Override
	public List<Vehiculo> buscarOuterLeftJoin() {
		
		return this.vehiculoRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Vehiculo> buscarOuterFullJoin() {
		
		return this.vehiculoRepository.seleccionarOuterFullJoin();
	}

	@Override
	public List<Vehiculo> buscarWhereJoin() {
		
		return this.vehiculoRepository.seleccionarWhereJoin();
	}

	@Override
	public List<Vehiculo> buscarJoinFetch() {
		
		return this.vehiculoRepository.seleccionarJoinFetch();
	}
	
	

}
