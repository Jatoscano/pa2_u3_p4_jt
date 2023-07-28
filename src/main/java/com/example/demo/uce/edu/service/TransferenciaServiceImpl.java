package com.example.demo.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.edu.repository.CuentaBancariaRepository;
import com.example.demo.uce.edu.repository.TransferenciaRepository;
import com.example.demo.uce.edu.repository.model.CuentaBancaria;
import com.example.demo.uce.edu.repository.model.Transferencia;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class TransferenciaServiceImpl implements TransferenciaService{

	@Autowired
	private TransferenciaRepository transferenciaRepository;
	
	@Autowired
	private CuentaBancariaRepository cuentaBancariaRepository;
	
	@Override
	public void registrar(Transferencia transferencia) {
		
		this.transferenciaRepository.insertar(transferencia);
	}

	@Override
	public void guardar(Transferencia transferencia) {
		
		this.transferenciaRepository.actualizar(transferencia);
	}

	@Override
	public Transferencia buscar(Integer id) {
		
		return this.transferenciaRepository.seleccionar(id);
	}

	@Override
	public void borrar(Integer id) {
		
		this.transferenciaRepository.eliminar(id);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public void realizarTransferencia(Integer idOrigen, Integer idDestino,String cuentaOrigen, String cuentaDestino, BigDecimal monto){
		//1. Consulta del saldo a depositar a la apertura de nuestrs cuenta
			CuentaBancaria cuentaBancariaOrigen = this.cuentaBancariaRepository.seleccionar(idOrigen);
			CuentaBancaria cuentaBancariaDestino = this.cuentaBancariaRepository.seleccionar(idDestino);
				
			
		//2. Consutamos al saldo que vamos a aniadir o no
			BigDecimal saldoCuentaOrigen = cuentaBancariaOrigen.getSaldo();
			BigDecimal saldoCuentaDestino = cuentaBancariaDestino.getSaldo();
				
			if(monto.compareTo(saldoCuentaOrigen) <= 10 ) {
				//3.  si es suficiente ir al paso 4
				//4.  realizar la resta del saldo origen - monto
				BigDecimal nuevoSaldoOrigen = saldoCuentaOrigen.subtract(monto);
				//5.  actualizar el nuevo saldo de la cuenta origen
				cuentaBancariaOrigen.setSaldo(nuevoSaldoOrigen);
				
				//6. relaizamos la suma del saldo destino + monto
				BigDecimal nuevoSaldoDestino = saldoCuentaDestino.add(monto);
			//7. actualizamos el nuevo saldo de la cuenta destino
			cuentaBancariaDestino.setSaldo(nuevoSaldoDestino);
			
			this.cuentaBancariaRepository.actualizar(cuentaBancariaOrigen);
			this.cuentaBancariaRepository.actualizar(cuentaBancariaDestino);
			
			//12. creamos la transderecnia
			Transferencia transfer = new Transferencia();
			transfer.setCuentaBancaria(cuentaBancariaOrigen);
			transfer.setCuentaBancaria(cuentaBancariaDestino);
			transfer.setFecha(LocalDateTime.now());
			transfer.setMonto(monto);
			
			if(monto.compareTo(saldoCuentaOrigen) > 0) {
				throw new RuntimeException();
			}
			
			else {
			this.transferenciaRepository.insertar(transfer);
			}
			
			}
			else {
				//si no es suficiente imprimir mensaje de que no hya saldo
				System.out.println("Su saldo no es suficiente, su saldo es de : "
						+ saldoCuentaOrigen);
			}
			
	}

	
}
