package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.uce.edu.repository.model.CuentaBancaria;
import com.example.demo.uce.edu.repository.model.Propietario;
import com.example.demo.uce.edu.repository.model.Transferencia;
import com.example.demo.uce.edu.service.CuentaBancariaService;
import com.example.demo.uce.edu.service.PropietarioService;
import com.example.demo.uce.edu.service.TransferenciaService;

@SpringBootApplication
public class Pa2U3P4JtApplication implements CommandLineRunner{
	
	@Autowired
	private PropietarioService propietarioService;
	
	@Autowired
	private CuentaBancariaService cuentaBancariaService;
	
	@Autowired
	private TransferenciaService transferenciaService;
	
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
		
		propietario.setApellido("Lopez");
		propietario.setNombre("Ariel");
		propietario.setCedula("0192837465");
		
		cuentaBancaria1.setNumero("4321");
		cuentaBancaria1.setTipo("Ahorros");
		cuentaBancaria1.setSaldo(new BigDecimal(2000));
		
		cuentasBancarias.add(cuentaBancaria1);
		
		transferencia.setFecha(LocalDateTime.now());
		transferencia.setMonto(new BigDecimal(100));
	
	    propietario.setCuentasBancarias(cuentasBancarias);
	    cuentaBancaria1.setPropietario(propietario);
	    transferencia.setCuentaBancaria(cuentaBancaria2);
	    
	    //this.propietarioService.registrar(propietario);
	    
	    this.transferenciaService.realizarTransferencia(1 , 2, "0987", "4321", new BigDecimal(100));
	    
	    
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
		/*
		//VEHICULO - MATRICULA
		System.out.println("Joins - Vehiculos");
				//JOINS

				//INNER JOIN
				List<Vehiculo> listaVehiculo1 = new ArrayList<>();
			    listaVehiculo1 = this.vehiculoService.buscarInnerJoin();

				for(Vehiculo v: listaVehiculo1) {
					if(v == null) {
					 System.err.println("No existe aun el Vehiculo");
					}
					else {
					System.out.println(v);
					}
				}	
				
				//OUTER JOIN

				//RIGHT JOIN
				List<Vehiculo> listaVehiculo2 = new ArrayList<>();
			    listaVehiculo2 = this.vehiculoService.buscarOuterRightJoin();

				for(Vehiculo v: listaVehiculo2) {
					if(v == null) {
					 System.err.println("No existe aun el Vehiculo");
					}
					else {
					System.out.println(v);
					}
				}

				//LEFT JOIN
				List<Vehiculo> listaVehiculo3 = new ArrayList<>();
			    listaVehiculo3 = this.vehiculoService.buscarOuterLeftJoin();

				for(Vehiculo v: listaVehiculo3) {
					if(v == null) {
					 System.err.println("No existe aun el Vehiculo");
					}
					else {
					System.out.println(v);
					}
				}		

				//FULL - OUTER

				List<Vehiculo> listaVehiculo4 = new ArrayList<>();
			    listaVehiculo4 = this.vehiculoService.buscarOuterFullJoin();

				for(Vehiculo v: listaVehiculo4) {
					if(v == null) {
					 System.err.println("No existe aun el Vehiculo");
					}
					else {
					System.out.println(v);
					}
				}				

				// JOIN WHERE
				List<Vehiculo> listaVehiculo5 = new ArrayList<>();
			    listaVehiculo5 = this.vehiculoService.buscarWhereJoin();

				for(Vehiculo v: listaVehiculo5) {
					if(v == null) {
					 System.err.println("No existe aun el Vehiculo");
					}
					else {
					System.out.println(v);
					}
				}	
		
				//JOIN FETCH
				List<Vehiculo> listaVehiculo6 = new ArrayList<>();
				listaVehiculo6 = this.vehiculoService.buscarJoinFetch();
		
				for(Vehiculo v: listaVehiculo6) {	
					if(v == null) {
						System.err.println("No existe aun el Vehiculo");
					}
					else {
						System.out.println(v);
					}
				}	
		
		System.out.println("/////////////////////////////////////////////////////////////////////////////");		
		//CIUDADANO - EMPLEADO
		System.out.println("Joins - Ciudadanos");
				//JOINS		
		        
		        //INNER JOIN
		        List<Ciudadano> listaCiudadano1 = new ArrayList<>();
	            listaCiudadano1 = this.ciudadanoService.buscarInnerJoin();
	            
	            for(Ciudadano c: listaCiudadano1) {
	    			if(c == null) {
	    			 System.err.println("No existe aun el Ciudadano");
	    			}
	    			else {
	    			System.out.println(c);
	    			}
	    		}
	            
	            //RIGHT JOIN
	            List<Ciudadano> listaCiudadano2 = new ArrayList<>();
	    	    listaCiudadano2 = this.ciudadanoService.buscarOuterRightJoin(); 
	    	    
	    	    for(Ciudadano c: listaCiudadano2) {
	    			if(c == null) {
	    			 System.err.println("No existe aun el Ciudadano");
	    			}
	    			else {
	    			System.out.println(c);
	    			}
	    		}
	    	    
	    	    //LEFT JOIN
	    	    
	    	    List<Ciudadano> listaCiudadano3 = new ArrayList<>();
	    	    listaCiudadano3 = this.ciudadanoService.buscarOuterLeftJoin();
	    	    
	    	    for(Ciudadano c: listaCiudadano3) {
	    			if(c == null) {
	    			 System.err.println("No existe aun el Ciudadano");
	    			}
	    			else {
	    			System.out.println(c);
	    			}
	    		}
	    	    
	    	    
	    	    //FULL - OUTER
	    	    List<Ciudadano> listaCiudadano4 = new ArrayList<>();
	    	    listaCiudadano4 = this.ciudadanoService.buscarOuterFullJoin();
	    	    
	    	    for(Ciudadano c: listaCiudadano4) {
	    			if(c == null) {
	    			 System.err.println("No existe aun el Ciudadano");
	    			}
	    			else {
	    			System.out.println(c);
	    			}
	    		}
	    	    
	    	    //JOIN WHERE
	    	    List<Ciudadano> listaCiudadano5 = new ArrayList<>();
	    		listaCiudadano5 = this.ciudadanoService.buscarWhereJoin();
	    		
	    		for(Ciudadano c: listaCiudadano5) {
	    			if(c == null) {
	    				System.err.println("No existe aun el Ciudadano");
	    			}
	    			else {
	    			System.out.println(c);
	    			}
	    		}
	    		
	    		//JOIN FETCH
	    	    List<Ciudadano> listaCiudadano6 = new ArrayList<>();
	    		listaCiudadano6 = this.ciudadanoService.buscarJoinFetch();
	    		
	    		for(Ciudadano c: listaCiudadano6) {
	    			if(c == null) {
	    				System.err.println("No existe aun el Ciudadano");
	    			}
	    			else {
	    			System.out.println(c);
	    			}
	    		}
		*/
	}
}
