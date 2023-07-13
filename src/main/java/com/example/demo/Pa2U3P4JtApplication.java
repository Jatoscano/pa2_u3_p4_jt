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
		//JOINS

		//JOIN
		List<Hotel> listaHotel = new ArrayList<>();
		listaHotel = this.hotelService.buscarJoin();
		
		for(Hotel e: listaHotel) {
		System.out.println(e);
		}
		
		//INNER JOIN
		List<Hotel> listaHotel1 = new ArrayList<>();
		listaHotel1 = this.hotelService.buscarInnerJoin();
		
		for(Hotel e: listaHotel1) {
		System.out.println(e);
		}
		
		//OUTER JOIN
		
		//RIGHT JOIN
		List<Hotel> listaHotel2 = new ArrayList<>();
		listaHotel2 = this.hotelService.buscarOuterRightJoin();
		
		for(Hotel e: listaHotel2) {
		System.out.println(e);
		}

		//LEFT JOIN
		List<Hotel> listaHotel3 = new ArrayList<>();
		listaHotel3 = this.hotelService.buscarOuterLeftJoin();
		
		for(Hotel e: listaHotel3) {
		System.out.println(e);
		}

		//HABITACION - LEFT
		List<Hotel> listaHotel4 = new ArrayList<>();
		listaHotel4 = this.hotelService.buscarHabitacionOuterLeftJoin();
		
		for(Hotel e: listaHotel4) {
		System.out.println(e);
		}

		//FULL - OUTER
		List<Hotel> listaHotel5 = new ArrayList<>();
		listaHotel5 = this.hotelService.buscarOuterFullJoin();
		
		for(Hotel e: listaHotel5) {
		System.out.println(e);
		}
		
		List<Hotel> listaHotel6 = new ArrayList<>();
		listaHotel6 = this.hotelService.buscarOuterFullJoin();
		
		for(Hotel e: listaHotel6) {
			if(e == null) {
				System.err.println("No existe aun el Hotel");
			}
			else {
			System.out.println(e.getNombre());
			}
		}
		
		// JOIN WHERE
		List<Hotel> listaHotel7 = new ArrayList<>();
		listaHotel7 = this.hotelService.buscarWhereJoin();
		
		for(Hotel e: listaHotel7) {
			if(e == null) {
				System.err.println("No existe aun el Hotel");
			}
			else {
			System.out.println(e.getNombre());
			}
		}
	}
	
	

}
