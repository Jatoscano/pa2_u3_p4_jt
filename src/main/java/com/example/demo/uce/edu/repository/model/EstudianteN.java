package com.example.demo.uce.edu.repository.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "estudianteN", schema = "public")
@Entity
public class EstudianteN{
	@Id
	@SequenceGenerator(name = "seq_estudianteN", sequenceName = "seq_estudianteN", allocationSize = 1)
	@GeneratedValue(generator = "seq_estudianteN", strategy = GenerationType.SEQUENCE)
	@Column(name = "estn_id")
	private Integer id;
	
	@Column(name = "estn_nombre")
	private String nombre;
	
	@Column(name = "estn_apellido")
	private String apellido;
	
	@Column(name = "estn_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "estudianteN")
	private List<Matricula> matriculas;

	//Relacion Provincia - Estudiante
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estn_id_provincia")
	private Provincia provincia;

	@Override
	public String toString() {
		return "EstudianteN [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula
				+ ", provincia=" + provincia + "]";
	}

	//Get and Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
}
