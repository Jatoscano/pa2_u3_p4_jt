package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Hotel;

public interface HotelRepository {
	
	//Joins
	
	//Join
	public List<Hotel> seleccionarJoin();
	
	//Inner Join
	public List<Hotel> seleccionarInnerJoin();
	
	//Outer Join
	
	//Right Join
	public List<Hotel> seleccionarOuterRightJoin();
	
	//Left Join
	public List<Hotel> seleccionarOuterLeftJoin();
	
	//Left - Habitacion
	public List<Hotel> seleccionarHabitacionOuterLeftJoin();
	
	//Full Outer Join
	public List<Hotel> seleccionarOuterFullJoin();
	
	//Join Where
	public List<Hotel> seleccionarWhereJoin();
	
}
