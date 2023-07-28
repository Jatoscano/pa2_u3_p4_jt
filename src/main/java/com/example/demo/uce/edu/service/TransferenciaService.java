package com.example.demo.uce.edu.service;

import java.math.BigDecimal;

import com.example.demo.uce.edu.repository.model.Transferencia;

public interface TransferenciaService {

	public void registrar(Transferencia transferencia);
	public void guardar(Transferencia transferencia);
    public Transferencia buscar(Integer id);
	public void borrar(Integer id);
	
	public void realizarTransferencia(Integer idOrigen, Integer idDestino, String cuentaOrigen, String cuentaDestino, BigDecimal monto) 
			throws RuntimeException;
	
}
