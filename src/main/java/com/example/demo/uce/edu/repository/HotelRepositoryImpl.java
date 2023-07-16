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
	public void insertar(Hotel hotel) {
		
		this.entityManager.persist(hotel);
	}
	
	//JOINS
	
	//JOIN
	@Override
	public List<Hotel> seleccionarJoin() {
		//SQL
		//SELECT * FROM Hotel h JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
				
		//JPQL
		//SELECT h FROM Hotel h JOIN h.habitaciones ha
				
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones ha",Hotel.class);
		
		return myTypedQuery.getResultList();
	}

	//INNNER JOIN
	@Override
	public List<Hotel> seleccionarInnerJoin() {
		
		//SQL
		//SELECT * FROM Hotel h INNER JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
		
		//JPQL
		//SELECT h FROM Hotel h INNER JOIN h.habitaciones ha
		
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones ha",Hotel.class);
		
		return myTypedQuery.getResultList();
	}

	@Override
	public List<Hotel> seleccionarInnerJoinActualizacion() {
		//SQL
		//SELECT * FROM Hotel h INNER JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
				
		//JPQL
		//SELECT h FROM Hotel h INNER JOIN h.habitaciones ha
				
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h INNER JOIN h.habitaciones ha",Hotel.class);		
		
		List<Hotel> listaHoteles = myTypedQuery.getResultList();		
		for(Hotel h: listaHoteles) {
			h.getHabitaciones().size(); // Le doy la senial para que traiga los hoteles con sus refeencias
		}
		return listaHoteles;
	}
	
	//OUTER JOIN
	
	
	

	//RIGHT JOIN
	@Override
	public List<Hotel> seleccionarOuterRightJoin() {
		//SQL
		//SELECT * FROM Hotel h RIGHT JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
				
		//JPQL
		//SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha
				
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones ha",Hotel.class);
				
		return myTypedQuery.getResultList();
	}

	//LEFT JOIN
	@Override
	public List<Hotel> seleccionarOuterLeftJoin() {
		//SQL
				//SELECT * FROM Hotel h LEFT JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
						
				//JPQL
				//SELECT h FROM Hotel h LEFTT JOIN h.habitaciones ha
						
				TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones ha",Hotel.class);
						
				return myTypedQuery.getResultList();
	}

	//HABITACION - LEFT JOIN
	@Override
	public List<Hotel> seleccionarHabitacionOuterLeftJoin() {
		//SQL
		//SELECT * FROM Hotel h LEFT JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
				
		//JPQL
		//SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha
				
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery("SELECT ha FROM Hotel h LEFT JOIN h.habitaciones ha",Hotel.class);
				
		return myTypedQuery.getResultList();
	}
	
	//FULL OUTER JOIN
	@Override
	public List<Hotel> seleccionarOuterFullJoin() {
		//SQL
		//SELECT * FROM Hotel h FULL JOIN Habitacion ha ON h.hote_id = ha.habit_hotel_id
						
	    //JPQL
		//SELECT h FROM Hotel h FULL JOIN h.habitaciones ha
						
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

	//Join Fetch
	
	@Override
	public List<Hotel> seleccionarJoinFetch() {
		//SQL
		//SELECT * FROM Hotel h JOIN FETCH Habitacion ha ON h.hote_id = ha.habit_hotel_id
						
		//JPQL
		//SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha
						
		TypedQuery<Hotel> myTypedQuery = this.entityManager.createQuery(
				"SELECT h FROM Hotel h JOIN FETCH h.habitaciones ha"
				,Hotel.class);

		return myTypedQuery.getResultList();
	}
	
	

}
