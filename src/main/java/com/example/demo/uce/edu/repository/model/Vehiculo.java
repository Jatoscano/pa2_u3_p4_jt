package com.example.demo.uce.edu.repository.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "vehiculo", schema = "public")
@Entity
public class Vehiculo {

	@Id
	@GeneratedValue(generator = "seq_vehiculo", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_vehiculo", sequenceName = "seq_vehiculo", allocationSize = 1)
	@Column(name = "vehi_id")
	private Integer id;
	
	@Column(name = "vehi_marca")
	private String marca;
	
	@Column(name = "vehi_modelo")
	private String modelo;
	
	@OneToOne(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Matriculas matricula;

	
	//To String
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula + "]";
	}

	//Get and Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Matriculas getMatricula() {
		return matricula;
	}

	public void setMatricula(Matriculas matricula) {
		this.matricula = matricula;
	}
}
