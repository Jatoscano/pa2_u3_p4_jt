package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Pa2U3P4JtApplication.class);
	
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
		LOGGER.info("Hilo: "+ Thread.currentThread().getName());
	/*	
		Propietario propietario = new Propietario();
		CuentaBancaria cuentaBancaria1 = new CuentaBancaria();
		CuentaBancaria cuentaBancaria2 = new CuentaBancaria();
		List<CuentaBancaria> cuentasBancarias = new ArrayList<>(); 
		Transferencia transferencia = new Transferencia();

		propietario.setApellido("Cadiz");
		propietario.setNombre("Sonia");
		propietario.setCedula("7483909234");

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

	    //this.propietarioService.registrar(propietario);

	    //this.transferenciaService.realizarTransferencia(3 , 4, "4321", "2910", new BigDecimal(1891));
	    
	   // this.cuentaBancariaService.registrar(cuentaBancaria2);


	    List<CuentaBancaria> reporteTransferencia = new ArrayList<>();

	    reporteTransferencia = this.cuentaBancariaService.reporteTranferencias();
	    for(CuentaBancaria ca: reporteTransferencia) {
			if(ca == null) {
			 System.err.println("No existe aun la Cuenta Bancaria");
			}
			else {
			System.out.println(ca.getNumero());
			System.out.println("Tiene las siguientes transferencias: ");
			for(Transferencia t: ca.getTransferencias()) {
				System.out.println(t.getCuentaBancaria());
			}
			}
	    }
	  */  
		
	/*	
	    //Inicio
	    long tiempoInicial = System.currentTimeMillis();
	    for (int i =0; i<=30; i++){
	    	CuentaBancaria cuentaBancaria = new CuentaBancaria();
	    	cuentaBancaria.setNumero(String.valueOf(i));
			cuentaBancaria.setTipo("Corriente");
			cuentaBancaria.setSaldo(new BigDecimal(2000));
			this.cuentaBancariaService.registrar(cuentaBancaria);
	    }
	    
	    //Fin
	    long tiempoFinal = System.currentTimeMillis();
	    long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
	    LOGGER.info("Tiempo Transcurrido: "+(tiempoFinal - tiempoInicial));
	    LOGGER.info("Tiempo Transcurrido: "+tiempoTranscurrido);
	*/
	/*	
		//Inicio con metodo registrar
		//Inicio
		List<CuentaBancaria> listaCuentas = new ArrayList<>();
		long tiempoInicial = System.currentTimeMillis();
	    for (int i =0; i<=100; i++){
	    	CuentaBancaria cuentaBancaria = new CuentaBancaria();
	    	cuentaBancaria.setNumero(String.valueOf(i));
			cuentaBancaria.setTipo("Corriente");
			cuentaBancaria.setSaldo(new BigDecimal(2000));
		    listaCuentas.add(cuentaBancaria);
	    }
	    
	    //listaCuentas.stream().forEach(cuenta ->this.cuentaBancariaService.registrar(cuenta));
	    listaCuentas.parallelStream().forEach(cuenta ->this.cuentaBancariaService.agregarDos(cuenta));
	    
	    //Fin
	    long tiempoFinal = System.currentTimeMillis();
	    long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
	    LOGGER.info("Tiempo Transcurrido: "+(tiempoFinal - tiempoInicial));
	    LOGGER.info("Tiempo Transcurrido: "+tiempoTranscurrido);
	*/	
		//Inicio con el metodo agregarDos
				List<CuentaBancaria> listaCuentas = new ArrayList<>();
				long tiempoInicial = System.currentTimeMillis();
			    for (int i =0; i<=100; i++){
			    	CuentaBancaria cuentaBancaria = new CuentaBancaria();
			    	cuentaBancaria.setNumero(String.valueOf(i));
					cuentaBancaria.setTipo("Corriente");
					cuentaBancaria.setSaldo(new BigDecimal(2000));
				    listaCuentas.add(cuentaBancaria);
			    }
			   
			    Stream<String> listaFinal = listaCuentas.parallelStream().map(cuenta ->this.cuentaBancariaService.agregarDos(cuenta));
			    LOGGER.info("Se guardaron las siguientes cuentas: ");
			    listaFinal.forEach(cadena ->LOGGER.info(cadena));
			   
			    //Fin
			    long tiempoFinal = System.currentTimeMillis();
			    long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
			    LOGGER.info("Tiempo Transcurrido: "+(tiempoFinal - tiempoInicial));
			    LOGGER.info("Tiempo Transcurrido: "+tiempoTranscurrido); 
	}
	
}
