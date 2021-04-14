package com.example.demo.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class CuotaFechaService {

	public String obtenerFechaPago(int diaMes) {
		LocalDate now = LocalDate.now();
		LocalDate fechaPago = now.withDayOfMonth(diaMes).plusMonths(1);
		return fechaPago.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

	}

}
