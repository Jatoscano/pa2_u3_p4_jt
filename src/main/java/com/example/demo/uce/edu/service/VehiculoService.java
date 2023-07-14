package com.example.demo.uce.edu.service;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Vehiculo;

public interface VehiculoService {
	public void registrar(Vehiculo vehiculo);
	public void guardar(Vehiculo vehiculo);
    public Vehiculo buscar(Integer id);
	public void borrar(Integer id);
	
	//Joins
		
		//Inner Join
		public List<Vehiculo> buscarInnerJoin();
		
		//Outer Join
		
		//Right Join
		public List<Vehiculo> buscarOuterRightJoin();
		
		//Left Join
		public List<Vehiculo> buscarOuterLeftJoin();
		
		
		//Full Outer Join
		public List<Vehiculo> buscarOuterFullJoin();
		
		//Join Where
		public List<Vehiculo> buscarWhereJoin();
}
