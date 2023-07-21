package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Materia;
import com.example.demo.uce.edu.repository.model.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MatriculaNRepositoryImpl implements MatriculaNRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Matricula matricula) {
		
		this.entityManager.persist(matricula);
	}

	@Override
	public void actualizar(Matricula matricula) {
		
		this.entityManager.merge(matricula);
	}

	@Override
	public Matricula seleccionar(Integer id) {
		
		return this.entityManager.find(Matricula.class, id);
	}

	@Override
	public List<Matricula> seleccionarMatricula() {
		//SQL
		//SELECT * FROM Matricula ma JOIN FETCH Materia m ON ma.mtla_id_materia = m.mate_id
										
		//JPQL
	    //SELECT ma FROM Matricula ma JOIN FETCH ma.materia m
										
		TypedQuery<Matricula> myTypedQuery = this.entityManager.createQuery(
				"SELECT ma FROM Matricula ma JOIN FETCH ma.materia m"
				,Matricula.class);

		return myTypedQuery.getResultList();
	}

	
}
