package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Ciudadano;

public interface CiudadanoRepository {
	
	public void insertar(Ciudadano ciudadano);
	public void actualizar(Ciudadano ciudadano);
    public Ciudadano seleccionar(Integer id);
	public void eliminar(Integer id);
	
	//Joins
		
		//Inner Join
		public List<Ciudadano> seleccionarInnerJoin();
		
		//Outer Join
		
		//Right Join
		public List<Ciudadano> seleccionarOuterRightJoin();
		
		//Left Join
		public List<Ciudadano> seleccionarOuterLeftJoin();
		
		
		//Full Outer Join
		public List<Ciudadano> seleccionarOuterFullJoin();
		
		//Join Where
		public List<Ciudadano> seleccionarWhereJoin();	
}
