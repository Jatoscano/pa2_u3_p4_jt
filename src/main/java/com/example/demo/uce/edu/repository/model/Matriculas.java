package com.example.demo.uce.edu.repository.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "matriculas", schema = "public")
@Entity
public class Matriculas {

	@Id
	@GeneratedValue(generator = "seq_matriculas", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_matriculas", sequenceName = "seq_matriculas", allocationSize = 1)
	@Column(name = "matr_id")
	private Integer id;
	
	@Column(name = "matr_codigo")
	private String codigo;
	
	@Column(name = "matr_fechaDeInscripcion")
	private LocalDateTime fechaDeInscripcion;
	
	@OneToOne
	@JoinColumn(name = "matr_id_vehiculo")
	private Vehiculo vehiculo;

	//To String
	@Override
	public String toString() {
		return "Matricula [id=" + id + ", codigo=" + codigo + ", fechaDeInscripcion=" + fechaDeInscripcion + "]";
	}

	//Get and Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getFechaDeInscripcion() {
		return fechaDeInscripcion;
	}

	public void setFechaDeInscripcion(LocalDateTime fechaDeInscripcion) {
		this.fechaDeInscripcion = fechaDeInscripcion;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
}
