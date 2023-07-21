package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Semestre;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SemestreRepositoryImpl implements SemestreRepository{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Semestre semestre) {
		
		this.entityManager.persist(semestre);
	}

	@Override
	public void actualizar(Semestre semestre) {
		
		this.entityManager.merge(semestre);
	}

	@Override
	public Semestre seleccionar(Integer id) {
		
		return this.entityManager.find(Semestre.class, id);
	}

	
}
