package com.example.demo.model;

public class CuotaRq {

	private String dni;
	private String tarjeta;
	private String moneda;
	private Double monto;
	private Integer cuota;
	private String tea;
	private Integer diaPago;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	
	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Integer getCuota() {
		return cuota;
	}

	public void setCuota(Integer cuota) {
		this.cuota = cuota;
	}

	public String getTea() {
		return tea;
	}

	public void setTea(String tea) {
		this.tea = tea;
	}

	public Integer getDiaPago() {
		return diaPago;
	}

	public void setDiaPago(Integer diaPago) {
		this.diaPago = diaPago;
	}

}
