package com.example.demo.uce.edu.repository.model;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "cuentaBancaria", schema = "public")
@Entity
public class CuentaBancaria {

	@Id
	@GeneratedValue(generator = "seq_cuentaBancaria", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_cuentaBancaria", sequenceName = "seq_cuentaBancaria", allocationSize = 1)
	@Column(name = "ctbn_id")
	private Integer id;
	
	@Column(name = "ctbn_numero")
	private String numero;
	
	@Column(name = "ctbn_saldo")
	private BigDecimal saldo;
	
	@Column(name = "ctbn_tipo")
	private String tipo;
	
	//Propietario - Cuenta Bancaria
	@ManyToOne
	@JoinColumn(name = "ctbn_id_propietario")
	private Propietario propietario;

	//Cuenta Bancaria - Tranferencia
	@OneToMany(mappedBy = "cuentaBancaria", fetch = FetchType.LAZY)
	private List<Transferencia> transferencias;
	
	//To String
	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numero=" + numero + ", saldo=" + saldo + ", tipo=" + tipo
				+ ", propietario=" + propietario + "]";
	}

	//Get and Set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public List<Transferencia> getTransferencias() {
		return transferencias;
	}

	public void setTransferencias(List<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}
}
