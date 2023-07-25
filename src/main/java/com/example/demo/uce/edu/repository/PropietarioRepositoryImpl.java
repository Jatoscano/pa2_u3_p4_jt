package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.uce.edu.repository.model.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PropietarioRepositoryImpl implements PropietarioRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Propietario propietario) {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.entityManager.persist(propietario);
	}

	@Override
	public void actualizar(Propietario propietario) {
		
		this.entityManager.merge(propietario);
	}

	@Override
	public Propietario seleccionar(Integer id) {
		
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

}
