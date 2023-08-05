package com.example.demo.uce.edu.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.CuentaBancaria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements CuentaBancariaRepository{

	private static final Logger LOGGER = LoggerFactory.getLogger(CiudadanoRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(CuentaBancaria cuentaBancaria) {
		LOGGER.info("Hilo Repository: "+ Thread.currentThread().getName());
		this.entityManager.persist(cuentaBancaria);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		
		this.entityManager.merge(cuentaBancaria);
	}

	@Override
	public CuentaBancaria seleccionar(Integer id) {
		
		return this.entityManager.find(CuentaBancaria.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		
		this.entityManager.remove(this.seleccionar(id));
	}

	@Override
	public CuentaBancaria seleccionarNumeroCuenta(String numero) {
		
		return this.entityManager.find(CuentaBancaria.class, numero);
	}

	@Override
	public List<CuentaBancaria> registrarTransferencia() {
		//SQL
		//SELECT * FROM CuentaBancaria ca JOIN FETCH Transferencia t ON ca.ctbn_id = t.tran_id_cuentaBancaria
				
		//JPQL
		//SELECT ca FROM CuentaBancaria ca JOIN FETCH ca.transferencia t
								
		TypedQuery<CuentaBancaria> myTypedQuery = this.entityManager.createQuery(
				"SELECT ca FROM CuentaBancaria ca JOIN FETCH ca.transferencias t"
				,CuentaBancaria.class);

		return myTypedQuery.getResultList();
	}

	
	
}
