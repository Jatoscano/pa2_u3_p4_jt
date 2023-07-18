package com.example.demo.uce.edu.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "matricula", schema = "public")
@Entity
public class Matricula {
	
	@Id
	@SequenceGenerator(name = "seq_matricula", sequenceName = "seq_matricula", allocationSize = 1)
	@GeneratedValue(generator = "seq_matricula", strategy = GenerationType.SEQUENCE)
	@Column(name = "mtla_id")
	private Integer id;
	
	@Column(name = "mtla_fechaDeMatricula")
	private LocalDateTime fechaDeMatricula;
	
	@Column(name = "mtla_numeroDeMatricula")
	private String numeroDeMatricula;
	
	@Column(name = "mtla_valor")
	private BigDecimal valor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	// el ultimo nombre defino en la clase se define en la clase Alumno
	@JoinColumn(name = "mtla_id_estudianteN")
	private EstudianteN estudianteN;
	
	@ManyToOne(cascade = CascadeType.ALL)
	// el ultimo nombre defino en la clase se define en la clase Materia
	@JoinColumn(name = "mtla_id_materia")
	private Materia materia;

	
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", fechaDeMatricula=" + fechaDeMatricula + ", numeroDeMatricula="
				+ numeroDeMatricula + ", valor=" + valor + "]";
	}

	//Get and Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaDeMatricula() {
		return fechaDeMatricula;
	}

	public void setFechaDeMatricula(LocalDateTime fechaDeMatricula) {
		this.fechaDeMatricula = fechaDeMatricula;
	}

	public String getNumeroDeMatricula() {
		return numeroDeMatricula;
	}

	public void setNumeroDeMatricula(String numeroDeMatricula) {
		this.numeroDeMatricula = numeroDeMatricula;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public EstudianteN getEstudianteN() {
		return estudianteN;
	}

	public void setEstudianteN(EstudianteN estudianteN) {
		this.estudianteN = estudianteN;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	
}
