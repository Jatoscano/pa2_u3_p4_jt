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
import com.example.demo.uce.edu.repository.model.EstudianteN;
import com.example.demo.uce.edu.repository.model.Materia;
import com.example.demo.uce.edu.repository.model.Matricula;
import com.example.demo.uce.edu.repository.model.Propietario;
import com.example.demo.uce.edu.repository.model.Provincia;
import com.example.demo.uce.edu.repository.model.Semestre;
import com.example.demo.uce.edu.repository.model.Transferencia;
import com.example.demo.uce.edu.service.CuentaBancariaService;
import com.example.demo.uce.edu.service.EstudianteNService;
import com.example.demo.uce.edu.service.MateriaService;
import com.example.demo.uce.edu.service.MatriculaNService;
import com.example.demo.uce.edu.service.PropietarioService;
import com.example.demo.uce.edu.service.TransferenciaService;

@SpringBootApplication
public class Pa2U3P4JtApplication implements CommandLineRunner{
	
	@Autowired
	private EstudianteNService estudianteNService;
	
	@Autowired
	private MateriaService materiaService;
	
	@Autowired
	private MatriculaNService matriculaNService;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P4JtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Provincia provincia = new Provincia();
	    EstudianteN estudiante = new EstudianteN();
	    
	    Semestre semestre = new Semestre();
	    Materia materia = new Materia();
	    
	    Matricula matricula = new Matricula();
	    
	    List<EstudianteN> estudiantes = new ArrayList<>();
	    List<Materia> materias = new ArrayList<>();
	    List<Matricula> matriculas = new ArrayList<>(); 	
	    
	    estudiante.setApellido("Toscano");
	    estudiante.setNombre("Andres");
	    estudiante.setCedula("1724693740");
	    
	    provincia.setCodigo("02");
	    provincia.setNombre("Pichincha");
	    provincia.setCanton("Quito");
	    
	    semestre.setCodigo("COMP");
	    semestre.setNivel("2");
	    semestre.setPeriodo("2022 - 2023");
	    
	    materia.setCodigo("001");
	    materia.setNombre("Prog.Av II");
	    materia.setParalelo("C6");
	    
	    matricula.setNumeroDeMatricula("M - 001");
	    matricula.setFechaDeMatricula(LocalDateTime.now());
	    matricula.setValor(new BigDecimal(60));
	    
	    
	    estudiantes.add(estudiante);
	    materias.add(materia);
	    matriculas.add(matricula);
	    
	    provincia.setEstudiantesN(estudiantes);
	    semestre.setMaterias(materias);
	    
	    //estudiante.setMatriculas(matriculas);
	    estudiante.setProvincia(provincia);
	    materia.setSemestre(semestre);
	    //materia.setMatriculas(matriculas);
	    
	    matricula.setEstudianteN(estudiante);
	    matricula.setMateria(materia);
	    
	    
	    
	    //CRUD
	    this.matriculaNService.registrar(matricula);
	    //this.estudianteNService.registrar(estudiante);
	    //this.materiaService.registrar(materia);
	   
	    /*
	    List<Matricula> reporteMaterias = new ArrayList<>();
	    List<Materia> ma1 = new ArrayList<>();
	 
	    reporteMaterias = this.matriculaNService.buscarMatricula();
	    for(Matricula ma: reporteMaterias) {
			if(ma == null) {
			 System.err.println("No existe aun la Matricula Inscrita");
			}
			System.out.println(ma.getNumeroDeMatricula());
			System.out.println("Tiene las siguientes materias: ");
			for(Materia m: ma1.getMateria()) {
				System.out.println(m.getCodigo());
			}
	    }
		*/
	}
}
