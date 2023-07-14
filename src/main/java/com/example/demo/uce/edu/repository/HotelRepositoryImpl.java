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

	//JOINS
	
	//JOIN
	@Override
	public List<Hotel> seleccionarJoin() {
		//SQL
		//SELECT * FROM Hotel h JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
				
		//JPQL
		//SELECT h FROM hotel h JOIN h.habitaciones ha
				
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",Hotel.class);
				
		return myTypedQuery.getResultList();
	}

	//INNNER JOIN
	@Override
	public List<Hotel> seleccionarInnerJoin() {
		
		//SQL
		//SELECT * FROM Hotel h INNER JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
		
		//JPQL
		//SELECT h FROM hotel h INNER JOIN h.habitaciones ha
		
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones ha",Hotel.class);
		
		return myTypedQuery.getResultList();
	}

	//OUTER JOIN
	
	
	//RIGHT JOIN
	@Override
	public List<Hotel> seleccionarOuterRightJoin() {
		//SQL
		//SELECT * FROM Hotel h RIGHT JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
				
		//JPQL
		//SELECT h FROM hotel h RIGHT JOIN h.habitaciones ha
				
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha",Hotel.class);
				
		return myTypedQuery.getResultList();
	}

	//LEFT JOIN
	@Override
	public List<Hotel> seleccionarOuterLeftJoin() {
		//SQL
				//SELECT * FROM Hotel h LEFT JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
						
				//JPQL
				//SELECT h FROM hotel h LEFTT JOIN h.habitaciones ha
						
				TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",Hotel.class);
						
				return myTypedQuery.getResultList();
	}

	//HABITACION - LEFT JOIN
	@Override
	public List<Hotel> seleccionarHabitacionOuterLeftJoin() {
		//SQL
		//SELECT * FROM Hotel h LEFT JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
				
		//JPQL
		//SELECT ha FROM hotel h LEFT JOIN h.habitaciones ha
				
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha",Hotel.class);
				
		return myTypedQuery.getResultList();
	}
	
	//FULL OUTER JOIN
	@Override
	public List<Hotel> seleccionarOuterFullJoin() {
		//SQL
		//SELECT * FROM Hotel h FULL JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
						
	    //JPQL
		//SELECT h FROM hotel h FULL JOIN h.habitaciones ha
						
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones ha",Hotel.class);
						
		return myTypedQuery.getResultList();
	}

	//Join Where
	
	@Override
	public List<Hotel> seleccionarWhereJoin() {
		//SQL
		//SELECT * FROM Hotel h,Habitacion ha WHERE h.hote_id = ha.habit_hotel_id
								
	    //JPQL
		//SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel
								
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h, Habitacion ha WHERE h = ha.hotel",Hotel.class);
								
	    return myTypedQuery.getResultList();
	}
	

}
