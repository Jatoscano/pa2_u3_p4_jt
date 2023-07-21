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

@Table(name = "semestre", schema = "public")
@Entity
public class Semestre {

	@Id
	@SequenceGenerator(name = "seq_semestre", sequenceName = "seq_semestre", allocationSize = 1)
	@GeneratedValue(generator = "seq_semestre", strategy = GenerationType.SEQUENCE)
	@Column(name = "sems_id")
	private Integer id;
	
	@Column(name = "sems_codigo")
	private String codigo;
	
	@Column(name = "sems_nivel")
	private String nivel;
	
	@Column(name = "sems_periodo")
	private String periodo;
	
	@OneToMany(mappedBy = "semestre", fetch = FetchType.LAZY)
	private List<Materia> materias;

	
	@Override
	public String toString() {
		return "Semestre [id=" + id + ", codigo=" + codigo + ", nivel=" + nivel + ", periodo=" + periodo + "]";
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

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}	
}
