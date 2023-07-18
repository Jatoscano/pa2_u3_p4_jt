package com.example.demo.uce.edu.repository.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Table(name = "provincia", schema = "public")
@Entity
public class Provincia {

	@Id
	@SequenceGenerator(name = "seq_provincia", sequenceName = "seq_provincia", allocationSize = 1)
	@GeneratedValue(generator = "seq_provincia", strategy = GenerationType.SEQUENCE)
	@Column(name = "prov_id")
	private Integer id;
	
	@Column(name = "prov_nombre")
	private String nombre;
	
	@Column(name = "prov_codigo")
	private String codigo;
	
	@Column(name = "prov_canton")
	private String canton;
	
	@OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<EstudianteN> estudiantesN;

	//To String
	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", canton=" + canton + "]";
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public List<EstudianteN> getEstudiantesN() {
		return estudiantesN;
	}

	public void setEstudiantesN(List<EstudianteN> estudiantesN) {
		this.estudiantesN = estudiantesN;
	}
}
