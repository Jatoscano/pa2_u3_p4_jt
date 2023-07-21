package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Provincia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ProvinciaRepositoryImpl implements ProvinciaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Provincia provincia) {
		
		this.entityManager.persist(provincia);
	}

	@Override
	public void actualizar(Provincia provincia) {
		
		this.entityManager.merge(provincia);
	}

	@Override
	public Provincia seleccionar(Integer id) {
		
		return this.entityManager.find(Provincia.class, id);
	}

}
