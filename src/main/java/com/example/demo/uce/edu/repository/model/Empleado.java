package com.example.demo.uce.edu.repository.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "empleado", schema = "public")
@Entity
public class Empleado {
	@Id
	@SequenceGenerator(name = "seq_empleado", sequenceName = "seq_empleado", allocationSize = 1)
	@GeneratedValue(generator = "seq_empleado", strategy = GenerationType.SEQUENCE)
	@Column(name = "empl_id")
	private Integer id;
	
	@Column(name = "empl_sueldo")
	private BigDecimal sueldo;
	
	@Column(name = "empl_cargo")
	private String cargo;
	
	@OneToOne
	@JoinColumn(name = "empl_ciudadano_id")
	private Ciudadano ciudadano;
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", sueldo=" + sueldo + ", cargo=" + cargo + "]";
	}
	// get and set
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getSueldo() {
		return sueldo;
	}
	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Ciudadano getCiudadano() {
		return ciudadano;
	}
	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}
}
