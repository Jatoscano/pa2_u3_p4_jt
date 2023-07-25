package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.uce.edu.repository.model.CuentaBancaria;
import com.example.demo.uce.edu.repository.model.Propietario;
import com.example.demo.uce.edu.repository.model.Transferencia;
import com.example.demo.uce.edu.service.CuentaBancariaService;
import com.example.demo.uce.edu.service.PropietarioService;
import com.example.demo.uce.edu.service.TransferenciaService;

@SpringBootApplication
public class Pa2U3P4JtApplication implements CommandLineRunner{
	
	@Autowired
	private TransferenciaService transferenciaService;

	@Autowired
	private CuentaBancariaService cuentaBancariaService;
	
	@Autowired
	private PropietarioService propietarioService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Propietario propietario = new Propietario();
		CuentaBancaria cuentaBancaria1 = new CuentaBancaria();
		CuentaBancaria cuentaBancaria2 = new CuentaBancaria();
		List<CuentaBancaria> cuentasBancarias = new ArrayList<>(); 
		Transferencia transferencia = new Transferencia();

		propietario.setApellido("Cevalloz");
		propietario.setNombre("Sebastian");
		propietario.setCedula("7483920100");

		cuentaBancaria1.setNumero("7481");
		cuentaBancaria1.setTipo("Corriente");
		cuentaBancaria1.setSaldo(new BigDecimal(2000));

		cuentasBancarias.add(cuentaBancaria1);

		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(new BigDecimal(100));

	    propietario.setCuentasBancarias(cuentasBancarias);
	    cuentaBancaria1.setPropietario(propietario);
	    transferencia.setCuentaBancaria(cuentaBancaria2);
	    System.out.println("main: " + TransactionSynchronizationManager.isActualTransactionActive());

	    this.propietarioService.registrar(propietario);

	    //this.transferenciaService.realizarTransferencia(1 , 2, "0987", "4321", new BigDecimal(100));


	    List<CuentaBancaria> reporteTransferencia = new ArrayList<>();

	    reporteTransferencia = this.cuentaBancariaService.reporteTranferencias();
	    for(CuentaBancaria ca: reporteTransferencia) {
			if(ca == null) {
			 System.err.println("No existe aun la Cuenta Bancaria");
			}
			System.out.println(ca.getNumero());
			System.out.println("Tiene las siguientes transferencias: ");
			for(Transferencia t: ca.getTransferencias()) {
				System.out.println(t.getCuentaBancaria());
			}
	    }
	}
}
