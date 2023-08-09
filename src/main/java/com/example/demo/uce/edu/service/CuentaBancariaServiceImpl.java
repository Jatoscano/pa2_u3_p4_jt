package com.example.demo.uce.edu.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.CuentaBancariaRepository;
import com.example.demo.uce.edu.repository.model.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService{

	private static final Logger LOGGER = LoggerFactory.getLogger(CiudadanoServiceImpl.class);
	
	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;
	
	@Override
	public void registrar(CuentaBancaria cuentaBancaria) {
		LOGGER.info("Hilo Service: "+ Thread.currentThread().getName());
		//SUMAR, RESTAR, MULTIPLICAR - LOGICA QUE SE DEMORA 1 SEGUNDO
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.cuentaBancariaRepository.insertar(cuentaBancaria);
	}

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		
		this.cuentaBancariaRepository.actualizar(cuentaBancaria);
	}

	@Override
	public CuentaBancaria buscar(Integer id) {
		
		return this.cuentaBancariaRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.cuentaBancariaRepository.eliminar(id);
	}

	@Override
	public List<CuentaBancaria> reporteTranferencias() {
		
		return this.cuentaBancariaRepository.registrarTransferencia();
	}

	@Override
	public String agregarDos(CuentaBancaria cuentaBancaria) {
		LOGGER.info("Hilo Service: "+ Thread.currentThread().getName());
		//SUMAR, RESTAR, MULTIPLICAR - LOGICA QUE SE DEMORA 1 SEGUNDO
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.cuentaBancariaRepository.insertar(cuentaBancaria);
		return cuentaBancaria.getNumero();
	}

	@Override
	@Async
	public void agregarAsincrono(CuentaBancaria cuentaBancaria) {
		LOGGER.info("Hilo Service: "+ Thread.currentThread().getName());
		//SUMAR, RESTAR, MULTIPLICAR - LOGICA QUE SE DEMORA 1 SEGUNDO
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.cuentaBancariaRepository.insertar(cuentaBancaria);
	}

	@Override
	@Async
	public CompletableFuture<String> agregarAsincronoDos(CuentaBancaria cuentaBancaria) {
		LOGGER.info("Hilo Service: "+ Thread.currentThread().getName());
		//SUMAR, RESTAR, MULTIPLICAR - LOGICA QUE SE DEMORA 1 SEGUNDO
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.cuentaBancariaRepository.insertar(cuentaBancaria);
		
		return CompletableFuture.completedFuture(cuentaBancaria.getNumero());
	}
	
	
}
