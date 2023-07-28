package com.example.demo.uce.edu.repository.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "transferencia", schema = "public")
@Entity
public class Transferencia {

	@Id
	@GeneratedValue(generator = "seq_transferencia", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_transferencia", sequenceName = "seq_transferencia", allocationSize = 1)
	@Column(name = "tran_id")
	private Integer id;
	
	@Column(name = "tran_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "tran_monto")
	private BigDecimal monto;
	
	@ManyToOne
	@JoinColumn(name = "tran_id_cuentaBancaria")
	private CuentaBancaria cuentaBancaria;
	
	//To String
	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fecha=" + fecha + ", monto=" + monto + ", cuentaBancaria="
				+ cuentaBancaria + "]";
	}


	//Get and Set
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDateTime getFecha() {
		return fecha;
	}


	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}


	public BigDecimal getMonto() {
		return monto;
	}


	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}


	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}


	public void setCuentaBancaria(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
}
