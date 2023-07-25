package com.example.demo.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.uce.edu.repository.PropietarioRepository;
import com.example.demo.uce.edu.repository.model.Propietario;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class PropietarioServiceImpl implements PropietarioService{

	@Autowired
	private PropietarioRepository propietarioRepository;
	
	@Autowired
	private InterfacePruebaService interfacePruebaService;
	@Override
	@Transactional
	public void registrar(Propietario propietario) {
		System.out.println("Service: " + TransactionSynchronizationManager.isActualTransactionActive());
		//this.propietarioRepository.insertar(propietario);
		//this.interfacePruebaService.prueba();
		//this.interfacePruebaService.prueba2();
		//this.interfacePruebaService.pruebaSupports();
		//this.interfacePruebaService.pruebaNotSupported();
		//this.interfacePruebaService.pruebaRequired();
		this.interfacePruebaService.pruebaRequiresNew();
	}

	@Override
	public void guardar(Propietario propietario) {
		
		this.propietarioRepository.actualizar(propietario);
	}

	@Override
	public Propietario buscar(Integer id) {
		
		return this.propietarioRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.propietarioRepository.eliminar(id);
	}

	@Transactional(value = TxType.NEVER)
	public void prueba() {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		System.out.println("metodo de prueba");
	}
}
