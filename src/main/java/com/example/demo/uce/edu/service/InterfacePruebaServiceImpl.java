package com.example.demo.uce.edu.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class InterfacePruebaServiceImpl implements InterfacePruebaService{

	@Override
	@Transactional(value = TxType.NEVER)
	public void prueba() {
		
		System.out.println("metodo 2: " +TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba");
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void prueba2() {
		
		System.out.println("metodo 2: " +TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba 2");
		
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		
		System.out.println("metodo 2: " +TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba Supports");
		
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void pruebaNotSupported() {
		
		System.out.println("metodo 2: " + TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba Not Supported");
		
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void pruebaRequired() {
		
		System.out.println("metodo 2: " + TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba Required");
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaRequiresNew() {
		
		System.out.println("metodo 2: " + TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba Requires New");
	}
	
	
}
