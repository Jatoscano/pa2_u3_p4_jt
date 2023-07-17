package com.example.demo.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.edu.repository.model.CuentaBancaria;
import com.example.demo.uce.edu.repository.model.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements CuentaBancariaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		
		this.entityManager.persist(cuentaBancaria);
	}

	@Override
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
