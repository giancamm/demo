package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tarjeta")
public class Tarjeta {

	@Id
	private int id;

	private String nombre;

	private double tasa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa;
	}

	public Tarjeta(int id, String nombre, double tasa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tasa = tasa;
	}

	public Tarjeta() {
		super();
	}

	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", nombre=" + nombre + ", tasa=" + tasa + "]";
				
	}
	
}
