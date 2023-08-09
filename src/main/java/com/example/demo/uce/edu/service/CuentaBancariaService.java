package com.example.demo.uce.edu.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.example.demo.uce.edu.repository.model.CuentaBancaria;

public interface CuentaBancariaService {

	public void registrar(CuentaBancaria cuentaBancaria);
	public void guardar(CuentaBancaria cuentaBancaria);
    public CuentaBancaria buscar(Integer id);
	public void borrar(Integer id);
	
	public List<CuentaBancaria> reporteTranferencias();
	
	public String agregarDos(CuentaBancaria cuentaBancaria);
	
	public void agregarAsincrono(CuentaBancaria cuentaBancaria);
	
	public CompletableFuture<String> agregarAsincronoDos(CuentaBancaria cuentaBancaria);
}
