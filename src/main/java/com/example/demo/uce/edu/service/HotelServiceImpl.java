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
	
	@Override
	public List<Hotel> buscarInnerJoin() {
		
		return this.hotelRepository.seleccionarInnerJoin();
	}

}
