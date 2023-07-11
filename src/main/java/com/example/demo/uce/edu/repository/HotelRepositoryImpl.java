package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements HotelRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Hotel> seleccionarInnerJoin() {
		
		//SQL
		//SELECT * FROM Hotel h JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
		
		//JPQL
		//SELECT h FROM hotel h JOIN h.habitaciones ha
		
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",Hotel.class);
		
		return myTypedQuery.getResultList();
	}
	
	
}
