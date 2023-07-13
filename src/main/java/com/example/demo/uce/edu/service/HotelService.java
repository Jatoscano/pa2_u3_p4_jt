package com.example.demo.uce.edu.service;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Hotel;

public interface HotelService {

	//Joins
	
	//Join
	public List<Hotel> buscarJoin();
	
	//Inner Join
	public List<Hotel> buscarInnerJoin();
	
	//Outer Join
		//Right
	public List<Hotel> buscarOuterRightJoin();
	
	//Left
	public List<Hotel> buscarOuterLeftJoin();
		
	//Left - Habitacion
	public List<Hotel> buscarHabitacionOuterLeftJoin();
	
	//Full - Outer
	public List<Hotel> buscarOuterFullJoin();
	
	//Join Where
	public List<Hotel> buscarWhereJoin();
}
