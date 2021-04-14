package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.ClienteTarjeta;
import com.example.demo.entity.Tarjeta;
import com.example.demo.model.CuotaRq;
import com.example.demo.model.CuotaRs;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.TarjetaRepository;

@Component
public class CuotasService {

	@Autowired
	private CuotaFechaService fechaService;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	

	public CuotaRs execute(CuotaRq request) {


		double tea = Double.valueOf(request.getTea().replace("%", ""));
		
		CuotaRs respuesta = new CuotaRs();
		Optional<ClienteTarjeta> clienteTarjeta = clientRepository.findById(Integer.parseInt(request.getDni()));

		if(!clienteTarjeta.isPresent())  {
			respuesta.setEstado("fallido");
			respuesta.setMensaje("DNI no disponible");
			return respuesta;
		}
		
		List<Tarjeta> tarjetasPorNombre = tarjetaRepository.findByNombreIgnoreCase(request.getTarjeta().trim());
		
		if(tarjetasPorNombre.isEmpty()) {
			respuesta.setEstado("fallido");
			respuesta.setMensaje("La tarjeta no existe");
			return respuesta;
		}
		
		boolean clienteTieneTarjeta = false;
		boolean teaIsOk = true;
		for(Tarjeta tarjeta : tarjetasPorNombre) {
			if(tarjeta.getId() == clienteTarjeta.get().getIdtarjeta())  {
				clienteTieneTarjeta = true;
				
				if(tarjeta.getTasa() != tea) {
					teaIsOk = false;
				}
				break;
			}
		} 
 		
		
		if(!clienteTieneTarjeta) {
			respuesta.setEstado("fallido");
			respuesta.setMensaje("El cliente no tiene la tarjeta");
			return respuesta;
		}
		

		if(!teaIsOk) {
			respuesta.setEstado("fallido");
			respuesta.setMensaje("La tea no coincide...");
			return respuesta;
		}
		
		double cuotaMensual = calcularCuotaMensual(request.getCuota(), request.getMonto(), tea);

		
		respuesta.setEstado("exitoso");
		respuesta.setCuota(String.format("%.2f", cuotaMensual));
		respuesta.setMoneda("S/");
		respuesta.setPrimeraCuota(fechaService.obtenerFechaPago(request.getDiaPago()));

		return respuesta;
	}

	private double calcularCuotaMensual(int numeroCuotas, double monto, double tasaEfectivaAnual) {

		double cuotaMensual = 0;

		double tasaEfectivaMensual = obtenerTasaEfectivaMensual(tasaEfectivaAnual) / 100;

		double numerador = tasaEfectivaMensual * Math.pow((1 + tasaEfectivaMensual), numeroCuotas);
		double denominador = Math.pow((1 + tasaEfectivaMensual), numeroCuotas) - 1;
		cuotaMensual = monto * (numerador / denominador);
		return cuotaMensual;
	}

	private double obtenerTasaEfectivaMensual(double tasaEfectivaAnual) {
		double exponente = 30.0 / 360.0;
		double argumento = 1 + (tasaEfectivaAnual / 100);
		double tasaEfectivaMensual = (Math.pow(argumento, exponente) - 1) * 100;
		return tasaEfectivaMensual;
	}

}
