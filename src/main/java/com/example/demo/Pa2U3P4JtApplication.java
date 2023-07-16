package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.Habitacion;
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
		
		List<Hotel> listaHotel = new ArrayList<>();
	    listaHotel = this.hotelService.buscarInnerJoinActualizacion();
		
		for(Hotel h: listaHotel) {
			if(h == null) {
			 System.err.println("No existe aun el Hotal");
			}
			else {
			System.out.println(h.getNombre());
			System.out.println("Tiene las siguientes habitaciones: ");
			for(Habitacion ha: h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
			}
		}
		

		System.out.println("SQL Join Fetch");
		
		List<Hotel> listaHote2 = new ArrayList<>();
	    listaHote2 = this.hotelService.buscarJoinFetch();
		
		for(Hotel h: listaHote2) {
			if(h == null) {
			 System.err.println("No existe aun el Hotal");
			}
			else {
			System.out.println(h.getNombre());
			System.out.println("Tiene las siguientes habitaciones: ");
			for(Habitacion ha: h.getHabitaciones()) {
				System.out.println(ha.getNumero());
			}
			}
		}	
		
		
		Hotel hotel = new Hotel();
		Habitacion habitacion = new Habitacion();
		Habitacion habitacion1 = new Habitacion();
		Habitacion habitacion2 = new Habitacion();
		List<Habitacion> habitaciones = new ArrayList<>();
		
		hotel.setNombre("Marriot");
		hotel.setDireccion("Av. Eloy Alfaro");
		
		habitacion.setNumero("22");
		habitacion.setValor(new BigDecimal(80));
		
		habitacion1.setNumero("23");
		habitacion1.setValor(new BigDecimal(100));
		
		habitacion2.setNumero("24");
		habitacion2.setValor(new BigDecimal(180));
		
		habitaciones.add(habitacion);
		habitaciones.add(habitacion1);
		habitaciones.add(habitacion2);
		
		habitacion.setHotel(hotel);
		hotel.setHabitaciones(habitaciones);
		
		this.hotelService.registrar(hotel);	
		
	}
}
