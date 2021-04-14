package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clitarj")
public class ClienteTarjeta {
	
	@Id
	private Integer dnicliente;

	private int idtarjeta;

	public Integer getDnicliente() {
		return dnicliente;
	}

	public void setDnicliente(Integer dnicliente) {
		this.dnicliente = dnicliente;
	}

	public int getIdtarjeta() {
		return idtarjeta;
	}

	public void setIdtarjeta(int idtarjeta) {
		this.idtarjeta = idtarjeta;
	}


	public ClienteTarjeta(Integer dnicliente, int idtarjeta) {
		super();
		this.dnicliente = dnicliente;
		this.idtarjeta = idtarjeta;
	}
	
	public ClienteTarjeta() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "ClienteTarjeta [id=" + dnicliente + ", nombre=" + idtarjeta +"]";
	}
	
}
	
	
	