package com.example.demo.uce.edu.repository;

import java.util.List;

import com.example.demo.uce.edu.repository.model.Hotel;

public interface HotelRepository {
	
	//Joins
	
	//Inner Join
	public List<Hotel> seleccionarInnerJoin();
	
}
