package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Vehiculo;

public interface VehiculoRepository {
	public void insertar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo);
    public Vehiculo seleccionar(Integer id);
	public void eliminar(Integer id);
	
	//Joins
		
		//Inner Join
		public List<Vehiculo> seleccionarInnerJoin();
		
		//Outer Join
		
		//Right Join
		public List<Vehiculo> seleccionarOuterRightJoin();
		
		//Left Join
		public List<Vehiculo> seleccionarOuterLeftJoin();
		
		
		//Full Outer Join
		public List<Vehiculo> seleccionarOuterFullJoin();
		
		//Join Where
		public List<Vehiculo> seleccionarWhereJoin();
}
