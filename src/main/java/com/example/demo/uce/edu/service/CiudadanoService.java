package com.example.demo.uce.edu.service;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Ciudadano;
import com.example.demo.uce.edu.repository.model.Hotel;

public interface CiudadanoService {

	public void registrar(Ciudadano ciudadano);
	public void guardar(Ciudadano ciudadano);
    public Ciudadano buscar(Integer id);
	public void borrar(Integer id);	
	//Joins
			
		//Inner Join
		public List<Ciudadano> buscarInnerJoin();
		
		//Outer Join
			//Right
		public List<Ciudadano> buscarOuterRightJoin();
		
		//Left
		public List<Ciudadano> buscarOuterLeftJoin();
			
		//Full - Outer
		public List<Ciudadano> buscarOuterFullJoin();
		
		//Join Where
		public List<Ciudadano> buscarWhereJoin();
		
		//Join Fetch
		public List<Ciudadano> buscarJoinFetch();
}
