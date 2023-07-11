package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.Hotel;
import com.example.demo.uce.edu.service.HotelService;

@SpringBootApplication
public class Pa2U3P4JtApplication implements CommandLineRunner{

	@Autowired
	private HotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Hotel> listaHotel = new ArrayList<>();
		listaHotel = this.hotelService.buscarInnerJoin();
		
		for(Hotel e: listaHotel) {
		System.out.println(e);
		}
	}
	
	

}
