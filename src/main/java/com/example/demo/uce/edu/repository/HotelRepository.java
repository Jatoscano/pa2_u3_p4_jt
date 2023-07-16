package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Hotel;

public interface HotelRepository {
	
	public void insertar(Hotel hotel);
	
	//Joins
	
	//Join
	public List<Hotel> seleccionarJoin();
	
	//Inner Join
	public List<Hotel> seleccionarInnerJoin();
	
	//Inner join - Actualizacion
	public List<Hotel> seleccionarInnerJoinActualizacion();
	
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
	
	//Join Fetch
	public List<Hotel> seleccionarJoinFetch();
	
}
