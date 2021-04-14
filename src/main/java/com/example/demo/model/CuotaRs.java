package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CuotaRs {

	private String cuota;
	private String moneda;
	private String primeraCuota;
	private String estado;
	private String mensaje;
		

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCuota() {
		return cuota;
	}

	public void setCuota(String cuota) {
		this.cuota = cuota;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getPrimeraCuota() {
		return primeraCuota;
	}

	public void setPrimeraCuota(String primeraCuota) {
		this.primeraCuota = primeraCuota;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
