package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.EstudianteN;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EstudianteNRepositoryImpl implements EstudianteNRepository{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(EstudianteN estudianteN) {
		
		this.entityManager.persist(estudianteN);
	}

	@Override
	public void actualizar(EstudianteN estudianteN) {
		
		this.entityManager.merge(estudianteN);
	}

	@Override
	public EstudianteN seleccionar(Integer id) {
		
		return this.entityManager.find(EstudianteN.class, id);
	}

}
