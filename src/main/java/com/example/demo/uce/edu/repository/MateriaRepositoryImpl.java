package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Hotel;
import com.example.demo.uce.edu.repository.model.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class MateriaRepositoryImpl implements MateriaRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Materia materia) {
		
		this.entityManager.persist(materia);
	}

	@Override
	public void actualizar(Materia materia) {
		
		this.entityManager.merge(materia);
	}

	@Override
	public Materia seleccionar(Integer id) {
		
		return this.entityManager.find(Materia.class, id);
	}
}
