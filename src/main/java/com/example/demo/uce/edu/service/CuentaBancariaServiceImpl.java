package com.example.demo.uce.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.CuentaBancariaRepository;
import com.example.demo.uce.edu.repository.model.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService{

	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;
	
	@Override
	public void registrar(CuentaBancaria cuentaBancaria) {
		
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

	
}
