package com.example.demo.uce.edu.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements TransferenciaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Transferencia transferencia) {
		
		this.entityManager.persist(transferencia);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Transferencia transferencia) {
		
		this.entityManager.merge(transferencia);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Transferencia seleccionar(Integer id) {
		
		return this.entityManager.find(Transferencia.class, id);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

	
	
}
