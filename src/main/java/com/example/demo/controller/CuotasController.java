package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CuotaRq;
//import com.example.demo.model.CuotaRs;
//import com.example.demo.services.CuotaFechaService;
import com.example.demo.services.CuotasService;

@RestController
@RequestMapping("/api/cuotas")
public class CuotasController {
	
	@Autowired
	private CuotasService cuotaService;
	
	
	@PostMapping("/calcular")
	public ResponseEntity<?> calcularCuotas(@RequestBody CuotaRq request){
		return ResponseEntity.ok(cuotaService.execute(request));
	}

}
