package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.HotelRepository;
import com.example.demo.uce.edu.repository.model.Hotel;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	//JOINS
	
	//JOIN
	@Override
	public List<Hotel> buscarJoin() {
		
		return this.hotelRepository.seleccionarJoin();
	}

	//INNNER JOIN
	@Override
	public List<Hotel> buscarInnerJoin() {
		
		return this.hotelRepository.seleccionarInnerJoin();
	}

	//OUTER JOIN
	
	//RIGHT JOIN
	@Override
	public List<Hotel> buscarOuterRightJoin() {
		
		return this.hotelRepository.seleccionarOuterRightJoin();
	}

	//LEFT JOIN
	@Override
	public List<Hotel> buscarOuterLeftJoin() {
		
		return this.hotelRepository.seleccionarOuterLeftJoin();
	}

	@Override
	public List<Hotel> buscarHabitacionOuterLeftJoin() {
		
		return this.hotelRepository.seleccionarHabitacionOuterLeftJoin();
	}

	
	//FULL OUTER JOIN
	@Override
	public List<Hotel> buscarOuterFullJoin() {
		
		return this.hotelRepository.seleccionarOuterFullJoin();
	}

	//JOIN WHERE
	@Override
	public List<Hotel> buscarWhereJoin() {
		
		return this.hotelRepository.seleccionarWhereJoin();
	}
}
