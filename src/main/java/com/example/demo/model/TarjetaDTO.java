package com.example.demo.model;

public class TarjetaDTO {

	private String nombre;
	private double tasa;

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

	public TarjetaDTO(String nombre, double tasa) {
		super();
		this.nombre = nombre;
		this.tasa = tasa;
	}

	public TarjetaDTO() {
		super();
	}

}
